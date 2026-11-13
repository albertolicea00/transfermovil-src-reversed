"""Compare five MiTransfer tab menu builders against JADX using JVM fixtures."""
import re
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

from scripts.tests.test_child_user_ui import extract_method

ROOT = Path(__file__).resolve().parents[2]
TABS = ROOT / 'app/src/main/java/cu/etecsa/transfermovil/banking/ui/tabs'


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class WalletTabMenuTest(unittest.TestCase):
    def test_order_labels_icons_types_and_operations_match_source(self):
        classes = []
        checks = []
        for index, name in enumerate(['AgentOperationsTabFragment', 'GeneralBankingTabFragment',
                                      'MainBankingTabFragment', 'WalletBoletoTabFragment',
                                      'WalletOperationsTabFragment']):
            clean = (TABS / (name + '.java')).read_text()
            raw_name = re.search(r'@obfuscated_class\s+([\w.]+)', clean)[1]
            source = (ROOT / 'src' / Path(*raw_name.split('.')).with_suffix('.java')).read_text()
            for suffix, text in [('Original', source), ('Clean', clean)]:
                method = extract_method(text, 'private void initData()')
                classes.append('static class Tab' + str(index) + suffix + ' extends Base {\n' + method + '\n}')
            checks.append(f'compare(new Tab{index}Original(),new Tab{index}Clean(),"{name}");')
        harness = '''
import java.util.List;
import java.util.ArrayList;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
public class MenuCheck {
    static class Context { String getString(int id){return "resource:"+id;} }
    static class Recycler { vD9rc3MbTL adapter; void setAdapter(vD9rc3MbTL value){adapter=value;} }
    static class vD9rc3MbTL {
        List<WUULVgZq02> rows; Object listener;
        vD9rc3MbTL(Context context,List<WUULVgZq02> values){rows=values;}
        void setOnItemClickListener(Object value){listener=value;}
    }
    static class Base {
        Context context=new Context(); Recycler rvseguridad=new Recycler(); Object onItemClickListener=new Object();
        String getString(int id){return context.getString(id);}
    }
CLASSES
    static void equal(Object a,Object b,String label){
        if(!java.util.Objects.equals(a,b)) throw new AssertionError(label+": "+a+" != "+b);
    }
    static void build(Base value) throws Exception {
        java.lang.reflect.Method init=value.getClass().getDeclaredMethod("initData");init.setAccessible(true);init.invoke(value);
    }
    static void compare(Base original,Base clean,String label) throws Exception {
        build(original);build(clean);
        equal(original.rvseguridad.adapter.rows.size(),clean.rvseguridad.adapter.rows.size(),label+" count");
        for(int i=0;i<original.rvseguridad.adapter.rows.size();i++) {
            Object a=original.rvseguridad.adapter.rows.get(i),b=clean.rvseguridad.adapter.rows.get(i);
            for(java.lang.reflect.Field field:WUULVgZq02.class.getFields()) equal(field.get(a),field.get(b),label+" row "+i+" "+field.getName());
        }
        equal(clean.onItemClickListener,clean.rvseguridad.adapter.listener,label+" click listener");
        System.out.println(label+": "+clean.rvseguridad.adapter.rows.size()+" rows");
    }
    public static void main(String[] args) throws Exception { CHECKS }
}
'''.replace('CLASSES', '\n'.join(classes)).replace('CHECKS', '\n'.join(checks))
        source_paths = [ROOT / 'src' / path for path in [
            'cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/FdonIAFI9w.java',
            'cu/etecsa/cubacel/tr/tm/B21UyndcVvF/WUULVgZq02.java',
            'cu/etecsa/cubacel/tr/tm/B21UyndcVvF/XPH60zChinL/rBXnNc0Kx4.java',
        ]]
        with tempfile.TemporaryDirectory() as directory:
            resource = Path(directory) / 'R.java'
            resource_source = (ROOT / 'src/cu/etecsa/cubacel/tr/tm/R.java').read_text()
            resource.write_text('package cu.etecsa.cubacel.tr.tm; public final class R {\n' +
                                extract_method(resource_source, 'public static final class string') + '\n' +
                                extract_method(resource_source, 'public static final class drawable') + '\n}')
            main = Path(directory) / 'MenuCheck.java' 
            main.write_text(harness)
            compiled = subprocess.run(['javac', '-d', directory, str(main), str(resource), *map(str, source_paths)],
                                      capture_output=True, text=True)
            self.assertEqual(0, compiled.returncode, compiled.stderr)
            run = subprocess.run(['java', '-cp', directory, 'MenuCheck'], capture_output=True, text=True)
            self.assertEqual(0, run.returncode, run.stderr)
            self.assertEqual(5, len(run.stdout.splitlines()))
