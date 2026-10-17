package cu.etecsa.transfermovil.data.model;

/**
 * ONAT/OFA tax obligation entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ObligacionesOFA
 * @fingerprint code, descripcion, abreviatura fields; OFA obligation catalog
 */
public class OfaObligation {

    private String code;
    private String descripcion;
    private String abreviatura;

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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
