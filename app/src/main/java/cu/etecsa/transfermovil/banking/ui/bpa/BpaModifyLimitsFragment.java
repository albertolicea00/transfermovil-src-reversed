package cu.etecsa.transfermovil.banking.ui.bpa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputLayout;

import cu.etecsa.transfermovil.banking.BankOperationBaseFragment;
import cu.etecsa.transfermovil.banking.BankType;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/**
 * BPA fragment for temporarily modifying ATM/POS transaction limits.
 * <p>
 * Collects ATM limit, POS limit (auto-computes total), validates both are
 * positive, then sends USSD code "61" with "atm*pos*total*currency*account".
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.qmcwKV1fzU
 * @original_apk_version 1.260416
 */
public class BpaModifyLimitsFragment extends BankOperationBaseFragment {

    private Button btnAceptar;
    private AutoCompleteTextView inputATM;
    private TextInputLayout inputLayoutATM;
    private TextInputLayout inputLayoutPOS;
    private TextInputLayout inputLayoutTOTAL;
    private AutoCompleteTextView inputPOS;
    private AutoCompleteTextView inputTOTAL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.vx38bjtn0eckz, container, false);
        context = container.getContext();

        inputLayoutATM = (TextInputLayout) rootView.findViewById(R.id.input__layout_atm);
        inputATM = (AutoCompleteTextView) rootView.findViewById(R.id.input_atm);
        inputLayoutPOS = (TextInputLayout) rootView.findViewById(R.id.input__layout_pos);
        inputPOS = (AutoCompleteTextView) rootView.findViewById(R.id.input_pos);
        inputLayoutTOTAL = (TextInputLayout) rootView.findViewById(R.id.input__layout_total);
        inputTOTAL = (AutoCompleteTextView) rootView.findViewById(R.id.input_limite_total);
        inputLayoutTOTAL.setVisibility(View.GONE);

        initComponentesCuentas(rootView, BankType.BPA);

        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        return rootView;
    }

    @Override
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateSumaApp() || !validateSelectionAccounts()) {
            return;
        }

        String atm = inputATM.getText().toString().trim();
        String pos = inputPOS.getText().toString().trim();

        int sumaTotal = 0;
        try {
            int atmValue = Integer.parseInt(atm);
            int posValue = Integer.parseInt(pos);
            sumaTotal = atmValue + posValue;
        } catch (Exception e) {
        }
        String total = String.valueOf(sumaTotal);

        String msg = String.format(
                "¿Desea modificar los límites temporalmente de sus cuentas bancarias? "
                        + "Límites temporales establecidos: ATM: %s, POS:%s y Total: %s.",
                atm, pos, total);
        String cadena = atm + "*" + pos + "*" + total + "*" + monedaTarjeta + "*" + cuentaOrigen;
        ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmLimiteBanco);
        UssdDispatcher.actionCallUSSDBack(context, "61", cadena, msg, group, getFragmentManager());
    }

    @Override
    public void nuevoDatos() {
    }

    /**
     * Validates that both ATM and POS input fields are non-empty.
     */
    private boolean validateCuenta() {
        if (inputATM.getText().toString().trim().isEmpty()) {
            inputLayoutATM.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(inputATM);
            return false;
        }
        inputLayoutATM.setErrorEnabled(false);

        if (inputPOS.getText().toString().trim().isEmpty()) {
            inputLayoutPOS.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(inputPOS);
            return false;
        }
        inputLayoutPOS.setErrorEnabled(false);
        return true;
    }

    /**
     * Validates that both ATM and POS values are positive numbers.
     */
    private boolean validateSumaApp() {
        try {
            float atm = Float.parseFloat(inputATM.getText().toString().trim());
            float pos = Float.parseFloat(inputPOS.getText().toString().trim());

            if (atm > 0.0f) {
                inputLayoutATM.setErrorEnabled(false);
                if (pos > 0.0f) {
                    inputLayoutPOS.setErrorEnabled(false);
                    return true;
                }
                inputLayoutPOS.setError("El valor de POS debe ser mayor que cero");
                requestFocus(inputPOS);
                return false;
            }
            inputLayoutATM.setError("El valor de ATM debe ser mayor que cero");
            requestFocus(inputATM);
            return false;
        } catch (Exception e) {
            inputLayoutATM.setError("Valor incorrecto");
            requestFocus(inputATM);
            inputLayoutPOS.setError("Valor incorrecto");
            return false;
        }
    }

    @Override
    public void onUssdResponseReceived(String response) {
    }

    @Override
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
