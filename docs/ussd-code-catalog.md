# USSD code catalog — TODO

Target: Transfermóvil 1.260416 (`cu.etecsa.cubacel.tr.tm-v162.apk`). This document is reserved **only** for USSD codes sent by the client, what each code does, and how each dial string is constructed. SMS, HTTP, and UI implementation details belong in their existing documents.

The current [telephony analysis](telephony.md) is the starting point. Its lists and inferred purposes need to be checked against callers before they become entries here. No code should be dialed while building this catalog; use static analysis and offline examples with dummy values.

## Inventory to complete

- [ ] Enumerate every USSD dispatch call and literal prefix. Start with `*222`, `*444`, `*100`, `*111`, `*133`, and `*234`, then search for dynamically assembled prefixes.
- [ ] For each call, record the exact source class/method and line, bank or service, user action, operation identifier, and whether the purpose is confirmed or inferred.
- [ ] Resolve every `BankOperationCode`/menu operation to its actual USSD invocation. Mark operations handled by SMS or HTTP as out of scope rather than guessing a USSD code.
- [ ] Distinguish gateway prefixes, operation selectors, parameters, packet sequence fields, version fields, and the final `#` terminator. Record the order and any escaping or URI encoding.
- [ ] Trace `rDEl7rW1aN.code()` and `AFm1GraXBXUkpF1hmOdV.Tz34gww2TFwrsuT8ukpL`: input types, lookup data, transformation steps, padding, and output. Separate verified behavior from hypotheses.
- [ ] Trace `pAzq93vIl3` packet splitting, sequence generation, retries, and multi-step calls. Record when one user action sends more than one USSD request.
- [ ] Compare the `ACTION_CALL` path with `TelephonyManager.sendUssdRequest()` and note any format or response-handling differences.
- [ ] Add offline test vectors using dummy access codes, accounts, PINs, and amounts. Never record live credentials or submit real requests.

## Confirmed banking entries (initial subset)

The operations listed here are confirmed from the reconstructed call sites and the
shared `FBsQzP3Zfj.actionCallUSSDBack(...)` implementation. The list is a partial
catalog; packet splitting for partial USSD paths is still under investigation.

A static scan of banking UI source currently finds 66 single-line
`actionCallUSSDBack(...)` call sites using 32 distinct service selectors. This
count excludes multiline and dynamically assembled calls, and does not mean all
selectors represent different user-visible operations.

| Service / bank | User action | Dial string template | Construction algorithm | Source evidence | Confidence |
| --- | --- | --- | --- | --- | --- |
| BFI | Query balance | `tel:*<access>*46*E(<currency>*<account>)*<version>%23` | Select currency and account; transform the complete payload through `rDEl7rW1aN.code()`. Partial path uses packet gateway `110`, operation `46`, version `05`. | `BfiConsultarSaldoFragment.submitForm`; `FBsQzP3Zfj.actionCallUSSDBack` | Confirmed |
| BFI | Query limits | `tel:*<access>*62*E(<currency>*<account>)*<version>%23` | Same account payload and transform; partial path uses `110`, `62`, `05`. | `BfiConsultarLimiteFragment.submitForm`; dispatcher | Confirmed |
| BFI | Query latest operations | `tel:*<access>*48*E(<currency>*<account>)*<version>%23` | Same account payload and transform; partial path uses `110`, `48`, `05`. | `BfiConsultarUltimasOperacionesFragment.submitForm`; dispatcher | Confirmed |
| BFI | Query payment priority | `tel:*<access>*28*E(<account>)*<version>%23` | Transform selected account with `rDEl7rW1aN.code()`. | `BfiConsultarPrelacionPagoFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query balance/limits | `tel:*<access>*62*E(<currency>*<account>)*<version>%23` | Transform currency and selected account. Partial path uses `110`, `62`, `01`. | `BpaBalanceQueryFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query card balance | `tel:*<access>*46*E(<currency>*<account>)*<version>%23` | Transform currency and selected account. Partial path uses `110`, `46`, `01`. | `BpaAccountQueryFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query latest operations | `tel:*<access>*48*E(<service>*<currency>*<account>)*<version>%23` | Transform service, currency, and selected account in that order. Partial path uses `110`, `48`, `01`. | `BpaLastOperationsFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano / BFI | Convert CUC account to CUP | `tel:*<access>*87*E(<account>)*<version>%23` | Transform selected account with `rDEl7rW1aN.code()`. | `MetroConvertirCuentaFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay gas bill | `tel:*<access>*67*E(<account>*0*<currency>)*<version>%23` | Select account and currency, append literal service field `0`, then transform the payload. | `MetroGasPaymentFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Change PIN | `tel:*<access>*69*E(<new-PIN>)*<version>%23` | Validate the repeated PIN, then transform the new PIN. | `MetroChangePinFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Query operations by service type | `tel:*<access>*48*E(<service-type>*<currency>)*<version>%23` | Service type is spinner position + 1, followed by currency. | `MetroBalanceQueryFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay water bill | `tel:*<access>*51*E(<account>*0*<currency>)*<version>%23` | Transform account, fixed service field `0`, and currency. | `MetroServiceQueryFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Change ATM/POS limits | `tel:*<access>*61*E(<ATM>*<POS>*<ATM+POS>*<currency>)*<version>%23` | Total is integer ATM + POS; a second source screen sends the same payload. | `MetroLimitChangeFragment.submitForm`, `MetroEstadoCuentasFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay electricity bill | `tel:*<access>*41*E(<account>*0*<currency>)*<version>%23` | Transform account, fixed service field `0`, and currency. | `MetroAssociateAccountFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay cashier gas bill | `tel:*<access>*67*E(<account>*0*<currency>)*<version>%23` | Transform account, fixed service field `0`, and currency. Shares selector/payload with the restored gas payment path. | `MetroCashierPaymentFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Change temporary limits | `tel:*<access>*61*E(<ATM>*<POS>*<total>*<currency>*<account>)*<version>%23` | `total` is computed as integer ATM + POS limits, then the full payload is transformed. Partial path uses `110`, `61`, `05`. | `MetroModificarLimitesFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Modify payment priority | `tel:*<access>*27*E(<priority-code>*<account>)*<version>%23` | Transform selected priority code and account. | `MetroModificarPrelacionFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Reprint card | `tel:*<access>*74*E(<currency>*<account>*<commission-account>*<municipality>*<branch>)*<version>%23` | Read municipality and branch codes from selected entities, then transform the ordered payload. | `MetroReimprimirTarjetaFragment.submitForm`; dispatcher | Confirmed |
| General | Transfer to bank account | `tel:*<access>*45*E(<account>*<amount>*<recipient-phone-or-00000000>)*<version>%23` | Validates a 16-digit destination account, amount, and optional 8-digit phone; uses `00000000` when phone is blank. | `TransferFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Reserve appointment | `tel:*<access>*102*E(<bank>*<service>*<branch-DPA>*<identity>*<phone-or-0>*<currency>*<account>)*<version>%23` | Fields are assembled in this order; when partial USSD is enabled, packet helper uses gateway `110`, operation `102`. | `WalletTicketPurchaseFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Change reservation date | `tel:*<access>*105*E(<bank>*<service>*<identity>*<date>)*<version>%23` | Date is passed after identity number. | `WalletTicketDateFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Cancel reservation | `tel:*<access>*106*E(<bank>*<service>*<identity>)*<version>%23` | Requires selected service and identity number. | `WalletTicketReservationFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Query reservation | `tel:*<access>*107*E(<bank>*<identity>)*<version>%23` | Query form accepts QR-prefilled identity data. | `WalletTicketQueryFragment.submitForm`; dispatcher | Confirmed |
| Banks | Pay traffic fine | `tel:*<access>*97*E(<fine-id>*0000*<article>*<inciso>*<municipality>*<province>*1*<date>*<currency>*<account>)*<version>%23` | Article/inciso may come from the local traffic catalog; packet helper is used when partial USSD is enabled. | `WalletTrafficFineDetailFragment.enviarUSSD`; dispatcher | Confirmed |
| MiTransfer / OFA | Reserve heritage-city activity | `tel:*<access>*8*E(<identity>*<activity-code>*<customer-type>*<quantity>*<date>*0*<total>*<currency>*<phone>*<balance-flag>*2)*<version>%23` | Activity price and total are assembled client-side; partial path uses gateway `110`, operation `8`, agency marker `04`. | `dWLcK5oQoS.submitForm`; dispatcher | Confirmed |

Here `E(x)` is the existing `rDEl7rW1aN.code(x)` transformation, `<access>` and
`<version>` come from the first `AppConfig`, and `%23` is produced by
`Uri.encode("#")`. The ordinary dispatcher asks for confirmation and starts
`ACTION_CALL`. This table describes source behavior only and does not dial any
code or include live credentials.

## Entry format

Use one row per **executed** USSD variant, not one row per UI label:

| Service / bank | User action | Dial string template | Construction algorithm | Source evidence | Confidence |
| --- | --- | --- | --- | --- | --- |
| TODO | TODO | TODO | TODO | TODO | TODO |

For any nontrivial algorithm, add a short subsection with inputs, ordered transformations, packet rules, and one dummy input/output example. Link to the original Java source at the exact method. Avoid copying sensitive constants into this catalog when a source link suffices.

## Source starting points

- `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java` — dispatch overloads.
- `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java` — `code()` and dialing flow.
- `src/AFm1GraXBXUkpF1hmOdV/Tz34gww2TFwrsuT8ukpL.java` — numeric transformation.
- `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java` — packet construction.

**Done when:** Every distinct executed USSD path has an evidence-backed purpose and reproducible construction description, and uncertain mappings are explicitly labeled.
