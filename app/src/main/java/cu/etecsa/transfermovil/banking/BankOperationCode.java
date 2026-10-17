package cu.etecsa.transfermovil.banking;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w
 * @fingerprint 332 operation codes across 5 banks/services.
 *
 * Prefix key:
 *   AG    → Agent (ETECSA telecom agent)
 *   BPA   → Banco Popular de Ahorro
 *   BAN   → BANDEC (Banco de Crédito y Comercio)
 *   METRO → Banco Metropolitano
 *   BFI   → Banco Financiero Internacional
 *   BOLSA → ETECSA Wallet/Bolsa
 *   Conf  → Configuration operations
 *
 * No-prefix entries are general Cubacel/ETECSA operations.
 */
public enum BankOperationCode {
    // --- Cubacel/ETECSA general ---
    ConsultaSaldo222, ConsultaSaldo111, LLamada, Llamar99,
    RecargarMovilBono, TransferirSaldoMovil, CambioClave,
    ConsultarEstadoBono, GestionPlanes, ConsultarPlanDatos,
    ConsultarPlanVoz, ConsultarPlanSMS, ConsultarPlanAmigos,
    VotoMovil, AdelantaSaldo,

    // --- Agent (AG) ---
    AGPredeterminarTarjeta, AGConsultarFactura, AGPagarFactura,
    AGUltimosPago, AGRectificarPago, AGAutenticar, AGConsultarSaldo,
    AGRecargar, AGUltimasRecargas, AGCambiarclave, AGDesconectar,
    AGRecargarNauta, AGConsultarNautaUlt, xf94v3SFEM,

    // --- BPA ---
    BPAAutenticarse, BPATransferencia, BPAElectricidad, BPATelefono,
    BPAONAT, BPAConsultarSaldo, BPAConsultarServicio, BPAUltimasoperaciones,
    BPARegistrarse, BPACambiarclave, BPADesconectar, BPARecargaMovil,
    BPACambioLimite, BPAConsultaLimite, BPAEliminarRegistro, BPAAmortizar,
    BPAConsultarTodasCuentas, BPAGiroPostal, BPAConsultarGiroPostal,
    BPAPagoExterno, BPARecargaNauta, BPAAsociarCuenta, BPAConsultaCredito,
    BPARecargaPropia, BPAPlazoFijo, BPARCerrarPlazoFijo, BPAPinDigital,
    BPAJClub, BPAGas, BPAAgua, BPARenovarTarj, BPARecuperarTarj,
    BPATipoCambio, BPAMultaContravension, BPAMultaTransito, BPAConsultaMulta,
    BPAConvertirCuenta, BPAImprimirMLC, BPAInformacionTarjeta,
    BPACombustibleCompra, BPACombustibleUltOper, BPACombustibleConsultaCuenta,
    BPACombustibleConsultaEstado, BPACombustibleActToken, BPACombustibleConsultas,
    BPACajaExtra, BPARecargaBolsa, BPAPCC, BPAPaquetesCubacel,
    BPACuentaFiscal, BPAReservasTicket, BPAConsultaTicket,
    BPAConsultaSindicato, BPARecargaTFA, BPAObtenerCuentaEstandar,

    // --- BANDEC (BAN) ---
    BANAutenticar, BANTransferencia, BANElectricidad, BANTelefono,
    BANONAT, BANConsultarSaldo, BANConsultarServicio, BANUltimasoperaciones,
    BANRegistrarse, BANCambiarclave, BANDesconectar, BANEliminarRegistro,
    BANRecargaMovil, BANCambioLimite, BANConsultaLimite, BANCambioCuenta,
    BANUltimosPagos, BANAmortizar, BANConsultarTodasCuentas, BANGiroPostal,
    BANConsultarGiroPostal, BANPagoExterno, BANRecargaNauta, BANGas,
    BANCambioPinMultibanca, BANImprimirMLC, BANRecargaPropia, BANReimpresion,
    BANInfoTarjeta, BANPinDigital, BANJClub, BANAgua, BANReimprimir,
    BANIDComercio, BANPlazoFijo, BANCierrePlazoFijo, BANTipoCambio,
    BANMultaContravension, BANMultaTransito, BANConsultaMulta,
    BANConvertirCuenta, BANEstadoPagoExterno, BANPatrimoniOfa,
    BANCombustibleCompra, BANCombustibleUltOper, BANCombustibleConsultaCuenta,
    BANCombustibleConsultaEstado, BANCombustibleActToken, BANCombustibleConsultas,
    BANCajaExtra, BANRecargaBolsa, BANEstadoCuentas, BANCambioMensualidad,
    BANPCC, BANPaquetesCubacel, BANCuentaFiscal, BANReservasTicket,
    BANConsultaTicket, BANConsultaSindicato, BANRecargaTFA,

    // --- Metropolitano (METRO) ---
    METROAutenticarse, METROConsultarSaldo, METROConsultarServicio,
    METROTransferirEfectivo, METROTelefono, METROElectricidad, METROAgua,
    METROImpuestos, METROUltimasoperaciones, METRORegistrarse,
    METRODesconectar, METROEliminarregistro, METROActualizarcuenta,
    METRORecargaMovil, METROCambioLimite, METROConsultaLimite,
    METROConsultaTodasCuentas, METROCambioPin, METROAsociarCuenta,
    METROGiroPostal, METROConsultarGiroPostal, METROPagoExterno,
    METRORecargaNauta, METROReimprimirTarjeta, METROLocalizarTransferencia,
    METROConsultaCredito, METROGas, METRORecargaPropia, METROPinDigital,
    METROJClub, METROTipoCambio, METROImprimirMLC, METROConvertirCuenta,
    METROPlazoFijo, METROCierrePlazoFijo, METROMultaContravension,
    METROMultaTransito, METROConsultaMulta, METROInformacionTarjeta,
    METROCombustibleCompra, METROCombustibleUltOper, METROCombustibleConsultaCuenta,
    METROCombustibleConsultaEstado, METROCombustibleActToken,
    METROCombustibleConsultas, METROCajaExtra, METROPagoCredito,
    METRORecargaBolsa, METROPatrimoniOfa, METROEstadoCuentas,
    METROConsultaPrelacion, METROModificarPrelacion, METROCambioMensualidad,
    METROObtenerCuentaEstandar, METROPCC, METROPaquetesCubacel,
    METROCuentaFiscal, METROReservasTicket, METROConsultaTicket,
    METROConsultaSindicato, METRORecargaTFA,

    // --- BFI ---
    BFIAutenticarse, BFIConsultarSaldo, BFIConsultarServicio,
    BFITransferirEfectivo, BFITelefono, BFIElectricidad, BFIAgua,
    BFIImpuestos, BFIUltimasoperaciones, BFIRegistrarse, BFIDesconectar,
    BFIEliminarregistro, BFIActualizarcuenta, BFIRecargaMovil,
    BFICambioLimite, BFIConsultaLimite, BFIConsultaTodasCuentas,
    BFICambioPin, BFIAsociarCuenta, BFIGiroPostal, BFIConsultarGiroPostal,
    BFIPagoExterno, BFIRecargaNauta, BFIReimprimirTarjeta,
    BFILocalizarTransferencia, BFIConsultaCredito, BFIGas, BFIRecargaPropia,
    BFIPinDigital, BFIJClub, BFITipoCambio, BFIImprimirMLC,
    BFIConvertirCuenta, BFIPlazoFijo, BFICierrePlazoFijo,
    BFIMultaContravension, BFIMultaTransito, BFIConsultaMulta,
    BFIInformacionTarjeta, BFICombustibleCompra, BFICombustibleUltOper,
    BFICombustibleConsultaCuenta, BFICombustibleConsultaEstado,
    BFICombustibleActToken, BFICombustibleConsultas, BFICajaExtra,
    BFIPagoCredito, BFIRecargaBolsa, BFIPatrimoniOfa, BFIEstadoCuentas,
    BFIConsultaPrelacion, BFIModificarPrelacion, BFICambioMensualidad,
    BFIObtenerCuentaEstandar, BFIPCC, BFIPaquetesCubacel, BFICuentaFiscal,
    BFIReservasTicket, BFIConsultaTicket, BFITransferirEmpresa,
    BFIPagoExternoEmpresa,

    // --- Configuration ---
    ConfActualizar, ConfAgente, ConfMiBoleto, ConfCuentas, ConfSalvas,
    ConfAvanzadas, UpdateWallet,

    // --- ETECSA Wallet/Bolsa ---
    BOLSAAutenticarse, BOLSATransferencia, BOLSATelefono, BOLSAConsultarSaldo,
    BOLSARegistrarse, BOLSADesconectar, BOLSARecargaMovil,
    BOLSAEliminarRegistro, BOLSARecargaNauta, BOLSARecargaPropia,
    BOLSAUltimasOperaciones, BOLSACambioPin, BOLSAElectricidad, BOLSAAgua,
    BOLSAgas, BOLSAImpuestos, BOLSAPagoLinea, BOLSARecargaBolsa,
    BOLSACompraPaqueteMLC, BOLSARecargaNautaMLC, BOLSAConsultaServicio,
    BOLSARecargaFWA, BOLSACompraPaqueteFWA, BOLSARecargaCUPWalletTicket,
    BOLSAExtraccionWalletTicket, BOLSATransferirBancos, BOLSAEstadoCuenta,
    BOLSAConsultaReservaOFA, BOLSAPCC,

    // --- Bolsa Agent (BOLSAAG) ---
    BOLSAAGFacturaTelefonica, BOLSAAGRecargaMovil, BOLSAAGCuponNauta,
    BOLSAAGConsultaCuponNauta, BOLSAAGRecargaNauta, BOLSAAGRecargaNautaHogar,
    BOLSAAGRecargaWalletCUP, BOLSAAGRecargaPropia, BOLSAAGPaquetesCubacel,
    BOLSAPaquetesCubacel, BOLSAAGRecargaMovilAgencia,

    // --- Bolsa misc ---
    BOLSAReservasOFA, BOLSAAporteOFA, BOLSAReservasTicket,
    BOLSAConsultaTicket, BOLSAEliminarTicket, BOLSACambioFechaTicket,
    BOLSAPatrimoniOfa, BOLSARecargaTFA, BOLSAAsociarCuenta,
    BOLSATransferenciaClasica, BOLSAConsultaMiBoleto, BOLSAConsultaSindicato,
    BOLSACompraMiBoleto, BOLSAVendedorMiBoleto, BOLSAVotoMovil,
    BOLSATransferenciaClasicaEmpresarial, BOLSAPagoExternoClasicaEmpresarial,

    // --- Other ---
    Bulevar, ConsultaSellos
}
