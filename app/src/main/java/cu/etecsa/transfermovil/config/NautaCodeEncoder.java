package cu.etecsa.transfermovil.config;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB
 * @fingerprint Encodes non-numeric strings (e.g. Nauta email addresses) into digit-only
 *              sequences suitable for USSD transmission. Digits within the input are
 *              delimited by URI-encoded '#' markers. Non-digit characters are replaced
 *              with their 2-digit code from CharacterCodeDictionary (EKB7Plln4L).
 *              Returns "ERROR" if any character has no dictionary mapping.
 */
public class NautaCodeEncoder {
    public CharacterCodeDictionary dictionaryCodePhone = new CharacterCodeDictionary();

    public String coding_message(String cadena) {
        String cadenaCode = "";
        boolean hasUnmappedChar = false;
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
                hasUnmappedChar = true;
            }
        }
        if (!hasUnmappedChar) {
            return cadenaCode;
        }
        return "ERROR";
    }

    public List<String> getCodes(List<String> codes) {
        List<String> encodedCodes = new ArrayList<>();
        for (String c : codes) {
            String encoded = "";
            for (int i = 0; i < c.length(); i++) {
                encoded = encoded + this.dictionaryCodePhone.getCode(Character.toString(c.charAt(i)));
            }
            encodedCodes.add(encoded);
        }
        return encodedCodes;
    }
}
