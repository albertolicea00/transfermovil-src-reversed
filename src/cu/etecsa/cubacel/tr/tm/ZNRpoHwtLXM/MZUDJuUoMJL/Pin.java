package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class Pin implements ITMDataDatabase {

    @DatabaseField
    private String descripcion;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String pin;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        String str = this.descripcion;
        if (str == null) {
            return "<font color=#f44336>" + this.pin + "</font>," + this.descripcion;
        }
        if (str != null && str.length() == 0) {
            return "<font color=#f44336>" + this.pin + "</font>," + this.descripcion;
        }
        return this.pin + "," + this.descripcion;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("Pin");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 cuenta = new z9CJ2fIAs7();
        cuenta.setNombre("pin");
        cuenta.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(cuenta);
        z9CJ2fIAs7 tipo_cuenta = new z9CJ2fIAs7();
        tipo_cuenta.setNombre("descripcion");
        tipo_cuenta.setTipo(cQi3wj0jBL.DATA);
        camposList.add(tipo_cuenta);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
