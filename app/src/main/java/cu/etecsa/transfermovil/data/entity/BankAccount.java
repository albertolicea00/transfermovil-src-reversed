package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.BancoService
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "BancoService")
public class BankAccount {

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
