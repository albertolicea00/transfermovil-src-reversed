# Java reconstruction handoff

Temporary pause/resume checkpoint. Remove when resuming; update when stopping.

**Snapshot:** 2026-10-29. **APK:** `cu.etecsa.cubacel.tr.tm-v162.apk`
(version 1.260416, code 162). **SHA-256:**
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

## Recovered context

Claude session `581986d3-8fc3-4c9e-a8a5-be8ec2012462` and its project memories
were read locally. The user wants complete, traceable Java reconstruction.
Earlier agents stopped on API limits; their drafts were not validated.
Keep TODO.md current and use short Conventional Commits without co-author lines.

## Completed in the latest continuation

- User requested that the README progress bar be maintained. It now tracks TODO
  task completion (65/130 = 50%), refreshed by `make progress` or `make inventory`.
  It can fall when scope grows; it is explicitly not verified code coverage.
- Corrected original paths for base activity/USSD/SMS class and field mappings,
  the parser target name, and login request package targets; 15 mapping
  incidences remain. Identity checks do not validate method behavior.
- All seven tests pass, including progress scope/rounding/idempotency tests.

- Kept `data/OperationMenuBuilder.java` as the single reconstruction of
  `ZNRpoHwtLXM.nljtDl5MIf`, restored all original method bodies with clean
  dependencies, and removed the banking duplicate containing omitted bodies.
  The database helper's `fill_all` and `update_*` calls retain their API.
- Restored `Operation.operacion` to `BankOperationCode` and added the missing
  `TaxRecord` from `Tributo`, preserving original export metadata quirks.
- Added/corrected the menu, tax entity and operation enum mappings.
- `make test-reconstruction` passes four tests, including JVM compilation and
  85 original-versus-clean menu method/scenario comparisons. Android, resources,
  JSON fixtures, ORMLite annotations and DAO persistence are substituted.
  This is not a full Android build or proof of real SQLite/navigation behavior.

## Current review inventory

Run `make inventory` for `.workspace/reconstruction-inventory.json` (local,
regenerable). See [inventory notes](../../docs/reconstruction-inventory.md).

| Scope | Original files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All src/ | 794 | 360 | 364 | 70 |
| Main package | 596 | 223 | 303 | 70 |

504 clean files, 73 explicit class mappings, and 15 mapping incidences remain
(14 absent clean targets, 1 absent original path, no annotation conflicts).
These counts are not a completion percentage or proof of faithful behavior.

## Remaining work

1. Review the remaining 26 interrupted drafts under `banking/ui/` (pagers,
   tabs, BPA, BFI, Metropolitano, wallet). Several contain stubs, null returns,
   or fixed values. Compare source before marking complete.
2. Resolve remaining duplicate candidates and mapping incidences from the JSON
   review queue. Source-linked classes can still be incomplete or incorrect.
   For example, `ecommerce/model/request/TwoFactorLoginRequest.factor` is String
   in the clean draft but int in original `L9hiDpmAir`; correct with source evidence.
3. Review 223 unlinked main-package originals, distinguishing generated code
   from application logic. Prioritize `B0jOLrWx09th/p1CEgMEeWUbD/`
   `{P2MO7cFkntPD,zpT98w56Knm,DrR0lEVP3qk}`, `B0jOLrWx09th/`
   `{hTZG5yFgyZY,MqnAp2jnnon,ivq3YYEGPZM,VW6IL66KC6M}`, `B21UyndcVvF`,
   `oEpx7i6I9Bq`, and `us8tbD58ow4`.
4. Continue behavior/reference checks. No Gradle project builds the entire clean
   Java tree yet. Original fragment name strings require coordinated navigation
   mapping before a runnable reconstruction.

Functional analysis tasks remain in [TODO.md](../../TODO.md).
