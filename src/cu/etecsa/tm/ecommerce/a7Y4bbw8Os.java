package cu.etecsa.tm.ecommerce;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.zWwX278fcd;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.q0H70da5TFZ;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.oEp8f9G278;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.V8vPhoI56gL;

/* JADX INFO: loaded from: classes.dex */
public class a7Y4bbw8Os extends AppCompatActivity implements zWwX278fcd {
    public V8vPhoI56gL appPresenter;
    public Button btReintento;
    public Context context;
    private ProgressBar mProgressView;
    public TextView txCargando;
    public String HEAD_LOG = "a7Y4bbw8Os";
    public View.OnClickListener btReinicioClick = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.a7Y4bbw8Os.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            a7Y4bbw8Os.this.init();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hgjdlstcf1hmm);
        this.context = getApplicationContext();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) findViewById(R.id.progress);
        this.txCargando = (TextView) findViewById(R.id.txCargando);
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        this.mProgressView.setVisibility(8);
        this.txCargando.setVisibility(8);
        Button button = (Button) findViewById(R.id.btReintento);
        this.btReintento = button;
        button.setOnClickListener(this.btReinicioClick);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        if (isOnline()) {
            this.mProgressView.setVisibility(0);
            this.txCargando.setVisibility(0);
            oEp8f9G278 oep8f9g278 = new oEp8f9G278(this, this.context);
            this.appPresenter = oep8f9g278;
            oep8f9g278.iniApp();
            return;
        }
        this.btReintento.setVisibility(0);
        this.mProgressView.setVisibility(8);
        this.txCargando.setVisibility(8);
        ShowMessageADialog("Notificación", "No hay acceso a internet. Chequee su conexión por datos móviles o red wifi.");
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.zWwX278fcd
    public void initResult(boolean result, q0H70da5TFZ appState, String mensaje) {
        this.mProgressView.setVisibility(8);
        this.txCargando.setVisibility(8);
        Log.i(this.HEAD_LOG + "initResult", mensaje);
        if (result) {
            switch (AnonymousClass3.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ[appState.ordinal()]) {
                case 1:
                    Log.i(this.HEAD_LOG + "initResult", "NOCSRF");
                    break;
                case 2:
                    Log.i(this.HEAD_LOG + "initResult", "LOGIN_SIN_TOKEN");
                    Intent intent = new Intent(this, (Class<?>) C1b1PWKeZSE.class);
                    startActivity(intent);
                    finish();
                    break;
                case 3:
                    Log.i(this.HEAD_LOG + "initResult", "LOGINOK");
                    Intent intent2 = new Intent(this, (Class<?>) hd5jZHAGaN.class);
                    startActivity(intent2);
                    finish();
                    break;
                case 4:
                    Log.i(this.HEAD_LOG + "initResult", "ERROR");
                    break;
            }
        }
        ShowMessageADialog("Error", mensaje);
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.a7Y4bbw8Os$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ;

        static {
            int[] iArr = new int[q0H70da5TFZ.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ = iArr;
            try {
                iArr[q0H70da5TFZ.NOCSRF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ[q0H70da5TFZ.LOGIN_SIN_TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ[q0H70da5TFZ.LOGINOK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$q0H70da5TFZ[q0H70da5TFZ.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.a7Y4bbw8Os.2
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(a7Y4bbw8Os.this).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.a7Y4bbw8Os.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }
}
