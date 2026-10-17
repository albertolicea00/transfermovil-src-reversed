package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank
 * @fingerprint ITMDataDatabase, encrypted cuenta field, alias/agencia/tipo_moneda/movil_notificar
 *
 * ORMLite entity for mobile card bank accounts. Uses the same AES/ECB
 * encryption scheme as BankAccountCard for the cuenta field.
 *
 * NOTE: The decompiled source may be missing the @DatabaseTable annotation
 * (possible decompiler artifact), but the class is persisted via ORMLite.
 *
 * SECURITY: Same weak AES/ECB encryption as BankAccountCard with
 * hardcoded key "708091521823824654864548452244".
 */
@DatabaseTable(tableName = "MCBank")
public class MobileCardBank implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    /** Bank account number — ENCRYPTED with AES/ECB (weak) */
    @DatabaseField
    private String cuenta;

    @DatabaseField
    private String alias;

    /** Bank type enum (obfuscated: R1sDOSqZ2z) */
    @DatabaseField
    private BankType agencia;

    /** Currency type enum (obfuscated: qTDVwLFEjE) */
    @DatabaseField
    private Currency tipo_moneda;

    @DatabaseField
    private String movil_notificar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /** Returns the account number after AES/ECB decryption. */
    public String getCuenta() {
        // In original: BaseMainActivity.decryption(this.cuenta, cv)
        return cuenta;
    }

    /** Encrypts and stores the account number using AES/ECB. */
    public void setCuenta(String cuenta) {
        // In original: BaseMainActivity.encryption(cuenta, cv)
        this.cuenta = cuenta;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public BankType getAgencia() {
        return agencia;
    }

    public void setAgencia(BankType agencia) {
        this.agencia = agencia;
    }

    public Currency getTipoMoneda() {
        return tipo_moneda;
    }

    public void setTipoMoneda(Currency tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getMovilNotificar() {
        return movil_notificar;
    }

    public void setMovilNotificar(String movil_notificar) {
        this.movil_notificar = movil_notificar;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata("MCBank");
        metadata.setPrimaryKey("id");
        metadata.addDataField("cuenta");
        metadata.addDataField("alias");
        metadata.addDataField("agencia");
        metadata.addDataField("tipo_moneda");
        metadata.addDataField("movil_notificar");
        return metadata;
    }
}
