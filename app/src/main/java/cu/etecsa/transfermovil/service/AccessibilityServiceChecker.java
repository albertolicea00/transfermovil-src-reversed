package cu.etecsa.transfermovil.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.w9YDCnqpz8I
 * @original_apk_version 1.260416
 */
public class AccessibilityServiceChecker {
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
