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

## 2026-10-28 snapshot

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

| Scope | Original Java files | Unlinked | Single candidate | Multiple candidates |
| --- | ---: | ---: | ---: | ---: |
| All `src/` | 794 | 361 | 362 | 71 |
| Main app package | 596 | 224 | 301 | 71 |

There are 504 clean files and 72 explicit class mappings. All clean files have
an annotation resolving to an original Java path. The explicit mapping file has
28 incidences: 18 absent clean targets, 6 absent original paths, and 4 annotation
conflicts. These counts do not establish a completion percentage.

### Initial source checks

- `ZNRpoHwtLXM.nljtDl5MIf` has two candidates: `banking/OperationMenuBuilder.java`
  and `data/OperationMenuBuilder.java`. The original exposes `fill_all`,
  `fill_generales`, and other underscore-named methods. The data candidate keeps
  these names; the banking candidate changes them to `fillAll`, `fillGenerales`,
  etc. `data/TransferMobilDatabaseOpenHelper.java` calls `fill_all` in both
  creation and upgrade paths. This identifies an integration difference but does
  not establish either candidate's full behavioral fidelity. Both remain for review.
- `banking/BankOperationCode.java` matches all 332 original constants from
  `ZNRpoHwtLXM/FdonIAFI9w.java`, in their original order. Its mapping entry instead
  points to `l08fNVC4KOKK.FdonIAFI9w`, which has no Java file in `src/`.
  Review the mapping against this source evidence before correcting it.

Review duplicate candidates and mapping conflicts first, then compare methods
against JADX and smali where decompilation is incomplete. Record verified
equivalences in `classes.json` only after that review.
