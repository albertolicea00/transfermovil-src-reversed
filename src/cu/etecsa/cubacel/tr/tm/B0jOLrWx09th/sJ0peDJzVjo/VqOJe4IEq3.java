package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;

/* JADX INFO: loaded from: classes.dex */
public class VqOJe4IEq3 extends Fragment {
    public Button btnAceptar;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.VqOJe4IEq3.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (VqOJe4IEq3.this.isFieldsOK()) {
                try {
                    VqOJe4IEq3.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public Context context;
    public TextInputLayout lyCI;
    public View rootView;
    public TextView titleToolbar;
    public AutoCompleteTextView txCI;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.wkkthza6eag50, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        this.lyCI = (TextInputLayout) v.findViewById(R.id.lyCI);
        this.txCI = (AutoCompleteTextView) v.findViewById(R.id.txCI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (!validateCi()) {
            return false;
        }
        return true;
    }

    private boolean validateCi() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        try {
            String ci = this.txCI.getText().toString().trim();
            String cadena = ci + "*1";
            String msg = "¿Desea consultar los últimos sellos para el carné de identidad: " + cadena + " ?";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "110", cadena, msg, group, getFragmentManager());
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }
}
