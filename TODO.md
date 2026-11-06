# TODO — Transfermóvil Reverse Engineering

## Extraction & Setup

- [x] Verify APK identity (SHA-256, package, version, SDK levels)
- [x] Inventory APK contents (DEX, assets, libs, resources)
- [x] Decode manifest via aapt (components, permissions, intent filters)
- [x] Extract resource strings (operations, UI labels, error messages)
- [x] Map drawer menu navigation structure (agent vs general modes)
- [x] Extract REST API endpoints from DEX strings
- [x] Identify named (unobfuscated) classes and infer package roles
- [x] Document asset JSON files (banking, geographic, tax, transit data)
- [x] Install JADX and decompile bytecode to Java source
- [x] Install Apktool and decode resources to readable XML
- [x] Organize decompiled source into `app/` directory
- [x] Extract smali disassembly into `smali/` directory
- [x] Verify decompilation quality and completeness (98.8%, 40 errors)

## Clean Java Reconstruction

- [x] Generate a reproducible [source-to-clean inventory](docs/reconstruction-inventory.md) with duplicate candidates and mapping inconsistencies.
- [x] Resolve `OperationMenuBuilder` duplicates, restore full source behavior and immediate entity dependencies, and compare against JADX in an isolated JVM harness.
- [x] Restore missing phone/card entities and correct DAO entity identities against the original schema.
- [x] Restore two-factor integer codes, request marker, API response wrapper, and permission/error enums; compare model schemas and accessors against original JVM classes.
- [x] Restore all 56 e-commerce model/domain/geographic classes against original source, including payment, refund, pagination, profile and QR structures; compare their JSON payloads with Gson.
- [x] Recover the e-commerce error handler from smali and compare operation/default/null behavior against bytecode evidence.
- [x] Reconstruct the USSD accessibility service/callback/checker and SMS receiver; compare event/control flow against original classes under simulated Android.
- [x] Consolidate duplicate activation validators and compare the canonical algorithm against original source for normal/error inputs.
- [x] Restore auth validation/session metadata and all operation enum values; compare expiry boundaries and DAO errors with the original.
- [x] Restore `GlobalState.isAGTelecom()` from smali and compare valid, invalid, missing, and DAO-error behavior against the original activation flow.
- [x] Consolidate duplicate character/text encoders and callback interfaces; verify dictionary/marker behavior and callback contracts.
- [x] Reconstruct the launcher splash router, including its three-second delay and agent-code-based mode selection.
- [x] Add clean Agent and General activity targets to the manifest and splash route while preserving their original inherited behavior.
- [x] Consolidate the administrative keypad collision and restore its AppConfig access-code editor destination.
- [x] Remove the unused null-returning alternate `OQcONjDATJ` pager and map the complete 11-tab agent data-management pager.
- [x] Remove the null-returning alternate `ENqS9qPLC9` mobile list candidate and point the general-mode pager to its canonical source mapping.
- [x] Restore all 28 database entity source bodies, including field constraints, metadata, constructors and accessors; preserve the original default table names for renamed entities and compare schemas/defaults/accessors/JSON.
- [x] Restore the base activity's AES encryption/decryption delegation and compare its original JCE behavior.
- [x] Restore the shared BFI account-entry base and balance-query screen, including saved-account loading, account/currency selection, validation, and direct/partial USSD dispatch.
- [x] Restore the second BFI account form base plus limit, latest-operations, and payment-priority screens from their JADX sources.
- [x] Recover the two BFI `mostrarTarjeta()` methods that JADX emitted as throwing stubs; verify card-type and image behavior from smali.
- [x] Recover the Metropolitano coordinate and Cubacel-plan card-rendering methods from smali and restore both screens.
- [x] Replace 16 empty BPA class shells with their source bodies from JADX.
- [x] Restore four BPA screens with truncated `mostrarTarjeta()` methods using archived smali behavior.
- [x] Restore ten short banking list/edit screens whose original bodies were available in JADX.
- [x] Replace 33 empty Wallet Java shells with their original JADX bodies and clean shared account bases where available.
- [x] Restore the five bank operation tab pagers and their original fragment routing from JADX.
- [x] Restore the five bank logo tab hosts and connect them to the clean operation pagers.
- [x] Restore the four interrupted Metropolitano operation screens and migrate their shared commission-account base.
- [x] Document eight source-confirmed BFI/Metropolitano USSD operations and their dispatcher template.
- [x] Recover the shared BFI bank/card/currency validator from smali and remove its raw base-class dependency.
- [x] Restore QR transfer saved-account retrieval and persistence through the original encrypted bank-code accessor.
- [x] Restore Metro gas payment and PIN change screens plus the BPA balance/limits query from JADX.
- [x] Restore BPA card-balance and latest-operations query screens from JADX.
- [x] Restore six additional Metropolitano query, payment, and limit-change screens from JADX.
- [x] Replace 21 empty Metropolitano class shells with their original source bodies.
- [x] Restore `BaseMainActivity.code()` numeric/mixed USSD encoding, document the reversible transformation, and compare output with the original under a fixed seed.
- [x] Review all 60 original paths with multiple reconstruction candidates; remove unreferenced duplicate drafts and retain one source candidate per path. Remaining classes can still be incomplete and require behavioral reconstruction.
- [x] Resolve all three missing clean activity mapping targets with source-backed Agent, General, and Bulevar login implementations.
- [x] Restore the Bulevar login startup screen: offline retry, progress state, startup presenter result handling, and token-based route to login/home.
- [x] Replace the raw BFI security-menu page with a clean menu and migrate its registration and change-PIN forms, preserving source-confirmed validation and USSD payloads.
- [x] Replace the raw BFI session tab with a clean menu and PIN-authentication screen; preserve the local session reset and confirmed selector-70 action.
- [x] Replace the raw BFI consultations menu and route its actions to clean balance, latest-operations, limit, and account-statement fragments.
- [x] Migrate the BFI account-statement form with date-range, email, and charge-account validation plus selector-26 dispatch.
- [x] Compare the BFI account-statement form with JADX; confirm the migrated validations and selector-26 payload match the source.
- [x] Repair BPA account/session menu dispatch to use the source agent-code helper and existing activity interfaces; replace unresolved close-session dispatcher calls.
- [x] Replace seven invalid static `UssdDispatcher.actionCallUSSDBack` calls in BPA and MiTransfer forms with the matching source `FBsQzP3Zfj` overloads.
- [ ] Review remaining partial BFI/Wallet implementations and compare their behavior with source before claiming feature completeness.
- [x] Reconstruct the BFI USSD account base from Agg55uYctq by reusing clean account selection/card behavior and restoring observer callbacks and the four-parameter packet limit.
- [x] Migrate the BFI payment form and the QR/contact base it needs onto clean Java; preserve both selector-31/selector-30 payment branches.
- [x] Migrate the BFI enterprise-transfer form from `f1IveoSASW` onto `BfiUssdAccountFragment` and connect the three transfer modes to it.
- [x] Compare migrated BFI transfer/payment form bodies with JADX; confirm payload branches and selectors `104`, `31`, and `30` while noting clean shared-base callback delegation.
- [x] Compare BFI balance, limit, and latest-operation forms with JADX; confirm selectors `46`, `62`, and `48`, their payload construction, and partial-USSD marker `05`.
- [x] Compare general-fine and traffic-fine Wallet forms with JADX; confirm selectors `96`/`97`, field order, and the absence of partial-packet dispatch in both screens.
- [x] Migrate the BFI transfer/payment operations menu and its three-mode dialogs; keep source forms as destinations pending their own clean migrations.
- [ ] Review the remaining 208 main-package source files without exact reconstruction links; distinguish generated code from application logic.
- [ ] Compile and validate reconstructed behavior before claiming functional completeness.

## Architecture & Navigation

- [x] Map manifest components (activities, services, receivers, providers)
- [x] Identify two app modes: Agent and General
- [x] Trace launch activity → main screen flow
- [x] Map Agent and General drawer menu items to their raw fragment/activity destinations; identify destinations without clean classes.
- [x] Restore the home operations grid adapter: database loading, saved ordering, add/remove actions, and original dispatcher routing for fragment and dialog operations.
- [x] Identify how agent vs general mode is selected and persisted
- [x] Document the splash/intro flow (first-run vs returning user)
- [x] Map the `generalVsAgentVersion` logic
- [x] Document the e-commerce Bulevar entry from both mode drawers and startup routing by token state.

## USSD / Telephony

- [ ] Complete the dedicated [USSD code catalog](docs/ussd-code-catalog.md): every executed code, purpose, construction algorithm, and source evidence.
- [x] Document USSD send mechanism (tel: intent + CALL_PHONE)
- [x] Document accessibility service USSD response capture
- [x] List discovered USSD codes (*222*, *100*, *111, *133, *234)
- [x] Decompile `sendDataUSSD` and trace full USSD code construction
- [x] Decompile accessibility service response parsing logic
- [x] Map USSD code → operation mapping (*444=BANDEC, *222=main, 100+ service codes)
- [x] Document multi-step USSD flows (sendNextUssd / nextUssdCode)
- [x] Check dual-SIM routing in telephony source; document absence of explicit subscription selection in the inspected paths.
- [x] Document USSD API failures, response parsing, accessibility-service failure, and the absence of an app-level timeout/retry.
- [x] Map USSD code format: `*{access}*{service}#` via actionCallUSSD

## SMS

- [x] Identify SMS receiver (X9ZiE8XZNKy)
- [x] Decompile SMS receiver — stub/no-op, real handling elsewhere
- [x] Document outgoing SMS format (HzjedYqYeh.send_sms via SmsManager)
- [x] Document SMS response parsing (g0xM9kQCsqu, 32 service types, PAGOxMOVIL sender)
- [x] Map General-mode "Servicios SMS" menu operations to their recipient, message body, and confirmation flow.
- [x] Identify SMS-based operations vs USSD-based operations

## Banking

- [x] List banking operations from string resources
- [x] Identify BancoService as banking service handler
- [x] Decompile BancoService — ORMLite entity, stores bank PINs plaintext
- [x] Document authentication flow (30-min session via AOperKey table)
- [x] Trace balance inquiry routes from bank/menu screens to USSD, including account-specific selector `46`, all-account selector `58`, direct `*444*46`, and Agent stock `11*2`; no SMS dispatch is used by these traced flows.
- [x] Trace bank transfer flow (banco_transferencia → selector `45`), including short bank forms and extended origin/PIN/phone/message/balance payload construction.
- [x] Trace PIN change flow (banco_cambiar_clave), including selector-69 new-only, old/new, prefixed old/new, and length-validation variants.
- [x] Document source-confirmed per-bank differences (BPA, BANDEC, Metropolitano, BFI); unknown coverage remains explicitly marked.
- [x] Map account registration flow (banco_registro) across BPA, BANDEC, Metropolitano, BFI and MiTransfer, including each selector-49 payload and partial-USSD agency marker.
- [x] Remove the unreferenced Metro PIN-change draft whose layout IDs and USSD dispatch were placeholders; its source fingerprint belongs to the BFI `BFICambioPin` menu, while the actual Metro PIN screen remains `MetroChangePinFragment`.
- [x] Document electricity payment flow (banco_electricidad), including observed bank/wallet payload and partial-packet variants.
- [x] Document general and traffic fine payment flows (`banco_multa`), selectors `96` and `97`, source-backed payload order, validation scope, and dispatcher behavior.
- [x] Document ONAT tax payment (`banco_onat`): RC05/NIT and partial-payment variants under selector `43`, defaults, and source-confirmed partial-USSD routing.
- [x] Compare migrated ONAT RC05/NIT form with raw `ROgpLrCtHa`; confirm selector-43 payload builders and agency packet routing match.
- [x] Record source-confirmed fixed telephone and ONAT stamp USSD payload variants (selectors 42 and 43) in the [USSD catalog](docs/ussd-code-catalog.md); other ONAT and telephone variants remain under review.
- [x] Record both ONAT tax payload builders for selector 43, including field order and default sentinel values, in the [USSD catalog](docs/ussd-code-catalog.md).
- [x] Trace transaction-limits queries from bank menus and account forms: direct CUP/CUC selectors `62*1/2`, plus account payloads and partial-USSD agency markers `01`, `03`, and `05`.
- [x] Document session-management dispatches for `banco_desconectar` and `OP_Close_Session`, including direct dialing and the limits of source-only evidence.

## MiTransfer (Wallet)

- [x] Identify MiTransfer in drawer menu and string resources
- [x] Source-trace the MiTransfer CUP ticket form: amount validation, selector 17, full/partial dispatch, and callback behavior.
- [x] Reconstruct and connect the MiTransfer mobile recharge form from `zzyNbaqs1U`, preserving CUP menu routing, CUP/USD selectors, contact normalization, and payload construction.
- [x] Reconstruct the MiTransfer mobile-to-mobile transfer form from `LjOlaYSSMH` and route the wallet transfer dialog's MiTransfer choice to it; preserve selector 45 and partial-USSD behavior.
- [x] Reconstruct the MiTransfer cash-ticket withdrawal form from `f9Reflqt3EZ` and connect its menu route; preserve selector 95, currency/entity selection, optional location fields, and partial-USSD behavior.
- [x] Reconstruct the classic-card transfer form from `l3GXbXAyUW` and connect the “Clásica” dialog choice; preserve selector 45, card/PIN branches, validation, and partial-USSD behavior.
- [x] Reconstruct the bank-to-wallet transfer form from `H0oV6Ot0bS` and connect `BOLSATransferirBancos`; preserve selector 16, local agency data, validation, and partial-USSD behavior.
- [x] Reconstruct the MiTransfer electricity form from `dwdZ5sHcFR` and connect `BOLSAElectricidad`; preserve selector 41, CUP invoice payload, local invoice persistence, and partial-USSD behavior.
- [x] Reconstruct the MiTransfer water form from `U1sIOmca96i`, reuse the mapped clean shared account base, and connect `BOLSAAgua`; preserve region selectors 19/21 and saved invoice handling.
- [x] Reconstruct the MiTransfer gas form from `XCDkgbw8oZ` and connect `BOLSAgas`; preserve selector 67, account validation/persistence, and partial-USSD behavior.
- [x] Reconstruct the MiTransfer own-card recharge form from `JrjJL8mtlI` and connect `BOLSARecargaPropia`; preserve selector 77, CUP payload, saved series, and partial-USSD behavior.
- [x] Reconstruct the MiTransfer Extra USD package form from `f3Ttlx30sMT`, replace the misnamed unused stub, and connect `BOLSACompraPaqueteMLC`; preserve selector 33 and contact normalization.
- [x] Reconstruct and route MiTransfer 4G balance recharge from `wbFn8tBw8W`; preserve selector 20 and USD payload.
- [x] Reconstruct and route MiTransfer 4G package purchase from `q55ExEc6x2l`; preserve selector 18 and offer-request payload.
- [x] Reconstruct and route MiTransfer Cubacel package purchase from `WyYHxgzYyW`; document the JSON/database catalog and selector-6 request.
- [x] Reconstruct and route MiTransfer TFA recharge from `b7zSZMAX7cN`; preserve selector 108, CUP payload, and partial-USSD route.
- [x] Reconstruct and route MiTransfer organization payment from `xb7DiohJuX`; document selectors 7/122, form validation, and source/resource mismatch.
- [x] Reconstruct and route MiTransfer OFA reservation from `dWLcK5oQoS`; replace the mislabeled CADECA stub and preserve selector 8.
- [x] Document Cubacel plan purchase flow (`compraplanescubacel.json`), catalog version field, and selector payload construction.
- [ ] Decompile and migrate remaining MiTransfer wallet flows.
- [x] Replace the `WalletRechargeFragment` stub and connect `BOLSARecargaCUPWalletTicket` to clean UI with selector-17 full/partial dispatch parity.
- [x] Document wallet authentication (`frmAuthBolsa`): four-digit PIN validation and selector-40 payload construction are recorded in the USSD catalog.
- [x] Trace MiTransfer saved-account balance query and partial-USSD packet route; record the construction in the USSD catalog.
- [x] Trace MiTransfer latest-operations selector, currency/account variants, and partial-USSD agency markers; record the construction in the USSD catalog.
- [x] Compare MiTransfer session-close menu with `H0kVHR7zuu`; restore selector `70` on confirmation and source-backed local configuration reset behavior.
- [x] Migrate the MiTransfer latest-operations fragment into clean Java and route the General Banking menu to it.
- [x] Compare the migrated MiTransfer latest-operations form with `dI2tctjNbR`; confirm selector `48`, payload order, saved-account agency `08`, and wallet agency `04`.
- [x] Document MiBoleto QR feature (hidden in menu)
- [x] Decompile MiBoletoService

## Agent Operations

- [x] Identify AgentService and agent-specific UI
- [x] Decompile AgentService — ORMLite entity (code, phone), no logic
- [x] Document source-confirmed agent registration, SMS activation-code retrieval, local validation, `AgentService` persistence, and `getCodeAgent()` behavior.
- [x] Trace Agent services menu: authentication, stock, recharge, latest-recharge branches, PIN change, and disconnect; record selector/payload and source-visible validation behavior.
- [x] Inventory General-mode carrier-service operations, fragment destinations, and saved-operation reconciliation; confirm direct `*222` and `*111` routes.
- [x] Trace direct General-mode carrier queries for bonus, plan management, data/voice/SMS/Amigos plans, and advance balance; add literal codes and source branches to the USSD catalog.
- [ ] Trace the remaining General-mode carrier-service form/dialog payloads and runtime destinations.
- [x] Trace and document Agent Resumen/Detalle routes, local `RecordSMS` data, chart/detail filters, and a likely summary-loader iterator defect.

## E-Commerce / Bulevar

- [x] List REST API endpoints (/api/payment/*, /api/business/*, etc.)
- [x] Identify deep links (transfermovil.app, transfermovil://)
- [x] Identify base URL for API (dynamic from SharedPreferences, not hardcoded)
- [x] Decompile API client — y6NQQxH0NI singleton, getUnsafeOkHttpClient
- [x] Document authentication flow (/loginapk, /loginfactorapk, Bearer+XSRF)
- [ ] Map business/merchant registration flow
- [ ] Trace payment processing flow (/api/payment/store)
- [ ] Document refund flow (/api/refunds/store)
- [ ] Map child user / sub-account permissions
- [ ] Document payment source management (activar/desactivar)

## Networking & TLS

- [x] Identify OkHttp 4.2.2 as HTTP client
- [x] Note certificate pinning evidence
- [ ] Decompile OkHttp interceptor chain
- [ ] Extract pinned certificates and target hosts
- [ ] Document TLS configuration (min version, cipher suites)
- [x] Identify custom trust manager — e-commerce uses getUnsafeOkHttpClient (trusts ALL certs)
- [ ] Document cleartext traffic usage (which hosts allow HTTP?)
- [ ] Trace self-update mechanism (REQUEST_INSTALL_PACKAGES)

## Security & Crypto

- [x] Note debuggable=true, allowBackup=true, usesCleartextTraffic=true
- [x] Identify CryptoProvider inner class
- [x] Decompile CryptoProvider — identify algorithms (AES? RSA?)
- [x] Determine what data is encrypted and when
- [x] Check for hardcoded keys or predictable IVs
- [ ] Audit certificate pinning implementation strength
- [x] Audit SharedPreferences for sensitive data storage
- [x] Check for root/emulator detection — none found
- [x] Audit exported components for unprotected access
- [x] Review FileProvider path configuration security

## Local Storage

- [x] Identify ORMLite as ORM, SharedPreferences keys
- [x] Found CodigoAcceso table in migration
- [x] Decompile database helper — list all tables and schemas
- [x] Document what data is persisted locally
- [x] Trace the CodigoAcceso (access code) table usage
- [x] Map SharedPreferences usage across the app
- [x] Document Nauta account storage (nautaListDao, nautaCuentas)

## Nauta Integration

- [x] Identify Nauta features (recarga, accounts, export, Nauta Hogar)
- [x] Decompile Nauta top-up flow (recargaNauta)
- [ ] Document Nauta account types and management
- [x] Trace Nauta Hogar (home internet) flow
- [x] Document Nauta Plus feature

## Cubacel Mobile

- [x] Identify plan consultation features (data, voice, SMS, amigos)
- [ ] Decompile mobile top-up flow (OP_Recg_movil)
- [x] Document plan purchase flows (compraplanescubacel.json)
- [ ] Trace phone debt consultation (OP_Deuda_Telefono)
- [ ] Document bonus/bono mechanism

## Dynamic Checks (When Emulator Available)

- [ ] Install APK on emulator and capture launch behavior
- [ ] Capture logcat during registration/login flow
- [ ] Inspect UI hierarchy and compare with static menu analysis
- [ ] Test USSD code sending (with mock/test only)
- [ ] Capture network traffic for API calls
- [ ] Test deep link handling

## iOS Port

- [ ] Complete the [iOS port feasibility and plan](docs/ios-port-todo.md), including public API limits and a feature parity decision.

## Miscellaneous

- [x] Document barcode/QR scanning usage (ML Kit integration)
- [x] Map contact lookup for transfers (READ_CONTACTS)
- [x] Document the "Teléfonos Útiles" (useful phone numbers) section
- [x] Document Voto Móvil (canales_votomovil.json) feature
- [x] Document Mi Turno appointment system
- [x] Map the ciudades patrimoniales (heritage cities) feature
- [x] Document transit fine articles (art_inc_transito.json)
- [x] Trace RECEIVE_BOOT_COMPLETED receiver behavior: permission declared, no boot receiver registered, raw receiver class is a no-op.
