# MiTransfer 4G/FWA operations

## Menu routes

`BOLSARecargaFWA` opens a two-option dialog. Option 0 is “Recarga de saldo” and opens `FwaBalanceRechargeFragment` (source `wbFn8tBw8W`, selector `20`). Option 1 is labeled “Compra de gigas” in the checked resource strings and opens `FwaDataPackagePurchaseFragment` (source `q55ExEc6x2l`, selector `18`). The older clean drafts called these `LandlineRechargeFragment` and `CubacelPlanRechargeFragment`; both were unused stubs and have been replaced with names that match the source behavior. `BOLSACompraPaqueteFWA` routes directly to the selector-18 purchase form.

## Balance recharge, selector 20

The form requests a mobile/account value, amount, and USD wallet choice, then sends `<account>*<amount>*USD*1`. The number must be nonempty and have length 8 or 10. Amount validation only checks nonempty text; the source does not parse it or enforce a numeric range. USD is the only bolsa and maps to `1`. The form dispatches through the standard USSD helper and has no partial-USSD branch.

## Data package purchase, selector 18

The form requests a mobile/account value and USD wallet. The number must be nonempty and have length 8 or 10. Although the screen inflates a Prepago/Pospago/Pospago residencial selector, it hides that control and does not validate or use its value. It sends `<account>*1501*USD*1` through the standard USSD helper and asks to continue to display offers. The source method named `nuevoDatos()` is empty. No partial-USSD branch appears in the handler.

## Source limits

Contact selection can populate the number field. Successful recarga, offer retrieval, purchase completion, number semantics, and live navigation have not been verified against a device or service.
