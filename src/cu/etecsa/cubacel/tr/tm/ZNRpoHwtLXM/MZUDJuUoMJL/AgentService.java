package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class AgentService {

    @DatabaseField
    private String code;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String phone;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
