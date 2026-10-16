package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.YWo20QOWZz;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class aCwLXhT3MF extends YWo20QOWZz {
    private Button btnAceptar;
    public DatePickerDialog fFindatePicker;
    public DatePickerDialog fIniciodatePicker;
    public String fechaFin;
    public String fechaInicio;
    private TextInputLayout lyEmail;
    private TextInputLayout lyFechaFin;
    private TextInputLayout lyFechaInicio;
    private AutoCompleteTextView txEmail;
    private TextInputEditText txFechaFin;
    private TextInputEditText txFechaInicio;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.abe5fxpdreekw, container, false);
        this.context = container.getContext();
        this.lyEmail = (TextInputLayout) this.rootView.findViewById(R.id.lyEmail);
        this.txEmail = (AutoCompleteTextView) this.rootView.findViewById(R.id.txEmail);
        this.lyFechaInicio = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaInicio);
        this.txFechaInicio = (TextInputEditText) this.rootView.findViewById(R.id.txFechaInicio);
        this.lyFechaFin = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaFin);
        this.txFechaFin = (TextInputEditText) this.rootView.findViewById(R.id.txFechaFin);
        fechaInicioConfig();
        fechaFinConfig();
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.Metropolitano);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aCwLXhT3MF.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateCorreo() || !validateFechaInicio() || !validateFechaFin() || !validateSelectionAccounts()) {
            return;
        }
        String correo = this.txEmail.getText().toString().toLowerCase().trim();
        String cadena = correo + "*" + this.fechaInicio + "*" + this.fechaFin + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "26", cadena, "¿Desea obtener el estado de la cuenta seleccionada? Esta operación realiza un cobro de comisión a la cuenta selecionada", group, getFragmentManager());
    }

    private void fechaInicioConfig() {
        this.txFechaInicio.setInputType(0);
        this.txFechaInicio.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                aCwLXhT3MF.this.fIniciodatePicker = new DatePickerDialog(aCwLXhT3MF.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF.2.1
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
                        aCwLXhT3MF.this.txFechaInicio.setText(year2 + "/" + mes + "/" + dia);
                        aCwLXhT3MF.this.fechaInicio = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, -6);
                long limit = fechaTope.getTimeInMillis();
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                aCwLXhT3MF.this.fIniciodatePicker.getDatePicker().setMinDate(limit);
                aCwLXhT3MF.this.fIniciodatePicker.getDatePicker().setMaxDate(now);
                aCwLXhT3MF.this.fIniciodatePicker.show();
            }
        });
    }

    private void fechaFinConfig() {
        this.txFechaFin.setInputType(0);
        this.txFechaFin.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                aCwLXhT3MF.this.fFindatePicker = new DatePickerDialog(aCwLXhT3MF.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.aCwLXhT3MF.3.1
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
                        aCwLXhT3MF.this.txFechaFin.setText(year2 + "/" + mes + "/" + dia);
                        aCwLXhT3MF.this.fechaFin = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, -12);
                long limit = fechaTope.getTimeInMillis();
                aCwLXhT3MF.this.fFindatePicker.getDatePicker().setMinDate(limit);
                aCwLXhT3MF.this.fFindatePicker.getDatePicker().setMaxDate(now);
                aCwLXhT3MF.this.fFindatePicker.show();
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean validateCorreo() {
        if (this.txEmail.getText().toString().trim().isEmpty()) {
            this.lyEmail.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txEmail);
            return false;
        }
        if (!this.txEmail.getText().toString().contains("@")) {
            this.lyEmail.setError(this.context.getString(R.string.hint_email_valido));
            requestFocus(this.txEmail);
            return false;
        }
        if (!this.txEmail.getText().toString().contains(".cu")) {
            this.lyEmail.setError(this.context.getString(R.string.hint_email_cuba));
            requestFocus(this.txEmail);
            return false;
        }
        this.lyEmail.setErrorEnabled(false);
        return true;
    }

    private boolean validateFechaInicio() {
        if (this.txFechaInicio.getText().toString().trim().isEmpty()) {
            this.lyFechaInicio.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFechaInicio);
            return false;
        }
        this.lyFechaInicio.setErrorEnabled(false);
        return true;
    }

    private boolean validateFechaFin() {
        if (this.txFechaFin.getText().toString().trim().isEmpty()) {
            this.lyFechaFin.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFechaFin);
            return false;
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date fechaIni = formato.parse(this.txFechaInicio.getText().toString().trim());
            Date fechaFin = formato.parse(this.txFechaFin.getText().toString().trim());
            if (!fechaIni.after(fechaFin) && !fechaIni.equals(fechaFin)) {
                this.lyFechaFin.setErrorEnabled(false);
                return true;
            }
            this.lyFechaInicio.setError(this.context.getString(R.string.err_fecha_ini_mayor_fecha_fin));
            requestFocus(this.txFechaInicio);
            return false;
        } catch (ParseException e) {
            this.lyFechaInicio.setError(this.context.getString(R.string.err_general));
            requestFocus(this.txFechaInicio);
            return false;
        } catch (Exception e2) {
            this.lyFechaInicio.setError(this.context.getString(R.string.err_general));
            requestFocus(this.txFechaInicio);
            return false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.YWo20QOWZz
    public void nuevoDatosComision() {
    }
}
