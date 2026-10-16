package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$UssdResponseCallback;
import android.util.Log;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class WV9lIl58Oa {
    private static final String TAG = "WV9lIl58Oa-PRUEBA";
    private Context context;
    private String nextUssdCode;
    private TelephonyManager telephonyManager;

    public WV9lIl58Oa(Context context) {
        this.context = context;
        this.telephonyManager = (TelephonyManager) context.getSystemService("phone");
    }

    public void sendUssdRequest(String ussdCode, String nextUssdCode) {
        this.nextUssdCode = nextUssdCode;
        if (this.telephonyManager != null) {
            Log.i(TAG, "USSD Response: enviando inicio");
            TelephonyManager$UssdResponseCallback callback = null;
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                callback = new TelephonyManager$UssdResponseCallback() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.WV9lIl58Oa.1
                    public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
                        Log.i(WV9lIl58Oa.TAG, "USSD Response: " + ((Object) response));
                        WV9lIl58Oa.this.sendNextUssd();
                    }

                    public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int failureCode) {
                        Log.e(WV9lIl58Oa.TAG, "USSD Failed with code: " + failureCode);
                    }
                };
            }
            if (i < 26 || ContextCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") != 0) {
                return;
            }
            this.telephonyManager.sendUssdRequest(ussdCode, callback, new Handler());
            return;
        }
        Log.e(TAG, "TelephonyManager is not available.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextUssd() {
        String str = this.nextUssdCode;
        if (str != null && !str.isEmpty()) {
            Log.i(TAG, "Sending next USSD: " + this.nextUssdCode);
            sendUssdRequest(this.nextUssdCode, null);
        }
    }
}
