# Agent operation statistics

The statistics pages are built from locally stored `RecordSMS` rows parsed from `PAGOxMOVIL` messages. They do not query a live Agent API in the traced UI path.

## Navigation

Both `S9ycHcoxAzy` and `IHVTCBmiLV` expose the statistics drawer group. In the legacy activity, `resumidas` opens `mYaQ7jnA3Y` with `newEstaditica=1`; `detalladas` opens `LxRjrwTADB`. The newer activity opens `postcP0gVS` for detailed statistics. The summary adapter receives the current month and year.

## Summary view

`mYaQ7jnA3Y` creates `ByJot7nE5d`. Its initial data loader iterates every `KYTjPlWScT` module, finds the latest stored record date for that module, and fetches that month/year's records. `Agentes` is one of the module values. The view binds monthly operation data to pie charts centered on “Cantidad” and “Importe”; its legends split operations by service and currency. Selecting a module/month and CUP or USD updates the chart data from that module's records.

There is a likely control-flow defect in the JADX body of `ByJot7nE5d.cargarDatos()`: for a non-empty record list it enters `while (isOkOperationForEntity)`, calls `iterator.next()` without checking `hasNext()`, and only sets the flag false inside a catch that begins after `next()`. The final `next()` can therefore throw out to the constructor's outer catch and interrupt initial summary population. This is a static source observation; runtime behavior has not been tested.

The DAO also exposes `getResumenRecordLists()`, which groups all `recordsms` rows by service and currency and returns sum/count. A tracked-source call-site search found the method definition but no caller, so it is not evidence of the summary page's data source.

## Detailed view

`LxRjrwTADB` and `postcP0gVS` provide five module tabs: Agents, BPA, BANDEC, Metropolitano, and MiTransfer. Each tab passes its `KYTjPlWScT` module to `D1rOcltDGsD`. The detail fragment loads either all records for that module, a selected month/year, or a month/year filtered further by service and currency. Its search filters the loaded rows by service name, account, currency, or transaction ID.

Rows display service, account, date, amount, currency, and transaction ID. When a transfer account is not already masked with `X`, the detail fragment masks its middle six digits and writes the masked account back to the matching `RecordSMS` row. Thus opening the detailed view can mutate locally stored display data.

## Source references

- [`S9ycHcoxAzy.java`](../src/cu/etecsa/cubacel/tr/tm/S9ycHcoxAzy.java) and [`IHVTCBmiLV.java`](../src/cu/etecsa/cubacel/tr/tm/IHVTCBmiLV.java): drawer routing and statistics visibility.
- [`mYaQ7jnA3Y.java`](../src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/mYaQ7jnA3Y.java), [`ByJot7nE5d.java`](../src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/ByJot7nE5d.java): monthly summary and charts.
- [`LxRjrwTADB.java`](../src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/LxRjrwTADB.java), [`postcP0gVS.java`](../src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/postcP0gVS.java), [`D1rOcltDGsD.java`](../src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/D1rOcltDGsD.java): module tabs and detailed records.
- [`unYp8VQThY.java`](../src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/unYp8VQThY.java): record queries, date filters, and summary aggregate helper.
- [`g0xM9kQCsqu.java`](../src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/g0xM9kQCsqu.java): SMS-to-`RecordSMS` parsing.
