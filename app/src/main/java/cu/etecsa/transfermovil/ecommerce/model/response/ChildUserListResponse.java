package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.ChildUser;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.L8gvrPUGKT
 * @original_apk_version 1.260416
 */
public class ChildUserListResponse extends BaseApiResult {
    public List<ChildUser> itemsList;

    public List<ChildUser> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(List<ChildUser> itemsList) {
        this.itemsList = itemsList;
    }
}
