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

USSD codes sent via `CALL_PHONE` intent. String analysis reveals these code-related identifiers:

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

The accessibility service (`l08fNVC4KOKK...O7xyZJJBFWg`) is configured to:

- **Monitor package:** `com.android.phone`
- **Event types:** All (`0xffffffff`)
- **Feedback type:** Spoken (0x1)
- **Flags:** `DEFAULT` (0x1)
- **Can retrieve window content:** `true`

**How it works:** When the phone app shows a USSD response dialog, the accessibility service reads the dialog text content. This is the standard pattern for USSD automation on Android, since there is no public API to programmatically read USSD responses on most SDK levels. The service intercepts `TYPE_WINDOW_STATE_CHANGED` and similar events from `com.android.phone`, extracts the response text, and routes it back to the app for parsing.

> **Hypothesis:** The settings activity reference `MainGeneralActivity` in the accessibility config likely doesn't exist as declared — this is an alias or obfuscated mapping. Needs JADX decompilation to confirm.

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

### Sending

Operations under "Servicios SMS" in the general drawer menu. Banking operations also use SMS as a transport. Relevant string patterns:

- `consultar_plan_sms` — query SMS plan
- `Servicios SMS` — SMS services menu section

### Receiving

**Broadcast receiver** `X9ZiE8XZNKy` — **stub/no-op in current build:**

- Listens for `android.provider.Telephony.SMS_RECEIVED`
- Requires `android.permission.BROADCAST_SMS` sender permission
- Exported — receives system SMS broadcasts
- `onReceive()`: stores context, logs `"SMS_IN" → "ok"`, returns immediately
- Does **not** call `getMessagesFromIntent()`, extract sender/body, or forward data
- Contains dead code `displayAlert(String)` that shows an AlertDialog titled "Nuevo mensaje" — never called from `onReceive`
- Fields: `ACTION = "android.provider.Telephony.SMS_RECEIVED"` (set in constructor, never read), `myContext` (stored, unused)

**Implication:** Real SMS processing happens elsewhere. Likely candidates:
1. **Dynamic receiver** — app declares `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`, suggesting runtime-registered BroadcastReceivers
2. **ContentResolver polling** — read SMS via content provider after USSD/SMS operations complete
3. The manifest registration may serve to hold the SMS permission grant or ensure app wakes on SMS arrival

## Multi-Step Operation Flow (Hypothesis)

Based on the `sendNextUssd` / `nextUssdCode` pattern, banking operations likely follow this flow:

```
1. User selects operation (e.g., transfer)
2. App constructs USSD code: *222*<operation>*<params>#
3. sendDataUSSD → dials code via CALL_PHONE intent
4. Accessibility service intercepts USSD response dialog
5. App parses response text
6. If multi-step: sendNextUssd constructs follow-up code
7. Repeat until operation complete or error
```

This matches ETECSA's menu-driven USSD banking system where each response may require further input.

## SIM Selection

`READ_PHONE_STATE` permission enables SIM detection. On dual-SIM devices, the app likely allows selecting which SIM to use for USSD/SMS operations. Requires decompiled code to confirm SIM selection UI and logic.

## Open Questions

1. **USSD code parameter format:** How are account numbers, PINs, and amounts encoded in the USSD string?
2. **Response parsing:** What patterns does the accessibility service use to extract data from USSD response dialogs?
3. **SMS format:** What is the structure of outgoing and incoming SMS for banking operations?
4. **Error handling:** How does the app handle USSD timeouts, malformed responses, or accessibility service unavailability?
5. **SIM selection:** Is there explicit dual-SIM handling, or does it rely on the system default?
