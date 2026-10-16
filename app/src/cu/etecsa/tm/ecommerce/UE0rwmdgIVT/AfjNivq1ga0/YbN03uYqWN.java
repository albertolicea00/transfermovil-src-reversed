package cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0;

import com.github.paolorotolo.appintro.BuildConfig;
import com.google.gson.annotations.SerializedName;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.XpLbwNXtZPa.fGYt3sYXbt;

/* JADX INFO: loaded from: classes.dex */
public class YbN03uYqWN implements fGYt3sYXbt {

    @SerializedName("filters")
    public Filters filters;

    @SerializedName("startRow")
    public int startRow = 0;

    @SerializedName("sortBy")
    public String sortBy = "created_at";

    @SerializedName("descending")
    public boolean descending = true;

    @SerializedName("page")
    public int page = 1;

    @SerializedName("rowsPerPage")
    public int rowsPerPage = 8;

    @SerializedName("rowsNumber")
    public int rowsNumber = 8;

    public YbN03uYqWN() {
        Filters filters = new Filters();
        filters.currency = new String[0];
        filters.banck_code = BuildConfig.FLAVOR;
        filters.startdate = BuildConfig.FLAVOR;
        filters.enddate = BuildConfig.FLAVOR;
        filters.external_code = BuildConfig.FLAVOR;
        filters.payment_code = BuildConfig.FLAVOR;
        filters.source = new String[0];
        filters.status = new String[0];
        filters.tm_code = BuildConfig.FLAVOR;
        filters.refund_code = BuildConfig.FLAVOR;
        filters.reference_refund = BuildConfig.FLAVOR;
        filters.tm_reference_refund = BuildConfig.FLAVOR;
        filters.create_user = BuildConfig.FLAVOR;
        this.filters = filters;
    }

    public int getStartRow() {
        return this.startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isDescending() {
        return this.descending;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRowsPerPage() {
        return this.rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getRowsNumber() {
        return this.rowsNumber;
    }

    public void setRowsNumber(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public Filters getFilters() {
        return this.filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public class Filters {

        @SerializedName("banck_code")
        public String banck_code;

        @SerializedName("create_user")
        public String create_user;

        @SerializedName("currency")
        public String[] currency;

        @SerializedName("enddate")
        public String enddate;

        @SerializedName("external_code")
        public String external_code;

        @SerializedName("payment_code")
        public String payment_code;

        @SerializedName("reference_refund")
        public String reference_refund;

        @SerializedName("refund_code")
        public String refund_code;

        @SerializedName("source")
        public String[] source;

        @SerializedName("startdate")
        public String startdate;

        @SerializedName("status")
        public String[] status;

        @SerializedName("tm_code")
        public String tm_code;

        @SerializedName("tm_reference_refund")
        public String tm_reference_refund;

        public Filters() {
        }

        public String[] getSource() {
            return this.source;
        }

        public void setSource(String[] source) {
            this.source = source;
        }

        public String[] getStatus() {
            return this.status;
        }

        public void setStatus(String[] status) {
            this.status = status;
        }

        public String getStartdate() {
            return this.startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public String getEnddate() {
            return this.enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getPayment_code() {
            return this.payment_code;
        }

        public void setPayment_code(String payment_code) {
            this.payment_code = payment_code;
        }

        public String getExternal_code() {
            return this.external_code;
        }

        public void setExternal_code(String external_code) {
            this.external_code = external_code;
        }

        public String getBanck_code() {
            return this.banck_code;
        }

        public void setBanck_code(String banck_code) {
            this.banck_code = banck_code;
        }

        public String getTm_code() {
            return this.tm_code;
        }

        public void setTm_code(String tm_code) {
            this.tm_code = tm_code;
        }

        public String getRefund_code() {
            return this.refund_code;
        }

        public void setRefund_code(String refund_code) {
            this.refund_code = refund_code;
        }

        public String getReference_refund() {
            return this.reference_refund;
        }

        public void setReference_refund(String reference_refund) {
            this.reference_refund = reference_refund;
        }

        public String getTm_reference_refund() {
            return this.tm_reference_refund;
        }

        public void setTm_reference_refund(String tm_reference_refund) {
            this.tm_reference_refund = tm_reference_refund;
        }

        public String getCreate_user() {
            return this.create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }

        public String[] getCurrency() {
            return this.currency;
        }

        public void setCurrency(String[] currency) {
            this.currency = currency;
        }
    }
}
