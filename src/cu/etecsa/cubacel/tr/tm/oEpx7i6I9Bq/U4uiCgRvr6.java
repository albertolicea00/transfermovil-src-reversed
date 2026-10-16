package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class U4uiCgRvr6 extends Fragment {
    public AppConfig appConfig;
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputCodigo;
    private TextInputLayout inputLayoutCodigo;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ycolq1nul50dk, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        this.inputLayoutCodigo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_codigo);
        this.inputCodigo = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_codigo);
        if (appConfigList.size() > 0) {
            AppConfig appConfig = appConfigList.get(0);
            this.appConfig = appConfig;
            this.inputCodigo.setText(appConfig.getCodigo());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.U4uiCgRvr6.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                U4uiCgRvr6.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCodigo()) {
            return;
        }
        final String codigo = this.inputCodigo.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.confirm_code) + ": " + codigo);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.U4uiCgRvr6.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(U4uiCgRvr6.this.context);
                U4uiCgRvr6.this.appConfig.setCodigo(codigo);
                unYp8VQThY.getInstance().updateAppConfig(U4uiCgRvr6.this.appConfig);
                Toast.makeText(U4uiCgRvr6.this.context, "Cambio en codigo de acceso ACEPTADO", 1).show();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCodigo() {
        if (this.inputCodigo.getText().toString().trim().isEmpty()) {
            this.inputLayoutCodigo.setError(this.context.getString(R.string.err_msg_empty_codigo_acceso));
            requestFocus(this.inputCodigo);
            return false;
        }
        if (this.inputCodigo.getText().toString().trim().length() != 3) {
            this.inputLayoutCodigo.setError(this.context.getString(R.string.err_msg_len_codigo_acceso));
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
}
