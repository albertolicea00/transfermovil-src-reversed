package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb
 */
public class UserProfileRequest {
    @SerializedName("username") public String username;
    @SerializedName("email") public String email;
    @SerializedName("phone") public String phone;
    @SerializedName("dni") public String dni;
    @SerializedName("address") public String address;
    @SerializedName("province") public String province;
    @SerializedName("municipality") public String municipality;
    @SerializedName("photo") public String photo;
    @SerializedName("roles") public int[] roles;
}
