# MiTransfer fixed-phone bill payment

The `BOLSATelefono` menu item now opens `FixedPhoneBillPaymentFragment`, migrated from `p5B8KozjvpQ`. The form accepts a 14- or 15-character phone account and offers a total-payment switch or a manual amount; the wallet selector contains only CUP. Manual amount validation checks only that the field is nonempty, not that it parses as a number.

Selector `42` receives `<phone-account>*<amount-or-0>*0*<wallet-type>`. Total payment uses amount `0`; manual payment uses the typed amount. Partial USSD uses gateway `110`, selector `42`, agency `04`, and max 4 parameters. Standard mode uses `actionCallUSSDBack`.

Before dispatch, the screen saves a new `Factura` row when the account is not already present, with `tipo_Factura = 0`, then calls `UpdateMenu` on the hosting activity when supported. The source-matched UI and route are restored; transaction runtime is not verified.
