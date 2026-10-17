package cu.etecsa.transfermovil.data.qr;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * QR code payment data with Gson serialized field names.
 * Read-only model: only getters, no setters.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRData
 * @fingerprint @SerializedName("P","T","Ci","Dt"); inner AdditionalDetail with "id","dc","v","m"
 */
public class QrPaymentData {

    @SerializedName("P")
    private String pin;

    @SerializedName("T")
    private String token;

    @SerializedName("Ci")
    private String ci;

    @SerializedName("Dt")
    private List<AdditionalDetail> detallesAdicionales;

    public String getPin() {
        return pin;
    }

    public String getToken() {
        return token;
    }

    public String getCi() {
        return ci;
    }

    public List<AdditionalDetail> getDetallesAdicionales() {
        return detallesAdicionales;
    }

    /**
     * Additional detail line item within a QR payment.
     */
    public static class AdditionalDetail {

        @SerializedName("id")
        private String id;

        @SerializedName("dc")
        private String descripcion;

        @SerializedName("v")
        private String valor;

        @SerializedName("m")
        private String moneda;

        public String getId() {
            return id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getValor() {
            return valor;
        }

        public String getMoneda() {
            return moneda;
        }
    }
}
