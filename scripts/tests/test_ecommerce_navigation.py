"""Exercise credential/factor callback routing on the JVM and check manifest aliases."""
import shutil
import subprocess
import tempfile
import unittest
import xml.etree.ElementTree as ET
from pathlib import Path

from scripts.tests.test_child_user_ui import extract_method

ROOT = Path(__file__).resolve().parents[2]
CLEAN = ROOT / 'app/src/main/java/cu/etecsa/transfermovil/ecommerce'
RAW = ROOT / 'src/cu/etecsa/tm/ecommerce/LaIvmOMkyve/LkJy0pyJfa8'


class EcommerceNavigationTest(unittest.TestCase):
    def test_source_activity_aliases_target_declared_clean_activities(self):
        android = '{http://schemas.android.com/apk/res/android}'
        application = ET.parse(ROOT / 'app/AndroidManifest.xml').getroot().find('application')
        declared = set()
        aliases = {}
        for element in application:
            if element.tag == 'activity':
                declared.add(element.attrib[android + 'name'])
            elif element.tag == 'activity-alias':
                name = element.attrib[android + 'name']
                target = element.attrib[android + 'targetActivity']
                self.assertIn(target, declared, 'alias target must be declared before alias')
                self.assertNotIn(name, declared)
                if name.startswith('cu.etecsa.tm.ecommerce.'):
                    self.assertEqual('false', element.attrib[android + 'exported'])
                elif name == 'cu.etecsa.cubacel.tr.tm.prPzLeyxKk':
                    self.assertEqual('true', element.attrib[android + 'exported'])
                    self.assertEqual('cu.etecsa.transfermovil.ui.SplashActivity', target)
                aliases[name] = target
        for raw, clean in [('a7Y4bbw8Os', 'LoginActivity'),
                           ('C1b1PWKeZSE', 'CredentialLoginActivity'),
                           ('hd5jZHAGaN', 'EcommerceHomeActivity')]:
            self.assertEqual('cu.etecsa.transfermovil.ecommerce.' + clean,
                             aliases['cu.etecsa.tm.ecommerce.' + raw])

    @unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
    def test_credential_payload_and_factor_result_match_source(self):
        classes = []
        for name, path, signature in [
            ('OriginalCredentials', RAW / 'BHjQLXD3fY.java', 'public void onResult('),
            ('CleanCredentials', CLEAN / 'CredentialLoginFragment.java', 'public void onResult('),
            ('OriginalFactor', RAW / 'n5G52vH5qAR.java', 'public void onResultFactor('),
            ('CleanFactor', CLEAN / 'TwoFactorLoginFragment.java', 'public void onResultFactor('),
        ]:
            classes.append('static class ' + name + ' extends Base {\n' +
                           extract_method(path.read_text(), signature) + '\n}')
        harness = '''
import java.util.HashMap;
public class NavigationCheck {
    static class Bundle extends HashMap<String,String> {
        void putString(String key,String value){ put(key,value); }
    }
    static class Fragment { Bundle args; void setArguments(Bundle value){args=value;} }
    static class n5G52vH5qAR extends Fragment {}
    static class TwoFactorLoginFragment extends Fragment {}
    static class PVrNBPiBYx extends Fragment {}
    static class EcommerceHomeFragment extends Fragment {}
    static class R { static class id { static int containerView=1; } }
    static class Text {
        String value; Text(String value){this.value=value;} String getText(){return value;}
    }
    static class FragmentTransaction {
        Fragment fragment; boolean committed;
        FragmentTransaction replace(int id,Fragment value){fragment=value;return this;}
        void commit(){committed=true;}
    }
    static class FragmentManager {
        FragmentTransaction transaction=new FragmentTransaction();
        FragmentTransaction beginTransaction(){return transaction;}
    }
    static class Activity {
        FragmentManager manager=new FragmentManager();
        FragmentManager getSupportFragmentManager(){return manager;}
    }
    static class Base {
        Activity activity=new Activity(); Text txUser=new Text("  USER@Mail  ");
        Text txPass=new Text("  secret  "); String error;
        Activity getActivity(){return activity;}
        void ShowMessageADialog(String title,String message){error=title+":"+message;}
    }
CLASSES
    static void check(boolean value){if(!value)throw new AssertionError();}
    public static void main(String[] args) {
        OriginalCredentials original=new OriginalCredentials();
        CleanCredentials clean=new CleanCredentials();
        original.onResult(true,200,"ok"); clean.onResult(true,200,"ok");
        FragmentTransaction a=original.activity.manager.transaction;
        FragmentTransaction b=clean.activity.manager.transaction;
        check(a.committed && b.committed);
        check(a.fragment.args.equals(b.fragment.args));
        check(b.fragment instanceof TwoFactorLoginFragment);
        check(b.fragment.args.get("user").equals("user@mail"));
        check(b.fragment.args.get("pass").equals("secret"));
        clean.onResult(false,403,"failed"); original.onResult(false,403,"failed");
        check(clean.error.equals(original.error));
        OriginalFactor oa=new OriginalFactor(); CleanFactor cb=new CleanFactor();
        oa.onResultFactor(true,200,"ok");cb.onResultFactor(true,200,"ok");
        check(oa.activity.manager.transaction.committed);
        check(cb.activity.manager.transaction.committed);
        check(oa.activity.manager.transaction.fragment instanceof PVrNBPiBYx);
        check(cb.activity.manager.transaction.fragment instanceof EcommerceHomeFragment);
        oa.onResultFactor(false,401,"expired");cb.onResultFactor(false,401,"expired");
        check(oa.error.equals(cb.error));
    }
}
'''.replace('CLASSES', '\n'.join(classes))
        with tempfile.TemporaryDirectory() as directory:
            source = Path(directory) / 'NavigationCheck.java'
            source.write_text(harness)
            subprocess.run(['javac', '-d', directory, str(source)], check=True,
                           capture_output=True, text=True)
            subprocess.run(['java', '-cp', directory, 'NavigationCheck'], check=True,
                           capture_output=True, text=True)
