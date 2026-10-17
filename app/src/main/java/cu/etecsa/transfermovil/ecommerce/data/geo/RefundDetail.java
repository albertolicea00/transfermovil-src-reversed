package cu.etecsa.transfermovil.ecommerce.data.geo;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.scwi3AAgLR
 *
 * Refund record from API with @SerializedName JSON contract.
 */
public class RefundDetail {
    @SerializedName("amount") public int amount;
    @SerializedName("banck") public int banck;
    @SerializedName("bank_id") public String bank_id;
    @SerializedName("callback") public String callback;
    @SerializedName("created_at") public String created_at;
    @SerializedName("currency") public String currency;
    @SerializedName("external_code") public String external_code;
    @SerializedName("id") public int id;
    @SerializedName("notified_at") public String notified_at;
    @SerializedName("payment_code") public String payment_code;
    @SerializedName("reference_refund") public String reference_refund;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
