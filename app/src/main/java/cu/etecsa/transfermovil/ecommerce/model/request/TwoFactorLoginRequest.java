package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.L9hiDpmAir
 * @original_apk_version 1.260416
 */
public class TwoFactorLoginRequest implements BaseRequest {

    @SerializedName("email")
    public String email;

    @SerializedName("factor")
    public int factor;

    @SerializedName("password")
    public String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFactor() {
        return this.factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
}
