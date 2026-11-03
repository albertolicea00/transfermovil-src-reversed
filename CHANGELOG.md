# Changelog

## 2026-10-29 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Restored the original source bodies for all 28 database entities, including ORMLite constraints, constructors, metadata, accessors and JSON-visible fields; preserved `MCBank` and `MiBoletoService` table identities after semantic renaming. Compared model schemas/defaults/accessors and Gson payloads, and checked the base activity's AES delegation against JCE helpers.
- Updated README task progress from the checklist after expanding completed reconstruction work; it is now 73/138 (52%). Four mapping issues remain and all 63 multiply-candidate source paths are still explicitly queued for review.
- Replaced the throwing auth validator placeholder with the original typed state machine, including clearing and updating expired sessions; removed the alternative draft that omitted those writes. Restored AuthSession schema metadata and 20 missing operation enum constants (46 total).
- Compared 517 auth operation/state cases with a fixed test clock, including the exact 30-minute boundary, invalid dates and DAO errors. Expanded model/contract comparisons to 78 class pairs.
- Consolidated duplicate text/dictionary encoders and refresh/account/offer callback interfaces. Verified all dictionary entries and digit/unsupported/null/Unicode encoding behavior against the original. Duplicate-candidate originals decreased to 63.

- Reconstructed the USSD accessibility service, callback registry/interface, enabled-service checker and SMS receiver; corrected the original service path mapping. Compared 240 event scenarios, five enablement scenarios and SMS receipt/alert behavior with original classes under simulated Android, without live telephony actions.
- Consolidated the duplicate activation-code classes under `config/ActivationCodeValidator`, corrected callers and accessor entity imports, and verified 3,272 algorithm comparisons. Four missing clean mapping targets and 69 duplicate-candidate originals remain.

- Recovered the missing e-commerce `MessageHandler`, including a method JADX failed to reconstruct, from original smali. Preserved operation-specific messages, HTTP/log formats, null failures and the unhandled-statistics empty result.
- Added a restricted smali evaluator, source-hashed evidence for 126 operation/code combinations, JVM comparisons and documentation. Seven mapping incidences remain.

- Restored full source bodies for all 56 clean e-commerce model, domain, and geographic classes: original fields, constructors/defaults, inheritance, interfaces, accessors and nested DTOs. Corrected incomplete pagination filters, numeric payment/refund source IDs, missing profile/payment/QR fields and a substituted nested user type.
- Expanded JVM parity checks to 73 original/clean class pairs including nested classes and dependencies. Added actual Gson 2.9.1 JSON-tree comparisons using a local jar (optional via `TRANSFERMOVIL_GSON_JAR` elsewhere), covering defaults and setter mutations. Preserved original Gson member keys and the QR getter's fixed version behavior.

- Reconstructed `OwnCard`, `MobilePhone`, and `LandlinePhone` with original table/field metadata and corrected own-card, bank, agent, and MiBoleto DAO type identities.
- Restored numeric two-factor login codes and request marker interfaces; reconstructed the missing API response wrapper and permission/error enums with original grant IDs.
- Added JVM comparisons of 14 original/reconstructed model pairs, including schemas, defaults, metadata, enum IDs/order, and getters/setters. Mapping incidences decreased to 8; seven missing original-to-clean links were filled.

- Updated the README progress bar to 50% (65 of 130 TODO tasks), with an explicit task-count definition rather than an unsupported reconstruction percentage. Added `make progress`, refresh on `make inventory`, and stale-progress checking via `scripts/update-progress.py --check`.
- Corrected stale original paths for the base activity, USSD dispatcher, SMS sender/parser and base activity field mappings; corrected the existing SMS parser and login request target names. Mapping incidences decreased from 25 to 15; these link fixes do not establish behavioral fidelity.
- Added progress tests for completed work, expanding scope, rounding, repeatability, and missing inputs; updated reconstruction notes and handoff.

## 2026-10-28 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Resolved duplicate `OperationMenuBuilder` reconstructions: removed the banking draft with omitted method bodies and restored the complete original menu logic in the data package, preserving database caller APIs and original fragment strings.
- Restored `Operation.operacion` to the original enum type and reconstructed the missing `TaxRecord` entity with its original metadata quirks. Added/corrected verified menu, tax entity, and operation enum mappings.
- Added `make test-reconstruction`: JVM compilation and 85 original-versus-clean method/scenario comparisons with dependency substitutes, plus enum order and inventory tests. Full Android build, real SQLite/asset behavior, and navigation remain unverified.
- Regenerated the inventory: 70 originals with multiple candidates and 25 mapping incidences remain; updated reconstruction tasks and handoff.

- Resumed reconstruction from the local Claude session, project memories, and repository handoff.
- Added a reproducible source-to-clean inventory and `make inventory`; changed `make stats` to report exact links and inconsistencies without a completion percentage or a misleading unmapped-package list.
- Recorded 71 original paths with multiple candidates and 28 explicit mapping incidences; added reconstruction review tasks and documented `OperationMenuBuilder` integration differences.
- Verified that the reconstructed `BankOperationCode` preserves all 332 original constants in order; behavioral validation and duplicate resolution remain pending.

## 2026-10-17 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Removed `smali/` from local Git history while retaining the files in the working directory as ignored, local analysis input; `src/` remains versioned for mapping references and Java diffs.
- Created `.workspace/archives/smali-1.260416.162.zip` (3,439 smali files; SHA-256 `77dd5055bd0b9b5e0dea8bf9fb459858170739892fc78a8a9be73f4c12778737`) for versioned local storage and a possible future Release upload.
- Updated the versioning procedure and README to reflect local smali archives and Git-tracked JADX sources.
- Added a tracked `smali/.gitkeep` placeholder so fresh clones retain the empty directory while disassembly remains ignored.
- Replaced the planned SemVer and dual-tag scheme with APK version, versionCode, and internal release tags (`1.260416.162-v1.0`); renamed the local smali archive to `smali-1.260416.162.zip`.
- Created and pushed the annotated tag `1.260416.162-v1.0`; no GitHub Release entry exists yet.
- Added a README tag history table showing the available release tag and APK metadata.

## 2026-10-17 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Added repository inventory statistics, a documentation index, and a project tree to `README.md`; replaced the misleading all-checked list with explicit project statuses, removed an undefined completion percentage, and fixed the task-list link.
- Added TODO documents for an evidence-backed USSD code catalog and iOS port feasibility, with links from the repository guide and task list.
- Committed 28 interrupted Java reconstruction drafts for later review; several contain stubs and two represent the same obfuscated `OperationMenuBuilder` class.
- Added reusable `.workspace/handoff.md` with verified file counts, coverage limitations, unresolved source groups, and steps for resuming work.
- Defined repository versioning strategy and release lifecycle: established target-coupled Semantic Versioning (`MAJOR.MINOR.PATCH`) where MAJOR bumps track new upstream Transfermóvil APK releases, MINOR tracks reconstruction/mapping milestones, and PATCH tracks fixes.
- Created `docs/versioning.md`: documented single-branch workflow (`main`), Git tag conventions (`target-v<version>` and `v<SemVer>`), native uncompressed text storage rationale, cross-version diffing commands, and step-by-step target upgrade procedure.
- Updated `README.md` and `AGENTS.md` with versioning strategy overview and documentation links.

## 2026-10-16 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Restructured repo: `src/` now holds raw JADX output (obfuscated), `app/src/main/java/` is the clean reconstructed source target, `mappings/classes.json` tracks obfuscated → semantic name mappings.
- Security audit: exported components (deep link handler accepts unvalidated payment params from any app), FileProvider exposes entire sandbox, SharedPreferences stores auth tokens plaintext, no root/emulator detection.
- Added Makefile + 4 scripts: `decompile.sh`, `verify-apk.sh`, `mapping-stats.sh`, `search-strings.sh`.
- 10 clean reconstructed classes: USSD cipher (4 classes), CryptoProvider (7 AES schemes), BankAccount, AgentAccount, SessionManager, ApiClient (TLS bypass documented), AuthValidator (30-min session).
- 30 classes, 14 fields, 2 enums mapped in `mappings/classes.json`.
- Decoded the AndroidManifest via aapt: mapped all activities, services, receivers, providers, permissions, intent filters, and deep links.
- Documented architecture in `docs/architecture.md`: two drawer modes (Agent/General), navigation tree, 3439 obfuscated app classes, e-commerce module, 30+ bundled JSON asset files, dependency inventory.
- Documented telephony in `docs/telephony.md`: USSD send/receive mechanism via accessibility service monitoring `com.android.phone`, 10 USSD codes found (`*222*` prefix family), SMS receiver `X9ZiE8XZNKy`.
- Documented networking/storage in `docs/networking.md`: OkHttp 4.2.2, certificate pinning evidence, known URLs (etecsa.cu, miboleto.mibulevar.com, apklis.cu, pamarillas.cu), auth tokens (ACCESS_TOKEN, X-XSRF-TOKEN, sessionToken), ORMLite local DB, SharedPreferences keys.
- Noted security-relevant flags: `debuggable=true`, `allowBackup=true`, `usesCleartextTraffic=true`, broad FileProvider paths.
- Full crypto analysis in `docs/security.md`: 7 AES encryption schemes identified in V5FFEZ0Qrr0, hardcoded key `"ABCDEFGHIJKLMNOP"`, hardcoded salt `"1927271231"`, ECB mode usage, custom 2-iteration PBKDF, PBKDF2 for wallet ops.
- Updated AGENTS.md with doc links, README.md progress checklist.
- JADX/Apktool installation in progress — bytecode decompilation deferred.
- Deep smali analysis of accessibility service (`O7xyZJJBFWg`): confirmed START/STOP_LISTENING broadcast control, auto-click "ACEPTAR" on USSD dialogs, callback via `TVYvUziTDv.onUssdReceived()`.
- Confirmed USSD dial format `tel:*{access}*{service}#` via `ACTION_CALL` in `rDEl7rW1aN.actionCallUSSD()` (7 overloads).
- Documented USSD code obfuscation: `code()` method uses `crude_code` binary lookup table with `code_version` for parameter encoding.
- Found hardcoded encryption key material `cv = "708091521823824654864548452244"` in `rDEl7rW1aN`.
- Confirmed `BancoService` and `AgentService` are ORMLite DB entities (not service handlers). BancoService stores per-bank PINs in plaintext.
- Confirmed SMS stub receiver; real SMS handling via `HzjedYqYeh.send_sms()` and dynamic receiver `rDEl7rW1aN$18`.
- SMS code extraction methods found: `sms_code_bank`, `sms_code_agente`, `sms_code_boleto`, `sms_code_bulevar`.
- SMS parser analysis: `g0xM9kQCsqu` is a 13,840-line parser with 32 service types, gateway sender "PAGOxMOVIL", positional field extraction, activation code parsing from welcome SMS.
- USSD dispatch class `FBsQzP3Zfj` (8,898 lines): 12 `actionCallUSSD*` overloads, full format `tel:*{codigo}*{service}*{data}*{version}#`.
- Main activities identified: `IHVTCBmiLV` (Agent mode, `drawermenu`), `S9ycHcoxAzy` (General mode, `drawermenu_general`), both extend `rDEl7rW1aN`. Splash router `prPzLeyxKk` dispatches via `generalVsAgentVersion()`.
- Full database schema documented in `docs/storage.md`: 26 tables in `TransferMDB.sqlite` v162, migration logic drops legacy CodigoAcceso/Version tables.
- AppConfig entity: stores `codigo` (access code), `imei`, `phone`, `code_bank`, feature flags.
- Updated `docs/telephony.md`, `docs/security.md`, `docs/networking.md` with confirmed findings.
- Created `docs/domain-model.md`: complete catalog of 45 entity classes, 47 operations enum, 14 currencies, all field types. Security: only CuentaBanco.cuenta uses encryption; PINs, PII, IMEI all plaintext.
- Documented USSD packet protocol in telephony.md: `*<access>*<service>*<pos><max>*<seq>*<oper>*<agency>*<params>*<version>#`, packet splitting at 52 chars, SDK-dependent dispatch (TelephonyManager ≥26, accessibility <26).
- JADX 1.5.6 installed and decompiled full APK: 790 app Java classes + 4 encoding classes (98.8% success, 40 errors). Source in `app/src/`.
- 32 JSON asset files extracted and committed to `app/assets/` (bank branches, gas stations, provinces, Cubacel plans, transit fines, etc.).
- Created `docs/ecommerce.md`: e-commerce API client (`y6NQQxH0NI`) uses `getUnsafeOkHttpClient()` — TLS completely disabled (trusts ALL certs, no hostname verification). Login via `/loginapk` (email+password) and `/loginfactorapk` (2FA). 33 REST endpoints confirmed from Java source.
- Banking auth flow traced: `validateAuth()` checks `AOperKey` table, 30-minute session timeout, 4 auth states (NO_REGISTRADO, AUTH_OK, NO_AUTH, ERRO_AUTH). Local-only session management.
- Launch flow: `prPzLeyxKk` (splash) → `generalVsAgentVersion()` checks agent activation code → Agent mode (`IHVTCBmiLV`) or General mode (`S9ycHcoxAzy`).
- Full operation dispatch enum `FdonIAFI9w`: 332 operations across 5 banks (Metropolitano 61, BFI 61, BANDEC 60, BPA 55, Wallet 47).

## 2026-10-13 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Created the repository for Transfermóvil reverse engineering and documentation.
- Added the current APK metadata to `README.md` and its extraction procedure to `docs/target-metadata.md`.
- Added an extraction progress checklist and a note to `README.md` clarifying that analysis tasks depend on the decompiled APK.
