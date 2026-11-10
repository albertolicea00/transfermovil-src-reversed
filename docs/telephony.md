# Telephony: USSD and SMS

Analysis of USSD and SMS handling in Transfermóvil v1.260416.

The clean `sms/SmsSender` is a source-linked implementation of
`HzjedYqYeh`: it preserves `SmsManager.sendTextMessage`, the `SENDTO` fallback
when `SEND_SMS` is missing, the success/failure toast behavior, and inbox
filtering by exact sender `PAGOxMOVIL`. The source and clean version both return
before closing the cursor when the body column is absent or the inbox is empty;
they also assume the query returns a non-null cursor. This parity note does not
cover runtime permission or provider behavior.

## SMS import pipeline coverage

The raw `g0xM9kQCsqu` parser is about 1,830 lines. The clean `sms/SmsParser`
contains getters, regex/date helpers, app-data extraction, Cubacel plan-catalog
persistence, fuel coupon parsing, wallet-currency refresh, and agent
telecom-wallet confirmation parsing. Fuel parsing preserves
coupon confirmations, status/token updates, coupon-list updates, and ticket
persistence through the clean `TransportTicket` entity. Wallet refresh decrypts
the currency list and replaces the `WalletCurrency` rows only after a successful
decrypt and delete, matching the raw parser's sequence.
`FuelSmsImportTask` invokes that parser for each inbox message, matching
`XYfkGsUkKH`.

The SMS parser now includes the transaction, wallet, fuel, ticket-offer,
purchase-confirmation, and app-data methods from `g0xM9kQCsqu`. The main
`SmsParser.parse` routes PAGOxMOVIL transaction and service messages into
records, including same-day promotions and plan-catalog updates. MiBoleto offer
parsing persists offer lists and ticket purchases, applies status/token updates,
and refreshes attraction data from purchase confirmations.
`SmsImportTask` stores parsed records with their inbox timestamp and skips an
existing record with the same transaction ID and service type, matching
`HPuMiTypoW`. `OffersSmsTask` filters inbox messages from the start of the
current day and passes each eligible message to the ticket parser, matching
`DHfGEge8yT`; its source counter is never incremented, so the callback reports
zero new offers. The three clean MiBoleto screens now use this clean task. The
fuel task's UI callback contract matches raw `XYfkGsUkKH`/`Ti8eM28U2E`: visibility `0` in
`onPreExecute`, visibility `4` in `onPostExecute`, followed by
`onCuentasResult(true, 1, "ok")` regardless of the background result. The
two-argument constructor also matches the raw task call used by the ticket
screen. Inbox-read success does not indicate that a message contained a valid
fuel record; unsupported messages can yield an empty record or null.

## QR and barcode scanning

The shared scanner is `OJ3XxacXOT`. It accepts camera input and images selected
from the gallery, and dispatches the decoded text back to the operation form as
the `QRData` argument. Operation and bank arguments determine the destination:
bank transfer forms, business transfers, external payments, coupon top-up,
Voto Móvil, and Caja Extra are among the mapped routes. A generated QR helper
(`ZUoEY89WdA`) also creates and transforms QR bitmaps; that is separate from
scanning.

Scanning has two implementations selected by the `activarMejoraQR` setting:
the newer camera path uses CameraX with ML Kit, with ZXing as a fallback when
decoding a gallery image; the legacy path uses `ZXingScannerView`. Both decode
QR codes. The form which launches the scanner requests camera permission. The
gallery path requests media/read access as needed and accepts `image/*`.
Operation-specific forms remain responsible for interpreting `QRData`; a
successful decode does not itself authorize or submit a payment.

### MiBoleto QR tickets

The MiBoleto management list refreshes offers from SMS received today, shows
stored ticket purchases, and can mark selected purchases consumed. For a ticket
QR, the app decrypts the stored token using the transaction ID and transfer ID
as salt, splits the result into token and PIN, then creates a QR JSON object
with token, PIN, identity number, and optional detail records. If the ticket
contains payable attractions, the user selects one detail for the QR; entries
whose stored value is `0` are omitted. If none remain, the base ticket QR is
shown. This documents the client generation path; server validation of QR
redemption is outside the source examined here.

## Mi Turno appointments

The Wallet exposes four appointment operations. All dispatch through the
confirmation-gated USSD helper; the operation data begins with a bank code and
uses the selected service/identity fields:

| Operation | USSD selector | Data fields passed by the form |
|:---|:---:|:---|
| Reserve appointment | `102` | bank, service, branch DPA, identity number, optional confirmation phone, currency, source account |
| Change reservation date | `105` | bank, service type, identity number, selected date |
| Cancel reservation | `106` | bank, service type, identity number |
| Query reservation | `107` | bank, identity number |

The reservation form loads province/municipality/branch choices and service
catalogs from packaged JSON, and supports selecting a stored or manually
entered account. It warns that a reservation charges a commission and can
optionally submit a notification phone. Help text says the user will receive
an SMS the day before the appointment. The change-date screen limits its date
picker to approximately six months ahead. QR scanning can prefill the identity
number from a decoded identity-card QR; users still review and confirm the
USSD operation.

Packaged catalog files include `provinciasMiTurno.json`, separate gas and
`Gas Balita` province lists, `provincias_servicios_bancos_miturno.json`, and
`sucursales_miturno_servicios.json`. These are static client lookup data; the
appointment submission and reservation state are handled by the USSD service.

## OFA Ciudades Patrimoniales

The MiTransfer wallet's OFA screen (`dWLcK5oQoS`) lets a user choose one of the
five locally listed heritage cities, then a reservation/activity loaded from
the matching city code. It collects identity number, customer type, quantity,
date, currency/price, wallet type, and optionally a contact phone; it computes
the total as unit price times quantity and can include a “send balance” flag.
The price for national or foreign customers is selected from the reservation
record. The date picker starts at today and ends six months ahead, except for
three named HabanaBusTour/shuttle offerings that use the alternate date mode.

After field validation, the app displays a confirmation containing the chosen
reservation, date, and total, plus a link to the OFA terms page. It sends
selector `8` with the fields in their assembled order, through the packetized
USSD path when partial USSD is enabled or the regular confirmation-gated USSD
dispatcher otherwise. Static assets include `ciudadPatrimonial.json` (5 city
records), `reservasOFA.json` (21 reservation records), and supporting
obligation/zone catalogs. These files describe client-side choices; the app
does not establish that every listed reservation is currently available.

## Traffic fines

Bank traffic-fine payment forms use selector `97`. The form validates the fine
identifier, article/inciso (or accepts manually entered article data in edit
mode), province/municipality, date, and source account, then requests
confirmation before sending. Its payload order is fine ID, fixed `0000`,
article, inciso, municipality code, province code, fixed `1`, fine date,
currency, and account. Partial-USSD mode uses the shared packet sender.

The client-side `art_inc_transito.json` lookup contains 95 article records and
430 inciso records. Each inciso includes its article number, description,
inciso number, and a `peligrosidad` value; selecting an article filters this
data into the inciso list. The catalog populates the form and does not replace
server-side fine verification.

## Permissions

| Permission | Purpose |
|:---|:---|
| `CALL_PHONE` | Initiate USSD calls via `tel:` intent |
| `SEND_SMS` | Send SMS for banking/service operations |
| `READ_SMS` | Read incoming SMS (responses) |
| `RECEIVE_SMS` | Receive SMS broadcasts |
| `WRITE_SMS` | Write to SMS provider |
| `READ_PHONE_STATE` | SIM state, phone number, operator |
| `android.hardware.telephony` | Declared as required feature |
| `BIND_ACCESSIBILITY_SERVICE` | Read USSD response dialogs from `com.android.phone` |

## USSD Mechanism

### Sending

USSD codes sent via `ACTION_CALL` intent with `tel:` URI. Confirmed from smali analysis of `rDEl7rW1aN`:

### USSD Code Format

```
tel:*{codeAcceso}*{codeService}#{encoded}
```

- `codeAcceso` — access code from `AppConfig.getCodigo()` (ORMLite entity via `unYp8VQThY` singleton); the resource fallback/default `codigoAcceso` (`0x7f100078`) is `444`
- `codeService` — operation-specific code
- URI-encoded `#` terminator

### USSD Dispatch Class: `FBsQzP3Zfj`

Static utility used directly by reconstructed screens and `OperationsGridAdapter`;
the mapped clean `UssdDispatcher` shell was an unused `Activity` with no-op
methods, so it has been removed. USSD dialing and operation routing still call
the tracked raw `FBsQzP3Zfj` from forms and the operation grid.
`BaseMainActivity` contains separate direct-dial overloads. A clean migration
of the helper remains pending. The active raw utility exposes these overloads:

| Method | Behavior |
|:---|:---|
| `actionCallUSSDBack(ctx, codeService, codeToSend, msg, viewGroup, fm)` | Standard: confirm dialog → dial → auto-back |
| `actionCallUSSDBack(bankCode, ctx, ...)` | Persists the bank code and authentication timestamp, then dials |
| `actionCallUSSDBack(bankCode, ctx, ..., activity)` | Also refreshes the matching main activity's menu |
| `actionCallUSSDBack454(ctx, ...)` | Variant for specific operation (454) |
| `actionCallUSSDBackAsocClasica(ctx, ..., observer)` | With observer callback (association) |
| `actionCallUSSDBackHttp(ctx, ..., SpannableString)` | HTTP-style styled message |
| `actionCallUSSDBackObserver(ctx, ..., observer)` | Generic observer-pattern callback |
| `actionCallUSSDBackWithRetun(ctx, ...)` | With return value |
| `actionCallUSSDNOBack(ctx, activity, ...)` | No auto-back action |
| `actionCallUSSDNoBackSimple(ctx, ...)` | Simple no-back |
| `actionCallUSSDSimple(ctx, code, msg)` | Minimal: no view group, no fragment |
| `callLenght(ctx, code)` | Returns USSD code length (validation) |

Full USSD string construction (from `actionCallUSSDBack`):

```
tel:*{codigo}*{codeService}*{codeSendTo}*{number}#
```

- `codigo` = `AppConfig.getCodigo()` — access code from registration
- `codeService` = operation identifier passed by caller
- `codeSendTo` = processed via `rDEl7rW1aN.code()` (may encode/transform)
- `number` = `AppConfig.getNumber()` — app version/identifier
- `#` is URI-encoded

All overloads show a confirmation dialog ("Confirmar"/"Cancelar") before dialing, except `actionCallUSSDSimple` which may dial directly.

Also contains: `closeSessionBank()`, `getDialogOperation()`, `getBundleOperation()`, `goToFragment()`, fragment navigation, and survey/evaluation UI.

### USSD Code Obfuscation (`code()` method)

The `code(String)` method (745 lines) transforms USSD parameters before dialing:

1. Splits input on `*`
2. Separates numeric parts from non-numeric (e.g., Nauta email addresses)
3. Uses `Tz34gww2TFwrsuT8ukpL` with hardcoded `code_version` and `crude_code` to encode numbers
4. Pads single-digit encoded numbers with leading `"0"`

**Hardcoded constants:**
- `code_version = "372653282298718711"`
- `crude_code` = 1024-character binary string (lookup table for numeric encoding)

### String identifiers found

- `sendDataUSSD` — primary USSD send function
- `sendNextUssd` — sequential USSD code sending (multi-step operations)
- `nextUssdCode` — queued next code
- `sendUssdTest` — test/debug USSD sender
- `showSendUSSD` — UI for USSD sending
- `swEnviarUssd` — switch/toggle for USSD sending
- `isUssdDialog` — flag for USSD dialog state
- `version_ussd` — USSD protocol version tracking
- `articuloUSSD` — USSD article/item reference
- `ussdReceiver` — USSD response receiver

### Receiving (Accessibility Service)

The accessibility service (`l08fNVC4KOKK...O7xyZJJBFWg`) extends `AccessibilityService`. Smali analysis confirms:

**Configuration** (set programmatically in `onServiceConnected`):

- **Monitor package:** `com.android.phone`
- **Event types:** `0x20` (`TYPE_WINDOW_STATE_CHANGED`)
- **Feedback type:** `0x10` (`FEEDBACK_GENERIC`)
- **Flags:** `0x1` (`FLAG_INCLUDE_NOT_IMPORTANT_VIEWS`)

**Control flow:**

1. App broadcasts `START_LISTENING` → service's inner `BroadcastReceiver` ($1) sets `shouldListen = true`
2. App dials USSD via `tel:` intent
3. Phone app shows USSD response dialog → `onAccessibilityEvent` fires
4. Service checks `shouldListen == true` AND `eventType == 0x20`
5. Extracts event text via `getText()`
6. Text matching chain (the `USSD` check is case-sensitive; the others lowercase the text):
   - Contains `"USSD"` → `performGlobalAction(GLOBAL_ACTION_BACK)` + `respondToUssd()`
   - Contains `"si"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
   - Contains `"ok"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
   - Contains `"aceptar"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
7. `respondToUssd()` searches for button labeled `"ACEPTAR"` and clicks it (`ACTION_CLICK`)
8. Callback via singleton `Ax4arraYwv.getInstance().getCallback()` → `TVYvUziTDv.onUssdReceived()`
9. App broadcasts `STOP_LISTENING` when done

The service and its callback/checker helpers now have complete clean counterparts
under `app/src/main/java/cu/etecsa/transfermovil/service/`. The exact original
service path is `l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.O7xyZJJBFWg`.
`make test-reconstruction` compares 240 event/control scenarios and five service
enablement scenarios against the original Java, using a simulated Android API.
The same harness checks the SMS receiver entry point and alert behavior. These
checks do not enable accessibility, dial USSD, or send SMS on a device.

**Key classes:**

| Class | Role |
|:---|:---|
| `O7xyZJJBFWg` | AccessibilityService implementation |
| `O7xyZJJBFWg$1` | BroadcastReceiver for START/STOP_LISTENING |
| `O7xyZJJBFWg$2` | Cancel button click handler (dialog) |
| `O7xyZJJBFWg$3` | "Ir a Configuración" click → opens accessibility settings |
| `Ax4arraYwv` | Singleton holding callback reference |
| `TVYvUziTDv` | Interface with `onUssdReceived()` method |
| `w9YDCnqpz8I` | Utility with `isAccessibilityServiceEnabled(context, class)` |

**User-facing dialog** (`showAccessibilityServiceDialog`): Shows Spanish AlertDialog asking permission — "Para que esta aplicación funcione correctamente, necesitas activar el servicio de accesibilidad. Esto nos permitirá interactuar con las ventanas de USSD."

> **Security note:** The service auto-clicks "ACEPTAR" on any USSD dialog from `com.android.phone`. No validation of dialog source or content. Any USSD prompt that contains "si", "ok", or "aceptar" in its text gets auto-dismissed.

## USSD Codes (Confirmed from Java Decompilation)

Two USSD gateways are used: `*222` (Transfermóvil/Metropolitano/BPA/Wallet) and `*444` (BANDEC).

### BANDEC (`*444` prefix)

| Code | Operation | Confirmation Message |
|:---|:---|:---|
| `*444*3` | Generic query | "¿Desea realizar la consulta?" |
| `*444*13` | Auth/Register | (dynamic) |
| `*444*15` | Transfer | (dynamic) |
| `*444*16` | Electricity payment | (dynamic) |
| `*444*46` | **Balance inquiry** | "¿Desea consultar el saldo de su tarjeta?" |
| `*444*48` | Last operations | "¿Desea ver las últimas operaciones?" |
| `*444*58` | All account balances | "¿Desea consultar el importe de todas sus cuentas?" |
| `*444*62` | Transaction limits | "¿Desea consultar los límites de sus cuentas bancarias?" |
| `*444*68*02` | Delete registration | "¿Desea eliminar registro asociado?" |
| `*444*70` | Close session | (dynamic) |
| `*444*91` | PIN change | (dynamic) |

### Transfermóvil (`*222` prefix)

| Code | Inferred Operation |
|:---|:---|
| `*222` | Base service selector |
| `*222*264` | Metropolitano/BPA banking |
| `*222*266` | Bonus/wallet operation |

### Cubacel bonus flows (static source evidence)

The general-mode **Seguridad** menu in `LALCrDPvhM` exposes “Consultar estado del bono” as its fifth row (zero-based position 4). After confirmation, `showSendUSSD("222", "266", ...)` constructs `tel:*222*266%23` and launches `ACTION_CALL`. This is a carrier query; the client does not parse a returned balance or define bonus expiry rules.

The same menu routes “Gestión de planes” separately to `*133#`, and data, voice, SMS, and Amigos plan queries to `*222*328#`, `*222*869#`, `*222*767#`, and `*222*264#`. They should not be conflated with the bonus-status query.

The menu's first recarga action opens `b0kkzvOCEu`, which requires a nonblank bonus key, allows scanning a QR code tagged as `Recarga_Cupon` for ETECSA, then dispatches `662*<key>` through the activity's USSD handler with a confirmation message. Static code establishes the client-side key validation and request construction only; it does not reveal the carrier's bonus accounting, eligibility, or response semantics. Source evidence: `LALCrDPvhM`, `b0kkzvOCEu`, and `ICmtk949Og`.

The other actions in the same three-row bonus/recharge menu (`ICmtk949Og`) are balance transfer and recharge-key change. `C8l2t8799rL` validates an 8-character phone, a 4-character PIN, and a nonempty integer amount, then confirms and dispatches `<phone>*<PIN>*<amount>` with `*234*1`. `E1lhoLKryWP` dispatches `<new-key>*<repeated-key>` with `*234*2`; it intends to require four characters in each field, but both length checks read the new-key field, leaving the repeated field's length unchecked. Neither form persists the values in the inspected code. The source-confirmed templates and branch references are in the [USSD catalog](ussd-code-catalog.md#confirmed-banking-entries-initial-subset).
| `*222*328` | Data/invoice operation |
| `*222*767` | Service operation |
| `*222*869` | Service operation |

### Other

| Code | Purpose |
|:---|:---|
| `*100*` | ETECSA balance inquiry (standard) |
| `*111` | Customer service / info line |
| `*133` | Bonus/promo service |
| `*234*3` | Additional service |

### USSD Packet Protocol (`pAzq93vIl3`)

Full USSD code format per packet:

```
*<codeAcceso>*<codeService>*<banderaEmpaquetado>*<codeOper>*<agency>*<encoded_params>*<version>#
```

| Field | Source | Description |
|:---|:---|:---|
| `codeAcceso` | `AppConfig.getCodigo()` | Registration access code |
| `codeService` | Caller (e.g., `*222`) | Service prefix |
| `banderaEmpaquetado` | Generated | `<pos><max>*<secuencia>` — 2-digit zero-padded position + total + sequence ID |
| `codeOper` | Caller (e.g., `264`) | Operation number |
| `agency` | Agent code or empty | Agent identifier (empty for general users) |
| `encoded_params` | `rDEl7rW1aN.code()` | Encoded parameters (PINs, amounts, accounts) |
| `version` | `AppConfig.getNumber()` | App version/identifier |

**Packet splitting:** Parameters split by `*` delimiter. `MAX_PARAMETERS_TOTAL` = 52 chars. `MAX_PARAMETERS_TO_PACKAGE` = 6 (default, configurable). If payload exceeds limit → split into multiple USSD calls with position/total/sequence metadata.

**Sequence ID generation:**
- SDK < 26: `generarSecuenciaBasica()` → `mmss` (minutes + seconds)
- SDK ≥ 26: `generarSecuencia()` → `dMHHmss` + last year digit + random 0-9

**Two execution paths based on SDK level:**

| SDK | Method | Mechanism |
|:---|:---|:---|
| ≥ 26 (Android 8+) | `MX9gh9mLxd` (UssdHelper) | `TelephonyManager.sendUssdRequest()` with callback listener |
| < 26 | Accessibility service | `START_LISTENING` broadcast → `sendDataUSSD(0)` → accessibility reads response → `onUssdReceived()` → sends next packet |

**Declared constant:** `MAX_FALLAS_USSD` = 3; source search found no use of this field, so it does not implement retries.

### Numeric Parameter Encoding

`BaseMainActivity.code()` (original `rDEl7rW1aN.code()`) uses a random integer from 0 through 99 as a two-digit prefix. `crude_code` is parsed into 128 byte values: each successive 8-bit chunk starts at an offset selected by cycling through the digits of `code_version` (`372653282298718711`).

Each numeric field is transformed in two steps:

1. Pairs of digits index the byte table; each result is formatted as two digits. For an odd-length field, the last digit uses a ten-entry map drawn from table values below 10.
2. The substituted decimal value is XORed as a `long` with a decimal key string made by cycling through table values beginning at the random seed, then truncating the key string to the substituted value's length.

Fields containing non-digits use `NautaCodeEncoder.getCodes()` and the character dictionary. Mixed inputs keep numeric and Nauta fields in their original order. The output includes a two-digit original-length prefix for every field; the legacy all-numeric format joins the first two length/value pairs without `*`, while mixed fields use `*` separators. A nonnumeric-only input uses `00` in place of the random seed. Unknown Nauta characters stringify as `null` in `getCodes()`; this behavior is preserved from source.

This is deterministic-obfuscation with a random per-call seed, not authenticated encryption: the version, lookup table, substitution, and XOR operations are all present in the client. The current clean reconstruction is compared against the original for numeric, odd/even length, mixed, and Nauta cases with a fixed test seed.

### USSD Failure and Timeout Behavior

The app has two distinct request paths, and neither schedules an app-level timeout:

- On Android 8+ (`MX9gh9mLxd`), `TelephonyManager.sendUssdRequest()` reports failures through `onReceiveUssdResponseFailed`. The multipart sender forwards the platform `failureCode` to `onUssdError`, emits a failed progress result with code `3`, closes its progress UI, and returns to the previous fragment. A successful response advances only when its text contains the exact substring `siendo procesada,`; any other response is treated as a part failure and stops the sequence. No retry is attempted in that callback.
- The pre-Android-8 accessibility path (`pAzq93vIl3`) advances only after the registered callback receives an accessibility event. Missing `CALL_PHONE` permission returns without dispatching the call. If the accessibility service is unavailable, automatic sending shows a permission toast and stops. No timer detects a response that never arrives.
- `MAX_FALLAS_USSD` is initialized to `3`, but the reconstructed source has no reads of this field and does not implement three retries. The callback helper `WV9lIl58Oa` logs a platform failure but does not notify its caller; its success callback sends the optional next request regardless of response text.
- `O7xyZJJBFWg` listens while `shouldListen` is true and handles `TYPE_WINDOW_STATE_CHANGED` events from `com.android.phone` only when text contains `USSD`, `si`, `ok`, or `aceptar`. Other text or no event receives no app-level error or timeout callback.

### SIM Routing

No explicit SIM/subscription selection was found in the inspected source. The newer helpers obtain the default `TelephonyManager` with `getSystemService("phone")`; the older paths start `ACTION_CALL` with a `tel:` URI. Searches found no `SubscriptionManager`, subscription-specific manager, or phone-account selection call in the tracked app source. SIM routing is therefore left to Android, carrier, and device default behavior; the app provides no SIM picker in these paths.

### USSD Code Number Mapping (Hypothesis)

The numbers after `*222*` may map to operations via alphanumeric phone keypad encoding:
- 264 → likely "BNK" or similar
- 266 → could map to "BON" (bonus)
- 328 → could map to "FAC" (factura/invoice) or "DAT" (datos)
- 767 → could map to "POS" or "SOS"
- 869 → could map to "TOW" or similar

This is speculative — requires code-level confirmation.

## SMS Mechanism

### SMS vs USSD operation classification

A static scan of the tracked JADX Java sources found two UI call sites for the
shared outbound `send_sms()` helper:

| Flow | Destination | Transport |
|:---|:---|:---|
| General “Servicios SMS” menu | `2266` with `OFERTA`, `TARIFA`, `PLANES`, or `AMIGOS` | SMS, after confirmation |
| Voto Móvil | `2899` or `3099` with the user-entered/QR-prefilled text | SMS, after confirmation |

The useful-number menu uses `ACTION_CALL` to telephone numbers, not SMS.
Banking and wallet forms inspected in this tree use the USSD dispatcher, which
constructs `tel:` requests; their SMS role is mainly receiving and parsing the
service responses. This classification is based on source call sites and does
not claim that no remote or dynamically loaded code can add other paths.

### Contact lookup for transfers

The General account-transfer form requests `READ_CONTACTS` when needed, opens
the Android contact picker, and queries the selected contact's phone rows for
`data2 = 2`. It removes spaces and a leading `+`, removes one leading `0`, and
strips the `53` country prefix from 10-digit numbers beginning `535` or `536`.
Before dispatch, the form accepts an empty optional recipient phone or exactly
eight digits. Contact import only fills that recipient-phone field; the user
still supplies the 16-digit destination account and amount and confirms USSD
selector `45`.

### Voto Móvil

The General-mode sender form (`XRa1KuZNBW`) offers the channel sender numbers
`2899` and `3099` (labels come from `array_voto`). The user enters a message
and confirms before `HzjedYqYeh.send_sms()` sends it; the shared SMS helper then
uses direct `SmsManager` delivery when permission is granted or opens the SMS
app otherwise.

The QR scanner is launched with operation `VotoMovil`. The form recognizes a
`QRData` value identifying `VOTOMOVIL`, uses it to select a sender and
prepopulate the message, then still requires the user to submit and confirm.
The scanner-side parser expects JSON with `type: "VOTOMOVIL"` and a `data`
object containing `canalId` and `texto`; it matches the channel name against
the channel list. The older form-side parser also accepts the legacy
comma-separated payload after the `VOTOMOVIL` prefix, so the accepted shape
depends on which QR route supplies the argument.

`app/assets/canales_votomovil.json` defines 20 channels: free-coded entries
`L1`–`L10` (IDs 1–10, `esDePago: 0`) and paid-coded entries `P21`–`P30`
(IDs 21–30, `esDePago: 1`). This flag is catalog metadata; the inspected form
does not itself charge or validate payment.

The MiTransfer `BOLSAVotoMovil` destination (`cdINOtQ3iN`) is a separate
channel-and-wallet form. It validates a required 1–12 character text made only
of letters/digits, with no spaces or special characters, then sends
`<channel-id>*<text>*<wallet-type>` under service selector `215`. It uses
`actionCallUSSDBack454`: the helper transforms the payload with `rDEl7rW1aN`
and asks for confirmation before dialing the `*454*...#` request. This flow
has no partial-USSD branch in the inspected form. Paid-channel selection also
requires a wallet marker; the source UI route now opens this migrated form.

### Useful phone numbers

The General drawer's `tel_utiles` destination (`s9lZwtvq9Dl`) renders five
rows. Selecting one immediately launches `ACTION_CALL` to the listed number:

| Row | Number | Service label |
|:---|:---:|:---|
| 1 | `104` | Ambulance |
| 2 | `105` | Fire service |
| 3 | `106` | PNR / police |
| 4 | `107` | Maritime rescue |
| 5 | `103` | Anti-drug service |

No confirmation dialog appears in this fragment's click handler; the device
must permit the call intent.

### General-mode “Servicios SMS” menu

The General drawer routes `servicios` to `BktkqFBOIQ`. Its four rows ask for
confirmation, then call `HzjedYqYeh.send_sms("2266", body, context)`:

| Menu row | SMS body | Confirmation prompt |
| --- | --- | --- |
| Ofertas ETECSA | `OFERTA` | Resource `msg_confirm_send_sms_ofertas` |
| Tarifas | `TARIFA` | Resource `msg_confirm_send_sms_tarifas` |
| Oferta Planes | `PLANES` | Offers for Nauta, SMS, and voice plans |
| Ofertas Amigos | `AMIGOS` | Offers for Plan Amigos |

These four drawer actions are SMS-based, not USSD. The menu does not send until
the user confirms; actual sending follows the shared `send_sms` permission and
fallback behavior documented below. This is a mapping of this menu only, not a
classification of every app operation.

### Sending (`HzjedYqYeh.send_sms`)

Static method `send_sms(String number, String body_text, Context context)`:

1. Checks `SEND_SMS` permission via `ContextCompat.checkSelfPermission`
2. **If no permission:** falls back to `ACTION_SENDTO` intent (`smsto:{number}`) with `sms_body` extra — opens default SMS app
3. **If has permission:** uses `SmsManager.getDefault().sendTextMessage(number, null, body, null, null)` — sends directly, no delivery/sent callbacks
4. Shows toast: "SMS enviado. espere un SMS de respuesta" (SMS sent, wait for a reply SMS)
5. On exception: shows "Ha ocurrido un error. SMS no enviado"

Also has `readSmsInbox(ContentResolver)` returning `ArrayList<rIgmgP6JXL>` — reads SMS inbox via content provider.

### Receiving

**Manifest receiver** `X9ZiE8XZNKy` — **stub/no-op in current build.** `onReceive()` just logs `"SMS_IN" → "ok"` and returns.

**Dynamic receiver** in `rDEl7rW1aN` — field `mReceivedSMSReceiver` (inner class `$18`) is a runtime-registered `BroadcastReceiver` for incoming SMS processing.

### SMS Response Parsing (`g0xM9kQCsqu`)

13,840-line parser class. `parse(rIgmgP6JXL) → RecordSMS` is the main entry (~6,200 lines of if/else chain).

**Gateway sender ID**: `"PAGOxMOVIL"` — all bank/service responses arrive from this sender.

**Parsing strategy**: pattern-matches Spanish-language SMS body against templates, then extracts fields by positional split indices (split on spaces, hardcoded indices for amount, currency, account, etc.).

**32 recognized service types**:

| Category | Services |
|:---|:---|
| Recargas | Recarga Movil, Recarga Nauta, Recarga Propia, Recarga de Saldo Movil, Recarga nauta banco, Recarga Nauta MLC, Recarga Nauta Hogar 4G, Recarga CUP Monedero |
| Pagos | Pago Factura, Pago Electricidad, Pago Agua, Pago Gas, Pago ONAT, Pago de Multa, Pago Telefono(P), Pago Telefono(T) |
| Transferencias | Transferencia, Giro postal |
| Otros | Combustible, Amortizar, Aporte Patrimonio, Caja Extra, Compra en linea, Compra Mi Boleto, Sello de Timbre, Nauta Hogar, Gigas Nauta Hogar 4G, Paquete MLC, Mi Turno, Joven Club, Factura Telefonica, Visitas-Recorridos |

**Keyword matching examples**:
- "La recarga se realizo con exito" → Recarga type
- "El pago de la factura" → Pago type
- "La Transferencia" → Transferencia
- "Giro Postal" → Giro postal
- "PIN de combustible" → Combustible
- "INFORMACION:" → Promotional (classified by bank: BPA, Bandec, Metropolitano, ETECSA)

**Activation SMS parsing** (`parse_fill_sms_data`): Handles "Bienvenido al sistema TRANSFERMOVIL" welcome SMS. Extracts by positional index: phone number (index 6), version (index 10), and module-specific activation codes (bank, agent, bulevar, boleto).

**Validated currencies**: CUP, CUC, USD, MLC (enforced in `RecordSMS.setMoneda`)

### SMS Code Extraction

`rDEl7rW1aN` has methods to extract activation/auth codes from received SMS via `ContentResolver`:

| Method | Purpose |
|:---|:---|
| `sms_code_bank(ContentResolver)` | Extract bank activation code from SMS |
| `sms_code_agente(ContentResolver)` | Extract agent code from SMS |
| `sms_code_boleto(ContentResolver)` | Extract boleto code from SMS |
| `sms_code_bulevar(ContentResolver)` | Extract bulevar code from SMS |
| `sms_actualizar_bd(ContentResolver)` | Update local DB from SMS data |
| `sms_actualizar_bd_datos_app(ContentResolver)` | Update app config data from SMS |

## Confirmed Operation Flow

```
1. User selects operation (e.g., transfer)
2. App broadcasts START_LISTENING → accessibility service activates
3. code() encodes parameters using crude_code binary lookup table
4. actionCallUSSD() builds: tel:*{access}*{encoded_params}#
5. ACTION_CALL intent dials USSD
6. Phone shows USSD dialog → accessibility service fires
7. Service checks text for "USSD"/"si"/"ok"/"aceptar"
8. Auto-clicks "ACEPTAR" button, presses BACK
9. Calls TVYvUziTDv.onUssdReceived() callback
10. If multi-step: sendNextUssd constructs follow-up code
11. App broadcasts STOP_LISTENING when done
```

## SIM Selection

`READ_PHONE_STATE` is declared, but no SIM-selection UI or subscription-specific USSD/SMS calls were found in the inspected app sources; see [SIM Routing](#sim-routing).

## Key Class Map

| Obfuscated Name | Role |
|:---|:---|
| `S9ycHcoxAzy` | **General mode main activity** — extends `rDEl7rW1aN`, uses `drawermenu_general`, has SMS receiver field |
| `IHVTCBmiLV` | **Agent mode main activity** — extends `rDEl7rW1aN`, uses `drawermenu` (full agent menu) |
| `prPzLeyxKk` | **Splash/router activity** — 3s splash, `generalVsAgentVersion()` decides which main activity to launch |
| `rDEl7rW1aN` | Base activity — USSD dialing, SMS extraction, encryption, code construction |
| `FBsQzP3Zfj` | Raw USSD utility — `actionCallUSSD*` overloads, dialog management, fragment navigation; still called directly |
| `HzjedYqYeh` | SMS sender (`send_sms` static) + inbox reader |
| `O7xyZJJBFWg` | Accessibility service for USSD response capture |
| `Ax4arraYwv` | Singleton callback holder for USSD responses |
| `TVYvUziTDv` | Callback interface (`onUssdReceived()`) |
| `Tz34gww2TFwrsuT8ukpL` | USSD code encoder (uses `code_version` + `crude_code`) |
| `unYp8VQThY` | AppConfig singleton/DB helper (holds access code, DAOs) |
| `X9ZiE8XZNKy` | Manifest SMS receiver (stub) |
| `rDEl7rW1aN$18` | Dynamic SMS receiver (runtime-registered) |
| `g0xM9kQCsqu` | SMS parser — `parse(rIgmgP6JXL)` → `RecordSMS` |
| `rIgmgP6JXL` | SMS data object (raw message container) |

## Open Questions

1. ~~USSD code parameter format~~ — **Answered:** encoded via `code()` with binary lookup table
2. ~~Response parsing~~ — **Answered:** accessibility service matches text for "USSD"/"si"/"ok"/"aceptar"
3. **SMS format:** What is the structure of outgoing and incoming SMS for banking operations?
4. ~~**Error handling:** How does the app handle USSD timeouts, malformed responses, or accessibility service unavailability?~~ — **Answered:** no app-level timeout; API failures and response parsing differ by path, and the accessibility path can wait without a timeout callback.
5. ~~**SIM selection:** Is there explicit dual-SIM handling, or does it rely on the system default?~~ — **Answered:** no explicit subscription selection found; requests use the default telephony service or a `tel:` call intent.
6. ~~**Code encoder details:** What does `Tz34gww2TFwrsuT8ukpL.aSHV52SplNh3HfZBSmJe()` actually compute from the binary lookup table?~~ — **Answered:** it seeds the per-field substitution/XOR encoder with an integer 0–99 and returns the seed followed by encoded numeric fields; see [Numeric Parameter Encoding](#numeric-parameter-encoding).
7. ~~**AppConfig access code:** What is the default access code (string resource `0x7f100078`)?~~ — **Answered:** `codigoAcceso` is `444`; the database helper uses it when creating or upgrading `AppConfig`.
