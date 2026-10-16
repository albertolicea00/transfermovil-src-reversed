# Architecture Overview

Analysis of `cu.etecsa.cubacel.tr.tm` v1.260416 (code 162).

## Build Properties

| Property | Value |
|:---|:---|
| Compile SDK | 34 (Android 14) |
| Min SDK | 21 (Android 5.0) |
| Target SDK | 33 (Android 13) |
| `debuggable` | `true` |
| `allowBackup` | `true` |
| `usesCleartextTraffic` | `true` |
| `requestLegacyExternalStorage` | `true` |
| Native ABIs | arm64-v8a, armeabi-v7a, x86, x86_64 |
| DEX files | 2 (classes.dex ~11MB, classes2.dex ~105KB) |
| App classes | ~3439 (all in classes.dex, obfuscated) |

> **Security note:** `debuggable=true` in a production build is unusual and permits attaching a debugger. `allowBackup=true` allows `adb backup` data extraction.

## Obfuscation

All app class and method names are obfuscated with random alphanumeric strings (e.g., `prPzLeyxKk`, `B0jOLrWx09th`). Resource IDs are not obfuscated — layout XML filenames use similar random strings but string resource names retain meaningful identifiers (e.g., `banco_saldo`, `consultar_plan_sms`).

## Package Structure

Two logical modules in the DEX:

| Package | Purpose |
|:---|:---|
| `cu.etecsa.cubacel.tr.tm` | Main app — activities, services, receivers, fragments |
| `cu.etecsa.tm.ecommerce` | E-commerce module — online shopping, Bulevar, product views |

## Application Class

`cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N` — the custom `Application` subclass, defined in the e-commerce module. Initializes global state.

## Named (Unobfuscated) Classes

Some inner classes retained readable names despite obfuscation:

| Class | Package | Purpose |
|:---|:---|:---|
| `AgentService` | `ZNRpoHwtLXM.MZUDJuUoMJL` | Agent operation handling |
| `BancoService` | `ZNRpoHwtLXM.MZUDJuUoMJL` | Banking operation handling |
| `MiBoletoService` | `ZNRpoHwtLXM.MZUDJuUoMJL` | Ticket/boleto operation handling |
| `CryptoProvider` | `l08fNVC4KOKK.V5FFEZ0Qrr0` | Custom crypto provider (inner class) |
| `SMS_properties` | `tm.ecommerce.qHBfDCWv13G.tgTvaFy8UG` | SMS configuration properties |
| `DatosTarjeta` | `B0jOLrWx09th.EV9Tu0zIL4` | Card data model ("datos de tarjeta") |
| `MyAdapter` (×15) | Various packages | RecyclerView list adapters |

## Package Functional Mapping (Hypothesis)

Based on class hierarchy analysis, string references, and named classes:

| Obfuscated Package | Inferred Function | Evidence |
|:---|:---|:---|
| `B0jOLrWx09th` | **Main UI** — fragments, adapters, screens | Most fragments and adapters; deepest hierarchy; `DatosTarjeta` card data model |
| `B0jOLrWx09th.MqnAp2jnnon` | **Banking fragments** | Sub-packages with 3-4 Fragment subclasses each |
| `B0jOLrWx09th.hTZG5yFgyZY` | **Settings/config UI** | Multiple sub-packages |
| `B0jOLrWx09th.ivq3YYEGPZM` | **Agent UI** | Adapters and fragments |
| `B0jOLrWx09th.p1CEgMEeWUbD` | **Payment/operations UI** | Most `MyAdapter` inner classes (12+) |
| `ZNRpoHwtLXM` | **Service layer** | `AgentService`, `BancoService`, `MiBoletoService` |
| `l08fNVC4KOKK` | **Telephony/security** | Accessibility service, `CryptoProvider`, USSD/SMS handling |
| `us8tbD58ow4` | **Utilities** | Adapters, helpers |
| `tm.ecommerce` | **E-commerce** | 102 distinct classes; deep link handler, product views |

## Manifest Components

### Activities

| Obfuscated Name | Role | Evidence |
|:---|:---|:---|
| `prPzLeyxKk` | **Launcher / splash** | `MAIN` + `LAUNCHER` intent filter |
| `IHVTCBmiLV` | Internal activity | Portrait-locked, config change handling |
| `S9ycHcoxAzy` | **Deep link handler** | Handles `ACTION_SEND` (text/plain), `ACTION_VIEW` for `https://transfermovil.app/action` and `transfermovil://tm_compra_en_linea/action` |
| `QqWqw83vJf` | Internal activity | No special attributes |
| `nNLWm3R1aPI.wComYkZMDc` | Custom-themed activity | Config change handling |
| `FileChooserActivity` | File picker (3rd party) | `ar.com.daidalos.afiledialog` library |

**E-commerce activities:**

| Obfuscated Name | Evidence |
|:---|:---|
| `yzjeVbN3sq` | General e-commerce |
| `mBdwa3RRkn` | Portrait-locked, labeled (resource string) |
| `a7Y4bbw8Os` | Portrait-locked |
| `bAogvejtBb` | Portrait-locked |
| `H9l22AIYKkA` | Custom theme |
| `C1b1PWKeZSE` | Custom theme |
| `hd5jZHAGaN` | Custom theme |
| `LaIvmOMkyve.isyTi1whjIo.vHqHzxi5J3` | Portrait-locked, labeled |

### Services

| Obfuscated Name | Role | Evidence |
|:---|:---|:---|
| `l08fNVC4KOKK...O7xyZJJBFWg` | **Accessibility service** | `BIND_ACCESSIBILITY_SERVICE` permission; monitors `com.android.phone` for USSD dialog interception |
| `MetadataHolderService` | CameraX config | Disabled by default |
| `MlKitComponentDiscoveryService` | ML Kit barcode scanning registration | Direct-boot aware |
| `TransportBackendDiscovery` | Google Data Transport (analytics) | — |
| `JobInfoSchedulerService` | Google Data Transport scheduling | `BIND_JOB_SERVICE` |

### Receivers

| Obfuscated Name | Role | Evidence |
|:---|:---|:---|
| `X9ZiE8XZNKy` | **SMS receiver** | `android.provider.Telephony.SMS_RECEIVED`, requires `BROADCAST_SMS` permission, exported |
| `AlarmManagerSchedulerBroadcastReceiver` | Google transport alarm | Not exported |

### Content Providers

| Name | Authority | Role |
|:---|:---|:---|
| `FileProvider` | `cu.etecsa.cubacel.tr.tm.provider` | File sharing via content URIs. Exposes cache, internal files, and external storage paths. |
| `MlKitInitProvider` | `cu.etecsa.cubacel.tr.tm.mlkitinitprovider` | ML Kit auto-initialization |
| `InitializationProvider` | `cu.etecsa.cubacel.tr.tm.androidx-startup` | AndroidX Startup (emoji2 initializer) |

## Navigation Structure (from drawer menus)

Two drawer configurations exist: `drawermenu.xml` (agent mode) and `drawermenu_general.xml` (general/end-user mode).

### Agent Mode (`drawermenu.xml`)

```
Inicio (Home)
├── [Cubacel reference]
├── Agentes
│   ├── Servicios
│   └── Generales
├── Monedero (Wallet)
│   ├── MiTransfer
│   └── MiBoleto QR [hidden]
├── Bancos [hidden]
│   ├── Metropolitano
│   ├── BPA
│   ├── BANDEC
│   ├── BFI
│   └── [2 more, string refs]
├── Comercio [hidden]
│   └── Bulevar
├── Estadisticas [hidden]
│   ├── Resumen de Operaciones
│   └── Detalle de Operaciones
├── Configuración
└── Ayuda [hidden/disabled]
```

### General Mode (`drawermenu_general.xml`)

```
Inicio (Home)
├── Servicios
│   ├── Llamadas
│   ├── Operaciones
│   ├── Servicios SMS
│   ├── Teléfonos Útiles
│   └── Nauta [hidden/disabled]
├── Monedero
│   ├── MiTransfer
│   └── MiBoleto QR [hidden]
├── Bancos [hidden]
│   ├── BPA
│   ├── BANDEC
│   ├── Metropolitano
│   ├── BFI
│   └── [2 more, string refs]
├── Comercio [hidden]
│   └── Bulevar
├── Estadisticas [hidden]
│   ├── Resumen de Operaciones
│   └── Detalle de Operaciones
├── Configuración
└── Ayuda [hidden/disabled]
```

**Interpretation:** The app has two operational modes — "Agent" (for payment agents/businesses that process transactions on behalf of others) and "General" (end-user). Bancos, Comercio, and Estadisticas sections start hidden and are likely server-enabled or conditionally shown based on user type / authentication state.

## Key Operations (from string resources)

| String ID | Label (es) | Category |
|:---|:---|:---|
| `OP_Close_Session` | Cerrar la sesión | Session |
| `OP_Consulat_Deuda` | Pagar deuda de un teléfono | Payments |
| `OP_Deuda_Telefono` | Consultar deuda de un teléfono | Queries |
| `OP_Recg_movil` | Recargar un móvil | Top-up |
| `OP_Ult_Recargas` | Últimas Recargas | History |
| `OP_ultimas_nauta` | Últimas recargas de bonos | History |
| `OP_ultimos_pagos` | Últimos Pagos | History |

### Banking Operations

Authentication, balance check, transfers (same-bank and inter-bank via Metropolitano), change PIN, check account status, electricity payments, traffic fines, ONAT (tax), session disconnect, and transaction limits queries.

### Boleto (Ticket/Transit) Operations

Ticket status, integrated query, update, and last operations — likely tied to the "MiBoleto QR" feature for transit/event tickets.

## Dependencies

| Library | Version | Purpose |
|:---|:---|:---|
| OkHttp | 4.2.2 | HTTP client |
| ORMLite | — | SQLite ORM for local persistence |
| Google ML Kit | — | Barcode/QR scanning |
| CameraX (Camera2) | — | Camera access for QR scanning |
| Google Data Transport | — | Analytics/telemetry |
| AndroidX (AppCompat, Emoji2, Startup) | — | UI framework |
| aFileDialog | — | File chooser (3rd party) |

## Deep Links

| Scheme | Host | Path | Purpose |
|:---|:---|:---|:---|
| `https` | `transfermovil.app` | `/action` (prefix) | Web-to-app e-commerce actions |
| `transfermovil` | `tm_compra_en_linea` | `/action` (pattern) | Custom scheme for in-app commerce |

Both handled by `S9ycHcoxAzy`, which also accepts `ACTION_SEND` with `text/plain` MIME type.

## Asset Data Files

30+ JSON config files bundled with the app, providing static reference data:

| Category | Files | Records |
|:---|:---|:---|
| Banking branches | `sucursalesBanco.json`, `sucursalesBancoBANDEC.json`, `sucursalesBancoBPA.json`, `sucursalesCadeca.json` | Hundreds of branch locations |
| Gas stations | `sucursalesGas.json`, `sucursalesGasBalita.json`, `scursalesGasBalitaHabana.json` | Hundreds of locations |
| Government entities | `entidades.json`, `entidadesEfectivo.json` | Payment entities (MININT, MFP) |
| Geographic | `dpa.json`, `municipios_la_habana.json` | Province/municipality codes |
| Cubacel plans | `compraplanescubacel.json` | Data, voice, SMS plans |
| Transit/fines | `art_inc_transito.json` | 3248 lines, traffic violation articles |
| Tax/fiscal | `obligacionesOFA.json`, `reservasOFA.json`, `tipoPrelacion.json`, `tributos.json` | Tax obligations and categories |
| Bulevar | `dpabulevar.json`, `permisosBulevar.json` | Commerce permits |
| Voting | `canales_votomovil.json` | TV/media channels (Voto Móvil) |
| Heritage cities | `ciudadPatrimonial.json` | Heritage city info |
| Appointment booking | `provinciasMiTurno*.json`, `sucursales_miturno_servicios.json` | "Mi Turno" appointment system |
