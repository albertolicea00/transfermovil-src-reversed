package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class U2OwCo4i4Zi extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public R1sDOSqZ2z agencia;
    public int banco;
    private Button btnAceptar;
    public Context context;
    public Float importe;
    public TextInputLayout inputLayoutTipoMoneda;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lySerie;
    public String monedaSerie;
    public View rootView;
    public String serie;
    public jN13TOyLMX spinnerTipoMoneda;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txSerie;
    public int moneda = 0;
    public boolean serieCorrecto = true;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.U2OwCo4i4Zi.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (U2OwCo4i4Zi.this.isFieldsOK()) {
                try {
                    U2OwCo4i4Zi.this.nuevoDatos();
                    U2OwCo4i4Zi.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.U2OwCo4i4Zi.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            U2OwCo4i4Zi.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.puiakig6rfrx2, container, false);
        this.context = container.getContext();
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass5.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    break;
                case 2:
                    this.banco = 2;
                    break;
                case 3:
                    this.banco = 3;
                    break;
            }
        }
        loadViewUI(this.rootView);
        if (getArguments() != null && getArguments().containsKey("cuenta_id")) {
            try {
                int cuentaID = getArguments().getInt("cuenta_id");
                TarjetaPropia tarjeta = unYp8VQThY.getInstance().getPropiaListWithID(cuentaID);
                this.txSerie.setText(tarjeta.getSerie());
                switch (AnonymousClass5.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[tarjeta.getTipo_moneda().ordinal()]) {
                    case 1:
                        this.txMonedaImporte.setText("CUP");
                        break;
                    case 2:
                        this.txMonedaImporte.setText("CUC");
                        break;
                }
            } catch (Exception e) {
            }
        }
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.U2OwCo4i4Zi$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE;

        static {
            int[] iArr = new int[qTDVwLFEjE.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE = iArr;
            try {
                iArr[qTDVwLFEjE.CUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.CUC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr2;
            try {
                iArr2[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public void loadViewUI(View v) {
        this.txSerie = (AutoCompleteTextView) v.findViewById(R.id.txSerie);
        this.lySerie = (TextInputLayout) v.findViewById(R.id.lySerie);
        this.txSerie.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.U2OwCo4i4Zi.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                U2OwCo4i4Zi.this.txMonedaImporte.setText(BuildConfig.FLAVOR);
                U2OwCo4i4Zi.this.lySerie.setErrorEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String serie = U2OwCo4i4Zi.this.txSerie.getText().toString().trim();
                if (serie.length() >= 3) {
                    char caracter = serie.charAt(2);
                    switch (caracter) {
                        case '5':
                            U2OwCo4i4Zi u2OwCo4i4Zi = U2OwCo4i4Zi.this;
                            u2OwCo4i4Zi.serieCorrecto = true;
                            u2OwCo4i4Zi.txMonedaImporte.setText("CUP");
                            break;
                        case '6':
                            U2OwCo4i4Zi u2OwCo4i4Zi2 = U2OwCo4i4Zi.this;
                            u2OwCo4i4Zi2.serieCorrecto = true;
                            u2OwCo4i4Zi2.txMonedaImporte.setText("CUC");
                            break;
                        default:
                            U2OwCo4i4Zi u2OwCo4i4Zi3 = U2OwCo4i4Zi.this;
                            u2OwCo4i4Zi3.serieCorrecto = false;
                            u2OwCo4i4Zi3.txMonedaImporte.setText(BuildConfig.FLAVOR);
                            U2OwCo4i4Zi.this.validateSerieIncorrecto();
                            break;
                    }
                }
            }
        });
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        this.lyMonto = (TextInputLayout) v.findViewById(R.id.lyMonto);
        this.txMonedaImporte = (AutoCompleteTextView) v.findViewById(R.id.txMonedaImporte);
        this.lyMonedaImporte = (TextInputLayout) v.findViewById(R.id.lyMonedaImporte);
        this.spinnerTipoMoneda = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoMoneda);
        TextInputLayout textInputLayout = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoMoneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        if (this.banco == 2) {
            textInputLayout.setVisibility(8);
        }
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        unYp8VQThY.init(this.context);
        List<TarjetaPropia> facturasLists = unYp8VQThY.getInstance().getAllPropiaLists();
        List<String> facList = new ArrayList<>();
        for (TarjetaPropia wl : facturasLists) {
            facList.add(wl.getSerie());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.txSerie.setAdapter(adapter);
        this.txSerie.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.U2OwCo4i4Zi.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    U2OwCo4i4Zi.this.txSerie.showDropDown();
                }
            }
        });
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (validateSerie() && validateMonto()) {
            return this.agencia == R1sDOSqZ2z.BANDEC || validateTipoMoneda();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        this.serie = this.txSerie.getText().toString().trim();
        this.importe = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
        this.monedaSerie = this.txMonedaImporte.getText().toString().trim();
        String cadena = this.serie + "*" + String.valueOf(this.importe) + "*" + this.moneda;
        String numberAsString = String.format("%.2f", this.importe);
        String msg = "Confirme los siguientes datos de la tarjeta propia a recargar: Serie: " + this.serie + " importe a recargar: " + numberAsString + " " + this.monedaSerie + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "77", cadena, msg, group, getFragmentManager());
    }

    private boolean validateSerie() {
        if (this.txSerie.getText().toString().trim().isEmpty()) {
            this.lySerie.setError("El campo no puede estar vacio");
            requestFocus(this.txSerie);
            return false;
        }
        if (this.txSerie.getText().toString().trim().length() != 12) {
            this.lySerie.setError(getString(R.string.err_msg_len_serie_12_propia));
            requestFocus(this.txSerie);
            return false;
        }
        if (!this.serieCorrecto) {
            this.lySerie.setError("Número de serie incorrecto");
            requestFocus(this.txSerie);
            return false;
        }
        this.lySerie.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateSerieIncorrecto() {
        this.lySerie.setError("Número de serie incorrecto");
        requestFocus(this.txSerie);
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

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x003b  */
    public void nuevoDatos() {
        try {
            String serie = this.txSerie.getText().toString();
            List<TarjetaPropia> c_list = unYp8VQThY.getInstance().getTarjetaPropiaWithSerie(serie);
            if (c_list.size() == 0) {
                TarjetaPropia c = new TarjetaPropia();
                c.setDescripcion("Nueva");
                c.setSerie(serie);
                switch (this.txMonedaImporte.getText().toString().trim()) {
                    case "CUP":
                        c.setTipo_moneda(qTDVwLFEjE.CUP);
                        break;
                    case "CUC":
                        c.setTipo_moneda(qTDVwLFEjE.CUC);
                        break;
                }
                unYp8VQThY.getInstance().addPropia(c);
            }
        } catch (Exception e) {
        }
    }
}
