package cu.etecsa.transfermovil.data;

import android.content.Context;
import android.util.Log;

import com.github.paolorotolo.appintro.BuildConfig;

import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.data.entity.Municipio;
import cu.etecsa.transfermovil.data.entity.Operacion;
import cu.etecsa.transfermovil.data.entity.Provincia;
import cu.etecsa.transfermovil.data.entity.Tributo;
import cu.etecsa.transfermovil.data.model.BankType;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Builds and manages operation menus for all bank/service types in the application.
 * <p>
 * Operations are menu items displayed to users, organized by service type:
 * General (ETECSA mobile services), Agent (recharge agents), BPA, BANDEC,
 * Metropolitano (banks), and MiTransfer/Bolsa (digital wallet).
 * <p>
 * Two population strategies exist:
 * <ul>
 *   <li>{@link #fillList(Context)} - Builds in-memory lists then upserts each operation
 *       via {@link #updateOperation(Operacion)}. Used for app upgrades.</li>
 *   <li>{@link #fill_all(Context)} - Inserts all operations directly to the database.
 *       Used for fresh installs.</li>
 * </ul>
 * <p>
 * Update methods ({@code update_*}) patch icons and fragment references for
 * version-specific UI refreshes without recreating operations.
 * <p>
 * Note: {@code BuildConfig.FLAVOR} resolves to "" (empty string) and is used for
 * operations that have no dedicated fragment (handled by USSD/SMS dispatch instead).
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.nljtDl5MIf
 * @fingerprint 3842-line operation menu builder. Creates bank/service operation lists.
 */
public class OperationMenuBuilder {

    private static final String TAG = "OPERLOG";

    public Context context;
    public List<Operacion> listGenerales = new ArrayList<>();
    public List<Operacion> listAgente = new ArrayList<>();
    public List<Operacion> listBPA = new ArrayList<>();
    public List<Operacion> listBANDEC = new ArrayList<>();
    public List<Operacion> listMETRO = new ArrayList<>();
    public List<Operacion> listBolsa = new ArrayList<>();

    // -------------------------------------------------------------------------
    // Helper: creates a fully-configured Operacion instance.
    // fragment "" means the operation is handled via USSD/SMS, not a UI fragment.
    // -------------------------------------------------------------------------

    private Operacion createOp(String titulo, String subtitulo, int imagen,
                               String fragmentName, BankType tipo,
                               int order, BankOperationCode operacion, boolean activo) {
        Operacion op = new Operacion();
        op.setTitulo(titulo);
        op.setSubtitulo(subtitulo);
        op.setImagen(imagen);
        op.setFragment_name(fragmentName);
        op.setTipo_serivicio(tipo);
        op.setOrder(order);
        op.setOperacion(operacion);
        op.setActivo(activo);
        return op;
    }

    // =========================================================================
    // fillList: Build in-memory lists, then upsert all operations to database.
    // Used when upgrading from a previous version.
    // =========================================================================

    public void fillList(Context context) {
        this.context = context;

        // --- Agent operations (ETECSA recharge agent) ---
        BankType etecsa = BankType.ETECSA;

        listAgente.add(createOp("Autenticar", "Recarga Movil",
                R.drawable.ic_autenticacion_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60",
                etecsa, -1, BankOperationCode.AGAutenticar, true));

        listAgente.add(createOp("Consultar Saldo", "Recarga Movil",
                R.drawable.ic_consultar_saldo_222,
                BuildConfig.FLAVOR, etecsa, -1, BankOperationCode.AGConsultarSaldo, true));

        listAgente.add(createOp("Recargar", "Recarga Movil",
                R.drawable.ic_recargar_saldo_movil,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW",
                etecsa, -1, BankOperationCode.AGRecargar, true));

        listAgente.add(createOp("Ultimas Recargas", "Recarga Movil",
                R.drawable.ic_ultimas_recargas_agente,
                BuildConfig.FLAVOR, etecsa, -1, BankOperationCode.AGUltimasRecargas, true));

        listAgente.add(createOp("Cambiar clave", "Recarga Movil",
                R.drawable.ic_cambio_pin_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD",
                etecsa, -1, BankOperationCode.AGCambiarclave, true));

        listAgente.add(createOp("Desconectar", "Recarga Movil",
                R.drawable.ic_desconcetarse_agente,
                BuildConfig.FLAVOR, etecsa, -1, BankOperationCode.AGDesconectar, true));

        listAgente.add(createOp("Recargar", "Recarga Nauta",
                R.drawable.ic_recarga_nauta_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1",
                etecsa, -1, BankOperationCode.AGRecargarNauta, true));

        listAgente.add(createOp("Ultimas recargas", "Recarga Nauta",
                R.drawable.ic_ultimas_recargas_ag,
                BuildConfig.FLAVOR, etecsa, -1, BankOperationCode.AGConsultarNautaUlt, true));

        listAgente.add(createOp(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.paquetes_cubacel_agentes,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.WyYHxgzYyW",
                etecsa, -1, BankOperationCode.BOLSAPaquetesCubacel, true));

        listAgente.add(createOp(context.getString(R.string.banco_telefono),
                context.getString(R.string.banco_sub_telefono),
                R.drawable.bolsa_ag_factura_telefonica,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS",
                etecsa, -1, BankOperationCode.BOLSAAGFacturaTelefonica, true));

        listAgente.add(createOp(context.getString(R.string.menu_title_recarga_movil_bolsa),
                context.getString(R.string.menu_sub_recarga_movil_bolsa),
                R.drawable.bolsa_ag_recarga_movil,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaMovil, true));

        listAgente.add(createOp(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.bolsa_ag_recarga_nauta,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaNauta, true));

        listAgente.add(createOp(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.bolsa_ag_recarga_propia,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.BpgQdOQz0p",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaPropia, true));

        // --- General operations (ETECSA mobile services, no bank) ---
        BankType general = BankType.General;

        listGenerales.add(createOp("Consulta tu Saldo Prepago", "Marcando *222#",
                R.drawable.ico_agent_consultar_factura_color,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultaSaldo222, true));

        listGenerales.add(createOp("Consulta tu Saldo Pospago", "Marcando *111#",
                R.drawable.ico_agent_consultar_factura_color,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultaSaldo111, true));

        listGenerales.add(createOp("LLamar", "Realizar LLamada",
                R.drawable.ic_llamar,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2",
                general, -1, BankOperationCode.LLamada, true));

        listGenerales.add(createOp("Llamar con *99", "El destinatario paga",
                R.drawable.ic_llamar_con_99,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2",
                general, -1, BankOperationCode.Llamar99, true));

        listGenerales.add(createOp("Recarga tu Movil con Cupon",
                "Recargar movil con cupon de recarga ",
                R.drawable.ic_recargar_naura_cupon_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu",
                general, -1, BankOperationCode.RecargarMovilBono, true));

        listGenerales.add(createOp("Transferir tu Saldo", "Transferencia de saldo",
                R.drawable.ic_transferir_saldo,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL",
                general, -1, BankOperationCode.TransferirSaldoMovil, true));

        listGenerales.add(createOp("Cambiar su clave de transferencia", "Cambio de clave",
                R.drawable.ic_cambio_pin_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP",
                general, -1, BankOperationCode.CambioClave, true));

        listGenerales.add(createOp(context.getString(R.string.title_consultar_estado_bono),
                context.getString(R.string.subtitle_consultar_estado_bono),
                R.drawable.ic_consultar_bono,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultarEstadoBono, true));

        listGenerales.add(createOp(context.getString(R.string.title_gestion_planes),
                context.getString(R.string.subtitle_gestion_planes),
                R.drawable.ic_plan_amigos,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.GestionPlanes, true));

        listGenerales.add(createOp(context.getString(R.string.title_consultar_plan_datos),
                context.getString(R.string.subtitle_consultar_plan_datos),
                R.drawable.ic_consultar_plan_datos,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultarPlanDatos, true));

        listGenerales.add(createOp(context.getString(R.string.title_consultar_plan_voz),
                context.getString(R.string.subtitle_consultar_plan_voz),
                R.drawable.ic_consultar_plan_voz,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultarPlanVoz, true));

        listGenerales.add(createOp(context.getString(R.string.consultar_plan_sms),
                context.getString(R.string.subconsultar_plan_sms),
                R.drawable.ic_consultar_plan_sms,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultarPlanSMS, true));

        listGenerales.add(createOp(context.getString(R.string.consultar_plan_amigos),
                context.getString(R.string.subconsultar_plan_amigos),
                R.drawable.ic_consultar_plan_amigo,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.ConsultarPlanAmigos, true));

        listGenerales.add(createOp(context.getString(R.string.title_operaciones_adelanta),
                context.getString(R.string.detail_operaciones_adelanta),
                R.drawable.ic_adelantar_saldo,
                BuildConfig.FLAVOR, general, -1, BankOperationCode.AdelantaSaldo, true));

        // --- BPA operations ---
        BankType bpa = BankType.BPA;

        listBPA.add(createOp("Autenticarse", "BPA",
                R.drawable.ic_autenticacion_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.lzGEfceoJu",
                bpa, 6, BankOperationCode.BPAAutenticarse, true));

        listBPA.add(createOp("Transferencia", "BPA",
                R.drawable.ic_transferencia_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h",
                bpa, -1, BankOperationCode.BPATransferencia, true));

        listBPA.add(createOp("Electricidad", "BPA",
                R.drawable.ic_pago_factura_electricidad_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.xSwGh0MTOg",
                bpa, -1, BankOperationCode.BPAElectricidad, true));

        listBPA.add(createOp("Telecomunicaciones", "BPA",
                R.drawable.ic_pago_tfa_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.u4QMc0S0ZHo",
                bpa, -1, BankOperationCode.BPATelefono, true));

        listBPA.add(createOp("ONAT", "BPA",
                R.drawable.ic_pago_onat_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAONAT, true));

        listBPA.add(createOp("Consultar Saldo", "BPA",
                R.drawable.ic_consulta_saldo_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.ix4mhKGJty",
                bpa, -1, BankOperationCode.BPAConsultarSaldo, true));

        listBPA.add(createOp("Consultar Servicio", "BPA",
                R.drawable.ic_consultar_servicio_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT",
                bpa, -1, BankOperationCode.BPAConsultarServicio, true));

        listBPA.add(createOp("Ultimas operaciones", "BPA",
                R.drawable.ic_consulta_utlimas_oper_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.h3sd43nvje",
                bpa, -1, BankOperationCode.BPAUltimasoperaciones, true));

        listBPA.add(createOp("Registrarse", "BPA",
                R.drawable.ic_registrarse_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.IixhA1yamp",
                bpa, 5, BankOperationCode.BPARegistrarse, true));

        listBPA.add(createOp("Cambiar clave", "BPA",
                R.drawable.ic_cambio_pin_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.PQmKwgxZd1",
                bpa, -1, BankOperationCode.BPACambiarclave, true));

        listBPA.add(createOp("Desconectar", "BPA",
                R.drawable.ic_desconectarse_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPADesconectar, true));

        listBPA.add(createOp("Recarga Movil", "BPA",
                R.drawable.ic_recarga_saldo_movil_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPARecargaMovil, true));

        listBPA.add(createOp("Cambio de limite", "BPA",
                R.drawable.ic_cambio_limites_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.qmcwKV1fzU",
                bpa, -1, BankOperationCode.BPACambioLimite, true));

        listBPA.add(createOp("Consulta de limites", "BPA",
                R.drawable.ic_consulta_limites_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.e8WK1Uajbq",
                bpa, -1, BankOperationCode.BPAConsultaLimite, true));

        listBPA.add(createOp(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAPagoExterno, true));

        listBPA.add(createOp(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPARecargaNauta, true));

        listBPA.add(createOp(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.o6kycf55Gw",
                bpa, -1, BankOperationCode.BPAGiroPostal, true));

        listBPA.add(createOp(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.XvOK7VM4qL",
                bpa, -1, BankOperationCode.BPAConsultarGiroPostal, true));

        listBPA.add(createOp(context.getString(R.string.title_service_bpa_consulta_integrada),
                context.getString(R.string.sub_service_bpa_consulta_integrada),
                R.drawable.ic_consulta_todas_cuentas_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAConsultarTodasCuentas, true));

        listBPA.add(createOp(context.getString(R.string.title_service_bpa_amortizar),
                context.getString(R.string.sub_service_bpa_amortizar),
                R.drawable.ic_amortizar_credito_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.Dm6u4PA5eg",
                bpa, -1, BankOperationCode.BPAAmortizar, true));

        listBPA.add(createOp(context.getString(R.string.title_service_bpa_consulta_credito),
                context.getString(R.string.sub_service_consulta_credito),
                R.drawable.ic_consulta_credito_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAConsultaCredito, true));

        listBPA.add(createOp(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPARecargaPropia, true));

        listBPA.add(createOp(context.getString(R.string.title_service_bpa_agua),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.zOs55UzH6z",
                bpa, -1, BankOperationCode.BPAAgua, true));

        listBPA.add(createOp(context.getString(R.string.title_service_bpa_gas),
                context.getString(R.string.sub_service_bpa_gas),
                R.drawable.ic_pago_factura_gas_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.FgpBLXKm6t",
                bpa, -1, BankOperationCode.BPAGas, true));

        listBPA.add(createOp(context.getString(R.string.title_jclub),
                context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAJClub, true));

        listBPA.add(createOp(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPARecargaBolsa, true));

        listBPA.add(createOp(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAPaquetesCubacel, true));

        listBPA.add(createOp(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAReservasTicket, true));

        listBPA.add(createOp(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPAPCC, true));

        listBPA.add(createOp(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_bpa,
                BuildConfig.FLAVOR, bpa, -1, BankOperationCode.BPARecargaTFA, true));

        // --- BANDEC operations ---
        BankType bandec = BankType.BANDEC;

        listBANDEC.add(createOp("Autenticarse", "BANDEC",
                R.drawable.ic_autenticacion_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TGFziPh3KJ",
                bandec, 8, BankOperationCode.BANAutenticar, true));

        listBANDEC.add(createOp("Transferencia", "BANDEC",
                R.drawable.ic_transferencia_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ZDkigMAIBm",
                bandec, -1, BankOperationCode.BANTransferencia, true));

        listBANDEC.add(createOp("Electricidad", "BANDEC",
                R.drawable.ic_pago_factura_electricidad_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.Q3Nvf439ab",
                bandec, -1, BankOperationCode.BANElectricidad, true));

        listBANDEC.add(createOp("Telecomunicaciones", "BANDEC",
                R.drawable.ic_pago_factura_telefono_fijo_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.iQte15zdZs",
                bandec, -1, BankOperationCode.BANTelefono, true));

        listBANDEC.add(createOp("ONAT", "BANDEC",
                R.drawable.ic_pago_onat_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANONAT, true));

        listBANDEC.add(createOp("Consultar Saldo", "BANDEC",
                R.drawable.ic_consulta_saldo_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANConsultarSaldo, true));

        listBANDEC.add(createOp("Consultar Servicio", "BANDEC",
                R.drawable.ic_consultar_servicio_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3",
                bandec, -1, BankOperationCode.BANConsultarServicio, true));

        listBANDEC.add(createOp("Ultimas operaciones", "BANDEC",
                R.drawable.ic_consulta_utlimas_oper_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.gaJlF6dT3z",
                bandec, -1, BankOperationCode.BANUltimasoperaciones, true));

        listBANDEC.add(createOp("Registrarse", "BANDEC",
                R.drawable.ic_registrarse_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.wLHKkaC4Ha",
                bandec, 7, BankOperationCode.BANRegistrarse, true));

        listBANDEC.add(createOp("Cambiar clave", "BANDEC",
                R.drawable.ic_cambio_pin_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.FtAKxvNjrD",
                bandec, -1, BankOperationCode.BANCambiarclave, true));

        listBANDEC.add(createOp("Desconectar", "BANDEC",
                R.drawable.ic_desconectarse_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANDesconectar, true));

        listBANDEC.add(createOp("Eliminar Registro", "BANDEC",
                R.drawable.ic_eliminar_registro_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANEliminarRegistro, true));

        listBANDEC.add(createOp("Recarga Movil", "BANDEC",
                R.drawable.ic_recarga_saldo_movil_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANRecargaMovil, true));

        listBANDEC.add(createOp("Cambio de limite", "BANDEC",
                R.drawable.ic_cambio_limites_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.uWkWt7AEZ5",
                bandec, -1, BankOperationCode.BANCambioLimite, true));

        listBANDEC.add(createOp("Consulta de limites", "BANDEC",
                R.drawable.ic_consulta_limites_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANConsultaLimite, true));

        listBANDEC.add(createOp("Ultimos pagos realizados", "BANDEC",
                R.drawable.ic_consulta_credito_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANUltimosPagos, true));

        listBANDEC.add(createOp("Cambio de cuenta", "BANDEC",
                R.drawable.ic_actualizar_cuenta_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.o9swVUfDl4q",
                bandec, -1, BankOperationCode.BANCambioCuenta, true));

        listBANDEC.add(createOp("Amortizar Credito", "BANDEC",
                R.drawable.ic_amortizar_credito_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.LZaBQezxPC",
                bandec, -1, BankOperationCode.BANAmortizar, true));

        listBANDEC.add(createOp("Consultar Todas las Cuentas", "BANDEC",
                R.drawable.ic_consulta_todas_cuentas_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANConsultarTodasCuentas, true));

        listBANDEC.add(createOp(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANPagoExterno, true));

        listBANDEC.add(createOp(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANRecargaNauta, true));

        listBANDEC.add(createOp(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ASLdujtVtr",
                bandec, -1, BankOperationCode.BANGiroPostal, true));

        listBANDEC.add(createOp(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.gsthr0APCT",
                bandec, -1, BankOperationCode.BANConsultarGiroPostal, true));

        listBANDEC.add(createOp(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.aiwIHVBe0c",
                bandec, -1, BankOperationCode.BANGas, true));

        listBANDEC.add(createOp(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANRecargaPropia, true));

        listBANDEC.add(createOp(context.getString(R.string.title_service_bpa_agua),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt",
                bandec, -1, BankOperationCode.BANAgua, true));

        // NOTE: Original bug - recargaJClubBANDEC is created but recargaJClub (BPA's) is added
        listBANDEC.add(createOp(context.getString(R.string.title_jclub),
                context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANJClub, true));

        listBANDEC.add(createOp(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.SZARzeWeX5",
                bandec, -1, BankOperationCode.BANPatrimoniOfa, true));

        listBANDEC.add(createOp(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANRecargaBolsa, true));

        listBANDEC.add(createOp(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANPaquetesCubacel, true));

        listBANDEC.add(createOp(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANReservasTicket, true));

        // NOTE: Original bug - pccBANDEC and tfaBANDEC are added to listBPA instead of listBANDEC
        listBPA.add(createOp(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANPCC, true));

        listBPA.add(createOp(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_bandec,
                BuildConfig.FLAVOR, bandec, -1, BankOperationCode.BANRecargaTFA, true));

        // --- Metropolitano operations ---
        BankType metro = BankType.Metropolitano;

        listMETRO.add(createOp("Autenticarse", "Metropolitano",
                R.drawable.ic_autenticacion_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PAZK2sdsJ5",
                metro, 4, BankOperationCode.METROAutenticarse, true));

        listMETRO.add(createOp("Consultar Saldo", "Metropolitano",
                R.drawable.ic_consulta_saldo_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.dVxDCMi9cK",
                metro, -1, BankOperationCode.METROConsultarSaldo, true));

        listMETRO.add(createOp("Consultar Servicio", "Metropolitano",
                R.drawable.ic_consultar_servicio_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr",
                metro, -1, BankOperationCode.METROConsultarServicio, true));

        listMETRO.add(createOp("Transferir Efectivo", "Metropolitano",
                R.drawable.ic_transferencia_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U",
                metro, -1, BankOperationCode.METROTransferirEfectivo, true));

        listMETRO.add(createOp("Telecomunicaciones", "Metropolitano",
                R.drawable.ic_pago_factura_telefono_fijo_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7",
                metro, -1, BankOperationCode.METROTelefono, true));

        listMETRO.add(createOp("Electricidad", "Metropolitano",
                R.drawable.ic_pago_factura_electricidad_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.PliSaYhOg0",
                metro, -1, BankOperationCode.METROElectricidad, true));

        listMETRO.add(createOp("Agua", "Metropolitano",
                R.drawable.ic_pago_factura_agua_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.BoMBck6OXT",
                metro, -1, BankOperationCode.METROAgua, true));

        listMETRO.add(createOp("Impuestos", "Metropolitano",
                R.drawable.ic_pago_onat_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROImpuestos, true));

        listMETRO.add(createOp("Ultimas operaciones", "Metropolitano",
                R.drawable.ic_consulta_utlimas_oper_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.GhhAuUBVrI",
                metro, -1, BankOperationCode.METROUltimasoperaciones, true));

        listMETRO.add(createOp("Registrarse", "Metropolitano",
                R.drawable.ic_registrarse_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.RFBEnXW0Xr",
                metro, 3, BankOperationCode.METRORegistrarse, true));

        listMETRO.add(createOp("Desconectar", "Metropolitano",
                R.drawable.ic_desconectarse_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRODesconectar, true));

        listMETRO.add(createOp("Actualizar cuenta", "Metropolitano",
                R.drawable.ic_actualizar_cuenta_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.uurdBwh7ub",
                metro, -1, BankOperationCode.METROActualizarcuenta, true));

        listMETRO.add(createOp("Recarga Movil", "Metropolitano",
                R.drawable.ic_recarga_saldo_movil_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRORecargaMovil, true));

        listMETRO.add(createOp("Cambio de limite", "Metropolitano",
                R.drawable.ic_cambio_limites_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE",
                metro, -1, BankOperationCode.METROCambioLimite, true));

        listMETRO.add(createOp("Consulta de limites", "Metropolitano",
                R.drawable.ic_consulta_limites_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.gkzzwVYksz",
                metro, -1, BankOperationCode.METROConsultaLimite, true));

        listMETRO.add(createOp("Consultar Todas las Cuentas", "Metropolitano",
                R.drawable.ic_consulta_todas_cuentas_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROConsultaTodasCuentas, true));

        listMETRO.add(createOp(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb",
                metro, -1, BankOperationCode.METROGas, true));

        listMETRO.add(createOp(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROPagoExterno, true));

        listMETRO.add(createOp(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.mhElzRz7zH",
                metro, -1, BankOperationCode.METROGiroPostal, true));

        listMETRO.add(createOp(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.jyBbMyVMOV",
                metro, -1, BankOperationCode.METROConsultarGiroPostal, true));

        listMETRO.add(createOp(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRORecargaNauta, true));

        listMETRO.add(createOp(context.getString(R.string.title_reimprimir_tarjeta),
                context.getString(R.string.sub_reimprimir_tarjeta),
                R.drawable.ic_reimprimir_tarjeta_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROReimprimirTarjeta, true));

        listMETRO.add(createOp(context.getString(R.string.title_metro_localizar_transferencias),
                context.getString(R.string.sub_localizar_transferencias),
                R.drawable.ic_localizar_transferencia_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROLocalizarTransferencia, true));

        listMETRO.add(createOp(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRORecargaPropia, true));

        listMETRO.add(createOp(context.getString(R.string.title_jclub),
                context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROJClub, true));

        listMETRO.add(createOp(context.getString(R.string.title_tipo_cambio),
                context.getString(R.string.sub_tipo_cambio),
                R.drawable.ic_tipo_cambio_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROTipoCambio, true));

        listMETRO.add(createOp(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.lQox6tgMlH",
                metro, -1, BankOperationCode.METROPatrimoniOfa, true));

        listMETRO.add(createOp(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRORecargaBolsa, true));

        listMETRO.add(createOp(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROPaquetesCubacel, true));

        listMETRO.add(createOp(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROReservasTicket, true));

        listMETRO.add(createOp(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METROPCC, true));

        listMETRO.add(createOp(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_metro,
                BuildConfig.FLAVOR, metro, -1, BankOperationCode.METRORecargaTFA, true));

        // --- MiTransfer / Bolsa operations (digital wallet) ---
        BankType bolsaType = BankType.MiTransfer;

        listBolsa.add(createOp(context.getString(R.string.tx_registrarse),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_registrarse_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.eUkRSfpCKs",
                bolsaType, 1, BankOperationCode.BOLSARegistrarse, true));

        listBolsa.add(createOp(context.getString(R.string.tx_autenticarse),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_autenticacion_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qZS87tGogtP.R5fFZkKuVnr",
                bolsaType, 2, BankOperationCode.BOLSAAutenticarse, true));

        listBolsa.add(createOp(context.getString(R.string.tx_consultar_saldo),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_consulta_saldo_bolsa,
                BuildConfig.FLAVOR, bolsaType, 10, BankOperationCode.BOLSAConsultarSaldo, true));

        listBolsa.add(createOp(context.getString(R.string.tx_ultimas_operaciones),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_consulta_utlimas_oper_bolsa,
                BuildConfig.FLAVOR, bolsaType, 10, BankOperationCode.BOLSAUltimasOperaciones, true));

        listBolsa.add(createOp(context.getString(R.string.menu_title_transferencia_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_transferencia_bolsa,
                BuildConfig.FLAVOR, bolsaType, 11, BankOperationCode.BOLSATransferencia, true));

        listBolsa.add(createOp(context.getString(R.string.banco_telefono),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_factura_telefono_fijo_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.p5B8KozjvpQ",
                bolsaType, 12, BankOperationCode.BOLSATelefono, true));

        listBolsa.add(createOp(context.getString(R.string.menu_title_recarga_movil_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_recarga_saldo_movil_bolsa,
                BuildConfig.FLAVOR, bolsaType, 13, BankOperationCode.BOLSARecargaMovil, true));

        listBolsa.add(createOp(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_nauta_hogar_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.KtF0PRB8vS",
                bolsaType, 14, BankOperationCode.BOLSARecargaNauta, true));

        listBolsa.add(createOp(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_recarga_tarjeta_propia_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI",
                bolsaType, 15, BankOperationCode.BOLSARecargaPropia, true));

        listBolsa.add(createOp(context.getString(R.string.title_pago_externo),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_linea_bolsa,
                BuildConfig.FLAVOR, bolsaType, 16, BankOperationCode.BOLSAPagoLinea, true));

        listBolsa.add(createOp(context.getString(R.string.menu_title_compra_paquete_mlc_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_paquetes_combinados_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f3Ttlx30sMT",
                bolsaType, 17, BankOperationCode.BOLSACompraPaqueteMLC, true));

        listBolsa.add(createOp(context.getString(R.string.menu_title_compra_nauta_plus_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_nauta_plus_bolsa,
                BuildConfig.FLAVOR, bolsaType, 18, BankOperationCode.BOLSARecargaNautaMLC, true));

        listBolsa.add(createOp(context.getString(R.string.tx_consultar_servicio_bolsa),
                context.getString(R.string.tx_sub_consultar_servicio_bolsa),
                R.drawable.ic_consultar_servicio_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb",
                bolsaType, 19, BankOperationCode.BOLSAConsultaServicio, true));

        listBolsa.add(createOp(context.getString(R.string.banco_desconectar),
                context.getString(R.string.banco_sub_desconectar),
                R.drawable.ic_desconectarse_bolsa,
                BuildConfig.FLAVOR, bolsaType, 20, BankOperationCode.BOLSADesconectar, true));

        listBolsa.add(createOp(context.getString(R.string.menu_tite_recarga_cup_ticket),
                context.getString(R.string.menu_sub_recarga_cup_ticket),
                R.drawable.ic_recargar_monedero_cup_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR",
                bolsaType, 21, BankOperationCode.BOLSARecargaCUPWalletTicket, true));

        listBolsa.add(createOp(context.getString(R.string.menu_tite_extraccion_efectivo_ticket),
                context.getString(R.string.menu_sub_extraccion_efectivo_ticket),
                R.drawable.ic_extraer_efectivo_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ",
                bolsaType, 22, BankOperationCode.BOLSAExtraccionWalletTicket, true));

        listBolsa.add(createOp(context.getString(R.string.menu_tite_transferir_bolsa_bancos),
                context.getString(R.string.menu_sub_transferir_bolsa_bancos),
                R.drawable.ic_transferir_cuentas_banco_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS",
                bolsaType, 23, BankOperationCode.BOLSATransferirBancos, true));

        listBolsa.add(createOp(context.getString(R.string.banco_electricidad),
                context.getString(R.string.banco_sub_electricidad),
                R.drawable.ic_pago_factura_electricidad_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dwdZ5sHcFR",
                bolsaType, 24, BankOperationCode.BOLSAElectricidad, true));

        listBolsa.add(createOp(context.getString(R.string.title_pago_agua_hab),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.U1sIOmca96i",
                bolsaType, 25, BankOperationCode.BOLSAAgua, true));

        listBolsa.add(createOp(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XCDkgbw8oZ",
                bolsaType, 26, BankOperationCode.BOLSAgas, true));

        listBolsa.add(createOp(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.WyYHxgzYyW",
                bolsaType, 27, BankOperationCode.BOLSAPaquetesCubacel, true));

        listBolsa.add(createOp(context.getString(R.string.title_reservas_ofa),
                context.getString(R.string.tx_sub_patrimonio_bolsa),
                R.drawable.ic_reserva_ofa_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS",
                bolsaType, 28, BankOperationCode.BOLSAReservasOFA, true));

        listBolsa.add(createOp(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_pago_miturno_bolsa,
                BuildConfig.FLAVOR, bolsaType, 29, BankOperationCode.BOLSAReservasTicket, true));

        listBolsa.add(createOp(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bolsa,
                BuildConfig.FLAVOR, bolsaType, 30, BankOperationCode.BOLSAPCC, true));

        listBolsa.add(createOp(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_tfa_bolsa,
                BuildConfig.FLAVOR, bolsaType, 30, BankOperationCode.BOLSARecargaTFA, true));

        listBolsa.add(createOp(context.getString(R.string.tx_title_clasica),
                context.getString(R.string.tx_subtitle_clasica),
                R.drawable.ic_asociar_cuenta_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb",
                bolsaType, 31, BankOperationCode.BOLSAAsociarCuenta, true));

        listBolsa.add(createOp(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.C6ZYln3x19W",
                bolsaType, 32, BankOperationCode.BOLSAAporteOFA, true));

        listBolsa.add(createOp(context.getString(R.string.title_consulta_miboleto),
                context.getString(R.string.subtitle_consulta_miboleto),
                R.drawable.ic_consulta_miboleto_bolsa,
                BuildConfig.FLAVOR, bolsaType, 33, BankOperationCode.BOLSAConsultaMiBoleto, true));

        listBolsa.add(createOp(context.getString(R.string.title_compra_miboleto),
                context.getString(R.string.subtitle_compra_miboleto),
                R.drawable.ic_miboleto_pago_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA",
                bolsaType, 34, BankOperationCode.BOLSACompraMiBoleto, true));

        listBolsa.add(createOp(context.getString(R.string.msg_votomovil_etecsa),
                context.getString(R.string.msg_votomovil_descrip_etecsa),
                R.drawable.ic_voto_movil,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN",
                bolsaType, 35, BankOperationCode.BOLSAVotoMovil, true));

        listBolsa.add(createOp(context.getString(R.string.tx_transferencia_clasica_empresa),
                context.getString(R.string.ly_title_transferencia_a_clasica_empresa),
                R.drawable.ico_transfer_clasica,
                BuildConfig.FLAVOR, bolsaType, -1,
                BankOperationCode.BOLSATransferenciaClasicaEmpresarial, true));

        listBolsa.add(createOp(context.getString(R.string.title_pago_externo_empresarial),
                context.getString(R.string.sub_pago_externo_empresarial),
                R.drawable.ic_pago_linea_empresarial,
                BuildConfig.FLAVOR, bolsaType, -1,
                BankOperationCode.BOLSAPagoExternoClasicaEmpresarial, true));

        // --- Persist all lists to database via upsert ---
        for (Operacion item : listAgente) {
            updateOperation(item);
        }
        for (Operacion item : listGenerales) {
            updateOperation(item);
        }
        for (Operacion item : listBPA) {
            updateOperation(item);
        }
        for (Operacion item : listBANDEC) {
            updateOperation(item);
        }
        for (Operacion item : listMETRO) {
            updateOperation(item);
        }
        for (Operacion item : listBolsa) {
            updateOperation(item);
        }

        // Clean up deprecated operations
        try {
            DatabaseHelper db = DatabaseHelper.getInstance();
            db.deleteOperacion(db.getOperacion(BankOperationCode.AGPredeterminarTarjeta));
            db.deleteOperacion(db.getOperacion(BankOperationCode.AGConsultarFactura));
            db.deleteOperacion(db.getOperacion(BankOperationCode.AGPagarFactura));
            db.deleteOperacion(db.getOperacion(BankOperationCode.AGUltimosPago));
            db.deleteOperacion(db.getOperacion(BankOperationCode.AGRectificarPago));
            db.deleteOperacion(db.getOperacion(BankOperationCode.VotoMovil));
        } catch (Exception e) {
            // Silently ignore — these operations may not exist in the database
        }
    }

    // -------------------------------------------------------------------------
    // Upsert logic: update existing operation or insert new one.
    // If duplicates exist, delete all and re-insert.
    // -------------------------------------------------------------------------

    private void updateOperation(Operacion operacion) {
        try {
            DatabaseHelper db = DatabaseHelper.getInstance();
            Operacion original = db.getOperacion(operacion.getOperacion());
            if (original != null) {
                // Handle duplicate entries — delete all and re-insert
                if (db.getCountOperacion(operacion.getOperacion()) > 1) {
                    for (Operacion duplicate : db.getListOperacion(operacion.getOperacion())) {
                        db.deleteOperacion(duplicate);
                    }
                    db.addOperacion(operacion);
                    return;
                }
                // Normal case — update mutable fields on the existing record
                original.setFragment_name(operacion.getFragment_name());
                original.setImagen(operacion.getImagen());
                original.setTitulo(operacion.getTitulo());
                original.setSubtitulo(operacion.getSubtitulo());
                db.updateOperacion(original);
                return;
            }
            // New operation — insert
            db.addOperacion(operacion);
        } catch (Exception ex) {
            // Recovery: delete corrupt entry and re-insert
            try {
                DatabaseHelper db = DatabaseHelper.getInstance();
                db.deleteOperacion(db.getOperacion(operacion.getOperacion()));
                db.addOperacion(operacion);
            } catch (Exception e) {
                Log.e(TAG, ex.getMessage());
            }
        }
    }

    // =========================================================================
    // fill_all: Fresh install — insert all operations directly to database.
    // Also loads geographic (DPA) and tax (tributos) reference data.
    // =========================================================================

    public void fill_all(Context context) {
        this.context = context;
        fill_generales();
        fill_agente();
        fill_banco_bpa();
        fill_banco_bandec();
        fill_banco_metro();
        fill_provincias(context);
        fill_municipios(context);
        fill_tributos(context);
        fill_banco_bolsa();
    }

    // -------------------------------------------------------------------------
    // Helper: creates and directly inserts an operation to the database.
    // -------------------------------------------------------------------------

    private void addOpToDb(String titulo, String subtitulo, int imagen,
                           String fragmentName, BankType tipo,
                           int order, BankOperationCode operacion, boolean activo) {
        DatabaseHelper.getInstance().addOperacion(
                createOp(titulo, subtitulo, imagen, fragmentName, tipo, order, operacion, activo));
    }

    // -------------------------------------------------------------------------
    // fill_generales: General ETECSA mobile service operations
    // -------------------------------------------------------------------------

    public void fill_generales() {
        BankType general = BankType.General;

        addOpToDb("Consulta tu Saldo Prepago", "Marcando *222#",
                R.drawable.ic_consultar_saldo_222, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultaSaldo222, true);

        addOpToDb("Consulta tu Saldo Pospago", "Marcando *111#",
                R.drawable.ic_consultar_saldo_111, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultaSaldo111, true);

        addOpToDb("LLamar", "Realizar LLamada",
                R.drawable.ic_llamar,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2",
                general, -1, BankOperationCode.LLamada, true);

        addOpToDb("Llamar con *99", "El destinatario paga",
                R.drawable.ic_llamar_con_99,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2",
                general, -1, BankOperationCode.Llamar99, true);

        addOpToDb("Recarga tu Movil con Cupon", "Recargar movil con cupon de recarga ",
                R.drawable.ic_recargar_saldo_movil,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu",
                general, -1, BankOperationCode.RecargarMovilBono, true);

        addOpToDb("Transferir tu Saldo", "Transferencia de saldo",
                R.drawable.ic_transferir_saldo,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL",
                general, -1, BankOperationCode.TransferirSaldoMovil, true);

        addOpToDb("Cambiar su clave de transferencia", "Cambio de clave",
                R.drawable.ic_cambiar_clave_transferencia,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP",
                general, -1, BankOperationCode.CambioClave, true);

        addOpToDb(context.getString(R.string.title_consultar_estado_bono),
                context.getString(R.string.subtitle_consultar_estado_bono),
                R.drawable.ic_consultar_bono, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultarEstadoBono, true);

        addOpToDb(context.getString(R.string.title_gestion_planes),
                context.getString(R.string.subtitle_gestion_planes),
                R.drawable.ic_recargar_con_bono, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.GestionPlanes, true);

        addOpToDb(context.getString(R.string.title_consultar_plan_datos),
                context.getString(R.string.subtitle_consultar_plan_datos),
                R.drawable.ic_consultar_plan_datos, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultarPlanDatos, true);

        addOpToDb(context.getString(R.string.title_consultar_plan_voz),
                context.getString(R.string.subtitle_consultar_plan_voz),
                R.drawable.ic_consultar_plan_voz, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultarPlanVoz, true);

        addOpToDb(context.getString(R.string.consultar_plan_sms),
                context.getString(R.string.subconsultar_plan_sms),
                R.drawable.ic_consultar_plan_sms, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultarPlanSMS, true);

        addOpToDb(context.getString(R.string.consultar_plan_amigos),
                context.getString(R.string.subconsultar_plan_amigos),
                R.drawable.ic_consultar_plan_amigo, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.ConsultarPlanAmigos, true);

        addOpToDb(context.getString(R.string.title_operaciones_adelanta),
                context.getString(R.string.detail_operaciones_adelanta),
                R.drawable.ic_adelantar_saldo, BuildConfig.FLAVOR,
                general, -1, BankOperationCode.AdelantaSaldo, true);
    }

    // -------------------------------------------------------------------------
    // fill_agente: ETECSA recharge agent operations.
    // NOTE: Agent operations are inserted as inactive (activo=false) initially.
    // The BOLSA agent operations (factura, recarga, nauta, propia) are active.
    // -------------------------------------------------------------------------

    public void fill_agente() {
        BankType etecsa = BankType.ETECSA;

        // Traditional agent operations (inactive by default — activated on login)
        addOpToDb("Autenticar", "Recarga Movil",
                R.drawable.ic_autenticacion_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60",
                etecsa, -1, BankOperationCode.AGAutenticar, false);

        addOpToDb("Consultar Saldo", "Recarga Movil",
                R.drawable.ic_consultar_saldo_agente, BuildConfig.FLAVOR,
                etecsa, -1, BankOperationCode.AGConsultarSaldo, false);

        addOpToDb("Recargar", "Recarga Movil",
                R.drawable.ic_recarga_movil_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW",
                etecsa, -1, BankOperationCode.AGRecargar, false);

        addOpToDb("Ultimas Recargas", "Recarga Movil",
                R.drawable.ic_ultimas_recargas_agente, BuildConfig.FLAVOR,
                etecsa, -1, BankOperationCode.AGUltimasRecargas, false);

        addOpToDb("Cambiar clave", "Recarga Movil",
                R.drawable.ic_cambio_pin_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD",
                etecsa, -1, BankOperationCode.AGCambiarclave, false);

        addOpToDb("Desconectar", "Recarga Movil",
                R.drawable.ic_desconcetarse_agente, BuildConfig.FLAVOR,
                etecsa, -1, BankOperationCode.AGDesconectar, false);

        addOpToDb("Recargar", "Recarga Nauta",
                R.drawable.ic_recarga_nauta_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1",
                etecsa, -1, BankOperationCode.AGRecargarNauta, false);

        addOpToDb("Ultimas recargas", "Recarga Nauta",
                R.drawable.ic_ultimas_recargas_ag, BuildConfig.FLAVOR,
                etecsa, -1, BankOperationCode.AGConsultarNautaUlt, false);

        // BOLSA agent operations (active)
        addOpToDb(context.getString(R.string.banco_telefono),
                context.getString(R.string.banco_sub_telefono),
                R.drawable.ic_pagar_factura_telf_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS",
                etecsa, -1, BankOperationCode.BOLSAAGFacturaTelefonica, true);

        addOpToDb(context.getString(R.string.menu_title_recarga_movil_bolsa),
                context.getString(R.string.menu_sub_recarga_movil_bolsa),
                R.drawable.ic_recarga_movil_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaMovil, true);

        addOpToDb(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_recarga_nauta_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaNauta, true);

        addOpToDb(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_propia_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.BpgQdOQz0p",
                etecsa, -1, BankOperationCode.BOLSAAGRecargaPropia, true);

        addOpToDb(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_planes_agente,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.WyYHxgzYyW",
                etecsa, -1, BankOperationCode.BOLSAPaquetesCubacel, true);
    }

    // -------------------------------------------------------------------------
    // fill_banco_bpa: BPA bank operations (same structure as fillList BPA section).
    // Identical operations to the fillList BPA block but inserted directly to DB.
    // Order is slightly different: Registrarse comes after Autenticarse.
    // -------------------------------------------------------------------------

    public void fill_banco_bpa() {
        // Structurally identical to the BPA section of fillList().
        // 30 operations: Autenticarse, Registrarse, Transferencia, Electricidad,
        // Telecomunicaciones, ONAT, Consultar Saldo, Consultar Servicio,
        // Ultimas operaciones, Cambiar clave, Desconectar, Recarga Movil,
        // Cambio de limite, Consulta de limites, Pago Externo, Recarga Nauta,
        // Giro Postal, Consultar Giro, Consulta Integrada, Amortizar,
        // Consulta Credito, Recarga Propia, Agua, Gas, JClub, Recarga Bolsa,
        // Paquetes Cubacel, Reserva Ticket, PCC, Recarga TFA
        BankType bpaType = BankType.BPA;

        addOpToDb("Autenticarse", "BPA", R.drawable.ic_autenticacion_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.lzGEfceoJu",
                bpaType, -1, BankOperationCode.BPAAutenticarse, true);

        addOpToDb("Registrarse", "BPA", R.drawable.ic_registrarse_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.IixhA1yamp",
                bpaType, -1, BankOperationCode.BPARegistrarse, true);

        addOpToDb("Transferencia", "BPA", R.drawable.ic_transferencia_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h",
                bpaType, -1, BankOperationCode.BPATransferencia, true);

        // ... 11 more core BPA banking operations (Electricidad through Consulta limites)
        // with identical pattern: string title, "BPA" subtitle, bank-specific drawable,
        // obfuscated fragment name, BPA type, order -1, BankOperationCode.BPA*, active

        addOpToDb("Electricidad", "BPA", R.drawable.ic_pago_factura_electricidad_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.xSwGh0MTOg",
                bpaType, -1, BankOperationCode.BPAElectricidad, true);

        addOpToDb("Telecomunicaciones", "BPA", R.drawable.ic_pago_factura_telefono_fijo_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.u4QMc0S0ZHo",
                bpaType, -1, BankOperationCode.BPATelefono, true);

        addOpToDb("ONAT", "BPA", R.drawable.ic_pago_onat_bpa,
                BuildConfig.FLAVOR, bpaType, -1, BankOperationCode.BPAONAT, true);

        addOpToDb("Consultar Saldo", "BPA", R.drawable.ic_consulta_saldo_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.ix4mhKGJty",
                bpaType, -1, BankOperationCode.BPAConsultarSaldo, true);

        addOpToDb("Consultar Servicio", "BPA", R.drawable.ic_consultar_servicio_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT",
                bpaType, -1, BankOperationCode.BPAConsultarServicio, true);

        addOpToDb("Ultimas operaciones", "BPA", R.drawable.ic_consulta_utlimas_oper_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.h3sd43nvje",
                bpaType, -1, BankOperationCode.BPAUltimasoperaciones, true);

        addOpToDb("Cambiar clave", "BPA", R.drawable.ic_cambio_pin_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.PQmKwgxZd1",
                bpaType, -1, BankOperationCode.BPACambiarclave, true);

        addOpToDb("Desconectar", "BPA", R.drawable.ic_desconectarse_bpa,
                BuildConfig.FLAVOR, bpaType, -1, BankOperationCode.BPADesconectar, true);

        addOpToDb("Recarga Movil", "BPA", R.drawable.ic_recarga_saldo_movil_bpa,
                BuildConfig.FLAVOR, bpaType, -1, BankOperationCode.BPARecargaMovil, true);

        addOpToDb("Cambio de limite", "BPA", R.drawable.ic_cambio_limites_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.qmcwKV1fzU",
                bpaType, -1, BankOperationCode.BPACambioLimite, true);

        addOpToDb("Consulta de limites", "BPA", R.drawable.ic_consulta_limites_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.e8WK1Uajbq",
                bpaType, -1, BankOperationCode.BPAConsultaLimite, true);

        // ... 16 more BPA operations using string resources (Pago Externo through TFA)
        addOpToDb(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAPagoExterno, true);

        addOpToDb(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPARecargaNauta, true);

        addOpToDb(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.o6kycf55Gw",
                bpaType, -1, BankOperationCode.BPAGiroPostal, true);

        addOpToDb(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.XvOK7VM4qL",
                bpaType, -1, BankOperationCode.BPAConsultarGiroPostal, true);

        addOpToDb(context.getString(R.string.title_service_bpa_consulta_integrada),
                context.getString(R.string.sub_service_bpa_consulta_integrada),
                R.drawable.ic_consulta_todas_cuentas_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAConsultarTodasCuentas, true);

        addOpToDb(context.getString(R.string.title_service_bpa_amortizar),
                context.getString(R.string.sub_service_bpa_amortizar),
                R.drawable.ic_amortizar_credito_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.Dm6u4PA5eg",
                bpaType, -1, BankOperationCode.BPAAmortizar, true);

        addOpToDb(context.getString(R.string.title_service_bpa_consulta_credito),
                context.getString(R.string.sub_service_consulta_credito),
                R.drawable.ic_consulta_credito_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAConsultaCredito, true);

        addOpToDb(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPARecargaPropia, true);

        addOpToDb(context.getString(R.string.title_service_bpa_agua),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.zOs55UzH6z",
                bpaType, -1, BankOperationCode.BPAAgua, true);

        addOpToDb(context.getString(R.string.title_service_bpa_gas),
                context.getString(R.string.sub_service_bpa_gas),
                R.drawable.ic_pago_factura_gas_bpa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.FgpBLXKm6t",
                bpaType, -1, BankOperationCode.BPAGas, true);

        addOpToDb(context.getString(R.string.title_jclub), context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAJClub, true);

        addOpToDb(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPARecargaBolsa, true);

        addOpToDb(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAPaquetesCubacel, true);

        addOpToDb(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAReservasTicket, true);

        addOpToDb(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPAPCC, true);

        addOpToDb(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_bpa, BuildConfig.FLAVOR,
                bpaType, -1, BankOperationCode.BPARecargaTFA, true);
    }

    // -------------------------------------------------------------------------
    // fill_banco_bandec: BANDEC bank operations
    // Same 30-operation pattern as BPA with BANDEC-specific drawables/fragments.
    // Includes: Autenticarse, Registrarse, Transferencia, Electricidad,
    // Telecomunicaciones, ONAT, Consultar Saldo, Consultar Servicio,
    // Ultimas operaciones, Cambiar clave, Desconectar, Eliminar Registro,
    // Recarga Movil, Cambio limite, Consulta limites, Ultimos pagos,
    // Cambio cuenta, Amortizar, Consultar Todas Cuentas, Pago Externo,
    // Recarga Nauta, Giro Postal, Consultar Giro, Gas, Recarga Propia,
    // Agua, JClub, OFA/Patrimonio, Recarga Bolsa, Paquetes Cubacel,
    // Reserva Ticket, PCC, Recarga TFA
    // -------------------------------------------------------------------------

    public void fill_banco_bandec() {
        BankType bandecType = BankType.BANDEC;

        addOpToDb("Autenticarse", "BANDEC", R.drawable.ic_autenticacion_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TGFziPh3KJ",
                bandecType, -1, BankOperationCode.BANAutenticar, true);

        addOpToDb("Registrarse", "BANDEC", R.drawable.ic_registrarse_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.wLHKkaC4Ha",
                bandecType, -1, BankOperationCode.BANRegistrarse, true);

        addOpToDb("Transferencia", "BANDEC", R.drawable.ic_transferencia_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ZDkigMAIBm",
                bandecType, -1, BankOperationCode.BANTransferencia, true);

        addOpToDb("Electricidad", "BANDEC", R.drawable.ic_pago_factura_electricidad_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.Q3Nvf439ab",
                bandecType, -1, BankOperationCode.BANElectricidad, true);

        addOpToDb("Telecomunicaciones", "BANDEC", R.drawable.ic_pago_factura_telefono_fijo_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.iQte15zdZs",
                bandecType, -1, BankOperationCode.BANTelefono, true);

        addOpToDb("ONAT", "BANDEC", R.drawable.ic_pago_onat_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANONAT, true);

        addOpToDb("Consultar Saldo", "BANDEC", R.drawable.ic_consulta_saldo_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANConsultarSaldo, true);

        addOpToDb("Consultar Servicio", "BANDEC", R.drawable.ic_consultar_servicio_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3",
                bandecType, -1, BankOperationCode.BANConsultarServicio, true);

        addOpToDb("Ultimas operaciones", "BANDEC", R.drawable.ic_consulta_utlimas_oper_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.gaJlF6dT3z",
                bandecType, -1, BankOperationCode.BANUltimasoperaciones, true);

        addOpToDb("Cambiar clave", "BANDEC", R.drawable.ic_cambio_pin_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.FtAKxvNjrD",
                bandecType, -1, BankOperationCode.BANCambiarclave, true);

        addOpToDb("Desconectar", "BANDEC", R.drawable.ic_desconectarse_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANDesconectar, true);

        addOpToDb("Eliminar Registro", "BANDEC", R.drawable.ic_eliminar_registro_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANEliminarRegistro, true);

        addOpToDb("Recarga Movil", "BANDEC", R.drawable.ic_recarga_saldo_movil_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANRecargaMovil, true);

        addOpToDb("Cambio de limite", "BANDEC", R.drawable.ic_cambio_limites_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.uWkWt7AEZ5",
                bandecType, -1, BankOperationCode.BANCambioLimite, true);

        addOpToDb("Consulta de limites", "BANDEC", R.drawable.ic_consulta_limites_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANConsultaLimite, true);

        addOpToDb("Ultimos pagos realizados", "BANDEC", R.drawable.ic_consulta_credito_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANUltimosPagos, true);

        addOpToDb("Cambio de cuenta", "BANDEC", R.drawable.ic_actualizar_cuenta_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.o9swVUfDl4q",
                bandecType, -1, BankOperationCode.BANCambioCuenta, true);

        addOpToDb("Amortizar Credito", "BANDEC", R.drawable.ic_amortizar_credito_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.LZaBQezxPC",
                bandecType, -1, BankOperationCode.BANAmortizar, true);

        addOpToDb("Consultar Todas las Cuentas", "BANDEC", R.drawable.ic_consulta_todas_cuentas_bandec,
                BuildConfig.FLAVOR, bandecType, -1, BankOperationCode.BANConsultarTodasCuentas, true);

        // ... remaining BANDEC operations using string resources
        addOpToDb(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANPagoExterno, true);

        addOpToDb(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANRecargaNauta, true);

        addOpToDb(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ASLdujtVtr",
                bandecType, -1, BankOperationCode.BANGiroPostal, true);

        addOpToDb(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.gsthr0APCT",
                bandecType, -1, BankOperationCode.BANConsultarGiroPostal, true);

        addOpToDb(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.aiwIHVBe0c",
                bandecType, -1, BankOperationCode.BANGas, true);

        addOpToDb(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANRecargaPropia, true);

        addOpToDb(context.getString(R.string.title_service_bpa_agua),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt",
                bandecType, -1, BankOperationCode.BANAgua, true);

        addOpToDb(context.getString(R.string.title_jclub), context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANJClub, true);

        addOpToDb(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_bandec,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.SZARzeWeX5",
                bandecType, -1, BankOperationCode.BANPatrimoniOfa, true);

        addOpToDb(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANRecargaBolsa, true);

        addOpToDb(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANPaquetesCubacel, true);

        addOpToDb(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANReservasTicket, true);

        addOpToDb(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANPCC, true);

        addOpToDb(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_bandec, BuildConfig.FLAVOR,
                bandecType, -1, BankOperationCode.BANRecargaTFA, true);
    }

    // -------------------------------------------------------------------------
    // fill_banco_metro: Metropolitano bank operations
    // 33 operations including Metro-specific: Actualizar cuenta, Reimprimir
    // Tarjeta, Localizar Transferencia, Tipo de Cambio, OFA/Patrimonio
    // -------------------------------------------------------------------------

    public void fill_banco_metro() {
        BankType metroType = BankType.Metropolitano;

        addOpToDb("Autenticarse", "Metropolitano", R.drawable.ic_autenticacion_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PAZK2sdsJ5",
                metroType, -1, BankOperationCode.METROAutenticarse, true);

        addOpToDb("Registrarse", "Metropolitano", R.drawable.ic_registrarse_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.RFBEnXW0Xr",
                metroType, -1, BankOperationCode.METRORegistrarse, true);

        addOpToDb("Consultar Saldo", "Metropolitano", R.drawable.ic_consulta_saldo_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.dVxDCMi9cK",
                metroType, -1, BankOperationCode.METROConsultarSaldo, true);

        addOpToDb("Consultar Servicio", "Metropolitano", R.drawable.ic_consultar_servicio_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr",
                metroType, -1, BankOperationCode.METROConsultarServicio, true);

        addOpToDb("Transferir Efectivo", "Metropolitano", R.drawable.ic_transferencia_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U",
                metroType, -1, BankOperationCode.METROTransferirEfectivo, true);

        addOpToDb("Telecomunicaciones", "Metropolitano", R.drawable.ic_pago_factura_telefono_fijo_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7",
                metroType, -1, BankOperationCode.METROTelefono, true);

        addOpToDb("Electricidad", "Metropolitano", R.drawable.ic_pago_factura_electricidad_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.PliSaYhOg0",
                metroType, -1, BankOperationCode.METROElectricidad, true);

        addOpToDb("Agua", "Metropolitano", R.drawable.ic_pago_factura_agua_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.BoMBck6OXT",
                metroType, -1, BankOperationCode.METROAgua, true);

        addOpToDb("Impuestos", "Metropolitano", R.drawable.ic_pago_onat_metro,
                BuildConfig.FLAVOR, metroType, -1, BankOperationCode.METROImpuestos, true);

        addOpToDb("Ultimas operaciones", "Metropolitano", R.drawable.ic_consulta_utlimas_oper_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.GhhAuUBVrI",
                metroType, -1, BankOperationCode.METROUltimasoperaciones, true);

        addOpToDb("Desconectar", "Metropolitano", R.drawable.ic_desconectarse_metro,
                BuildConfig.FLAVOR, metroType, -1, BankOperationCode.METRODesconectar, true);

        addOpToDb("Actualizar cuenta", "Metropolitano", R.drawable.ic_actualizar_cuenta_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.uurdBwh7ub",
                metroType, -1, BankOperationCode.METROActualizarcuenta, true);

        addOpToDb("Recarga Movil", "Metropolitano", R.drawable.ic_recarga_saldo_movil_metro,
                BuildConfig.FLAVOR, metroType, -1, BankOperationCode.METRORecargaMovil, true);

        addOpToDb("Cambio de limite", "Metropolitano", R.drawable.ic_cambio_limites_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE",
                metroType, -1, BankOperationCode.METROCambioLimite, true);

        addOpToDb("Consulta de limites", "Metropolitano", R.drawable.ic_consulta_limites_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.gkzzwVYksz",
                metroType, -1, BankOperationCode.METROConsultaLimite, true);

        addOpToDb("Consultar Todas las Cuentas", "Metropolitano", R.drawable.ic_consulta_todas_cuentas_metro,
                BuildConfig.FLAVOR, metroType, -1, BankOperationCode.METROConsultaTodasCuentas, true);

        // ... remaining Metro operations using string resources
        addOpToDb(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb",
                metroType, -1, BankOperationCode.METROGas, true);

        addOpToDb(context.getString(R.string.title_pago_externo),
                context.getString(R.string.sub_pago_externo),
                R.drawable.ic_pago_linea_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROPagoExterno, true);

        addOpToDb(context.getString(R.string.title_giro_postal),
                context.getString(R.string.sub_giro_postal),
                R.drawable.ic_enviar_giro_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.mhElzRz7zH",
                metroType, -1, BankOperationCode.METROGiroPostal, true);

        addOpToDb(context.getString(R.string.title_consulta_giro),
                context.getString(R.string.sub_consulta_giros),
                R.drawable.ic_consultar_giro_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.jyBbMyVMOV",
                metroType, -1, BankOperationCode.METROConsultarGiroPostal, true);

        addOpToDb(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.sub_recarga_nauta),
                R.drawable.ic_pago_nauta_hogar_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METRORecargaNauta, true);

        addOpToDb(context.getString(R.string.title_reimprimir_tarjeta),
                context.getString(R.string.sub_reimprimir_tarjeta),
                R.drawable.ic_reimprimir_tarjeta_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROReimprimirTarjeta, true);

        addOpToDb(context.getString(R.string.title_metro_localizar_transferencias),
                context.getString(R.string.sub_localizar_transferencias),
                R.drawable.ic_localizar_transferencia_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROLocalizarTransferencia, true);

        addOpToDb(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.hint_subtitle_recarga_propia),
                R.drawable.ic_recarga_tarjeta_propia_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METRORecargaPropia, true);

        addOpToDb(context.getString(R.string.title_jclub), context.getString(R.string.sub_jclub),
                R.drawable.ic_pago_joven_club_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROJClub, true);

        addOpToDb(context.getString(R.string.title_tipo_cambio),
                context.getString(R.string.sub_tipo_cambio),
                R.drawable.ic_tipo_cambio_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROTipoCambio, true);

        addOpToDb(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_metro,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.lQox6tgMlH",
                metroType, -1, BankOperationCode.METROPatrimoniOfa, true);

        addOpToDb(context.getString(R.string.title_recarga_bolsa_cup),
                context.getString(R.string.subtitle_recarga_bolsa_cup),
                R.drawable.ic_recargar_monedero_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METRORecargaBolsa, true);

        addOpToDb(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROPaquetesCubacel, true);

        addOpToDb(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_compra_miturno_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROReservasTicket, true);

        addOpToDb(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METROPCC, true);

        addOpToDb(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_pago_tfa_metro, BuildConfig.FLAVOR,
                metroType, -1, BankOperationCode.METRORecargaTFA, true);
    }

    // -------------------------------------------------------------------------
    // fill_banco_bolsa: MiTransfer digital wallet operations (30 operations)
    // Includes wallet-specific: Recarga CUP Ticket, Extraccion Efectivo,
    // Transferir a Bancos, VotoMovil, Asociar Cuenta, MiBoleto,
    // Transferencia Clasica Empresarial, Pago Externo Empresarial
    // -------------------------------------------------------------------------

    public void fill_banco_bolsa() {
        BankType bolsaType = BankType.MiTransfer;

        addOpToDb(context.getString(R.string.tx_registrarse),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_registrarse_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.eUkRSfpCKs",
                bolsaType, 1, BankOperationCode.BOLSARegistrarse, true);

        addOpToDb(context.getString(R.string.tx_autenticarse),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_autenticacion_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qZS87tGogtP.R5fFZkKuVnr",
                bolsaType, 2, BankOperationCode.BOLSAAutenticarse, true);

        addOpToDb(context.getString(R.string.tx_consultar_saldo),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_consulta_saldo_bolsa, BuildConfig.FLAVOR,
                bolsaType, 10, BankOperationCode.BOLSAConsultarSaldo, true);

        addOpToDb(context.getString(R.string.tx_ultimas_operaciones),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_consulta_utlimas_oper_bolsa, BuildConfig.FLAVOR,
                bolsaType, 10, BankOperationCode.BOLSAUltimasOperaciones, true);

        addOpToDb(context.getString(R.string.menu_title_transferencia_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_transferencia_bolsa, BuildConfig.FLAVOR,
                bolsaType, 11, BankOperationCode.BOLSATransferencia, true);

        addOpToDb(context.getString(R.string.banco_telefono),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_factura_telefono_fijo_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.p5B8KozjvpQ",
                bolsaType, 12, BankOperationCode.BOLSATelefono, true);

        addOpToDb(context.getString(R.string.menu_title_recarga_movil_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_recarga_saldo_movil_bolsa, BuildConfig.FLAVOR,
                bolsaType, 13, BankOperationCode.BOLSARecargaMovil, true);

        addOpToDb(context.getString(R.string.title_recarga_nauta),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_nauta_hogar_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.KtF0PRB8vS",
                bolsaType, 14, BankOperationCode.BOLSARecargaNauta, true);

        addOpToDb(context.getString(R.string.hint_recarga_propia),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_recarga_tarjeta_propia_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI",
                bolsaType, 15, BankOperationCode.BOLSARecargaPropia, true);

        addOpToDb(context.getString(R.string.title_pago_externo),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_linea_bolsa, BuildConfig.FLAVOR,
                bolsaType, 16, BankOperationCode.BOLSAPagoLinea, true);

        addOpToDb(context.getString(R.string.menu_title_compra_paquete_mlc_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_paquetes_combinados_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f3Ttlx30sMT",
                bolsaType, 17, BankOperationCode.BOLSACompraPaqueteMLC, true);

        addOpToDb(context.getString(R.string.menu_title_compra_nauta_plus_bolsa),
                context.getString(R.string.tx_subtexto_bolsa),
                R.drawable.ic_pago_nauta_plus_bolsa, BuildConfig.FLAVOR,
                bolsaType, 18, BankOperationCode.BOLSARecargaNautaMLC, true);

        addOpToDb(context.getString(R.string.tx_consultar_servicio_bolsa),
                context.getString(R.string.tx_sub_consultar_servicio_bolsa),
                R.drawable.ic_consultar_servicio_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb",
                bolsaType, 19, BankOperationCode.BOLSAConsultaServicio, true);

        addOpToDb(context.getString(R.string.banco_desconectar),
                context.getString(R.string.banco_sub_desconectar),
                R.drawable.ic_desconectarse_bolsa, BuildConfig.FLAVOR,
                bolsaType, 20, BankOperationCode.BOLSADesconectar, true);

        addOpToDb(context.getString(R.string.menu_tite_recarga_cup_ticket),
                context.getString(R.string.menu_sub_recarga_cup_ticket),
                R.drawable.ic_recargar_monedero_cup_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR",
                bolsaType, 21, BankOperationCode.BOLSARecargaCUPWalletTicket, true);

        addOpToDb(context.getString(R.string.menu_tite_extraccion_efectivo_ticket),
                context.getString(R.string.menu_sub_extraccion_efectivo_ticket),
                R.drawable.ic_extraer_efectivo_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ",
                bolsaType, 22, BankOperationCode.BOLSAExtraccionWalletTicket, true);

        addOpToDb(context.getString(R.string.menu_tite_transferir_bolsa_bancos),
                context.getString(R.string.menu_sub_transferir_bolsa_bancos),
                R.drawable.ic_transferir_cuentas_banco_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS",
                bolsaType, 23, BankOperationCode.BOLSATransferirBancos, true);

        addOpToDb(context.getString(R.string.banco_electricidad),
                context.getString(R.string.banco_sub_electricidad),
                R.drawable.ic_pago_factura_electricidad_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dwdZ5sHcFR",
                bolsaType, 24, BankOperationCode.BOLSAElectricidad, true);

        addOpToDb(context.getString(R.string.title_pago_agua_hab),
                context.getString(R.string.sub_service_bpa_agua),
                R.drawable.ic_pago_factura_agua_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.U1sIOmca96i",
                bolsaType, 25, BankOperationCode.BOLSAAgua, true);

        addOpToDb(context.getString(R.string.title_service_metro_gas),
                context.getString(R.string.sub_service_metro_gas),
                R.drawable.ic_pago_factura_gas_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XCDkgbw8oZ",
                bolsaType, 26, BankOperationCode.BOLSAgas, true);

        addOpToDb(context.getString(R.string.head_paquetes_cubacel),
                context.getString(R.string.sub_compra_paquetes),
                R.drawable.ic_compra_paquetes_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.WyYHxgzYyW",
                bolsaType, 27, BankOperationCode.BOLSAPaquetesCubacel, true);

        addOpToDb(context.getString(R.string.title_reservas_ofa),
                context.getString(R.string.tx_sub_patrimonio_bolsa),
                R.drawable.ic_reserva_ofa_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS",
                bolsaType, 28, BankOperationCode.BOLSAReservasOFA, true);

        addOpToDb(context.getString(R.string.title_reserva_ticket),
                context.getString(R.string.subtitle_reserva_ticket),
                R.drawable.ic_pago_miturno_bolsa, BuildConfig.FLAVOR,
                bolsaType, 29, BankOperationCode.BOLSAReservasTicket, true);

        addOpToDb(context.getString(R.string.title_organizacion_politica),
                context.getString(R.string.subtitle_pcc),
                R.drawable.ic_pago_organizaciones_masa_bolsa, BuildConfig.FLAVOR,
                bolsaType, 30, BankOperationCode.BOLSAPCC, true);

        addOpToDb(context.getString(R.string.title_recarga_tfa),
                context.getString(R.string.subtitle_recarga_tfa),
                R.drawable.ic_tfa_bolsa, BuildConfig.FLAVOR,
                bolsaType, 30, BankOperationCode.BOLSARecargaTFA, true);

        addOpToDb(context.getString(R.string.tx_title_clasica),
                context.getString(R.string.tx_subtitle_clasica),
                R.drawable.ic_asociar_cuenta_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb",
                bolsaType, 31, BankOperationCode.BOLSAAsociarCuenta, true);

        addOpToDb(context.getString(R.string.tx_head_patrimonio2),
                context.getString(R.string.tx_sub_patrimonio),
                R.drawable.ic_ofa_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.C6ZYln3x19W",
                bolsaType, 32, BankOperationCode.BOLSAAporteOFA, true);

        addOpToDb(context.getString(R.string.title_consulta_miboleto),
                context.getString(R.string.subtitle_consulta_miboleto),
                R.drawable.ic_consulta_miboleto_bolsa, BuildConfig.FLAVOR,
                bolsaType, 33, BankOperationCode.BOLSAConsultaMiBoleto, true);

        addOpToDb(context.getString(R.string.title_compra_miboleto),
                context.getString(R.string.subtitle_compra_miboleto),
                R.drawable.ic_miboleto_pago_bolsa,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA",
                bolsaType, 34, BankOperationCode.BOLSACompraMiBoleto, true);

        addOpToDb(context.getString(R.string.msg_votomovil_etecsa),
                context.getString(R.string.msg_votomovil_descrip_etecsa),
                R.drawable.ic_voto_movil,
                "cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN",
                bolsaType, 35, BankOperationCode.BOLSAVotoMovil, true);

        addOpToDb(context.getString(R.string.tx_transferencia_clasica_empresa),
                context.getString(R.string.ly_title_transferencia_a_clasica_empresa),
                R.drawable.ico_transfer_clasica, BuildConfig.FLAVOR,
                bolsaType, -1, BankOperationCode.BOLSATransferenciaClasicaEmpresarial, true);

        addOpToDb(context.getString(R.string.title_pago_externo_empresarial),
                context.getString(R.string.sub_pago_externo_empresarial),
                R.drawable.ic_pago_linea_empresarial, BuildConfig.FLAVOR,
                bolsaType, -1, BankOperationCode.BOLSAPagoExternoClasicaEmpresarial, true);
    }

    // =========================================================================
    // Update methods: patch icons and fragment references for version upgrades.
    // These update existing DB records without recreating them.
    // =========================================================================

    /**
     * Updates general ETECSA operations with new icons for a specific version.
     * Changes icon drawables and some fragment references.
     */
    public void update_generales(Context context, int version) {
        try {
            this.context = context;
            DatabaseHelper db = DatabaseHelper.getInstance();

            Operacion realizarLlamada = db.getOperacion(BankOperationCode.LLamada);
            realizarLlamada.setImagen(R.drawable.call_phone_gris_color);
            realizarLlamada.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2");
            realizarLlamada.setActivo(true);
            db.updateOperacion(realizarLlamada);

            Operacion realizarLlamada99 = db.getOperacion(BankOperationCode.Llamar99);
            realizarLlamada99.setImagen(R.drawable.call_phone_nine_color);
            realizarLlamada99.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2");
            realizarLlamada99.setTipo_serivicio(BankType.General);
            realizarLlamada99.setActivo(true);
            db.updateOperacion(realizarLlamada99);

            Operacion recargarConBono = db.getOperacion(BankOperationCode.RecargarMovilBono);
            recargarConBono.setImagen(R.drawable.ico_gestion_recarga_color);
            recargarConBono.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu");
            db.updateOperacion(recargarConBono);

            Operacion transferirSaldo = db.getOperacion(BankOperationCode.TransferirSaldoMovil);
            transferirSaldo.setImagen(R.drawable.ico_gestion_tranferir_color);
            transferirSaldo.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL");
            db.updateOperacion(transferirSaldo);

            Operacion cambioClave = db.getOperacion(BankOperationCode.CambioClave);
            cambioClave.setImagen(R.drawable.ico_agent_predet_pin_color);
            cambioClave.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP");
            db.updateOperacion(cambioClave);

            // Update icons for USSD-based operations
            Operacion saldoPrepago = db.getOperacion(BankOperationCode.ConsultaSaldo222);
            saldoPrepago.setImagen(R.drawable.ico_agent_consultar_factura_color);
            db.updateOperacion(saldoPrepago);

            Operacion saldoPospago = db.getOperacion(BankOperationCode.ConsultaSaldo111);
            saldoPospago.setImagen(R.drawable.ico_agent_consultar_factura_color);
            db.updateOperacion(saldoPospago);

            Operacion estadoBono = db.getOperacion(BankOperationCode.ConsultarEstadoBono);
            estadoBono.setImagen(R.drawable.consultar_estado_bono);
            db.updateOperacion(estadoBono);

            Operacion planes = db.getOperacion(BankOperationCode.GestionPlanes);
            planes.setImagen(R.drawable.planes_menu_color);
            db.updateOperacion(planes);

            Operacion planDatos = db.getOperacion(BankOperationCode.ConsultarPlanDatos);
            planDatos.setImagen(R.drawable.plan_datos_color);
            db.updateOperacion(planDatos);

            Operacion planVoz = db.getOperacion(BankOperationCode.ConsultarPlanVoz);
            planVoz.setImagen(R.drawable.plan_voz_color_1);
            db.updateOperacion(planVoz);

            Operacion planSms = db.getOperacion(BankOperationCode.ConsultarPlanSMS);
            planSms.setImagen(R.drawable.plan_sms_color);
            db.updateOperacion(planSms);

            Operacion planAmigos = db.getOperacion(BankOperationCode.ConsultarPlanAmigos);
            planAmigos.setImagen(R.drawable.plan_amigos_color);
            db.updateOperacion(planAmigos);

            Operacion votoMovil = db.getOperacion(BankOperationCode.VotoMovil);
            votoMovil.setImagen(R.drawable.etecsa_votomovil);
            votoMovil.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW");
            db.updateOperacion(votoMovil);

            Operacion adelantaSaldo = db.getOperacion(BankOperationCode.AdelantaSaldo);
            adelantaSaldo.setImagen(R.drawable.adelanta_saldo_etecsa);
            adelantaSaldo.setFragment_name(BuildConfig.FLAVOR);
            adelantaSaldo.setSubtitulo(context.getString(R.string.detail_operaciones_adelanta));
            db.updateOperacion(adelantaSaldo);
        } catch (Exception e) {
            Log.i("TRANSFEREXCEPTION", e.getMessage());
        }
    }

    /**
     * Updates BPA bank operation icons for a specific version.
     * Replaces old-style icons with new banco_bpa_* drawables.
     */
    public void update_bpa(int version) {
        DatabaseHelper db = DatabaseHelper.getInstance();

        // Each operation gets its updated icon and sometimes a corrected fragment name.
        // Pattern: get operation by code, set new image, optionally set fragment, update.

        Operacion bpa1 = db.getOperacion(BankOperationCode.BPAAutenticarse);
        bpa1.setImagen(R.drawable.banco_bpa_login);
        bpa1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.lzGEfceoJu");
        bpa1.setActivo(true);
        db.updateOperacion(bpa1);

        Operacion bpa2 = db.getOperacion(BankOperationCode.BPATransferencia);
        bpa2.setImagen(R.drawable.banco_bpa_transferencia);
        bpa2.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h");
        bpa2.setActivo(true);
        db.updateOperacion(bpa2);

        // ... 24 more BPA icon updates following the same pattern.
        // Notable: BPATelefono fragment points to Operaciones package (not DrR0lEVP3qk)

        Operacion bpa3 = db.getOperacion(BankOperationCode.BPAElectricidad);
        bpa3.setImagen(R.drawable.banco_bpa_electricidad);
        bpa3.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.xSwGh0MTOg");
        bpa3.setActivo(true);
        db.updateOperacion(bpa3);

        Operacion bpa4 = db.getOperacion(BankOperationCode.BPATelefono);
        bpa4.setImagen(R.drawable.banco_bpa_telefono);
        // NOTE: Different package path than fill methods — uses "Operaciones" instead of "DrR0lEVP3qk"
        bpa4.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.Operaciones.u4QMc0S0ZHo");
        bpa4.setActivo(true);
        db.updateOperacion(bpa4);

        Operacion bpa5 = db.getOperacion(BankOperationCode.BPAONAT);
        bpa5.setImagen(R.drawable.banco_bpa_onat);
        bpa5.setFragment_name(BuildConfig.FLAVOR);
        bpa5.setActivo(true);
        db.updateOperacion(bpa5);

        Operacion bpa6 = db.getOperacion(BankOperationCode.BPAConsultarSaldo);
        bpa6.setTitulo("Consultar Saldo");
        bpa6.setSubtitulo("BPA");
        bpa6.setImagen(R.drawable.banco_bpa_consultar);
        bpa6.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.ix4mhKGJty");
        bpa6.setActivo(true);
        db.updateOperacion(bpa6);

        Operacion bpa7 = db.getOperacion(BankOperationCode.BPAConsultarServicio);
        bpa7.setImagen(R.drawable.banco_bpa_cons_serv);
        bpa7.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT");
        bpa7.setActivo(true);
        db.updateOperacion(bpa7);

        Operacion bpa8 = db.getOperacion(BankOperationCode.BPAUltimasoperaciones);
        bpa8.setImagen(R.drawable.banco_bpa_ultimas);
        bpa8.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.h3sd43nvje");
        bpa8.setActivo(true);
        db.updateOperacion(bpa8);

        Operacion bpa9 = db.getOperacion(BankOperationCode.BPARegistrarse);
        bpa9.setImagen(R.drawable.banco_bpa_registro);
        bpa9.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.IixhA1yamp");
        bpa9.setActivo(true);
        db.updateOperacion(bpa9);

        Operacion bpa10 = db.getOperacion(BankOperationCode.BPACambiarclave);
        bpa10.setImagen(R.drawable.banco_bpa_pin);
        bpa10.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.PQmKwgxZd1");
        bpa10.setActivo(true);
        db.updateOperacion(bpa10);

        Operacion bpa11 = db.getOperacion(BankOperationCode.BPADesconectar);
        bpa11.setImagen(R.drawable.banco_bpa_salir);
        bpa11.setActivo(true);
        db.updateOperacion(bpa11);

        Operacion bpa12 = db.getOperacion(BankOperationCode.BPARecargaMovil);
        bpa12.setImagen(R.drawable.banco_bpa_recarga);
        bpa12.setFragment_name(BuildConfig.FLAVOR);
        bpa12.setActivo(true);
        db.updateOperacion(bpa12);

        Operacion recargaNautaBPA = db.getOperacion(BankOperationCode.BPARecargaNauta);
        recargaNautaBPA.setImagen(R.drawable.banco_bpa_nauta);
        db.updateOperacion(recargaNautaBPA);

        Operacion bpa13 = db.getOperacion(BankOperationCode.BPACambioLimite);
        bpa13.setImagen(R.drawable.banco_bpa_cambio_limite);
        bpa13.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.qmcwKV1fzU");
        bpa13.setActivo(true);
        db.updateOperacion(bpa13);

        Operacion bpa14 = db.getOperacion(BankOperationCode.BPAConsultaLimite);
        bpa14.setImagen(R.drawable.banco_bpa_consulta_limite);
        bpa14.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.e8WK1Uajbq");
        bpa14.setActivo(true);
        db.updateOperacion(bpa14);

        Operacion amortizarBPA = db.getOperacion(BankOperationCode.BPAAmortizar);
        amortizarBPA.setImagen(R.drawable.banco_bpa_amortizar);
        amortizarBPA.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.Dm6u4PA5eg");
        amortizarBPA.setActivo(true);
        db.updateOperacion(amortizarBPA);

        Operacion consultaCreditoBPA = db.getOperacion(BankOperationCode.BPAConsultaCredito);
        consultaCreditoBPA.setImagen(R.drawable.banco_bpa_consulta_creditos);
        consultaCreditoBPA.setFragment_name(BuildConfig.FLAVOR);
        consultaCreditoBPA.setActivo(true);
        db.updateOperacion(consultaCreditoBPA);

        Operacion giroBPA = db.getOperacion(BankOperationCode.BPAGiroPostal);
        giroBPA.setImagen(R.drawable.banco_bpa_giro);
        giroBPA.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.o6kycf55Gw");
        giroBPA.setActivo(true);
        db.updateOperacion(giroBPA);

        Operacion consultaGiroBPA = db.getOperacion(BankOperationCode.BPAConsultarGiroPostal);
        consultaGiroBPA.setImagen(R.drawable.banco_bpa_consulta_giro);
        consultaGiroBPA.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.XvOK7VM4qL");
        consultaGiroBPA.setActivo(true);
        db.updateOperacion(consultaGiroBPA);

        Operacion consultaIntegradaBPA = db.getOperacion(BankOperationCode.BPAConsultarTodasCuentas);
        consultaIntegradaBPA.setImagen(R.drawable.banco_bpa_consulta_integrada);
        consultaIntegradaBPA.setFragment_name(BuildConfig.FLAVOR);
        consultaIntegradaBPA.setActivo(true);
        db.updateOperacion(consultaIntegradaBPA);

        Operacion pagoExternoBPA = db.getOperacion(BankOperationCode.BPAPagoExterno);
        pagoExternoBPA.setImagen(R.drawable.banco_bpa_compra);
        pagoExternoBPA.setFragment_name(BuildConfig.FLAVOR);
        pagoExternoBPA.setActivo(true);
        db.updateOperacion(pagoExternoBPA);

        Operacion propiaBPA = db.getOperacion(BankOperationCode.BPARecargaPropia);
        propiaBPA.setImagen(R.drawable.banco_bpa_recarga_propia);
        propiaBPA.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(propiaBPA);

        Operacion bpaAgua = db.getOperacion(BankOperationCode.BPAAgua);
        bpaAgua.setImagen(R.drawable.banco_bpa_agua);
        bpaAgua.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.zOs55UzH6z");
        db.updateOperacion(bpaAgua);

        Operacion bpaGas = db.getOperacion(BankOperationCode.BPAGas);
        bpaGas.setImagen(R.drawable.banco_bpa_gas);
        bpaGas.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.FgpBLXKm6t");
        db.updateOperacion(bpaGas);

        Operacion bpaJClub = db.getOperacion(BankOperationCode.BPAJClub);
        bpaJClub.setImagen(R.drawable.banco_bpa_jclub);
        bpaJClub.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(bpaJClub);

        Operacion bpaTicket = db.getOperacion(BankOperationCode.BPAReservasTicket);
        bpaTicket.setImagen(R.drawable.ico_ticket_reserva_bpa);
        bpaTicket.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(bpaTicket);
    }

    /**
     * Updates BANDEC bank operation icons for a specific version.
     * NOTE: Also updates BPAJClub at the end (appears to be intentional cross-bank update).
     */
    public void update_bandec(int version) {
        DatabaseHelper db = DatabaseHelper.getInstance();

        // Same pattern as update_bpa: get by code, set new banco_bandec_* icon, update.
        // 27 operations updated with new icons.
        // Notable: BANUltimosPagos explicitly sets tipo_serivicio to BANDEC.
        // Notable: BANRecargaPropia re-sets its operacion code.
        // Notable: Last entry updates BPAJClub (cross-bank).

        Operacion bandec1 = db.getOperacion(BankOperationCode.BANAutenticar);
        bandec1.setImagen(R.drawable.banco_bandec_auth_login);
        bandec1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TGFziPh3KJ");
        bandec1.setActivo(true);
        db.updateOperacion(bandec1);

        Operacion bandec2 = db.getOperacion(BankOperationCode.BANTransferencia);
        bandec2.setImagen(R.drawable.banco_bandec_transfer);
        bandec2.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ZDkigMAIBm");
        bandec2.setActivo(true);
        db.updateOperacion(bandec2);

        Operacion bandec3 = db.getOperacion(BankOperationCode.BANElectricidad);
        bandec3.setImagen(R.drawable.banco_bandec_electric);
        bandec3.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.Q3Nvf439ab");
        bandec3.setActivo(true);
        db.updateOperacion(bandec3);

        Operacion bandec4 = db.getOperacion(BankOperationCode.BANTelefono);
        bandec4.setImagen(R.drawable.banco_bandec_telefono);
        bandec4.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.iQte15zdZs");
        bandec4.setActivo(true);
        db.updateOperacion(bandec4);

        Operacion bandec5 = db.getOperacion(BankOperationCode.BANONAT);
        bandec5.setImagen(R.drawable.banco_bandec_onat);
        bandec5.setFragment_name(BuildConfig.FLAVOR);
        bandec5.setActivo(true);
        db.updateOperacion(bandec5);

        Operacion bandec6 = db.getOperacion(BankOperationCode.BANConsultarSaldo);
        bandec6.setImagen(R.drawable.banco_bandec_consult_saldo);
        bandec6.setActivo(true);
        db.updateOperacion(bandec6);

        Operacion bandec7 = db.getOperacion(BankOperationCode.BANConsultarServicio);
        bandec7.setImagen(R.drawable.banco_bandec_consult_serv);
        bandec7.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3");
        bandec7.setActivo(true);
        db.updateOperacion(bandec7);

        Operacion bandec8 = db.getOperacion(BankOperationCode.BANUltimasoperaciones);
        bandec8.setImagen(R.drawable.banco_bandec_ult_oper);
        bandec8.setActivo(true);
        db.updateOperacion(bandec8);

        Operacion bandec9 = db.getOperacion(BankOperationCode.BANRegistrarse);
        bandec9.setImagen(R.drawable.banco_bandec_register);
        bandec9.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.wLHKkaC4Ha");
        bandec9.setActivo(true);
        db.updateOperacion(bandec9);

        Operacion bandec10 = db.getOperacion(BankOperationCode.BANCambiarclave);
        bandec10.setImagen(R.drawable.banco_bandec_cambio_clave);
        bandec10.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.FtAKxvNjrD");
        bandec10.setActivo(true);
        db.updateOperacion(bandec10);

        Operacion bandec11 = db.getOperacion(BankOperationCode.BANDesconectar);
        bandec11.setImagen(R.drawable.banco_bandec_salir);
        bandec11.setActivo(true);
        db.updateOperacion(bandec11);

        Operacion bandec12 = db.getOperacion(BankOperationCode.BANEliminarRegistro);
        bandec12.setImagen(R.drawable.banco_bandec_eliminar_registro);
        bandec12.setActivo(true);
        db.updateOperacion(bandec12);

        Operacion bandec13 = db.getOperacion(BankOperationCode.BANRecargaMovil);
        bandec13.setImagen(R.drawable.banco_bandec_recarga2);
        bandec13.setFragment_name(BuildConfig.FLAVOR);
        bandec13.setActivo(true);
        db.updateOperacion(bandec13);

        Operacion bandec14 = db.getOperacion(BankOperationCode.BANCambioLimite);
        bandec14.setImagen(R.drawable.banco_bandec_cambio_limite);
        bandec14.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.uWkWt7AEZ5");
        bandec14.setActivo(true);
        db.updateOperacion(bandec14);

        Operacion bandec15 = db.getOperacion(BankOperationCode.BANConsultaLimite);
        bandec15.setImagen(R.drawable.banco_bandec_consulta_limite);
        bandec15.setActivo(true);
        db.updateOperacion(bandec15);

        Operacion bandec16 = db.getOperacion(BankOperationCode.BANUltimosPagos);
        bandec16.setImagen(R.drawable.banco_bandec_ultimos_pagos);
        bandec16.setTipo_serivicio(BankType.BANDEC);
        bandec16.setActivo(true);
        db.updateOperacion(bandec16);

        Operacion bandec17 = db.getOperacion(BankOperationCode.BANCambioCuenta);
        bandec17.setImagen(R.drawable.banco_bandec_cambio_cuenta);
        bandec17.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.o9swVUfDl4q");
        bandec17.setActivo(true);
        db.updateOperacion(bandec17);

        Operacion bandec18 = db.getOperacion(BankOperationCode.BANAmortizar);
        bandec18.setImagen(R.drawable.banco_bandec_amortizar_credito);
        bandec18.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.LZaBQezxPC");
        bandec18.setActivo(true);
        db.updateOperacion(bandec18);

        Operacion bandec19 = db.getOperacion(BankOperationCode.BANConsultarTodasCuentas);
        bandec19.setImagen(R.drawable.banco_bandec_consultar_todas_cuentas);
        bandec19.setActivo(true);
        db.updateOperacion(bandec19);

        Operacion recargaNautaBANDEC = db.getOperacion(BankOperationCode.BANRecargaNauta);
        recargaNautaBANDEC.setImagen(R.drawable.banco_bandec_nauta);
        db.updateOperacion(recargaNautaBANDEC);

        Operacion giroBandec = db.getOperacion(BankOperationCode.BANGiroPostal);
        giroBandec.setImagen(R.drawable.banco_bandec_giro);
        giroBandec.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ASLdujtVtr");
        giroBandec.setActivo(true);
        db.updateOperacion(giroBandec);

        Operacion consultaGiroBandec = db.getOperacion(BankOperationCode.BANConsultarGiroPostal);
        consultaGiroBandec.setImagen(R.drawable.banco_bandec_giro);
        consultaGiroBandec.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.gsthr0APCT");
        consultaGiroBandec.setActivo(true);
        db.updateOperacion(consultaGiroBandec);

        Operacion pagoExternoBandec = db.getOperacion(BankOperationCode.BANPagoExterno);
        pagoExternoBandec.setImagen(R.drawable.banco_bandec_compra);
        pagoExternoBandec.setFragment_name(BuildConfig.FLAVOR);
        pagoExternoBandec.setActivo(true);
        db.updateOperacion(pagoExternoBandec);

        Operacion gas = db.getOperacion(BankOperationCode.BANGas);
        gas.setTitulo(context.getString(R.string.title_service_metro_gas));
        gas.setSubtitulo(context.getString(R.string.sub_service_metro_gas));
        gas.setImagen(R.drawable.banco_bandec_gas);
        gas.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.aiwIHVBe0c");
        db.updateOperacion(gas);

        Operacion propia = db.getOperacion(BankOperationCode.BANRecargaPropia);
        propia.setImagen(R.drawable.banco_bandec_recarga_propia);
        propia.setFragment_name(BuildConfig.FLAVOR);
        propia.setActivo(true);
        propia.setOperacion(BankOperationCode.BANRecargaPropia);
        db.updateOperacion(propia);

        Operacion bandecAgua = db.getOperacion(BankOperationCode.BANAgua);
        bandecAgua.setImagen(R.drawable.banco_bandec_agua);
        bandecAgua.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt");
        db.updateOperacion(bandecAgua);

        // Cross-bank: also update BPA JClub icon in this method
        Operacion recargaJClubBPA = db.getOperacion(BankOperationCode.BPAJClub);
        recargaJClubBPA.setImagen(R.drawable.banco_bpa_jclub);
        recargaJClubBPA.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(recargaJClubBPA);
    }

    /**
     * Updates Metropolitano bank operation icons for a specific version.
     */
    public void update_metro(int version) {
        DatabaseHelper db = DatabaseHelper.getInstance();

        // Same pattern: get by code, set banco_metro_* icon, update.
        // Notable: METROCambioLimite and METROConsultaTodasCuentas re-set their operacion codes.

        Operacion metro1 = db.getOperacion(BankOperationCode.METROAutenticarse);
        metro1.setImagen(R.drawable.banco_metro_autenticar);
        metro1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PAZK2sdsJ5");
        metro1.setActivo(true);
        db.updateOperacion(metro1);

        Operacion metro2 = db.getOperacion(BankOperationCode.METROConsultarSaldo);
        metro2.setImagen(R.drawable.banco_metro_consultar);
        metro2.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.dVxDCMi9cK");
        metro2.setActivo(true);
        db.updateOperacion(metro2);

        Operacion metro3 = db.getOperacion(BankOperationCode.METROConsultarServicio);
        metro3.setImagen(R.drawable.banco_metro_telebanca);
        metro3.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr");
        metro3.setActivo(true);
        db.updateOperacion(metro3);

        Operacion metro4 = db.getOperacion(BankOperationCode.METROTransferirEfectivo);
        metro4.setImagen(R.drawable.banco_metro_transferir);
        metro4.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U");
        metro4.setActivo(true);
        db.updateOperacion(metro4);

        Operacion metro5 = db.getOperacion(BankOperationCode.METROTelefono);
        metro5.setImagen(R.drawable.banco_metro_telefono);
        metro5.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7");
        metro5.setActivo(true);
        db.updateOperacion(metro5);

        Operacion metro6 = db.getOperacion(BankOperationCode.METROElectricidad);
        metro6.setImagen(R.drawable.banco_metro_pelectrica);
        metro6.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.PliSaYhOg0");
        metro6.setActivo(true);
        db.updateOperacion(metro6);

        Operacion metro7 = db.getOperacion(BankOperationCode.METROAgua);
        metro7.setImagen(R.drawable.banco_metro_pagua);
        metro7.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.BoMBck6OXT");
        metro7.setActivo(true);
        db.updateOperacion(metro7);

        Operacion metro8 = db.getOperacion(BankOperationCode.METROImpuestos);
        metro8.setImagen(R.drawable.banco_metro_onat);
        metro8.setActivo(true);
        db.updateOperacion(metro8);

        Operacion metro9 = db.getOperacion(BankOperationCode.METROUltimasoperaciones);
        metro9.setImagen(R.drawable.banco_metro_uoperaciones);
        metro9.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.GhhAuUBVrI");
        metro9.setActivo(true);
        db.updateOperacion(metro9);

        Operacion metro10 = db.getOperacion(BankOperationCode.METRORegistrarse);
        metro10.setImagen(R.drawable.banco_metro_registro);
        metro10.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.RFBEnXW0Xr");
        metro10.setActivo(true);
        db.updateOperacion(metro10);

        Operacion metro11 = db.getOperacion(BankOperationCode.METRODesconectar);
        metro11.setImagen(R.drawable.banco_metro_cerrar);
        metro11.setActivo(true);
        db.updateOperacion(metro11);

        Operacion metro12 = db.getOperacion(BankOperationCode.METROActualizarcuenta);
        metro12.setImagen(R.drawable.banco_metro_actualizar);
        metro12.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.uurdBwh7ub");
        metro12.setActivo(true);
        db.updateOperacion(metro12);

        Operacion metro13 = db.getOperacion(BankOperationCode.METRORecargaMovil);
        metro13.setImagen(R.drawable.banco_metro_recarga);
        metro13.setFragment_name(BuildConfig.FLAVOR);
        metro13.setActivo(true);
        db.updateOperacion(metro13);

        Operacion metro14 = db.getOperacion(BankOperationCode.METROCambioLimite);
        metro14.setImagen(R.drawable.banco_metro_cambio_limite);
        metro14.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE");
        metro14.setActivo(true);
        metro14.setOperacion(BankOperationCode.METROCambioLimite);
        db.updateOperacion(metro14);

        Operacion metro16 = db.getOperacion(BankOperationCode.METROConsultaTodasCuentas);
        metro16.setImagen(R.drawable.banco_metro_consultar_todas_cuentas);
        metro16.setFragment_name(BuildConfig.FLAVOR);
        metro16.setActivo(true);
        metro16.setOperacion(BankOperationCode.METROConsultaTodasCuentas);
        db.updateOperacion(metro16);

        Operacion metro15 = db.getOperacion(BankOperationCode.METROConsultaLimite);
        metro15.setImagen(R.drawable.banco_metro_consulta_limite);
        metro15.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.Aj11H1nzNkW.gkzzwVYksz");
        metro15.setActivo(true);
        metro15.setOperacion(BankOperationCode.METROConsultaLimite);
        db.updateOperacion(metro15);

        Operacion recargaNauta = db.getOperacion(BankOperationCode.METRORecargaNauta);
        recargaNauta.setImagen(R.drawable.banco_metro_nauta);
        db.updateOperacion(recargaNauta);

        Operacion giroMetro = db.getOperacion(BankOperationCode.METROGiroPostal);
        giroMetro.setImagen(R.drawable.banco_metro_giro);
        giroMetro.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.mhElzRz7zH");
        giroMetro.setActivo(true);
        db.updateOperacion(giroMetro);

        Operacion consultaGiroMetro = db.getOperacion(BankOperationCode.METROConsultarGiroPostal);
        consultaGiroMetro.setImagen(R.drawable.banco_metro_consulta_giro);
        consultaGiroMetro.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.jyBbMyVMOV");
        consultaGiroMetro.setActivo(true);
        db.updateOperacion(consultaGiroMetro);

        Operacion reimprimirTarjeta = db.getOperacion(BankOperationCode.METROReimprimirTarjeta);
        reimprimirTarjeta.setImagen(R.drawable.banco_metro_reimprimir);
        reimprimirTarjeta.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(reimprimirTarjeta);

        Operacion localizarTransferencias = db.getOperacion(BankOperationCode.METROLocalizarTransferencia);
        localizarTransferencias.setImagen(R.drawable.banco_metro_localizar);
        localizarTransferencias.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(localizarTransferencias);

        Operacion pagoExternoMetro = db.getOperacion(BankOperationCode.METROPagoExterno);
        pagoExternoMetro.setImagen(R.drawable.banco_metro_compra);
        db.updateOperacion(pagoExternoMetro);

        Operacion propia = db.getOperacion(BankOperationCode.METRORecargaPropia);
        propia.setImagen(R.drawable.banco_metrore_carga_propia);
        propia.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(propia);

        Operacion recargaJClub = db.getOperacion(BankOperationCode.METROJClub);
        recargaJClub.setImagen(R.drawable.banco_metro_jclub);
        recargaJClub.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(recargaJClub);

        Operacion tipoCambio = db.getOperacion(BankOperationCode.METROTipoCambio);
        tipoCambio.setImagen(R.drawable.banco_metro_tipo_cambio);
        tipoCambio.setFragment_name(BuildConfig.FLAVOR);
        db.updateOperacion(tipoCambio);
    }

    /**
     * Updates agent operations: removes deprecated operations and refreshes icons.
     * Deprecated operations: AGPredeterminarTarjeta, AGConsultarFactura,
     * AGPagarFactura, AGUltimosPago, AGRectificarPago.
     */
    public void update_agente() {
        DatabaseHelper db = DatabaseHelper.getInstance();

        // Delete deprecated agent operations
        db.deleteOperacion(db.getOperacion(BankOperationCode.AGPredeterminarTarjeta));
        db.deleteOperacion(db.getOperacion(BankOperationCode.AGConsultarFactura));
        db.deleteOperacion(db.getOperacion(BankOperationCode.AGPagarFactura));
        db.deleteOperacion(db.getOperacion(BankOperationCode.AGUltimosPago));
        db.deleteOperacion(db.getOperacion(BankOperationCode.AGRectificarPago));

        // Update traditional agent operation icons (all set to inactive)
        Operacion recargaMovil1 = db.getOperacion(BankOperationCode.AGAutenticar);
        recargaMovil1.setImagen(R.drawable.ico_agente_autenticar_color);
        recargaMovil1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60");
        recargaMovil1.setActivo(false);
        db.updateOperacion(recargaMovil1);

        Operacion recargaMovil2 = db.getOperacion(BankOperationCode.AGConsultarSaldo);
        recargaMovil2.setImagen(R.drawable.ico_agente_consultar_color);
        recargaMovil2.setActivo(false);
        db.updateOperacion(recargaMovil2);

        Operacion recargaMovil3 = db.getOperacion(BankOperationCode.AGRecargar);
        recargaMovil3.setImagen(R.drawable.ico_agent_recargar_color);
        recargaMovil3.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW");
        recargaMovil3.setActivo(false);
        db.updateOperacion(recargaMovil3);

        Operacion recargaMovil4 = db.getOperacion(BankOperationCode.AGUltimasRecargas);
        recargaMovil4.setImagen(R.drawable.ico_agente_ultimas_color);
        recargaMovil4.setActivo(false);
        db.updateOperacion(recargaMovil4);

        Operacion recargaMovil5 = db.getOperacion(BankOperationCode.AGCambiarclave);
        recargaMovil5.setImagen(R.drawable.ico_agent_predet_pin_color);
        recargaMovil5.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD");
        recargaMovil5.setActivo(false);
        db.updateOperacion(recargaMovil5);

        Operacion recargaMovil6 = db.getOperacion(BankOperationCode.AGDesconectar);
        recargaMovil6.setImagen(R.drawable.ico_agente_desc_color);
        recargaMovil6.setActivo(false);
        db.updateOperacion(recargaMovil6);

        Operacion recargaNauta1 = db.getOperacion(BankOperationCode.AGRecargarNauta);
        recargaNauta1.setImagen(R.drawable.ico_agente_nauta_color);
        recargaNauta1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1");
        recargaNauta1.setActivo(false);
        db.updateOperacion(recargaNauta1);

        Operacion recargaNauta2 = db.getOperacion(BankOperationCode.AGConsultarNautaUlt);
        recargaNauta2.setImagen(R.drawable.ico_agente_ultimas_color);
        recargaNauta2.setActivo(false);
        db.updateOperacion(recargaNauta2);

        // Update BOLSA agent operations (with null checks — may not exist)
        try {
            Operacion ag1 = db.getOperacion(BankOperationCode.BOLSAAGFacturaTelefonica);
            if (ag1 != null) {
                ag1.setImagen(R.drawable.bolsa_ag_factura_telefonica);
                ag1.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS");
                ag1.setActivo(false);
                db.updateOperacion(ag1);
            }

            Operacion ag2 = db.getOperacion(BankOperationCode.BOLSAAGRecargaMovil);
            if (ag2 != null) {
                ag2.setImagen(R.drawable.bolsa_ag_recarga_movil);
                ag2.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK");
                ag2.setActivo(false);
                db.updateOperacion(ag2);
            }

            Operacion ag3 = db.getOperacion(BankOperationCode.BOLSAAGRecargaNauta);
            if (ag3 != null) {
                ag3.setImagen(R.drawable.bolsa_ag_recarga_nauta);
                ag3.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU");
                ag3.setActivo(false);
                db.updateOperacion(ag3);
            }

            Operacion ag4 = db.getOperacion(BankOperationCode.BOLSAAGRecargaPropia);
            if (ag4 != null) {
                ag4.setImagen(R.drawable.bolsa_ag_recarga_propia);
                ag4.setFragment_name("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.BpgQdOQz0p");
                ag4.setActivo(false);
                db.updateOperacion(ag4);
            }
        } catch (Exception e) {
            // Silently ignore — BOLSA agent operations may not exist
        }
    }

    // =========================================================================
    // Reference data loaders: populate geographic and tax lookup tables
    // from JSON assets bundled in the APK.
    // =========================================================================

    /**
     * Loads province (Provincia) data from dpa.json asset into the database.
     * JSON structure: {"Prov": [{"Prov": "01", "Nombre": "...", "Abreviatura": "..."}]}
     */
    public void fill_provincias(Context context) {
        try {
            String json = loadJSONFromAsset("dpa.json", context);
            JSONObject root = new JSONObject(json);
            JSONArray provinces = root.getJSONArray("Prov");
            for (int i = 0; i < provinces.length(); i++) {
                try {
                    JSONObject obj = provinces.getJSONObject(i);
                    Provincia p = new Provincia();
                    p.setCod_provincia(obj.getString("Prov"));
                    p.setNombre(obj.getString("Nombre"));
                    p.setAbreviatura(obj.getString("Abreviatura"));
                    DatabaseHelper.getInstance().addProvincia(p);
                } catch (Exception e) {
                    // Skip malformed entries
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads municipality (Municipio) data from dpa.json asset into the database.
     * JSON structure: {"Mun": [{"Mun": "01", "Prov": "01", "Nombre": "...", "Abreviatura": "..."}]}
     */
    public void fill_municipios(Context context) {
        try {
            String json = loadJSONFromAsset("dpa.json", context);
            JSONObject root = new JSONObject(json);
            JSONArray municipalities = root.getJSONArray("Mun");
            for (int i = 0; i < municipalities.length(); i++) {
                try {
                    JSONObject obj = municipalities.getJSONObject(i);
                    Municipio m = new Municipio();
                    m.setCod_municipio(obj.getString("Mun"));
                    m.setCod_provincia(obj.getString("Prov"));
                    m.setNombre(obj.getString("Nombre"));
                    m.setAbreviatura(obj.getString("Abreviatura"));
                    DatabaseHelper.getInstance().addMunicipio(m);
                } catch (Exception e) {
                    // Skip malformed entries
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads tax code (Tributo) data from tributos.json asset into the database.
     * Used by ONAT (tax authority) payment operations.
     * JSON structure: {"tributos": [{"Codigo": "...", "Nombre": "...",
     *   "Abreviatura": "...", "TipoPersona": "...", "Moneda": "...", "Tipo": "..."}]}
     */
    public void fill_tributos(Context context) {
        try {
            String json = loadJSONFromAsset("tributos.json", context);
            JSONObject root = new JSONObject(json);
            JSONArray tributos = root.getJSONArray("tributos");
            for (int i = 0; i < tributos.length(); i++) {
                try {
                    JSONObject obj = tributos.getJSONObject(i);
                    Tributo t = new Tributo();
                    t.setCod_tributo(obj.getString("Codigo"));
                    t.setNombre(obj.getString("Nombre"));
                    t.setAbreviatura(obj.getString("Abreviatura"));
                    t.setTipo(obj.getString("Tipo"));
                    t.setTipoPersona(obj.getString("TipoPersona"));
                    t.setMoneda(obj.getString("Moneda"));
                    DatabaseHelper.getInstance().addTributo(t);
                } catch (Exception e) {
                    // Skip malformed entries
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a JSON file from the app's assets directory.
     *
     * @param nameJson the asset filename (e.g., "dpa.json", "tributos.json")
     * @param context  Android context for asset access
     * @return the file contents as a UTF-8 string, or null on error
     */
    public String loadJSONFromAsset(String nameJson, Context context) {
        try {
            InputStream is = context.getAssets().open(nameJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
