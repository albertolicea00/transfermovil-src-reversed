package cu.etecsa.transfermovil.banking.ui.metro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Fragment for converting a CUC account to CUP at the Metropolitano/BFI bank.
 * Extends QGQCqILT4b (base banking fragment with account selector).
 * User selects a source account; fragment sends USSD code "87" with the account number.
 * Confirmation: "¿Desea cambiar su cuenta {cuentaOrigen} en CUC a CUP?"
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.XupYdyDxle
 * @fingerprint Metro/BFI CUC-to-CUP account conversion fragment (USSD 87)
 */
public class MetroConvertirCuentaFragment /* extends QGQCqILT4b */ {

    private Button btnAceptar;
    public String tipoServicio = "0";
    public TextView toolbar_title;

    // Inherited from QGQCqILT4b:
    // public View rootView;
    // public Context context;
    // public String cuentaOrigen;

    // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflates layout: R.layout.y2c4tmczn3yyyt
        // rootView = inflater.inflate(R.layout.y2c4tmczn3yyyt, container, false);
        // context = container.getContext();
        // DatabaseHelper.init(context);

        // toolbar_title = rootView.findViewById(R.id.toolbar_title);
        // toolbar_title.setText("Convertir Cuenta CUC a CUP");

        // initComponentesCuentas(rootView, BankType.BFI);

        // btnAceptar = rootView.findViewById(R.id.btn_aceptar);
        // btnAceptar.setOnClickListener(view -> submitForm());

        return null; // stub
    }

    /**
     * Validates account selection, then sends USSD code "87"
     * with payload = cuentaOrigen.
     * Confirmation: "¿Desea cambiar su cuenta {cuentaOrigen} en CUC a CUP?"
     */
    // @Override
    public void submitForm() {
        // super.submitForm();
        // if (!validateSelectionAccounts()) return;
        // nuevoDatos();

        // String msg = "¿Desea cambiar su cuenta " + cuentaOrigen + " en CUC a CUP?";
        // String cadena = cuentaOrigen;
        // ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmView);
        // FBsQzP3Zfj.actionCallUSSDBack(context, "87", cadena, msg, group, getFragmentManager());
    }

    // @Override
    public void nuevoDatos() { /* no-op override */ }
}
