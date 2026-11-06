# MiTransfer ticket reservations

`BOLSAReservasTicket` now resets the shared ticket form state before showing a three-option dialog, then opens the source-matched screen: create (`XnVSHGPTkK`), cancel (`QVPgkl8ZGC`), or change date (`Wwc5crW71D`). The previous clean “query” label for `Wwc5crW71D` was inaccurate; its payload includes a start date and its menu text is the date-change option.

| Action | Selector | Payload |
| --- | ---: | --- |
| Create reservation | `102` | `<agency-id>*<entity-id>*<branch-DPA>*<CI>*<confirmation-phone>*<wallet-type>` |
| Cancel reservation | `106` | `<agency-id>*<service-type>*<CI>` |
| Change reservation date | `105` | `<agency-id>*<service-type>*<CI>*<start-date>` |

The three handlers use the standard USSD dispatcher; no partial-USSD path appears in the inspected methods. Creation also exposes QR and link actions. Before opening the dialog, the menu clears global currency, entity, province, branch, service, auxiliary data, send-balance, selected-account label, and account values, matching the source reset in `rR6oImkdEU`.

The migrations are package/class renames of the raw screens and the menu now executes the selected route. Runtime reservation behavior has not been tested against a live service.
