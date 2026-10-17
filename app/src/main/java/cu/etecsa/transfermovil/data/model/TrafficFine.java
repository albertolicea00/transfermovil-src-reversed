package cu.etecsa.transfermovil.data.model;

/**
 * Traffic violation fine entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MultasTransito
 * @fingerprint articulo, inciso, descripcion, peligrosidad fields; traffic fine catalog
 */
public class TrafficFine {

    private String articulo;
    private String inciso;
    private String descripcion;
    private String peligrosidad;

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getInciso() {
        return inciso;
    }

    public void setInciso(String inciso) {
        this.inciso = inciso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }
}
