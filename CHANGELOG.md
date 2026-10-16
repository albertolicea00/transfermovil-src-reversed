# Changelog

## 2026-10-16 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Decoded the AndroidManifest via aapt: mapped all activities, services, receivers, providers, permissions, intent filters, and deep links.
- Documented architecture in `docs/architecture.md`: two drawer modes (Agent/General), navigation tree, 3439 obfuscated app classes, e-commerce module, 30+ bundled JSON asset files, dependency inventory.
- Documented telephony in `docs/telephony.md`: USSD send/receive mechanism via accessibility service monitoring `com.android.phone`, 10 USSD codes found (`*222*` prefix family), SMS receiver `X9ZiE8XZNKy`.
- Documented networking/storage in `docs/networking.md`: OkHttp 4.2.2, certificate pinning evidence, known URLs (etecsa.cu, miboleto.mibulevar.com, apklis.cu, pamarillas.cu), auth tokens (ACCESS_TOKEN, X-XSRF-TOKEN, sessionToken), ORMLite local DB, SharedPreferences keys.
- Noted security-relevant flags: `debuggable=true`, `allowBackup=true`, `usesCleartextTraffic=true`, broad FileProvider paths.
- Updated AGENTS.md with doc links, README.md progress checklist.
- JADX/Apktool installation in progress — bytecode decompilation deferred.

## 2026-10-13 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Created the repository for Transfermóvil reverse engineering and documentation.
- Added the current APK metadata to `README.md` and its extraction procedure to `docs/target-metadata.md`.
- Added an extraction progress checklist and a note to `README.md` clarifying that analysis tasks depend on the decompiled APK.
