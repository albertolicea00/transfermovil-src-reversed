# MiTransfer Nauta Plus

## Menu and screen

The General MiTransfer menu routes `BOLSARecargaNautaMLC` to a choice dialog with “sin cuenta” and “con cuenta” options. Both now open the clean `NautaPlusRechargeFragment`, migrated from raw JADX class `HZgbT8IXPf`, with the selected `AccountType` under bundle key `OpcionNautaPlus`.

In “sin cuenta” mode, the account field and saved-account picker are hidden. In “con cuenta” mode, the username field is shown with the Nauta Plus account hint and a saved-account picker is available. The raw screen's account autocomplete is populated from saved Nauta usernames.

## Selector 34 payloads

| Mode | Payload | Validation |
| --- | --- | --- |
| With account | `<username>*<mobile>*<bolsa>` | Username required; spaces and `@` rejected. Mobile required, eight digits, starts with `5` or `6`. USD bolsa required. |
| Without account | `0000*<mobile>*<bolsa>` | Mobile required, eight digits, starts with `5` or `6`. USD bolsa required. |

Both branches send regular selector `34` through `FBsQzP3Zfj.actionCallUSSDBack`; the screen selects only the `Cuenta USD` bolsa and has no partial-USSD branch in the inspected handler. Confirmation copy differs: with-account confirms the username and optional mobile display, while without-account confirms the beneficiary mobile. The raw `toLowerCase()` call does not assign its result, so it does not alter the username before sending.

The menu now passes `AccountType.SIN_CUENTA` or `AccountType.CON_CUENTA` into the migrated screen. The source enum's declaration order differs from the clean enum, but this route compares named constants and passes the clean enum throughout; it does not rely on ordinal values.

## Evidence limits

This documents the source-visible form and request construction. Successful purchases, server-side interpretation of `0000`, and runtime UI navigation have not been verified against a live service or device.
