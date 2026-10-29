package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.transfermovil.ecommerce.model.BaseRequest;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.hJ45hA3s7Q
 * @original_apk_version 1.260416
 */
public class BusinessUpdateRequest implements BaseRequest {

    @SerializedName("descriptionBusiness")
    public String descriptionBusiness;

    @SerializedName("id")
    public String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptionBusiness() {
        return this.descriptionBusiness;
    }

    public void setDescriptionBusiness(String descriptionBusiness) {
        this.descriptionBusiness = descriptionBusiness;
    }
}
