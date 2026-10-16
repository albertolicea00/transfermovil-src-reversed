package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.github.paolorotolo.appintro.BuildConfig;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class AppConfig {

    @DatabaseField
    private boolean activada;

    @DatabaseField
    private String codigo;

    @DatabaseField
    private int evaluacion;

    @DatabaseField
    private Date fechaHoraAuthBank;

    @DatabaseField
    private Date fechaUltimasExperiencias;

    @DatabaseField
    private Date fechaUltimasPromos;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String imei;

    @DatabaseField
    private String number;

    @DatabaseField
    private String phone;

    @DatabaseField
    private String code_bank = BuildConfig.FLAVOR;

    @DatabaseField
    private boolean noMostrarEncuesta = false;

    @DatabaseField
    private boolean mensajeInicio = true;

    @DatabaseField
    private boolean activarussdparcial = false;

    @DatabaseField
    private boolean activarmodulomiboleto = false;

    @DatabaseField
    private boolean activarMejoraQR = false;

    @DatabaseField
    private int comprapaquetes = 0;

    public boolean isActivarMejoraQR() {
        return this.activarMejoraQR;
    }

    public void setActivarMejoraQR(boolean activarMejoraQR) {
        this.activarMejoraQR = activarMejoraQR;
    }

    public boolean isActivarussdparcial() {
        return this.activarussdparcial;
    }

    public boolean isActivarmodulomiboleto() {
        return this.activarmodulomiboleto;
    }

    public int getComprapaquetes() {
        return this.comprapaquetes;
    }

    public void setActivarussdparcial(boolean activarussdparcial) {
        this.activarussdparcial = activarussdparcial;
    }

    public void setActivarModuloMiboleto(boolean activarmodulomiboleto) {
        this.activarmodulomiboleto = activarmodulomiboleto;
    }

    public void setComprapaquetes(int comprapaquetes) {
        this.comprapaquetes = comprapaquetes;
    }

    public boolean isMensajeInicio() {
        return this.mensajeInicio;
    }

    public void setMensajeInicio(boolean mensajeInicio) {
        this.mensajeInicio = mensajeInicio;
    }

    public Date getFechaUltimasPromos() {
        return this.fechaUltimasPromos;
    }

    public void setFechaUltimasPromos(Date fechaUltimasPromos) {
        this.fechaUltimasPromos = fechaUltimasPromos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public boolean isActivada() {
        return this.activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public String getCode_bank() {
        return this.code_bank;
    }

    public void setCode_bank(String number_bank) {
        this.code_bank = number_bank;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getFechaHoraAuthBank() {
        return this.fechaHoraAuthBank;
    }

    public void setFechaHoraAuthBank(Date fechaHoraAuthBank) {
        this.fechaHoraAuthBank = fechaHoraAuthBank;
    }

    public Date getFechaUltimasExperiencias() {
        return this.fechaUltimasExperiencias;
    }

    public void setFechaUltimasExperiencias(Date fechaUltimasExperiencias) {
        this.fechaUltimasExperiencias = fechaUltimasExperiencias;
    }

    public int getEvaluacion() {
        return this.evaluacion;
    }

    public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }

    public boolean isNoMostrarEncuesta() {
        return this.noMostrarEncuesta;
    }

    public void setNoMostrarEncuesta(boolean noMostrarEncuesta) {
        this.noMostrarEncuesta = noMostrarEncuesta;
    }
}
