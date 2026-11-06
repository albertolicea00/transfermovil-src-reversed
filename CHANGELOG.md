# Changelog

## 2026-11-06 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Replaced the BFI configuration tab's raw security menu with a clean menu that preserves its two source-backed options and navigation.
- Migrated BFI registration and PIN-change forms into clean classes. Preserved selector `49` with `05*<current-PIN>*<new-PIN>*<identity>` and partial-USSD marker `05`, plus selector `69` with `05*<current-PIN>*<new-PIN>`.
- Compared Wallet PIN authentication against JADX and documented selector `40`, access code `04`, the four-digit validation, and `04*<PIN>` payload in the USSD catalog.
- Updated the reconstruction checklist. Android compilation and runtime navigation remain unverified.

## 2026-11-05 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Traced additional fixed-telephone and ONAT stamp/tax dispatches from raw JADX source: selectors `42` and `43`, payload order, full-payment sentinel, and the ONAT partial-packet field-order difference. Added a literal-selector inventory count; the catalog remains incomplete.
- Traced both ONAT tax builders using selector `43`: one selects among payment modes and supplies `0000` defaults for unused fields; the other builds DPA, taxpayer, tax, period, amount, account, and optional entity fields, with agency-specific partial-USSD routing.
- Compared all nine literal selector-`41` electricity dispatches and documented the four observed invoice/currency-or-wallet/source-account payload shapes plus partial-USSD agency markers `01`–`05`. Updated the banking checklist for this source-backed flow.
- Compared all seven literal selector-`69` PIN-change dispatches: new-only, old/new, and prefixed old/new payloads; PIN confirmation, four/five-digit constraints, and Wallet partial-USSD routing. Updated the banking checklist.
- Traced bank disconnection selector `70` and Agent mobile-recharge close-session selector `11*6` to the shared direct-dial overload. Documented that the source confirms the UI route and action request, while server-side session termination cannot be established statically.
- Traced balance routes from banking and Agent menus: literal `*444*46`, account payload selector `46`, all-account selector `58`, and Agent stock selector `11*2`. The inspected paths all dispatch USSD; no SMS fallback appears in these balance handlers.
- Compared the bank transfer forms using selector `45`: BPA/Metropolitano short payloads include currency and optional recipient phone, while the extended form supports source-account selection, optional PIN prefix, amount/card currencies, phone, message, send-mobile and send-balance flags. Documented packet-payload reordering.
- Mapped all five account-registration screens routed from BPA, BANDEC, Metropolitano, BFI and MiTransfer menus. Selector `49` payloads differ by account, identity, name fields and PIN requirements; partial-USSD agency markers are `01`–`05`.
- Removed an unreferenced `MetroCambiarClaveFragment` draft that inflated layout ID `0`, used resource ID `0`, and had its dispatcher commented out. Its fingerprint routes from the BFI security menu to selector `69` with payload `05*<current-PIN>*<new-PIN>`; the clean Metropolitano PIN screen is separately restored in `MetroChangePinFragment`.
- Traced selector `62` limit inquiries through the CUP/CUC menu choice and account forms. Account payloads are `currency*account`; observed partial-USSD markers are `01`, `03`, and `05`, while the menu selector sends only currency ID `1` or `2`.
- Reconstructed the launcher `SplashActivity`: original 3-second delay, agent activation validation, fallback to General mode, launch error handling, splash menu and resource links. Agent and General activity bodies are now migrated into clean targets below.
- Inventory now links `prPzLeyxKk` to a clean class; mapping issues fell from four to three. The app-wide Android build and navigation are still unverified.
- The existing 16-test reconstruction suite and README progress check pass; the suite does not compile the Android activity or provide a Splash-specific runtime comparison.
- Restored the smali-backed `GlobalState.isAGTelecom()` activation check instead of the unconditional false placeholder. Compared 31 generated-code, missing/invalid-code, phone/version mismatch, and accessor-error cases against the original validator and method.
- Documented both USSD request paths' failure handling, the unused three-failure counter, accessibility-service gaps, and lack of an app-level timeout. Source review also found no explicit SIM/subscription selection in the inspected USSD/SMS paths; TODO now records both findings.
- Corrected the dispatcher overload documentation: its `String banco` argument stores the bank code and authentication timestamp, not a SIM slot. Recorded the `codigoAcceso` default (`444`) and its database initialization/update use.
- Restored `BaseMainActivity.code()` from JADX source: seed/table construction, digit-pair substitution, cyclic XOR, mixed Nauta character mapping, field-length prefixes, and legacy separators. Compared 49 numeric/mixed inputs against the original with a deterministic test seed; made `DigitSubstituter`'s two package-consumed fields package-private so `XorCipherStep` compiles. Full reconstruction suite: 18 tests pass.
- Documented the reversible USSD parameter transform and the default access code; README progress now includes this recovered behavior.
- Consolidated the duplicate `fDxylqSabM` candidates: retained the complete administrative keypad, removed the empty activation-pad draft, and reconstructed its direct three-digit access-code editor destination from `U4uiCgRvr6`. Added both source mappings; multiple-candidate paths decreased from 63 to 62.
- Consolidated `OQcONjDATJ` to its complete 11-tab agent data-management pager and removed an unused duplicate that returned `null`; multiple-candidate paths decreased to 61.
- Removed the null-returning alternate annotation for `ENqS9qPLC9` and reused the canonical banking mobile-list class in the general-mode contact pager. This resolves the link collision only; the mobile-list behavior is still an incomplete reconstruction.
- Removed the unused null-returning `wTZi6Zeikv` contact-pager draft. The retained banking pager matches the original eight-tab general-mode implementation; the deleted draft claimed ten tabs and returned `null`. No production references targeted the draft.
- Removed the remaining unreferenced `ui/contacts` drafts: 25 duplicate declarations for source classes already represented under `banking/ui`. Twenty-four were null-returning stubs and one contained fields/comments only. No code imported this package; candidates retained in `banking/ui` remain incomplete where noted, so this only removes false duplicate links.
- Resolved the remaining 34 duplicate source annotations by removing unreferenced, field-only `Agent*`/generic fragments; retained the corresponding `Wallet*` source candidate based on its annotation and declared fields. The inventory now has no multiple-candidate paths. Wallet fragments still vary in completeness and are not runtime-verified; this is source identity cleanup, not feature completion.
- Marked the source-collision review complete and refreshed README inventory counts; the task bar changes only for the completed review item.
- Documented the source-backed Bulevar launch path in both app modes, offline retry state, startup URL/currency initialization, and no-token versus token routing; Android runtime behavior remains unverified.
- Mapped both mode drawers to their exact fragment/activity destinations, recorded the differing wallet targets and permission requests, and flagged raw-only destinations. Android navigation remains unverified.
- Restored the home operations grid adapter from JADX: loads active and inactive operations from `DatabaseHelper`, renders the original card layout, uses the original dispatcher for fragment/dialog routing, and supports adding, removing, and reordering operations with order updates persisted to the DAO. Android runtime and resource IDs remain unverified.
- Migrated the full Agent and General activity bodies from JADX into clean package classes, adapted their package-local activity references, and routed the splash and manifest through them. Their implementation still imports retained raw service, entity, and fragment classes.
- Migrated the full Bulevar startup/login activity body into clean `ecommerce/LoginActivity`, registered it while retaining the obfuscated manifest activity for raw callers, and upgraded its mapping confidence based on the body match. The inventory now has zero mapping issues. Android compilation/runtime remain unverified.
- Migrated the BFI balance, limits, latest-operations, and payment-priority fragments plus both account-form bases. Their USSD codes match JADX (`46`, `62`, `48`, and `28`; partial forms for the first three). Recovered `mostrarTarjeta()` in both bases from archived smali; both methods have the same control flow after source line numbers are normalized, mapping bank prefixes to the original card drawables and swallowing malformed identifiers as before.
- Restored five bank operation tab pagers (BANDEC, BFI, BFI enterprise, BPA, Metropolitano) from JADX, including their original child fragments, tab counts, and titles. These clean wrappers still depend on raw child fragment classes; no Android build has verified them.
- Migrated the five bank logo tab hosts and routed each to its clean operation pager, preserving the original layouts, colors, and logo custom views from JADX.
- Migrated four Metropolitano screens (CUC-to-CUP conversion, limit changes, payment priority, card reprint) and introduced a clean commission-account base for the reprint flow. The screens now use the reconstructed BFI account bases where source inheritance matches; reprint retains raw model/service dependencies.
- Added an initial evidence-backed USSD catalog for eight BFI and Metropolitano operations, including account/limit payload order, the common reversible transform, direct-call template, and partial-packet selectors. Full packet splitting and the broader app-wide inventory remain open.
- Recovered `EV9Tu0zIL4.validarCuenta()` from archived smali and added a clean shared account-validation fragment used by the BFI account bases. It preserves bank-prefix routing, PAN/standardized card types, currency rules, early invalid results, and the original null result on parsing exceptions.
- Refreshed README progress to 110/167 tasks (66%) and source inventory to 457 clean files, 339 unlinked JADX files, no duplicate candidates, and no mapping issues. Two utility/draft classes remain unannotated.
- Added a reproducible package-segment breakdown for the 208 unlinked main-package files; the remaining task still requires class-by-class classification because package counts alone do not separate generated code from app behavior.
- Surveyed banking UI dispatcher usage: 66 single-line `actionCallUSSDBack` call sites and 32 distinct service selectors. Recorded the partial-scan limits in the catalog; more variants remain to trace.
- Confirmed `RECEIVE_BOOT_COMPLETED` is declared without a registered boot receiver; the raw receiver class is a no-op. Documented that distinction in the architecture notes.
- Mapped the General-mode “Servicios SMS” drawer to four confirmation-gated messages sent to `2266` (`OFERTA`, `TARIFA`, `PLANES`, `AMIGOS`) and documented that menu as SMS-based.
- Documented the five General-mode useful phone actions (`104`–`107`, `103`) and the Voto Móvil sender/QR flow. The channel asset contains 10 free-coded and 10 paid-coded entries; the UI still requires send confirmation.
- Documented shared QR scan routes, CameraX/ML Kit and legacy ZXing modes, gallery fallback, and the boundary between decoding and submitting an operation.
- Documented Mi Turno reservation, query, date-change, and cancellation selectors and payload fields, plus static catalogs, identity QR prefill, commission/notification behavior, and the date-picker horizon.
- Documented OFA Ciudades Patrimoniales: local city/reservation catalogs, client-side pricing and date inputs, confirmation, optional contact/balance flags, and USSD selector `8`.
- Documented traffic-fine selector `97`, confirmation and payload order, and the local `art_inc_transito.json` catalog (95 articles, 430 incisos).
- Migrated MiBoleto and fuel-ticket detail fragments from their complete JADX bodies. MiBoleto now uses the clean auth validator, restores list/refresh/consumed-state actions and ticket QR generation; fuel-ticket account callbacks reload ticket data and update the progress bar. Reviewed the three-field MiBoleto service-account entity and documented the QR payload flow.
- Restored the general account transfer form from JADX: saved-account suggestions, 16-digit account and optional 8-digit recipient-phone validation, contact picker normalization, QR import/export routes, and confirmation-gated selector `45` dispatch. Android runtime remains unverified.
- Classified the outbound SMS paths from source call sites (`2266` service queries and Voto Móvil `2899`/`3099`) and distinguished them from useful-number calls and banking USSD flows.
- Documented the transfer form's contact-picker permission, phone-row query, number normalization, and final eight-digit validation.
- Refreshed the task bar after these documentation/reconstruction blocks: 120/167 tasks (72%); README and TODO counts match. Source inventory remains 457 clean files, 339 unlinked originals, and no mapping conflicts. Android build/runtime validation remains pending.
- Expanded the USSD catalog with confirmed source paths for general account transfer, Mi Turno reserve/change/cancel/query, traffic-fine payment, and OFA heritage reservations. The overall catalog remains open for remaining selectors and dynamic variants.
- Restored the six `BaseMainActivity.actionCallUSSD` overloads from the original dispatcher: direct access-code calls, encoded calls with AppConfig fallbacks, explicit access-code calls, confirmation dialogs, and form clearing. Migrated the wallet classic-balance screen and wired the wallet-versus-classic balance chooser to selector `46` or the account form.
- Reconnected QR transfer generation to the original encrypted bank-account getter/setter through a clean `BankCodeAccessor` adapter, initialized the original database service, and corrected the `BankType` package import. This restores saved-account autofill and persistence for supported banks.
- Replaced three banking class shells with their full JADX bodies: Metropolitano gas payment, Metropolitano PIN change, and BPA balance/limits query. Corrected the mislabeled gas-payment draft to its source-backed function name and added these selectors/payloads to the partial USSD catalog.
- Restored the two remaining BPA account-query shells (card balance and latest operations) against their original source, including direct and partial USSD paths with gateway packet version `01`; expanded the USSD catalog with their exact parameter order.
- Restored six additional Metropolitano source bodies: service-based latest-operations query, water/electricity/gas payment, two ATM/POS limit variants, and account association. Added the distinct selectors and parameter layouts to the USSD catalog.
- Replaced 23 empty Metropolitano Java shells with their original JADX bodies (authentication, account selectors, bill payments, transfers, navigation, and related screens). Recovered both card-rendering methods that JADX emitted as throwing stubs from archived smali and restored the coordinate-transfer and Cubacel-plan screens.
- Replaced 16 empty BPA shells with original source bodies, including operation menu, authentication, transfers, service payments, PIN changes, and account queries.
- Recovered the four BPA `mostrarTarjeta()` implementations from archived smali while migrating their full screen bodies, completing the corresponding account-card rendering paths.
- Restored ten banking list/edit class shells (invoices, Nauta, own cards, public services, bank accounts, landlines, and MiBoleto) from their original source bodies.
- Replaced 33 empty Wallet Java shells with original JADX bodies, including transfers, ticket purchases, service payments, fines, Nauta/Cubacel recharges, and fuel operations. Routed wallet fragments through clean account bases where the source inheritance matched.

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
