package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx
 */
public class PaymentStoreRequest {
    @SerializedName("amont") public float amont;
    @SerializedName("description") public String description;
    @SerializedName("pago") public PaymentInner pago;

    public static class PaymentInner {
        @SerializedName("external_code") public String external_code;
        @SerializedName("payment_code") public String payment_code;
        @SerializedName("source") public String source;
    }
}
