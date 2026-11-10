# MiTransfer cash withdrawal ticket

The clean [`WalletWithdrawFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletWithdrawFragment.java) is body-identical to raw `f9Reflqt3EZ` after normalizing package and class name. The operations menu routes `BOLSAExtraccionWalletTicket` to this fragment.

## Entity and location selection

The form loads cash entities from `V9s8rJIDplX.loadDataEntidadEfectivo()` and partitions them by currency containing `CUP` or `USD`. Selecting wallet type 1 chooses USD entities; type 2 chooses CUP entities. Selecting entity code `22098` reveals province and municipality controls; changing province clears the current municipality and reloads municipalities from the local database. Other entities clear and hide both location fields. If no province/municipality is selected, the payload uses location `0`.

The amount must parse as a float and be at least `1`, unless `pagoTotal` is enabled (it defaults false). Currency and entity are required. After confirmation, the form builds `<entity-code>*<amount>*<currency>*<location-code><wallet-type>`, where a selected location is province code concatenated with municipality code. It dispatches selector `95`; partial mode uses gateway `110`, agency `04`, and the four-parameter packet limit. The response callback is empty. The confirmation warns that USD withdrawal is converted at the applicable CUP rate; CUP selection says the indicated amount is deducted.

## Sources

- [`f9Reflqt3EZ.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f9Reflqt3EZ.java): raw withdrawal form and dispatch.
- [`rR6oImkdEU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/rR6oImkdEU.java): raw menu route.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean route.
