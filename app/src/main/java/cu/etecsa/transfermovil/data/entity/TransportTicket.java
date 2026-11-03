package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "TCTicket")
public class TransportTicket implements ITMDataDatabase {

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
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("TCTicket");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema data = new FieldSchema();
        data.setNombre("data");
        FieldType cqi3wj0jbl = FieldType.DATA;
        data.setTipo(cqi3wj0jbl);
        camposList.add(data);
        FieldSchema serie = new FieldSchema();
        serie.setNombre("serie");
        serie.setTipo(cqi3wj0jbl);
        camposList.add(serie);
        FieldSchema alias = new FieldSchema();
        alias.setNombre("alias");
        alias.setTipo(cqi3wj0jbl);
        camposList.add(alias);
        FieldSchema idBank = new FieldSchema();
        idBank.setNombre("idbank");
        idBank.setTipo(cqi3wj0jbl);
        camposList.add(idBank);
        FieldSchema idTM = new FieldSchema();
        idTM.setNombre("idtM");
        idTM.setTipo(cqi3wj0jbl);
        camposList.add(idTM);
        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        FieldSchema importe = new FieldSchema();
        importe.setNombre("importe");
        importe.setTipo(cqi3wj0jbl);
        camposList.add(importe);
        FieldSchema fecha = new FieldSchema();
        fecha.setNombre("fecha");
        fecha.setTipo(cqi3wj0jbl);
        camposList.add(fecha);
        FieldSchema consumido = new FieldSchema();
        consumido.setNombre("consumido");
        consumido.setTipo(cqi3wj0jbl);
        camposList.add(consumido);
        FieldSchema deleted = new FieldSchema();
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
