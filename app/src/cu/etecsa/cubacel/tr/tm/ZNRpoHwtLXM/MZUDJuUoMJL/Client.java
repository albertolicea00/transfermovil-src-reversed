package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
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
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("Client");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 name = new z9CJ2fIAs7();
        name.setNombre("name");
        name.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(name);
        z9CJ2fIAs7 phone = new z9CJ2fIAs7();
        phone.setNombre("phone");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        phone.setTipo(cqi3wj0jbl);
        camposList.add(phone);
        z9CJ2fIAs7 ci = new z9CJ2fIAs7();
        ci.setNombre("ci");
        ci.setTipo(cqi3wj0jbl);
        camposList.add(ci);
        z9CJ2fIAs7 address = new z9CJ2fIAs7();
        address.setNombre("address");
        address.setTipo(cqi3wj0jbl);
        camposList.add(address);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
