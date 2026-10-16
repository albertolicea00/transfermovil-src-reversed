package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.BancoService
 * @fingerprint @DatabaseTable, fields: code, phone, pmetro, pbpa, pbandec
 *
 * ORMLite entity persisted in TransferMDB.sqlite. Stores the user's bank
 * service association: which banks are linked, the phone number used for
 * USSD operations, and the PIN for each bank.
 *
 * SECURITY: All three bank PINs stored as plaintext strings. Combined with
 * debuggable=true and allowBackup=true, full credential extraction is
 * trivial via adb backup.
 */
@DatabaseTable(tableName = "BancoService")
public class BankAccount {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String code;

    @DatabaseField
    private String phone;

    /** Metropolitano bank PIN — STORED IN PLAINTEXT */
    @DatabaseField
    private String pmetro;

    /** BPA bank PIN — STORED IN PLAINTEXT */
    @DatabaseField
    private String pbpa;

    /** BANDEC bank PIN — STORED IN PLAINTEXT */
    @DatabaseField
    private String pbandec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPinMetropolitano() {
        return pmetro;
    }

    public void setPinMetropolitano(String pin) {
        this.pmetro = pin;
    }

    public String getPinBpa() {
        return pbpa;
    }

    public void setPinBpa(String pin) {
        this.pbpa = pin;
    }

    public String getPinBandec() {
        return pbandec;
    }

    public void setPinBandec(String pin) {
        this.pbandec = pin;
    }
}
