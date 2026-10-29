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
| All `src/` | 794 | 353 | 371 | 70 |
| Main app package | 596 | 220 | 306 | 70 |

There are 511 clean files and 73 explicit class mappings. All clean files have
an annotation resolving to an original Java path. The explicit mapping file has
8 incidences: 7 absent clean targets and 1 absent original path. No class
annotation conflicts remain. These counts do not establish a completion percentage.

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

JVM tests compare 73 original and clean model pairs (including nested classes and
dependencies): reflected fields and annotations, defaults, metadata, enum
order/permission IDs, getters, and setter mutations. A second run uses actual
Gson to compare JSON trees at defaults and after mutations. It uses the local
Gson 2.9.1 jar when available; set `TRANSFERMOVIL_GSON_JAR` elsewhere. The wire
test is explicitly skipped when the jar is absent, while schema tests still run.
JSONObject and database annotations remain substitutes, so this does not test
SQLite persistence, real JSON-object internals, or Android UI/network flows.

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
