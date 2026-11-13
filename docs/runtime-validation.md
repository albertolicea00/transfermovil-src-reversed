# Local Android runtime validation

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

## Scope and artifact

On 2026-11-13, the clean Java tree was compiled against the target APK's converted bytecode jar and Android SDK 36, converted to DEX with Android build-tools 36.0.0, then added to a resource-rebuilt copy of the target APK. The resulting locally signed research artifact was `.workspace/transfermovil-hybrid-research.apk` (SHA-256 `a6cab617c8c42fe3ea27815a383cfa19a3d6f4cbcca1b337a666069d458e1393`). Its original DEX and dependencies remain present; this is a hybrid runtime probe, not an independently rebuilt or redistributable application. `.workspace/` artifacts and captured user-interface/log files are local and ignored.

The test used a separate read-only Android 16/API 36 AVD on `emulator-5582`; no physical device or other running emulator was modified. Wi-Fi and mobile data were disabled. `CALL_PHONE` and `READ_SMS` were granted to pass the app's startup gate, while `CALL_PHONE` and `SEND_SMS` app operations were blocked. No credentials, payment confirmations, SMS, USSD, or live API requests were submitted.

## Observed results

- The clean launcher alias reached `cu.etecsa.transfermovil.ui.GeneralMainActivity` on a warm launch. The initial cold launch encountered a system input-focus ANR at the permission handoff; after permissions were configured and the app restarted, the clean activity resumed. This first ANR is retained as an environment/runtime observation, not classified as a source defect.
- The main screen showed the same visible operation labels in the same grid positions as the original APK capture, including registration, authentication, balance, recent operations, cash transfer, and telecom services.
- The registration screen displayed identity and PIN fields. The authentication screen displayed a PIN field. Neither form was submitted. No fatal Java exception or `ClassCastException` appeared in the captured logcat during these screens.
- Captures are in `.workspace/runtime-validation/`: `original-grid.xml`, `hybrid-grid.xml`, `hybrid-register.xml`, `hybrid-login.xml`, corresponding activity snapshots, and logcat files. These are local evidence, not tracked fixtures.

## Reproduction outline

1. Run `scripts/compile-reconstruction.py` with the target-derived bytecode jar and local Android `android.jar` as documented in [Java compilation](java-compilation.md). The resulting run directory contains compiled clean classes.
2. Package those classes into a jar, run Android build-tools `d8 --min-api 21 --lib <android.jar> --classpath <target-bytecode.jar>`, and append its DEX as `classes3.dex` to a resource rebuild of the decoded target APK. Keep the target DEX files and dependencies intact.
3. Align and locally sign the scratch APK, install only on a dedicated disposable AVD, disable radios, and block carrier-related app operations. Do not use a personal device or an emulator containing unrelated user data.
4. Capture the original and hybrid hierarchy using `uiautomator dump`; confirm the XML root package before comparing labels or bounds. Capture logcat around each screen transition. The exact local build commands and intermediate inputs are recorded in shell history and ignored `.workspace/` artifacts for this run.

## Remaining runtime gaps

Authenticated login, account-backed navigation, backend traffic, registration submission, transaction flows, and carrier execution remain unverified. The manifest's deep-link route converts transaction query parameters and can proceed into payment handling, so it was not invoked without a safe inert harness. The existing offline dispatcher tests do not substitute for Android integration or provider validation. The hybrid package's original dependencies also mean successful activity launch does not establish standalone buildability.
