package cu.etecsa.transfermovil.util;

import java.security.MessageDigest;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UkO3Y6TcHD
 * @fingerprint SHA-256 hash → hex string. Uses (b & 0xFF) + 256 trick for zero-padding.
 *              Spurious import of RecyclerView.ViewHolder.FLAG_TMP_DETACHED (value 256)
 *              used as the hex padding constant.
 */
public class Sha256Util {

    private Sha256Util() {
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
            stringBuffer.append(Integer.toString((b & 0xFF) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
