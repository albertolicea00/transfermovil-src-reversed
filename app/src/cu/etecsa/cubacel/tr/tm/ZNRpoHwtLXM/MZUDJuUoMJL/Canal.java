package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

/* JADX INFO: loaded from: classes.dex */
public class Canal {
    private String consecutivo;
    private int esDePago;
    private String id;
    private String nombre;

    public Canal() {
    }

    public Canal(String nombre, String id, String consecutivo, int esDePago) {
        this.nombre = nombre;
        this.id = id;
        this.consecutivo = consecutivo;
        this.esDePago = esDePago;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsecutivo() {
        return this.consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getEsDePago() {
        return this.esDePago;
    }

    public void setEsDePago(int esDePago) {
        this.esDePago = esDePago;
    }

    public String toString() {
        return this.nombre;
    }
}
