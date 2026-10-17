package cu.etecsa.transfermovil.data.model;

/**
 * Payment channel reference data.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Canal
 * @fingerprint nombre, id, consecutivo, esDePago fields; payment channel catalog
 */
public class Channel {

    private String nombre;
    private String id;
    private String consecutivo;
    private boolean esDePago;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public boolean isEsDePago() {
        return esDePago;
    }

    public void setEsDePago(boolean esDePago) {
        this.esDePago = esDePago;
    }
}
