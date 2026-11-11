# Unlinked main-package source review

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.
Snapshot generated from `scripts/reconstruction-inventory.py` on 2026-11-11.

## Purpose and limits

This ledger retains the baseline cohort of 213 Java source files in the main application package that lacked exact clean-source links when review began. Two cohort members, `MEqNzldfDl` and `KeTIEVSfVo`, now have exact clean-source annotations; 211 remain currently unlinked. The ledger is an audit queue, not a decompilation-success metric. Current JADX output reports 98.8% class decompilation success (40 errors); this queue measures source-to-clean class identity links. Those are separate measures, and a link does not prove behavioral equivalence.

Assign one primary category only after checking the source body and, where useful, callers/usages. The review is organized by package segment and nested package so it can reveal which files contain Transfermóvil behavior/support and which are generated or third-party code. The `oEpx7i6I9Bq` package has ten confirmed application-behavior screens, all 16 `B21UyndcVvF` rows are classified as app behavior/support, `iN1lHDKE5h`, `CBIHzlCw60`, `NdeFyyhxF1`, `Kw29o4NNrz`, and `pECcPKxF9i` are confirmed application behavior, `GVEefrRz76` and `FBsQzP3Zfj` are confirmed app support, `H0oV6Ot0bS$$ExternalSyntheticApiModelOutline0` is confirmed generated glue, and `BuildConfig`/`R` are confirmed generated classes; the other 177 rows remain pending:

- `application behavior`: UI, routing, domain rules, persistence, protocol, network, or security logic.
- `generated`: resource/build output, synthetic bridges, binding code, or compiler-generated machinery.
- `third-party/library`: vendored or dependency implementation rather than Transfermóvil-specific behavior.
- `application support`: app-specific adapter/helper that supports behavior but is not itself a user-facing feature.
- `unknown`: evidence is insufficient; retain it in scope and explain what needs inspection.

Package location or class name alone is not enough to classify a source. For every reviewed row, record the category, a short role, and evidence (source methods, callers, resource use, or dependency signatures). Exact-link eligible application behavior to clean code or document why it is excluded. Do not remove generated/library rows from counts until the classification evidence supports exclusion. Once all rows are classified, publish category totals and calculate a scope-adjusted clean reconstruction coverage using only in-scope application behavior/support. Keep that metric separate from JADX decompilation success (98.8%) and exact source-link coverage (385/596), since they measure distinct things.

## Package batches

| Package segment | Sources | Initial review focus | Status |
| --- | ---: | --- | --- |
| `B0jOLrWx09th` | 139 | Review fragments, activities, dialogs, generated callbacks, and support classes individually; `iN1lHDKE5h`/`CBIHzlCw60`/`NdeFyyhxF1`/`Kw29o4NNrz`/`pECcPKxF9i` are behavior, `GVEefrRz76` is shared account-selection support, and one empty R8 outline class is generated. | Partial: 5 behavior, 1 support, 1 generated, 132 pending |
| `l08fNVC4KOKK` | 20 | 20 shared runtime sources; distinguish app protocol/telephony helpers from generic adapters and generated glue; `FBsQzP3Zfj` is the Transfermóvil USSD dispatcher and app support. | Partial: 1 application support |
| `B21UyndcVvF` | 16 | App-specific operation/list adapters and sticky-header RecyclerView support; reviewed from class bodies and callers. | Reviewed: app behavior/support |
| `ZNRpoHwtLXM` | 13 | 13 data/domain sources; classify entities, DAOs, helpers, enums, and database/generated support. | Pending |
| `us8tbD58ow4` | 11 | Statistics history, SMS records, and chart fragments/models; reviewed from source bodies and screen callers. | Reviewed: application behavior/support |
| `oEpx7i6I9Bq` | 10 | Saved-account, transfer, configuration, activation, backup/restore, and update UI. | Reviewed: 10 application behavior |
| `h4VIMAs7y2v` | 2 | QR payment/transfer scanner fragments; reviewed from camera/gallery flows and callers. | Reviewed: application behavior |
| `BuildConfig` | 1 | 1 generated build-configuration source. | Reviewed: generated |
| `R` | 1 | 1 generated Android resource identifier source. | Reviewed: generated |

Reviewed source ledger; pending classifications use the `Pending` marker:

### `B0jOLrWx09th` — 139 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/GVEefrRz76.java` | application support | Shared source-account selector, saved/new account state, currency-dependent selection, card artwork/classification, and validation hooks; active caller `WalletBillPaymentFragment` extends this class and delegates its account and submit UI to it. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.CBIHzlCw60` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/CBIHzlCw60.java` | application behavior | Nauta menu screen builds recharge/latest-payment actions; routes recharge to `NdeFyyhxF1`, offers selector `91` or the recent-recharge form `Kw29o4NNrz`, and owns the menu/dialog flow. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.Kw29o4NNrz` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/Kw29o4NNrz.java` | application behavior | Nauta latest-recharge query form loads saved account types, handles international/national selection, validates the account, persists its selected type, and dispatches selector `91` with account and type. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/NdeFyyhxF1.java` | application behavior | Nauta recharge form loads saved accounts/destination phones, distinguishes international and national account types, accepts bonus/ticket values, validates optional notification phone, persists selections, and dispatches selector `90`. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.pECcPKxF9i` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/I1YePWjLywK9/pECcPKxF9i.java` | application behavior | Nauta balance-query form loads saved account types, handles international/national selection, validates the account, persists its type, and dispatches selector `92` with account and type. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/A9IFPpW4HW.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/VqNI4JnvJD.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/cwVwMsOO60.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/g1bQ0lLj6na.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.yzFfgPWLpL` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/Tpv6wiFh8L6/yzFfgPWLpL.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.JM38ENT2L0` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JM38ENT2L0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.JUhL44kV5Z` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/JUhL44kV5Z.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.Mu8P2X7JEu` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/Mu8P2X7JEu.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.R0CqDlLUE6` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/R0CqDlLUE6.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.SkgMUqFCoe` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/SkgMUqFCoe.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.vnC9BffKAI` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/XJnzkvfXNkI/vnC9BffKAI.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.wRqLBJvNq6` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/MqnAp2jnnon/wRqLBJvNq6.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.UTk9UWZYxf` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/UTk9UWZYxf.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/r7Rinp9ooL.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xf94v3SFEM` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xf94v3SFEM.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/VW6IL66KC6M/xpc0ejPtmZ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.cSs8O7U2kmm.Z4cR6n2oFo` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/cSs8O7U2kmm/Z4cR6n2oFo.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS$$ExternalSyntheticApiModelOutline0` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/H0oV6Ot0bS$$ExternalSyntheticApiModelOutline0.java` | generated | R8 synthetic API-model outline class with no fields or methods; generated bridge/support shell, no application logic. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/HZgbT8IXPf.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/JrjJL8mtlI.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/s9CT6pjRyD.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.x12rSjPY6pZ` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/QM5YzxsQFRH/x12rSjPY6pZ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/RmIDjwu3SCe/wfroNBIJF7.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.BpgQdOQz0p` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/BpgQdOQz0p.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.CepWe39cnz` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/CepWe39cnz.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.H4bU7yMkJJK` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/H4bU7yMkJJK.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/ee4tsHNQiS.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/f03gMUuBeK.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/tKjjxHr2PT.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/hTZG5yFgyZY/rq5HBT3ZZCR/yww1pS0VKU.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/AjGJz9tVLXv/GMFMyKMnO2.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/FNRzUmC7E5.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.IVWCBH7bqvy.ICmtk949Og` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/IVWCBH7bqvy/ICmtk949Og.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.KyQXczCdrr` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/KyQXczCdrr.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.LALCrDPvhM` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/LALCrDPvhM.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/aQdU5kg0yGq/BktkqFBOIQ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/aQdU5kg0yGq/XRa1KuZNBW.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/C8l2t8799rL.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/E1lhoLKryWP.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/kE6CyiKsVrS/b0kkzvOCEu.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.s88cBrrDEaR` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/s88cBrrDEaR.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.vaYCVGq917` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/vaYCVGq917.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/ivq3YYEGPZM/xLm6Wjf6gEf/s9lZwtvq9Dl.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.AXjqRy5YBz` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/AXjqRy5YBz.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.Dm6u4PA5eg` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Dm6u4PA5eg.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.FX8u11r7nB` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FX8u11r7nB.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.FgpBLXKm6t` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/FgpBLXKm6t.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.Hg2ath75ih` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/Hg2ath75ih.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/iN1lHDKE5h.java` | application behavior | Extended account transfer form: `submitForm` validates destination/origin, CUP/CUC/USD rules, recipient phone, optional message/flags, PIN/agencia mode, and selector-45 standard/partial payloads; uses account/card classifier and packet helper. Distinct from the clean short-form `BpaTransferFragment`. |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.o6kycf55Gw` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/o6kycf55Gw.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.pxpQ3hcmYF` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/pxpQ3hcmYF.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.u4QMc0S0ZHo` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/u4QMc0S0ZHo.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.xSwGh0MTOg` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/xSwGh0MTOg.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.zOs55UzH6z` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/gCOrME2HrQt/zOs55UzH6z.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/kmO9Md6JHr.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.voNSkP3P8q` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/DrR0lEVP3qk/izLB5V8oGbU/voNSkP3P8q.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.CA73VZ4FAR` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CA73VZ4FAR.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.CiYPvcQWEO` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/CiYPvcQWEO.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D38ae2xieeM` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/D38ae2xieeM.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/KmgeIVr5RG.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.SIxHnoWicq` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/SIxHnoWicq.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.eRe5PTC1On` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/eRe5PTC1On.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.fvzO0qRHbu` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/fvzO0qRHbu.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.hvC0UGR2L0` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/hvC0UGR2L0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.kAazEwDasT` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/kAazEwDasT.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/KsDQL9cTTl.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.Xh70Rdjfpc` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/Xh70Rdjfpc.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.g9VybPHHUE` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/nNSC8tRyptP/g9VybPHHUE.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.p3NpwYhcUs3` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/p3NpwYhcUs3.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.sT2WhSOo3S` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sT2WhSOo3S.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.sxbhjZQZxo` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/sxbhjZQZxo.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.D6YZ7ruA6K` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/D6YZ7ruA6K.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.Lxfm3mPhrA` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/Lxfm3mPhrA.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.iQte15zdZs` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/iQte15zdZs.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.t7in6psmmaQ` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/OfZgAbz2cY8/uWXPvgMX2Iw/t7in6psmmaQ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.A2n01rp2LB` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/A2n01rp2LB.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.CUlS6AdACy` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/CUlS6AdACy.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/FSH5TTPZXI.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.GKs5yCtPyT` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/GKs5yCtPyT.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/ILoKZQnPEb.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/LHLbFzX21y.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.RGGlSlGwBS` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/RGGlSlGwBS.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.Sh9ycEKe3r` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/Sh9ycEKe3r.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.U3Fs3ZfEsvU` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/U3Fs3ZfEsvU.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.aagv9XXigK` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/aagv9XXigK.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.e7QqJJqvaOU` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/e7QqJJqvaOU.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.o7atwhPiFj` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/o7atwhPiFj.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.oGGmtSBioS` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/oGGmtSBioS.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.yB5HZ4Ae3W` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/yB5HZ4Ae3W.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.zqBrU3RI5y` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/EE2asIZ0vyr/zqBrU3RI5y.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/P2MO7cFkntPD/SXVyD7BX7KJ/dLMLrixv4f.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.GhhAuUBVrI` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/GhhAuUBVrI.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.dVxDCMi9cK` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/dVxDCMi9cK.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.gkzzwVYksz` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/gkzzwVYksz.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.m3eQg75J6k0` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/Aj11H1nzNkW/m3eQg75J6k0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.B0Bcr9KURy` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/B0Bcr9KURy.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.BoMBck6OXT` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/BoMBck6OXT.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.KJm9NxxPQx` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/KJm9NxxPQx.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.MAvaCEUqwa` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/MAvaCEUqwa.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.N4kvcsGpCN` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/N4kvcsGpCN.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.PliSaYhOg0` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/PliSaYhOg0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.QLR2f9HcHa` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/QLR2f9HcHa.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.RFGGC2VcTY` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/RFGGC2VcTY.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.TlJMpg47gS` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/TlJMpg47gS.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/aCwLXhT3MF.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.k2rtzJwkcQ` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/k2rtzJwkcQ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.lQox6tgMlH` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/lQox6tgMlH.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.mhElzRz7zH` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/mhElzRz7zH.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.onjPHcH2OE` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/onjPHcH2OE.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/pnl2Kga8j7.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.q8aBmCOCwuI` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/q8aBmCOCwuI.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/x6Wob3Sa98U.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/EJvHfXHGTV8/yiqT29TYTb.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.FLftkSrl5R` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/FLftkSrl5R.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.HGFRxfLF5W` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/HGFRxfLF5W.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.TFU20KJsT9` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/TFU20KJsT9.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.tYCC0hiRcm` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/tYCC0hiRcm.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/G8E5Fjf9l7Y1/xR6zA9CmCE.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.L3qC11Tn05K` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/L3qC11Tn05K.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.PEi17BvMam` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/PEi17BvMam.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/RC71RyOpsk.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.Vdv5nYP39d` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/Vdv5nYP39d.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.bvKZxRIdlB` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/PKbdqsi8z03/bvKZxRIdlB.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.T460cLTd4A1` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/T460cLTd4A1.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.dYe9oOuW7h` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/dYe9oOuW7h.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.gUJ1ICglWB` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/gUJ1ICglWB.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/hJhf3aumcr.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.jyBbMyVMOV` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/jyBbMyVMOV.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.kD9wg15jwt` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/kD9wg15jwt.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.rZEvnp2Sqs` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/rZEvnp2Sqs.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.uurdBwh7ub` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/uurdBwh7ub.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.x65QVMzjQ2n` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/x65QVMzjQ2n.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.yDpeA65zCe` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yDpeA65zCe.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.yvWHEB2qa4` | `src/cu/etecsa/cubacel/tr/tm/B0jOLrWx09th/p1CEgMEeWUbD/zpT98w56Knm/yvWHEB2qa4.java` | Pending | Pending |

### `l08fNVC4KOKK` — 20 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java` | application support | App-specific USSD dispatcher: builds dial URIs from AppConfig and transformed payloads; provides confirmation, return/no-return, observer, and navigation variants used by clean forms and operation menus. See [telephony notes](telephony.md#ussd-dispatch-class-fbsqzp3zfj). |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/IixRWvtdZG.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.QfruhfaN5Z` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/QfruhfaN5Z.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.H5bNyNZfB5K` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/H5bNyNZfB5K.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/MX9gh9mLxd.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd$$ExternalSyntheticApiModelOutline0` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/MX9gh9mLxd$$ExternalSyntheticApiModelOutline0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.T7hdFVrmeS5` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/T7hdFVrmeS5.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.WV9lIl58Oa` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/WV9lIl58Oa.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.iNEsCMH3jK` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/iNEsCMH3jK.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.LXkgnXgQxU` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/LXkgnXgQxU.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.i4QWQ24WFj` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/i4QWQ24WFj.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.jraNhpzll4` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/jraNhpzll4.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/pAzq93vIl3.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.tuqYe4EsPvj.T0kxbcahAZJ` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/tuqYe4EsPvj/T0kxbcahAZJ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.doK2nmcsGSe.OWv0ASqPtJ` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/doK2nmcsGSe/OWv0ASqPtJ.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.doK2nmcsGSe.fQ34SUWqmN` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/doK2nmcsGSe/fQ34SUWqmN.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.doK2nmcsGSe.jUkmOGHTpN` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/doK2nmcsGSe/jUkmOGHTpN.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.doK2nmcsGSe.naLGp4k3kz` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/doK2nmcsGSe/naLGp4k3kz.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/z9AyDhvWhoQ/iUhUEXEdlxs/K5TDZs6r2lUJ/rRvXcuGxBE.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.V6JQkNZYoP2.vwtSdi7ika` | `src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/z9AyDhvWhoQ/iUhUEXEdlxs/V6JQkNZYoP2/vwtSdi7ika.java` | Pending | Pending |

### `B21UyndcVvF` — 16 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/ByJot7nE5d.java` | application behavior | Chart adapter for account/operation history; used by `us8tbD58ow4.mYaQ7jnA3Y`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.DmvQBLZLbV` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/DmvQBLZLbV.java` | application support | Binds `yHdVJARBHM` rows; used by `c69cv...x5ijzOU4VE`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/J9bkD55BKNh.java` | application support | Binds saved mobile-card accounts for `KeTIEVSfVo`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.JPTJLdwS9n` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/JPTJLdwS9n.java` | application support | Swipe/drag callback used by `us8tbD58ow4.D1rOcltDGsD`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QJoZrWCCWp` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/QJoZrWCCWp.java` | application support | Binds bank account rows; used by `c69cv...OxDrWxtsSZ`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/QV8ylwbhfB.java` | application support | Searchable SMS/statistics adapter over `M7OG7jG8CS` / `RecordSMS`; used by `D1rOcltDGsD`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.BolUq6wGDu` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XPH60zChinL/BolUq6wGDu.java` | application support | Custom RecyclerView attaches the package's sticky-header decoration. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.gNS2UxRuVW` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XPH60zChinL/gNS2UxRuVW.java` | application behavior | DiffUtil operation-menu adapter over `WUULVgZq02`; binds sticky section headers across two screens. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XPH60zChinL/ouX1muv8Hd.java` | application support | Sticky-header decoration used by `gNS2UxRuVW` operation menus. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XPH60zChinL/rBXnNc0Kx4.java` | application support | Defines `Post`/`Header` item types for grouped menu rows. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XvulaG5FAh.java` | application support | Dynamic-data adapter for `yHdVJARBHM` list pages; called by multiple screens. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.aKh5ZFPmqR` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/aKh5ZFPmqR.java` | application behavior | Operations-list adapter over `qcI22KekhL`; used by `us8tbD58ow4.B2duAUYNOU`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/khginYXYg6.java` | application support | Binds app-data rows; used by `c69cv...JntDz3d2vV`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lTi2u1QNOn` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/lTi2u1QNOn.java` | application support | App-list adapter with 50-row cap and active/inactive view types. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/xToaaw6pAW.java` | application support | Binds `yHdVJARBHM` app rows; used by `c69cv...MmUcSVNG36`. |
| `cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xy8ZrFR33a` | `src/cu/etecsa/cubacel/tr/tm/B21UyndcVvF/xy8ZrFR33a.java` | application support | Searchable RecyclerView adapter over `M7OG7jG8CS`. |

### `ZNRpoHwtLXM` — 13 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.DKCSeesA6l` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/DKCSeesA6l.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.olmTMXRAbf` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/KA1Vl8CZhLC/olmTMXRAbf.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.V7zVJ66kDf` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/V7zVJ66kDf.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.FqBpCTmUog` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/FqBpCTmUog.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.HEi1mzxf5v` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/HEi1mzxf5v.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.HEi1mzxf5v$$ExternalSyntheticApiModelOutline0` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/HEi1mzxf5v$$ExternalSyntheticApiModelOutline0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.Q94Igo6JT0` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/Q94Igo6JT0.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.Tm6hIpKM2l` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/Tm6hIpKM2l.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.XHCKnvJV9M` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/XHCKnvJV9M.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.i2s4qBIJCN` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/cVlXsnFy9Yf/i2s4qBIJCN.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.ho8G382dwNt.fHZ2PXN4o9` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/ho8G382dwNt/fHZ2PXN4o9.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.xNWgXsOsGx` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/ZbIB2agz7et/xNWgXsOsGx.java` | Pending | Pending |
| `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX` | `src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/tDZO41TAmLO/V9s8rJIDplX.java` | Pending | Pending |

### `us8tbD58ow4` — 11 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.B2duAUYNOU` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/B2duAUYNOU.java` | application behavior | Displays operation-summary rows from `unYp8VQThY`; uses app adapter `aKh5ZFPmqR` and refresh task. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.D1rOcltDGsD` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/D1rOcltDGsD.java` | application behavior | SMS/statistics detail screen; queries `RecordSMS` by service/date/currency and supports search/import/export. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.LxRjrwTADB` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/LxRjrwTADB.java` | application behavior | Tabbed statistics detail host for Agent, BPA, Bandec, Metro, and Wallet records. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.BXJNp1qv2n` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/BXJNp1qv2n.java` | application support | Currency enum used to group and label app statistics/chart series. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.FlNVShJWtm` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/FlNVShJWtm.java` | application support | Operation aggregate model: date, amount, currency, operation enum, and chart color. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.dI57nRThKt` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/dI57nRThKt.java` | application support | App-specific chart `SliceValue` carrying a `Nl0yptXmjQ` operation for selection. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.o3etZ8qrxr` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/o3etZ8qrxr.java` | application support | Aggregates operation/currency statistics into chart values and legend labels. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.oy860zvrlY` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/oy860zvrlY.java` | application support | ArrayAdapter renders legend rows with app currency and amount formatting. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.tGolNOl3DN` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/hMfWZ7cboKl/tGolNOl3DN.java` | application support | Legend-row model for currency, operation, color, amount, and label. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.mYaQ7jnA3Y` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/mYaQ7jnA3Y.java` | application behavior | Monthly operation-history screen; creates the chart/history adapter and resets cached data on refresh. |
| `cu.etecsa.cubacel.tr.tm.us8tbD58ow4.postcP0gVS` | `src/cu/etecsa/cubacel/tr/tm/us8tbD58ow4/postcP0gVS.java` | application behavior | Statistics tab host mapping five financial services to `D1rOcltDGsD` detail fragments. |

### `oEpx7i6I9Bq` — 10 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/KeTIEVSfVo.java` | application behavior | Saved mobile-card account list; `fillAdapter`, account CRUD actions, QR/share and six transfer routes; clean list and adapter now linked and opened by both main activities. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/MEqNzldfDl.java` | application behavior | Saved mobile-card account add/edit UI; validates account/alias, persists `MCBank`, and launches classic association. JADX stubs for `mostrarTarjeta`/`getBanco` are recovered from smali in the annotated clean editor draft. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/ULtRAlRy1V.java` | application behavior | Database backup/restore screen; file document launchers, export/import tasks, and data presenter. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UUlOTi00Yp` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/UUlOTi00Yp.java` | application behavior | Application settings; persists partial-USSD and QR-improvement switches in `AppConfig`. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UoWmGAF016` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/UoWmGAF016.java` | application behavior | Configuration menu; source routes entries to app update, activation, account management, backup/restore, and settings fragments. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/W2FmEAMdovs.java` | application behavior | Agent-version activation; validates activation code against app version/phone, stores agent code, enables ETECSA operations, and requests USSD authorization. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/WBJpHonI92.java` | application behavior | Update/download screen; shows current version and invokes the app APK download manager for ETECSA/APK sources. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.b3vEPrhNHF` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/b3vEPrhNHF.java` | application behavior | MiBoleto seller activation; validates activation code and enables the MiBoleto module in app configuration. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.eD2GCZ4Vix` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/eD2GCZ4Vix.java` | application behavior | Bank-module activation; validates code, enables bank operations and stores bank activation settings. |
| `cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa` | `src/cu/etecsa/cubacel/tr/tm/oEpx7i6I9Bq/xtUiphIcBa.java` | application behavior | Bulevar bank-module activation; validates code and requests authorization through the USSD dispatcher. |

### `h4VIMAs7y2v` — 2 sources

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT` | `src/cu/etecsa/cubacel/tr/tm/h4VIMAs7y2v/OJ3XxacXOT.java` | application behavior | QR scanning fragment: camera/ML Kit and ZXing analysis, gallery import, tap-to-focus, and result routing; used by payment/transfer and ticket screens. |
| `cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ` | `src/cu/etecsa/cubacel/tr/tm/h4VIMAs7y2v/f6Y2Wmtg6jQ.java` | application behavior | QR scanner variant with camera/gallery decoding and payment-option/result flows; callback is implemented by `AgentMainActivity`, `GeneralMainActivity`, and `S9ycHcoxAzy`. |

### `BuildConfig` — 1 source

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.BuildConfig` | `src/cu/etecsa/cubacel/tr/tm/BuildConfig.java` | Generated | Constant-only application/build/version identifiers; no executable methods. |

### `R` — 1 source

| Source identifier | File | Category | Role / evidence |
| --- | --- | --- | --- |
| `cu.etecsa.cubacel.tr.tm.R` | `src/cu/etecsa/cubacel/tr/tm/R.java` | Generated | Nested Android resource-ID constants only; references resources, no feature logic. |

## Completion criteria

- Every one of the 213 baseline rows has a supported primary category and role/evidence note; 10 `oEpx7i6I9Bq` screens, `iN1lHDKE5h`, `CBIHzlCw60`, `NdeFyyhxF1`, `Kw29o4NNrz`, `pECcPKxF9i`, `GVEefrRz76`, `FBsQzP3Zfj`, 16 `B21UyndcVvF` behavior/support classes, 2 QR scanner fragments, 11 statistics behavior/support classes, and 3 generated classes are confirmed, leaving 164 rows pending classification. Two rows now have exact clean-source links, so current main-package link coverage is 385/596.
- Generated and third-party/library rows have evidence and a reason they do not need a clean application reconstruction.
- Every application-behavior source has an exact clean link or a written, evidence-backed exclusion.
- Refresh package counts and the source-link metric whenever exact links or classifications change.
