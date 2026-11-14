#!/usr/bin/env python3
"""Synchronize the README progress bar with TODO checkboxes and source reconstruction stats."""

import argparse
import re
import subprocess
from pathlib import Path

MARKER = "<!-- do not delete this progress-bar-->"


def get_source_stats(root: Path) -> tuple[int, int]:
    """Return (single_candidate, source_files) from scripts/mapping-stats.sh."""
    script = root / "scripts" / "mapping-stats.sh"
    if not script.exists():
        return 0, 0
    output = subprocess.check_output(["bash", str(script)], text=True)
    source_match = re.search(r"source_files:\s*(\d+)", output)
    linked_match = re.search(r"single_candidate:\s*(\d+)", output)
    source_files = int(source_match.group(1)) if source_match else 0
    linked_files = int(linked_match.group(1)) if linked_match else 0
    return linked_files, source_files


def update(readme: str, todo: str, linked_files: int = 0, source_files: int = 0) -> str:
    tasks = re.findall(r"^- \[([ xX])\] ", todo, re.MULTILINE)
    if not tasks:
        raise ValueError("TODO.md has no task checkboxes")
    completed = sum(value.lower() == "x" for value in tasks)
    todo_pct = completed * 100 // len(tasks)
    source_pct = (linked_files * 100 // source_files) if source_files > 0 else 0
    overall_pct = (todo_pct + source_pct) // 2 if source_files > 0 else todo_pct
    blocks = overall_pct * 50 // 100
    bar = "█" * blocks + "░" * (50 - blocks)
    source_pct_str = f"{(linked_files * 100 / source_files):.1f}%" if source_files > 0 else "0%"
    replacement = (
        '<!-- 50 blocks; each full block = 2% of combined TODO + source reconstruction progress --> '
        + MARKER
        + "\n"
        f'<span style="white-space: nowrap;"><code>[{bar}] {overall_pct}%</code></span>\n\n'
        f'**Overall progress: {overall_pct}%** '
        f'(Task-list: {completed}/{len(tasks)} [{todo_pct}%]; '
        f'Source reconstruction: {linked_files}/{source_files} [{source_pct_str}]). '
        'Run `make progress` or `make inventory` to refresh from [TODO.md](TODO.md) and `make stats`.'
    )
    pattern = (
        r"<!--[^\n]*" + re.escape(MARKER) + r"\n<span[^\n]*</span>"
        r"(?:\n\n\*\*(?:Task-list|Overall) progress:[^\n]*)?"
    )
    result, count = re.subn(pattern, lambda _: replacement, readme)
    if count != 1:
        raise ValueError("Expected exactly one README progress bar marker")
    return result


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--check", action="store_true", help="Fail if README progress is stale")
    args = parser.parse_args()
    path = args.root / "README.md"
    previous = path.read_text()
    linked_files, source_files = get_source_stats(args.root)
    current = update(previous, (args.root / "TODO.md").read_text(), linked_files, source_files)
    if args.check:
        if previous != current:
            parser.exit(1, "README progress is stale; run make progress\n")
        print("README progress matches TODO.md and make stats")
    else:
        if previous != current:
            path.write_text(current)
        print(re.search(r"\*\*(?:Task-list|Overall) progress:.*?\*\*", current)[0].strip("*"))


if __name__ == "__main__":
    main()
