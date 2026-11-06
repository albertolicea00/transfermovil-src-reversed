# MiTransfer Extra USD package purchase

The General MiTransfer `BOLSACompraPaqueteMLC` menu item now opens `WalletExtraPackageFragment`, migrated from the raw class `f3Ttlx30sMT`. The old clean `MobileTransferFragment` stub carried this source annotation despite being unrelated to mobile-to-mobile transfer; it had no callers and was removed.

## Form and request

The form takes a beneficiary mobile number and fixes the account choice to the USD wallet. It accepts 8- or 10-character numbers; the source does not additionally validate prefix or digit content. Contact lookup strips spaces, removes a leading `+` or `0`, and for a 10-character number beginning `535` or `536`, removes the first two characters.

On submit, the source forces `tipoBolsa = 1` and sends selector `33` with `<mobile>*1`. The confirmation asks to buy an Extra USD plan using the USD account and says that confirming will display available offers. Dispatch uses the standard USSD helper; the inspected form has no partial-USSD branch. Its `nuevoDatos()` method is empty, so this form itself does not persist the number.

The menu route now opens the migrated form. Source comparison after package/class normalization is exact. The subsequent offer list and purchase completion are outside this form's observed request path and have not been runtime-verified.
