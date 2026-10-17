package cu.etecsa.transfermovil.ecommerce.data.geo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.n8AvCp2wNR
 *
 * Payment code with associated payment and refund lists.
 */
public class PaymentCodeDetail {
    @SerializedName("code") public String code;
    @SerializedName("payment") public List<PaymentDetail> payment;
    @SerializedName("refunds") public List<RefundDetail> refunds;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public List<PaymentDetail> getPayment() { return payment; }
    public void setPayment(List<PaymentDetail> payment) { this.payment = payment; }
    public List<RefundDetail> getRefunds() { return refunds; }
    public void setRefunds(List<RefundDetail> refunds) { this.refunds = refunds; }
}
