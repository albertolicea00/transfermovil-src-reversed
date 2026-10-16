package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;

/* JADX INFO: loaded from: classes.dex */
public class F5QGj1YaNB extends Fragment {
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputCi;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCi;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutCuenta;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.q1qecsmobxewfy, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.hint_tarj_telebanca));
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCi = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.F5QGj1YaNB.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                F5QGj1YaNB.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateClave() || !validateCi()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String pin = this.inputClave.getText().toString().trim();
        String ci = this.inputCi.getText().toString().trim();
        String cadena = "03*" + ci + "*" + pin + "*" + cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "68", cadena, "Desea eliminar su registro del sistema", group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty() || !this.inputCuenta.getText().toString().trim().substring(0, 2).contains("95")) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_err_tarjeta_telebanca));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 10) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_tarjeta_telebanca));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCi() {
        if (this.inputCi.getText().toString().trim().isEmpty()) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
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
}
