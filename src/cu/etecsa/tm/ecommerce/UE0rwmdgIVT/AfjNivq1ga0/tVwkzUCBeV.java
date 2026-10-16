package cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0;

import com.google.gson.annotations.SerializedName;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.XpLbwNXtZPa.fGYt3sYXbt;

/* JADX INFO: loaded from: classes.dex */
public class tVwkzUCBeV implements fGYt3sYXbt {

    @SerializedName("filters")
    public FiltersCuadre filters;

    public FiltersCuadre getFilters() {
        return this.filters;
    }

    public void setFilters(FiltersCuadre filters) {
        this.filters = filters;
    }

    public static class FiltersCuadre {

        @SerializedName("create_user")
        public String create_user;

        @SerializedName("enddate")
        public String enddate;

        @SerializedName("source")
        public String[] source;

        @SerializedName("startdate")
        public String startdate;

        public String[] getSource() {
            return this.source;
        }

        public void setSource(String[] source) {
            this.source = source;
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

        public String getCreate_user() {
            return this.create_user;
        }

        public void setCreate_user(String create_user) {
            this.create_user = create_user;
        }
    }
}
