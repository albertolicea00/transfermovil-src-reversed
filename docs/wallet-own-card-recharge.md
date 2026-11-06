# MiTransfer own-card recharge

The General MiTransfer `BOLSARecargaPropia` menu item now opens `OwnCardPaymentFragment`, migrated from raw JADX class `JrjJL8mtlI`. This path reloads a saved own-card series; it is separate from bank-specific own-card screens.

## Form and payload

The form selects a card series, amount, and CUP wallet. The CUP wallet is the only offered bolsa and maps to `tipoBolsa = 2`. The request is `<series>*<amount>*2` with selector `77`. Regular USSD uses `FBsQzP3Zfj.actionCallUSSDBack`; partial USSD uses gateway `110`, selector `77`, agency `04`, and maximum 4 parameters.

The series is required and must contain exactly 12 characters. The `serieCorrecto` flag is initialized `true` and is not changed in this source class, so the additional “incorrect series” check does not add validation in the observed path. Amount is parsed as a float and must be at least 1; the bolsa selection is required.

Before dispatch, the form inserts an unseen series into `TarjetaPropia` with description `Nueva` and currency `CUP`. It does not persist the amount or transaction result in that entity. A saved series can be selected from autocomplete or the account picker.

## Evidence limits

Source comparison after package/class normalization is exact. Runtime navigation, carrier response, and whether all valid card series are exactly 12 characters have not been verified on-device or against a live service.
