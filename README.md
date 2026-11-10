# Transfermóvil Source (Reversed)

![Target Version](https://img.shields.io/badge/Target%20Version-1.260416-blue?style=flat-square)
![Version Code](https://img.shields.io/badge/Version%20Code-162-informational?style=flat-square)
![Min SDK](https://img.shields.io/badge/Min%20SDK-21-orange?style=flat-square)
![Target SDK](https://img.shields.io/badge/Target%20SDK-33-green?style=flat-square)
![Last Update](https://img.shields.io/badge/Last%20Update-November%202026-lightgrey?style=flat-square)

<!-- 50 blocks; each full block = 2% of TODO tasks --> <!-- do not delete this progress-bar-->
<span style="white-space: nowrap;"><code>[████████████████████████████████████████████░░░░░░] 88%</code></span>

**Task-list progress: 292/329 completed; 37 pending.** Tasks have equal weight. This is not verified code coverage or a working-app percentage. The value can fall when scope grows. Run `make progress` or `make inventory` to refresh it from [TODO.md](TODO.md).

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
| **Project tag** | `1.260416.162-v1.0` |
| **Min SDK** | `21` |
| **Target SDK** | `33` |
| **SHA-256 Hash** | `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a` |

See [metadata extraction](docs/target-metadata.md) to reproduce these values from the APK.

## Project status

| Area | Status | Current state |
| :--- | :--- | :--- |
| APK identification and extraction | Complete for the current APK | Metadata, manifest, resources, JADX Java, and smali are available. |
| Clean Java reconstruction | In progress | 457 files exist; some are partial or contain stubs. The source-link inventory currently has no duplicate candidates. |
| Protocol and feature analysis | In progress | Topic documents contain findings; the complete USSD code catalog remains a TODO. |
| iOS port research | Planned | Feasibility, platform limits, and feature parity remain TODOs. |
| Build and behavioral validation | Pending | The reconstructed Java tree has not been compiled or verified as a working app. |

See the [task list](TODO.md) for specific remaining work. Paused sessions record a temporary checkpoint in `.workspace/handoff.md`. The bar above tracks completed checklist items; full reconstruction and Android behavior remain unverified.

## Documentation

| Document | Contents |
| :--- | :--- |
| [Target metadata](docs/target-metadata.md) | APK identity, version, SDK levels, and SHA-256 extraction. |
| [Banking differences](docs/banking-bank-differences.md) | Source-backed comparison of BPA, BANDEC, Metropolitano, and BFI flows. |
| [Fine payments](docs/traffic-fines.md) | General and traffic fine forms, selector 96/97 payloads, validation, and confirmation dispatch. |
| [ONAT tax payments](docs/onat-tax-payments.md) | Selector 43 tax form variants, field defaults, partial-USSD routing, and source limits. |
| [Agent registration](docs/agent-registration.md) | Agent activation request, SMS code retrieval, local validation algorithm, persistence, and confirmed menu selectors. |
| [General carrier services](docs/general-carrier-menu.md) | General-mode mobile-service menu inventory, fragment destinations, and operation database behavior. |
| [MiTransfer CUP ticket recharge](docs/wallet-ticket-recharge.md) | Clean selector-17 ticket form, partial-USSD routing, and source comparison. |
| [MiTransfer mobile recharge](docs/wallet-mobile-recharge.md) | CUP/USD wallet top-up form, contact normalization, and selector/payload mapping. |
| [MiTransfer mobile transfer](docs/wallet-mobile-transfer.md) | Selector-45 mobile transfer, amount/account validation, wallet type, optional flags, and partial-USSD route. |
| [MiTransfer cash withdrawal](docs/wallet-cash-withdrawal.md) | Selector-95 cash ticket, currency-specific entities, optional province/municipality, and partial-USSD dispatch. |
| [MiTransfer classic transfer](docs/wallet-classic-transfer.md) | Classic-card destination validation, optional origin/PIN, selector-45 payload, and packet route. |
| [MiTransfer bank transfer](docs/wallet-bank-transfer.md) | Selector-16 transfer from bank accounts, agency list, currency checks, and partial-USSD route. |
| [MiTransfer electricity payment](docs/wallet-electricity-payment.md) | Selector-41 invoice payment, local invoice persistence, and partial-USSD route. |
| [MiTransfer water payment](docs/wallet-water-payment.md) | Region/payment-type branches, selectors 19/21, saved invoice persistence, and partial-USSD behavior. |
| [MiTransfer gas payment](docs/wallet-gas-payment.md) | Selector-67 invoice payment, saved gas account persistence, and partial-USSD route. |
| [MiTransfer Nauta recharge](docs/wallet-nauta-recharge.md) | General Wallet selectors 59/84/86 for Nauta and Nauta Hogar, including partial-USSD routing. |
| [MiTransfer Nauta Plus](docs/wallet-nauta-plus.md) | Selector-34 purchase form for saved-account and beneficiary-mobile modes. |
| [MiTransfer own-card recharge](docs/wallet-own-card-recharge.md) | Selector-77 CUP wallet recharge of a 12-character saved card series. |
| [MiTransfer Extra USD package](docs/wallet-extra-package.md) | Selector-33 beneficiary request that starts the Extra USD offer flow. |
| [MiTransfer 4G/FWA](docs/wallet-fwa.md) | Selector-20 balance recharge and selector-18 USD gigabyte offer request. |
| [MiTransfer Cubacel packages](docs/cubacel-package-purchase.md) | Local/JSON plan catalog and selector-6 CUP/USD package request. |
| [MiTransfer TFA recharge](docs/wallet-tfa-recharge.md) | Selector-108 CUP recharge with partial-USSD routing. |

| [MiTransfer organization payment](docs/wallet-political-organization-payment.md) | PCC/UJC selector-7 payment and the source-only selector-122 branch. |
| [MiTransfer OFA reservation](docs/wallet-ofa-reservation.md) | Selector-8 reservation payload, fare calculation, and regular/partial dispatch. |
| [MiTransfer OFA contribution](docs/wallet-ofa-contribution.md) | Selector-94 obligation payment with period picker and CUP routing. |
| [MiTransfer ticket reservations](docs/wallet-ticket-reservations.md) | Create/cancel/date-change actions with selectors 102/106/105 and state reset. |
| [MiTransfer fixed-phone payment](docs/wallet-fixed-phone-payment.md) | Selector-42 total/manual bill payment, saved account, and partial routing. |
| [MiTransfer Pago en Línea](docs/wallet-qr-dynamic-payment.md) | QR payment form with static/dynamic selectors 31/30 and origin-account branches. |
| [MiTransfer enterprise operations](docs/wallet-enterprise-routes.md) | Enterprise transfer/payment dialog routing and typed arguments. |
| [MiTransfer MiBoleto purchase](docs/wallet-miboleto-purchase.md) | Selector-118 offer purchase and shared booking state reset. |
| [Agent statistics](docs/agent-statistics.md) | Source-backed summary/detail paths, local SMS data, filters, and the summary loader's static risk. |
| [Architecture](docs/architecture.md) | Manifest components, app modes, navigation, dependencies, and assets. |
| [Telephony](docs/telephony.md) | Current USSD and SMS analysis, including dispatch and response handling. |
| [USSD code catalog TODO](docs/ussd-code-catalog.md) | Planned inventory of executed codes, their purposes, and construction algorithms. |
| [Networking](docs/networking.md) | HTTP stack, URLs, tokens, TLS, and local persistence. |
| [Security](docs/security.md) | Cryptography, key handling, and security findings. |
| [Storage](docs/storage.md) | SQLite schema, ORMLite entities, migrations, and preferences. |
| [Domain model](docs/domain-model.md) | Entities, operations, currencies, and enum mappings. |
| [E-commerce](docs/ecommerce.md) | API client, endpoints, authentication, and sessions. |
| [E-commerce errors](docs/ecommerce-errors.md) | Error-code messages recovered from smali and checked against bytecode evidence. |
| [Versioning](docs/versioning.md) | Repository versions, tags, and cross-version comparisons. |
| [Reconstruction inventory](docs/reconstruction-inventory.md) | Reproducible source links, duplicate candidates, mapping conflicts, and review limits. |
| [iOS port TODO](docs/ios-port-todo.md) | Planned feasibility study, platform limits, and feature parity decisions. |

For work in progress, use the [task list](TODO.md). Paused sessions also provide `.workspace/handoff.md`. [CHANGELOG.md](CHANGELOG.md) records completed changes; [AGENTS.md](AGENTS.md) is the repository guide for contributors and coding agents.

---

## Versioning Strategy

Release names and Git tags use `<APK versionName>.<APK versionCode>-v<internal version>`. The current target's first project release is `1.260416.162-v1.0`. Later work on the same APK uses `-v1.1`, `-v1.2`, and so on; a new APK starts its own internal sequence at `-v1.0`.

The project follows a **single-branch workflow** (`main`). Raw JADX Java in `src/` stays in Git for mapping references and cross-version diffs. Smali stays in the local `smali/` directory, ignored by Git, with APK-specific ZIPs in `.workspace/archives/` for local comparison or possible future Release assets.

For complete details, branching guidelines, and the APK upgrade procedure, see [docs/versioning.md](docs/versioning.md).

## Tag History

| Tag | APK version | Version code | Internal release | GitHub Release |
| :--- | :--- | ---: | :--- | :--- |
| [`1.260416.162-v1.0`](https://github.com/albertolicea00/transfermovil-src-reversed/tree/1.260416.162-v1.0) | `1.260416` | `162` | `v1.0` | Not published |

---

## Project structure

```text
.
├── app/
│   ├── assets/                     Extracted JSON and other assets
│   ├── res/                        Extracted Android resources
│   └── src/main/java/             Clean, still incomplete Java reconstruction
├── src/                           Raw, obfuscated JADX Java output
├── smali/                         Local Dalvik disassembly (Git-ignored)
├── mappings/
│   └── classes.json               Obfuscated-to-clean name mappings
├── docs/                          Topic-specific analysis and TODOs
├── scripts/                       Extraction, verification, and search tools
├── .workspace/
│   ├── handoff.md                  Temporary pause/resume note, tracked by Git
│   ├── bin/                        Local APK inputs
│   └── archives/                   Local versioned smali ZIPs
├── Makefile                        Analysis commands
├── TODO.md                         Remaining project tasks
├── CHANGELOG.md                    Completed changes by analysis session
├── AGENTS.md                       Repository working guide
└── README.md
```

*Generated files under `.workspace/` and the local `smali/` directory are excluded from Git, except for `smali/.gitkeep`, which keeps the empty directory in clones. `handoff.md` is tracked so a paused session can be resumed. A fresh clone needs the matching APK to regenerate smali, or a separately obtained versioned smali ZIP.*

Repository inventory for the current target (2026-10-17):

| Item | Count | Location |
| :--- | ---: | :--- |
| Decompiled Java files | 794 | `src/` (including 596 in the main app package) |
| Clean Java reconstruction files | 457 | `app/src/main/java/` |
| Local smali files | 3,439 | `smali/` (ignored by Git) |
| Extracted resource files | 35 | `app/res/` |
| Extracted asset files | 32 | `app/assets/` |
| Topic documents | 11 | `docs/` |
| Class mappings | 86 | `mappings/classes.json` |
| Analysis scripts | 4 | `scripts/` |

*These are file and mapping counts, not a measure of reconstruction completeness; some clean classes are partial or duplicate the same original class.*

## Legal Notice

**This is not the official source code for Transfermóvil.** It is a close approximation reconstructed from the publicly distributed build of the application for research purposes.

The Copyright Laws of the United States recognize "fair use" of copyrighted content. Section 107 of the U.S. Copyright Act states:

> "Notwithstanding the provisions of sections 106 and 106A, the fair use of a copyrighted work, including such use by reproduction in copies or phonorecords or by any other means specified by that section, for purposes such as criticism, comment, news reporting, teaching (including multiple copies for classroom use), scholarship, or research, is not an infringement of copyright."

This repository and its contents are covered under fair use for the purposes of interoperability research, security auditing, and protocol analysis. Any DMCA takedown notice targeting this repository on these grounds would be invalid.
