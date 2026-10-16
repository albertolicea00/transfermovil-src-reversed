# TODO — Transfermóvil Reverse Engineering

## Extraction & Setup

- [x] Verify APK identity (SHA-256, package, version, SDK levels)
- [x] Inventory APK contents (DEX, assets, libs, resources)
- [x] Decode manifest via aapt (components, permissions, intent filters)
- [x] Extract resource strings (operations, UI labels, error messages)
- [x] Map drawer menu navigation structure (agent vs general modes)
- [x] Extract REST API endpoints from DEX strings
- [x] Identify named (unobfuscated) classes and infer package roles
- [x] Document asset JSON files (banking, geographic, tax, transit data)
- [ ] Install JADX and decompile bytecode to Java source
- [x] Install Apktool and decode resources to readable XML
- [x] Organize decompiled source into `app/` directory
- [x] Extract smali disassembly into `smali/` directory
- [ ] Verify decompilation quality and completeness

## Architecture & Navigation

- [x] Map manifest components (activities, services, receivers, providers)
- [x] Identify two app modes: Agent and General
- [ ] Trace launch activity → main screen flow
- [ ] Map fragment-to-screen assignments for each drawer menu item
- [ ] Identify how agent vs general mode is selected and persisted
- [ ] Document the splash/intro flow (first-run vs returning user)
- [ ] Map the `generalVsAgentVersion` logic
- [ ] Document the e-commerce module activation path

## USSD / Telephony

- [x] Document USSD send mechanism (tel: intent + CALL_PHONE)
- [x] Document accessibility service USSD response capture
- [x] List discovered USSD codes (*222*, *100*, *111, *133, *234)
- [x] Decompile `sendDataUSSD` and trace full USSD code construction
- [x] Decompile accessibility service response parsing logic
- [ ] Map USSD code → operation mapping (what does *222*264 do?)
- [x] Document multi-step USSD flows (sendNextUssd / nextUssdCode)
- [ ] Trace SIM selection logic for dual-SIM devices
- [ ] Document USSD error handling and timeout behavior
- [x] Map USSD code format: `*{access}*{service}#` via actionCallUSSD

## SMS

- [x] Identify SMS receiver (X9ZiE8XZNKy)
- [x] Decompile SMS receiver — stub/no-op, real handling elsewhere
- [x] Document outgoing SMS format (HzjedYqYeh.send_sms via SmsManager)
- [x] Document SMS response parsing (g0xM9kQCsqu, 32 service types, PAGOxMOVIL sender)
- [ ] Map "Servicios SMS" menu operations
- [ ] Identify SMS-based operations vs USSD-based operations

## Banking

- [x] List banking operations from string resources
- [x] Identify BancoService as banking service handler
- [x] Decompile BancoService — ORMLite entity, stores bank PINs plaintext
- [ ] Document authentication flow (frmAuthBanco, validateAuth)
- [ ] Trace balance inquiry flow (banco_saldo → USSD/SMS)
- [ ] Trace transfer flow (banco_transferencia → code construction)
- [ ] Trace PIN change flow (banco_cambiar_clave)
- [ ] Document per-bank differences (BPA, BANDEC, Metropolitano, BFI)
- [ ] Map account registration flow (banco_registro)
- [ ] Document electricity payment flow (banco_electricidad)
- [ ] Document traffic fine payment (banco_multa)
- [ ] Document ONAT tax payment (banco_onat)
- [ ] Trace transaction limits query (banco_sub_consulta_limites)
- [ ] Document session management (banco_desconectar, OP_Close_Session)

## MiTransfer (Wallet)

- [x] Identify MiTransfer in drawer menu and string resources
- [ ] Decompile MiTransfer wallet flows
- [ ] Document wallet authentication (frmAuthBolsa)
- [ ] Trace wallet balance and operations
- [ ] Document MiBoleto QR feature (hidden in menu)
- [ ] Decompile MiBoletoService

## Agent Operations

- [x] Identify AgentService and agent-specific UI
- [ ] Decompile AgentService — map agent operation dispatch
- [ ] Document agent registration and code retrieval (getCodeAgent)
- [ ] Trace agent-specific services and generales menus
- [ ] Document estadisticas (Resumen/Detalle de Operaciones) for agents

## E-Commerce / Bulevar

- [x] List REST API endpoints (/api/payment/*, /api/business/*, etc.)
- [x] Identify deep links (transfermovil.app, transfermovil://)
- [ ] Identify base URL for API (likely miboleto.mibulevar.com)
- [ ] Decompile API client — trace request/response handling
- [ ] Document authentication flow (ACCESS_TOKEN, X-XSRF-TOKEN)
- [ ] Map business/merchant registration flow
- [ ] Trace payment processing flow (/api/payment/store)
- [ ] Document refund flow (/api/refunds/store)
- [ ] Map child user / sub-account permissions
- [ ] Document payment source management (activar/desactivar)

## Networking & TLS

- [x] Identify OkHttp 4.2.2 as HTTP client
- [x] Note certificate pinning evidence
- [ ] Decompile OkHttp interceptor chain
- [ ] Extract pinned certificates and target hosts
- [ ] Document TLS configuration (min version, cipher suites)
- [ ] Identify any custom trust manager / cert validation bypass
- [ ] Document cleartext traffic usage (which hosts allow HTTP?)
- [ ] Trace self-update mechanism (REQUEST_INSTALL_PACKAGES)

## Security & Crypto

- [x] Note debuggable=true, allowBackup=true, usesCleartextTraffic=true
- [x] Identify CryptoProvider inner class
- [x] Decompile CryptoProvider — identify algorithms (AES? RSA?)
- [x] Determine what data is encrypted and when
- [x] Check for hardcoded keys or predictable IVs
- [ ] Audit certificate pinning implementation strength
- [ ] Audit SharedPreferences for sensitive data storage
- [ ] Check for root/emulator detection
- [ ] Audit exported components for unprotected access
- [ ] Review FileProvider path configuration security

## Local Storage

- [x] Identify ORMLite as ORM, SharedPreferences keys
- [x] Found CodigoAcceso table in migration
- [x] Decompile database helper — list all tables and schemas
- [x] Document what data is persisted locally
- [x] Trace the CodigoAcceso (access code) table usage
- [ ] Map SharedPreferences usage across the app
- [ ] Document Nauta account storage (nautaListDao, nautaCuentas)

## Nauta Integration

- [x] Identify Nauta features (recarga, accounts, export, Nauta Hogar)
- [ ] Decompile Nauta top-up flow (recargaNauta)
- [ ] Document Nauta account types and management
- [ ] Trace Nauta Hogar (home internet) flow
- [ ] Document Nauta Plus feature

## Cubacel Mobile

- [x] Identify plan consultation features (data, voice, SMS, amigos)
- [ ] Decompile mobile top-up flow (OP_Recg_movil)
- [ ] Document plan purchase flows (compraplanescubacel.json)
- [ ] Trace phone debt consultation (OP_Deuda_Telefono)
- [ ] Document bonus/bono mechanism

## Dynamic Checks (When Emulator Available)

- [ ] Install APK on emulator and capture launch behavior
- [ ] Capture logcat during registration/login flow
- [ ] Inspect UI hierarchy and compare with static menu analysis
- [ ] Test USSD code sending (with mock/test only)
- [ ] Capture network traffic for API calls
- [ ] Test deep link handling

## Miscellaneous

- [ ] Document barcode/QR scanning usage (ML Kit integration)
- [ ] Map contact lookup for transfers (READ_CONTACTS)
- [ ] Document the "Teléfonos Útiles" (useful phone numbers) section
- [ ] Document Voto Móvil (canales_votomovil.json) feature
- [ ] Document Mi Turno appointment system
- [ ] Map the ciudades patrimoniales (heritage cities) feature
- [ ] Document transit fine articles (art_inc_transito.json)
- [ ] Trace RECEIVE_BOOT_COMPLETED receiver behavior
