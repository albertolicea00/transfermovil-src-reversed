package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/* JADX INFO: loaded from: classes.dex */
public class umjSGajOy3 extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public int MAX_PARAMETERS_PQUETE = 3;
    private Button btnAceptar;
    public Context context;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCi;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputClaveNueva;
    private TextInputLayout inputLayoutCi;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutClaveNueva;
    private TextInputLayout inputLayoutRepetirNueva;
    private AutoCompleteTextView inputRepetirNueva;
    public int keyDel;
    public boolean lock;
    public pAzq93vIl3 manager;
    public View rootView;
    public Drawable tarjeta_bfi;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.bb7c2wk75gr3t, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCi = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutClaveNueva = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_clave_nueva);
        this.inputClaveNueva = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave_nueva);
        this.inputLayoutRepetirNueva = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_repetir_nueva);
        this.inputRepetirNueva = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_repetir_nueva);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.umjSGajOy3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                umjSGajOy3.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        boolean isPartialUSSD;
        if (!validateCi() || !validateClave() || !validateClaveNueva() || !validateRepeatPin()) {
            return;
        }
        String clave = this.inputClave.getText().toString().trim();
        String clave_nueva = this.inputClaveNueva.getText().toString().trim();
        String ci = this.inputCi.getText().toString().trim();
        String cadena = "05*" + clave + "*" + clave_nueva + "*" + ci;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBancoBFI);
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
            isPartialUSSD = false;
        }
        if (!isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "49", cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "49", "05", this.MAX_PARAMETERS_PQUETE, cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        }
    }

    private boolean validateCi() {
        if (this.inputCi.getText().toString().trim().isEmpty()) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_len_ci_all));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutClave.setError(BuildConfig.FLAVOR);
            this.inputLayoutRepetirNueva.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutRepetirNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutRepetirNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
        return true;
    }

    private boolean validateClaveNueva() {
        if (this.inputClaveNueva.getText().toString().trim().isEmpty()) {
            this.inputLayoutClaveNueva.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClaveNueva);
            return false;
        }
        if (this.inputClaveNueva.getText().toString().trim().length() != 4) {
            this.inputLayoutClaveNueva.setError(getString(R.string.err_msg_len_clave_banco));
            requestFocus(this.inputClaveNueva);
            return false;
        }
        this.inputLayoutClaveNueva.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        if (this.inputRepetirNueva.getText().toString().trim().isEmpty()) {
            this.inputLayoutRepetirNueva.setError(getString(R.string.err_msg_empty_repeatpin));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutClave.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputRepetirNueva);
            return false;
        }
        if (this.inputRepetirNueva.getText().toString().trim().length() != 4) {
            this.inputLayoutRepetirNueva.setError(getString(R.string.err_msg_len_repeatpin));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutClave.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputRepetirNueva);
            return false;
        }
        if (!this.inputRepetirNueva.getText().toString().equals(this.inputClaveNueva.getText().toString())) {
            this.inputLayoutRepetirNueva.setError(getString(R.string.err_msg_match_pin));
            this.inputLayoutClaveNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutClave.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputRepetirNueva);
            return false;
        }
        if (this.inputClave.getText().toString().equals(this.inputClaveNueva.getText().toString())) {
            this.inputLayoutClaveNueva.setError(getString(R.string.err_msg_clave_igual));
            this.inputLayoutRepetirNueva.setError(BuildConfig.FLAVOR);
            this.inputLayoutClave.setError(BuildConfig.FLAVOR);
            this.inputLayoutCi.setError(BuildConfig.FLAVOR);
            requestFocus(this.inputClaveNueva);
            return false;
        }
        this.inputLayoutRepetirNueva.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public String reemplazarCaracteresRaros(String input) {
        String output = input;
        for (int i = 0; i < "àèìòùÀÉËÌÓÚçÇ".length(); i++) {
            output = output.replace("àèìòùÀÉËÌÓÚçÇ".charAt(i), "aeiouAEIIOUcC".charAt(i));
        }
        return output;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
