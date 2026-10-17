package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket
 * @fingerprint @DatabaseTable, ITMDataDatabase, data, idbank, idtm, importe float, consumido, deleted, serie
 *
 * ORMLite entity for transport/commerce tickets. Tracks ticket state
 * (consumed, deleted), bank/TM identifiers, and monetary value.
 *
 * NOTE: Has duplicate getter/setter pairs for idbank (getIdBank/getIdbank)
 * and idtm (getIdTM/getIdtm) -- decompiler artifact from accessor variants.
 */
@DatabaseTable(tableName = "TCTicket")
public class TransportTicket implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String data;

    @DatabaseField
    private String idbank;

    @DatabaseField
    private String idtm;

    @DatabaseField
    private float importe;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private Date fecha;

    @DatabaseField
    private boolean consumido;

    @DatabaseField
    private String alias;

    @DatabaseField
    private String serie;

    @DatabaseField
    private boolean deleted;

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

    /** CamelCase accessor variant. */
    public String getIdBank() {
        return this.idbank;
    }

    /** CamelCase accessor variant. */
    public void setIdBank(String idBank) {
        this.idbank = idBank;
    }

    /** CamelCase accessor variant. */
    public String getIdTM() {
        return this.idtm;
    }

    /** CamelCase accessor variant. */
    public void setIdTM(String idtm) {
        this.idtm = idtm;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /** Duplicate lowercase accessor -- decompiler artifact. */
    public String getIdbank() {
        return this.idbank;
    }

    /** Duplicate lowercase accessor -- decompiler artifact. */
    public void setIdbank(String idbank) {
        this.idbank = idbank;
    }

    /** Duplicate lowercase accessor -- decompiler artifact. */
    public String getIdtm() {
        return this.idtm;
    }

    /** Duplicate lowercase accessor -- decompiler artifact. */
    public void setIdtm(String idtm) {
        this.idtm = idtm;
    }

    @Override
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
        data.setTipo(FieldType.DATA);
        camposList.add(data);

        FieldSchema serie = new FieldSchema();
        serie.setNombre("serie");
        serie.setTipo(FieldType.DATA);
        camposList.add(serie);

        FieldSchema alias = new FieldSchema();
        alias.setNombre("alias");
        alias.setTipo(FieldType.DATA);
        camposList.add(alias);

        FieldSchema idBank = new FieldSchema();
        idBank.setNombre("idbank");
        idBank.setTipo(FieldType.DATA);
        camposList.add(idBank);

        // NOTE: Original decompiled source uses "idtM" (capital M) here
        FieldSchema idTM = new FieldSchema();
        idTM.setNombre("idtM");
        idTM.setTipo(FieldType.DATA);
        camposList.add(idTM);

        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(FieldType.DATA);
        camposList.add(moneda);

        FieldSchema importe = new FieldSchema();
        importe.setNombre("importe");
        importe.setTipo(FieldType.DATA);
        camposList.add(importe);

        FieldSchema fecha = new FieldSchema();
        fecha.setNombre("fecha");
        fecha.setTipo(FieldType.DATA);
        camposList.add(fecha);

        FieldSchema consumido = new FieldSchema();
        consumido.setNombre("consumido");
        consumido.setTipo(FieldType.DATA);
        camposList.add(consumido);

        FieldSchema deleted = new FieldSchema();
        deleted.setNombre("deleted");
        deleted.setTipo(FieldType.DATA);
        camposList.add(deleted);

        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
