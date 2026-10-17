package cu.etecsa.transfermovil.banking.ui;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E
 * @fingerprint Callback for accounts/fuel SMS processing result
 */
public interface AccountsResultCallback {
    void onCuentasResult(Boolean success, int count, String message);
    void onSetProgressBarVisibility(int visibility);
}
