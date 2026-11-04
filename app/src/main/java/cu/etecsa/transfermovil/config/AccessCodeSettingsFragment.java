package cu.etecsa.transfermovil.config;

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
import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.AppConfig;
import java.util.List;

/**
 * Changes the three-digit USSD access code after the administrative keypad accepts a code.
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.U4uiCgRvr6
 */
public class AccessCodeSettingsFragment extends Fragment {

    public AppConfig appConfig;
    private Button acceptButton;
    public Context context;
    private AutoCompleteTextView accessCodeInput;
    private TextInputLayout accessCodeLayout;
    public View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ycolq1nul50dk, container, false);
        this.context = container.getContext();
        DatabaseHelper.init(this.context);
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAllAppConfigLists();
        this.accessCodeLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_codigo);
        this.accessCodeInput = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_codigo);
        if (!appConfigList.isEmpty()) {
            this.appConfig = appConfigList.get(0);
            this.accessCodeInput.setText(this.appConfig.getCodigo());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.acceptButton = button;
        button.setOnClickListener(view -> submitForm());
        return this.rootView;
    }

    private void submitForm() {
        if (!validateAccessCode()) {
            return;
        }
        final String code = this.accessCodeInput.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.confirm_code) + ": " + code);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper.init(AccessCodeSettingsFragment.this.context);
                AccessCodeSettingsFragment.this.appConfig.setCodigo(code);
                DatabaseHelper.getInstance().updateAppConfig(AccessCodeSettingsFragment.this.appConfig);
                Toast.makeText(AccessCodeSettingsFragment.this.context,
                        "Cambio en codigo de acceso ACEPTADO", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateAccessCode() {
        String code = this.accessCodeInput.getText().toString().trim();
        if (code.isEmpty()) {
            this.accessCodeLayout.setError(this.context.getString(R.string.err_msg_empty_codigo_acceso));
            requestFocus(this.accessCodeInput);
            return false;
        }
        if (code.length() != 3) {
            this.accessCodeLayout.setError(this.context.getString(R.string.err_msg_len_codigo_acceso));
            requestFocus(this.accessCodeInput);
            return false;
        }
        this.accessCodeLayout.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
