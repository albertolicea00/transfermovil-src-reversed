package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class wJTVCHHHdv extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutNroMulta;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputNroMulta;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.rsg65rwrysq90, container, false);
        this.context = container.getContext();
        this.inputLayoutNroMulta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputNroMulta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nro);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.wJTVCHHHdv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wJTVCHHHdv.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNroMulta() || !validateMonto()) {
            return;
        }
        String nroMulta = this.inputNroMulta.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String cadena = nroMulta + "*" + monto;
        String msg = "Deseapagar la multa:  " + nroMulta + ". Monto: " + monto + " CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmMulta);
        rDEl7rW1aN bs = new rDEl7rW1aN();
        if (bs.getCodeAgent() != null) {
            if (bs.getCodeAgent().getCode().contains("-1")) {
                ((S9ycHcoxAzy) getActivity()).actionCallUSSD("44", cadena, msg, group);
                return;
            } else {
                ((IHVTCBmiLV) getActivity()).actionCallUSSD("44", cadena, msg, group);
                return;
            }
        }
        ((S9ycHcoxAzy) getActivity()).actionCallUSSD("44", cadena, msg, group);
    }

    private boolean validateNroMulta() {
        if (this.inputNroMulta.getText().toString().trim().isEmpty()) {
            this.inputLayoutNroMulta.setError(getString(R.string.err_msg_empty_nro_multa));
            requestFocus(this.inputNroMulta);
            return false;
        }
        if (this.inputNroMulta.getText().toString().trim().length() != 10) {
            this.inputLayoutNroMulta.setError(getString(R.string.err_msg_len_nro_multa));
            requestFocus(this.inputNroMulta);
            return false;
        }
        this.inputLayoutNroMulta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
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
}
