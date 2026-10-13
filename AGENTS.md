# Repository guide
- Goal: reverse engineer the Transfermóvil Android client for interoperability, protocol analysis, and security research.
- Structure: `app/` holds app source and resources; `smali/` holds disassembly; `scripts/` holds tooling; `docs/` holds topic-specific notes.
- `.workspace/bin/` holds local APK inputs; `README.md` shows the current target metadata; `CHANGELOG.md` tracks substantive project changes.
- `docs/target-metadata.md`: how to extract package, version, SDK levels, and SHA-256 from an APK.
- Keep detailed procedures in separate `docs/*.md` files and add a one-line summary and link here for each new document.
- Read only the documentation relevant to the current task.
- Update `CHANGELOG.md` for every completed change; put the date, APK filename, and SHA-256 in each analysis session's `##` heading.
