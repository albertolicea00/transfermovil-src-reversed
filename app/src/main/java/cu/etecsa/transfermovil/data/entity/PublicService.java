package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico
 * @fingerprint @DatabaseTable, ITMDataDatabase, valor, tipo_servicio (int), cod_servicio, id_client FK->Client
 *
 * ORMLite entity for public utility services (electricity, water, gas, phone).
 * Each row links a service identifier to a client via foreign key.
 */
@DatabaseTable(tableName = "ServicioPublico")
public class PublicService implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String valor;

    @DatabaseField
    private int tipo_servicio;

    @DatabaseField
    private String cod_servicio;

    @DatabaseField
    private int id_client;

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

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("ServicioPublico");

        List<FieldSchema> camposList = new ArrayList<>();

        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);

        FieldSchema valor = new FieldSchema();
        valor.setNombre("valor");
        valor.setTipo(FieldType.IDENTITY);
        camposList.add(valor);

        FieldSchema tipo_servicio = new FieldSchema();
        tipo_servicio.setNombre("tipo_servicio");
        tipo_servicio.setTipo(FieldType.DATA);
        camposList.add(tipo_servicio);

        FieldSchema cod_servicio = new FieldSchema();
        cod_servicio.setNombre("cod_servicio");
        cod_servicio.setTipo(FieldType.DATA);
        camposList.add(cod_servicio);

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
