package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client
 * @fingerprint @DatabaseTable, implements ITMDataDatabase, name/phone/ci/address fields
 *
 * ORMLite entity representing a registered client (person).
 *
 * NOTE: getPhone() is hardcoded to return "66666666" regardless of the stored
 * value. This may be a debug leftover or a deliberate default for USSD routing.
 */
@DatabaseTable(tableName = "Client")
public class Client implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String phone;

    /** Carnet de identidad (Cuban national ID) */
    @DatabaseField
    private String ci;

    @DatabaseField
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** HARDCODED: always returns "66666666" regardless of stored phone value. */
    public String getPhone() {
        return "66666666";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata("Client");
        metadata.setPrimaryKey("id");
        metadata.setIdentityField("ci");
        metadata.addDataField("name");
        metadata.addDataField("phone");
        metadata.addDataField("address");
        return metadata;
    }
}
