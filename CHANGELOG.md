# Changelog

## 2026-10-16 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

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
- Main activities identified: `S9ycHcoxAzy` (Agent mode), `IHVTCBmiLV` (General mode), both extend `rDEl7rW1aN`.
- Full database schema documented in `docs/storage.md`: 26 tables in `TransferMDB.sqlite` v162, migration logic drops legacy CodigoAcceso/Version tables.
- AppConfig entity: stores `codigo` (access code), `imei`, `phone`, `code_bank`, feature flags.
- Updated `docs/telephony.md`, `docs/security.md`, `docs/networking.md` with confirmed findings.

## 2026-10-13 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Created the repository for Transfermóvil reverse engineering and documentation.
- Added the current APK metadata to `README.md` and its extraction procedure to `docs/target-metadata.md`.
- Added an extraction progress checklist and a note to `README.md` clarifying that analysis tasks depend on the decompiled APK.
