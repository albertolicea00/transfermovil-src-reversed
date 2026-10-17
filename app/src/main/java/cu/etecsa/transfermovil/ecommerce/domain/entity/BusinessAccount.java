package cu.etecsa.transfermovil.ecommerce.domain.entity;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB
 *
 * Payment source/account linked to a business.
 */
public class BusinessAccount {
    public boolean activo;
    public String descripcion;
    public String fechaCreacion;
    public int id;
    public int idNegocio;
    public String moneda;
    public String source;
    public String tituloNegocio;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public int getIdNegocio() { return idNegocio; }
    public void setIdNegocio(int idNegocio) { this.idNegocio = idNegocio; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public String getTituloNegocio() { return tituloNegocio; }
    public void setTituloNegocio(String tituloNegocio) { this.tituloNegocio = tituloNegocio; }
}
