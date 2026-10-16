package cu.etecsa.tm.ecommerce.qHBfDCWv13G;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class tgTvaFy8UG {
    public String numero_telefonico = BuildConfig.FLAVOR;
    public String code_bulevar = BuildConfig.FLAVOR;

    public String smsCodeBulevar(ContentResolver cs) {
        try {
            ArrayList<SMS_properties> sms = readSmsInbox(cs);
            if (sms == null) {
                return BuildConfig.FLAVOR;
            }
            for (int i = 0; i < sms.size(); i++) {
                if (parse_fill_sms_data(sms.get(i).getBody()) && !this.code_bulevar.isEmpty()) {
                    return this.code_bulevar;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public boolean parse_fill_sms_data(String sms) {
        if (sms.contains("Bienvenido al Bulevar de Transfermovil")) {
            String[] msg_separate = sms.split(" ");
            if (sms.contains("Su clave de acceso al servicio es:")) {
                this.code_bulevar = msg_separate[12];
                return true;
            }
            return true;
        }
        return false;
    }

    public ArrayList<SMS_properties> readSmsInbox(ContentResolver contentResolver) {
        ArrayList<SMS_properties> smsMessagesList = new ArrayList<>();
        String[] selectionArgs = {"PAGOxMOVIL"};
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, " address=? ", selectionArgs, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        smsInboxCursor.getColumnIndex("person");
        int indexDate = smsInboxCursor.getColumnIndex("date");
        smsInboxCursor.getColumnIndex("type");
        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) {
            return null;
        }
        do {
            try {
                Date d = new Date(Long.parseLong(smsInboxCursor.getString(indexDate)));
                SMS_properties sms_p = new SMS_properties();
                sms_p.setDate(d);
                sms_p.setAddress(smsInboxCursor.getString(indexAddress));
                sms_p.setBody(smsInboxCursor.getString(indexBody));
                smsMessagesList.add(sms_p);
            } catch (Exception e) {
                Log.d("Error", "Exception");
            }
        } while (smsInboxCursor.moveToNext());
        smsInboxCursor.close();
        return smsMessagesList;
    }

    public class SMS_properties {
        private String address;
        private String body;
        private Date date;
        private String date_no_convert;
        private String person;
        private String type;

        public SMS_properties() {
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPerson() {
            return this.person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getDate_no_convert() {
            return this.date_no_convert;
        }

        public void setDate_no_convert(String date_no_convert) {
            this.date_no_convert = date_no_convert;
        }
    }
}
