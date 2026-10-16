package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w9YDCnqpz8I {
    public static boolean isAccessibilityServiceEnabled(Context context, Class<? extends AccessibilityService> service) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService("accessibility");
        if (am != null) {
            List<AccessibilityServiceInfo> enabledServices = am.getEnabledAccessibilityServiceList(-1);
            for (AccessibilityServiceInfo enabledService : enabledServices) {
                if (enabledService.getResolveInfo().serviceInfo.packageName.equals(context.getPackageName()) && enabledService.getResolveInfo().serviceInfo.name.equals(service.getName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
