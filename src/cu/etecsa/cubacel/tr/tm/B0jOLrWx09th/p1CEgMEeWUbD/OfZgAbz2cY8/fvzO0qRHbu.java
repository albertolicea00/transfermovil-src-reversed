package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class fvzO0qRHbu extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoGiro;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputCIDestino;
    private AutoCompleteTextView inputCIOrigen;
    private TextInputLayout inputLayoutCIDestino;
    private TextInputLayout inputLayoutCIOrigen;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoGiro;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputNumeroDestinatario;
    public View rootView;
    public jN13TOyLMX spinnerTipoGiro;
    public jN13TOyLMX spinnerTipoMoneda;
    public String[] tipogiro;
    public String[] tipomoneda;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.c6qtx7siox18wl, container, false);
        this.context = container.getContext();
        this.inputLayoutCIOrigen = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci_origen);
        this.inputCIOrigen = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci_origen);
        this.inputLayoutCIDestino = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci_destino);
        this.inputCIDestino = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci_destino);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_phone_confirm);
        this.tipogiro = getResources().getStringArray(R.array.tipo_giro);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_motivo_giro);
        this.inputLayoutTipoGiro = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoGiro = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMotivoGiro);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.tipo_giro, android.R.layout.simple_list_item_1);
        this.adapterTipoGiro = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoGiro.setAdapter(this.adapterTipoGiro);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.fvzO0qRHbu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fvzO0qRHbu.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        int idCurrency;
        if (!validateCIOrigen() || !validateCIDestino() || !validateMonto() || !validateTipoMotivo() || !validateNumber()) {
            return;
        }
        String destinatario = "00000000";
        if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            destinatario = this.inputNumeroDestinatario.getText().toString();
        }
        int pos_tipoMoneda = this.spinnerTipoMoneda.getPosition_select();
        if (pos_tipoMoneda == 0) {
            idCurrency = 1;
        } else {
            idCurrency = 2;
        }
        int idTipoGiro = this.spinnerTipoGiro.getPosition_select() + 1;
        String ciO = this.inputCIOrigen.getText().toString().trim();
        String ciD = this.inputCIDestino.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String msg = "Desea realizar un giro al propietario del carnet de identidad: " + ciD + ", monto: " + monto + " CUP. El costo total de la operación es de: " + U6ucOCBccJ.calculate_importe_giro(Double.parseDouble(monto)) + " CUP. ";
        String cadena = ciO + "*" + ciD + "*" + monto + "*" + idCurrency + "*" + idTipoGiro + "*" + destinatario;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "64", cadena, msg, group, getFragmentManager());
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

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
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
}
