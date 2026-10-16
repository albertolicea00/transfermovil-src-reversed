package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class O7xyZJJBFWg extends AccessibilityService {
    private boolean shouldListen = false;
    private BroadcastReceiver controlReceiver = new BroadcastReceiver() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.O7xyZJJBFWg.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("NF_LOG", "on Receive init");
            if (intent != null) {
                Log.i("NF_LOG", "on Receive");
                String action = intent.getAction();
                if ("START_LISTENING".equals(action)) {
                    O7xyZJJBFWg.this.shouldListen = true;
                    Log.i("NF_LOG", "Started listening for USSD events.");
                } else if ("STOP_LISTENING".equals(action)) {
                    O7xyZJJBFWg.this.shouldListen = false;
                    Log.i("NF_LOG", "Stopped listening for USSD events.");
                }
            }
        }
    };

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i("NF_LOG", "Event received");
        Log.i("NF_LOG", "shouldListen" + String.valueOf(this.shouldListen));
        if (this.shouldListen && event.getEventType() == 32) {
            String eventText = String.valueOf(event.getText());
            Log.i("NF_LOG", "Event text: " + eventText);
            if (eventText.contains("USSD")) {
                Log.i("NF_LOG", "USSD detected");
                performGlobalAction(1);
                respondToUssd(event);
                return;
            }
            if (eventText.toLowerCase().contains("si")) {
                Log.i("NF_LOG", "ACEPTAR detected");
                performGlobalAction(1);
                respondToUssd(event);
                TVYvUziTDv callback = Ax4arraYwv.getInstance().getCallback();
                if (callback != null) {
                    callback.onUssdReceived();
                    return;
                }
                return;
            }
            if (eventText.toLowerCase().contains("ok")) {
                Log.i("NF_LOG", "OK detected");
                performGlobalAction(1);
                respondToUssd(event);
                TVYvUziTDv callback2 = Ax4arraYwv.getInstance().getCallback();
                if (callback2 != null) {
                    callback2.onUssdReceived();
                    return;
                }
                return;
            }
            if (eventText.toLowerCase().contains("aceptar")) {
                Log.i("NF_LOG", "ACEPTAR detected");
                performGlobalAction(1);
                respondToUssd(event);
                TVYvUziTDv callback3 = Ax4arraYwv.getInstance().getCallback();
                if (callback3 != null) {
                    callback3.onUssdReceived();
                }
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.d("NF_LOG", "Service onInterrupt");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        registerReceiver(this.controlReceiver, new IntentFilter("START_LISTENING"));
        registerReceiver(this.controlReceiver, new IntentFilter("STOP_LISTENING"));
        Log.d("NF_LOG", "Service connected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = 1;
        info.packageNames = new String[]{"com.android.phone"};
        info.eventTypes = 32;
        info.feedbackType = 16;
        setServiceInfo(info);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d("NF_LOG", "Service destroyed");
        unregisterReceiver(this.controlReceiver);
    }

    private void respondToUssd(AccessibilityEvent event) {
        AccessibilityNodeInfo source = event.getSource();
        Log.i("NF_LOG", "Event");
        if (source != null) {
            Log.i("NF_LOG", "Event2");
            List<AccessibilityNodeInfo> nodeInfoList = source.findAccessibilityNodeInfosByText("ACEPTAR");
            if (nodeInfoList != null && !nodeInfoList.isEmpty()) {
                Log.i("NF_LOG", "Event3");
                for (AccessibilityNodeInfo node : nodeInfoList) {
                    if (node.isClickable()) {
                        Log.i("NF_LOG", "Event4 click");
                        node.performAction(16);
                        return;
                    }
                }
            }
        }
    }

    public void ensureAccessibilityServiceRunning(Context context) {
        boolean isServiceEnabled = w9YDCnqpz8I.isAccessibilityServiceEnabled(context, O7xyZJJBFWg.class);
        if (!isServiceEnabled) {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            context.startActivity(intent);
            startAccessibilityService(context);
            return;
        }
        Log.i("NF_LOG", "Accessibility Service is already running.");
    }

    private void startAccessibilityService(Context context) {
        Intent intent = new Intent(context, (Class<?>) O7xyZJJBFWg.class);
        context.startService(intent);
    }

    public void stopAccessibilityService(Context context) {
        Intent intent = new Intent(context, (Class<?>) O7xyZJJBFWg.class);
        context.stopService(intent);
    }

    public static void showAccessibilityServiceDialog(final Context context) {
        new AlertDialog.Builder(context).setTitle("Permiso de Accesibilidad Necesario").setMessage("Para que esta aplicación funcione correctamente, necesitas activar el servicio de accesibilidad. Esto nos permitirá interactuar con las ventanas de USSD. ¿Deseas activarlo ahora?").setPositiveButton("Ir a Configuración", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.O7xyZJJBFWg.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                context.startActivity(intent);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.O7xyZJJBFWg.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}
