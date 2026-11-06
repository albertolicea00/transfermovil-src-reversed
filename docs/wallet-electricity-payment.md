# MiTransfer electricity payment

The clean [`WalletElectricityPaymentFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/WalletElectricityPaymentFragment.java) reconstructs raw `dwdZ5sHcFR` and is the destination for `BOLSAElectricidad`.

The form loads saved electricity invoice identifiers (`Factura`, type `1`) into an autocomplete field and offers a dialog to select from stored entries. It validates a non-empty invoice and the wallet-type selection. The form sets `tipoBolsa=2` (CUP), builds `<invoice>*0*2`, and dispatches selector `41`. If the invoice is not already stored, it inserts it locally and asks the host activity to refresh its operation menu. Partial mode uses gateway `110`, agency marker `04`, and a four-parameter limit.

## Sources

- [`dwdZ5sHcFR.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dwdZ5sHcFR.java): raw invoice form and dispatch.
- [`rR6oImkdEU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/rR6oImkdEU.java): source menu route.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean menu route.
