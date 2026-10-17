# Versioning & Release Strategy

This document defines the versioning scheme, Git branching and tagging workflow, and procedures for tracking upstream Transfermóvil application releases.

---

## 1. Versioning Scheme

The repository adheres to a specialized Semantic Versioning (`MAJOR.MINOR.PATCH`) model coupled directly to upstream Transfermóvil releases:

$$\text{Version} = \mathbf{MAJOR} \,.\, \mathbf{MINOR} \,.\, \mathbf{PATCH}$$

### 1.1 MAJOR Version (`X.0.0`) — Upstream Target APK Release
* Incremented **exclusively** when a new version of the Transfermóvil APK is targeted and imported into the repository.
* **Example:**
  * `1.0.0`: Initial target `v1.260416` (versionCode `162`).
  * `2.0.0`: Next target release (e.g., versionCode `163`).
* Every bump of the `MAJOR` version resets `MINOR` and `PATCH` to `0`.

### 1.2 MINOR Version (`x.Y.0`) — Reconstruction & Analysis Milestones
* Incremented when significant reverse engineering, clean reconstruction, or architectural mapping milestones are achieved for the current target APK:
  * Newly reconstructed clean classes in `app/src/main/java/`.
  * Substantial updates to `mappings/classes.json`.
  * New architectural, protocol, or cryptographic documentation in `docs/`.
  * Toolchain improvements in `scripts/` or `Makefile`.

### 1.3 PATCH Version (`x.y.Z`) — Fixes & Corrections
* Incremented for incremental improvements, corrections, and maintenance within the active target version:
  * Bug fixes in reconstructed clean code.
  * Corrected method/class mappings.
  * Clarifications or typo fixes in documentation.
  * Dependency or script maintenance.

---

## 2. Git Branching & Tagging Model

To keep the repository clean and avoid merge overhead between divergent branch structures, the project follows a **single-branch workflow** (`main`) combined with **two types of Git tags**:

```
(main) ──●────────●────────●────────●────────● (v2.0.0 / target-v1.260500)
         │        │        │        │
      v1.0.0   v1.1.0   v1.1.1   v1.2.0
   (target-v1.260416)
```

### Tag Types

| Tag Pattern | Purpose | Example |
| :--- | :--- | :--- |
| `target-v<version>` | Marks the committed baseline (`src/`, assets, manifest) for an APK; the matching smali ZIP is stored separately. | `target-v1.260416` |
| `v<MAJOR>.<MINOR>.<PATCH>` | Marks project releases encompassing reconstructed code, mappings, and documentation. | `v1.0.0`, `v1.1.0` |

---

## 3. Decompiled Source and Local Smali Archives

Keep obfuscated JADX Java in `src/` under Git. Its references support `mappings/classes.json`, full-text search, and line-by-line comparisons between target tags.

Keep Apktool output in the local `smali/` directory. Git tracks only `smali/.gitkeep` so the directory exists in fresh clones; `.gitignore` excludes the disassembly files. Obfuscation can rename almost every smali file between APKs, limiting Git's cross-version delta compression. Store each version as `.workspace/archives/smali-v<version>.zip` instead of committing either loose smali or the ZIP to Git. The `.workspace/` archive directory is also ignored. A fresh clone therefore has no disassembly until the matching APK is decompiled or a versioned ZIP is obtained separately.

Current local archive: `smali-v1.260416.zip`, SHA-256 `77dd5055bd0b9b5e0dea8bf9fb459858170739892fc78a8a9be73f4c12778737`. It contains the top-level `smali/` directory and can be restored with:

```bash
unzip .workspace/archives/smali-v1.260416.zip -d .
```

Record the APK SHA-256, archive SHA-256, and decompiler versions for each target. Local ZIPs can later be uploaded as Release assets if desired; the APK binaries remain local.

---

## 4. Comparing Changes Between APK Releases (Diffing)

Once target baseline tags are in place, comparing changes between versions is immediate:

### Comparing Decompiled Java Source
```bash
git diff target-v1.260416..target-v1.260500 -- src/
```

### Comparing Dalvik Smali Disassembly

Smali is outside Git. Extract two locally available archives into separate directories, then compare them:

```bash
mkdir -p .workspace/compare/old .workspace/compare/new
unzip -q .workspace/archives/smali-v1.260416.zip -d .workspace/compare/old
unzip -q .workspace/archives/smali-v1.260500.zip -d .workspace/compare/new
diff -ruN .workspace/compare/old/smali .workspace/compare/new/smali
```

### Comparing Manifest, Permissions & Components
```bash
git diff target-v1.260416..target-v1.260500 -- app/AndroidManifest.xml
```

### Comparing Bundled JSON Data Assets
```bash
git diff target-v1.260416..target-v1.260500 -- app/assets/
```

### File-Level Change Summary
```bash
git diff --stat target-v1.260416..target-v1.260500
```

> [!TIP]
> On GitHub or GitLab, you can compare any two target tags visually via URL:
> `https://github.com/<owner>/<repo>/compare/target-v1.260416...target-v1.260500`

---

## 5. Procedure for Upgrading to a New Target APK

Follow these steps when a new Transfermóvil APK release becomes available:

1. **Stage Binary:**
   Place the new APK in `.workspace/bin/`:
   ```bash
   cp /path/to/new-transfermovil.apk .workspace/bin/cu.etecsa.cubacel.tr.tm-v<code_version>.apk
   ```

2. **Verify Metadata:**
   Inspect SHA-256 hash, package name, version, and SDK levels:
   ```bash
   make verify APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v<code_version>.apk
   ```

3. **Decompile Target:**
   Run the automated decompiler toolchain to refresh `src/`, `smali/`, `app/res/`, and `app/assets/`:
   ```bash
   make decompile APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v<code_version>.apk
   ```

4. **Archive Smali Locally:**
   Package the new `smali/` tree and record its SHA-256. Keep this ZIP outside Git:
   ```bash
   mkdir -p .workspace/archives
   zip -qr .workspace/archives/smali-v<version>.zip smali/
   shasum -a 256 .workspace/archives/smali-v<version>.zip
   ```

5. **Commit Decompiled Baseline:**
   Commit the JADX source, assets, resources, and manifest; apply the baseline tag:
   ```bash
   git add src/ app/res/ app/assets/ app/AndroidManifest.xml
   git commit -m "chore(target): import decompiled baseline for APK v<version> (build <code_version>)"
   git tag -a target-v<version> -m "Raw decompiled baseline for Transfermóvil v<version> (build <code_version>)"
   ```

6. **Analyze Diff & Update Artifacts:**
   * Run cross-version diffs to detect modified cryptography, new endpoints, altered USSD codes, or schema migrations.
   * Update `mappings/classes.json` to account for new or renamed classes.
   * Adapt clean reconstructed classes in `app/src/main/java/`.
   * Update `README.md` metadata table and log findings in `CHANGELOG.md`.

7. **Tag the Next Major Release:**
   ```bash
   git tag -a v<NEW_MAJOR>.0.0 -m "Release v<NEW_MAJOR>.0.0 targeting Transfermóvil v<version>"
   git push origin main --tags
   ```
