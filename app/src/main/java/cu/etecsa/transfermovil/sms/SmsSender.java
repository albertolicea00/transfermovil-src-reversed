package cu.etecsa.transfermovil.sms;

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

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HzjedYqYeh
 * @fingerprint Sends SMS (SmsManager or ACTION_SENDTO fallback) and reads inbox
 *              filtered by sender "PAGOxMOVIL". No cursor close in error path.
 */
public class SmsSender {

    public static boolean send_sms(String number, String body_text, Context context) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") != 0) {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(number)));
                intent.putExtra("sms_body", body_text);
                context.startActivity(intent);
            } else {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, body_text, null, null);
                Toast.makeText(context, "SMS enviado. espere un SMS de respuesta", Toast.LENGTH_LONG).show();
            }
            return true;
        } catch (Exception e) {
            Toast.makeText(context, "Ha ocurrido un error. SMS no enviado", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public ArrayList<SmsMessage> readSmsInbox(ContentResolver contentResolver) {
        ArrayList<SmsMessage> smsMessagesList = new ArrayList<>();
        String[] selectionArgs = {"PAGOxMOVIL"};
        Cursor smsInboxCursor = contentResolver.query(
                Uri.parse("content://sms/inbox"), null, " address=? ", selectionArgs, null);
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
                SmsMessage sms = new SmsMessage();
                sms.setDate(d);
                sms.setAddress(smsInboxCursor.getString(indexAddress));
                sms.setBody(smsInboxCursor.getString(indexBody));
                smsMessagesList.add(sms);
            } catch (Exception e) {
                Log.d("Error", "Exception");
            }
        } while (smsInboxCursor.moveToNext());
        smsInboxCursor.close();
        return smsMessagesList;
    }
}
