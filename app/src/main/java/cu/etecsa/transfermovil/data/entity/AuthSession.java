package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.core.enums.OperationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "AOperKey")
public class AuthSession implements ITMDataDatabase {

    @DatabaseField
    public Date authDate;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    public boolean isAuth;

    @DatabaseField
    public OperationType operacion;

    @DatabaseField
    public String pin;

    public OperationType getOperacion() {
        return this.operacion;
    }

    public void setOperacion(OperationType operacion) {
        this.operacion = operacion;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isAuth() {
        return this.isAuth;
    }

    public void setAuth(boolean auth) {
        this.isAuth = auth;
    }

    public Date getAuthDate() {
        return this.authDate;
    }

    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("AOperKey");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema data = new FieldSchema();
        data.setNombre("operacion");
        FieldType cqi3wj0jbl = FieldType.DATA;
        data.setTipo(cqi3wj0jbl);
        camposList.add(data);
        FieldSchema pin = new FieldSchema();
        pin.setNombre("pin");
        pin.setTipo(cqi3wj0jbl);
        camposList.add(pin);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
