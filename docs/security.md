# Security & Cryptography

Analysis of encryption, key management, and security posture in Transfermóvil v1.260416.

Source: `cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0` (smali)

## Manifest Security Flags

| Flag | Value | Risk |
|:---|:---|:---|
| `android:debuggable` | `true` | Attacker can attach debugger, inspect memory |
| `android:allowBackup` | `true` | Local backup exposes app data via `adb backup` |
| `android:usesCleartextTraffic` | `true` | HTTP allowed — traffic sniffable |

## CryptoProvider Inner Class

Registers Apache Harmony `SHA1PRNG` as security provider ("Crypto", v1.0). Used by `getRawKey()` for deterministic key generation from seed — not a real CSPRNG use, just ensures cross-device reproducibility of derived keys.

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
| `crude_code` (1024-char binary) | `rDEl7rW1aN` instance field | Binary lookup table for USSD parameter encoding |
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

The `code()` method (745 lines) uses a proprietary encoding for USSD parameters:

- **Encoder class:** `AFm1GraXBXUkpF1hmOdV.Tz34gww2TFwrsuT8ukpL`
- **Constructor:** `(code_version, crude_code)` — both hardcoded static values
- **Encoding method:** `aSHV52SplNh3HfZBSmJe(List<String> numbers)`
- Splits input on `*`, separates numeric from non-numeric (Nauta emails bypass encoding)
- Pads single-digit encoded results with leading "0"

This is obfuscation, not encryption — deterministic and reversible with the static constants from the APK.

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

## Accessibility Service Security

The USSD response capture service (`O7xyZJJBFWg`) auto-clicks any button labeled "ACEPTAR" on any USSD dialog from `com.android.phone` when `shouldListen=true`. No validation of dialog source content beyond string matching for "USSD", "si", "ok", or "aceptar". A malicious USSD push containing these keywords would be auto-dismissed.
