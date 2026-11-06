# MiTransfer TFA recharge

The `BOLSARecargaTFA` menu now opens `TfaRechargeFragment`, migrated from raw JADX class `b7zSZMAX7cN`. It collects a TFA identifier and amount, and offers only the CUP wallet. The account field must be nonempty and 8 or 10 characters; the amount must parse as a float of at least 1. The CUP selection sets wallet marker `2`.

The form sends `<identifier>*<amount>*2` under selector `108`. Regular USSD uses `FBsQzP3Zfj.actionCallUSSDBack`; partial USSD uses gateway `110`, selector `108`, agency `04`, and maximum 4 parameters. The source contains a USD confirmation branch for marker `1`, but the inspected layout exposes only the CUP option and the item listener assigns `2`.

Contact selection can fill the identifier. The method `nuevoDatos()` is empty, so the form itself does not persist it. Runtime navigation and live TFA processing have not been verified.
