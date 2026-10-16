package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class eGLVt6hhNF extends Agg55uYctq {
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
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.eGLVt6hhNF.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            eGLVt6hhNF.this.submitForm();
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickModalidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.eGLVt6hhNF.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            eGLVt6hhNF.this.spPlazos.setText(BuildConfig.FLAVOR);
            eGLVt6hhNF eglvt6hhnf = eGLVt6hhNF.this;
            eglvt6hhnf.plazos = 0;
            int i = position + 1;
            eglvt6hhnf.modalidad = i;
            switch (i) {
                case 1:
                    eglvt6hhnf.inputLayoutPlazos.setVisibility(0);
                    eGLVt6hhNF eglvt6hhnf2 = eGLVt6hhNF.this;
                    eglvt6hhnf2.adapterPlazos = ArrayAdapter.createFromResource(eglvt6hhnf2.context, R.array.plazo_fijo_meses_bandec, android.R.layout.simple_list_item_1);
                    break;
                case 2:
                    eglvt6hhnf.inputLayoutPlazos.setVisibility(0);
                    eGLVt6hhNF eglvt6hhnf3 = eGLVt6hhNF.this;
                    eglvt6hhnf3.adapterPlazos = ArrayAdapter.createFromResource(eglvt6hhnf3.context, R.array.plazo_fijo_meses_adelanto_bandec, android.R.layout.simple_list_item_1);
                    break;
            }
            eGLVt6hhNF.this.adapterPlazos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            eGLVt6hhNF eglvt6hhnf4 = eGLVt6hhNF.this;
            eglvt6hhnf4.spPlazos.setAdapter(eglvt6hhnf4.adapterPlazos);
            eGLVt6hhNF eglvt6hhnf5 = eGLVt6hhNF.this;
            eglvt6hhnf5.spPlazos.setOnItemClickListener(eglvt6hhnf5.spClickPlazos);
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickPlazos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.eGLVt6hhNF.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            eGLVt6hhNF.this.plazos = position + 1;
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickInteres = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.eGLVt6hhNF.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            eGLVt6hhNF.this.interes = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.iwdgv3nelsqdz, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        loadViewUI(this.rootView);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.inputLayoutModalidad = (TextInputLayout) v.findViewById(R.id.inputLayoutModalidad);
        this.inputLayoutPlazos = (TextInputLayout) v.findViewById(R.id.inputLayoutPlazos);
        this.inputLayoutInteres = (TextInputLayout) v.findViewById(R.id.inputLayoutInteres);
        this.inputLayoutImporte = (TextInputLayout) v.findViewById(R.id.inputLayoutImporte);
        this.lyMonedaImporte = (TextInputLayout) v.findViewById(R.id.lyMonedaImporte);
        this.inputLayoutModalidad.setVisibility(0);
        this.inputLayoutInteres.setVisibility(8);
        this.inputLayoutPlazos.setVisibility(8);
        this.spModalidad = (jN13TOyLMX) v.findViewById(R.id.spModalidad);
        this.spPlazos = (jN13TOyLMX) v.findViewById(R.id.spPlazos);
        this.spCobroInteres = (jN13TOyLMX) v.findViewById(R.id.spCobroInteres);
        this.inputImporte = (TextInputEditText) v.findViewById(R.id.inputImporte);
        this.txMonedaImporte = (AutoCompleteTextView) v.findViewById(R.id.txMonedaImporte);
        this.btn_aceptar = (Button) v.findViewById(R.id.btn_aceptar);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.plazo_fijo_modalidad_bandec, android.R.layout.simple_list_item_1);
        this.adapterModalidad = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spModalidad.setAdapter(this.adapterModalidad);
        this.spModalidad.setOnItemClickListener(this.spClickModalidad);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        this.btn_aceptar.setOnClickListener(this.btnAceptarOnClick);
        this.txMonedaImporte.setText("CUP");
    }

    private void enviarUSSD() {
        String modalidadEnvio = "0000";
        String plazoEnvio = "0000";
        switch (this.modalidad) {
            case 1:
                modalidadEnvio = "05";
                switch (this.plazos) {
                    case 1:
                        plazoEnvio = "03";
                        this.mesesPeriodo = "3 Meses";
                        break;
                    case 2:
                        plazoEnvio = "06";
                        this.mesesPeriodo = "6 Meses";
                        break;
                    case 3:
                        plazoEnvio = "12";
                        this.mesesPeriodo = "12 Meses";
                        break;
                    case 4:
                        plazoEnvio = "24";
                        this.mesesPeriodo = "24 Meses";
                        break;
                    case 5:
                        plazoEnvio = "36";
                        this.mesesPeriodo = "36 Meses";
                        break;
                    case 6:
                        plazoEnvio = "48";
                        this.mesesPeriodo = "48 Meses";
                        break;
                    case 7:
                        plazoEnvio = "60";
                        this.mesesPeriodo = "60 Meses";
                        break;
                }
                break;
            case 2:
                modalidadEnvio = "16";
                switch (this.plazos) {
                    case 1:
                        plazoEnvio = "72";
                        this.mesesPeriodo = "72 Meses";
                        break;
                }
                break;
        }
        String cadena = String.valueOf(this.importe) + "*" + plazoEnvio + "*" + modalidadEnvio + "*" + this.moneda + "*" + this.cuentaOrigen;
        String msg = "Desea formalizar el depósito a plazo fijo por un importe de " + this.importe + " CUP, en un período de " + this.mesesPeriodo + ". Al vencimiento del plazo se prorrogará de oficio en los mismos términos a la tasa vigente.";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "81", "02", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "81", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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
        return validateTipoModalidad() && validateTipoPlazo() && validateSWCuentas() && validateMonto() && validateSelectionAccounts();
    }

    private boolean validateTipoModalidad() {
        if (this.spModalidad.getText().toString().trim().isEmpty()) {
            this.inputLayoutModalidad.setError("Seleccione una de las opciones");
            requestFocus(this.spModalidad);
            return false;
        }
        this.inputLayoutModalidad.setErrorEnabled(false);
        return true;
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

    private boolean validateSWCuentas() {
        if (this.swCuentasBanco.isChecked()) {
            return true;
        }
        Toast.makeText(this.context, "Debe insertar una cuenta. Habilite el uso de cuentas origen.", 1).show();
        return false;
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
            int i = this.modalidad;
            if (i == 1) {
                if (f < 100.0f) {
                    this.inputLayoutImporte.setError("El monto debe ser mayor o igual a 100 CUP");
                    requestFocus(this.inputImporte);
                    return false;
                }
            } else if (i == 2 && f < 1000.0f) {
                this.inputLayoutImporte.setError("El monto debe ser mayor o igual a 1000 CUP");
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
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
