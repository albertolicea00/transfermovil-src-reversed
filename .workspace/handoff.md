# Transfermóvil reconstruction handoff

## Current state — 2026-11-12

Repository: `/Users/albertolicea00/Develop/00 WIP/transfermovil-src-reversed`
Target APK: `cu.etecsa.cubacel.tr.tm-v162.apk`
SHA-256: `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`

The user asked to continue the full 213-source classification and prefers larger conventional commits in English, without coauthor. Do not push. Three agents were assigned disjoint ledger sections and have now completed their edits. The root agent classified the ten remaining `l08fNVC4KOKK` sources. All ledger changes are currently uncommitted in `docs/unmapped-source-review.md`.

## Ledger result

The baseline ledger still has exactly 213 unique rows. Current categories are 160 application behavior, 48 application support, 5 generated, and 0 pending. Three reviewed package blocks were completed by agents: `OfZgAbz2cY8` (18 behavior, 1 support), `P2MO7cFkntPD` (15 behavior, 1 support), and `zpT98w56Knm` (42 behavior, 1 support). The last ten shared-runtime rows in `l08fNVC4KOKK` were also classified (one app behavior, nine support).

Recent committed work:
- `18d00de docs: classify BPA inquiry menu`
- `2318e02 docs: classify BPA operation forms`
- `6c369e2 docs: classify mobile service operations`

## Required next steps

1. Recheck all 213 ledger row IDs are unique and category totals equal 213; run `git diff --check`.
2. Update the ledger summary and package table to reflect zero pending rows and the current category totals.
3. Mark the completed package classification TODO items as done; preserve remaining reconstruction tasks that are not part of the 213-source audit.
4. Update README task progress/bar and classification totals using `make progress`; do not confuse exact source-link coverage with the scope-adjusted reconstruction metric.
5. Add a dated `CHANGELOG.md` entry with the APK and SHA-256 in the session heading.
6. Review the complete diff, then create one or a few grouped Conventional Commits in English. Do not add a coauthor and do not push.
7. Continue with outstanding reconstruction TODOs after the 213-source audit is fully documented and committed.

Important: `AXjqRy5YBz.mostrarTarjeta` remains an JADX decompilation stub; this was recorded in its ledger evidence. Its surrounding transfer validation and selector-45 submission were reviewed.
