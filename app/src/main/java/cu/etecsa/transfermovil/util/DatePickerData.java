package cu.etecsa.transfermovil.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UaLAvTSm1e
 * @fingerprint Singleton providing day/month/year arrays for date picker spinners.
 *              Years: current year → current year + 5.
 */
public class DatePickerData {
    private static DatePickerData instance;

    public String[] arrayAnios;

    public String[] diasDelMes = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
    };

    public String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public String[] mesesNumeros = {
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
    };

    public static DatePickerData getInstance() {
        if (instance == null) {
            instance = new DatePickerData();
        }
        return instance;
    }

    private DatePickerData() {
        llenarAnnos();
    }

    public void llenarAnnos() {
        List<String> anios = new ArrayList<>();
        int anoActual = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = anoActual; i <= anoActual + 5; i++) {
            anios.add(String.valueOf(i));
        }
        this.arrayAnios = anios.toArray(new String[0]);
    }
}
