package cu.etecsa.transfermovil.banking.ui.metro;

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

/**
 * Fragment for changing the Metropolitano bank card PIN.
 * Collects current PIN, new PIN, and PIN confirmation (all 4 digits).
 * Sends USSD code "69" with payload "05*{currentPin}*{newPin}".
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.KvpkEH7lRr
 * @fingerprint Metro bank PIN change fragment (USSD 69)
 */
public class MetroCambiarClaveFragment extends Fragment {

    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayout;
    private TextInputLayout inputLayoutNewpin;
    private TextInputLayout inputLayoutRepeatpin;
    private AutoCompleteTextView inputNewpin;
    private AutoCompleteTextView inputPin;
    private AutoCompleteTextView inputRepeatpin;
    public View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflates layout: R.layout.xnef61mpzqomc
        this.rootView = inflater.inflate(/* R.layout.xnef61mpzqomc */ 0, container, false);
        this.context = container.getContext();

        // Current PIN field
        this.inputLayout = (TextInputLayout) rootView.findViewById(/* R.id.input__layout_clave */ 0);
        this.inputLayout.setVisibility(View.VISIBLE);
        this.inputPin = (AutoCompleteTextView) rootView.findViewById(/* R.id.input_clave */ 0);
        this.inputLayout.setHint(getString(/* R.string.hint_pin_banco_actual */ 0));

        // New PIN field
        this.inputLayoutNewpin = (TextInputLayout) rootView.findViewById(/* R.id.input__layout_newpin */ 0);
        this.inputNewpin = (AutoCompleteTextView) rootView.findViewById(/* R.id.input_newpin */ 0);
        this.inputLayoutNewpin.setHint(getString(/* R.string.hint_pin_new_banco */ 0));

        // Repeat PIN field
        this.inputLayoutRepeatpin = (TextInputLayout) rootView.findViewById(/* R.id.input__layout_repeat_pin */ 0);
        this.inputRepeatpin = (AutoCompleteTextView) rootView.findViewById(/* R.id.input_repeat_pin */ 0);
        this.inputLayoutRepeatpin.setHint(getString(/* R.string.hint_repeatclave_bolsa */ 0));

        // All PIN fields limited to 4 characters
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputPin.setFilters(fArray);
        this.inputNewpin.setFilters(fArray);
        this.inputRepeatpin.setFilters(fArray);

        this.btnAceptar = (Button) rootView.findViewById(/* R.id.btn_aceptar */ 0);
        this.btnAceptar.setOnClickListener(view -> submitForm());

        return this.rootView;
    }

    /**
     * Validates all three PIN fields, then sends USSD code "69"
     * with payload "05*{currentPin}*{newPin}".
     * Confirmation message: R.string.confirm_cambio_clave
     */
    private void submitForm() {
        if (!validatePinActual() || !validatePin() || !validateRepeatPin()) {
            return;
        }
        String pin = "05*" + inputPin.getText().toString().trim()
                + "*" + inputNewpin.getText().toString().trim();
        String msg = getString(/* R.string.confirm_cambio_clave */ 0);
        ViewGroup group = (ViewGroup) rootView.findViewById(/* R.id.frmChangePassBanco */ 0);
        // FBsQzP3Zfj.actionCallUSSDBack(context, "69", pin, msg, group, getFragmentManager());
    }

    /**
     * Validates current PIN is non-empty and exactly 4 digits.
     * Error on invalid: "Escriba clave actual"
     */
    private boolean validatePinActual() {
        if (inputPin.getText().toString().trim().isEmpty()) {
            inputLayout.setError(getString(/* R.string.err_msg_empty_newpin */ 0));
            requestFocus(inputPin);
            return false;
        }
        if (inputPin.getText().toString().trim().length() != 4) {
            inputLayout.setError("Escriba clave actual");
            requestFocus(inputPin);
            return false;
        }
        inputLayout.setErrorEnabled(false);
        return true;
    }

    /** Validates new PIN is non-empty and exactly 4 digits. */
    private boolean validatePin() {
        if (inputNewpin.getText().toString().trim().isEmpty()) {
            inputLayoutNewpin.setError(getString(/* R.string.err_msg_empty_newpin */ 0));
            requestFocus(inputNewpin);
            return false;
        }
        if (inputNewpin.getText().toString().trim().length() != 4) {
            inputLayoutNewpin.setError(getString(/* R.string.err_msg_len_newpin */ 0));
            requestFocus(inputNewpin);
            return false;
        }
        inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    /** Validates repeat PIN matches the new PIN. */
    private boolean validateRepeatPin() {
        if (inputRepeatpin.getText().toString().trim().isEmpty()) {
            inputLayoutRepeatpin.setError(getString(/* R.string.err_msg_empty_repeatpin */ 0));
            requestFocus(inputRepeatpin);
            return false;
        }
        if (inputRepeatpin.getText().toString().trim().length() != 4) {
            inputLayoutRepeatpin.setError(getString(/* R.string.err_msg_len_repeatpin */ 0));
            requestFocus(inputRepeatpin);
            return false;
        }
        if (!inputRepeatpin.getText().toString().equals(inputNewpin.getText().toString())) {
            inputLayoutRepeatpin.setError(getString(/* R.string.err_msg_match_pin */ 0));
            requestFocus(inputRepeatpin);
            return false;
        }
        inputLayoutNewpin.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
