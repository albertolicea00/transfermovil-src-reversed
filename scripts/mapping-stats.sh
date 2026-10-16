#!/usr/bin/env bash
# mapping-stats.sh — Show progress of class name mapping (obfuscated → clean).
#
# Usage:
#   ./scripts/mapping-stats.sh
#
# Reads mappings/classes.json and counts mapped vs total classes.
# Also compares against src/ to show coverage percentage.
#
# Prerequisites:
#   - jq (brew install jq)
#   - Python 3 (for JSON fallback if jq missing)

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
MAPPING="$REPO_ROOT/mappings/classes.json"

if [ ! -f "$MAPPING" ]; then
    echo "Error: $MAPPING not found" >&2
    exit 1
fi

echo "=== Mapping Progress ==="

# Count mapped classes
if command -v jq &>/dev/null; then
    MAPPED_CLASSES=$(jq '.classes | length' "$MAPPING")
    MAPPED_FIELDS=$(jq '[.fields | to_entries[] | .value | length] | add // 0' "$MAPPING")
    MAPPED_ENUMS=$(jq '.enums | length' "$MAPPING")
else
    MAPPED_CLASSES=$(python3 -c "import json; d=json.load(open('$MAPPING')); print(len(d.get('classes',{})))")
    MAPPED_FIELDS=$(python3 -c "import json; d=json.load(open('$MAPPING')); print(sum(len(v) for v in d.get('fields',{}).values()))")
    MAPPED_ENUMS=$(python3 -c "import json; d=json.load(open('$MAPPING')); print(len(d.get('enums',{})))")
fi

# Count total Java files in src/
TOTAL_CLASSES=$(find "$REPO_ROOT/src" -name '*.java' -type f | wc -l | tr -d ' ')

# Count clean classes in app/
CLEAN_CLASSES=$(find "$REPO_ROOT/app/src" -name '*.java' -type f 2>/dev/null | wc -l | tr -d ' ')

echo "Mapped classes:  $MAPPED_CLASSES / $TOTAL_CLASSES ($(( MAPPED_CLASSES * 100 / TOTAL_CLASSES ))%)"
echo "Mapped fields:   $MAPPED_FIELDS"
echo "Mapped enums:    $MAPPED_ENUMS"
echo "Clean classes:   $CLEAN_CLASSES"
echo ""

# List unmapped packages
echo "=== Unmapped Packages ==="
find "$REPO_ROOT/src" -name '*.java' -type f | \
    sed 's|.*/src/||; s|/[^/]*\.java$||; s|/|.|g' | \
    sort -u | head -20
echo "  ... ($(find "$REPO_ROOT/src" -name '*.java' -type f | sed 's|.*/src/||; s|/[^/]*\.java$||; s|/|.|g' | sort -u | wc -l | tr -d ' ') packages total)"
