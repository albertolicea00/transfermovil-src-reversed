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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Client")
public class Client implements ITMDataDatabase {

    @DatabaseField
    private String address;

    @DatabaseField
    private String ci;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String phone;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return "66666666";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCi() {
        return this.ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        String str = this.name;
        if (str == null) {
            return "<font color=#f44336>" + this.phone + "</font>," + this.name;
        }
        if (str != null && str.length() == 0) {
            return "<font color=#f44336>" + this.phone + "</font>," + this.name;
        }
        return this.phone + "," + this.name;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("Client");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema name = new FieldSchema();
        name.setNombre("name");
        name.setTipo(FieldType.IDENTITY);
        camposList.add(name);
        FieldSchema phone = new FieldSchema();
        phone.setNombre("phone");
        FieldType cqi3wj0jbl = FieldType.DATA;
        phone.setTipo(cqi3wj0jbl);
        camposList.add(phone);
        FieldSchema ci = new FieldSchema();
        ci.setNombre("ci");
        ci.setTipo(cqi3wj0jbl);
        camposList.add(ci);
        FieldSchema address = new FieldSchema();
        address.setNombre("address");
        address.setTipo(cqi3wj0jbl);
        camposList.add(address);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
