package cu.etecsa.transfermovil.stats;

/**
 * Summary item for a service type showing aggregated stats.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.qcI22KekhL
 * @fingerprint Model with operation count, currency, total amount, and service name for summary display
 */
public class ServiceSummaryItem {
    public String cantidad;
    public String moneda;
    public String monto;
    public String servicio;

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
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

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
