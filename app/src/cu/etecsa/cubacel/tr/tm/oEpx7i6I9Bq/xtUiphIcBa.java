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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xtUiphIcBa extends Fragment {
    public AppConfig appConfig;
    public rDEl7rW1aN bs;
    private Button btnAceptar;
    private Button btnSolicitarCode;
    public Context context;
    private AutoCompleteTextView inputCodigo;
    private TextInputLayout inputLayoutCodigo;
    public Fr52O1uSYF msap;
    public View rootView;
    private TextView text_agente;
    public String phone = BuildConfig.FLAVOR;
    public int MAX_CONTADOR = 3;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.msap = new Fr52O1uSYF();
        this.rootView = inflater.inflate(R.layout.jpjcepyu5qgb4, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        this.inputLayoutCodigo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cod_agente);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cod_agente);
        this.inputCodigo = autoCompleteTextView;
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                xtUiphIcBa.this.bs = new rDEl7rW1aN();
                xtUiphIcBa xtuiphicba = xtUiphIcBa.this;
                xtuiphicba.bs.sms_actualizar_bd_datos_app(xtuiphicba.getContext().getContentResolver());
                xtUiphIcBa xtuiphicba2 = xtUiphIcBa.this;
                String code = xtuiphicba2.bs.sms_code_bulevar(xtuiphicba2.getContext().getContentResolver());
                if (!code.isEmpty()) {
                    xtUiphIcBa.this.inputCodigo.setText(code);
                }
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xtUiphIcBa.this.habilitar_modulo_banco();
            }
        });
        this.text_agente = (TextView) this.rootView.findViewById(R.id.txt_info);
        Button button2 = (Button) this.rootView.findViewById(R.id.btn_sol_code);
        this.btnSolicitarCode = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xtUiphIcBa.this.solicitarCodigoAuthUSSD();
            }
        });
        try {
            Fr52O1uSYF fr52O1uSYF = this.msap;
            if (fr52O1uSYF != null && fr52O1uSYF.getCodigoBanco() != null) {
                int code = Integer.valueOf(this.msap.getCodigoBanco()).intValue();
                if (this.msap.getCodigoBanco().contains("-1") && code < this.MAX_CONTADOR) {
                    this.btnSolicitarCode.setEnabled(false);
                    this.btnSolicitarCode.setVisibility(8);
                    this.text_agente.setText(R.string.msg_insert_codigo_modulo_bulevar);
                }
            }
        } catch (Exception e) {
        }
        return this.rootView;
    }

    public void habilitar_modulo_banco() {
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
                String input_inverso = BuildConfig.FLAVOR;
                StringBuilder input1 = new StringBuilder();
                input1.append(version);
                StringBuilder input2 = input1.reverse();
                for (int i = 0; i < input2.length(); i++) {
                    input_inverso = input_inverso + input2.charAt(i);
                }
                hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                if (ac.check_code_activation(codigo, input_inverso, this.phone)) {
                    this.msap.setPhone(this.phone);
                    this.msap.setCodigoBanco(codigo);
                    rDEl7rW1aN ba = new rDEl7rW1aN();
                    ba.helpAlertGestionAndCloseApp(getContext(), this.context.getString(R.string.txt_alert_close_app_when_active_bulevar));
                    return;
                }
                Toast toast1 = Toast.makeText(getContext(), R.string.txt_codigo_habilitacion_incorrecto, 0);
                toast1.show();
                return;
            }
            if (this.phone == null) {
                getAlertDialogAviso();
            }
        }
    }

    private void getAlertDialogAviso() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.dz98f5sddprqt, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialoglayout);
        final AlertDialog alertDialog = builder.create();
        Button btnok = (Button) dialoglayout.findViewById(R.id.btn_aceptar);
        btnok.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private boolean validateCodigo() {
        if (this.inputCodigo.getText().toString().trim().isEmpty()) {
            this.inputLayoutCodigo.setError(this.context.getString(R.string.err_cod_not_vacio));
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
        String codigo = "10*" + version;
        String msg = this.context.getString(R.string.msg_confirm_activar_modulo_bulevar);
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
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent dial = new Intent("android.intent.action.CALL", number);
                xtUiphIcBa.this.startActivity(dial);
                xtUiphIcBa.this.clearForm(group);
                try {
                    Fr52O1uSYF fr52O1uSYF = xtUiphIcBa.this.msap;
                    if (fr52O1uSYF != null && fr52O1uSYF.getCodigoBanco() != null) {
                        int code = 0;
                        if (xtUiphIcBa.this.msap.getCodigoBanco() != BuildConfig.FLAVOR) {
                            code = Integer.valueOf(xtUiphIcBa.this.msap.getCodigoBanco()).intValue();
                        }
                        xtUiphIcBa xtuiphicba = xtUiphIcBa.this;
                        if (code < xtuiphicba.MAX_CONTADOR) {
                            int code2 = code + 1;
                            xtuiphicba.msap.setCodigoBanco(String.valueOf(code2));
                            xtUiphIcBa xtuiphicba2 = xtUiphIcBa.this;
                            if (code2 == xtuiphicba2.MAX_CONTADOR) {
                                xtuiphicba2.msap.setCodigoBanco("-1");
                                xtUiphIcBa.this.btnSolicitarCode.setEnabled(false);
                                xtUiphIcBa.this.btnSolicitarCode.setVisibility(8);
                                xtUiphIcBa.this.text_agente.setText(R.string.msg_insert_codigo_modulo_bulevar);
                            }
                        }
                    }
                } catch (Exception ex) {
                    Log.d("LOG", ex.getMessage().toString());
                }
                xtUiphIcBa.this.text_agente.setText(R.string.msg_insert_cod_activacion_bulevar);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.xtUiphIcBa.5
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
