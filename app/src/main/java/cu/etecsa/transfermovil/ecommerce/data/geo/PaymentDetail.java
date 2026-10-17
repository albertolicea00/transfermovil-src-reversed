package cu.etecsa.transfermovil.ecommerce.data.geo;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.jxtoYnTPbp
 *
 * Detailed payment record from API with @SerializedName JSON contract.
 */
public class PaymentDetail {
    @SerializedName("amount") public float amount;
    @SerializedName("banck") public int banck;
    @SerializedName("banck_code") public String banck_code;
    @SerializedName("callback") public String callback;
    @SerializedName("cellphone") public String cellphone;
    @SerializedName("created_at") public String created_at;
    @SerializedName("currency") public String currency;
    @SerializedName("description") public String description;
    @SerializedName("external_code") public String external_code;
    @SerializedName("id") public int id;
    @SerializedName("notified_at") public String notified_at;

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getExternal_code() { return external_code; }
    public void setExternal_code(String external_code) { this.external_code = external_code; }
}
