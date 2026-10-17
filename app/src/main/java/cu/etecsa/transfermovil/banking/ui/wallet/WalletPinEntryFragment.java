package cu.etecsa.transfermovil.banking.ui.wallet;

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
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qZS87tGogtP.R5fFZkKuVnr
 *
 * 4-digit PIN entry for wallet authentication.
 * Sends USSD: *04*40*{04*pin}# to authenticate wallet session.
 */
public class WalletPinEntryFragment extends Fragment {

    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputClave;
    private TextInputLayout inputLayoutClave;
    public View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.cd2rithgghw6z, container, false);
        this.context = container.getContext();
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.lyClave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.txClave);
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputClave.setFilters(fArray);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WalletPinEntryFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    void submitForm() {
        if (!validateClave()) {
            return;
        }
        String clave = "04*" + this.inputClave.getText().toString().trim();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmAuthBolsa);
        UssdDispatcher.actionCallUSSDBack("04", this.context, "40", clave,
                "Desea autenticarse en el sistema", group, getFragmentManager(), getActivity());
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clave_bolsa));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_newpin_bolsa));
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
}
