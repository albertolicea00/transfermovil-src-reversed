# USSD code catalog and dispatch evidence

Target: Transfermóvil 1.260416 (`cu.etecsa.cubacel.tr.tm-v162.apk`). This document is reserved **only** for USSD codes sent by the client, what each code does, and how each dial string is constructed. SMS, HTTP, and UI implementation details belong in their existing documents.

The current [telephony analysis](telephony.md) is the starting point. Its lists and inferred purposes need to be checked against callers before they become entries here. No code should be dialed while building this catalog; use static analysis and offline examples with dummy values.

## Coverage and reproduction

Static catalog refreshed 2026-11-13. The [complete dispatch evidence inventory](ussd-dispatch-inventory.md) contains **797 syntactic invocations across 317 raw Java files**, including multiline and dynamic calls, plus **53 URI/platform-send evidence lines**. It preserves every ordered argument expression and source location. Counts overlap between wrapper and platform layers; they are neither executed-operation counts nor proof of runtime reachability. SMS/HTTP-only operations and ordinary telephone calls are distinguished below.

Run `python3 scripts/ussd-inventory.py --check` to verify the appendix or use `--json` for machine-readable operands. The semantic table remains a confirmed subset; construction families, direct codes, dynamic-selector variants, numeric/text encoding, packets and uncertainty boundaries follow it. The appendix makes remaining variable/dataflow questions reviewable without pretending that a lexical scan resolved them.

## Confirmed semantic entries

The operations listed here are confirmed from reconstructed call sites and shared
dispatchers. The list is a partial catalog; packet mechanics are documented in
[telephony notes](telephony.md#ussd-packet-protocol-pazq93vil3), while operation
and menu coverage remains open.

The source paths below provide readable semantic examples. The generated appendix, rather than a single-line grep count, is the reproducible call-site inventory.

| Service / bank | User action | Dial string template | Construction algorithm | Source evidence | Confidence |
| --- | --- | --- | --- | --- | --- |
| Banking / MiTransfer | Query union dues by identity number | `tel:*<access>*121*E(<bank-id>*<identity-number>)*<version>%23` | Bank IDs are `1` BPA, `2` BANDEC, `3` Metropolitano, and `4` MiTransfer. The identity text is checked for nonblank content but sent without trimming. The shared dispatcher encodes the payload and adds the configured version. | `WalletSyndicateQueryFragment.submitForm` / `SlZq2dCM9i`; `FBsQzP3Zfj.actionCallUSSDBack(Context, String, String, String, ViewGroup, FragmentManager)` | Confirmed client route |
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
| MiTransfer | Pay water bill | `tel:*<access>*19*E(1*<invoice>*<amount>*<payment-type>*0000*2)*<version>%23` for Havana; `tel:*<access>*21*E(2*<invoice>*<amount>*<payment-type>*0000*2)*<version>%23` for Varadero | Uses region IDs `1`/`2`; payment type and amount are selected by the form, and wallet type is fixed to `2`. Partial requests use gateway `110`, marker `04`, and a stored parameter-count hint of four (unused by the active character splitter). | `U1sIOmca96i.submitForm`; clean `WalletWaterPaymentFragment`; `wallet-water-payment.md` | Confirmed |
| Bank water-payment forms | Pay water bill (Havana region) | `tel:*<access>*19*E(1*<invoice>*<amount>*<payment-type>*<currency-or-0>*<source-account>)*<version>%23` | Three forms use the same selector/payload layout with varying partial gateway markers: `01` (`zOs55UzH6z`), `03` (`BoMBck6OXT`), and `05` (`LHLbFzX21y`). A BANDEC-oriented form uses literal `0` in the currency slot and marker `02` (`T4RQ5wDJDt`). | `zOs55UzH6z`, `BoMBck6OXT`, `LHLbFzX21y`, `T4RQ5wDJDt`; `pAzq93vIl3` | Confirmed source variants |
| Bank water-payment form | Pay water bill (other region choices) | `tel:*<access>*51*E(2*<invoice>*<amount>*<payment-type>*<source-account>)*<version>%23`; `tel:*<access>*21*E(3*<invoice>*<amount>*<payment-type>*0*<source-account>)*<version>%23` | In `T4RQ5wDJDt`, region `2` routes selector `51` without the zero field; other region choice routes selector `21` with the zero field. Both partial routes use gateway `110`, marker `02`, four parameters. | `T4RQ5wDJDt.submitForm`; `pAzq93vIl3` | Confirmed |
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
| MiTransfer | Authenticate wallet session | `tel:*<access>*40*E(04*<PIN>)*<version>%23` | Accepts exactly four PIN characters, prefixes the payload with `04*`, and dispatches using bank-session marker `04` and selector `40`; the actual access prefix remains configured in `AppConfig`; the shared dispatcher transforms the payload, appends the configured version, asks for confirmation, and starts `ACTION_CALL`. | `R5fFZkKuVnr.submitForm`; clean `WalletPinEntryFragment.submitForm`; `FBsQzP3Zfj.actionCallUSSDBack(String, ...)` | Confirmed |
| MiTransfer | Query wallet balance for a saved account | `tel:*<access>*46*E(1*<16-digit-account>*<wallet-type>)*<version>%23` | The account selector combines saved MiTransfer and enterprise classic accounts. Wallet type is the selected spinner position plus one; `tipo` remains `1`. When partial USSD is enabled, it uses gateway `110`, selector `46`, marker `08`, and a stored parameter-count hint of four (unused by the active character splitter). | `GvNasrezHU.submitForm`; `GvNasrezHU.cargarMisCuentas`; `FBsQzP3Zfj.actionCallUSSDBack` / `pAzq93vIl3.principalEnviarUSSD` | Confirmed |
| MiTransfer | Request CUP cash-deposit ticket | `tel:*<access>*17*E(<amount>*CUP)*<version>%23` | The wallet form requires an amount of at least `1` unless its `pagoTotal` mode is set. It confirms the amount as a CADECA deposit ticket to the CUP account. Partial mode uses gateway `110`, selector `17`, marker `04`, and a stored parameter-count hint of four (unused by the active character splitter). The response callback does not process the USSD result. | `P8DtkaSW4dR.submitForm` / `validateMonto`; clean `WalletRechargeFragment`; dispatcher and `pAzq93vIl3.principalEnviarUSSD` | Confirmed |
| MiTransfer | Request FWA data-package offers | `tel:*<access>*18*E(<account>*1501*USD*1)*<version>%23` | Requires an account string of length 8 or 10 and the USD wallet option. The hidden service-type selector does not affect the request; the final wallet-type field is `1`. The form asks for confirmation to display available offers. The observed path uses the standard dispatcher, with no partial-USSD branch. | `q55ExEc6x2l.submitForm` / `validateCuenta`; clean `FwaDataPackagePurchaseFragment`; `wallet-fwa.md` | Confirmed client request; offer retrieval not independently observed |
| MiTransfer | Recharge FWA balance | `tel:*<access>*20*E(<account>*<amount>*USD*1)*<version>%23` | Account must be 8 or 10 characters and amount must be nonempty; the form does not parse the amount or enforce a numeric range. USD is the only wallet option and maps to `1`. The standard dispatcher is used, with no partial-USSD branch. | `wbFn8tBw8W.submitForm` / `validateCuenta` / `validateMonto`; clean `FwaBalanceRechargeFragment`; `wallet-fwa.md` | Confirmed |
| MiTransfer | Query latest operations | `tel:*<access>*48*E(1*<account-or-currency>*<wallet-type>)*<version>%23` | Uses selector `48`, with `tipo` fixed at `1` and Wallet type set to spinner position + 1. Saved MiTransfer/enterprise accounts select agency marker `08` and require a 16-character account; CUP/USD options use marker `04` and send the selected currency string. Partial USSD uses gateway `110` and a stored parameter-count hint of four (unused by the active character splitter). | `dI2tctjNbR.submitForm`; `dI2tctjNbR.spClickBolsa`; `dI2tctjNbR.cargarMisCuentas`; clean `WalletLatestOperationsFragment` | Confirmed and migrated into clean Java |
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
| Banking | Query fine by identifier | `tel:*<access>*98*E(<fine-type>*<fine-id>*<identity-or-0000>*<license-or-0000>)*<version>%23` | Contravention sets `fine-type=1` and fills identity; traffic sets `fine-type=2` and fills driver-license number. The unused identity/license slot is literal `0000`. Partial mode routes through gateway `110`, selector `98`, marker `02`, and the packet helper; ordinary mode uses the confirmation dispatcher. | `ULFE6hmQU6.submitForm` / `enviarUSSD`; `pAzq93vIl3.principalEnviarUSSD`; `FBsQzP3Zfj.actionCallUSSDBack` | Confirmed |
| MiTransfer | Validate QR ticket | `tel:*<access>*119*E(<identity>*<PIN>*<token>*<detail-id>*<amount-text>)*<version>%23` | After decoding QR ticket data, the form assembles identity, PIN, token, the first detail ID, and the amount field's text in order, then confirms with “¿Desea validar el boleto?”. The amount text can be empty when no currency is selected. The observed path uses the ordinary dispatcher. | `wfroNBIJF7.SubmitForm`; General and Agent home-menu routes in `S9ycHcoxAzy` and `IHVTCBmiLV` | Confirmed client payload; server effect not independently observed |
| MiTransfer / OFA | Reserve heritage-city activity | `tel:*<access>*8*E(<identity>*<activity-code>*<customer-type>*<quantity>*<date>*0*<total>*<currency>*<phone>*<balance-flag>*2)*<version>%23` | Activity price and total are assembled client-side; partial path uses gateway `110`, operation `8`, agency marker `04`. | `dWLcK5oQoS.submitForm`; dispatcher | Confirmed |

Here `E(x)` is the existing `rDEl7rW1aN.code(x)` transformation, `<access>` and
`<version>` come from the first `AppConfig`, and `%23` is produced by
`Uri.encode("#")`. The ordinary dispatcher asks for confirmation and starts
`ACTION_CALL`. This table describes source behavior only and does not dial any
code or include live credentials.

## Construction families

`A` means the first configured `AppConfig.getCodigo()`; `V` means its `getNumber()`. These are configuration strings, not necessarily a bank identifier or APK `versionName`. Some overloads use the `codigoAcceso` resource if no configuration exists; others leave empty strings. `P` is the caller's ordered payload, `S` a selector, and `E(P)` the encoder below. A selector has meaning inside its gateway and payload schema; it is not an enum ordinal.

| Family / source | Actual URI or request construction | Important distinction |
| --- | --- | --- |
| `rDEl7rW1aN.actionCallUSSD(codeAcc, S, P, message, group)` at line 636 | `tel:*codeAcc*S*P%23` | Explicit gateway, raw payload, no configured version or `E`. Used by mobile `234` forms. |
| Three-argument `actionCallUSSD(codeToSend, message, group)` at line 656 | `tel:*codeToSend%23` | Raw carrier code, such as `662*coupon`; no configured access code. |
| One-argument `actionCallUSSD(S)` at line 676 | `tel:*A*S%23` | No payload or version; `S` can itself contain `*`, e.g. `11*2`. |
| Two-/four-argument `actionCallUSSD(S,P,...)`, `actionCallUSSDBack`, `actionCallUSSDCodeAccess` | `tel:*A*S*E(P)*V%23` | The explicit `CodeAccess` variant substitutes its supplied access value. Confirmation/back-stack behavior differs; bytes follow the same family. |
| `FBsQzP3Zfj.actionCallUSSDBack` and observer/return/HTTP variants | `tel:*A*S*E(P)*V%23` | The three-argument instance method returns a URI rather than executing a call. Methods computing URI length are not dispatches. |
| `FBsQzP3Zfj.actionCallUSSDBack(banco,context,S,P,...)` at lines 503/547 | `tel:*A*S*E(P)*V%23` | `banco` sets local bank-session metadata; it does **not** replace `A`. |
| `FBsQzP3Zfj.actionCallUSSDSimple` at line 112 | `tel:*A*S*P*V%23` | Raw payload; surveys deliberately skip `E`. |
| `FBsQzP3Zfj.getAlertDialogBuilder` at line 1513 | Default `tel:codeToSend%23`; nonempty access-platform argument selects configured encoded family | Source tests string-reference inequality against `BuildConfig.FLAVOR`, not value equality. Current literal-code routes pass that exact empty constant. |
| Four activation-screen local helpers `actionCallUSSDSoloSolHabilitarCodigo` | `tel:*A*S*P%23` | Raw activation payload already embeds app version; no second version suffix. Missing config falls back to access resource. |
| `LALCrDPvhM.showSendUSSD(source,operation,...)` | `tel:*source[*operation]%23` | Optional second segment omitted only for empty operation. |
| `principalEnviarUSSD` / `pAzq93vIl3` | `*A*gateway*PPNN*mmss*operation*agency*chunk*V#` | See packet rules below. Gateway `110` is an envelope; original operation remains a separate field. |

Source bodies: [base overloads](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L636), [shared overloads](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L96), and every original operand/URI expression in the [dispatch evidence inventory](ussd-dispatch-inventory.md). `%23` is only URI escaping for the terminator. Other user payload fields are not generally URI-escaped by these builders; encoding and field validation are separate operations.

## Literal carrier and legacy-menu codes

These bypass configured `A`/`V` and `E`. The table records client intent from the source enum/menu and confirmation, without asserting carrier-side behavior. Duplicate direct/menu routes are retained in the appendix.

| Literal dial string | Client purpose / source operation | Evidence |
| --- | --- | --- |
| `*222#` | Prepaid balance (`ConsultaSaldo222`) | `FBsQzP3Zfj.getDialogOperation`, case 3; `FNRzUmC7E5` line 105 |
| `*111#` | Postpaid balance (`ConsultaSaldo111`) | Case 4; `FNRzUmC7E5` line 127 |
| `*222*266#` | Bonus status | Case 19; `LALCrDPvhM.showSendUSSD` caller |
| `*133#` | Plan-management menu | Case 20; same carrier helper |
| `*222*328#` | Data plan | Case 21 |
| `*222*869#` | Voice plan | Case 22 |
| `*222*767#` | SMS plan | Case 23 |
| `*222*264#` | Amigos plan | Case 24 |
| `*234*3#` | Advance balance | Case 31 |
| `*234*1*phone*PIN*amount#` | Mobile balance transfer | `C8l2t8799rL.submitForm`; explicit-gateway base overload |
| `*234*2*PIN*repeat#` | Recharge-PIN change | `E1lhoLKryWP.submitForm`; same explicit-gateway overload |
| `*662*coupon#` | Coupon recharge | `b0kkzvOCEu.submitForm`; raw-code overload |
| `*444*3#` | Agent latest fixed-phone payments (`AGUltimosPago`) | `getDialogOperation` case 5 |
| `*444*13#` | Agent recharge stock balance (`AGConsultarSaldo`) | Case 6 |
| `*444*15#` | Agent latest mobile recharges (`AGUltimasRecargas`) | Case 7 |
| `*444*16#` | Agent recharge disconnect (`AGDesconectar`) | Case 8 |
| `*444*91#` | Agent latest Nauta recharges (`AGConsultarNautaUlt`) | Case 9 |
| `*444*46#` | Card balance | Case 13 |
| `*444*48#` | Latest banking operations | Case 14 |
| `*444*70#` | Disconnect bank/wallet session | Cases 12/15/17/64 |
| `*444*68*02#` | Delete BANDEC registration | Case 16 |
| `*444*62#` | Banking limits | Case 26 |
| `*444*58#` | All-account balance | Cases 28/30 |

The literal `444` menu routes coexist with configured-access routes; do not rewrite them as `A` merely because a default configuration may use that value. `tel:104`–`107`, `tel:103`, normal mobile calls and `tel:*99phone` are telephone call paths, not USSD submissions. They remain visible in the sink audit to make that exclusion reviewable. The current `getDialogOperation` cases and their enum switch mapping are in [FBsQzP3Zfj](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L882).

## Configuration, activation and dynamic selector variants

| Dial schema / selector | Client action and payload algorithm | Evidence |
| --- | --- | --- |
| `*A*100*V#` | First configuration/version validation; both main activities send this when creating `AppConfig` or handling its `new_version` marker. No payload transform. | `IHVTCBmiLV.ValidateVersion` lines 871/882; `S9ycHcoxAzy` lines 760/771 |
| `*A*80*1*app-version#` | Request agent activation code | `W2FmEAMdovs.solicitarCodigoAuthUSSD`, lines 193–209 |
| `*A*80*10*app-version#` | Request module activation code; subtype `10` is a literal in both source helpers | `eD2GCZ4Vix` lines 215–231; `xtUiphIcBa` lines 178–194 |
| `*A*123*11*app-version#` | Request MiBoleto module activation code | `b3vEPrhNHF` lines 199–215 |
| `*A*80*3*rating*V#` | User experience survey: integer rating sent raw; one UI variant checks `rating>0`, the other does not | `FBsQzP3Zfj.crearEncuestaUsuarios` / `encuestaUsuarios`, lines 817/838 |
| `*A*11*2#`, `*A*11*4#`, `*A*11*6#` | Agent recharge stock, latest recharges, and disconnect; one-argument raw configured dispatcher | `g1bQ0lLj6na` lines 106/147/126 |
| Encoded selector `13` | Agent/general mobile recharge form's declared `codeService`; payload `phone*amount*currencyOrBag` | `f03gMUuBeK` field line 63 and submit line 155 |
| Encoded selector `10` | Agent/general Cubacel packages: `phone*package-id*package-ussd-version*currency*wallet-type` | `tKjjxHr2PT` field line 68 and submit lines 198–200 |
| Encoded selector `6` | MiTransfer Cubacel packages; same package metadata field order, wallet selections differ | `WyYHxgzYyW` field line 68 and submit line 200 |
| Encoded selectors `54` / `23` | MiTransfer mobile top-up branch sets `codeService` by selected wallet/currency; do not collapse the two paths | `zzyNbaqs1U` lines 108/112 and submit line 157 |
| Encoded selector `215` | Channel-dependent payment form; payload and channel-dependent confirmation come from the form, not a universal “voting” selector | `cdINOtQ3iN`, `actionCallUSSDBack454` line 419 |
| Encoded selector `220` | Extended account transfer with optional PIN/flags; packet gateway `110`, agency `08`; ordinary vs return callback branches share selector | `Z3kYdPwq6K2`, lines 424–428 |

Other dynamically passed selectors (`operacion`, `codeOper`) belong to shared menu/packet wrappers. Their original caller operands are preserved in the appendix rather than replaced with guessed numeric values. The full 332-value `FdonIAFI9w`/`BankOperationCode` enum also includes settings, screen routing and SMS/HTTP actions; its ordinal is not a USSD code. For example `VotoMovil` routes to SMS and `Bulevar` is commerce. An enum-only or database-defined route is not evidence that a corresponding USSD request exists. Source `goToFragment` chooses a database fragment or the central dialog switch; bank-specific menus also bypass that registry. This is why the catalog follows dispatch operands and sinks instead of asserting one code per enum.

## Payload transform `E`

The smali-backed algorithm has these ordered steps:

1. Split the caller payload on literal `*` using Java `String.split`, including its trailing-empty-field behavior. Record the original length of every digit-only field; mark nonnumeric fields with length `0`. `esEntero` uses `Character.isDigit`, not an ASCII-only regular expression; later decimal parsing can still fail for some inputs.
2. Build a substitution permutation from the **1,250-bit** `crude_code` and the **18-digit** `code_version`. For each version digit, skip that many bits, consume the next eight as a binary integer, and cycle the version index back to zero after its last digit. The current constants produce **100 distinct entries, 0–99**, consuming the input exactly.
3. Draw one integer seed `0..99` for the call. Substitute numeric fields in two-digit groups through the table; pad each substituted pair to two decimal digits. For an odd final digit, use the single-digit permutation obtained by retaining table values below ten in table order.
4. Form the per-field XOR key starting again at the same seed for each field. For each input character, if the index equals `table.size()-1` (99), append `table[0]` and set the index to `1`; otherwise append `table[index]` and increment it. This preserves the source's unusual skip of key-table slot 99 rather than substituting ordinary modulo-100 wrapping. Concatenate those values' unpadded decimal spellings and truncate to the substituted numeric text's length. Parse both as Java `long` and XOR them. Decimal output is not padded back to the input width; the original-length prefix preserves that information. Overflow/empty numeric text can throw.
5. Nonnumeric fields use `kR22DOzTiB.getCodes` and `EKB7Plln4L`'s character dictionary. Preserve numeric and text fields in their original order. Unknown dictionary characters stringify as `null` rather than receiving an invented replacement. All-text inputs use seed prefix `00`.
6. Prefix seed and original field lengths with at least two decimal digits. Concatenate seed plus first length/value; join subsequent field length/value pairs with literal `*`. A text field's length marker is `00`, regardless of its original character count.

**Decompiler repair and verification limit:** JADX's `YzK9tTZsYVnC5kFxSie` loses the version-index reset, holds the final digit, and eventually throws when only six bits remain for `substring(0,8)`. Earlier JVM comparisons could pass by matching that exception in both original/clean code. The APK's actual loop resets the index at `:goto_0`; this is a source-oracle repair justified by bytecode, not an intentional protocol change. Clean implementation/tests must compare successful values as well as exceptions. Raw JADX is retained unchanged as evidence.

Reproduce bytecode evidence without touching tracked source:

```sh
apktool d -r -o /tmp/transfermovil-ussd-smali .workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk
# Inspect AFm1GraXBXUkpF1hmOdV/YzK9tTZsYVnC5kFxSie.smali under the decoded smali directory.
# At the last code_version digit: if-ne v3,last,:cond_0; goto :goto_0.
# :goto_0 sets v3=0; the non-last branch increments and jumps to :goto_1.
PYTHONDONTWRITEBYTECODE=1 python3 -m unittest discover -s scripts/tests -p test_ussd_encoding.py -v
```

### Offline fixed-seed vectors

These outputs were derived from the source encoder with the smali-backed reset and seed fixed to `42` in temporary JVM copies. The production seed remains random. All credentials/account-like strings below are dummy inputs; no request was sent.

| Input `P` | `E(P)` at seed 42 |
| --- | --- |
| `1` | `42013` |
| `12` | `42025` |
| `1*0` | `42013*011` |
| `1*2` | `42013*014` |
| `01*0000000000000001` | `420257*167167513568805339` |
| `1*user@nauta.cu` | `42013*0081199331649259814559158281` |
| `CUP` | `0000601044` |
| Empty string | `NumberFormatException` |
| `***` | `ArrayIndexOutOfBoundsException` after Java splitting removes all trailing empty fields |

For dummy `A=999`, `S=46`, `P=1*0`, `V=00`, the encoded URI family yields `tel:*999*46*42013*011*00%23`. The literal carrier family for `234`, option `1`, dummy phone `50000000`, PIN `0000`, amount `1` yields `tel:*234*1*50000000*0000*1%23`; it never calls `E`. These examples illustrate wire construction, not accepted bank/carrier credentials.

## Packet construction and response sequencing

The active character splitter takes `E(P)`, splits at `*`, and grows chunks under `currentLength + nextTokenLength + 32 <= 52`. The first token of a chunk is accepted even if over the budget, so 52 is not an independently enforced maximum emitted request length. Empty tokens are skipped. Each chunk starts with `*` inside the concatenated packet body.

For one-based position `p` and packet count `n`, pad each to at least two decimal digits and concatenate `PPNN`; append local `mmss` as the sequence ID. Emit `*A*gateway*PPNN*mmss*operation*agency*chunk*V`. `agency` is the caller's packet routing marker, not the AppConfig access prefix. Typical markers are `01` BPA, `02` BANDEC, `03` Metropolitano, `04` MiTransfer, `05` BFI and `08` account/classic flows; retain the exact caller value for a variant. The hint called `MAX_PARAMETERS_PQUETE`/`maxParametersXPqte` is stored, but the active character splitter does not use it. A declared value of four does not establish a four-field packet limit.

On Android 26+, `MX9gh9mLxd.sendNextUssd()` appends literal `#` and uses `TelephonyManager.sendUssdRequest`, not a `tel:` URI. It advances after a response containing `siendo procesada,`; other responses and failures stop that automatic chain. Below 26, accessibility capture advances `sendDataUSSD`, which appends `Uri.encode("#")` to a `tel:` URI. The nine-argument overload's pre-26 one-packet branch falls back to the ordinary encoded dispatcher, so it emits the original operation family rather than the packet envelope. A manual send callback can select a packet explicitly. `MAX_FALLAS_USSD=3` is not an active retry policy: no increment/retry use was found. Detailed state flow and platform limits remain in [telephony notes](telephony.md#ussd-packet-protocol-pazq93vil3).

Packet examples must fix `mmss`, seed and configuration to compare bytes. With dummy `A=999`, gateway `110`, operation `46`, agency `05`, `E(P)=42013*011`, `V=00`, `mmss=1234`, the tokens fit one chunk, giving `*999*110*0101*1234*46*05*42013*011*00#` on the API-26+ send path. Pre-26 via the nine-argument single-packet fallback emits the ordinary `*999*46*E(P)*00#` family instead. No packet is sent by these offline examples.

## Remaining uncertainty boundaries

- The appendix enumerates every tracked Java call in the documented dispatch families and every literal telephone construction line. It does not prove that every call is reachable in a real account/device state or recover code missing from JADX methods automatically.
- Confirmed table rows describe caller intent and ordered fields. The appendix retains all other caller operands and baseline source roles so unresolved variable- or database-defined routing remains visible; there is no invented one-to-one mapping from all 332 operation enum values to selectors.
- Client code cannot establish carrier acceptance, server accounting effects, live permissions/SIM behavior, backend response contracts, or feature availability. Those remain unexecuted external validation, not completed static findings.
