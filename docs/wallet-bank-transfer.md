# MiTransfer transfer from a bank account

The `BOLSATransferirBancos` menu entry now routes to the clean [`WalletBankTransferFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/WalletBankTransferFragment.java), reconstructed from raw `H0oV6Ot0bS`. It is separate from the mobile-to-mobile transfer and the classic-card transfer forms.

The form loads transfer agencies from local JSON data, supports USD/CUP, accepts a destination card and amount, and optionally accepts a phone/contact and a four-character PIN when an agency argument is provided. It validates the destination, amount, currency selection, and bank/currency compatibility; certain MLC/CUP combinations prompt for confirmation. If the optional phone is absent, the source keeps sentinel `0000`.

As the destination card prefix identifies a bank, the form also selects the first loaded agency whose code contains the inferred bank index (`1` BPA, `2` BANDEC, or `3` Metropolitano). This assignment occurs alongside logo selection; it is not based on the display name. The source uses substring containment and keeps the first match.

The request uses selector `16` and payload `<optional-08*PIN-prefix><selected-agency-code>*<destination>*<amount>*<currency>*<phone-or-0000>*<send-to-own-phone-flag>*<wallet-type>`. Partial dispatch uses gateway `110`, agency marker `04`, and a four-parameter limit. Full dispatch chooses the standard or return-enabled selector-16 helper depending on whether the PIN branch is active.

## Source references

- [`H0oV6Ot0bS.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS.java): raw bank-to-wallet transfer.
- [`rR6oImkdEU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/rR6oImkdEU.java): operations-tab destination.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean menu route.
