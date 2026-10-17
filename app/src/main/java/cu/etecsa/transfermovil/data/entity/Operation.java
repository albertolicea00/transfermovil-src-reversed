package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.core.enums.BankType;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion
 * @fingerprint @DatabaseTable, operacion (BankOperationCode), activo, titulo, fragment_name, order, tipo_servicio (BankType)
 *
 * ORMLite entity representing a banking operation menu item. Each row maps
 * an operation code to its UI presentation (title, subtitle, icon resource,
 * fragment class name) and activation state.
 *
 * NOTE: The getter/setter for tipo_servicio has a typo in the original
 * decompiled source: getTipo_serivicio() (missing 'c' in servicio).
 * Preserved here for binary compatibility.
 */
@DatabaseTable(tableName = "Operacion")
public class Operation {

    @DatabaseField(generatedId = true)
    private int id;

    /** Bank operation code enum. obfuscated: FdonIAFI9w (BankOperationCode, 332 values) */
    @DatabaseField
    private String operacion;
    // Original type: BankOperationCode (obfuscated: FdonIAFI9w)
    // Stored as String because the enum has 332 values and is not yet reconstructed.

    @DatabaseField
    private boolean activo;

    @DatabaseField
    private String titulo;

    @DatabaseField
    private String subtitulo;

    @DatabaseField
    private int imagen;

    @DatabaseField
    private String fragment_name;

    @DatabaseField
    private int order;

    /** obfuscated: R1sDOSqZ2z */
    @DatabaseField
    private BankType tipo_servicio;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperacion() {
        return this.operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImagen() {
        return this.imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getFragment_name() {
        return this.fragment_name;
    }

    public void setFragment_name(String fragment_name) {
        this.fragment_name = fragment_name;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * NOTE: Typo preserved from original decompiled source — "serivicio" instead
     * of "servicio". The original getter name is getTipo_serivicio().
     */
    public BankType getTipo_serivicio() {
        return this.tipo_servicio;
    }

    /**
     * NOTE: Typo preserved from original — "serivicio" instead of "servicio".
     */
    public void setTipo_serivicio(BankType tipo_serivicio) {
        this.tipo_servicio = tipo_serivicio;
    }
}
