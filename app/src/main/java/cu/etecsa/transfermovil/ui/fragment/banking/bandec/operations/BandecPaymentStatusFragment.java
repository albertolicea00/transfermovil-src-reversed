package cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.XKpe29TPn0 */
public class BandecPaymentStatusFragment extends BandecAccountSelectionFragment {
    private Button btnAceptar;
    public TextInputLayout lyReferencia;
    public String tipoServicio = "0";
    public TextView toolbar_title;
    public AutoCompleteTextView txReferencia;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.nhzdbui6st2dw, container, false);
        Context context = container.getContext();
        this.context = context;
        DatabaseHelper.init(context);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.title_consultar_estado_pago_banco);
        this.lyReferencia = (TextInputLayout) this.rootView.findViewById(R.id.lyReferencia);
        this.txReferencia = (AutoCompleteTextView) this.rootView.findViewById(R.id.txReferencia);
        initComponentesCuentas(this.rootView, BankType.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.XKpe29TPn0.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BandecPaymentStatusFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // BandecAccountSelectionFragment
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String referencia = this.txReferencia.getText().toString().trim();
        String cadena = referencia + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        UssdDispatcher.actionCallUSSDBack(this.context, "89", cadena, "¿Desea consultar el estado del pago especificado?", group, getFragmentManager());
    }

    @Override // BandecAccountSelectionFragment
    public void nuevoDatos() {
    }

    private boolean validateCuenta() {
        if (this.txReferencia.getText().toString().trim().isEmpty()) {
            this.lyReferencia.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txReferencia);
            return false;
        }
        this.lyReferencia.setErrorEnabled(false);
        return true;
    }
}
