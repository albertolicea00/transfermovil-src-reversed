package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.ho8G382dwNt;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class fHZ2PXN4o9 {
    public String convertData(String data) {
        try {
            String randomData = getRandomString();
            String key1ToCadena = encHash(randomData);
            String hashDato = encHash(data);
            String dato = encryption(key1ToCadena, data);
            return key1ToCadena + hashDato + dato;
        } catch (Exception e) {
            return null;
        }
    }

    public String invertData(String dataEnc) {
        try {
            String key1ToCadena = dataEnc.substring(0, RecyclerView.ViewHolder.FLAG_IGNORE);
            String hashData = dataEnc.substring(RecyclerView.ViewHolder.FLAG_IGNORE, RecyclerView.ViewHolder.FLAG_TMP_DETACHED);
            String info = dataEnc.substring(RecyclerView.ViewHolder.FLAG_TMP_DETACHED);
            String dataPure = decryption(key1ToCadena, info);
            if (compareHash(hashData, dataPure)) {
                return dataPure;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean compareHash(String hash, String dataPure) {
        String dataOrigin = encHash(dataPure);
        if (hash.equals(dataOrigin)) {
            return true;
        }
        return false;
    }

    public String getRandomString() {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(20);
        for (int i = 0; i < 20; i++) {
            int randomLimitedInt = ((int) (random.nextFloat() * ((122 - 97) + 1))) + 97;
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    private String encHash(String data) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest(data.getBytes());
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + RecyclerView.ViewHolder.FLAG_TMP_DETACHED, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String cadena = sb.toString();
        return cadena;
    }

    public String encryption(String cv, String strNormalText) {
        try {
            SecretKey k = V5FFEZ0Qrr0.generateKey(cv);
            String normalTextEnc = V5FFEZ0Qrr0.encryptMsg(strNormalText, k);
            return normalTextEnc;
        } catch (Exception ex) {
            Log.d("ERROR", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String decryption(String cv, String strEncryptedText) {
        try {
            SecretKey k = V5FFEZ0Qrr0.generateKey(cv);
            String strDecryptedText = V5FFEZ0Qrr0.decryptMsg(strEncryptedText, k);
            return strDecryptedText;
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }
}
