package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UaLAvTSm1e {
    private static UaLAvTSm1e instace;
    public String[] arrayAnios;
    public String[] diasDelMes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    public String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public String[] mesesNumeros = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    public static UaLAvTSm1e getIsntance() {
        if (instace == null) {
            instace = new UaLAvTSm1e();
        }
        return instace;
    }

    private UaLAvTSm1e() {
        llenarAnnos();
    }

    public void llenarAnnos() {
        List<String> anios = new ArrayList<>();
        int anoActual = Calendar.getInstance().get(1);
        for (int i = anoActual; i <= anoActual + 5; i++) {
            anios.add(String.valueOf(i));
        }
        this.arrayAnios = (String[]) anios.toArray(new String[0]);
    }
}
