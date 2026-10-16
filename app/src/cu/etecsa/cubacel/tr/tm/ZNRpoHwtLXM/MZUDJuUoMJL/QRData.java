package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QRData {

    @SerializedName("Ci")
    private String ci;

    @SerializedName("Dt")
    private List<DetalleAdicional> detallesAdicionales;

    @SerializedName("P")
    private String pin;

    @SerializedName("T")
    private String token;

    public static class DetalleAdicional {

        @SerializedName("dc")
        private String dc;

        @SerializedName("id")
        private String id;

        @SerializedName("m")
        private String m;

        @SerializedName("v")
        private String v;

        public String getDescripcion() {
            return this.dc;
        }

        public String getId() {
            return this.id;
        }

        public String getMoneda() {
            return this.m;
        }

        public String getValor() {
            return this.v;
        }
    }

    public String getPin() {
        return this.pin;
    }

    public String getToken() {
        return this.token;
    }

    public List<DetalleAdicional> getDetallesAdicionales() {
        return this.detallesAdicionales;
    }

    public String getCi() {
        return this.ci;
    }
}
