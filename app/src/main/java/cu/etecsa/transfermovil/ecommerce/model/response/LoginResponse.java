package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.Permission;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.gC3MfWqxUy */
public class LoginResponse extends BaseApiResult {
    public int idUser;
    public List<Permission> itemPermisos;
    public String token;
    public String userName;

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public List<Permission> getItemPermisos() { return itemPermisos; }
    public void setItemPermisos(List<Permission> itemPermisos) { this.itemPermisos = itemPermisos; }
}
