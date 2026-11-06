# ONAT tax payment flows

Selector `43` is shared by multiple tax-payment screens. Treating it as one form hides real differences in payment mode, field order, defaults, and partial-USSD routing. This note records the three builders currently present in the source.

## RC05 / NIT form (`WalletOnatPaymentFragment`)

The form has two `y2Cht3lmjg` modes:

| Mode | Payload before encoding | Client-side selections |
| --- | --- | --- |
| `PagoRC05` | `1*0000*<RC05>*<RC04-tribute>*0000*<amount>*<card-currency>*<account>` | RC04 is selected from the fiscal-vector data. DPA and period retain the `0000` defaults. |
| `PagoNIT` | `2*<province+municipality>*<NIT>*<tribute-code>*<period>*<amount>*<card-currency>*<account>` | Province and municipality form DPA; period comes from the selected month/year. |

For stamped payments, the form validates and inserts an entity code before currency and account, and uses the stamp period. Both modes validate amount and source account; RC05 mode validates the fiscal vector, while NIT mode validates NIT, province, municipality, tribute, and period. The regular route uses `actionCallUSSDBack` selector `43`. With partial USSD enabled, it instead uses `principalEnviarUSSD` with gateway `110`, selector `43`, a bank marker (`01` BPA, `02` BANDEC, `03` Metropolitano), and the configured packet-size limit.

## License / tax-identifier partial payment (`LLgTQRWb61`)

This separate form selects among monthly fixed, annual fixed, and declared-amount partial payments. Its ordered payload is:

`<payment-mode>*<RC04>*<RC05>*<tax-code>*<amount>*<card-currency>`

- Monthly fixed: mode `1`, RC04 from input; RC05 from input; tax code and amount default to `0000`.
- Annual fixed: mode `1`, the entered code goes into the tax-code field; RC04 and amount default to `0000`.
- Declared amount: mode `2`, RC04 and amount from input; tax code defaults to `0000`.

This form uses the ordinary selector `43` confirmation dispatcher and its own validation for the RC04/tax code, RC05, amount, and currency. It does not add DPA, period, entity, or account fields in its payload.

## Dispatch and limits of evidence

The ordinary dispatcher reads the configured access code and version, transforms the payload with `code()`, and asks the user to confirm before dialing. The partial route is specifically shown in the `WalletOnatPaymentFragment` source branch; the separate `LLgTQRWb61` form has no partial-packet branch. Source confirms client payload construction and call initiation, not acceptance or settlement by ONAT.

Raw sources: [`ROgpLrCtHa.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/ROgpLrCtHa.java), [`LLgTQRWb61.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/LLgTQRWb61.java), and [`FBsQzP3Zfj.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java) for menu routing and dispatch helpers.
