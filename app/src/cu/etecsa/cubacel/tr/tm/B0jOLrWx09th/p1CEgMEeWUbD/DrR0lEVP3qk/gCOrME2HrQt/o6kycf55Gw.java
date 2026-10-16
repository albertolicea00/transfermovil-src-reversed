package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class o6kycf55Gw extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapterTipoGiro;
    private Button btnAceptar;
    private AutoCompleteTextView inputCIDestino;
    private AutoCompleteTextView inputCIOrigen;
    private TextInputLayout inputLayoutCIDestino;
    private TextInputLayout inputLayoutCIOrigen;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoGiro;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputNumeroDestinatario;
    public jN13TOyLMX spinnerTipoGiro;
    public String[] tipogiro;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.llg9vymz2rdyp, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCIOrigen = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci_origen);
        this.inputCIOrigen = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci_origen);
        this.inputLayoutCIDestino = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci_destino);
        this.inputCIDestino = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci_destino);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_phone_confirm);
        this.tipogiro = getResources().getStringArray(R.array.tipo_giro);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_motivo_giro);
        this.inputLayoutTipoGiro = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoGiro = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMotivoGiro);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.tipo_giro, android.R.layout.simple_list_item_1);
        this.adapterTipoGiro = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoGiro.setAdapter(this.adapterTipoGiro);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BPA);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.o6kycf55Gw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                o6kycf55Gw.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateCIOrigen() || !validateCIDestino() || !validateMonto() || !validateSelectionAccounts() || !validateTipoMotivo() || !validateNumber()) {
            return;
        }
        String destinatario = "00000000";
        if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            destinatario = this.inputNumeroDestinatario.getText().toString();
        }
        int idTipoGiro = this.spinnerTipoGiro.getPosition_select() + 1;
        String ciO = this.inputCIOrigen.getText().toString().trim();
        String ciD = this.inputCIDestino.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String msg = "Desea realizar un giro al propietario del carnet de identidad: " + ciD + ", monto: " + monto + " CUP. El costo total de la operación es de: " + U6ucOCBccJ.calculate_importe_giro(Double.parseDouble(monto)) + " CUP. ";
        String cadena = ciO + "*" + ciD + "*" + monto + "*" + this.monedaTarjeta + "*" + idTipoGiro + "*" + destinatario + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "64", "01", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "64", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateCIOrigen() {
        if (this.inputCIOrigen.getText().toString().trim().isEmpty()) {
            this.inputLayoutCIOrigen.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCIOrigen);
            return false;
        }
        if (this.inputCIOrigen.getText().toString().trim().length() != 11) {
            this.inputLayoutCIOrigen.setError(getString(R.string.err_msg_len_ci));
            requestFocus(this.inputCIOrigen);
            return false;
        }
        this.inputLayoutCIOrigen.setErrorEnabled(false);
        return true;
    }

    private boolean validateCIDestino() {
        if (this.inputCIDestino.getText().toString().trim().isEmpty()) {
            this.inputLayoutCIDestino.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCIDestino);
            return false;
        }
        if (this.inputCIDestino.getText().toString().trim().length() != 11) {
            this.inputLayoutCIDestino.setError(getString(R.string.err_msg_len_ci));
            requestFocus(this.inputCIDestino);
            return false;
        }
        this.inputLayoutCIDestino.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        return true;
    }

    private boolean validateTipoMotivo() {
        if (this.spinnerTipoGiro.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoGiro.setError("Seleccione el motivo del giro");
            requestFocus(this.spinnerTipoGiro);
            return false;
        }
        this.inputLayoutTipoGiro.setErrorEnabled(false);
        return true;
    }

    private boolean validateNumber() {
        if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8 && !this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
        FragmentManager fragmentManager = getFragmentManager();
        Bundle result = new Bundle();
        result.putBoolean("returning", true);
        fragmentManager.setFragmentResult("returnToA", result);
        fragmentManager.popBackStack();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
