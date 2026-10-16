package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class Factura implements ITMDataDatabase {

    @DatabaseField
    private String cod_factura;

    @DatabaseField
    private String factura;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private int tipo_factura;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura() {
        return this.factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getTipo_Factura() {
        return this.tipo_factura;
    }

    public void setTipo_Factura(int tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getCodFactura() {
        return this.cod_factura;
    }

    public void setCodFactura(String cod_factura) {
        this.cod_factura = cod_factura;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("Factura");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 factura = new z9CJ2fIAs7();
        factura.setNombre("factura");
        factura.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(factura);
        z9CJ2fIAs7 tipo_factura = new z9CJ2fIAs7();
        tipo_factura.setNombre("tipo_factura");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        tipo_factura.setTipo(cqi3wj0jbl);
        camposList.add(tipo_factura);
        z9CJ2fIAs7 idCliente = new z9CJ2fIAs7();
        idCliente.setNombre("id_client");
        idCliente.setTipo(cQi3wj0jBL.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        z9CJ2fIAs7 cod_factura = new z9CJ2fIAs7();
        cod_factura.setNombre("cod_factura");
        cod_factura.setTipo(cqi3wj0jbl);
        camposList.add(cod_factura);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
