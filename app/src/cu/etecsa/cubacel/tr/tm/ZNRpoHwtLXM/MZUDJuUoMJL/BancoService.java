package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class BancoService {

    @DatabaseField
    private String code;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String pbandec;

    @DatabaseField
    private String pbpa;

    @DatabaseField
    private String phone;

    @DatabaseField
    private String pmetro;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPmetro() {
        return this.pmetro;
    }

    public void setPmetro(String pmetro) {
        this.pmetro = pmetro;
    }

    public String getPbpa() {
        return this.pbpa;
    }

    public void setPbpa(String pbpa) {
        this.pbpa = pbpa;
    }

    public String getPbandec() {
        return this.pbandec;
    }

    public void setPbandec(String pbandec) {
        this.pbandec = pbandec;
    }
}
