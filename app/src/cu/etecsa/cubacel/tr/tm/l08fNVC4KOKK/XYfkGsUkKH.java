package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class XYfkGsUkKH extends AsyncTask<Void, Integer, Boolean> {
    public ContentResolver cs;
    public Ti8eM28U2E resultView;

    public XYfkGsUkKH(ContentResolver contentResolver, Ti8eM28U2E viewCombutible) {
        this.cs = contentResolver;
        this.resultView = viewCombutible;
    }

    public void setProgressBarVisiblity(int visiblity) {
        Ti8eM28U2E ti8eM28U2E = this.resultView;
        if (ti8eM28U2E != null) {
            ti8eM28U2E.onSetProgressBarVisibility(visiblity);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        setProgressBarVisiblity(0);
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voids) {
        sms_actualizar_bd();
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean result) {
        setProgressBarVisiblity(4);
        Ti8eM28U2E ti8eM28U2E = this.resultView;
        if (ti8eM28U2E != null) {
            ti8eM28U2E.onCuentasResult(true, 1, "ok");
        }
    }

    public boolean sms_actualizar_bd() {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(this.cs);
            if (sms == null) {
                return false;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                parseSMS.parseCombustible(sms.get(i));
            }
            return true;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }
}
