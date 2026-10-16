package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;

/* JADX INFO: loaded from: classes.dex */
public class p8fd3aGf9lK extends UceJvUZMUO {
    public Button btnAceptar;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.p8fd3aGf9lK.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (p8fd3aGf9lK.this.isFieldsOK()) {
                try {
                    p8fd3aGf9lK.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public View rootView;
    public TextView titleToolbar;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.q5a28hhlkul8xu, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        this.titleToolbar.setText("Actualizar cupón de combustible");
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        loadComponents(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (!validateSerie()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        try {
            String cadena = this.txSerie.getText().toString().trim();
            String msg = "¿Desea actualizar la clave del cupón de combustible con número de serie: " + cadena + " ? ";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "39", cadena, msg, group, getFragmentManager());
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }
}
