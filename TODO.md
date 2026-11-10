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
- [x] Compare method signatures for BFI external payment, QR account base, and enterprise transfer against their annotated JADX sources; confirm no method is missing or extra.
- [x] Compare `BfiExternalPaymentFragment` with `Eqj43O0pUx`; confirm PIN/account/currency validation, QR variants, selectors `30`/`31`, packet marker `05`, and truncation branches.
- [x] Compare `BfiQrAccountFragment` with `LgiFGRpiEl`; link the identical QR/contact behavior and document the clean shared account-callback base.
- [x] Migrate the BANDEC account-limit, latest-operations, and payment-status form bodies into their clean screens; record selectors `62`, `48`, and `89`.
- [x] Reconstruct BANDEC's shared account selector from `DQIrxODoMU`, restore its card-logo method from archived smali, and rewire the three clean query forms.
- [x] Compare `WalletWaterPaymentFragment` with `U1sIOmca96i`; confirm selector routing, payload order, and source validation quirks are represented in [wallet water notes](docs/wallet-water-payment.md).
- [x] Compare Wallet bank-transfer and Metro coordinate-transfer card-prefix helpers with archived smali; restore the bank-transfer agency inference and confirm Metro only updates the logo.
- [x] Compare `BfiAssociateAccountFragment` with source `F2leFVNWrdy`; account formatting/length, foreign-bank confirmation, random coordinate challenge, and selector `60` payload match.
- [x] Reconcile the agent data-management pager with source `OQcONjDATJ`; preserve its 11 ordered tabs, titles, child screens, and adapter behavior.
- [x] Reconcile the General data-management pager with source `wTZi6Zeikv`; preserve its eight ordered tabs, titles, contact permission request, and fixed-tab setup.
- [x] Audit `crypto/CryptoProvider.java` against `V5FFEZ0Qrr0`; document its implemented scheme coverage, renamed API, raw call sites, and static-audit limit in [security notes](docs/security.md).
- [x] Audit `data/DatabaseHelper.java` against `unYp8VQThY`; document its matching public API breadth and the remaining static-only query/migration limits in [storage notes](docs/storage.md).
- [x] Audit `ecommerce/ApiClient.java` against `y6NQQxH0NI`; document the implemented request paths and missing image APIs in [e-commerce notes](docs/ecommerce.md).
- [x] Audit `ecommerce/SessionManager.java` against `UhA7J2923N`; document implemented persistence and remaining auth/error API parity in [e-commerce notes](docs/ecommerce.md).
- [x] Audit `sms/FuelSmsImportTask.java`, `SmsImportTask.java`, and `SmsParser.java` against their raw sources; document their unimplemented parser/import behavior in [telephony notes](docs/telephony.md).
- [x] Compare `sms/SmsSender.java` with `HzjedYqYeh`; document matching send/fallback/inbox behavior and the source cursor early-return limitation in [telephony notes](docs/telephony.md).
- [x] Restore `AboutFragment` layout inflation from `ESS7dlKa1m`.
- [x] Restore the Bulevar management/statistics menu and both destinations from `KiXWwF51Aq`.
- [x] Reconcile `ui/qr/QrCodeGenerator.java` with source `ZUoEY89WdA`; retain all QR generation, image-processing, and decoding entry points under clean method names.
- [x] Compare `update/UpdateApiClient.java` with `dST9RIJkDp`; document matching GET behavior and raw-only error logging in [networking notes](docs/networking.md).
- [x] Remove the unused `UssdDispatcher` Activity shell mapped to static helper `FBsQzP3Zfj`; document active raw call sites and remaining clean migration in [telephony notes](docs/telephony.md).
- [x] Compare `util/Sha256Util.java` with `UkO3Y6TcHD`; confirm UTF-8 SHA-256, lowercase hex padding, and null-on-error behavior match.
- [x] Rebuild the clean MiBoleto ticket base from `L4aAENEGbqv`, move status/key-update/latest-operations screens off the raw base, and remove the empty base placeholder.
- [x] Reconcile `b6FtEHgm1B` against `QrDynamicPaymentFragment`: same base, layout, QR parsing/menu flow and selectors `31`/`30`; retain the richer clean screen with wallet currencies and stricter amount checks, and remove the null-returning duplicate shell.
- [x] Migrate public-service/PCC draft `udysei7zCr` into clean `PublicServicePaymentFragment`; retain its CUP-only bolsa selector, contact-confirmation flow, validation, and selector `7` full/partial (`04`) USSD payload.
- [x] Recover `WalletBankTransferFragment.mostrarTarjeta()` from archived smali; match PAN/standard prefixes, drawables, and first matching transfer-agency selection.
- [x] Reconstruct the BFI USSD account base from Agg55uYctq by reusing clean account selection/card behavior and restoring observer callbacks and the four-parameter packet limit.
- [x] Migrate the BFI payment form and the QR/contact base it needs onto clean Java; preserve both selector-31/selector-30 payment branches.
- [x] Migrate the BFI enterprise-transfer form from `f1IveoSASW` onto `BfiUssdAccountFragment` and connect the three transfer modes to it.
- [x] Compare migrated BFI transfer/payment form bodies with JADX; confirm payload branches and selectors `104`, `31`, and `30` while noting clean shared-base callback delegation.
- [x] Compare BFI balance, limit, and latest-operation forms with JADX; confirm selectors `46`, `62`, and `48`, their payload construction, and partial-USSD marker `05`.
- [x] Compare general-fine and traffic-fine Wallet forms with JADX; confirm selectors `96`/`97`, field order, and the absence of partial-packet dispatch in both screens.
- [x] Migrate the BFI transfer/payment operations menu and its three-mode dialogs; keep source forms as destinations pending their own clean migrations.
- [ ] Review the remaining 216 main-package source files without exact reconstruction links; distinguish generated code from application logic.
- [ ] Inventory the 216 unmapped main-package sources by package and identify which contain application behavior versus generated/library code.
- [ ] Add exact reconstruction links for each unmapped application-behavior class that remains in scope; record excluded generated/library classes and evidence.
- [x] Add verified exact source annotations for the Wallet/FWA recharge, bank transfer, electricity, gas, and water forms; regenerate the exact-link inventory.
- [x] Add the verified `L4aAENEGbqv` source annotation to `MiBoletoTicketBaseFragment` and refresh the exact-link inventory.
- [x] Link fourteen source-confirmed MiBoleto, ticket reservation, OFA, TFA, Cubacel-package, fixed-phone, and Voto Móvil screens; regenerate the exact-link inventory.
- [x] Link `BfiEnterpriseTransferFragment`, `BankTransferBfiFragment`, `MiBoletoPurchaseFragment`, and `WalletExtraPackageFragment` to their source-confirmed classes; refresh the inventory.
- [x] Link the BANDEC limit, latest-operations, and recent-payments wrapper screens to their exact source classes; refresh the inventory.
- [x] Link the BANDEC invoice-debt and postal-order query wrappers to their exact source classes; refresh the inventory.
- [x] Migrate the BANDEC enrollment form body from `wLHKkaC4Ha` into `BandecRegistrationFragment`, restore card icons from smali, and link the source exactly.
- [x] Migrate the BANDEC card-status query from `HgJHxigegS` into `BandecCardInfoQueryFragment`, restore its card-icon method from smali, and link the source exactly.
- [x] Compare `BankingAccountValidatorFragment` with archived `EV9Tu0zIL4`; correct the PAN currency slice to source characters 3–4 and record the bank/currency offsets.
- [x] Reconstruct `BankAccountEditFragment` from `oaEWezaNAI`, recover its card-prefix icon method from archived smali, and route account-list, BANDEC, BFI, and Wallet entry points to the clean screen.
- [x] Compare `BfiChangePinFragment` with `KvpkEH7lRr`; restore the source short-old-PIN message, raw equality comparison, and error-field clearing behavior.
- [x] Compare `BfiRegistrationFragment` with `umjSGajOy3`; confirm selector-49 payload, partial marker, field errors, and new-PIN-versus-current-PIN rule.
- [x] Compare clean Wallet gas and electricity forms with `XCDkgbw8oZ` and `dwdZ5sHcFR`; confirm invoice persistence, validation, payloads, selectors `67`/`41`, and partial marker `04`.
- [x] Compare `FwaDataPackagePurchaseFragment` with `q55ExEc6x2l`; confirm contact permission gating, validation, selector-18 payload, and offer-confirmation text match.
- [x] Compare `FwaBalanceRechargeFragment` with `wbFn8tBw8W`; confirm account/amount/bundle validation and selector-20 payload order match.
- [x] Restore the Wallet CUP recharge `btHelp` dialog and source help text omitted from the clean `P8DtkaSW4dR` screen.
- [x] Compare Wallet CUP recharge form with `P8DtkaSW4dR`; confirm amount validation, selector-17 payload, and standard/partial dispatch after restoring help UI.
- [x] Refresh the exact unmapped main-package count and package-segment distribution from the reproducible inventory.
- [x] Resolve the duplicate `Agg55uYctq` candidate: keep `BaseBankingFragment` as the source-backed reconstruction and remove the false source annotation from derived helper `BfiUssdAccountFragment`.
- [x] Share the single `SvY0xjeNSz` PIN-auth implementation between BFI and Metro menus; route Metro to `BfiPinAuthFragment` and remove its duplicate screen copy.
- [x] Share the single `umjSGajOy3` registration implementation between BFI and Metro menus; route Metro to `BfiRegistrationFragment` and remove its duplicate screen copy.
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
- [ ] Migrate the active `FBsQzP3Zfj` action overloads and operation routing into a clean USSD dispatch/navigation component.

- [ ] Complete the dedicated [USSD code catalog](docs/ussd-code-catalog.md): every executed code, purpose, construction algorithm, and source evidence.
- [x] Record MiTransfer selector-17 CUP cash-deposit ticket request, amount validation, and partial packet marker in the USSD catalog.
- [x] Record MiTransfer selector-18 FWA data-package offer request, account validation, and fixed USD payload in the USSD catalog.
- [x] Record MiTransfer selector-20 FWA balance-recharge payload, validation, and dispatcher path in the USSD catalog.
- [x] Record MiTransfer and bank water-payment selector-19/21 variants, selector-51 regional path, and partial-packet markers in the USSD catalog.
- [x] Add the selector-121 union-dues query and its bank-ID/identity payload construction to the USSD catalog.
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
- [x] Reconstruct the omitted `g0xM9kQCsqu` SMS parser methods for transaction, wallet, fuel, ticket, purchase-confirmation, and app-data messages.
- [x] Restore today's-message filtering, ticket-offer import callbacks, and clean caller routing from `DHfGEge8yT`.
- [x] Restore `SmsImportTask` parsing, transaction/service deduplication, database insertion, and result behavior from `HPuMiTypoW`.
- [x] Restore fuel coupon confirmation, status, and listing parsing plus the `FuelSmsImportTask` inbox loop from `g0xM9kQCsqu` and `XYfkGsUkKH`.
- [x] Restore encrypted Wallet currency-list updates and agent telecom-wallet confirmation parsing from `g0xM9kQCsqu`.
- [x] Restore phone, version, and service activation-code extraction from `Datos App` and activation SMS.
- [x] Restore persistence of Cubacel plan-catalog entries parsed from SMS using the clean plan entity.
- [x] Restore `FuelSmsImportTask` constructor and `Ti8eM28U2E` progress/completion callback contract from `XYfkGsUkKH`.

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

### Empty banking fragment drafts

- [x] Remove the unreferenced `MetroTransferFragment` shell after confirming it had no callers; its `F2leFVNWrdy` mapping was incorrect (that source is BFI account association).
- [x] Migrate the source-backed BFI associate-account form `F2leFVNWrdy` into `BfiAssociateAccountFragment`; preserve selector `60`, random coordinate prompt, 16-digit account validation, confirmation, and card logos.
- [x] Replace the BFI enterprise Settings tab's raw `bnsLemXoui` menu with clean `BfiSecurityMenuFragment`; preserve its two displayed actions (registration and change PIN). The `BFIAsociarCuenta` callback exists in source but is not added by `initData()`, so keep its mapped form out of the visible menu.
- [x] Remove the unused `BandecAccountConversionFragment` shell: source `Xh70Rdjfpc` implements selector `87`, but `X7obECfkKf.initData()` never adds `BANConvertirCuenta`; the handler case has no visible menu item or clean callers.
- [x] Remove the unused `BandecBranchLookupFragment` shell: its `KsDQL9cTTl` mapping is actually the USD-with-MLC account-opening form (selector `76`), invoked from BANDEC Configuración; branch lookup is not its behavior.
- [x] Route BANDEC `BANCambioLimite` from the settings menu to source-backed `BandecChangeLimitFragment`; preserve selector `61`, ATM/POS/total validation, and partial-USSD behavior.
- [x] Remove the unused `BandecDisconnectFragment` shell: its `g9VybPHHUE` mapping is actually delete-registration (selector `68`); BANDEC disconnect is a confirmation dialog in source `rvxiiV3tYu`, now exposed by `BandecSessionMenuFragment`.
- [x] Route `BANCierrePlazoFijo` to source-backed `BandecFixedTermCloseFragment`; preserve selector `82`.
- [x] Route `BANPlazoFijo` to source-backed `BandecFixedTermOpenFragment`; preserve selector `81`, term choices, currency, and source-account data.
- [x] Route `BANCambioMensualidad` to source-backed `BandecMonthlyPaymentChangeFragment`; preserve the source selector `25` form.
- [x] Correct the `BandecReprintFragment` mapping: `m0X6Kxdhmv` changes loan monthly payment (selector `25`), not card reprint; route that operation as `BandecMonthlyPaymentChangeFragment` and connect actual `BANReimpresion` to `BandecCardReprintFragment` (selector `74`).
- [x] Correct the mislabeled `BandecAuthenticateFragment` draft: source `rvxiiV3tYu` is the three-action BANDEC Sesión menu. Route the tab through `BandecSessionMenuFragment` and preserve authentication, disconnect, and card selection destinations.
- [x] Correct the mislabeled `BandecBalanceQueryFragment` draft: source `R7PmVxXLJZC` is the 14-item BANDEC Consultas menu. Route all visible rows through `BandecQueriesMenuFragment` and preserve their source-backed destinations.
- [x] Migrate the BANDEC operation router from `bLlRBTTLue`; preserve all 26 source menu entries and original destinations, while routing `BANTransferencia` to the clean transfer form.
- [x] Correct the mislabeled `BandecRegistrationFragment` draft: source `X7obECfkKf` is the nine-action BANDEC Configuración menu. Route the tab through `BandecSettingsMenuFragment` and preserve registration and the other settings destinations.
- [x] Remove the mislabeled `BandecCardRenewalFragment` shell: its `gaJlF6dT3z` source is BANDEC latest-operations query (selector `48`), routed by `R7PmVxXLJZC` under `BANUltimasoperaciones`; the clean shell had no callers.
- [x] Remove the mislabeled `BandecCommerceIdFragment` shell: its `ikSs6fqL5Q` source is BANDEC account-limit consultation (selector `62`), mapped from `R7PmVxXLJZC` as `BANConsultaLimite`; the shell has no callers.
- [x] Remove the mislabeled `BandecExternalPaymentFragment` shell: its `ZF74c8UCRU` source is BANDEC recent-payments query (selector `63`, `BANUltimosPagos`), not external payment; no clean caller uses the shell.
- [x] Route BANDEC `BANPinDigital` from the settings menu to source-backed `BandecPinDigitalFragment`; preserve selector `79`, account checks, and coordinate challenge behavior.
- [x] Replace the mislabeled `BandecRechargeFragment` draft with `BandecPaymentStatusFragment`; route `BANEstadoPagoExterno` from Consultas to source `XKpe29TPn0`, preserving payment-reference/account validation and selector `89`.
- [x] Remove the unused `BandecBillingPaymentFragment` shell: its `D6YZ7ruA6K` source is a legacy mobile top-up form with no callers; the active BANDEC `BANRecargaMovil` route opens `SjZHfPJPwX` with selectors `54`/`88`.
- [x] Trace `Q3Nvf439ab` and route BANDEC electricity to `BandecElectricityFragment`; preserve the source-backed saved-invoice form, selector `41`, account lengths, and partial-USSD dispatch. A clean-room form rewrite remains future work.
- [x] Correct the mislabeled `BandecFinePaymentFragment` draft to `BandecOfaPaymentFragment`; route `BANPatrimoniOfa` to source `SZARzeWeX5` and preserve its obligation form and selector `94`.
- [x] Route `BANGas` in the clean BANDEC operation router to source-backed `BandecGasPaymentFragment`; preserve saved gas-account selection, source form behavior, and the original gas dispatch.
- [x] Remove the duplicate `BandecInvoiceListFragment` shell: it incorrectly reused `Q3Nvf439ab`, whose source form is the electricity payment screen and whose only menu metadata routes to electricity.
- [x] Migrate `g7yG4Frdxy` into `BandecInvoiceSelectionFragment` and connect the contracted-services pay action; preserve saved invoice choices, service type, validation, selector `52`, and full/partial dispatch.
- [x] Route `BANAmortizar` to source-backed `BandecLoanAmortizationFragment`; preserve account/name/monthly-payment/amount validation and selector `55` full/partial dispatch.
- [x] Remove the duplicate `BandecNautaRechargeFragment` shell: its `ZDkigMAIBm` mapping is the menu-routed BANDEC transfer form, now represented by `BandecTransferFragment`; no BANDEC Nauta route targets this shell.
- [x] Remove the unused `BandecPublicServicePaymentFragment` shell: its `t7in6psmmaQ` source is only constructed by private RC05/NIT helpers in `bLlRBTTLue` and `FBsQzP3Zfj`, neither called; active `BANONAT` uses the RC04/NIT/stamp chooser with `ROgpLrCtHa`/`TGMSi5UDp7`.
- [x] Correct the BANDEC transfer mapping and migrate the menu-routed `ZDkigMAIBm` form into `BandecTransferFragment`; retain selector `45`, regular/PIN/partial packet paths, source and destination account choices, and recovered card logos. `Lxfm3mPhrA` is an unreferenced duplicate.
- [x] Connect `BANTransferencia` through the clean BANDEC router while preserving the remaining source menu destinations.
- [x] Trace `T4RQ5wDJDt` and route BANDEC water payment to `BandecUtilityPaymentFragment`; preserve region/payment selectors, amount validation, and dispatch selectors `19`, `51`, and `21`. A clean-room form rewrite remains future work.
- [x] Correct the wire-transfer draft to `BandecPostalOrderFragment`; route `BANGiroPostal` to source `ASLdujtVtr` and preserve identity fields, giro reason, and selector `64` full/partial dispatch.
- [x] Route BANDEC `BANCambioCuenta` from the clean session menu to source-backed `AccountSwitchFragment`; preserve selector `60` and card/coordinate validation.
- [x] Route BANDEC `BANAutenticar` from the clean session menu to source-backed `AuthenticateFragment`; preserve password validation and source dispatch `02`/`40`.
- [x] Migrate the BANDEC contracted-services menu from `Kgii4NH4Ce` and connect its tab; preserve the four add/query/pay/delete actions and original destinations.
- [x] Remove the unused common `BankAuthMenuFragment` shell: `KmgeIVr5RG` has no source or clean callers and its item callback is empty; active bank flows are routed by their bank-specific menus.
- [x] Remove the misidentified `BankOperationBaseFragment` shell: its `p3NpwYhcUs3` mapping is an enum (`Agregar`, `Pago`, `Eliminar`, `Consulta`), not a Fragment; the enum is retained and used by the BANDEC contracted-services routes.
- [x] Remove the unused `BranchSelectionFragment` shell: its stale `vVF87n7MnK` mapping is the BANDEC card-reprint form, now represented by `BandecCardReprintFragment` and connected from Configuración; the common shell had no callers.
- [x] Route BANDEC `BANInfoTarjeta` from Consultas to source-backed `BandecCardInfoQueryFragment`; preserve 16-digit account validation and selector `78`, and remove the stale common shell.
- [x] Remove the duplicate empty `ui/fragment/banking/bandec/BandecChangeLimitFragment` shell; the active operation route uses `operations/BandecChangeLimitFragment` backed by `uWkWt7AEZ5` (selector `61`).
- [x] Expose clean BANDEC Consultas routes for latest operations (`48`), account limits (`62`), and recent payments (`63`) using correctly named source adapters.
- [x] Route BANDEC `BANEstadoCuentas` to source-backed `BandecAccountStatementFragment`; preserve email/date/account validation and selector `26`.
- [x] Route BANDEC `BANConsultarTodasCuentas` through an explicit Sí/No confirmation and preserve source agent-aware selector `58` dispatch.
- [x] Route BANDEC `BANConsultaMulta` through a clean fine-type chooser and source-linked adapter; preserve the Metropolitano agency argument for both fine types.
- [x] Route BANDEC `BANConsultaTicket` through its original two-choice dialog; preserve the agent-aware `103` call and BANDEC reservation lookup (`107`).
- [x] Confirm `BANConsultaSindicato` has no visible BANDEC Consultas row: source `initData()` creates 14 entries without it; keep its inherited switch destination without inventing a menu action.
- [x] Route BANDEC `BANConsultarSaldo` through the source confirmation and preserve agent-aware selector `46` dispatch.
- [x] Route BANDEC `BANTipoCambio` through the source confirmation and preserve agent-aware selector `85` dispatch.
- [x] Route BANDEC fuel consultation choices to their four source-linked coupon forms in original order.
- [x] Remove the unused common `ChangeLimitFragment` shell: `SIxHnoWicq` has no callers; the reachable BANDEC limits action uses `uWkWt7AEZ5`, already routed as `BandecChangeLimitFragment` (selector `61`).
- [x] Correct the `ChangePasswordFragment` draft to `MultibancaPinChangeFragment`; route `BANCambioPinMultibanca` through the clean settings menu and preserve source validation and selector `75`.
- [x] Route BANDEC `BANCambiarclave` through clean `ChangePinFragment`; preserve access-key validation and selector `69`.
- [x] Remove the duplicate `CoordinateAuthFragment` shell: its stale `RYCvQK4nkF` mapping is BANDEC digital-PIN change, already routed through `BandecPinDigitalFragment` (selector `79`).
- [x] Remove the mislabeled `DisconnectFragment` shell: `sxbhjZQZxo` deletes BANDEC registration with selector `68`; actual disconnect is a confirmation action in the BANDEC session menu.
- [x] Remove the unused common `ElectricityPaymentFragment` shell: source `D38ae2xieeM` has no callers; reachable electricity routes use bank-specific reconstructed screens.
- [x] Remove the unused common `FinePaymentFragment` shell: source `CiYPvcQWEO` has no callers; no clean menu route targets it.
- [x] Remove the unused common `GasPaymentFragment` shell: source `sT2WhSOo3S` has no callers; reachable gas routes use bank-specific reconstructed screens.
- [x] Route BANDEC `BANConsultarServicio` to source-backed `BandecInvoiceQueryFragment`; preserve invoice/ONAT service selection and dispatch selectors `47`, `56`, and `22`, and remove the stale common shell.
- [x] Migrate `q9DNC6bnexm` into `InvoiceTypeSelectionFragment` and route BANDEC contracted-service add/query/delete actions to it; preserve saved-invoice handling, operation arguments, confirmations, and selector `52` behavior.
- [x] Remove the unused common `LoanAmortizationFragment` shell: source `kAazEwDasT` has no callers; the reachable BANDEC loan route uses its bank-specific screen.
- [x] Remove the unused common `PublicServicePaymentFragment` shell: source `CA73VZ4FAR` has no callers; live public-service routes use their specific clean screens.
- [x] Route BANDEC `BANRegistrarse` grid entries in all three `OperationMenuBuilder` profiles to source-backed `BandecRegistrationFragment`; preserve the original enrollment validation and selectors `49`/packet `110`.
- [x] Remove the unused common `SecurityMenuFragment` shell: `eRe5PTC1On` has no source or clean callers; the live BPA/BFI/BANDEC security routes use their bank-specific menus.
- [x] Remove the unused common `UtilityBillPaymentFragment` shell: source `hvC0UGR2L0` has no callers; live BANDEC water uses `BandecUtilityPaymentFragment`.
- [x] Remove the unused common `WireTransferFragment` shell: source `fvzO0qRHbu` has no callers; BANDEC postal order uses `BandecPostalOrderFragment`.
- [x] Route BANDEC `BANConsultarGiroPostal` from Consultas to `BandecPostalOrderQueryFragment`; preserve CI-based pending-order lookup and selector `65`, and remove the stale common shell.

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
- [x] Reconstruct and route MiTransfer OFA contribution from `C6ZYln3x19W`; preserve selector 94, obligation loading, and partial-USSD dispatch.
- [x] Reconstruct and connect MiTransfer ticket reservation creation from `XnVSHGPTkK`; preserve selector 102.
- [x] Reconstruct and connect MiTransfer ticket reservation cancellation from `QVPgkl8ZGC`; preserve selector 106.
- [x] Reconstruct and connect MiTransfer ticket reservation date change from `Wwc5crW71D`; preserve selector 105 and correct the mislabeled query stub.
- [x] Reconstruct and route MiTransfer fixed-phone bill payment from `p5B8KozjvpQ`; replace the generic invoice stub and preserve selector 42.
- [x] Reconstruct and route MiTransfer Pago en Línea from `s9CT6pjRyD`; preserve QR mode arguments, shared-state reset, and selector-30/31 branches.
- [x] Restore MiTransfer enterprise transfer from `Z3kYdPwq6K2` with selector 220, and route external-payment choices with `PayType`/`CLASICAEMP`; preserve `TransferType` and shared-state reset.
- [x] Reconstruct and route MiTransfer MiBoleto purchase from `TBaFnBLjEA`; preserve selector 118, currency mapping, and shared booking reset.
- [x] Restore the MiBoleto ticket-status screen from `w7mHpmOa4EP`, route the General MiBoleto menu to the clean screen, and preserve saved-series selection and selector 114 dispatch.
- [x] Restore MiBoleto key update from `hjX8MS8xO9`, route the General MiBoleto menu to the clean screen, and preserve saved-series validation and selector 115 dispatch.
- [x] Restore MiBoleto latest operations from `i9I9XZGnR3`, route the General menu to the clean screen, and preserve optional email encoding and selector 113 full/partial dispatch.
- [x] Restore MiBoleto integrated ticket query from `OXpoe3K2m1`, route the General menu to the clean screen, and preserve date/email validation and selector 112 full/partial dispatch.
- [x] Restore the MiTurno reservation lookup from `x12rSjPY6pZ`, route the General ticket-query choice to the clean screen, and preserve CI input, QR prefill/scan, and selector 107.
- [x] Remove five unreferenced banking draft shells whose source classes now have canonical clean implementations: gas, electricity, wallet latest operations, bank-to-wallet transfer, and water payment.
- [x] Restore the OFA visit-query form from `dYBdUyjb1D`, replace its mislabeled settings stub, and connect the General-mode dialog while preserving selectors, argument handling, validation, and selector 9.
- [x] Reconstruct and route MiTransfer Voto Móvil from `cdINOtQ3iN`; preserve selector 215, encoded 454 dispatch, and channel validation.
- [x] Document Cubacel plan purchase flow (`compraplanescubacel.json`), catalog version field, and selector payload construction.
- [x] Migrate MiTransfer enrollment (`eUkRSfpCKs`) to clean Java and route selector 49, including partial-USSD dispatch.
- [x] Migrate classic-account association (`HTmIvOo9nb`) to clean Java and preserve selector 111, POS-field validation, and saved-account callback.
- [x] Link `NautaUserFragment` to the exact `KtF0PRB8vS` source, confirm normalized source-body identity, and route both dynamic General-menu entries to the clean class.
- [x] Restore Wallet tab routes for registration, PIN change, wallet registration deletion, and classic-account registration deletion from `eUkRSfpCKs`, `Cmok7CcIR9`, `Nju5UJgFce`, and `m44wUnA8d5`.
- [x] Route classic and classic-enterprise association to `HTmIvOo9nb` and `l2FaHPPBDa` respectively, preserving the MiTransfer/`CLASICAEMP` saved-account types.
- [x] Compare `BfiTransferFragment` with `Z3kYdPwq6K2`; confirm enterprise Wallet selector `220`, agency `08`, field validation, and three dispatch branches.
- [x] Compare `WalletWithdrawFragment` with `f9Reflqt3EZ`; link its identical clean body and verify the selector-95 cash-ticket form remains routed from the Wallet menu.
- [ ] Review remaining MiTransfer and Boleto-tab management flows for clean model and dispatcher adapters.
- [x] Migrate General service-debt query `k5fNqiPSlwb`; preserve five service types, invoice validation, selector-47 full/partial branches, and guard optional invoice/type prefills when arguments are incomplete.
- [x] Migrate General account-statement query `qAMfdm9Kls`; preserve six-month date pickers, CUP/USD, email validation/encoding, and selector-26 full/partial branches.
- [x] Migrate General union-payment query `SlZq2dCM9i` by routing to its clean equivalent; preserve QR CI prefill, agency mapping, and selector 121.
- [x] Migrate General telephone-invoice query `HFzgpLELho`; preserve phone-number validation, operation arguments, saved-number insertion/menu refresh, and selector-47 dispatch.
- [x] Link and compare the three clean General service-debt, phone-invoice, and account-statement screens to their source classes; record the guarded-prefill behavior difference.
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
- [x] Trace General-mode carrier-service form payloads and destinations for bonus recharge, balance transfer, and recharge-key change; direct query codes are catalogued separately ([USSD catalog](docs/ussd-code-catalog.md#confirmed-banking-entries-initial-subset)).
- [x] Trace and document Agent Resumen/Detalle routes, local `RecordSMS` data, chart/detail filters, and a likely summary-loader iterator defect.

## E-Commerce / Bulevar

- [x] List REST API endpoints (/api/payment/*, /api/business/*, etc.)
- [x] Identify deep links (transfermovil.app, transfermovil://)
- [x] Identify base URL for API (dynamic from SharedPreferences, not hardcoded)
- [x] Decompile API client — y6NQQxH0NI singleton, getUnsafeOkHttpClient
- [x] Document authentication flow (/loginapk, /loginfactorapk, Bearer+XSRF)
- [x] Restore the `EcommerceActivity` host layout, initial menu, toolbar, splash menu, and back/quit flow from `QqWqw83vJf`.
- [x] Add clean profile API routes and `ProfilePresenter` for current profile, profile update, and password change; convert a selected photo before update.
- [x] Migrate child-user create/update request paths to a clean presenter that prepares a nonempty photo before dispatch.
- [ ] Connect child-user presenter results to clean UI callbacks.
- [x] Give `ChildUserPresenter` distinct typed list, detail, and mutation callback methods.
- [x] Map child-user list payload `dt.rows` into the clean `ChildUserListResponse` fields from source.
- [x] Map child-user detail payload `user` into its clean response model, retaining source JSON for province/municipality catalog resolution.
- [x] Resolve child-user province and municipality from the initialized local region tables and map them into e-commerce region models.
- [x] Require HTTP 200 plus response `code` containing `Ok` for child-user mutation success, matching the source parser.
- [x] Add source-backed child-user API routes for list, detail, delete, and status alongside create/update.
- [x] Add clean child-user create/update API adapters for source-confirmed endpoints and nested-photo preparation.
- [x] Audit callers for `processPUTImage`/`processPOSTImage`; no Java callers or endpoint paths were found, so the multipart overloads remain unported and their boundary behavior unverified.
- [x] Audit `normalizeImageForUri`, EXIF rotation, and bitmap-to-URI writer callers; none were found in the checked Java tree, so these paths remain unported.
- [x] Restore `ApiClient.convertImageToSend` PNG/base64 conversion from `y6NQQxH0NI`, including half-size Glide decoding and quality-50 PNG output.
- [x] Restore the unauthenticated-session action from `UhA7J2923N`: clear the token, open Login, and reset the activity task stack.
- [x] Reconcile HTTP messages, operation-specific error mappings, and log formats in clean `MessageHandler` with `UhA7J2923N`/`IGxV3uh9sw` ([error notes](docs/ecommerce-errors.md)).
- [x] Match clean numeric permission checks to `UhA7J2923N.checkUserPermission(enum)`, including enum IDs and null/empty/malformed grant behavior ([e-commerce notes](docs/ecommerce.md#session-data-sharedpreferences)).
- [x] Map the Bulevar business-profile create/update/delete workflow and its `GESTIONAR_NEGOCIO` permission gate ([e-commerce notes](docs/ecommerce.md#business-management-flow)); no separate merchant onboarding flow was found.
- [x] Trace the dynamic-payment form, request, QR response, share link, and payment-status follow-up ([e-commerce notes](docs/ecommerce.md#payments)).
- [x] Document refund form validation, request fields, endpoint, and response handling ([e-commerce notes](docs/ecommerce.md#refunds)).
- [x] Map child-user permission loading, selectable grant codes, status/update sequence, and UI permission gates ([e-commerce notes](docs/ecommerce.md#child-users)).
- [x] Document payment-source activation/deactivation confirmation, request payload, endpoint selection, and response handling ([e-commerce notes](docs/ecommerce.md#payment-sources)).

## Networking & TLS

- [x] Identify OkHttp 4.2.2 as HTTP client
- [x] Audit OkHttp library pinning strings against app configuration; no app-level certificate pinning was found.
- [x] Audit app-owned OkHttp client builders; no custom interceptor chain was found.
- [x] Search app code for pinned certificate declarations and host associations; none were found.
- [x] Document absence of app-level TLS version/cipher configuration; negotiated values remain runtime-dependent.
- [x] Identify custom trust manager — e-commerce uses getUnsafeOkHttpClient (trusts ALL certs)
- [x] Document the app-wide cleartext manifest policy and the source-confirmed HTTP update-download host; there is no per-host network security configuration ([networking notes](docs/networking.md#cleartext-scope)).
- [x] Trace the self-update download and `REQUEST_INSTALL_PACKAGES` installer handoff; the method has no located caller and runtime installation remains unverified ([networking notes](docs/networking.md#self-update-download-and-installer-handoff)).

## Security & Crypto

- [x] Note debuggable=true, allowBackup=true, usesCleartextTraffic=true
- [x] Identify CryptoProvider inner class
- [x] Decompile CryptoProvider — identify algorithms (AES? RSA?)
- [x] Determine what data is encrypted and when
- [x] Check for hardcoded keys or predictable IVs
- [x] Audit certificate pinning implementation strength; app clients have no pin configuration, and Bulevar/WebSocket clients trust all certificates and hostnames.
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
- [x] Document Nauta account types and management, including the `@nauta.com.cu`/`@nauta.co.cu` suffixes and saved-account CRUD behavior in [recharge notes](docs/wallet-nauta-recharge.md) and [storage notes](docs/storage.md).
- [x] Trace Nauta Hogar (home internet) flow
- [x] Document Nauta Plus feature

## Cubacel Mobile

- [x] Identify plan consultation features (data, voice, SMS, amigos)
- [x] Trace agent-mode mobile top-up (`OP_Recg_movil`), including validation, saved-number behavior, and selector `12` ([recharge notes](docs/wallet-mobile-recharge.md#agent-mode-mobile-recharge-ussd)).
- [x] Document plan purchase flows (compraplanescubacel.json)
- [x] Trace agent-mode fixed-phone debt query (`OP_Deuda_Telefono`), including saved-number behavior and selector `1` ([fixed-phone notes](docs/wallet-fixed-phone-payment.md#agent-mode-fixed-phone-debt-query-ussd)).
- [x] Document the client-visible bonus status query and coupon-key recharge flow, with carrier-side rules explicitly left unknown ([telephony notes](docs/telephony.md#cubacel-bonus-flows-static-source-evidence)).

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
