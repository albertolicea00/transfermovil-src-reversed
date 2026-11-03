package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Factura")
public class Invoice implements ITMDataDatabase {

    @DatabaseField
    private String cod_factura;

    @DatabaseField
    private String factura;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private int tipo_factura;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura() {
        return this.factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getTipo_Factura() {
        return this.tipo_factura;
    }

    public void setTipo_Factura(int tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getCodFactura() {
        return this.cod_factura;
    }

    public void setCodFactura(String cod_factura) {
        this.cod_factura = cod_factura;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("Factura");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema factura = new FieldSchema();
        factura.setNombre("factura");
        factura.setTipo(FieldType.IDENTITY);
        camposList.add(factura);
        FieldSchema tipo_factura = new FieldSchema();
        tipo_factura.setNombre("tipo_factura");
        FieldType cqi3wj0jbl = FieldType.DATA;
        tipo_factura.setTipo(cqi3wj0jbl);
        camposList.add(tipo_factura);
        FieldSchema idCliente = new FieldSchema();
        idCliente.setNombre("id_client");
        idCliente.setTipo(FieldType.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        FieldSchema cod_factura = new FieldSchema();
        cod_factura.setNombre("cod_factura");
        cod_factura.setTipo(cqi3wj0jbl);
        camposList.add(cod_factura);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
