package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.F1fDSmu2Acf;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class xpc0ejPtmZ extends QGQCqILT4b implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public Activity activity;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    public ImageButton btnContacts;
    private CheckBox chConfirmPhone;
    public Uri contactUri;
    public String displayContact;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    public Boolean isShareQR;
    private TextInputLayout lyLayoutDescripcion;
    public TextInputLayout lyMonedaTransaccion;
    public TextInputLayout lyPhoneConfirm;
    private TextInputLayout lyStImporte;
    public pAzq93vIl3 manager;
    public ConstraintLayout modalConfirmarPago;
    public String noProveedor;
    public jN13TOyLMX spinnerTipoMonedaImporte;
    public f9CS9TjtF3 tipoQR;
    public String[] tipomoneda;
    public TextView tituloInfoQR;
    public TextView toobarTitle;
    public TextView txContacto;
    private AutoCompleteTextView txDescripcion;
    public AutoCompleteTextView txPhoneConfirm;
    private AutoCompleteTextView txStImporte;
    public TextView txTitulo;
    public int spinnerPositionSelect = 0;
    public String aux = "1";
    public boolean isEnviarAuxDat = false;
    public String DEEP_LINK_URL = "https://transfermovil.app/action?";
    public String dataSendQR = BuildConfig.FLAVOR;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isDirectScan = false;
    public boolean isPartialUSSD = false;
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    xpc0ejPtmZ.this.modalConfirmarPago.setVisibility(0);
                    xpc0ejPtmZ.this.isEnviarAuxDat = true;
                } else {
                    xpc0ejPtmZ.this.modalConfirmarPago.setVisibility(8);
                    xpc0ejPtmZ.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || xpc0ejPtmZ.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    xpc0ejPtmZ.this.busk_contactos(v);
                } else {
                    xpc0ejPtmZ.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    public enum f9CS9TjtF3 {
        DINAMICO,
        ESTATICO
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.k2sklwn5hsfmv, container, false);
        this.context = container.getContext();
        this.activity = getActivity();
        this.isShareQR = false;
        this.manager = new pAzq93vIl3(this.context, this);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toobarTitle = textView;
        textView.setText("Caja Extra");
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.textView7);
        this.tituloInfoQR = textView2;
        textView2.setVisibility(8);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_notransaccion);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_notransaccion);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.txTitulo = (TextView) this.rootView.findViewById(R.id.txTitulo);
        this.lyStImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_stimporte);
        this.txStImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_stimporte);
        this.lyLayoutDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_descripcion);
        this.txDescripcion = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_descripcion);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerMonedaTransaccion);
        this.lyMonedaTransaccion = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_moneda_transaccion);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.chConfirmPhone = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        this.tipoQR = f9CS9TjtF3.DINAMICO;
        this.lyStImporte.setVisibility(8);
        this.lyLayoutDescripcion.setVisibility(8);
        this.txTitulo.setVisibility(8);
        this.inputLayoutMonto.setVisibility(8);
        this.inputLayoutCuenta.setVisibility(8);
        this.inputLayoutTipoMonedaImporte.setVisibility(8);
        this.lyMonedaTransaccion.setVisibility(8);
        Bundle arg = getArguments();
        R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
        this.agencia = r1sDOSqZ2z;
        initComponentesCuentas(this.rootView, r1sDOSqZ2z);
        R1sDOSqZ2z r1sDOSqZ2z2 = this.agencia;
        R1sDOSqZ2z r1sDOSqZ2z3 = R1sDOSqZ2z.Metropolitano;
        if (r1sDOSqZ2z2 == r1sDOSqZ2z3) {
            this.inputLayoutClave.setHint(getString(R.string.pin_tarjeta_telebanca));
        }
        R1sDOSqZ2z r1sDOSqZ2z4 = this.agencia;
        if (r1sDOSqZ2z4 == r1sDOSqZ2z3 || r1sDOSqZ2z4 == R1sDOSqZ2z.BPA) {
            InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
            this.inputClave.setFilters(fArray);
        }
        if (arg.containsKey("APK_VALUE")) {
            String qrdata = arg.getString("APK_VALUE");
            JSONCompleteFields(qrdata);
            putData();
        }
        completarQR();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xpc0ejPtmZ.this.submitForm();
            }
        });
        if (getArguments() != null && getArguments().containsKey("returning_to_a")) {
            try {
                this.isDirectScan = getArguments().getBoolean("returning_to_a");
            } catch (Exception e) {
            }
        }
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
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CajaExtra);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
        saveData();
        switch (uyh0pxs9m37in.getItemId()) {
            case R.id.itemCargarLink /* 2131297006 */:
                showLinkDialog();
                return true;
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                } else {
                    OJ3XxacXOT qr = new OJ3XxacXOT();
                    qr.setArguments(arg);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                }
                return true;
            case R.id.qrshare /* 2131297281 */:
                if (this.isShareQR.booleanValue()) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction("android.intent.action.SEND");
                    sendIntent.putExtra("android.intent.extra.TEXT", "He compartido con usted desde Transfermóvil un link para la compra en línea: " + this.dataSendQR + " ");
                    sendIntent.setType("text/plain");
                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                } else {
                    Toast.makeText(this.context, "QR vacio o incompleto.", 1).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    public void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri);
            if (telf != null) {
                String telf2 = telf.replace(" ", BuildConfig.FLAVOR).trim();
                if (telf2.contains("+")) {
                    telf2 = telf2.substring(1);
                }
                if (telf2.charAt(0) == '0') {
                    telf2 = telf2.substring(1);
                }
                if ((telf2.substring(0, 3).toString().contains("535") || telf2.substring(0, 3).toString().contains("536")) && telf2.length() == 10) {
                    telf2 = telf2.substring(2);
                }
                this.txPhoneConfirm.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txContacto.setText(this.displayContact);
                    this.txContacto.setVisibility(0);
                    this.displayContact = BuildConfig.FLAVOR;
                }
            }
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        try {
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
        } catch (Exception e) {
            return null;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        String descripcion;
        String movilConfirmar;
        super.submitForm();
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!validateClave() || !validateCuenta()) {
            return;
        }
        if (this.tipoQR == f9CS9TjtF3.DINAMICO) {
            Toast.makeText(this.context, "Error cargando los datos", 1).show();
            return;
        }
        if (!validateImporteEscrito() || !validateSelectionAccounts() || !validateTipoMonedaImporte()) {
            return;
        }
        int idCurrencyCuenta = 1;
        int i = this.spinnerPositionSelect;
        if (i == 0) {
            idCurrencyCuenta = 1;
        } else if (i == 1) {
            idCurrencyCuenta = 2;
        } else if (i == 2) {
            idCurrencyCuenta = 3;
        }
        String agency = "0";
        switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
            case 1:
                agency = "01";
                break;
            case 2:
                agency = "02";
                break;
            case 3:
                agency = "03";
                break;
        }
        String pin = this.inputClave.getText().toString().trim();
        String cuenta = this.inputCuenta.getText().toString().trim();
        this.inputMonto.getText().toString().trim();
        String monto = this.txStImporte.getText().toString().trim();
        if (this.txDescripcion.getText().toString().isEmpty()) {
            descripcion = "0000";
        } else {
            String descripcion2 = this.txDescripcion.getText().toString().trim();
            descripcion = descripcion2;
        }
        if (!this.isEnviarAuxDat || this.txPhoneConfirm.getText().toString().trim().length() <= 0) {
            movilConfirmar = "00";
        } else {
            String movilConfirmar2 = this.txPhoneConfirm.getText().toString().trim();
            movilConfirmar = movilConfirmar2;
        }
        String cadena = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*" + movilConfirmar + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "32", cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "32", agency, this.MAX_PARAMETERS_PQUETE, cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        return true;
    }

    private boolean validateImporteEscrito() {
        String montoStr = this.txStImporte.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.lyStImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.lyStImporte.setError("No se permiten ceros a la izquierda");
            requestFocus(this.txStImporte);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.lyStImporte.setError("Formato de monto inválido");
            requestFocus(this.txStImporte);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.lyStImporte.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.lyStImporte.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.lyStImporte.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.lyStImporte.setError("El monto debe ser mayor a 0");
            requestFocus(this.txStImporte);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.lyStImporte.setError("El monto debe ser mayor a 0");
                requestFocus(this.txStImporte);
                return false;
            }
            if (monto.scale() > 2) {
                this.lyStImporte.setError("Solo se permiten hasta 2 decimales");
                requestFocus(this.txStImporte);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.lyStImporte.setError("Monto inválido");
            requestFocus(this.txStImporte);
            return false;
        }
    }

    private boolean validateTipoMonedaImporte() {
        if (this.spinnerTipoMonedaImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMonedaImporte.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMonedaImporte);
            return false;
        }
        this.inputLayoutTipoMonedaImporte.setErrorEnabled(false);
        return true;
    }

    public void completarQR() {
        putData();
        try {
            if (getArguments() != null) {
                Bundle arg = getArguments();
                if (arg.containsKey("QRData")) {
                    String qrdata = arg.getString("QRData");
                    JSONCompleteFields(qrdata);
                }
            }
        } catch (Exception e) {
        }
    }

    private void JSONCompleteFields(String qrdata) {
        if (isJSONValid(qrdata)) {
            this.dataSendQR = BuildConfig.FLAVOR;
            String idTransaccion = BuildConfig.FLAVOR;
            try {
                try {
                    JSONObject jsonObj = new JSONObject(qrdata);
                    double importe = 0.0d;
                    if (jsonObj.has("id_transaccion")) {
                        idTransaccion = String.valueOf(jsonObj.get("id_transaccion"));
                        this.inputCuenta.setText(idTransaccion);
                    }
                    if (jsonObj.has("importe")) {
                        importe = Double.parseDouble(String.valueOf(jsonObj.get("importe")));
                        this.inputMonto.setText(String.valueOf(importe));
                    }
                    if (jsonObj.has("moneda")) {
                        String moneda = (String) jsonObj.get("moneda");
                        this.lyMonedaTransaccion.setVisibility(0);
                        this.inputLayoutTipoMonedaImporte.setVisibility(0);
                        if (moneda.contains("CUP") || moneda.contains("1")) {
                            this.spinnerPositionSelect = 0;
                            this.spinnerTipoMonedaImporte.setText("CUP");
                        } else if (moneda.contains("CUC") || moneda.contains("2")) {
                            this.spinnerPositionSelect = 1;
                            this.spinnerTipoMonedaImporte.setText("CUC");
                        } else if (moneda.contains("USD") || moneda.contains("3")) {
                            this.spinnerPositionSelect = 2;
                            this.spinnerTipoMonedaImporte.setText("USD");
                        }
                    }
                    if (jsonObj.has("numero_proveedor")) {
                        this.noProveedor = String.valueOf(jsonObj.get("numero_proveedor"));
                    }
                    if (jsonObj.has("version")) {
                        String p = String.valueOf(jsonObj.get("version"));
                        if (!p.isEmpty()) {
                            this.aux = String.valueOf(jsonObj.get("version"));
                        }
                    }
                    if (jsonObj.has("titulo") && !jsonObj.isNull("titulo")) {
                        String titulo = String.valueOf(jsonObj.get("titulo"));
                        this.txTitulo.setVisibility(0);
                        if (titulo.length() >= 40) {
                            this.txTitulo.setText(titulo.subSequence(0, 19));
                        } else {
                            this.txTitulo.setText(titulo);
                        }
                    }
                    this.tituloInfoQR.setVisibility(0);
                    if (importe == 0.0d) {
                        this.lyStImporte.setVisibility(0);
                        this.lyLayoutDescripcion.setVisibility(0);
                        this.tipoQR = f9CS9TjtF3.ESTATICO;
                        this.inputLayoutMonto.setVisibility(8);
                        this.inputLayoutCuenta.setVisibility(8);
                        if (jsonObj.has("descripcion")) {
                            this.txDescripcion.setText(jsonObj.getString("descripcion"));
                            this.txDescripcion.setEnabled(false);
                            return;
                        }
                        return;
                    }
                    if (!idTransaccion.contains("ESTATICO")) {
                        this.tipoQR = f9CS9TjtF3.DINAMICO;
                        return;
                    }
                    this.lyLayoutDescripcion.setVisibility(0);
                    this.tipoQR = f9CS9TjtF3.ESTATICO;
                    this.inputLayoutCuenta.setVisibility(8);
                    if (jsonObj.has("importe")) {
                        this.txStImporte.setText(String.valueOf(importe));
                        this.txStImporte.setEnabled(false);
                    }
                    if (jsonObj.has("descripcion")) {
                        this.txDescripcion.setText(jsonObj.getString("descripcion"));
                        this.txDescripcion.setEnabled(false);
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                } catch (Exception e2) {
                    ex = e2;
                    ex.printStackTrace();
                    Toast.makeText(this.context, "ERROR no es posible leer el Código QR.", 1);
                    this.isShareQR = false;
                }
            } catch (JSONException e3) {
                e = e3;
            } catch (Exception e4) {
                ex = e4;
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

    public boolean isTextPlainValid(String jpo48jtycgtsp) {
        if (!jpo48jtycgtsp.contains("TRANSFERMOVIL_ETECSA") || !jpo48jtycgtsp.contains("PAGO_EXTERNO")) {
            return false;
        }
        try {
            String[] parametros = jpo48jtycgtsp.split(",");
            return parametros.length == 5;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4 && this.inputClave.getText().toString().trim().length() != 5) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco_mixto));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
        return true;
    }

    private void saveData() {
        String cuenta = BuildConfig.FLAVOR;
        U6ucOCBccJ.pmoneda = this.monedaTarjeta;
        String p = this.inputClave.getText().toString().trim();
        U6ucOCBccJ.pdata = p;
        jceCwl8l2R jcecwl8l2r = this.seleccionCuenta;
        U6ucOCBccJ.pseleccionCuenta = jcecwl8l2r;
        switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jcecwl8l2r.ordinal()]) {
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
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
            int i = U6ucOCBccJ.pmoneda;
            this.monedaTarjeta = i;
            String pin = U6ucOCBccJ.pdata;
            jceCwl8l2R seleccion = U6ucOCBccJ.pseleccionCuenta;
            String str = U6ucOCBccJ.pcuenta;
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
            if (pin.length() > 0) {
                this.inputClave.setText(pin);
            }
            switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[seleccion.ordinal()]) {
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

    private void showLinkDialog() {
        DialogFragment dialogFrag = new F1fDSmu2Acf();
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLink;
        if (requestCode == 1 && resultCode == 1) {
            try {
                String dataLink2 = data.getStringExtra("link");
                List<String> list = extractUrls(dataLink2);
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            dataLink2 = list.get(0);
                        }
                    } catch (Exception e) {
                        dataLink = data.getStringExtra("link");
                    }
                }
                dataLink = dataLink2;
                if (dataLink != null && dataLink.length() > 0 && ((dataLink.contains("https") && dataLink.contains("transfermovil")) || dataLink.contains("transfermovil://tm_compra_en_linea/action"))) {
                    Uri dataURI = Uri.parse(dataLink);
                    String id_transaccion = dataURI.getQueryParameter("id_transaccion");
                    String importe = dataURI.getQueryParameter("importe");
                    String moneda = dataURI.getQueryParameter("moneda");
                    String numero_proveedor = dataURI.getQueryParameter("numero_proveedor");
                    JSONObject obj = new JSONObject();
                    String importe2 = importe.replace(",", ".");
                    try {
                        obj.put("id_transaccion", id_transaccion);
                        obj.put("importe", new Double(importe2));
                        try {
                            obj.put("moneda", moneda);
                            try {
                                obj.put("numero_proveedor", new Integer(numero_proveedor));
                                obj.put("version", BuildConfig.FLAVOR);
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                    }
                    JSONCompleteFields(obj.toString());
                    putData();
                } else {
                    Toast.makeText(this.context, "Enlace incorrecto", 0).show();
                }
            } catch (Exception e5) {
                Toast.makeText(this.context, "Enlace incorrecto", 0).show();
            }
        }
        if (requestCode == 1 && data != null) {
            Uri data2 = data.getData();
            this.contactUri = data2;
            renderContact(data2);
        }
    }

    public static List<String> extractUrls(String text) {
        List<String> containedUrls = new ArrayList<>();
        Pattern pattern = Pattern.compile("((https):((//transfermovil.app/action?))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", 2);
        Matcher urlMatcher = pattern.matcher(text);
        while (urlMatcher.find()) {
            containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }
        return containedUrls;
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
