# General-mode carrier services menu

`nljtDl5MIf.fillList()` seeds the `General` service category with 14 operations. Entries with a fragment class point to a form; an empty fragment name delegates to a dialog or direct dispatcher branch. The operation enum and `FBsQzP3Zfj.getDialogOperation()` confirm selectors for the two balance queries, while the remaining payload and destination behavior still needs per-operation tracing.

| Menu label | Operation | Destination / observed behavior |
|---|---|---|
| Consulta tu Saldo Prepago | `ConsultaSaldo222` | Direct confirmation for `*222` |
| Consulta tu Saldo Pospago | `ConsultaSaldo111` | Direct confirmation for `*111` |
| Llamar | `LLamada` | [`GMFMyKMnO2`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/AjGJz9tVLXv/GMFMyKMnO2.java) in mode `1`; launches `ACTION_CALL` to `tel:<8-digit-number>` |
| Llamar con *99 | `Llamar99` | Same form in mode `2`; launches `ACTION_CALL` to `tel:*99<8-digit-number>` |
| Recarga tu Móvil con Cupón | `RecargarMovilBono` | [`b0kkzvOCEu`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java): accepts a non-empty voucher code and sends the code as `662*<voucher>` through the selected General/Agent activity dispatcher. |
| Transferir tu Saldo | `TransferirSaldoMovil` | [`C8l2t8799rL`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java): selector `234`, option `1`, payload `<phone>*<PIN>*<amount>` |
| Cambiar su clave de transferencia | `CambioClave` | [`E1lhoLKryWP`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java): selector `234`, option `2`, payload `<new-key>*<repeat>` |
| Consultar estado del bono | `ConsultarEstadoBono` | Dialog/direct dispatcher branch |
| Gestión de planes | `GestionPlanes` | Dialog/direct dispatcher branch |
| Consultar plan de datos | `ConsultarPlanDatos` | Dialog/direct dispatcher branch |
| Consultar plan de voz | `ConsultarPlanVoz` | Dialog/direct dispatcher branch |
| Consultar plan SMS | `ConsultarPlanSMS` | Dialog/direct dispatcher branch |
| Consultar plan Amigos | `ConsultarPlanAmigos` | Dialog/direct dispatcher branch |
| Adelanta saldo | `AdelantaSaldo` | Dialog/direct dispatcher branch |

All entries are marked active and initially use order `-1`; `updateOperation()` reconciles them with the local operation database. This is the seed menu, not necessarily the final visible ordering: saved order, active state, and duplicate cleanup can change what is displayed. Forms and exact USSD payloads remain under their own source-tracing tasks.

## Voucher recharge details

The form can launch the QR scanner with `Nl0yptXmjQ.Recarga_Cupon` and service `ETECSA`. Returned `QRData` is copied when all characters are digits; otherwise the form strips every non-digit character before filling the voucher field. Manual and scanned input share the same non-empty-only validation. The confirmation text includes the entered value, and selector `662` is dispatched through the Agent activity when an agent record exists and is active, otherwise through the General activity. This establishes local construction and routing, not carrier acceptance or voucher format requirements.

## Call forms

`FNRzUmC7E5` sets operation mode `1` for the ordinary call and `2` for the `*99` call. Both require exactly eight trimmed characters and can pick a contact. Contact normalization strips spaces, removes one leading `+` or `0`, and removes a leading `53` only for 10-character values beginning with `535` or `536`. The call button places the `ACTION_CALL` request directly; this path does not use the USSD helper. The source does not show local digit-only validation for manually entered numbers.

## Mobile balance transfer

`C8l2t8799rL` requires an eight-character recipient, a four-character PIN, and a non-empty amount without a period. It does not check that the amount contains only digits or is positive. After confirmation it calls the active Agent/General dispatcher with selector `234`, leading option `1`, and payload `<recipient>*<PIN>*<amount>`. Contact picking uses the same normalization rules as the call form. The source confirms only the constructed request and local checks.

The transfer-key form `E1lhoLKryWP` uses selector `234`, leading option `2`, and payload `<new-key>*<repeat>`. Both fields are shown, but the handler does not compare them. Its second length check mistakenly checks the new-key field again, so the repeated value has no effective non-empty or four-character validation. This is a source-confirmed client-side validation gap; carrier-side validation is outside the static evidence.

## Sources

- [`nljtDl5MIf.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/nljtDl5MIf.java): operation definitions, fragment destinations, persistence reconciliation.
- [`FdonIAFI9w.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/FdonIAFI9w.java): operation enum.
- [`FBsQzP3Zfj.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java): operation-dialog dispatch and confirmed `*222`/`*111` branches.
