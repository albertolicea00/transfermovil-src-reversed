# Telephony: USSD and SMS

Analysis of USSD and SMS handling in Transfermóvil v1.260416.

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

- `codeAcceso` — access code from `AppConfig.getCodigo()` (ORMLite entity via `unYp8VQThY` singleton), falls back to string resource `0x7f100078`
- `codeService` — operation-specific code
- URI-encoded `#` terminator

### USSD Dispatch Class: `FBsQzP3Zfj`

8898-line static utility class. All USSD dialing goes through here. ~12 overloads:

| Method | Behavior |
|:---|:---|
| `actionCallUSSDBack(ctx, codeService, codeToSend, msg, viewGroup, fm)` | Standard: confirm dialog → dial → auto-back |
| `actionCallUSSDBack(simSlot, ctx, ...)` | Dual-SIM: specifies SIM slot |
| `actionCallUSSDBack(simSlot, ctx, ..., activity)` | With Activity reference for result |
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
6. Text matching chain (all case-insensitive):
   - Contains `"USSD"` → `performGlobalAction(GLOBAL_ACTION_BACK)` + `respondToUssd()`
   - Contains `"si"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
   - Contains `"ok"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
   - Contains `"aceptar"` → BACK + `respondToUssd()` + callback `onUssdReceived()`
7. `respondToUssd()` searches for button labeled `"ACEPTAR"` and clicks it (`ACTION_CLICK`)
8. Callback via singleton `Ax4arraYwv.getInstance().getCallback()` → `TVYvUziTDv.onUssdReceived()`
9. App broadcasts `STOP_LISTENING` when done

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

## USSD Codes Found in Binary

| Code | Likely Purpose |
|:---|:---|
| `*100*` | Balance inquiry (standard ETECSA) |
| `*111` | Customer service / info line |
| `*133` | Service code (likely bonus/promo related) |
| `*222` | Base prefix for Transfermóvil banking operations |
| `*222*264` | Banking operation (specific service) |
| `*222*266` | Banking operation (specific service) |
| `*222*328` | Banking operation (specific service) |
| `*222*767` | Banking operation (specific service) |
| `*222*869` | Banking operation (specific service) |
| `*234*3` | Additional service code |

> **Note:** USSD codes like `*222*NNN` typically encode operations as `*prefix*operation_code*params#`. The exact parameter format (account numbers, PINs, amounts) requires JADX decompilation of the code constructing these strings.

### USSD Code Number Mapping (Hypothesis)

The numbers after `*222*` may map to operations via alphanumeric phone keypad encoding:
- 264 → likely "BNK" or similar
- 266 → could map to "BON" (bonus)
- 328 → could map to "FAC" (factura/invoice) or "DAT" (datos)
- 767 → could map to "POS" or "SOS"
- 869 → could map to "TOW" or similar

This is speculative — requires code-level confirmation.

## SMS Mechanism

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

`READ_PHONE_STATE` permission enables SIM detection. On dual-SIM devices, the app likely allows selecting which SIM to use for USSD/SMS operations. Requires decompiled code to confirm SIM selection UI and logic.

## Key Class Map

| Obfuscated Name | Role |
|:---|:---|
| `S9ycHcoxAzy` | **Agent mode main activity** — extends `rDEl7rW1aN`, has drawer, FABs, QR, SMS receiver field |
| `IHVTCBmiLV` | **General mode main activity** — extends `rDEl7rW1aN`, same layout, no SMS receiver field |
| `rDEl7rW1aN` | Base activity — USSD dialing, SMS extraction, encryption, code construction |
| `FBsQzP3Zfj` | **USSD dispatch class** — 12 `actionCallUSSD*` overloads, dialog management, fragment navigation |
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
4. **Error handling:** How does the app handle USSD timeouts, malformed responses, or accessibility service unavailability?
5. **SIM selection:** Is there explicit dual-SIM handling, or does it rely on the system default?
6. **Code encoder details:** What does `Tz34gww2TFwrsuT8ukpL.aSHV52SplNh3HfZBSmJe()` actually compute from the binary lookup table?
7. **AppConfig access code:** What is the default access code (string resource `0x7f100078`)?
