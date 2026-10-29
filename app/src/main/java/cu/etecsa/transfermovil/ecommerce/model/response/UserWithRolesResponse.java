package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.data.geo.Municipality;
import cu.etecsa.transfermovil.ecommerce.data.geo.Province;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.io.Serializable;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS
 * @original_apk_version 1.260416
 */
public class UserWithRolesResponse extends BaseApiResult {
    public User user;
    public int[] userRoles;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int[] getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(int[] userRoles) {
        this.userRoles = userRoles;
    }

    public static class User implements Serializable {
        public String address;
        public String dni;
        public String email;
        public int id;
        public Municipality municipality;
        public String phone;
        public String photo;
        public Province province;
        public String updateAt;
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

        public String getPhoto() {
            return this.photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
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

        public String getUpdateAt() {
            return this.updateAt;
        }

        public void setUpdateAt(String updateAt) {
            this.updateAt = updateAt;
        }
    }
}
