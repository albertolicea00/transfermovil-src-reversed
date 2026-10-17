package cu.etecsa.transfermovil.banking.ui.bpa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cu.etecsa.transfermovil.banking.BankOperationBaseFragment2;
import cu.etecsa.transfermovil.banking.BankType;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/**
 * BPA fragment for converting a CUC account to CUP.
 * <p>
 * Extends the secondary base fragment (QGQCqILT4b). Sends USSD code "87"
 * with the account number. Used during the CUC-to-CUP currency unification process.
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.ZZ6L6QderZ
 * @original_apk_version 1.260416
 */
public class BpaConvertCucToCupFragment extends BankOperationBaseFragment2 {

    private Button btnAceptar;
    public String tipoServicio = "0";
    public TextView toolbar_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.y2c4tmczn3yyyt, container, false);
        Context context = container.getContext();
        this.context = context;
        DatabaseHelper.init(context);

        TextView textView = (TextView) rootView.findViewById(R.id.toolbar_title);
        toolbar_title = textView;
        textView.setText("Convertir Cuenta CUC a CUP");

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
        String msg = "¿Desea cambiar su cuenta " + cuentaOrigen + " en CUC a CUP?";
        String cadena = cuentaOrigen;
        ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmView);
        UssdDispatcher.actionCallUSSDBack(context, "87", cadena, msg, group, getFragmentManager());
    }

    @Override
    public void nuevoDatos() {
    }
}
