# MiTransfer MiBoleto purchase

The `BOLSACompraMiBoleto` option now resets shared booking values and opens `MiBoletoPurchaseFragment`, migrated from raw class `TBaFnBLjEA`. It loads an offer, CI, date, quantity, total, currency, and optional confirmation phone.

Selector `118` receives `<offer-id>*<CI>*<quantity>*<start-date>*<total>*<currency-id>*<confirmation-phone>*<wallet-type>`. USD maps to currency `1` and wallet `1`; the other currency branch maps to `2`/`2`. The regular handler uses `actionCallUSSDBackHttp` with a clickable MiBoleto information link; partial USSD uses gateway `110`, selector `118`, agency `04`, maximum 4 parameters.

The menu clears the shared MiBoleto CI/date/quantity/amount/phone/currency holder before opening the screen, matching source. Runtime offer purchase is unverified.

## Saved ticket management review

`MiBoletoListFragment` links to `c69cvBqjXKw.x5ijzOU4VE`, and
`MiBoletoEditFragment` links to `c69cvBqjXKw.j1jiweJ8ci`. The list's
`onItemClicked()` now opens the clean editor and passes the selected purchase's
local database ID as the string argument `id`, preserving the source navigation
contract. The source editor loads that purchase, edits its alias, displays its
additional details, and generates a QR from its stored token.

Three copied JADX listeners referred to a nonexistent captured field `this.f$0`:
QR-detail confirmation in the list, QR-image click in the editor, and QR-detail
confirmation in the editor. They now call the corresponding enclosing fragment
methods. Their selection checks and QR generation bodies remain source-derived:
no selection shows the existing message; a selected detail is the sole detail
included in the QR; the editor displays the generated image and its dialog.

The editor's status and key-update actions retain selectors `114` and `115`,
respectively, using `String.valueOf(ticket.getIdOferta())` and the original
`FBsQzP3Zfj.actionCallUSSDNoBackSimple()` confirmation/dispatch overload. These
screens still depend on raw ticket database models, list adapters, cryptography,
QR generation, and dispatcher helpers. This bounded navigation/listener repair
does not complete clean model/dispatcher migration or establish an Android build
or runtime result. Validation compares the edited navigation and QR/selector
method bodies with the annotated JADX sources after identity/receiver
normalization.
