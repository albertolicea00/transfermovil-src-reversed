package cu.etecsa.transfermovil.update;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.RoPkqiwcQO
 * @fingerprint Callback interface for APK update checking UI.
 */
public interface UpdateCheckListener {
    void checkForUpdate(String url);
    void setProgressBarVisiblity(int visibility);
    void updateApp(String url);
}
