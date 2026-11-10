# MiTransfer enterprise operation routes

The `BOLSATransferenciaClasicaEmpresarial` dialog now opens `BfiEnterpriseTransferFragment` and passes the selected option as integer bundle value `TransferType`. The `BOLSAPagoExternoClasicaEmpresarial` dialog opens `BfiExternalPaymentFragment` with integer `PayType` and `R1sDOSqZ2z.CLASICAEMP`.

Both routes clear `U6ucOCBccJ.pmoneda` and `pdata` before launching the form, matching the original `rR6oImkdEU` callbacks. The source forms themselves are already migrated; this change restores menu-to-form navigation and argument delivery. Runtime submission remains unverified.

The clean `BfiExternalPaymentFragment` is linked to source `Eqj43O0pUx`. Its
form validation and `submitForm()` payload construction match the source for
dynamic/static QR payments, optional certification and confirmation phones,
selectors `30`/`31`, and partial-USSD marker `05` with six-parameter packets.
The source truncates long account strings before dispatch in the documented
branches; the clean implementation retains those same branches.
