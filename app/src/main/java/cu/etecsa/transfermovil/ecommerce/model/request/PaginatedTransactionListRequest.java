package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ
 *
 * Paginated request with filters for transaction listing.
 */
public class PaginatedTransactionListRequest {
    @SerializedName("start") public int start;
    @SerializedName("length") public int length;

    public static class Filters {
        @SerializedName("payment_code") public String payment_code;
    }
}
