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

The clean `ecommerce/ApiClient` implements the singleton, the four JSON POST
variants, authenticated PUT/GET, synchronous response bridge, cookie/CSRF
handling, the unsafe TLS client, and the reachable PNG/base64 conversion
helper. It is a partial reconstruction rather than a stub. The source also
exposes multipart `processPUTImage` overloads, `processPOSTImage`, URI
normalization, and a bitmap-to-file writer; they have no Java callers in the
checked tree and are not included in the clean client.

### TLS Configuration

**`getUnsafeOkHttpClient()`** — **completely disables TLS verification**:
- Custom `X509TrustManager` with empty `checkServerTrusted()` → trusts ALL certificates
- `HostnameVerifier` returns `true` always → no hostname checking
- `SSLContext.getInstance("SSL")` initialized with trust-all manager

> **Critical security finding**: The e-commerce module is vulnerable to trivial MITM attacks. Any network intermediary can intercept and modify all API traffic including login credentials, payment data, and session tokens.

## Authentication

### Entry and startup routing

Both main activities (`IHVTCBmiLV` for agent mode and `S9ycHcoxAzy` for general
mode) handle the drawer item `R.id.bulevar` by starting the e-commerce activity
`a7Y4bbw8Os`. The clean Agent/General activities route that item to the migrated
`LoginActivity` equivalent. The login activity sets the Bulevar layout, configures its progress
indicator and retry button, then invokes its startup presenter. If connectivity
is absent, it hides the progress views, shows the retry button, and displays a
Spanish connection dialog. With connectivity, it calls `iniApp()`.

The startup presenter initializes the API URL and default currency (`CUP`) only
when the URL is empty, then routes from the stored access token: no token gives
`LOGIN_SIN_TOKEN` and starts `C1b1PWKeZSE` (the credential login activity); a
token gives `LOGINOK` and starts `hd5jZHAGaN` (the authenticated home activity).
The `NOCSRF` and `ERROR` results do not start a destination. The agent operation
menu builder can also expose a `Bulevar de Transfermóvil` operation when its
bank-code condition passes, but the drawer route above is the direct launch path
for both app modes. The clean `LoginActivity` and clean Agent/General activity
classes now contain reconstructed bodies, though their imports still depend on
the retained JADX module classes. This path has no Android runtime verification.

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

The clean `ecommerce/SessionManager` implements persistence for the session
and preference keys, numeric grant checks, asset loading, and a session-expiry
dialog. Its expiry action now clears the access token, starts clean
`LoginActivity`, and resets the task stack like raw `UhA7J2923N` starts
`a7Y4bbw8Os`. The source also has message/log helpers, typed error-message
dispatch, and enum-based permission checking. Clean equivalents are split
across `MessageHandler` and `SessionManager`; their exact message/log and
permission parity is tracked below. `SessionManager.hasPermission(int)` now
matches `UhA7J2923N.checkUserPermission(enum)`: numeric grant IDs match the
enum values (including `VER_ESTADISTICA=1000` and `VER_GRUPO_ENTIDAD=1001`),
empty or malformed entries are ignored, and a null grant string throws during
`split` in both implementations.

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

### Business management flow

The Bulevar account screen (`RjBvMOuknd`) opens `nCeySAq4vz` to create, rename, or delete a business. The dialog hides create/update/delete controls unless the session has `GESTIONAR_NEGOCIO`; create and update require a nonblank description and show a confirmation before returning their action and data to the screen. Create/update requests contain `descriptionBusiness`; delete sends `id`. The presenter calls `/api/business/storeBusiness`, `/api/business/updateBusiness`, or `/api/business/deleteBusiness`, then refreshes the list after success. This is business-profile CRUD from the client UI, not a separate merchant onboarding/KYC flow. Evidence: `RjBvMOuknd`, `nCeySAq4vz`, `WpYPbPBxxh`, and `tgXzViKJOK`.

### Payments
| Endpoint | Purpose |
|:---|:---|
| `/api/payment/store` | Process payment |
| `/api/payment/analisis` | Payment analysis |
| `/api/payment/sumOfsales` | Sales summary |
| `/api/payment_refunds/list` | List refunds |

The seller screen `H9l22AIYKkA` requires a selected payment source and a nonempty amount. It sends `Ph6mQUZRw4` with `amount` (the keypad formats integer digits as a decimal amount), `description`, and `sources` (the selected source ID) through `iHni1rlkwr` to `/api/payment/store`. On HTTP 200, the client requires a response `code` containing `Ok`, parses the `qr` JSON into transaction ID, amount, currency, and provider number, and sets QR version `5`. It renders a QR and shareable deep link, then checks the transaction by payment code using polling or a provider listener depending on WebSocket configuration. Amount validation checks only that the entry is nonempty; there is no positive minimum in the screen. Evidence: `H9l22AIYKkA`, `iHni1rlkwr`, `ruM2FlC2jP`, `g7q75bsZ7U4`, and `IIvRN9WfE5`. The source proves client flow, not settlement behavior.

### Image upload and profile-photo paths

The reachable profile and child-user presenters call `convertImageToSend`; the clean `ApiClient` uses the same conversion helper, which decodes source bounds, asks Glide for half-width/half-height, compresses PNG at quality `50`, and serializes a `data:image/png;base64,` URI without line wrapping. Clean `ProfilePresenter` implements current-profile, profile-update, and password operations using confirmed routes and converts a nonempty photo path before update. It maps the response's `user` identity fields and photo URL; profile-region resolution and the clean profile screen remain pending. `ApiClient` and `ChildUserPresenter` expose list, detail, create, update, delete, and status operations for `/api/childusers/list`, `/api/user/get`, `/api/user/store`, `/api/user/update`, `/api/user/destroy`, and `/api/user/banned`; create/update prepare a nonempty nested photo before dispatch. The presenter maps `dt.rows` into `ChildUser` and detail `user` into `UserWithRolesResponse.User`. Its callback separates typed list/detail results from mutation results. Mutation success requires HTTP 200 and response `code` containing `Ok`, as in the source parser. Child-user detail resolution queries the main database province/municipality tables, maps matched entries to e-commerce region models, and handles four-digit and suffix municipality codes following the source repository. Request exceptions now become HTTP-500-style failures delivered through the same typed callback, and a detached/missing callback is tolerated; the actual clean UI hookup remains pending. This lookup requires `DatabaseHelper.init()` to have run. Evidence: `PWf5TMuFy2`, `MNdSLKzqqG`, `BpB71R2rG8`, `ldmbl4HatR`, `e26lZ6zHsTP`, and `y6NQQxH0NI`.

The same raw API client has three multipart helpers (`processPUTImage` overloads and `processPOSTImage`) that resize a file to half its original dimensions, write a shared `newthub.jpg` at JPEG quality `50`, then send a multipart body with a hardcoded `Content-Type` boundary. No Java call sites for those multipart helpers were found in the checked `src/` tree, so no endpoint or caller is identified and the overloads were not ported. Whether the header boundary matches the builder-generated body remains unconfirmed. `normalizeImageForUri`, its EXIF rotation helper, and the private URI-to-file bitmap writer likewise have no Java call sites found and were not ported.

### Refunds
| Endpoint | Purpose |
|:---|:---|
| `/api/refunds/store` | Process refund |
| `/api/refunds/analisis` | Refund analysis |

In the payment list, choosing a purchase opens `isiTmFZ2lx` with the original payment details. The refund form requires a nonempty amount that parses as a float and is no greater than the purchase amount, plus a nonempty description. It then posts a `FhtwnBtOAx` request to `/api/refunds/store`; JSON fields are `pago` (original `payment_code`, `external_code`, and integer `source`), `amont` (spelling as serialized), and `description`. The client does not enforce a positive minimum amount. A successful HTTP 200 response is treated as success when `code` contains `Ok`; optional `refund` text is shown to the user. Other codes map through the refund error catalog. Evidence: `nz5e9USlvI`, `isiTmFZ2lx`, `FhtwnBtOAx`, `eLrApWcG9O`, and `z5jDbHBKvX`. Server acceptance and transaction effects are not verified.

### Payment Sources
| Endpoint | Purpose |
|:---|:---|
| `/api/source/storeSource` | Add source |
| `/api/source/updateSource` | Update source |
| `/api/source/deleteSource` | Delete source |
| `/api/source/activarSource` | Activate source |
| `/api/source/desactivarSource` | Deactivate source |

The business-account screen opens `p0cxg0PRR2` to toggle a payment source's state and asks for confirmation before returning `estado` plus the source value. Presenter `HLAV6HkYgi` passes that boolean and source to `N4F6dxO3TC.estadoCuenta`; `true` posts a request containing `source` to `/api/source/activarSource`, and `false` posts to `/api/source/desactivarSource`. On HTTP 200 the use case expects JSON `code` containing `Ok`; the screen refreshes its account list on success. This establishes the client request and response handling, not server-side effects. The clean source manager currently has request/model scaffolding but no migrated screen workflow.

### Child Users
| Endpoint | Purpose |
|:---|:---|
| `/api/childusers/list` | List sub-users |
| `/api/childusers/grants` | Get permissions |
| `/api/childusers/update/grants` | Update permissions |

The child-user detail flow loads profile data with `/api/user/get` and requests the user's grants. `BpB71R2rG8.getPermisoChildTodos` combines the grants available to the signed-in account with the child's current grants by `codigo`, marking current entries enabled. In `GB0CGE0H88`, the operator can change each grant and the user status; the save action submits the blocked/status value through `/api/user/banned`, then sends `user_id` plus the enabled grant-code array to `/api/childusers/update/grants`. The request model serializes those exact names (`user_id`, `grants`). The detail screen hides editing when the session has neither `GESTIONAR_USUARIOS` nor `GESTIONAR_USUARIOS_HIJOS`; the login grant enum assigns those codes `602` and `801` (view codes are `601` and `800`). Evidence: `xoBMVddCFw`, `GB0CGE0H88`, `OkZVobY9IO`, `BpB71R2rG8`, and `e26lZ6zHsTP`. The server's authorization rules and the meaning of every backend grant are outside the static client evidence.

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
