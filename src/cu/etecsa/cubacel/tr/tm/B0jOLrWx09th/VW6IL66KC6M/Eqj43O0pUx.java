package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.F1fDSmu2Acf;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.f9CS9TjtF3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Eqj43O0pUx extends LgiFGRpiEl {
    private static final int MAX_LENGHT = 130;
    private static final int MAX_LENGHT_ID = 15;
    public ArrayAdapter<CharSequence> adapterCategoria;
    private ImageButton btnCertificar;
    private ImageButton btnSecondContacts;
    public int categoria;
    private List<CuentaBanco> cuentasList;
    private AutoCompleteTextView inputCertificar;
    private TextInputLayout inputLayoutCategoria;
    private TextInputLayout inputLayoutCertificar;
    private TextInputLayout inputLayoutSecondPhone;
    private AutoCompleteTextView inputSecondPhone;
    private List<CuentaBanco> lCuentas;
    public pAzq93vIl3 manager;
    public jN13TOyLMX spinnerCategoria;
    public SpinnerDialog spinnerDialog;
    private TextView txNombreCertificar;
    private TextView txSecondContacto;
    public int MAX_PARAMETERS_PQUETE = 6;
    private String secondPhone = "0";
    public int payType = 0;
    private View.OnClickListener btnSecondContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Eqj43O0pUx.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    Eqj43O0pUx.this.busk_contactos(v);
                } else {
                    Eqj43O0pUx.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnCertificarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Eqj43O0pUx.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    Eqj43O0pUx.this.busk_contactos2(v);
                } else {
                    Eqj43O0pUx.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickCategoria = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            Eqj43O0pUx.this.categoria = position + 1;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    if (Eqj43O0pUx.this.cargarMisCuentas()) {
                        Eqj43O0pUx.this.monedaTarjeta = 0;
                        Eqj43O0pUx.this.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        Eqj43O0pUx.this.inputLayoutMisCuentas.setVisibility(0);
                        Eqj43O0pUx.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                    }
                    break;
                case 1:
                    Eqj43O0pUx.this.monedaTarjeta = 0;
                    Eqj43O0pUx.this.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    Eqj43O0pUx.this.inputLayoutMisCuentas.setVisibility(8);
                    Eqj43O0pUx.this.inputLayoutCuentaWrite.setVisibility(0);
                    Eqj43O0pUx.this.mcBankArrayAdapter = null;
                    Eqj43O0pUx.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Eqj43O0pUx.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    Eqj43O0pUx.this.seleccionCuenta = jceCwl8l2R.MONEDA;
                    Eqj43O0pUx.this.monedaTarjeta = position + 1;
                    Eqj43O0pUx.this.inputLayoutMisCuentas.setVisibility(8);
                    Eqj43O0pUx.this.inputLayoutCuentaWrite.setVisibility(8);
                    Eqj43O0pUx.this.mcBankArrayAdapter = null;
                    Eqj43O0pUx.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Eqj43O0pUx.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Eqj43O0pUx.this.context);
            builder.setTitle(Eqj43O0pUx.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(Eqj43O0pUx.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.5.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public ArrayList<String> items = new ArrayList<>();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.b1fvoceamkjay, container, false);
        this.context = container.getContext();
        this.activity = getActivity();
        this.manager = new pAzq93vIl3(this.context, this);
        initComponents();
        this.isShareQR = false;
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_notransaccion);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_notransaccion);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.txTitulo = (TextView) this.rootView.findViewById(R.id.txTitulo);
        this.lyStImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_stimporte);
        this.txStImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_stimporte);
        this.tipoQR = f9CS9TjtF3.DINAMICO;
        this.lyLayoutDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_descripcion);
        this.txDescripcion = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_descripcion);
        this.lyLayoutDescripcion.setVisibility(8);
        this.lyStImporte.setVisibility(8);
        ((LgiFGRpiEl) this).tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerMonedaTransaccion);
        this.inputLayoutCategoria = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_categoria);
        this.spinnerCategoria = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCategoria);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.categ_tranfer_bfi, android.R.layout.simple_list_item_1);
        this.adapterCategoria = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCategoria.setAdapter(this.adapterCategoria);
        this.spinnerCategoria.setOnItemClickListener(this.spClickCategoria);
        this.inputCertificar = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCertificar);
        this.inputLayoutCertificar = (TextInputLayout) this.rootView.findViewById(R.id.lyCertificar);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnCertificar);
        this.btnCertificar = imageButton;
        imageButton.setOnClickListener(this.btnCertificarOnClick);
        this.txNombreCertificar = (TextView) this.rootView.findViewById(R.id.txNombreCertificar);
        Bundle arg = getArguments();
        this.agencia = R1sDOSqZ2z.BFI;
        if (arg != null && arg.containsKey("PayType")) {
            this.payType = ((Integer) arg.getSerializable("PayType")).intValue();
        }
        if (arg != null && arg.containsKey("R1sDOSqZ2z")) {
            this.agencia = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
        }
        initComponentesCuentas(this.rootView, this.agencia);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.accounts, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        int i = this.payType;
        if (i == 1 || i == 2) {
            this.inputLayoutCertificar.setVisibility(8);
            this.btnCertificar.setVisibility(8);
            this.chConfirmPhone.setVisibility(0);
            if (this.payType == 1) {
                this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_con_confirm));
            } else {
                this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_indistinta));
            }
        } else {
            this.inputLayoutCertificar.setVisibility(0);
            this.btnCertificar.setVisibility(0);
            this.chConfirmPhone.setVisibility(8);
            this.modalConfirmarPago.setVisibility(8);
            this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_con_solic));
        }
        R1sDOSqZ2z r1sDOSqZ2z = this.agencia;
        R1sDOSqZ2z r1sDOSqZ2z2 = R1sDOSqZ2z.Metropolitano;
        if (r1sDOSqZ2z == r1sDOSqZ2z2) {
            this.inputLayoutClave.setHint(getString(R.string.pin_tarjeta_telebanca));
        }
        R1sDOSqZ2z r1sDOSqZ2z3 = this.agencia;
        if (r1sDOSqZ2z3 == r1sDOSqZ2z2 || r1sDOSqZ2z3 == R1sDOSqZ2z.BPA) {
            InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
            this.inputClave.setFilters(fArray);
        }
        if (arg.containsKey("APK_VALUE")) {
            String qrdata = arg.getString("APK_VALUE");
            JSONCompleteFields(qrdata);
            TEXTPLAINCompleteFields(qrdata);
            putData();
        }
        completarQR();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Eqj43O0pUx.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        this.varContacto = 1;
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos2(View v) {
        this.varContacto = 2;
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem uyh0pxs9m37in = menu.findItem(R.id.qrsgen);
        uyh0pxs9m37in.setVisible(false);
        MenuItem itemCargarLink = menu.findItem(R.id.itemCargarLink);
        itemCargarLink.setVisible(true);
        MenuItem itemShare = menu.findItem(R.id.qrshare);
        itemShare.setVisible(true);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Eqj43O0pUx);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
        arg.putSerializable("PayType", Integer.valueOf(this.payType));
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String movilCertifica;
        String cadena;
        String cadena2;
        String cadena3;
        String cadena4;
        super.submitForm();
        if (!validateClave() || !validateCuenta()) {
            return;
        }
        if (this.tipoQR == f9CS9TjtF3.DINAMICO) {
            if (!validateMonto()) {
                return;
            }
        } else if (!validateImporteEscrito()) {
            return;
        }
        if (!validateSelectionAccounts() || !validateTipoMonedaImporte() || !validateCategoria() || !validateMovilCertifica()) {
            return;
        }
        boolean isPartialUSSD = false;
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
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
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
            case 1:
                agency = "01";
                break;
            case 2:
                agency = "02";
                break;
            case 3:
                agency = "03";
                break;
            case 4:
                agency = "05";
                break;
            case 5:
                agency = "08";
                break;
        }
        String pin = this.inputClave.getText().toString().trim();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        if (this.inputCertificar.getText().toString().trim().isEmpty()) {
            movilCertifica = "0";
        } else {
            String movilCertifica2 = this.inputCertificar.getText().toString().trim();
            movilCertifica = movilCertifica2;
        }
        if (this.tipoQR == f9CS9TjtF3.ESTATICO) {
            String monto2 = movilCertifica;
            String monto3 = this.txStImporte.getText().toString().trim();
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            if (this.isEnviarAuxDat) {
                String movilConfirmar = "0";
                if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                    movilConfirmar = this.txPhoneConfirm.getText().toString().trim();
                }
                String cadena5 = agency + "*" + pin + "*" + cuenta + "*" + monto3 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + movilConfirmar + "*" + this.idQR + "*" + this.payType + "*" + monto2 + "*" + this.categoria;
                if (FBsQzP3Zfj.callLenght(this.context, cadena5) < MAX_LENGHT) {
                    cadena2 = cadena5;
                } else {
                    if (cuenta.length() > 15) {
                        cuenta = cuenta.substring(cuenta.length() - 15);
                    }
                    cadena2 = agency + "*" + pin + "*" + cuenta + "*" + monto3 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + movilConfirmar + "*" + this.idQR + "*" + this.payType + "*" + monto2 + "*" + this.categoria;
                    Log.d("TMDESA", "FINAL CUT USSD[" + cadena2 + "] LENGHT[" + cadena2.length() + "]");
                }
                cadena = cadena2;
            } else {
                String cadena6 = agency + "*" + pin + "*" + cuenta + "*" + monto3 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + this.payType + "*" + monto2 + "*" + this.categoria;
                if (FBsQzP3Zfj.callLenght(this.context, cadena6) < MAX_LENGHT) {
                    cadena = cadena6;
                } else {
                    if (cuenta.length() > 8) {
                        cuenta = cuenta.substring(cuenta.length() - 8);
                    }
                    String cadena7 = agency + "*" + pin + "*" + cuenta + "*" + monto3 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + this.payType + "*" + monto2 + "*" + this.categoria;
                    Log.d("TMDESA", "FINAL CUT USSD[" + cadena7 + "] LENGHT[" + cadena7.length() + "]");
                    cadena = cadena7;
                }
            }
            if (!isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "31", cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
                return;
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "31", "05", this.MAX_PARAMETERS_PQUETE, cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
                return;
            }
        }
        ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        if (this.isEnviarAuxDat) {
            String movilConfirmar2 = "0";
            if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                movilConfirmar2 = this.txPhoneConfirm.getText().toString().trim();
            }
            String cadena8 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + movilConfirmar2 + "*" + this.payType + "*" + movilCertifica + "*" + this.categoria;
            if (FBsQzP3Zfj.callLenght(this.context, cadena8) < MAX_LENGHT) {
                cadena4 = cadena8;
            } else {
                if (cuenta.length() > 15) {
                    cuenta = cuenta.substring(cuenta.length() - 15);
                }
                cadena4 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + movilConfirmar2 + "*" + this.payType + "*" + movilCertifica + "*" + this.categoria;
                Log.d("TMDESA", "FINAL CUT USSD[" + cadena4 + "] LENGHT[" + cadena4.length() + "]");
            }
            cadena3 = cadena4;
        } else {
            String cadena9 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + this.payType + "*" + movilCertifica + "*" + this.categoria;
            if (FBsQzP3Zfj.callLenght(this.context, cadena9) < MAX_LENGHT) {
                cadena3 = cadena9;
            } else {
                if (cuenta.length() > 15) {
                    cuenta = cuenta.substring(cuenta.length() - 15);
                }
                String cadena10 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + this.payType + "*" + movilCertifica + "*" + this.categoria;
                Log.d("TMDESA", "FINAL CUT USSD[" + cadena10 + "] LENGHT[" + cadena10.length() + "]");
                cadena3 = cadena10;
            }
        }
        if (!isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "30", cadena3, "¿Desea proceder con el pago?", group2, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "30", "05", this.MAX_PARAMETERS_PQUETE, cadena3, "¿Desea proceder con el pago?", group2, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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

    private boolean validateMovilCertifica() {
        if (this.payType == 0) {
            if (this.inputCertificar.getText().toString().trim().isEmpty()) {
                this.inputLayoutCertificar.setError(getString(R.string.err_msg_empty_cuenta));
                requestFocus(this.inputCertificar);
                return false;
            }
            if (this.inputCertificar.getText().toString().trim().length() != 8 && this.inputCertificar.getText().toString().trim().length() != 10) {
                this.inputLayoutCertificar.setError(getString(R.string.err_msg_movil_numero));
                requestFocus(this.inputCertificar);
                return false;
            }
            this.inputLayoutCertificar.setErrorEnabled(false);
            return true;
        }
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
        if (this.txStImporte.getText().toString().trim().isEmpty()) {
            this.lyStImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txStImporte);
            return false;
        }
        return true;
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

    private boolean validateCategoria() {
        if (this.spinnerCategoria.getText().toString().trim().isEmpty()) {
            this.inputLayoutCategoria.setError("Seleccione");
            requestFocus(this.spinnerCategoria);
            return false;
        }
        this.inputLayoutCategoria.setErrorEnabled(false);
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
                    TEXTPLAINCompleteFields(qrdata);
                }
            }
        } catch (Exception e) {
        }
    }

    private void TEXTPLAINCompleteFields(String qrdata) {
        if (isTextPlainValid(qrdata)) {
            this.dataSendQR = BuildConfig.FLAVOR;
            String[] parametros = qrdata.split(",");
            this.inputCuenta.setText(parametros[0]);
            float monto = Float.parseFloat(parametros[1]);
            this.inputMonto.setText(String.valueOf(monto));
            String moneda = parametros[2];
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
            this.noProveedor = parametros[3];
            this.aux = parametros[4];
            this.dataSendQR = this.DEEP_LINK_URL + String.format("id_transaccion=%s&importe=%f&moneda=%s&numero_proveedor=%d", parametros[0], Float.valueOf(monto), moneda, this.noProveedor);
            this.isShareQR = true;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl
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
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jcecwl8l2r.ordinal()]) {
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
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
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BFI.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICAEMP.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
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
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[seleccion.ordinal()]) {
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl, androidx.fragment.app.Fragment
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
            if (this.varContacto == 1) {
                renderContact(data2);
            } else {
                renderContact2(data2);
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(this.bancoEntity);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.mcBankArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (MCBank uyh0pxs9m37in : list) {
                this.mcBankArrayAdapter.add(uyh0pxs9m37in);
            }
            this.mcBankArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerMisCuentas.setAdapter(this.mcBankArrayAdapter);
            this.spinnerMisCuentas.setOnItemClickListener(this.spClickMisCuentas);
            return true;
        } catch (Exception e) {
            return false;
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

    private void renderContact2(Uri uri) {
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
                this.inputCertificar.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txNombreCertificar.setText(this.displayContact);
                    this.txNombreCertificar.setVisibility(0);
                    this.displayContact = BuildConfig.FLAVOR;
                }
            }
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
        }
    }

    private void renderContact3(Uri uri) {
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
                this.inputCertificar.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txNombreCertificar.setText(this.displayContact);
                    this.txNombreCertificar.setVisibility(0);
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

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
        Toast.makeText(this.activity, response, 0).show();
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
