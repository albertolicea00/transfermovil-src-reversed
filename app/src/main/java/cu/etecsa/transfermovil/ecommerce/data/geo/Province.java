package cu.etecsa.transfermovil.ecommerce.data.geo;

import java.io.Serializable;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ
 */
public class Province implements Serializable {
    public String abreviatura;
    public String cod_provincia;
    public String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAbreviatura() { return abreviatura; }
    public void setAbreviatura(String abreviatura) { this.abreviatura = abreviatura; }
    public String getCod_provincia() { return cod_provincia; }
    public void setCod_provincia(String cod_provincia) { this.cod_provincia = cod_provincia; }

    public String toString() {
        return cod_provincia + " - " + abreviatura;
    }
}
