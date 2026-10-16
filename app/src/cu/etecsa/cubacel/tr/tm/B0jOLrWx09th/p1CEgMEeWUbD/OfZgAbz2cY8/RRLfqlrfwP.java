package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

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
public class RRLfqlrfwP extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNewpin;
    private TextInputLayout inputLayoutPin;
    private TextInputLayout inputLayoutRepeatpin;
    private AutoCompleteTextView inputNewpin;
    private AutoCompleteTextView inputPin;
    private AutoCompleteTextView inputRepeatpin;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.wlxfpg1873ndx, container, false);
        this.context = container.getContext();
        this.inputLayoutPin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputPin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutNewpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_newpin);
        this.inputNewpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_newpin);
        this.inputLayoutRepeatpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_repeat_pin);
        this.inputRepeatpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_repeat_pin);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.RRLfqlrfwP.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RRLfqlrfwP.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validatePin() || !validateNewPin() || !validateRepeatPin()) {
            return;
        }
        String pin = this.inputPin.getText().toString().trim() + "*" + this.inputNewpin.getText().toString().trim() + "*" + this.inputRepeatpin.getText().toString().trim();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmChangePassBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "75", pin, "¿Desea solicitar el cambio de su PIN de multibanca?", group, getFragmentManager());
    }

    private boolean validatePin() {
        if (this.inputPin.getText().toString().trim().isEmpty()) {
            this.inputLayoutPin.setError(getString(R.string.hint_pin_banco_actual));
            requestFocus(this.inputPin);
            return false;
        }
        if (this.inputPin.getText().toString().trim().length() != 4) {
            this.inputLayoutPin.setError(getString(R.string.err_msg_len_pin_banco_bandec));
            requestFocus(this.inputPin);
            return false;
        }
        this.inputLayoutPin.setErrorEnabled(false);
        return true;
    }

    private boolean validateNewPin() {
        if (this.inputNewpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutNewpin.setError(getString(R.string.hint_pin_new_banco));
            requestFocus(this.inputNewpin);
            return false;
        }
        if (this.inputNewpin.getText().toString().trim().length() != 4) {
            this.inputLayoutNewpin.setError(getString(R.string.err_msg_len_pin_banco_bandec));
            requestFocus(this.inputNewpin);
            return false;
        }
        this.inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        if (this.inputRepeatpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutRepeatpin.setError(getString(R.string.hint_pin_rep_banco));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        if (this.inputRepeatpin.getText().toString().trim().length() != 4) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_len_pin_banco_bandec));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        if (!this.inputRepeatpin.getText().toString().equals(this.inputNewpin.getText().toString())) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_match_pin));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        this.inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
