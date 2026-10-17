package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.data.geo.Municipality;
import cu.etecsa.transfermovil.ecommerce.data.geo.Province;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OUl0pYQl8g */
public class UserProfileResponse extends BaseApiResult {
    public String address;
    public String dni;
    public String email;
    public int id;
    public Municipality municipality;
    public String phone;
    public String photo;
    public Province province;
    public String updateAt;
    public int[] userRoles;
    public String username;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
