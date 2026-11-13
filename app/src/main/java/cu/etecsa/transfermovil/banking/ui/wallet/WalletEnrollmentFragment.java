package cu.etecsa.transfermovil.banking.ui.wallet;

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
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.eUkRSfpCKs */
public class WalletEnrollmentFragment extends Fragment
        implements pAzq93vIl3.UssdResponseObserver {
    private Context context;
    private View rootView;
    private pAzq93vIl3 manager;
    private TextInputLayout lyCI;
    private TextInputLayout lyNewPin;
    private TextInputLayout lyRepeatPin;
    private AutoCompleteTextView txCI;
    private AutoCompleteTextView txNewPin;
    private AutoCompleteTextView txRepeatPin;
    private boolean isPartialUSSD;
    private boolean isDirectScan;
    private static final int MAX_PACKET_PARAMETERS = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        rootView = inflater.inflate(R.layout.logr8gwypgplk, container, false);
        context = container.getContext();
        manager = new pAzq93vIl3(context, this);
        lyCI = rootView.findViewById(R.id.lyCI);
        txCI = rootView.findViewById(R.id.txCI);
        TextInputLayout lyEmail = rootView.findViewById(R.id.lyEmail);
        lyEmail.setVisibility(View.GONE);
        lyNewPin = rootView.findViewById(R.id.lyNewPin);
        txNewPin = rootView.findViewById(R.id.txNewPin);
        lyRepeatPin = rootView.findViewById(R.id.lyRepeatPin);
        txRepeatPin = rootView.findViewById(R.id.txRepeatPin);
        Button accept = rootView.findViewById(R.id.btn_aceptar);
        accept.setOnClickListener(view -> submitForm());
        return rootView;
    }

    private void submitForm() {
        if (!validateCi() || !validatePin() || !validateRepeatPin()) return;
        String ci = txCI.getText().toString().trim();
        String pin = txNewPin.getText().toString().trim();
        String payload = "04*0000*" + ci + "*" + pin;
        ViewGroup form = rootView.findViewById(R.id.frmRegistroBanco);
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists()
                    .get(0).isActivarussdparcial();
        } catch (Exception ignored) {
            isPartialUSSD = false;
        }
        if (!isPartialUSSD) {
            UssdDispatcher.actionCallUSSDBack(context, "49", payload,
                    "Desea registrarse en el sistema", form, getFragmentManager());
        } else {
            manager.principalEnviarUSSD(context, "110", "49", "04",
                    MAX_PACKET_PARAMETERS, payload,
                    "Desea registrarse en el sistema", form, getFragmentManager());
        }
    }

    private boolean validateCi() {
        if (txCI.getText().toString().trim().isEmpty()) {
            lyCI.setError(getString(R.string.err_msg_len_ci_all_bolsa));
            requestFocus(txCI);
            return false;
        }
        lyCI.setErrorEnabled(false);
        return true;
    }

    private boolean validatePin() {
        String pin = txNewPin.getText().toString().trim();
        if (pin.isEmpty()) {
            lyNewPin.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(txNewPin);
            return false;
        }
        if (pin.length() != 4) {
            lyNewPin.setError(getString(R.string.err_msg_len_newpin_bolsa));
            requestFocus(txNewPin);
            return false;
        }
        lyNewPin.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepeatPin() {
        String repeated = txRepeatPin.getText().toString().trim();
        if (repeated.isEmpty()) {
            lyRepeatPin.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(txRepeatPin);
            return false;
        }
        if (repeated.length() != 4) {
            lyRepeatPin.setError(getString(R.string.err_msg_len_repeatpin_bolsa));
            requestFocus(txRepeatPin);
            return false;
        }
        if (!txRepeatPin.getText().toString().equals(txNewPin.getText().toString())) {
            lyNewPin.setError(getString(R.string.err_msg_match_pin_bolsa));
            requestFocus(txNewPin);
            return false;
        }
        lyNewPin.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus() && getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    @Override
    public void onUssdResponseReceived(String response) { }

    @Override
    public void onCloseAndBack() {
        try {
            FragmentManager fragments = getActivity().getSupportFragmentManager();
            fragments.popBackStack();
            if (isPartialUSSD && isDirectScan) fragments.popBackStack();
        } catch (Exception ignored) {
            if (getActivity() != null) getActivity().onBackPressed();
        }
    }
}
