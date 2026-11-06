# Traffic and general fine payments

The client has two source-confirmed fine payment forms. They use separate selectors and payload schemas. Both build the encoded payload with `rDEl7rW1aN.code()` through `FBsQzP3Zfj.actionCallUSSDBack`, show a confirmation dialog, and dial only after confirmation.

## General fine payment — selector 96

`WalletTrafficFineFragment.enviarUSSD()` constructs the fields in this order:

`<fine-id>*<identity>*<amount>*<amount-currency-id>*<decree>*<article>*<clause>*<fine-date>*<card-currency>*<source-account>`

- Amount currency ID is `1` or `2` for the two options exposed by `currency_no_cuc`; the confirmation label maps those values to CUP and USD.
- Empty article or clause values are sent as `0000`.
- The amount is parsed as a Java `float` and serialized with `String.valueOf(float)` for the payload. The confirmation display separately formats it to two decimals.
- Validation checks the fine ID, identity, amount, amount currency, selected account, date and the form's other required fields before dispatch.
- The form calls the ordinary confirmation dispatcher with selector `96`; source does not show a partial-USSD packet helper on this path.

## Traffic fine — selector 97

`WalletTrafficFineDetailFragment.enviarUSSD()` constructs:

`<fine-id>*0000*<article>*<clause>*<municipality-code>*<province-code>*1*<fine-date>*<card-currency>*<source-account>`

- Province code comes from the selected province. Municipality code is province code concatenated with municipality code.
- The second field is the literal `0000`; the currency/type field is the literal `1` in this form.
- Article and clause values can come from the selected traffic-offense data (`MultasTransito`); untouched values use `0000` sentinels.
- The form validates fine ID, article/clause selection, province, municipality, date and source account before dispatch.
- It also calls the ordinary confirmation dispatcher with selector `97`; there is no partial-USSD packet construction in this call path.

## Shared dispatch behavior and evidence limits

The dispatcher reads the configured access code and app version, transforms the entire payload, builds `tel:*<access>*<selector>*<encoded-payload>*<version>%23`, and opens a confirmation dialog. The user must confirm before `ACTION_CALL` starts; cancel leaves the form in place. This establishes client-side construction and routing, not successful bank-side payment or settlement.

Raw source: [`NzOTegfhDk.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/NzOTegfhDk.java) (`enviarUSSD`, general selector `96`), [`rc7O18ZPOU.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/rc7O18ZPOU.java) (`enviarUSSD`, traffic selector `97`), and [`FBsQzP3Zfj.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java) (`actionCallUSSDBack`). The clean reconstructions are [`WalletTrafficFineFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/wallet/WalletTrafficFineFragment.java) and [`WalletTrafficFineDetailFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/wallet/WalletTrafficFineDetailFragment.java).
