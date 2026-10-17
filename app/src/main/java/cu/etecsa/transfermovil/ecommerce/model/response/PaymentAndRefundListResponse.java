package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.RefundRecord;
import cu.etecsa.transfermovil.ecommerce.domain.entity.TransactionRecord;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ALtYP1fGkI */
public class PaymentAndRefundListResponse extends BaseApiResult {
    public List<RefundRecord> devList;
    public List<TransactionRecord> pagoList;

    public List<TransactionRecord> getPagoList() { return pagoList; }
    public void setPagoList(List<TransactionRecord> pagoList) { this.pagoList = pagoList; }
    public List<RefundRecord> getDevList() { return devList; }
    public void setDevList(List<RefundRecord> devList) { this.devList = devList; }
}
