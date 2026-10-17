package cu.etecsa.transfermovil.stats;

import cu.etecsa.transfermovil.core.enums.AgentSource;
import java.util.Date;

/**
 * Record of a single financial transaction for display.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.M7OG7jG8CS
 * @fingerprint Model with account, date, transaction ID, currency, amount, service type, and agent source for transaction records
 */
public class TransactionRecord {
    public String cuenta;
    public Date fecha;
    public String idTransaccion;
    public String moneda;
    public String monto;
    public String servicio;
    public AgentSource tipo_servicio;

    public AgentSource getTipo_servicio() {
        return this.tipo_servicio;
    }

    public void setTipo_servicio(AgentSource tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
