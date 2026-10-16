package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class CompraPlanesCubacel {

    @DatabaseField
    private Date fechaAct;

    @DatabaseField
    private String nombre = this.nombre;

    @DatabaseField
    private String nombre = this.nombre;

    @DatabaseField(columnName = "id")
    private int id = this.id;

    @DatabaseField(columnName = "id")
    private int id = this.id;

    @DatabaseField
    private int version_ussd = this.version_ussd;

    @DatabaseField
    private int version_ussd = this.version_ussd;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion_ussd() {
        return this.version_ussd;
    }

    public void setVersion_ussd(int version_ussd) {
        this.version_ussd = version_ussd;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public Date getFecha() {
        return this.fechaAct;
    }
}
