package cu.etecsa.transfermovil.ecommerce.model.response;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5
 * @original_apk_version 1.260416
 */
public class QrPaymentResponse extends BaseApiResult {
    public QrData qrResponse;

    public QrData getQrResponse() {
        return this.qrResponse;
    }

    public void setQrResponse(QrData qrResponse) {
        this.qrResponse = qrResponse;
    }

    public class QrData {

        @SerializedName("id_transaccion")
        public String id_transaccion;

        @SerializedName("importe")
        public float importe;

        @SerializedName("moneda")
        public String moneda;

        @SerializedName("numero_proveedor")
        public String numero_proveedor;

        @SerializedName("version")
        public String version;

        public QrData() {
        }

        public String getId_transaccion() {
            return this.id_transaccion;
        }

        public void setId_transaccion(String id_transaccion) {
            this.id_transaccion = id_transaccion;
        }

        public float getImporte() {
            return this.importe;
        }

        public void setImporte(float importe) {
            this.importe = importe;
        }

        public String getMoneda() {
            return this.moneda;
        }

        public void setMoneda(String moneda) {
            this.moneda = moneda;
        }

        public String getNumero_proveedor() {
            return this.numero_proveedor;
        }

        public void setNumero_proveedor(String numero_proveedor) {
            this.numero_proveedor = numero_proveedor;
        }

        public String getVersion() {
            return "5";
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
