package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.RefundRecord;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg */
public class PaginatedRefundListResponse extends BaseApiResult {
    private List<RefundRecord> itemsList = new ArrayList<>();
    public int recordFiltered;
    public int recordTotal;

    public int getRecordTotal() { return recordTotal; }
    public void setRecordTotal(int recordTotal) { this.recordTotal = recordTotal; }
    public int getRecordFiltered() { return recordFiltered; }
    public void setRecordFiltered(int recordFiltered) { this.recordFiltered = recordFiltered; }
    public List<RefundRecord> getItemsList() { return itemsList; }
    public void setItemsList(List<RefundRecord> itemsList) { this.itemsList = itemsList; }
}
