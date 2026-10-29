package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4
 * @original_apk_version 1.260416
 */
public class RefundRequest implements BaseRequest {

    @SerializedName("amount")
    public float amount;

    @SerializedName("description")
    public String description;

    @SerializedName("sources")
    public int sources;

    public int getSources() {
        return this.sources;
    }

    public void setSources(int sources) {
        this.sources = sources;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
