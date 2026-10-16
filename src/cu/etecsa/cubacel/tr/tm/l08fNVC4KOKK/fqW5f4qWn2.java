package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class fqW5f4qWn2 {
    public String get_phone_number(Context appContext) {
        TelephonyManager tMgr = (TelephonyManager) appContext.getSystemService("phone");
        String mPhoneNumber = tMgr.getLine1Number();
        return mPhoneNumber;
    }

    public String get_IMEI_number(Context appContext) {
        TelephonyManager tMgr = (TelephonyManager) appContext.getSystemService("phone");
        String mIMEINumber = tMgr.getDeviceId();
        return mIMEINumber;
    }
}
