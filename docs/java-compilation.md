# Hybrid Java compiler audit

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

`scripts/compile-reconstruction.py` compiles every Java source under
`app/src/main/java` against a **local APK-derived bytecode jar** and a **local
Android platform jar**. This is a dependency-backed compiler audit: it detects
unresolved symbols, invalid signatures, type mismatches and other Java errors
in the reconstructed tree while retaining the APK's raw dependencies.
It is not a standalone Android build, an APK produced from clean source, a
resource-packaging test, behavioral equivalence, or runtime verification.

## Local prerequisites and provenance

- Python 3 and a JDK with `javac` on PATH. The initial audit used Temurin
  `javac 17.0.15`; the report records the actual version and command per run.
- The target APK remains local in `.workspace/bin/`.
- Pin dex2jar to **2.4**, using its official
  [v2.4 release](https://github.com/pxb1988/dex2jar/releases/tag/v2.4) and
  [dex-tools-v2.4.zip asset](https://github.com/pxb1988/dex2jar/releases/download/v2.4/dex-tools-v2.4.zip).
  The locally available distribution is `.workspace/tools/dex-tools-v2.4/`.
  The audit script does not download, install or invoke converters.
- The current local dependency jar is
  `.workspace/tools/target-bytecode.jar`; its local conversion log is
  `.workspace/tools/dex2jar.log`.
- The audited Android SDK platform is API 36, revision 2, extension level 17:
  `/Users/albertolicea00/Library/Android/sdk/platforms/android-36/android.jar`.
  This compile classpath does not change the target APK's min SDK 21 / target
  SDK 33 and does not prove compatibility on either platform level.

Local artifact fingerprints observed on 2026-11-13:

| Artifact | SHA-256 |
| --- | --- |
| `.workspace/tools/dex-tools-v2.4.zip` | `ee7c45eb3c1d2474a6145d8d447e651a736a22d9664b6d3d3be5a5a817dda23a` |
| `.workspace/tools/target-bytecode.jar` | `1889f1b436928ebb7859293617ffc2a98bf2831b425db2498c22a30b8e489dcf` |
| Android SDK API-36 `android.jar` | `d9eb9da824d9e247a352f570f01e1169e725b2954bca9e283a71786c59b59f9a` |

These are fingerprints of the available local artifacts, not independently
attested vendor checksums or proof that an arbitrary supplied jar originated
from this APK. Regenerating a jar can change archive metadata and its hash;
retain the conversion command, log, tool version and APK hash alongside it.
The documented invocation keeps binaries, compiler outputs and reports under
ignored `.workspace/`; a custom `--output` path remains the caller's choice.

If the conversion needs to be reproduced with the already available tool:

```sh
bash .workspace/tools/dex-tools-v2.4/d2j-dex2jar.sh \
  -f -o .workspace/tools/target-bytecode.jar \
  .workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk
```

This command replaces the local jar; retain an earlier audit's fingerprint
when comparing runs. A conversion warning/error is conversion evidence to
inspect, not an instruction to invent missing Java classes.

## Run the full audit

From the repository root:

```sh
python3 scripts/compile-reconstruction.py \
  --bytecode-jar .workspace/tools/target-bytecode.jar \
  --android-jar /Users/albertolicea00/Library/Android/sdk/platforms/android-36/android.jar \
  --apk .workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk
```

Elsewhere, supply the installed SDK's real `android.jar` path. Both jar
arguments are mandatory and validated as existing ZIP/JAR files. `--apk` is
optional fingerprint evidence; it is not used as a compiler classpath entry.
`--javac` selects an installed compiler, `--root` selects the repository,
`--output` selects a local report directory, and `--timeout` sets a positive
compiler timeout in seconds (default 300). No command is passed through a
shell, including paths with spaces.

The script performs these steps:

1. Collect every clean `.java` file and fingerprint the source inputs and
   dependency jars. All files are supplied in one compile invocation; this
   is not a selected-file smoke test.
2. Copy the actual target resource constants from
   `src/cu/etecsa/cubacel/tr/tm/R.java` into the run directory, changing only
   its package to `cu.etecsa.transfermovil`. This permits clean resource
   references without fabricated IDs or replacement Android/library stubs.
   Existing clean `R.java` with that package causes an explicit failure
   requiring review instead of silently compiling two definitions.
3. Create fresh per-run class output and a quoted source argument file.
   Earlier audit classes are never reused as dependencies. The Android
   platform jar precedes the target bytecode jar on the classpath.
4. Run `javac -proc:none -Xmaxerrs 10000 -Xmaxwarns 10000 -encoding UTF-8`
   with an empty source search path, the two explicit classpath jars and
   every clean source plus generated `R.java`. Annotation processing is
   disabled; diagnostics are requested in English for reproducible parsing.
5. Preserve the compiler output and parse file/line/severity/message/detail
   records. Fingerprint inputs again; a source-set, source-content or
   dependency change during compilation invalidates the run as
   `inputs_changed`, even if `javac` itself returned zero.

## Reports and result interpretation

The default output directory is `.workspace/compile-reconstruction/`:

| File/directory | Purpose |
| --- | --- |
| `report.json` | Latest result, command, tool version, source/dependency fingerprints, counts and `diagnostics_by_file`. |
| `javac.log` | Complete latest compiler output; inspect this if parsing or counts need review. |
| `run-*/report.json`, `run-*/javac.log` | Per-run evidence retained when the latest report is replaced. |
| `run-*/sources.txt` | Exact quoted source list passed to `javac`. |
| `run-*/generated/cu/etecsa/transfermovil/R.java` | Real target constants with the clean package declaration. |
| `run-*/classes/` | Compiler outputs for this run only; a failed run can contain partial output. |

`status` is `passed` only for compiler exit zero with stable inputs;
`failed`, `timeout`, and `inputs_changed` all return script exit status 1.
Invalid arguments or missing prerequisites fail before compilation.
A `passed` hybrid audit means this source set compiled with these supplied
binary dependencies. Raw implementations remain on the classpath, so it
does not establish a self-contained clean reconstruction or code provenance
for those dependencies. A passing run does not certify that new methods
match bytecode behavior or can execute under Android.

For failures, `diagnostics_by_file` contains each error/warning's source path,
line, primary message and following symbol/location/type details. Top-level
`error_diagnostics` and `error_files` count parsed compiler errors, not
independent defects: one missing base or wrong model type can cause many
cascading diagnostics. `global_errors` retains errors without a source-file
location. `diagnostics_may_be_capped` signals reaching the 10,000-error limit;
a timeout or other compiler termination can also make output incomplete.
Source/dependency changes are listed explicitly. `report.json` fingerprints
the source content present at the start, not a moving working-tree promise.

The first recorded full run on 2026-11-13 compiled **475 clean Java files plus
one generated resource source** and reported **563 errors in 50 files**,
with stable inputs and no reached error cap. That is a historical failure
snapshot, not a claim that those counts remain current after subsequent
repairs. Rerun the command and inspect the timestamped report after changes.

Passing isolated JVM comparisons in `make test-reconstruction` and this
hybrid compiler audit answer different questions. A future standalone
Android build still needs explicit dependency declarations, resource/manifest
processing, DEX/package construction, signing and supported-device tests;
real financial/carrier behavior remains outside this offline audit.

## Repaired-tree snapshot — 2026-11-13

The subsequent `compile-root10` local report compiles all **475 clean Java
files plus the real target R constants**, with **zero errors and 12 warnings**.
The inputs were stable. The warnings concern deprecated boxed-number
constructors; they were retained rather than changing source behavior during
integration repair. The isolated test suite has 29 passing tests, including
mocked USSD dispatch and smali-backed encoding, SMS and date-picker cases.
This is a dependency-backed compiler milestone, not a standalone source build
or a claim that every Android screen/backend workflow is complete.

## Latest tree snapshot — 2026-11-13

After restoring 12 landline/agent-recharge screens and replacing the Wallet
Boleto and session-menu adapters with clean typed models, `compile-root12`
compiled **488 clean Java files plus the real target R constants** with
`javac 17.0.15`, **zero errors and 12 warnings**. The APK, source and
dependency fingerprints remained stable during compilation. The warnings
remain deprecated boxed-number constructors. The report and full compiler log
are local under ignored `.workspace/compile-root12/`; they are not committed
build products.
