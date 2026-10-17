package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig
 * @fingerprint @DatabaseTable, codigo/imei/phone/feature-flags/mensajeInicio fields
 *
 * Singleton-style app configuration persisted in TransferMDB.sqlite.
 * Stores device identity, access code, feature flags, and UI messages.
 *
 * SECURITY: IMEI stored as plaintext. Combined with debuggable=true and
 * allowBackup=true, device fingerprint extraction is trivial.
 */
@DatabaseTable(tableName = "AppConfig")
public class AppConfig {

    @DatabaseField(generatedId = true)
    private int id;

    /** Access/activation code */
    @DatabaseField
    private String codigo;

    /** Device IMEI — STORED IN PLAINTEXT */
    @DatabaseField
    private String imei;

    @DatabaseField
    private String phone;

    @DatabaseField
    private String code_bank;

    /** Feature flag: partial USSD activation */
    @DatabaseField
    private boolean activarussdparcial;

    /** Feature flag: ticket module enabled */
    @DatabaseField
    private boolean activarmodulomiboleto;

    /** Feature flag: improved QR scanning */
    @DatabaseField
    private boolean activarMejoraQR;

    /** Feature flag: package purchasing */
    @DatabaseField
    private boolean comprapaquetes;

    /** Startup message displayed to user */
    @DatabaseField
    private String mensajeInicio;

    /** Whether to suppress the survey prompt */
    @DatabaseField
    private boolean noMostrarEncuesta;

    /** Last update date (as string) */
    @DatabaseField
    private String fechaAct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCodeBank() {
        return code_bank;
    }

    public void setCodeBank(String code_bank) {
        this.code_bank = code_bank;
    }

    public boolean isActivarUssdParcial() {
        return activarussdparcial;
    }

    public void setActivarUssdParcial(boolean activarussdparcial) {
        this.activarussdparcial = activarussdparcial;
    }

    public boolean isActivarModuloMiBoleto() {
        return activarmodulomiboleto;
    }

    public void setActivarModuloMiBoleto(boolean activarmodulomiboleto) {
        this.activarmodulomiboleto = activarmodulomiboleto;
    }

    public boolean isActivarMejoraQR() {
        return activarMejoraQR;
    }

    public void setActivarMejoraQR(boolean activarMejoraQR) {
        this.activarMejoraQR = activarMejoraQR;
    }

    public boolean isCompraPaquetes() {
        return comprapaquetes;
    }

    public void setCompraPaquetes(boolean comprapaquetes) {
        this.comprapaquetes = comprapaquetes;
    }

    public String getMensajeInicio() {
        return mensajeInicio;
    }

    public void setMensajeInicio(String mensajeInicio) {
        this.mensajeInicio = mensajeInicio;
    }

    public boolean isNoMostrarEncuesta() {
        return noMostrarEncuesta;
    }

    public void setNoMostrarEncuesta(boolean noMostrarEncuesta) {
        this.noMostrarEncuesta = noMostrarEncuesta;
    }

    public String getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }
}
