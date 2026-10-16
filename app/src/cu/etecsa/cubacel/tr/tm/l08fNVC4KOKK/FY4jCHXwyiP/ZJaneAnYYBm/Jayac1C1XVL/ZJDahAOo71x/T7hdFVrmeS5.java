package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class T7hdFVrmeS5 {
    private static final String TAG = "T7hdFVrmeS5";
    private Context context;
    private H5bNyNZfB5K ussdAccessibility;
    private WV9lIl58Oa ussdHelper;

    public T7hdFVrmeS5(Context context) {
        this.context = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.ussdHelper = new WV9lIl58Oa(context);
        } else {
            this.ussdAccessibility = new H5bNyNZfB5K();
        }
    }

    public void sendUssd(String ussdCode, String nextUssdCode) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.ussdHelper.sendUssdRequest(ussdCode, nextUssdCode);
        } else {
            this.ussdAccessibility.sendNextUssd(nextUssdCode);
        }
    }

    public void sendUssdTest(String ussdCode, String nextUssdCode) {
        this.ussdHelper.sendUssdRequest(ussdCode, nextUssdCode);
    }
}
