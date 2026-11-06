# MiTransfer OFA contribution

The `BOLSAAporteOFA` menu entry now opens `OfaContributionFragment`, migrated from `C6ZYln3x19W`. The screen loads OFA obligation definitions from bundled data through `V9s8rJIDplX`, uses the shared parent form to load taxpayer/contributor fields, and offers a month picker and CUP wallet.

It requires an obligation, CI, contributor, code, selected period, amount, and wallet. The amount must parse as a float; the inspected validator does not enforce a positive minimum. The period must have both display text and a stored date value.

Selector `94` receives `<CI>*<contributor>*<code>*<period>*<amount>*<obligation-code>*2`. Regular dispatch uses `FBsQzP3Zfj.actionCallUSSDBack`; partial dispatch uses gateway `110`, selector `94`, agency `04`, maximum 4 parameters. The source migration preserves the parent `qHxc7HcCDX` behavior used by the child screen. Runtime menu and server behavior remain unverified.
