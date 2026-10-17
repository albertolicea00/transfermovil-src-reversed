package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco
 * @fingerprint @DatabaseTable, ITMDataDatabase, encrypted cuenta field, tipo_moneda/id_client/descripcion
 *
 * ORMLite entity for bank account cards. The cuenta (account number) field
 * is the ONLY encrypted field in the entire app, using AES/ECB with the
 * hardcoded key cv="708091521823824654864548452244" via
 * BaseMainActivity.encryption/decryption.
 *
 * SECURITY: ECB mode provides no semantic security — identical plaintext
 * blocks produce identical ciphertext blocks. The key is hardcoded and
 * shared across all installations.
 */
@DatabaseTable(tableName = "CuentaBanco")
public class BankAccountCard implements ITMDataDatabase {

    /** Hardcoded AES key used for cuenta encryption/decryption */
    private static final String ENCRYPTION_KEY = "708091521823824654864548452244";

    @DatabaseField(generatedId = true)
    private int id;

    /** Bank account number — ENCRYPTED with AES/ECB (weak) */
    @DatabaseField
    private String cuenta;

    /** Currency type enum (obfuscated: qTDVwLFEjE) */
    @DatabaseField
    private Currency tipo_moneda;

    /** Foreign key to Client table */
    @DatabaseField
    private int id_client;

    @DatabaseField
    private String descripcion;

    @DatabaseField
    private String movil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /** Returns the account number after AES/ECB decryption. */
    public String getCuenta() {
        // In original: BaseMainActivity.decryption(this.cuenta, cv)
        // Decrypts using AES/ECB with hardcoded key
        return cuenta;
    }

    /** Encrypts and stores the account number using AES/ECB. */
    public void setCuenta(String cuenta) {
        // In original: BaseMainActivity.encryption(cuenta, cv)
        // Encrypts using AES/ECB with hardcoded key
        this.cuenta = cuenta;
    }

    /** Returns the raw stored value, bypassing decryption. */
    public String getCuentaOld() {
        return cuenta;
    }

    /** Sets the raw value directly, bypassing encryption. */
    public void setCuentaOld(String cuenta) {
        this.cuenta = cuenta;
    }

    public Currency getTipoMoneda() {
        return tipo_moneda;
    }

    public void setTipoMoneda(Currency tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public int getIdClient() {
        return id_client;
    }

    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata("CuentaBanco");
        metadata.setPrimaryKey("id");
        metadata.addDataField("cuenta");
        metadata.addDataField("tipo_moneda");
        metadata.addDataField("id_client");
        metadata.addDataField("descripcion");
        metadata.addDataField("movil");
        return metadata;
    }
}
