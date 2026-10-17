package cu.etecsa.transfermovil.core;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.O40QmFq77yZ
 * @fingerprint Singleton flag tracking whether SMS data has been imported
 */
public final class ImportFlag {
    private static boolean isImported;

    private ImportFlag() {
        isImported = false;
    }

    public static boolean isImported() {
        return isImported;
    }

    public static void setIsImported(boolean isImported) {
        ImportFlag.isImported = isImported;
    }
}
