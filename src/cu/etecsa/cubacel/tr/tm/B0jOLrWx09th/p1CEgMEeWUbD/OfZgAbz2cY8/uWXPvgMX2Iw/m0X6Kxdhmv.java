package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw;

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
public class m0X6Kxdhmv extends QGQCqILT4b {
    private Button btnAceptar;
    public TextInputLayout lyImporte;
    private AutoCompleteTextView txMonto;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.gk7lxooaajtzx, container, false);
        this.context = container.getContext();
        this.lyImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyImporte);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.m0X6Kxdhmv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m0X6Kxdhmv.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        String importe = this.txMonto.getText().toString().trim();
        String cadena = importe + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "25", cadena, "¿Desea realizar la modificar la mensualidad?", group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        this.lyImporte.setErrorEnabled(false);
        try {
            Float importe = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
            if (importe.floatValue() < 1.0f) {
                this.lyImporte.setError("El monto no debe ser inferior al valor de 1 CUP.");
                requestFocus(this.txMonto);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.lyImporte.setError("Monto incorrecto");
            requestFocus(this.txMonto);
            return false;
        }
    }
}
