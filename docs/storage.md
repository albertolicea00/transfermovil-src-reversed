# Local Storage

Analysis of SQLite database, SharedPreferences, and data persistence in Transfermóvil v1.260416.

## Database

| Property | Value |
|:---|:---|
| File | `TransferMDB.sqlite` |
| Version | 162 (0xa2) |
| ORM | ORMLite (com.j256.ormlite) |
| Helper class | `ZqXxImD3Ix` (extends `OrmLiteSqliteOpenHelper`) |
| Entity package | `ZNRpoHwtLXM.MZUDJuUoMJL` |

## Tables (26)

### Core User Data

| Table | Columns | Purpose |
|:---|:---|:---|
| `Client` | id, name, ci, phone, address | Registered user/contact profiles |
| `TeflMovil` | id, idClient, id_client, number | Mobile phone numbers linked to clients |
| `TelfFijo` | id, id_client, number | Landline numbers linked to clients |
| `Nauta` | id, id_client, cuenta, tipo_cuenta | Nauta internet accounts |

### App Configuration

| Table | Columns | Purpose |
|:---|:---|:---|
| `AppConfig` | id, phone, number, codigo, imei, activada, evaluacion, mensajeInicio, noMostrarEncuesta, fechaUltimasExperiencias, fechaUltimasPromos, code_bank, fechaHoraAuthBank, activarmodulomiboleto, activarussdparcial, activarMejoraQR, comprapaquetes | Singleton app state and feature flags |
| `Operacion` | id, titulo, subtitulo, fragment_name, imagen, order, activo, operacion (enum), tipo_servicio (enum) | UI menu operations registry |

### Banking & Credentials

| Table | Columns | Purpose |
|:---|:---|:---|
| `BancoService` | id, code, phone, **pbandec**, **pbpa**, **pmetro** | Bank PINs stored **plaintext** (BANDEC, BPA, Metropolitano) |
| `Pin` | id, pin, descripcion | Stored PINs (recharge cards, access codes) |
| `CuentaBanco` | id, id_client, cuenta, descripcion, movil, tipo_moneda (enum) | Bank account numbers |
| `MCBank` | id, cuenta, alias, movil_notificar, agencia (enum), tipo_moneda (enum) | Multi-currency bank accounts |
| `TarjetaPropia` | id, id_client, serie, descripcion, tipo_moneda (enum) | User's own bank cards |
| `AOperKey` | id, pin, operacion (enum), isAuth, authDate | Per-operation authentication keys |

### Transaction Records

| Table | Columns | Purpose |
|:---|:---|:---|
| `RecordSMS` | id, fecha, cuenta, monto, moneda, servicio, idTransaccion, mostrar, tipo_servicio | SMS-based transaction receipts |
| `TCTicket` | id, serie, alias, data, idbank, idtm, importe (float), moneda, fecha, consumido, deleted | Transfer tickets/vouchers |
| `Factura` | id, id_client, factura, cod_factura, tipo_factura | Saved invoice references |

### Services

| Table | Columns | Purpose |
|:---|:---|:---|
| `AgentService` | id, code, phone | Agent service credentials |
| `MiBoletoService` | id, code, phone | MiBoleto service credentials |
| `ServicioPublico` | id, id_client, cod_servicio, tipo_servicio, valor | Public utility service identifiers |

### E-Commerce / Tickets

| Table | Columns | Purpose |
|:---|:---|:---|
| `OfertasBoleto` | id, id_control, nombre, precio (double), moneda, cantPersona, validDays, tipo_oferta, fecha, fechaOferta | Ticket/event catalog |
| `CompraBoleto` | id, alias, ci_beneficiario, id_oferta, id_transaccion, id_transferencia, estado, datos, fechaCompra, fechaInicial, fechaVencimiento, fechaActualizacion, consumido, deleted | Purchased tickets lifecycle |
| `TMonedasWallet` | id (String), currency, descripcion, fecha, allowTransfer | Multi-currency wallet entries |

### Cubacel

| Table | Columns | Purpose |
|:---|:---|:---|
| `CompraPlanesCubacel` | id, nombre, version_ussd, fechaAct | Data/voice plan purchase catalog |

### Lookup Tables

| Table | Columns | Purpose |
|:---|:---|:---|
| `Provincia` | cod_provincia, nombre, abreviatura | Cuban provinces |
| `Municipio` | id, cod_municipio, cod_provincia, nombre, abreviatura | Cuban municipalities |
| `Tributo` | cod_tributo, nombre, abreviatura, moneda, tipo, tipoPersona | ONAT tax codes |

### Promotional

| Table | Columns | Purpose |
|:---|:---|:---|
| `PromoSMS` | id, mensaje, fecha_inicio, fecha_fin, habilitado, icono_asociado, tipo_promo | Promotional SMS with date ranges |

## Migration Logic (onUpgrade)

- Uses `createTableIfNotExists` for 17 tables added after original schema
- Drops legacy tables: `Version`, `CodigoAcceso`
- ALTER TABLE migrations for `AppConfig`: adds columns across versions (`agregarAppConfigNewColumms`, `agregarAppConfigMiboletoNewColumms`, `agregarAppConfigCompraPaquetes`, `agregarAppConfigMejoraQR`)
- Re-encrypts agent codes using new app version (`UpgradeCodeVersion3`, `UpgradeCodeVersionAgente`)
- Repopulates lookup tables (Provincia, Municipio, Tributo) from bundled JSON assets
- Updates `AppConfig` fields: number, codigo, imei, evaluacion, etc.

## SharedPreferences

| Key | Purpose |
|:---|:---|
| `PREF_ACCOUNT` | Current account reference |
| `PREF_CURRENCY` | Selected currency |
| Various feature flags | UI state, drawer selections |

## Security Concerns

- **Bank PINs in plaintext**: `BancoService.pbpa`, `pbandec`, `pmetro` stored as plain strings
- **IMEI stored**: `AppConfig.imei` — device fingerprint in DB
- **`allowBackup=true`**: entire SQLite DB extractable via `adb backup`
- **No DB encryption**: SQLite file not encrypted (no SQLCipher)
- Combined: ADB backup + plaintext PINs = complete credential theft vector
