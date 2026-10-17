package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN
 *
 * Paginated request with filters for payment/refund listing.
 */
public class PaginatedPaymentListRequest {
    @SerializedName("start") public int start;
    @SerializedName("length") public int length;

    public static class Filters {
        @SerializedName("payment_code") public String payment_code;
        @SerializedName("refund_code") public String refund_code;
    }
}
