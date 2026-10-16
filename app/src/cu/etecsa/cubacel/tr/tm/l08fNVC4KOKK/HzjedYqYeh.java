package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class HzjedYqYeh {
    public static boolean send_sms(String number, String body_text, Context context) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") != 0) {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(number)));
                intent.putExtra("sms_body", body_text);
                context.startActivity(intent);
            } else {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, body_text, null, null);
                Toast.makeText(context, "SMS enviado. espere un SMS de respuesta", 1).show();
            }
            return true;
        } catch (Exception e) {
            Toast.makeText(context, "Ha ocurrido un error. SMS no enviado", 1).show();
            return false;
        }
    }

    public ArrayList<rIgmgP6JXL> readSmsInbox(ContentResolver contentResolver) {
        ArrayList<rIgmgP6JXL> smsMessagesList = new ArrayList<>();
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
                rIgmgP6JXL sms_p = new rIgmgP6JXL();
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
}
