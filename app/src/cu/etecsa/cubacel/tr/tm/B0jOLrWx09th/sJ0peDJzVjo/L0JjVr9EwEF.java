package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioSucursal;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class L0JjVr9EwEF extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public static List<ServicioSucursal> serviciosMiTurnoList = new ArrayList();
    public AccessibilityManager accessibilityManager;
    public Activity activity;
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public int banco;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    public CheckBox chConfirmPhone;
    private Uri contactUri;
    public String displayContact;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyCI;
    private TextInputLayout lyCuenta;
    private TextInputLayout lyEntidad;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyPhoneConfirm;
    private TextInputLayout lyProvincia;
    private TextInputLayout lySucursal;
    private TextInputLayout lyTipoServicioBanco;
    public ConstraintLayout modalConfirmarPago;
    public Municipio municipio;
    public List<Municipio> municipioList;
    public ArrayAdapter<Municipio> municipiosArrayAdapter;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public ArrayAdapter<SucursalCadeca> reservasTicketArrayAdapter;
    public ArrayAdapter<ServicioSucursal> serviciosArrayAdapter;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private jN13TOyLMX spSucursal;
    private jN13TOyLMX spTipoServicioBanco;
    public SucursalCadeca sucursal;
    public List<SucursalCadeca> sucursalTicketList;
    private AutoCompleteTextView txCI;
    private TextView txContacto;
    private AutoCompleteTextView txCuenta;
    private AutoCompleteTextView txPhoneConfirm;
    public int spinnerEntidadPositionSelect = 0;
    public int spinnerProvinciaPositionSelect = 0;
    public int spinnerSucursalPositionSelect = 0;
    public int spinnerPositionSelect = 0;
    private int entidad = 0;
    public boolean isEnviarAuxDat = false;
    private String qrdata = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            L0JjVr9EwEF l0JjVr9EwEF = L0JjVr9EwEF.this;
            l0JjVr9EwEF.provincia = l0JjVr9EwEF.provinciasArrayAdapter.getItem(position);
            L0JjVr9EwEF.this.jsonFilesManager = new V9s8rJIDplX();
            if (L0JjVr9EwEF.this.entidad != 3 || (!L0JjVr9EwEF.this.provincia.getCod_provincia().equals("34") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("21") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("30") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("31"))) {
                L0JjVr9EwEF.this.lyMunicipio.setVisibility(8);
                L0JjVr9EwEF.this.spMunicipio.setHint(R.string.hint_municipio);
                if (L0JjVr9EwEF.this.entidad != 1) {
                    if (L0JjVr9EwEF.this.entidad != 2) {
                        if (L0JjVr9EwEF.this.entidad >= 4) {
                            L0JjVr9EwEF l0JjVr9EwEF2 = L0JjVr9EwEF.this;
                            l0JjVr9EwEF2.jsonFilesManager.loadSucursalServiciosbancos(l0JjVr9EwEF2.context);
                        } else {
                            L0JjVr9EwEF l0JjVr9EwEF3 = L0JjVr9EwEF.this;
                            l0JjVr9EwEF3.jsonFilesManager.loadSucursalGasBalita(l0JjVr9EwEF3.context);
                        }
                    } else {
                        L0JjVr9EwEF l0JjVr9EwEF4 = L0JjVr9EwEF.this;
                        l0JjVr9EwEF4.jsonFilesManager.loadSucursalGas(l0JjVr9EwEF4.context);
                    }
                } else {
                    L0JjVr9EwEF l0JjVr9EwEF5 = L0JjVr9EwEF.this;
                    l0JjVr9EwEF5.jsonFilesManager.loadSucursalCadeca(l0JjVr9EwEF5.context);
                }
            } else {
                L0JjVr9EwEF.this.spMunicipio.setText(BuildConfig.FLAVOR);
                L0JjVr9EwEF l0JjVr9EwEF6 = L0JjVr9EwEF.this;
                l0JjVr9EwEF6.loadMunicipios(l0JjVr9EwEF6.provincia.getCod_provincia());
                L0JjVr9EwEF.this.lyMunicipio.setVisibility(0);
                L0JjVr9EwEF.this.spMunicipio.setHint(R.string.hint_municipio_casa_comercial);
                L0JjVr9EwEF l0JjVr9EwEF7 = L0JjVr9EwEF.this;
                if (l0JjVr9EwEF7.sucursalTicketList != null) {
                    l0JjVr9EwEF7.reservasTicketArrayAdapter.clear();
                }
            }
            L0JjVr9EwEF.this.spSucursal.setText(BuildConfig.FLAVOR);
            if (L0JjVr9EwEF.this.entidad != 3 || (!L0JjVr9EwEF.this.provincia.getCod_provincia().equals("34") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("34") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("34") && !L0JjVr9EwEF.this.provincia.getCod_provincia().equals("31"))) {
                L0JjVr9EwEF.this.loadSucursal();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickEntidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            L0JjVr9EwEF.this.entidad = position + 1;
            L0JjVr9EwEF.this.spProvincia.setText(BuildConfig.FLAVOR);
            L0JjVr9EwEF.this.spSucursal.setText(BuildConfig.FLAVOR);
            if (L0JjVr9EwEF.this.entidad == 4) {
                L0JjVr9EwEF.this.lyTipoServicioBanco.setVisibility(0);
            } else {
                L0JjVr9EwEF.this.lyTipoServicioBanco.setVisibility(8);
            }
            if (position > 0) {
                L0JjVr9EwEF.this.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                L0JjVr9EwEF.this.txCI.setHint(R.string.hint_ci_pasaporte);
            }
            L0JjVr9EwEF.this.loadProvincias();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            L0JjVr9EwEF l0JjVr9EwEF = L0JjVr9EwEF.this;
            l0JjVr9EwEF.sucursal = l0JjVr9EwEF.reservasTicketArrayAdapter.getItem(position);
            L0JjVr9EwEF l0JjVr9EwEF2 = L0JjVr9EwEF.this;
            if (l0JjVr9EwEF2.sucursal == null || l0JjVr9EwEF2.entidad < 4) {
                if (L0JjVr9EwEF.this.spTipoServicioBanco != null) {
                    L0JjVr9EwEF.this.spTipoServicioBanco.setAdapter(null);
                    L0JjVr9EwEF.this.spTipoServicioBanco.setText(BuildConfig.FLAVOR);
                    return;
                }
                return;
            }
            String codDpaSucursal = L0JjVr9EwEF.this.sucursal.getDpa();
            L0JjVr9EwEF l0JjVr9EwEF3 = L0JjVr9EwEF.this;
            l0JjVr9EwEF3.jsonFilesManager.loadAllServiciosSucursal(l0JjVr9EwEF3.context);
            L0JjVr9EwEF l0JjVr9EwEF4 = L0JjVr9EwEF.this;
            L0JjVr9EwEF.serviciosMiTurnoList = l0JjVr9EwEF4.jsonFilesManager.getServiciosBancosDPA(codDpaSucursal, l0JjVr9EwEF4.context);
            L0JjVr9EwEF.this.serviciosArrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_dropdown_item_1line);
            for (ServicioSucursal uyh0pxs9m37in : L0JjVr9EwEF.serviciosMiTurnoList) {
                L0JjVr9EwEF.this.serviciosArrayAdapter.add(uyh0pxs9m37in);
            }
            L0JjVr9EwEF.this.serviciosArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            L0JjVr9EwEF.this.spTipoServicioBanco.setAdapter(L0JjVr9EwEF.this.serviciosArrayAdapter);
            L0JjVr9EwEF.this.spTipoServicioBanco.setOnItemClickListener(L0JjVr9EwEF.this.spClickServicio);
            L0JjVr9EwEF.this.serviciosArrayAdapter.notifyDataSetChanged();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ServicioSucursal servicioSeleccionado;
            ArrayAdapter<ServicioSucursal> arrayAdapter = L0JjVr9EwEF.this.serviciosArrayAdapter;
            if (arrayAdapter != null && position >= 0 && (servicioSeleccionado = arrayAdapter.getItem(position)) != null) {
                L0JjVr9EwEF.this.entidad = Integer.parseInt(servicioSeleccionado.getCodServicio());
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickTipoMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 1:
                    if (L0JjVr9EwEF.this.cargarMisCuentas()) {
                        L0JjVr9EwEF.this.monedaTarjeta = 0;
                        L0JjVr9EwEF.this.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        L0JjVr9EwEF.this.inputLayoutMisCuentas.setVisibility(0);
                        L0JjVr9EwEF.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                    }
                    break;
                case 2:
                    L0JjVr9EwEF.this.monedaTarjeta = 0;
                    L0JjVr9EwEF.this.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    L0JjVr9EwEF.this.inputLayoutMisCuentas.setVisibility(8);
                    L0JjVr9EwEF.this.inputLayoutCuentaWrite.setVisibility(0);
                    L0JjVr9EwEF.this.mcBankArrayAdapter = null;
                    L0JjVr9EwEF.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    L0JjVr9EwEF.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    L0JjVr9EwEF.this.seleccionCuenta = jceCwl8l2R.MONEDA;
                    L0JjVr9EwEF.this.monedaTarjeta = position + 1;
                    L0JjVr9EwEF.this.inputLayoutMisCuentas.setVisibility(8);
                    L0JjVr9EwEF.this.inputLayoutCuentaWrite.setVisibility(8);
                    L0JjVr9EwEF.this.mcBankArrayAdapter = null;
                    L0JjVr9EwEF.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    L0JjVr9EwEF.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(L0JjVr9EwEF.this.context);
            builder.setTitle(L0JjVr9EwEF.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(L0JjVr9EwEF.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.8.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.9
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            L0JjVr9EwEF l0JjVr9EwEF = L0JjVr9EwEF.this;
            l0JjVr9EwEF.municipio = l0JjVr9EwEF.municipiosArrayAdapter.getItem(position);
            L0JjVr9EwEF.this.jsonFilesManager = new V9s8rJIDplX();
            L0JjVr9EwEF l0JjVr9EwEF2 = L0JjVr9EwEF.this;
            l0JjVr9EwEF2.jsonFilesManager.loadSucursalGasBalitaHab(l0JjVr9EwEF2.context);
            L0JjVr9EwEF.this.spSucursal.setText(BuildConfig.FLAVOR);
            L0JjVr9EwEF.this.loadSucursal();
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.10
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    L0JjVr9EwEF.this.modalConfirmarPago.setVisibility(0);
                    L0JjVr9EwEF.this.isEnviarAuxDat = true;
                } else {
                    L0JjVr9EwEF.this.modalConfirmarPago.setVisibility(8);
                    L0JjVr9EwEF.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        this.context = context;
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.rootView = inflater.inflate(R.layout.mg6bylewri5ue, container, false);
        this.manager = new pAzq93vIl3(this.context, this);
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass13.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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
        initComponentesCuentas(this.rootView, this.agencia);
        this.jsonFilesManager = new V9s8rJIDplX();
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_only_cup, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        this.spinnerTipoMoneda.setAdapter(arrayAdapterCreateFromResource);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickTipoMoneda);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(R.id.lyProvincia);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(R.id.lySucursal);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.lyTipoServicioBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoServicioBanco);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.txCI = autoCompleteTextView;
        autoCompleteTextView.setHint(R.string.hint_ci_pasaporte);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.lyCuenta = (TextInputLayout) this.rootView.findViewById(R.id.lyCuenta);
        this.txCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCuenta);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(R.id.spProvincia);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(R.id.spSucursal);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.spTipoServicioBanco = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoServicioBanco);
        if (this.banco == 3) {
            ArrayAdapter<CharSequence> adapterEntidad = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket_metro, android.R.layout.simple_list_item_1);
            adapterEntidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
            this.spEntidad = jn13toylmx;
            jn13toylmx.setAdapter(adapterEntidad);
            this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        } else {
            ArrayAdapter<CharSequence> adapterEntidad2 = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket, android.R.layout.simple_list_item_1);
            adapterEntidad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jN13TOyLMX jn13toylmx2 = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
            this.spEntidad = jn13toylmx2;
            jn13toylmx2.setAdapter(adapterEntidad2);
            this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        }
        this.municipioList = new ArrayList();
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.chConfirmPhone = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                L0JjVr9EwEF.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                L0JjVr9EwEF.this.mensajeAyuda("Ayuda", "La opción MiTurno permite realizar reservas en diferentes servicios. Será notificado un día antes, vía SMS, para presentarse en la oficina seleccionada. Puede utilizar el lector de QR para escanear su carnet de identidad");
            }
        });
        putData();
        if (arg != null && arg.containsKey("QRData")) {
            String string = arg.getString("QRData");
            this.qrdata = string;
            try {
                String ci = string.split("CI:")[1].split("FV")[0].trim();
                this.txCI.setText(ci);
            } catch (Exception e) {
                this.txCI.setText(BuildConfig.FLAVOR);
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnBskContacto = imageButton;
        imageButton.setImageResource(R.drawable.ico_contacts);
        this.btnBskContacto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || L0JjVr9EwEF.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    L0JjVr9EwEF.this.busk_contactos(v);
                } else {
                    L0JjVr9EwEF.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        return this.rootView;
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
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ReservasTicket);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
        saveData();
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

    private void saveData() {
        String cuenta = BuildConfig.FLAVOR;
        U6ucOCBccJ.pmoneda = this.monedaTarjeta;
        U6ucOCBccJ.pEntidad = this.spEntidad.getText().toString();
        U6ucOCBccJ.pProvincia = this.provincia;
        U6ucOCBccJ.pSucursal = this.spSucursal.getText().toString();
        U6ucOCBccJ.pSucursalCadeca = this.sucursal;
        U6ucOCBccJ.ptipoServicio = this.entidad;
        U6ucOCBccJ.pdata = this.txPhoneConfirm.getText().toString();
        U6ucOCBccJ.pIsEnviar = this.isEnviarAuxDat;
        U6ucOCBccJ.pseleccionCuenta = this.seleccionCuenta;
        jN13TOyLMX jn13toylmx = this.spTipoServicioBanco;
        if (jn13toylmx != null) {
            U6ucOCBccJ.ptipoServicioBanco = jn13toylmx.getText().toString();
        }
        switch (AnonymousClass13.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[this.seleccionCuenta.ordinal()]) {
            case 1:
                if (validateCuentaSpOrigen()) {
                    cuenta = this.miCuentaSeleccion;
                    U6ucOCBccJ.pTextoSpMisCuentas = this.spinnerMisCuentas.getText().toString();
                }
                break;
            case 2:
                cuenta = this.inputCuentaWrite.getText().toString().trim();
                if (this.cuentaOrigen.contains("-")) {
                    cuenta = this.cuentaOrigen.replace("-", BuildConfig.FLAVOR);
                }
                break;
        }
        U6ucOCBccJ.pcuenta = cuenta;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF$13, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass13 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R;

        static {
            int[] iArr = new int[jceCwl8l2R.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R = iArr;
            try {
                iArr[jceCwl8l2R.MIS_CUENTAS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jceCwl8l2R.NUEVA_CUENTA.ordinal()] = 2;
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

    private void putData() {
        try {
            this.entidad = U6ucOCBccJ.ptipoServicio;
            if (!U6ucOCBccJ.pEntidad.equals(BuildConfig.FLAVOR)) {
                this.spEntidad.setText(U6ucOCBccJ.pEntidad);
                if (this.entidad >= 4) {
                    this.lyTipoServicioBanco.setVisibility(0);
                } else {
                    this.lyTipoServicioBanco.setVisibility(8);
                }
                loadProvincias();
                Provincia provincia = U6ucOCBccJ.pProvincia;
                if (provincia != null) {
                    this.provincia = provincia;
                    this.spProvincia.setText(provincia.getNombre());
                    loadSucursal();
                    String str = U6ucOCBccJ.pSucursal;
                    if (str != BuildConfig.FLAVOR) {
                        this.spSucursal.setText(str);
                        SucursalCadeca sucursalCadeca = U6ucOCBccJ.pSucursalCadeca;
                        this.sucursal = sucursalCadeca;
                        if (this.entidad >= 4 && sucursalCadeca != null) {
                            String codDpaSucursal = sucursalCadeca.getDpa();
                            this.jsonFilesManager.loadAllServiciosSucursal(this.context);
                            serviciosMiTurnoList = this.jsonFilesManager.getServiciosBancosDPA(codDpaSucursal, this.context);
                            this.serviciosArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
                            for (ServicioSucursal uyh0pxs9m37in : serviciosMiTurnoList) {
                                this.serviciosArrayAdapter.add(uyh0pxs9m37in);
                            }
                            this.serviciosArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            this.spTipoServicioBanco.setAdapter(this.serviciosArrayAdapter);
                            this.spTipoServicioBanco.setOnItemClickListener(this.spClickServicio);
                            this.serviciosArrayAdapter.notifyDataSetChanged();
                            String str2 = U6ucOCBccJ.ptipoServicioBanco;
                            if (str2 != null && !str2.isEmpty()) {
                                this.spTipoServicioBanco.setText(U6ucOCBccJ.ptipoServicioBanco);
                            }
                        }
                    }
                }
            }
            this.monedaTarjeta = U6ucOCBccJ.pmoneda;
            jceCwl8l2R seleccion = U6ucOCBccJ.pseleccionCuenta;
            String str3 = U6ucOCBccJ.pcuenta;
            this.chConfirmPhone.setChecked(U6ucOCBccJ.pIsEnviar);
            this.txPhoneConfirm.setText(U6ucOCBccJ.pdata);
            this.isEnviarAuxDat = U6ucOCBccJ.pIsEnviar;
            int i = this.monedaTarjeta;
            if (i == 1) {
                this.spinnerPositionSelect = 0;
                this.spinnerTipoMoneda.setText("CUP");
            } else if (i == 2) {
                this.spinnerPositionSelect = 1;
                this.spinnerTipoMoneda.setText("CUC");
            } else if (i == 3) {
                this.spinnerPositionSelect = 2;
                this.spinnerTipoMoneda.setText("USD");
            }
            switch (AnonymousClass13.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[seleccion.ordinal()]) {
                case 1:
                    this.monedaTarjeta = 0;
                    this.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                    this.inputLayoutMisCuentas.setVisibility(0);
                    this.inputLayoutCuentaWrite.setVisibility(8);
                    this.miCuentaSeleccion = U6ucOCBccJ.pcuenta;
                    this.spinnerTipoMoneda.setText("-MIS CUENTAS-");
                    break;
                case 2:
                    this.monedaTarjeta = 0;
                    this.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    this.inputLayoutMisCuentas.setVisibility(8);
                    this.inputLayoutCuentaWrite.setVisibility(0);
                    this.mcBankArrayAdapter = null;
                    this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    this.cuentaOrigen = U6ucOCBccJ.pcuenta;
                    this.spinnerTipoMoneda.setText("-INSERTAR CUENTA-");
                    this.inputCuentaWrite.setText(this.cuentaOrigen);
                    break;
                default:
                    this.seleccionCuenta = jceCwl8l2R.MONEDA;
                    this.inputLayoutMisCuentas.setVisibility(8);
                    this.inputLayoutCuentaWrite.setVisibility(8);
                    this.mcBankArrayAdapter = null;
                    this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadProvincias() {
        List<Provincia> list;
        try {
            int i = this.entidad;
            if (i == 1) {
                list = unYp8VQThY.getInstance().getAllProvinciasLists();
            } else if (i == 2) {
                list = this.jsonFilesManager.loadProvinciasMiTurnoGas(this.context);
            } else if (i >= 4) {
                list = this.jsonFilesManager.loadProvinciasMiTurnoServiciosBanco(this.context);
            } else {
                list = this.jsonFilesManager.loadProvinciasMiTurnoGasBalita(this.context);
            }
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.provinciaList = list;
            this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Provincia uyh0pxs9m37in : list) {
                this.provinciasArrayAdapter.add(uyh0pxs9m37in);
            }
            if (this.entidad >= 4) {
                this.lyTipoServicioBanco.setVisibility(0);
            } else {
                this.lyTipoServicioBanco.setVisibility(8);
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
    public boolean loadSucursal() {
        List<SucursalCadeca> list;
        try {
            int i = this.entidad;
            if (i == 1) {
                list = this.jsonFilesManager.getSucursalxCadecaDPA(this.provincia.getCod_provincia(), this.context);
            } else if (i == 2) {
                list = this.jsonFilesManager.getSucursalGasDPA(this.provincia.getCod_provincia(), this.context);
            } else if (i == 3 && (this.provincia.getCod_provincia().equals("34") || this.provincia.getCod_provincia().equals("21") || this.provincia.getCod_provincia().equals("30") || this.provincia.getCod_provincia().equals("31"))) {
                list = this.jsonFilesManager.getSucursalGasBalitaDPAHab(this.provincia.getCod_provincia(), this.municipio.getCod_municipio(), this.context);
            } else if (this.entidad >= 4) {
                list = this.jsonFilesManager.getSucursalBancosDPA(this.provincia.getCod_provincia(), this.context);
            } else {
                list = this.jsonFilesManager.getSucursalGasBalitaDPA(this.provincia.getCod_provincia(), this.context);
            }
            if (list != null && list.size() > 0) {
                this.sucursalTicketList = list;
                this.reservasTicketArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
                for (SucursalCadeca uyh0pxs9m37in : list) {
                    this.reservasTicketArrayAdapter.add(uyh0pxs9m37in);
                }
                this.reservasTicketArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.spSucursal.setAdapter(this.reservasTicketArrayAdapter);
                this.spSucursal.setOnItemClickListener(this.spClickSucursal);
                this.reservasTicketArrayAdapter.notifyDataSetChanged();
                return true;
            }
            this.reservasTicketArrayAdapter.clear();
            this.spSucursal.setAdapter(this.reservasTicketArrayAdapter);
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadMunicipios(String codProvincia) {
        try {
            List<Municipio> list = this.jsonFilesManager.loadMunicipiosLaHabana(this.context, codProvincia);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.municipioList = list;
            this.municipiosArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipiosArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipiosArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spMunicipio.setAdapter(this.municipiosArrayAdapter);
            this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateSpEntidad() || !validateSpProvincia()) {
            return;
        }
        if ((this.entidad == 3 && this.provincia.getCod_provincia().equals("23") && !validateSpMunicipio()) || !validateSpSucursal()) {
            return;
        }
        if ((this.entidad >= 4 && !validateSpTipoServicioBanco()) || !validateCI() || !validateCell() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        try {
            switch (this.monedaTarjeta) {
            }
        } catch (Exception e) {
        }
        String msg = "Desea realizar la reserva al CI: " + this.txCI.getText().toString() + "? Esta operación realiza un cobro de comisión a la cuenta seleccionada";
        String cellConfirm = "0";
        if (this.isEnviarAuxDat && this.txPhoneConfirm.getText().toString().trim().length() > 0) {
            cellConfirm = this.txPhoneConfirm.getText().toString();
        }
        String cadena = String.valueOf(this.banco) + "*" + String.valueOf(this.entidad) + "*" + this.sucursal.getDpa() + "*" + this.txCI.getText().toString() + "*" + cellConfirm + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTicket);
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pEntidad = BuildConfig.FLAVOR;
        U6ucOCBccJ.pProvincia = new Provincia();
        U6ucOCBccJ.pSucursal = BuildConfig.FLAVOR;
        U6ucOCBccJ.pSucursalCadeca = new SucursalCadeca();
        U6ucOCBccJ.ptipoServicio = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        U6ucOCBccJ.pIsEnviar = false;
        U6ucOCBccJ.pTextoSpMisCuentas = BuildConfig.FLAVOR;
        U6ucOCBccJ.pcuenta = BuildConfig.FLAVOR;
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "102", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "102", cadena, msg, group, getFragmentManager());
        }
    }

    public boolean validateSpEntidad() {
        if (this.spEntidad.getText().toString().trim().isEmpty()) {
            this.lyEntidad.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spEntidad);
            return false;
        }
        this.lyEntidad.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpProvincia() {
        if (this.spProvincia.getText().toString().trim().isEmpty()) {
            this.lyProvincia.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spProvincia);
            return false;
        }
        this.lyProvincia.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpMunicipio() {
        if (this.lyMunicipio.getVisibility() == 0) {
            if (this.spMunicipio.getText().toString().trim().isEmpty()) {
                this.lyMunicipio.setError(getString(R.string.err_msg_empty_cuenta));
                requestFocus(this.spMunicipio);
                return false;
            }
            this.lyMunicipio.setErrorEnabled(false);
            return true;
        }
        return true;
    }

    public boolean validateSpSucursal() {
        if (this.spSucursal.getText().toString().trim().isEmpty()) {
            this.lySucursal.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spSucursal);
            return false;
        }
        this.lySucursal.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpTipoServicioBanco() {
        if (this.spTipoServicioBanco.getText().toString().trim().isEmpty()) {
            this.lyTipoServicioBanco.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spTipoServicioBanco);
            return false;
        }
        this.lyTipoServicioBanco.setErrorEnabled(false);
        return true;
    }

    public boolean validateCI() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    private boolean validateCell() {
        this.txPhoneConfirm.getText().toString().trim().length();
        if (this.txPhoneConfirm.getText().toString().trim().length() > 0 && this.txPhoneConfirm.getText().toString().trim().length() != 8) {
            this.lyPhoneConfirm.setError(this.context.getString(R.string.err_msg_len_numero));
            requestFocus(this.txPhoneConfirm);
            return false;
        }
        this.lyPhoneConfirm.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_hint_aviso));
        builder.setMessage(this.context.getString(R.string.err_no_tiene_cuentas));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            Uri data2 = data.getData();
            this.contactUri = data2;
            renderContact(data2);
        }
    }

    private void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri).replace(" ", BuildConfig.FLAVOR).trim();
            if (telf.contains("+")) {
                telf = telf.substring(1);
            }
            if (telf.charAt(0) == '0') {
                telf = telf.substring(1);
            }
            if ((telf.substring(0, 3).toString().contains("535") || telf.substring(0, 3).toString().contains("536")) && telf.length() == 10) {
                telf = telf.substring(2);
            }
            this.txPhoneConfirm.setText(telf);
            String str = this.displayContact;
            if (str != null && str.length() > 0) {
                this.txContacto.setVisibility(0);
                this.txContacto.setText(this.displayContact);
                this.displayContact = BuildConfig.FLAVOR;
                return;
            }
            this.txContacto.setVisibility(8);
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
            this.txContacto.setVisibility(8);
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        this.displayContact = BuildConfig.FLAVOR;
        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
        if (contactCursor.moveToFirst()) {
            id = contactCursor.getString(0);
        }
        contactCursor.close();
        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "display_name"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
        if (phoneCursor.moveToFirst()) {
            phone = phoneCursor.getString(0);
            this.displayContact = phoneCursor.getString(1);
        }
        phoneCursor.close();
        return phone;
    }

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.12
            @Override // java.lang.Runnable
            public void run() {
                new androidx.appcompat.app.AlertDialog.Builder(L0JjVr9EwEF.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF.12.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
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
