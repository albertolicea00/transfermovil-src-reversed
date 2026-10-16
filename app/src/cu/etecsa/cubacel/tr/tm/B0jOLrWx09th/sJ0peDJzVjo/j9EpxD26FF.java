package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class j9EpxD26FF extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    public R1sDOSqZ2z agencia;
    public String agenciaL;
    public int banco;
    public Button btn_aceptar;
    public DatePickerDialog datePicker;
    public String fechaMulta;
    private TextInputLayout lyArticulo;
    private TextInputLayout lyCarnet;
    private TextInputLayout lyDecreto;
    private TextInputLayout lyFecha;
    private TextInputLayout lyInciso;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lyMulta;
    public int monedaImporte;
    private jN13TOyLMX.OnItemClickListener spClickMonedaImporte = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.j9EpxD26FF.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            j9EpxD26FF.this.monedaImporte = position + 1;
        }
    };
    public jN13TOyLMX spMonedaImporte;
    public String[] tipomonedaImporte;
    private AutoCompleteTextView txArticulo;
    private AutoCompleteTextView txCarnet;
    private AutoCompleteTextView txDecreto;
    private AutoCompleteTextView txFecha;
    private AutoCompleteTextView txInciso;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txMulta;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.b8mloqlpqisjn, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agenciaL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agenciaL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agenciaL = "03";
                    break;
            }
        }
        this.lyMulta = (TextInputLayout) this.rootView.findViewById(R.id.lyMulta);
        this.lyCarnet = (TextInputLayout) this.rootView.findViewById(R.id.lyCarnet);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.lyMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyMonedaImporte);
        this.lyDecreto = (TextInputLayout) this.rootView.findViewById(R.id.lyDecreto);
        this.lyArticulo = (TextInputLayout) this.rootView.findViewById(R.id.lyArticulo);
        this.lyInciso = (TextInputLayout) this.rootView.findViewById(R.id.lyInciso);
        this.lyFecha = (TextInputLayout) this.rootView.findViewById(R.id.lyFecha);
        this.txMulta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMulta);
        this.txCarnet = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCarnet);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.txDecreto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txDecreto);
        this.txArticulo = (AutoCompleteTextView) this.rootView.findViewById(R.id.txArticulo);
        this.txInciso = (AutoCompleteTextView) this.rootView.findViewById(R.id.txInciso);
        this.txFecha = (AutoCompleteTextView) this.rootView.findViewById(R.id.txFecha);
        this.lyDecreto.setVisibility(8);
        this.lyArticulo.setVisibility(8);
        this.lyInciso.setVisibility(8);
        this.lyFecha.setVisibility(8);
        this.txDecreto.setVisibility(8);
        this.txArticulo.setVisibility(8);
        this.txInciso.setVisibility(8);
        this.txFecha.setVisibility(8);
        this.spMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spMonedaImporte);
        this.tipomonedaImporte = getResources().getStringArray(R.array.currency_no_cuc);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_no_cuc, android.R.layout.simple_list_item_1);
        this.adapterTipoMonedaImporte = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMonedaImporte.setAdapter(this.adapterTipoMonedaImporte);
        this.spMonedaImporte.setOnItemClickListener(this.spClickMonedaImporte);
        initComponentesCuentas(this.rootView, this.agencia);
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.j9EpxD26FF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                j9EpxD26FF.this.datePicker = new DatePickerDialog(j9EpxD26FF.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.j9EpxD26FF.1.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        j9EpxD26FF.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        j9EpxD26FF.this.fechaMulta = dia + "/" + mes + "/" + year2;
                    }
                }, year, month, day);
                j9EpxD26FF.this.datePicker.show();
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btn_aceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.j9EpxD26FF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j9EpxD26FF.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.j9EpxD26FF$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private boolean isFieldsOK() {
        return validateMulta() && validateCI() && validateMonto() && validateTipoMonedaImporte() && validateSelectionAccounts();
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

    private void enviarUSSD() {
        String monedaImporteTx = "0";
        String articulo = "0000";
        String inciso = "0000";
        String idMulta = this.txMulta.getText().toString().trim();
        String ci = this.txCarnet.getText().toString().trim();
        float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
        int i = this.monedaImporte;
        if (i == 1) {
            monedaImporteTx = "CUP";
        } else if (i == 2) {
            monedaImporteTx = "USD";
        }
        String decreto = this.txDecreto.getText().toString().trim();
        if (!this.txArticulo.getText().toString().isEmpty()) {
            articulo = this.txArticulo.getText().toString().trim();
        }
        if (!this.txInciso.getText().toString().isEmpty()) {
            inciso = this.txInciso.getText().toString().trim();
        }
        String cadena = idMulta + "*" + ci + "*" + String.valueOf(importe) + "*" + String.valueOf(this.monedaImporte) + "*" + decreto + "*" + articulo + "*" + inciso + "*" + this.fechaMulta + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String numberAsString = String.format("%.2f", Float.valueOf(importe));
        String msg = "Confirme que desea pagar el siguiente identificador de multa: ID de Multa: " + idMulta + ",  importe a pagar : " + numberAsString + " " + monedaImporteTx + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "96", this.agenciaL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "96", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateMulta() {
        if (this.txMulta.getText().toString().trim().isEmpty()) {
            this.lyMulta.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txMulta);
            return false;
        }
        this.lyMulta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCI() {
        if (this.txCarnet.getText().toString().trim().isEmpty()) {
            this.lyCarnet.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txCarnet);
            return false;
        }
        this.lyCarnet.setErrorEnabled(false);
        return true;
    }

    private boolean validateDecreto() {
        if (this.txDecreto.getText().toString().trim().isEmpty()) {
            this.lyDecreto.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txDecreto);
            return false;
        }
        this.lyDecreto.setErrorEnabled(false);
        return true;
    }

    private boolean validateArticulo() {
        if (this.txArticulo.getText().toString().trim().isEmpty()) {
            return false;
        }
        validateDecreto();
        this.lyArticulo.setErrorEnabled(false);
        return true;
    }

    private boolean validateInciso() {
        if (this.txInciso.getText().toString().trim().isEmpty()) {
            return false;
        }
        validateArticulo();
        this.lyInciso.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        this.lyMonto.setErrorEnabled(false);
        try {
            Float importe = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
            if (importe.floatValue() < 1.0f) {
                this.lyMonto.setError("El monto no debe ser inferior al valor de 1 CUP.");
                requestFocus(this.txMonto);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.lyMonto.setError("Monto incorrecto");
            requestFocus(this.txMonto);
            return false;
        }
    }

    private boolean validateFecha() {
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFecha);
            return false;
        }
        this.lyFecha.setErrorEnabled(false);
        return true;
    }

    private boolean validateTipoMonedaImporte() {
        if (this.spMonedaImporte.getText().toString().trim().isEmpty()) {
            this.lyMonedaImporte.setError("Seleccione el tipo de moneda");
            requestFocus(this.spMonedaImporte);
            return false;
        }
        this.lyMonedaImporte.setErrorEnabled(false);
        return true;
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
