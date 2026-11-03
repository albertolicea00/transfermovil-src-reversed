package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.core.enums.Currency;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "TarjetaPropia")
public class OwnCard implements ITMDataDatabase {

    @DatabaseField
    private String descripcion;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private String serie;

    @DatabaseField
    private Currency tipo_moneda;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Currency getTipo_moneda() {
        return this.tipo_moneda;
    }

    public void setTipo_moneda(Currency tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("TarjetaPropia");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema idCliente = new FieldSchema();
        idCliente.setNombre("id_client");
        idCliente.setTipo(FieldType.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        FieldSchema tipoMoneda = new FieldSchema();
        tipoMoneda.setNombre("tipo_moneda");
        FieldType cqi3wj0jbl = FieldType.DATA;
        tipoMoneda.setTipo(cqi3wj0jbl);
        camposList.add(tipoMoneda);
        FieldSchema serie = new FieldSchema();
        serie.setNombre("serie");
        serie.setTipo(FieldType.IDENTITY);
        camposList.add(serie);
        FieldSchema descripcion = new FieldSchema();
        descripcion.setNombre("descripcion");
        descripcion.setTipo(cqi3wj0jbl);
        camposList.add(descripcion);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
