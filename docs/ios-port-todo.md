# iOS port feasibility and plan — TODO

Target Android client: Transfermóvil 1.260416 (`cu.etecsa.cubacel.tr.tm-v162.apk`). This is a research checklist for a possible iOS implementation, not a claim that feature parity is possible or an implementation plan ready to execute.

## First decision: what can an iOS app actually do?

- [x] Build a static feature matrix from [architecture](architecture.md), [telephony](telephony.md), [e-commerce](ecommerce.md), [storage](storage.md), and [security](security.md): user action, Android dependency, required outcome, iOS public API, gap, and possible user-assisted or server-side alternative.
- [ ] Test USSD feasibility on supported iPhone and iOS versions. Apple's [Phone Links documentation](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html) says `tel:` links containing `*` or `#` are not dialed and that dialing requires user confirmation. Verify current device behavior and whether any public API supports the required USSD requests and responses. Do not assume Android's `ACTION_CALL`, `sendUssdRequest()`, or accessibility-dialog capture can be replicated.
- [ ] Check SMS parity. Apple's [Message UI](https://developer.apple.com/documentation/messageui) provides a user-facing compose screen in which the user can edit, send, or cancel. Investigate whether any public API meets the app's direct-send and incoming-response parsing needs; document the precise limits before selecting an alternative.
- [ ] Check whether Core Telephony exposes the SIM, carrier, and line-selection information each workflow requires. Start with Apple's [Core Telephony reference](https://developer.apple.com/documentation/coretelephony).
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
| USSD dispatch and response | Send carrier codes and capture the interactive reply, including multi-step operations. | Apple says a native `tel:` URL requires user confirmation and a URL containing `*` or `#` is not dialed; [Phone Links](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html). No public USSD request/response API was identified in the reviewed docs. Device/carrier testing remains. | The documented app relies on Android dial intents, `sendUssdRequest()`, and accessibility capture. | No parity decision until device tests; plan for manual carrier interaction or a server-side integration if supported by ETECSA. |
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

Static source/documentation review completed 2026-11-10. The API and distribution conclusions remain provisional until current device tests and the App Store/carrier-policy review are completed.

### Distribution and authorization (reviewed 2026-11-10)

Apple's current [App Review Guidelines](https://developer.apple.com/app-store/review/guidelines/) state that apps in highly regulated fields such as banking and financial services, or apps requiring sensitive user information, should be submitted by the legal entity providing those services. Apple's [complete-review documentation](https://developer.apple.com/help/app-review/before-submitting-for-review/complete-review/) lists partnership documentation from the financial institution or bank providing the service for financial apps. Transfermóvil's client-visible banking and wallet operations make this a material review gate, but this static review cannot determine the appropriate submitting entity, licensing status, or required agreements for a future iOS product. Those points require the service owner and Apple to confirm against the proposed feature set and target storefronts.

**Done when:** The matrix cites Apple documentation and supported-device tests, names every blocked or user-assisted feature, and yields a scoped iOS implementation plan with explicit parity limits.
