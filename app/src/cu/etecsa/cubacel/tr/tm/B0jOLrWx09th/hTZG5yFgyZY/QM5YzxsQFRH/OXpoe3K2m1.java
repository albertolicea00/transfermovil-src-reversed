package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class OXpoe3K2m1 extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ImageView btHelp;
    public Button btnAceptar;
    public CheckBox checkBox;
    public Context context;
    public DatePickerDialog fIniciodatePicker;
    public String fechaInicio;
    public TextInputLayout lyEmail;
    public TextInputLayout lyFecha;
    public pAzq93vIl3 manager;
    public View rootView;
    public TextView titleToolbar;
    public AutoCompleteTextView txEmail;
    public AutoCompleteTextView txFecha;
    public boolean isEnviarAuxDat = false;
    public String processedEmail = "0";
    public boolean isPartialUSSD = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (OXpoe3K2m1.this.isFieldsOK()) {
                try {
                    OXpoe3K2m1.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.4
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            try {
                if (isChecked) {
                    OXpoe3K2m1.this.lyEmail.setVisibility(0);
                    OXpoe3K2m1.this.txEmail.setVisibility(0);
                    OXpoe3K2m1.this.isEnviarAuxDat = true;
                } else {
                    OXpoe3K2m1.this.lyEmail.setVisibility(8);
                    OXpoe3K2m1.this.txEmail.setVisibility(8);
                    OXpoe3K2m1.this.isEnviarAuxDat = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.wlcmgujykhosv, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        loadViewUI(this.rootView);
        this.titleToolbar.setText(R.string.consulta_integrada_boleto);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        this.txFecha = (AutoCompleteTextView) v.findViewById(R.id.txFecha);
        this.txEmail = (AutoCompleteTextView) v.findViewById(R.id.txEmail);
        this.lyFecha = (TextInputLayout) v.findViewById(R.id.lyFecha);
        this.lyEmail = (TextInputLayout) v.findViewById(R.id.lyEmail);
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBoxMyPhone);
        this.checkBox = checkBox;
        checkBox.setEnabled(true);
        this.checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.lyEmail.setVisibility(8);
        this.txEmail.setVisibility(8);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        ImageView imageView = (ImageView) v.findViewById(R.id.btHelp);
        this.btHelp = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                OXpoe3K2m1.this.mensajeAyuda("Ayuda", "La consulta le enviará un SMS con los últimos 10 boletos activos en el plazo de un mes anterior a la fecha seleccionada. Si desea ver todos los boletos comprados debe marcar la opción de Inserte un correo válido e introducir uno al cual se le enviará la información.");
            }
        });
        fechaInicioConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        boolean fechaValida = validateSerie();
        if (!fechaValida) {
            return false;
        }
        if (this.isEnviarAuxDat) {
            boolean emailValido = validateEmailIfNeeded();
            if (!emailValido) {
                return false;
            }
            return true;
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

    private boolean validateEmailIfNeeded() {
        if (this.isEnviarAuxDat) {
            String email = this.txEmail.getText().toString().trim();
            if (email.isEmpty()) {
                this.lyEmail.setError("El correo electrónico es requerido");
                requestFocus(this.txEmail);
                return false;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                this.lyEmail.setError("Ingrese un correo electrónico válido");
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

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        String email;
        String cadena;
        try {
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            if (!this.isEnviarAuxDat) {
                email = "0";
            } else {
                String email2 = String.valueOf(this.txEmail.getText());
                email = email2;
            }
            String cadena2 = this.fechaInicio + "*" + email;
            try {
                this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
            } catch (Exception e) {
            }
            if (!this.isPartialUSSD) {
                cadena = cadena2;
            } else {
                cadena = this.fechaInicio + "*" + this.processedEmail;
            }
            if (this.isPartialUSSD) {
                this.manager.principalEnviarUSSD(this.context, "110", "112", "04", this.MAX_PARAMETERS_PQUETE, cadena, "¿Desea obtener los últimos Boletos del rango de fecha especificado?", group, getFragmentManager());
            } else {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "112", cadena, "¿Desea obtener los últimos Boletos del rango de fecha especificado?", group, getFragmentManager());
            }
        } catch (Exception e2) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }

    private void fechaInicioConfig() {
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                OXpoe3K2m1.this.fIniciodatePicker = new DatePickerDialog(OXpoe3K2m1.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.3.1
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
                        OXpoe3K2m1.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        OXpoe3K2m1.this.fechaInicio = dia + "/" + mes + "/" + year2;
                        OXpoe3K2m1.this.lyFecha.setErrorEnabled(false);
                    }
                }, year, month, day);
                Calendar today = Calendar.getInstance();
                Calendar fechaTope = Calendar.getInstance();
                long now = today.getTimeInMillis();
                fechaTope.add(2, -6);
                long limit = fechaTope.getTimeInMillis();
                OXpoe3K2m1.this.fIniciodatePicker.getDatePicker().setMaxDate(now);
                OXpoe3K2m1.this.fIniciodatePicker.getDatePicker().setMinDate(limit);
                OXpoe3K2m1.this.fIniciodatePicker.show();
            }
        });
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        requireActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.5
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(OXpoe3K2m1.this.requireContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
                alertDialog.show();
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                if (textView != null) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD) {
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
