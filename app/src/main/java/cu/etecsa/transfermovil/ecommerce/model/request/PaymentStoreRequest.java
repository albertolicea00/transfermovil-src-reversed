package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;
import java.io.Serializable;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx
 * @original_apk_version 1.260416
 */
public class PaymentStoreRequest implements BaseRequest, Serializable {

    @SerializedName("amont")
    public float amont;

    @SerializedName("description")
    public String description;

    @SerializedName("pago")
    public PaymentInner pago;

    public PaymentInner getPago() {
        return this.pago;
    }

    public void setPago(PaymentInner pago) {
        this.pago = pago;
    }

    public float getAmont() {
        return this.amont;
    }

    public void setAmont(float amont) {
        this.amont = amont;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class PaymentInner {

        @SerializedName("external_code")
        public String external_code;

        @SerializedName("payment_code")
        public String payment_code;

        @SerializedName("source")
        public int source;

        public String getPayment_code() {
            return this.payment_code;
        }

        public void setPayment_code(String payment_code) {
            this.payment_code = payment_code;
        }

        public String getExternal_code() {
            return this.external_code;
        }

        public void setExternal_code(String external_code) {
            this.external_code = external_code;
        }

        public int getSource() {
            return this.source;
        }

        public void setSource(int source) {
            this.source = source;
        }
    }
}
