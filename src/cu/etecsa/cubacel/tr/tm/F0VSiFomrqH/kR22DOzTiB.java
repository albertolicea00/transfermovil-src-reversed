package cu.etecsa.cubacel.tr.tm.F0VSiFomrqH;

import android.net.Uri;
import com.github.paolorotolo.appintro.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kR22DOzTiB {
    public EKB7Plln4L dictionaryCodePhone = new EKB7Plln4L();

    public String coding_message(String cadena) {
        String cadenaCode = BuildConfig.FLAVOR;
        boolean isValuesinNull = false;
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isDigit(cadena.charAt(i))) {
                if (i == 0 || !Character.isDigit(cadena.charAt(i - 1))) {
                    cadenaCode = cadenaCode + Uri.encode("#") + Character.toString(cadena.charAt(i));
                } else if (i + 1 == cadena.length() || !Character.isDigit(cadena.charAt(i + 1))) {
                    cadenaCode = cadenaCode + Character.toString(cadena.charAt(i)) + Uri.encode("#");
                } else {
                    cadenaCode = cadenaCode + Character.toString(cadena.charAt(i));
                }
            } else if (this.dictionaryCodePhone.getCode(Character.toString(cadena.charAt(i))) != null) {
                cadenaCode = cadenaCode + this.dictionaryCodePhone.getCode(Character.toString(cadena.charAt(i)));
            } else {
                isValuesinNull = true;
            }
        }
        if (!isValuesinNull) {
            return cadenaCode;
        }
        return "ERROR";
    }

    public List<String> getCodes(List<String> codes) {
        List<String> c_c = new ArrayList<>();
        for (String c : codes) {
            String letter = BuildConfig.FLAVOR;
            for (int i = 0; i < c.length(); i++) {
                letter = letter + this.dictionaryCodePhone.getCode(Character.toString(c.charAt(i)));
            }
            c_c.add(letter);
        }
        return c_c;
    }
}
