# Security & Cryptography

Analysis of encryption, key management, and security posture in Transfermóvil v1.260416.

Source: `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0` (smali)

## Manifest Security Flags

| Flag | Value | Risk |
|:---|:---|:---|
| `android:debuggable` | `true` | Attacker can attach debugger, inspect memory |
| `android:allowBackup` | `true` | Local backup exposes app data via `adb backup` |
| `android:usesCleartextTraffic` | `true` | HTTP allowed — traffic sniffable |

## Agent Activation Check

`GlobalState.isAGTelecom(context)` loads the stored agent activation code, app version, and phone number, then passes them to `ActivationCodeValidator`. The check is a deterministic digit-difference calculation; it selects the local agent mode but does not establish remote identity. Missing, empty, `-1`-containing codes and accessor or validator errors all return `false`.

## CryptoProvider Inner Class

Registers Apache Harmony `SHA1PRNG` as security provider ("Crypto", v1.0). Used by `getRawKey()` for deterministic key generation from seed — not a real CSPRNG use, just ensures cross-device reproducibility of derived keys.

The clean `crypto/CryptoProvider` is an implemented reconstruction linked to raw `V5FFEZ0Qrr0`, not an empty placeholder. Its renamed API covers seed-based AES, SecretKey AES/ECB, hardcoded and caller-key AES/CBC, card-data decryption, wallet encryption, SHA-256, and hex/Base64 helpers. The raw class remains in use by BFI QR and wallet/ticket screens for source-named methods such as `cH`, `shKey`, `toHex`, and `decryptMonedasWallet`; not every raw helper is a clean `CryptoProvider` call. No runtime parity claim is made for provider-specific edge cases because this audit was static.

## Encryption Schemes

### 1. Basic AES/ECB (seed-based)

Methods: `encrypt(seed, cleartext)`, `decrypt(seed, encrypted)`

- `getRawKey(seed)` → SHA1PRNG seeded → AES KeyGenerator → 128-bit key
- Cipher: **AES/ECB** (no IV, no mode specified = ECB default)
- Encoding: hex
- **Flaw**: ECB mode leaks patterns in structured data

### 2. AES/ECB with SecretKey

Methods: `encryptMsg(message, secret)`, `decryptMsg(cipherText, secret)`

- Cipher: `AES/ECB/PKCS5Padding`
- Encoding: Base64
- **Flaw**: ECB mode, same as above

### 3. AES/CBC with hardcoded key

Methods: `encryptAES(plainText)`, `decryptAES(encryptedText)` (single param)

- **Hardcoded key**: `"ABCDEFGHIJKLMNOP"` (16 bytes UTF-8)
- **IV = key bytes** (same 16 bytes reused)
- Cipher: `AES/CBC/PKCS5PADDING`
- Encoding: Base64
- **Flaws**: Hardcoded key trivially extractable; key reused as IV eliminates CBC's IV benefit

### 4. AES/CBC with caller-provided key/IV

Methods: `encryptAES(text, keyData, ivData)`, `decryptAES(text, keyData, ivData)` (string and byte[] overloads)

- Cipher: `AES/CBC/PKCS5PADDING`
- Encoding: Base64
- Security depends entirely on caller's key/IV management

### 5. Card Decryption (`cH` → `procesarDatos` → `decryptTarjeta`)

Entry point: `cH(data, a, b)` where `a` and `b` are likely bank reference + device ID.

Flow:
1. `k = a + b` (string concatenation)
2. `r = SHA-256(k.getBytes("UTF8"))` → 32 bytes
3. `password = r[0:16]`, `vector = r[16:32]`
4. `procesarDatos(data, password, vector)` with **hardcoded salt** `"1927271231"`
5. `decryptTarjeta`: custom key derivation (`DeriveKeyAndIv`) with **2 iterations**, 128-bit key
6. Cipher: `AES/CBC/NoPadding`
7. Result cleaned: `replaceAll("[^A-Za-z0-9 ]", "")`

**Flaws**:
- Hardcoded salt `"1927271231"`
- Only **2 iterations** in key derivation — negligible brute-force resistance
- Custom PBKDF (not standard PBKDF2) — `concat(dx, pass, salt)` → SHA-256, iterated

### 6. Wallet Encryption (`encryptIA` / `decryptMonedasWallet`)

Uses **standard PBKDF2WithHmacSHA1** via `javax.crypto.SecretKeyFactory`.

- `generateKeyAndIV(password, salt, iterations, keySize=128)`
- Cipher: `AES/CBC/PKCS5Padding`
- IV: random 16 bytes, **prepended** to ciphertext
- Encoding: Base64
- **Best scheme in the app** — uses proper PBKDF2 and random IV

### 7. Key Generation Helper

Method: `generateKey(ky)` — SHA-256 of input string → SecretKeySpec for AES.

### 8. SHA-256 Utility

Methods: `shKey(String)`, `shKey(byte[])`, `getSha256(data)` — straightforward SHA-256 hashing.

## Hardcoded Secrets

| Value | Location | Usage |
|:---|:---|:---|
| `"ABCDEFGHIJKLMNOP"` | `encryptionKey` field | AES key for single-param encrypt/decrypt |
| `"708091521823824654864548452244"` | `rDEl7rW1aN.cv` (static) | Key material for `generateKey()` → AES SecretKey |
| `"372653282298718711"` | `rDEl7rW1aN.code_version` (static) | USSD code encoder version identifier |
| `crude_code` (1250-char binary) | `rDEl7rW1aN` instance field | Binary lookup table for USSD parameter encoding |
| `"1927271231"` | `procesarDatos`, `validarLLaveDerivada` | Salt for card decryption |
| `"12345678"` | `cH`, `validarLLaveDerivada` | `tfmid` — likely device/app identifier |
| `"Referencia001delbanco3"` | `validarLLaveDerivada` | Test bank reference |

## Key Derivation Summary

| Scheme | Algorithm | Iterations | Used By |
|:---|:---|:---|:---|
| SHA1PRNG seed | Apache Harmony SHA1PRNG | N/A | `getRawKey` → basic encrypt/decrypt |
| Custom PBKDF | SHA-256 concat+hash | **2** | `DeriveKeyAndIv` → card operations |
| PBKDF2 | PBKDF2WithHmacSHA1 | caller-specified | `generateKeyAndIV` → wallet operations |
| Direct SHA-256 | SHA-256 | 1 | `shKey` → `cH` card helper |

## Hex/Base64 Encoding

- Basic encrypt/decrypt: hex encoding (`toHex`/`toByte`)
- All AES/CBC variants: Base64 encoding
- ECB with SecretKey: Base64 with `NO_WRAP` flag

## Security Assessment

**Critical**:
- Hardcoded AES key `"ABCDEFGHIJKLMNOP"` — any data encrypted with single-param `encryptAES`/`decryptAES` is recoverable by anyone with the APK
- **Bank PINs stored in plaintext** — `BancoService` table has `pbpa`, `pmetro`, `pbandec` columns (BPA, Metropolitano, BANDEC bank PINs) as plain strings in SQLite
- ECB mode usage leaks plaintext structure
- `debuggable=true` in production APK
- Hardcoded encryption key `"708091521823824654864548452244"` in `rDEl7rW1aN.cv` — used for AES/ECB encryption of stored data

**High**:
- Hardcoded salt `"1927271231"` with only 2 iterations — card encryption key derivation trivially brute-forceable
- Key reused as IV in hardcoded-key AES/CBC
- `allowBackup=true` — all app data extractable via ADB (combined with plaintext PINs = full credential theft)
- `Pin` table stores recharge card PINs — also in `TransferMDB.sqlite`
- IMEI stored in `AppConfig` table — device fingerprinting data in local DB

**Medium**:
- `usesCleartextTraffic=true` — HTTP connections allowed
- Custom PBKDF instead of standard PBKDF2 in card operations
- Apache Harmony SHA1PRNG — deterministic, not cryptographically random when seeded

**Low / Positive**:
- Wallet operations use proper PBKDF2WithHmacSHA1 + random IV
- Certificate pinning evidence in OkHttp configuration

## Encryption Usage in `rDEl7rW1aN`

The main activity base class uses scheme 7 (`generateKey`) with the static `cv` field:

```
encryption(plaintext):
  key = V5FFEZ0Qrr0.generateKey("708091521823824654864548452244")
  return V5FFEZ0Qrr0.encryptMsg(plaintext, key)

decryption(ciphertext):
  key = V5FFEZ0Qrr0.generateKey("708091521823824654864548452244")
  return V5FFEZ0Qrr0.decryptMsg(ciphertext, key)
```

This chains schemes 7 → 2: SHA-256 of `cv` → AES/ECB/PKCS5Padding with Base64 encoding. Both the key material and algorithm are fully deterministic and extractable.

## USSD Code Encoding

The `code()` method uses a proprietary two-stage numeric cipher for USSD parameters.

### Architecture (4 classes in `AFm1GraXBXUkpF1hmOdV`)

| Class | Role |
|:---|:---|
| `Tz34gww2TFwrsuT8ukpL` | Orchestrator — random seed + delegates |
| `YzK9tTZsYVnC5kFxSie` | Lookup table builder — parses `crude_code` into substitution matrix |
| `hKRRh7lnIpNaVleqsuo` | Digit-pair substitution via matrix |
| `ytpPfHi93O3gQEyZrT9r` | XOR step — substituted value ⊕ cyclic key from matrix |

### Encoding flow

1. Parse `crude_code` (1250-char binary string) using cyclic `code_version` digits: skip `d` bits, consume the following eight bits as an integer, then repeat. The target constants produce a 100-entry permutation of integers 0–99; restart the version index after its final digit.
2. Generate random seed 0-99 per encoding instance
3. For each numeric parameter:
   - **Stage 1 — Substitution**: take digit pairs (2 chars), look up combined 2-digit number in substitution list → replacement value
   - **Stage 2 — XOR**: build cyclic key stream from matrix, XOR substituted value (as long) with key (as long) via `xor-long/2addr`
4. Prefix the output with the two-digit random seed and prefix each field with its original length padded to at least two digits. Separate subsequent length/value fields with `*`.
5. Non-numeric strings (Nauta emails) use the character-dictionary path (`kR22DOzTiB.getCodes()`); all-nonnumeric input replaces the random seed prefix with `00`.

### Bytecode correction and verification

JADX loses the offset-index reset in
`AFm1GraXBXUkpF1hmOdV/YzK9tTZsYVnC5kFxSie.smali`, method
`aSHV52SplNh3HfZBSmJe(Ljava/lang/String;)V`. After the final version digit,
bytecode branches to `:goto_0`, which sets `v3` to zero. The raw Java and the
previous clean implementation held the final index instead, leaving a six-bit
tail and throwing during ordinary numeric encoding. `SubstitutionTableBuilder`
now cycles the index as the bytecode does. Tracked JADX output stays unchanged.

The encoder JVM oracle repairs precisely that missing reset in a temporary raw
helper. It verifies the full substitution permutation and seven fixed seed-42
vectors, then compares 49 input cases at every seed 0–99: 4,607 successful output
comparisons and 300 expected malformed-input exception comparisons overall.
This replaces the prior fixed-seed check, whose matches were exceptions and did
not establish valid request encoding. It also exposes and fixes a clean
assembler bug: `1*0` at seed 42 must produce `42013*011`, including the separator.
These checks exercise reconstructed algorithms, not the carrier gateway.

### Assessment

This is **obfuscation, not encryption** — fully deterministic and reversible with the static constants from the APK. The random seed (0-99) provides minimal per-session variation. The `code_version` and `crude_code` are effectively a shared secret between client and ETECSA's USSD gateway.

## Database Entities (ORMLite)

### BancoService

| Field | Type | Notes |
|:---|:---|:---|
| `id` | int | Auto-generated primary key |
| `code` | String | Bank service code |
| `phone` | String | Associated phone number |
| `pmetro` | String | **Metropolitano bank password (plaintext)** |
| `pbpa` | String | **BPA bank password (plaintext)** |
| `pbandec` | String | **BANDEC bank password (plaintext)** |

### AgentService

| Field | Type | Notes |
|:---|:---|:---|
| `id` | int | Auto-generated primary key |
| `code` | String | Agent service code |
| `phone` | String | Agent phone number |

> Bank PINs for three banks stored as unencrypted strings. With `debuggable=true` + `allowBackup=true`, full credential extraction is trivial via ADB.

## Exported Components Audit

4 components declared `android:exported="true"` in manifest:

| Component | Type | Protection | Risk |
|:---|:---|:---|:---|
| `X9ZiE8XZNKy` | BroadcastReceiver (SMS) | `BROADCAST_SMS` permission | Low — system-protected |
| `O7xyZJJBFWg` | AccessibilityService | `BIND_ACCESSIBILITY_SERVICE` | Low — system-protected |
| `prPzLeyxKk` | Activity (launcher) | None (standard launcher) | None |
| `S9ycHcoxAzy` | Activity (deep links) | None | **High** |

### Deep Link Handler (`S9ycHcoxAzy`)

Handles `ACTION_VIEW` (http/https/transfermovil schemes) and `ACTION_SEND` (text/plain).

**Attack surface**: any app can send an intent with crafted payment parameters:
- `id_transaccion` — transaction ID
- `importe` — payment amount
- `numero_proveedor` — provider number
- `moneda` — currency
- `descripcion` — description

These params are parsed from URI query parameters, assembled into a JSON object, and passed directly to `enviarDatos()` → payment fragment (`r7Rinp9ooL` for banks, `s9CT6pjRyD` for MiTransfer). No origin validation, no input sanitization on amount/provider, no confirmation of intent source. User still selects bank from dialog, but pre-filled values could mislead.

**Exploitation**: malicious app sends `Intent(ACTION_VIEW, "transfermovil://pay?id_transaccion=X&importe=99999&numero_proveedor=ATTACKER&moneda=CUP")` → TM opens payment screen with attacker-controlled amount/destination pre-populated.

## FileProvider Configuration

Path config in `app/res/xml/provider_paths.xml`:

```xml
<cache-path name="cache" path="/" />
<files-path name="files" path="/" />
<external-files-path name="files" path="." />
<external-path name="external" path="." />
<external-files-path name="external_files" path="." />
<files-path name="files" path="." />
```

**Issue**: exposes entire cache, internal files, and external storage directories via content URIs. Any component that generates a `content://` URI from this provider grants read access to the full app sandbox. Combined with `allowBackup=true`, the entire local data store is accessible.

## SharedPreferences Audit

### E-Commerce Module (`SESSION_SHARE_DATA`, mode=MODE_PRIVATE)

Stored in `UhA7J2923N` singleton, all plaintext:

| Key | Content | Risk |
|:---|:---|:---|
| `ACCESS_TOKEN` | Bearer auth token | Session hijack if backed up |
| `CSRF_TOKEN` | XSRF token | CSRF bypass |
| `TOKEN_TYPE` | Token type string | Low |
| `API_URL` | Dynamic base URL | API redirect if tampered |
| `USER_NAME` | E-commerce username | PII exposure |
| `USER_ID` | E-commerce user ID | PII exposure |
| `USER_ROL` | User role string | Privilege escalation if tampered |
| `GRANTS` | Permission grants | Privilege escalation if tampered |
| `PREF_ACCOUNT` | Account preference | Low |
| `PREF_CURRENCY` | Currency preference | Low |

MODE_PRIVATE provides app-level isolation, but `allowBackup=true` + `debuggable=true` means all prefs extractable via `adb backup`. Auth tokens, CSRF tokens, and user role stored without encryption.

### Main App SharedPreferences

Main banking module stores sensitive data primarily in ORMLite SQLite (see Database Entities above). SharedPreferences in fragments used for UI state: `returning`, `newEstaditica`, `modulo`, `operacion`, `servicio` — navigation/UI keys, not credentials. Bank PINs go to `BancoService` SQLite table instead.

### No Root/Emulator Detection

No calls to `su`, `/system/xbin/su`, `test-keys`, `Build.FINGERPRINT` checks, `Superuser.apk`, or emulator property checks found in any decompiled source. Banking app with plaintext credentials and no runtime integrity checks.

## Accessibility Service Security

The USSD response capture service (`O7xyZJJBFWg`) auto-clicks any button labeled "ACEPTAR" on any USSD dialog from `com.android.phone` when `shouldListen=true`. No validation of dialog source content beyond string matching for "USSD", "si", "ok", or "aceptar". A malicious USSD push containing these keywords would be auto-dismissed.
