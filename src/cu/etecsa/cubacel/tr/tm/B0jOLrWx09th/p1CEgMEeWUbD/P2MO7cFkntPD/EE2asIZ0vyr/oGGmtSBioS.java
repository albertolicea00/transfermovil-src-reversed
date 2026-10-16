package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class oGGmtSBioS extends QGQCqILT4b {
    private Button btnAceptar;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMensualidad;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutNombre;
    private AutoCompleteTextView inputMensualidad;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputNombre;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ciqnven4op1dh, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutMensualidad = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_mensualidad);
        this.inputMensualidad = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_mensualidad);
        this.inputLayoutNombre = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nombre);
        this.inputNombre = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nombre);
        this.inputLayoutNombre.setHint("Nombre y apellidos");
        this.inputLayoutNombre.setVisibility(8);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.inputLayoutMonto.setVisibility(8);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.oGGmtSBioS.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oGGmtSBioS.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateMensualidad() || !validateSelectionAccounts()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String mensualidad = this.inputMensualidad.getText().toString().trim();
        String msg = String.format("¿Desea amortizar  la cuenta: %s. Cantidad de meses a pagar: %s.?  El pago se realizará en la moneda de la cuenta seleccionada", cuenta, mensualidad);
        String cadena = cuenta + "*" + mensualidad + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "55", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMensualidad() {
        if (this.inputMensualidad.getText().toString().trim().isEmpty()) {
            this.inputLayoutMensualidad.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputMensualidad);
            return false;
        }
        if (this.inputMensualidad.getText().toString().trim().length() <= 0) {
            this.inputLayoutMensualidad.setError(getString(R.string.err_mayor_cero));
            requestFocus(this.inputMensualidad);
            return false;
        }
        this.inputLayoutMensualidad.setErrorEnabled(false);
        return true;
    }
}
