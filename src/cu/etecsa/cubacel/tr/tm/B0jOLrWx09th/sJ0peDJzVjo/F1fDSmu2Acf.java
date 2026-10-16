package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class F1fDSmu2Acf extends DialogFragment {
    public Button btnAceptar;
    private View.OnClickListener btnOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.F1fDSmu2Acf.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (F1fDSmu2Acf.this.isFieldsOK()) {
                try {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("link", F1fDSmu2Acf.this.edEnlaceCompartido.getText().toString().trim());
                    F1fDSmu2Acf.this.getTargetFragment().onActivityResult(F1fDSmu2Acf.this.getTargetRequestCode(), 1, returnIntent);
                    F1fDSmu2Acf.this.dismiss();
                } catch (Exception e) {
                    Toast.makeText(F1fDSmu2Acf.this.context, "Ha ocurrido un error inesperado, vuelva intentarlo", 1).show();
                }
            }
        }
    };
    public Context context;
    public EditText edEnlaceCompartido;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.gj8ezqu7vihdk, container, false);
        this.rootView = viewInflate;
        this.edEnlaceCompartido = (EditText) viewInflate.findViewById(R.id.edEnlaceCompartido);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptarCodigo);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnOnClick);
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        loadViewUI(this.rootView);
    }

    public void loadViewUI(View v) {
        this.edEnlaceCompartido = (EditText) v.findViewById(R.id.edEnlaceCompartido);
        this.btnAceptar = (Button) v.findViewById(R.id.btnAceptarCodigo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (!validatLink()) {
            return false;
        }
        return true;
    }

    private boolean validatLink() {
        if (this.edEnlaceCompartido.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.context, "Este campo no puede ser vacío", 0).show();
            return false;
        }
        return true;
    }
}
