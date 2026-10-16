package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CiudadesPatrimoniales;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ReservasOFA;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dWLcK5oQoS extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    public CheckBox checkBoxSendSaldo;
    public CiudadesPatrimoniales ciudadPatrimonial;
    public ArrayAdapter<CiudadesPatrimoniales> ciudadesPatrimonialesArrayAdapter;
    public List<CiudadesPatrimoniales> ciudadesPatrimonialesList;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    private int enviarSaldo;
    public DatePickerDialog fIniciodatePicker;
    public String fechaInicio;
    public String hora;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyCI;
    private TextInputLayout lyCantidad;
    private TextInputLayout lyCiudadPatrimonial;
    private TextInputLayout lyFecha;
    private TextInputLayout lyMoneda;
    private TextInputLayout lyMonto;
    private TextInputLayout lyPhoneConfirm;
    private TextInputLayout lyReservas;
    private TextInputLayout lyTipoCliente;
    public pAzq93vIl3 manager;
    public ConstraintLayout modalConfirmarPago;
    public String moneda;
    public ReservasOFA reservasOFA;
    public ArrayAdapter<ReservasOFA> reservasOFAArrayAdapter;
    public List<ReservasOFA> reservasOFAList;
    public View rootView;
    private jN13TOyLMX spBolsas;
    private jN13TOyLMX spCiudadPatrimonial;
    private jN13TOyLMX spReservas;
    private jN13TOyLMX spTipoCliente;
    private AutoCompleteTextView txCI;
    private AutoCompleteTextView txCantidad;
    private TextView txContacto;
    private TextInputEditText txFecha;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txPhoneConfirm;
    public boolean isEnviarAuxDat = false;
    private int tipoBolsa = 0;
    private int tipoCliente = 0;
    private String importe = "0";
    private String importeTotal = "0";
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.5
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || dWLcK5oQoS.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    dWLcK5oQoS.this.busk_contactos(v);
                } else {
                    dWLcK5oQoS.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickCiudadPatrimonial = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dWLcK5oQoS dwlck5oqos = dWLcK5oQoS.this;
            dwlck5oqos.ciudadPatrimonial = dwlck5oqos.ciudadesPatrimonialesArrayAdapter.getItem(position);
            dWLcK5oQoS dwlck5oqos2 = dWLcK5oQoS.this;
            dwlck5oqos2.loadReservaOFA(dwlck5oqos2.ciudadPatrimonial.getCode());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickTipoCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dWLcK5oQoS.this.tipoCliente = position + 1;
            dWLcK5oQoS.this.txCantidad.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.txMonto.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.txMonedaImporte.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS dwlck5oqos = dWLcK5oQoS.this;
            if (dwlck5oqos.reservasOFA != null) {
                if (dwlck5oqos.tipoCliente == 1) {
                    dWLcK5oQoS dwlck5oqos2 = dWLcK5oQoS.this;
                    dwlck5oqos2.moneda = dwlck5oqos2.reservasOFA.getMonedaNac();
                    dWLcK5oQoS dwlck5oqos3 = dWLcK5oQoS.this;
                    dwlck5oqos3.importe = String.valueOf(Float.parseFloat(dwlck5oqos3.reservasOFA.getPrecioNac()));
                    return;
                }
                dWLcK5oQoS dwlck5oqos4 = dWLcK5oQoS.this;
                dwlck5oqos4.moneda = dwlck5oqos4.reservasOFA.getMonedaExt();
                dWLcK5oQoS dwlck5oqos5 = dWLcK5oQoS.this;
                dwlck5oqos5.importe = String.valueOf(Float.parseFloat(dwlck5oqos5.reservasOFA.getPrecioExt()));
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickReservas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dWLcK5oQoS dwlck5oqos = dWLcK5oQoS.this;
            dwlck5oqos.reservasOFA = dwlck5oqos.reservasOFAArrayAdapter.getItem(position);
            dWLcK5oQoS.this.txFecha.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.spTipoCliente.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.txCantidad.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.txMonto.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.txMonedaImporte.setText(BuildConfig.FLAVOR);
            dWLcK5oQoS.this.importe = "0";
            if (dWLcK5oQoS.this.spReservas.getText().toString().trim().equals("HabanaBusTour-T1 Ciudad") || dWLcK5oQoS.this.spReservas.getText().toString().trim().equals("HabanaBusTour-T3 Playas") || dWLcK5oQoS.this.spReservas.getText().toString().trim().equals("Shuttle Aeropuerto Habana")) {
                dWLcK5oQoS.this.fechaConfig(1);
            } else {
                dWLcK5oQoS.this.fechaConfig(0);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.9
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dWLcK5oQoS.this.tipoBolsa = position + 1;
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.10
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    dWLcK5oQoS.this.modalConfirmarPago.setVisibility(0);
                    dWLcK5oQoS.this.isEnviarAuxDat = true;
                } else {
                    dWLcK5oQoS.this.modalConfirmarPago.setVisibility(8);
                    dWLcK5oQoS.this.isEnviarAuxDat = false;
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
        this.rootView = inflater.inflate(R.layout.muf9vpjhffgpj, container, false);
        this.context = container.getContext();
        this.jsonFilesManager = new V9s8rJIDplX();
        this.manager = new pAzq93vIl3(this.context, this);
        this.lyCiudadPatrimonial = (TextInputLayout) this.rootView.findViewById(R.id.lyCiudadPatrimonial);
        this.lyTipoCliente = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoCliente);
        this.lyReservas = (TextInputLayout) this.rootView.findViewById(R.id.lyReservas);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.lyFecha = (TextInputLayout) this.rootView.findViewById(R.id.lyFecha);
        this.lyCantidad = (TextInputLayout) this.rootView.findViewById(R.id.lyCantidad);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.lyMoneda = (TextInputLayout) this.rootView.findViewById(R.id.lyMoneda);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.txCI = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.txFecha = (TextInputEditText) this.rootView.findViewById(R.id.txFecha);
        this.txCantidad = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCantidad);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.chConfirmPhone = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.checkBoxSendSaldo = (CheckBox) this.rootView.findViewById(R.id.checkBoxSendSaldo);
        this.txCantidad.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    if (Float.parseFloat(dWLcK5oQoS.this.importe) <= 0.0f || dWLcK5oQoS.this.txCantidad.getText().toString().equals(BuildConfig.FLAVOR) || Float.parseFloat(dWLcK5oQoS.this.txCantidad.getText().toString()) <= 0.0f) {
                        dWLcK5oQoS.this.txMonto.setText(R.string.hint_importe);
                        dWLcK5oQoS.this.txMonedaImporte.setText(R.string.hint_xmoneda);
                        return;
                    }
                    NumberFormat nf = new DecimalFormat("##.###");
                    String monto = BuildConfig.FLAVOR;
                    try {
                        monto = nf.format(Double.parseDouble(dWLcK5oQoS.this.importe));
                    } catch (Exception e) {
                    }
                    if (!monto.equals(BuildConfig.FLAVOR)) {
                        dWLcK5oQoS.this.txMonto.setText(String.valueOf(Integer.parseInt(monto) * Integer.parseInt(dWLcK5oQoS.this.txCantidad.getText().toString())));
                    } else {
                        dWLcK5oQoS.this.txMonto.setText(String.valueOf(Float.parseFloat(dWLcK5oQoS.this.importe) * Integer.parseInt(dWLcK5oQoS.this.txCantidad.getText().toString())));
                    }
                    dWLcK5oQoS.this.txMonedaImporte.setText(dWLcK5oQoS.this.moneda);
                } catch (Exception e2) {
                }
            }
        });
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.spCiudadPatrimonial = (jN13TOyLMX) this.rootView.findViewById(R.id.spCiudadPatrimonial);
        this.spReservas = (jN13TOyLMX) this.rootView.findViewById(R.id.spReservas);
        this.spTipoCliente = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoCliente);
        ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> adapterspTipoCliente = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cliente, android.R.layout.simple_list_item_1);
        adapterspTipoCliente.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTipoCliente.setAdapter(adapterspTipoCliente);
        this.spTipoCliente.setOnItemClickListener(this.spClickTipoCliente);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dWLcK5oQoS.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dWLcK5oQoS.this.mensajeAyuda("Ayuda", "La opción OFA Ciudades Patrimoniales del Monedero MiTransfer de Transfermóvil, facilita el pago electrónico de entradas y reservas a las atracciones recomendadas para visitar en las ciudades patrimoniales cubanas. Conoce más en https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales");
            }
        });
        loadCiudadesPatrimoniales();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        this.enviarSaldo = 0;
        if (!validateSpCiudadPatrimonial() || !validateSpTipoCliente() || !validateSpReservas() || !validateCI() || !validateFecha() || !validateCantidad() || !validateCell() || !validateSpBolsa()) {
            return;
        }
        if (this.checkBoxSendSaldo.isChecked()) {
            this.enviarSaldo = 1;
        }
        this.tipoBolsa = 2;
        String cellConfirm = "0";
        this.hora = "0";
        if (this.isEnviarAuxDat) {
            cellConfirm = this.txPhoneConfirm.getText().toString();
        }
        this.importeTotal = String.valueOf(Float.parseFloat(this.importe) * Float.parseFloat(this.txCantidad.getText().toString()));
        String cadena = this.txCI.getText().toString() + "*" + this.reservasOFA.getCode() + "*" + this.tipoCliente + "*" + this.txCantidad.getText().toString() + "*" + this.fechaInicio + "*" + this.hora + "*" + this.importeTotal + "*" + this.moneda + "*" + cellConfirm + "*" + this.enviarSaldo + "*" + this.tipoBolsa;
        String msg = "Desea realizar la reserva: " + this.reservasOFA.getNombre() + " el día " + this.fechaInicio + " con un valor de " + this.importeTotal + " " + this.moneda + ".";
        if (Float.parseFloat(this.txCantidad.getText().toString().trim()) > 1.0f) {
            msg = msg + " El precio de cada entrada es de " + this.importe + " " + this.moneda;
        }
        String msg2 = msg + "\nLas visitas y recorridos que comparte esta opción, están sujetas a la aceptación de los siguientes términos y condiciones. https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales";
        SpannableString spannableString = new SpannableString(msg2);
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                dWLcK5oQoS.this.openWebPage("https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales");
            }
        };
        spannableString.setSpan(clickableSpan, msg2.indexOf("https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales"), msg2.length(), 0);
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "8", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg2, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBackHttp(this.context, "8", cadena, spannableString, group, getFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebPage(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        startActivity(intent);
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

    public boolean validateSpCiudadPatrimonial() {
        if (this.spCiudadPatrimonial.getText().toString().trim().isEmpty()) {
            this.lyCiudadPatrimonial.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spCiudadPatrimonial);
            return false;
        }
        this.lyCiudadPatrimonial.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpTipoCliente() {
        if (this.spTipoCliente.getText().toString().trim().isEmpty()) {
            this.lyTipoCliente.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spTipoCliente);
            return false;
        }
        this.lyTipoCliente.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpReservas() {
        if (this.spReservas.getText().toString().trim().isEmpty()) {
            this.lyReservas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spReservas);
            return false;
        }
        this.lyReservas.setErrorEnabled(false);
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

    private boolean validateFecha() {
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFecha);
            return false;
        }
        this.lyFecha.setErrorEnabled(false);
        return true;
    }

    private boolean validateCantidad() {
        if (this.txCantidad.getText().toString().trim().isEmpty()) {
            this.lyCantidad.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txCantidad);
            return false;
        }
        if (Float.parseFloat(this.txCantidad.getText().toString().trim()) <= 0.0f) {
            this.lyCantidad.setError(this.context.getString(R.string.err_mayor_cero));
            requestFocus(this.txCantidad);
            return false;
        }
        this.lyCantidad.setErrorEnabled(false);
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

    private boolean loadCiudadesPatrimoniales() {
        try {
            List<CiudadesPatrimoniales> list = this.jsonFilesManager.loadCiudadPatrimonial(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.ciudadesPatrimonialesList = list;
            this.ciudadesPatrimonialesArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (CiudadesPatrimoniales uyh0pxs9m37in : list) {
                this.ciudadesPatrimonialesArrayAdapter.add(uyh0pxs9m37in);
            }
            this.ciudadesPatrimonialesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spCiudadPatrimonial.setAdapter(this.ciudadesPatrimonialesArrayAdapter);
            this.spCiudadPatrimonial.setOnItemClickListener(this.spClickCiudadPatrimonial);
            this.ciudadesPatrimonialesArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadReservaOFA(String codCiudad) {
        try {
            this.spReservas.setText(BuildConfig.FLAVOR);
            this.txFecha.setText(BuildConfig.FLAVOR);
            this.spTipoCliente.setText(BuildConfig.FLAVOR);
            this.txCantidad.setText(BuildConfig.FLAVOR);
            this.txMonto.setText(BuildConfig.FLAVOR);
            this.txMonedaImporte.setText(BuildConfig.FLAVOR);
            this.importe = "0";
            List<ReservasOFA> list = this.jsonFilesManager.getReservasOFA(codCiudad, this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.reservasOFAList = list;
            this.reservasOFAArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (ReservasOFA uyh0pxs9m37in : list) {
                this.reservasOFAArrayAdapter.add(uyh0pxs9m37in);
            }
            this.reservasOFAArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spReservas.setAdapter(this.reservasOFAArrayAdapter);
            this.spReservas.setOnItemClickListener(this.spClickReservas);
            this.reservasOFAArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fechaConfig(int sum) {
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                dWLcK5oQoS.this.fIniciodatePicker = new DatePickerDialog(dWLcK5oQoS.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.11.1
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
                        dWLcK5oQoS.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        dWLcK5oQoS.this.fechaInicio = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, 6);
                long limit = fechaTope.getTimeInMillis();
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                dWLcK5oQoS.this.fIniciodatePicker.getDatePicker().setMinDate(now);
                dWLcK5oQoS.this.fIniciodatePicker.getDatePicker().setMaxDate(limit);
                dWLcK5oQoS.this.fIniciodatePicker.show();
            }
        });
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.12
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                dWLcK5oQoS.this.openWebPage("https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales");
            }
        };
        spannableString.setSpan(clickableSpan, mensaje.indexOf("https://pamarillas.cu/micrositio/ofa-ciudades-patrimoniales"), mensaje.length(), 0);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.13
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(dWLcK5oQoS.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dWLcK5oQoS.13.1
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

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
