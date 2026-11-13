#!/usr/bin/env python3
"""Inventory static USSD call operands and telephone sinks without executing Java."""
import argparse
from collections import Counter
from itertools import groupby
import json
from pathlib import Path
import re

METHODS = (r"actionCallUSSD\w*|principalEnviarUSSD|sendUssdRequests?|callUSSD|"
           r"sendDataUSSD|sendUSSD|getAlertDialogBuilder|showSendUSSD")
LITERALS = r'''"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'|//[^\n]*|/\*[\s\S]*?\*/'''


def mask(source):
    """Mask comments/literals while preserving positions and newlines."""
    return re.sub(LITERALS, lambda m: "".join(
        "\n" if c == "\n" else " " for c in m[0]), source)


def arguments(source, masked, start):
    depth, at, last, parts = 1, start, start, []
    while depth and at < len(masked):
        char = masked[at]
        if char in "([{":
            depth += 1
        elif char in ")]}":
            depth -= 1
        if char == "," and depth == 1:
            parts.append(source[last:at].strip())
            last = at + 1
        if depth == 0:
            parts.append(source[last:at].strip())
        at += 1
    if depth:
        raise ValueError(f"Unclosed invocation at offset {start}")
    return [" ".join(part.split()) for part in parts], at


def inventory(root):
    calls, templates = [], []
    for path in sorted((root / "src").rglob("*.java")):
        source = path.read_text()
        masked = mask(source)
        relative = path.relative_to(root).as_posix()
        for match in re.finditer(r"\b(" + METHODS + r")\s*\(", masked):
            prefix = masked[max(0, match.start() - 30):match.start()]
            if re.search(r"\b(?:void|Uri|String|int|boolean)\s*$", prefix):
                continue
            args, end = arguments(source, masked, match.end())
            if re.match(r"\s*(?:throws\b[^{}]*)?\{", masked[end:]):
                continue
            calls.append({"source": relative,
                          "line": source.count("\n", 0, match.start()) + 1,
                          "method": match[1], "arguments": args})
        for number, line in enumerate(source.splitlines(), 1):
            if '"tel:' in line or '.sendUssdRequest(' in line:
                templates.append({"source": relative, "line": number,
                                  "expression": line.strip()})
    return {"calls": calls, "templates": templates}


def render(root, report):
    roles = {}
    for line in (root / "docs/unmapped-source-review.md").read_text().splitlines():
        if line.startswith("| `cu.etecsa."):
            cells = line.split("|")
            roles[cells[2].strip(" `")] = cells[4].strip()

    def cell(value):
        return value.replace("|", "&#124;").replace("`", "&#96;")

    def link(path, number):
        return f"[{Path(path).name}:{number}](../{path}#L{number})"

    calls, templates = report["calls"], report["templates"]
    out = ["# USSD dispatch evidence inventory", "",
           "Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256 "
           "`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.", "",
           "Companion to the [USSD catalog](ussd-code-catalog.md). "
           f"This inventory records **{len(calls)} syntactic invocation sites across "
           f"{len({c['source'] for c in calls})} raw Java files**, followed by "
           f"**{len(templates)} telephone-URI construction/platform-send evidence lines**. "
           "Sites are not unique operations and do not prove runtime execution, "
           "reachability, successful encoding, carrier acceptance, or server effects. "
           "Parameter variables retain their original names; open the linked source "
           "to inspect assignments/validation and use the protocol-family rules in "
           "the catalog. Wrapper calls and platform calls overlap intentionally. "
           "Ordinary telephone links and a length-only URI calculation remain in "
           "the sink audit; they are not USSD operations.", "",
           "This is a complete lexical inventory for the listed method families "
           "and `tel:` literals in tracked `src/`, including multiline calls and "
           "dynamic operands. It is not a whole-program dataflow/reachability proof. "
           "Smali-only bodies absent from Java, reflection, arbitrary string-driven "
           "destinations, and server-side operations are outside extraction.", "",
           "## Reproduction", "",
           "Run `python3 scripts/ussd-inventory.py --check` to verify this snapshot, "
           "or `python3 scripts/ussd-inventory.py --output "
           "docs/ussd-dispatch-inventory.md` to regenerate it. "
           "`--json` emits all operands as JSON. The scanner masks comments/literals "
           "for call recognition, balances delimiters to split top-level arguments, "
           "excludes declarations, and preserves original operand expressions. "
           "It does not execute Java or contact a device. Role notes come from "
           "the baseline classification ledger; they do not prove a particular "
           "branch's server-side purpose.", "", "## Method counts", "",
           "| Method | Invocation sites |", "| --- | ---: |"]
    for method, count in sorted(Counter(c["method"] for c in calls).items()):
        out.append(f"| `{method}` | {count} |")
    out += ["", "## Invocation evidence by source", "",
            "Arguments retain original order, one invocation per row. "
            "`principalEnviarUSSD` carries context, gateway, operation, agency, "
            "stored parameter-count hint, payload, confirmation, group, and fragment "
            "manager. The active splitter uses a character budget rather than "
            "that hint. `actionCallUSSD` overloads differ by arity; use the catalog "
            "before treating the first numeric argument as a global selector.", ""]
    for source, grouped in groupby(calls, lambda c: c["source"]):
        out += [f"### `{source}`", ""]
        if source in roles:
            out += ["Baseline source role/evidence: " + roles[source], ""]
        out += ["| Source line | Method | Ordered argument expressions |",
                "| --- | --- | --- |"]
        for call in grouped:
            args = "<br>".join(f"{i + 1}. `{cell(arg)}`"
                              for i, arg in enumerate(call["arguments"]))
            out.append(f"| {link(source, call['line'])} | "
                       f"`{call['method']}` | {args} |")
        out.append("")
    out += ["## URI construction and platform-send audit", "",
            "| Source | Original expression |", "| --- | --- |"]
    for item in templates:
        out.append(f"| {link(item['source'], item['line'])} | "
                   f"`{cell(item['expression'])}` |")
    return "\n".join(out) + "\n"


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path,
                        default=Path(__file__).resolve().parents[1])
    parser.add_argument("--output", type=Path)
    parser.add_argument("--check", action="store_true")
    parser.add_argument("--json", action="store_true")
    args = parser.parse_args()
    root = args.root.resolve()
    report = inventory(root)
    content = (json.dumps(report, indent=2, ensure_ascii=False) + "\n"
               if args.json else render(root, report))
    if args.check:
        target = args.output or root / "docs/ussd-dispatch-inventory.md"
        if not target.exists() or target.read_text() != content:
            raise SystemExit(f"Outdated USSD inventory: {target}")
        print(f"USSD inventory current: {len(report['calls'])} calls, "
              f"{len(report['templates'])} sink/template lines")
    elif args.output:
        args.output.write_text(content)
    else:
        print(content, end="")


if __name__ == "__main__":
    main()
