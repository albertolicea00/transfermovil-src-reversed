# Domain Model

Complete entity and enum catalog from smali analysis of Transfermóvil v1.260416.
All model classes in `cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL`.

## Database

- **File:** `TransferMDB.sqlite`
- **Version:** 162 (matches APK versionCode)
- **Helper:** `ZqXxImD3Ix` extends `OrmLiteSqliteOpenHelper`
- **Tables:** 26 (all created via `TableUtils.createTableIfNotExists`)
- **Migration:** drops legacy `Version` and `CodigoAcceso` tables; `UpgradeCodeVersion3` re-encrypts agent codes
- **Seed data:** `fill_all()` via `nljtDl5MIf` populates reference tables from JSON assets on fresh install
- **Encryption:** only `CuentaBanco.cuenta` uses encryption (`rDEl7rW1aN.encryption()/decryption()`); all other sensitive fields stored plaintext

## Entity Classes (ORMLite POJOs)

### Banking & Payments

| Entity | Fields | Notes |
|:---|:---|:---|
| `BancoService` | `id:int`, `code:String`, `phone:String`, `pmetro:String`, `pbpa:String`, `pbandec:String` | **Plaintext bank PINs** per bank |
| `CuentaBanco` | `id:int`, `id_client:int`, `cuenta:String`, `descripcion:String`, `movil:String`, `tipo_moneda:qTDVwLFEjE` | Bank account linked to client |
| `MCBank` | `id:int`, `alias:String`, `cuenta:String`, `movil_notificar:String`, `agencia:R1sDOSqZ2z`, `tipo_moneda:qTDVwLFEjE` | Multi-currency bank account |
| `Pin` | `id:int`, `pin:String`, `descripcion:String` | **Plaintext PIN storage** |
| `TarjetaPropia` | `id:int`, `id_client:int`, `serie:String`, `descripcion:String`, `tipo_moneda:qTDVwLFEjE` | User's own card |
| `Factura` | `id:int`, `id_client:int`, `cod_factura:String`, `factura:String`, `tipo_factura:int` | Invoice/bill |

### Wallet & Tickets

| Entity | Fields | Notes |
|:---|:---|:---|
| `CompraBoleto` | `id:int`, `idOferta:String`, `idTransaccion:String`, `idTransferencia:String`, `ci:String`, `alias:String`, `importe:double`, `moneda:String`, `token:String`, `estado:String`, `fechaCompra:Date`, `fechaVencimiento:Date`, `consumido:boolean`, `deleted:boolean`, ... | Ticket purchase record |
| `TCTicket` | `id:int`, `idbank:String`, `idtm:String`, `serie:String`, `alias:String`, `importe:float`, `moneda:String`, `data:String`, `consumido:boolean`, `deleted:boolean`, `fecha:Date` | Transit/commerce ticket |
| `TMonedasWallet` | `id:String`, `currency:String`, `descripcion:String`, `allowTransfer:int`, `fecha:Date` | Wallet currency entry |
| `RecordOferta` | `id:int`, `idOferta:String`, `idTransaccion:String`, `idTransferencia:String`, `monto:String`, `moneda:String`, `tipoOferta:String`, `token:String`, `tipo_servicio:KYTjPlWScT`, `fecha:Date`, `fechaVencimiento:String`, `mostrar:Boolean` | Offer/deal record |
| `RecordSMS` | `id:int`, `idTransaccion:String`, `cuenta:String`, `monto:String`, `moneda:String`, `servicio:String`, `tipo_servicio:KYTjPlWScT`, `fecha:Date`, `mostrar:Boolean` | SMS transaction log |

### Contacts & Accounts

| Entity | Fields | Notes |
|:---|:---|:---|
| `Client` | `id:int`, `name:String`, `phone:String`, `ci:String`, `address:String` | Contact/client record |
| `TeflMovil` | `id:int`, `idClient:int`, `id_client:int`, `number:String` | Mobile phone numbers (duplicate FK fields) |
| `TelfFijo` | `id:int`, `id_client:int`, `number:String` | Landline numbers |
| `Nauta` | `id:int`, `id_client:int`, `cuenta:String`, `tipo_cuenta:int` | Nauta internet account |
| `ServicioPublico` | `id:int`, `id_client:int`, `cod_servicio:String`, `valor:String`, `tipo_servicio:int` | Public utility service |

### Operations & Config

| Entity | Fields | Notes |
|:---|:---|:---|
| `Operacion` | `id:int`, `titulo:String`, `subtitulo:String`, `fragment_name:String`, `imagen:int`, `order:int`, `activo:boolean`, `operacion:Nl0yptXmjQ`, `tipo_servicio:R1sDOSqZ2z` | Operation menu item |
| `AppConfig` | `id:int`, `phone:String`, `number:String`, `imei:String`, `codigo:String`, `code_bank:String`, `activada:boolean`, `activarMejoraQR:boolean`, `activarmodulomiboleto:boolean`, `activarussdparcial:boolean`, `comprapaquetes:int`, `evaluacion:int`, `mensajeInicio:boolean`, `noMostrarEncuesta:boolean`, `fechaHoraAuthBank:Date`, ... | App configuration — **stores IMEI** |
| `AOperKey` | `id:int`, `pin:String`, `isAuth:boolean`, `authDate:Date`, `operacion:Nl0yptXmjQ` | Operation auth key — **plaintext PIN** |
| `CompraPlanesCubacel` | `id:int`, `nombre:String`, `version_ussd:int`, `fechaAct:Date` | Cubacel plan purchase config |
| `PromoSMS` | `id:int`, `mensaje:String`, `tipo_promo:R1sDOSqZ2z`, `habilitado:boolean`, `icono_asociado:int`, `fecha_inicio:Date`, `fecha_fin:Date` | SMS promotion |
| `AgentService` | `id:int`, `code:String`, `phone:String` | Agent service config |
| `MiBoletoService` | `id:int`, `code:String`, `phone:String` | MiBoleto service config |

### QR Data

| Entity | Fields | Notes |
|:---|:---|:---|
| `QRData` | `ci:String`, `pin:String`, `token:String`, `detallesAdicionales:List` | **Plaintext PIN and token** |
| `QRMiBoleto` | `Id:String`, `Ci:String`, `P:String`, `T:String`, `Dt:List` | Short field names (P=PIN?, T=Token?) |
| `QRCombustible` | `Pin:String`, `Token:String` | **Fuel QR — plaintext PIN/token** |

### Reference Data (from JSON assets)

| Entity | Fields | Notes |
|:---|:---|:---|
| `SucursalBancaria` | `codigoSucursal`, `dpa`, `titulo` | Bank branches |
| `SucursalCadeca` | `codigoPovincia`, `cod_mun`, `dpa`, `titulo` | Currency exchange (CADECA) |
| `SucursalGas` | `codigoPovincia`, `dpa`, `titulo` | Gas stations |
| `ServicioSucursal` | `codDpa`, `codServicio`, `nomServicio` | Branch services |
| `MultasTransito` | `articulo:int`, `inciso:int`, `descripcion`, `peligrosidad:int` | Traffic violations |
| `CiudadesPatrimoniales` | `code`, `nombre`, `abreviatura` | Heritage cities |
| `Municipio` | `id`, `cod_provincia`, `cod_municipio`, `nombre`, `abreviatura` | Municipalities |
| `Provincia` | `cod_provincia`, `nombre`, `abreviatura` | Provinces |
| `EntidadEfectivo` | `code`, `nombre`, `moneda` | Cash payment entities |
| `Empresa` | `code`, `empresa`, `ministerio` | Government entities |
| `DenominacionSello` | `nombre`, `importe`, `moneda` | Stamp denominations |
| `ObligacionesOFA` | `code`, `descripcion`, `abreviatura` | Tax obligations |
| `ReservasOFA` | `code`, `nombre`, `ciudad`, `abreviatura`, `precioNac`, `precioExt`, `monedaNac`, `monedaExt` | OFA reservations |
| `TipoPrelacion` | `code`, `descripcion` | Prelation types |
| `Tributo` | `cod_tributo`, `nombre`, `abreviatura`, `moneda`, `tipo`, `tipoPersona` | Tax tributes |
| `OfertasBoleto` | `id`, `nombre`, `precio:double`, `moneda`, `cantPersona:int`, `tipo_oferta:int`, `validDays:int`, ... | Ticket offers |
| `Canal` | `id`, `nombre`, `consecutivo`, `esDePago:int` | Voto Móvil channels |

### Enum: EntidadesModel (Table Categories)

`Clientes`, `Factura`, `Fijos`, `Moviles`, `Nautas`, `Pines`

## Enums

### Operations (`Nl0yptXmjQ`) — 47 operations

| Value | Inferred Purpose |
|:---|:---|
| `Login` | Session authentication |
| `Consulta` | Balance inquiry |
| `Transferencia` | Bank transfer |
| `TransferenciaEmpresa` | Business transfer |
| `Pago` | Generic payment |
| `Pago_Electricidad` | Electricity bill |
| `Pago_Agua` | Water bill |
| `Pago_Gas` | Gas bill |
| `Pago_ONAT` | Tax payment (ONAT) |
| `Pago_Telefono` | Phone bill |
| `Pago_Factura_Telefonica` | Phone invoice |
| `Recarga_Movil` | Mobile top-up |
| `Recarga_Movil_Banco` | Mobile top-up via bank |
| `Recarga_Propia` | Self top-up |
| `Recarga_Nauta` | Nauta top-up |
| `Recarga_Nauta_Banco` | Nauta top-up via bank |
| `Recarga_Nauta_Hogar_Banco` | Nauta home via bank |
| `RecargaNautaHogar4G` | Nauta home 4G |
| `RecargaNautaMLC` | Nauta MLC top-up |
| `RecargaCUPBolsa` | CUP wallet top-up |
| `Recarga_Cupon` | Coupon top-up |
| `CompraPaquetesCubacel` | Cubacel package purchase |
| `PaqueteMLC` | MLC package |
| `GigasNautaHogare4G` | Nauta home 4G data |
| `Giro` | Money order/wire |
| `SelloTimbre` | Stamp purchase |
| `CuentaFiscal` | Fiscal account |
| `CajaExtra` | Extra cash operation |
| `Amortizacion` | Loan amortization |
| `Aporte_Patrimonio` | Equity contribution |
| `BOLSATransferirBancos` | Wallet-to-bank transfer |
| `PCC` | Party contribution (PCC) |
| `JClub` | Club membership |
| `Ticket_Combustible_Gestion` | Fuel ticket management |
| `Ticket_MiBoleto_Gestion` | MiBoleto ticket management |
| `VendedorMiBoleto` | MiBoleto vendor |
| `ReservasTicket` | Ticket reservation |
| `ConsultarReservasTicket` | Check reservation |
| `ModificarReservasTicket` | Modify reservation |
| `EliminarReservasTicket` | Delete reservation |
| `ConsultarPagosSindicato` | Union payment query |
| `VisitaRecorridos` | Heritage city visits |
| `VotoMovil` | Mobile voting |
| `Eqj43O0pUx` | Obfuscated (unknown) |
| `TBaFnBLjEA` | Obfuscated (unknown) |
| `xf94v3SFEM` | Obfuscated (unknown) |

### Banks / Service Types (`R1sDOSqZ2z`)

`BANDEC`, `BFI`, `BPA`, `Metropolitano`, `ETECSA`, `MiTransfer`, `MIBOLETO`, `General`, `CLASICA`, `CLASICAEMP`

### Transaction Service Category (`KYTjPlWScT`)

`Agentes`, `BancoBANDEC`, `BancoBPA`, `BancoMetro`, `BolsaEtecsa`

### Currency (`qTDVwLFEjE`)

`CUP`, `CUC`, `USD`, `EUR`, `GBP`, `MXN`, `CHF`, `JPY`, `CAD`, `NOK`, `SEK`, `DKK`, `OTHER`, `NONE`

### Auth Actions (`HrLy23Pb9b`)

`AUTENTICAR`, `REGISTRO`, `RESTABLECER`

### Account View (`jceCwl8l2R`)

`MIS_CUENTAS`, `MONEDA`, `NUEVA_CUENTA`, `VACIO`

### Account Type (`RiZsr8xXRC`)

`CON_CUENTA`, `SIN_CUENTA`

### Card Type (`x8AaGMBO19`)

`ESTANDARIZADA`, `PAN`, `NONE`

### Payment Type (`y2Cht3lmjg`)

`PagoNIT`, `PagoRC05`, `ParcialFijoAnual`, `ParcialFijoMensual`, `ParcilFijoImporte`

### Source Type (`h79qmyRfm3`)

`CIMEX`, `TURISMO`, `UCIAPKLIST`, `UCIAPKTODUS`

### Layout Type (`f9CS9TjtF3`)

`DINAMICO`, `ESTATICO`

## Security Findings

1. **Plaintext PINs in SQLite**: `BancoService.pmetro/pbpa/pbandec`, `Pin.pin`, `AOperKey.pin`, `QRData.pin`, `QRCombustible.Pin`
2. **Plaintext tokens**: `QRData.token`, `QRCombustible.Token`, `CompraBoleto.token`
3. **IMEI stored**: `AppConfig.imei` — device fingerprint
4. **No encryption layer visible** between entity fields and SQLite storage (ORMLite writes fields directly)
5. Combined with `allowBackup=true` + `debuggable=true` → trivial data extraction via ADB
