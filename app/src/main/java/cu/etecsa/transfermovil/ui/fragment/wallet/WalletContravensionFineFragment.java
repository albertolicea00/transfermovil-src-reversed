package cu.etecsa.transfermovil.ui.fragment.wallet;

import cu.etecsa.transfermovil.banking.ui.bfi.BaseBankingFragment;

import android.R;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MultasTransito;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.cLvoxQAY8E */
public class WalletContravensionFineFragment extends BaseBankingFragment {
    public ArrayAdapter<CharSequence> adapterArticulosMulta;
    public ArrayAdapter<CharSequence> adapterTipoPeligrosidad;
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public int articulo;
    public String[] articuloMUlta;
    public int banco;
    public Button btn_aceptar;
    public CardView cdDatallesMulta;
    public DatePickerDialog datePicker;
    public String fechaMulta;
    public MultasTransito incisoMulta;
    public ArrayAdapter<MultasTransito> incisosArrayAdapter;
    public List<MultasTransito> incisosList;
    public boolean isEdit;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyArticulo;
    private TextInputLayout lyArticuloSP;
    private TextInputLayout lyFecha;
    private TextInputLayout lyInciso;
    private TextInputLayout lyIncisoSP;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lyMulta;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyPeligrosidad;
    private TextInputLayout lyProvincia;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public int peligrosidad;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public jN13TOyLMX spArticulo;
    public jN13TOyLMX spInciso;
    public jN13TOyLMX spMunicipio;
    public jN13TOyLMX spPeligrosidad;
    public jN13TOyLMX spProvincia;
    public Switch swEditar;
    public String[] tipoPeligrosidad;
    private AutoCompleteTextView txArticulo;
    public TextView txDatosMulta;
    private AutoCompleteTextView txDecreto;
    private AutoCompleteTextView txFecha;
    private AutoCompleteTextView txInciso;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txMulta;
    public TextView txPeligrosidad;
    public String articuloUSSD = "0000";
    public String incisoUSSD = "0000";
    private jN13TOyLMX.OnItemClickListener spClickTipoPeligrosidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
            clvoxqay8e.peligrosidad = position + 1;
            clvoxqay8e.lyMonto.setVisibility(0);
            WalletContravensionFineFragment.this.lyMonedaImporte.setVisibility(0);
            WalletContravensionFineFragment clvoxqay8e2 = WalletContravensionFineFragment.this;
            switch (clvoxqay8e2.peligrosidad) {
                case 1:
                    clvoxqay8e2.txMonto.setText("60");
                    break;
                case 2:
                    clvoxqay8e2.txMonto.setText("40");
                    break;
                case 3:
                    clvoxqay8e2.txMonto.setText("20");
                    break;
            }
            WalletContravensionFineFragment.this.txMonedaImporte.setText("CUP");
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
            clvoxqay8e.provincia = clvoxqay8e.provinciasArrayAdapter.getItem(position);
            WalletContravensionFineFragment clvoxqay8e2 = WalletContravensionFineFragment.this;
            clvoxqay8e2.municipio = null;
            clvoxqay8e2.spMunicipio.setText(BuildConfig.FLAVOR);
            WalletContravensionFineFragment clvoxqay8e3 = WalletContravensionFineFragment.this;
            clvoxqay8e3.loadMunicipio(clvoxqay8e3.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickArticulos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
            clvoxqay8e.articulo = Integer.valueOf(clvoxqay8e.articuloMUlta[position]).intValue();
            WalletContravensionFineFragment clvoxqay8e2 = WalletContravensionFineFragment.this;
            clvoxqay8e2.articuloUSSD = String.valueOf(clvoxqay8e2.articulo);
            WalletContravensionFineFragment clvoxqay8e3 = WalletContravensionFineFragment.this;
            clvoxqay8e3.incisoMulta = null;
            clvoxqay8e3.spInciso.setText(BuildConfig.FLAVOR);
            WalletContravensionFineFragment.this.cdDatallesMulta.setVisibility(8);
            WalletContravensionFineFragment.this.txPeligrosidad.setVisibility(8);
            WalletContravensionFineFragment.this.txDatosMulta.setVisibility(8);
            WalletContravensionFineFragment.this.txDatosMulta.setText(BuildConfig.FLAVOR);
            WalletContravensionFineFragment.this.txPeligrosidad.setText(BuildConfig.FLAVOR);
            WalletContravensionFineFragment.this.jsonFilesManager = new V9s8rJIDplX();
            WalletContravensionFineFragment clvoxqay8e4 = WalletContravensionFineFragment.this;
            List<MultasTransito> list = clvoxqay8e4.jsonFilesManager.loadDataTransitoIncisos(clvoxqay8e4.context, WalletContravensionFineFragment.this.articulo);
            WalletContravensionFineFragment.this.incisosList = null;
            if (list != null && list.size() > 0) {
                WalletContravensionFineFragment clvoxqay8e5 = WalletContravensionFineFragment.this;
                clvoxqay8e5.incisosList = list;
                clvoxqay8e5.incisosArrayAdapter = new ArrayAdapter<>(WalletContravensionFineFragment.this.context, R.layout.simple_dropdown_item_1line);
                for (MultasTransito uyh0pxs9m37in : list) {
                    WalletContravensionFineFragment.this.incisosArrayAdapter.add(uyh0pxs9m37in);
                }
                WalletContravensionFineFragment.this.incisosArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                WalletContravensionFineFragment clvoxqay8e6 = WalletContravensionFineFragment.this;
                clvoxqay8e6.spInciso.setAdapter(clvoxqay8e6.incisosArrayAdapter);
                WalletContravensionFineFragment clvoxqay8e7 = WalletContravensionFineFragment.this;
                clvoxqay8e7.spInciso.setOnItemClickListener(clvoxqay8e7.spClickInciso);
                WalletContravensionFineFragment.this.incisosArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickInciso = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
            clvoxqay8e.incisoMulta = clvoxqay8e.incisosArrayAdapter.getItem(position);
            WalletContravensionFineFragment clvoxqay8e2 = WalletContravensionFineFragment.this;
            clvoxqay8e2.incisoUSSD = String.valueOf(clvoxqay8e2.incisoMulta);
            WalletContravensionFineFragment clvoxqay8e3 = WalletContravensionFineFragment.this;
            if (clvoxqay8e3.incisoMulta != null) {
                clvoxqay8e3.cdDatallesMulta.setVisibility(0);
                WalletContravensionFineFragment.this.txPeligrosidad.setVisibility(0);
                WalletContravensionFineFragment.this.txDatosMulta.setVisibility(0);
                WalletContravensionFineFragment clvoxqay8e4 = WalletContravensionFineFragment.this;
                clvoxqay8e4.txDatosMulta.setText(clvoxqay8e4.incisoMulta.getDescripcion());
                WalletContravensionFineFragment clvoxqay8e5 = WalletContravensionFineFragment.this;
                clvoxqay8e5.txPeligrosidad.setText(String.valueOf(clvoxqay8e5.incisoMulta.getPeligrosidad()));
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
            clvoxqay8e.municipio = clvoxqay8e.municipioArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.a9a6tdoq4oqqk, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.isEdit = false;
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass9.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agencyL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agencyL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agencyL = "03";
                    break;
            }
        }
        this.lyMulta = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMulta);
        this.lyPeligrosidad = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyPeligrosidad);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMonto);
        this.lyMonedaImporte = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMonedaImporte);
        this.lyArticulo = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyArticulo);
        this.lyInciso = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyInciso);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMunicipio);
        this.lyFecha = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyFecha);
        this.lyArticuloSP = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyArticuloSP);
        this.lyIncisoSP = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyIncisoSP);
        this.txMulta = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txMulta);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txMonto);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txMonedaImporte);
        this.txDecreto = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txDecreto);
        this.txArticulo = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txArticulo);
        this.txInciso = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txInciso);
        this.txFecha = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txFecha);
        this.spPeligrosidad = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spPeligrosidad);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spProvincia);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spMunicipio);
        this.spArticulo = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spArticulo);
        this.spInciso = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spInciso);
        this.lyPeligrosidad.setVisibility(8);
        this.spPeligrosidad.setVisibility(8);
        this.cdDatallesMulta = (CardView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.cdDatallesMulta);
        this.txPeligrosidad = (TextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txPeligrosidad);
        this.txDatosMulta = (TextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.txDatosMulta);
        this.cdDatallesMulta.setVisibility(8);
        this.lyArticulo.setVisibility(8);
        this.lyInciso.setVisibility(8);
        Switch r0 = (Switch) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.swEditar);
        this.swEditar = r0;
        r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                WalletContravensionFineFragment clvoxqay8e = WalletContravensionFineFragment.this;
                clvoxqay8e.articuloUSSD = BuildConfig.FLAVOR;
                clvoxqay8e.incisoUSSD = BuildConfig.FLAVOR;
                clvoxqay8e.spArticulo.setText(BuildConfig.FLAVOR);
                WalletContravensionFineFragment.this.spInciso.setText(BuildConfig.FLAVOR);
                WalletContravensionFineFragment clvoxqay8e2 = WalletContravensionFineFragment.this;
                clvoxqay8e2.articulo = 0;
                clvoxqay8e2.incisoMulta = null;
                clvoxqay8e2.cdDatallesMulta.setVisibility(8);
                WalletContravensionFineFragment.this.txPeligrosidad.setVisibility(8);
                WalletContravensionFineFragment.this.txDatosMulta.setVisibility(8);
                WalletContravensionFineFragment.this.txDatosMulta.setText(BuildConfig.FLAVOR);
                WalletContravensionFineFragment.this.txPeligrosidad.setText(BuildConfig.FLAVOR);
                if (!b) {
                    WalletContravensionFineFragment.this.lyArticulo.setVisibility(8);
                    WalletContravensionFineFragment.this.lyInciso.setVisibility(8);
                    WalletContravensionFineFragment.this.lyArticuloSP.setVisibility(0);
                    WalletContravensionFineFragment.this.lyIncisoSP.setVisibility(0);
                    return;
                }
                WalletContravensionFineFragment.this.cdDatallesMulta.setVisibility(8);
                WalletContravensionFineFragment.this.lyArticulo.setVisibility(0);
                WalletContravensionFineFragment.this.lyInciso.setVisibility(0);
                WalletContravensionFineFragment.this.lyArticuloSP.setVisibility(8);
                WalletContravensionFineFragment.this.lyIncisoSP.setVisibility(8);
                WalletContravensionFineFragment.this.isEdit = true;
            }
        });
        initComponentesCuentas(this.rootView, this.agencia);
        loadProvincias();
        this.tipoPeligrosidad = getResources().getStringArray(cu.etecsa.cubacel.tr.tm.R.array.array_multa_peligrosidad);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, cu.etecsa.cubacel.tr.tm.R.array.array_multa_peligrosidad, R.layout.simple_list_item_1);
        this.adapterTipoPeligrosidad = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spPeligrosidad.setAdapter(this.adapterTipoPeligrosidad);
        this.spPeligrosidad.setOnItemClickListener(this.spClickTipoPeligrosidad);
        this.articuloMUlta = getResources().getStringArray(cu.etecsa.cubacel.tr.tm.R.array.array_articulos_multa);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, cu.etecsa.cubacel.tr.tm.R.array.array_articulos_multa, R.layout.simple_list_item_1);
        this.adapterArticulosMulta = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spArticulo.setAdapter(this.adapterArticulosMulta);
        this.spArticulo.setOnItemClickListener(this.spClickArticulos);
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                WalletContravensionFineFragment.this.datePicker = new DatePickerDialog(WalletContravensionFineFragment.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.2.1
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
                        WalletContravensionFineFragment.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        WalletContravensionFineFragment.this.fechaMulta = dia + "/" + mes + "/" + year2;
                    }
                }, year, month, day);
                WalletContravensionFineFragment.this.datePicker.show();
            }
        });
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btn_aceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletContravensionFineFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.WalletContravensionFineFragment$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
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
        if (!validateMulta()) {
            return false;
        }
        if (this.isEdit) {
            if (!validateArticulo() || !validateInciso()) {
                return false;
            }
            this.incisoUSSD = this.txInciso.getText().toString().trim();
            this.articuloUSSD = this.txArticulo.getText().toString().trim();
        } else if (!validateArticuloSP() || !validateIncisoSP()) {
            return false;
        }
        return validateMunicipio() && validateMunicipio() && validateFecha() && validateSelectionAccounts();
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
        String idMulta = this.txMulta.getText().toString().trim();
        String provinciaCod = this.provincia.getCod_provincia();
        String municipioCod = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
        String cadena = idMulta + "*0000*" + this.articuloUSSD + "*" + this.incisoUSSD + "*" + municipioCod + "*" + provinciaCod + "*1*" + this.fechaMulta + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String msg = "Confirme que desea pagar el siguiente identificador de multa de tránsito: ID de Multa: " + idMulta + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.frmBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "97", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            UssdDispatcher.actionCallUSSDBack(this.context, "97", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateMulta() {
        if (this.txMulta.getText().toString().trim().isEmpty()) {
            this.lyMulta.setError(this.context.getString(cu.etecsa.cubacel.tr.tm.R.string.hint_campo_vacio));
            requestFocus(this.txMulta);
            return false;
        }
        this.lyMulta.setErrorEnabled(false);
        return true;
    }

    private boolean validatePeligrosidad() {
        this.lyPeligrosidad.setErrorEnabled(false);
        if (this.spPeligrosidad.getText().toString().trim().isEmpty()) {
            this.lyPeligrosidad.setError("Seleccione la peligrosidad");
            requestFocus(this.spPeligrosidad);
            return false;
        }
        this.lyPeligrosidad.setErrorEnabled(false);
        return true;
    }

    private boolean validateArticulo() {
        if (this.txArticulo.getText().toString().trim().isEmpty()) {
            this.lyArticulo.setError(this.context.getString(cu.etecsa.cubacel.tr.tm.R.string.hint_campo_vacio));
            requestFocus(this.txArticulo);
            return false;
        }
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

    private boolean validateFecha() {
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError(this.context.getString(cu.etecsa.cubacel.tr.tm.R.string.hint_campo_vacio));
            requestFocus(this.txFecha);
            return false;
        }
        this.lyFecha.setErrorEnabled(false);
        return true;
    }

    private boolean validateProvincia() {
        this.lyProvincia.setErrorEnabled(false);
        if (this.spProvincia.getText().toString().trim().isEmpty()) {
            this.lyProvincia.setError("Seleccione el provincia");
            requestFocus(this.spProvincia);
            return false;
        }
        this.lyProvincia.setErrorEnabled(false);
        return true;
    }

    private boolean validateMunicipio() {
        this.lyMunicipio.setErrorEnabled(false);
        if (this.spMunicipio.getText().toString().trim().isEmpty()) {
            this.lyMunicipio.setError("Seleccione el municipio");
            requestFocus(this.spMunicipio);
            return false;
        }
        this.lyMunicipio.setErrorEnabled(false);
        return true;
    }

    private boolean validateArticuloSP() {
        this.lyArticuloSP.setErrorEnabled(false);
        if (this.spArticulo.getText().toString().trim().isEmpty()) {
            this.lyArticuloSP.setError("Seleccione el artículo");
            requestFocus(this.spArticulo);
            return false;
        }
        this.lyArticuloSP.setErrorEnabled(false);
        return true;
    }

    private boolean validateIncisoSP() {
        this.lyIncisoSP.setErrorEnabled(false);
        if (this.spInciso.getText().toString().trim().isEmpty()) {
            this.lyIncisoSP.setError("Seleccione el inciso");
            requestFocus(this.spInciso);
            return false;
        }
        this.lyIncisoSP.setErrorEnabled(false);
        return true;
    }

    private boolean loadProvincias() {
        try {
            List<Provincia> list = unYp8VQThY.getInstance().getAllProvinciasLists();
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.provinciaList = list;
            this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
            for (Provincia uyh0pxs9m37in : list) {
                this.provinciasArrayAdapter.add(uyh0pxs9m37in);
            }
            this.provinciasArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.spProvincia.setAdapter(this.provinciasArrayAdapter);
            this.spProvincia.setOnItemClickListener(this.spClickProvincias);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadMunicipio(String codigo) {
        try {
            List<Municipio> list = unYp8VQThY.getInstance().getAllMunipiosLists(codigo);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.municipiosList = list;
            this.municipioArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipioArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipioArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.spMunicipio.setAdapter(this.municipioArrayAdapter);
            this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
            this.municipioArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
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
