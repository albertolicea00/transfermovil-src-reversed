#!/usr/bin/env bash
# decompile.sh — Decompile an APK into src/ (JADX Java), smali/ (Apktool), and app/ resources.
#
# Usage:
#   ./scripts/decompile.sh <path-to-apk>
#
# Prerequisites:
#   - jadx (brew install jadx)
#   - apktool (brew install apktool)
#   - aapt2 (from Android SDK build-tools)
#
# Output:
#   src/          — JADX decompiled Java (obfuscated names, as-is)
#   smali/        — Apktool smali disassembly
#   app/res/      — Decoded resources (layouts, drawables, strings)
#   app/assets/   — Raw asset files from APK
#   app/AndroidManifest.xml — Decoded manifest
#
# Notes:
#   - Only copies app-specific packages to src/ (cu.etecsa.*, AFm1*)
#   - Skips third-party libs (androidx, com.google, kotlin, etc.)
#   - Existing output dirs are backed up with .bak suffix before overwriting

set -euo pipefail

APK="${1:?Usage: $0 <path-to-apk>}"
REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
WORK_DIR="$(mktemp -d)"

trap 'rm -rf "$WORK_DIR"' EXIT

echo "=== Decompiling $APK ==="
echo "Repo root: $REPO_ROOT"
echo "Work dir:  $WORK_DIR"

# --- JADX decompilation → src/ ---
echo ""
echo "--- JADX decompilation ---"
jadx --no-res --output-dir "$WORK_DIR/jadx" "$APK" 2>&1 | tail -5

echo "Copying app-specific sources to src/..."
for pkg_dir in "$WORK_DIR/jadx/sources/cu" "$WORK_DIR/jadx/sources/AFm1"*; do
    if [ -d "$pkg_dir" ]; then
        pkg_name="$(basename "$pkg_dir")"
        if [ -d "$REPO_ROOT/src/$pkg_name" ]; then
            echo "  Backing up existing src/$pkg_name"
            mv "$REPO_ROOT/src/$pkg_name" "$REPO_ROOT/src/${pkg_name}.bak"
        fi
        cp -R "$pkg_dir" "$REPO_ROOT/src/"
        echo "  Copied $pkg_name ($(find "$REPO_ROOT/src/$pkg_name" -name '*.java' | wc -l | tr -d ' ') files)"
    fi
done

# --- Apktool disassembly → smali/ ---
echo ""
echo "--- Apktool disassembly ---"
apktool d -f -o "$WORK_DIR/apktool" "$APK" 2>&1 | tail -5

if [ -d "$WORK_DIR/apktool/smali" ]; then
    echo "Copying smali to smali/..."
    if [ -d "$REPO_ROOT/smali" ]; then
        echo "  Backing up existing smali/"
        mv "$REPO_ROOT/smali" "$REPO_ROOT/smali.bak"
    fi
    cp -R "$WORK_DIR/apktool/smali" "$REPO_ROOT/smali"
    echo "  Copied $(find "$REPO_ROOT/smali" -name '*.smali' | wc -l | tr -d ' ') smali files"
fi

# --- Resources → app/ ---
echo ""
echo "--- Resources ---"

if [ -d "$WORK_DIR/apktool/res" ]; then
    echo "Copying decoded resources to app/res/..."
    rm -rf "$REPO_ROOT/app/res"
    cp -R "$WORK_DIR/apktool/res" "$REPO_ROOT/app/res"
fi

if [ -f "$WORK_DIR/apktool/AndroidManifest.xml" ]; then
    echo "Copying AndroidManifest.xml..."
    cp "$WORK_DIR/apktool/AndroidManifest.xml" "$REPO_ROOT/app/AndroidManifest.xml"
fi

# --- Assets (extract from APK as zip) ---
echo ""
echo "--- Assets ---"
mkdir -p "$WORK_DIR/assets"
unzip -qo "$APK" 'assets/*' -d "$WORK_DIR/assets" 2>/dev/null || true
if [ -d "$WORK_DIR/assets/assets" ]; then
    echo "Copying assets to app/assets/..."
    rm -rf "$REPO_ROOT/app/assets"
    cp -R "$WORK_DIR/assets/assets" "$REPO_ROOT/app/assets"
    echo "  Copied $(find "$REPO_ROOT/app/assets" -type f | wc -l | tr -d ' ') asset files"
fi

# --- Summary ---
echo ""
echo "=== Done ==="
echo "  src/:   $(find "$REPO_ROOT/src" -name '*.java' 2>/dev/null | wc -l | tr -d ' ') Java files"
echo "  smali/: $(find "$REPO_ROOT/smali" -name '*.smali' 2>/dev/null | wc -l | tr -d ' ') smali files"
echo "  app/:   manifest + $(find "$REPO_ROOT/app/res" -type f 2>/dev/null | wc -l | tr -d ' ') resources + $(find "$REPO_ROOT/app/assets" -type f 2>/dev/null | wc -l | tr -d ' ') assets"
