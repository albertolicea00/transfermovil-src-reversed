package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.ChildUser;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.L8gvrPUGKT */
public class ChildUserListResponse extends BaseApiResult {
    public List<ChildUser> itemsList;

    public List<ChildUser> getItemsList() { return itemsList; }
    public void setItemsList(List<ChildUser> itemsList) { this.itemsList = itemsList; }
}
