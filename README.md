# Transfermóvil Source (Reversed)

![Target Version](https://img.shields.io/badge/Target%20Version-1.260416-blue?style=flat-square)
![Version Code](https://img.shields.io/badge/Version%20Code-162-informational?style=flat-square)
![Min SDK](https://img.shields.io/badge/Min%20SDK-21-orange?style=flat-square)
![Target SDK](https://img.shields.io/badge/Target%20SDK-33-green?style=flat-square)
![Last Update](https://img.shields.io/badge/Last%20Update-October%202026-lightgrey?style=flat-square)

## Overview

This repository contains reverse-engineered source code, extracted resources, and structural analysis of the Transfermóvil client binary. The primary objective is to inspect implementation details, verify communication protocols (USSD/SMS/HTTP), and document internal logic.

Repository inventory for the current target (2026-10-17):

| Item | Count | Location |
| :--- | ---: | :--- |
| Decompiled Java files | 794 | `src/` (including 596 in the main app package) |
| Clean Java reconstruction files | 504 | `app/src/main/java/` |
| Smali files | 3,439 | `smali/` |
| Extracted resource files | 35 | `app/res/` |
| Extracted asset files | 32 | `app/assets/` |
| Topic documents | 11 | `docs/` |
| Class mappings | 72 | `mappings/classes.json` |
| Analysis scripts | 4 | `scripts/` |

These are file and mapping counts, not a measure of reconstruction completeness; some clean classes are partial or duplicate the same original class.

> [!WARNING]
> **Disclaimer:** This repository is strictly intended for interoperability research, protocol analysis, and security auditing. All original application logic, trademarks, and associated intellectual property belong to ETECSA. No proprietary binaries are hosted for redistribution.

## Current Target Metadata

| Property | Value |
| :--- | :--- |
| **Package Name** | `cu.etecsa.cubacel.tr.tm` |
| **Target Version** | `1.260416` |
| **Version Code** | `162` |
| **Min SDK** | `21` |
| **Target SDK** | `33` |
| **SHA-256 Hash** | `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a` |

See [metadata extraction](docs/target-metadata.md) to reproduce these values from the APK.

## Project status

| Area | Status | Current state |
| :--- | :--- | :--- |
| APK identification and extraction | Complete for the current APK | Metadata, manifest, resources, JADX Java, and smali are available. |
| Clean Java reconstruction | In progress | 504 files exist; some are partial, contain stubs, or duplicate an original class. |
| Protocol and feature analysis | In progress | Topic documents contain findings; the complete USSD code catalog remains a TODO. |
| iOS port research | Planned | Feasibility, platform limits, and feature parity remain TODOs. |
| Build and behavioral validation | Pending | The reconstructed Java tree has not been compiled or verified as a working app. |

See the [task list](TODO.md) and the current [session handoff](.workspace/handoff.md) for specific remaining work. No overall completion percentage has been verified.

## Documentation

| Document | Contents |
| :--- | :--- |
| [Target metadata](docs/target-metadata.md) | APK identity, version, SDK levels, and SHA-256 extraction. |
| [Architecture](docs/architecture.md) | Manifest components, app modes, navigation, dependencies, and assets. |
| [Telephony](docs/telephony.md) | Current USSD and SMS analysis, including dispatch and response handling. |
| [USSD code catalog TODO](docs/ussd-code-catalog.md) | Planned inventory of executed codes, their purposes, and construction algorithms. |
| [Networking](docs/networking.md) | HTTP stack, URLs, tokens, TLS, and local persistence. |
| [Security](docs/security.md) | Cryptography, key handling, and security findings. |
| [Storage](docs/storage.md) | SQLite schema, ORMLite entities, migrations, and preferences. |
| [Domain model](docs/domain-model.md) | Entities, operations, currencies, and enum mappings. |
| [E-commerce](docs/ecommerce.md) | API client, endpoints, authentication, and sessions. |
| [Versioning](docs/versioning.md) | Repository versions, tags, and cross-version comparisons. |
| [iOS port TODO](docs/ios-port-todo.md) | Planned feasibility study, platform limits, and feature parity decisions. |

For work in progress, use the [task list](TODO.md) and the temporary [session handoff](.workspace/handoff.md). [CHANGELOG.md](CHANGELOG.md) records completed changes; [AGENTS.md](AGENTS.md) is the repository guide for contributors and coding agents.

## Project structure

```text
.
├── app/
│   ├── assets/                     Extracted JSON and other assets
│   ├── res/                        Extracted Android resources
│   └── src/main/java/             Clean, still incomplete Java reconstruction
├── src/                           Raw, obfuscated JADX Java output
├── smali/                         Dalvik disassembly
├── mappings/
│   └── classes.json               Obfuscated-to-clean name mappings
├── docs/                          Topic-specific analysis and TODOs
├── scripts/                       Extraction, verification, and search tools
├── .workspace/
│   ├── handoff.md                  Temporary pause/resume note, tracked by Git
│   └── bin/                        Local APK inputs
├── Makefile                        Analysis commands
├── TODO.md                         Remaining project tasks
├── CHANGELOG.md                    Completed changes by analysis session
├── AGENTS.md                       Repository working guide
└── README.md
```

Most generated files under `.workspace/` are excluded from Git; `handoff.md` is tracked so a paused session can be resumed.

---

## Versioning Strategy

This project uses a Semantic Versioning scheme (`MAJOR.MINOR.PATCH`) mapped directly to Transfermóvil releases:

* **MAJOR (`X.0.0`):** Increments **only** when a new Transfermóvil APK version is targeted and imported (e.g., `1.0.0` for APK v1.260416, `2.0.0` for the next APK release).
* **MINOR (`x.Y.0`):** Increments for significant reconstruction milestones, new class mappings, and architectural documentation for the current target.
* **PATCH (`x.y.Z`):** Increments for bug fixes, mapping corrections, and minor improvements.

The project follows a **single-branch workflow** (`main`) with version and baseline tags (`target-v<version>` and `v<SemVer>`), allowing immediate line-by-line diffing between APK releases using standard `git diff`.

For complete details, branching guidelines, and the APK upgrade procedure, see [docs/versioning.md](docs/versioning.md).

---

## Legal Notice

**This is not the official source code for Transfermóvil.** It is a close approximation reconstructed from the publicly distributed build of the application for research purposes.

The Copyright Laws of the United States recognize "fair use" of copyrighted content. Section 107 of the U.S. Copyright Act states:

> "Notwithstanding the provisions of sections 106 and 106A, the fair use of a copyrighted work, including such use by reproduction in copies or phonorecords or by any other means specified by that section, for purposes such as criticism, comment, news reporting, teaching (including multiple copies for classroom use), scholarship, or research, is not an infringement of copyright."

This repository and its contents are covered under fair use for the purposes of interoperability research, security auditing, and protocol analysis. Any DMCA takedown notice targeting this repository on these grounds would be invalid.
