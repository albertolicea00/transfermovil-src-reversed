# MiTransfer Nauta recharge

## Source and route

The General MiTransfer menu routes `BOLSARecargaNauta` to [`NautaUserFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/NautaUserFragment.java), reconstructed from the raw JADX class `KtF0PRB8vS`. Their bodies are identical after normalizing the package and class name. Both dynamic menu definitions now point to the clean class. This is the general Wallet menu form; the bank-specific `WalletNautaRechargeFragment` (`PqTzgaEYF6`) is a separate flow and uses bank agency markers.

The screen accepts a Nauta account, account type, amount, optional recipient mobile, and a bolsa choice. The account-type labels are “Navegación Internacional” (`1`, `@nauta.com.cu`) and “Navegación Nacional” (`2`, `@nauta.co.cu`). It also has Nauta Hogar switches for a home-internet top-up and for paying outstanding debt.

The first Nauta Hogar switch reveals the debt-payment switch and clears its checked state whenever the first switch changes. With Nauta Hogar enabled, the second switch selects between selector `84` (top-up) and selector `86` (outstanding-debt payment); with it disabled, the form uses regular selector `59`. Thus the second switch cannot remain selected when the user leaves Nauta Hogar mode.

All three branches share the same field validation: username is required, may not contain spaces or `@`, and is limited to 20 characters; account type is required; amount must parse as a float and be at least 1; optional recipient mobile must be eight digits beginning with `5` or `6`; and the bolsa choice is required. The source does not show a Nauta Hogar-specific validation branch.

## USSD requests

| Operation | Selector | Payload suffix | Partial gateway |
| --- | ---: | --- | --- |
| Regular Nauta top-up | `59` | `*1` | `110`, selector `59`, agency `04`, maximum 4 parameters |
| Nauta Hogar top-up | `84` | `*2` | `110`, selector `84`, agency `04`, maximum 4 parameters |
| Nauta Hogar debt payment | `86` | `*3` | `110`, selector `86`, agency `04`, maximum 4 parameters |

Each payload starts with `<account>*<account-type>*<amount>*0*<mobile>*<bolsa>`. The no-mobile default is `0000000`; the account type is selected as `1` or `2`. The regular USSD dispatcher receives the corresponding selector directly. All three partial-USSD branches use the same gateway, agency, and parameter limit.

When partial USSD is enabled, `processString` inserts a `*` at the midpoint of accounts longer than ten characters before building the payload. The raw method calls `toLowerCase()` without assigning its result, so it does not actually lowercase the stored account. The error guard checks whether the account contains `ERROR`; these source quirks are preserved in the reconstruction.

## Scope

The clean fragment is a package/class-renamed migration of the JADX class, and the General MiTransfer menu now opens it. The behavior is source-backed; runtime navigation and USSD execution have not been tested on-device.
