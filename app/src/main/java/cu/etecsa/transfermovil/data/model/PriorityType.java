package cu.etecsa.transfermovil.data.model;

/**
 * Tax priority type entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TipoPrelacion
 * @fingerprint code, descripcion fields; toString returns descripcion
 */
public class PriorityType {

    private String code;
    private String descripcion;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
