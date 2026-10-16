package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class TMonedasWallet {

    @DatabaseField
    private int allowTransfer;

    @DatabaseField
    private String currency;

    @DatabaseField
    private String descripcion;

    @DatabaseField
    private Date fecha;

    @DatabaseField(generatedId = false, id = true)
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAllowTransfer() {
        return this.allowTransfer;
    }

    public void setAllowTransfer(int allowTransfer) {
        this.allowTransfer = allowTransfer;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
