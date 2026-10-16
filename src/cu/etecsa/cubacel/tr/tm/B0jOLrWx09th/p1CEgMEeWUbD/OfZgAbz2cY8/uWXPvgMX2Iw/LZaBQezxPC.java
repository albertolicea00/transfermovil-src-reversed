package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class LZaBQezxPC extends Agg55uYctq {
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
        this.rootView = inflater.inflate(R.layout.qgz5v55skrhs3, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutNombre = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nombre);
        this.inputNombre = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nombre);
        this.inputLayoutNombre.setHint("Nombre y apellidos");
        this.inputLayoutMensualidad = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_mensualidad);
        this.inputMensualidad = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_mensualidad);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.LZaBQezxPC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LZaBQezxPC.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateNombreApp() || !validateMensualidad() || !validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String nombre = this.inputNombre.getText().toString().trim();
        String mensualidad = this.inputMensualidad.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String msg = String.format("¿Desea amortizar  la cuenta: %s, Nombre: %s y mensualidad: %s, con el monto: %s en la moneda de la cuenta seleccionada?", cuenta, nombre, mensualidad, monto);
        String cadena = cuenta + "*" + monto + "*" + mensualidad + "*" + nombre;
        if (this.swCuentasBanco.isChecked()) {
            cadena = cuenta + "*" + monto + "*" + mensualidad + "*" + nombre + "*" + this.cuentaOrigen;
        }
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "55", "02", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "55", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateNombreApp() {
        if (this.inputNombre.getText().toString().trim().isEmpty()) {
            this.inputLayoutNombre.setError(getString(R.string.err_msg_empty_full_nombre));
            requestFocus(this.inputNombre);
            return false;
        }
        this.inputLayoutNombre.setErrorEnabled(false);
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

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputMonto);
            return false;
        }
        if (this.inputMensualidad.getText().toString().trim().length() <= 0) {
            this.inputLayoutMonto.setError(getString(R.string.err_mayor_cero));
            requestFocus(this.inputMonto);
            return false;
        }
        this.inputLayoutMonto.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
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
