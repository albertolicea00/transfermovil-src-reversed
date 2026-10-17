package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.core.enums.BankType;
import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS
 * @fingerprint @DatabaseTable, mensaje, fecha_inicio/fin, tipo_promo (BankType), habilitado
 *
 * ORMLite entity for SMS-based promotional messages. Each row defines a
 * promotion with a validity window, associated icon, bank type, and
 * enabled/disabled state.
 */
@DatabaseTable(tableName = "PromoSMS")
public class SmsPromotion {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String mensaje;

    @DatabaseField
    private Date fecha_inicio;

    @DatabaseField
    private Date fecha_fin;

    /** obfuscated: R1sDOSqZ2z */
    @DatabaseField
    private BankType tipo_promo;

    @DatabaseField
    private int icono_asociado;

    @DatabaseField
    private boolean habilitado;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_inicio() {
        return this.fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return this.fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BankType getTipo_promo() {
        return this.tipo_promo;
    }

    public void setTipo_promo(BankType tipo_promo) {
        this.tipo_promo = tipo_promo;
    }

    public int getIcono_asociado() {
        return this.icono_asociado;
    }

    public void setIcono_asociado(int icono_asociado) {
        this.icono_asociado = icono_asociado;
    }

    public boolean isHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
