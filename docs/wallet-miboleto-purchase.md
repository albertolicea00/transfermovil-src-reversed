# MiTransfer MiBoleto purchase

The `BOLSACompraMiBoleto` option now resets shared booking values and opens `MiBoletoPurchaseFragment`, migrated from raw class `TBaFnBLjEA`. It loads an offer, CI, date, quantity, total, currency, and optional confirmation phone.

Selector `118` receives `<offer-id>*<CI>*<quantity>*<start-date>*<total>*<currency-id>*<confirmation-phone>*<wallet-type>`. USD maps to currency `1` and wallet `1`; the other currency branch maps to `2`/`2`. The regular handler uses `actionCallUSSDBackHttp` with a clickable MiBoleto information link; partial USSD uses gateway `110`, selector `118`, agency `04`, maximum 4 parameters.

The menu clears the shared MiBoleto CI/date/quantity/amount/phone/currency holder before opening the screen, matching source. Runtime offer purchase is unverified.
