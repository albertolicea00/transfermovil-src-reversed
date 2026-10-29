package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.List;
import cu.etecsa.transfermovil.data.ITMDataDatabase;

/**
 * Tax reference row, including original import/export metadata quirks.
 * The metadata names its table "Nauta" and repeats "nombre" for the tipo field;
 * these values are preserved from the APK rather than corrected speculatively.
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Tributo
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Tributo")
public class TaxRecord implements ITMDataDatabase {

    @DatabaseField
    public String abreviatura;

    @DatabaseField(id = true)
    public String cod_tributo;

    @DatabaseField
    public String moneda;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public String tipo;

    @DatabaseField
    public String tipoPersona;

    public String getCod_tributo() {
        return this.cod_tributo;
    }

    public void setCod_tributo(String cod_tributo) {
        this.cod_tributo = cod_tributo;
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

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String toString() {
        return this.cod_tributo + " - " + this.abreviatura;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("Nauta");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema cod_tributo = new FieldSchema();
        cod_tributo.setNombre("cod_tributo");
        cod_tributo.setTipo(FieldType.IDENTITY);
        camposList.add(cod_tributo);
        FieldSchema nombre = new FieldSchema();
        nombre.setNombre("nombre");
        FieldType dataType = FieldType.DATA;
        nombre.setTipo(dataType);
        camposList.add(nombre);
        FieldSchema abreviatura = new FieldSchema();
        abreviatura.setNombre("abreviatura");
        abreviatura.setTipo(dataType);
        camposList.add(abreviatura);
        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(dataType);
        camposList.add(moneda);
        FieldSchema tipo = new FieldSchema();
        tipo.setNombre("nombre");
        tipo.setTipo(dataType);
        camposList.add(tipo);
        FieldSchema tipoPersona = new FieldSchema();
        tipoPersona.setNombre("tipoPersona");
        tipoPersona.setTipo(dataType);
        camposList.add(tipoPersona);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
