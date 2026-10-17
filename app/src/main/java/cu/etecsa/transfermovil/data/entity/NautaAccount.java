package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta
 * @fingerprint @DatabaseTable, ITMDataDatabase, cuenta/tipo_cuenta/id_client fields
 *
 * ORMLite entity for Nauta email/internet accounts.
 * Links a Nauta account (email or internet) to a Client via foreign key.
 */
@DatabaseTable(tableName = "Nauta")
public class NautaAccount implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String cuenta;

    @DatabaseField
    private String tipo_cuenta;

    /** Foreign key to Client table */
    @DatabaseField
    private int id_client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoCuenta() {
        return tipo_cuenta;
    }

    public void setTipoCuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getIdClient() {
        return id_client;
    }

    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata("Nauta");
        metadata.setPrimaryKey("id");
        metadata.addDataField("cuenta");
        metadata.addDataField("tipo_cuenta");
        metadata.addDataField("id_client");
        return metadata;
    }
}
