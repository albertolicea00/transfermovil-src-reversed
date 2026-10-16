package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class eUkRSfpCKs extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout lyCI;
    private TextInputLayout lyEmail;
    private TextInputLayout lyNewPin;
    private TextInputLayout lyRepeatPin;
    public pAzq93vIl3 manager;
    public View rootView;
    private AutoCompleteTextView txCI;
    private AutoCompleteTextView txEmail;
    private AutoCompleteTextView txNewPin;
    private AutoCompleteTextView txRepeatPin;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.logr8gwypgplk, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.lyEmail = (TextInputLayout) this.rootView.findViewById(R.id.lyEmail);
        this.txEmail = (AutoCompleteTextView) this.rootView.findViewById(R.id.txEmail);
        this.lyEmail.setVisibility(8);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.txCI = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.lyNewPin = (TextInputLayout) this.rootView.findViewById(R.id.lyNewPin);
        this.txNewPin = (AutoCompleteTextView) this.rootView.findViewById(R.id.txNewPin);
        this.lyRepeatPin = (TextInputLayout) this.rootView.findViewById(R.id.lyRepeatPin);
        this.txRepeatPin = (AutoCompleteTextView) this.rootView.findViewById(R.id.txRepeatPin);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.eUkRSfpCKs.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eUkRSfpCKs.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCi() || !validatePin() || !validateRepeatPin()) {
            return;
        }
        String ci = this.txCI.getText().toString().trim();
        String pin = this.txNewPin.getText().toString().trim();
        String cadena = "04*0000*" + ci + "*" + pin;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "49", cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "49", "04", this.MAX_PARAMETERS_PQUETE, cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        }
    }

    private boolean validateCi() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_len_ci_all_bolsa));
            requestFocus(this.txCI);
            return false;
        }
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    private boolean validateEmail() {
        if (this.txEmail.getText().toString().trim().isEmpty()) {
            this.lyEmail.setError(getString(R.string.hint_campo_vacio));
            requestFocus(this.txEmail);
            return false;
        }
        Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
        Matcher m = p.matcher(this.txEmail.getText().toString().trim());
        if (!m.find()) {
            this.lyEmail.setError("Dirección de correo inválida");
            requestFocus(this.txEmail);
            return false;
        }
        this.lyEmail.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private boolean validatePin() {
        if (this.txNewPin.getText().toString().trim().isEmpty()) {
            this.lyNewPin.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(this.txNewPin);
            return false;
        }
        if (this.txNewPin.getText().toString().trim().length() != 4) {
            this.lyNewPin.setError(getString(R.string.err_msg_len_newpin_bolsa));
            requestFocus(this.txNewPin);
            return false;
        }
        this.lyNewPin.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        if (this.txRepeatPin.getText().toString().trim().isEmpty()) {
            this.lyRepeatPin.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(this.txRepeatPin);
            return false;
        }
        if (this.txRepeatPin.getText().toString().trim().length() != 4) {
            this.lyRepeatPin.setError(getString(R.string.err_msg_len_repeatpin_bolsa));
            requestFocus(this.txRepeatPin);
            return false;
        }
        if (!this.txRepeatPin.getText().toString().equals(this.txNewPin.getText().toString())) {
            this.lyNewPin.setError(getString(R.string.err_msg_match_pin_bolsa));
            requestFocus(this.txNewPin);
            return false;
        }
        this.lyNewPin.setErrorEnabled(false);
        return true;
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
