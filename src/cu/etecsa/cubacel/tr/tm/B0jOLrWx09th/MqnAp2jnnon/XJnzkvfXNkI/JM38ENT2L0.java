package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class JM38ENT2L0 extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNumero;
    private EditText inputNumero;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.qtigi9czswfsc, container, false);
        this.context = container.getContext();
        this.inputLayoutNumero = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rpfnumero);
        this.inputNumero = (EditText) this.rootView.findViewById(R.id.input_rpfnumero);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.JM38ENT2L0.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JM38ENT2L0.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNumero()) {
            return;
        }
        String numero = this.inputNumero.getText().toString().trim();
        String msg = "Desea rectificar el pago con " + getString(R.string.hint_transaccion) + ": " + numero;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRePagarFactura);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("4", numero, msg, group);
    }

    private boolean validateNumero() {
        if (this.inputNumero.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumero.setError(getString(R.string.err_msg_empty_transaccion));
            requestFocus(this.inputNumero);
            return false;
        }
        this.inputLayoutNumero.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
