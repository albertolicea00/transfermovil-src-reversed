package cu.etecsa.transfermovil.ecommerce.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.TzJ2tcDcUWM.YjMcWATWMD
 *
 * User profile DTO for API serialization (used in request and response).
 */
public class UserProfile {
    @SerializedName("address") public String address;
    @SerializedName("dni") public String dni;
    @SerializedName("email") public String email;
    @SerializedName("id") public String id;
    @SerializedName("municipality") public String municipality;
    @SerializedName("phone") public String phone;
    @SerializedName("photo") public String photo;
    @SerializedName("province") public String province;
    @SerializedName("username") public String username;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getMunicipality() { return municipality; }
    public void setMunicipality(String municipality) { this.municipality = municipality; }
}
