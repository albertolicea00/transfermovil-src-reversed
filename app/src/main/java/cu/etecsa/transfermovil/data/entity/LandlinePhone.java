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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "TelfFijo")
public class LandlinePhone implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

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
        metadata.setTabla_name("TelfFijo");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema number = new FieldSchema();
        number.setNombre("number");
        number.setTipo(FieldType.IDENTITY);
        camposList.add(number);
        FieldSchema idCliente = new FieldSchema();
        idCliente.setNombre("id_client");
        idCliente.setTipo(FieldType.FK);
        idCliente.setTablaForanea("Client");
        idCliente.setCampoForaneo("id");
        camposList.add(idCliente);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
