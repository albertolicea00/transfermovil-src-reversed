# MiTransfer mobile recharge

The clean [`WalletTopupFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletTopupFragment.java) reconstructs raw `zzyNbaqs1U`. The main operations menu's `BOLSARecargaMovil` entry routes to it with currency `CUP` and agency `MiTransfer`, matching the raw menu branch.

## Form and USSD construction

The form accepts an 8- or 10-character mobile number and an amount parsed as a float with minimum `1`. It requires a selected wallet type. Contact picking requires `READ_CONTACTS`; the form normalizes spaces, a leading plus/zero, and a leading `53` for ten-character numbers starting with `535` or `536`.

For CUP, the form selects service `54` and `tipoBolsa=2`; for USD, service `23` and `tipoBolsa=1`. It sends `<phone>*<amount>*0*<tipoBolsa>` through the ordinary confirmation dispatcher. `nuevoDatos()` is empty, so this form does not persist new phone numbers. The source also contains an unused currency-choice dialog; the executed `BOLSARecargaMovil` menu handler opens CUP directly.

## Evidence and limits

- [`zzyNbaqs1U.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/zzyNbaqs1U.java): source form behavior.
- [`rR6oImkdEU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/rR6oImkdEU.java): raw CUP menu route and dormant currency-choice dialog.
- [`WalletTopupFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletTopupFragment.java) and [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean form and route.

The dispatcher request is source-confirmed; this note does not claim carrier-side acceptance or runtime behavior.
