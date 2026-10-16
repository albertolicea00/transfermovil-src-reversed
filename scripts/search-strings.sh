#!/usr/bin/env bash
# search-strings.sh — Search for strings across decompiled source and smali.
#
# Usage:
#   ./scripts/search-strings.sh <pattern> [--smali] [--java] [--both]
#
# Searches for a grep pattern across:
#   --java   (default)  Search src/ Java files only
#   --smali             Search smali/ files only
#   --both              Search both src/ and smali/
#
# Examples:
#   ./scripts/search-strings.sh "ACCESS_TOKEN"
#   ./scripts/search-strings.sh "getUnsafeOkHttpClient" --both
#   ./scripts/search-strings.sh "USSD\|ussd" --smali

set -euo pipefail

PATTERN="${1:?Usage: $0 <pattern> [--smali|--java|--both]}"
MODE="${2:---java}"
REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"

case "$MODE" in
    --java)
        echo "=== Searching src/ (Java) for: $PATTERN ==="
        grep -rn "$PATTERN" "$REPO_ROOT/src/" --include="*.java" || echo "(no matches)"
        ;;
    --smali)
        echo "=== Searching smali/ for: $PATTERN ==="
        grep -rn "$PATTERN" "$REPO_ROOT/smali/" --include="*.smali" || echo "(no matches)"
        ;;
    --both)
        echo "=== Searching src/ (Java) for: $PATTERN ==="
        grep -rn "$PATTERN" "$REPO_ROOT/src/" --include="*.java" || echo "(no matches)"
        echo ""
        echo "=== Searching smali/ for: $PATTERN ==="
        grep -rn "$PATTERN" "$REPO_ROOT/smali/" --include="*.smali" || echo "(no matches)"
        ;;
    *)
        echo "Unknown mode: $MODE. Use --java, --smali, or --both." >&2
        exit 1
        ;;
esac
