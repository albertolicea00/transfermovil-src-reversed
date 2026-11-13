# iOS port feasibility and implementation plan

Target Android client: Transfermóvil 1.260416 (`cu.etecsa.cubacel.tr.tm-v162.apk`). Static feasibility review completed 2026-11-12. An API-backed commerce/QR/local-data application is a viable implementation scope; full Android USSD/SMS parity is not supported by the public APIs reviewed. No iPhone/carrier tests, backend requests, submissions, or agreements were performed.

## First decision: what can an iOS app actually do?

- [x] Build a static feature matrix from [architecture](architecture.md), [telephony](telephony.md), [e-commerce](ecommerce.md), [storage](storage.md), and [security](security.md): user action, Android dependency, required outcome, iOS public API, gap, and possible user-assisted or server-side alternative.
- [ ] Test USSD feasibility on supported iPhone and iOS versions. Apple's [Phone Links documentation](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html) says `tel:` links containing `*` or `#` are not dialed and that dialing requires user confirmation. Verify current device behavior and whether any public API supports the required USSD requests and responses. Do not assume Android's `ACTION_CALL`, `sendUssdRequest()`, or accessibility-dialog capture can be replicated.
- [x] Review documented SMS parity. Apple's [Message UI](https://developer.apple.com/documentation/messageui) provides a user-facing compose screen in which the user can edit, send, or cancel. Investigate whether any public API meets the app's direct-send and incoming-response parsing needs; document the precise limits before selecting an alternative.
- [x] Review documented Core Telephony coverage for SIM, carrier, and line-selection requirements. Start with Apple's [Core Telephony reference](https://developer.apple.com/documentation/coretelephony).
- [x] Record the current App Store submission requirement relevant to banking/financial services; keep the developer entity, carrier/bank authorization, and storefront scope unresolved until a port owner is identified.
- [ ] Confirm which legal entity can submit the port and obtain ETECSA/bank/carrier approvals for the selected markets and implementation.

## Porting work to scope after feasibility

- [ ] Separate platform-independent rules (operation definitions, USSD parameter encoding, response formats, validation) from Android-only code. Define Swift-compatible fixtures and offline tests for protocol behavior.
- [x] Map Android navigation and major agent, banking, wallet, QR/boleto, and e-commerce feature families to a provisional iOS screen scope below; accessibility, localization, and permission design remain implementation work.
- [ ] Rebuild online flows with `URLSession`, including authentication, session renewal, deep links, and errors. Audit the backend rather than copying the Android client's trust-all TLS behavior. Apple's [App Transport Security](https://developer.apple.com/documentation/BundleResources/Information-Property-List/NSAppTransportSecurity) documents the default HTTPS and trust requirements.
- [ ] Map SQLite/ORMLite entities and preferences to an iOS data model. Plan migration only for data the user can legitimately export or re-enter. Store secrets with [Keychain Services](https://developer.apple.com/documentation/security/keychain-services).
- [ ] Compare all protocol-compatible cryptography with known-answer test vectors. Treat insecure Android schemes as interoperability constraints to assess, not design patterns to copy into new features.
- [ ] Replace Android-specific camera, QR, notifications, background jobs, contacts, files, and app-update flows with supported iOS APIs where each feature is still required.
- [x] Define a gated proof-of-concept for the highest-risk requirement below; execution remains blocked on a carrier/service-owner test environment and authorization.

## Decision record to fill in

| Feature | Required outcome | iOS evidence / device test | Gap | Decision |
| --- | --- | --- | --- | --- |
| USSD dispatch and response | Send carrier codes and capture the interactive reply, including multi-step operations. | Apple says a native `tel:` URL requires user confirmation and a URL containing `*` or `#` is not dialed; [Phone Links](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html). No public USSD request/response API was identified in the reviewed docs. Device/carrier testing remains. | The documented app relies on Android dial intents, `sendUssdRequest()`, and accessibility capture. | Exclude automated USSD and response capture from the public-API implementation scope. Device tests may assess a manual carrier handoff, but cannot establish an undocumented API contract. Reopen parity only with a supported carrier integration. |
| SMS send and response | Send service SMS and parse incoming transaction/activation responses. | [`MFMessageComposeViewController`](https://developer.apple.com/documentation/MessageUI/MFMessageComposeViewController) displays a user-editable, cancelable compose UI; it does not expose the app's Android-style direct send or inbox-reading flow. Device behavior still needs validation. | No reviewed public API provides general silent SMS sending or reading arbitrary incoming SMS. | User-composed send may cover selected outgoing actions; incoming parsing needs a different delivery path or remains unavailable. |
| SIM/carrier selection | Identify service lines and select the SIM for an operation. | [`CTCarrier`](https://developer.apple.com/documentation/coretelephony/ctcarrier) is deprecated with no replacement; [`CTTelephonyNetworkInfo`](https://developer.apple.com/documentation/coretelephony/cttelephonynetworkinfo) exposes service identifiers and change notifications. Test on supported devices. | Subscriber identity and per-operation line selection are not established by the reviewed public APIs. | Require device testing and carrier confirmation before promising line selection. |
| Online commerce | Authenticate, call the e-commerce API, open deep links, and render QR/payment flows. | [`URLSession`](https://developer.apple.com/documentation/foundation/urlsession) and registered/custom links provide platform building blocks. No device-specific blocker identified from the current client sources. | Must use verified TLS and confirm backend support; Android trust-all behavior is not an acceptable design target. | Feasible to prototype after backend/API review. |
| Local data and secrets | Store preferences, records, and credentials. | Use Core Data/SwiftData and [Keychain Services](https://developer.apple.com/documentation/security/keychain-services); confirm schema and migration needs against the data inventory. | ORMLite/SQLite schema and Android preferences need a migration policy. | Feasible; migrate only data needed for the iOS feature set. |
| QR and device integrations | Scan/render QR, access contacts/camera, notify, and update the app. | Use AVFoundation/Vision and system permission flows; app updates are distributed through platform channels rather than the Android package installer. | Rebuild Android service, file, background-work, and installer behavior individually. | Feasible per feature, subject to device testing and distribution rules. |

### Provisional screen map and port scope

This maps the source-backed Android navigation to iOS feature families; it is a
scope proposal, not a claim that every operation can be ported.

| Android area | User-facing feature families | Provisional iOS scope |
| --- | --- | --- |
| Shared home and settings | Operation shortcuts, preferences, help, local catalogs | Port the navigation and catalog experiences; redesign permissions and accessibility for iOS. |
| General mode | Carrier services, SMS shortcuts, useful numbers, MiTransfer, MiBoleto, banks, Bulevar, statistics | Port informational and QR/UI surfaces. Carrier and bank operations need a supported service API or explicit user handoff; no silent SMS/inbox parity. |
| Agent mode | Agent operations and services, MiTransfer, MiBoleto, banks, Bulevar, statistics | Port screens only after the service owner supplies supported APIs and approves the agent workflow; local form validation can be reused after protocol review. |
| Banking and wallet tabs | BPA, BANDEC, Metropolitano, BFI, MiTransfer balance, transfers, payments, statements, limits | Preserve the information architecture only where the operation backend is approved. USSD-dependent actions are out of parity under the reviewed public iOS APIs. |
| Bulevar commerce | Login, product browsing, cart/checkout, payment QR/deep links, refunds and business tools | Candidate for an API-backed iOS module after backend, TLS, legal-entity, and service-owner review. |
| QR and ticket workflows | Scan QR, MiBoleto and MiTurno lookup/purchase/reservation | Candidate for a native camera/QR flow; every submit action still depends on an approved backend or supported carrier integration. |
| SMS-driven records and updates | Import transaction/activation SMS; download and install APK updates | No direct parity plan. Replace with an authorized server feed or user-export/import flow; distribute iOS updates through Apple's channels. |

### Gated proof-of-concept

The highest-risk dependency is an end-to-end USSD banking or wallet request with
the reply needed to continue the transaction. The reviewed public APIs do not
provide an app-controlled USSD request/response channel. Do not build the full
USSD feature set on the assumption that a `tel:` link can carry `*`/`#` or expose
the interactive response.

Before any port commitment, the service owner and carrier would need to provide
a written-authorized test account/line and a non-production endpoint or
carrier-supported iOS integration. The experiment should use one read-only
balance query, public iOS APIs only, and record whether it can submit the
request, obtain each interactive response, handle cancellation, and avoid
exposing account secrets. Pass only if the complete response loop is supported
without private APIs; otherwise mark USSD-dependent banking/wallet operations
out of parity and scope a server API or manual carrier handoff separately.
This gate is defined but not executed because the required test environment
and authorization are not present in the repository.

Static source/documentation review refreshed 2026-11-12. The implementation scope below follows documented public APIs; device/carrier behavior, backend compatibility, distribution approval, and provider agreements remain separate unexecuted gates.

### Distribution and authorization (reviewed 2026-11-12)

Apple's current [App Review Guidelines](https://developer.apple.com/app-store/review/guidelines/) state that apps in highly regulated fields such as banking and financial services, or apps requiring sensitive user information, should be submitted by the legal entity providing those services. Apple's [complete-review documentation](https://developer.apple.com/help/app-review/before-submitting-for-review/complete-review/) lists partnership documentation from the financial institution or bank providing the service for financial apps. Transfermóvil's client-visible banking and wallet operations make this a material review gate, but this static review cannot determine the appropriate submitting entity, licensing status, or required agreements for a future iOS product. Those points require the service owner and Apple to confirm against the proposed feature set and target storefronts.

## Current public-API findings (reviewed 2026-11-12)

- **USSD:** The archived [Phone Links reference](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html) explicitly describes confirmation for `tel:` and rejection of `*`/`#` strings. This is an archived platform contract, not a current-device test. No request/interactive-response interface appears in the reviewed [Core Telephony API surface](https://developer.apple.com/documentation/coretelephony/cttelephonynetworkinfo). Excluding Android-style USSD is an inference from these documented capabilities; do not treat percent-encoding `#` as evidence that the restriction disappears.
- **SMS:** [Message UI](https://developer.apple.com/documentation/messageui/mfmessagecomposeviewcontroller) lets the app prefill recipients/body and present a composer. The user may edit or cancel; delivery is not guaranteed by the composer. Check `canSendText()` and handle the delegate result. That result is not a bank response or transaction receipt. [IdentityLookup](https://developer.apple.com/documentation/identitylookup) provides spam-filtering/reporting extensions, not an Android SMS inbox replacement; it does not establish arbitrary history import or transaction-response delivery to the app.
- **SIM:** [CTCarrier](https://developer.apple.com/documentation/coretelephony/ctcarrier) is deprecated from iOS 16; carrier-provider dictionaries are listed as deprecated in [CTTelephonyNetworkInfo](https://developer.apple.com/documentation/coretelephony/cttelephonynetworkinfo). Its [dataServiceIdentifier](https://developer.apple.com/documentation/coretelephony/cttelephonynetworkinfo/dataserviceidentifier) is read-only and identifies the service currently providing data. It is neither a phone number nor a setter for the voice/SMS/USSD line. Source Android subscription IDs cannot be migrated to iOS service identifiers.
- **Network and secrets:** Keep `URLSession` trust evaluation and default [ATS](https://developer.apple.com/documentation/bundleresources/information-property-list/nsapptransportsecurity); verify production endpoint compatibility before accepting a backend. Use [Keychain](https://developer.apple.com/documentation/security/keychain-services) for small secrets. Reproducing the Android trust-all client or storing secrets in migrated preferences is excluded from the proposed implementation.

## Implementation work packages and acceptance gates

These packages are a design deliverable, not completed Swift work. There is no iOS project in this repository.

| Order | Package | Inputs / implementation | Acceptance evidence |
| --- | --- | --- | --- |
| 1 | Offline domain core | Map operation enum IDs, currencies, DTOs, validation rules, null/default behavior, and protocol encoders to a Swift package. Retain source field order and numeric types; isolate platform dependencies behind interfaces. | JSON fixtures compare with the existing 78-pair model/Gson harness; fixed-clock auth vectors and fixed-seed numeric/mixed USSD encoder vectors match. Encoding fixtures run offline and do not imply transport support. |
| 2 | Local-data boundary | Define a versioned SQLite/Core Data schema for the selected features using [storage notes](storage.md). Preferences hold nonsecrets; Keychain holds session credentials. Import user-provided supported exports into a staging area, validate, then commit atomically; never expect access to Android private files/SMS. | Round-trip dummy exports, incompatible-version rejection, duplicate handling, missing-field defaults, rollback and deletion checks. Record which Android entities are intentionally omitted. |
| 3 | Commerce client | Map the 33 endpoints in [e-commerce notes](ecommerce.md), auth/token persistence, errors and cancellation to `URLSession`/`Codable`. Confirm endpoint certificates and backend iOS support. Redact request logs; preserve response-code semantics. | Service-owner sandbox supplies login, expired-token, offline, malformed-error, pagination and checkout fixtures. Receipt/status reconciliation uses server IDs; retries do not duplicate payments. |
| 4 | Native navigation and QR | Shared home/settings/help; commerce screens; QR camera/gallery and generation; contacts through the system picker; document import/export and permission fallbacks. Preserve source route arguments, not Android class names. | Camera and photo permission denial, malformed/unsupported QR, currency/amount boundaries, deep-link validation, VoiceOver, Dynamic Type, Spanish labels and offline states on physical supported iPhones. A QR submit button requires a supported backend. |
| 5 | User-assisted carrier actions | Only selected outgoing SMS through the system composer and ordinary telephone-number links. Clearly represent cancel/failure/unknown delivery. USSD-dependent forms remain disabled or omitted; saved QR/account data may remain viewable. | Real-device composer cancellation and unavailable-service checks. No success state based solely on returning from Messages/Phone; no inbox/parser or USSD response promises. |
| 6 | Provider-dependent banking/agent module | ETECSA/bank/carrier supplies a supported non-USSD API or documented carrier integration. Move bank/session/transaction state behind that transport boundary; specify request IDs and status reconciliation before enabling monetary actions. | Provider test environment proves authentication, a read-only query, cancellation/timeout, response delivery, selected-line behavior where relevant, and transaction reconciliation. Android accessibility or private iOS APIs cannot satisfy this gate. |
| 7 | Distribution and operations | Establish submitting entity, rights/agreements, target storefronts, privacy disclosures, retention/deletion behavior, supported device/OS matrix, test accounts/demo mode and support process. | Provider records plus Apple review requirements; production monitoring and signed release distribution. No APK downloader/installer translation. |

### Parity disposition by feature

| Source feature | Disposition | Replacement / dependency |
| --- | --- | --- |
| General/Agent home, settings, help, local operation catalogs | Native implementation candidate | SwiftUI/UIKit and a versioned local catalog; preserve the two source modes. |
| BPA/BANDEC/Metro/BFI/MiTransfer registration, authentication, balances, limits, payments, transfers and statements | Excluded from initial transactional scope | Depend on supported provider transport. Keep validation/DTO fixtures reusable offline. |
| Agent recharge stock, activation and statistical summaries from SMS | Provider-dependent | Server-issued agent identity and transaction feed; local reconstruction cannot supply authority or receipts. |
| Ordinary useful-number calls | User-assisted | System `tel:` handoff, confirmation and return; no programmatic call-completion claim. |
| ETECSA offers, Voto Móvil and other outgoing SMS shortcuts | User-assisted candidate | Editable system composer; no guarantee of delivery or accepted vote/service operation. |
| Incoming activation/transaction SMS and historical SMS imports | No direct parity | Explicitly entered code, user-imported supported statement, or provider feed; no general Messages database access assumed. |
| SIM identification and per-request line selection | No promised parity | User chooses appropriate line in supported system/provider flow; data service ID is insufficient. |
| Bulevar login, product/cart, business/refund tools | API-backed candidate | Schema/auth/TLS review and supported backend; source Android login UI is not proof of service availability. |
| MiBoleto/MiTurno/OFA QR, validation, reservation and purchase | Split capability | Offline QR display/parsing can port; USSD submission/verification requires provider backend. |
| Local saved accounts, beneficiaries, notes and exports | Native implementation candidate | User-controlled supported imports, local schema and Keychain; Android encrypted backups need explicit compatibility tests. |
| SMS-derived reports and historical statistics | Data-dependent | Recompute from imported/provider records only; absent history remains absent. |
| Camera, QR generation, contacts and files | Native implementation candidate | System APIs and explicit permission/availability states. |
| Background USSD/SMS listener and accessibility capture | Excluded | No reviewed public app API supplies the required cross-app capture behavior. |
| Android APK self-update | Excluded | Select a supported Apple distribution channel for the deployment context. |

## Remaining external validation

| Gate | Status | Required input and completion evidence |
| --- | --- | --- |
| Supported-device/carrier experiment | Not executed | An identified iOS project, physical supported devices/OS builds and test line; record model/build, carrier, SIM/eSIM/dual-line setup, composer/phone behavior and exact observed outcomes. Simulator results cannot prove carrier behavior. |
| Provider backend and account | Not available in repository | Service owner provides sandbox, credentials and API contract. Record read-only/transaction test outcomes without storing live secrets. |
| Submitting entity and approvals | Not established | Owner supplies agreements and storefront scope; distribution review determines applicable documentation. |
| Swift implementation | Not started | A separately scoped iOS codebase and the work packages above. |

Static feasibility and scoping are complete to the documented evidence. Device tests, provider agreements, a supported banking transport, and implementation remain pending; they cannot be honestly marked complete by repository analysis alone.
