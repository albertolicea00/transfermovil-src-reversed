package cu.etecsa.transfermovil.service;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.Ax4arraYwv
 * @original_apk_version 1.260416
 */
public class UssdCallbackRegistry {
    private static UssdCallbackRegistry instance;
    private UssdResponseCallback callback;

    private UssdCallbackRegistry() {
    }

    public static synchronized UssdCallbackRegistry getInstance() {
        if (instance == null) {
            instance = new UssdCallbackRegistry();
        }
        return instance;
    }

    public void setCallback(UssdResponseCallback callback) {
        this.callback = callback;
    }

    public UssdResponseCallback getCallback() {
        return this.callback;
    }
}
