#!/usr/bin/env python3
"""Compile clean Java against local APK-derived dependencies; no APK/runtime claim."""
import argparse
from collections import defaultdict
from datetime import datetime, timezone
import hashlib
import json
import os
from pathlib import Path
import re
import shutil
import subprocess
import tempfile
import time
import zipfile


RESOURCE_PACKAGE = "cu.etecsa.transfermovil"
DIAGNOSTIC = re.compile(r"^(.*\.java):(\d+): (error|warning): (.*)$")


def sha256(path):
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for block in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(block)
    return digest.hexdigest()


def quote_arg(value):
    return '"' + str(value).replace("\\", "\\\\").replace('"', '\\"') + '"'


def diagnostics(log, root):
    records, global_messages = [], []
    current = None
    for line in log.splitlines():
        match = DIAGNOSTIC.match(line)
        if match:
            path = Path(match[1])
            try:
                path = path.resolve().relative_to(root).as_posix()
            except ValueError:
                path = str(path)
            current = {"file": str(path), "line": int(match[2]),
                       "severity": match[3], "message": match[4], "details": []}
            records.append(current)
        elif re.match(r"^error:", line):
            global_messages.append(line)
            current = None
        elif current is not None:
            if re.match(r"^(?:\d+ (?:error|warning)s?$|Note:)", line):
                current = None
            else:
                current["details"].append(line)
    return records, global_messages


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--bytecode-jar", required=True, type=Path,
                        help="Local jar converted from the target APK with dex2jar")
    parser.add_argument("--android-jar", required=True, type=Path,
                        help="Local Android SDK platform android.jar")
    parser.add_argument("--root", type=Path,
                        default=Path(__file__).resolve().parents[1])
    parser.add_argument("--output", type=Path,
                        help="Local report directory (default .workspace/compile-reconstruction)")
    parser.add_argument("--apk", type=Path, help="Optional local APK to fingerprint")
    parser.add_argument("--javac", default="javac")
    parser.add_argument("--timeout", type=int, default=300)
    args = parser.parse_args()
    root = args.root.resolve()
    if args.timeout <= 0:
        parser.error("--timeout must be positive")
    jars = {"android_jar": args.android_jar.resolve(),
            "bytecode_jar": args.bytecode_jar.resolve()}
    for label, path in jars.items():
        if not path.is_file() or not zipfile.is_zipfile(path):
            parser.error(f"{label} must be an existing jar: {path}")
    javac = shutil.which(args.javac)
    if javac is None:
        parser.error(f"Compiler not found: {args.javac}")
    apk = args.apk.resolve() if args.apk else None
    if apk and not apk.is_file():
        parser.error(f"APK not found: {apk}")
    source_root = root / "app/src/main/java"
    sources = sorted(source_root.rglob("*.java"))
    if not sources:
        parser.error(f"No clean Java sources: {source_root}")
    resource_source = root / "src/cu/etecsa/cubacel/tr/tm/R.java"
    if not resource_source.is_file():
        parser.error(f"Missing target resource constants: {resource_source}")
    for source in sources:
        if source.name == "R.java" and re.search(
                r"^\s*package\s+" + re.escape(RESOURCE_PACKAGE) + r"\s*;",
                source.read_text(), re.MULTILINE):
            parser.error(f"Clean R already exists; review resource generation: {source}")
    inputs = sources + [resource_source]
    before = {str(path.relative_to(root)): sha256(path) for path in inputs}
    dependency_before = {label: sha256(path) for label, path in jars.items()}
    output = (args.output.resolve() if args.output else
              root / ".workspace/compile-reconstruction")
    output.mkdir(parents=True, exist_ok=True)
    # Every run has fresh classes; earlier output cannot mask a missing type.
    run = Path(tempfile.mkdtemp(prefix="run-", dir=output))
    classes = run / "classes"
    classes.mkdir()
    generated_r = run / "generated" / "cu/etecsa/transfermovil/R.java"
    generated_r.parent.mkdir(parents=True)
    raw_r = resource_source.read_text()
    clean_r, replacements = re.subn(
        r"^package cu\.etecsa\.cubacel\.tr\.tm;",
        "package " + RESOURCE_PACKAGE + ";", raw_r, count=1, flags=re.MULTILINE)
    if replacements != 1:
        parser.error("Raw R package differs from the expected target namespace")
    generated_r.write_text(clean_r)
    argfile = run / "sources.txt"
    argfile.write_text("\n".join(quote_arg(path) for path in sources + [generated_r]) + "\n")
    command = [javac, "-J-Duser.language=en", "-J-Duser.country=US", "-proc:none",
               "-Xmaxerrs", "10000", "-Xmaxwarns", "10000", "-encoding", "UTF-8",
               "-classpath", os.pathsep.join(str(p) for p in jars.values()),
               "-sourcepath", "", "-d", str(classes), "@" + str(argfile)]
    version = subprocess.run([javac, "-version"], capture_output=True, text=True,
                             timeout=15)
    started = datetime.now(timezone.utc).isoformat()
    start = time.monotonic()
    timed_out = False
    try:
        compiled = subprocess.run(command, cwd=root, capture_output=True,
                                  text=True, timeout=args.timeout)
        log, exit_code = compiled.stdout + compiled.stderr, compiled.returncode
    except subprocess.TimeoutExpired as error:
        timed_out = True
        def as_text(value):
            return value.decode(errors="replace") if isinstance(value, bytes) else value or ""
        log, exit_code = as_text(error.stdout) + as_text(error.stderr), None
    elapsed = time.monotonic() - start
    changed = [str(path.relative_to(root)) for path in inputs
               if not path.exists() or sha256(path) != before[str(path.relative_to(root))]]
    current_sources = set(source_root.rglob("*.java"))
    changed += [str(path.relative_to(root)) for path in current_sources.symmetric_difference(sources)
                if str(path.relative_to(root)) not in changed]
    changed_dependencies = [label for label, path in jars.items()
                            if not path.exists() or sha256(path) != dependency_before[label]]
    records, global_messages = diagnostics(log, root)
    errors = [record for record in records if record["severity"] == "error"]
    by_file = defaultdict(list)
    for record in records:
        by_file[record["file"]].append(record)
    status = ("timeout" if timed_out else "inputs_changed" if changed or changed_dependencies else
              "passed" if exit_code == 0 else "failed")
    report = {
        "scope": "Hybrid dependency-backed clean-Java compiler audit; not a standalone APK build or runtime verification",
        "status": status, "started_utc": started, "elapsed_seconds": round(elapsed, 3),
        "javac_version": (version.stdout + version.stderr).strip(),
        "command": command, "cwd": str(root), "run_directory": str(run),
        "clean_source_files": len(sources), "generated_resource_files": 1,
        "exit_code": exit_code, "timeout": timed_out,
        "error_diagnostics": len(errors),
        "warning_diagnostics": sum(r["severity"] == "warning" for r in records),
        "error_files": len({r["file"] for r in errors}),
        "diagnostic_limit": 10000, "diagnostics_may_be_capped": len(errors) >= 10000,
        "global_errors": global_messages, "inputs_changed_during_run": sorted(changed),
        "dependencies_changed_during_run": changed_dependencies,
        "dependencies": {label: {"path": str(path), "sha256": dependency_before[label]}
                         for label, path in jars.items()},
        "apk": {"path": str(apk), "sha256": sha256(apk)} if apk else None,
        "bytecode_provenance": "User-supplied local artifact; conversion provenance is not automatically attested",
        "input_sha256": before, "generated_r_sha256": sha256(generated_r),
        "diagnostics_by_file": dict(sorted(by_file.items())),
    }
    for directory in (run, output):
        (directory / "javac.log").write_text(log)
        (directory / "report.json").write_text(json.dumps(report, indent=2) + "\n")
    print(f"Hybrid Java audit: {status}; {len(sources)} clean sources + target R; "
          f"{len(errors)} errors in {report['error_files']} files")
    print(f"Report: {output / 'report.json'}")
    print(f"Compiler log: {output / 'javac.log'}")
    raise SystemExit(0 if status == "passed" else 1)


if __name__ == "__main__":
    main()
