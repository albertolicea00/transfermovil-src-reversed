package cu.etecsa.cubacel.tr.tm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;

/* JADX INFO: loaded from: classes.dex */
public class prPzLeyxKk extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    private boolean block = false;
    public Fr52O1uSYF msap;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlory6n6mxx92);
        try {
            this.msap = new Fr52O1uSYF();
        } catch (Exception ex) {
            Log.e("TM_SPLASH", "prPzLeyxKk Fr52O1uSYF: " + ex.getMessage());
            System.runFinalization();
        }
        new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.prPzLeyxKk.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (prPzLeyxKk.this.generalVsAgentVersion()) {
                        Intent i = new Intent(prPzLeyxKk.this, (Class<?>) IHVTCBmiLV.class);
                        prPzLeyxKk.this.startActivity(i);
                    } else {
                        Intent i2 = new Intent(prPzLeyxKk.this, (Class<?>) S9ycHcoxAzy.class);
                        prPzLeyxKk.this.startActivity(i2);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(prPzLeyxKk.this.getBaseContext(), R.string.err_open_app, 0);
                    toast.show();
                    U6ucOCBccJ.writeLog(e.getMessage());
                    System.runFinalization();
                }
                prPzLeyxKk.this.finish();
            }
        }, SPLASH_TIME_OUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean generalVsAgentVersion() {
        try {
            if (this.msap.getCodigoAgente(this) == null) {
                return false;
            }
            hY5P1xQ5h8 ac = new hY5P1xQ5h8();
            String codigo_activacion = this.msap.getCodigoAgente(this);
            if (codigo_activacion.contains("-1") || codigo_activacion.isEmpty()) {
                return false;
            }
            String version = this.msap.getVersion(this);
            String phone = this.msap.getPhone(this);
            if (!ac.check_code_activation(codigo_activacion, version, phone)) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            Log.e("TM_SPLASH", "Exception generalVsAgentVersion: " + ex.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        uyh0pxs9m37in.getItemId();
        return super.onOptionsItemSelected(uyh0pxs9m37in);
    }
}
