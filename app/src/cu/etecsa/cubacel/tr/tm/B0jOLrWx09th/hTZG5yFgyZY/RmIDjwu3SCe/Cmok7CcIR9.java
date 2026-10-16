package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
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

/* JADX INFO: loaded from: classes.dex */
public class Cmok7CcIR9 extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayout;
    private TextInputLayout inputLayoutNewpin;
    private TextInputLayout inputLayoutRepeatpin;
    private AutoCompleteTextView inputNewpin;
    private AutoCompleteTextView inputPin;
    private AutoCompleteTextView inputRepeatpin;
    public pAzq93vIl3 manager;
    public View rootView;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.h6iqrixxcdpdgn, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputLayout = textInputLayout;
        textInputLayout.setVisibility(0);
        this.inputPin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutNewpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_newpin);
        this.inputNewpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_newpin);
        this.inputLayoutRepeatpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_repeat_pin);
        this.inputRepeatpin = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_repeat_pin);
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputPin.setFilters(fArray);
        this.inputNewpin.setFilters(fArray);
        this.inputRepeatpin.setFilters(fArray);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.Cmok7CcIR9.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Cmok7CcIR9.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validatePinActual() || !validatePin() || !validateRepeatPin()) {
            return;
        }
        String pin = this.inputPin.getText().toString().trim() + "*" + this.inputNewpin.getText().toString().trim();
        String msg = getString(R.string.confirm_cambio_clave_bolsa);
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmChangePassBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "69", pin, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "69", "04", this.MAX_PARAMETERS_PQUETE, pin, msg, group, getFragmentManager());
        }
    }

    private boolean validatePinActual() {
        if (this.inputPin.getText().toString().trim().isEmpty()) {
            this.inputLayout.setError(getString(R.string.err_msg_empty_newpin_bolsa));
            requestFocus(this.inputPin);
            return false;
        }
        if (this.inputPin.getText().toString().trim().length() != 4) {
            this.inputLayout.setError(getString(R.string.tx_escriba_clave_actual_bolsa));
            requestFocus(this.inputPin);
            return false;
        }
        this.inputLayout.setErrorEnabled(false);
        return true;
    }

    private boolean validatePin() {
        if (this.inputNewpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutNewpin.setError(getString(R.string.err_msg_empty_newpin_bolsa));
            requestFocus(this.inputNewpin);
            return false;
        }
        if (this.inputNewpin.getText().toString().trim().length() != 4) {
            this.inputLayoutNewpin.setError(getString(R.string.err_msg_len_newpin_bolsa));
            requestFocus(this.inputNewpin);
            return false;
        }
        this.inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        if (this.inputRepeatpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        if (this.inputRepeatpin.getText().toString().trim().length() != 4) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_len_repeatpin_bolsa));
            requestFocus(this.inputRepeatpin);
            return false;
        }
        if (!this.inputRepeatpin.getText().toString().equals(this.inputNewpin.getText().toString())) {
            this.inputLayoutRepeatpin.setError(getString(R.string.err_msg_match_pin_bolsa));
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
