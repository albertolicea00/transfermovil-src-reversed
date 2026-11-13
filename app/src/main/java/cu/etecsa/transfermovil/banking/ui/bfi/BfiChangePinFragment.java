package cu.etecsa.transfermovil.banking.ui.bfi;

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
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.KvpkEH7lRr */
public class BfiChangePinFragment extends Fragment {
    private Context context;
    private TextInputLayout inputLayout;
    private TextInputLayout inputLayoutNewpin;
    private TextInputLayout inputLayoutRepeatpin;
    private AutoCompleteTextView inputPin;
    private AutoCompleteTextView inputNewpin;
    private AutoCompleteTextView inputRepeatpin;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.xnef61mpzqomc, container, false);
        context = container.getContext();
        inputLayout = rootView.findViewById(R.id.input__layout_clave);
        inputLayout.setVisibility(View.VISIBLE);
        inputPin = rootView.findViewById(R.id.input_clave);
        inputLayout.setHint(getString(R.string.hint_pin_banco_actual));
        inputLayoutNewpin = rootView.findViewById(R.id.input__layout_newpin);
        inputNewpin = rootView.findViewById(R.id.input_newpin);
        inputLayoutNewpin.setHint(getString(R.string.hint_pin_new_banco));
        inputLayoutRepeatpin = rootView.findViewById(R.id.input__layout_repeat_pin);
        inputRepeatpin = rootView.findViewById(R.id.input_repeat_pin);
        inputLayoutRepeatpin.setHint(getString(R.string.hint_repeatclave_bolsa));
        InputFilter[] fourDigits = {new InputFilter.LengthFilter(4)};
        inputPin.setFilters(fourDigits);
        inputNewpin.setFilters(fourDigits);
        inputRepeatpin.setFilters(fourDigits);
        Button accept = rootView.findViewById(R.id.btn_aceptar);
        accept.setOnClickListener(view -> submitForm());
        return rootView;
    }

    private void submitForm() {
        String oldPin = inputPin.getText().toString().trim();
        String newPin = inputNewpin.getText().toString().trim();
        String repeatedPin = inputRepeatpin.getText().toString().trim();
        if (oldPin.isEmpty()) {
            inputLayout.setError(getString(R.string.err_msg_empty_newpin));
            requestFocus(inputPin);
            return;
        }
        if (oldPin.length() != 4) {
            inputLayout.setError("Escriba clave actual");
            requestFocus(inputPin);
            return;
        }
        inputLayout.setErrorEnabled(false);
        if (!validate(inputNewpin, inputLayoutNewpin, newPin, R.string.err_msg_empty_newpin, R.string.err_msg_len_newpin)
                || !validate(inputRepeatpin, inputLayoutRepeatpin, repeatedPin, R.string.err_msg_empty_repeatpin, R.string.err_msg_len_repeatpin, false)) return;
        if (!inputRepeatpin.getText().toString().equals(inputNewpin.getText().toString())) {
            inputLayoutRepeatpin.setError(getString(R.string.err_msg_match_pin));
            requestFocus(inputRepeatpin);
            return;
        }
        inputLayoutNewpin.setErrorEnabled(false);
        String payload = "05*" + oldPin + "*" + newPin;
        ViewGroup form = rootView.findViewById(R.id.frmChangePassBanco);
        UssdDispatcher.actionCallUSSDBack(context, "69", payload, getString(R.string.confirm_cambio_clave), form, getFragmentManager());
    }

    private boolean validate(AutoCompleteTextView field, TextInputLayout layout, String value, int emptyError, int lengthError) {
        return validate(field, layout, value, emptyError, lengthError, true);
    }

    private boolean validate(AutoCompleteTextView field, TextInputLayout layout, String value,
                              int emptyError, int lengthError, boolean clearErrorOnSuccess) {
        if (value.isEmpty()) {
            layout.setError(getString(emptyError));
            requestFocus(field);
            return false;
        }
        if (value.length() != 4) {
            layout.setError(getString(lengthError));
            requestFocus(field);
            return false;
        }
        if (clearErrorOnSuccess) layout.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) getActivity().getWindow().setSoftInputMode(5);
    }
}
