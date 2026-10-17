package cu.etecsa.transfermovil.ecommerce.domain.entity;

import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.q5eErW0HcCa
 *
 * Aggregated sales summary per business account.
 */
public class BusinessSalesSummary {
    public String cantidadTotal;
    public String cantidadUsuarios;
    public String cuenta;
    public int id;
    public String importeTotal;
    public List<SalesDetail> ventas;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCuenta() { return cuenta; }
    public void setCuenta(String cuenta) { this.cuenta = cuenta; }
    public String getCantidadTotal() { return cantidadTotal; }
    public void setCantidadTotal(String cantidadTotal) { this.cantidadTotal = cantidadTotal; }
    public String getImporteTotal() { return importeTotal; }
    public void setImporteTotal(String importeTotal) { this.importeTotal = importeTotal; }
    public String getCantidadUsuarios() { return cantidadUsuarios; }
    public void setCantidadUsuarios(String cantidadUsuarios) { this.cantidadUsuarios = cantidadUsuarios; }
    public List<SalesDetail> getVentas() { return ventas; }
    public void setVentas(List<SalesDetail> ventas) { this.ventas = ventas; }
}
