package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel
 * @fingerprint @DatabaseTable, nombre/version_ussd/fechaAct fields
 *
 * ORMLite entity for Cubacel mobile plan definitions.
 * Stores plan name, USSD version string, and last update date.
 *
 * NOTE: JADX decompilation produced duplicate field names in the original
 * output; this reconstruction resolves them to their intended semantics.
 */
@DatabaseTable(tableName = "CompraPlanesCubacel")
public class CubacelPlan {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String version_ussd;

    @DatabaseField
    private String fechaAct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersionUssd() {
        return version_ussd;
    }

    public void setVersionUssd(String version_ussd) {
        this.version_ussd = version_ussd;
    }

    public String getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }
}
