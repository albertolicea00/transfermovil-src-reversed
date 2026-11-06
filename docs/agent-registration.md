# Agent registration and activation code

This note follows the client-side flow in `W2FmEAMdovs`, the SMS parser `g0xM9kQCsqu`, `rDEl7rW1aN`, and the `AgentService` DAO. It describes local validation and persistence; it does not establish whether the remote service accepts a request.

## Requesting an activation code

The activation screen requests an agent code with selector `80` and payload `1*<app-version>`. The client builds `tel:*<access-code>*80*1*<version>#`, asks the user to confirm, then starts `ACTION_CALL`. After confirmation it records the local agent code as `-1`, hides the request button, and tells the user to enter the activation code returned by the service.

The screen can use the phone and version parsed from `PAGOxMOVIL` inbox messages. `HzjedYqYeh.readSmsInbox()` queries the SMS inbox with address `PAGOxMOVIL`; it does not request a sort order. The parser recognizes accented and unaccented activation-message prefixes, takes the phone from whitespace token 6, and for messages containing `para agentes` takes the agent code from token 14. `sms_code_agente()` scans returned rows and returns the first non-empty parsed code. Therefore the source does not prove that the selected SMS is the newest or validate an originating sender beyond the inbox address filter.

## Local validation and storage

`W2FmEAMdovs.habilitar_version_agente()` requires a non-empty entered code, obtains phone/version values, then calls `hY5P1xQ5h8.check_code_activation(code, version, phone)`. The validator uses the first code character as a digit `r`, normalizes the phone (8 digits unchanged, 10 digits drop the first two, 7 digits gain a leading `5`; a leading `+` is stripped), rotates the normalized phone left by `r`, prefixes the version with `r`, and computes eight absolute per-position digit differences. The expected string is `r` followed by those eight differences; validation is `entered-code.contains(expected-string)`.

On a local match, the screen stores the entered code and phone through `Fr52O1uSYF` in the ORMLite `AgentService` table, enables ETECSA operations, and presents a restart notice. `AgentService` has `code`, `phone`, and generated `id` fields. The storage helper updates the first row or inserts a row when none exists. `rDEl7rW1aN.getCodeAgent()` returns that first row, or `null` if the table is empty; callers use the code to distinguish an inactive `-1` state from an activated agent.

## Agent menu routes observed

The source menu `g1bQ0lLj6na` exposes authentication, stock balance, mobile recharge, latest recharges, PIN change, and disconnect. Confirmed direct selectors include `11*2` for stock balance, `11*4` for all latest recharges, and `11*6` for disconnect. The “by mobile” latest-recharges choice opens `yzFfgPWLpL`. The mobile-recharge form `A9IFPpW4HW` requires an eight-character number and a non-empty amount, stores a previously unseen number in `TeflMovil`, refreshes the drawer, then sends selector `12` with `<phone>*<amount>`. Authentication uses selector `11` with `1*<four-digit-PIN>`.

The PIN-change form `VqNI4JnvJD` sends selector `11` with payload `3*<new-PIN>*3*<new-PIN>` after confirmation; it checks the new and repeated PIN values match. Its repeated-PIN length condition mistakenly checks the new-PIN field a second time. Since the following equality check compares the raw strings, this misplaced check does not by itself let a differently sized confirmation pass; it is still an apparent validation-code defect worth correcting only with intended product behavior confirmed. Length checks trim whitespace, while equality does not. The general drawer’s `nljtDl5MIf.listGenerales` is a separate carrier-services menu and remains under review.

## Raw source references

- [`W2FmEAMdovs.java`](../src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/W2FmEAMdovs.java): request, SMS auto-fill, local validation, activation and persistence.
- [`g0xM9kQCsqu.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/g0xM9kQCsqu.java): activation SMS token parsing.
- [`rDEl7rW1aN.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java): SMS retrieval helper and first-row `getCodeAgent()`.
- [`hY5P1xQ5h8.java`](../src/cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/hY5P1xQ5h8.java): activation-code algorithm.
- [`AgentService.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/MZUDJuUoMJL/AgentService.java) and [`Fr52O1uSYF.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/Fr52O1uSYF.java): persistence.
- [`g1bQ0lLj6na.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java), [`A9IFPpW4HW.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/A9IFPpW4HW.java), and [`VqNI4JnvJD.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/VqNI4JnvJD.java): Agent drawer routes, mobile recharge, and PIN change.
