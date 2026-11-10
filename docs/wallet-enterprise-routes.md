# MiTransfer enterprise operation routes

The `BOLSATransferenciaClasicaEmpresarial` dialog now opens `BfiEnterpriseTransferFragment` and passes the selected option as integer bundle value `TransferType`. The `BOLSAPagoExternoClasicaEmpresarial` dialog opens `BfiExternalPaymentFragment` with integer `PayType` and `R1sDOSqZ2z.CLASICAEMP`.

Both routes clear `U6ucOCBccJ.pmoneda` and `pdata` before launching the form, matching the original `rR6oImkdEU` callbacks. The source forms themselves are already migrated; this change restores menu-to-form navigation and argument delivery. Runtime submission remains unverified.

The clean `BfiExternalPaymentFragment` is linked to source `Eqj43O0pUx`. Its
form validation and `submitForm()` payload construction match the source for
dynamic/static QR payments, optional certification and confirmation phones,
selectors `30`/`31`, and partial-USSD marker `05` with six-parameter packets.
The source truncates long account strings before dispatch in the documented
branches; the clean implementation retains those same branches.

The shared clean [`BfiQrAccountFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/bfi/BfiQrAccountFragment.java)
matches `LgiFGRpiEl` after accounting for its renamed class/package and the
clean inheritance adapter. QR parsing, contact selection, confirmation-phone
state, and auxiliary QR data handling are the same. `BfiUssdAccountFragment`
is a clean shared callback/packet-state adapter; it does not claim a separate
one-to-one source class.

The Wallet Boleto configuration tab's association dialog routes “Clásica” to
`HTmIvOo9nb`, which stores the account under `MiTransfer`, and “Clásica
empresarial” to `l2FaHPPBDa`, which stores it under `CLASICAEMP`. The delete
registration choices route to `Nju5UJgFce` (wallet registration) and
`m44wUnA8d5` (saved classic/enterprise account); PIN change routes to
`Cmok7CcIR9`. Their clean counterparts now back the tab actions.

The General Wallet enterprise transfer form, [`BfiTransferFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/BfiTransferFragment.java),
matches source `Z3kYdPwq6K2` after package and class-name normalization. It
validates destination, amount, category, wallet type, optional source account,
and phone fields; sends selector `220` with agency `08`; and preserves the
partial-USSD, ordinary, and return-observer dispatch branches.
