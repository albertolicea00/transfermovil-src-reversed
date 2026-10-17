package cu.etecsa.transfermovil.update;

import java.io.File;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.TglsVwaylD
 * @fingerprint Callback interface for APK update check/download results.
 */
public interface UpdateResultCallback {
    void onResultCheckUpdate(Boolean success, int httpCode, String message, String version);
    void onResultUpdate(Boolean success, int httpCode, String message, String version, File apkFile);
    void onSetProgressBarVisibility(int visibility);
}
