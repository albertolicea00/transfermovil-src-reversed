# MiTransfer enterprise operation routes

The `BOLSATransferenciaClasicaEmpresarial` dialog now opens `BfiEnterpriseTransferFragment` and passes the selected option as integer bundle value `TransferType`. The `BOLSAPagoExternoClasicaEmpresarial` dialog opens `BfiExternalPaymentFragment` with integer `PayType` and `R1sDOSqZ2z.CLASICAEMP`.

Both routes clear `U6ucOCBccJ.pmoneda` and `pdata` before launching the form, matching the original `rR6oImkdEU` callbacks. The source forms themselves are already migrated; this change restores menu-to-form navigation and argument delivery. Runtime submission remains unverified.
