# Reconstruction inventory

Run `make stats` for counts or `make inventory` to generate
`.workspace/reconstruction-inventory.json`. Python 3 is the only dependency.
The generated JSON is local and reproducible; it is not a verified mapping database.

The inventory joins every Java file under `src/` to clean files under
`app/src/main/java/` using exact `@obfuscated_class` annotations and explicit
`mappings/classes.json` entries. It keeps both sources of evidence so a conflict
does not silently replace a candidate. Source identifiers come from paths relative
to `src/`; clean names come from package declarations and filenames.
Inner classes without their own Java file and names from smali are not resolved
by this tool. It does not infer matches from short names.

Each original has a `link_status`: `unlinked`, `single_candidate`, or
`multiple_candidates`. These indicate review scope, not implementation quality.
A single candidate can still contain stubs, omitted methods, or incorrect behavior.
Generated and library classes are included in the full inventory; filter the
`original` field to `cu.etecsa.cubacel.tr.tm.` for the main application package.

`mapping_issues` distinguishes absent original paths (`source_not_found`), absent
clean classes (`clean_not_found`), and disagreement between a mapping entry and a
clean file's annotation (`annotation_conflict`). These are individual incidences;
one mapping may have more than one. Resolve them against source before editing
the authoritative mapping file.

## 2026-10-29 snapshot

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

| Scope | Original Java files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All `src/` | 794 | 347 | 384 | 63 |
| Main app package | 596 | 215 | 318 | 63 |

There are 510 clean files and 82 explicit class mappings. All clean files have
an annotation resolving to an original Java path. The explicit mapping file has
4 incidences, all absent clean targets. No class annotation conflicts or absent
original paths remain. These counts do not establish a completion percentage.

The accessibility service, callback registry/interface, enabled-service checker,
and SMS receiver are reconstructed. JVM tests compare 240 accessibility event
scenarios, five enablement scenarios, and receiver behavior with original classes
under a fake Android API. The activation validator duplicate was consolidated
under `config/ActivationCodeValidator`; its original algorithm matches in 3,272
normal/error input comparisons. The JADX test oracle restores only a missing
catch-variable declaration needed to compile the original validator.

The stale paths for the base activity, USSD dispatcher, SMS sender and SMS parser
now point to their actual files in `l08fNVC4KOKK/`; the SMS parser target and login
request packages match existing clean declarations. These are verified identity
links, not verification of all methods in those reconstructions. In particular,
the two-factor login request's `factor` has been restored from String to int,
matching the original. Added the missing request marker, API response wrapper,
permission/error enums, and own-card/mobile/landline entities. The own-card DAO
now uses `OwnCard`, distinct from the MiBoleto service registration entity.
The complete 56-class e-commerce model/domain/geographic tree now follows the
original bodies, including inheritance, nested classes, constructors/defaults,
and accessors. Earlier drafts dropped filters/DTO fields, changed numeric types,
and replaced a nested user model with a different class.

JVM tests compare 78 original and clean model pairs (including nested classes and
dependencies): reflected fields and annotations, defaults, metadata, enum
order/permission IDs, getters, and setter mutations. A second run uses actual
Gson to compare JSON trees at defaults and after mutations. It uses the local
Gson 2.9.1 jar when available; set `TRANSFERMOVIL_GSON_JAR` elsewhere. The wire
test is explicitly skipped when the jar is absent, while schema tests still run.
JSONObject and database annotations remain substitutes, so this does not test
SQLite persistence, real JSON-object internals, or Android UI/network flows.

Auth validation now has its original typed implementation instead of the throwing
placeholder or the alternative draft that omitted clearing expired state. A
fixed-clock JVM comparison checks 517 operation/state combinations against the
original, including the inclusive 30-minute boundary, future/null dates and DAO
failures. Only the clock read is replaced in test copies; production uses Date().
The original 46-value operation enum and full AuthSession metadata are restored.

Character dictionary/text encoder duplicates and three equivalent callback
interfaces were consolidated. Encoding comparisons cover every dictionary entry,
digit-run boundaries, unsupported characters, nulls and Unicode digit inputs.
The original single-digit marker behavior and literal `null` concatenation in
`getCodes` are preserved. Callback checks distinguish primitive boolean from
nullable Boolean result parameters.

### README task progress

`make progress` updates the preserved 50-block README bar from the top-level
checkboxes in TODO.md. `make inventory` also refreshes it. The percentage is
`floor(100 * completed / total)` and filled blocks are
`floor(50 * completed / total)`. Tasks have equal weight; the number can decrease
when scope grows. This checklist metric is separate from reconstruction fidelity
and from the source-link counts above. Run
`python3 scripts/update-progress.py --check` to detect an outdated bar.

### Operation menu reconstruction

- `data/OperationMenuBuilder.java` is the single reconstruction of
  `ZNRpoHwtLXM.nljtDl5MIf`. The former banking candidate had empty banking fill
  and update methods and was removed. The remaining candidate was replaced with
  all original method bodies, adapting dependency names to existing clean classes.
  It preserves the `fill_all` and `update_*` API called by the database helper.
- `Operation.operacion` now uses `BankOperationCode`, matching the original
  `FdonIAFI9w` field and the DAO API. The stale String placeholder was removed.
- Added the missing `TaxRecord` entity from `Tributo`. Its database table stays
  `Tributo`; original export metadata quirks (`Nauta` table descriptor and the
  duplicate `nombre` field descriptor) are preserved explicitly.
- `banking/BankOperationCode.java` matches all 332 original constants from
  `ZNRpoHwtLXM/FdonIAFI9w.java`, in order. Its mapping now names that actual path.

Run `make test-reconstruction` with Python 3 and a JDK. The JVM comparison
compiles the real reconstructed menu, entities, enums, and metadata classes,
and compares them with the original JADX menu adapted only for dependency names.
It checks 17 public methods under five DAO scenarios: missing records, existing
records, duplicate records, a transient query failure, and persistent query
failure. It compares ordered DAO/log traces, row field values, returned values,
exception types, and in-memory menu lists (85 method/scenario pairs).

Android classes, resource IDs/string lookup, ORMLite annotations, JSON data, and
the DAO implementation are test substitutes. JSON fixtures include valid and
malformed rows. This verifies menu control flow and data construction under
those scenarios; it does not validate real asset parsing, SQLite persistence,
Android navigation, or the full application build. Fragment class strings retain
APK names; a future runnable app needs coordinated navigation mapping.

Review duplicate candidates and mapping conflicts first, then compare methods
against JADX and smali where decompilation is incomplete. Record verified
equivalences in `classes.json` only after that review.

## 2026-11-04 snapshot

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

| Scope | Original Java files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All `src/` | 794 | 345 | 449 | 0 |
| Main app package | 596 | 215 | 381 | 0 |

There are 449 clean Java files and 86 explicit class mappings. Three mapping
incidences remain, all mappings to absent clean activities (`AgentMainActivity`,
`GeneralMainActivity`, and e-commerce `LoginActivity`). A single source candidate
is an identity link only; it does not certify complete methods, UI behavior, or a
working Android build. The task bar is 86/146 and remains separate from these
source-link counts.

## 2026-11-05 snapshot

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

| Scope | Original Java files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All `src/` | 794 | 339 | 455 | 0 |
| Main app package | 596 | 208 | 388 | 0 |

### Main-package unlinked source distribution

The 208 unlinked main-package files group as follows. This is a package-path
count from the generated inventory; it does not yet classify each class as
generated code, Android glue, or application behavior.

| Original package segment | Unlinked files |
| --- | ---: |
| `B0jOLrWx09th` | 135 |
| `l08fNVC4KOKK` | 19 |
| `B21UyndcVvF` | 16 |
| `ZNRpoHwtLXM` | 13 |
| `us8tbD58ow4` | 11 |
| `oEpx7i6I9Bq` | 10 |
| `h4VIMAs7y2v` | 2 |
| `BuildConfig`, `R` | 2 |

There are 457 clean Java files and 86 explicit class mappings. All explicit
class mappings resolve to clean files; two utility/draft classes remain
intentionally unannotated: the old incomplete card-validation draft and the
new QR bank-code adapter. The Agent, General, and e-commerce login activities
contain bodies migrated from JADX, with imports adapted to retained raw-module
classes. BFI account screens now use clean shared bases, while five bank tab
hosts/pagers and nineteen primary BFI/Metropolitano/BPA operations have
source-backed routing. Twenty-three additional Metro classes now contain their
original source bodies, sixteen BPA screens, ten list/edit screens, and
thirty-three Wallet screens were restored from JADX; eight card-rendering
methods missing from JADX were recovered from archived smali. These screens
retain raw service, model, or child-fragment dependencies.
Source links do not establish that screens compile or run; the inventory
progress bar remains separate from source-link coverage.

## 2026-11-10 snapshot

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

| Scope | Original Java files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All `src/` | 794 | 368 | 426 | 0 |
| Main app package | 596 | 237 | 359 | 0 |

Generated with `python3 scripts/reconstruction-inventory.py` from the current
`src/`, clean Java tree, and `mappings/classes.json`. The live inventory reports
449 clean Java files, 85 mapping entries, no mapping issues or duplicate
candidates, and 23 clean files without source annotations. Duplicate candidates
were resolved by reusing shared BFI authentication/registration screens and
removing false source tags from derived helpers. The unused `UssdDispatcher`
Activity mapping was removed because the active source is a static helper
called directly by the app. These are exact-link counts only and do not
establish behavioral completeness.

The 237 unlinked main-package sources group by first package segment as follows:

| Original package segment | Unlinked files |
| --- | ---: |
| `B0jOLrWx09th` | 163 |
| `l08fNVC4KOKK` | 20 |
| `B21UyndcVvF` | 16 |
| `ZNRpoHwtLXM` | 13 |
| `us8tbD58ow4` | 11 |
| `oEpx7i6I9Bq` | 10 |
| `h4VIMAs7y2v` | 2 |
| `BuildConfig`, `R` | 2 |

This refresh establishes the current package distribution only. It does not
classify the obfuscated classes as generated code, Android glue, or application
behavior; that source-by-source review and exact-link cleanup remain open.
