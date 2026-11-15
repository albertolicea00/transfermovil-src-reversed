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
            if name == 'WalletBoletoTabFragment':
                checks.append(f'compareBoleto(new Tab{index}Original(),new Tab{index}Clean(),"{name}");')
            elif name == 'WalletOperationsTabFragment':
                checks.append(f'compareOperations(new Tab{index}Original(),new Tab{index}Clean(),"{name}");')
            else:
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
    static class Recycler {
        vD9rc3MbTL adapter;
        BoletoManagementAdapter boletoAdapter;
        MenuAdapter menuAdapter;
        void setAdapter(vD9rc3MbTL value){adapter=value;}
        void setAdapter(BoletoManagementAdapter value){boletoAdapter=value;}
        void setAdapter(MenuAdapter value){menuAdapter=value;}
    }
    static class vD9rc3MbTL {
        List<WUULVgZq02> rows; Object listener;
        vD9rc3MbTL(Context context,List<WUULVgZq02> values){rows=values;}
        void setOnItemClickListener(Object value){listener=value;}
    }
    static class BoletoManagementAdapter {
        enum Action { REGISTER, CHANGE_PIN, DELETE_REGISTRATION, ASSOCIATE_CLASSIC_ACCOUNT }
        static final class MenuItem {
            final String title, subtitle; final int icon; final Action action;
            MenuItem(String title, String subtitle, int icon, Action action) {
                this.title = title; this.subtitle = subtitle; this.icon = icon; this.action = action;
            }
        }
        final List<MenuItem> rows; Object listener;
        BoletoManagementAdapter(List<MenuItem> rows) { this.rows = rows; }
        void setOnItemClickListener(Object value) { listener = value; }
    }
    enum Action { AUTHENTICATE, DISCONNECT }
    static final class MenuRow {
        final String title, subtitle; final int icon; final Action action;
        MenuRow(String title, String subtitle, int icon, Action action) {
            this.title = title; this.subtitle = subtitle; this.icon = icon; this.action = action;
        }
    }
    static final class MenuAdapter {
        final List<MenuRow> rows;
        MenuAdapter(List<MenuRow> rows) { this.rows = rows; }
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
    static FdonIAFI9w mapBoleto(BoletoManagementAdapter.Action action) {
        switch (action) {
            case REGISTER: return FdonIAFI9w.BOLSARegistrarse;
            case CHANGE_PIN: return FdonIAFI9w.BOLSACambioPin;
            case DELETE_REGISTRATION: return FdonIAFI9w.BOLSAEliminarRegistro;
            case ASSOCIATE_CLASSIC_ACCOUNT: return FdonIAFI9w.BOLSAAsociarCuenta;
            default: throw new AssertionError("Unknown action: "+action);
        }
    }
    static FdonIAFI9w mapOperation(Action action) {
        switch (action) {
            case AUTHENTICATE: return FdonIAFI9w.BOLSAAutenticarse;
            case DISCONNECT: return FdonIAFI9w.BOLSADesconectar;
            default: throw new AssertionError("Unknown action: "+action);
        }
    }
    static void compareBoleto(Base original,Base clean,String label) throws Exception {
        build(original);build(clean);
        List<WUULVgZq02> origRows=original.rvseguridad.adapter.rows;
        List<BoletoManagementAdapter.MenuItem> cleanRows=clean.rvseguridad.boletoAdapter.rows;
        equal(origRows.size(),cleanRows.size(),label+" count");
        for(int i=0;i<origRows.size();i++) {
            WUULVgZq02 a=origRows.get(i);
            BoletoManagementAdapter.MenuItem b=cleanRows.get(i);
            equal(a.titulo,b.title,label+" row "+i+" title");
            equal(a.subtitulo,b.subtitle,label+" row "+i+" subtitle");
            equal(a.icono,b.icon,label+" row "+i+" icon");
            equal(a.type,rBXnNc0Kx4.Post,label+" row "+i+" type");
            equal(a.operacion,mapBoleto(b.action),label+" row "+i+" action");
        }
        equal(clean.onItemClickListener,clean.rvseguridad.boletoAdapter.listener,label+" click listener");
        System.out.println(label+": "+cleanRows.size()+" rows");
    }
    static void compareOperations(Base original,Base clean,String label) throws Exception {
        build(original);build(clean);
        List<WUULVgZq02> origRows=original.rvseguridad.adapter.rows;
        List<MenuRow> cleanRows=clean.rvseguridad.menuAdapter.rows;
        equal(origRows.size(),cleanRows.size(),label+" count");
        for(int i=0;i<origRows.size();i++) {
            WUULVgZq02 a=origRows.get(i);
            MenuRow b=cleanRows.get(i);
            equal(a.titulo,b.title,label+" row "+i+" title");
            equal(a.subtitulo,b.subtitle,label+" row "+i+" subtitle");
            equal(a.icono,b.icon,label+" row "+i+" icon");
            equal(a.type,rBXnNc0Kx4.Post,label+" row "+i+" type");
            equal(a.operacion,mapOperation(b.action),label+" row "+i+" action");
        }
        System.out.println(label+": "+cleanRows.size()+" rows");
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
