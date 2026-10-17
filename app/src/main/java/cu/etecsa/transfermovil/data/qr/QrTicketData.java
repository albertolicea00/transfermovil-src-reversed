package cu.etecsa.transfermovil.data.qr;

import java.util.ArrayList;
import java.util.List;

/**
 * QR code data for ticket (MiBoleto) purchases.
 * Supports parsing pipe-delimited detail strings.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRMiBoleto
 * @fingerprint agregarDetallesDesdeString pipe/semicolon parser; inner AdditionalDetail with id,dc,v,m
 */
public class QrTicketData {

    private String P;
    private String T;
    private String Id;
    private String Ci;
    private List<AdditionalDetail> Dt;

    public String getPin() {
        return P;
    }

    public void setPin(String pin) {
        this.P = pin;
    }

    public String getToken() {
        return T;
    }

    public void setToken(String token) {
        this.T = token;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String ci) {
        this.Ci = ci;
    }

    public List<AdditionalDetail> getDt() {
        return Dt;
    }

    public void setDt(List<AdditionalDetail> dt) {
        this.Dt = dt;
    }

    /**
     * Parses a pipe-delimited string of detail items.
     * Each item is semicolon-delimited: "id;descripcion;valor;moneda".
     *
     * @param datos pipe-separated detail entries
     */
    public void agregarDetallesDesdeString(String datos) {
        if (datos == null || datos.isEmpty()) {
            return;
        }
        if (Dt == null) {
            Dt = new ArrayList<>();
        }
        String[] items = datos.split("\\|");
        for (String item : items) {
            String[] parts = item.split(";");
            if (parts.length >= 4) {
                AdditionalDetail detail = new AdditionalDetail();
                detail.setId(parts[0]);
                detail.setDescripcion(parts[1]);
                detail.setValor(parts[2]);
                detail.setMoneda(parts[3]);
                Dt.add(detail);
            }
        }
    }

    /**
     * Additional detail line item within a QR ticket.
     */
    public static class AdditionalDetail {

        private String id;
        private String dc;
        private String v;
        private String m;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescripcion() {
            return dc;
        }

        public void setDescripcion(String descripcion) {
            this.dc = descripcion;
        }

        public String getValor() {
            return v;
        }

        public void setValor(String valor) {
            this.v = valor;
        }

        public String getMoneda() {
            return m;
        }

        public void setMoneda(String moneda) {
            this.m = moneda;
        }
    }
}
