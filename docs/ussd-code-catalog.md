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
| General mode | Query prepaid balance | `tel:*222%23` | The carrier-services menu opens a confirmation dialog and dispatches the literal `*222` through the direct-code helper. | `nljtDl5MIf` (`ConsultaSaldo222`); `FBsQzP3Zfj.getDialogOperation`, case 3 | Confirmed |
| General mode | Query postpaid balance | `tel:*111%23` | The carrier-services menu opens a confirmation dialog and dispatches the literal `*111` through the direct-code helper. | `nljtDl5MIf` (`ConsultaSaldo111`); `FBsQzP3Zfj.getDialogOperation`, case 4 | Confirmed |
| General mode | Query bonus status | `tel:*222*266%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`ConsultarEstadoBono`); `FBsQzP3Zfj.getDialogOperation`, case 19 | Confirmed |
| General mode | Manage plans | `tel:*133%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`GestionPlanes`); `FBsQzP3Zfj.getDialogOperation`, case 20 | Confirmed |
| General mode | Query data plan | `tel:*222*328%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`ConsultarPlanDatos`); `FBsQzP3Zfj.getDialogOperation`, case 21 | Confirmed |
| General mode | Query voice plan | `tel:*222*869%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`ConsultarPlanVoz`); `FBsQzP3Zfj.getDialogOperation`, case 22 | Confirmed |
| General mode | Query SMS plan | `tel:*222*767%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`ConsultarPlanSMS`); `FBsQzP3Zfj.getDialogOperation`, case 23 | Confirmed |
| General mode | Query Amigos plan | `tel:*222*264%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`ConsultarPlanAmigos`); `FBsQzP3Zfj.getDialogOperation`, case 24 | Confirmed |
| General mode | Request advance balance | `tel:*234*3%23` | Confirmation dialog dispatches this literal carrier code. | `nljtDl5MIf` (`AdelantaSaldo`); `FBsQzP3Zfj.getDialogOperation`, case 31 | Confirmed |
| General mode | Transfer mobile balance | `tel:*234*1*<phone>*<PIN>*<amount>%23` | The Seguridad menu routes to a form; it requires an 8-digit phone, 4-character PIN, and nonempty integer amount, then confirms and dispatches the fields in this order. | `ICmtk949Og` → `C8l2t8799rL.submitForm`; `rDEl7rW1aN.actionCallUSSD(String,String,String,String,ViewGroup)` | Confirmed |
| General mode | Change mobile recharge PIN | `tel:*234*2*<new-PIN>*<repeated-PIN>%23` | The Seguridad menu routes to a form; it checks both fields and dispatches the two entered values in order after confirmation. The source mistakenly checks the first field's length twice, so the repeated PIN's 4-character length is not independently validated. | `ICmtk949Og` → `E1lhoLKryWP.submitForm`; dispatcher | Confirmed payload; source validation defect |
| General mode | Recharge mobile using bonus key | `tel:*662*<bonus-key>%23` | The bonus-recharge form requires a nonempty key, optionally prefills it from an ETECSA coupon QR, then confirms and dispatches `662*<key>` using the direct-code overload. | `ICmtk949Og` → `b0kkzvOCEu.submitForm`; `OJ3XxacXOT` QR route | Confirmed |
| General menu | Query card balance | `tel:*444*46%23` | A confirmation dialog dispatches the literal code directly; no account payload, AppConfig access code, app version, or SMS path is used by this branch. | `FBsQzP3Zfj.getAlertDialogBuilder`, case 13 | Confirmed |
| Banking | Query all registered account balances | `tel:*<access>*58%23` | A confirmation dialog dispatches selector `58` through the configured access-code overload without a payload/version. | `FBsQzP3Zfj.showDialogTodasCuentas`; `rDEl7rW1aN.actionCallUSSD(String)` | Confirmed |
| Agent mobile-recharge module | Query stock balance | `tel:*<access>*11*2%23` | The stock-balance confirmation calls the one-argument direct-dial overload with literal `11*2`. | `g1bQ0lLj6na.showDialogConsultaSaldo`; `rDEl7rW1aN.actionCallUSSD(String)` | Confirmed |
| BFI | Query balance | `tel:*<access>*46*E(<currency>*<account>)*<version>%23` | Select currency and account; transform the complete payload through `rDEl7rW1aN.code()`. Partial path uses packet gateway `110`, operation `46`, version `05`. | `BfiConsultarSaldoFragment.submitForm`; `FBsQzP3Zfj.actionCallUSSDBack` | Confirmed |
| BFI | Query limits | `tel:*<access>*62*E(<currency>*<account>)*<version>%23` | Same account payload and transform; partial path uses `110`, `62`, `05`. | `BfiConsultarLimiteFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Query account limits | `tel:*<access>*62*E(<currency>*<account>)*<version>%23` | Account form uses the same ordered currency/account payload; partial path uses gateway `110`, selector `62`, agency marker `03`. | `gkzzwVYksz.submitForm`; dispatcher | Confirmed |
| Banking menu | Query limits by currency | `tel:*<access>*62*E(1-or-2)*<version>%23` | A CUP/CUC choice sends the selected value (`1` for CUP, `2` for CUC) through the direct two-argument dispatcher. These menu paths do not attach a bank account. | `yDpeA65zCe.showDialogConsultarLimites`; `rDEl7rW1aN.actionCallUSSD(String,String)` | Confirmed |
| BFI | Query latest operations | `tel:*<access>*48*E(<currency>*<account>)*<version>%23` | Same account payload and transform; partial path uses `110`, `48`, `05`. | `BfiConsultarUltimasOperacionesFragment.submitForm`; dispatcher | Confirmed |
| BFI | Query payment priority | `tel:*<access>*28*E(<account>)*<version>%23` | Transform selected account with `rDEl7rW1aN.code()`. | `BfiConsultarPrelacionPagoFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query balance/limits | `tel:*<access>*62*E(<currency>*<account>)*<version>%23` | Transform currency and selected account. Partial path uses `110`, `62`, `01`. | `BpaBalanceQueryFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query card balance | `tel:*<access>*46*E(<currency>*<account>)*<version>%23` | Transform currency and selected account. Partial path uses `110`, `46`, `01`. | `BpaAccountQueryFragment.submitForm`; dispatcher | Confirmed |
| BPA | Query latest operations | `tel:*<access>*48*E(<service>*<currency>*<account>)*<version>%23` | Transform service, currency, and selected account in that order. Partial path uses `110`, `48`, `01`. | `BpaLastOperationsFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano / BFI | Convert CUC account to CUP | `tel:*<access>*87*E(<account>)*<version>%23` | Transform selected account with `rDEl7rW1aN.code()`. | `MetroConvertirCuentaFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay gas bill | `tel:*<access>*67*E(<account>*0*<currency>)*<version>%23` | Select account and currency, append literal service field `0`, then transform the payload. | `MetroGasPaymentFragment.submitForm`; dispatcher | Confirmed |
| Banking / Wallet | Change PIN | `tel:*<access>*69*E(<new-PIN-or-prefix*old-PIN*new-PIN>)*<version>%23` | The seven literal selector-`69` call sites use three observed payload forms: new PIN alone; old PIN + new PIN; or a literal bank-specific prefix (`03` or `05`) + old PIN + new PIN. Forms validate matching PIN confirmation; observed new-PIN lengths are four digits, except a BANDEC-labeled screen requiring five. Wallet partial-USSD calls use gateway `110`, selector `69`, agency marker `04`. | `PQmKwgxZd1.submitForm`, `B0Bcr9KURy.submitForm`, `ToMfHpA64Q.submitForm`, `FtAKxvNjrD.submitForm`, `KvpkEH7lRr.submitForm`, `FLftkSrl5R.submitForm`, `Cmok7CcIR9.submitForm` | Confirmed payload variants |
| Metropolitano | Query operations by service type | `tel:*<access>*48*E(<service-type>*<currency>)*<version>%23` | Service type is spinner position + 1, followed by currency. | `MetroBalanceQueryFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Pay water bill | `tel:*<access>*51*E(<account>*0*<currency>)*<version>%23` | Transform account, fixed service field `0`, and currency. | `MetroServiceQueryFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Change ATM/POS limits | `tel:*<access>*61*E(<ATM>*<POS>*<ATM+POS>*<currency>)*<version>%23` | Total is integer ATM + POS; a second source screen sends the same payload. | `MetroLimitChangeFragment.submitForm`, `MetroEstadoCuentasFragment.submitForm`; dispatcher | Confirmed |
| Banking / Wallet | Pay electricity bill | `tel:*<access>*41*E(<invoice>*0*[<currency-or-wallet-type>][*<source-account>])*<version>%23` | A source scan of nine dispatches finds four payload shapes: invoice + `0`; invoice + `0` + currency/wallet type; and either shape with a saved source account. Partial USSD uses gateway `110` with agency markers `01`, `02`, `03`, `04`, or `05` in the observed branches. | `CUlS6AdACy.submitForm`, `D38ae2xieeM.submitForm`, `xSwGh0MTOg.submitForm`, `Yff3Tf50gc.submitForm`, `Q3Nvf439ab.submitForm`, `XnzjMaEqy5.submitForm`, `dwdZ5sHcFR.submitForm`, `PliSaYhOg0.submitForm`; dispatcher | Confirmed variants |
| Metropolitano | Pay cashier gas bill | `tel:*<access>*67*E(<account>*0*<currency>)*<version>%23` | Transform account, fixed service field `0`, and currency. Shares selector/payload with the restored gas payment path. | `MetroCashierPaymentFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Change temporary limits | `tel:*<access>*61*E(<ATM>*<POS>*<total>*<currency>*<account>)*<version>%23` | `total` is computed as integer ATM + POS limits, then the full payload is transformed. Partial path uses `110`, `61`, `05`. | `MetroModificarLimitesFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Modify payment priority | `tel:*<access>*27*E(<priority-code>*<account>)*<version>%23` | Transform selected priority code and account. | `MetroModificarPrelacionFragment.submitForm`; dispatcher | Confirmed |
| Metropolitano | Reprint card | `tel:*<access>*74*E(<currency>*<account>*<commission-account>*<municipality>*<branch>)*<version>%23` | Read municipality and branch codes from selected entities, then transform the ordered payload. | `MetroReimprimirTarjetaFragment.submitForm`; dispatcher | Confirmed |
| General | Transfer to bank account | `tel:*<access>*45*E(<account>*<amount>*<recipient-phone-or-00000000>)*<version>%23` | Validates a 16-digit destination account, amount, and optional 8-digit phone; uses `00000000` when phone is blank. | `TransferFragment.submitForm`; dispatcher | Confirmed |
| BPA / Metropolitano | Transfer to bank account | `tel:*<access>*45*E(<destination-account>*<amount>*<currency>*<recipient-phone-or-00000000>)*<version>%23` | Same payload order appears in both bank transfer forms; blank destination phone becomes `00000000`. | `I2qACpsJwr.submitForm`, `BpaTransferFragment.submitForm`, `MetroExternalPaymentFragment.submitForm` | Confirmed |
| Banking | Extended account transfer | `tel:*<access>*45*E([<agency>*<PIN>*]<destination>*<amount>*<amount-currency>*<card-currency>*<origin-account>*<phone>*<send-mobile-flag>*<message>*<send-balance-flag>)*<version>%23` | Supports saved/new origin-account choices and an optional agency/PIN prefix. Destination, origin, phone, and message initialize to `0000`; amount and optional flags initialize to `0`. Partial packets reorder the origin-account and flag fields; the currency fields remain present. | `iN1lHDKE5h.submitForm`; `pAzq93vIl3` packet helper | Confirmed payload construction; agency/PIN branch depends on screen mode |
| BPA | Register banking access | `tel:*<access>*49*E(01*<account>*<name>*<surname1>*<surname2>*<identity>)*<version>%23` | Strip account hyphens before dispatch. Partial USSD uses gateway `110`, agency marker `01`. | `IixhA1yamp.submitForm`; BPA menu `BPARegistrarse` | Confirmed |
| BANDEC | Register banking access | `tel:*<access>*49*E(02*<account>*<name>*<identity>)*<version>%23` | Partial USSD uses gateway `110`, agency marker `02`. | `wLHKkaC4Ha.submitForm`; BANDEC menu `BANRegistrarse` | Confirmed |
| Metropolitano | Register banking access | `tel:*<access>*49*E(03*<account>*<name>*<surname1>*<surname2>*<identity>)*<version>%23` | Partial USSD uses gateway `110`, agency marker `03`. | `RFBEnXW0Xr.submitForm`; menu `METRORegistrarse` | Confirmed |
| MiTransfer | Register account access | `tel:*<access>*49*E(04*0000*<identity>*<PIN>)*<version>%23` | This Wallet registration form requests identity and a PIN; its partial path uses gateway `110`, agency marker `04`. | `eUkRSfpCKs.submitForm`; menu `BOLSARegistrarse` | Confirmed |
| MiTransfer | Authenticate wallet session | `tel:*04*40*E(04*<PIN>)*<version>%23` | Accepts exactly four PIN characters, prefixes the payload with `04*`, and dispatches using access code `04` and selector `40`; the shared dispatcher transforms the payload, appends the configured version, asks for confirmation, and starts `ACTION_CALL`. | `R5fFZkKuVnr.submitForm`; clean `WalletPinEntryFragment.submitForm`; `FBsQzP3Zfj.actionCallUSSDBack(String, ...)` | Confirmed |
| MiTransfer | Query wallet balance for a saved account | `tel:*<access>*46*E(1*<16-digit-account>*<wallet-type>)*<version>%23` | The account selector combines saved MiTransfer and enterprise classic accounts. Wallet type is the selected spinner position plus one; `tipo` remains `1`. When partial USSD is enabled, it uses gateway `110`, selector `46`, marker `08`, and a four-parameter packet limit. | `GvNasrezHU.submitForm`; `GvNasrezHU.cargarMisCuentas`; `FBsQzP3Zfj.actionCallUSSDBack` / `pAzq93vIl3.principalEnviarUSSD` | Confirmed |
| MiTransfer | Query latest operations | `tel:*<access>*48*E(1*<account-or-currency>*<wallet-type>)*<version>%23` | Uses selector `48`, with `tipo` fixed at `1` and Wallet type set to spinner position + 1. Saved MiTransfer/enterprise accounts select agency marker `08` and require a 16-character account; CUP/USD options use marker `04` and send the selected currency string. Partial USSD uses gateway `110` and a four-parameter limit. | `dI2tctjNbR.submitForm`; `dI2tctjNbR.spClickBolsa`; `dI2tctjNbR.cargarMisCuentas`; clean `WalletLatestOperationsFragment` | Confirmed and migrated into clean Java |
| BFI | Register banking access | `tel:*<access>*49*E(05*<current-PIN>*<new-PIN>*<identity>)*<version>%23` | The form validates current/new PINs and identity; partial USSD uses gateway `110`, agency marker `05`. | `umjSGajOy3.submitForm`; BFI menu `BFIRegistrarse` | Confirmed |
| Banking / Wallet | Pay fixed telephone bill | `tel:*<access>*42*E(<invoice>*<amount-or-0>*<currency>)*<version>%23` | For partial payment, sends the entered amount; for full payment, sends literal `0`. The currency field comes from the selected payment currency, separate from the invoice's detected CUP/CUC label. | `AckAnySXkn.submitForm`; variants `l2i2DeDgof.submitForm`, `p5B8KozjvpQ.submitForm`, `pxpQ3hcmYF.submitForm` | Confirmed |
| ONAT | Buy stamp (personal or company) | `tel:*<access>*43*E(2*<DPA>*<NIT>*<tax-code>*<MM/YYYY>*<amount>*<entity>*<currency>*<account>)*<version>%23` | Selector `43` has multiple ONAT payload variants. The stamp form builds the sequence shown; partial USSD uses gateway `110` and rearranges tax-code/NIT in the packet payload. | `TGMSi5UDp7.submitForm`; `FBsQzP3Zfj.actionCallUSSDBack` | Confirmed |
| ONAT | Pay tax by RC05 or NIT | `tel:*<access>*43*E(<mode>*<DPA>*<NIT>*<tribute-code>*<period>*<amount>*[<entity>*]<currency>*<account>)*<version>%23` | RC05 mode uses `1*0000*<RC05>*<RC04>*0000`; NIT mode uses `2*<province+municipality>*<NIT>*<tribute>*<month/year>`. Stamped mode inserts entity before currency/account. Partial USSD uses gateway `110` and bank markers `01`/`02`/`03`. | `WalletOnatPaymentFragment.submitForm` (`ROgpLrCtHa`); dispatcher and packet manager | Confirmed |
| ONAT | Pay tax by license or tax identifier | `tel:*<access>*43*E(<payment-mode>*<RC04>*<RC05>*<tax-code>*<amount>*<currency>)*<version>%23` | Monthly fixed uses mode `1` and RC04; annual fixed uses mode `1` and the tax-code field; declared amount uses mode `2` with RC04 and amount. Unused fields default to `0000`. This separate form uses the ordinary confirmation dispatcher. | `LLgTQRWb61.submitForm` | Confirmed |
| Banking / MiTransfer | Disconnect from bank session | `tel:*<access>*70%23` | Positive confirmation dispatches literal selector `70`; the one-argument dispatcher reads configured access code and starts `ACTION_CALL` without app version or payload encoding. Wallet and bank menu sources also clear the local bank configuration before showing the confirmation dialog. | `p97uirGL7T.showDialogCerrarSession`; `H0kVHR7zuu.showDialogCerrarSession`; `rDEl7rW1aN.actionCallUSSD(String)`; `FBsQzP3Zfj.closeSessionBank(Activity)` | Confirmed client route; server-side session effects not independently observable |
| Agent mobile-recharge module | Close session | `tel:*<access>*11*6%23` | The menu labels this operation `OP_Close_Session`/“Cerrar la sesión”; the handler calls the same direct one-argument dispatcher with `11*6`. | `g1bQ0lLj6na`; `rDEl7rW1aN.actionCallUSSD(String)` | Confirmed route; server-side session effects not independently observable |
| Mi Turno | Reserve appointment | `tel:*<access>*102*E(<bank>*<service>*<branch-DPA>*<identity>*<phone-or-0>*<currency>*<account>)*<version>%23` | Fields are assembled in this order; when partial USSD is enabled, packet helper uses gateway `110`, operation `102`. | `WalletTicketPurchaseFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Change reservation date | `tel:*<access>*105*E(<bank>*<service>*<identity>*<date>)*<version>%23` | Date is passed after identity number. | `WalletTicketDateFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Cancel reservation | `tel:*<access>*106*E(<bank>*<service>*<identity>)*<version>%23` | Requires selected service and identity number. | `WalletTicketReservationFragment.submitForm`; dispatcher | Confirmed |
| Mi Turno | Query reservation | `tel:*<access>*107*E(<bank>*<identity>)*<version>%23` | Query form accepts QR-prefilled identity data. | `WalletTicketQueryFragment.submitForm`; dispatcher | Confirmed |
| Banks | Pay general fine | `tel:*<access>*96*E(<fine-id>*<identity>*<amount>*<amount-currency-id>*<decree>*<article>*<clause>*<date>*<card-currency>*<account>)*<version>%23` | Empty article/clause default to `0000`; amount is serialized from a float; ordinary confirmation dispatcher, with no partial-packet helper in this call path. | `WalletTrafficFineFragment.enviarUSSD` (`NzOTegfhDk`); dispatcher | Confirmed |
| Banks | Pay traffic fine | `tel:*<access>*97*E(<fine-id>*0000*<article>*<inciso>*<municipality>*<province>*1*<date>*<currency>*<account>)*<version>%23` | Article/inciso may come from the local traffic catalog; municipality code is province code concatenated with municipality code. Uses the ordinary confirmation dispatcher; no partial-packet helper appears in this call path. | `WalletTrafficFineDetailFragment.enviarUSSD` (`rc7O18ZPOU`); dispatcher | Confirmed |
| MiTransfer / OFA | Reserve heritage-city activity | `tel:*<access>*8*E(<identity>*<activity-code>*<customer-type>*<quantity>*<date>*0*<total>*<currency>*<phone>*<balance-flag>*2)*<version>%23` | Activity price and total are assembled client-side; partial path uses gateway `110`, operation `8`, agency marker `04`. | `dWLcK5oQoS.submitForm`; dispatcher | Confirmed |

Here `E(x)` is the existing `rDEl7rW1aN.code(x)` transformation, `<access>` and
`<version>` come from the first `AppConfig`, and `%23` is produced by
`Uri.encode("#")`. The ordinary dispatcher asks for confirmation and starts
`ACTION_CALL`. This table describes source behavior only and does not dial any
code or include live credentials.

A static source scan finds 91 distinct numeric literal service selectors in
single-line `actionCallUSSDBack(...)` invocations under `src/`. The selector
count is not a count of user-visible operations: several operations share a
selector, and other call sites use dynamic selectors or different dispatch
overloads. The inventory is therefore still incomplete.

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
