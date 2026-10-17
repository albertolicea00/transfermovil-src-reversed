package cu.etecsa.transfermovil.data;

import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu
 * @fingerprint tabla_name, camposSquemas (List of FieldSchema)
 *
 * Table schema descriptor returned by {@link ITMDataDatabase#getMetadata()}.
 * Carries the table name and an ordered list of field descriptors used by the
 * data import/export framework.
 */
public class TableMetadata {

    public String tabla_name;
    public List<FieldSchema> camposSquemas;

    public String getTabla_name() {
        return this.tabla_name;
    }

    public void setTabla_name(String tabla_name) {
        this.tabla_name = tabla_name;
    }

    public List<FieldSchema> getCamposSquemas() {
        return this.camposSquemas;
    }

    public void setCamposSquemas(List<FieldSchema> camposSquemas) {
        this.camposSquemas = camposSquemas;
    }
}
