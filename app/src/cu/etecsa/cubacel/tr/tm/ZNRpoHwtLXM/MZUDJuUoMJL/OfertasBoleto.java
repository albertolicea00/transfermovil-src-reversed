package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class OfertasBoleto {

    @DatabaseField
    public int cantPersona;

    @DatabaseField
    public Date fecha;

    @DatabaseField
    public String fechaOferta;

    @DatabaseField(id = true, unique = true)
    public String id;

    @DatabaseField
    public long id_control;

    @DatabaseField
    public String moneda;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public double precio;

    @DatabaseField
    public int tipo_oferta;

    @DatabaseField
    public int validDays;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTipo_oferta() {
        return this.tipo_oferta;
    }

    public void setTipo_oferta(int tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaOferta() {
        return this.fechaOferta;
    }

    public void setFechaOferta(String fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public String toString() {
        return this.nombre + " - " + this.precio + " " + this.moneda;
    }

    public int getValidDays() {
        return this.validDays;
    }

    public void setValidDays(int validDays) {
        this.validDays = validDays;
    }

    public int getCantPersona() {
        return this.cantPersona;
    }

    public void setCantPersona(int cantPersona) {
        this.cantPersona = cantPersona;
    }

    public long getId_control() {
        return this.id_control;
    }

    public void setId_control(long id_control) {
        this.id_control = id_control;
    }
}
