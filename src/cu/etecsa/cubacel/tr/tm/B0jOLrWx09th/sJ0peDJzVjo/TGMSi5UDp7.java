package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.DenominacionSello;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Empresa;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TGMSi5UDp7 extends Agg55uYctq {
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public Button btnAceptar;
    private CheckBox chSetImporte;
    public DenominacionSello denominacion;
    public ArrayAdapter<DenominacionSello> denominacionArrayAdapter;
    public List<DenominacionSello> denominacionList;
    public Empresa empresa;
    public ArrayAdapter<Empresa> empresaArrayAdapter;
    public List<Empresa> empresaList;
    public String fecha;
    public boolean isPersonalDenomiacion;
    private TextInputLayout lyDenominacion;
    private TextInputLayout lyEntidad;
    private TextInputLayout lyImporte;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyNIT;
    private TextInputLayout lyPeriodo;
    private TextInputLayout lyProvincia;
    private TextInputLayout lyRC04;
    private TextInputLayout lyTributo;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    private jN13TOyLMX spDenominacion;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private TextView toolbarTitle;
    private TextInputEditText txImporte;
    private AutoCompleteTextView txNIT;
    private TextInputEditText txPeriodo;
    private AutoCompleteTextView txRC04;
    public EditText txTributo;
    public View zcomponentFechaView;
    public String tributo = "0730122";
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            try {
                TGMSi5UDp7 tGMSi5UDp7 = TGMSi5UDp7.this;
                tGMSi5UDp7.provincia = tGMSi5UDp7.provinciasArrayAdapter.getItem(position);
                TGMSi5UDp7 tGMSi5UDp8 = TGMSi5UDp7.this;
                tGMSi5UDp8.municipio = null;
                tGMSi5UDp8.spMunicipio.setText(BuildConfig.FLAVOR);
                TGMSi5UDp7 tGMSi5UDp9 = TGMSi5UDp7.this;
                tGMSi5UDp9.loadMunicipio(tGMSi5UDp9.provincia.getCod_provincia());
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            TGMSi5UDp7 tGMSi5UDp7 = TGMSi5UDp7.this;
            tGMSi5UDp7.municipio = tGMSi5UDp7.municipioArrayAdapter.getItem(position);
        }
    };
    public jN13TOyLMX.OnItemClickListener spEmpresaOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            TGMSi5UDp7 tGMSi5UDp7 = TGMSi5UDp7.this;
            tGMSi5UDp7.empresa = tGMSi5UDp7.empresaList.get(position);
        }
    };
    public jN13TOyLMX.OnItemClickListener spDenominacionOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            TGMSi5UDp7 tGMSi5UDp7 = TGMSi5UDp7.this;
            tGMSi5UDp7.denominacion = tGMSi5UDp7.denominacionList.get(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ealghgrkajdzq, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.lyNIT = (TextInputLayout) this.rootView.findViewById(R.id.lyNIT);
        this.txNIT = (AutoCompleteTextView) this.rootView.findViewById(R.id.txNIT);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.lyTributo = (TextInputLayout) this.rootView.findViewById(R.id.lyTributo);
        this.lyPeriodo = (TextInputLayout) this.rootView.findViewById(R.id.lyPeriodo);
        this.txPeriodo = (TextInputEditText) this.rootView.findViewById(R.id.txPeriodo);
        this.txImporte = (TextInputEditText) this.rootView.findViewById(R.id.txImporte);
        this.lyImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyImporte);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.spEntidad = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
        this.lyDenominacion = (TextInputLayout) this.rootView.findViewById(R.id.lyDenominacion);
        this.spDenominacion = (jN13TOyLMX) this.rootView.findViewById(R.id.spDenominacion);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chSetImporte);
        this.chSetImporte = checkBox;
        checkBox.setVisibility(0);
        this.chSetImporte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TGMSi5UDp7.this.lyDenominacion.setVisibility(8);
                    TGMSi5UDp7.this.lyImporte.setVisibility(0);
                    TGMSi5UDp7.this.spDenominacion.setText(BuildConfig.FLAVOR);
                    TGMSi5UDp7 tGMSi5UDp7 = TGMSi5UDp7.this;
                    tGMSi5UDp7.denominacion = null;
                    tGMSi5UDp7.isPersonalDenomiacion = true;
                    return;
                }
                TGMSi5UDp7.this.lyDenominacion.setVisibility(0);
                TGMSi5UDp7.this.lyImporte.setVisibility(8);
                TGMSi5UDp7 tGMSi5UDp8 = TGMSi5UDp7.this;
                tGMSi5UDp8.isPersonalDenomiacion = false;
                tGMSi5UDp8.txImporte.setText(BuildConfig.FLAVOR);
            }
        });
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.lyRC04 = (TextInputLayout) this.rootView.findViewById(R.id.lyRC04);
        this.txRC04 = (AutoCompleteTextView) this.rootView.findViewById(R.id.txRC04);
        this.txTributo = (EditText) this.rootView.findViewById(R.id.txTributo);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbarTitle = textView;
        textView.setText(R.string.tx_title_sellos_postales);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TGMSi5UDp7.this.submitForm();
            }
        });
        loadProvincias();
        loadEntidades();
        loadDenominacion();
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass7.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.agencyL = "01";
                    break;
                case 2:
                    this.agencyL = "02";
                    break;
                case 3:
                    this.agencyL = "03";
                    break;
            }
            initComponentesCuentas(this.rootView, this.agencia);
        }
        this.lyTributo.setVisibility(8);
        this.lyPeriodo.setVisibility(8);
        this.lyRC04.setVisibility(8);
        this.lyNIT.setHint("Carné de Identidad");
        this.lyEntidad.setVisibility(0);
        InputFilter[] fArray = {new InputFilter.LengthFilter(11)};
        this.txNIT.setFilters(fArray);
        this.lyImporte.setVisibility(8);
        this.lyDenominacion.setVisibility(0);
        View viewFindViewById = this.rootView.findViewById(R.id.zcomponent_fecha);
        this.zcomponentFechaView = viewFindViewById;
        viewFindViewById.setVisibility(8);
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String importe;
        super.submitForm();
        if (!validateNITCI() || !validateProvincia() || !validateMunicipio()) {
            return;
        }
        String dpa = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
        String rc04Tributo = this.tributo;
        String periodo = getFechaSellos();
        if (this.isPersonalDenomiacion) {
            if (!validateMonto()) {
                return;
            }
        } else if (!validateDenominacion()) {
            return;
        }
        if (!validateEmpresa()) {
            return;
        }
        String entidad = this.empresa.getCode();
        if (!validateSelectionAccounts()) {
            return;
        }
        String rc05Nit = this.txNIT.getText().toString().trim();
        if (this.isPersonalDenomiacion) {
            importe = this.txImporte.getText().toString().trim();
        } else {
            importe = this.denominacion.getImporte();
        }
        String cadena = "2*" + dpa + "*" + rc05Nit + "*" + rc04Tributo + "*" + periodo + "*" + importe + "*" + entidad + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmOnat);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "43", cadena, "¿ Desea realizar la compra del sello ? ", group, getFragmentManager());
            return;
        }
        String cadenaPack = "2*" + dpa + "*" + rc04Tributo + "*" + rc05Nit + "*" + periodo + "*" + importe + "*" + entidad + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        this.manager.principalEnviarUSSD(this.context, "110", "43", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadenaPack, "¿ Desea realizar la compra del sello ? ", group, getFragmentManager());
    }

    public String getFechaSellos() {
        try {
            Calendar today = Calendar.getInstance();
            int mes = today.get(2) + 1;
            int anno = today.get(1);
            return mes + "/" + anno;
        } catch (Exception e) {
            return "01/2023";
        }
    }

    private boolean loadProvincias() {
        try {
            List<Provincia> list = unYp8VQThY.getInstance().getAllProvinciasLists();
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.provinciaList = list;
            this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Provincia uyh0pxs9m37in : list) {
                this.provinciasArrayAdapter.add(uyh0pxs9m37in);
            }
            this.provinciasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
            this.municipioArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipioArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipioArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spMunicipio.setAdapter(this.municipioArrayAdapter);
            this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
            this.municipioArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean loadEntidades() {
        this.lyEntidad.setVisibility(8);
        try {
            this.empresaList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<Empresa> list = jsonFilesManager.loadDataEmpresas(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.empresaArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Empresa uyh0pxs9m37in : list) {
                this.empresaArrayAdapter.add(uyh0pxs9m37in);
                this.empresaList.add(uyh0pxs9m37in);
            }
            this.empresaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spEntidad.setAdapter(this.empresaArrayAdapter);
            this.spEntidad.setOnItemClickListener(this.spEmpresaOnClickListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean loadDenominacion() {
        try {
            this.denominacionList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<DenominacionSello> list = jsonFilesManager.loadDataDenominacionSello(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.denominacionArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (DenominacionSello uyh0pxs9m37in : list) {
                this.denominacionArrayAdapter.add(uyh0pxs9m37in);
                this.denominacionList.add(uyh0pxs9m37in);
            }
            this.denominacionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spDenominacion.setAdapter(this.denominacionArrayAdapter);
            this.spDenominacion.setOnItemClickListener(this.spDenominacionOnClickListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateMonto() {
        this.lyImporte.setErrorEnabled(false);
        if (this.txImporte.getText().toString().trim().isEmpty()) {
            this.lyImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txImporte);
            return false;
        }
        if (Float.valueOf(this.txImporte.getText().toString().trim()).floatValue() == 0.0f) {
            this.lyImporte.setError("Indique un monto superior a cero");
            requestFocus(this.txImporte);
            return false;
        }
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        String edit_onat = this.txNIT.getText().toString();
        List<ServicioPublico> c_list = unYp8VQThY.getInstance().getServicioPublicoListsWithValor(edit_onat);
        if (c_list.size() == 0) {
            ServicioPublico s = new ServicioPublico();
            s.setTipo_servicio(0);
            s.setCod_servicio("RC05");
            s.setValor(edit_onat);
            unYp8VQThY.getInstance().addServicioPublico(s);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    private boolean validateNITCI() {
        this.lyNIT.setErrorEnabled(false);
        if (this.txNIT.getText().toString().trim().isEmpty()) {
            this.lyNIT.setError(getString(R.string.err_msg_empty_nit_ci));
            requestFocus(this.txNIT);
            return false;
        }
        if (this.txNIT.getText().toString().trim().length() != 11 && this.txNIT.getText().toString().trim().length() != 16) {
            this.lyNIT.setError("NIT ó Carnet de identidad inválido");
            requestFocus(this.txNIT);
            return false;
        }
        this.lyNIT.setErrorEnabled(false);
        return true;
    }

    private boolean validateProvincia() {
        this.lyProvincia.setErrorEnabled(false);
        if (this.spProvincia.getText().toString().trim().isEmpty()) {
            this.lyProvincia.setError("Seleccione la provincia");
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

    private boolean validateDenominacion() {
        this.lyDenominacion.setErrorEnabled(false);
        if (this.spDenominacion.getText().toString().trim().isEmpty()) {
            this.lyDenominacion.setError("Seleccione un importe");
            requestFocus(this.spDenominacion);
            return false;
        }
        this.lyDenominacion.setErrorEnabled(false);
        return true;
    }

    private boolean validateEmpresa() {
        this.lyEntidad.setErrorEnabled(false);
        if (this.spEntidad.getText().toString().trim().isEmpty()) {
            this.lyEntidad.setError("Seleccione la entidad");
            requestFocus(this.spEntidad);
            return false;
        }
        this.lyEntidad.setErrorEnabled(false);
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
