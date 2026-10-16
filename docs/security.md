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
- ECB mode usage leaks plaintext structure
- `debuggable=true` in production APK

**High**:
- Hardcoded salt `"1927271231"` with only 2 iterations — card encryption key derivation trivially brute-forceable
- Key reused as IV in hardcoded-key AES/CBC
- `allowBackup=true` — all app data extractable via ADB

**Medium**:
- `usesCleartextTraffic=true` — HTTP connections allowed
- Custom PBKDF instead of standard PBKDF2 in card operations
- Apache Harmony SHA1PRNG — deterministic, not cryptographically random when seeded

**Low / Positive**:
- Wallet operations use proper PBKDF2WithHmacSHA1 + random IV
- Certificate pinning evidence in OkHttp configuration
