# MiTransfer OFA reservation

The `BOLSAReservasOFA` menu entry now opens `OfaReservationFragment`, migrated from raw JADX class `dWLcK5oQoS`. The previous clean stub was named `CadecaExchangeFragment`, but the source uses `ReservasOFA` data, city-patrimony selections, and a Ciudades Patrimoniales terms URL.

The form requires a city, client type, reservation, nonempty CI, date, positive quantity, and wallet selection. Optional confirmation phone must be exactly 8 characters when supplied. The source forces wallet marker `2` and hour `0`; a checkbox controls `enviarSaldo`. Total amount is computed as unit price times quantity.

Selector `8` receives the ordered payload `<CI>*<reservation-code>*<client-type>*<quantity>*<date>*0*<total>*<currency>*<confirmation-phone-or-0>*<send-balance-flag>*2`. Regular mode uses `actionCallUSSDBackHttp` and makes the terms URL clickable in the confirmation; partial mode uses gateway `110`, selector `8`, agency `04`, and max 4 parameters.

Validation is source-visible but limited: CI and date are only checked for nonempty values; quantity is parsed as float and must be positive, with no local exception guard around that parse; confirmation phone length is checked without validating digits or prefix. The exact source migration, menu route, and request are documented; live reservations remain unverified.
