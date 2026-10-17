package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto
 * @fingerprint @DatabaseTable, token(unique)/idOferta/importe/moneda/fechaCompra/estado fields
 *
 * ORMLite entity for ticket/voucher purchases ("Mi Boleto" module).
 * Tracks offer details, transaction IDs, expiration, and consumption state.
 */
@DatabaseTable(tableName = "CompraBoleto")
public class TicketPurchase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(unique = true)
    private String token;

    @DatabaseField
    private String idOferta;

    @DatabaseField
    private double importe;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private Date fechaCompra;

    @DatabaseField
    private Date fechaVencimiento;

    @DatabaseField
    private int estado;

    @DatabaseField
    private String datos;

    @DatabaseField
    private String alias;

    /** Carnet de identidad of the purchaser */
    @DatabaseField
    private String ci;

    @DatabaseField
    private int tipoCompra;

    @DatabaseField
    private String idTransaccion;

    @DatabaseField
    private String idTransferencia;

    @DatabaseField
    private boolean consumido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(String idOferta) {
        this.idOferta = idOferta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(int tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }
}
