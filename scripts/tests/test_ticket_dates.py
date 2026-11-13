"""Exercise the recovered MiBoleto date callback against APK-smali branch cases."""
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

from scripts.tests.test_child_user_ui import extract_method

ROOT = Path(__file__).resolve().parents[2]
SOURCE = ROOT / 'app/src/main/java/cu/etecsa/transfermovil/ui/fragment/MiBoletoPurchaseFragment.java'


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class TicketDateTest(unittest.TestCase):
    def test_ranges_cutoffs_failures_and_early_returns(self):
        method = extract_method(SOURCE.read_text(), 'private void fechaConfig(')
        # Only freeze Calendar reads; retain the production callback statements.
        method = method.replace('Calendar.getInstance()', 'clock()')
        harness = r'''
import java.util.*;
import java.text.*;
public class DateCheck {
    static Calendar clock() {
        Calendar value=Calendar.getInstance(); value.clear(); value.set(2026,0,10,12,34,56); return value;
    }
    static class View {
        interface OnClickListener { void onClick(View value); }
        OnClickListener listener;
        void setInputType(int value){} void setText(String value){} void setVisibility(int value){}
        void setOnClickListener(OnClickListener value){listener=value;}
    }
    static class DatePicker {
        long min=-1,max=-1;
        void setMinDate(long value){min=value;} void setMaxDate(long value){max=value;}
    }
    static class DatePickerDialog {
        interface OnDateSetListener {void onDateSet(DatePicker picker,int year,int month,int day);}
        DatePicker picker=new DatePicker(); boolean shown;
        DatePickerDialog(Object context,OnDateSetListener listener,int year,int month,int day){}
        DatePicker getDatePicker(){return picker;}
        void updateDate(int year,int month,int day){}
        void show(){shown=true;}
    }
    static class Offer {
        String dates;int days; Offer(String dates,int days){this.dates=dates;this.days=days;}
        String getFechaOferta(){return dates;} int getValidDays(){return days;}
    }
    static class Toast {
        static String message;
        static Toast makeText(Object context,String text,int duration){message=text;return new Toast();}
        void show(){}
    }
    static class Log {static int errors;static void e(String tag,String value){errors++;}}
    static class MiBoletoPurchaseFragment {
        View txFecha=new View(),txIntervaloFechas=new View();Object context=new Object();
        Offer ofertaActual;DatePickerDialog fIniciodatePicker;String fechaInicio;int fallback;
        void configurarFechasPorDefecto(int sum){fallback++;}
        METHOD
    }
    static void check(String dates,int days,String min,String max,boolean shown,int fallback,int errors,String toast) {
        MiBoletoPurchaseFragment screen=new MiBoletoPurchaseFragment();
        screen.ofertaActual=new Offer(dates,days);Toast.message=null;Log.errors=0;
        screen.fechaConfig(0);screen.txFecha.listener.onClick(screen.txFecha);
        DatePickerDialog dialog=screen.fIniciodatePicker;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String actualMin=dialog.picker.min<0?null:format.format(new Date(dialog.picker.min));
        String actualMax=dialog.picker.max<0?null:format.format(new Date(dialog.picker.max));
        if(!Objects.equals(min,actualMin)||!Objects.equals(max,actualMax)||shown!=dialog.shown
           ||fallback!=screen.fallback||errors!=Log.errors||!Objects.equals(toast,Toast.message))
            throw new AssertionError(dates+" days="+days+" got="+actualMin+","+actualMax+","+dialog.shown
                +","+screen.fallback+","+Log.errors+","+Toast.message);
    }
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        check("-",0,null,null,true,1,0,null);
        check("01/01/2026-01/30/2026",0,"2026-01-10","2026-01-30",true,0,0,null);
        check("01/01/2026-01/30/2026",3,"2026-01-13","2026-01-30",true,0,0,null);
        check("01/20/2026-01/30/2026",3,"2026-01-20","2026-01-30",true,0,0,null);
        check("01/01/2026-01/12/2026",3,null,null,false,0,0,"No hay fechas disponibles para esta oferta");
        check("01/13/2026",3,null,null,false,1,0,"Esta fecha ya no está disponible para compra");
        check("01/14/2026",3,"2026-01-14","2026-01-14",true,0,0,null);
        check("01/09/2026",0,"2026-01-09","2026-01-09",true,0,0,null);
        check("junk",0,null,null,true,1,1,null);
        check("01/01/2026-01/02/2026-extra",0,null,null,true,0,0,null);
        check("02/30/2026",0,"2026-03-02","2026-03-02",true,0,0,null);
    }
}
'''.replace('METHOD', method)
        with tempfile.TemporaryDirectory() as directory:
            source = Path(directory) / 'DateCheck.java'
            source.write_text(harness)
            build = subprocess.run(['javac', '-d', directory, str(source)], capture_output=True, text=True)
            self.assertEqual(0, build.returncode, build.stderr)
            run = subprocess.run(['java', '-cp', directory, 'DateCheck'], capture_output=True, text=True)
            self.assertEqual(0, run.returncode, run.stderr)
