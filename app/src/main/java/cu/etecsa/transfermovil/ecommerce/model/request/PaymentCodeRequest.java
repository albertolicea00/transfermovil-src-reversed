package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.MlJJtXnfZh
 * @original_apk_version 1.260416
 */
public class PaymentCodeRequest implements BaseRequest {

    @SerializedName("payment_code")
    public String payment_code;

    public String getPayment_code() {
        return this.payment_code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }
}
