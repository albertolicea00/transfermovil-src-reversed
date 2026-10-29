#!/usr/bin/env python3
"""Synchronize the README progress bar with completed top-level TODO checkboxes.

This is task-list progress, not a percentage of verified reconstruction. Tasks
have equal weight; adding scope can lower the percentage. Use --check in checks.
"""

import argparse
import re
from pathlib import Path

MARKER = "<!-- do not delete this progress-bar-->"


def update(readme, todo):
    tasks = re.findall(r"^- \[([ xX])\] ", todo, re.MULTILINE)
    if not tasks:
        raise ValueError("TODO.md has no task checkboxes")
    completed = sum(value.lower() == "x" for value in tasks)
    percent = completed * 100 // len(tasks)
    blocks = completed * 50 // len(tasks)
    bar = "█" * blocks + "░" * (50 - blocks)
    replacement = (
        '<!-- 50 blocks; each full block = 2% of TODO tasks --> ' + MARKER + "\n"
        f'<span style="white-space: nowrap;"><code>[{bar}] {percent}%</code></span>\n\n'
        f'**Task-list progress: {completed}/{len(tasks)} completed; '
        f'{len(tasks) - completed} pending.** '
        'Tasks have equal weight. This is not verified code coverage or a working-app percentage. '
        'The value can fall when scope grows. '
        'Run `make progress` or `make inventory` to refresh it from [TODO.md](TODO.md).'
    )
    pattern = (
        r"<!--[^\n]*" + re.escape(MARKER) + r"\n<span[^\n]*</span>"
        r"(?:\n\n\*\*Task-list progress:[^\n]*)?"
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
    current = update(previous, (args.root / "TODO.md").read_text())
    if args.check:
        if previous != current:
            parser.exit(1, "README progress is stale; run make progress\n")
        print("README progress matches TODO.md")
    else:
        if previous != current:
            path.write_text(current)
        print(re.search(r"\*\*Task-list progress:.*?\*\*", current)[0].strip("*"))


if __name__ == "__main__":
    main()
