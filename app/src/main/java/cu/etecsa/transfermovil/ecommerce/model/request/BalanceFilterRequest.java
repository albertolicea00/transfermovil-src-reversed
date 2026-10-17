package cu.etecsa.transfermovil.ecommerce.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV
 *
 * Balance/settlement filter with source, date range, and creating user.
 */
public class BalanceFilterRequest {
    public static class FiltersCuadre {
        @SerializedName("source") public String source;
        @SerializedName("start_date") public String start_date;
        @SerializedName("end_date") public String end_date;
        @SerializedName("create_user") public String create_user;
    }
}
