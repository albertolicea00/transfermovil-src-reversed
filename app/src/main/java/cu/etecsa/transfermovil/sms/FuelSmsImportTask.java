package cu.etecsa.transfermovil.sms;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.XYfkGsUkKH
 * @fingerprint AsyncTask that imports fuel/combustible SMS. Uses SmsParser.parseCombustible().
 *              Shows/hides progress bar via Ti8eM28U2E callback interface.
 *
 * Dependencies (obfuscated references):
 *   - g0xM9kQCsqu → SmsParser (parseCombustible method)
 *   - Ti8eM28U2E → UI callback interface with onSetProgressBarVisibility/onCuentasResult
 */
public class FuelSmsImportTask extends AsyncTask<Void, Integer, Boolean> {
    public ContentResolver cs;
    // public Ti8eM28U2E resultView; // UI callback

    public FuelSmsImportTask(ContentResolver contentResolver) {
        this.cs = contentResolver;
    }

    // public void setProgressBarVisibility(int visibility) {
    //     if (resultView != null) resultView.onSetProgressBarVisibility(visibility);
    // }

    @Override
    public void onPreExecute() {
        super.onPreExecute();
        // setProgressBarVisibility(View.VISIBLE);
    }

    @Override
    public Boolean doInBackground(Void... voids) {
        sms_actualizar_bd();
        return null;
    }

    @Override
    public void onPostExecute(Boolean result) {
        // setProgressBarVisibility(View.GONE);
        // if (resultView != null) resultView.onCuentasResult(true, 1, "ok");
    }

    public boolean sms_actualizar_bd() {
        try {
            SmsSender sms_center = new SmsSender();
            ArrayList<SmsMessage> sms = sms_center.readSmsInbox(this.cs);
            if (sms == null) {
                return false;
            }
            // g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            // for (int i = 0; i < sms.size(); i++) {
            //     parseSMS.parseCombustible(sms.get(i));
            // }
            return true;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }
}
