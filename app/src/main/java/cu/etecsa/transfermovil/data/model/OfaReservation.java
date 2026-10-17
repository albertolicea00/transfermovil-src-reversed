package cu.etecsa.transfermovil.data.model;

/**
 * OFA reservation entry with dual pricing (national/foreign).
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ReservasOFA
 * @fingerprint precioNac/precioExt dual pricing; toString returns nombre
 */
public class OfaReservation {

    private String code;
    private String nombre;
    private String abreviatura;
    private String ciudad;
    private String precioNac;
    private String precioExt;
    private String monedaNac;
    private String monedaExt;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPrecioNac() {
        return precioNac;
    }

    public void setPrecioNac(String precioNac) {
        this.precioNac = precioNac;
    }

    public String getPrecioExt() {
        return precioExt;
    }

    public void setPrecioExt(String precioExt) {
        this.precioExt = precioExt;
    }

    public String getMonedaNac() {
        return monedaNac;
    }

    public void setMonedaNac(String monedaNac) {
        this.monedaNac = monedaNac;
    }

    public String getMonedaExt() {
        return monedaExt;
    }

    public void setMonedaExt(String monedaExt) {
        this.monedaExt = monedaExt;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
