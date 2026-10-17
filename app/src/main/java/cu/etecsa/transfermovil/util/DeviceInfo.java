package cu.etecsa.transfermovil.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.fqW5f4qWn2
 * @fingerprint Reads phone number (getLine1Number) and IMEI (getDeviceId) via TelephonyManager.
 *              Both APIs deprecated on newer Android; IMEI requires READ_PHONE_STATE.
 */
public class DeviceInfo {

    public String get_phone_number(Context appContext) {
        TelephonyManager tMgr = (TelephonyManager) appContext.getSystemService("phone");
        return tMgr.getLine1Number();
    }

    public String get_IMEI_number(Context appContext) {
        TelephonyManager tMgr = (TelephonyManager) appContext.getSystemService("phone");
        return tMgr.getDeviceId();
    }
}
