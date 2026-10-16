package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioSucursal;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XnVSHGPTkK extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public static List<ServicioSucursal> serviciosMiTurnoList = new ArrayList();
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyCI;
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
    public View rootView;
    public ArrayAdapter<ServicioSucursal> serviciosArrayAdapter;
    private jN13TOyLMX spBolsas;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private jN13TOyLMX spSucursal;
    private jN13TOyLMX spTipoServicioBanco;
    public SucursalCadeca sucursal;
    public List<SucursalCadeca> sucursalTicketList;
    private AutoCompleteTextView txCI;
    private TextView txContacto;
    private AutoCompleteTextView txPhoneConfirm;
    public boolean isEnviarAuxDat = false;
    private int tipoBolsa = 0;
    private int entidad = 0;
    private String agencyId = "4";
    private String qrdata = BuildConfig.FLAVOR;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || XnVSHGPTkK.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    XnVSHGPTkK.this.busk_contactos(v);
                } else {
                    XnVSHGPTkK.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnVSHGPTkK.this.tipoBolsa = position + 1;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickEntidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnVSHGPTkK.this.entidad = position + 1;
            XnVSHGPTkK.this.spProvincia.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK.this.spMunicipio.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK.this.spSucursal.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK.this.spTipoServicioBanco.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK.this.spTipoServicioBanco.setAdapter(null);
            XnVSHGPTkK.this.lyMunicipio.setVisibility(8);
            if (position > 0) {
                XnVSHGPTkK.this.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                XnVSHGPTkK.this.txCI.setHint(R.string.hint_ci_pasaporte);
            }
            XnVSHGPTkK.this.loadProvincias();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnVSHGPTkK xnVSHGPTkK = XnVSHGPTkK.this;
            xnVSHGPTkK.sucursal = xnVSHGPTkK.reservasTicketArrayAdapter.getItem(position);
            XnVSHGPTkK xnVSHGPTkK2 = XnVSHGPTkK.this;
            if (xnVSHGPTkK2.sucursal == null || xnVSHGPTkK2.entidad < 4) {
                if (XnVSHGPTkK.this.spTipoServicioBanco != null) {
                    XnVSHGPTkK.this.spTipoServicioBanco.setAdapter(null);
                    XnVSHGPTkK.this.spTipoServicioBanco.setText(BuildConfig.FLAVOR);
                    return;
                }
                return;
            }
            String codDpaSucursal = XnVSHGPTkK.this.sucursal.getDpa();
            XnVSHGPTkK xnVSHGPTkK3 = XnVSHGPTkK.this;
            xnVSHGPTkK3.jsonFilesManager.loadAllServiciosSucursal(xnVSHGPTkK3.context);
            XnVSHGPTkK xnVSHGPTkK4 = XnVSHGPTkK.this;
            XnVSHGPTkK.serviciosMiTurnoList = xnVSHGPTkK4.jsonFilesManager.getServiciosBancosDPA(codDpaSucursal, xnVSHGPTkK4.context);
            XnVSHGPTkK.this.serviciosArrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_dropdown_item_1line);
            for (ServicioSucursal uyh0pxs9m37in : XnVSHGPTkK.serviciosMiTurnoList) {
                XnVSHGPTkK.this.serviciosArrayAdapter.add(uyh0pxs9m37in);
            }
            XnVSHGPTkK.this.serviciosArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            XnVSHGPTkK.this.spTipoServicioBanco.setAdapter(XnVSHGPTkK.this.serviciosArrayAdapter);
            XnVSHGPTkK.this.spTipoServicioBanco.setOnItemClickListener(XnVSHGPTkK.this.spClickServicio);
            XnVSHGPTkK.this.serviciosArrayAdapter.notifyDataSetChanged();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ServicioSucursal servicioSeleccionado;
            ArrayAdapter<ServicioSucursal> arrayAdapter = XnVSHGPTkK.this.serviciosArrayAdapter;
            if (arrayAdapter != null && position >= 0 && (servicioSeleccionado = arrayAdapter.getItem(position)) != null) {
                XnVSHGPTkK.this.entidad = Integer.parseInt(servicioSeleccionado.getCodServicio());
            }
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.8
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    XnVSHGPTkK.this.modalConfirmarPago.setVisibility(0);
                    XnVSHGPTkK.this.isEnviarAuxDat = true;
                } else {
                    XnVSHGPTkK.this.modalConfirmarPago.setVisibility(8);
                    XnVSHGPTkK.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.10
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnVSHGPTkK xnVSHGPTkK = XnVSHGPTkK.this;
            xnVSHGPTkK.provincia = xnVSHGPTkK.provinciasArrayAdapter.getItem(position);
            if (XnVSHGPTkK.this.entidad != 3 || (!XnVSHGPTkK.this.provincia.getCod_provincia().equals("34") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("21") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("30") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("31"))) {
                XnVSHGPTkK.this.lyMunicipio.setVisibility(8);
                XnVSHGPTkK.this.spMunicipio.setHint(R.string.hint_municipio);
                XnVSHGPTkK.this.jsonFilesManager = new V9s8rJIDplX();
                if (XnVSHGPTkK.this.entidad != 1) {
                    if (XnVSHGPTkK.this.entidad != 2) {
                        if (XnVSHGPTkK.this.entidad >= 4) {
                            XnVSHGPTkK xnVSHGPTkK2 = XnVSHGPTkK.this;
                            xnVSHGPTkK2.jsonFilesManager.loadSucursalServiciosbancos(xnVSHGPTkK2.context);
                        } else {
                            XnVSHGPTkK xnVSHGPTkK3 = XnVSHGPTkK.this;
                            xnVSHGPTkK3.jsonFilesManager.loadSucursalGasBalita(xnVSHGPTkK3.context);
                        }
                    } else {
                        XnVSHGPTkK xnVSHGPTkK4 = XnVSHGPTkK.this;
                        xnVSHGPTkK4.jsonFilesManager.loadSucursalGas(xnVSHGPTkK4.context);
                    }
                } else {
                    XnVSHGPTkK xnVSHGPTkK5 = XnVSHGPTkK.this;
                    xnVSHGPTkK5.jsonFilesManager.loadSucursalCadeca(xnVSHGPTkK5.context);
                }
                XnVSHGPTkK.this.spSucursal.setText(BuildConfig.FLAVOR);
                if (XnVSHGPTkK.this.entidad != 3 || (!XnVSHGPTkK.this.provincia.getCod_provincia().equals("34") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("34") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("34") && !XnVSHGPTkK.this.provincia.getCod_provincia().equals("31"))) {
                    XnVSHGPTkK.this.loadSucursal();
                    return;
                }
                return;
            }
            XnVSHGPTkK.this.spMunicipio.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK xnVSHGPTkK6 = XnVSHGPTkK.this;
            xnVSHGPTkK6.loadMunicipios(xnVSHGPTkK6.provincia.getCod_provincia());
            XnVSHGPTkK.this.lyMunicipio.setVisibility(0);
            XnVSHGPTkK.this.spMunicipio.setHint(R.string.hint_municipio_casa_comercial);
            XnVSHGPTkK xnVSHGPTkK7 = XnVSHGPTkK.this;
            if (xnVSHGPTkK7.sucursalTicketList != null) {
                xnVSHGPTkK7.reservasTicketArrayAdapter.clear();
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.11
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnVSHGPTkK xnVSHGPTkK = XnVSHGPTkK.this;
            xnVSHGPTkK.municipio = xnVSHGPTkK.municipiosArrayAdapter.getItem(position);
            XnVSHGPTkK.this.jsonFilesManager = new V9s8rJIDplX();
            XnVSHGPTkK xnVSHGPTkK2 = XnVSHGPTkK.this;
            xnVSHGPTkK2.jsonFilesManager.loadSucursalGasBalitaHab(xnVSHGPTkK2.context);
            XnVSHGPTkK.this.spSucursal.setText(BuildConfig.FLAVOR);
            XnVSHGPTkK.this.loadSucursal();
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
        this.rootView = inflater.inflate(R.layout.xjs6nortupjtg, container, false);
        this.context = container.getContext();
        this.jsonFilesManager = new V9s8rJIDplX();
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(R.id.lyProvincia);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(R.id.lySucursal);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.lyTipoServicioBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoServicioBanco);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.txCI = autoCompleteTextView;
        autoCompleteTextView.setHint(R.string.hint_ci_pasaporte);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.chConfirmPhone = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(R.id.spProvincia);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(R.id.spSucursal);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.spTipoServicioBanco = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoServicioBanco);
        ArrayAdapter<CharSequence> adapterEntidad = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket_metro, android.R.layout.simple_list_item_1);
        adapterEntidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
        this.spEntidad = jn13toylmx;
        jn13toylmx.setAdapter(adapterEntidad);
        this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        this.municipioList = new ArrayList();
        ArrayAdapter<Municipio> arrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, this.municipioList);
        this.municipiosArrayAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMunicipio.setAdapter(this.municipiosArrayAdapter);
        this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XnVSHGPTkK.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XnVSHGPTkK.this.mensajeAyuda("Ayuda", "La opción MiTurno permite realizar reservas en diferentes servicios. Será notificado un día antes, vía SMS, para presentarse en la oficina seleccionada. Puede utilizar el lector de QR para escanear su carnet de identidad");
            }
        });
        putData();
        Bundle arg = getArguments();
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
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateSpEntidad() || !validateSpProvincia()) {
            return;
        }
        if ((this.entidad == 3 && this.provincia.getCod_provincia().equals("23") && !validateSpMunicipio()) || !validateSpSucursal()) {
            return;
        }
        if ((this.entidad >= 4 && !validateSpTipoServicioBanco()) || !validateCI() || !validateCell() || !validateSpBolsa()) {
            return;
        }
        this.tipoBolsa = 2;
        String cellConfirm = "0";
        if (this.isEnviarAuxDat && this.txPhoneConfirm.getText().toString().trim().length() > 0) {
            cellConfirm = this.txPhoneConfirm.getText().toString();
        }
        String cadena = this.agencyId + "*" + String.valueOf(this.entidad) + "*" + this.sucursal.getDpa() + "*" + this.txCI.getText().toString() + "*" + cellConfirm + "*" + this.tipoBolsa;
        String msg = "Desea realizar la reserva al beneficiario con CI: " + this.txCI.getText().toString() + "? Esta operación realiza un cobro de comisión a la cuenta seleccionada";
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
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "102", cadena, msg, group, getFragmentManager());
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
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

    public boolean validateSpTipoServicioBanco() {
        if (this.spTipoServicioBanco.getText().toString().trim().isEmpty()) {
            this.lyTipoServicioBanco.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spTipoServicioBanco);
            return false;
        }
        this.lyTipoServicioBanco.setErrorEnabled(false);
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

    private void saveData() {
        U6ucOCBccJ.pmoneda = this.tipoBolsa;
        U6ucOCBccJ.pEntidad = this.spEntidad.getText().toString();
        U6ucOCBccJ.pProvincia = this.provincia;
        U6ucOCBccJ.pMunicipio = this.municipio;
        U6ucOCBccJ.pSucursal = this.spSucursal.getText().toString();
        U6ucOCBccJ.pSucursalCadeca = this.sucursal;
        U6ucOCBccJ.pdata = this.txPhoneConfirm.getText().toString();
        U6ucOCBccJ.pIsEnviar = this.isEnviarAuxDat;
        U6ucOCBccJ.ptipoServicio = this.entidad;
        jN13TOyLMX jn13toylmx = this.spTipoServicioBanco;
        if (jn13toylmx != null) {
            U6ucOCBccJ.ptipoServicioBanco = jn13toylmx.getText().toString();
        }
    }

    private void putData() {
        try {
            if (!U6ucOCBccJ.pEntidad.equals(BuildConfig.FLAVOR)) {
                this.spEntidad.setText(U6ucOCBccJ.pEntidad);
                this.entidad = U6ucOCBccJ.ptipoServicio;
                loadProvincias();
                Provincia provincia = U6ucOCBccJ.pProvincia;
                if (provincia != null) {
                    this.provincia = provincia;
                    this.spProvincia.setText(provincia.toString());
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
            this.chConfirmPhone.setChecked(U6ucOCBccJ.pIsEnviar);
            this.txPhoneConfirm.setText(U6ucOCBccJ.pdata);
            this.isEnviarAuxDat = U6ucOCBccJ.pIsEnviar;
        } catch (Exception e) {
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
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
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
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
        int i = this.entidad;
        if (i == 1) {
            list = this.jsonFilesManager.getSucursalxCadecaDPA(this.provincia.getCod_provincia(), this.context);
        } else if (i == 2) {
            list = this.jsonFilesManager.getSucursalGasDPA(this.provincia.getCod_provincia(), this.context);
        } else if (i == 3 && (this.provincia.getCod_provincia().equals("34") || this.provincia.getCod_provincia().equals("30") || this.provincia.getCod_provincia().equals("21") || this.provincia.getCod_provincia().equals("31"))) {
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
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.9
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(XnVSHGPTkK.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK.9.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
                alertDialog.show();
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                if (textView != null) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        });
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
}
