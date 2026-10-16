package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/* JADX INFO: loaded from: classes.dex */
public class P8DtkaSW4dR extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public AccessibilityManager accessibilityManager;
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    public Context context;
    private TextInputLayout lyMonto;
    public pAzq93vIl3 manager;
    public View rootView;
    private AutoCompleteTextView txMonto;
    public boolean pagoTotal = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        this.context = context;
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.manager = new pAzq93vIl3(this.context, this);
        try {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                this.rootView = inflater.inflate(R.layout.nfoph5kavkjek, container, false);
            } else {
                this.rootView = inflater.inflate(R.layout.nfoph5kavkjek, container, false);
            }
        } catch (Exception e) {
            this.rootView = inflater.inflate(R.layout.nfoph5kavkjek, container, false);
        }
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.lyMonto.setHint(getString(R.string.monto_moneda_en_cuc));
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                P8DtkaSW4dR.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                P8DtkaSW4dR p8DtkaSW4dR = P8DtkaSW4dR.this;
                p8DtkaSW4dR.mensajeAyuda("Ayuda", p8DtkaSW4dR.context.getString(R.string.tx_help_recargar_wallet_cup));
            }
        });
        return this.rootView;
    }

    public void submitForm() {
        if (!validateMonto()) {
            return;
        }
        String monto = this.txMonto.getText().toString().trim();
        String msg = "¿ Desea solicitar un ticket para el depósito en cadeca a su cuenta CUP , con el monto en CUP: " + monto + " ?";
        String cadena = monto + "*CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "17", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "17", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.txMonto.getText().toString().trim().isEmpty()) {
                this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.txMonto);
                return false;
            }
            try {
                float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
                if (importe < 1.0f) {
                    this.lyMonto.setError(getString(R.string.err_msg_importe_inferior));
                    requestFocus(this.txMonto);
                    return false;
                }
                this.lyMonto.setErrorEnabled(false);
                return true;
            } catch (Exception e) {
                this.lyMonto.setError("Monto incorrecto");
                requestFocus(this.txMonto);
                return false;
            }
        }
        return true;
    }

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR.3
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(P8DtkaSW4dR.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.P8DtkaSW4dR.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
