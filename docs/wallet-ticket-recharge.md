# MiTransfer CUP deposit ticket

`P8DtkaSW4dR` is the source form for the “Recarga CUP” wallet ticket operation. The clean [`WalletRechargeFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletRechargeFragment.java) now reconstructs its amount form, validation, confirmation, and full/partial USSD paths. [`MainBankingTabFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java) routes `BOLSARecargaCUPWalletTicket` to that clean fragment.

## Source behavior

The raw form inflates `nfoph5kavkjek`, labels the amount in CUC in the input hint, but describes the requested deposit as CUP and builds `<amount>*CUP`. The amount must parse as a float and be at least `1`; `pagoTotal` defaults to false and no setter appears in this class. It confirms the amount before dispatch.

When partial USSD is disabled, it invokes selector `17` through `FBsQzP3Zfj.actionCallUSSDBack`. When enabled, it sends gateway `110`, selector `17`, agency marker `04`, a four-parameter limit, and the same `<amount>*CUP` payload through `pAzq93vIl3.principalEnviarUSSD`. The source form creates a USSD response manager but its response callback is empty. On close, it pops the current fragment, and pops a second entry only when both partial USSD and `isDirectScan` are true; this class initializes `isDirectScan` to false and does not set it elsewhere.

The clean form keeps the source resource identifiers and reuses the application's existing USSD helpers. This records request construction and menu routing, not carrier acceptance; the repository has no Android build configuration for runtime verification.

## Sources

- [`P8DtkaSW4dR.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/P8DtkaSW4dR.java): raw amount form, selector and packet paths, callbacks.
- [`OperationMenuBuilder.java`](../app/src/main/java/cu/etecsa/transfermovil/data/OperationMenuBuilder.java): operation menu entries.
- [`WalletRechargeFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletRechargeFragment.java): clean form reconstruction.
