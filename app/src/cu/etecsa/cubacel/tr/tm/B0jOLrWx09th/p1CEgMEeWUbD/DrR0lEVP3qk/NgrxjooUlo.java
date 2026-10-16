package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class NgrxjooUlo extends Fragment {
    public ArrayAdapter<CharSequence> adapterInteres;
    public ArrayAdapter<CharSequence> adapterModalidad;
    public ArrayAdapter<CharSequence> adapterPlazos;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public Button btn_aceptar;
    public Context context;
    public float importe;
    public TextInputEditText inputImporte;
    public TextInputLayout inputLayoutImporte;
    public TextInputLayout inputLayoutInteres;
    public TextInputLayout inputLayoutModalidad;
    public TextInputLayout inputLayoutPlazos;
    public TextInputLayout inputLayoutTipoMoneda;
    public int interes;
    public TextInputLayout lyMonedaImporte;
    public String mesesPeriodo;
    public int modalidad;
    public int plazos;
    public View rootView;
    public jN13TOyLMX spCobroInteres;
    public jN13TOyLMX spModalidad;
    public jN13TOyLMX spPlazos;
    public jN13TOyLMX spinnerTipoMoneda;
    public AutoCompleteTextView txMonedaImporte;
    public int moneda = 1;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.NgrxjooUlo.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (NgrxjooUlo.this.isFieldsOK()) {
                try {
                    NgrxjooUlo.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickPlazos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.NgrxjooUlo.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            NgrxjooUlo.this.spCobroInteres.setText(BuildConfig.FLAVOR);
            NgrxjooUlo ngrxjooUlo = NgrxjooUlo.this;
            ngrxjooUlo.interes = 0;
            int i = position + 1;
            ngrxjooUlo.plazos = i;
            switch (i) {
                case 5:
                    ngrxjooUlo.adapterInteres = ArrayAdapter.createFromResource(ngrxjooUlo.context, R.array.plazo_fijo_cobro_interes_deposito, android.R.layout.simple_list_item_1);
                    break;
                default:
                    ngrxjooUlo.adapterInteres = ArrayAdapter.createFromResource(ngrxjooUlo.context, R.array.plazo_fijo_cobro_interes, android.R.layout.simple_list_item_1);
                    break;
            }
            NgrxjooUlo.this.adapterInteres.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            NgrxjooUlo ngrxjooUlo2 = NgrxjooUlo.this;
            ngrxjooUlo2.spCobroInteres.setAdapter(ngrxjooUlo2.adapterInteres);
            NgrxjooUlo ngrxjooUlo3 = NgrxjooUlo.this;
            ngrxjooUlo3.spCobroInteres.setOnItemClickListener(ngrxjooUlo3.spClickInteres);
            NgrxjooUlo.this.inputLayoutInteres.setVisibility(0);
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickInteres = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.NgrxjooUlo.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            NgrxjooUlo.this.interes = position + 1;
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.NgrxjooUlo.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.o9cocylfn4bzr, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.inputLayoutModalidad = (TextInputLayout) v.findViewById(R.id.inputLayoutModalidad);
        this.inputLayoutPlazos = (TextInputLayout) v.findViewById(R.id.inputLayoutPlazos);
        this.inputLayoutInteres = (TextInputLayout) v.findViewById(R.id.inputLayoutInteres);
        this.inputLayoutImporte = (TextInputLayout) v.findViewById(R.id.inputLayoutImporte);
        this.inputLayoutTipoMoneda = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoMoneda);
        this.lyMonedaImporte = (TextInputLayout) v.findViewById(R.id.lyMonedaImporte);
        this.inputLayoutInteres.setVisibility(8);
        this.spModalidad = (jN13TOyLMX) v.findViewById(R.id.spModalidad);
        this.spPlazos = (jN13TOyLMX) v.findViewById(R.id.spPlazos);
        this.spCobroInteres = (jN13TOyLMX) v.findViewById(R.id.spCobroInteres);
        this.spinnerTipoMoneda = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoMoneda);
        this.inputImporte = (TextInputEditText) v.findViewById(R.id.inputImporte);
        this.txMonedaImporte = (AutoCompleteTextView) v.findViewById(R.id.txMonedaImporte);
        this.btn_aceptar = (Button) v.findViewById(R.id.btn_aceptar);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.plazo_fijo_meses_adelanto, android.R.layout.simple_list_item_1);
        this.adapterPlazos = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spPlazos.setAdapter(this.adapterPlazos);
        this.spPlazos.setOnItemClickListener(this.spClickPlazos);
        this.btn_aceptar.setOnClickListener(this.btnAceptarOnClick);
        this.txMonedaImporte.setText("CUP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        String plazoEnvio = "0000";
        String interesEnvio = "0000";
        int i = this.plazos;
        switch (i) {
            case 1:
                plazoEnvio = "12M";
                this.mesesPeriodo = "12 Meses";
                break;
            case 2:
                plazoEnvio = "24M";
                this.mesesPeriodo = "24 Meses";
                break;
            case 3:
                plazoEnvio = "36M";
                this.mesesPeriodo = "36 Meses";
                break;
            case 4:
                plazoEnvio = "60M";
                this.mesesPeriodo = "60 Meses";
                break;
            case 5:
                plazoEnvio = "72M";
                this.mesesPeriodo = "72 Meses";
                break;
        }
        if (i < 5) {
            switch (this.interes) {
                case 1:
                    interesEnvio = "1M";
                    break;
                case 2:
                    interesEnvio = "12M";
                    break;
            }
        } else {
            switch (this.interes) {
                case 1:
                    interesEnvio = "1M";
                    break;
                case 2:
                    interesEnvio = "V";
                    break;
                default:
                    Toast.makeText(this.context, "Ha ocurrido un error en la selección del interés.", 1).show();
                    return;
            }
        }
        String cadena = String.valueOf(this.importe) + "*" + plazoEnvio + "*" + interesEnvio + "*" + this.moneda;
        String msg = "Desea formalizar el depósito a plazo fijo por un importe de " + this.importe + " CUP, en un período de " + this.mesesPeriodo + ". Al vencimiento del plazo se prorrogará de oficio en los mismos términos a la tasa vigente.";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "81", cadena, msg, group, getFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        return validateTipoPlazo() && validateTipoInteres() && validateMonto();
    }

    private boolean validateTipoModalidad() {
        if (this.spModalidad.getText().toString().trim().isEmpty()) {
            this.inputLayoutModalidad.setError("Seleccione una de las modalidades");
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

    private boolean validateTipoInteres() {
        if (this.spCobroInteres.getText().toString().trim().isEmpty()) {
            this.inputLayoutInteres.setError("Seleccione el cobro de interés adelantado");
            requestFocus(this.spCobroInteres);
            return false;
        }
        this.inputLayoutInteres.setErrorEnabled(false);
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
            if (f < 500.0f) {
                this.inputLayoutImporte.setError("El monto debe ser mayor o igual a 500 CUP");
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
