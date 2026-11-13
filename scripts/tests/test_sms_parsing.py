"""Literal SMS labels and smali-backed MiBoleto catalog failure boundaries."""
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

from scripts.tests.test_child_user_ui import extract_method

ROOT = Path(__file__).resolve().parents[2]
RAW = ROOT / 'src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/g0xM9kQCsqu.java'
CLEAN = ROOT / 'app/src/main/java/cu/etecsa/transfermovil/sms/SmsParser.java'


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class SmsParsingTest(unittest.TestCase):
    def test_literal_labels_and_offer_batch_failures(self):
        raw, clean = RAW.read_text(), CLEAN.read_text()
        signatures = ['public static String getElement(', 'public static String getElementLine(']
        original = '\n'.join(extract_method(raw, signature) for signature in signatures)
        restored = '\n'.join(extract_method(clean, signature) for signature in signatures)
        restored += '\n' + extract_method(clean, 'private void procesarListadoOfertas(')
        restored += '\n' + extract_method(clean, 'private boolean esIdTmValido(')
        harness = r'''
import java.util.*;
public class SmsCheck {
    static List<String> events=new ArrayList<>();
    static class Log {
        static void e(String tag,String value){events.add("error:"+tag);}
        static void e(String tag,String value,Throwable error){events.add("error:"+tag);}
        static void i(String tag,String value){events.add("ok:"+tag);}
    }
    static class TicketOffer {
        String id,name,currency,range; double price;int days,count;long control;Date date;
        void setId(String v){id=v;} void setNombre(String v){name=v;} void setFecha(Date v){date=v;}
        void setFechaOferta(String v){range=v;} void setValidDays(int v){days=v;}
        void setCantPersona(int v){count=v;} void setId_control(long v){control=v;}
        long getId_control(){return control;} void setPrecio(double v){price=v;}
        void setMoneda(String v){currency=v;}
    }
    static class DatabaseHelper {
        static DatabaseHelper instance=new DatabaseHelper();
        static List<TicketOffer> previous=new ArrayList<>(),added=new ArrayList<>();
        static boolean failLookup,failWrite;
        static DatabaseHelper getInstance(){return instance;}
        List<TicketOffer> getAllOfertasmiBoletoOrderBy(){
            if(failLookup)throw new IllegalStateException("lookup");return previous;
        }
        void deleteOfertasWithIdTmLess(long value){events.add("delete:"+value);}
        void addOfertasMiBoleto(TicketOffer value){
            if(failWrite)throw new IllegalStateException("write");added.add(value);events.add("add:"+value.id);
        }
    }
    static class Original { ORIGINAL }
    static class Restored { RESTORED }
    static void helpers() {
        String[][] cases={{"Id_tm:","Id_tm: 123\nnext"},{"[id]:","[id]: 456 CUP"},
            {"missing","abcdef ghij"},{"x:","x:  value with spaces\nnext"},
            {"x:","x:"},{null,"text"},{"x:",null},{"x:","before\nx: one\r\nrest"}};
        for(String[] item:cases) {
            if(!Objects.equals(Original.getElement(item[0],item[1]),Restored.getElement(item[0],item[1])))
                throw new AssertionError(Arrays.toString(item));
            if(!Objects.equals(Original.getElementLine(item[0],item[1]),Restored.getElementLine(item[0],item[1])))
                throw new AssertionError(Arrays.toString(item));
        }
        if(!"456".equals(Restored.getElement("[id]:","[id]: 456 CUP")))throw new AssertionError("literal prefix");
        if(Restored.getElementLine("absent","no label")!=null)throw new AssertionError("missing line");
    }
    static void reset(){events.clear();DatabaseHelper.previous.clear();DatabaseHelper.added.clear();
        DatabaseHelper.failLookup=false;DatabaseHelper.failWrite=false;}
    static void batch(String rows,String... expected) {
        new Restored().procesarListadoOfertas("Id_tm: 10\nCodigo;Nombre;Precio;Moneda;Fecha;Plazo;Cantidad\n"+rows,new Date(1));
        if(!events.equals(Arrays.asList(expected)))throw new AssertionError(rows+" got "+events);
    }
    public static void main(String[] args) {
        helpers();reset();
        String good="A; Offer ; 12.5 ; CUP ;01/01/2026;3;2";
        batch(good,"delete:10","add:A","ok:Ofertas");
        TicketOffer offer=DatabaseHelper.added.get(0);
        if(!"Offer".equals(offer.name)||offer.price!=12.5||offer.days!=3||offer.count!=2
           ||offer.control!=10||!"CUP".equals(offer.currency)||!new Date(1).equals(offer.date))
            throw new AssertionError("offer fields");
        reset();batch("X;bad;invalid;CUP;date;0;1|"+good,"delete:10","error:Ofertas","add:A","ok:Ofertas");
        reset();batch("X;bad;1;CUP;date;invalid;1|"+good,"delete:10","error:Ofertas");
        reset();batch("too;short|"+good,"delete:10","error:Ofertas","add:A","ok:Ofertas");
        reset();DatabaseHelper.failLookup=true;batch(good,"error:Ofertas");
        reset();DatabaseHelper.failWrite=true;batch(good,"delete:10","error:Ofertas");
        reset();TicketOffer old=new TicketOffer();old.control=11;DatabaseHelper.previous.add(old);batch(good);
        reset();old.control=10;DatabaseHelper.previous.add(old);batch(good,"delete:10","add:A","ok:Ofertas");
        reset();try{new Restored().procesarListadoOfertas("Id_tm: invalid",new Date());
            throw new AssertionError("invalid id must propagate");}catch(NumberFormatException expected){}
    }
}
'''.replace('ORIGINAL', original).replace('RESTORED', restored)
        with tempfile.TemporaryDirectory() as directory:
            path = Path(directory) / 'SmsCheck.java'
            path.write_text(harness)
            build = subprocess.run(['javac', '-d', directory, str(path)], capture_output=True, text=True)
            self.assertEqual(0, build.returncode, build.stderr)
            run = subprocess.run(['java', '-cp', directory, 'SmsCheck'], capture_output=True, text=True)
            self.assertEqual(0, run.returncode, run.stderr)
