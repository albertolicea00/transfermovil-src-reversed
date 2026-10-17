package cu.etecsa.transfermovil.ecommerce.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.l1i6XXWOfGBF.zMnpbxBIN5
 *
 * Payment record API DTO (separate from domain entity TransactionRecord).
 */
public class PaymentRecord {
    @SerializedName("amount") public float amount;
    @SerializedName("banck") public int banck;
    @SerializedName("banck_code") public String banck_code;
    @SerializedName("cellphone") public String cellphone;
    @SerializedName("create_user") public String create_user;

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
    public int getBanck() { return banck; }
    public void setBanck(int banck) { this.banck = banck; }
}
