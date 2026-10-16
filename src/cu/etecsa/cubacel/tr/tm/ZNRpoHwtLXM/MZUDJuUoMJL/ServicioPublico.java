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
public class ServicioPublico implements ITMDataDatabase {

    @DatabaseField
    private String cod_servicio;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private int tipo_servicio;

    @DatabaseField
    private String valor;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getTipo_servicio() {
        return this.tipo_servicio;
    }

    public void setTipo_servicio(int tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getCod_servicio() {
        return this.cod_servicio;
    }

    public void setCod_servicio(String cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("ServicioPublico");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 valor = new z9CJ2fIAs7();
        valor.setNombre("valor");
        valor.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(valor);
        z9CJ2fIAs7 tipo_servicio = new z9CJ2fIAs7();
        tipo_servicio.setNombre("tipo_servicio");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        tipo_servicio.setTipo(cqi3wj0jbl);
        camposList.add(tipo_servicio);
        z9CJ2fIAs7 cod_servicio = new z9CJ2fIAs7();
        cod_servicio.setNombre("cod_servicio");
        cod_servicio.setTipo(cqi3wj0jbl);
        camposList.add(cod_servicio);
        z9CJ2fIAs7 idCliente = new z9CJ2fIAs7();
        idCliente.setNombre("id_client");
        idCliente.setTipo(cQi3wj0jBL.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
