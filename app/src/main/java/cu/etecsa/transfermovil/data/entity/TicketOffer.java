package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.OfertasBoleto
 * @fingerprint @DatabaseTable, id PK+unique, nombre, precio, moneda, tipo_oferta, validDays
 *
 * ORMLite entity for ticket/boleto offers. Each row represents an available
 * offer with pricing, currency, validity period, and passenger capacity.
 */
@DatabaseTable(tableName = "OfertasBoleto")
public class TicketOffer {

    @DatabaseField(id = true, unique = true)
    public String id;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public double precio;

    @DatabaseField
    public String moneda;

    @DatabaseField
    public int tipo_oferta;

    @DatabaseField
    public Date fecha;

    @DatabaseField
    public String fechaOferta;

    @DatabaseField
    public int cantPersona;

    @DatabaseField
    public long id_control;

    @DatabaseField
    public int validDays;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTipo_oferta() {
        return this.tipo_oferta;
    }

    public void setTipo_oferta(int tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
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

    public int getValidDays() {
        return this.validDays;
    }

    public void setValidDays(int validDays) {
        this.validDays = validDays;
    }

    @Override
    public String toString() {
        return this.nombre + " - " + this.precio + " " + this.moneda;
    }
}
