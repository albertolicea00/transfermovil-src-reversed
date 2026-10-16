package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class o7atwhPiFj extends QGQCqILT4b {
    public ArrayAdapter<CharSequence> adapterInteres;
    public ArrayAdapter<CharSequence> adapterModalidad;
    public ArrayAdapter<CharSequence> adapterPlazos;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public Button btn_aceptar;
    public float importe;
    public TextInputEditText inputImporte;
    public TextInputLayout inputLayoutImporte;
    public TextInputLayout inputLayoutInteres;
    public TextInputLayout inputLayoutModalidad;
    public TextInputLayout inputLayoutPlazos;
    public int interes;
    public TextInputLayout lyMonedaImporte;
    public String mesesPeriodo;
    public int modalidad;
    public int plazos;
    public jN13TOyLMX spCobroInteres;
    public jN13TOyLMX spModalidad;
    public jN13TOyLMX spPlazos;
    public AutoCompleteTextView txMonedaImporte;
    public int moneda = 1;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.o7atwhPiFj.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            o7atwhPiFj.this.submitForm();
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickPlazos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.o7atwhPiFj.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            o7atwhPiFj.this.plazos = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.iwdgv3nelsqdz, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.inputLayoutModalidad = (TextInputLayout) v.findViewById(R.id.inputLayoutModalidad);
        this.inputLayoutPlazos = (TextInputLayout) v.findViewById(R.id.inputLayoutPlazos);
        this.inputLayoutInteres = (TextInputLayout) v.findViewById(R.id.inputLayoutInteres);
        this.inputLayoutImporte = (TextInputLayout) v.findViewById(R.id.inputLayoutImporte);
        this.lyMonedaImporte = (TextInputLayout) v.findViewById(R.id.lyMonedaImporte);
        this.inputLayoutInteres.setVisibility(8);
        this.spModalidad = (jN13TOyLMX) v.findViewById(R.id.spModalidad);
        this.spPlazos = (jN13TOyLMX) v.findViewById(R.id.spPlazos);
        this.spCobroInteres = (jN13TOyLMX) v.findViewById(R.id.spCobroInteres);
        this.inputImporte = (TextInputEditText) v.findViewById(R.id.inputImporte);
        this.txMonedaImporte = (AutoCompleteTextView) v.findViewById(R.id.txMonedaImporte);
        this.btn_aceptar = (Button) v.findViewById(R.id.btn_aceptar);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.plazo_fijo_meses_adelanto_metro, android.R.layout.simple_list_item_1);
        this.adapterPlazos = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spPlazos.setAdapter(this.adapterPlazos);
        this.spPlazos.setOnItemClickListener(this.spClickPlazos);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        this.btn_aceptar.setOnClickListener(this.btnAceptarOnClick);
        this.txMonedaImporte.setText("CUP");
    }

    private void enviarUSSD() {
        String plazoEnvio = "0000";
        switch (this.plazos) {
            case 1:
                plazoEnvio = "12";
                this.mesesPeriodo = "12 Meses";
                break;
            case 2:
                plazoEnvio = "24";
                this.mesesPeriodo = "24 Meses";
                break;
            case 3:
                plazoEnvio = "36";
                this.mesesPeriodo = "36 Meses";
                break;
            case 4:
                plazoEnvio = "60";
                this.mesesPeriodo = "60 Meses";
                break;
        }
        String cadena = String.valueOf(this.importe) + "*" + plazoEnvio + "*0000*" + this.moneda + "*" + this.cuentaOrigen;
        String msg = "Desea formalizar el depósito a plazo fijo por un importe de " + this.importe + " CUP, en un período de " + this.mesesPeriodo + ". Al vencimiento del plazo se prorrogará de oficio en los mismos términos a la tasa vigente.";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "81", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (isFieldsOK()) {
            try {
                enviarUSSD();
            } catch (Exception e) {
            }
        }
    }

    private boolean isFieldsOK() {
        return validateTipoPlazo() && validateMonto() && validateSelectionAccounts();
    }

    private boolean validateTipoPlazo() {
        if (this.spPlazos.getText().toString().trim().isEmpty()) {
            this.inputLayoutPlazos.setError("Seleccione la cantidad de meses para el plazo");
            requestFocus(this.spPlazos);
            return false;
        }
        this.inputLayoutPlazos.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputImporte);
            return false;
        }
        this.inputLayoutImporte.setErrorEnabled(false);
        try {
            float f = Float.parseFloat(this.inputImporte.getText().toString().trim());
            this.importe = f;
            if (f < 200.0f) {
                this.inputLayoutImporte.setError("El monto debe ser mayor o igual a 200 CUP");
                requestFocus(this.inputImporte);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.inputLayoutImporte.setError("Monto incorrecto");
            requestFocus(this.inputImporte);
            return false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }
}
