package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class DHfGEge8yT extends AsyncTask<Void, Integer, Boolean> {
    private ContentResolver contentResolver;
    private int nuevasOfertas = 0;
    private SYLBHJttme resultView;

    public DHfGEge8yT(ContentResolver contentResolver, SYLBHJttme viewOfertas) {
        this.contentResolver = contentResolver;
        this.resultView = viewOfertas;
    }

    public void setProgressBarVisibility(int visibility) {
        SYLBHJttme sYLBHJttme = this.resultView;
        if (sYLBHJttme != null) {
            sYLBHJttme.onSetProgressBarVisibility(visibility);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        setProgressBarVisibility(0);
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voids) {
        return Boolean.valueOf(procesarSMSOfertas());
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean result) {
        String mensaje;
        setProgressBarVisibility(4);
        if (this.resultView != null) {
            if (result.booleanValue()) {
                mensaje = this.nuevasOfertas + " nuevas ofertas procesadas";
            } else {
                mensaje = "Error al procesar ofertas";
            }
            this.resultView.onOfertasResult(result.booleanValue(), this.nuevasOfertas, mensaje);
        }
    }

    private boolean procesarSMSOfertas() {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            Calendar startOfToday = Calendar.getInstance();
            startOfToday.set(11, 0);
            startOfToday.set(12, 0);
            startOfToday.set(13, 0);
            startOfToday.set(14, 0);
            Date startOfTodayDate = startOfToday.getTime();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(this.contentResolver);
            if (sms == null) {
                return false;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            boolean processedAny = false;
            for (int i = 0; i < sms.size(); i++) {
                rIgmgP6JXL smsProperty = sms.get(i);
                Date smsDate = smsProperty.getDate();
                if (smsDate != null && !smsDate.before(startOfTodayDate)) {
                    parseSMS.parseOfertasBoleto(smsProperty);
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
