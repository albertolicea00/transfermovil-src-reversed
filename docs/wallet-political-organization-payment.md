# MiTransfer political-organization payment

The `BOLSAPCC` menu item now opens `CreditPaymentFragment`, migrated from `xb7DiohJuX`. It extends the source-backed shared banking form base and supports the inherited account/wallet selection UI.

The subclass validates an organization, an 11-character CI, a CUP/USD wallet, and either a declared income or a month count when internal organization value `3` is selected. The source resource currently exposes only `PCC` and `UJC`; the special value-3 months branch therefore has no visible corresponding choice in that array. For the normal organization path, payload is `<organization>*<CI>*<income>*0000*<optional-confirmation-mobile>*<wallet-type>` under selector `7`. Partial USSD uses gateway `110`, selector `7`, agency `04`, max 4 parameters. The code path for organization value `3` instead sends the months value under selector `122` with the same partial settings.

CI validation checks length only, then tries to parse it as a float into `importe`; parse failure resets `importe` to zero but still passes validation. Income must parse as a float but has no observed lower-bound check. The optional confirmation phone is initialized to `00` unless the confirmation control is enabled and a value is present. Local persistence method `nuevoDatos()` is empty.

The form and route are source-backed; server behavior and runtime UI are unverified. The value-3 option/resource mismatch and CI-to-float behavior are retained as observed limitations.
