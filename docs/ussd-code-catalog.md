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
