package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura
 * @fingerprint @DatabaseTable, ITMDataDatabase, factura/tipo_factura/id_client/cod_factura fields
 *
 * ORMLite entity for utility invoices (electricity, water, phone, etc.).
 * Links an invoice code and type to a Client via foreign key.
 */
@DatabaseTable(tableName = "Factura")
public class Invoice implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String factura;

    @DatabaseField
    private String tipo_factura;

    /** Foreign key to Client table */
    @DatabaseField
    private int id_client;

    @DatabaseField
    private String cod_factura;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getTipoFactura() {
        return tipo_factura;
    }

    public void setTipoFactura(String tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public int getIdClient() {
        return id_client;
    }

    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    public String getCodFactura() {
        return cod_factura;
    }

    public void setCodFactura(String cod_factura) {
        this.cod_factura = cod_factura;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata("Factura");
        metadata.setPrimaryKey("id");
        metadata.addDataField("factura");
        metadata.addDataField("tipo_factura");
        metadata.addDataField("id_client");
        metadata.addDataField("cod_factura");
        return metadata;
    }
}
