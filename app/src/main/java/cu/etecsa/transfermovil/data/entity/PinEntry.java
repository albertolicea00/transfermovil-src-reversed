package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin
 * @fingerprint @DatabaseTable, ITMDataDatabase, pin, descripcion, HTML toString
 *
 * ORMLite entity storing saved PINs with optional descriptions.
 * toString() renders entries with null/empty descriptions in red HTML
 * ({@code <font color=#f44336>}), suggesting these are displayed in
 * a WebView or HTML-capable TextView.
 *
 * SECURITY: PINs stored as plaintext strings in SQLite.
 */
@DatabaseTable(tableName = "Pin")
public class PinEntry implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String pin;

    @DatabaseField
    private String descripcion;

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

    /**
     * Returns HTML-formatted string. Entries with null or empty description
     * are wrapped in red font tags. The null check has a redundant branch
     * in the original decompiled code (checks null, then checks non-null
     * with length == 0 separately).
     */
    @Override
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

    @Override
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
