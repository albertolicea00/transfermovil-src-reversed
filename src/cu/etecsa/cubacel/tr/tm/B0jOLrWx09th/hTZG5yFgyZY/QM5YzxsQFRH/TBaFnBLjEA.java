package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.OfertasBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.As6QBoLoQJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.DHfGEge8yT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TBaFnBLjEA extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public Activity activity;
    public AppCompatImageView btHelp;
    public AppCompatImageView btReload;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    public DatePickerDialog fIniciodatePicker;
    public String fechaInicio;
    public String hora;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyCI;
    private TextInputLayout lyCantidad;
    private TextInputLayout lyFecha;
    private TextInputLayout lyMoneda;
    private TextInputLayout lyMonto;
    private TextInputLayout lyOferta;
    private TextInputLayout lyPhoneConfirm;
    public pAzq93vIl3 manager;
    public ConstraintLayout modalConfirmarPago;
    public String moneda;
    private OfertasBoleto ofertaActual;
    private ArrayAdapter<OfertasBoleto> ofertasArrayAdapter;
    private List<OfertasBoleto> ofertasList;
    public View rootView;
    private jN13TOyLMX spBolsas;
    private jN13TOyLMX spOferta;
    private AutoCompleteTextView txCI;
    private AutoCompleteTextView txCantidad;
    private TextView txContacto;
    private TextInputEditText txFecha;
    private TextView txFechaUpdate;
    private TextView txIntervaloFechas;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txPhoneConfirm;
    private int ofertaActualPosition = 0;
    private double precioUnitario = 0.0d;
    private int tipoBolsa = 0;
    private int tipoCliente = 0;
    private String importe = "0";
    private String importeTotal = "0";
    private String qrCI = BuildConfig.FLAVOR;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || TBaFnBLjEA.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    TBaFnBLjEA.this.busk_contactos(v);
                } else {
                    TBaFnBLjEA.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private AdapterView.OnItemClickListener spClickOfertas = new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int arrayResource;
            try {
                OfertasBoleto ofertaSeleccionada = (OfertasBoleto) parent.getItemAtPosition(position);
                TBaFnBLjEA.this.spBolsas.setText(BuildConfig.FLAVOR);
                TBaFnBLjEA.this.ofertaActualPosition = position;
                TBaFnBLjEA.this.ofertaActual = ofertaSeleccionada;
                TBaFnBLjEA.this.txMonedaImporte.setText(ofertaSeleccionada.getMoneda());
                TBaFnBLjEA.this.spOferta.setText((CharSequence) ofertaSeleccionada.getNombre(), false);
                TBaFnBLjEA.this.moneda = ofertaSeleccionada.getMoneda();
                String intervaloFechas = ofertaSeleccionada.getFechaOferta();
                String intervaloFix = TBaFnBLjEA.this.parseFecha(intervaloFechas);
                if (!intervaloFechas.equals("-")) {
                    TBaFnBLjEA.this.txIntervaloFechas.setText("Disponible: " + intervaloFix);
                    TBaFnBLjEA.this.txIntervaloFechas.setVisibility(0);
                } else {
                    TBaFnBLjEA.this.txIntervaloFechas.setText("Válido hasta agotar existencias");
                    TBaFnBLjEA.this.txIntervaloFechas.setVisibility(0);
                }
                TBaFnBLjEA.this.calcularImporteEnTiempoReal();
                if ("CUP".equals(TBaFnBLjEA.this.moneda)) {
                    arrayResource = R.array.array_bolsa_tipo_solo_cup;
                } else if ("USD".equals(TBaFnBLjEA.this.moneda)) {
                    arrayResource = R.array.array_bolsa_tipo_solo_usd;
                } else {
                    arrayResource = -1;
                }
                if (arrayResource != -1) {
                    ArrayAdapter<CharSequence> adapterTipoBolsa = ArrayAdapter.createFromResource(TBaFnBLjEA.this.context, arrayResource, android.R.layout.simple_list_item_1);
                    adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    TBaFnBLjEA.this.spBolsas.setAdapter(adapterTipoBolsa);
                    return;
                }
                Toast.makeText(TBaFnBLjEA.this.context, "El formato de la moneda de la oferta es incorrecto", 1).show();
            } catch (Exception e) {
                Log.e("spClickOfertas", "Error al seleccionar oferta: " + e.getMessage(), e);
                Toast.makeText(TBaFnBLjEA.this.context, "Error al seleccionar oferta", 0).show();
                TBaFnBLjEA.this.ofertaActual = null;
                TBaFnBLjEA.this.txMonto.setText(String.format(Locale.getDefault(), "%.2f", Double.valueOf(0.0d)));
                TBaFnBLjEA.this.txMonedaImporte.setText(BuildConfig.FLAVOR);
                TBaFnBLjEA.this.txIntervaloFechas.setVisibility(8);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
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
        this.rootView = inflater.inflate(R.layout.cugjf2pjjzriq, container, false);
        this.context = container.getContext();
        this.jsonFilesManager = new V9s8rJIDplX();
        this.manager = new pAzq93vIl3(this.context, this);
        this.lyOferta = (TextInputLayout) this.rootView.findViewById(R.id.lyOferta);
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
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.txFechaUpdate = (TextView) this.rootView.findViewById(R.id.tvFechaUpdate);
        this.txIntervaloFechas = (TextView) this.rootView.findViewById(R.id.txIntervaloFechas);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        this.chConfirmPhone = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btHelp = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btReload = (AppCompatImageView) this.rootView.findViewById(R.id.btReload);
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        this.spOferta = (jN13TOyLMX) this.rootView.findViewById(R.id.spOferta);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(adapterTipoBolsa);
        jN13TOyLMX jn13toylmx = this.spBolsas;
        if (jn13toylmx != null) {
            jn13toylmx.setOnItemClickListener(this.spClickBolsa);
        } else {
            Log.e("TBaFnBLjEA", "spBolsas is null");
        }
        ArrayAdapter<OfertasBoleto> arrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
        this.ofertasArrayAdapter = arrayAdapter;
        this.spOferta.setAdapter(arrayAdapter);
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TBaFnBLjEA.this.submitForm();
            }
        });
        setupCantidadListener();
        this.spOferta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TBaFnBLjEA.this.ofertaActual = (OfertasBoleto) parent.getItemAtPosition(position);
                TBaFnBLjEA.this.calcularImporteEnTiempoReal();
            }
        });
        this.spOferta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        Button btnActualizar = (Button) this.rootView.findViewById(R.id.btnActualizarOfertas);
        btnActualizar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TBaFnBLjEA.this.actualizarOfertas();
            }
        });
        this.btHelp.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.btReload.setOnClickListener(new AnonymousClass4());
        loadFormData();
        loadOfertasFromDatabase();
        fechaConfig(0);
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("QRData")) {
            String string = arg.getString("QRData");
            this.qrCI = string;
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
    public /* synthetic */ void lambda$onCreateView$0(View v) {
        this.spOferta.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View v) {
        mensajeAyuda("Ayuda", "La lupa ejecuta una consulta de ofertas MiBoleto, la cual proporcionará las ofertas disponibles para comprar a través de un SMS. \n\nEl botón de refrescar sirve para actualizar las ofertas en la aplicación una vez recibido el SMS. \n\nConoce más sobre las ofertas en: https://miboleto.mibulevar.com");
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            TBaFnBLjEA.this.getActivity().getWindow().setFlags(16, 16);
            final ProgressDialog progressDialog = new ProgressDialog(TBaFnBLjEA.this.getActivity());
            progressDialog.setMessage("Actualizando ofertas de MiBoleto...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            new DHfGEge8yT(TBaFnBLjEA.this.getActivity().getContentResolver(), new SYLBHJttme() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.4.1
                @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
                public void onSetProgressBarVisibility(int visibility) {
                }

                @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
                public void onOfertasResult(boolean success, int count, String message) {
                    new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ProgressDialog progressDialog2 = progressDialog;
                            if (progressDialog2 != null && progressDialog2.isShowing()) {
                                progressDialog.dismiss();
                            }
                            TBaFnBLjEA.this.getActivity().getWindow().clearFlags(16);
                        }
                    }, 1000L);
                    TBaFnBLjEA.this.loadOfertasFromDatabase();
                }
            }).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateSpCiudadPatrimonial() || !validateCI() || !validateFecha() || !validateCantidad() || !validateCell() || !validateSpBolsa()) {
            return;
        }
        if (this.txMonedaImporte.getText().toString().equals("USD")) {
            this.tipoBolsa = 1;
            this.moneda = "1";
        } else {
            this.tipoBolsa = 2;
            this.moneda = "2";
        }
        String cellConfirm = this.txPhoneConfirm.getText().toString();
        String montoStr = this.txMonto.getText().toString().replace(',', '.');
        this.importeTotal = String.valueOf(Float.parseFloat(montoStr));
        String cadena = this.ofertaActual.getId() + "*" + this.txCI.getText().toString() + "*" + this.txCantidad.getText().toString() + "*" + this.fechaInicio + "*" + this.importeTotal + "*" + this.moneda + "*" + cellConfirm + "*" + this.tipoBolsa;
        String msg = "Desea comprar la oferta: " + ((Object) this.spOferta.getText()) + " el día " + this.fechaInicio + " con un valor de " + this.importeTotal + " " + this.txMonedaImporte.getText().toString() + ". Cantidad de boletos: " + this.txCantidad.getText().toString() + ".";
        if (Float.parseFloat(this.txCantidad.getText().toString().trim()) > 1.0f) {
            msg = msg + " El precio de la oferta por boleto es de " + this.ofertaActual.getPrecio() + " " + this.txMonedaImporte.getText().toString() + ".";
        }
        String msg2 = msg + "\nPara obtener infomación acerca de las atracciones asociadas a la oferta, toque el siguiente enlace: https://miboleto.mibulevar.com";
        SpannableString spannableString = new SpannableString(msg2);
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                TBaFnBLjEA.this.openWebPage("https://miboleto.mibulevar.com");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(-16776961);
                ds.setUnderlineText(true);
            }
        };
        spannableString.setSpan(clickableSpan, msg2.indexOf("https://miboleto.mibulevar.com"), msg2.length(), 0);
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        As6QBoLoQJ.ci = BuildConfig.FLAVOR;
        As6QBoLoQJ.fecha = BuildConfig.FLAVOR;
        As6QBoLoQJ.fechaInicio = BuildConfig.FLAVOR;
        As6QBoLoQJ.cantidad = BuildConfig.FLAVOR;
        As6QBoLoQJ.monto = BuildConfig.FLAVOR;
        As6QBoLoQJ.phone = BuildConfig.FLAVOR;
        As6QBoLoQJ.moneda = BuildConfig.FLAVOR;
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "118", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg2, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBackHttp(this.context, "118", cadena, spannableString, group, getFragmentManager());
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
        if (this.spOferta.getText().toString().trim().isEmpty()) {
            this.lyOferta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spOferta);
            return false;
        }
        this.lyOferta.setErrorEnabled(false);
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
        Date fechaInicioIntervalo;
        Date fechaFinIntervalo;
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFecha);
            return false;
        }
        OfertasBoleto ofertasBoleto = this.ofertaActual;
        if (ofertasBoleto != null && !ofertasBoleto.getFechaOferta().equals("-")) {
            try {
                String fechaSeleccionada = this.fechaInicio.replace("-", "/");
                String fechaOferta = parseFecha(this.ofertaActual.getFechaOferta());
                String[] intervalo = fechaOferta.split("-");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                SimpleDateFormat sdfSel = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                if (intervalo.length > 1) {
                    fechaInicioIntervalo = sdf.parse(intervalo[0].trim());
                    fechaFinIntervalo = sdf.parse(intervalo[1].trim());
                } else {
                    fechaInicioIntervalo = sdf.parse(intervalo[0].trim());
                    fechaFinIntervalo = sdf.parse(intervalo[0].trim());
                }
                Date fechaSel = sdfSel.parse(fechaSeleccionada);
                if (!fechaSel.before(fechaInicioIntervalo) && !fechaSel.after(fechaFinIntervalo)) {
                }
                this.txIntervaloFechas.setVisibility(0);
                this.lyFecha.setError("Seleccione una fecha dentro del intervalo");
                requestFocus(this.txFecha);
                return false;
            } catch (Exception e) {
                Log.e("validateFecha", "Error al validar fechas: " + e.getMessage());
                this.lyFecha.setError("Error al validar fecha");
                return false;
            }
        }
        this.lyFecha.setErrorEnabled(false);
        return true;
    }

    private boolean validateCantidad() {
        String cantidadStr = this.txCantidad.getText().toString().trim();
        int max = this.ofertaActual.getCantPersona();
        if (cantidadStr.isEmpty()) {
            this.lyCantidad.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txCantidad);
            return false;
        }
        try {
            String cantidadNormalizada = cantidadStr.replace(',', '.');
            float cantidad = Float.parseFloat(cantidadNormalizada);
            if (cantidad <= 0.0f) {
                this.lyCantidad.setError(this.context.getString(R.string.err_mayor_cero));
                requestFocus(this.txCantidad);
                return false;
            }
            if (cantidad > max && max > 0) {
                this.lyCantidad.setError(this.context.getString(R.string.err_mayor_cantida_personas) + " " + max);
                requestFocus(this.txCantidad);
                return false;
            }
            this.lyCantidad.setErrorEnabled(false);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateCell() {
        this.txPhoneConfirm.getText().toString().trim().length();
        if (this.txPhoneConfirm.getText().toString().trim().length() > 0 && this.txPhoneConfirm.getText().toString().trim().length() != 8) {
            this.lyPhoneConfirm.setError(this.context.getString(R.string.err_msg_len_numero));
            requestFocus(this.txPhoneConfirm);
            return false;
        }
        if (this.txPhoneConfirm.getText().toString().trim().isEmpty()) {
            this.lyPhoneConfirm.setError(this.context.getString(R.string.hint_campo_vacio));
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
            String telf = getPhone(uri).replace(" ", BuildConfig.FLAVOR).replace("-", BuildConfig.FLAVOR).trim();
            if (telf.contains("+")) {
                telf = telf.substring(1);
            }
            if (telf.length() > 0 && telf.charAt(0) == '0') {
                telf = telf.substring(1);
            }
            if (telf.length() >= 3 && ((telf.substring(0, 3).contains("535") || telf.substring(0, 3).contains("536")) && telf.length() == 10)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadOfertasFromDatabase() {
        try {
            List<OfertasBoleto> list = unYp8VQThY.getInstance().getAllOfertasmiBoleto();
            if (list == null || list.isEmpty()) {
                mensaje("Información", "No se encontraron ofertas disponibles, es necesario que realice una Consulta de Ofertas en la sección de Consultas MiBoleto.");
                return false;
            }
            List<OfertasBoleto> ofertasValidas = new ArrayList<>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Calendar hoy = Calendar.getInstance();
            hoy.set(11, 0);
            hoy.set(12, 0);
            hoy.set(13, 0);
            hoy.set(14, 0);
            for (OfertasBoleto oferta : list) {
                String intervaloFechas = oferta.getFechaOferta();
                int validDays = oferta.getValidDays();
                if (validDays == 0) {
                    if (intervaloFechas.equals("-")) {
                        ofertasValidas.add(oferta);
                    } else {
                        try {
                            String[] fechas = intervaloFechas.split("-");
                            if (fechas.length == 2) {
                                Date fechaFin = simpleDateFormat.parse(fechas[1].trim());
                                if (!fechaFin.before(hoy.getTime())) {
                                    ofertasValidas.add(oferta);
                                }
                            } else if (fechas.length == 1) {
                                Date fechaFin2 = simpleDateFormat.parse(fechas[0].trim());
                                if (!fechaFin2.before(hoy.getTime())) {
                                    ofertasValidas.add(oferta);
                                }
                            }
                        } catch (Exception e) {
                            ofertasValidas.add(oferta);
                            Log.e("FilterOfertas", "Error al parsear fechas: " + e.getMessage());
                        }
                    }
                } else {
                    try {
                        String[] fechas2 = intervaloFechas.split("-");
                        Date fechaFinOferta = null;
                        if (fechas2.length == 2) {
                            fechaFinOferta = simpleDateFormat.parse(fechas2[1].trim());
                        } else if (fechas2.length == 1) {
                            fechaFinOferta = simpleDateFormat.parse(fechas2[0].trim());
                        }
                        if (fechaFinOferta != null) {
                            Calendar fechaLimiteCompra = Calendar.getInstance();
                            fechaLimiteCompra.setTime(fechaFinOferta);
                            fechaLimiteCompra.add(5, -validDays);
                            fechaLimiteCompra.set(11, 0);
                            fechaLimiteCompra.set(12, 0);
                            fechaLimiteCompra.set(13, 0);
                            fechaLimiteCompra.set(14, 0);
                            boolean dentroPeriodoCompra = !hoy.getTime().after(fechaFinOferta) && hoy.getTime().before(fechaLimiteCompra.getTime());
                            if (dentroPeriodoCompra) {
                                ofertasValidas.add(oferta);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("FilterOfertas", "Error al parsear fechas con validDays: " + e2.getMessage());
                    }
                }
            }
            this.ofertasList = ofertasValidas;
            if (!ofertasValidas.isEmpty()) {
                this.ofertasArrayAdapter = new ArrayAdapter<OfertasBoleto>(this.context, android.R.layout.simple_dropdown_item_1line) { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.9
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int position, View convertView, ViewGroup parent) {
                        TextView textView = (TextView) super.getView(position, convertView, parent);
                        OfertasBoleto oferta2 = (OfertasBoleto) getItem(position);
                        if (oferta2 != null) {
                            textView.setText(oferta2.getNombre());
                        }
                        return textView;
                    }

                    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        return getView(position, convertView, parent);
                    }
                };
                for (OfertasBoleto uyh0pxs9m37in : ofertasValidas) {
                    this.ofertasArrayAdapter.add(uyh0pxs9m37in);
                }
                if (this.spOferta == null) {
                    this.spOferta = (jN13TOyLMX) this.rootView.findViewById(R.id.spOferta);
                }
                if (this.spOferta != null) {
                    this.ofertasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spOferta.setAdapter(this.ofertasArrayAdapter);
                    this.spOferta.setOnItemClickListener(this.spClickOfertas);
                    this.ofertasArrayAdapter.notifyDataSetChanged();
                    Date fecha = ofertasValidas.get(0).getFecha();
                    String fechaFormateada = simpleDate.format(fecha);
                    this.txFechaUpdate.setText("Última actualización: " + fechaFormateada);
                    return true;
                }
                Log.e("loadOfertasDB", "Error: Spinner no inicializado");
                Toast.makeText(this.context, "Error al configurar las ofertas", 0).show();
                return false;
            }
            Toast.makeText(this.context, "No hay ofertas disponibles actualmente", 0).show();
            return false;
        } catch (Exception ex) {
            Log.e("loadOfertasDB", "Error al cargar ofertas: " + ex.getMessage(), ex);
            return false;
        }
    }

    public boolean actualizarOfertas() {
        mostrarConfirmacionActualizacion();
        return true;
    }

    private void fechaConfig(final int sum) {
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long minDate;
                Calendar calendarHoy = Calendar.getInstance();
                int day = calendarHoy.get(5);
                int month = calendarHoy.get(2);
                int year = calendarHoy.get(1);
                String intervaloFechas = TBaFnBLjEA.this.ofertaActual != null ? TBaFnBLjEA.this.ofertaActual.getFechaOferta() : "-";
                int validDays = TBaFnBLjEA.this.ofertaActual != null ? TBaFnBLjEA.this.ofertaActual.getValidDays() : 0;
                TBaFnBLjEA.this.fIniciodatePicker = new DatePickerDialog(TBaFnBLjEA.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.10.1
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
                        TBaFnBLjEA.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        TBaFnBLjEA.this.fechaInicio = dia + "-" + mes + "-" + year2;
                        TBaFnBLjEA.this.txIntervaloFechas.setVisibility(8);
                    }
                }, year, month, day);
                if (intervaloFechas.equals("-")) {
                    TBaFnBLjEA.this.configurarFechasPorDefecto(sum);
                } else {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                        String[] fechas = intervaloFechas.split("-");
                        Calendar hoy = Calendar.getInstance();
                        hoy.set(11, 0);
                        hoy.set(12, 0);
                        hoy.set(13, 0);
                        hoy.set(14, 0);
                        Date fechaActual = hoy.getTime();
                        try {
                            if (fechas.length == 2) {
                                Date fechaInicioIntervalo = sdf.parse(fechas[0].trim());
                                Date fechaFinIntervalo = sdf.parse(fechas[1].trim());
                                if (validDays > 0) {
                                    try {
                                        Calendar calFechaMinima = Calendar.getInstance();
                                        calFechaMinima.setTime(fechaActual);
                                        calFechaMinima.add(5, validDays);
                                        Date fechaMinimaDisponible = calFechaMinima.getTime();
                                        if (fechaMinimaDisponible.after(fechaInicioIntervalo)) {
                                            try {
                                                minDate = fechaMinimaDisponible.getTime();
                                            } catch (Exception e) {
                                                e = e;
                                            }
                                        } else {
                                            minDate = fechaInicioIntervalo.getTime();
                                        }
                                        try {
                                            if (minDate > fechaFinIntervalo.getTime()) {
                                                try {
                                                    try {
                                                        Toast.makeText(TBaFnBLjEA.this.context, "No hay fechas disponibles para esta oferta", 0).show();
                                                        return;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                }
                                            } else {
                                                try {
                                                    long maxDate = fechaFinIntervalo.getTime();
                                                    TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMinDate(minDate);
                                                    try {
                                                        TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMaxDate(maxDate);
                                                        Calendar calMinDate = Calendar.getInstance();
                                                        calMinDate.setTimeInMillis(minDate);
                                                        TBaFnBLjEA.this.fIniciodatePicker.updateDate(calMinDate.get(1), calMinDate.get(2), calMinDate.get(5));
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        Log.e("FechaConfig", "Error al parsear fechas: " + e.getMessage());
                                                        TBaFnBLjEA.this.configurarFechasPorDefecto(sum);
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                    }
                                    Log.e("FechaConfig", "Error al parsear fechas: " + e.getMessage());
                                    TBaFnBLjEA.this.configurarFechasPorDefecto(sum);
                                } else {
                                    long minDate2 = fechaInicioIntervalo.before(fechaActual) ? fechaActual.getTime() : fechaInicioIntervalo.getTime();
                                    long maxDate2 = fechaFinIntervalo.getTime();
                                    TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMinDate(minDate2);
                                    TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMaxDate(maxDate2);
                                    Calendar calMinDate2 = Calendar.getInstance();
                                    calMinDate2.setTimeInMillis(minDate2);
                                    TBaFnBLjEA.this.fIniciodatePicker.updateDate(calMinDate2.get(1), calMinDate2.get(2), calMinDate2.get(5));
                                }
                            } else if (fechas.length == 1) {
                                Date fechaUnica = sdf.parse(fechas[0].trim());
                                if (validDays > 0) {
                                    Calendar fechaLimiteCompra = Calendar.getInstance();
                                    fechaLimiteCompra.setTime(fechaUnica);
                                    fechaLimiteCompra.add(5, -validDays);
                                    if (!fechaActual.before(fechaLimiteCompra.getTime()) || fechaActual.after(fechaUnica)) {
                                        Toast.makeText(TBaFnBLjEA.this.context, "Esta fecha ya no está disponible para compra", 0).show();
                                        TBaFnBLjEA.this.configurarFechasPorDefecto(sum);
                                        return;
                                    } else {
                                        TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMinDate(fechaUnica.getTime());
                                        TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMaxDate(fechaUnica.getTime());
                                        Calendar calFechaUnica = Calendar.getInstance();
                                        calFechaUnica.setTime(fechaUnica);
                                        TBaFnBLjEA.this.fIniciodatePicker.updateDate(calFechaUnica.get(1), calFechaUnica.get(2), calFechaUnica.get(5));
                                    }
                                } else {
                                    TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMinDate(fechaUnica.getTime());
                                    TBaFnBLjEA.this.fIniciodatePicker.getDatePicker().setMaxDate(fechaUnica.getTime());
                                    Calendar calFechaUnica2 = Calendar.getInstance();
                                    calFechaUnica2.setTime(fechaUnica);
                                    TBaFnBLjEA.this.fIniciodatePicker.updateDate(calFechaUnica2.get(1), calFechaUnica2.get(2), calFechaUnica2.get(5));
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                    }
                }
                TBaFnBLjEA.this.fIniciodatePicker.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configurarFechasPorDefecto(int sum) {
        Calendar fechaTope = Calendar.getInstance();
        fechaTope.add(2, 6);
        long limit = fechaTope.getTimeInMillis();
        Calendar today = Calendar.getInstance();
        today.add(5, sum);
        long now = today.getTimeInMillis();
        this.fIniciodatePicker.getDatePicker().setMinDate(now);
        this.fIniciodatePicker.getDatePicker().setMaxDate(limit);
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.11
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                TBaFnBLjEA.this.openWebPage("https://miboleto.mibulevar.com");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(-16776961);
                ds.setUnderlineText(true);
            }
        };
        spannableString.setSpan(clickableSpan, mensaje.indexOf("https://miboleto.mibulevar.com"), mensaje.length(), 0);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.12
            @Override // java.lang.Runnable
            public void run() {
                TextView messageTextView = new TextView(TBaFnBLjEA.this.getContext());
                messageTextView.setText(spannableString);
                messageTextView.setMovementMethod(LinkMovementMethod.getInstance());
                messageTextView.setPadding(50, 40, 50, 20);
                messageTextView.setTextAlignment(2);
                messageTextView.setTextSize(16.0f);
                messageTextView.setTextColor(-16777216);
                AlertDialog alertDialog = new AlertDialog.Builder(TBaFnBLjEA.this.getContext()).setTitle(title).setView(messageTextView).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.12.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
                alertDialog.show();
            }
        });
    }

    public void mensaje(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.13
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(TBaFnBLjEA.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.13.1
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

    public void mostrarConfirmacionActualizacion() {
        final SpannableString spannableString = new SpannableString("¿Usted desea realizar una consulta de las Ofertas disponibles para el servicio de compra de boletos?");
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.14
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(TBaFnBLjEA.this.getContext()).setTitle("Información").setMessage(spannableString).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.14.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        rDEl7rW1aN bs = new rDEl7rW1aN();
                        if (bs.getCodeAgent() != null) {
                            if (bs.getCodeAgent().getCode().contains("-1")) {
                                ((S9ycHcoxAzy) TBaFnBLjEA.this.getActivity()).actionCallUSSD("117");
                                return;
                            } else {
                                ((IHVTCBmiLV) TBaFnBLjEA.this.getActivity()).actionCallUSSD("117");
                                return;
                            }
                        }
                        ((S9ycHcoxAzy) TBaFnBLjEA.this.getActivity()).actionCallUSSD("117");
                    }
                }).setNegativeButton("Cancelar", null).create();
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

    private void setupCantidadListener() {
        this.txCantidad.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA.15
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TBaFnBLjEA.this.calcularImporteEnTiempoReal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcularImporteEnTiempoReal() {
        try {
            String cantidadStr = this.txCantidad.getText().toString().trim();
            if (this.ofertaActual == null || this.ofertaActualPosition < 0 || cantidadStr.isEmpty()) {
                this.txMonto.setText(String.format(Locale.getDefault(), "%.2f", Double.valueOf(0.0d)));
            } else {
                String cantidadNormalizada = cantidadStr.replace(',', '.');
                float cantidad = Float.parseFloat(cantidadNormalizada);
                double importe = ((double) cantidad) * this.ofertaActual.getPrecio();
                this.txMonto.setText(String.format(Locale.getDefault(), "%.2f", Double.valueOf(importe)));
            }
        } catch (NumberFormatException e) {
            this.txMonto.setText(String.format(Locale.getDefault(), "%.2f", Double.valueOf(0.0d)));
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
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.TBaFnBLjEA);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
        saveFormData();
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

    private void saveFormData() {
        As6QBoLoQJ.ci = this.txCI.getText().toString();
        As6QBoLoQJ.fecha = this.txFecha.getText().toString();
        String str = this.fechaInicio;
        As6QBoLoQJ.fechaInicio = str != null ? str.toString() : BuildConfig.FLAVOR;
        As6QBoLoQJ.cantidad = this.txCantidad.getText().toString();
        As6QBoLoQJ.monto = this.txMonto.getText().toString();
        As6QBoLoQJ.phone = this.txPhoneConfirm.getText().toString();
        As6QBoLoQJ.moneda = this.txMonedaImporte.getText().toString();
    }

    private void loadFormData() {
        String str = As6QBoLoQJ.ci;
        if (str != null) {
            this.txCI.setText(str);
        }
        String str2 = As6QBoLoQJ.fecha;
        if (str2 != null) {
            this.txFecha.setText(str2);
        }
        this.fechaInicio = As6QBoLoQJ.fechaInicio;
        String str3 = As6QBoLoQJ.cantidad;
        if (str3 != null) {
            this.txCantidad.setText(str3);
        }
        String str4 = As6QBoLoQJ.monto;
        if (str4 != null) {
            this.txMonto.setText(str4);
        }
        String str5 = As6QBoLoQJ.phone;
        if (str5 != null) {
            this.txPhoneConfirm.setText(str5);
        }
        String str6 = As6QBoLoQJ.moneda;
        if (str6 != null) {
            this.txMonedaImporte.setText(str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseFecha(String intervaloStr) {
        if (intervaloStr == null || intervaloStr.isEmpty()) {
            return null;
        }
        try {
            String[] fechas = intervaloStr.split("-");
            if (fechas.length == 0) {
                return null;
            }
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < fechas.length; i++) {
                String fecha = fechas[i].trim();
                String[] partes = fecha.split("/");
                if (partes.length != 3) {
                    return null;
                }
                String mes = partes[0];
                String dia = partes[1];
                String str = partes[2];
                if (i > 0) {
                    resultado.append("-");
                }
                resultado.append(dia);
                resultado.append("/");
                resultado.append(mes);
                resultado.append("/");
                resultado.append(str);
            }
            return resultado.toString();
        } catch (Exception e) {
            Log.e("DATE_ERROR", "Error al parsear intervalo de fecha: " + intervaloStr, e);
            return null;
        }
    }
}
