package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class CompraBoleto {

    @DatabaseField(columnName = "alias")
    private String alias;

    @DatabaseField(columnName = "ci_beneficiario")
    private String ci;

    @DatabaseField(columnName = "consumido")
    private boolean consumido;

    @DatabaseField
    private String datos;

    @DatabaseField
    private boolean deleted;

    @DatabaseField
    private String estado;

    @DatabaseField(columnName = "fecha_actualizacion")
    private Date fechaActualizacion;

    @DatabaseField(canBeNull = false, columnName = "fecha_compra")
    private Date fechaCompra;

    @DatabaseField(columnName = "fecha_inicial")
    private Date fechaInicial;

    @DatabaseField(columnName = "fecha_vencimiento")
    private Date fechaVencimiento;

    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, columnName = "id_oferta")
    private String idOferta;

    @DatabaseField(columnName = "id_transaccion")
    private String idTransaccion;

    @DatabaseField(columnName = "id_transferencia")
    private String idTransferencia;

    @DatabaseField(canBeNull = false)
    private double importe;

    @DatabaseField(canBeNull = false)
    private String moneda;

    @DatabaseField(columnName = "tipo_compra")
    private String tipoCompra;

    @DatabaseField(canBeNull = false, unique = true)
    private String token;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCompra() {
        return this.tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getCi() {
        return this.ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getIdOferta() {
        return this.idOferta;
    }

    public void setIdOferta(String idOferta) {
        if (idOferta == null || idOferta.isEmpty()) {
            throw new IllegalArgumentException("El ID de la oferta no puede ser nulo o vacío");
        }
        this.idOferta = idOferta;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacío");
        }
        this.token = token;
    }

    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdTransferencia() {
        return this.idTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getPrecio() {
        return this.importe;
    }

    public void setPrecio(double precio) {
        if (precio < 0.0d) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.importe = precio;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        if (moneda == null || moneda.isEmpty()) {
            throw new IllegalArgumentException("La moneda no puede ser nula o vacía");
        }
        this.moneda = moneda;
    }

    public Date getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDatos() {
        return this.datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public boolean isConsumido() {
        return this.consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }
}
