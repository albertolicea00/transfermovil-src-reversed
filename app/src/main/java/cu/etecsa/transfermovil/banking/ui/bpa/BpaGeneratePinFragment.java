package cu.etecsa.transfermovil.banking.ui.bpa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import cu.etecsa.transfermovil.banking.BankOperationBaseFragment;
import cu.etecsa.transfermovil.banking.BankType;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.transfermovil.ussd.UssdFormManager;

/**
 * BPA fragment for generating a PIN code (non-printed PIN).
 * <p>
 * Sends USSD code "79" (or partial "110"/"79"/"01") with currency and account.
 * On successful USSD response, navigates back to the parent fragment via
 * fragment result "returnToA".
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.uLySWsCVTv
 * @original_apk_version 1.260416
 */
public class BpaGeneratePinFragment extends BankOperationBaseFragment {

    private Button btnAceptar;
    public String tipoServicio = "0";
    public TextView toolbar_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.jozkrainwpt1o, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new UssdFormManager(context, this);
        DatabaseHelper.init(this.context);

        TextView textView = (TextView) rootView.findViewById(R.id.toolbar_title);
        toolbar_title = textView;
        textView.setText(getString(R.string.hint_pin_no_impreso));

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
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cadena = monedaTarjeta + "*" + cuentaOrigen;
        ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmView);
        if (!isPartialUSSD) {
            UssdDispatcher.actionCallUSSDBack(context, "79", cadena,
                    "¿Confirme que desea generar el código pin?",
                    group, getFragmentManager());
        } else {
            manager.principalEnviarUSSD(context, "110", "79", "01",
                    MAX_PARAMETERS_PQUETE, cadena,
                    "¿Confirme que desea generar el código pin?",
                    group, getFragmentManager());
        }
    }

    @Override
    public void nuevoDatos() {
    }

    @Override
    public void onUssdResponseReceived(String response) {
        FragmentManager fragmentManager = getFragmentManager();
        Bundle result = new Bundle();
        result.putBoolean("returning", true);
        fragmentManager.setFragmentResult("returnToA", result);
        fragmentManager.popBackStack();
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
