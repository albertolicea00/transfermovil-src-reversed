# Changelog

## 2026-11-10 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Restored Wallet bank-transfer agency inference from destination-card prefixes using archived smali evidence.
- Compared Wallet bank-transfer and Metro coordinate-transfer card-prefix behavior against archived smali and recorded their distinct agency-selection behavior.
- Added the MiTransfer selector-17 CUP cash-deposit ticket path, validation, and partial-USSD route to the catalog.
- Added the MiTransfer selector-18 FWA data-package offer request and its fixed USD payload to the catalog.
- Added the MiTransfer selector-20 FWA balance-recharge payload, validation, and standard dispatch route to the catalog.
- Added MiTransfer and bank water-payment selector-19/21 payload variants, regional selector-51 routing, and partial-USSD markers to the catalog.
- Compared the clean Wallet water-payment form with `U1sIOmca96i`; documented parity for selector routes, payload, and preserved validation quirks.
- Refreshed reconstruction inventory: 257 unmapped main-package files remain, with current package-segment counts recorded.
- Added exact source annotations to seven Wallet/FWA forms and regenerated the source-link inventory.
- Corrected shared PAN currency parsing to read source characters 3–4, separate from the bank code at characters 5–6.
- Confirmed the clean FWA package-purchase form preserves source contact permission gating, validation, selector-18 payload, and offer-confirmation text.
- Confirmed the clean FWA balance-recharge form preserves source account/amount/bundle validation and selector-20 payload order.
- Added source-backed selector-98 fine-query and selector-119 QR-ticket validation routes to the USSD catalog.
- Added a provisional iOS screen/feature scope and a gated, read-only USSD feasibility proof-of-concept.
- Restored the reachable e-commerce profile PNG/base64 conversion helper and closed source-call audits for unused multipart and EXIF image utilities.
- Replaced generic OkHttp string evidence with a source audit of client builders: no app pinning, interceptors, or custom TLS policy; trust-all clients remain identified.
- Restored the fuel SMS task's two-argument callback contract and exact progress/result callbacks; left parsing open because the clean parser method is absent.
- Recorded current Apple App Review requirements for financial apps and separated the unresolved submitting-entity and carrier/bank authorization decisions.
- Added an official-Apple static iOS feature matrix for USSD, SMS, telephony, commerce, storage, and QR; kept device and distribution checks open.
- Matched clean e-commerce permission checks to raw enum behavior, including the null-grant exception and malformed-entry handling.
- Confirmed clean e-commerce HTTP/error messages and log formats match the recorded `UhA7J2923N` bytecode evidence.
- Restored the e-commerce session-expiry Login redirect and task-stack reset from `UhA7J2923N`.
- Audited e-commerce image handling: reachable profile flows use PNG/base64 requests, while multipart and EXIF helpers have no Java callers found; split the migration queue by verified reachability.
- Traced dynamic Bulevar payment creation through `/api/payment/store`, QR/deep-link generation, and payment-status follow-up.
- Traced child-user permission loading and updates, including available/current grant merge, status submission, grant-code payload, and UI gates.
- Documented Bulevar business-profile CRUD, the permission gate, request fields, and confirmed endpoints; distinguished it from merchant onboarding.
- Documented e-commerce refund validation, serialized request fields, endpoint response handling, and the missing positive-amount bound.
- Traced payment-source activation and deactivation from confirmation dialog through request payload, endpoint, and response handling.
- Traced General-mode bonus recharge, mobile-balance transfer, and recharge-key change forms; recorded USSD payload order and the repeated-key validation defect.
- Traced the self-update HTTP download and APK installer handoff, noting missing integrity verification and the lack of a located caller.
- Documented app-wide cleartext policy and the source-confirmed HTTP self-update host; noted that host-specific runtime behavior is not established.
- Traced agent-mode Cubacel mobile recharge and fixed-phone debt-query forms, documenting number validation/storage and USSD selectors `12` and `1`.
- Documented Cubacel bonus status and coupon-key recharge client flows from their menu/forms, distinguishing them from plan management and recording unknown carrier-side behavior.
- Audited `BfiAssociateAccountFragment` against `F2leFVNWrdy`; confirmed matching card formatting, account validation, foreign-bank warning/confirmation, coordinate challenge, and selector `60` payload.
- Removed a duplicate empty BANDEC limit-change shell and updated the source-link backlog from the current exact inventory; three other duplicate-candidate links remain queued for review.
- Routed Metro authentication to shared `BfiPinAuthFragment` after confirming both screens matched source `SvY0xjeNSz`; removed the duplicate Metro copy and source-link collision.
- Routed Metro registration to shared `BfiRegistrationFragment` after confirming both screens matched source `umjSGajOy3`; removed the duplicate Metro copy and source-link collision.
- Kept `BaseBankingFragment` as the canonical `Agg55uYctq` reconstruction and removed that false mapping from the derived `BfiUssdAccountFragment` helper.
- Routed BANDEC `BANEstadoCuentas` to `BandecAccountStatementFragment`, preserving the source email/date/account checks and selector `26`.
- Routed BANDEC `BANConsultarTodasCuentas` through a clean confirmation and preserved agent-aware selector `58` dispatch.
- Routed BANDEC fine consultation through a clean type chooser and source-linked form adapter, preserving the Contravension/Transito arguments and Metropolitano agency.
- Routed BANDEC ticket consultation through the source-backed two-choice dialog, preserving agent-aware selector `103` and the BANDEC reservation lookup form.
- Confirmed the source-only BANDEC union-dues callback has no visible menu row; its inherited destination remains available to direct callbacks with selector `121` and BANDEC agency mapping.
- Routed BANDEC balance consultation through a clean confirmation and preserved agent-aware selector `46` dispatch.
- Routed BANDEC exchange-rate consultation through a clean confirmation and preserved agent-aware selector `85` dispatch.
- Routed BANDEC fuel consultation through its four source-linked coupon forms in the source menu's original order.
- Audited `CryptoProvider` against `V5FFEZ0Qrr0`; documented implemented scheme coverage, raw API call sites, and the lack of runtime parity verification.
- Audited `DatabaseHelper` against `unYp8VQThY`; confirmed 196 public methods on each side and documented static-only limits for query and migration parity.
- Audited the clean e-commerce API/session classes against their raw sources; documented image-request and session/error behaviors that remain to migrate.
- Compared `SmsSender` with `HzjedYqYeh`; documented matching send/inbox behavior and the cursor-close limitation inherited from source.
- Audited the SMS parser/import tasks; documented that parsing, storage, and fuel progress callbacks remain omitted from the clean implementations.
- Restored the About layout, Bulevar management/statistics menu, and e-commerce host shell from their source fragments/activity.
- Compared `Sha256Util` with `UkO3Y6TcHD`; confirmed UTF-8 SHA-256, lowercase hex padding, and null-on-error parity.
- Removed the unused `UssdDispatcher` Activity shell and false mapping to static helper `FBsQzP3Zfj`; documented the remaining clean dispatch migration.
- Compared `UpdateApiClient` with `dST9RIJkDp`; documented matching GET behavior, raw-only error logging, and the remaining full update-flow trace.
- Linked the existing Nauta account-type and saved-account management evidence to its pending TODO item.
- Removed the unreferenced common `BranchSelectionFragment` shell after tracing its stale `vVF87n7MnK` mapping to BANDEC card reprint, already routed through `BandecCardReprintFragment` from Configuración.
- Removed the unused common `BankAuthMenuFragment` and `SecurityMenuFragment` shells after confirming neither legacy menu has callers; the bank-specific security menus remain the active routes, and `KmgeIVr5RG` has an empty item callback.
- Removed two stale common shells: `CoordinateAuthFragment` duplicated the routed BANDEC digital-PIN source `RYCvQK4nkF` (selector `79`), while `DisconnectFragment` actually mapped to registration deletion `sxbhjZQZxo` (selector `68`); disconnect remains in the session-menu confirmation.
- Removed the misidentified `BankOperationBaseFragment` shell: mapped source `p3NpwYhcUs3` is the contracted-services operation enum, not a base fragment; clean BANDEC routes continue to use the enum values.
- Removed seven unreachable common banking shells for electricity, fines, gas, loan amortization, public services, utility bills, and wire transfers; their source fingerprints have no callers, while reachable BANDEC operations already use bank-specific clean adapters.
- Routed BANDEC `BANInfoTarjeta` to `BandecCardInfoQueryFragment`, preserving the source's 16-digit account validation and selector `78`; removed the obsolete common placeholder.
- Routed BANDEC `BANConsultarServicio` to `BandecInvoiceQueryFragment`, preserving utility and ONAT query paths with selectors `47`, `56`, and `22`; removed the misnamed common placeholder.
- Routed all three BANDEC `BANRegistrarse` operation entries to `BandecRegistrationFragment`; preserved the source account/card validation and selector `49` plus packet dispatch `110`.
- Routed BANDEC `BANConsultarGiroPostal` to `BandecPostalOrderQueryFragment`, preserving identity-based pending-order lookup and selector `65`; removed the stale common shell.
- Added named BANDEC query adapters for latest operations, account limits, and recent payments; routed Consultas actions and preserved selectors `48`, `62`, and `63`.
- Removed the unused common limit-change shell mapped to caller-free `SIxHnoWicq`; the reachable BANDEC limits action remains routed through `BandecChangeLimitFragment` from `uWkWt7AEZ5`.
- Connected BANDEC access-key and Multibanca PIN changes to clean source-backed forms; corrected the stale `ChangePasswordFragment` mapping and preserved selectors `69`/`75`.
- Connected BANDEC `BANAutenticar` to source-backed `AuthenticateFragment` in the clean session menu; preserved password validation and dispatch `02`/`40`.
- Connected BANDEC session-menu `BANCambioCuenta` to source-backed `AccountSwitchFragment`; retained selector `60`, account/card checks, and original authenticate/disconnect actions.
- Removed the unused BANDEC public-service shell after tracing `t7in6psmmaQ` to private RC05/NIT helpers with no callers; live `BANONAT` uses the RC04/NIT/stamp chooser and opens `ROgpLrCtHa` or `TGMSi5UDp7`.
- Connected BANDEC fixed-term open/close (`81`/`82`), loan amortization (`55`), card reprint (`74`), and monthly-payment change (`25`) to source-backed clean adapters; corrected the stale reprint mapping to monthly-payment change.
- Corrected BANDEC giro postal routing to `BandecPostalOrderFragment`; preserved source `ASLdujtVtr`, identity fields, giro reason, and selector `64` dispatch.
- Connected BANDEC `BANGas` to source-backed `BandecGasPaymentFragment` in the clean operations router, preserving the saved-account and gas-payment form.
- Removed the unused BANDEC billing placeholder mapped to legacy `D6YZ7ruA6K`; the active `BANRecargaMovil` route uses `SjZHfPJPwX` (selectors `54`/`88`).
- Corrected the BANDEC fine-payment draft to the actual patrimonio/ONAT obligation form (`SZARzeWeX5`); the clean router now connects `BANPatrimoniOfa` to `BandecOfaPaymentFragment` (selector `94`).
- Corrected the mislabeled BANDEC recharge draft to `BandecPaymentStatusFragment` and routed the Consultas `BANEstadoPagoExterno` action to source `XKpe29TPn0` (selector `89`).
- Connected BANDEC Configuración limit-change and digital-PIN actions to source-backed clean routes; retained selectors `61` and `79` and delegated the other seven actions to their original source destinations.
- Removed the unused `BandecExternalPaymentFragment` shell after confirming `ZF74c8UCRU` is the recent-payments query (`BANUltimosPagos`, selector `63`), not external payment.
- Removed the unused `BandecCommerceIdFragment` placeholder after tracing `ikSs6fqL5Q` to BANDEC account-limit consultation (selector `62`, `BANConsultaLimite`).
- Removed duplicate `BandecNautaRechargeFragment` placeholder: its `ZDkigMAIBm` mapping is the active BANDEC transfer form already reconstructed as `BandecTransferFragment`.
- Removed the unused `BandecCardRenewalFragment` placeholder after confirming its `gaJlF6dT3z` source is the BANDEC latest-operations query (selector `48`) under `BANUltimasoperaciones`.
- Removed the unused BANDEC account-conversion shell: although `Xh70Rdjfpc` implements selector `87` and the settings handler has a case for `BANConvertirCuenta`, the source menu never adds that operation to its visible rows.
- Removed two unused BANDEC draft shells after tracing their mismatched mappings: `KsDQL9cTTl` opens a USD account with MLC backing (selector `76`), while `g9VybPHHUE` deletes registration (selector `68`); disconnect remains the source session-menu confirmation.
- Removed the duplicate `BandecInvoiceListFragment` shell after confirming its `Q3Nvf439ab` mapping is the active BANDEC electricity payment form.
- Corrected BANDEC session/settings draft mappings: `rvxiiV3tYu` is the three-action Sesión menu and `X7obECfkKf` is the nine-action Configuración menu; connected them through clean named routes.
- Corrected the BANDEC `R7PmVxXLJZC` mapping from a balance-query placeholder to the 14-item Consultas menu; the Consultas tab now uses `BandecQueriesMenuFragment`.
- Corrected BANDEC electricity/water mappings and routed the clean operation router to source-backed `BandecElectricityFragment` (`Q3Nvf439ab`, selector `41`) and `BandecUtilityPaymentFragment` (`T4RQ5wDJDt`, selectors `19`/`51`/`21`).
- Migrated invoice management form `q9DNC6bnexm` into `InvoiceTypeSelectionFragment`; routed the BANDEC add/query/delete actions to it while keeping payment on its separate form.
- Migrated contracted-services payment form `g7yG4Frdxy` into `BandecInvoiceSelectionFragment` and routed the menu's pay action to it; preserved invoice selector, service type, validation, selector `52`, and partial dispatch.
- Migrated the BANDEC contracted-services menu `Kgii4NH4Ce` and connected it to the service tab; kept the four add/query/pay/delete actions and their original destination arguments.
- Migrated the 26-entry BANDEC operation router from `bLlRBTTLue`, connected it to the clean operation pager, and routed `BANTransferencia` to `BandecTransferFragment` while keeping the remaining source destinations intact.
- Migrated the menu-routed BANDEC transfer form `ZDkigMAIBm` into `BandecTransferFragment`; preserved selector `45`, PIN/partial dispatch, account source modes, contact/message options, and bank logos. The mapped `Lxfm3mPhrA` class has no callers and is a duplicate candidate.

- Routed the BFI enterprise Settings tab through clean `BfiSecurityMenuFragment`; source `bnsLemXoui.initData()` exposes only registration and PIN change, while its associate-account callback is not reachable from the displayed list.
- Migrated BFI account association `F2leFVNWrdy` into `BfiAssociateAccountFragment`; preserved random matrix coordinates, selector `60`, account validation/confirmation, and source-backed card-logo branches.

- Corrected a source-map error: `F2leFVNWrdy` is BFI account association (`BFIAsociarCuenta`, selector `60`), not Metro transfer; removed the unreferenced Metro placeholder and added the actual BFI migration to TODO.

- Reconciled agent and General data-management pagers against `OQcONjDATJ` and `wTZi6Zeikv`; verified all 11/8 tab destinations, titles, and General contact permission setup.

- Reconciled the QR image utility with `ZUoEY89WdA`; verified its 23 public/private static operation names map to the clean generator, including GIF, logo, dithering, rotation, resizing, and decoding paths.

- Recovered the Wallet transfer card-logo renderer using shared card-validation branches; documented PAN/standard bank prefixes and icon selection in `docs/domain-model.md`.

- Reconciled raw QR screen `b6FtEHgm1B` with `QrDynamicPaymentFragment`: both share layout, menu, QR parsing, and selectors `31`/`30`; removed the null-returning duplicate shell and documented the clean implementation mapping.

- Migrated the MiTransfer public-service/PCC draft `udysei7zCr` into clean `PublicServicePaymentFragment`; preserved CUP bolsa choice, contact-confirmation payload, salary validation, and selector `7` full/partial (`04`) calls.

- Expanded the TODO backlog: enumerated all 53 empty banking fragments and 16 remaining application-layer placeholders by file, split the four raw General-mode screens into separate tasks, and retained seven recent completions without hiding them in parent items.
- Rebuilt the shared MiBoleto ticket form base as `MiBoletoTicketBaseFragment`; status, key-update, and latest-operations screens now inherit it, and the empty `TicketBaseFragment` shell was removed.
- Routed General-mode union-payment lookup from raw `SlZq2dCM9i` to `WalletSyndicateQueryFragment`; its MiTransfer agency argument selects the same selector-121 payload branch.
- Migrated General telephone-invoice query `HFzgpLELho` into `GeneralPhoneInvoiceQueryFragment` and connected the dialog route; preserved eight-digit validation, saved-number insertion/menu refresh, and selector `47`.
- Migrated General MiTransfer account-statement query `qAMfdm9Kls` into `GeneralWalletStatementFragment` and connected the dialog route; preserved six-month date bounds, currency selection, email validation/encoding, and selector `26` full/partial dispatch.
- Migrated General service-debt query `k5fNqiPSlwb` into `GeneralServiceDebtQueryFragment` and connected both General-menu routes; preserved five service types, saved-invoice selection, service-specific validation, and selector `47` full/partial dispatch. Agency-only dialog arguments no longer trigger invalid invoice-prefill access.

## 2026-11-07 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Restored the MiTransfer Voto Móvil form from `cdINOtQ3iN`, connected the menu, and documented selector `215`, wallet validation, and the encoded `454` call path in telephony notes.
- Restored MiTransfer MiBoleto purchase from `TBaFnBLjEA`, connected its menu route and booking-state reset, and documented selector `118` with regular/partial dispatch.
- Restored the MiBoleto status form from `w7mHpmOa4EP`, connected its General-mode menu route, and preserved saved-ticket series selection, ten-character validation, and selector `114`.
- Restored the MiBoleto key-update form from `hjX8MS8xO9`, connected its General-mode menu route, and preserved saved-ticket series selection, ten-character validation, and selector `115`.
- Restored MiBoleto latest operations from `i9I9XZGnR3`, connected its General-mode menu route, and preserved optional email encoding plus selector `113` full/partial dispatch.
- Restored MiBoleto integrated ticket query from `OXpoe3K2m1`, connected its General-mode menu route, and preserved date/email validation, encoded email, and selector `112` full/partial dispatch.
- Restored MiTurno reservation lookup from `x12rSjPY6pZ`, connected the General ticket-query choice to the clean screen, and preserved CI QR prefill/scanning, help, and selector `107`.
- Removed five unreferenced banking fragment shells after confirming each obfuscated source already has a canonical clean implementation for gas, electricity, latest operations, bank-to-wallet transfer, or water payment.
- Restored the OFA visit-query form from `dYBdUyjb1D`, replaced its mislabeled settings stub, and connected the General-mode query dialog with its two modes and selector `9` payload.
- Restored enterprise transfer and external-payment dialog actions, passing `TransferType`/`PayType` and the `CLASICAEMP` agency argument while resetting shared state.
- Corrected the MiTransfer enterprise-transfer destination to the source-mapped `Z3kYdPwq6K2` form: selector `220` with partial marker `08`; kept BFI enterprise banking selector `104` in its separate route.

## 2026-11-06 — cu.etecsa.cubacel.tr.tm-v162.apk — SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

- Restored the MiTransfer Pago en Línea QR form from `s9CT6pjRyD`, connected the mode/agency bundle and source state reset, and documented static/dynamic selector branches `31`/`30`.
- Replaced the generic invoice stub with the fixed-phone payment form from `p5B8KozjvpQ`, connected `BOLSATelefono`, and documented selector `42`, saved account behavior, and partial-USSD routing.
- Restored MiTransfer ticket reservation create/cancel/date-change screens from `XnVSHGPTkK`, `QVPgkl8ZGC`, and `Wwc5crW71D`; wired all dialog choices and the source-backed shared-state reset.
- Restored the MiTransfer OFA contribution form from `C6ZYln3x19W`, connected `BOLSAAporteOFA`, and documented obligation loading and selector-94 CUP/partial payload.
- Replaced the unused CADECA-named stub with the OFA reservation form from `dWLcK5oQoS`, connected `BOLSAReservasOFA`, and documented selector-8 fields and HTTP/partial dispatch.
- Restored and connected the MiTransfer organization-payment form from `xb7DiohJuX`; documented selectors `7`/`122`, partial-USSD settings, and observed CI/resource anomalies.
- Restored and routed the MiTransfer TFA selector-108 recharge from `b7zSZMAX7cN`; documented CUP-only UI selection, amount/account validation, and partial-USSD dispatch.
- Restored MiTransfer Cubacel package selection from `WyYHxgzYyW`, connected `BOLSAPaquetesCubacel`, and documented its local/JSON catalog refresh and selector-6 CUP/USD payload.
- Replaced two misnamed FWA stubs with `wbFn8tBw8W`/`q55ExEc6x2l` source migrations, connected the recharge and gigabyte purchase routes, and documented selector `20`/`18` payloads plus the mislabeled “consulta” menu text.
- Replaced the unused, misnamed mobile-transfer stub with the source-backed Extra USD package form from `f3Ttlx30sMT`; connected `BOLSACompraPaqueteMLC` and documented selector `33` and contact-number normalization.
- Restored the MiTransfer own-card selector-77 form from `JrjJL8mtlI`, connected `BOLSARecargaPropia`, and documented CUP payload, local series persistence, and validation limits.
- Migrated the Nauta Plus selector-34 form from `HZgbT8IXPf`, connected both account modes from the MiTransfer menu, and documented their payloads, validation, USD bolsa, and source limits.
- Traced Nauta Hogar switch behavior and shared account/amount/mobile validation; clarified international/national account labels and selector `84` versus debt selector `86` in the Nauta flow notes.
- Documented Nauta account persistence, profile assignment, type/domain mapping, DAO query behavior, and the observed null/error-handling limits in `docs/storage.md`.
- Restored and routed the General MiTransfer Nauta form from `KtF0PRB8vS`; documented selectors `59`, `84`, and `86`, their payload branches, partial-USSD settings, and source quirks.
- Added a source-backed comparison of BPA, BANDEC, Metropolitano, and BFI registration, query, transfer, and PIN distinctions, with explicit limits where the current source review is incomplete. Linked it from README and completed the corresponding TODO item.
- Documented general and traffic fine flows (selectors `96` and `97`) from raw and clean sources; corrected the catalog's unsupported claim that the traffic-fine screen can use partial-USSD packets.
- Documented the ONAT selector-`43` RC05/NIT and monthly/annual/declared-amount builders, including ordered fields, defaults, and the distinct partial-USSD path. Linked the details from README and the USSD catalog.
- Compared BFI enterprise-transfer and external-payment form bodies against `f1IveoSASW` and `Eqj43O0pUx`; their payload branches and selectors `104`, `31`, and `30` match, with USSD callbacks supplied by the clean shared base.
- Compared `BfiAccountStatementFragment` with raw `MIya98FZRz`; the executable form body matches after mapping its clean commission-account base, including selector `26` and payload order.
- Compared both clean Wallet fine forms with raw `NzOTegfhDk` and `rc7O18ZPOU`; selector, payload, confirmation, and validation implementations match, and neither form has a partial-packet call path.
- Compared the clean ONAT RC05/NIT form with `ROgpLrCtHa`; the executable form body matches after mapping its source base to the clean banking base, including regular and partial selector-43 dispatch.
- Fixed MiTransfer session close: the clean menu now dispatches selector `70` on positive confirmation and resets its local bank configuration through the source-backed helper before opening the dialog; removed the nonexistent dispatcher call.
- Repaired BPA account/session menu dispatch: use the source-backed agent-code lookup and activity interfaces, restore local session reset through `FBsQzP3Zfj`, and remove unresolved clean dispatcher/activity placeholders.
- Compared `WalletLatestOperationsFragment` with `dI2tctjNbR`; the form preserves selector `48`, payload order `1*<selected-value>*<wallet-type>`, and the `08` saved-account / `04` wallet routes.
- Compared BFI balance, limit, and latest-operation forms with raw `Mg7YIILN4B`, `leZyk029xo`, and `Np5pMRuX6q`; executable methods match, including selectors `46`/`62`/`48` and partial marker `05`.
- Replaced seven calls to a nonexistent static `UssdDispatcher.actionCallUSSDBack` with source-backed `FBsQzP3Zfj` overloads across BPA account forms and MiTransfer PIN authentication.
- Documented agent selector-`80` activation, `PAGOxMOVIL` SMS extraction, the local code-validation algorithm, first-row `AgentService` persistence/lookup, and source-confirmed menu routes.
- Traced Agent Resumen/Detalle statistics from the navigation menus through monthly charts and per-module records; documented local SMS data, detail filters/account masking, and a likely unverified iterator-exhaustion defect in summary loading.
- Traced all six Agent drawer actions, mobile-recharge local number persistence and selector-12 payload, latest-recharge branches, and selector-11 PIN-change payload; recorded a source-visible repeated-PIN validation issue and split the remaining General-mode menu review into its own TODO.
- Inventoried all 14 General-mode carrier-service seed operations, their fragment destinations, enum routes, and saved-operation reconciliation; confirmed the direct `*222`/`*111` balance branches and left remaining form payloads for focused tracing.
- Traced General-mode coupon recharge: selector `662`, non-empty voucher validation, QR scan category, non-digit stripping for scanned data, and Agent/General activity routing.
- Traced General-mode ordinary and `*99` calling: shared form modes, eight-character validation, contact-number normalization, and direct `ACTION_CALL` URI construction.
- Traced General-mode mobile balance transfer: selector `234`, option `1`, recipient/PIN/amount field order, local validation limits, and Agent/General dispatcher selection.
- Traced the General-mode transfer-key change route: selector `234`, option `2`, payload order, and source-visible missing equality check/repeated-field length validation gap.
- Added nine source-confirmed General-mode carrier codes to the USSD catalog: prepaid/postpaid balances, bonus status, plan management, four plan queries, and advance balance; all are literal confirmation-dialog calls.
- Traced the MiTransfer CUP deposit-ticket form: amount validation, selector `17`, payload `<amount>*CUP`, partial gateway `110`/agency `04` route, and empty response callback; identified the clean form stub and missing banking-tab route.
- Reconstructed `WalletRechargeFragment` from `P8DtkaSW4dR` and connected `BOLSARecargaCUPWalletTicket` in the clean banking tab; preserved selector-17 full/partial USSD dispatch, amount validation, and close/back behavior. Updated the source-trace note to reflect the implementation.
- Reconstructed `WalletTopupFragment` from `zzyNbaqs1U` and connected the MiTransfer mobile-recharge menu to its source-confirmed CUP route; documented CUP/USD selectors, `phone*amount*0*type` payload, contact normalization, and the dormant USD selection dialog.
- Reconstructed `WalletTransferFragment` from `LjOlaYSSMH` and wired the MiTransfer option in the wallet transfer dialog; preserved selector `45`, six-field payload, contact selection, validation, and partial marker `04`. The classic-transfer option still routes to its raw source pending migration.
- Reconstructed `WalletWithdrawFragment` from `f9Reflqt3EZ` and connected `BOLSAExtraccionWalletTicket`; preserved selector `95`, CUP/USD entity lists, conditional province/municipality selection, payload construction, and partial marker `04`.
- Reconstructed `BankTransferBfiFragment` from `l3GXbXAyUW` and replaced the “Clásica” dialog's raw destination with the clean form; preserved selector `45`, classic-card checks, optional account/PIN prefixes, contact handling, and agency marker `08` partial dispatch.
- Reconstructed the distinct bank-to-wallet transfer as `WalletBankTransferFragment` from `H0oV6Ot0bS` and connected `BOLSATransferirBancos`; preserved selector `16`, agency/currency payloads, and the `04` partial route.
- Reconstructed `WalletElectricityPaymentFragment` from `dwdZ5sHcFR` and connected `BOLSAElectricidad`; preserved selector `41`, CUP invoice payload, saved-invoice insertion/menu refresh, and partial marker `04`.
- Reconstructed `WalletWaterPaymentFragment` from `U1sIOmca96i` on `BfiUssdAccountFragment` and connected `BOLSAAgua`; preserved Havana/Varadero selectors `19`/`21`, invoice persistence, and partial marker `04`, while documenting source-visible validation quirks.
- Reconstructed `WalletGasPaymentFragment` from `XCDkgbw8oZ` and connected `BOLSAgas`; preserved selector `67`, 12-character invoice validation, type-3 invoice persistence, and partial marker `04`.

- Added `BfiUssdAccountFragment`, reusing the clean two-account selector/card renderer and restoring Agg55uYctq's USSD observer contract and four-parameter packet limit. Transfer and external-payment forms remain pending migration.
- Migrated `f1IveoSASW` into `BfiEnterpriseTransferFragment` on the clean BFI account base and routed its three `TransferType` choices to the migrated form; retained its selector-104 and partial-USSD logic.
- Migrated `LgiFGRpiEl` to the clean BFI QR/contact account base and `Eqj43O0pUx` to `BfiExternalPaymentFragment`; routed external-payment modes to the new form and retained its selector-31/selector-30 branches.
- Removed a residual raw `LgiFGRpiEl` cast from the migrated external-payment form. Clarified that `scripts/tests/test_update_progress.py` tests only README progress calculations; it does not validate Android or banking behavior.

- Replaced the raw BFI operations menu with a clean menu for transfer and external payment, preserving both three-mode dialogs and their existing source-backed raw form destinations.

- Replaced the BFI configuration tab's raw security menu with a clean menu that preserves its two source-backed options and navigation.
- Migrated BFI registration and PIN-change forms into clean classes. Preserved selector `49` with `05*<current-PIN>*<new-PIN>*<identity>` and partial-USSD marker `05`, plus selector `69` with `05*<current-PIN>*<new-PIN>`.
- Replaced the BFI session tab's raw menu and PIN prompt with clean classes. The PIN form uses access code `05`, selector `40`, and `05*<PIN>`; session close retains the local config reset and confirmed selector `70` dispatch.
- Replaced the BFI consultations menu with a clean menu and connected its balance, latest-operations, limits, and account-statement actions to clean screens.
- Migrated the BFI account-statement form, preserving email validation, date pickers limited to the past six months, account selection, and selector `26` payload order `email*start-date*end-date*account`.
- Compared Wallet PIN authentication against JADX and documented selector `40`, access code `04`, the four-digit validation, and `04*<PIN>` payload in the USSD catalog.
- Traced MiTransfer saved-account balance queries: selector `46`, payload `1*<account>*<wallet-type>`, and partial-USSD route `110/46/08` with a four-parameter limit.
- Traced MiTransfer latest-operations selector `48`: saved-account and currency options, agency markers `08`/`04`, and the shared four-parameter partial-USSD route.
- Migrated `dI2tctjNbR` to `WalletLatestOperationsFragment` and connected the General Banking menu to it, preserving dynamic wallet labels, saved MiTransfer/enterprise accounts, validations, and full/partial USSD dispatch.
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
