#!/usr/bin/env bash
# Show exact reconstruction links; file counts do not measure faithful behavior.
# Usage: ./scripts/mapping-stats.sh [--output path/to/inventory.json]
# Requires Python 3. See docs/reconstruction-inventory.md for report semantics.
set -euo pipefail
REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
exec python3 "$REPO_ROOT/scripts/reconstruction-inventory.py" "$@"
