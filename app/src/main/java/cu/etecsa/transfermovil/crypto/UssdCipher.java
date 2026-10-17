package cu.etecsa.transfermovil.crypto;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8
 * @fingerprint Activation code generation/verification. Derives a 9-digit code from
 *              a random prefix, app version, and phone number using digit rotation
 *              and absolute difference per position.
 *
 * Algorithm:
 *   1. Normalize phone to 8 digits (strip +, country code)
 *   2. Rotate phone digits left by `random` positions
 *   3. Prepend `random` to version → 8-digit version string
 *   4. For each position i in [0..7]: abs(version[i] - rotatedPhone[i])
 *   5. Result = random + 8 absolute-diff digits
 */
public class UssdCipher {

    public boolean check_code_activation(String code, String version_number, String phone_number) {
        return code.contains(en_version(
                Integer.valueOf(Character.toString(code.charAt(0))).intValue(),
                version_number, phone_number));
    }

    public String en_version(int random, String version_number, String aphone_number) {
        try {
            String phone_number = corregir_numero_telefonico(aphone_number);
            if (phone_number.contains("-1")) {
                return "-1";
            }
            String code = "";
            String phone_rotate = rotar_phone(phone_number, random);
            String pos_phone = Character.toString(phone_rotate.charAt(random));
            Integer.parseInt(pos_phone);
            String version_complete = String.valueOf(random) + version_number;
            for (int i = 0; i < 8; i++) {
                int n_version = Integer.parseInt(String.valueOf(version_complete.charAt(i)));
                int n_phone = Integer.parseInt(String.valueOf(phone_rotate.charAt(i)));
                int resto_absoluto = Math.abs(n_version - n_phone);
                code = code + String.valueOf(resto_absoluto);
            }
            return String.valueOf(random) + code;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String corregir_numero_telefonico(String aphone_number) {
        if (aphone_number == null || aphone_number.isEmpty()) {
            return "-1";
        }
        if (aphone_number.startsWith("+")) {
            aphone_number = aphone_number.substring(1);
        }
        if (aphone_number.length() == 8) {
            return aphone_number;
        }
        if (aphone_number.length() == 10) {
            return aphone_number.substring(2);
        }
        if (aphone_number.length() == 7) {
            return "5" + aphone_number;
        }
        return "-1";
    }

    public String rotar_phone(String phone, int n_rotate) {
        String telef_rotate = "";
        for (int i = n_rotate; i < phone.length(); i++) {
            telef_rotate = telef_rotate + Character.toString(phone.charAt(i));
        }
        for (int i = 0; i < n_rotate; i++) {
            telef_rotate = telef_rotate + Character.toString(phone.charAt(i));
        }
        return telef_rotate;
    }
}
