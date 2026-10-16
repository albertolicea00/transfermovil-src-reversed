package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/* JADX INFO: loaded from: classes.dex */
public class i9I9XZGnR3 extends L4aAENEGbqv implements pAzq93vIl3.UssdResponseObserver {
    public ImageView btHelp;
    public Button btnAceptar;
    public CheckBox checkBox;
    public TextInputLayout lyEmail;
    public pAzq93vIl3 manager;
    public View rootView;
    public TextView titleToolbar;
    public AutoCompleteTextView txEmail;
    public boolean isEnviarAuxDat = false;
    public boolean isPartialUSSD = false;
    public String processedEmail = "0";
    public int MAX_PARAMETERS_PQUETE = 4;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (i9I9XZGnR3.this.isFieldsOK()) {
                try {
                    i9I9XZGnR3.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3.4
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            try {
                if (isChecked) {
                    i9I9XZGnR3.this.lyEmail.setVisibility(0);
                    i9I9XZGnR3.this.txEmail.setVisibility(0);
                    i9I9XZGnR3.this.isEnviarAuxDat = true;
                } else {
                    i9I9XZGnR3.this.lyEmail.setVisibility(8);
                    i9I9XZGnR3.this.txEmail.setVisibility(8);
                    i9I9XZGnR3.this.isEnviarAuxDat = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.yxq8vb0em2gox, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        loadViewUI(this.rootView);
        this.titleToolbar.setText(R.string.consulta_ultimas_oper_boleto);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        this.txEmail = (AutoCompleteTextView) v.findViewById(R.id.txEmail);
        this.lyEmail = (TextInputLayout) v.findViewById(R.id.lyEmail);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        this.lyEmail.setVisibility(8);
        this.txEmail.setVisibility(8);
        CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBoxMyPhone);
        this.checkBox = checkBox;
        checkBox.setEnabled(true);
        this.checkBox.setVisibility(0);
        this.checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        ImageView imageView = (ImageView) v.findViewById(R.id.btHelp);
        this.btHelp = imageView;
        imageView.setVisibility(0);
        this.btHelp.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                i9I9XZGnR3.this.mensajeAyuda("Ayuda", "La consulta le enviará un SMS con las últimas 10 operaciones del boleto. Si desea ver todas las operaciones realizadas del boleto, debe marcar la opción de Inserte un correo válido e introducir uno al cual se le enviará la información.");
            }
        });
        loadComponents(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (!validateSerie()) {
            return false;
        }
        if (this.isEnviarAuxDat) {
            boolean emailValido = validateEmailIfNeeded();
            return emailValido;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        String email;
        String cadena;
        try {
            String cadena2 = this.txSerie.getText().toString().trim();
            String msg = "¿Desea consultar las últimas operaciones asociadas al boleto con número de serie: " + cadena2 + " ?";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            if (!this.isEnviarAuxDat) {
                email = "0";
            } else {
                email = String.valueOf(this.txEmail.getText());
            }
            try {
                this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
            } catch (Exception e) {
            }
            if (this.isPartialUSSD) {
                cadena = cadena2 + "*" + this.processedEmail;
            } else {
                cadena = cadena2 + "*" + email;
            }
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "113", cadena, msg, group, getFragmentManager());
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "113", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
            }
        } catch (Exception e2) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
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

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        requireActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3.3
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(i9I9XZGnR3.this.requireContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3.3.1
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
