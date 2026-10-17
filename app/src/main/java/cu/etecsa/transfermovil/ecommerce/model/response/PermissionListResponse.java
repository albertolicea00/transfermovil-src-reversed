package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.Permission;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T */
public class PermissionListResponse extends BaseApiResult {
    public List<Permission> listPermisos;

    public List<Permission> getListPermisos() { return listPermisos; }
    public void setListPermisos(List<Permission> listPermisos) { this.listPermisos = listPermisos; }
}
