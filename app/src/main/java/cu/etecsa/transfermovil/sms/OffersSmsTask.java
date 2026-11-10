package cu.etecsa.transfermovil.sms;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;
import cu.etecsa.transfermovil.banking.ui.OffersResultCallback;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.DHfGEge8yT
 * @fingerprint AsyncTask that processes offer/promo SMS from today only.
 *              Filters by date >= start of today, parses via SmsParser.parseOfertasBoleto().
 *
 * Dependencies (obfuscated references):
 *   - g0xM9kQCsqu → SmsParser (parseOfertasBoleto method)
 *   - SYLBHJttme → UI callback with onSetProgressBarVisibility/onOfertasResult
 */
public class OffersSmsTask extends AsyncTask<Void, Integer, Boolean> {
    private ContentResolver contentResolver;
    private int nuevasOfertas = 0;
    private OffersResultCallback resultView;

    public OffersSmsTask(ContentResolver contentResolver, OffersResultCallback resultView) {
        this.contentResolver = contentResolver;
        this.resultView = resultView;
    }

    @Override
    public void onPreExecute() {
        super.onPreExecute();
        setProgressBarVisibility(0);
    }

    @Override
    public Boolean doInBackground(Void... voids) {
        return Boolean.valueOf(procesarSMSOfertas());
    }

    @Override
    public void onPostExecute(Boolean result) {
        setProgressBarVisibility(4);
        if (this.resultView != null) {
            boolean success = result.booleanValue();
            String message = success
                    ? this.nuevasOfertas + " nuevas ofertas procesadas"
                    : "Error al procesar ofertas";
            this.resultView.onOfertasResult(success, this.nuevasOfertas, message);
        }
    }

    public void setProgressBarVisibility(int visibility) {
        if (this.resultView != null) {
            this.resultView.onSetProgressBarVisibility(visibility);
        }
    }

    private boolean procesarSMSOfertas() {
        try {
            SmsSender sms_center = new SmsSender();
            Calendar startOfToday = Calendar.getInstance();
            startOfToday.set(Calendar.HOUR_OF_DAY, 0);
            startOfToday.set(Calendar.MINUTE, 0);
            startOfToday.set(Calendar.SECOND, 0);
            startOfToday.set(Calendar.MILLISECOND, 0);
            Date startOfTodayDate = startOfToday.getTime();

            ArrayList<SmsMessage> sms = sms_center.readSmsInbox(this.contentResolver);
            if (sms == null) {
                return false;
            }
            SmsParser parser = new SmsParser();
            boolean processedAny = false;
            for (int i = 0; i < sms.size(); i++) {
                SmsMessage smsProperty = sms.get(i);
                Date smsDate = smsProperty.getDate();
                if (smsDate != null && !smsDate.before(startOfTodayDate)) {
                    parser.parseOfertasBoleto(smsProperty);
                    processedAny = true;
                }
            }
            return processedAny;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }
}
