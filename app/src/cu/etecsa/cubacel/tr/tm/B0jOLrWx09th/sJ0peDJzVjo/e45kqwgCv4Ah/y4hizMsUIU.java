package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class y4hizMsUIU extends Fragment {
    public Button btnAceptar;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.y4hizMsUIU.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (y4hizMsUIU.this.isFieldsOK()) {
                try {
                    y4hizMsUIU.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public Context context;
    public DatePickerDialog fIniciodatePicker;
    public String fechaInicio;
    public TextInputLayout lyFecha;
    public View rootView;
    public TextView titleToolbar;
    public AutoCompleteTextView txFecha;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fwr5jtavoxoll, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        this.titleToolbar.setText("Consulta de Cupones");
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        this.txFecha = (AutoCompleteTextView) v.findViewById(R.id.txFecha);
        this.lyFecha = (TextInputLayout) v.findViewById(R.id.lyFecha);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        fechaInicioConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (!validateSerie()) {
            return false;
        }
        return true;
    }

    private boolean validateSerie() {
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError("El campo no puede estar vacio");
            requestFocus(this.txFecha);
            return false;
        }
        this.lyFecha.setErrorEnabled(false);
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        try {
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "37", this.fechaInicio, "¿Desea obtener los últimos cupones de combustible en el rango de fecha especificado?", group, getFragmentManager());
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }

    private void fechaInicioConfig() {
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.y4hizMsUIU.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                y4hizMsUIU.this.fIniciodatePicker = new DatePickerDialog(y4hizMsUIU.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.y4hizMsUIU.2.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        y4hizMsUIU.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        y4hizMsUIU.this.fechaInicio = dia + "/" + mes + "/" + year2;
                        y4hizMsUIU.this.lyFecha.setErrorEnabled(false);
                    }
                }, year, month, day);
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                y4hizMsUIU.this.fIniciodatePicker.getDatePicker().setMaxDate(now);
                y4hizMsUIU.this.fIniciodatePicker.show();
            }
        });
    }
}
