package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.Business;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.xc7SYjTCzp
 * @original_apk_version 1.260416
 */
public class BusinessListResponse extends BaseApiResult {
    public List<Business> itemsList;

    public List<Business> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(List<Business> itemsList) {
        this.itemsList = itemsList;
    }
}
