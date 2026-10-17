package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.PaymentSource;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy */
public class PaymentSourceListResponse extends BaseApiResult {
    public List<PaymentSource> itemsList;
    public int recordFiltered;
    public int recordTotal;

    public int getRecordTotal() { return recordTotal; }
    public void setRecordTotal(int recordTotal) { this.recordTotal = recordTotal; }
    public int getRecordFiltered() { return recordFiltered; }
    public void setRecordFiltered(int recordFiltered) { this.recordFiltered = recordFiltered; }
    public List<PaymentSource> getItemsList() { return itemsList; }
    public void setItemsList(List<PaymentSource> itemsList) { this.itemsList = itemsList; }
}
