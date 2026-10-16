package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.util.Base64;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class V5FFEZ0Qrr0 {
    private static final String AES = "AES";
    private static final String HEX = "0123456789ABCDEF";
    private static final String UTF8 = "UTF-8";
    private static final String aesEncryptionAlgorithem = "AES";
    private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
    private static final String encryptionKey = "ABCDEFGHIJKLMNOP";

    public static byte[] shKey(String a) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[0];
        byte[] message = a.getBytes(StandardCharsets.US_ASCII);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(message);
        return digest;
    }

    public static byte[] shKey(byte[] message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(message);
        return digest;
    }

    public static SecretKey generateKey(String ky) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return new SecretKeySpec(shKey(ky), "AES");
    }

    public static String encryptMsg(String message, SecretKey secret) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secret);
        byte[] cipherText = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.encodeToString(cipherText, 2);
    }

    public static String decryptMsg(String cipherText, SecretKey secret) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secret);
        byte[] decode = Base64.decode(cipherText, 2);
        String decryptString = new String(cipher.doFinal(decode), "UTF-8");
        return decryptString;
    }

    public static String encrypt(String seed, String cleartext) throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes());
        return toHex(result);
    }

    public static String decrypt(String seed, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result);
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", new CryptoProvider());
        sr.setSeed(seed);
        kgen.init(RecyclerView.ViewHolder.FLAG_IGNORE, sr);
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return raw;
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    public static String fromHex(String hex) {
        return new String(toByte(hex));
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer result = new StringBuffer(buf.length * 2);
        for (byte b : buf) {
            appendHex(result, b);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 15));
        sb.append(HEX.charAt(b & 15));
    }

    public static final class CryptoProvider extends Provider {
        public CryptoProvider() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    public static String cH(String data, String a, String b) {
        try {
            String k = a + b;
            byte[] r = shKey(k.getBytes("UTF8"));
            byte[] password = new byte[16];
            byte[] vector = new byte[16];
            for (int i = 0; i < 16; i++) {
                password[i] = r[i];
                vector[i] = r[i + 16];
            }
            String valor = procesarDatos(data, password, vector);
            return valor;
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String procesarDatos(String data, byte[] pass, byte[] vector) {
        try {
            return decryptTarjeta(data, pass, "1927271231", vector);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (InvalidParameterSpecException e5) {
            e5.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
            return BuildConfig.FLAVOR;
        } catch (NoSuchPaddingException e8) {
            e8.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String decryptTarjeta(String textoCifrado, byte[] password, String salt, byte[] vector) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        int PasswordIterations = 2;
        byte[] bArr = new byte[0];
        byte[] llaveDerivada = DeriveKeyAndIv(password, salt.getBytes(StandardCharsets.US_ASCII), vector, RecyclerView.ViewHolder.FLAG_IGNORE, 2);
        String llaveValor = Base64.encodeToString(llaveDerivada, 0);
        llaveValor.getBytes(StandardCharsets.UTF_8);
        byte[] valueDcry = aesDecry(textoCifrado, llaveDerivada, vector);
        int length = valueDcry.length;
        String cadena = BuildConfig.FLAVOR;
        int i = 0;
        while (i < length) {
            byte uyh0pxs9m37in = valueDcry[i];
            int valorInt = uyh0pxs9m37in >= 0 ? uyh0pxs9m37in : uyh0pxs9m37in + 256;
            int PasswordIterations2 = PasswordIterations;
            char valor = (char) valorInt;
            cadena = cadena + valor;
            i++;
            PasswordIterations = PasswordIterations2;
        }
        try {
            Base64.encodeToString(valueDcry, 0);
        } catch (Exception e) {
        }
        try {
            Base64.encodeToString(valueDcry, 0);
        } catch (Exception e2) {
        }
        String valueStr = new String(valueDcry, StandardCharsets.UTF_8);
        new String(valueStr.getBytes(StandardCharsets.US_ASCII), "UTF-8");
        String result = valueStr.replaceAll("[^A-Za-z0-9 ]", BuildConfig.FLAVOR);
        return result;
    }

    public static void validarLLaveDerivada() throws NoSuchAlgorithmException {
        String k = "Referencia001delbanco312345678";
        byte[] r = new byte[0];
        try {
            r = shKey(k);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] password = new byte[16];
        byte[] vector = new byte[16];
        for (int i = 0; i < 16; i++) {
            password[i] = r[i];
            vector[i] = r[i + 16];
        }
        int i2 = password.length;
        byte[] dataset = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            char c = (char) password[i3];
            dataset[i3] = (byte) c;
        }
        Base64.encodeToString(r, 0);
        Base64.encodeToString(password, 0);
        Base64.encodeToString(vector, 0);
        try {
            try {
                new String(password, "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
        }
        "1927271231".getBytes(StandardCharsets.US_ASCII);
    }

    public static byte[] aesDecry(String content, byte[] key, byte[] vector) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] contentByte = Base64.decode(content, 0);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(vector);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, keySpec, ivSpec);
        byte[] result = cipher.doFinal(contentByte);
        return result;
    }

    public static byte[] DeriveKeyAndIv(byte[] passphrase, byte[] salt, byte[] initialvect, int keySize, int PasswordIterations) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] key = new byte[keySize / 8];
            byte[] dx = new byte[0];
            byte[] salted = new byte[0];
            byte[] bArr = new byte[0];
            Base64.encodeToString(key, 0);
            Base64.encodeToString(dx, 0);
            Base64.encodeToString(salted, 0);
            Base64.encodeToString(passphrase, 0);
            for (int i = 0; i < PasswordIterations; i++) {
                try {
                    byte[] aux = Concat(dx, passphrase);
                    try {
                        byte[] dx2 = Concat(aux, salt);
                        Base64.encodeToString(dx2, 0);
                        dx = md.digest(dx2);
                        Base64.encodeToString(dx, 0);
                    } catch (Exception e) {
                        ex = e;
                        ex.printStackTrace();
                        return null;
                    }
                } catch (Exception e2) {
                    ex = e2;
                    ex.printStackTrace();
                    return null;
                }
            }
            Base64.encodeToString(dx, 0);
            int maxCopy = keySize / 8;
            for (int i2 = 0; i2 < maxCopy; i2++) {
                key[i2] = dx[i2];
            }
            return key;
        } catch (Exception e3) {
            ex = e3;
        }
    }

    private static byte[] Concat(String a, byte[] b) {
        try {
            return Concat(a.getBytes("UTF8"), b);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] Concat(byte[] a, byte[] b) {
        byte[] output = new byte[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            output[a.length + j] = b[j];
        }
        return output;
    }

    public static String getSha256(String data) {
        String x = BuildConfig.FLAVOR;
        try {
            byte[] r = shKey(data.getBytes("UTF8"));
            x = Base64.encodeToString(r, 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return x.trim();
    }

    public static byte[] aesPKCDecry(byte[] contentByte, byte[] key, byte[] vector) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(vector);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, keySpec, ivSpec);
        byte[] result = cipher.doFinal(contentByte);
        return result;
    }

    public static String encryptAES(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(1, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedText = Base64.encodeToString(cipherText, 0);
            return encryptedText;
        } catch (Exception E) {
            System.err.println("Encrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String decryptAES(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(2, secretKey, ivparameterspec);
            byte[] cipherText = Base64.decode(encryptedText.getBytes("UTF8"), 0);
            String decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
            return decryptedText;
        } catch (Exception E) {
            System.err.println("decrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String encryptAES(String plainText, String keyData, String ivData) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = keyData.getBytes("UTF-8");
            byte[] iv = ivData.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
            cipher.init(1, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedText = Base64.encodeToString(cipherText, 0);
            return encryptedText;
        } catch (Exception E) {
            System.err.println("Encrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String encryptAES(String plainText, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
            cipher.init(1, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedText = Base64.encodeToString(cipherText, 0);
            return encryptedText;
        } catch (Exception E) {
            System.err.println("Encrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String decryptAES(String encryptedText, String keyData, String ivData) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = keyData.getBytes("UTF-8");
            byte[] iv = ivData.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
            cipher.init(2, secretKey, ivparameterspec);
            byte[] cipherText = Base64.decode(encryptedText.getBytes("UTF8"), 0);
            String decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
            return decryptedText;
        } catch (Exception E) {
            System.err.println("decrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String decryptAES(String encryptedText, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
            cipher.init(2, secretKey, ivparameterspec);
            byte[] cipherText = Base64.decode(encryptedText.getBytes("UTF8"), 0);
            String decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
            return decryptedText;
        } catch (Exception E) {
            System.err.println("decrypt Exception : " + E.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static Object[] generateKeyAndIV(String password, byte[] salt, int iterations, int keySize) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keySize);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey tmp = factory.generateSecret(spec);
        byte[] keyBytes = tmp.getEncoded();
        byte[] ivBytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        return new Object[]{secretKey, ivBytes};
    }

    public static String encryptIA(String plainText, String password, byte[] salt, int iterations) throws Exception {
        Object[] keyAndIV = generateKeyAndIV(password, salt, iterations, RecyclerView.ViewHolder.FLAG_IGNORE);
        SecretKey secretKey = (SecretKey) keyAndIV[0];
        byte[] ivBytes = (byte[]) keyAndIV[1];
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKey, new IvParameterSpec(ivBytes));
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        byte[] ivAndEncrypted = new byte[ivBytes.length + encryptedBytes.length];
        System.arraycopy(ivBytes, 0, ivAndEncrypted, 0, ivBytes.length);
        System.arraycopy(encryptedBytes, 0, ivAndEncrypted, ivBytes.length, encryptedBytes.length);
        return Base64.encodeToString(ivAndEncrypted, 0);
    }

    public static String decryptMonedasWallet(String encryptedText, String password, byte[] salt, int iterations) throws Exception {
        byte[] ivAndEncrypted = Base64.decode(encryptedText, 0);
        byte[] ivBytes = new byte[16];
        byte[] encryptedBytes = new byte[ivAndEncrypted.length - 16];
        System.arraycopy(ivAndEncrypted, 0, ivBytes, 0, 16);
        System.arraycopy(ivAndEncrypted, 16, encryptedBytes, 0, encryptedBytes.length);
        Object[] keyAndIV = generateKeyAndIV(password, salt, iterations, RecyclerView.ViewHolder.FLAG_IGNORE);
        SecretKey secretKey = (SecretKey) keyAndIV[0];
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(ivBytes));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, "UTF-8");
    }
}
