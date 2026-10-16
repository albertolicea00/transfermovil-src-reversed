package cu.etecsa.cubacel.tr.tm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class X9ZiE8XZNKy extends BroadcastReceiver {
    public String ACTION = rDEl7rW1aN.ACTION;
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
