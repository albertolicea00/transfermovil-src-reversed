package cu.etecsa.transfermovil.ecommerce.domain.entity;

import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.q5eErW0HcCa
 * @original_apk_version 1.260416
 */
public class BusinessSalesSummary {
    public String cantidadTotal;
    public String cantidadUsuarios;
    public String cuenta;
    public int id;
    public String importeTotal;
    public List<SalesDetail> ventas;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCantidadTotal() {
        return this.cantidadTotal;
    }

    public void setCantidadTotal(String cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getImporteTotal() {
        return this.importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    public List<SalesDetail> getVentas() {
        return this.ventas;
    }

    public void setVentas(List<SalesDetail> ventas) {
        this.ventas = ventas;
    }

    public String getCantidadUsuarios() {
        return this.cantidadUsuarios;
    }

    public void setCantidadUsuarios(String cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }
}
