package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$UssdResponseCallback;
import android.util.Log;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class MX9gh9mLxd {
    private static final String TAG = "WV9lIl58Oa";
    private UssdCallbackListener callbackListener;
    private Context context;
    private int currentIndex = 0;
    private TelephonyManager telephonyManager;
    private String[] ussdCodes;

    public interface UssdCallbackListener {
        void onUssdError(String str, int i);

        void onUssdResponse(String str, String str2);

        void onUssdResponseData(boolean z, int i, boolean z2, String str, String str2);
    }

    public static /* synthetic */ int access$108(MX9gh9mLxd x0) {
        int i = x0.currentIndex;
        x0.currentIndex = i + 1;
        return i;
    }

    public MX9gh9mLxd(Context context, UssdCallbackListener callbackListener) {
        this.context = context;
        this.telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.callbackListener = callbackListener;
    }

    public void sendUssdRequests(String[] ussdCodes) {
        if (ussdCodes == null || ussdCodes.length == 0) {
            Log.e(TAG, "No hay códigos USSD para enviar.");
            this.callbackListener.onUssdResponseData(false, 0, false, "No hay códigos USSD para enviar.", "1");
        } else {
            this.ussdCodes = ussdCodes;
            this.currentIndex = 0;
            sendNextUssd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextUssd() {
        if (this.currentIndex >= this.ussdCodes.length) {
            Log.i(TAG, "Todos los USSD han sido enviados.");
            this.callbackListener.onUssdResponseData(true, this.ussdCodes.length, true, "Todos los USSD han sido enviados.", "0");
            return;
        }
        String ussdCode = this.ussdCodes[this.currentIndex] + "#";
        Log.i(TAG, "Enviando USSD: " + ussdCode);
        if (this.telephonyManager == null) {
            Log.e(TAG, "TelephonyManager no disponible.");
            this.callbackListener.onUssdResponseData(false, 0, false, "TelephonyManager no disponible.", "2");
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            TelephonyManager$UssdResponseCallback callback = new TelephonyManager$UssdResponseCallback() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.1
                public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
                    Log.i(MX9gh9mLxd.TAG, "Respuesta USSD: " + ((Object) response));
                    boolean isSend = true;
                    if (MX9gh9mLxd.this.callbackListener != null) {
                        if (response.toString().contains("siendo procesada,")) {
                            MX9gh9mLxd.this.callbackListener.onUssdResponseData(true, MX9gh9mLxd.this.currentIndex + 1, false, "Enviado parte " + String.valueOf(MX9gh9mLxd.this.currentIndex + 1), "0");
                        } else {
                            isSend = false;
                            MX9gh9mLxd.this.callbackListener.onUssdResponseData(false, MX9gh9mLxd.this.currentIndex + 1, false, "Error Enviado - parte " + String.valueOf(MX9gh9mLxd.this.currentIndex + 1), "3");
                        }
                    }
                    if (isSend) {
                        MX9gh9mLxd.access$108(MX9gh9mLxd.this);
                        MX9gh9mLxd.this.sendNextUssd();
                    }
                }

                public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int failureCode) {
                    Log.e(MX9gh9mLxd.TAG, "Fallo en USSD: " + request + " | Código: " + failureCode);
                    if (MX9gh9mLxd.this.callbackListener != null) {
                        MX9gh9mLxd.this.callbackListener.onUssdError(request, failureCode);
                        MX9gh9mLxd.this.callbackListener.onUssdResponseData(false, MX9gh9mLxd.this.currentIndex + 1, false, "Error Enviado parte " + String.valueOf(MX9gh9mLxd.this.currentIndex + 1), "3");
                    }
                }
            };
            if (i >= 26) {
                if (ContextCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") != 0) {
                    Log.e(TAG, "Permiso CALL_PHONE no concedido.");
                    this.callbackListener.onUssdResponseData(false, this.currentIndex + 1, false, "Permiso CALL_PHONE no concedido. " + String.valueOf(this.currentIndex + 1), "3");
                    return;
                }
                this.telephonyManager.sendUssdRequest(ussdCode, callback, new Handler());
                return;
            }
            this.callbackListener.onUssdResponseData(false, this.currentIndex + 1, false, "USSD no soportado en esta versión de Android. " + String.valueOf(this.currentIndex + 1), "3");
            Log.e(TAG, "USSD no soportado en esta versión de Android.");
        }
    }
}
