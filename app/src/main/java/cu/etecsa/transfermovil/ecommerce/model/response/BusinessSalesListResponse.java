package cu.etecsa.transfermovil.ecommerce.model.response;

import cu.etecsa.transfermovil.ecommerce.domain.entity.BusinessSalesSummary;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import java.util.List;

/** @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.luC26d6Wdp */
public class BusinessSalesListResponse extends BaseApiResult {
    public List<BusinessSalesSummary> listNegocios;

    public List<BusinessSalesSummary> getListNegocios() { return listNegocios; }
    public void setListNegocios(List<BusinessSalesSummary> listNegocios) { this.listNegocios = listNegocios; }
}
