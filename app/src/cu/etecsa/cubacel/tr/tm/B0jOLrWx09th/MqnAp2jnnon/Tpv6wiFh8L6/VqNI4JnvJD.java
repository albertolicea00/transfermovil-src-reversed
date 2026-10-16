package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6;

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
public class VqNI4JnvJD extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNewCode;
    private TextInputLayout inputLayoutRepCode;
    private EditText inputNewCode;
    private EditText inputRepCode;
    public String menuOpcion = "3";
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.o69g2wkcjgmrcl, container, false);
        this.context = container.getContext();
        this.inputLayoutNewCode = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_movil_nuevo_codigo);
        this.inputNewCode = (EditText) this.rootView.findViewById(R.id.input_movil_nuevo_codigo);
        this.inputLayoutRepCode = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_movil_rep_cod);
        this.inputRepCode = (EditText) this.rootView.findViewById(R.id.input_movil_rep_cod);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VqNI4JnvJD.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateEmpty() || !validatePass()) {
            return;
        }
        String cadena = this.menuOpcion + "*" + this.inputNewCode.getText().toString().trim();
        String msg = this.context.getString(R.string.msg_conf_cambio_pass) + this.inputNewCode.getText().toString().trim();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmPassword);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("11", cadena + "*" + cadena, msg, group);
    }

    private boolean validateEmpty() {
        if (this.inputNewCode.getText().toString().trim().isEmpty() || this.inputNewCode.getText().toString().trim().length() != 4) {
            this.inputLayoutNewCode.setError(this.context.getString(R.string.err_msg_len_clave));
            requestFocus(this.inputNewCode);
            return false;
        }
        if (this.inputRepCode.getText().toString().trim().isEmpty() || this.inputNewCode.getText().toString().trim().length() != 4) {
            this.inputLayoutRepCode.setError(this.context.getString(R.string.err_msg_len_clave));
            requestFocus(this.inputRepCode);
            return false;
        }
        this.inputLayoutRepCode.setErrorEnabled(false);
        return true;
    }

    private boolean validatePass() {
        if (!this.inputNewCode.getText().toString().equals(this.inputRepCode.getText().toString())) {
            this.inputLayoutNewCode.setError(this.context.getString(R.string.err_msg_num_pass_no_equals));
            requestFocus(this.inputNewCode);
            return false;
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
