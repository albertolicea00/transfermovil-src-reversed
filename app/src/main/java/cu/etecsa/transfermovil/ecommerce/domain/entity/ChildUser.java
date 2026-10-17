package cu.etecsa.transfermovil.ecommerce.domain.entity;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.JpFlOZXEDx
 *
 * Summary info for a child/sub-user managed by the account owner.
 */
public class ChildUser {
    public boolean activo;
    public String avatar;
    public String correo;
    public String creado;
    public int idUser;
    public String nombre;
    public String updateAt;

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public String getCreado() { return creado; }
    public void setCreado(String creado) { this.creado = creado; }
    public String getUpdateAt() { return updateAt; }
    public void setUpdateAt(String updateAt) { this.updateAt = updateAt; }
}
