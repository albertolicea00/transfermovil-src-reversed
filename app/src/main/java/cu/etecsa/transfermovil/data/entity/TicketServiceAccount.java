package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MiBoletoService
 * @fingerprint @DatabaseField but NO @DatabaseTable, code/phone fields
 *
 * Service registration for the "Mi Boleto" (ticket) module.
 * Same pattern as BankAccount (BancoService) and AgentAccount (AgentService):
 * stores the service code and associated phone number.
 *
 * NOTE: Has @DatabaseField annotations on fields but is MISSING the
 * @DatabaseTable class annotation. This may be a decompiler artifact
 * or intentional (entity registered programmatically).
 */
public class TicketServiceAccount {

    @DatabaseField
    private String code;

    @DatabaseField
    private String phone;

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
