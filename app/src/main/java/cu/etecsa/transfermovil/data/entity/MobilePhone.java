package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.List;
import cu.etecsa.transfermovil.data.ITMDataDatabase;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "TeflMovil")
public class MobilePhone implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int idClient;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private String number;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId_client() {
        return this.id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("TeflMovil");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema number = new FieldSchema();
        number.setNombre("number");
        number.setTipo(FieldType.DATA);
        camposList.add(number);
        FieldSchema idClienteD = new FieldSchema();
        idClienteD.setNombre("id_client");
        idClienteD.setTipo(FieldType.FK);
        idClienteD.setTablaForanea("Client");
        idClienteD.setCampoForaneo("id");
        camposList.add(idClienteD);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
