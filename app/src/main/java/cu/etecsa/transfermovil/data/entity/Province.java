package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Provincia")
public class Province {

    @DatabaseField
    public String abreviatura;

    @DatabaseField(id = true)
    public String cod_provincia;

    @DatabaseField
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
