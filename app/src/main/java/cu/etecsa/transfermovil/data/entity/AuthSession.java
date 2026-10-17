package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey
 * @fingerprint @DatabaseTable, isAuth/authDate/pin/operacion fields, 30-min auth window
 *
 * Tracks per-operation banking authentication state.
 * Each row records whether a specific operation type has been
 * authenticated and when, enforcing a 30-minute validity window.
 *
 * SECURITY: PIN stored as plaintext string.
 */
@DatabaseTable(tableName = "AOperKey")
public class AuthSession {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private boolean isAuth;

    @DatabaseField
    private Date authDate;

    /** Banking PIN — STORED IN PLAINTEXT */
    @DatabaseField
    private String pin;

    /** Operation type enum (obfuscated: Nl0yptXmjQ) */
    @DatabaseField
    private OperationType operacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        this.isAuth = auth;
    }

    public Date getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public OperationType getOperacion() {
        return operacion;
    }

    public void setOperacion(OperationType operacion) {
        this.operacion = operacion;
    }
}
