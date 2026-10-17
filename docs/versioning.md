# Versioning & Release Strategy

This document defines release names, Git tags, and the procedure for tracking Transfermóvil APKs.

## Release and Tag Format

Use the same name for a project release and its annotated Git tag:

```text
<APK versionName>.<APK versionCode>-v<internal version>
```

The first two fields come from the APK manifest. The final `vN.M` is this project's internal release number for that APK. It starts at `v1.0` for each new APK and advances when reconstruction, mappings, documentation, or tooling are released. This is a project-specific format, not Semantic Versioning.

| APK versionName | APK versionCode | Internal version | Tag / release name |
| :--- | ---: | :--- | :--- |
| `1.260416` | `162` | `v1.0` | `1.260416.162-v1.0` |
| `1.260416` | `162` | `v1.1` | `1.260416.162-v1.1` |
| `1.260500` | `163` | `v1.0` | `1.260500.163-v1.0` |

## Git Workflow

Use a single `main` branch and one annotated tag per project release. The first tag for an APK provides its committed source baseline (`src/`, assets, and manifest). Later internal tags retain the same APK fields. Compare first tags across APKs for changes in the target; compare internal tags on one APK for project changes.

```text
(main) ──●────────────────────●────────────────────●
         │                    │                    │
   1.260416.162-v1.0    1.260416.162-v1.1    1.260500.163-v1.0
```

## Decompiled Source and Local Smali Archives

Keep obfuscated JADX Java in `src/` under Git. Its references support `mappings/classes.json`, full-text search, and line-by-line comparisons between releases.

Keep Apktool output in the local `smali/` directory. Git tracks only `smali/.gitkeep` so the directory exists in fresh clones; `.gitignore` excludes disassembly. Obfuscation can rename almost every smali file between APKs, limiting Git's cross-version delta compression. Store each APK as `.workspace/archives/smali-<versionName>.<versionCode>.zip` instead of committing either loose smali or the ZIP to Git. The archive directory is ignored too. A fresh clone needs the matching APK to regenerate smali, or a separately obtained ZIP.

Current local archive: `smali-1.260416.162.zip`, SHA-256 `77dd5055bd0b9b5e0dea8bf9fb459858170739892fc78a8a9be73f4c12778737`. It contains a top-level `smali/` directory and can be restored with:

```bash
unzip .workspace/archives/smali-1.260416.162.zip -d .
```

Record the APK SHA-256, archive SHA-256, and decompiler versions for each target. Local ZIPs may later be uploaded as Release assets; APK binaries remain local.

## Comparing APK Releases

Compare the first release tags for each APK. Substitute actual tag names for future versions.

### Decompiled Java

```bash
git diff 1.260416.162-v1.0..1.260500.163-v1.0 -- src/
```

### Smali

Extract two locally available archives into separate directories:

```bash
mkdir -p .workspace/compare/old .workspace/compare/new
unzip -q .workspace/archives/smali-1.260416.162.zip -d .workspace/compare/old
unzip -q .workspace/archives/smali-1.260500.163.zip -d .workspace/compare/new
diff -ruN .workspace/compare/old/smali .workspace/compare/new/smali
```

### Manifest, Assets, and Summary

```bash
git diff 1.260416.162-v1.0..1.260500.163-v1.0 -- app/AndroidManifest.xml
git diff 1.260416.162-v1.0..1.260500.163-v1.0 -- app/assets/
git diff --stat 1.260416.162-v1.0..1.260500.163-v1.0
```

For changes to reconstruction on the same APK, compare internal release tags, for example `1.260416.162-v1.0..1.260416.162-v1.1`.

## Upgrading to a New APK

1. Place the new APK in `.workspace/bin/` and verify its metadata and SHA-256:

   ```bash
   make verify APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v<versionCode>.apk
   ```

2. Decompile the APK to refresh `src/`, local `smali/`, `app/res/`, and `app/assets/`:

   ```bash
   make decompile APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v<versionCode>.apk
   ```

3. Archive the local smali tree, and record the ZIP hash in the analysis notes:

   ```bash
   mkdir -p .workspace/archives
   zip -qr .workspace/archives/smali-<versionName>.<versionCode>.zip smali/
   shasum -a 256 .workspace/archives/smali-<versionName>.<versionCode>.zip
   ```

4. Commit the JADX source, resources, assets, and manifest:

   ```bash
   git add src/ app/res/ app/assets/ app/AndroidManifest.xml
   git commit -m "chore(target): import APK <versionName> (<versionCode>)"
   ```

5. Compare the APKs, update `mappings/classes.json` and reconstructed code, and record findings in `README.md` and `CHANGELOG.md`.

6. When the project release is ready, tag the commit with the APK fields and internal `vN.M`. Use the identical name for a GitHub Release if one is published:

   ```bash
   git tag -a <versionName>.<versionCode>-v1.0 -m "Release <versionName>.<versionCode>-v1.0"
   git push origin main --tags
   ```

   Increase the internal version for subsequent releases on the same APK. The first release for a different APK starts at `v1.0`.
