# MiTransfer saved bank accounts

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

## Saved-account editor

`MobileCardBankEditFragment` is a clean-package draft of source `MEqNzldfDl`. It uses the clean `MobileCardBank` model, `DatabaseHelper`, `BankType`, `Currency`, and the clean Agent/General activity classes. The source card classifier is recovered from `smali-1.260416.162.zip`, because JADX emitted throwing stubs for both `mostrarTarjeta()` and `getBanco()`.

The two methods use different positions for PAN cards beginning with `92`: `mostrarTarjeta()` reads characters 5–6 for the card image, while `getBanco()` reads characters 4–5 for issuer selection. Both methods recognize the source mappings `12` → BPA, `06` → BANDEC, `95` → Metropolitano; standard prefixes `12`, `06`, `05`, and `03` map to BPA, BANDEC, Metropolitano, and BFI. `976003` and `976004` identify CLASICA and CLASICAEMP. The editor switches to the classic-currency resource for those two prefixes. Short/malformed PAN inputs follow the original exception/unknown handling.

The clean draft preserves account formatting, alias/account uniqueness checks, optional eight-digit notification phone, currency selection, confirmation, encrypted account persistence through `MobileCardBank`, activity menu refresh, and the post-save association shortcut. The source shortcut routes MiTransfer to `WalletClassicAccountAssociationFragment` and CLASICAEMP to `WalletQrPaymentFragment`.

## List and navigation migration

`KeTIEVSfVo` is now represented by clean `MobileCardBankListFragment` and `MobileCardBankAdapter`. The list keeps the 20-account limit, masked PAN rows, expandable actions, edit/delete/QR/share controls, and the source's six agency routes. Agent and General account-management entries both open the clean list. BANDEC, BFI, MiTransfer, and CLASICAEMP route to clean forms; BPA and Metropolitano retain the original source-form destinations because no clean equivalents are linked yet. Editing and deleting reload the list when it resumes.

Remaining work is to migrate the BPA and Metropolitano transfer destinations, then compare all saved-account screens with runtime/UI behavior. The BPA route is the extended source form `iN1lHDKE5h` (saved/new origin account, CUP/CUC/USD amount, optional agency/PIN, recipient phone, message, and send flags); the clean `BpaTransferFragment` is a separate short form and is not a drop-in replacement. This static source comparison does not establish a successful banking transaction.

## Evidence

- [`MEqNzldfDl.java`](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/MEqNzldfDl.java): decompiled editor and the two JADX stubs.
- [`MEqNzldfDl.smali` in the local archive](../.workspace/archives/smali-1.260416.162.zip): method bytecode used to recover issuer/card classification.
- [`MobileCardBankEditFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/MobileCardBankEditFragment.java): clean-package editor draft.
- [`MobileCardBankListFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/MobileCardBankListFragment.java) and [`MobileCardBankAdapter.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/MobileCardBankAdapter.java): clean account list, row UI, and actions.
- [`MobileCardBank.java`](../app/src/main/java/cu/etecsa/transfermovil/data/entity/MobileCardBank.java) and [`DatabaseHelper.java`](../app/src/main/java/cu/etecsa/transfermovil/data/DatabaseHelper.java): clean data model and DAO facade.
