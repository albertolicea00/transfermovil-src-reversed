package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class QGWR08ohw3 extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputATM;
    private TextInputLayout inputLayoutATM;
    private TextInputLayout inputLayoutPOS;
    private TextInputLayout inputLayoutTOTAL;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputPOS;
    private AutoCompleteTextView inputTOTAL;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public String[] tipomoneda;
    public int moneda = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.QGWR08ohw3.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            QGWR08ohw3.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.xcuzqo61emtxe, container, false);
        this.context = container.getContext();
        this.inputLayoutATM = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_atm);
        this.inputATM = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_atm);
        this.inputLayoutPOS = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pos);
        this.inputPOS = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pos);
        this.inputLayoutTOTAL = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_total);
        this.inputTOTAL = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_limite_total);
        this.inputLayoutTOTAL.setVisibility(8);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.QGWR08ohw3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QGWR08ohw3.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateSumaApp() || !validateTipoMoneda()) {
            return;
        }
        String atm = this.inputATM.getText().toString().trim();
        String pos = this.inputPOS.getText().toString().trim();
        int sumaTotal = 0;
        try {
            int atmF = Integer.parseInt(atm);
            int posF = Integer.parseInt(pos);
            sumaTotal = atmF + posF;
        } catch (Exception e) {
        }
        String total = String.valueOf(sumaTotal);
        String msg = String.format("¿Desea modificar temporalmente los límites de sus cuentas bancarias? Límites temporales establecidos: ATM: %s, POS:%s y Total: %s.", atm, pos, total);
        String cadena = atm + "*" + pos + "*" + total + "*" + this.moneda;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmLimiteBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "61", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputATM.getText().toString().trim().isEmpty()) {
            this.inputLayoutATM.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputATM);
            return false;
        }
        this.inputLayoutATM.setErrorEnabled(false);
        if (this.inputPOS.getText().toString().trim().isEmpty()) {
            this.inputLayoutPOS.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputPOS);
            return false;
        }
        this.inputLayoutPOS.setErrorEnabled(false);
        return true;
    }

    private boolean validateSumaApp() {
        try {
            float atm = Float.parseFloat(this.inputATM.getText().toString().trim());
            float pos = Float.parseFloat(this.inputPOS.getText().toString().trim());
            if (atm > 0.0f) {
                this.inputLayoutATM.setErrorEnabled(false);
                if (pos > 0.0f) {
                    this.inputLayoutPOS.setErrorEnabled(false);
                    return true;
                }
                this.inputLayoutPOS.setError("El valor de POS debe ser mayor que cero");
                requestFocus(this.inputPOS);
                return false;
            }
            this.inputLayoutATM.setError("El valor de ATM debe ser mayor que cero");
            requestFocus(this.inputATM);
            return false;
        } catch (Exception e) {
            this.inputLayoutATM.setError("Valor incorrecto");
            requestFocus(this.inputATM);
            this.inputLayoutPOS.setError("Valor incorrecto");
            return false;
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
    }
}
