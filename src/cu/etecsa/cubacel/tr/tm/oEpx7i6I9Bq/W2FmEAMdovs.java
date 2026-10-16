package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class W2FmEAMdovs extends Fragment {
    public AppConfig appConfig;
    public rDEl7rW1aN bs;
    private Button btnAceptar;
    private Button btnSolicitarCode;
    public Context context;
    private AutoCompleteTextView inputCodigo;
    private TextInputLayout inputLayoutCodigo;
    public Fr52O1uSYF msap;
    public String phone = BuildConfig.FLAVOR;
    public View rootView;
    private TextView text_agente;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.msap = new Fr52O1uSYF();
        this.rootView = inflater.inflate(R.layout.eh7lkpiispqte, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        this.inputLayoutCodigo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cod_agente);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cod_agente);
        this.inputCodigo = autoCompleteTextView;
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                W2FmEAMdovs.this.bs = new rDEl7rW1aN();
                W2FmEAMdovs w2FmEAMdovs = W2FmEAMdovs.this;
                w2FmEAMdovs.bs.sms_actualizar_bd_datos_app(w2FmEAMdovs.getContext().getContentResolver());
                W2FmEAMdovs w2FmEAMdovs2 = W2FmEAMdovs.this;
                String code = w2FmEAMdovs2.bs.sms_code_agente(w2FmEAMdovs2.getContext().getContentResolver());
                if (!code.isEmpty()) {
                    W2FmEAMdovs.this.inputCodigo.setText(code);
                }
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                W2FmEAMdovs.this.habilitar_version_agente();
            }
        });
        this.text_agente = (TextView) this.rootView.findViewById(R.id.txt_info);
        Button button2 = (Button) this.rootView.findViewById(R.id.btn_sol_code);
        this.btnSolicitarCode = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                W2FmEAMdovs.this.solicitarCodigoAuthUSSD();
            }
        });
        if (this.msap.getCodigoAgente().contains("-1")) {
            this.btnSolicitarCode.setEnabled(false);
            this.btnSolicitarCode.setVisibility(8);
            this.text_agente.setText(R.string.msg_insert_codigo_modulo_tele);
        }
        return this.rootView;
    }

    public void habilitar_version_agente() {
        String str;
        Fr52O1uSYF fr52O1uSYF = new Fr52O1uSYF();
        this.msap = fr52O1uSYF;
        if (fr52O1uSYF.getPhone() == null || this.msap.getPhone().isEmpty()) {
            rDEl7rW1aN rdel7rw1an = new rDEl7rW1aN();
            this.bs = rdel7rw1an;
            rdel7rw1an.sms_actualizar_bd_datos_app(getContext().getContentResolver());
        }
        if (validateCodigo()) {
            String codigo = this.inputCodigo.getText().toString().trim();
            String version = this.msap.getVersion();
            String str2 = this.phone;
            if (str2 == null || str2 == BuildConfig.FLAVOR) {
                this.phone = this.msap.getPhone();
            }
            if (version != null && (str = this.phone) != BuildConfig.FLAVOR && str != null) {
                hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                if (ac.check_code_activation(codigo, version, this.phone)) {
                    this.msap.setCodigoAgente(codigo);
                    this.msap.setPhone(this.phone);
                    rDEl7rW1aN ba = new rDEl7rW1aN();
                    try {
                        List<Operacion> operacionesAgente = unYp8VQThY.getInstance().getOperacionesListTipo(R1sDOSqZ2z.ETECSA);
                        for (Operacion op : operacionesAgente) {
                            op.setActivo(true);
                            unYp8VQThY.getInstance().updateOperacion(op);
                        }
                    } catch (Exception e) {
                    }
                    ba.helpAlertGestionAndCloseApp(getContext(), this.context.getString(R.string.txt_alert_close_app_when_active_version_agent));
                    return;
                }
                Toast toast1 = Toast.makeText(getContext(), R.string.err_cog_activacion_incorrecto, 0);
                toast1.show();
                return;
            }
            if (this.phone == null) {
                getAlertDialogAviso();
            }
        }
    }

    private void getAlertDialog() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.uagqxkz1kmbdy, (ViewGroup) null);
        final EditText etcode = (EditText) dialoglayout.findViewById(R.id.input_auxphone);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialoglayout);
        final AlertDialog alertDialog = builder.create();
        Button btnok = (Button) dialoglayout.findViewById(R.id.btn_aceptar);
        btnok.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!etcode.getText().toString().trim().isEmpty()) {
                    W2FmEAMdovs.this.phone = etcode.getText().toString();
                    alertDialog.dismiss();
                }
            }
        });
        alertDialog.show();
    }

    private void getAlertDialogAviso() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.dz98f5sddprqt, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialoglayout);
        final AlertDialog alertDialog = builder.create();
        Button btnok = (Button) dialoglayout.findViewById(R.id.btn_aceptar);
        btnok.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private boolean validateCodigo() {
        if (this.inputCodigo.getText().toString().trim().isEmpty()) {
            this.inputLayoutCodigo.setError(this.context.getString(R.string.err_cog_not_vacio));
            requestFocus(this.inputCodigo);
            return false;
        }
        this.inputLayoutCodigo.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void solicitarCodigoAuthUSSD() {
        rDEl7rW1aN ba = new rDEl7rW1aN();
        String version = ba.getCodeVersionApp();
        String codigo = "1*" + version;
        String msg = this.context.getString(R.string.txt_desea_activar_modulo_tele);
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmHabilitarAcceso);
        actionCallUSSDSoloSolHabilitarCodigo("80", codigo, msg, group);
    }

    public void actionCallUSSDSoloSolHabilitarCodigo(String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String codeAcceso;
        getString(R.string.codigoAcceso);
        unYp8VQThY.init(getContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
        } else {
            codeAcceso = getString(R.string.codigoAcceso);
        }
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + Uri.encode("#");
        Log.d("code", cadena);
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent dial = new Intent("android.intent.action.CALL", number);
                W2FmEAMdovs.this.startActivity(dial);
                W2FmEAMdovs.this.clearForm(group);
                W2FmEAMdovs.this.msap.setCodigoAgente("-1");
                W2FmEAMdovs.this.btnSolicitarCode.setEnabled(false);
                W2FmEAMdovs.this.btnSolicitarCode.setVisibility(8);
                W2FmEAMdovs.this.text_agente.setText(R.string.msg_insert_cod_version);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.W2FmEAMdovs.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void clearForm(ViewGroup group) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText(BuildConfig.FLAVOR);
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                clearForm((ViewGroup) view);
            }
        }
    }
}
