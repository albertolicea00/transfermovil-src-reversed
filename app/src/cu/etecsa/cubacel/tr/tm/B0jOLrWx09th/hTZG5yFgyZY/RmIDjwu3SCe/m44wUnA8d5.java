package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m44wUnA8d5 extends Fragment implements FBsQzP3Zfj.UssdBaseObserver {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private Button btnAceptar;
    public Context context;
    public String cuenta;
    private AutoCompleteTextView inputCi;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCi;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMisCuentas;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public List<MCBank> misCuentas;
    public View rootView;
    public jN13TOyLMX spBolsa;
    public jN13TOyLMX spinnerMisCuentas;
    public int tipoBolsa = 0;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public String tipo = "1";
    public jN13TOyLMX.OnItemClickListener btnUltOper = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.m44wUnA8d5.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.m44wUnA8d5.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = m44wUnA8d5.this.mcBankArrayAdapter.getItem(position);
            m44wUnA8d5.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.m44wUnA8d5.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            m44wUnA8d5 m44wuna8d5 = m44wUnA8d5.this;
            m44wuna8d5.tipoBolsa = position + 1;
            switch (position) {
                case 0:
                    if (m44wuna8d5.cargarMisCuentas()) {
                        m44wUnA8d5.this.inputLayoutMisCuentas.setVisibility(0);
                    } else {
                        m44wUnA8d5.this.showDialogNoTieneCuentas();
                        m44wUnA8d5.this.inputLayoutMisCuentas.setVisibility(8);
                    }
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ytsbwky0i9zog, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_mis_cuentas, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerMisCuentas.setAdapter(this.adapterTipoBolsa);
        this.spinnerMisCuentas.setOnItemClickListener(this.spClickBolsa);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_cuenta);
        this.inputLayoutMisCuentas = textInputLayout;
        textInputLayout.setVisibility(8);
        this.spBolsa = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuenta);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCi = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.m44wUnA8d5.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m44wUnA8d5.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateClave() || !validateCi() || !validateCuenta()) {
            return;
        }
        String pin = this.inputClave.getText().toString().trim();
        String ci = this.inputCi.getText().toString().trim();
        this.cuenta = this.miCuentaSeleccion;
        String cadena = "08*" + ci + "*" + pin + "*" + this.cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBackAsocClasica(this.context, "68", cadena, "Desea eliminar su registro del sistema", group, getFragmentManager(), this);
    }

    private boolean validateCuenta() {
        if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        if (this.miCuentaSeleccion.length() != 16) {
            this.spBolsa.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.spBolsa);
            return false;
        }
        this.inputLayoutMisCuentas.setErrorEnabled(false);
        return true;
    }

    private boolean validateCi() {
        if (this.inputCi.getText().toString().trim().isEmpty()) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public String reemplazarCaracteresRaros(String input) {
        String output = input;
        for (int i = 0; i < "àèìòùÀÉËÌÓÚçÇ".length(); i++) {
            output = output.replace("àèìòùÀÉËÌÓÚçÇ".charAt(i), "aeiouAEIIOUcC".charAt(i));
        }
        return output;
    }

    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.MiTransfer);
            List<MCBank> listClasic = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.CLASICAEMP);
            this.mcBankArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            if ((list == null || list.size() <= 0) && (listClasic == null || listClasic.size() <= 0)) {
                return false;
            }
            if (list != null && list.size() > 0) {
                for (MCBank uyh0pxs9m37in : list) {
                    this.mcBankArrayAdapter.add(uyh0pxs9m37in);
                }
            }
            if (listClasic != null && listClasic.size() > 0) {
                for (MCBank uyh0pxs9m37in2 : listClasic) {
                    this.mcBankArrayAdapter.add(uyh0pxs9m37in2);
                }
            }
            this.mcBankArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spBolsa.setAdapter(this.mcBankArrayAdapter);
            this.spBolsa.setOnItemClickListener(this.spClickMisCuentas);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.m44wUnA8d5.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj.UssdBaseObserver
    public void onCloseAndBack() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj.UssdBaseObserver
    public void onClose(boolean result) {
        if (result) {
            rDEl7rW1aN baseActivity = new rDEl7rW1aN();
            List<MCBank> cuentaBanco = unYp8VQThY.getInstance().getMiCuenta(baseActivity.encryption(this.cuenta));
            if (cuentaBanco.size() > 0) {
                unYp8VQThY.init(this.context);
                unYp8VQThY.getInstance().deleteMCBank(cuentaBanco.get(0));
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack();
        }
    }
}
