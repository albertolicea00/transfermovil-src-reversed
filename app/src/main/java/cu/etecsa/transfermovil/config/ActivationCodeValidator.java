package cu.etecsa.transfermovil.config;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8
 * @fingerprint Validates agent activation codes using phone number rotation + version XOR.
 *              Algorithm: first digit of code is rotation index; phone number is rotated
 *              left by that amount; each digit of (random + version_number) is XOR'd
 *              (absolute difference) with corresponding digit of rotated phone.
 *              Result must appear in the submitted code.
 */
public class ActivationCodeValidator {

    public boolean check_code_activation(String code, String versionNumber, String phoneNumber) {
        return code.contains(
            en_version(
                Integer.valueOf(Character.toString(code.charAt(0))).intValue(),
                versionNumber,
                phoneNumber
            )
        );
    }

    public String en_version(int random, String versionNumber, String rawPhoneNumber) {
        try {
            String phoneNumber = corregir_numero_telefonico(rawPhoneNumber);
            if (phoneNumber.contains("-1")) {
                return "-1";
            }
            String code = "";
            String phoneRotate = rotar_phone(phoneNumber, random);
            String posPhone = Character.toString(phoneRotate.charAt(random));
            Integer.parseInt(posPhone);

            String versionComplete = String.valueOf(random) + versionNumber;
            for (int i = 0; i < 8; i++) {
                int nVersion = Integer.parseInt(String.valueOf(versionComplete.charAt(i)));
                int nPhone = Integer.parseInt(String.valueOf(phoneRotate.charAt(i)));
                int absoluteDiff = Math.abs(nVersion - nPhone);
                code = code + String.valueOf(absoluteDiff);
            }
            return String.valueOf(random) + code;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String corregir_numero_telefonico(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return "-1";
        }
        if (phoneNumber.startsWith("+")) {
            phoneNumber = phoneNumber.substring(1);
        }
        if (phoneNumber.length() == 8) {
            return phoneNumber;
        }
        if (phoneNumber.length() == 10) {
            return phoneNumber.substring(2);
        }
        if (phoneNumber.length() == 7) {
            return "5" + phoneNumber;
        }
        return "-1";
    }

    public String rotar_phone(String phone, int nRotate) {
        String rotated = "";
        for (int i = nRotate; i < phone.length(); i++) {
            rotated = rotated + Character.toString(phone.charAt(i));
        }
        for (int i = 0; i < nRotate; i++) {
            rotated = rotated + Character.toString(phone.charAt(i));
        }
        return rotated;
    }
}
