package cu.etecsa.transfermovil.ecommerce.domain.entity;

import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.v7emp5gRyD
 * @original_apk_version 1.260416
 */
public class Business {
    public List<BusinessAccount> cuentasList;
    public String id;
    public String titulo;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<BusinessAccount> getCuentasList() {
        return this.cuentasList;
    }

    public void setCuentasList(List<BusinessAccount> cuentasList) {
        this.cuentasList = cuentasList;
    }
}
