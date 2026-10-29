package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.L9hiDpmAir
 */
public class TwoFactorLoginRequest implements BaseRequest {
    @SerializedName("email") public String email;
    @SerializedName("password") public String password;
    @SerializedName("factor") public int factor;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getFactor() { return factor; }
    public void setFactor(int factor) { this.factor = factor; }
}
