# MiTransfer gas payment

The clean [`WalletGasPaymentFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/WalletGasPaymentFragment.java) reconstructs raw `XCDkgbw8oZ`; `BOLSAgas` now routes to this form.

The form loads gas invoices (`Factura`, type `3`), offers saved-account selection, validates a non-empty 12-character identifier and selected wallet type, and requires a payment-type selection. It stores a newly entered invoice and refreshes the host menu. The request uses selector `67` and payload `<invoice>*0*0000*<payment-type>*2`; partial mode uses gateway `110`, agency `04`, and a four-parameter limit. The source does not apply a digit-only check to the invoice identifier.

## Sources

- [`XCDkgbw8oZ.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XCDkgbw8oZ.java): raw gas form and dispatcher path.
- [`rR6oImkdEU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/rR6oImkdEU.java): source menu route.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean menu route.
