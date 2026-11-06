# Transferencia Clásica from MiTransfer

The clean [`BankTransferBfiFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/BankTransferBfiFragment.java) reconstructs raw `l3GXbXAyUW`. The wallet transfer dialog now routes “MiTransfer” to `WalletTransferFragment` and “Clásica” to this clean form.

## Form and payload

The form validates a destination card by removing hyphens, requiring 16 characters, and requiring prefix `976003`. It validates a positive amount with up to two decimal places and a selected wallet type. A USD source type can reveal locally stored accounts; selecting one supplies the origin card. An optional phone accepts 8 or 10 characters. When an `R1sDOSqZ2z` agency argument is provided, the form also requires a four-character PIN and prefixes the payload with `08*<PIN>*`.

The remaining ordered fields are `<operation-type>*<origin-card>*<destination-card>*<amount>*<send-to-own-phone-flag>*<phone>*<include-balance-flag>*<wallet-type>`. Selector `45` is used. Partial mode uses gateway `110`, agency marker `08`, and four parameters per packet. Full mode uses the regular selector-45 helper when there is no PIN; the PIN path uses the return-enabled helper. Contact selection requests `READ_CONTACTS` and applies the source normalization for plus/zero and Cuban mobile prefixes.

## Evidence and limits

- [`l3GXbXAyUW.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java): original form and payload construction.
- [`BankTransferBfiFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/BankTransferBfiFragment.java): clean source reconstruction.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): wallet dialog route.

This documents client behavior and does not establish whether the carrier accepts the request.
