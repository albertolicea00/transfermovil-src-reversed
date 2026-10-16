package cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.XpLbwNXtZPa.fGYt3sYXbt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FhtwnBtOAx implements fGYt3sYXbt, Serializable {

    @SerializedName("amont")
    public float amont;

    @SerializedName("description")
    public String description;

    @SerializedName("pago")
    public Pago pago;

    public Pago getPago() {
        return this.pago;
    }

    public void setPago(Pago pago) {
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

    public static class Pago {

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
