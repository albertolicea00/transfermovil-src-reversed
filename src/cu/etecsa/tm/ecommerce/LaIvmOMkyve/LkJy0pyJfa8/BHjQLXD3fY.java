package cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.c1TYoqkyyPA;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7;

/* JADX INFO: loaded from: classes.dex */
public class BHjQLXD3fY extends Fragment implements L6l0bKlV5aq {
    public Activity activity;
    public Button btLogin;
    public View.OnClickListener btLoginClick = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.BHjQLXD3fY.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (BHjQLXD3fY.this.isOnline()) {
                if (!BHjQLXD3fY.this.validatUser() || !BHjQLXD3fY.this.validatPass()) {
                    return;
                }
                BHjQLXD3fY bHjQLXD3fY = BHjQLXD3fY.this;
                bHjQLXD3fY.loginPresenter.login(bHjQLXD3fY.txUser.getText().toString().trim(), BHjQLXD3fY.this.txPass.getText().toString().trim());
                return;
            }
            BHjQLXD3fY.this.mProgressView.setVisibility(4);
            BHjQLXD3fY bHjQLXD3fY2 = BHjQLXD3fY.this;
            bHjQLXD3fY2.ShowMessageADialog("Error", bHjQLXD3fY2.context.getResources().getString(R.string.err_not_connection));
        }
    };
    public Context context;
    public mAtrYjNld7 loginPresenter;
    public TextInputLayout lyPass;
    public TextInputLayout lyUser;
    private ProgressBar mProgressView;
    public View rootView;
    public TextInputEditText txPass;
    public TextInputEditText txUser;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getContext().getTheme().applyStyle(R.style.AppThemeBulevar_NoActionBar, true);
        this.rootView = inflater.inflate(R.layout.ve6io0ufqddku, container, false);
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
        this.lyUser = (TextInputLayout) this.rootView.findViewById(R.id.lyUser);
        this.lyPass = (TextInputLayout) this.rootView.findViewById(R.id.lyPass);
        this.txUser = (TextInputEditText) this.rootView.findViewById(R.id.lyCode);
        this.txPass = (TextInputEditText) this.rootView.findViewById(R.id.txPass);
        Button button = (Button) this.rootView.findViewById(R.id.btLogin);
        this.btLogin = button;
        button.setOnClickListener(this.btLoginClick);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatUser() {
        if (this.txUser.getText().toString().trim().isEmpty()) {
            this.lyUser.setError("Este campo no puede ser vacío");
            requestFocus(this.txUser);
            return false;
        }
        this.lyUser.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatPass() {
        if (this.txPass.getText().toString().trim().isEmpty()) {
            this.lyPass.setError("Este campo no puede ser vacío");
            requestFocus(this.txPass);
            return false;
        }
        this.lyPass.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onResult(Boolean result, int code, String mensaje) {
        if (result.booleanValue()) {
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            n5G52vH5qAR fragment = new n5G52vH5qAR();
            Bundle data = new Bundle();
            data.putString("user", this.txUser.getText().toString().toLowerCase().trim());
            data.putString("pass", this.txPass.getText().toString().trim());
            fragment.setArguments(data);
            mFragmentTransaction.replace(R.id.containerView, fragment).commit();
            return;
        }
        ShowMessageADialog("Error", mensaje);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onResultFactor(Boolean result, int code, String mensaje) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.BHjQLXD3fY.2
            @Override // java.lang.Runnable
            public void run() {
                BHjQLXD3fY.this.mProgressView.setVisibility(visibility);
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
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.BHjQLXD3fY.3
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(BHjQLXD3fY.this.context).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.BHjQLXD3fY.3.1
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
}
