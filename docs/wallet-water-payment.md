# MiTransfer water payment

The clean [`WalletWaterPaymentFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/WalletWaterPaymentFragment.java) reconstructs `U1sIOmca96i` on the shared clean `BfiUssdAccountFragment` base. The `BOLSAAgua` menu entry routes to it.

The form loads saved water-account invoice values (`Factura`, type `2`), supports region selection for Aguas de La Habana or Aguas de Varadero, and selects a payment type. Payload order is `<region>*<invoice>*<amount>*<payment-type>*0000*2`. Havana uses selector `19`; Varadero uses selector `21`. Both routes support ordinary USSD and partial gateway `110` with agency marker `04` and four parameters. A newly entered invoice is saved locally and the host operation menu is refreshed.

Source-visible quirks are retained and should be reviewed before changing behavior: the region listener loads the same `array_agua_tipo_pago` for both regions even though a separate Varadero array exists; amount validation is only invoked for one region/type combination, and parse failure resets amount to zero but returns success. The form sends `0000` in the fifth payload field regardless of saved account state.

## Sources

- [`U1sIOmca96i.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/U1sIOmca96i.java): raw form, selectors, and validation.
- [`Agg55uYctq.java`](../src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/Agg55uYctq.java): original shared base.
- [`WalletWaterPaymentFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/wallet/WalletWaterPaymentFragment.java) and [`BfiUssdAccountFragment.java`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/bfi/BfiUssdAccountFragment.java): clean reconstruction and shared base.
