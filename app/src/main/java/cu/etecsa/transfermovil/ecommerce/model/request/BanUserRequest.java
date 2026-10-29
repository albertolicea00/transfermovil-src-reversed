package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p
 * @original_apk_version 1.260416
 */
public class BanUserRequest implements BaseRequest {

    @SerializedName("banned")
    public String banned;

    @SerializedName("id")
    public int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanned() {
        return this.banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }
}
