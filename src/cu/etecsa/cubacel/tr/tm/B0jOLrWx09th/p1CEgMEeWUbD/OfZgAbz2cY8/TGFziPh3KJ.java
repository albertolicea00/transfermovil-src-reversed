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
public class TGFziPh3KJ extends Fragment {
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputClave;
    private TextInputLayout inputLayoutClave;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.x5fgs1su15ug8r, container, false);
        this.context = container.getContext();
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TGFziPh3KJ.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TGFziPh3KJ.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateClave()) {
            return;
        }
        String clave = "02*" + this.inputClave.getText().toString().trim();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmAuthBanco);
        FBsQzP3Zfj.actionCallUSSDBack("02", this.context, "40", clave, "Desea autenticarse en el sistema", group, getFragmentManager(), getActivity());
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 5) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco_bandec));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
