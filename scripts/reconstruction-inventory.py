#!/usr/bin/env python3
"""Inventory source links without treating names or file counts as verified behavior.

Uses exact source-relative identifiers, @obfuscated_class tags, and classes.json.
Run with --output PATH to save the complete review queue as JSON.
"""

import argparse
import json
import re
from collections import Counter, defaultdict
from pathlib import Path


def inventory(root):
    source_root = root / "src"
    clean_root = root / "app/src/main/java"
    mappings = json.loads((root / "mappings/classes.json").read_text())["classes"]
    sources = {
        ".".join(p.relative_to(source_root).with_suffix("").parts): p
        for p in sorted(source_root.rglob("*.java"))
    }
    clean = {}
    annotations = defaultdict(set)
    for path in sorted(clean_root.rglob("*.java")):
        text = path.read_text()
        package = re.search(r"^\s*package\s+([\w.]+)\s*;", text, re.MULTILINE)
        name = f"{package[1]}.{path.stem}" if package else path.stem
        tags = sorted(set(re.findall(r"@obfuscated_class\s+([\w.$]+)", text)))
        relative = path.relative_to(root).as_posix()
        clean[relative] = {"class": name, "annotations": tags}
        for tag in tags:
            annotations[tag].add(relative)

    by_name = defaultdict(set)
    for path, info in clean.items():
        by_name[info["class"]].add(path)
    links = defaultdict(set)
    for original, paths in annotations.items():
        if original in sources:
            links[original].update(paths)
    mapping_issues = []
    for original, entry in sorted(mappings.items()):
        target = entry["clean"]
        paths = by_name.get(target, set())
        if original not in sources:
            mapping_issues.append({"original": original, "clean": target,
                                   "issue": "source_not_found"})
        if not paths:
            mapping_issues.append({"original": original, "clean": target,
                                   "issue": "clean_not_found"})
        for path in sorted(paths):
            tags = clean[path]["annotations"]
            if tags and original not in tags:
                mapping_issues.append({"original": original, "clean": target,
                                       "path": path, "issue": "annotation_conflict"})
        if original in sources:
            links[original].update(paths)

    records = []
    for original, path in sources.items():
        candidates = sorted(links[original])
        records.append({
            "original": original,
            "source": path.relative_to(root).as_posix(),
            "candidates": candidates,
            "link_status": "unlinked" if not candidates else (
                "multiple_candidates" if len(candidates) > 1 else "single_candidate"),
        })
    statuses = Counter(r["link_status"] for r in records)
    return {
        "scope": "Java files in src/; exact path identifiers only; no behavioral validation",
        "summary": {
            "source_files": len(sources), "clean_files": len(clean),
            "mapping_entries": len(mappings),
            **{s: statuses[s] for s in ("unlinked", "single_candidate", "multiple_candidates")},
            "clean_without_annotation": sum(not i["annotations"] for i in clean.values()),
            "unresolved_annotations": sum(k not in sources for k in annotations),
            "mapping_issues": len(mapping_issues),
        },
        "sources": records,
        "clean_without_annotation": [p for p, i in clean.items() if not i["annotations"]],
        "unresolved_annotations": [
            {"original": k, "candidates": sorted(v)}
            for k, v in sorted(annotations.items()) if k not in sources
        ],
        "mapping_issues": mapping_issues,
    }


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--output", type=Path, help="Write full JSON inventory to this path")
    args = parser.parse_args()
    report = inventory(args.root.resolve())
    print("Reconstruction links (not implementation coverage)")
    for key, value in report["summary"].items():
        print(f"  {key}: {value}")
    if args.output:
        args.output.parent.mkdir(parents=True, exist_ok=True)
        args.output.write_text(json.dumps(report, indent=2, ensure_ascii=False) + "\n")
        print(f"Review queue: {args.output}")


if __name__ == "__main__":
    main()
