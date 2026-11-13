# Banking differences by bank

This comparison summarizes only behaviors traced to form builders and menu dispatches in the current JADX reconstruction. It is not a complete feature matrix for each bank. USSD payload values shown below are transformed by the shared `rDEl7rW1aN.code()` path where the form calls it; the catalog records the corresponding dial templates.

| Bank | Confirmed distinctions | Source-backed examples |
| --- | --- | --- |
| BPA | Account registration carries agency marker `01`, full name plus both surnames, and identity number. Account queries use currency then account; latest operations additionally prepend service type. The short transfer form sends destination, amount, currency, and optional recipient phone. A separate extended form supports saved/new origin accounts, CUP/CUC/USD checks, optional agency/PIN prefix, recipient phone, message, and send-phone/balance flags. The active Operations tab is reconstructed as a clean menu and routes selector-45 transfer to the extended form. | `IixhA1yamp.submitForm`; `BpaBalanceQueryFragment.submitForm`; `BpaLastOperationsFragment.submitForm`; `BpaTransferFragment.submitForm`; clean [`BpaOperationsTabFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/bpa/BpaOperationsTabFragment.java) and [`BpaExtendedTransferFragment`](../app/src/main/java/cu/etecsa/transfermovil/banking/ui/bpa/BpaExtendedTransferFragment.java) from `voNSkP3P8q` and `iN1lHDKE5h` |
| BANDEC | Registration carries marker `02` and uses account, name, and identity fields without the two surname fields present in the BPA and Metro forms. A BANDEC-labeled PIN-change form requires five digits, unlike the observed four-digit forms. Account-limit query sends currency plus origin account (selector `62`); latest operations sends service type, currency, and origin account (selector `48`); payment-status query sends reference and origin account (selector `89`). The three query forms now share a clean account-selection base that preserves BANDEC's own currency options and hides the bank-account switch. | `wLHKkaC4Ha.submitForm`; clean [`BandecRegistrationFragment`](../app/src/main/java/cu/etecsa/transfermovil/ui/fragment/banking/bandec/auth/BandecRegistrationFragment.java); `Cmok7CcIR9.submitForm`; `ikSs6fqL5Q.submitForm`; `gaJlF6dT3z.submitForm`; `XKpe29TPn0.submitForm`; `DQIrxODoMU.initComponentesCuentas` |
| Metropolitano | Registration carries marker `03` and includes both surnames. Its traced screens include account-limit queries, service-type operation queries, gas/water payments, temporary-limit changes, payment-priority changes, card reprint, and transfers. The account-limit partial packet uses marker `03`; other operations can use different markers, so the marker is operation-specific. | `RFBEnXW0Xr.submitForm`; `gkzzwVYksz.submitForm`; `MetroBalanceQueryFragment.submitForm`; `MetroGasPaymentFragment.submitForm`; `MetroServiceQueryFragment.submitForm`; `MetroModificarLimitesFragment.submitForm`; `MetroReimprimirTarjetaFragment.submitForm` |
| BFI | Registration uses marker `05` and requires current PIN, new PIN, and identity. Account query forms commonly send currency then account; the restored operations include balance, latest operations, limits, payment priority, and account statement. The account statement payload orders email, start date, end date, and account. | `umjSGajOy3.submitForm`; `BfiConsultarSaldoFragment.submitForm`; `BfiConsultarUltimasOperacionesFragment.submitForm`; `BfiConsultarLimiteFragment.submitForm`; `BfiAccountStatementFragment.submitForm` |

## Shared behavior and limits

- The four bank registration forms use selector `49`; partial-USSD agency markers align with bank codes `01` (BPA), `02` (BANDEC), `03` (Metropolitano), and `05` (BFI). MiTransfer uses `08` and is outside this comparison.
- Selector `62` is not one uniform inquiry: the general banking menu can send only currency ID `1` or `2`, while BPA, Metropolitano, and BFI account forms send currency plus selected account. The source catalog currently confirms BPA/BFI account-form partial markers `01`/`05` and Metro marker `03`.
- Selector `45` has a short BPA/Metropolitano form and a separate extended BPA form with origin-account, PIN/agency, and optional message/flags. They are distinct forms; the extended BPA route is used by saved-account transfers and the standard BPA operation menu. This does not establish that every bank exposes both variants.
- The remaining source inventory includes unreconstructed classes and partially reconstructed screens. Absence from this table means “not yet traced,” not “unsupported by the app or bank.”

For payload templates and dispatcher details, see the [USSD code catalog](ussd-code-catalog.md), especially registration, selector `45`, selector `62`, and selector `69` entries.


## BFI encrypted QR metadata review

`banking/ui/bfi/BfiQrAccountFragment.manipulateExtraQRData()` is reconstructed
from APK method
`B0jOLrWx09th/VW6IL66KC6M/LgiFGRpiEl.smali` →
`manipulateExtraQRData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z`.
This is a bounded review of the shared BFI QR/payment metadata path; other
partial BFI/Wallet implementations still require their own behavioral review.

The metadata is decoded by `procesarExtra(extraData, noProveedor,
idTransaccion)` and split into description, regex text, date window and QR ID.
Bytecode tests the description length with `if-lez ... :cond_1`, so a nonempty
description sets the hint and enables its input/layout. JADX inverted this
branch in the copied clean method. The reconstructed branch follows bytecode.
The regex field is read but not validated by this method.

Bytecode also skips date checking on `if-lez ... :cond_8` and
`if-ne ... 0x10 ... :cond_8`: a nonempty 16-character window enters date
checking. The former clean condition required both length ≤ 0 and length 16,
which prevented all date checks. The restored gate interprets the first eight
characters as the start and the next eight as the end (`ddMMyyyy`). It compares
them with today's local date normalized through `yyyy-MM-dd`. A start after
today shows `QR no disponible`; an end before today shows `QR vencido`; either
flag returns false. Equality with either endpoint is allowed, and `00000000`
omits that endpoint's check.

The source's permissive error behavior is retained: decoding failure or null
data leaves the default true; malformed field arrays reach the original
stack-trace handler; date-parse failures log `EXC` and retain that endpoint's
false flag. Date parsing remains lenient through `SimpleDateFormat`. A nonempty
QR ID sets `isEnviarAuxDat` after date checking even when the result is false.
This review establishes the local metadata rules, not gateway acceptance or
full feature equivalence. Validation was a static comparison against the
method's bytecode branches and catch handlers; no runtime tests were run for
this change.
