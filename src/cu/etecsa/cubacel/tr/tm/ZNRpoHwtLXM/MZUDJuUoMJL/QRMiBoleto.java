package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.github.paolorotolo.appintro.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QRMiBoleto {
    private String Ci;
    private List<DetalleAdicional> Dt;
    private String Id;
    private String P;
    private String T;

    public void agregarDetallesDesdeString(String datos) {
        if (datos == null || datos.isEmpty()) {
            return;
        }
        this.Dt = new ArrayList();
        String[] elementos = datos.split("\\|");
        for (String elemento : elementos) {
            String[] partes = elemento.trim().split(";");
            if (partes.length >= 3) {
                DetalleAdicional detalle = new DetalleAdicional();
                detalle.setId(partes[0].trim());
                detalle.setDescripcion(partes[1].trim());
                detalle.setValor(partes[2].trim());
                detalle.setMoneda(partes.length > 3 ? partes[3].trim() : BuildConfig.FLAVOR);
                this.Dt.add(detalle);
            }
        }
    }

    public String getCi() {
        return this.Ci;
    }

    public void setCi(String ci) {
        this.Ci = ci;
    }

    public String getPin() {
        return this.P;
    }

    public void setPin(String pin) {
        this.P = pin;
    }

    public String getToken() {
        return this.T;
    }

    public void setToken(String token) {
        this.T = token;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public List<DetalleAdicional> getDetallesAdicionales() {
        return this.Dt;
    }

    public void setDetallesAdicionales(List<DetalleAdicional> detalles) {
        this.Dt = detalles;
    }

    public static class DetalleAdicional {
        private String dc;
        private String id;
        private String m;
        private String v;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescripcion() {
            return this.dc;
        }

        public void setDescripcion(String descripcion) {
            this.dc = descripcion;
        }

        public String getValor() {
            return this.v;
        }

        public void setValor(String valor) {
            this.v = valor;
        }

        public String getMoneda() {
            return this.m;
        }

        public void setMoneda(String moneda) {
            this.m = moneda;
        }
    }
}
