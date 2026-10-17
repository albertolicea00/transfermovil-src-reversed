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
| `target-v<version>` | Marks the exact commit of raw decompiled baseline files (`src/`, `smali/`, assets) for an APK. | `target-v1.260416` |
| `v<MAJOR>.<MINOR>.<PATCH>` | Marks project releases encompassing reconstructed code, mappings, and documentation. | `v1.0.0`, `v1.1.0` |

---

## 3. Why Text-Based `src/` and `smali/` are Kept Uncompressed

Decompiled Java source (`src/`) and Dalvik disassembly (`smali/`) are stored as loose text files rather than compressed archives (such as `.zip`):

1. **Native Git Diffing:** Git cannot display line-by-line differences of `.zip` or compressed files. Storing uncompressed text allows `git diff` to show exact modifications across app updates.
2. **Delta Compression Efficiency:** Git's internal packfile storage computes deltas between commits of text files. Re-compressing into a `.zip` would force Git to store full binary blobs for every release, rapidly bloating the `.git` directory.
3. **Full-Text Search & Grep:** Retaining uncompressed sources enables instant searching across all decompiled files via `git grep`, editor search, and GitHub web code search.
4. **Forensic Evidence:** Bytecode disassembly (`smali/`) provides an immutable, reproducible record of the target binary at that exact point in time.

---

## 4. Comparing Changes Between APK Releases (Diffing)

Once target baseline tags are in place, comparing changes between versions is immediate:

### Comparing Decompiled Java Source
```bash
git diff target-v1.260416..target-v1.260500 -- src/
```

### Comparing Dalvik Smali Disassembly
```bash
git diff target-v1.260416..target-v1.260500 -- smali/
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

4. **Commit Decompiled Baseline:**
   Commit the decompiled files and apply the target baseline tag:
   ```bash
   git add src/ smali/ app/res/ app/assets/ app/AndroidManifest.xml
   git commit -m "chore(target): import decompiled baseline for APK v<version> (build <code_version>)"
   git tag -a target-v<version> -m "Raw decompiled baseline for Transfermóvil v<version> (build <code_version>)"
   ```

5. **Analyze Diff & Update Artifacts:**
   * Run cross-version diffs to detect modified cryptography, new endpoints, altered USSD codes, or schema migrations.
   * Update `mappings/classes.json` to account for new or renamed classes.
   * Adapt clean reconstructed classes in `app/src/main/java/`.
   * Update `README.md` metadata table and log findings in `CHANGELOG.md`.

6. **Tag the Next Major Release:**
   ```bash
   git tag -a v<NEW_MAJOR>.0.0 -m "Release v<NEW_MAJOR>.0.0 targeting Transfermóvil v<version>"
   git push origin main --tags
   ```
