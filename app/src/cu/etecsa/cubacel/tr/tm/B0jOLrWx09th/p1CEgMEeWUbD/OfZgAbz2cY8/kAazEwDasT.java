package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;

/* JADX INFO: loaded from: classes.dex */
public class kAazEwDasT extends Fragment {
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMensualidad;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutNombre;
    private AutoCompleteTextView inputMensualidad;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputNombre;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ciqnven4op1dh, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutNombre = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nombre);
        this.inputNombre = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nombre);
        this.inputLayoutNombre.setHint("Nombre y apellidos");
        this.inputLayoutMensualidad = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_mensualidad);
        this.inputMensualidad = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_mensualidad);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.kAazEwDasT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kAazEwDasT.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateNombreApp() || !validateMensualidad() || !validateMonto()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String nombre = this.inputNombre.getText().toString().trim();
        String mensualidad = this.inputMensualidad.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String msg = String.format("¿Desea amortizar  la cuenta: %s, Nombre: %s y mensualidad: %s, con el monto: %s en la moneda de la cuenta seleccionada?", cuenta, nombre, mensualidad, monto);
        String cadena = cuenta + "*" + monto + "*" + mensualidad + "*" + nombre;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "55", cadena, msg, group, getFragmentManager());
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public String reemplazarCaracteresRaros(String input) {
        String output = input;
        for (int i = 0; i < "àèìòùÀÉËÌÓÚçÇ".length(); i++) {
            output = output.replace("àèìòùÀÉËÌÓÚçÇ".charAt(i), "aeiouAEIIOUcC".charAt(i));
        }
        return output;
    }
}
