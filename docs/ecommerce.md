# E-Commerce Module (Bulevar)

Analysis of the e-commerce subsystem in `cu.etecsa.tm.ecommerce` package.

## Architecture

- **Application class**: `UhA7J2923N` (custom `Application` subclass)
- **API client**: `y6NQQxH0NI` (singleton, OkHttp-based)
- **Base URL**: dynamic, stored in SharedPreferences (`API_URL` key in `SESSION_SHARE_DATA`)
- **Login endpoints**: `/loginapk` (email+password), `/loginfactorapk` (email+password+2FA factor)

## API Client (`y6NQQxH0NI`)

Singleton with 4 `processPOST` overloads:

| Overload | Auth | CSRF |
|:---|:---|:---|
| `processPOST(path, params)` | None | No |
| `processPOST(path, csrf, params)` | None | `X-XSRF-TOKEN` header |
| `processPOST(path, params, key)` | `Authorization` header | No |
| `processPOST(path, key)` | `Authorization` header | No |

Content type: `application/json` via Gson serialization.

### TLS Configuration

**`getUnsafeOkHttpClient()`** — **completely disables TLS verification**:
- Custom `X509TrustManager` with empty `checkServerTrusted()` → trusts ALL certificates
- `HostnameVerifier` returns `true` always → no hostname checking
- `SSLContext.getInstance("SSL")` initialized with trust-all manager

> **Critical security finding**: The e-commerce module is vulnerable to trivial MITM attacks. Any network intermediary can intercept and modify all API traffic including login credentials, payment data, and session tokens.

## Authentication

### Login Request (`XMAvvl35Dj`)
```json
POST /loginapk
{"email": "...", "password": "..."}
```

### 2FA Login Request (`L9hiDpmAir`)
```json
POST /loginfactorapk
{"email": "...", "password": "...", "factor": 123456}
```

### Login Response States (`q0H70da5TFZ` enum)
- `LOGINOK` — successful, token returned
- `LOGIN_SIN_TOKEN` — login without token (needs CSRF flow?)

### Session Data (SharedPreferences)

| Key | Purpose |
|:---|:---|
| `ACCESS_TOKEN` | Bearer token |
| `TOKEN_TYPE` | Token type (e.g., "Bearer") |
| `CSRF_TOKEN` | XSRF token for protected endpoints |
| `API_URL` | Dynamic base URL |
| `USER_ID` | Current user ID |
| `USER_NAME` | Current username |
| `USER_ROL` | User role |
| `GRANTS` | Permissions |
| `PREF_ACCOUNT` | Saved account |
| `PREF_CURRENCY` | Currency preference |
| `COMPACT_MODE` | UI preference |
| `COMUNICATION_MODE` | Communication preference |
| `HASHTAG_DEFAULT` | Default hashtag |
| `CHANGE_PHOTO_HOME` | Photo change flag |

## API Endpoints (33 confirmed from Java source)

### Authentication
| Endpoint | Method |
|:---|:---|
| `/loginapk` | Login with email/password |
| `/loginfactorapk` | Login with 2FA |

### User Management
| Endpoint | Purpose |
|:---|:---|
| `/api/user/current` | Get current user |
| `/api/user/get` | Get user by criteria |
| `/api/user/store` | Create user |
| `/api/user/update` | Update user |
| `/api/user/destroy` | Delete user |
| `/api/user/banned` | Ban user |
| `/api/user/sources` | User payment sources |

### Profile
| Endpoint | Purpose |
|:---|:---|
| `/api/profile/update` | Update profile |
| `/api/profile/password` | Change password |

### Business
| Endpoint | Purpose |
|:---|:---|
| `/api/business/getData` | Get business data |
| `/api/business/getBusiness` | Get business details |
| `/api/business/storeBusiness` | Create business |
| `/api/business/updateBusiness` | Update business |
| `/api/business/deleteBusiness` | Delete business |
| `/api/business/gethashtag` | Get business hashtag |

### Payments
| Endpoint | Purpose |
|:---|:---|
| `/api/payment/store` | Process payment |
| `/api/payment/analisis` | Payment analysis |
| `/api/payment/sumOfsales` | Sales summary |
| `/api/payment_refunds/list` | List refunds |

### Refunds
| Endpoint | Purpose |
|:---|:---|
| `/api/refunds/store` | Process refund |
| `/api/refunds/analisis` | Refund analysis |

### Payment Sources
| Endpoint | Purpose |
|:---|:---|
| `/api/source/storeSource` | Add source |
| `/api/source/updateSource` | Update source |
| `/api/source/deleteSource` | Delete source |
| `/api/source/activarSource` | Activate source |
| `/api/source/desactivarSource` | Deactivate source |

### Child Users
| Endpoint | Purpose |
|:---|:---|
| `/api/childusers/list` | List sub-users |
| `/api/childusers/grants` | Get permissions |
| `/api/childusers/update/grants` | Update permissions |

### Roles
| Endpoint | Purpose |
|:---|:---|
| `/api/roles/childgrants` | Get child role grants |

### Dashboard
| Endpoint | Purpose |
|:---|:---|
| `/api/home/getmonto` | Get balance |
| `/api/home/pagoDiario` | Daily payments |
| `/api/home/Devoluciongetdata` | Refund data |

## Service Layer Classes

| Package | Purpose |
|:---|:---|
| `Dyporpu9vbM/JAl9AlHrnbt` | Repository implementations (API calls) |
| `Dyporpu9vbM/QaHUruvdVUN` | Repository interfaces |
| `Dyporpu9vbM/tQvDIr4mUHh` | API client and HTTP infrastructure |
| `UE0rwmdgIVT/AfjNivq1ga0` | Request/response models |
| `LaIvmOMkyve` | UI activities and fragments |
| `I3ki0FxWzgdY` | Enums and constants |

## Security Assessment

**Critical**:
- TLS completely disabled via `getUnsafeOkHttpClient()` — trivial MITM
- Login credentials (`email`/`password`) sent over potentially interceptable connection
- Access tokens stored in plaintext SharedPreferences

**High**:
- Dynamic `API_URL` from SharedPreferences could be tampered with (combined with `allowBackup=true`)
- No certificate pinning in e-commerce module (despite main app having OkHttp cert pinning)
