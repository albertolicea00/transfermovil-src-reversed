package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AgentService
 * @fingerprint @DatabaseTable, fields: code, phone (no bank PINs)
 *
 * ORMLite entity for business agent accounts. Stores the agent's activation
 * code and associated phone number. Used when the app is in Agent mode
 * (activated via getCodigoAgente + check_code_activation).
 */
@DatabaseTable(tableName = "AgentService")
public class AgentAccount {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String code;

    @DatabaseField
    private String phone;

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
}
