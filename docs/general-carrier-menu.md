# General-mode carrier services menu

`nljtDl5MIf.fillList()` seeds the `General` service category with 14 operations. Entries with a fragment class point to a form; an empty fragment name delegates to a dialog or direct dispatcher branch. The operation enum and `FBsQzP3Zfj.getDialogOperation()` confirm selectors for the two balance queries, while the remaining payload and destination behavior still needs per-operation tracing.

| Menu label | Operation | Destination / observed behavior |
|---|---|---|
| Consulta tu Saldo Prepago | `ConsultaSaldo222` | Direct confirmation for `*222` |
| Consulta tu Saldo Pospago | `ConsultaSaldo111` | Direct confirmation for `*111` |
| Llamar | `LLamada` | `GMFMyKMnO2` call form |
| Llamar con *99 | `Llamar99` | Same `GMFMyKMnO2` call form, separate operation mode |
| Recarga tu Móvil con Cupón | `RecargarMovilBono` | `b0kkzvOCEu` |
| Transferir tu Saldo | `TransferirSaldoMovil` | `C8l2t8799rL` |
| Cambiar su clave de transferencia | `CambioClave` | `E1lhoLKryWP` |
| Consultar estado del bono | `ConsultarEstadoBono` | Dialog/direct dispatcher branch |
| Gestión de planes | `GestionPlanes` | Dialog/direct dispatcher branch |
| Consultar plan de datos | `ConsultarPlanDatos` | Dialog/direct dispatcher branch |
| Consultar plan de voz | `ConsultarPlanVoz` | Dialog/direct dispatcher branch |
| Consultar plan SMS | `ConsultarPlanSMS` | Dialog/direct dispatcher branch |
| Consultar plan Amigos | `ConsultarPlanAmigos` | Dialog/direct dispatcher branch |
| Adelanta saldo | `AdelantaSaldo` | Dialog/direct dispatcher branch |

All entries are marked active and initially use order `-1`; `updateOperation()` reconciles them with the local operation database. This is the seed menu, not necessarily the final visible ordering: saved order, active state, and duplicate cleanup can change what is displayed. Forms and exact USSD payloads remain under their own source-tracing tasks.

## Sources

- [`nljtDl5MIf.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/nljtDl5MIf.java): operation definitions, fragment destinations, persistence reconciliation.
- [`FdonIAFI9w.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/FdonIAFI9w.java): operation enum.
- [`FBsQzP3Zfj.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java): operation-dialog dispatch and confirmed `*222`/`*111` branches.
