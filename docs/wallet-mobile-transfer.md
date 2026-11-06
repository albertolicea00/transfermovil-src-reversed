# MiTransfer mobile balance transfer

The clean [`WalletTransferFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletTransferFragment.java) reconstructs the MiTransfer choice from the raw `LjOlaYSSMH` form. The wallet operations menu's transfer dialog now routes its first choice to this clean form; the “Clásica” choice continues to use raw `l3GXbXAyUW` pending its clean migration.

## Form and request

The form requires an eight-character destination, a positive amount formatted as an integer or a decimal with up to two places, and a selected wallet type. It offers contact selection and checkboxes for sending to the user's own mobile and including saldo. Wallet types come from the local `TMonedasWallet` list when available, excluding `-MIS CUENTAS-`, otherwise from the static resource list. The selected index maps to `tipoBolsa = index + 1`; index 0 labels the amount USD and index 1 labels it CUP.

After confirmation the form builds `<destination>*<amount>*0*<send-to-own-phone-flag>*<include-balance-flag>*<wallet-type>` and dispatches selector `45`. Partial mode uses gateway `110`, agency marker `04`, and a four-parameter packet limit; full mode uses the standard selector-45 dispatcher. The response callback is empty. A source caveat: successful validation does not visibly clear the amount input error state, while the wallet-type validator clears its own error.

## Sources

- [`LjOlaYSSMH.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/LjOlaYSSMH.java): raw MiTransfer mobile-transfer form.
- [`MainBankingTabFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs/MainBankingTabFragment.java): clean menu choice routing.
- [`WalletTransferFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/WalletTransferFragment.java): clean form reconstruction.
- [`l3GXbXAyUW.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java): retained source destination for the classic-transfer choice.

The client construction is established statically; this note does not claim server-side acceptance.
