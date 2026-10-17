# Java reconstruction handoff

This is the temporary pause/resume note. Update it when stopping work; remove it when work resumes.

**Snapshot:** 2026-10-17. **APK:** `cu.etecsa.cubacel.tr.tm-v162.apk` (version 1.260416, code 162). **SHA-256:** `b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

## Work in progress

The previous session was moving classes from `src/` (obfuscated JADX output) into `app/src/main/java/` (source with descriptive names), while recording equivalences in `mappings/classes.json`. It created e-commerce, banking UI, general UI, configuration, and utility modules. Its last commits were `783ea41`, `c195786`, `5b69f05`, `1f336e8`, and `d49d372`.

The user asked to stop reconstruction, document the state, and save existing work with Conventional Commits. The prior session's agents stopped because of a usage limit. Their unfinished tasks must not be treated as complete.

## Verified state

| Measure | Result | Meaning |
| --- | ---: | --- |
| Java files in `src/cu/etecsa/cubacel/tr/tm/` | 596 | JADX files in the main package, including generated files. |
| Java files already committed before this handoff | 476 | Files tracked by Git at the start of this session. |
| Drafts left after those commits | 28 | Previously untracked; committed as incomplete work for later review. |
| Java files visible in `app/src/main/java/` | 504 | File count, **not** a percentage of faithful reconstruction. |
| Unique `@obfuscated_class` identifiers | 433 | 372 match Java source paths in `src/` exactly. |
| `src/` Java files without an exact annotation match | 224 | Review queue; not necessarily 224 missing reconstructions. |

The **476/596 (80%)** figure in the Claude transcript divides file counts from different trees. Its later estimate of **about 120 remaining files** is also not supported by a one-to-one source mapping. Some clean files lack annotations, annotations are duplicated, and some reconstructed classes are partial outlines. There is **no verified completion percentage**.

## Drafts needing review

- `app/src/main/java/cu/etecsa/transfermovil/banking/OperationMenuBuilder.java` and `app/src/main/java/cu/etecsa/transfermovil/data/OperationMenuBuilder.java` both claim the same original class: `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.nljtDl5MIf`. They are alternative versions. Compare both with the original JADX source and choose one before integration.
- The other 26 drafts are under `banking/ui/` and cover pagers, tabs, BPA, BFI, Metropolitano, and the wallet. Several contain `stub`, `return null`, or fixed return values. Do not assume that they implement the original behavior.
- The reconstructed source was not compiled. This repository has an analysis `Makefile`, but no Gradle project was found for building `app/src/main/java/` directly.
- `mappings/classes.json` has 72 entries and was not updated for these 28 drafts. Review the equivalences and confidence levels when work resumes.

## Next session

1. Compare the 28 drafts with `src/`, resolve the duplicate `OperationMenuBuilder`, and replace stubs only where the original behavior can be established.
2. Build an inventory linking each original path to its clean counterpart. Prioritize these groups among paths without an exact annotation match: `B0jOLrWx09th/p1CEgMEeWUbD/{P2MO7cFkntPD,zpT98w56Knm,DrR0lEVP3qk}`, `B0jOLrWx09th/{hTZG5yFgyZY,MqnAp2jnnon,ivq3YYEGPZM,VW6IL66KC6M}`, `B21UyndcVvF`, `oEpx7i6I9Bq`, and `us8tbD58ow4`. Separate generated classes from application logic.
3. Update `mappings/classes.json` as each equivalence is verified. Record duplicate mappings and clean classes with unclear origins.
4. Check reconstructed methods and cross-class references before claiming coverage or attempting a build. Functional analysis tasks remain in [TODO.md](../../TODO.md).

This document is a resumption point. The drafts preserve interrupted work; they are **not validated** as functional source.
