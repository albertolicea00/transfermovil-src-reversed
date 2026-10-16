# Transfermovile Source (Reversed)

![Target Version](https://img.shields.io/badge/Target%20Version-1.260416-blue?style=flat-square)
![Version Code](https://img.shields.io/badge/Version%20Code-162-informational?style=flat-square)
![Min SDK](https://img.shields.io/badge/Min%20SDK-21-orange?style=flat-square)
![Target SDK](https://img.shields.io/badge/Target%20SDK-33-green?style=flat-square)
![Last Update](https://img.shields.io/badge/Last%20Update-October%202026-lightgrey?style=flat-square)

<!-- 50 blocks (each block █ = 2%) (░ empty blocks) -->
<span style="white-space: nowrap;"><code>[████████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░] 25%</code></span>

## Overview

This repository contains reverse-engineered source code, extracted resources, and structural analysis of the Transfermóvil client binary. The primary objective is to inspect implementation details, verify communication protocols (USSD/SMS/HTTP), and document internal logic.

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

## Extraction & Analysis Progress

- [x] Identify the target APK and verify its SHA-256 hash.
- [x] Extract and document package, version, and SDK metadata.
- [x] Inventory the APK contents and record the extraction tools used.
- [x] Decode the manifest and resources.
- [ ] Decompile the bytecode and check the quality and completeness of the output.
- [x] Organize the extracted files in the repository.
- [x] Review what was extracted and define the next analysis tasks from the evidence.
- [x] Document verified findings in focused `docs/` files.

> **Note:** Specific analysis tasks will be decided after inspecting the decompiled APK. The checklist does not assume which features or components the app contains.

*Check out the [TODO](../TODO.md) file for our complete development roadmap.*