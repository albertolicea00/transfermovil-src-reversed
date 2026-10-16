package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class qAMfdm9Kls extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    public Context context;
    public DatePickerDialog fFindatePicker;
    public DatePickerDialog fIniciodatePicker;
    public String fechaFin;
    public String fechaInicio;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyEmail;
    private TextInputLayout lyFechaFin;
    private TextInputLayout lyFechaInicio;
    public pAzq93vIl3 manager;
    public qTDVwLFEjE monedaBolsa;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public TextView toolbarTitle;
    private AutoCompleteTextView txEmail;
    private TextInputEditText txFechaFin;
    private TextInputEditText txFechaInicio;
    public String processedEmail = "0";
    public int tipoBolsa = 0;
    public String tipoBolsaDescripcion = BuildConfig.FLAVOR;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    qAMfdm9Kls.this.tipoBolsaDescripcion = "USD";
                    break;
                case 1:
                    qAMfdm9Kls.this.tipoBolsaDescripcion = "CUP";
                    break;
            }
            qAMfdm9Kls.this.tipoBolsa = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.usv2vno1rmuot, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.lyEmail = (TextInputLayout) this.rootView.findViewById(R.id.lyEmail);
        this.txEmail = (AutoCompleteTextView) this.rootView.findViewById(R.id.txEmail);
        this.lyFechaInicio = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaInicio);
        this.txFechaInicio = (TextInputEditText) this.rootView.findViewById(R.id.txFechaInicio);
        this.lyFechaFin = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaFin);
        this.txFechaFin = (TextInputEditText) this.rootView.findViewById(R.id.txFechaFin);
        fechaFinConfig();
        fechaInicioConfig();
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    qAMfdm9Kls.this.submitForm();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return this.rootView;
    }

    public void submitForm() throws ParseException {
        String correo;
        if (!validateCorreo() || !validateFechaInicio() || !validateFechaFin() || !validateSpBolsa()) {
            return;
        }
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        String email = this.txEmail.getText().toString().toLowerCase().trim();
        if (this.isPartialUSSD) {
            correo = this.processedEmail.toLowerCase().trim();
        } else {
            correo = this.txEmail.getText().toString().toLowerCase().trim();
        }
        String msg = "¿Desea obtener el estado  de cuenta del Monedero MiTransfer: " + this.tipoBolsaDescripcion + ", el cual será  enviado al siguiente correo electrónico: " + email + " ?  Esta operación realiza un cobro de comisión a la cuenta seleccionada";
        String cadena = correo + "*" + this.fechaInicio + "*" + this.fechaFin + "*" + this.tipoBolsaDescripcion;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "26", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "26", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private void fechaInicioConfig() {
        this.txFechaInicio.setInputType(0);
        this.txFechaInicio.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                qAMfdm9Kls.this.fIniciodatePicker = new DatePickerDialog(qAMfdm9Kls.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.3.1
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
                        qAMfdm9Kls.this.txFechaInicio.setText(year2 + "/" + mes + "/" + dia);
                        qAMfdm9Kls.this.fechaInicio = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, -6);
                long limit = fechaTope.getTimeInMillis();
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                qAMfdm9Kls.this.fIniciodatePicker.getDatePicker().setMinDate(limit);
                qAMfdm9Kls.this.fIniciodatePicker.getDatePicker().setMaxDate(now);
                qAMfdm9Kls.this.fIniciodatePicker.show();
            }
        });
    }

    private void fechaFinConfig() {
        this.txFechaFin.setInputType(0);
        this.txFechaFin.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                qAMfdm9Kls.this.fFindatePicker = new DatePickerDialog(qAMfdm9Kls.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls.4.1
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
                        qAMfdm9Kls.this.txFechaFin.setText(year2 + "/" + mes + "/" + dia);
                        qAMfdm9Kls.this.fechaFin = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, -6);
                long limit = fechaTope.getTimeInMillis();
                qAMfdm9Kls.this.fFindatePicker.getDatePicker().setMinDate(limit);
                qAMfdm9Kls.this.fFindatePicker.getDatePicker().setMaxDate(now);
                qAMfdm9Kls.this.fFindatePicker.show();
            }
        });
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private boolean validateCorreo() {
        String email = this.txEmail.getText().toString().trim();
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
        if (getUsernameFromEmail(email).length() > 20) {
            this.lyEmail.setError("El nombre del usuario del correo no puede tener más de 20 caracteres");
            requestFocus(this.txEmail);
            return false;
        }
        this.lyEmail.setErrorEnabled(false);
        String strProcessEmail = processEmail(email);
        this.processedEmail = strProcessEmail;
        this.processedEmail = strProcessEmail;
        return true;
    }

    private String getUsernameFromEmail(String email) {
        if (email != null) {
            try {
                if (!email.isEmpty()) {
                    int atIndex = email.indexOf(64);
                    return atIndex == -1 ? email : email.substring(0, atIndex);
                }
            } catch (Exception e) {
                return BuildConfig.FLAVOR;
            }
        }
        return BuildConfig.FLAVOR;
    }

    private String processEmail(String email) {
        if (email == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            if (email.isEmpty()) {
                return BuildConfig.FLAVOR;
            }
            int atIndex = email.indexOf(64);
            if (atIndex == -1) {
                return email;
            }
            String username = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);
            if (username.length() > 10) {
                int middle = username.length() / 2;
                String part1 = username.substring(0, middle);
                String part2 = username.substring(middle);
                return part1 + "*" + part2 + "*" + domain;
            }
            return username + "*" + domain;
        } catch (Exception e) {
            return email;
        }
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

    private boolean validateFechaFin() throws ParseException {
        if (this.txFechaFin.getText().toString().trim().isEmpty()) {
            this.lyFechaFin.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFechaFin);
            return false;
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaIni = formato.parse(this.txFechaInicio.getText().toString().trim());
        Date fechaFin = formato.parse(this.txFechaFin.getText().toString().trim());
        if (fechaIni.after(fechaFin) || fechaIni.equals(fechaFin)) {
            this.lyFechaInicio.setError(this.context.getString(R.string.err_fecha_ini_mayor_fecha_fin));
            requestFocus(this.txFechaInicio);
            return false;
        }
        this.lyFechaFin.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
