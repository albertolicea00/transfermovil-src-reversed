package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class TCTicket implements ITMDataDatabase {

    @DatabaseField
    private String alias;

    @DatabaseField
    private boolean consumido;

    @DatabaseField
    private String data;

    @DatabaseField
    private boolean deleted;

    @DatabaseField
    private Date fecha;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String idbank;

    @DatabaseField
    private String idtm;

    @DatabaseField
    private float importe;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private String serie;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdBank() {
        return this.idbank;
    }

    public void setIdBank(String idBank) {
        this.idbank = idBank;
    }

    public String getIdTM() {
        return this.idtm;
    }

    public void setIdTM(String idtm) {
        this.idtm = idtm;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isConsumido() {
        return this.consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("TCTicket");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 data = new z9CJ2fIAs7();
        data.setNombre("data");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        data.setTipo(cqi3wj0jbl);
        camposList.add(data);
        z9CJ2fIAs7 serie = new z9CJ2fIAs7();
        serie.setNombre("serie");
        serie.setTipo(cqi3wj0jbl);
        camposList.add(serie);
        z9CJ2fIAs7 alias = new z9CJ2fIAs7();
        alias.setNombre("alias");
        alias.setTipo(cqi3wj0jbl);
        camposList.add(alias);
        z9CJ2fIAs7 idBank = new z9CJ2fIAs7();
        idBank.setNombre("idbank");
        idBank.setTipo(cqi3wj0jbl);
        camposList.add(idBank);
        z9CJ2fIAs7 idTM = new z9CJ2fIAs7();
        idTM.setNombre("idtM");
        idTM.setTipo(cqi3wj0jbl);
        camposList.add(idTM);
        z9CJ2fIAs7 moneda = new z9CJ2fIAs7();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        z9CJ2fIAs7 importe = new z9CJ2fIAs7();
        importe.setNombre("importe");
        importe.setTipo(cqi3wj0jbl);
        camposList.add(importe);
        z9CJ2fIAs7 fecha = new z9CJ2fIAs7();
        fecha.setNombre("fecha");
        fecha.setTipo(cqi3wj0jbl);
        camposList.add(fecha);
        z9CJ2fIAs7 consumido = new z9CJ2fIAs7();
        consumido.setNombre("consumido");
        consumido.setTipo(cqi3wj0jbl);
        camposList.add(consumido);
        z9CJ2fIAs7 deleted = new z9CJ2fIAs7();
        deleted.setNombre("deleted");
        deleted.setTipo(cqi3wj0jbl);
        camposList.add(deleted);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }

    public String getIdbank() {
        return this.idbank;
    }

    public void setIdbank(String idbank) {
        this.idbank = idbank;
    }

    public String getIdtm() {
        return this.idtm;
    }

    public void setIdtm(String idtm) {
        this.idtm = idtm;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
