package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.data.geo.Municipality;
import cu.etecsa.transfermovil.ecommerce.data.geo.Province;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OUl0pYQl8g
 * @original_apk_version 1.260416
 */
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Municipality getMunicipality() {
        return this.municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int[] getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(int[] userRoles) {
        this.userRoles = userRoles;
    }
}
