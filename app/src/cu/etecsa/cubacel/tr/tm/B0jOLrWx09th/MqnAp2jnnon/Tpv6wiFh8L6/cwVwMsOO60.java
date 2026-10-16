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
public class cwVwMsOO60 extends Fragment {
    private Button btnAceptar;
    public Context context;
    private EditText inputAuteticar;
    private TextInputLayout inputLayoutAutenticar;
    public String menuOpcion = "1";
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.leaiuev1eeiak, container, false);
        this.context = container.getContext();
        this.inputLayoutAutenticar = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_autenticar_recarga);
        this.inputAuteticar = (EditText) this.rootView.findViewById(R.id.input_autenticar_recarga);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                cwVwMsOO60.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (validateAutentificacion()) {
            String cadena = this.menuOpcion + "*" + this.inputAuteticar.getText().toString().trim();
            String msg = "Desea autenticarse con la siguiente clave: " + this.inputAuteticar.getText().toString().trim();
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmAutenticar);
            ((IHVTCBmiLV) getActivity()).actionCallUSSD("11", cadena, msg, group);
        }
    }

    private boolean validateAutentificacion() {
        if (this.inputAuteticar.getText().toString().trim().isEmpty()) {
            this.inputLayoutAutenticar.setError(this.context.getString(R.string.err_msg_empty_num_recarga_aut));
            requestFocus(this.inputAuteticar);
            return false;
        }
        if (this.inputAuteticar.getText().toString().trim().length() != 4) {
            this.inputLayoutAutenticar.setError(getString(R.string.err_msg_len_clave));
            requestFocus(this.inputAuteticar);
            return false;
        }
        this.inputLayoutAutenticar.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
