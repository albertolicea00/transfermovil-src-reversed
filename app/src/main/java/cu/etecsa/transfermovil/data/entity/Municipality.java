package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio
 * @fingerprint @DatabaseTable, String id PK, cod_municipio/nombre/abreviatura/cod_provincia
 *
 * ORMLite entity for Cuban municipality lookup data.
 * Pre-populated reference table linking municipality codes to provinces.
 */
@DatabaseTable(tableName = "Municipio")
public class Municipality {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private String cod_municipio;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String abreviatura;

    @DatabaseField
    private String cod_provincia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodMunicipio() {
        return cod_municipio;
    }

    public void setCodMunicipio(String cod_municipio) {
        this.cod_municipio = cod_municipio;
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

    public String getCodProvincia() {
        return cod_provincia;
    }

    public void setCodProvincia(String cod_provincia) {
        this.cod_provincia = cod_provincia;
    }
}
