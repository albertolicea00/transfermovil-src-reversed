package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Pin")
public class PinEntry implements ITMDataDatabase {

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
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("Pin");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema cuenta = new FieldSchema();
        cuenta.setNombre("pin");
        cuenta.setTipo(FieldType.IDENTITY);
        camposList.add(cuenta);
        FieldSchema tipo_cuenta = new FieldSchema();
        tipo_cuenta.setNombre("descripcion");
        tipo_cuenta.setTipo(FieldType.DATA);
        camposList.add(tipo_cuenta);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
