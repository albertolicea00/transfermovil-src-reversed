package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.whiteelephant.monthpicker.MonthPickerDialog;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Empresa;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Tributo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UaLAvTSm1e;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ROgpLrCtHa extends Agg55uYctq {
    public AccessibilityManager accessibilityManager;
    public R1sDOSqZ2z agencia;
    public String anno;
    public ImageButton btSearchAccount;
    public Button btnAceptar;
    public ConstraintLayout controlFechaAccesible;
    public DatePickerDialog datePicker;
    public Empresa empresa;
    public ArrayAdapter<Empresa> empresaArrayAdapter;
    public List<Empresa> empresaList;
    public String fecha;
    public boolean isSelloTimbrado;
    public List<Tributo> lTributos;
    private TextInputLayout lyAnno;
    private TextInputLayout lyDia;
    private TextInputLayout lyEntidad;
    private TextInputLayout lyImporte;
    private TextInputLayout lyMes;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyNIT;
    private TextInputLayout lyPeriodo;
    private TextInputLayout lyProvincia;
    private TextInputLayout lyRC04;
    private TextInputLayout lyTributo;
    public String mes;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public List<String> onatList;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public List<ServicioPublico> servLists;
    public jN13TOyLMX spAnno;
    public jN13TOyLMX spDia;
    private jN13TOyLMX spEntidad;
    public jN13TOyLMX spMes;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    public SpinnerDialog spinnerDialog;
    public SpinnerDialog spinnerRCDialog;
    public y2Cht3lmjg tiposOnat;
    private TextView toolbarTitle;
    public Tributo tributo;
    public ArrayAdapter<Tributo> tributoArrayAdapter;
    public List<Tributo> tributosList;
    private TextInputEditText txImporte;
    private AutoCompleteTextView txNIT;
    private TextInputEditText txPeriodo;
    private AutoCompleteTextView txRC04;
    public EditText txTributo;
    public View zcomponentFechaView;
    public ArrayList<String> items = new ArrayList<>();
    public ArrayList<String> itemsRC = new ArrayList<>();
    public boolean isOpenOnceOne = false;
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.11
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            try {
                ROgpLrCtHa rOgpLrCtHa = ROgpLrCtHa.this;
                rOgpLrCtHa.provincia = rOgpLrCtHa.provinciasArrayAdapter.getItem(position);
                ROgpLrCtHa rOgpLrCtHa2 = ROgpLrCtHa.this;
                rOgpLrCtHa2.municipio = null;
                rOgpLrCtHa2.spMunicipio.setText(BuildConfig.FLAVOR);
                ROgpLrCtHa rOgpLrCtHa3 = ROgpLrCtHa.this;
                rOgpLrCtHa3.loadMunicipio(rOgpLrCtHa3.provincia.getCod_provincia());
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.12
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ROgpLrCtHa rOgpLrCtHa = ROgpLrCtHa.this;
            rOgpLrCtHa.municipio = rOgpLrCtHa.municipioArrayAdapter.getItem(position);
        }
    };
    public jN13TOyLMX.OnItemClickListener spEmpresaOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.13
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ROgpLrCtHa rOgpLrCtHa = ROgpLrCtHa.this;
            rOgpLrCtHa.empresa = rOgpLrCtHa.empresaList.get(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("y2Cht3lmjg")) {
                this.tiposOnat = (y2Cht3lmjg) arg.getSerializable("y2Cht3lmjg");
            }
        }
        if (this.tiposOnat == y2Cht3lmjg.PagoRC05) {
            setHasOptionsMenu(true);
        } else {
            setHasOptionsMenu(false);
        }
    }

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
        this.txTributo = (EditText) this.rootView.findViewById(R.id.txTributo);
        this.lyPeriodo = (TextInputLayout) this.rootView.findViewById(R.id.lyPeriodo);
        this.txPeriodo = (TextInputEditText) this.rootView.findViewById(R.id.txPeriodo);
        this.txImporte = (TextInputEditText) this.rootView.findViewById(R.id.txImporte);
        this.lyImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyImporte);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.spEntidad = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.lyRC04 = (TextInputLayout) this.rootView.findViewById(R.id.lyRC04);
        this.txRC04 = (AutoCompleteTextView) this.rootView.findViewById(R.id.txRC04);
        this.toolbarTitle = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.zcomponentFechaView = this.rootView.findViewById(R.id.zcomponent_fecha);
        this.lyDia = (TextInputLayout) this.rootView.findViewById(R.id.lyDia);
        this.lyMes = (TextInputLayout) this.rootView.findViewById(R.id.lyMes);
        this.lyAnno = (TextInputLayout) this.rootView.findViewById(R.id.lyAnno);
        this.spDia = (jN13TOyLMX) this.rootView.findViewById(R.id.spDia);
        this.spMes = (jN13TOyLMX) this.rootView.findViewById(R.id.spMes);
        this.spAnno = (jN13TOyLMX) this.rootView.findViewById(R.id.spAnno);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            initComponentesCuentas(this.rootView, r1sDOSqZ2z);
        } else {
            Bundle arg = getArguments();
            if (arg != null && arg.containsKey("QRData")) {
                String qrdata = arg.getString("QRData");
                JSONCompleteFields(qrdata);
            }
        }
        if (getArguments() != null) {
            Bundle arg2 = getArguments();
            if (arg2.containsKey("y2Cht3lmjg")) {
                y2Cht3lmjg y2cht3lmjg = (y2Cht3lmjg) arg2.getSerializable("y2Cht3lmjg");
                this.tiposOnat = y2cht3lmjg;
                if (y2cht3lmjg != y2Cht3lmjg.PagoNIT && arg2.containsKey("servicio")) {
                    String servicio = arg2.getString("servicio");
                    this.txNIT.setText(servicio);
                }
            }
        }
        if (this.tiposOnat == y2Cht3lmjg.PagoNIT) {
            this.toolbarTitle.setText(this.context.getString(R.string.tx_onat_nit_ci));
            this.txNIT.setHint(R.string.hint_nit);
            this.lyRC04.setVisibility(8);
            this.lyTributo.setVisibility(0);
            loadProvincias();
            loadTributos();
            loadComponentesAccesibilidad();
            this.txPeriodo.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ROgpLrCtHa.this.initMonthPicker();
                }
            });
        } else {
            this.toolbarTitle.setText(this.context.getString(R.string.tx_onat_nit_rc04));
            this.txNIT.setHint(R.string.hint_rc05);
            loadRC05();
            this.lyMunicipio.setVisibility(8);
            this.lyProvincia.setVisibility(8);
            this.lyPeriodo.setVisibility(8);
            this.zcomponentFechaView.setVisibility(8);
            this.lyRC04.setVisibility(0);
            this.lyTributo.setVisibility(8);
            this.btSearchAccount.setVisibility(0);
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ROgpLrCtHa.this.submitForm();
            }
        });
        this.isSelloTimbrado = false;
        loadEntidades();
        return this.rootView;
    }

    private void loadComponentesAccesibilidad() {
        ArrayAdapter<String> adapterDias = new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_item, UaLAvTSm1e.getIsntance().diasDelMes);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spDia.setAdapter(adapterDias);
        ArrayAdapter<String> adapterMeses = new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_item, UaLAvTSm1e.getIsntance().meses);
        adapterMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMes.setAdapter(adapterMeses);
        this.spMes.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.3
            @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
            public void onItemClick(View view, int position) {
                ROgpLrCtHa.this.mes = UaLAvTSm1e.getIsntance().mesesNumeros[position];
            }
        });
        ArrayAdapter<String> adapterAnnos = new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_item, UaLAvTSm1e.getIsntance().arrayAnios);
        adapterAnnos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spAnno.setAdapter(adapterAnnos);
        this.spAnno.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.4
            @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
            public void onItemClick(View view, int position) {
                ROgpLrCtHa.this.anno = UaLAvTSm1e.getIsntance().arrayAnios[position];
            }
        });
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (accessibilityManager.isTouchExplorationEnabled()) {
            this.zcomponentFechaView.setVisibility(0);
            this.lyPeriodo.setVisibility(8);
        } else {
            this.zcomponentFechaView.setVisibility(8);
            this.lyPeriodo.setVisibility(0);
        }
        if (!this.accessibilityManager.isTouchExplorationEnabled()) {
            this.txTributo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.5
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        ROgpLrCtHa.this.lyTributo.setErrorEnabled(false);
                        ROgpLrCtHa rOgpLrCtHa = ROgpLrCtHa.this;
                        rOgpLrCtHa.isOpenOnceOne = true;
                        rOgpLrCtHa.spinnerDialog.showSpinerDialog();
                        return;
                    }
                    ROgpLrCtHa.this.isOpenOnceOne = false;
                }
            });
            this.txTributo.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (ROgpLrCtHa.this.txTributo.getText().toString().length() > 0 || ROgpLrCtHa.this.isOpenOnceOne) {
                        ROgpLrCtHa.this.lyTributo.setErrorEnabled(false);
                        ROgpLrCtHa.this.spinnerDialog.showSpinerDialog();
                    }
                }
            });
        } else {
            this.txTributo.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ROgpLrCtHa.this.lyTributo.setErrorEnabled(false);
                    ROgpLrCtHa.this.spinnerDialog.showSpinerDialog();
                }
            });
        }
    }

    private void loadRC05() {
        try {
            unYp8VQThY.init(this.context);
            this.servLists = unYp8VQThY.getInstance().getFacturasListsTipoServicio(0);
            this.onatList = new ArrayList();
            for (ServicioPublico wl : this.servLists) {
                this.onatList.add(wl.getValor());
            }
            if (this.onatList.size() > 0) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.onatList);
                this.txNIT.setAdapter(adapter);
                this.txNIT.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        ROgpLrCtHa.this.txNIT.showDropDown();
                    }
                });
            }
            ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
            this.btSearchAccount = imageButton;
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    List<ServicioPublico> list = ROgpLrCtHa.this.servLists;
                    if (list == null || list.size() <= 0) {
                        Toast.makeText(ROgpLrCtHa.this.context, "No hay elementos para mostrar", 0).show();
                    } else {
                        ROgpLrCtHa.this.spinnerDialog.showSpinerDialog();
                    }
                }
            });
            loadSearchSpinner();
        } catch (Exception e) {
        }
    }

    private void loadSearchSpinnerTributos() {
        List<Tributo> allTributosLists = unYp8VQThY.getInstance().getAllTributosLists();
        this.lTributos = allTributosLists;
        if (allTributosLists != null && allTributosLists.size() > 0) {
            List<Tributo> list = this.lTributos;
            this.tributosList = list;
            for (Tributo uyh0pxs9m37in : list) {
                this.items.add(uyh0pxs9m37in.toString());
            }
        }
        SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione el tributo a pagar", 2131820786, "Cerrar");
        this.spinnerDialog = spinnerDialog;
        spinnerDialog.setCancellable(true);
        this.spinnerDialog.setShowKeyboard(false);
        this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.10
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in2, int position) {
                ROgpLrCtHa.this.txTributo.setText(uyh0pxs9m37in2);
                ROgpLrCtHa rOgpLrCtHa = ROgpLrCtHa.this;
                rOgpLrCtHa.tributo = rOgpLrCtHa.lTributos.get(position);
                ROgpLrCtHa rOgpLrCtHa2 = ROgpLrCtHa.this;
                rOgpLrCtHa2.empresa = null;
                if (rOgpLrCtHa2.tributo.getCod_tributo().contains("0730122")) {
                    ROgpLrCtHa rOgpLrCtHa3 = ROgpLrCtHa.this;
                    rOgpLrCtHa3.isSelloTimbrado = true;
                    rOgpLrCtHa3.lyEntidad.setVisibility(0);
                } else {
                    ROgpLrCtHa rOgpLrCtHa4 = ROgpLrCtHa.this;
                    rOgpLrCtHa4.isSelloTimbrado = false;
                    rOgpLrCtHa4.lyEntidad.setVisibility(8);
                }
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String agencyL;
        super.submitForm();
        String formaPago = "0000";
        String dpa = "0000";
        String rc04Tributo = "0000";
        String periodo = "0000";
        String entidad = "0000";
        switch (AnonymousClass18.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[this.tiposOnat.ordinal()]) {
            case 1:
                formaPago = "1";
                if (!validateVectorFiscal()) {
                    return;
                }
                nuevoDatos();
                rc04Tributo = this.txRC04.getText().toString().trim();
                break;
                break;
            case 2:
                formaPago = "2";
                if (!validateNITCI() || !validateProvincia() || !validateMunicipio() || !validateTributo() || !validatePeriodo()) {
                    return;
                }
                dpa = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
                rc04Tributo = this.tributo.getCod_tributo();
                periodo = this.fecha;
                break;
                break;
        }
        if (!validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        if (this.isSelloTimbrado) {
            if (!validateEmpresa()) {
                return;
            }
            entidad = this.empresa.getCode();
            periodo = getFechaSellos();
        }
        String rc05Nit = this.txNIT.getText().toString().trim();
        String importe = this.txImporte.getText().toString().trim();
        String cadena = formaPago + "*" + dpa + "*" + rc05Nit + "*" + rc04Tributo + "*" + periodo + "*" + importe + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        if (this.isSelloTimbrado) {
            cadena = formaPago + "*" + dpa + "*" + rc05Nit + "*" + rc04Tributo + "*" + periodo + "*" + importe + "*" + entidad + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        }
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmOnat);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "43", cadena, "¿ Desea realizar el pago del impuesto ? ", group, getFragmentManager());
            return;
        }
        switch (AnonymousClass18.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
            case 1:
                agencyL = "01";
                break;
            case 2:
                agencyL = "02";
                break;
            case 3:
                agencyL = "03";
                break;
            default:
                agencyL = BuildConfig.FLAVOR;
                break;
        }
        this.manager.principalEnviarUSSD(this.context, "110", "43", agencyL, this.MAX_PARAMETERS_PQUETE, cadena, "¿ Desea realizar el pago del impuesto ? ", group, getFragmentManager());
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa$18, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass18 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg;

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
            int[] iArr2 = new int[y2Cht3lmjg.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg = iArr2;
            try {
                iArr2[y2Cht3lmjg.PagoRC05.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[y2Cht3lmjg.PagoNIT.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
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

    private boolean loadTributos() {
        loadSearchSpinnerTributos();
        return true;
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

    public void initMonthPicker() {
        Calendar today = Calendar.getInstance();
        int annoMenos = today.get(1) - 6;
        int annoMax = today.get(1) + 20;
        MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(this.context, new MonthPickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.14
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnDateSetListener
            public void onDateSet(int selectedMonth, int selectedYear) {
                String mes;
                if (String.valueOf(selectedMonth + 1).length() > 1) {
                    mes = String.valueOf(selectedMonth + 1);
                } else {
                    mes = "0" + String.valueOf(selectedMonth + 1);
                }
                ROgpLrCtHa.this.txPeriodo.setText(mes + "/" + selectedYear);
                ROgpLrCtHa.this.fecha = mes + "/" + selectedYear;
            }
        }, today.get(1), today.get(2));
        builder.setActivatedMonth(today.get(2)).setMinYear(annoMenos).setActivatedYear(today.get(1)).setMaxYear(annoMax).setTitle("Seleccione el período").setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.16
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnMonthChangedListener
            public void onMonthChanged(int selectedMonth) {
            }
        }).setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.15
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnYearChangedListener
            public void onYearChanged(int selectedYear) {
            }
        }).build().show();
    }

    public String getFechaSellos() {
        try {
            Calendar today = Calendar.getInstance();
            int mes = today.get(2);
            int anno = today.get(1);
            return mes + "/" + anno;
        } catch (Exception e) {
            return "01/2023";
        }
    }

    private boolean validateVectorFiscal() {
        this.lyNIT.setErrorEnabled(false);
        this.lyRC04.setErrorEnabled(false);
        if (this.txNIT.getText().toString().trim().isEmpty()) {
            this.lyNIT.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.txNIT);
            return false;
        }
        if (this.txNIT.getText().toString().trim().length() != 11 && this.txNIT.getText().toString().trim().length() != 16) {
            this.lyNIT.setError(getString(R.string.tx_alert_longitud_rc05));
            requestFocus(this.txNIT);
            return false;
        }
        if (this.txRC04.getText().toString().trim().length() != 5) {
            this.lyRC04.setError(getString(R.string.tx_alert_longitud_rc04));
            requestFocus(this.txRC04);
            return false;
        }
        this.lyNIT.setErrorEnabled(false);
        this.lyRC04.setErrorEnabled(false);
        return true;
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

    private boolean validateTributo() {
        this.lyTributo.setErrorEnabled(false);
        if (this.txTributo.getText().toString().trim().isEmpty()) {
            this.lyTributo.setError("Seleccione el tributo a pagar");
            requestFocus(this.txTributo);
            return false;
        }
        this.lyTributo.setErrorEnabled(false);
        return true;
    }

    private boolean validatePeriodo() {
        if (this.accessibilityManager.isTouchExplorationEnabled()) {
            this.lyMes.setErrorEnabled(false);
            this.lyAnno.setErrorEnabled(false);
            if (this.spMes.getText().toString().trim().isEmpty()) {
                this.lyMes.setError("Seleccione el mes");
                requestFocus(this.spMes);
                return false;
            }
            if (this.spAnno.getText().toString().trim().isEmpty()) {
                this.lyAnno.setError("Seleccione el mes");
                requestFocus(this.spAnno);
                return false;
            }
            this.fecha = this.mes + "/" + this.anno;
            return true;
        }
        this.lyPeriodo.setErrorEnabled(false);
        if (this.txPeriodo.getText().toString().trim().isEmpty()) {
            this.lyPeriodo.setError("Seleccione el período");
            requestFocus(this.txPeriodo);
            return false;
        }
        if (this.fecha == null) {
            this.lyPeriodo.setError("Seleccione el período");
            requestFocus(this.txPeriodo);
            return false;
        }
        this.lyPeriodo.setErrorEnabled(false);
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

    private void loadSearchSpinner() {
        try {
            List<ServicioPublico> list = this.servLists;
            if (list != null && list.size() > 0) {
                for (ServicioPublico uyh0pxs9m37in : this.servLists) {
                    String facura = uyh0pxs9m37in.getValor();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getValor();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getValor();
                    }
                    this.items.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa.17
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    ServicioPublico cuenta = ROgpLrCtHa.this.servLists.get(position);
                    ROgpLrCtHa.this.txNIT.setText(cuenta.getValor());
                }
            });
        } catch (Exception e2) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem uyh0pxs9m37in = menu.findItem(R.id.qrsgen);
        uyh0pxs9m37in.setVisible(false);
        MenuItem itemCargarLink = menu.findItem(R.id.itemCargarLink);
        itemCargarLink.setVisible(false);
        MenuItem itemShare = menu.findItem(R.id.qrshare);
        itemShare.setVisible(false);
        MenuItem itemScan = menu.findItem(R.id.qrscan);
        itemScan.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Pago_ONAT);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
        arg.putSerializable("y2Cht3lmjg", this.tiposOnat);
        switch (uyh0pxs9m37in.getItemId()) {
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                    return true;
                }
                OJ3XxacXOT qr = new OJ3XxacXOT();
                qr.setArguments(arg);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    private void JSONCompleteFields(String qrdata) {
        if (isJSONValid(qrdata)) {
            try {
                JSONObject jsonObj = new JSONObject(qrdata);
                if (jsonObj.has("RC05")) {
                    String RC05 = String.valueOf(jsonObj.get("RC05"));
                    this.txNIT.setText(RC05);
                }
                if (jsonObj.has("importe")) {
                    double importe = Double.parseDouble(String.valueOf(jsonObj.get("importe")));
                    this.txImporte.setText(String.valueOf(importe));
                }
                if (jsonObj.has("RC04A")) {
                    String RC04 = String.valueOf(jsonObj.get("RC04A"));
                    this.txRC04.setText(RC04);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(this.context, "ERROR no es posible leer el Código QR.", 1);
            }
        }
    }

    public boolean isJSONValid(String jpo48jtycgtsp) {
        try {
            new JSONObject(jpo48jtycgtsp);
            return true;
        } catch (JSONException e) {
            try {
                new JSONArray(jpo48jtycgtsp);
                return true;
            } catch (JSONException e2) {
                return false;
            }
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
