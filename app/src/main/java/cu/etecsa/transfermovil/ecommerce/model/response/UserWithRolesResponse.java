package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.data.geo.Municipality;
import cu.etecsa.transfermovil.ecommerce.data.geo.Province;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import cu.etecsa.transfermovil.ecommerce.model.dto.UserProfile;
import java.io.Serializable;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS */
public class UserWithRolesResponse extends BaseApiResult {
    public UserProfile user;
    public int[] userRoles;

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
    public int[] getUserRoles() { return userRoles; }
    public void setUserRoles(int[] userRoles) { this.userRoles = userRoles; }
}
