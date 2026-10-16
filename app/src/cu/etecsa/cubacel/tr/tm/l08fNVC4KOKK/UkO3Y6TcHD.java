package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import androidx.recyclerview.widget.RecyclerView;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class UkO3Y6TcHD {
    private UkO3Y6TcHD() {
    }

    public static String generateSHA256(String message) {
        return hashString(message, "SHA-256");
    }

    private static String hashString(String message, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
            return convertByteArrayToHexString(hashedBytes);
        } catch (Exception e) {
            return null;
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : arrayBytes) {
            stringBuffer.append(Integer.toString((b & 255) + RecyclerView.ViewHolder.FLAG_TMP_DETACHED, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
