package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class PromoSMS {

    @DatabaseField
    private Date fecha_fin;

    @DatabaseField
    private Date fecha_inicio;

    @DatabaseField
    private boolean habilitado;

    @DatabaseField
    private int icono_asociado;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String mensaje;

    @DatabaseField
    private R1sDOSqZ2z tipo_promo;

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

    public R1sDOSqZ2z getTipo_promo() {
        return this.tipo_promo;
    }

    public void setTipo_promo(R1sDOSqZ2z tipo_promo) {
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
