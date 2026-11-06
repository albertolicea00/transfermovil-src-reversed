# MiTransfer Pago en Línea QR

The `BOLSAPagoLinea` menu entry now opens `QrDynamicPaymentFragment`, migrated from raw source `s9CT6pjRyD` with source type `xf94v3SFEM` and agency `MiTransfer`. The route also resets the shared QR payment currency and data fields before opening the form.

The screen inherits shared QR, bank-account, and account-selection behavior from `LgiFGRpiEl`/`Agg55uYctq`. It validates PIN, account, QR-dependent amount, wallet, and currency; an origin account is required when transfer selection is enabled. The scanned/provider data determines the QR provider, auxiliary values, QR ID, and currency.

The static QR branch uses selector `31` and a payload beginning `<agency>*<PIN>*<account>*<amount>*<currency-id>*<wallet-type>*<provider>*<aux>...`; it can include description, optional confirmation mobile, QR ID, and selected origin account. Dynamic QR generally uses selector `30` and similar bank/account/currency/provider fields. Provider auxiliary data containing `11200301` selects `actionCallUSSDNOBack`; the other dynamic branch uses regular selector `30` dispatch or partial gateway `110` with the agency marker.

The route now passes the same `Nl0yptXmjQ.xf94v3SFEM` and `R1sDOSqZ2z.MiTransfer` arguments as the original menu. Field ordering varies across static, dynamic, no-back, and optional-field branches, so the exact payload builders remain in the migrated source. Runtime QR and payment behavior have not been verified.
