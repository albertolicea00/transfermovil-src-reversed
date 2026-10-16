package cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.c1TYoqkyyPA;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.tgTvaFy8UG;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class n5G52vH5qAR extends Fragment implements L6l0bKlV5aq {
    public Activity activity;
    public Button btLogin;
    public Button btReenviar;
    public int contador;
    public Context context;
    public mAtrYjNld7 loginPresenter;
    public TextInputLayout lyCode;
    private ProgressBar mProgressView;
    public String pass;
    public View rootView;
    public Timer timer;
    public TextInputEditText txCode;
    public String user;
    public View.OnClickListener btLoginClick = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (n5G52vH5qAR.this.isOnline()) {
                if (!n5G52vH5qAR.this.validarCode()) {
                    return;
                }
                n5G52vH5qAR n5g52vh5qar = n5G52vH5qAR.this;
                n5g52vh5qar.loginPresenter.loginFactor(n5g52vh5qar.user, n5g52vh5qar.pass, n5g52vh5qar.txCode.getText().toString());
                return;
            }
            n5G52vH5qAR.this.mProgressView.setVisibility(4);
            n5G52vH5qAR n5g52vh5qar2 = n5G52vH5qAR.this;
            n5g52vh5qar2.ShowMessageADialog("Error", n5g52vh5qar2.context.getResources().getString(R.string.err_not_connection));
        }
    };
    public View.OnClickListener btReenviarClick = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!n5G52vH5qAR.this.isOnline()) {
                n5G52vH5qAR.this.mProgressView.setVisibility(4);
                n5G52vH5qAR n5g52vh5qar = n5G52vH5qAR.this;
                n5g52vh5qar.ShowMessageADialog("Error", n5g52vh5qar.context.getResources().getString(R.string.err_not_connection));
            } else {
                n5G52vH5qAR n5g52vh5qar2 = n5G52vH5qAR.this;
                n5g52vh5qar2.loginPresenter.login(n5g52vh5qar2.user, n5g52vh5qar2.pass);
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getContext().getTheme().applyStyle(R.style.AppThemeBulevar_NoActionBar, true);
        this.rootView = inflater.inflate(R.layout.ybfk5wr2gqyuq, container, false);
        Context context = container.getContext();
        this.context = context;
        this.loginPresenter = new c1TYoqkyyPA(this, context);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        this.mProgressView.setVisibility(8);
        this.lyCode = (TextInputLayout) this.rootView.findViewById(R.id.lyCode);
        TextInputEditText textInputEditText = (TextInputEditText) this.rootView.findViewById(R.id.txCode);
        this.txCode = textInputEditText;
        textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tgTvaFy8UG smsManager = new tgTvaFy8UG();
                String code = smsManager.smsCodeBulevar(n5G52vH5qAR.this.context.getContentResolver());
                if (code != BuildConfig.FLAVOR) {
                    n5G52vH5qAR.this.txCode.setText(code);
                }
            }
        });
        this.txCode.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean b) {
                tgTvaFy8UG smsManager = new tgTvaFy8UG();
                String code = smsManager.smsCodeBulevar(n5G52vH5qAR.this.context.getContentResolver());
                if (code != BuildConfig.FLAVOR) {
                    n5G52vH5qAR.this.txCode.setText(code);
                }
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btValidar);
        this.btLogin = button;
        button.setOnClickListener(this.btLoginClick);
        Button button2 = (Button) this.rootView.findViewById(R.id.btReenviar);
        this.btReenviar = button2;
        this.contador = 30;
        button2.setEnabled(false);
        this.btReenviar.setOnClickListener(this.btReenviarClick);
        AsynchTaskTimer();
        Bundle arg = getArguments();
        if (arg.containsKey("user")) {
            this.user = arg.getString("user");
        }
        if (arg.containsKey("pass")) {
            this.pass = arg.getString("pass");
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validarCode() {
        if (this.txCode.getText().toString().trim().isEmpty()) {
            this.lyCode.setError("Este campo no puede ser vacío");
            requestFocus(this.txCode);
            return false;
        }
        this.lyCode.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onResult(Boolean result, int code, String mensaje) {
        if (result.booleanValue()) {
            this.btReenviar.setEnabled(false);
            this.btReenviar.setBackground(getResources().getDrawable(R.drawable.func_bt_disabled));
            Toast.makeText(this.context, "Mensaje enviado", 0).show();
            return;
        }
        ShowMessageADialog("Error", mensaje);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onResultFactor(Boolean result, int code, String mensaje) {
        if (result.booleanValue()) {
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            PVrNBPiBYx fragment = new PVrNBPiBYx();
            mFragmentTransaction.replace(R.id.containerView, fragment).commit();
            return;
        }
        ShowMessageADialog("Error", mensaje);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.5
            @Override // java.lang.Runnable
            public void run() {
                n5G52vH5qAR.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.6
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(n5G52vH5qAR.this.context).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void AsynchTaskTimer() {
        final Handler handler = new Handler();
        TimerTask timertask = new TimerTask() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                handler.post(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.n5G52vH5qAR.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            n5G52vH5qAR.this.checkTimer();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(timertask, 0L, 1000L);
    }

    public void checkTimer() {
        if (!this.btReenviar.isEnabled()) {
            if (this.contador <= 0) {
                this.btReenviar.setBackground(getResources().getDrawable(R.drawable.func_bt_orange));
                this.btReenviar.setEnabled(true);
                this.btReenviar.setText("Reenviar SMS");
                this.contador = 30;
                return;
            }
            this.btReenviar.setBackground(getResources().getDrawable(R.drawable.func_bt_disabled));
            this.btReenviar.setText("Reenviar SMS en " + this.contador + " segundos");
            this.contador = this.contador - 1;
        }
    }
}
