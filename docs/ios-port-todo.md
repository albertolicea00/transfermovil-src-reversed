# iOS port feasibility and plan — TODO

Target Android client: Transfermóvil 1.260416 (`cu.etecsa.cubacel.tr.tm-v162.apk`). This is a research checklist for a possible iOS implementation, not a claim that feature parity is possible or an implementation plan ready to execute.

## First decision: what can an iOS app actually do?

- [ ] Build a feature matrix from [architecture](architecture.md), [telephony](telephony.md), [e-commerce](ecommerce.md), [storage](storage.md), and [security](security.md): user action, Android dependency, required outcome, iOS public API, gap, and possible user-assisted or server-side alternative.
- [ ] Test USSD feasibility on supported iPhone and iOS versions. Apple's [Phone Links documentation](https://developer.apple.com/library/archive/featuredarticles/iPhoneURLScheme_Reference/PhoneLinks/PhoneLinks.html) says `tel:` links containing `*` or `#` are not dialed and that dialing requires user confirmation. Verify current device behavior and whether any public API supports the required USSD requests and responses. Do not assume Android's `ACTION_CALL`, `sendUssdRequest()`, or accessibility-dialog capture can be replicated.
- [ ] Check SMS parity. Apple's [Message UI](https://developer.apple.com/documentation/messageui) provides a user-facing compose screen in which the user can edit, send, or cancel. Investigate whether any public API meets the app's direct-send and incoming-response parsing needs; document the precise limits before selecting an alternative.
- [ ] Check whether Core Telephony exposes the SIM, carrier, and line-selection information each workflow requires. Start with Apple's [Core Telephony reference](https://developer.apple.com/documentation/coretelephony).
- [ ] Check App Store distribution requirements and any carrier/bank agreements needed for the selected approach. Record sources and dates for policy conclusions.

## Porting work to scope after feasibility

- [ ] Separate platform-independent rules (operation definitions, USSD parameter encoding, response formats, validation) from Android-only code. Define Swift-compatible fixtures and offline tests for protocol behavior.
- [ ] Map Android UI and navigation to iOS screens, accessibility, localization, and system permission flows. Inventory agent, banking, wallet, QR/boleto, and e-commerce features separately.
- [ ] Rebuild online flows with `URLSession`, including authentication, session renewal, deep links, and errors. Audit the backend rather than copying the Android client's trust-all TLS behavior. Apple's [App Transport Security](https://developer.apple.com/documentation/BundleResources/Information-Property-List/NSAppTransportSecurity) documents the default HTTPS and trust requirements.
- [ ] Map SQLite/ORMLite entities and preferences to an iOS data model. Plan migration only for data the user can legitimately export or re-enter. Store secrets with [Keychain Services](https://developer.apple.com/documentation/security/keychain-services).
- [ ] Compare all protocol-compatible cryptography with known-answer test vectors. Treat insecure Android schemes as interoperability constraints to assess, not design patterns to copy into new features.
- [ ] Replace Android-specific camera, QR, notifications, background jobs, contacts, files, and app-update flows with supported iOS APIs where each feature is still required.
- [ ] Define a small proof of concept for the highest-risk requirement before committing to a full port: one end-to-end banking or wallet flow using only public iOS APIs and a safe test environment.

## Decision record to fill in

| Feature | Required outcome | iOS evidence / device test | Gap | Decision |
| --- | --- | --- | --- | --- |
| USSD dispatch and response | TODO | TODO | TODO | TODO |
| SMS send and response | TODO | TODO | TODO | TODO |
| Online commerce | TODO | TODO | TODO | TODO |
| Local secrets and data | TODO | TODO | TODO | TODO |
| QR and device integrations | TODO | TODO | TODO | TODO |

**Done when:** The matrix cites current Apple documentation and device tests, names every blocked or user-assisted feature, and yields a scoped iOS implementation plan with explicit parity limits.
