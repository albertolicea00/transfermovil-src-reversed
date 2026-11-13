# USSD dispatch evidence inventory

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256 `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

Companion to the [USSD catalog](ussd-code-catalog.md). This inventory records **797 syntactic invocation sites across 317 raw Java files**, followed by **53 telephone-URI construction/platform-send evidence lines**. Sites are not unique operations and do not prove runtime execution, reachability, successful encoding, carrier acceptance, or server effects. Parameter variables retain their original names; open the linked source to inspect assignments/validation and use the protocol-family rules in the catalog. Wrapper calls and platform calls overlap intentionally. Ordinary telephone links and a length-only URI calculation remain in the sink audit; they are not USSD operations.

This is a complete lexical inventory for the listed method families and `tel:` literals in tracked `src/`, including multiline calls and dynamic operands. It is not a whole-program dataflow/reachability proof. Smali-only bodies absent from Java, reflection, arbitrary string-driven destinations, and server-side operations are outside extraction.

## Reproduction

Run `python3 scripts/ussd-inventory.py --check` to verify this snapshot, or `python3 scripts/ussd-inventory.py --output docs/ussd-dispatch-inventory.md` to regenerate it. `--json` emits all operands as JSON. The scanner masks comments/literals for call recognition, balances delimiters to split top-level arguments, excludes declarations, and preserves original operand expressions. It does not execute Java or contact a device. Role notes come from the baseline classification ledger; they do not prove a particular branch's server-side purpose.

## Method counts

| Method | Invocation sites |
| --- | ---: |
| `actionCallUSSD` | 318 |
| `actionCallUSSDBack` | 287 |
| `actionCallUSSDBack454` | 1 |
| `actionCallUSSDBackAsocClasica` | 3 |
| `actionCallUSSDBackHttp` | 2 |
| `actionCallUSSDBackWithRetun` | 6 |
| `actionCallUSSDNOBack` | 4 |
| `actionCallUSSDNoBackSimple` | 4 |
| `actionCallUSSDSimple` | 2 |
| `actionCallUSSDSoloSolHabilitarCodigo` | 4 |
| `getAlertDialogBuilder` | 24 |
| `principalEnviarUSSD` | 125 |
| `sendDataUSSD` | 3 |
| `sendUssdRequest` | 5 |
| `sendUssdRequests` | 2 |
| `showSendUSSD` | 7 |

## Invocation evidence by source

Arguments retain original order, one invocation per row. `principalEnviarUSSD` carries context, gateway, operation, agency, stored parameter-count hint, payload, confirmation, group, and fragment manager. The active splitter uses a character budget rather than that hint. `actionCallUSSD` overloads differ by arity; use the catalog before treating the first numeric argument as a global selector.

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/CBIHzlCw60.java`

Baseline source role/evidence: Nauta menu screen builds recharge/latest-payment actions; routes recharge to `NdeFyyhxF1`, offers selector `91` or the recent-recharge form `Kw29o4NNrz`, and owns the menu/dialog flow.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [CBIHzlCw60.java:77](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/CBIHzlCw60.java#L77) | `actionCallUSSD` | 1. `"91"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/Kw29o4NNrz.java`

Baseline source role/evidence: Nauta latest-recharge query form loads saved account types, handles international/national selection, validates the account, persists its selected type, and dispatches selector `91` with account and type.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Kw29o4NNrz.java:151](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/Kw29o4NNrz.java#L151) | `actionCallUSSD` | 1. `"91"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |
| [Kw29o4NNrz.java:153](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/Kw29o4NNrz.java#L153) | `actionCallUSSD` | 1. `"91"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/NdeFyyhxF1.java`

Baseline source role/evidence: Nauta recharge form loads saved accounts/destination phones, distinguishes international and national account types, accepts bonus/ticket values, validates optional notification phone, persists selections, and dispatches selector `90`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [NdeFyyhxF1.java:182](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/NdeFyyhxF1.java#L182) | `actionCallUSSD` | 1. `"90"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/pECcPKxF9i.java`

Baseline source role/evidence: Nauta balance-query form loads saved account types, handles international/national selection, validates the account, persists its type, and dispatches selector `92` with account and type.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [pECcPKxF9i.java:132](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/pECcPKxF9i.java#L132) | `actionCallUSSD` | 1. `"92"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/A9IFPpW4HW.java`

Baseline source role/evidence: Agent/mobile recharge form validates an 8-digit phone and amount, saves new phone contacts, then dispatches selector `12` with phone and amount; instantiated by the service menu and the shared dynamic Cubacel operation menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [A9IFPpW4HW.java:70](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/A9IFPpW4HW.java#L70) | `actionCallUSSD` | 1. `"12"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/VqNI4JnvJD.java`

Baseline source role/evidence: Agent PIN-change form validates two four-character entries and equality, then submits selector `11` with option `3` and the new PIN twice; reached from the agent menu and shared Cubacel operation menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [VqNI4JnvJD.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/VqNI4JnvJD.java#L53) | `actionCallUSSD` | 1. `"11"`<br>2. `cadena + "*" + cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/cwVwMsOO60.java`

Baseline source role/evidence: Agent recharge-authentication form requires a four-character PIN and dispatches selector `11` with option `1` and the PIN; instantiated by the agent menu and shared Cubacel operation menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [cwVwMsOO60.java:47](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/cwVwMsOO60.java#L47) | `actionCallUSSD` | 1. `"11"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java`

Baseline source role/evidence: Agent-service menu routes authentication, recharge, and PIN change to forms; dispatches balance/close-session selectors `11*2`/`11*6` and latest-recharge selector `11*4`, with an option for a phone-specific query. Host route is `wRqLBJvNq6`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [g1bQ0lLj6na.java:106](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java#L106) | `actionCallUSSD` | 1. `"11*2"` |
| [g1bQ0lLj6na.java:126](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java#L126) | `actionCallUSSD` | 1. `"11*6"` |
| [g1bQ0lLj6na.java:147](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java#L147) | `actionCallUSSD` | 1. `"11*4"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/yzFfgPWLpL.java`

Baseline source role/evidence: Phone-specific latest-recharge form loads/saves known mobile numbers, validates an 8-digit number, then dispatches selector `11` with option `4` and the phone; routed from the agent menu and shared Cubacel operation menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yzFfgPWLpL.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/yzFfgPWLpL.java#L66) | `actionCallUSSD` | 1. `"11"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JM38ENT2L0.java`

Baseline source role/evidence: Fixed-phone payment rectification form validates a nonempty transaction identifier and dispatches selector `4` with that identifier; routed by `SkgMUqFCoe`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [JM38ENT2L0.java:48](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JM38ENT2L0.java#L48) | `actionCallUSSD` | 1. `"4"`<br>2. `numero`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JUhL44kV5Z.java`

Baseline source role/evidence: Fixed-phone recent-payments-by-number form loads/saves known landline numbers, validates eight digits, and dispatches selector `3`; reached from the latest-payments menu choice in `SkgMUqFCoe`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [JUhL44kV5Z.java:64](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JUhL44kV5Z.java#L64) | `actionCallUSSD` | 1. `"3"`<br>2. `numero`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/Mu8P2X7JEu.java`

Baseline source role/evidence: Default fixed-phone card/PIN form loads saved PINs, requires 12 characters, saves a new PIN, and dispatches selector `0`; routed by `SkgMUqFCoe`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Mu8P2X7JEu.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/Mu8P2X7JEu.java#L65) | `actionCallUSSD` | 1. `"0"`<br>2. `pin`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/R0CqDlLUE6.java`

Baseline source role/evidence: Fixed-phone payment form supports a saved/default PIN or entered 12-character PIN, validates the 8-digit phone, persists phone/PIN values, and dispatches selector `2`; routed by `SkgMUqFCoe`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [R0CqDlLUE6.java:97](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/R0CqDlLUE6.java#L97) | `actionCallUSSD` | 1. `"2"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/SkgMUqFCoe.java`

Baseline source role/evidence: Fixed-phone service menu routes PIN defaulting, balance query, bill payment, recent payments, and payment rectification; executes general latest-payments selector `3` and routes phone-specific history to `JUhL44kV5Z`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SkgMUqFCoe.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/SkgMUqFCoe.java#L105) | `actionCallUSSD` | 1. `"3"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/vnC9BffKAI.java`

Baseline source role/evidence: Fixed-phone balance-query form loads/saves landline numbers, validates eight digits, and dispatches selector `1`; routed by `SkgMUqFCoe`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [vnC9BffKAI.java:81](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/vnC9BffKAI.java#L81) | `actionCallUSSD` | 1. `"1"`<br>2. `numero`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/Eqj43O0pUx.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Eqj43O0pUx.java:425](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/Eqj43O0pUx.java#L425) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"31"`<br>3. `cadena`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [Eqj43O0pUx.java:428](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/Eqj43O0pUx.java#L428) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"31"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |
| [Eqj43O0pUx.java:465](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/Eqj43O0pUx.java#L465) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"30"`<br>3. `cadena3`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group2`<br>6. `getFragmentManager()` |
| [Eqj43O0pUx.java:467](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/Eqj43O0pUx.java#L467) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"30"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group2`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/UTk9UWZYxf.java`

Baseline source role/evidence: Caja Extra payment form parses dynamic payment QR data, validates PIN/source account/amount/currencies, supports optional confirmation phone and QR scanning, builds selector-`32` payload, and uses partial-USSD dispatch when configured; instantiated by banking/QR callers.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [UTk9UWZYxf.java:368](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/UTk9UWZYxf.java#L368) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"32"`<br>3. `cadena`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [UTk9UWZYxf.java:370](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/UTk9UWZYxf.java#L370) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"32"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java`

Baseline source role/evidence: Bank QR payment form handles dynamic/static JSON or text QR data, validates PIN/account/amount/currency, optionally confirms a phone, and dispatches payment selectors `30`/`31` with ordinary or partial USSD; used by the banking menu and QR scanner.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [r7Rinp9ooL.java:238](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L238) | `actionCallUSSDNOBack` | 1. `this.context`<br>2. `this.activity`<br>3. `"30"`<br>4. `cadena`<br>5. `"¿Desea proceder con el pago?"`<br>6. `group`<br>7. `getFragmentManager()` |
| [r7Rinp9ooL.java:240](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L240) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"30"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |
| [r7Rinp9ooL.java:298](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L298) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"30"`<br>3. `movilConfirmar2`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group2`<br>6. `getFragmentManager()` |
| [r7Rinp9ooL.java:300](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L300) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"30"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `movilConfirmar2`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group2`<br>9. `getFragmentManager()` |
| [r7Rinp9ooL.java:369](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L369) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"31"`<br>3. `movilConfirmar`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group3`<br>6. `getFragmentManager()` |
| [r7Rinp9ooL.java:371](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java#L371) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"31"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `movilConfirmar`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group3`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xf94v3SFEM.java`

Baseline source role/evidence: Online-purchase QR payment form parses JSON/text QR payloads, validates PIN/account/amount and currency, applies bank-specific currency choices, and dispatches selector `30` with provider and account data; `S9ycHcoxAzy` routes scanned `xf94v3SFEM` operations here.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xf94v3SFEM.java:186](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xf94v3SFEM.java#L186) | `actionCallUSSDNOBack` | 1. `this.context`<br>2. `this.activity`<br>3. `"30"`<br>4. `cadena`<br>5. `"¿Desea proceder con el pago?"`<br>6. `group`<br>7. `getFragmentManager()` |
| [xf94v3SFEM.java:193](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xf94v3SFEM.java#L193) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"30"`<br>3. `cadena2`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group2`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xpc0ejPtmZ.java`

Baseline source role/evidence: Caja Extra payment form observes USSD responses, parses dynamic QR data, validates PIN/source account/amount/currency, supports contact-based confirmation, and dispatches selector `32` or configured partial-USSD packets; instantiated by bank-operation and QR flows.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xpc0ejPtmZ.java:384](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xpc0ejPtmZ.java#L384) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"32"`<br>3. `cadena`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [xpc0ejPtmZ.java:386](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xpc0ejPtmZ.java#L386) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"32"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/H0kVHR7zuu.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [H0kVHR7zuu.java:125](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/H0kVHR7zuu.java#L125) | `actionCallUSSD` | 1. `"70"` |
| [H0kVHR7zuu.java:128](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/H0kVHR7zuu.java#L128) | `actionCallUSSD` | 1. `"70"` |
| [H0kVHR7zuu.java:132](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/H0kVHR7zuu.java#L132) | `actionCallUSSD` | 1. `"70"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/N9YZcaVn8GC.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [N9YZcaVn8GC.java:268](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/N9YZcaVn8GC.java#L268) | `actionCallUSSD` | 1. `"11*2"` |
| [N9YZcaVn8GC.java:288](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/N9YZcaVn8GC.java#L288) | `actionCallUSSD` | 1. `"11*6"` |
| [N9YZcaVn8GC.java:309](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/N9YZcaVn8GC.java#L309) | `actionCallUSSD` | 1. `"11*4"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [UMVR3qrc3V.java:223](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L223) | `actionCallUSSD` | 1. `"46"` |
| [UMVR3qrc3V.java:225](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L225) | `actionCallUSSD` | 1. `"46"` |
| [UMVR3qrc3V.java:251](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L251) | `actionCallUSSD` | 1. `"103"` |
| [UMVR3qrc3V.java:253](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L253) | `actionCallUSSD` | 1. `"103"` |
| [UMVR3qrc3V.java:288](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L288) | `actionCallUSSD` | 1. `"48"`<br>2. `pos` |
| [UMVR3qrc3V.java:290](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L290) | `actionCallUSSD` | 1. `"48"`<br>2. `pos` |
| [UMVR3qrc3V.java:380](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L380) | `actionCallUSSD` | 1. `"117"` |
| [UMVR3qrc3V.java:382](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/GerFAWQsHQB/UMVR3qrc3V.java#L382) | `actionCallUSSD` | 1. `"117"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/C6ZYln3x19W.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [C6ZYln3x19W.java:127](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/C6ZYln3x19W.java#L127) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"94"`<br>3. `cadena`<br>4. `"¿Desea realizar el pago? "`<br>5. `group`<br>6. `getFragmentManager()` |
| [C6ZYln3x19W.java:129](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/C6ZYln3x19W.java#L129) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"94"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea realizar el pago? "`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/GvNasrezHU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [GvNasrezHU.java:119](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/GvNasrezHU.java#L119) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"46"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [GvNasrezHU.java:121](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/GvNasrezHU.java#L121) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"46"`<br>4. `"08"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [H0oV6Ot0bS.java:423](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS.java#L423) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"16"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [H0oV6Ot0bS.java:425](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS.java#L425) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"16"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [H0oV6Ot0bS.java:427](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS.java#L427) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"16"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/HZgbT8IXPf.java`

Baseline source role/evidence: Nauta Plus bag-purchase form supports saved accounts or no-account purchase, optional eight-digit beneficiary phone, and bag type selection; constructs account/phone/type payload and dispatches selector `34`, with entry points in `rR6oImkdEU` and the shared operation dispatcher.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [HZgbT8IXPf.java:259](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/HZgbT8IXPf.java#L259) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"34"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [HZgbT8IXPf.java:278](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/HZgbT8IXPf.java#L278) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"34"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group2`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/JrjJL8mtlI.java`

Baseline source role/evidence: Own-card top-up form loads saved card series, validates series/amount/bag type, persists a new card series with currency, and dispatches selector `77` (including partial-USSD packets when configured); reached from bank operations and QR flows.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [JrjJL8mtlI.java:177](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/JrjJL8mtlI.java#L177) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"77"`<br>3. `cadena`<br>4. `msg2`<br>5. `group`<br>6. `getFragmentManager()` |
| [JrjJL8mtlI.java:179](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/JrjJL8mtlI.java#L179) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"77"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg2`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KtF0PRB8vS.java:356](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L356) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"59"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [KtF0PRB8vS.java:359](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L359) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"59"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [KtF0PRB8vS.java:381](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L381) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"84"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group2`<br>6. `getFragmentManager()` |
| [KtF0PRB8vS.java:384](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L384) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"84"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena2`<br>7. `msg2`<br>8. `group2`<br>9. `getFragmentManager()` |
| [KtF0PRB8vS.java:405](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L405) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"86"`<br>3. `cadena3`<br>4. `msg3`<br>5. `group3`<br>6. `getFragmentManager()` |
| [KtF0PRB8vS.java:407](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/KtF0PRB8vS.java#L407) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"86"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `msg3`<br>8. `group3`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/LjOlaYSSMH.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [LjOlaYSSMH.java:173](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/LjOlaYSSMH.java#L173) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"45"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [LjOlaYSSMH.java:175](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/LjOlaYSSMH.java#L175) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/OXpoe3K2m1.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [OXpoe3K2m1.java:240](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/OXpoe3K2m1.java#L240) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"112"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea obtener los últimos Boletos del rango de fecha especificado?"`<br>8. `group`<br>9. `getFragmentManager()` |
| [OXpoe3K2m1.java:242](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/OXpoe3K2m1.java#L242) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"112"`<br>3. `cadena`<br>4. `"¿Desea obtener los últimos Boletos del rango de fecha especificado?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/P8DtkaSW4dR.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [P8DtkaSW4dR.java:96](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/P8DtkaSW4dR.java#L96) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"17"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [P8DtkaSW4dR.java:98](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/P8DtkaSW4dR.java#L98) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"17"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/QVPgkl8ZGC.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [QVPgkl8ZGC.java:159](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/QVPgkl8ZGC.java#L159) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"106"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [TBaFnBLjEA.java:387](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java#L387) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"118"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg2`<br>8. `group`<br>9. `getFragmentManager()` |
| [TBaFnBLjEA.java:389](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java#L389) | `actionCallUSSDBackHttp` | 1. `this.context`<br>2. `"118"`<br>3. `cadena`<br>4. `spannableString`<br>5. `group`<br>6. `getFragmentManager()` |
| [TBaFnBLjEA.java:927](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java#L927) | `actionCallUSSD` | 1. `"117"` |
| [TBaFnBLjEA.java:930](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java#L930) | `actionCallUSSD` | 1. `"117"` |
| [TBaFnBLjEA.java:934](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/TBaFnBLjEA.java#L934) | `actionCallUSSD` | 1. `"117"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [U1sIOmca96i.java:228](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java#L228) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"19"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [U1sIOmca96i.java:231](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java#L231) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"21"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [U1sIOmca96i.java:236](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java#L236) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"19"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [U1sIOmca96i.java:238](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java#L238) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"21"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Wwc5crW71D.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Wwc5crW71D.java:166](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Wwc5crW71D.java#L166) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"105"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/WyYHxgzYyW.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [WyYHxgzYyW.java:200](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/WyYHxgzYyW.java#L200) | `actionCallUSSDBack` | 1. `this.context`<br>2. `this.codeService`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XCDkgbw8oZ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XCDkgbw8oZ.java:186](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XCDkgbw8oZ.java#L186) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [XCDkgbw8oZ.java:188](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XCDkgbw8oZ.java#L188) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"67"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XnVSHGPTkK.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XnVSHGPTkK.java:363](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/XnVSHGPTkK.java#L363) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"102"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Z3kYdPwq6K2.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Z3kYdPwq6K2.java:424](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Z3kYdPwq6K2.java#L424) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"220"`<br>4. `"08"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [Z3kYdPwq6K2.java:426](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Z3kYdPwq6K2.java#L426) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"220"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [Z3kYdPwq6K2.java:428](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/Z3kYdPwq6K2.java#L428) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"220"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [b6FtEHgm1B.java:294](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java#L294) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"31"`<br>3. `cadena2`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [b6FtEHgm1B.java:296](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java#L296) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"31"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena2`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |
| [b6FtEHgm1B.java:316](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java#L316) | `actionCallUSSDNOBack` | 1. `this.context`<br>2. `this.activity`<br>3. `"30"`<br>4. `cadena4`<br>5. `"¿Desea proceder con el pago?"`<br>6. `group2`<br>7. `getFragmentManager()` |
| [b6FtEHgm1B.java:340](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java#L340) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"30"`<br>3. `cadena3`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group3`<br>6. `getFragmentManager()` |
| [b6FtEHgm1B.java:342](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b6FtEHgm1B.java#L342) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"30"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group3`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b7zSZMAX7cN.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [b7zSZMAX7cN.java:135](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b7zSZMAX7cN.java#L135) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"108"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [b7zSZMAX7cN.java:137](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/b7zSZMAX7cN.java#L137) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"108"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/cdINOtQ3iN.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [cdINOtQ3iN.java:419](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/cdINOtQ3iN.java#L419) | `actionCallUSSDBack454` | 1. `this.context`<br>2. `"215"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dI2tctjNbR.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dI2tctjNbR.java:141](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dI2tctjNbR.java#L141) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [dI2tctjNbR.java:143](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dI2tctjNbR.java#L143) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"48"`<br>4. `this.agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dWLcK5oQoS.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dWLcK5oQoS.java:337](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dWLcK5oQoS.java#L337) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"8"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg2`<br>8. `group`<br>9. `getFragmentManager()` |
| [dWLcK5oQoS.java:339](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dWLcK5oQoS.java#L339) | `actionCallUSSDBackHttp` | 1. `this.context`<br>2. `"8"`<br>3. `cadena`<br>4. `spannableString`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dYBdUyjb1D.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dYBdUyjb1D.java:96](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dYBdUyjb1D.java#L96) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"9"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dwdZ5sHcFR.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dwdZ5sHcFR.java:164](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dwdZ5sHcFR.java#L164) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [dwdZ5sHcFR.java:166](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/dwdZ5sHcFR.java#L166) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"41"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f3Ttlx30sMT.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f3Ttlx30sMT.java:110](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f3Ttlx30sMT.java#L110) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"33"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f9Reflqt3EZ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f9Reflqt3EZ.java:223](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f9Reflqt3EZ.java#L223) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"95"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [f9Reflqt3EZ.java:225](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/f9Reflqt3EZ.java#L225) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"95"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/hjX8MS8xO9.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [hjX8MS8xO9.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/hjX8MS8xO9.java#L61) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"115"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/i9I9XZGnR3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [i9I9XZGnR3.java:144](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/i9I9XZGnR3.java#L144) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"113"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [i9I9XZGnR3.java:146](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/i9I9XZGnR3.java#L146) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"113"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [l3GXbXAyUW.java:326](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java#L326) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"45"`<br>4. `"08"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [l3GXbXAyUW.java:328](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java#L328) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [l3GXbXAyUW.java:330](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/l3GXbXAyUW.java#L330) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/p5B8KozjvpQ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [p5B8KozjvpQ.java:230](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/p5B8KozjvpQ.java#L230) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"42"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [p5B8KozjvpQ.java:232](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/p5B8KozjvpQ.java#L232) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/q55ExEc6x2l.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [q55ExEc6x2l.java:128](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/q55ExEc6x2l.java#L128) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"18"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java`

Baseline source role/evidence: Bank transfer/payment screen handles QR-sourced account/provider/amount fields, source-account and currency checks, optional phone confirmation, and USSD selectors `30`/`31`; called from bank menus and QR scanners.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [s9CT6pjRyD.java:311](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java#L311) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"31"`<br>3. `cadena2`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [s9CT6pjRyD.java:313](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java#L313) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"31"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena2`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group`<br>9. `getFragmentManager()` |
| [s9CT6pjRyD.java:333](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java#L333) | `actionCallUSSDNOBack` | 1. `this.context`<br>2. `this.activity`<br>3. `"30"`<br>4. `cadena4`<br>5. `"¿Desea proceder con el pago?"`<br>6. `group2`<br>7. `getFragmentManager()` |
| [s9CT6pjRyD.java:357](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java#L357) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"30"`<br>3. `cadena3`<br>4. `"¿Desea proceder con el pago?"`<br>5. `group3`<br>6. `getFragmentManager()` |
| [s9CT6pjRyD.java:359](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java#L359) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"30"`<br>4. `agency`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `"¿Desea proceder con el pago?"`<br>8. `group3`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/udysei7zCr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [udysei7zCr.java:146](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/udysei7zCr.java#L146) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"7"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [udysei7zCr.java:148](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/udysei7zCr.java#L148) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"7"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/w7mHpmOa4EP.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [w7mHpmOa4EP.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/w7mHpmOa4EP.java#L61) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"114"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/wbFn8tBw8W.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wbFn8tBw8W.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/wbFn8tBw8W.java#L105) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"20"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/x12rSjPY6pZ.java`

Baseline source role/evidence: Ticket-reservation query form validates an identity number and dispatches selector `107` with agency ID and identity; opened by QR scanning for the `ConsultarReservasTicket` operation.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [x12rSjPY6pZ.java:103](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/x12rSjPY6pZ.java#L103) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"107"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/xb7DiohJuX.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xb7DiohJuX.java:200](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/xb7DiohJuX.java#L200) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"7"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [xb7DiohJuX.java:203](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/xb7DiohJuX.java#L203) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"122"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [xb7DiohJuX.java:208](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/xb7DiohJuX.java#L208) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"7"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [xb7DiohJuX.java:210](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/xb7DiohJuX.java#L210) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"122"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/zzyNbaqs1U.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [zzyNbaqs1U.java:157](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/zzyNbaqs1U.java#L157) | `actionCallUSSDBack` | 1. `this.context`<br>2. `this.codeService`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Cmok7CcIR9.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Cmok7CcIR9.java:77](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Cmok7CcIR9.java#L77) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [Cmok7CcIR9.java:79](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Cmok7CcIR9.java#L79) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"69"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `pin`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/HTmIvOo9nb.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [HTmIvOo9nb.java:118](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/HTmIvOo9nb.java#L118) | `actionCallUSSDBackAsocClasica` | 1. `this.context`<br>2. `"111"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()`<br>7. `this` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Nju5UJgFce.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Nju5UJgFce.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Nju5UJgFce.java#L73) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"68"`<br>3. `cadena`<br>4. `"Desea eliminar su registro del sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [Nju5UJgFce.java:75](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/Nju5UJgFce.java#L75) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"68"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea eliminar su registro del sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/eUkRSfpCKs.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [eUkRSfpCKs.java:78](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/eUkRSfpCKs.java#L78) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"49"`<br>3. `cadena`<br>4. `"Desea registrarse en el sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [eUkRSfpCKs.java:80](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/eUkRSfpCKs.java#L80) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"49"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea registrarse en el sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/l2FaHPPBDa.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [l2FaHPPBDa.java:158](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/l2FaHPPBDa.java#L158) | `actionCallUSSDBackAsocClasica` | 1. `this.context`<br>2. `"111"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()`<br>7. `this` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/m44wUnA8d5.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [m44wUnA8d5.java:118](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/m44wUnA8d5.java#L118) | `actionCallUSSDBackAsocClasica` | 1. `this.context`<br>2. `"68"`<br>3. `cadena`<br>4. `"Desea eliminar su registro del sistema"`<br>5. `group`<br>6. `getFragmentManager()`<br>7. `this` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/wfroNBIJF7.java`

Baseline source role/evidence: CameraX/ML Kit scanner parses `QRData` ticket payloads, displays details and amount/currency, checks amount against QR-provided maximums, and dispatches selector `119` with identity/PIN/token/detail ID/amount; both `IHVTCBmiLV` and `S9ycHcoxAzy` open this flow.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wfroNBIJF7.java:208](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/wfroNBIJF7.java#L208) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"119"`<br>3. `cadena`<br>4. `"¿Desea validar el boleto?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qZS87tGogtP/R5fFZkKuVnr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [R5fFZkKuVnr.java:50](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qZS87tGogtP/R5fFZkKuVnr.java#L50) | `actionCallUSSDBack` | 1. `"04"`<br>2. `this.context`<br>3. `"40"`<br>4. `clave`<br>5. `"Desea autenticarse en el sistema"`<br>6. `group`<br>7. `getFragmentManager()`<br>8. `getActivity()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/HFzgpLELho.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [HFzgpLELho.java:83](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/HFzgpLELho.java#L83) | `actionCallUSSD` | 1. `"47"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/k5fNqiPSlwb.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [k5fNqiPSlwb.java:229](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/k5fNqiPSlwb.java#L229) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"47"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [k5fNqiPSlwb.java:231](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/k5fNqiPSlwb.java#L231) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"47"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/qAMfdm9Kls.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [qAMfdm9Kls.java:129](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/qAMfdm9Kls.java#L129) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"26"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [qAMfdm9Kls.java:131](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/qcFLXVxM456/qAMfdm9Kls.java#L131) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"26"`<br>4. `"04"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/BpgQdOQz0p.java`

Baseline source role/evidence: Own-card recharge form validates saved/new card series, amount, and currency/bag selection, stores new card records, and dispatches selector `4` with series, amount, and account type; dynamic operation menus route to this fragment.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [BpgQdOQz0p.java:168](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/BpgQdOQz0p.java#L168) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"4"`<br>3. `cadena`<br>4. `msg + cuenta`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/CepWe39cnz.java`

Baseline source role/evidence: Nauta balance-query form validates account and international/national account type, builds account/type payload, and dispatches selector `91` through the applicable banking or mobile activity; registered by the operation catalog.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [CepWe39cnz.java:151](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/CepWe39cnz.java#L151) | `actionCallUSSD` | 1. `"91"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |
| [CepWe39cnz.java:153](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/CepWe39cnz.java#L153) | `actionCallUSSD` | 1. `"91"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/H4bU7yMkJJK.java`

Baseline source role/evidence: Nauta recharge form validates account, bonus/ticket, account type, and optional destination phone, persists selected account metadata, and dispatches selector `90`; registered by the operation catalog.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [H4bU7yMkJJK.java:182](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/H4bU7yMkJJK.java#L182) | `actionCallUSSD` | 1. `"90"`<br>2. `cadenaSolicitud`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/ee4tsHNQiS.java`

Baseline source role/evidence: Fixed-phone bill form supports full or partial payment, validates account/amount/currency selection, persists the account, and dispatches selector `3`; reached through operation catalog and bank-operation menus.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ee4tsHNQiS.java:254](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/ee4tsHNQiS.java#L254) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"3"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/f03gMUuBeK.java`

Baseline source role/evidence: Mobile recharge form validates phone, amount, and currency/bag, saves the phone contact, and dispatches the configured service selector with phone/amount/type; registered by operation menus and the bank-operation adapter.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f03gMUuBeK.java:155](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/f03gMUuBeK.java#L155) | `actionCallUSSDBack` | 1. `this.context`<br>2. `this.codeService`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/tKjjxHr2PT.java`

Baseline source role/evidence: Cubacel package-purchase form loads plan options from local/cache data or refreshes them through `HPuMiTypoW`, validates an 8/10-digit mobile number, package, and currency, then dispatches configured selector `10` with package ID/version and destination; registered in the operation catalog.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [tKjjxHr2PT.java:200](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/tKjjxHr2PT.java#L200) | `actionCallUSSDBack` | 1. `this.context`<br>2. `this.codeService`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/yww1pS0VKU.java`

Baseline source role/evidence: Nauta/Nauta Hogar recharge form validates account type, amount, destination phone, and currency, saves account data, and dispatches selectors `14`, `15`, or `86` for standard recharge, Nauta Hogar recharge, or arrears; registered in the operation catalog.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yww1pS0VKU.java:333](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/yww1pS0VKU.java#L333) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"14"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [yww1pS0VKU.java:350](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/yww1pS0VKU.java#L350) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"15"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group2`<br>6. `getFragmentManager()` |
| [yww1pS0VKU.java:366](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/yww1pS0VKU.java#L366) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"86"`<br>3. `cadena3`<br>4. `msg3`<br>5. `group3`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/KyQXczCdrr.java`

Baseline source role/evidence: Nauta service menu routes account recharge and recent-recharge choices, dispatching general selector `91` or opening `Kw29o4NNrz` for account-specific history.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KyQXczCdrr.java:83](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/KyQXczCdrr.java#L83) | `actionCallUSSD` | 1. `"91"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java`

Baseline source role/evidence: Mobile operations menu routes coupon recharge, balance transfer, and PIN change, and dispatches USSD actions for advance balance, bonus status, and data/voice/SMS/friends plans.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [LALCrDPvhM.java:46](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L46) | `showSendUSSD` | 1. `"234"`<br>2. `"3"`<br>3. `lALCrDPvhM.context.getString(R.string.alert_dialog_msg_adelanta)` |
| [LALCrDPvhM.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L53) | `showSendUSSD` | 1. `"222"`<br>2. `"266"`<br>3. `lALCrDPvhM2.context.getString(R.string.alert_dialog_msg_bono_confirm)` |
| [LALCrDPvhM.java:57](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L57) | `showSendUSSD` | 1. `"133"`<br>2. `BuildConfig.FLAVOR`<br>3. `lALCrDPvhM3.context.getString(R.string.alert_dialog_msg_gesplanes_confirm)` |
| [LALCrDPvhM.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L61) | `showSendUSSD` | 1. `"222"`<br>2. `"328"`<br>3. `lALCrDPvhM4.context.getString(R.string.alert_dialog_msg_consultaplandatos_confirm)` |
| [LALCrDPvhM.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L65) | `showSendUSSD` | 1. `"222"`<br>2. `"869"`<br>3. `lALCrDPvhM5.context.getString(R.string.alert_dialog_msg_cconsultaplanvoz_confirm)` |
| [LALCrDPvhM.java:69](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L69) | `showSendUSSD` | 1. `"222"`<br>2. `"767"`<br>3. `lALCrDPvhM6.context.getString(R.string.alert_dialog_msg_consultaplansms_confirm)` |
| [LALCrDPvhM.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L73) | `showSendUSSD` | 1. `"222"`<br>2. `"264"`<br>3. `lALCrDPvhM7.context.getString(R.string.alert_dialog_msg_consiltaplanamigos_confirm)` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java`

Baseline source role/evidence: Balance-transfer form validates an eight-digit mobile, four-character PIN, and integer amount, normalizes contacts, then dispatches USSD selector `234` option `1`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [C8l2t8799rL.java:82](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java#L82) | `actionCallUSSD` | 1. `"234"`<br>2. `"1"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |
| [C8l2t8799rL.java:85](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java#L85) | `actionCallUSSD` | 1. `"234"`<br>2. `"1"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |
| [C8l2t8799rL.java:89](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java#L89) | `actionCallUSSD` | 1. `"234"`<br>2. `"1"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java`

Baseline source role/evidence: Recharge-PIN change form validates two four-character values and dispatches USSD selector `234` option `2` with both entries.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [E1lhoLKryWP.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java#L58) | `actionCallUSSD` | 1. `"234"`<br>2. `"2"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |
| [E1lhoLKryWP.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java#L61) | `actionCallUSSD` | 1. `"234"`<br>2. `"2"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |
| [E1lhoLKryWP.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java#L65) | `actionCallUSSD` | 1. `"234"`<br>2. `"2"`<br>3. `cadena`<br>4. `msg`<br>5. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java`

Baseline source role/evidence: Coupon-recharge form accepts a coupon code, imports numeric coupon data from QR scans, and dispatches selector `662` with the code.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [b0kkzvOCEu.java:67](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java#L67) | `actionCallUSSD` | 1. `cadena`<br>2. `msg`<br>3. `group` |
| [b0kkzvOCEu.java:70](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java#L70) | `actionCallUSSD` | 1. `cadena`<br>2. `msg`<br>3. `group` |
| [b0kkzvOCEu.java:74](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java#L74) | `actionCallUSSD` | 1. `cadena`<br>2. `msg`<br>3. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/myPAy8444WF/ULFE6hmQU6.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ULFE6hmQU6.java:168](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/myPAy8444WF/ULFE6hmQU6.java#L168) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"98"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [ULFE6hmQU6.java:170](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/myPAy8444WF/ULFE6hmQU6.java#L170) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"98"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/A3HXMd4hA0h.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [A3HXMd4hA0h.java:111](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/A3HXMd4hA0h.java#L111) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/e8WK1Uajbq.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [e8WK1Uajbq.java:54](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/e8WK1Uajbq.java#L54) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"62"`<br>3. `cadena`<br>4. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [e8WK1Uajbq.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/e8WK1Uajbq.java#L56) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"62"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/h3sd43nvje.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [h3sd43nvje.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/h3sd43nvje.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `"¿Desea ver las últimas operaciones realizadas?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [h3sd43nvje.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/h3sd43nvje.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"48"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea ver las últimas operaciones realizadas?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/ix4mhKGJty.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ix4mhKGJty.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/ix4mhKGJty.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"46"`<br>3. `cadena`<br>4. `"¿Desea consultar el saldo de su tarjeta?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [ix4mhKGJty.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/GF0vcofd59d/ix4mhKGJty.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"46"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar el saldo de su tarjeta?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/I2qACpsJwr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [I2qACpsJwr.java:161](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/I2qACpsJwr.java#L161) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IS7bwUrUyp.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [IS7bwUrUyp.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IS7bwUrUyp.java#L59) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [IS7bwUrUyp.java:62](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IS7bwUrUyp.java#L62) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [IS7bwUrUyp.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IS7bwUrUyp.java#L66) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IixhA1yamp.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [IixhA1yamp.java:98](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IixhA1yamp.java#L98) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"49"`<br>3. `cadena`<br>4. `"Desea registrarse en el sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [IixhA1yamp.java:100](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/IixhA1yamp.java#L100) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"49"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea registrarse en el sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Ittht2aX4N.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Ittht2aX4N.java:78](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Ittht2aX4N.java#L78) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"60"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/NJYHouEpvg.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [NJYHouEpvg.java:116](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/NJYHouEpvg.java#L116) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/NgrxjooUlo.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [NgrxjooUlo.java:178](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/NgrxjooUlo.java#L178) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"81"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/PQmKwgxZd1.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PQmKwgxZd1.java:51](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/PQmKwgxZd1.java#L51) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `"Desea cambiar su clave"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Udt22QU0bZ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Udt22QU0bZ.java:107](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Udt22QU0bZ.java#L107) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [VYOSpQMJgQ.java:245](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L245) | `actionCallUSSD` | 1. `"70"` |
| [VYOSpQMJgQ.java:248](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L248) | `actionCallUSSD` | 1. `"70"` |
| [VYOSpQMJgQ.java:252](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L252) | `actionCallUSSD` | 1. `"70"` |
| [VYOSpQMJgQ.java:275](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L275) | `actionCallUSSD` | 1. `"46"` |
| [VYOSpQMJgQ.java:278](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L278) | `actionCallUSSD` | 1. `"46"` |
| [VYOSpQMJgQ.java:282](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L282) | `actionCallUSSD` | 1. `"46"` |
| [VYOSpQMJgQ.java:304](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L304) | `actionCallUSSD` | 1. `"72"` |
| [VYOSpQMJgQ.java:307](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L307) | `actionCallUSSD` | 1. `"72"` |
| [VYOSpQMJgQ.java:311](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L311) | `actionCallUSSD` | 1. `"72"` |
| [VYOSpQMJgQ.java:333](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L333) | `actionCallUSSD` | 1. `"68*01"` |
| [VYOSpQMJgQ.java:336](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L336) | `actionCallUSSD` | 1. `"68*01"` |
| [VYOSpQMJgQ.java:340](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L340) | `actionCallUSSD` | 1. `"68*01"` |
| [VYOSpQMJgQ.java:363](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L363) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [VYOSpQMJgQ.java:366](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L366) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [VYOSpQMJgQ.java:371](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L371) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [VYOSpQMJgQ.java:374](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L374) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [VYOSpQMJgQ.java:379](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L379) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [VYOSpQMJgQ.java:381](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L381) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [VYOSpQMJgQ.java:405](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L405) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [VYOSpQMJgQ.java:408](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L408) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [VYOSpQMJgQ.java:413](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L413) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [VYOSpQMJgQ.java:416](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L416) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [VYOSpQMJgQ.java:421](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L421) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [VYOSpQMJgQ.java:423](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L423) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [VYOSpQMJgQ.java:447](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L447) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [VYOSpQMJgQ.java:450](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L450) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [VYOSpQMJgQ.java:455](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L455) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [VYOSpQMJgQ.java:458](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L458) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [VYOSpQMJgQ.java:463](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L463) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [VYOSpQMJgQ.java:465](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L465) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [VYOSpQMJgQ.java:488](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L488) | `actionCallUSSD` | 1. `"58"` |
| [VYOSpQMJgQ.java:491](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L491) | `actionCallUSSD` | 1. `"58"` |
| [VYOSpQMJgQ.java:495](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/VYOSpQMJgQ.java#L495) | `actionCallUSSD` | 1. `"58"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/XvOK7VM4qL.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XvOK7VM4qL.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/XvOK7VM4qL.java#L55) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"65"`<br>3. `ci`<br>4. `"¿Desea realizar la consulta de giros pendientes?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Yff3Tf50gc.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Yff3Tf50gc.java:100](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/Yff3Tf50gc.java#L100) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/auVvnTnpCQ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [auVvnTnpCQ.java:71](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/auVvnTnpCQ.java#L71) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"82"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/AXjqRy5YBz.java`

Baseline source role/evidence: Selector-45 bank-transfer form validates destination/origin accounts and CUP/CUC/USD rules, assembles recipient-phone, notification, and balance flags, then confirms and submits the transfer. Its card-rendering method is an JADX decompilation stub, so that detail remains unresolved.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [AXjqRy5YBz.java:589](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/AXjqRy5YBz.java#L589) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Dm6u4PA5eg.java`

Baseline source role/evidence: BPA loan-amortization form validates payment inputs and submits selector `55`; the BPA host menu routes the corresponding operation to this fragment.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Dm6u4PA5eg.java:71](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Dm6u4PA5eg.java#L71) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [Dm6u4PA5eg.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Dm6u4PA5eg.java#L73) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"55"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FX8u11r7nB.java`

Baseline source role/evidence: Mobile-recharge form accepts a phone and amount, imports contacts, and submits selector `54` (or a segmented `110`/`54` USSD path); the phone field uses the mobile-recharge label.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FX8u11r7nB.java:97](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FX8u11r7nB.java#L97) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [FX8u11r7nB.java:99](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FX8u11r7nB.java#L99) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"54"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FgpBLXKm6t.java`

Baseline source role/evidence: BPA gas-bill payment form validates account/amount and submits selector `67`; the BPA host menu exposes the gas operation.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FgpBLXKm6t.java:131](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FgpBLXKm6t.java#L131) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [FgpBLXKm6t.java:133](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FgpBLXKm6t.java#L133) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"67"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Hg2ath75ih.java`

Baseline source role/evidence: BPA credit/loan application form collects amount, term, and interest options and submits selector `81` through the BPA operation host.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Hg2ath75ih.java:168](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Hg2ath75ih.java#L168) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"81"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [Hg2ath75ih.java:170](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Hg2ath75ih.java#L170) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"81"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/iN1lHDKE5h.java`

Baseline source role/evidence: Extended account transfer form: `submitForm` validates destination/origin, CUP/CUC/USD rules, recipient phone, optional message/flags, PIN/agencia mode, and selector-45 standard/partial payloads; uses account/card classifier and packet helper. Distinct from the clean short-form `BpaTransferFragment`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [iN1lHDKE5h.java:641](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/iN1lHDKE5h.java#L641) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [iN1lHDKE5h.java:644](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/iN1lHDKE5h.java#L644) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [iN1lHDKE5h.java:649](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/iN1lHDKE5h.java#L649) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"45"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadenaInicio + cadenaAjustada`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/o6kycf55Gw.java`

Baseline source role/evidence: BPA postal-order form validates origin/destination identity numbers, amount, and reason, then submits selector `64`; the catalog labels the operation “Giro BPA”.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [o6kycf55Gw.java:96](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/o6kycf55Gw.java#L96) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"64"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [o6kycf55Gw.java:98](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/o6kycf55Gw.java#L98) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/pxpQ3hcmYF.java`

Baseline source role/evidence: ONAT public-service payment form validates license `RC05` and amount before dispatching selector `43`; its operation is exposed from the BPA service menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [pxpQ3hcmYF.java:91](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/pxpQ3hcmYF.java#L91) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [pxpQ3hcmYF.java:93](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/pxpQ3hcmYF.java#L93) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/u4QMc0S0ZHo.java`

Baseline source role/evidence: BPA landline/telecommunications bill form validates the account and amount and submits selector `42`, including partial-USSD handling; the host catalog labels it “Telecomunicaciones”.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [u4QMc0S0ZHo.java:159](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/u4QMc0S0ZHo.java#L159) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"42"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [u4QMc0S0ZHo.java:161](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/u4QMc0S0ZHo.java#L161) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/xSwGh0MTOg.java`

Baseline source role/evidence: BPA electricity-bill form validates payment data and submits selector `41`; the BPA host catalog labels the route “Electricidad”.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xSwGh0MTOg.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/xSwGh0MTOg.java#L105) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [xSwGh0MTOg.java:107](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/xSwGh0MTOg.java#L107) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"41"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java`

Baseline source role/evidence: BPA water-bill form handles region/branch variants and submits selectors `19`, `51`, or `21`, with partial-USSD handling; the operation is exposed through the BPA host menu.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [zOs55UzH6z.java:215](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L215) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"19"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [zOs55UzH6z.java:218](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L218) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"19"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [zOs55UzH6z.java:224](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L224) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [zOs55UzH6z.java:227](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L227) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"51"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [zOs55UzH6z.java:232](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L232) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"21"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [zOs55UzH6z.java:234](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java#L234) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"21"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f5AFyaj0rtx.java:255](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L255) | `actionCallUSSD` | 1. `"70"` |
| [f5AFyaj0rtx.java:258](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L258) | `actionCallUSSD` | 1. `"70"` |
| [f5AFyaj0rtx.java:262](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L262) | `actionCallUSSD` | 1. `"70"` |
| [f5AFyaj0rtx.java:285](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L285) | `actionCallUSSD` | 1. `"46"` |
| [f5AFyaj0rtx.java:288](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L288) | `actionCallUSSD` | 1. `"46"` |
| [f5AFyaj0rtx.java:292](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L292) | `actionCallUSSD` | 1. `"46"` |
| [f5AFyaj0rtx.java:314](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L314) | `actionCallUSSD` | 1. `"72"` |
| [f5AFyaj0rtx.java:317](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L317) | `actionCallUSSD` | 1. `"72"` |
| [f5AFyaj0rtx.java:321](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L321) | `actionCallUSSD` | 1. `"72"` |
| [f5AFyaj0rtx.java:344](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L344) | `actionCallUSSD` | 1. `"68*01"` |
| [f5AFyaj0rtx.java:347](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L347) | `actionCallUSSD` | 1. `"68*01"` |
| [f5AFyaj0rtx.java:351](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L351) | `actionCallUSSD` | 1. `"68*01"` |
| [f5AFyaj0rtx.java:374](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L374) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [f5AFyaj0rtx.java:377](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L377) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [f5AFyaj0rtx.java:382](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L382) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [f5AFyaj0rtx.java:385](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L385) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [f5AFyaj0rtx.java:390](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L390) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [f5AFyaj0rtx.java:392](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L392) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [f5AFyaj0rtx.java:416](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L416) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [f5AFyaj0rtx.java:419](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L419) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [f5AFyaj0rtx.java:424](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L424) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [f5AFyaj0rtx.java:427](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L427) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [f5AFyaj0rtx.java:432](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L432) | `actionCallUSSD` | 1. `operacion`<br>2. `"1"` |
| [f5AFyaj0rtx.java:434](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L434) | `actionCallUSSD` | 1. `operacion`<br>2. `"2"` |
| [f5AFyaj0rtx.java:458](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L458) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [f5AFyaj0rtx.java:461](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L461) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [f5AFyaj0rtx.java:466](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L466) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [f5AFyaj0rtx.java:469](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L469) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [f5AFyaj0rtx.java:474](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L474) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*1"` |
| [f5AFyaj0rtx.java:476](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L476) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*2"` |
| [f5AFyaj0rtx.java:499](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L499) | `actionCallUSSD` | 1. `"58"` |
| [f5AFyaj0rtx.java:502](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L502) | `actionCallUSSD` | 1. `"58"` |
| [f5AFyaj0rtx.java:506](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/f5AFyaj0rtx.java#L506) | `actionCallUSSD` | 1. `"58"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java`

Baseline source role/evidence: BPA security/consultation menu builds 14 operations, routes account, balance, service, history, credit, exchange-rate, fine, ticket, and fuel queries, and dispatches query selectors including `00*<option>` and `58`; dialog routes open dedicated query/payment fragments.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [kmO9Md6JHr.java:301](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L301) | `actionCallUSSD` | 1. `"78"` |
| [kmO9Md6JHr.java:304](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L304) | `actionCallUSSD` | 1. `"78"` |
| [kmO9Md6JHr.java:308](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L308) | `actionCallUSSD` | 1. `"78"` |
| [kmO9Md6JHr.java:333](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L333) | `actionCallUSSD` | 1. `"103"` |
| [kmO9Md6JHr.java:335](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L335) | `actionCallUSSD` | 1. `"103"` |
| [kmO9Md6JHr.java:368](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L368) | `actionCallUSSD` | 1. `"85"` |
| [kmO9Md6JHr.java:371](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L371) | `actionCallUSSD` | 1. `"85"` |
| [kmO9Md6JHr.java:375](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L375) | `actionCallUSSD` | 1. `"85"` |
| [kmO9Md6JHr.java:398](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L398) | `actionCallUSSD` | 1. `"72"` |
| [kmO9Md6JHr.java:401](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L401) | `actionCallUSSD` | 1. `"72"` |
| [kmO9Md6JHr.java:405](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L405) | `actionCallUSSD` | 1. `"72"` |
| [kmO9Md6JHr.java:428](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L428) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [kmO9Md6JHr.java:430](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L430) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [kmO9Md6JHr.java:432](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L432) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [kmO9Md6JHr.java:457](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L457) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [kmO9Md6JHr.java:460](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L460) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [kmO9Md6JHr.java:464](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L464) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [kmO9Md6JHr.java:488](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L488) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [kmO9Md6JHr.java:491](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L491) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [kmO9Md6JHr.java:494](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L494) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [kmO9Md6JHr.java:517](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L517) | `actionCallUSSD` | 1. `"58"` |
| [kmO9Md6JHr.java:520](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L520) | `actionCallUSSD` | 1. `"58"` |
| [kmO9Md6JHr.java:524](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java#L524) | `actionCallUSSD` | 1. `"58"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/p97uirGL7T.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [p97uirGL7T.java:123](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/p97uirGL7T.java#L123) | `actionCallUSSD` | 1. `"70"` |
| [p97uirGL7T.java:126](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/p97uirGL7T.java#L126) | `actionCallUSSD` | 1. `"70"` |
| [p97uirGL7T.java:130](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/p97uirGL7T.java#L130) | `actionCallUSSD` | 1. `"70"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/l2i2DeDgof.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [l2i2DeDgof.java:113](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/l2i2DeDgof.java#L113) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/lyFcskE3fH.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [lyFcskE3fH.java:88](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/lyFcskE3fH.java#L88) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/lzGEfceoJu.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [lzGEfceoJu.java:47](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/lzGEfceoJu.java#L47) | `actionCallUSSDBack` | 1. `"01"`<br>2. `this.context`<br>3. `"40"`<br>4. `clave`<br>5. `"Desea autenticarse en el sistema"`<br>6. `group`<br>7. `getFragmentManager()`<br>8. `getActivity()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/ocoSQMhcgK.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ocoSQMhcgK.java:82](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/ocoSQMhcgK.java#L82) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"79"`<br>3. `cadena`<br>4. `"Confirme que desea generar el código pin"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/qwKx2MD9JP.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [qwKx2MD9JP.java:90](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/qwKx2MD9JP.java#L90) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/T7bvG7kpeae.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [T7bvG7kpeae.java:120](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/T7bvG7kpeae.java#L120) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"76"`<br>3. `surcursalSeleccionado`<br>4. `"¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/Yhi9DhKkMz.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Yhi9DhKkMz.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/Yhi9DhKkMz.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"83"`<br>3. `cadena`<br>4. `"¿Confirme que desea recuperar el pin de la tarjeta magnética?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [Yhi9DhKkMz.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/Yhi9DhKkMz.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"83"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Confirme que desea recuperar el pin de la tarjeta magnética?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/ZZ6L6QderZ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ZZ6L6QderZ.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/ZZ6L6QderZ.java#L53) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"87"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/kWnV7nzNWl.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [kWnV7nzNWl.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/kWnV7nzNWl.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"74"`<br>3. `cadena`<br>4. `"¿Desea reimprimir su tarjeta?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [kWnV7nzNWl.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/kWnV7nzNWl.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"74"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea reimprimir su tarjeta?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/qmcwKV1fzU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [qmcwKV1fzU.java:68](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/qmcwKV1fzU.java#L68) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/uLySWsCVTv.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [uLySWsCVTv.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/uLySWsCVTv.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"79"`<br>3. `cadena`<br>4. `"¿Confirme que desea generar el código pin?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [uLySWsCVTv.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/r1lhlGiU6g65/uLySWsCVTv.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"79"`<br>4. `"01"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Confirme que desea generar el código pin?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/xoZnbyoSLT.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xoZnbyoSLT.java:208](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/xoZnbyoSLT.java#L208) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"47"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [xoZnbyoSLT.java:300](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/xoZnbyoSLT.java#L300) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"22"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/B1joQfx53b.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [B1joQfx53b.java:109](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/B1joQfx53b.java#L109) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CA73VZ4FAR.java`

Baseline source role/evidence: ONAT/license payment form validates RC04/RC05 or NIT details and amount, dispatches selector `43`, and offers partial-payment handling (`submitForm`, `validateLicencia*`, `validateMonto`, partial dialog).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [CA73VZ4FAR.java:109](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CA73VZ4FAR.java#L109) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CiYPvcQWEO.java`

Baseline source role/evidence: Traffic-fine payment validates fine number and amount, then sends selector `44` through either supported activity interface (`submitForm`, `validateNroMulta`, `validateMonto`).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [CiYPvcQWEO.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CiYPvcQWEO.java#L59) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [CiYPvcQWEO.java:62](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CiYPvcQWEO.java#L62) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [CiYPvcQWEO.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CiYPvcQWEO.java#L66) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/VEBwCeuUli.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [VEBwCeuUli.java:69](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/VEBwCeuUli.java#L69) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"26"`<br>3. `cadena`<br>4. `"¿Desea obtener el estado de la cuenta seleccionada? Esta operación realiza un cobro de comisión a la cuenta selecionada"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/XKpe29TPn0.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XKpe29TPn0.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/XKpe29TPn0.java#L59) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"89"`<br>3. `cadena`<br>4. `"¿Desea consultar el estado del pago especificado?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/ZF74c8UCRU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ZF74c8UCRU.java:77](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/ZF74c8UCRU.java#L77) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"63"`<br>3. `cadena`<br>4. `"Confirme que desea realizar la consulta de últimos pagos"`<br>5. `group`<br>6. `getFragmentManager()` |
| [ZF74c8UCRU.java:79](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/ZF74c8UCRU.java#L79) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"63"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Confirme que desea realizar la consulta de últimos pagos"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/gaJlF6dT3z.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [gaJlF6dT3z.java:52](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/gaJlF6dT3z.java#L52) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `"¿Desea ver las últimas operaciones realizadas?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/ikSs6fqL5Q.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ikSs6fqL5Q.java:51](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D0gaXBEFITec/ikSs6fqL5Q.java#L51) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"62"`<br>3. `cadena`<br>4. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D38ae2xieeM.java`

Baseline source role/evidence: Utility-service payment accepts a prefilled or entered account, validates it, and submits selector `41` (`submitForm`, `validateCuenta`).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [D38ae2xieeM.java:76](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D38ae2xieeM.java#L76) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/FtAKxvNjrD.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FtAKxvNjrD.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/FtAKxvNjrD.java#L53) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `"¿Desea solicitar el cambio de su clave?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/HgJHxigegS.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [HgJHxigegS.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/HgJHxigegS.java#L73) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"78"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/IAgKTqwlrn.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [IAgKTqwlrn.java:151](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/IAgKTqwlrn.java#L151) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java`

Baseline source role/evidence: BANDEC operation menu builds routes for authentication, transfers, utility payments, ONAT, registration, account/limit queries, fines, giro, and other banking services; its dialogs dispatch selectors including `70`, `46`, `48`, `68*02`, `62`, `63`, and `58`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KmgeIVr5RG.java:242](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L242) | `actionCallUSSD` | 1. `"70"` |
| [KmgeIVr5RG.java:244](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L244) | `actionCallUSSD` | 1. `"70"` |
| [KmgeIVr5RG.java:268](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L268) | `actionCallUSSD` | 1. `"46"` |
| [KmgeIVr5RG.java:271](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L271) | `actionCallUSSD` | 1. `"46"` |
| [KmgeIVr5RG.java:275](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L275) | `actionCallUSSD` | 1. `"46"` |
| [KmgeIVr5RG.java:297](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L297) | `actionCallUSSD` | 1. `"48"` |
| [KmgeIVr5RG.java:300](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L300) | `actionCallUSSD` | 1. `"48"` |
| [KmgeIVr5RG.java:304](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L304) | `actionCallUSSD` | 1. `"48"` |
| [KmgeIVr5RG.java:326](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L326) | `actionCallUSSD` | 1. `"68*02"` |
| [KmgeIVr5RG.java:329](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L329) | `actionCallUSSD` | 1. `"68*02"` |
| [KmgeIVr5RG.java:333](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L333) | `actionCallUSSD` | 1. `"68*02"` |
| [KmgeIVr5RG.java:355](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L355) | `actionCallUSSD` | 1. `"62"` |
| [KmgeIVr5RG.java:358](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L358) | `actionCallUSSD` | 1. `"62"` |
| [KmgeIVr5RG.java:362](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L362) | `actionCallUSSD` | 1. `"62"` |
| [KmgeIVr5RG.java:402](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L402) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [KmgeIVr5RG.java:405](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L405) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [KmgeIVr5RG.java:409](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L409) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [KmgeIVr5RG.java:431](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L431) | `actionCallUSSD` | 1. `"58"` |
| [KmgeIVr5RG.java:434](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L434) | `actionCallUSSD` | 1. `"58"` |
| [KmgeIVr5RG.java:438](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java#L438) | `actionCallUSSD` | 1. `"58"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/RRLfqlrfwP.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [RRLfqlrfwP.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/RRLfqlrfwP.java#L55) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"75"`<br>3. `pin`<br>4. `"¿Desea solicitar el cambio de su PIN de multibanca?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/RYCvQK4nkF.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [RYCvQK4nkF.java:88](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/RYCvQK4nkF.java#L88) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"79"`<br>3. `cadena`<br>4. `"Confirme que desea generar el código pin"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/SIxHnoWicq.java`

Baseline source role/evidence: Bank transfer/payment form validates the account and amount, then dispatches selector `61` (`submitForm`, `validateCuenta`, `validateSumaApp`).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SIxHnoWicq.java:83](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/SIxHnoWicq.java#L83) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TGFziPh3KJ.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [TGFziPh3KJ.java:47](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TGFziPh3KJ.java#L47) | `actionCallUSSDBack` | 1. `"02"`<br>2. `this.context`<br>3. `"40"`<br>4. `clave`<br>5. `"Desea autenticarse en el sistema"`<br>6. `group`<br>7. `getFragmentManager()`<br>8. `getActivity()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [R7PmVxXLJZC.java:310](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L310) | `actionCallUSSD` | 1. `"85"` |
| [R7PmVxXLJZC.java:313](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L313) | `actionCallUSSD` | 1. `"85"` |
| [R7PmVxXLJZC.java:317](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L317) | `actionCallUSSD` | 1. `"85"` |
| [R7PmVxXLJZC.java:338](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L338) | `actionCallUSSD` | 1. `"70"` |
| [R7PmVxXLJZC.java:340](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L340) | `actionCallUSSD` | 1. `"70"` |
| [R7PmVxXLJZC.java:365](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L365) | `actionCallUSSD` | 1. `"46"` |
| [R7PmVxXLJZC.java:368](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L368) | `actionCallUSSD` | 1. `"46"` |
| [R7PmVxXLJZC.java:372](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L372) | `actionCallUSSD` | 1. `"46"` |
| [R7PmVxXLJZC.java:394](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L394) | `actionCallUSSD` | 1. `"48"` |
| [R7PmVxXLJZC.java:397](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L397) | `actionCallUSSD` | 1. `"48"` |
| [R7PmVxXLJZC.java:401](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L401) | `actionCallUSSD` | 1. `"48"` |
| [R7PmVxXLJZC.java:423](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L423) | `actionCallUSSD` | 1. `"62"` |
| [R7PmVxXLJZC.java:426](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L426) | `actionCallUSSD` | 1. `"62"` |
| [R7PmVxXLJZC.java:430](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L430) | `actionCallUSSD` | 1. `"62"` |
| [R7PmVxXLJZC.java:482](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L482) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [R7PmVxXLJZC.java:485](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L485) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [R7PmVxXLJZC.java:489](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L489) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [R7PmVxXLJZC.java:512](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L512) | `actionCallUSSD` | 1. `"58"` |
| [R7PmVxXLJZC.java:515](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L515) | `actionCallUSSD` | 1. `"58"` |
| [R7PmVxXLJZC.java:519](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L519) | `actionCallUSSD` | 1. `"58"` |
| [R7PmVxXLJZC.java:617](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L617) | `actionCallUSSD` | 1. `"103"` |
| [R7PmVxXLJZC.java:619](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/R7PmVxXLJZC.java#L619) | `actionCallUSSD` | 1. `"103"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [X7obECfkKf.java:236](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L236) | `actionCallUSSD` | 1. `"68*02"` |
| [X7obECfkKf.java:239](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L239) | `actionCallUSSD` | 1. `"68*02"` |
| [X7obECfkKf.java:243](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L243) | `actionCallUSSD` | 1. `"68*02"` |
| [X7obECfkKf.java:265](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L265) | `actionCallUSSD` | 1. `"76"`<br>2. `"1"` |
| [X7obECfkKf.java:268](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L268) | `actionCallUSSD` | 1. `"76"`<br>2. `"1"` |
| [X7obECfkKf.java:272](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/X7obECfkKf.java#L272) | `actionCallUSSD` | 1. `"76"`<br>2. `"1"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/rvxiiV3tYu.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [rvxiiV3tYu.java:133](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/rvxiiV3tYu.java#L133) | `actionCallUSSD` | 1. `"70"` |
| [rvxiiV3tYu.java:135](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/TJzyszIDKqc/rvxiiV3tYu.java#L135) | `actionCallUSSD` | 1. `"70"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/fvzO0qRHbu.java`

Baseline source role/evidence: Postal giro form validates origin/destination identity numbers, amount, currency, reason, and recipient phone, then submits selector `64` (`submitForm`, `validateCIOrigen`, `validateCIDestino`, `validateMonto`, `validateTipoMotivo`, `validateNumber`).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [fvzO0qRHbu.java:108](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/fvzO0qRHbu.java#L108) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/gsthr0APCT.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [gsthr0APCT.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/gsthr0APCT.java#L55) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"65"`<br>3. `ci`<br>4. `"¿Desea realizar la consulta de giros pendientes?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/hvC0UGR2L0.java`

Baseline source role/evidence: Telecommunications/phone bill form validates account and amount, dispatches selector `42`, and presents payment-option selection.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [hvC0UGR2L0.java:107](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/hvC0UGR2L0.java#L107) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/idsoBKS8L3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [idsoBKS8L3.java:254](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/idsoBKS8L3.java#L254) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"47"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [idsoBKS8L3.java:264](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/idsoBKS8L3.java#L264) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"56"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group`<br>6. `getFragmentManager()` |
| [idsoBKS8L3.java:274](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/idsoBKS8L3.java#L274) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"56"`<br>3. `cadena3`<br>4. `msg3`<br>5. `group`<br>6. `getFragmentManager()` |
| [idsoBKS8L3.java:379](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/idsoBKS8L3.java#L379) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"22"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/kAazEwDasT.java`

Baseline source role/evidence: Application form validates account, applicant name, monthly term, and amount before submitting selector `55`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [kAazEwDasT.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/kAazEwDasT.java#L65) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/KsDQL9cTTl.java`

Baseline source role/evidence: BANDEC account-opening form selects a branch and submits selector `76` to open a USD account backed by MLC.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KsDQL9cTTl.java:120](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/KsDQL9cTTl.java#L120) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"76"`<br>3. `surcursalSeleccionado`<br>4. `"¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/Xh70Rdjfpc.java`

Baseline source role/evidence: Banking account operation form dispatches selector `87`; it extends the shared account/payment form (`QGQCqILT4b`).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Xh70Rdjfpc.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/Xh70Rdjfpc.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"87"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/g9VybPHHUE.java`

Baseline source role/evidence: Registration-removal form confirms deletion from the service and submits selector `68`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [g9VybPHHUE.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/g9VybPHHUE.java#L66) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"68"`<br>3. `cadena`<br>4. `"Desea eliminar su registro del sistema"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/uWkWt7AEZ5.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [uWkWt7AEZ5.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/uWkWt7AEZ5.java#L73) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"61"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [uWkWt7AEZ5.java:75](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/uWkWt7AEZ5.java#L75) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/o9swVUfDl4q.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [o9swVUfDl4q.java:78](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/o9swVUfDl4q.java#L78) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"60"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/q9DNC6bnexm.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [q9DNC6bnexm.java:178](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/q9DNC6bnexm.java#L178) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"52"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sT2WhSOo3S.java`

Baseline source role/evidence: Gas-payment form identifies the cashier, selects payment type, validates both, and submits selector `67`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [sT2WhSOo3S.java:106](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sT2WhSOo3S.java#L106) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sxbhjZQZxo.java`

Baseline source role/evidence: Password-change form validates the entered key and dispatches selector `68`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [sxbhjZQZxo.java:48](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sxbhjZQZxo.java#L48) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"68"`<br>3. `clave`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ASLdujtVtr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ASLdujtVtr.java:99](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ASLdujtVtr.java#L99) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"64"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [ASLdujtVtr.java:101](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ASLdujtVtr.java#L101) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/D6YZ7ruA6K.java`

Baseline source role/evidence: BANDEC mobile top-up validates phone, amount, and selected source account; imports contacts and sends selector `54`, with packetized partial-USSD fallback.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [D6YZ7ruA6K.java:100](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/D6YZ7ruA6K.java#L100) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"54"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [D6YZ7ruA6K.java:102](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/D6YZ7ruA6K.java#L102) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/LZaBQezxPC.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [LZaBQezxPC.java:74](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/LZaBQezxPC.java#L74) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"55"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [LZaBQezxPC.java:76](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/LZaBQezxPC.java#L76) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Lxfm3mPhrA.java`

Baseline source role/evidence: Extended account-transfer form validates transfer details and currency/account rules, assembles recipient/message/flags, and dispatches selector `45`; one card-rendering method is an JADX stub, so that rendering detail remains unresolved.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Lxfm3mPhrA.java:513](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Lxfm3mPhrA.java#L513) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Q3Nvf439ab.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Q3Nvf439ab.java:108](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Q3Nvf439ab.java#L108) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [Q3Nvf439ab.java:110](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Q3Nvf439ab.java#L110) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"41"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/SZARzeWeX5.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SZARzeWeX5.java:123](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/SZARzeWeX5.java#L123) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"94"`<br>3. `cadena`<br>4. `"¿Desea realizar el pago? "`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/StppiHhx0a.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [StppiHhx0a.java:52](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/StppiHhx0a.java#L52) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"82"`<br>3. `cadena`<br>4. `"¿Desea cerrar el plazo fijo de la cuenta indicada?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [T4RQ5wDJDt.java:207](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L207) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"19"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [T4RQ5wDJDt.java:210](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L210) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"19"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [T4RQ5wDJDt.java:217](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L217) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena2`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [T4RQ5wDJDt.java:220](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L220) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"51"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena2`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [T4RQ5wDJDt.java:226](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L226) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"21"`<br>3. `cadena3`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [T4RQ5wDJDt.java:228](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/T4RQ5wDJDt.java#L228) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"21"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ZDkigMAIBm.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ZDkigMAIBm.java:562](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ZDkigMAIBm.java#L562) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [ZDkigMAIBm.java:565](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ZDkigMAIBm.java#L565) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [ZDkigMAIBm.java:570](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/ZDkigMAIBm.java#L570) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"45"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadenaInicio + cadenaAjustada`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/aiwIHVBe0c.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [aiwIHVBe0c.java:134](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/aiwIHVBe0c.java#L134) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"67"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [aiwIHVBe0c.java:136](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/aiwIHVBe0c.java#L136) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/eGLVt6hhNF.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [eGLVt6hhNF.java:178](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/eGLVt6hhNF.java#L178) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"81"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [eGLVt6hhNF.java:180](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/eGLVt6hhNF.java#L180) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"81"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/g7yG4Frdxy.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [g7yG4Frdxy.java:186](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/g7yG4Frdxy.java#L186) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"52"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [g7yG4Frdxy.java:188](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/g7yG4Frdxy.java#L188) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"52"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/iQte15zdZs.java`

Baseline source role/evidence: Telecommunications bill form validates payment data, submits selector `42`, and supports packetized partial USSD.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [iQte15zdZs.java:177](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/iQte15zdZs.java#L177) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"42"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [iQte15zdZs.java:179](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/iQte15zdZs.java#L179) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/m0X6Kxdhmv.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [m0X6Kxdhmv.java:48](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/m0X6Kxdhmv.java#L48) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"25"`<br>3. `cadena`<br>4. `"¿Desea realizar la modificar la mensualidad?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/t7in6psmmaQ.java`

Baseline source role/evidence: ONAT payment form validates license/payment data and dispatches selector `43`, with partial-payment and packetized USSD paths.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [t7in6psmmaQ.java:117](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/t7in6psmmaQ.java#L117) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [t7in6psmmaQ.java:119](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/t7in6psmmaQ.java#L119) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/vVF87n7MnK.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [vVF87n7MnK.java:170](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/vVF87n7MnK.java#L170) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"74"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/wLHKkaC4Ha.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wLHKkaC4Ha.java:102](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/wLHKkaC4Ha.java#L102) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"49"`<br>3. `cadena`<br>4. `"Desea registrarse en el sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [wLHKkaC4Ha.java:104](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/wLHKkaC4Ha.java#L104) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"49"`<br>4. `"02"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea registrarse en el sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/AckAnySXkn.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [AckAnySXkn.java:129](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/AckAnySXkn.java#L129) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/CUlS6AdACy.java`

Baseline source role/evidence: BPA electricity payment form; validates payment fields and dispatches selector `41`, including segmented `110`/`41`/`05` handling.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [CUlS6AdACy.java:138](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/CUlS6AdACy.java#L138) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [CUlS6AdACy.java:140](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/CUlS6AdACy.java#L140) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"41"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/FSH5TTPZXI.java`

Baseline source role/evidence: Extended bank transfer form validates accounts/currency and assembles transfer payload; `submitForm` dispatches selector `45`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FSH5TTPZXI.java:587](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/FSH5TTPZXI.java#L587) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/GKs5yCtPyT.java`

Baseline source role/evidence: BPA gas payment form validates its fields and dispatches selector `54`, with segmented `110`/`54`/`05` handling.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [GKs5yCtPyT.java:123](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/GKs5yCtPyT.java#L123) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"54"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [GKs5yCtPyT.java:125](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/GKs5yCtPyT.java#L125) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/ILoKZQnPEb.java`

Baseline source role/evidence: BPA external payment form confirms and dispatches selector `94`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ILoKZQnPEb.java:99](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/ILoKZQnPEb.java#L99) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"94"`<br>3. `cadena`<br>4. `"¿Desea realizar el pago? "`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java`

Baseline source role/evidence: BPA water payment form handles region/branch variants and selectors `19`, `51`, and `21`, including partial USSD packets.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [LHLbFzX21y.java:211](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L211) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"19"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [LHLbFzX21y.java:214](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L214) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"19"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [LHLbFzX21y.java:220](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L220) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [LHLbFzX21y.java:223](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L223) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"51"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [LHLbFzX21y.java:228](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L228) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"21"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [LHLbFzX21y.java:230](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java#L230) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"21"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/MIya98FZRz.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [MIya98FZRz.java:71](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/MIya98FZRz.java#L71) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"26"`<br>3. `cadena`<br>4. `"¿Desea obtener el estado de la cuenta seleccionada? Esta operación realiza un cobro de comisión a la cuenta selecionada"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/RGGlSlGwBS.java`

Baseline source role/evidence: BPA postal giro form validates operation inputs and dispatches selector `64`, including segmented USSD.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [RGGlSlGwBS.java:96](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/RGGlSlGwBS.java#L96) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"64"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [RGGlSlGwBS.java:98](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/RGGlSlGwBS.java#L98) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/Sh9ycEKe3r.java`

Baseline source role/evidence: BPA telecommunications payment form validates account/amount and sends selector `42`; also defines a decimal amount input filter.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Sh9ycEKe3r.java:182](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/Sh9ycEKe3r.java#L182) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"42"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [Sh9ycEKe3r.java:184](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/Sh9ycEKe3r.java#L184) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/U3Fs3ZfEsvU.java`

Baseline source role/evidence: BPA gas bill payment form validates payment data and dispatches selector `67`, with segmented USSD support.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [U3Fs3ZfEsvU.java:111](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/U3Fs3ZfEsvU.java#L111) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [U3Fs3ZfEsvU.java:113](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/U3Fs3ZfEsvU.java#L113) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"67"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/aagv9XXigK.java`

Baseline source role/evidence: Fixed-term deposit closure confirmation form submits selector `82` and warns about early-closure conditions.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [aagv9XXigK.java:52](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/aagv9XXigK.java#L52) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"82"`<br>3. `cadena`<br>4. `"¿Desea cerrar el plazo fijo de la cuenta indicada? Si cierra el Plazo Fijo antes del mes o los tres meses de aperturado, se le cobrará una comisión"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/e7QqJJqvaOU.java`

Baseline source role/evidence: BPA query form validates inputs and submits selector `24`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [e7QqJJqvaOU.java:45](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/e7QqJJqvaOU.java#L45) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"24"`<br>3. `cadena`<br>4. `"¿Desea realizar realizar la consulta?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/f1IveoSASW.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f1IveoSASW.java:495](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/f1IveoSASW.java#L495) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"104"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [f1IveoSASW.java:497](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/f1IveoSASW.java#L497) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"104"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/o7atwhPiFj.java`

Baseline source role/evidence: BPA credit application form validates loan inputs and submits selector `81`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [o7atwhPiFj.java:108](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/o7atwhPiFj.java#L108) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"81"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/oGGmtSBioS.java`

Baseline source role/evidence: BPA loan amortization form confirms and submits selector `55`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [oGGmtSBioS.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/oGGmtSBioS.java#L65) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/yB5HZ4Ae3W.java`

Baseline source role/evidence: BPA ONAT payment form validates payment inputs and submits selector `43`, with segmented USSD support.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yB5HZ4Ae3W.java:169](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/yB5HZ4Ae3W.java#L169) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [yB5HZ4Ae3W.java:171](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/yB5HZ4Ae3W.java#L171) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/zqBrU3RI5y.java`

Baseline source role/evidence: Fixed-term deposit monthly contribution modification form confirms and submits selector `25`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [zqBrU3RI5y.java:48](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/zqBrU3RI5y.java#L48) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"25"`<br>3. `cadena`<br>4. `"¿Desea realizar la modificar la mensualidad?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EIfp9Vz3ur.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [EIfp9Vz3ur.java:54](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EIfp9Vz3ur.java#L54) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"53"`<br>3. `cadena`<br>4. `"Desea actualizar su cuenta"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/F2leFVNWrdy.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [F2leFVNWrdy.java:89](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/F2leFVNWrdy.java#L89) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"60"`<br>3. `cadena`<br>4. `"Desea actualizar su cuenta"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/Kq8PoyEkLY.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Kq8PoyEkLY.java:81](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/Kq8PoyEkLY.java#L81) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/LLgTQRWb61.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [LLgTQRWb61.java:184](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/LLgTQRWb61.java#L184) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/OqcjrfuV9V.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [OqcjrfuV9V.java:86](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/OqcjrfuV9V.java#L86) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"79"`<br>3. `cadena`<br>4. `"Confirme que desea generar el código pin"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/QGOIyTuo2a.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [QGOIyTuo2a.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/QGOIyTuo2a.java#L55) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"65"`<br>3. `ci`<br>4. `"¿Desea realizar la consulta de giros pendientes?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ME2IdEhApc.java:249](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L249) | `actionCallUSSD` | 1. `"58"` |
| [ME2IdEhApc.java:252](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L252) | `actionCallUSSD` | 1. `"58"` |
| [ME2IdEhApc.java:256](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L256) | `actionCallUSSD` | 1. `"58"` |
| [ME2IdEhApc.java:279](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L279) | `actionCallUSSD` | 1. `"78"` |
| [ME2IdEhApc.java:282](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L282) | `actionCallUSSD` | 1. `"78"` |
| [ME2IdEhApc.java:286](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L286) | `actionCallUSSD` | 1. `"78"` |
| [ME2IdEhApc.java:309](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L309) | `actionCallUSSD` | 1. `"85"` |
| [ME2IdEhApc.java:312](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L312) | `actionCallUSSD` | 1. `"85"` |
| [ME2IdEhApc.java:316](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L316) | `actionCallUSSD` | 1. `"85"` |
| [ME2IdEhApc.java:339](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L339) | `actionCallUSSD` | 1. `"73"` |
| [ME2IdEhApc.java:342](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L342) | `actionCallUSSD` | 1. `"73"` |
| [ME2IdEhApc.java:346](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L346) | `actionCallUSSD` | 1. `"73"` |
| [ME2IdEhApc.java:442](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L442) | `actionCallUSSD` | 1. `"72"` |
| [ME2IdEhApc.java:445](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L445) | `actionCallUSSD` | 1. `"72"` |
| [ME2IdEhApc.java:449](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L449) | `actionCallUSSD` | 1. `"72"` |
| [ME2IdEhApc.java:472](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L472) | `actionCallUSSD` | 1. `"103"` |
| [ME2IdEhApc.java:475](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L475) | `actionCallUSSD` | 1. `"103"` |
| [ME2IdEhApc.java:479](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/ME2IdEhApc.java#L479) | `actionCallUSSD` | 1. `"103"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/vhcWzIxxMH.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [vhcWzIxxMH.java:125](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/vhcWzIxxMH.java#L125) | `actionCallUSSD` | 1. `"70"` |
| [vhcWzIxxMH.java:128](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/vhcWzIxxMH.java#L128) | `actionCallUSSD` | 1. `"70"` |
| [vhcWzIxxMH.java:132](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/vhcWzIxxMH.java#L132) | `actionCallUSSD` | 1. `"70"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SqtuHONWS9.java:293](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L293) | `actionCallUSSD` | 1. `"70"` |
| [SqtuHONWS9.java:296](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L296) | `actionCallUSSD` | 1. `"70"` |
| [SqtuHONWS9.java:300](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L300) | `actionCallUSSD` | 1. `"70"` |
| [SqtuHONWS9.java:324](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L324) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [SqtuHONWS9.java:327](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L327) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [SqtuHONWS9.java:332](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L332) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [SqtuHONWS9.java:335](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L335) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [SqtuHONWS9.java:340](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L340) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [SqtuHONWS9.java:342](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L342) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [SqtuHONWS9.java:366](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L366) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [SqtuHONWS9.java:369](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L369) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [SqtuHONWS9.java:374](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L374) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [SqtuHONWS9.java:377](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L377) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [SqtuHONWS9.java:382](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L382) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [SqtuHONWS9.java:384](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L384) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [SqtuHONWS9.java:407](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L407) | `actionCallUSSD` | 1. `"58"` |
| [SqtuHONWS9.java:410](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L410) | `actionCallUSSD` | 1. `"58"` |
| [SqtuHONWS9.java:414](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L414) | `actionCallUSSD` | 1. `"58"` |
| [SqtuHONWS9.java:478](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L478) | `actionCallUSSD` | 1. `"73"` |
| [SqtuHONWS9.java:481](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L481) | `actionCallUSSD` | 1. `"73"` |
| [SqtuHONWS9.java:485](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L485) | `actionCallUSSD` | 1. `"73"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SvY0xjeNSz.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SvY0xjeNSz.java:51](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SvY0xjeNSz.java#L51) | `actionCallUSSDBack` | 1. `"05"`<br>2. `this.context`<br>3. `"40"`<br>4. `clave`<br>5. `"Desea autenticarse en el sistema"`<br>6. `group`<br>7. `getFragmentManager()`<br>8. `getActivity()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/ToMfHpA64Q.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ToMfHpA64Q.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/ToMfHpA64Q.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/VDdZyDB4Rz.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [VDdZyDB4Rz.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/VDdZyDB4Rz.java#L53) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"68"`<br>3. `cadena`<br>4. `"Desea eliminar su registro del sistema"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/WQfsFaP3Ke.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [WQfsFaP3Ke.java:106](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/WQfsFaP3Ke.java#L106) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/XnzjMaEqy5.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XnzjMaEqy5.java:117](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/XnzjMaEqy5.java#L117) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/ao6TPmKHkd.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ao6TPmKHkd.java:90](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/ao6TPmKHkd.java#L90) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/eeKPdD3QkE.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [eeKPdD3QkE.java:199](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/eeKPdD3QkE.java#L199) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/KvpkEH7lRr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KvpkEH7lRr.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/KvpkEH7lRr.java#L66) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/WoIpvvMtRp.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [WoIpvvMtRp.java:102](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/WoIpvvMtRp.java#L102) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"74"`<br>3. `cadena`<br>4. `"¿Desea reimprimir su tarjeta?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/XupYdyDxle.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [XupYdyDxle.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/XupYdyDxle.java#L53) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"87"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/wJLggUmg0M.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wJLggUmg0M.java:67](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/wJLggUmg0M.java#L67) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"27"`<br>3. `cadena`<br>4. `"¿Desea realizar la modificación de la prelación de pago?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/wT2pxaYNUx.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wT2pxaYNUx.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/wT2pxaYNUx.java#L73) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"61"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [wT2pxaYNUx.java:75](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/hqlegRdVXsu/wT2pxaYNUx.java#L75) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Mg7YIILN4B.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Mg7YIILN4B.java:117](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Mg7YIILN4B.java#L117) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"46"`<br>3. `cadena`<br>4. `"¿Desea consultar el saldo de su cuenta?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [Mg7YIILN4B.java:119](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Mg7YIILN4B.java#L119) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"46"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar el saldo de su cuenta?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Np5pMRuX6q.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [Np5pMRuX6q.java:126](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Np5pMRuX6q.java#L126) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `"Desea consultar las ultimas operaciones "`<br>5. `group`<br>6. `getFragmentManager()` |
| [Np5pMRuX6q.java:128](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/Np5pMRuX6q.java#L128) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"48"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea consultar las ultimas operaciones "`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/leZyk029xo.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [leZyk029xo.java:117](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/leZyk029xo.java#L117) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"62"`<br>3. `cadena`<br>4. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [leZyk029xo.java:119](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/leZyk029xo.java#L119) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"62"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/stRd4NiI1J.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [stRd4NiI1J.java:45](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/iKwHmDs0tyq/stRd4NiI1J.java#L45) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"28"`<br>3. `cadena`<br>4. `"¿Desea realizar la consulta de la prelación de pago?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/l0o1aWhls2I.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [l0o1aWhls2I.java:130](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/l0o1aWhls2I.java#L130) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m0lk5Y7wy1E.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [m0lk5Y7wy1E.java:246](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m0lk5Y7wy1E.java#L246) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"47"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [m0lk5Y7wy1E.java:256](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m0lk5Y7wy1E.java#L256) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"56"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group`<br>6. `getFragmentManager()` |
| [m0lk5Y7wy1E.java:276](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m0lk5Y7wy1E.java#L276) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"22"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m9T8uuGkPp.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [m9T8uuGkPp.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/m9T8uuGkPp.java#L105) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/pErBd7vVLh.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [pErBd7vVLh.java:111](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/pErBd7vVLh.java#L111) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/sHCJZGMjak.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [sHCJZGMjak.java:90](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/sHCJZGMjak.java#L90) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"76"`<br>3. `cadena`<br>4. `"¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/umjSGajOy3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [umjSGajOy3.java:82](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/umjSGajOy3.java#L82) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"49"`<br>3. `cadena`<br>4. `"Desea registrarse en el sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [umjSGajOy3.java:84](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/umjSGajOy3.java#L84) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"49"`<br>4. `"05"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea registrarse en el sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/wJTVCHHHdv.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [wJTVCHHHdv.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/wJTVCHHHdv.java#L59) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [wJTVCHHHdv.java:62](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/wJTVCHHHdv.java#L62) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [wJTVCHHHdv.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/wJTVCHHHdv.java#L66) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/GhhAuUBVrI.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 48 (zpT98w56Knm/Aj11H1nzNkW/GhhAuUBVrI.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [GhhAuUBVrI.java:82](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/GhhAuUBVrI.java#L82) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [GhhAuUBVrI.java:84](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/GhhAuUBVrI.java#L84) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"48"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/dVxDCMi9cK.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 46 (zpT98w56Knm/Aj11H1nzNkW/dVxDCMi9cK.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dVxDCMi9cK.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/dVxDCMi9cK.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"46"`<br>3. `cadena`<br>4. `"¿Desea consultar el saldo de su tarjeta?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [dVxDCMi9cK.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/dVxDCMi9cK.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"46"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar el saldo de su tarjeta?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/gkzzwVYksz.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 62 (zpT98w56Knm/Aj11H1nzNkW/gkzzwVYksz.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [gkzzwVYksz.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/gkzzwVYksz.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"62"`<br>3. `cadena`<br>4. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>5. `group`<br>6. `getFragmentManager()` |
| [gkzzwVYksz.java:58](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/gkzzwVYksz.java#L58) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"62"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/m3eQg75J6k0.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 28 (zpT98w56Knm/Aj11H1nzNkW/m3eQg75J6k0.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [m3eQg75J6k0.java:45](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/m3eQg75J6k0.java#L45) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"28"`<br>3. `cadena`<br>4. `"¿Desea realizar la consulta de la prelación de pago?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/B0Bcr9KURy.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 69 (zpT98w56Knm/B0Bcr9KURy.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [B0Bcr9KURy.java:56](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/B0Bcr9KURy.java#L56) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/B0pAI2n4A2L.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [B0pAI2n4A2L.java:130](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/B0pAI2n4A2L.java#L130) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/D72cHBJnHT4.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [D72cHBJnHT4.java:81](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/D72cHBJnHT4.java#L81) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"48"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EE6rW3ZDLN.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [EE6rW3ZDLN.java:106](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EE6rW3ZDLN.java#L106) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 19 (zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [BoMBck6OXT.java:215](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L215) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"19"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [BoMBck6OXT.java:218](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L218) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"19"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [BoMBck6OXT.java:224](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L224) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [BoMBck6OXT.java:227](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L227) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"51"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [BoMBck6OXT.java:232](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L232) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"21"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [BoMBck6OXT.java:234](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java#L234) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"21"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/KJm9NxxPQx.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 54 (zpT98w56Knm/EJvHfXHGTV8/KJm9NxxPQx.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [KJm9NxxPQx.java:123](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/KJm9NxxPQx.java#L123) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"54"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [KJm9NxxPQx.java:125](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/KJm9NxxPQx.java#L125) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/MAvaCEUqwa.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 24 (zpT98w56Knm/EJvHfXHGTV8/MAvaCEUqwa.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [MAvaCEUqwa.java:49](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/MAvaCEUqwa.java#L49) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"24"`<br>3. `cadena`<br>4. `"¿Desea realizar realizar la consulta?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/N4kvcsGpCN.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 81 (zpT98w56Knm/EJvHfXHGTV8/N4kvcsGpCN.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [N4kvcsGpCN.java:108](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/N4kvcsGpCN.java#L108) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"81"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/PliSaYhOg0.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 41 (zpT98w56Knm/EJvHfXHGTV8/PliSaYhOg0.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PliSaYhOg0.java:138](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/PliSaYhOg0.java#L138) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [PliSaYhOg0.java:140](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/PliSaYhOg0.java#L140) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"41"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/RFGGC2VcTY.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 43 (zpT98w56Knm/EJvHfXHGTV8/RFGGC2VcTY.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [RFGGC2VcTY.java:169](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/RFGGC2VcTY.java#L169) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [RFGGC2VcTY.java:171](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/RFGGC2VcTY.java#L171) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/TlJMpg47gS.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 82 (zpT98w56Knm/EJvHfXHGTV8/TlJMpg47gS.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [TlJMpg47gS.java:52](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/TlJMpg47gS.java#L52) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"82"`<br>3. `cadena`<br>4. `"¿Desea cerrar el plazo fijo de la cuenta indicada? Si cierra el Plazo Fijo antes del mes o los tres meses de aperturado, se le cobrará una comisión"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/aCwLXhT3MF.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 26 (zpT98w56Knm/EJvHfXHGTV8/aCwLXhT3MF.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [aCwLXhT3MF.java:69](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/aCwLXhT3MF.java#L69) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"26"`<br>3. `cadena`<br>4. `"¿Desea obtener el estado de la cuenta seleccionada? Esta operación realiza un cobro de comisión a la cuenta selecionada"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/k2rtzJwkcQ.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 25 (zpT98w56Knm/EJvHfXHGTV8/k2rtzJwkcQ.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [k2rtzJwkcQ.java:48](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/k2rtzJwkcQ.java#L48) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"25"`<br>3. `cadena`<br>4. `"¿Desea realizar la modificar la mensualidad?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/lQox6tgMlH.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 94 (zpT98w56Knm/EJvHfXHGTV8/lQox6tgMlH.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [lQox6tgMlH.java:99](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/lQox6tgMlH.java#L99) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"94"`<br>3. `cadena`<br>4. `"¿Desea realizar el pago? "`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/mhElzRz7zH.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 64 (zpT98w56Knm/EJvHfXHGTV8/mhElzRz7zH.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [mhElzRz7zH.java:96](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/mhElzRz7zH.java#L96) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"64"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [mhElzRz7zH.java:98](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/mhElzRz7zH.java#L98) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/onjPHcH2OE.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 45 (zpT98w56Knm/EJvHfXHGTV8/onjPHcH2OE.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [onjPHcH2OE.java:593](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/onjPHcH2OE.java#L593) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/pnl2Kga8j7.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 42 (zpT98w56Knm/EJvHfXHGTV8/pnl2Kga8j7.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [pnl2Kga8j7.java:182](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/pnl2Kga8j7.java#L182) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"42"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [pnl2Kga8j7.java:184](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/pnl2Kga8j7.java#L184) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/q8aBmCOCwuI.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 55 (zpT98w56Knm/EJvHfXHGTV8/q8aBmCOCwuI.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [q8aBmCOCwuI.java:65](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/q8aBmCOCwuI.java#L65) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"55"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 45 (zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [x6Wob3Sa98U.java:646](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java#L646) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [x6Wob3Sa98U.java:649](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java#L649) | `actionCallUSSDBackWithRetun` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [x6Wob3Sa98U.java:654](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java#L654) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"45"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadenaInicio + cadenaAjustada`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/yiqT29TYTb.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 67 (zpT98w56Knm/EJvHfXHGTV8/yiqT29TYTb.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yiqT29TYTb.java:131](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/yiqT29TYTb.java#L131) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"67"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [yiqT29TYTb.java:133](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/yiqT29TYTb.java#L133) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"67"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/F5QGj1YaNB.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [F5QGj1YaNB.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/F5QGj1YaNB.java#L59) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"68"`<br>3. `cadena`<br>4. `"Desea eliminar su registro del sistema"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/FLftkSrl5R.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 69 (zpT98w56Knm/G8E5Fjf9l7Y1/FLftkSrl5R.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FLftkSrl5R.java:63](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/FLftkSrl5R.java#L63) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"69"`<br>3. `pin`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/HGFRxfLF5W.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 87 (zpT98w56Knm/G8E5Fjf9l7Y1/HGFRxfLF5W.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [HGFRxfLF5W.java:53](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/HGFRxfLF5W.java#L53) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"87"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/TFU20KJsT9.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 27 (zpT98w56Knm/G8E5Fjf9l7Y1/TFU20KJsT9.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [TFU20KJsT9.java:67](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/TFU20KJsT9.java#L67) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"27"`<br>3. `cadena`<br>4. `"¿Desea realizar la modificación de la prelación de pago?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/tYCC0hiRcm.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 74 (zpT98w56Knm/G8E5Fjf9l7Y1/tYCC0hiRcm.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [tYCC0hiRcm.java:102](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/tYCC0hiRcm.java#L102) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"74"`<br>3. `cadena`<br>4. `"¿Desea reimprimir su tarjeta?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/xR6zA9CmCE.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 61 (zpT98w56Knm/G8E5Fjf9l7Y1/xR6zA9CmCE.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xR6zA9CmCE.java:73](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/xR6zA9CmCE.java#L73) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"61"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [xR6zA9CmCE.java:75](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/xR6zA9CmCE.java#L75) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/L3qC11Tn05K.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 44 (zpT98w56Knm/L3qC11Tn05K.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [L3qC11Tn05K.java:59](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/L3qC11Tn05K.java#L59) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [L3qC11Tn05K.java:62](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/L3qC11Tn05K.java#L62) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |
| [L3qC11Tn05K.java:66](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/L3qC11Tn05K.java#L66) | `actionCallUSSD` | 1. `"44"`<br>2. `cadena`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PAZK2sdsJ5.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PAZK2sdsJ5.java:51](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PAZK2sdsJ5.java#L51) | `actionCallUSSDBack` | 1. `"03"`<br>2. `this.context`<br>3. `"40"`<br>4. `clave`<br>5. `"Desea autenticarse en el sistema"`<br>6. `group`<br>7. `getFragmentManager()`<br>8. `getActivity()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java`

Baseline source role/evidence: Menu implements account balance/service query routes (zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PEi17BvMam.java:347](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L347) | `actionCallUSSD` | 1. `"58"` |
| [PEi17BvMam.java:350](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L350) | `actionCallUSSD` | 1. `"58"` |
| [PEi17BvMam.java:354](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L354) | `actionCallUSSD` | 1. `"58"` |
| [PEi17BvMam.java:377](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L377) | `actionCallUSSD` | 1. `"78"` |
| [PEi17BvMam.java:380](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L380) | `actionCallUSSD` | 1. `"78"` |
| [PEi17BvMam.java:384](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L384) | `actionCallUSSD` | 1. `"78"` |
| [PEi17BvMam.java:407](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L407) | `actionCallUSSD` | 1. `"85"` |
| [PEi17BvMam.java:410](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L410) | `actionCallUSSD` | 1. `"85"` |
| [PEi17BvMam.java:414](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L414) | `actionCallUSSD` | 1. `"85"` |
| [PEi17BvMam.java:437](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L437) | `actionCallUSSD` | 1. `"73"` |
| [PEi17BvMam.java:440](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L440) | `actionCallUSSD` | 1. `"73"` |
| [PEi17BvMam.java:444](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L444) | `actionCallUSSD` | 1. `"73"` |
| [PEi17BvMam.java:540](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L540) | `actionCallUSSD` | 1. `"72"` |
| [PEi17BvMam.java:543](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L543) | `actionCallUSSD` | 1. `"72"` |
| [PEi17BvMam.java:547](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L547) | `actionCallUSSD` | 1. `"72"` |
| [PEi17BvMam.java:572](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L572) | `actionCallUSSD` | 1. `"103"` |
| [PEi17BvMam.java:574](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java#L574) | `actionCallUSSD` | 1. `"103"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java`

Baseline source role/evidence: Menu implements operation chooser and fragment routes (zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [bvKZxRIdlB.java:125](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java#L125) | `actionCallUSSD` | 1. `"70"` |
| [bvKZxRIdlB.java:128](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java#L128) | `actionCallUSSD` | 1. `"70"` |
| [bvKZxRIdlB.java:132](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java#L132) | `actionCallUSSD` | 1. `"70"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/QGWR08ohw3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [QGWR08ohw3.java:90](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/QGWR08ohw3.java#L90) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"61"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/QvFJrHMt6S.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [QvFJrHMt6S.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/QvFJrHMt6S.java#L105) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"51"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/RFBEnXW0Xr.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [RFBEnXW0Xr.java:103](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/RFBEnXW0Xr.java#L103) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"49"`<br>3. `cadena`<br>4. `"Desea registrarse en el sistema"`<br>5. `group`<br>6. `getFragmentManager()` |
| [RFBEnXW0Xr.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/RFBEnXW0Xr.java#L105) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"49"`<br>4. `"03"`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"Desea registrarse en el sistema"`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/S3URlNRKqlK.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [S3URlNRKqlK.java:111](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/S3URlNRKqlK.java#L111) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"64"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/T460cLTd4A1.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 45 (zpT98w56Knm/T460cLTd4A1.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [T460cLTd4A1.java:199](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/T460cLTd4A1.java#L199) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"45"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/dYe9oOuW7h.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 79 (zpT98w56Knm/dYe9oOuW7h.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [dYe9oOuW7h.java:86](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/dYe9oOuW7h.java#L86) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"79"`<br>3. `cadena`<br>4. `"Confirme que desea generar el código pin"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/gUJ1ICglWB.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 42 (zpT98w56Knm/gUJ1ICglWB.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [gUJ1ICglWB.java:129](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/gUJ1ICglWB.java#L129) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"42"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/hJhf3aumcr.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 47/56 (zpT98w56Knm/hJhf3aumcr.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [hJhf3aumcr.java:246](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/hJhf3aumcr.java#L246) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"47"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [hJhf3aumcr.java:256](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/hJhf3aumcr.java#L256) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"56"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group`<br>6. `getFragmentManager()` |
| [hJhf3aumcr.java:276](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/hJhf3aumcr.java#L276) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"22"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/jyBbMyVMOV.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 65 (zpT98w56Knm/jyBbMyVMOV.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [jyBbMyVMOV.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/jyBbMyVMOV.java#L55) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"65"`<br>3. `ci`<br>4. `"¿Desea realizar la consulta de giros pendientes?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/kD9wg15jwt.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 76 (zpT98w56Knm/kD9wg15jwt.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [kD9wg15jwt.java:90](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/kD9wg15jwt.java#L90) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"76"`<br>3. `cadena`<br>4. `"¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/rZEvnp2Sqs.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 43 (zpT98w56Knm/rZEvnp2Sqs.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [rZEvnp2Sqs.java:184](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/rZEvnp2Sqs.java#L184) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/uurdBwh7ub.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 60 (zpT98w56Knm/uurdBwh7ub.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [uurdBwh7ub.java:89](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/uurdBwh7ub.java#L89) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"60"`<br>3. `cadena`<br>4. `"Desea actualizar su cuenta"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/x65QVMzjQ2n.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 41 (zpT98w56Knm/x65QVMzjQ2n.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [x65QVMzjQ2n.java:117](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/x65QVMzjQ2n.java#L117) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"41"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 70 (zpT98w56Knm/yDpeA65zCe.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yDpeA65zCe.java:293](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L293) | `actionCallUSSD` | 1. `"70"` |
| [yDpeA65zCe.java:296](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L296) | `actionCallUSSD` | 1. `"70"` |
| [yDpeA65zCe.java:300](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L300) | `actionCallUSSD` | 1. `"70"` |
| [yDpeA65zCe.java:324](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L324) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [yDpeA65zCe.java:327](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L327) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [yDpeA65zCe.java:332](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L332) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [yDpeA65zCe.java:335](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L335) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [yDpeA65zCe.java:340](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L340) | `actionCallUSSD` | 1. `"46"`<br>2. `"1"` |
| [yDpeA65zCe.java:342](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L342) | `actionCallUSSD` | 1. `"46"`<br>2. `"2"` |
| [yDpeA65zCe.java:366](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L366) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [yDpeA65zCe.java:369](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L369) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [yDpeA65zCe.java:374](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L374) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [yDpeA65zCe.java:377](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L377) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [yDpeA65zCe.java:382](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L382) | `actionCallUSSD` | 1. `"62"`<br>2. `"1"` |
| [yDpeA65zCe.java:384](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L384) | `actionCallUSSD` | 1. `"62"`<br>2. `"2"` |
| [yDpeA65zCe.java:407](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L407) | `actionCallUSSD` | 1. `"58"` |
| [yDpeA65zCe.java:410](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L410) | `actionCallUSSD` | 1. `"58"` |
| [yDpeA65zCe.java:414](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L414) | `actionCallUSSD` | 1. `"58"` |
| [yDpeA65zCe.java:478](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L478) | `actionCallUSSD` | 1. `"73"` |
| [yDpeA65zCe.java:481](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L481) | `actionCallUSSD` | 1. `"73"` |
| [yDpeA65zCe.java:485](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L485) | `actionCallUSSD` | 1. `"73"` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yvWHEB2qa4.java`

Baseline source role/evidence: Operation form confirms and dispatches selector 53 (zpT98w56Knm/yvWHEB2qa4.java).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yvWHEB2qa4.java:54](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yvWHEB2qa4.java#L54) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"53"`<br>3. `cadena`<br>4. `"Desea actualizar su cuenta"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/EyKrF4UJ9B.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [EyKrF4UJ9B.java:166](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/EyKrF4UJ9B.java#L166) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"5"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/GPsckxvkPu.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [GPsckxvkPu.java:207](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/GPsckxvkPu.java#L207) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"106"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/L0JjVr9EwEF.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [L0JjVr9EwEF.java:728](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/L0JjVr9EwEF.java#L728) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"102"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [L0JjVr9EwEF.java:730](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/L0JjVr9EwEF.java#L730) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"102"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/NzOTegfhDk.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [NzOTegfhDk.java:219](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/NzOTegfhDk.java#L219) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"96"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PTsHXOZ1gC.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PTsHXOZ1gC.java:242](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PTsHXOZ1gC.java#L242) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"7"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [PTsHXOZ1gC.java:245](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PTsHXOZ1gC.java#L245) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"122"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [PTsHXOZ1gC.java:250](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PTsHXOZ1gC.java#L250) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"7"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [PTsHXOZ1gC.java:252](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PTsHXOZ1gC.java#L252) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"122"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [PqTzgaEYF6.java:235](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L235) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"59"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [PqTzgaEYF6.java:238](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L238) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"59"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [PqTzgaEYF6.java:260](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L260) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"84"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena2`<br>7. `msg2`<br>8. `group2`<br>9. `getFragmentManager()` |
| [PqTzgaEYF6.java:263](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L263) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"84"`<br>3. `cadena2`<br>4. `msg2`<br>5. `group2`<br>6. `getFragmentManager()` |
| [PqTzgaEYF6.java:284](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L284) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"86"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena3`<br>7. `msg3`<br>8. `group3`<br>9. `getFragmentManager()` |
| [PqTzgaEYF6.java:286](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/PqTzgaEYF6.java#L286) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"86"`<br>3. `cadena3`<br>4. `msg3`<br>5. `group3`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/ROgpLrCtHa.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [ROgpLrCtHa.java:435](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/ROgpLrCtHa.java#L435) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `"¿ Desea realizar el pago del impuesto ? "`<br>5. `group`<br>6. `getFragmentManager()` |
| [ROgpLrCtHa.java:452](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/ROgpLrCtHa.java#L452) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `"¿ Desea realizar el pago del impuesto ? "`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SjZHfPJPwX.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SjZHfPJPwX.java:273](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SjZHfPJPwX.java#L273) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"88"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [SjZHfPJPwX.java:276](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SjZHfPJPwX.java#L276) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"54"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [SjZHfPJPwX.java:281](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SjZHfPJPwX.java#L281) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"88"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [SjZHfPJPwX.java:283](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SjZHfPJPwX.java#L283) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"54"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SlZq2dCM9i.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [SlZq2dCM9i.java:146](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/SlZq2dCM9i.java#L146) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"121"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/TGMSi5UDp7.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [TGMSi5UDp7.java:264](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/TGMSi5UDp7.java#L264) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"43"`<br>3. `cadena`<br>4. `"¿ Desea realizar la compra del sello ? "`<br>5. `group`<br>6. `getFragmentManager()` |
| [TGMSi5UDp7.java:268](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/TGMSi5UDp7.java#L268) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"43"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadenaPack`<br>7. `"¿ Desea realizar la compra del sello ? "`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/U2OwCo4i4Zi.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [U2OwCo4i4Zi.java:231](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/U2OwCo4i4Zi.java#L231) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"77"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/V0zQxQBN2i.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [V0zQxQBN2i.java:139](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/V0zQxQBN2i.java#L139) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"107"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/VqOJe4IEq3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [VqOJe4IEq3.java:85](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/VqOJe4IEq3.java#L85) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"110"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/cLvoxQAY8E.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [cLvoxQAY8E.java:390](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/cLvoxQAY8E.java#L390) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"97"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [cLvoxQAY8E.java:392](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/cLvoxQAY8E.java#L392) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"97"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/d7Bxd6SDJ6.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [d7Bxd6SDJ6.java:186](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/d7Bxd6SDJ6.java#L186) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"7"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [d7Bxd6SDJ6.java:188](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/d7Bxd6SDJ6.java#L188) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"7"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/T8uOynS2ba.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [T8uOynS2ba.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/T8uOynS2ba.java#L61) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"38"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/h97aDnMCap.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [h97aDnMCap.java:132](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/h97aDnMCap.java#L132) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"35"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [h97aDnMCap.java:134](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/h97aDnMCap.java#L134) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"35"`<br>4. `this.agenciaL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/iappKl5Vl3.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [iappKl5Vl3.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/iappKl5Vl3.java#L61) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"36"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/p8fd3aGf9lK.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [p8fd3aGf9lK.java:61](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/p8fd3aGf9lK.java#L61) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"39"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/y4hizMsUIU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [y4hizMsUIU.java:89](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/e45kqwgCv4Ah/y4hizMsUIU.java#L89) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"37"`<br>3. `this.fechaInicio`<br>4. `"¿Desea obtener los últimos cupones de combustible en el rango de fecha especificado?"`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/f96d7C4xhxd.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [f96d7C4xhxd.java:139](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/f96d7C4xhxd.java#L139) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"93"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/hqPCcU1E8u.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [hqPCcU1E8u.java:224](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/hqPCcU1E8u.java#L224) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"77"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [hqPCcU1E8u.java:226](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/hqPCcU1E8u.java#L226) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"77"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/j9EpxD26FF.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [j9EpxD26FF.java:222](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/j9EpxD26FF.java#L222) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"96"`<br>4. `this.agenciaL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [j9EpxD26FF.java:224](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/j9EpxD26FF.java#L224) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"96"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/kq0rlPklFL.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [kq0rlPklFL.java:165](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/kq0rlPklFL.java#L165) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"108"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/n6dAtto0KFy.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [n6dAtto0KFy.java:287](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/n6dAtto0KFy.java#L287) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"6"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/rGY5dubJYU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [rGY5dubJYU.java:214](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/rGY5dubJYU.java#L214) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"105"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/rc7O18ZPOU.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [rc7O18ZPOU.java:396](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/rc7O18ZPOU.java#L396) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"97"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/uKzekWA2jf.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [uKzekWA2jf.java:236](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/uKzekWA2jf.java#L236) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"29"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [uKzekWA2jf.java:239](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/uKzekWA2jf.java#L239) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"29"`<br>4. `"0" + this.banco`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/w1lXYiCfJyk.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [w1lXYiCfJyk.java:127](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/w1lXYiCfJyk.java#L127) | `principalEnviarUSSD` | 1. `this.context`<br>2. `"110"`<br>3. `"93"`<br>4. `this.agencyL`<br>5. `this.MAX_PARAMETERS_PQUETE`<br>6. `cadena`<br>7. `msg`<br>8. `group`<br>9. `getFragmentManager()` |
| [w1lXYiCfJyk.java:129](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/w1lXYiCfJyk.java#L129) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"93"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/yJCgdDviIu.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [yJCgdDviIu.java:198](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/sJ0peDJzVjo/yJCgdDviIu.java#L198) | `actionCallUSSDBack` | 1. `this.context`<br>2. `"59"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/GUihyrFQpq.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [GUihyrFQpq.java:276](../src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/GUihyrFQpq.java#L276) | `actionCallUSSDNoBackSimple` | 1. `this.context`<br>2. `"38"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [GUihyrFQpq.java:284](../src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/GUihyrFQpq.java#L284) | `actionCallUSSDNoBackSimple` | 1. `this.context`<br>2. `"39"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/j1jiweJ8ci.java`

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [j1jiweJ8ci.java:333](../src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/j1jiweJ8ci.java#L333) | `actionCallUSSDNoBackSimple` | 1. `this.context`<br>2. `"114"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |
| [j1jiweJ8ci.java:341](../src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/j1jiweJ8ci.java#L341) | `actionCallUSSDNoBackSimple` | 1. `this.context`<br>2. `"115"`<br>3. `cadena`<br>4. `msg`<br>5. `group`<br>6. `getFragmentManager()` |

### `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java`

Baseline source role/evidence: App-specific USSD dispatcher: builds dial URIs from AppConfig and transformed payloads; provides confirmation, return/no-return, observer, and navigation variants used by clean forms and operation menus. See [telephony notes](telephony.md#ussd-dispatch-class-fbsqzp3zfj).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [FBsQzP3Zfj.java:818](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L818) | `actionCallUSSDSimple` | 1. `context`<br>2. `"80"`<br>3. `cadena` |
| [FBsQzP3Zfj.java:839](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L839) | `actionCallUSSDSimple` | 1. `context`<br>2. `"80"`<br>3. `cadena` |
| [FBsQzP3Zfj.java:1245](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1245) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222"`<br>5. `"Seleccione"`<br>6. `mensaje`<br>7. `group` |
| [FBsQzP3Zfj.java:1249](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1249) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*111"`<br>5. `"Seleccione"`<br>6. `mensaje2`<br>7. `group` |
| [FBsQzP3Zfj.java:1252](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1252) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*3"`<br>5. `"Confirme"`<br>6. `"¿Desea realizar la consulta?"`<br>7. `group` |
| [FBsQzP3Zfj.java:1256](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1256) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*13"`<br>5. `"Confirme"`<br>6. `mensaje3`<br>7. `group` |
| [FBsQzP3Zfj.java:1260](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1260) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*15"`<br>5. `"Confirme"`<br>6. `mensaje4`<br>7. `group` |
| [FBsQzP3Zfj.java:1264](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1264) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*16"`<br>5. `"Confirme"`<br>6. `mensaje5`<br>7. `group` |
| [FBsQzP3Zfj.java:1268](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1268) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*91"`<br>5. `"Confirme"`<br>6. `mensaje6`<br>7. `group` |
| [FBsQzP3Zfj.java:1278](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1278) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*70"`<br>5. `"Confirme"`<br>6. `mensaje7`<br>7. `group` |
| [FBsQzP3Zfj.java:1281](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1281) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*46"`<br>5. `"Confirme"`<br>6. `"¿Desea consultar el saldo de su tarjeta?"`<br>7. `group` |
| [FBsQzP3Zfj.java:1284](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1284) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*48"`<br>5. `"Confirme"`<br>6. `"¿Desea ver las últimas operaciones realizadas? "`<br>7. `group` |
| [FBsQzP3Zfj.java:1288](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1288) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*70"`<br>5. `"Confirme"`<br>6. `mensaje8`<br>7. `group` |
| [FBsQzP3Zfj.java:1291](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1291) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*68*02"`<br>5. `"Confirme"`<br>6. `"¿Desea eliminar registro asociado a su cuenta y número telefónico?. "`<br>7. `group` |
| [FBsQzP3Zfj.java:1295](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1295) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*70"`<br>5. `"Confirme"`<br>6. `mensaje9`<br>7. `group` |
| [FBsQzP3Zfj.java:1302](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1302) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222*266"`<br>5. `"Confirme"`<br>6. `mensaje10`<br>7. `group` |
| [FBsQzP3Zfj.java:1306](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1306) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*133"`<br>5. `"Confirme"`<br>6. `mensaje11`<br>7. `group` |
| [FBsQzP3Zfj.java:1310](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1310) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222*328"`<br>5. `"Confirme"`<br>6. `mensaje12`<br>7. `group` |
| [FBsQzP3Zfj.java:1314](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1314) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222*869"`<br>5. `"Confirme"`<br>6. `mensaje13`<br>7. `group` |
| [FBsQzP3Zfj.java:1318](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1318) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222*767"`<br>5. `"Confirme"`<br>6. `mensaje14`<br>7. `group` |
| [FBsQzP3Zfj.java:1322](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1322) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*222*264"`<br>5. `"Confirme"`<br>6. `mensaje15`<br>7. `group` |
| [FBsQzP3Zfj.java:1328](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1328) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*62"`<br>5. `"Confirme"`<br>6. `"¿Desea consultar los límites de sus cuentas bancarias?"`<br>7. `group` |
| [FBsQzP3Zfj.java:1334](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1334) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*58"`<br>5. `"Confirme"`<br>6. `"¿Desea consultar el importe de todas sus cuentas?"`<br>7. `group` |
| [FBsQzP3Zfj.java:1340](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1340) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*58"`<br>5. `"Confirme"`<br>6. `"¿Desea consultar el importe de todas sus cuentas?"`<br>7. `group` |
| [FBsQzP3Zfj.java:1344](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1344) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*234*3"`<br>5. `"Confirme"`<br>6. `mensaje16`<br>7. `group` |
| [FBsQzP3Zfj.java:1446](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1446) | `getAlertDialogBuilder` | 1. `context`<br>2. `BuildConfig.FLAVOR`<br>3. `BuildConfig.FLAVOR`<br>4. `"*444*70"`<br>5. `"Confirme"`<br>6. `mensaje17`<br>7. `group` |
| [FBsQzP3Zfj.java:1647](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1647) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [FBsQzP3Zfj.java:1650](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1650) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [FBsQzP3Zfj.java:1654](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1654) | `actionCallUSSD` | 1. `"63"`<br>2. `tipoOperacion` |
| [FBsQzP3Zfj.java:1675](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1675) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [FBsQzP3Zfj.java:1677](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1677) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [FBsQzP3Zfj.java:1679](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1679) | `actionCallUSSD` | 1. `"62"`<br>2. `pos` |
| [FBsQzP3Zfj.java:1702](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1702) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [FBsQzP3Zfj.java:1705](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1705) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [FBsQzP3Zfj.java:1709](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1709) | `actionCallUSSD` | 1. `operacion`<br>2. `pos` |
| [FBsQzP3Zfj.java:1726](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1726) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [FBsQzP3Zfj.java:1729](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1729) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [FBsQzP3Zfj.java:1732](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1732) | `actionCallUSSD` | 1. `operacion`<br>2. `"00*" + pos` |
| [FBsQzP3Zfj.java:1989](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1989) | `actionCallUSSD` | 1. `"73"` |
| [FBsQzP3Zfj.java:1992](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1992) | `actionCallUSSD` | 1. `"73"` |
| [FBsQzP3Zfj.java:1996](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1996) | `actionCallUSSD` | 1. `"73"` |
| [FBsQzP3Zfj.java:2049](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2049) | `actionCallUSSD` | 1. `"58"` |
| [FBsQzP3Zfj.java:2052](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2052) | `actionCallUSSD` | 1. `"58"` |
| [FBsQzP3Zfj.java:2056](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2056) | `actionCallUSSD` | 1. `"58"` |
| [FBsQzP3Zfj.java:2077](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2077) | `actionCallUSSD` | 1. `"72"` |
| [FBsQzP3Zfj.java:2080](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2080) | `actionCallUSSD` | 1. `"72"` |
| [FBsQzP3Zfj.java:2084](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2084) | `actionCallUSSD` | 1. `"72"` |
| [FBsQzP3Zfj.java:2197](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2197) | `actionCallUSSD` | 1. `"85"` |
| [FBsQzP3Zfj.java:2200](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2200) | `actionCallUSSD` | 1. `"85"` |
| [FBsQzP3Zfj.java:2204](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2204) | `actionCallUSSD` | 1. `"85"` |
| [FBsQzP3Zfj.java:2257](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2257) | `actionCallUSSD` | 1. `"46"` |
| [FBsQzP3Zfj.java:2259](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2259) | `actionCallUSSD` | 1. `"46"` |
| [FBsQzP3Zfj.java:2289](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2289) | `actionCallUSSD` | 1. `"48"`<br>2. `pos` |
| [FBsQzP3Zfj.java:2291](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2291) | `actionCallUSSD` | 1. `"48"`<br>2. `pos` |
| [FBsQzP3Zfj.java:2530](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2530) | `actionCallUSSD` | 1. `"117"` |
| [FBsQzP3Zfj.java:2532](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L2532) | `actionCallUSSD` | 1. `"117"` |

### `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/MX9gh9mLxd.java`

Baseline source role/evidence: App-specific Android 8+ multi-USSD sender using `TelephonyManager.sendUssdRequest`; sequences packets from response callbacks, requires `CALL_PHONE`, recognizes the source response substring, and reports progress/failure through its listener.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [MX9gh9mLxd.java:99](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/MX9gh9mLxd.java#L99) | `sendUssdRequest` | 1. `ussdCode`<br>2. `callback`<br>3. `new Handler()` |

### `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java`

Baseline source role/evidence: Platform-switch facade between `WV9lIl58Oa` (API 26+) and `H5bNyNZfB5K` (older APIs); exposes paired-request methods but has no source callers in the tracked tree.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [T7hdFVrmeS5.java:24](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java#L24) | `sendUssdRequest` | 1. `ussdCode`<br>2. `nextUssdCode` |
| [T7hdFVrmeS5.java:31](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java#L31) | `sendUssdRequest` | 1. `ussdCode`<br>2. `nextUssdCode` |

### `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/WV9lIl58Oa.java`

Baseline source role/evidence: App-specific optional two-request `TelephonyManager` helper: sends a second USSD request after any success response, logs platform failures without notifying its caller, and silently returns without dispatch when API/permission gates fail; used by `T7hdFVrmeS5`.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [WV9lIl58Oa.java:44](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/WV9lIl58Oa.java#L44) | `sendUssdRequest` | 1. `ussdCode`<br>2. `callback`<br>3. `new Handler()` |
| [WV9lIl58Oa.java:55](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/WV9lIl58Oa.java#L55) | `sendUssdRequest` | 1. `this.nextUssdCode`<br>2. `null` |

### `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java`

Baseline source role/evidence: Partial-USSD coordinator: packs transformed payloads, chooses modern TelephonyCallback or pre-Android-8 accessibility sending, manages confirmation/progress/manual packet dialogs and response advancement. Detailed flow and limits are in [telephony notes](telephony.md#ussd-packet-protocol-pazq93vil3).

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [pAzq93vIl3.java:127](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L127) | `sendUssdRequests` | 1. `this.cadenaList` |
| [pAzq93vIl3.java:131](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L131) | `actionCallUSSDBack` | 1. `context`<br>2. `codeOper`<br>3. `secuencia`<br>4. `mensajeDialog`<br>5. `group`<br>6. `fragmentManager` |
| [pAzq93vIl3.java:172](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L172) | `sendUssdRequests` | 1. `this.cadenaList` |
| [pAzq93vIl3.java:233](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L233) | `sendDataUSSD` | 1. `0` |
| [pAzq93vIl3.java:245](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L245) | `sendDataUSSD` | 1. `this.posicion` |
| [pAzq93vIl3.java:263](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L263) | `sendDataUSSD` | 1. `data.data.noPaquete` |

### `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/UoWmGAF016.java`

Baseline source role/evidence: Configuration menu; source routes entries to app update, activation, account management, backup/restore, and settings fragments.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [UoWmGAF016.java:65](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/UoWmGAF016.java#L65) | `actionCallUSSD` | 1. `"116"` |
| [UoWmGAF016.java:67](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/UoWmGAF016.java#L67) | `actionCallUSSD` | 1. `"116"` |

### `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/W2FmEAMdovs.java`

Baseline source role/evidence: Agent-version activation; validates activation code against app version/phone, stores agent code, enables ETECSA operations, and requests USSD authorization.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [W2FmEAMdovs.java:196](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/W2FmEAMdovs.java#L196) | `actionCallUSSDSoloSolHabilitarCodigo` | 1. `"80"`<br>2. `codigo`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/b3vEPrhNHF.java`

Baseline source role/evidence: MiBoleto seller activation; validates activation code and enables the MiBoleto module in app configuration.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [b3vEPrhNHF.java:202](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/b3vEPrhNHF.java#L202) | `actionCallUSSDSoloSolHabilitarCodigo` | 1. `"123"`<br>2. `codigo`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/eD2GCZ4Vix.java`

Baseline source role/evidence: Bank-module activation; validates code, enables bank operations and stores bank activation settings.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [eD2GCZ4Vix.java:218](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/eD2GCZ4Vix.java#L218) | `actionCallUSSDSoloSolHabilitarCodigo` | 1. `"80"`<br>2. `codigo`<br>3. `msg`<br>4. `group` |

### `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/xtUiphIcBa.java`

Baseline source role/evidence: Bulevar bank-module activation; validates code and requests authorization through the USSD dispatcher.

| Source line | Method | Ordered argument expressions |
| --- | --- | --- |
| [xtUiphIcBa.java:181](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/xtUiphIcBa.java#L181) | `actionCallUSSDSoloSolHabilitarCodigo` | 1. `"80"`<br>2. `codigo`<br>3. `msg`<br>4. `group` |

## URI construction and platform-send audit

| Source | Original expression |
| --- | --- |
| [GMFMyKMnO2.java:68](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/AjGJz9tVLXv/GMFMyKMnO2.java#L68) | `String cadena = "tel:";` |
| [GMFMyKMnO2.java:71](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/AjGJz9tVLXv/GMFMyKMnO2.java#L71) | `cadena = "tel:" + this.inputMovil.getText().toString().trim();` |
| [GMFMyKMnO2.java:74](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/AjGJz9tVLXv/GMFMyKMnO2.java#L74) | `cadena = "tel:*99" + this.inputMovil.getText().toString().trim();` |
| [FNRzUmC7E5.java:105](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/FNRzUmC7E5.java#L105) | `Uri number = Uri.parse(Uri.parse("tel:*222") + Uri.encode("#"));` |
| [FNRzUmC7E5.java:127](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/FNRzUmC7E5.java#L127) | `Uri number = Uri.parse(Uri.parse("tel:*111") + Uri.encode("#"));` |
| [LALCrDPvhM.java:157](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L157) | `cadena = "tel:*" + source + "*" + operacion + Uri.encode("#");` |
| [LALCrDPvhM.java:159](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java#L159) | `cadena = "tel:*" + source + Uri.encode("#");` |
| [s9lZwtvq9Dl.java:35](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java#L35) | `ambulanciaIntent.setData(Uri.parse("tel:104"));` |
| [s9lZwtvq9Dl.java:40](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java#L40) | `bomberos.setData(Uri.parse("tel:105"));` |
| [s9lZwtvq9Dl.java:45](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java#L45) | `pnr.setData(Uri.parse("tel:106"));` |
| [s9lZwtvq9Dl.java:50](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java#L50) | `salv.setData(Uri.parse("tel:107"));` |
| [s9lZwtvq9Dl.java:55](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java#L55) | `drugs.setData(Uri.parse("tel:103"));` |
| [bnsLemXoui.java:252](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/bnsLemXoui.java#L252) | `String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [SqtuHONWS9.java:450](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SqtuHONWS9.java#L450) | `String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [RC71RyOpsk.java:315](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/RC71RyOpsk.java#L315) | `String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [yDpeA65zCe.java:450](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java#L450) | `String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [IHVTCBmiLV.java:871](../src/cu/etecsa/cubacel/tr/tm/IHVTCBmiLV.java#L871) | `String cadena = "tel:*" + app.getCodigo() + "*100*" + app.getNumber() + Uri.encode("#");` |
| [IHVTCBmiLV.java:882](../src/cu/etecsa/cubacel/tr/tm/IHVTCBmiLV.java#L882) | `String cadena2 = "tel:*" + appConfigList.get(0).getCodigo() + "*100*" + appConfigList.get(0).getNumber() + Uri.encode("#");` |
| [S9ycHcoxAzy.java:760](../src/cu/etecsa/cubacel/tr/tm/S9ycHcoxAzy.java#L760) | `String cadena = "tel:*" + app.getCodigo() + "*100*" + app.getNumber() + Uri.encode("#");` |
| [S9ycHcoxAzy.java:771](../src/cu/etecsa/cubacel/tr/tm/S9ycHcoxAzy.java#L771) | `String cadena2 = "tel:*" + appConfigList.get(0).getCodigo() + "*100*" + appConfigList.get(0).getNumber() + Uri.encode("#");` |
| [FBsQzP3Zfj.java:107](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L107) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:121](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L121) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:156](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L156) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:197](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L197) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:238](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L238) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:281](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L281) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:322](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L322) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:364](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L364) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:400](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L400) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:440](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L440) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:478](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L478) | `String cadena = "tel:*" + codeAcceso + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:514](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L514) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:558](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L558) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:1516](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1516) | `String cadena = "tel:" + codeToSend + Uri.encode("#");` |
| [FBsQzP3Zfj.java:1526](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1526) | `cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [FBsQzP3Zfj.java:1570](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1570) | `String cadena2 = "tel:*" + CodigoAcFinal + "*46*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [FBsQzP3Zfj.java:1800](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java#L1800) | `String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");` |
| [MX9gh9mLxd.java:99](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/MX9gh9mLxd.java#L99) | `this.telephonyManager.sendUssdRequest(ussdCode, callback, new Handler());` |
| [T7hdFVrmeS5.java:24](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java#L24) | `this.ussdHelper.sendUssdRequest(ussdCode, nextUssdCode);` |
| [T7hdFVrmeS5.java:31](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java#L31) | `this.ussdHelper.sendUssdRequest(ussdCode, nextUssdCode);` |
| [WV9lIl58Oa.java:44](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/WV9lIl58Oa.java#L44) | `this.telephonyManager.sendUssdRequest(ussdCode, callback, new Handler());` |
| [pAzq93vIl3.java:269](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java#L269) | `String ussdUri = "tel:" + ussdCode;` |
| [rDEl7rW1aN.java:637](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L637) | `String cadena = "tel:*" + codeAcc + "*" + codeService + "*" + codeToSend + Uri.encode("#");` |
| [rDEl7rW1aN.java:657](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L657) | `String cadena = "tel:*" + codeToSend + Uri.encode("#");` |
| [rDEl7rW1aN.java:686](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L686) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + Uri.encode("#");` |
| [rDEl7rW1aN.java:708](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L708) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [rDEl7rW1aN.java:730](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L730) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [rDEl7rW1aN.java:766](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L766) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [rDEl7rW1aN.java:798](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java#L798) | `String cadena = "tel:*" + codeAccess + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");` |
| [W2FmEAMdovs.java:209](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/W2FmEAMdovs.java#L209) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + Uri.encode("#");` |
| [b3vEPrhNHF.java:215](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/b3vEPrhNHF.java#L215) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + Uri.encode("#");` |
| [eD2GCZ4Vix.java:231](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/eD2GCZ4Vix.java#L231) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + Uri.encode("#");` |
| [xtUiphIcBa.java:194](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/xtUiphIcBa.java#L194) | `String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + Uri.encode("#");` |
