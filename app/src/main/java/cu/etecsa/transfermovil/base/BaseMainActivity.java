package cu.etecsa.transfermovil.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsMessage;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.SecretKey;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN
 * @fingerprint Base activity for both Agent and General modes (1158 lines).
 *              Contains: USSD code dispatch (6 actionCallUSSD overloads), USSD parameter encoding
 *              (code() method using UssdCipherOrchestrator), AES encryption/decryption via CryptoProvider,
 *              CSV import/export, SMS BroadcastReceiver for PAGOxMOVIL, APK update download,
 *              bank PIN storage (encrypted with hardcoded key cv).
 *
 * @security cv = "708091521823824654864548452244" — hardcoded AES key for bank PIN encryption.
 * @security code_version = "372653282298718711" — USSD encoding version identifier.
 * @security crude_code — 1024-char binary substitution table for USSD param encoding.
 * @security DownloadNewVersion uses plain HTTP: http://www.etecsa.cu/descargas/transfermovil/
 * @security mReceivedSMSReceiver processes raw PDUs without validation.
 *
 * Dependencies (obfuscated → clean):
 *   - V5FFEZ0Qrr0 → CryptoProvider (generateKey, encryptMsg, decryptMsg)
 *   - Tz34gww2TFwrsuT8ukpL → UssdCipherOrchestrator
 *   - unYp8VQThY → DatabaseHelper
 *   - g0xM9kQCsqu → SmsParser
 *   - HzjedYqYeh → SmsSender
 *   - rIgmgP6JXL → SmsMessage (app POJO)
 *   - Fr52O1uSYF → SharedPreferencesAccessor
 *   - kR22DOzTiB → NautaCodeEncoder
 *   - LZkPyWnV4b → CsvExportTask
 *   - b9Y4DfRgnv → EntityType enum (Todos, Clientes, Pines, etc.)
 *   - R1sDOSqZ2z → BankType enum
 *   - KYTjPlWScT → AgentSource enum
 */
public class BaseMainActivity extends AppCompatActivity {

    public static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    public static final int NOTIFICATION_ID_RECEIVED = 4641;

    public static String code_version = "372653282298718711";
    public static String cv = "708091521823824654864548452244";

    public ProgressDialog bar;
    public Context contextoFile;
    public boolean fileImport = false;

    public String crude_code = "10000110101100011000100100100000110010001100000011100010100110010001010010100010111110001100010000011000010101100000000110001100101010100100011000000101110001100001100010001011110001100010100001000110000001101000101001001101001000001000010001100100011010010111001000110011110010001001100001000100000010000111001000110000101110100001111110011000001000110010000111110001100001111111000110011000101001100101000110001000111100011000101011101011111100111010100010111101000110000110011000110011100011000100111000101000011100010100111000011101100011000010101010000010101000100010100011001010101101000110001011101100011001001101101001111100011000000100010001100100010110101000110110000110000101000100011000000010100000010010001101011011100010110001110001001011100000110110001100001000011001011010100101100010001100100011110100011000011000110001100101010110101011110001100010000101000110001001101010010001001110001000010110110001100100111010001101101000110010010110001000110101000011110110000011101000110001001001100100010010000001111000110010011101110001100000001011000110000100011001111101000110000010010100011000110111100101100101011001100000010011000110000000001000100111100011000101101000100100000100010010101000100011100011000001101110001110011000101001";

    // --- SMS BroadcastReceiver: listens for PAGOxMOVIL responses ---
    public final BroadcastReceiver mReceivedSMSReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle;
            String action = intent.getAction();
            if (ACTION.equals(action) && (bundle = intent.getExtras()) != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) return;
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }
                String sender = messages[0].getOriginatingAddress();
                if (sender.equals("PAGOxMOVIL")) {
                    displayAlert(sb.toString());
                }
            }
        }
    };

    // --- Form utilities ---

    public void clearForm(ViewGroup group) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                clearForm((ViewGroup) view);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void mensaje(String text) {
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void mensaje(String text, Context cn) {
        Toast.makeText(cn, text, Toast.LENGTH_SHORT).show();
    }

    // --- CSV Import/Export (file chooser dialogs omitted — depend on afiledialog lib) ---

    /**
     * CSV import: reads lines prefixed with TF (landline), TM (mobile), NA (nauta),
     * PI (pin), FA (invoice), CL (client), RS (SMS record). Falls back to heuristic
     * parsing for untagged 2-column (pin) or 4-column (client) rows.
     */
    // public boolean importar(File file, Context context) { ... }

    // --- Database lookups ---

    /**
     * Returns the app version code from AppConfig table, or null if none.
     */
    // public String getCodeVersionApp() { ... }

    /**
     * Returns the first AgentService record, or null if none registered.
     */
    // public AgentService getCodeAgent() { ... }

    // --- SMS inbox parsing methods ---
    // public boolean sms_actualizar_bd(ContentResolver cs) — parse all PAGOxMOVIL SMS → RecordSMS
    // public boolean sms_actualizar_bd_datos_app(ContentResolver cs) — extract phone number from SMS
    // public String sms_code_agente(ContentResolver cs) — extract agent code from SMS
    // public String sms_code_bank(ContentResolver cs) — extract bank code from SMS
    // public String sms_code_bulevar(ContentResolver cs) — extract boulevard code from SMS
    // public String sms_code_boleto(ContentResolver cs) — extract ticket code from SMS

    // --- USSD dispatch (6 overloads) ---

    /**
     * Builds USSD string: tel:*{codeAcc}*{codeService}*{codeToSend}#
     * Shows confirmation dialog, then fires ACTION_CALL intent.
     */
    public void actionCallUSSD(String codeAcc, String codeService, String codeToSend,
                                String mensaje_dialog, final ViewGroup group) {
        String cadena = "tel:*" + codeAcc + "*" + codeService + "*" + codeToSend + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        // Show confirm dialog → startActivity(new Intent(ACTION_CALL, number))
    }

    /**
     * Simple USSD: tel:*{codeToSend}#
     */
    public void actionCallUSSD(String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String cadena = "tel:*" + codeToSend + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        // Confirm dialog → ACTION_CALL
    }

    /**
     * USSD with access code from DB: tel:*{codeAcceso}*{codeService}#
     */
    public void actionCallUSSD(String codeService) {
        // Reads access code from AppConfig table
        // Falls back to R.string.codigoAcceso
        // Fires ACTION_CALL directly (no confirmation)
    }

    /**
     * USSD with encryption: tel:*{codeAcceso}*{codeService}*{encoded(codeToSend)}*{version}#
     * Uses code() method for USSD parameter encoding.
     */
    public void actionCallUSSD(String codeService, String codeToSend) {
        // Reads codeAcceso + version from AppConfig
        // Encodes codeToSend via code() method
        // Fires ACTION_CALL directly
    }

    /**
     * USSD with encryption + confirmation dialog.
     */
    public void actionCallUSSD(String codeService, String codeToSend,
                                String mensaje_dialog, final ViewGroup group) {
        // Same as above but shows confirmation dialog first
    }

    /**
     * USSD with explicit access code + encryption + confirmation.
     */
    public void actionCallUSSDCodeAccess(String codeAccess, String codeService,
                                          String codeToSend, String mensaje_dialog,
                                          final ViewGroup group) {
        // Uses provided codeAccess instead of DB lookup
    }

    // --- USSD Parameter Encoding ---

    /**
     * Two-stage USSD parameter encoding:
     * 1. Splits input by '*', separates numeric vs non-numeric parts
     * 2. Numeric parts: encoded via UssdCipherOrchestrator (substitution + XOR)
     * 3. Non-numeric parts (Nauta accounts): encoded via NautaCodeEncoder
     * 4. Reassembled with 2-digit length prefixes per segment
     *
     * @param cadena Raw USSD parameter string (e.g., "12345*nauta@email*6789")
     * @return Encoded string with length prefixes and cipher output
     */
    public String code(String cadena) {
        String[] splitCode = cadena.split("\\*");
        int[] lenght_original_list = new int[splitCode.length];
        boolean is_item_old_version = false;

        for (int i = 0; i < splitCode.length; i++) {
            if (esEntero(splitCode[i])) {
                lenght_original_list[i] = splitCode[i].length();
            } else {
                lenght_original_list[i] = 0;
                is_item_old_version = true;
            }
        }

        List<String> codeSplit = Arrays.asList(splitCode);
        List<String> code_nauta = new ArrayList<>();
        List<String> code_numbers = new ArrayList<>();
        List<String> code_Salida = new ArrayList<>();

        if (!is_item_old_version) {
            // All numeric: encode via UssdCipherOrchestrator
            // Tz34gww2TFwrsuT8ukpL cd = new Tz34gww2TFwrsuT8ukpL(code_version, crude_code);
            // code_Salida = cd.aSHV52SplNh3HfZBSmJe(codeSplit);
        } else {
            // Mixed: separate numeric/non-numeric, encode each with appropriate cipher
            // Numeric → UssdCipherOrchestrator, Non-numeric → NautaCodeEncoder (kR22DOzTiB)
        }

        // Reassemble with 2-digit length prefixes
        // Format: {random_seed}{len1}{encoded1}*{len2}{encoded2}*...
        return ""; // placeholder
    }

    public boolean esEntero(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            if (!Character.isDigit(cad.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // --- AES Encryption (using hardcoded key cv) ---

    /**
     * Encrypts text using CryptoProvider with hardcoded key cv.
     * Used for bank PIN storage.
     */
    public String encryption(String strNormalText) {
        try {
            // SecretKey k = CryptoProvider.generateKey(cv);
            // return CryptoProvider.encryptMsg(strNormalText, k);
            return "";
        } catch (Exception ex) {
            Log.d("ERROR", ex.getMessage());
            return "";
        }
    }

    public String decryption(String strEncryptedText) {
        try {
            // SecretKey k = CryptoProvider.generateKey(cv);
            // return CryptoProvider.decryptMsg(strEncryptedText, k);
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    // --- Bank PIN storage (encrypted in BancoService table) ---

    /**
     * Encrypts and stores a bank PIN for the given bank type.
     * Switch on BankType: Metropolitano→pmetro, BPA→pbpa, BANDEC→pbandec.
     */
    // public boolean setqrcodeBk(BankType agencyEntity, String argP) { ... }

    /**
     * Retrieves and decrypts bank PIN for the given bank type.
     */
    // public String getqrcodeBk(BankType agencyEntity) { ... }

    // --- Dialogs ---

    public void displayAlert(String mensaje) {
        androidx.appcompat.app.AlertDialog.Builder builder =
                new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Nuevo mensaje");
        builder.setMessage(mensaje).setCancelable(false)
                .setPositiveButton("OK", (dialog, id) -> dialog.cancel());
        builder.create().show();
    }

    public void helpAlertGestion(Context cn, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cn);
        builder.setTitle("Ayuda!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", (dialog, id) -> {});
        builder.create().show();
    }

    public void helpAlertGestionAndCloseApp(Context cn, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cn);
        builder.setTitle("Aviso!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", (dialog, id) -> System.exit(0));
        builder.create().show();
    }

    public void ShowMessageADialog(String title, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(mensaje).setCancelable(true)
                .setPositiveButton("Cerrar", (dialog, id) -> {});
        builder.create().show();
    }

    // --- APK Update Download ---

    /**
     * AsyncTask that downloads a new APK version from http://www.etecsa.cu/descargas/transfermovil/
     * with a SHA parameter. Shows progress dialog. Saves to /Download/transfermovil_new_version.apk
     * and triggers install via ACTION_VIEW intent.
     *
     * @security Plain HTTP download — no TLS, no integrity verification of downloaded APK.
     */
    public class DownloadNewVersion extends AsyncTask<String, Integer, Boolean> {
        public Context context;
        public String url_sha;

        public DownloadNewVersion(Context context, String url) {
            this.context = context;
            this.url_sha = url;
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            bar = new ProgressDialog(context);
            bar.setCancelable(false);
            bar.setMessage("Descargando...");
            bar.setIndeterminate(true);
            bar.setCanceledOnTouchOutside(false);
            bar.show();
        }

        @Override
        public void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            bar.setIndeterminate(false);
            bar.setMax(100);
            bar.setProgress(progress[0]);
            bar.setMessage(progress[0] > 99 ? "Finalizando... " : "Descargando... " + progress[0] + "%");
        }

        @Override
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            bar.dismiss();
            if (!result) {
                Toast.makeText(getApplicationContext(), "Error: Prueba de nuevo", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public Boolean doInBackground(String... arg0) {
            try {
                String downloadUrl = "http://www.etecsa.cu/descargas/transfermovil/?d=" + url_sha;
                URL url = new URL(Uri.parse(downloadUrl).toString());
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(false);
                c.connect();

                String path = Environment.getExternalStorageDirectory() + "/Download/";
                File dir = new File(path);
                dir.mkdirs();
                File outputFile = new File(dir, "transfermovil_new_version.apk");
                if (outputFile.exists()) outputFile.delete();

                InputStream is = c.getInputStream();
                int totalSize = c.getContentLength();
                byte[] buffer = new byte[8192];
                int downloaded = 0;
                FileOutputStream fos = new FileOutputStream(outputFile);
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                    downloaded += len;
                    publishProgress((downloaded * 100) / totalSize);
                }
                fos.close();
                is.close();
                openNewVersion(path);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public void openNewVersion(String location) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(
                Uri.fromFile(new File(location + "transfermovil_new_version.apk")),
                "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
