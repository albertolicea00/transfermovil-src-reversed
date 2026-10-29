package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.Permission;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.gC3MfWqxUy
 * @original_apk_version 1.260416
 */
public class LoginResponse extends BaseApiResult {
    public int idUser;
    public List<Permission> itemPermisos;
    public String token;
    public String userName;

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Permission> getItemPermisos() {
        return this.itemPermisos;
    }

    public void setItemPermisos(List<Permission> itemPermisos) {
        this.itemPermisos = itemPermisos;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
