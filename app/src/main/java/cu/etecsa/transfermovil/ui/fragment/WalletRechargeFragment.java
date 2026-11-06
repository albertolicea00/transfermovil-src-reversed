package cu.etecsa.transfermovil.ui.fragment;

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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

public class WalletRechargeFragment extends Fragment implements pAzq93vIl3.UssdResponseObserver {

    public Context context;
    public View rootView;
    public pAzq93vIl3 manager;
    private Button btnAceptar;
    private TextInputLayout lyMonto;
    private AutoCompleteTextView txMonto;
    private boolean pagoTotal;
    private boolean isPartialUSSD;
    private boolean isDirectScan;
    private final int maxParametersPerPacket = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = container.getContext();
        this.manager = new pAzq93vIl3(context, this);
        this.rootView = inflater.inflate(R.layout.nfoph5kavkjek, container, false);
        this.lyMonto = (TextInputLayout) rootView.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) rootView.findViewById(R.id.txMonto);
        this.lyMonto.setHint(getString(R.string.monto_moneda_en_cuc));
        this.btnAceptar = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar.setOnClickListener(view -> submitForm());
        return rootView;
    }

    private void submitForm() {
        if (!validateAmount()) return;
        String amount = txMonto.getText().toString().trim();
        String message = "¿ Desea solicitar un ticket para el depósito en cadeca a su cuenta CUP , con el monto en CUP: "
                + amount + " ?";
        String payload = amount + "*CUP";
        ViewGroup form = (ViewGroup) rootView.findViewById(R.id.frmBanco);
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception ignored) {
            isPartialUSSD = false;
        }
        if (!isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(context, "17", payload, message, form, getParentFragmentManager());
        } else {
            manager.principalEnviarUSSD(context, "110", "17", "04", maxParametersPerPacket,
                    payload, message, form, getParentFragmentManager());
        }
    }

    private boolean validateAmount() {
        if (pagoTotal) return true;
        String amount = txMonto.getText().toString().trim();
        if (amount.isEmpty()) {
            lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(txMonto);
            return false;
        }
        try {
            if (Float.parseFloat(amount) < 1.0f) {
                lyMonto.setError(getString(R.string.err_msg_importe_inferior));
                requestFocus(txMonto);
                return false;
            }
            lyMonto.setErrorEnabled(false);
            return true;
        } catch (NumberFormatException ignored) {
            lyMonto.setError("Monto incorrecto");
            requestFocus(txMonto);
            return false;
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) getActivity().getWindow().setSoftInputMode(5);
    }

    @Override
    public void onUssdResponseReceived(String response) {
        // The source implementation does not process the response here.
    }

    @Override
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (isPartialUSSD && isDirectScan) fragmentManager.popBackStack();
        } catch (Exception ignored) {
            try {
                getActivity().onBackPressed();
            } catch (Exception ignoredAgain) {
                // Match the source's best-effort fallback when the host is unavailable.
            }
        }
    }
}
