"""Source/router and mocked dispatch parity; no phone/network APIs are invoked."""
import re
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
RAW = ROOT / 'src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/FBsQzP3Zfj.java'
CLEAN = ROOT / 'app/src/main/java/cu/etecsa/transfermovil/ussd/UssdDispatcher.java'


def without_comments(value):
    # Only remove JADX comments: preserve URL strings and diagnostic messages.
    value = re.sub(r'/\*.*?\*/', '', value, flags=re.S)
    value = re.sub(r'// (?:from class:|android\.|androidx\.|cu\.)[^\n]*', '', value)
    return re.sub(r'\s+', '', value)


class UssdDispatcherSourceTest(unittest.TestCase):
    def test_complete_source_body_and_all_84_router_branches(self):
        raw = RAW.read_text()
        clean = CLEAN.read_text()
        start = raw.index('    /* JADX INFO: renamed from:')
        end = raw.index('    private static final Bundle getBundleOperation', start)
        mapping = {int(number): name for name, number in re.findall(
            r'\[FdonIAFI9w\.([A-Za-z0-9_]+)\.ordinal\(\)\] = (\d+);', raw[start:end])}
        self.assertEqual(set(mapping), set(range(1, 85)))
        raw = raw[:start] + raw[end:]
        start = raw.index('    private static final Bundle getBundleOperation')
        end = raw.index('    private static final AlertDialog.Builder getAlertDialogBuilder', start)
        router = raw[start:end]
        router = re.sub(r'switch \(AnonymousClass74\.\$SwitchMap\$[^\[]+\[operacion\.ordinal\(\)\]\)',
                        'switch (operacion)', router)
        router = re.sub(r'case (\d+):', lambda m: 'case ' + mapping[int(m.group(1))] + ':', router)
        raw = raw[:start] + router + raw[end:]
        raw = raw.replace('FBsQzP3Zfj', 'UssdDispatcher').replace('rDEl7rW1aN', 'BaseMainActivity')
        raw = raw.replace('IHVTCBmiLV', 'AgentMainActivity').replace('S9ycHcoxAzy', 'GeneralMainActivity')
        raw = raw.replace('public class UssdDispatcher extends Activity {', 'public class UssdDispatcher {')
        self.assertEqual(without_comments(raw[raw.index('public class '):]),
                         without_comments(clean[clean.index('public class '):]))

    def test_clean_callers_do_not_use_raw_dispatcher(self):
        for path in (ROOT / 'app/src/main/java').rglob('*.java'):
            if 'ecommerce' not in path.parts and path != CLEAN:
                self.assertNotIn('FBsQzP3Zfj', path.read_text(), str(path))


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class UssdDispatcherMockTest(unittest.TestCase):
    def test_confirm_cancel_failure_navigation_and_packet_parity(self):
        with tempfile.TemporaryDirectory(prefix='tm-dispatch-') as directory:
            root = Path(directory)
            def write(name, source):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(source)
            imports = '''import android.app.Activity; import android.content.*; import android.net.Uri;
import android.os.Bundle; import android.text.*; import android.text.method.LinkMovementMethod;
import android.util.Log; import android.view.*; import android.widget.*;
import androidx.appcompat.app.AlertDialog; import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager; import java.util.*;
import com.github.paolorotolo.appintro.BuildConfig; import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV; import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.transfermovil.ui.AgentMainActivity; import cu.etecsa.transfermovil.ui.GeneralMainActivity;
'''
            for source, package in [(RAW.read_text(), 'raw'), (CLEAN.read_text(), 'clean')]:
                body = source[source.index('    public interface UssdBaseObserver'):source.index('    public static final String validateAuthBank')]
                body = body.replace('FBsQzP3Zfj', 'Dispatcher').replace('UssdDispatcher', 'Dispatcher')
                body = body.replace('rDEl7rW1aN', 'Encoder').replace('BaseMainActivity', 'Encoder')
                write(package + '/Dispatcher.java', 'package ' + package + ';\n' + imports +
                      'public class Dispatcher {\n' + body + '\n}\n')
                write(package + '/Encoder.java', 'package '+package+'; public class Encoder { public String code(String s){return "encoded("+s+")";} }')
            for name, source in STUBS.items():
                write(name + '.java', source)
            for package in ['android.app', 'androidx.appcompat.app']:
                write(package.replace('.', '/') + '/AlertDialog.java', DIALOG.replace('PACKAGE', package))
            write('DispatchCheck.java', HARNESS)
            built = subprocess.run(['javac', '-d', str(root / 'classes'), *map(str, root.rglob('*.java'))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            checked = subprocess.run(['java', '-cp', str(root / 'classes'), 'DispatchCheck'],
                                     capture_output=True, text=True, timeout=60)
            self.assertEqual(checked.returncode, 0, checked.stderr + checked.stdout)
            self.assertIn('dispatch parity passed', checked.stdout)


STUBS = {
'android/content/Context': '''package android.content; import java.util.*;
public class Context { public static List<String> events=new ArrayList<>(); public static boolean fail;
 public void startActivity(Intent value){if(fail)throw new IllegalStateException(); events.add("call:"+value.uri+":"+value.flags);}
}''',
'android/content/Intent': '''package android.content; import android.net.Uri;
public class Intent { public Uri uri; public int flags; public String extra;
 public Intent(){} public Intent(String action,Uri uri){this.uri=uri;}
 public Intent addFlags(int value){flags|=value;return this;}
 public Intent putExtra(String key,String value){extra=key+":"+value;return this;}
}''',
'android/content/DialogInterface': '''package android.content; public interface DialogInterface {
void cancel(); void dismiss(); interface OnClickListener {void onClick(DialogInterface d,int id);} }''',
'android/app/Activity': '''package android.app; import android.content.*;
public class Activity extends Context {public void finish(){events.add("finish");}
public void setResult(int code,Intent value){events.add("result:"+code+":"+value.extra);} }''',
'android/net/Uri': '''package android.net; public class Uri {String value; private Uri(String value){this.value=value;}
public static Uri parse(String value){return new Uri(value);} public static String encode(String value){return value.equals("#")?"%23":value;}
public String toString(){return value;} }''',
'android/os/Bundle': '''package android.os; public class Bundle {public boolean returning;
public void putBoolean(String name,boolean value){returning=value;} }''',
'android/text/Html': '''package android.text; public class Html {public static String fromHtml(String s){return s;} }''',
'android/text/SpannableString': '''package android.text; public class SpannableString {public SpannableString(String s){} }''',
'android/text/method/LinkMovementMethod': '''package android.text.method; public class LinkMovementMethod {public static Object getInstance(){return new Object();}}''',
'android/util/Log': '''package android.util; public class Log {public static int d(String a,String b){return 0;}}''',
'android/view/View': '''package android.view; import android.content.Context;
public class View {public Context context; public View(){context=new Context();} public Context getContext(){return context;} }''',
'android/view/ViewGroup': '''package android.view; import java.util.*;
public class ViewGroup extends View {public List<View> children=new ArrayList<>(); public int getChildCount(){return children.size();}
public View getChildAt(int position){return children.get(position);} }''',
'android/widget/EditText': '''package android.widget; public class EditText extends android.view.View {public String text="filled";public void setText(String s){text=s;} }''',
'android/widget/TextView': '''package android.widget; public class TextView extends android.view.View {public void setMovementMethod(Object value){android.content.Context.events.add("link");}}''',
'androidx/core/content/ContextCompat': '''package androidx.core.content; public class ContextCompat {public static int permission;
public static int checkSelfPermission(android.content.Context context,String permissionName){return permission;} }''',
'androidx/fragment/app/FragmentManager': '''package androidx.fragment.app; import android.content.Context;import android.os.Bundle;
public class FragmentManager {public void popBackStack(){Context.events.add("pop");}
public void setFragmentResult(String key,Bundle value){Context.events.add("fragment:"+key+":"+value.returning);} }''',
'android/R': '''package android; public class R {public static class id {public static int message=1;} }''',
'cu/etecsa/cubacel/tr/tm/R': '''package cu.etecsa.cubacel.tr.tm; public class R {public static class string {public static int confirm=1;}}''',
'com/github/paolorotolo/appintro/BuildConfig': '''package com.github.paolorotolo.appintro; public class BuildConfig {public static final String FLAVOR="";}''',
'cu/etecsa/cubacel/tr/tm/IHVTCBmiLV': '''package cu.etecsa.cubacel.tr.tm; public class IHVTCBmiLV extends android.app.Activity {public void UpdateMenu(){events.add("menu-agent");}}''',
'cu/etecsa/cubacel/tr/tm/S9ycHcoxAzy': '''package cu.etecsa.cubacel.tr.tm; public class S9ycHcoxAzy extends android.app.Activity {public void UpdateMenu(){events.add("menu-general");}}''',
'cu/etecsa/transfermovil/ui/AgentMainActivity': '''package cu.etecsa.transfermovil.ui; public class AgentMainActivity extends android.app.Activity {public void UpdateMenu(){events.add("menu-agent");}}''',
'cu/etecsa/transfermovil/ui/GeneralMainActivity': '''package cu.etecsa.transfermovil.ui; public class GeneralMainActivity extends android.app.Activity {public void UpdateMenu(){events.add("menu-general");}}''',
'cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/MZUDJuUoMJL/AppConfig': '''package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;
public class AppConfig {public String bank; public String getCodigo(){return "444";} public String getNumber(){return "version";}
public void setCode_bank(String value){bank=value;android.content.Context.events.add("bank:"+value);}
public void setFechaHoraAuthBank(java.util.Date value){android.content.Context.events.add("auth-date");}}''',
'cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/unYp8VQThY': '''package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM;
import java.util.*;import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
public class unYp8VQThY {static unYp8VQThY instance=new unYp8VQThY();public static List<AppConfig> configs=new ArrayList<>();
public static void init(android.content.Context context){} public static unYp8VQThY getInstance(){return instance;}
public List<AppConfig> getAllAppConfigLists(){return configs;} public void updateAppConfig(AppConfig config){android.content.Context.events.add("save");}}''',
}

DIALOG = '''package PACKAGE; import android.content.*;
public class AlertDialog implements DialogInterface {public static AlertDialog last;
 public DialogInterface.OnClickListener positive,negative; public String title,message;
 public void show(){last=this;} public void cancel(){Context.events.add("cancel");} public void dismiss(){Context.events.add("dismiss");}
 public void setCanceledOnTouchOutside(boolean value){} public void setCancelable(boolean value){}
 public Object findViewById(int id){return new android.widget.TextView();}
 public static class Builder {AlertDialog dialog=new AlertDialog();public Builder(Context c){}
 public Builder setTitle(Object value){dialog.title=String.valueOf(value);return this;}
 public Builder setMessage(Object value){dialog.message=String.valueOf(value);return this;}
 public Builder setPositiveButton(String value,DialogInterface.OnClickListener click){dialog.positive=click;return this;}
 public Builder setNegativeButton(String value,DialogInterface.OnClickListener click){dialog.negative=click;return this;}
 public AlertDialog create(){return dialog;}public AlertDialog show(){dialog.show();return dialog;} }
}'''

HARNESS = r'''
import android.content.*; import android.app.Activity; import android.view.*;
import androidx.appcompat.app.AlertDialog; import androidx.fragment.app.FragmentManager;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import java.lang.reflect.*; import java.util.*;
public class DispatchCheck {
 static int cases;
 static List<String> run(String prefix,String name,int click,boolean fail,boolean empty,boolean denied,boolean bankActivity) throws Exception {
  Context.events.clear();Context.fail=fail;AlertDialog.last=null;android.app.AlertDialog.last=null;
  unYp8VQThY.configs.clear();if(!empty)unYp8VQThY.configs.add(new AppConfig());
  androidx.core.content.ContextCompat.permission=denied?1:0;
  Class<?> type=Class.forName(prefix+".Dispatcher");Object instance=type.getConstructor().newInstance();
  Context context=new Context();ViewGroup group=new ViewGroup();group.context=context;FragmentManager fm=new FragmentManager();
  Activity activity=bankActivity?(prefix.equals("raw")?new cu.etecsa.cubacel.tr.tm.IHVTCBmiLV():new cu.etecsa.transfermovil.ui.AgentMainActivity()):new Activity();
  Class<?> observer=Class.forName(prefix+".Dispatcher$UssdBaseObserver");
  Object obs=Proxy.newProxyInstance(type.getClassLoader(),new Class[]{observer},(proxy,method,args)->{
   Context.events.add("observer:"+method.getName()+":"+(args==null?"":Arrays.toString(args)));return null;});
  List<Class<?>> signature=new ArrayList<>();List<Object> args=new ArrayList<>();
  if(name.equals("uri")) {
   Object uri=type.getMethod("actionCallUSSDBack",Context.class,String.class,String.class).invoke(instance,context,"45","12*34");
   Context.events.add("uri:"+uri);
  } else if(name.equals("callLenght")) {
   Context.events.add("length:"+type.getMethod(name,Context.class,String.class).invoke(null,context,"12*34"));
  } else if(name.equals("clearForm")) {
   android.widget.EditText a=new android.widget.EditText(),b=new android.widget.EditText();ViewGroup nested=new ViewGroup();
   group.children.add(a);group.children.add(nested);nested.children.add(b);
   type.getMethod(name,ViewGroup.class).invoke(instance,group);Context.events.add("fields:"+a.text+":"+b.text);
  } else if(name.equals("createAlertDialog")) {
   type.getMethod(name,String.class,ViewGroup.class,android.net.Uri.class,FragmentManager.class)
    .invoke(null,"message",group,android.net.Uri.parse("tel:*222%23"),fm);
  } else {
   String actual=name;
   if(name.startsWith("bank")){actual="actionCallUSSDBack";signature.add(String.class);args.add("BPA");}
   signature.add(Context.class);args.add(context);
   if(name.equals("actionCallUSSDNOBack")){signature.add(Activity.class);args.add(activity);}
   signature.add(String.class);args.add("45");signature.add(String.class);args.add("12*34");
   if(!name.equals("actionCallUSSDSimple")) {
    boolean http=name.equals("actionCallUSSDBackHttp");signature.add(http?android.text.SpannableString.class:String.class);
    args.add(http?new android.text.SpannableString("message"):"message");
    signature.add(ViewGroup.class);args.add(group);signature.add(FragmentManager.class);args.add(fm);
   }
   if(name.endsWith("Observer")||name.endsWith("AsocClasica")){signature.add(observer);args.add(obs);}
   if(name.equals("bankActivity")){signature.add(Activity.class);args.add(activity);}
   type.getMethod(actual,signature.toArray(new Class[0])).invoke(null,args.toArray());
  }
  if(AlertDialog.last!=null){AlertDialog d=AlertDialog.last;
   Context.events.add("dialog:"+d.title);if(click>0)d.positive.onClick(d,1);else if(click<0)d.negative.onClick(d,0);}
  if(android.app.AlertDialog.last!=null){android.app.AlertDialog d=android.app.AlertDialog.last;
   Context.events.add("exit-dialog:"+d.message);if(click>0)d.positive.onClick(d,1);}
  return new ArrayList<>(Context.events);
 }
 public static void main(String[] args)throws Exception {
  String[] names={"uri","callLenght","clearForm","createAlertDialog","actionCallUSSDSimple","actionCallUSSDBack",
    "actionCallUSSDBack454","actionCallUSSDBackAsocClasica","actionCallUSSDBackObserver","actionCallUSSDBackHttp",
    "actionCallUSSDNoBackSimple","actionCallUSSDBackWithRetun","actionCallUSSDNOBack","bank","bankActivity"};
  for(String name:names)for(int click:new int[]{-1,0,1})for(boolean fail:new boolean[]{false,true})
   for(boolean empty:new boolean[]{false,true})for(boolean denied:new boolean[]{false,true})for(boolean bank:new boolean[]{false,true}) {
    Object a,b;
    try{a=run("raw",name,click,fail,empty,denied,bank);}catch(InvocationTargetException e){a="throws:"+e.getCause().getClass().getName();}
    try{b=run("clean",name,click,fail,empty,denied,bank);}catch(InvocationTargetException e){b="throws:"+e.getCause().getClass().getName();}
    if(!Objects.equals(a,b))throw new AssertionError(name+": "+a+" vs "+b);cases++;
   }
  List<String> events=run("clean","actionCallUSSDBack",1,false,false,false,false);
  if(!events.contains("call:tel:*444*45*encoded(12*34)*version%23:0")||!events.contains("fragment:returnToA:true")||!events.contains("pop"))throw new AssertionError(events);
  events=run("clean","actionCallUSSDSimple",1,false,false,false,false);
  if(!events.contains("call:tel:*444*45*12*34*version%23:268435456"))throw new AssertionError(events);
  Context.events.clear();
  clean.Dispatcher.actionCallUSSDBack("BPA",new Context(),"45","12*34","message",new ViewGroup(),
    new FragmentManager(),new cu.etecsa.transfermovil.ui.GeneralMainActivity());
  AlertDialog.last.positive.onClick(AlertDialog.last,1);
  if(!Context.events.contains("menu-general"))throw new AssertionError(Context.events);
  System.out.println("dispatch parity passed: "+cases);
 }
}
'''
