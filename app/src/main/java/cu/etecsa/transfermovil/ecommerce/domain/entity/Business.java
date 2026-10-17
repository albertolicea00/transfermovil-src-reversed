package cu.etecsa.transfermovil.ecommerce.domain.entity;

import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.v7emp5gRyD
 *
 * A business (negocio) with its linked payment accounts.
 */
public class Business {
    public String id;
    public String titulo;
    public List<BusinessAccount> cuentasList;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public List<BusinessAccount> getCuentasList() { return cuentasList; }
    public void setCuentasList(List<BusinessAccount> cuentasList) { this.cuentasList = cuentasList; }
}
