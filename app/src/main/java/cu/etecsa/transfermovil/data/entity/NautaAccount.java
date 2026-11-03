package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Nauta")
public class NautaAccount implements ITMDataDatabase {

    @DatabaseField
    private String cuenta;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int id_client;

    @DatabaseField
    private int tipo_cuenta;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipo_cuenta() {
        return this.tipo_cuenta;
    }

    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
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
        metadata.setTabla_name("Nauta");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema tipo_cuenta = new FieldSchema();
        tipo_cuenta.setNombre("tipo_cuenta");
        tipo_cuenta.setTipo(FieldType.DATA);
        camposList.add(tipo_cuenta);
        FieldSchema cuenta = new FieldSchema();
        cuenta.setNombre("cuenta");
        cuenta.setTipo(FieldType.IDENTITY);
        camposList.add(cuenta);
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
