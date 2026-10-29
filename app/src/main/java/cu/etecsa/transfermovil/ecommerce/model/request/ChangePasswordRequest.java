package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.K1a8LCEmAD
 * @original_apk_version 1.260416
 */
public class ChangePasswordRequest implements BaseRequest {

    @SerializedName("newpassword")
    public String newpassword;

    @SerializedName("oldpassword")
    public String oldpassword;

    @SerializedName("renewpassword")
    public String renewpassword;

    public String getOldpassword() {
        return this.oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return this.newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getRenewpassword() {
        return this.renewpassword;
    }

    public void setRenewpassword(String renewpassword) {
        this.renewpassword = renewpassword;
    }
}
