package cu.etecsa.transfermovil.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/** MiBoleto key update, reconstructed from {@code hjX8MS8xO9}. */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.hjX8MS8xO9 */
public class TicketUpdateFragment extends MiBoletoTicketBaseFragment {

    public Button btnAceptar;
    public View rootView;
    public TextView titleToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.yxq8vb0em2gox, container, false);
        context = container.getContext();
        titleToolbar = (TextView) rootView.findViewById(R.id.titleToolbar);
        titleToolbar.setText(R.string.consulta_actualizar_boleto);
        btnAceptar = (Button) rootView.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(view -> submitForm());
        loadComponents(rootView);
        return rootView;
    }

    private void submitForm() {
        if (!validateSerie()) {
            return;
        }
        try {
            String serie = txSerie.getText().toString().trim();
            String prompt = "¿Desea actualizar la clave del boleto con número de serie: " + serie + " ? ";
            ViewGroup form = (ViewGroup) rootView.findViewById(R.id.frmBanco);
            UssdDispatcher.actionCallUSSDBack(context, "115", serie, prompt, form, getFragmentManager());
        } catch (Exception error) {
            Toast.makeText(context, "Error intentelo de nuevo", Toast.LENGTH_SHORT).show();
        }
    }
}
