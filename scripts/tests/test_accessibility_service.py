"""Compare original and clean USSD accessibility events in a fake Android JVM.

No phone service, device, USSD call, SMS, or real accessibility action is used.
"""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
PREFIX = "cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FY4jCHXwyiP/ZJaneAnYYBm/Jayac1C1XVL/ZJDahAOo71x/"
PAIRS = {"O7xyZJJBFWg": "UssdAccessibilityService", "Ax4arraYwv": "UssdCallbackRegistry",
         "TVYvUziTDv": "UssdResponseCallback", "w9YDCnqpz8I": "AccessibilityServiceChecker"}


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class AccessibilityTest(unittest.TestCase):
    def test_original_event_and_control_flow(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-accessibility-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            for raw, clean in PAIRS.items():
                write(PREFIX + raw + ".java", (ROOT / "src" / (PREFIX + raw + ".java")).read_text())
                relative = "cu/etecsa/transfermovil/service/" + clean + ".java"
                write(relative, (ROOT / "app/src/main/java" / relative).read_text())
            for relative, source_root in (
                ("cu/etecsa/cubacel/tr/tm/X9ZiE8XZNKy.java", ROOT / "src"),
                ("cu/etecsa/transfermovil/receiver/SmsReceiver.java", ROOT / "app/src/main/java"),
            ):
                write(relative, (source_root / relative).read_text())
            for package, name in (
                ("cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK", "rDEl7rW1aN"),
                ("cu.etecsa.transfermovil.base", "BaseMainActivity"),
            ):
                write(package.replace(".", "/") + "/" + name + ".java",
                      "package " + package + "; public class " + name +
                      ' { public static final String ACTION="android.provider.Telephony.SMS_RECEIVED"; }')
            for name, text in STUBS.items():
                write(name + ".java", text)
            prefix = PREFIX.replace("/", ".")
            write("ServiceCheck.java", HARNESS.replace("ORIGINAL_PREFIX", prefix))
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "ServiceCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("Compared 240 event scenarios and 5 enablement scenarios", result.stdout)


STUBS = {
    "android/util/Trace": r"""package android.util;
public class Trace {
    public static java.util.List<String> events=new java.util.ArrayList<>();
    public static void add(String value) { events.add(value); }
    public static String target(Class<?> type) { return type.getSimpleName().equals("O7xyZJJBFWg")?"UssdAccessibilityService":type.getSimpleName(); }
    public static android.content.DialogInterface.OnClickListener positive,negative;
}""",
    "android/util/Log": r"""package android.util;
public class Log {
    public static int i(String tag,String value) { Trace.add(tag+":"+value); return 0; }
    public static int d(String tag,String value) { return i(tag,value); }
}""",
    "android/content/Context": r"""package android.content;
public class Context {
    public android.view.accessibility.AccessibilityManager manager=new android.view.accessibility.AccessibilityManager();
    public java.util.List<BroadcastReceiver> receivers=new java.util.ArrayList<>();
    public Object getSystemService(String name) { return manager; }
    public String getPackageName() { return "test.package"; }
    public Intent registerReceiver(BroadcastReceiver receiver,IntentFilter filter) {
        receivers.add(receiver); android.util.Trace.add("register:"+filter.action); return null;
    }
    public void unregisterReceiver(BroadcastReceiver receiver) { android.util.Trace.add("unregister"); }
    public void startActivity(Intent intent) { android.util.Trace.add("activity:"+intent.action+":"+intent.target); }
    public void startService(Intent intent) { android.util.Trace.add("start:"+intent.action+":"+intent.target); }
    public void stopService(Intent intent) { android.util.Trace.add("stop:"+intent.action+":"+intent.target); }
}""",
    "android/content/Intent": r"""package android.content;
public class Intent {
    public String action,target;
    public Intent(String action) { this.action=action; }
    public Intent(Context context,Class<?> type) { target=android.util.Trace.target(type); }
    public String getAction() { return action; }
}""",
    "android/content/IntentFilter": r"""package android.content;
public class IntentFilter { public String action; public IntentFilter(String action) { this.action=action; } }""",
    "android/content/BroadcastReceiver": r"""package android.content;
public abstract class BroadcastReceiver { public abstract void onReceive(Context context,Intent intent); }""",
    "android/content/DialogInterface": r"""package android.content;
public interface DialogInterface {
    void dismiss(); void cancel();
    interface OnClickListener { void onClick(DialogInterface dialog,int which); }
}""",
    "android/app/AlertDialog": r"""package android.app;
public class AlertDialog implements android.content.DialogInterface {
    public void show() { android.util.Trace.add("show"); }
    public void dismiss() { android.util.Trace.add("dismiss"); }
    public void cancel() { android.util.Trace.add("cancel"); }
    public static class Builder {
        public Builder(android.content.Context context) {}
        public Builder setTitle(String value) { android.util.Trace.add("title:"+value); return this; }
        public Builder setMessage(String value) { android.util.Trace.add("message:"+value); return this; }
        public Builder setCancelable(boolean value) { android.util.Trace.add("cancelable:"+value); return this; }
        public Builder setPositiveButton(String value,android.content.DialogInterface.OnClickListener cb) { android.util.Trace.positive=cb; return this; }
        public Builder setNegativeButton(String value,android.content.DialogInterface.OnClickListener cb) { android.util.Trace.negative=cb; return this; }
        public AlertDialog show() { android.util.Trace.add("dialog"); return new AlertDialog(); }
    }
}""",
    "androidx/appcompat/app/AlertDialog": r"""package androidx.appcompat.app;
public class AlertDialog extends android.app.AlertDialog {
    public static class Builder extends android.app.AlertDialog.Builder {
        public Builder(android.content.Context context) { super(context); }
        public AlertDialog create() { return new AlertDialog(); }
    }
}""",
    "android/accessibilityservice/AccessibilityService": r"""package android.accessibilityservice;
public abstract class AccessibilityService extends android.content.Context {
    public abstract void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event);
    public abstract void onInterrupt();
    public void onServiceConnected() {}
    public void onDestroy() {}
    public boolean performGlobalAction(int action) { android.util.Trace.add("global:"+action); return true; }
    public void setServiceInfo(AccessibilityServiceInfo info) {
        android.util.Trace.add("config:"+info.flags+":"+info.eventTypes+":"+info.feedbackType+":"+java.util.Arrays.toString(info.packageNames));
    }
}""",
    "android/accessibilityservice/AccessibilityServiceInfo": r"""package android.accessibilityservice;
public class AccessibilityServiceInfo {
    public int flags,eventTypes,feedbackType; public String[] packageNames;
    public android.content.pm.ResolveInfo resolve=new android.content.pm.ResolveInfo();
    public android.content.pm.ResolveInfo getResolveInfo() { return resolve; }
}""",
    "android/content/pm/ResolveInfo": r"""package android.content.pm;
public class ResolveInfo { public ServiceInfo serviceInfo=new ServiceInfo(); }""",
    "android/content/pm/ServiceInfo": r"""package android.content.pm;
public class ServiceInfo { public String packageName,name; }""",
    "android/view/accessibility/AccessibilityManager": r"""package android.view.accessibility;
public class AccessibilityManager {
    public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> enabled=new java.util.ArrayList<>();
    public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int mask) { return enabled; }
}""",
    "android/view/accessibility/AccessibilityEvent": r"""package android.view.accessibility;
public class AccessibilityEvent {
    public int type; public String text; public AccessibilityNodeInfo source;
    public int getEventType() { return type; }
    public java.util.List<CharSequence> getText() { return java.util.Arrays.asList(text); }
    public AccessibilityNodeInfo getSource() { return source; }
}""",
    "android/view/accessibility/AccessibilityNodeInfo": r"""package android.view.accessibility;
public class AccessibilityNodeInfo {
    public boolean clickable; public java.util.List<AccessibilityNodeInfo> children;
    public java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text) { android.util.Trace.add("find:"+text); return children; }
    public boolean isClickable() { return clickable; }
    public boolean performAction(int action) { android.util.Trace.add("node:"+action); return true; }
}""",
}

HARNESS = r"""
import java.lang.reflect.*;
import android.util.Trace;
import android.content.*;
import android.accessibilityservice.*;
import android.view.accessibility.*;
public class ServiceCheck {
    static String raw="ORIGINAL_PREFIX";
    static String clean="cu.etecsa.transfermovil.service.";
    static String events(String prefix,String service,String registry,String callback,int cb,int type,String text,int source) throws Exception {
        Trace.events.clear();
        AccessibilityService instance=(AccessibilityService)Class.forName(prefix+service).getConstructor().newInstance();
        Class<?> callbackType=Class.forName(prefix+callback);
        Object store=Class.forName(prefix+registry).getMethod("getInstance").invoke(null);
        Object listener=cb==0?null:Proxy.newProxyInstance(callbackType.getClassLoader(),new Class<?>[]{callbackType},(p,m,a)->{
            Trace.add("callback"); if(cb==2) throw new IllegalStateException("fixture callback"); return null;
        });
        store.getClass().getMethod("setCallback",callbackType).invoke(store,listener);
        try {
            instance.onServiceConnected();
            BroadcastReceiver control=instance.receivers.get(0);
            control.onReceive(instance,null);
            control.onReceive(instance,new Intent("UNKNOWN"));
            control.onReceive(instance,new Intent("START_LISTENING"));
            AccessibilityEvent event=new AccessibilityEvent(); event.type=type; event.text=text;
            if(source>0) {
                event.source=new AccessibilityNodeInfo();
                if(source>1) event.source.children=new java.util.ArrayList<>();
                if(source>2) event.source.children.add(new AccessibilityNodeInfo());
                if(source>3) { AccessibilityNodeInfo button=new AccessibilityNodeInfo(); button.clickable=true; event.source.children.add(button); }
            }
            instance.onAccessibilityEvent(event);
            control.onReceive(instance,new Intent("STOP_LISTENING"));
            instance.onAccessibilityEvent(event);
            control.onReceive(instance,new Intent("START_LISTENING"));
            instance.onAccessibilityEvent(event);
            instance.onInterrupt(); instance.onDestroy();
        } catch(Exception e) { Trace.add("throws:"+e.getClass().getName()); }
        return Trace.events.toString();
    }
    static String enabled(String prefix,String service,int mode) throws Exception {
        Trace.events.clear();
        Class<?> type=Class.forName(prefix+service); Object instance=type.getConstructor().newInstance();
        Context context=new Context();
        if(mode==0) context.manager=null;
        if(mode>1) {
            AccessibilityServiceInfo info=new AccessibilityServiceInfo();
            info.resolve.serviceInfo.packageName=mode==2?"other.package":"test.package";
            info.resolve.serviceInfo.name=mode==3?"OtherService":type.getName();
            context.manager.enabled.add(info);
        }
        type.getMethod("ensureAccessibilityServiceRunning",Context.class).invoke(instance,context);
        type.getMethod("stopAccessibilityService",Context.class).invoke(instance,context);
        type.getMethod("showAccessibilityServiceDialog",Context.class).invoke(null,context);
        Trace.positive.onClick(new android.app.AlertDialog(),0);
        Trace.negative.onClick(new android.app.AlertDialog(),0);
        return Trace.events.toString();
    }
    static String sms(String name,String action) throws Exception {
        Trace.events.clear(); Context context=new Context();
        BroadcastReceiver receiver=(BroadcastReceiver)Class.forName(name).getConstructor().newInstance();
        try { receiver.onReceive(context,action==null?null:new Intent(action)); }
        catch(Exception e) { Trace.add("throws:"+e.getClass().getName()); }
        Trace.add("context:"+(receiver.getClass().getField("myContext").get(receiver)==context));
        Trace.add("ACTION:"+receiver.getClass().getField("ACTION").get(receiver));
        receiver.getClass().getMethod("displayAlert",String.class).invoke(receiver,"fixture message");
        Trace.positive.onClick(new android.app.AlertDialog(),0);
        return Trace.events.toString();
    }
    public static void main(String[] args) throws Exception {
        int count=0;
        for(int cb=0;cb<3;cb++) for(int type:new int[]{1,32})
            for(String text:new String[]{"USSD", "ussd", "Si", "OK", "ACEPTAR", "sistema", "unrelated", ""})
                for(int source=0;source<5;source++) {
                    String a=events(raw,"O7xyZJJBFWg","Ax4arraYwv","TVYvUziTDv",cb,type,text,source);
                    String b=events(clean,"UssdAccessibilityService","UssdCallbackRegistry","UssdResponseCallback",cb,type,text,source);
                    if(!a.equals(b)) throw new AssertionError(cb+"/"+type+"/"+text+"/"+source+"\n"+a+"\n"+b);
                    count++;
                }
        for(int mode=0;mode<5;mode++) {
            String a=enabled(raw,"O7xyZJJBFWg",mode),b=enabled(clean,"UssdAccessibilityService",mode);
            if(!a.equals(b)) throw new AssertionError("enablement "+mode+"\n"+a+"\n"+b);
        }
        for(String action:new String[]{null,"android.provider.Telephony.SMS_RECEIVED","unrelated"}) {
            String a=sms("cu.etecsa.cubacel.tr.tm.X9ZiE8XZNKy",action);
            String b=sms("cu.etecsa.transfermovil.receiver.SmsReceiver",action);
            if(!a.equals(b)) throw new AssertionError("SMS "+action+"\n"+a+"\n"+b);
        }
        System.out.println("Compared "+count+" event scenarios and 5 enablement scenarios");
    }
}
"""
