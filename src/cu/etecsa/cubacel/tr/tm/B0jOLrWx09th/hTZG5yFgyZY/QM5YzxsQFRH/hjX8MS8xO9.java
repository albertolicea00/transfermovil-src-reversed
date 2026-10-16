package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

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
public class hjX8MS8xO9 extends L4aAENEGbqv {
    public Button btnAceptar;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.hjX8MS8xO9.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (hjX8MS8xO9.this.isFieldsOK()) {
                try {
                    hjX8MS8xO9.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public View rootView;
    public TextView titleToolbar;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.yxq8vb0em2gox, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        this.titleToolbar.setText(R.string.consulta_actualizar_boleto);
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
            String msg = "¿Desea actualizar la clave del boleto con número de serie: " + cadena + " ? ";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "115", cadena, msg, group, getFragmentManager());
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }
}
