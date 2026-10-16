package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
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
public class B0Bcr9KURy extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNewpin;
    private TextInputLayout inputLayoutRepeatpin;
    private AutoCompleteTextView inputNewpin;
    private AutoCompleteTextView inputRepeatpin;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.xnef61mpzqomc, container, false);
        this.context = container.getContext();
        this.inputLayoutNewpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_newpin);
        this.inputNewpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_newpin);
        this.inputLayoutRepeatpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_repeat_pin);
        this.inputRepeatpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_repeat_pin);
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputNewpin.setFilters(fArray);
        this.inputRepeatpin.setFilters(fArray);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.B0Bcr9KURy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                B0Bcr9KURy.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validatePin() || !validateRepeatPin()) {
            return;
        }
        String pin = this.inputNewpin.getText().toString().trim();
        String msg = getString(R.string.confirm_cambio_clave);
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmChangePassBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "69", pin, msg, group, getFragmentManager());
    }

    private boolean validatePin() {
        if (this.inputNewpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutNewpin.setError(getString(R.string.err_msg_empty_newpin));
            requestFocus(this.inputNewpin);
            return false;
        }
        if (this.inputNewpin.getText().toString().trim().length() != 4) {
            this.inputLayoutNewpin.setError(getString(R.string.err_msg_len_newpin));
            requestFocus(this.inputNewpin);
            return false;
        }
        this.inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        if (this.inputRepeatpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_empty_repeatpin));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        if (this.inputRepeatpin.getText().toString().trim().length() != 4) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_len_repeatpin));
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
