package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy
 * @original_apk_version 1.260416
 */
public class UserGrantsRequest implements BaseRequest {

    @SerializedName("grants")
    public int[] grants;

    @SerializedName("user_id")
    public int user_id;

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int[] getGrants() {
        return this.grants;
    }

    public void setGrants(int[] grants) {
        this.grants = grants;
    }
}
