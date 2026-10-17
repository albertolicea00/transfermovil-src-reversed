package cu.etecsa.transfermovil.ecommerce.model.response;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5 */
public class QrPaymentResponse extends BaseApiResult {
    public QrData qrResponse;

    public QrData getQrResponse() { return qrResponse; }
    public void setQrResponse(QrData qrResponse) { this.qrResponse = qrResponse; }

    public class QrData {
        @SerializedName("id_transaccion") public String id_transaccion;
        @SerializedName("importe") public float importe;
    }
}
