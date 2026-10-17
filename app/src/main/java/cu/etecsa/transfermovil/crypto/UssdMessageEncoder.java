package cu.etecsa.transfermovil.crypto;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB
 * @fingerprint Encodes text messages into numeric USSD-safe strings using UssdCharDictionary.
 *              Digit runs are preserved as-is, delimited by URI-encoded '#' markers.
 *              Non-digit characters are replaced by their 2-digit dictionary codes.
 *              Returns "ERROR" if any character has no dictionary mapping.
 */
public class UssdMessageEncoder {

    public UssdCharDictionary dictionaryCodePhone = new UssdCharDictionary();

    public String coding_message(String cadena) {
        String cadenaCode = "";
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
            String letter = "";
            for (int i = 0; i < c.length(); i++) {
                letter = letter + this.dictionaryCodePhone.getCode(Character.toString(c.charAt(i)));
            }
            c_c.add(letter);
        }
        return c_c;
    }
}
