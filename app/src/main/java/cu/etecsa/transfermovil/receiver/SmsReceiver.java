package cu.etecsa.transfermovil.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import cu.etecsa.transfermovil.base.BaseMainActivity;

/**
 * Broadcast entry point; the original only records receipt, not SMS parsing.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.X9ZiE8XZNKy
 * @original_apk_version 1.260416
 */
public class SmsReceiver extends BroadcastReceiver {
    public String ACTION = BaseMainActivity.ACTION;
    public Context myContext;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.myContext = context;
        intent.getAction();
        Log.i("SMS_IN", "ok");
    }

    public void displayAlert(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.myContext);
        builder.setTitle("Nuevo mensaje");
        builder.setMessage(mensaje).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.X9ZiE8XZNKy.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
