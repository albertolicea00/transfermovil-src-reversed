package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia
 * @fingerprint @DatabaseTable, cod_provincia PK, nombre, abreviatura, all public
 *
 * ORMLite entity for Cuban provinces. Used in location-based operations
 * such as tax payments and utility lookups.
 */
@DatabaseTable(tableName = "Provincia")
public class Province {

    @DatabaseField(id = true)
    public String cod_provincia;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public String abreviatura;

    public String getCod_provincia() {
        return this.cod_provincia;
    }

    public void setCod_provincia(String cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

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

    @Override
    public String toString() {
        return this.cod_provincia + " - " + this.abreviatura;
    }
}
