package cu.etecsa.transfermovil.data.model;

/**
 * Company/ministry reference entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Empresa
 * @fingerprint code, empresa, ministerio fields; company-ministry mapping
 */
public class Company {

    private String code;
    private String empresa;
    private String ministerio;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(String ministerio) {
        this.ministerio = ministerio;
    }
}
