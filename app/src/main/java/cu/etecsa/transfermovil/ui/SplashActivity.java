package cu.etecsa.transfermovil.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.config.ActivationCodeValidator;
import cu.etecsa.transfermovil.core.GlobalState;
import cu.etecsa.transfermovil.data.SharedPreferencesAccessor;

/**
 * Launch screen and mode router reconstructed from the v1.260416 JADX source.
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.prPzLeyxKk
 */
public class SplashActivity extends Activity {

    private static final int SPLASH_TIME_OUT = 3000;
    private static final String AGENT_ACTIVITY = "cu.etecsa.cubacel.tr.tm.IHVTCBmiLV";
    private static final String GENERAL_ACTIVITY = "cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy";

    private boolean block = false;
    public SharedPreferencesAccessor msap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlory6n6mxx92);
        try {
            this.msap = new SharedPreferencesAccessor();
        } catch (Exception ex) {
            Log.e("TM_SPLASH", "prPzLeyxKk Fr52O1uSYF: " + ex.getMessage());
            System.runFinalization();
        }
        new Handler().postDelayed(() -> {
            try {
                String target = generalVsAgentVersion() ? AGENT_ACTIVITY : GENERAL_ACTIVITY;
                startActivity(new Intent().setClassName(this, target));
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), R.string.err_open_app, Toast.LENGTH_SHORT).show();
                GlobalState.writeLog(e.getMessage());
                System.runFinalization();
            }
            finish();
        }, SPLASH_TIME_OUT);
    }

    private boolean generalVsAgentVersion() {
        try {
            String activationCode = this.msap.getCodigoAgente(this);
            if (activationCode == null) {
                return false;
            }
            if (activationCode.contains("-1") || activationCode.isEmpty()) {
                return false;
            }
            String version = this.msap.getVersion(this);
            String phone = this.msap.getPhone(this);
            return new ActivationCodeValidator().check_code_activation(activationCode, version, phone);
        } catch (Exception ex) {
            Log.e("TM_SPLASH", "Exception generalVsAgentVersion: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
