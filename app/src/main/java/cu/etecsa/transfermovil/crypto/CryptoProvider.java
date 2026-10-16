package cu.etecsa.transfermovil.crypto;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0
 * @fingerprint 7 AES schemes, hardcoded "ABCDEFGHIJKLMNOP", CryptoProvider inner class
 *
 * Central cryptographic utility. Contains 7 distinct encryption schemes ranging
 * from trivially broken (ECB + hardcoded key) to reasonable (PBKDF2 + random IV).
 * Used across the app for bank card decryption, data storage, and wallet operations.
 */
public class CryptoProvider {

    private static final String HEX_CHARS = "0123456789ABCDEF";

    // SECURITY: hardcoded key — trivially extractable from APK
    private static final String HARDCODED_AES_KEY = "ABCDEFGHIJKLMNOP";

    // SECURITY: hardcoded salt with only 2 iterations
    private static final String CARD_DECRYPTION_SALT = "1927271231";

    // ========================================================================
    // Scheme 1: AES/ECB with SHA1PRNG seed-based key (hex encoded)
    // Used by: encrypt(seed, cleartext) / decrypt(seed, encrypted)
    // Flaw: ECB mode leaks patterns; SHA1PRNG is deterministic when seeded
    // ========================================================================

    public static String encryptWithSeed(String seed, String cleartext) throws Exception {
        byte[] rawKey = deriveKeyViaSha1Prng(seed.getBytes());
        byte[] encrypted = aesEcbRaw(Cipher.ENCRYPT_MODE, rawKey, cleartext.getBytes());
        return bytesToHex(encrypted);
    }

    public static String decryptWithSeed(String seed, String hexCiphertext) throws Exception {
        byte[] rawKey = deriveKeyViaSha1Prng(seed.getBytes());
        byte[] decrypted = aesEcbRaw(Cipher.DECRYPT_MODE, rawKey, hexToBytes(hexCiphertext));
        return new String(decrypted);
    }

    /**
     * Derives a 128-bit AES key from seed using Apache Harmony's SHA1PRNG.
     * Deterministic: same seed always produces same key (cross-device reproducible).
     */
    private static byte[] deriveKeyViaSha1Prng(byte[] seed) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", new HarmonyCryptoProvider());
        sr.setSeed(seed);
        keyGen.init(128, sr);
        return keyGen.generateKey().getEncoded();
    }

    private static byte[] aesEcbRaw(int mode, byte[] key, byte[] input) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, keySpec);
        return cipher.doFinal(input);
    }

    // ========================================================================
    // Scheme 2: AES/ECB/PKCS5Padding with SecretKey (Base64 encoded)
    // Used by: encryptMsg(message, secret) / decryptMsg(cipherText, secret)
    // Flaw: ECB mode
    // ========================================================================

    public static String encryptMsg(String message, SecretKey secret) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        return Base64.encodeToString(cipher.doFinal(message.getBytes("UTF-8")), Base64.NO_WRAP);
    }

    public static String decryptMsg(String cipherText, SecretKey secret) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret);
        return new String(cipher.doFinal(Base64.decode(cipherText, Base64.NO_WRAP)), "UTF-8");
    }

    // ========================================================================
    // Scheme 3: AES/CBC/PKCS5PADDING with hardcoded key (key reused as IV)
    // Used by: encryptAES(plainText) / decryptAES(encryptedText)
    // Flaw: hardcoded key "ABCDEFGHIJKLMNOP", IV = key bytes
    // ========================================================================

    public static String encryptAesHardcoded(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            byte[] key = HARDCODED_AES_KEY.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec iv = new IvParameterSpec(key); // IV = key (!)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            return Base64.encodeToString(cipher.doFinal(plainText.getBytes("UTF8")), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static String decryptAesHardcoded(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            byte[] key = HARDCODED_AES_KEY.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec iv = new IvParameterSpec(key); // IV = key (!)
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.decode(encryptedText.getBytes("UTF8"), 0)), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    // ========================================================================
    // Scheme 4: AES/CBC/PKCS5PADDING with caller-provided key and IV
    // Used by: encryptAES(text, key, iv) / decryptAES(text, key, iv)
    // Security depends entirely on caller's key/IV management
    // ========================================================================

    public static String encryptAesCbc(String plainText, String keyData, String ivData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(keyData.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(ivData.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            return Base64.encodeToString(cipher.doFinal(plainText.getBytes("UTF8")), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static String encryptAesCbc(String plainText, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return Base64.encodeToString(cipher.doFinal(plainText.getBytes("UTF8")), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static String decryptAesCbc(String encryptedText, String keyData, String ivData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(keyData.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(ivData.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.decode(encryptedText.getBytes("UTF8"), 0)), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String decryptAesCbc(String encryptedText, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return new String(cipher.doFinal(Base64.decode(encryptedText.getBytes("UTF8"), 0)), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    // ========================================================================
    // Scheme 5: Card decryption — SHA-256 key derivation + custom PBKDF (2 iterations)
    // Used by: decryptCard(data, bankRef, deviceId)
    // Flaw: hardcoded salt "1927271231", only 2 iterations, custom PBKDF
    // ========================================================================

    /**
     * Decrypts bank card data. Key derived from SHA-256(bankRef + deviceId),
     * split into 16-byte password and 16-byte IV, then run through a custom
     * 2-iteration key derivation before AES/CBC/NoPadding decryption.
     *
     * @param data      Base64-encoded ciphertext
     * @param bankRef   bank reference string
     * @param deviceId  device identifier (typically IMEI or "12345678")
     * @return decrypted card data (alphanumeric only), or "" on error
     */
    public static String decryptCard(String data, String bankRef, String deviceId) {
        try {
            byte[] hash = sha256(( bankRef + deviceId).getBytes("UTF8"));
            byte[] password = new byte[16];
            byte[] vector = new byte[16];
            System.arraycopy(hash, 0, password, 0, 16);
            System.arraycopy(hash, 16, vector, 0, 16);

            byte[] derivedKey = deriveKeyCustomPbkdf(password, CARD_DECRYPTION_SALT.getBytes(StandardCharsets.US_ASCII), vector, 128, 2);
            byte[] decrypted = aesDecryptNoPadding(data, derivedKey, vector);

            StringBuilder result = new StringBuilder();
            for (byte b : decrypted) {
                result.append((char) (b >= 0 ? b : b + 256));
            }
            return new String(decrypted, StandardCharsets.UTF_8).replaceAll("[^A-Za-z0-9 ]", "");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Custom PBKDF: concat(previousHash, password, salt) → SHA-256, repeated.
     * Only 2 iterations — negligible brute-force resistance.
     */
    static byte[] deriveKeyCustomPbkdf(byte[] password, byte[] salt, byte[] iv, int keySize, int iterations) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] dx = new byte[0];
            for (int i = 0; i < iterations; i++) {
                byte[] combined = concat(concat(dx, password), salt);
                dx = md.digest(combined);
            }
            byte[] key = new byte[keySize / 8];
            System.arraycopy(dx, 0, key, 0, keySize / 8);
            return key;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] aesDecryptNoPadding(String base64Content, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        return cipher.doFinal(Base64.decode(base64Content, 0));
    }

    // ========================================================================
    // Scheme 6: Wallet encryption — PBKDF2WithHmacSHA1 + random IV (best scheme)
    // Used by: encryptWallet(plainText, password, salt, iterations)
    //          decryptWallet(encryptedText, password, salt, iterations)
    // IV is random 16 bytes, prepended to ciphertext
    // ========================================================================

    public static String encryptWallet(String plainText, String password, byte[] salt, int iterations) throws Exception {
        Object[] keyAndIv = generatePbkdf2KeyAndIv(password, salt, iterations, 128);
        SecretKey secretKey = (SecretKey) keyAndIv[0];
        byte[] ivBytes = (byte[]) keyAndIv[1];

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Prepend IV to ciphertext
        byte[] ivAndEncrypted = new byte[ivBytes.length + encrypted.length];
        System.arraycopy(ivBytes, 0, ivAndEncrypted, 0, ivBytes.length);
        System.arraycopy(encrypted, 0, ivAndEncrypted, ivBytes.length, encrypted.length);
        return Base64.encodeToString(ivAndEncrypted, 0);
    }

    public static String decryptWallet(String encryptedText, String password, byte[] salt, int iterations) throws Exception {
        byte[] ivAndEncrypted = Base64.decode(encryptedText, 0);
        byte[] ivBytes = new byte[16];
        byte[] encryptedBytes = new byte[ivAndEncrypted.length - 16];
        System.arraycopy(ivAndEncrypted, 0, ivBytes, 0, 16);
        System.arraycopy(ivAndEncrypted, 16, encryptedBytes, 0, encryptedBytes.length);

        Object[] keyAndIv = generatePbkdf2KeyAndIv(password, salt, iterations, 128);
        SecretKey secretKey = (SecretKey) keyAndIv[0];

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
        return new String(cipher.doFinal(encryptedBytes), "UTF-8");
    }

    private static Object[] generatePbkdf2KeyAndIv(String password, byte[] salt, int iterations, int keySize) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keySize);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();
        byte[] ivBytes = new byte[16];
        new SecureRandom().nextBytes(ivBytes);
        return new Object[]{new SecretKeySpec(keyBytes, "AES"), ivBytes};
    }

    // ========================================================================
    // Utilities
    // ========================================================================

    /** SHA-256 of key string → SecretKeySpec for AES. Used with cv constant. */
    public static SecretKey generateKey(String keyMaterial) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return new SecretKeySpec(sha256(keyMaterial), "AES");
    }

    public static byte[] sha256(String input) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(input.getBytes(StandardCharsets.US_ASCII));
    }

    public static byte[] sha256(byte[] input) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(input);
    }

    /** SHA-256 hash as Base64 string. */
    public static String sha256Base64(String data) {
        try {
            return Base64.encodeToString(sha256(data.getBytes("UTF8")), 0).trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static String bytesToHex(byte[] buf) {
        if (buf == null) return "";
        StringBuilder result = new StringBuilder(buf.length * 2);
        for (byte b : buf) {
            result.append(HEX_CHARS.charAt((b >> 4) & 0xF));
            result.append(HEX_CHARS.charAt(b & 0xF));
        }
        return result.toString();
    }

    public static byte[] hexToBytes(String hex) {
        int len = hex.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hex.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return result;
    }

    private static byte[] concat(byte[] a, byte[] b) {
        byte[] out = new byte[a.length + b.length];
        System.arraycopy(a, 0, out, 0, a.length);
        System.arraycopy(b, 0, out, a.length, b.length);
        return out;
    }

    /**
     * Registers Apache Harmony SHA1PRNG as security provider.
     * Used only by Scheme 1 for deterministic key generation from seed.
     */
    public static final class HarmonyCryptoProvider extends Provider {
        public HarmonyCryptoProvider() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }
}
