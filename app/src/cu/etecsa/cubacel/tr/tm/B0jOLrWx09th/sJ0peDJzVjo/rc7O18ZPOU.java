package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MultasTransito;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class rc7O18ZPOU extends QGQCqILT4b {
    public Activity activity;
    public ArrayAdapter<CharSequence> adapterArticulosMulta;
    public ArrayAdapter<CharSequence> adapterTipoPeligrosidad;
    public R1sDOSqZ2z agencia;
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
    public boolean isConfirmMulta;
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
    private jN13TOyLMX.OnItemClickListener spClickTipoPeligrosidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
            rc7o18zpou.peligrosidad = position + 1;
            rc7o18zpou.lyMonto.setVisibility(0);
            rc7O18ZPOU.this.lyMonedaImporte.setVisibility(0);
            rc7O18ZPOU rc7o18zpou2 = rc7O18ZPOU.this;
            switch (rc7o18zpou2.peligrosidad) {
                case 1:
                    rc7o18zpou2.txMonto.setText("60");
                    break;
                case 2:
                    rc7o18zpou2.txMonto.setText("40");
                    break;
                case 3:
                    rc7o18zpou2.txMonto.setText("20");
                    break;
            }
            rc7O18ZPOU.this.txMonedaImporte.setText("CUP");
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
            rc7o18zpou.provincia = rc7o18zpou.provinciasArrayAdapter.getItem(position);
            rc7O18ZPOU rc7o18zpou2 = rc7O18ZPOU.this;
            rc7o18zpou2.municipio = null;
            rc7o18zpou2.spMunicipio.setText(BuildConfig.FLAVOR);
            rc7O18ZPOU rc7o18zpou3 = rc7O18ZPOU.this;
            rc7o18zpou3.loadMunicipio(rc7o18zpou3.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickArticulos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
            rc7o18zpou.articulo = Integer.valueOf(rc7o18zpou.articuloMUlta[position]).intValue();
            rc7O18ZPOU rc7o18zpou2 = rc7O18ZPOU.this;
            rc7o18zpou2.articuloUSSD = String.valueOf(rc7o18zpou2.articulo);
            rc7O18ZPOU rc7o18zpou3 = rc7O18ZPOU.this;
            rc7o18zpou3.incisoMulta = null;
            rc7o18zpou3.spInciso.setText(BuildConfig.FLAVOR);
            rc7O18ZPOU.this.cdDatallesMulta.setVisibility(8);
            rc7O18ZPOU.this.txPeligrosidad.setVisibility(8);
            rc7O18ZPOU.this.txDatosMulta.setVisibility(8);
            rc7O18ZPOU.this.txDatosMulta.setText(BuildConfig.FLAVOR);
            rc7O18ZPOU.this.txPeligrosidad.setText(BuildConfig.FLAVOR);
            rc7O18ZPOU.this.jsonFilesManager = new V9s8rJIDplX();
            rc7O18ZPOU rc7o18zpou4 = rc7O18ZPOU.this;
            List<MultasTransito> list = rc7o18zpou4.jsonFilesManager.loadDataTransitoIncisos(rc7o18zpou4.context, rc7O18ZPOU.this.articulo);
            rc7O18ZPOU.this.incisosList = null;
            if (list != null && list.size() > 0) {
                rc7O18ZPOU rc7o18zpou5 = rc7O18ZPOU.this;
                rc7o18zpou5.incisosList = list;
                rc7o18zpou5.incisosArrayAdapter = new ArrayAdapter<>(rc7O18ZPOU.this.context, R.layout.simple_dropdown_item_1line);
                for (MultasTransito uyh0pxs9m37in : list) {
                    rc7O18ZPOU.this.incisosArrayAdapter.add(uyh0pxs9m37in);
                }
                rc7O18ZPOU.this.incisosArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                rc7O18ZPOU rc7o18zpou6 = rc7O18ZPOU.this;
                rc7o18zpou6.spInciso.setAdapter(rc7o18zpou6.incisosArrayAdapter);
                rc7O18ZPOU rc7o18zpou7 = rc7O18ZPOU.this;
                rc7o18zpou7.spInciso.setOnItemClickListener(rc7o18zpou7.spClickInciso);
                rc7O18ZPOU.this.incisosArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickInciso = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
            rc7o18zpou.incisoMulta = rc7o18zpou.incisosArrayAdapter.getItem(position);
            rc7O18ZPOU rc7o18zpou2 = rc7O18ZPOU.this;
            rc7o18zpou2.incisoUSSD = String.valueOf(rc7o18zpou2.incisoMulta);
            rc7O18ZPOU rc7o18zpou3 = rc7O18ZPOU.this;
            if (rc7o18zpou3.incisoMulta != null) {
                rc7o18zpou3.cdDatallesMulta.setVisibility(0);
                rc7O18ZPOU.this.txPeligrosidad.setVisibility(0);
                rc7O18ZPOU.this.txDatosMulta.setVisibility(0);
                rc7O18ZPOU rc7o18zpou4 = rc7O18ZPOU.this;
                rc7o18zpou4.txDatosMulta.setText(rc7o18zpou4.incisoMulta.getDescripcion());
                rc7O18ZPOU rc7o18zpou5 = rc7O18ZPOU.this;
                rc7o18zpou5.txPeligrosidad.setText(String.valueOf(rc7o18zpou5.incisoMulta.getPeligrosidad()));
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
            rc7o18zpou.municipio = rc7o18zpou.municipioArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.a9a6tdoq4oqqk, container, false);
        this.context = container.getContext();
        this.isEdit = false;
        this.isConfirmMulta = false;
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass12.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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
        r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
                rc7o18zpou.articuloUSSD = BuildConfig.FLAVOR;
                rc7o18zpou.incisoUSSD = BuildConfig.FLAVOR;
                rc7o18zpou.spArticulo.setText(BuildConfig.FLAVOR);
                rc7O18ZPOU.this.spInciso.setText(BuildConfig.FLAVOR);
                rc7O18ZPOU rc7o18zpou2 = rc7O18ZPOU.this;
                rc7o18zpou2.articulo = 0;
                rc7o18zpou2.incisoMulta = null;
                rc7o18zpou2.cdDatallesMulta.setVisibility(8);
                rc7O18ZPOU.this.txPeligrosidad.setVisibility(8);
                rc7O18ZPOU.this.txDatosMulta.setVisibility(8);
                rc7O18ZPOU.this.txDatosMulta.setText(BuildConfig.FLAVOR);
                rc7O18ZPOU.this.txPeligrosidad.setText(BuildConfig.FLAVOR);
                if (!b) {
                    rc7O18ZPOU.this.lyArticulo.setVisibility(8);
                    rc7O18ZPOU.this.lyInciso.setVisibility(8);
                    rc7O18ZPOU.this.lyArticuloSP.setVisibility(0);
                    rc7O18ZPOU.this.lyIncisoSP.setVisibility(0);
                    return;
                }
                rc7O18ZPOU.this.cdDatallesMulta.setVisibility(8);
                rc7O18ZPOU.this.lyArticulo.setVisibility(0);
                rc7O18ZPOU.this.lyInciso.setVisibility(0);
                rc7O18ZPOU.this.lyArticuloSP.setVisibility(8);
                rc7O18ZPOU.this.lyIncisoSP.setVisibility(8);
                rc7O18ZPOU.this.isEdit = true;
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
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                rc7O18ZPOU.this.datePicker = new DatePickerDialog(rc7O18ZPOU.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.2.1
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
                        rc7O18ZPOU.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        rc7O18ZPOU.this.fechaMulta = dia + "/" + mes + "/" + year2;
                    }
                }, year, month, day);
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                rc7O18ZPOU.this.datePicker.getDatePicker().setMaxDate(now);
                rc7O18ZPOU.this.datePicker.show();
            }
        });
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btn_aceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                rc7O18ZPOU.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU$12, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass12 {
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

    private void enviarUSSD() {
        String idMulta = this.txMulta.getText().toString().trim();
        String provinciaCod = this.provincia.getCod_provincia();
        String municipioCod = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
        String cadena = idMulta + "*0000*" + this.articuloUSSD + "*" + this.incisoUSSD + "*" + municipioCod + "*" + provinciaCod + "*1*" + this.fechaMulta + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String msg = "Confirme que desea pagar el siguiente identificador de multa de tránsito: ID de Multa: " + idMulta + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "97", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean validateMulta() {
        if (this.txMulta.getText().toString().trim().isEmpty()) {
            this.lyMulta.setError(this.context.getString(cu.etecsa.cubacel.tr.tm.R.string.hint_campo_vacio));
            requestFocus(this.txMulta);
            return false;
        }
        if (!this.isConfirmMulta && !this.txMulta.getText().toString().matches("([a-zA-Z]+[1-9]+)+")) {
            showSugerencia();
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

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.9
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(rc7O18ZPOU.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.9.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private boolean showSugerencia() {
        if (!this.isConfirmMulta) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Sugerencia");
            builder.setMessage(this.context.getString(cu.etecsa.cubacel.tr.tm.R.string.tx_sugerencia_formato_multa));
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    rc7O18ZPOU rc7o18zpou = rc7O18ZPOU.this;
                    rc7o18zpou.isConfirmMulta = true;
                    rc7o18zpou.submitForm();
                }
            });
            builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            return true;
        }
        return false;
    }
}
