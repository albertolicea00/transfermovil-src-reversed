package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.core.enums.Currency;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "MCBank")
public class MobileCardBank implements ITMDataDatabase {

    @DatabaseField
    private BankType agencia;

    @DatabaseField
    private String alias;

    @DatabaseField
    private String cuenta;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String movil_notificar;

    @DatabaseField
    private Currency tipo_moneda;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getTipo_moneda() {
        return this.tipo_moneda;
    }

    public void setTipo_moneda(Currency tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getCuenta() {
        BaseMainActivity baseActivity = new BaseMainActivity();
        return baseActivity.decryption(this.cuenta);
    }

    public void setCuenta(String cuenta) {
        BaseMainActivity baseActivity = new BaseMainActivity();
        this.cuenta = baseActivity.encryption(cuenta);
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public BankType getAgencia() {
        return this.agencia;
    }

    public void setAgencia(BankType agencia) {
        this.agencia = agencia;
    }

    public String getMovil_notificar() {
        return this.movil_notificar;
    }

    public void setMovil_notificar(String movil_notificar) {
        this.movil_notificar = movil_notificar;
    }

    public String toString() {
        BaseMainActivity baseActivity = new BaseMainActivity();
        String textCuenta = baseActivity.decryption(this.cuenta);
        return this.alias.toUpperCase() + " - " + textCuenta.substring(12);
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("MCBank");
        List<FieldSchema> camposList = new ArrayList<>();
        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);
        FieldSchema tipoMoneda = new FieldSchema();
        tipoMoneda.setNombre("tipo_moneda");
        FieldType cqi3wj0jbl = FieldType.DATA;
        tipoMoneda.setTipo(cqi3wj0jbl);
        camposList.add(tipoMoneda);
        FieldSchema cuenta = new FieldSchema();
        cuenta.setNombre("cuenta");
        cuenta.setTipo(FieldType.IDENTITY);
        camposList.add(cuenta);
        FieldSchema alias = new FieldSchema();
        alias.setNombre("alias");
        alias.setTipo(cqi3wj0jbl);
        camposList.add(alias);
        FieldSchema agencia = new FieldSchema();
        agencia.setNombre("agencia");
        agencia.setTipo(cqi3wj0jbl);
        camposList.add(agencia);
        FieldSchema movil = new FieldSchema();
        movil.setNombre("movil_notificar");
        movil.setTipo(cqi3wj0jbl);
        camposList.add(movil);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
