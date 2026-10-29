package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;
import cu.etecsa.transfermovil.ecommerce.model.dto.UserProfile;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO
 * @original_apk_version 1.260416
 */
public class ChildUserCreateRequest implements BaseRequest {

    @SerializedName("roles")
    public int[] roles;

    @SerializedName("user")
    public UserProfile user;

    public int[] getRoles() {
        return this.roles;
    }

    public void setRoles(int[] roles) {
        this.roles = roles;
    }

    public UserProfile getUser() {
        return this.user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }
}
