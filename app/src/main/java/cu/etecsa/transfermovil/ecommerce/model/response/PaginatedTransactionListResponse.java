package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.TransactionRecord;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.j670rPXODo
 * @original_apk_version 1.260416
 */
public class PaginatedTransactionListResponse extends BaseApiResult {
    public List<TransactionRecord> itemsList;
    public int recordFiltered;
    public int recordTotal;

    public List<TransactionRecord> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(List<TransactionRecord> itemsList) {
        this.itemsList = itemsList;
    }

    public int getRecordTotal() {
        return this.recordTotal;
    }

    public void setRecordTotal(int recordTotal) {
        this.recordTotal = recordTotal;
    }

    public int getRecordFiltered() {
        return this.recordFiltered;
    }

    public void setRecordFiltered(int recordFiltered) {
        this.recordFiltered = recordFiltered;
    }
}
