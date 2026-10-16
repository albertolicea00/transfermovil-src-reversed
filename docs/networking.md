# Networking and Storage

Analysis of network clients, endpoints, TLS configuration, and local persistence in Transfermóvil v1.260416.

## Network Stack

| Component | Details |
|:---|:---|
| HTTP client | OkHttp 4.2.2 |
| Protocol support | HTTP/2 (Huffman, HPACK, frame handling present) |
| Cleartext traffic | Allowed (`usesCleartextTraffic=true` in manifest) |

### TLS / Certificate Handling

String evidence from binary:

- `tlsVersions=` — TLS version configuration
- `Pinned certificates for` — **certificate pinning** is implemented
- `Peer certificate chain:` — certificate chain inspection
- `certificates` — general cert handling
- `getSslSocketFactoryOrNull$okhttp` — SSL socket factory access
- `getX509TrustManagerOrNull$okhttp` — trust manager access
- `ConnectionSpec$Builder` — OkHttp connection spec customization

> **Hypothesis:** The app likely pins specific certificates for its backend connections. The `ConnectionSpec.Builder` usage suggests custom TLS configuration beyond defaults. Requires decompiled code to identify pinned certificates and whether pinning can be bypassed (relevant for interception analysis).

## Known URLs

### ETECSA / Official

| URL | Purpose |
|:---|:---|
| `http://www.etecsa.cu/descargas/transfermovil/?d=` | APK download (with parameter) |
| `https://www.etecsa.cu/aplicaciones/transfermovil` | App information page |
| `https://www.etecsa.cu/sites/default/files/aplicaciones/transfermovil_0.apk` | Direct APK download |
| `https://www.apklis.cu/application/cu.etecsa.cubacel.tr.tm` | APKlis store listing |

### E-commerce

| URL | Purpose |
|:---|:---|
| `https://miboleto.mibulevar.com` | MiBulevar e-commerce/ticket platform |

### External / Government

| URL | Purpose |
|:---|:---|
| `https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales` | OFA heritage cities (terms & conditions) |

### Legacy

| URL | Purpose |
|:---|:---|
| `https://plus.google.com/` | Google+ (defunct, likely legacy code) |

### REST API Endpoints (E-commerce Backend)

Found as plaintext paths in the DEX. The base URL is not in plaintext — likely assembled in obfuscated code.

**User Management:**

| Endpoint | Method (inferred) | Purpose |
|:---|:---|:---|
| `/api/user/current` | GET | Current user info |
| `/api/user/get` | GET | Get user by ID |
| `/api/user/store` | POST | Create user |
| `/api/user/update` | PUT/PATCH | Update user |
| `/api/user/destroy` | DELETE | Delete user |
| `/api/user/banned` | GET/POST | Ban status |
| `/api/user/sources` | GET | User payment sources |

**Profile:**

| Endpoint | Purpose |
|:---|:---|
| `/api/profile/update` | Update profile |
| `/api/profile/password` | Change password |

**Business (Agent/Merchant):**

| Endpoint | Purpose |
|:---|:---|
| `/api/business/getBusiness` | Get business info |
| `/api/business/getData` | Get business data |
| `/api/business/gethashtag` | Get business hashtag |
| `/api/business/storeBusiness` | Create business |
| `/api/business/updateBusiness` | Update business |
| `/api/business/deleteBusiness` | Delete business |

**Payments:**

| Endpoint | Purpose |
|:---|:---|
| `/api/payment/store` | Process payment |
| `/api/payment/analisis` | Payment analysis/report |
| `/api/payment/sumOfsales` | Sales summary |
| `/api/payment_refunds/list` | List refunds |
| `/api/refunds/store` | Process refund |
| `/api/refunds/analisis` | Refund analysis |

**Payment Sources:**

| Endpoint | Purpose |
|:---|:---|
| `/api/source/storeSource` | Add payment source |
| `/api/source/updateSource` | Update payment source |
| `/api/source/deleteSource` | Delete payment source |
| `/api/source/activarSource` | Activate source |
| `/api/source/desactivarSource` | Deactivate source |

**Child Users (Sub-accounts):**

| Endpoint | Purpose |
|:---|:---|
| `/api/childusers/list` | List sub-users |
| `/api/childusers/grants` | Get permissions |
| `/api/childusers/update/grants` | Update permissions |

**Roles:**

| Endpoint | Purpose |
|:---|:---|
| `/api/roles/childgrants` | Get child role grants |

**Home/Dashboard:**

| Endpoint | Purpose |
|:---|:---|
| `/api/home/getmonto` | Get balance/amount |
| `/api/home/pagoDiario` | Daily payments summary |
| `/api/home/Devoluciongetdata` | Refund data |

> **Note:** These endpoints belong to the e-commerce (Bulevar/MiBulevar) subsystem, not the USSD banking backend. The USSD banking operations use `tel:*222` intents and SMS, not HTTP APIs. The base URL for these APIs is likely `https://miboleto.mibulevar.com` based on the only non-ETECSA domain found. The `@nauta.co.cu` domain reference suggests Nauta email integration for account-related features.

## Authentication Tokens

String identifiers found:

| Token | Context |
|:---|:---|
| `ACCESS_TOKEN` | Primary access token |
| `access_token` | Same, lowercase variant |
| `X-XSRF-TOKEN` | CSRF protection header |
| `sessionToken` | Session management |
| `LOGIN_SIMPLE` | Simple login type |
| `loginRequest` | Login request object |
| `getLoginJSON` | JSON login payload |
| `loadDataAuth` | Auth data loading |
| `validateAuth` | Auth validation |
| `frmAuthBanco` | Bank authentication form |
| `frmAuthBolsa` | Wallet/bolsa authentication form |

> **Hypothesis:** The app uses a token-based auth system with CSRF protection. There appear to be separate auth flows for banking (`frmAuthBanco`) and the MiTransfer wallet (`frmAuthBolsa`), suggesting different backend services or at least different auth scopes.

## Local Persistence

### SQLite via ORMLite

The app uses ORMLite ORM for local database storage. String evidence:

- `Getting a writable database from helper` — ORMLite helper pattern
- `queryForOne from database failed:` — query operations
- `queryForLong from database failed:` — long/count queries
- `DatabaseField`, `DatabaseTable` annotations — ORM entity definitions

**Known entities (from smali analysis):**

| Entity Class | Table Fields | Notes |
|:---|:---|:---|
| `BancoService` | `id`, `code`, `phone`, `pmetro`, `pbpa`, `pbandec` | **Stores bank PINs in plaintext** per bank |
| `AgentService` | `id`, `code`, `phone` | Agent credentials |
| `AppConfig` | `codigo` (at minimum) | App configuration, access code for USSD |
| `CodigoAcceso` | (from migration strings) | Access code storage |

> **Security finding:** Bank PINs stored as plaintext strings in local SQLite database. Combined with `allowBackup=true` and `debuggable=true`, any device with USB debugging or ADB backup can extract all stored bank PINs. See [crypto.md](crypto.md) for full security analysis.

**Stored data includes:** operation history, cached account info, saved contacts/phone numbers, app configuration, **bank PINs (plaintext)**, agent codes.

### SharedPreferences

| Key | Purpose |
|:---|:---|
| `PREF_ACCOUNT` | Saved account reference |
| `PREF_CURRENCY` | Currency preference |

### File Provider

Exposes broad file paths for sharing:

```
cache/   → app cache directory
files/   → internal files directory
external → external storage root
```

> **Security note:** The provider_paths.xml exposes the entire external storage root and cache directory. Combined with `allowBackup=true`, this maximizes data extractability.

## Permissions Summary (Network/Storage Related)

| Permission | Purpose |
|:---|:---|
| `INTERNET` | Network access |
| `ACCESS_NETWORK_STATE` | Check connectivity |
| `READ_EXTERNAL_STORAGE` | Read files (pre-API 33) |
| `WRITE_EXTERNAL_STORAGE` | Write files (max SDK 28) |
| `MANAGE_EXTERNAL_STORAGE` | Broad file access (API 30+) |
| `READ_MEDIA_IMAGES` | Image access (API 33+) |
| `READ_MEDIA_VISUAL_USER_SELECTED` | Photo picker (API 34+) |
| `REQUEST_INSTALL_PACKAGES` | Self-update / APK installation |
| `CAMERA` | QR/barcode scanning |
| `READ_CONTACTS` | Contact lookup for transfers |
| `RECEIVE_BOOT_COMPLETED` | Start on boot (likely for scheduled checks) |
| `VIBRATE` | Notification feedback |

## Open Questions

1. **API endpoints:** Where are the backend server URLs defined? Likely in obfuscated code constants.
2. **Certificate pins:** Which certificates are pinned, and for which hosts?
3. **Request format:** What does a typical banking API request look like (headers, body, auth)?
4. **Database schema:** What tables does the ORMLite database define?
5. **Self-update mechanism:** How does `REQUEST_INSTALL_PACKAGES` work — does the app download APKs from `etecsa.cu` and install them?
6. **Nauta integration:** How does `@nauta.co.cu` / `ExportNautas` relate to the auth or account system?
