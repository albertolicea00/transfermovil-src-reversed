# MiTransfer Cubacel package purchase

The `BOLSAPaquetesCubacel` menu now opens `CubacelPackagePurchaseFragment`, migrated from raw JADX class `WyYHxgzYyW`. The same source screen supports CUP and USD wallet choices, contact selection, and a locally cached package catalog.

## Package catalog

The form reads `AppConfig.comprapaquetes`. Values `0` and `1` load package records from the bundled JSON through `V9s8rJIDplX`, delete the old `CompraPlanesCubacel` rows, insert the loaded records, and update the configuration version from the first package's `version_ussd`. Other values load the catalog from the local database. A reload action invokes `HPuMiTypoW` and schedules UI refresh after ten seconds; the source does not wait on a completion callback before showing “Actualización completada”.

Each selected package contributes its ID and `version_ussd`. The form validates a nonempty mobile/account field of length 8 or 10, a wallet selection, and a package selection. It sends `<mobile>*<package-id>*<version-ussd>*<currency-enum>*<wallet-type>` through selector `6`. Wallet type `1` maps to USD and `2` to CUP. The confirmation wording differs by wallet: USD says to buy a package, while CUP names the selected package.

`nuevoDatos()` is empty, so this form has no local phone persistence. The manager's network/update behavior and successful package purchase have not been runtime-verified; the ten-second UI delay is source-visible but does not prove the background refresh completed.
