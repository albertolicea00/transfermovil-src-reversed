# Changelog

## 2026-10-17 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

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
