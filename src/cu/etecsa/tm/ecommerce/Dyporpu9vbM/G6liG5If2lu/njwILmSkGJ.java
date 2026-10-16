package cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class njwILmSkGJ implements Serializable {
    public String abreviatura;
    public String cod_provincia;
    public String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCod_provincia() {
        return this.cod_provincia;
    }

    public void setCod_provincia(String cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String toString() {
        return this.cod_provincia + " - " + this.abreviatura;
    }
}
