package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.BusinessSalesSummary;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.luC26d6Wdp
 * @original_apk_version 1.260416
 */
public class BusinessSalesListResponse extends BaseApiResult {
    public List<BusinessSalesSummary> listNegocios;

    public List<BusinessSalesSummary> getListNegocios() {
        return this.listNegocios;
    }

    public void setListNegocios(List<BusinessSalesSummary> listNegocios) {
        this.listNegocios = listNegocios;
    }
}
