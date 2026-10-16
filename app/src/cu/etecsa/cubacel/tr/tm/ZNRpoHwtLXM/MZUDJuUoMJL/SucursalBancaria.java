package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

/* JADX INFO: loaded from: classes.dex */
public class SucursalBancaria {
    public String codigoSucursal;
    public String dpa;
    public String titulo;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDpa() {
        return this.dpa;
    }

    public void setDpa(String dpa) {
        this.dpa = dpa;
    }

    public String getCodigoSucursal() {
        return this.codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String toString() {
        return this.codigoSucursal + " - " + this.titulo;
    }
}
