#!/usr/bin/env bash
# verify-apk.sh — Verify APK identity and extract metadata.
#
# Usage:
#   ./scripts/verify-apk.sh <path-to-apk>
#
# Output:
#   Prints package name, version, SDK levels, and SHA-256 hash.
#   Exit code 0 if APK is valid, 1 on error.
#
# Prerequisites:
#   - aapt2 (from Android SDK build-tools) or aapt
#   - shasum or sha256sum

set -euo pipefail

APK="${1:?Usage: $0 <path-to-apk>}"

if [ ! -f "$APK" ]; then
    echo "Error: File not found: $APK" >&2
    exit 1
fi

echo "=== APK Metadata ==="

# SHA-256
if command -v shasum &>/dev/null; then
    SHA256="$(shasum -a 256 "$APK" | awk '{print $1}')"
elif command -v sha256sum &>/dev/null; then
    SHA256="$(sha256sum "$APK" | awk '{print $1}')"
else
    echo "Error: No sha256 tool found" >&2
    exit 1
fi
echo "SHA-256:      $SHA256"

# Package info via aapt
if command -v aapt2 &>/dev/null; then
    AAPT="aapt2"
elif command -v aapt &>/dev/null; then
    AAPT="aapt"
else
    echo "Error: aapt/aapt2 not found. Install Android SDK build-tools." >&2
    exit 1
fi

DUMP="$($AAPT dump badging "$APK" 2>/dev/null)"
PACKAGE="$(echo "$DUMP" | grep "^package:" | sed "s/.*name='\([^']*\)'.*/\1/")"
VERSION_NAME="$(echo "$DUMP" | grep "^package:" | sed "s/.*versionName='\([^']*\)'.*/\1/")"
VERSION_CODE="$(echo "$DUMP" | grep "^package:" | sed "s/.*versionCode='\([^']*\)'.*/\1/")"
MIN_SDK="$(echo "$DUMP" | grep "^sdkVersion:" | sed "s/sdkVersion:'\([^']*\)'/\1/")"
TARGET_SDK="$(echo "$DUMP" | grep "^targetSdkVersion:" | sed "s/targetSdkVersion:'\([^']*\)'/\1/")"

echo "Package:      $PACKAGE"
echo "Version:      $VERSION_NAME (code: $VERSION_CODE)"
echo "Min SDK:      $MIN_SDK"
echo "Target SDK:   $TARGET_SDK"
echo "File:         $(basename "$APK")"
echo "Size:         $(du -h "$APK" | awk '{print $1}')"
