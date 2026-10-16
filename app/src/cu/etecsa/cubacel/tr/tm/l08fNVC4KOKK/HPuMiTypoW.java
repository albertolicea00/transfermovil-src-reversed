package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HPuMiTypoW extends AsyncTask<Void, Integer, Boolean> {
    public ContentResolver cs;
    public Ti8eM28U2E updateCombustibleView;

    public HPuMiTypoW(ContentResolver contentResolver) {
        this.cs = contentResolver;
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voids) {
        sms_actualizar_bd();
        return null;
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
                RecordSMS recordSMS = parseSMS.parse(sms.get(i));
                if (recordSMS != null) {
                    recordSMS.setFecha(sms.get(i).getDate());
                    List<RecordSMS> c_list = unYp8VQThY.getInstance().getRecordSMSwithIDTransactionByType(recordSMS.getIdTransaccion(), recordSMS.getTipo_servicio());
                    if (c_list != null) {
                        if (c_list.size() == 0) {
                            unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                        }
                    } else {
                        unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }
}
