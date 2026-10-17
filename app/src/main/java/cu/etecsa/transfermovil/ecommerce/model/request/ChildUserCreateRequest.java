package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.dto.UserProfile;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO
 */
public class ChildUserCreateRequest {
    @SerializedName("user") public UserProfile user;
    @SerializedName("roles") public int[] roles;
}
