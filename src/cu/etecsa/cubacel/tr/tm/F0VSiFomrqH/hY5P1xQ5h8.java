package cu.etecsa.cubacel.tr.tm.F0VSiFomrqH;

import com.github.paolorotolo.appintro.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class hY5P1xQ5h8 {
    public boolean check_code_activation(String code, String version_number, String phone_number) {
        if (!code.contains(en_version(Integer.valueOf(Character.toString(code.charAt(0))).intValue(), version_number, phone_number))) {
            return false;
        }
        return true;
    }

    public String en_version(int random, String version_number, String aphone_number) {
        try {
            String phone_number = corregir_numero_telefonico(aphone_number);
            if (phone_number.contains("-1")) {
                return "-1";
            }
            String code = BuildConfig.FLAVOR;
            String phone_rotate = rotar_phone(phone_number, random);
            String pos_phone = Character.toString(phone_rotate.charAt(random));
            Integer.parseInt(pos_phone);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(random));
            try {
                sb.append(version_number);
                String version_complete = sb.toString();
                for (int i = 0; i < 8; i++) {
                    int n_version = Integer.parseInt(String.valueOf(version_complete.charAt(i)));
                    int n_phone = Integer.parseInt(String.valueOf(phone_rotate.charAt(i)));
                    int resto_absoluto = Math.abs(n_version - n_phone);
                    code = code + String.valueOf(resto_absoluto);
                }
                String valor = String.valueOf(random) + code;
                return valor.toString();
            } catch (Exception e) {
                ex = e;
            }
        } catch (Exception e2) {
            ex = e2;
        }
        return ex.getMessage();
    }

    public String corregir_numero_telefonico(String aphone_number) {
        if (aphone_number == null || aphone_number.isEmpty()) {
            return "-1";
        }
        if (aphone_number.startsWith("+")) {
            aphone_number = aphone_number.substring(1);
        }
        if (aphone_number.length() == 8) {
            String phone_number = aphone_number;
            return phone_number;
        }
        if (aphone_number.length() == 10) {
            String phone_number2 = aphone_number.substring(2);
            return phone_number2;
        }
        if (aphone_number.length() != 7) {
            return "-1";
        }
        String phone_number3 = "5" + aphone_number;
        return phone_number3;
    }

    public String rotar_phone(String phone, int n_rotate) {
        String telef_rotate = BuildConfig.FLAVOR;
        for (int i = n_rotate; i < phone.length(); i++) {
            telef_rotate = telef_rotate + Character.toString(phone.charAt(i));
        }
        for (int i2 = 0; i2 < n_rotate; i2++) {
            telef_rotate = telef_rotate + Character.toString(phone.charAt(i2));
        }
        return telef_rotate;
    }
}
