package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class TarjetaPropia implements ITMDataDatabase {

    @DatabaseField
    private String descripcion;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private String serie;

    @DatabaseField
    private qTDVwLFEjE tipo_moneda;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public qTDVwLFEjE getTipo_moneda() {
        return this.tipo_moneda;
    }

    public void setTipo_moneda(qTDVwLFEjE tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("TarjetaPropia");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 idCliente = new z9CJ2fIAs7();
        idCliente.setNombre("id_client");
        idCliente.setTipo(cQi3wj0jBL.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        z9CJ2fIAs7 tipoMoneda = new z9CJ2fIAs7();
        tipoMoneda.setNombre("tipo_moneda");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        tipoMoneda.setTipo(cqi3wj0jbl);
        camposList.add(tipoMoneda);
        z9CJ2fIAs7 serie = new z9CJ2fIAs7();
        serie.setNombre("serie");
        serie.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(serie);
        z9CJ2fIAs7 descripcion = new z9CJ2fIAs7();
        descripcion.setNombre("descripcion");
        descripcion.setTipo(cqi3wj0jbl);
        camposList.add(descripcion);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
