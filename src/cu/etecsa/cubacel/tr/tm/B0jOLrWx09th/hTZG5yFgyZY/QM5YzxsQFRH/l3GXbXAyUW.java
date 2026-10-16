package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l3GXbXAyUW extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private R1sDOSqZ2z agency;
    private String agencyCode;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private ImageButton btnCuentaDestino;
    public CheckBox checkBoxMyPhone;
    public CheckBox checkBoxSendSaldo;
    private Uri contactUri;
    public Context context;
    public String cuentaCaracteres;
    private List<CuentaBanco> cuentasList;
    public String displayContact;
    public int enviarMiMovil;
    public int enviarSaldo;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputCuentaDestino;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutCuentaDestino;
    public TextInputLayout inputLayoutMisCuentas;
    private TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    public boolean isWithPin;
    public int keyDel;
    private List<CuentaBanco> lCuentas;
    private TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public List<MCBank> misCuentas;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerMisCuentas;
    public Drawable tarjeta;
    public TextView txContacto;
    private AutoCompleteTextView txMonedaImporte;
    public int tipoBolsa = 0;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public String cuentaDestino = BuildConfig.FLAVOR;
    public boolean seleccionTransferencia = false;
    public ArrayList<String> items = new ArrayList<>();
    private String tipo = "1";
    private String movilConfrirm = "0";
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || l3GXbXAyUW.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    l3GXbXAyUW.this.busk_contactos(v);
                } else {
                    l3GXbXAyUW.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            l3GXbXAyUW l3gxbxayuw = l3GXbXAyUW.this;
            l3gxbxayuw.tipoBolsa = position + 1;
            if (position == 0) {
                l3gxbxayuw.txMonedaImporte.setText("USD");
            }
            switch (position) {
                case 0:
                    if (!l3GXbXAyUW.this.cargarMisCuentas()) {
                        l3GXbXAyUW.this.showDialogNoTieneCuentas();
                        l3GXbXAyUW.this.inputLayoutMisCuentas.setVisibility(8);
                        l3GXbXAyUW.this.seleccionTransferencia = false;
                    } else {
                        l3GXbXAyUW l3gxbxayuw2 = l3GXbXAyUW.this;
                        l3gxbxayuw2.seleccionTransferencia = true;
                        l3gxbxayuw2.inputLayoutMisCuentas.setVisibility(0);
                    }
                    break;
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = l3GXbXAyUW.this.mcBankArrayAdapter.getItem(position);
            l3GXbXAyUW.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.g5innboeybmpry, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.checkBoxMyPhone);
        this.checkBoxMyPhone = checkBox;
        checkBox.setEnabled(true);
        this.checkBoxSendSaldo = (CheckBox) this.rootView.findViewById(R.id.checkBoxSendSaldo);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_tipo_moneda_importe);
        this.inputLayoutTipoMonedaImporte = textInputLayout;
        textInputLayout.setVisibility(0);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_mis_cuentas, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        this.inputLayoutMisCuentas = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_mis_cuentas);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        this.inputLayoutCuentaDestino = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta_destino);
        this.inputCuentaDestino = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta_destino);
        this.btnCuentaDestino = (ImageButton) this.rootView.findViewById(R.id.btSearchCuenta);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutClave.setHint(getString(R.string.err_msg_err_pin));
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputClave.setFilters(fArray);
        if (Build.VERSION.SDK_INT >= 26) {
            this.inputClave.setImportantForAutofill(2);
        }
        this.inputLayoutClave.setVisibility(8);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            this.agency = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.isWithPin = true;
            this.agencyCode = "08";
            this.inputLayoutClave.setVisibility(0);
        }
        if (getArguments() != null && getArguments().containsKey("returning_to_a")) {
            try {
                this.isDirectScan = getArguments().getBoolean("returning_to_a");
            } catch (Exception e) {
            }
        }
        this.btnCuentaDestino.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (unYp8VQThY.getInstance().getCuentasLists() != null && unYp8VQThY.getInstance().getCuentasLists().size() > 0) {
                    l3GXbXAyUW.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(l3GXbXAyUW.this.context);
                builder.setTitle("Notificación").setMessage("No tiene cuentas registradas. Para insertarlas debe ir a Gestión->Cuentas Banco.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l3GXbXAyUW.this.submitForm();
            }
        });
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.inputLayoutMisCuentas.setVisibility(8);
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("cuenta_origen_id")) {
            try {
                int id = arg.getInt("cuenta_origen_id");
                MCBank cuentaMC = unYp8VQThY.getInstance().getMCBank(id);
                this.spBolsas.setText("-MIS CUENTAS-");
                cargarMisCuentas();
                this.inputLayoutMisCuentas.setVisibility(0);
                this.spinnerMisCuentas.setText(cuentaMC.toString());
                this.miCuentaSeleccion = cuentaMC.getCuenta();
                this.txMonedaImporte.setText(cuentaMC.getTipo_moneda().toString());
            } catch (Exception e2) {
            }
        }
        loadDataDestino();
        initSeparator();
        loadSearchSpinnerCuentas();
        completarQR();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICA);
        switch (uyh0pxs9m37in.getItemId()) {
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                } else {
                    OJ3XxacXOT qr = new OJ3XxacXOT();
                    qr.setArguments(arg);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                }
                return true;
            case R.id.qrsgen /* 2131297280 */:
                KeTIEVSfVo perfiles = new KeTIEVSfVo();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, perfiles).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        this.enviarMiMovil = 0;
        this.enviarSaldo = 0;
        String cadenaInicio = BuildConfig.FLAVOR;
        if (this.isWithPin) {
            if (!validateClave()) {
                return;
            }
            cadenaInicio = this.agencyCode + "*" + this.inputClave.getText().toString().trim() + "*";
        }
        if (!validateCuentaDestino() || !validateMonto()) {
            return;
        }
        String importe = this.inputMonto.getText().toString().trim();
        if (!validateSpBolsa()) {
            return;
        }
        if ((this.seleccionTransferencia && !validateCuentaOrigen()) || !validatePhone()) {
            return;
        }
        if (this.checkBoxMyPhone.isChecked()) {
            this.enviarMiMovil = 1;
        }
        if (this.checkBoxSendSaldo.isChecked()) {
            this.enviarSaldo = 1;
        }
        String cadena = cadenaInicio + (this.tipo + "*" + this.miCuentaSeleccion + "*" + this.cuentaDestino + "*" + importe + "*" + this.enviarMiMovil + "*" + this.movilConfrirm + "*" + this.enviarSaldo + "*" + this.tipoBolsa);
        String msg = "Desea transferir " + importe + " " + this.txMonedaImporte.getText().toString() + " a la cuenta del número " + this.cuentaDestino;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "45", "08", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else if (!this.isWithPin) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "45", cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBackWithRetun(this.context, "45", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMonto() {
        String montoStr = this.inputMonto.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.inputLayoutMonto.setError("No se permiten ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
            requestFocus(this.inputMonto);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
                requestFocus(this.inputMonto);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.inputLayoutMonto.setError("Monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
    }

    private boolean validateCuentaDestino() {
        if (this.inputCuentaDestino.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuentaDestino.setError(this.context.getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuentaDestino);
            return false;
        }
        if (this.inputCuentaDestino.getText().toString().replace("-", BuildConfig.FLAVOR).length() != 16) {
            this.inputLayoutCuentaDestino.setError(this.context.getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuentaDestino);
            return false;
        }
        if (!this.inputCuentaDestino.getText().toString().replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
            this.inputLayoutCuentaDestino.setError(getString(R.string.err_msg_err_tarjeta_clasica));
            requestFocus(this.inputCuentaDestino);
            return false;
        }
        this.cuentaDestino = this.inputCuentaDestino.getText().toString().replace("-", BuildConfig.FLAVOR);
        this.inputLayoutCuentaDestino.setErrorEnabled(false);
        return true;
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

    private boolean validateCuentaOrigen() {
        if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        if (this.miCuentaSeleccion.length() != 16) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        this.inputLayoutMisCuentas.setErrorEnabled(false);
        return true;
    }

    private boolean validatePhone() {
        if (!this.inputCuenta.getText().toString().trim().isEmpty() && this.inputCuenta.getText().toString().trim().length() != 8 && this.inputCuenta.getText().toString().trim().length() != 10) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.movilConfrirm = this.inputCuenta.getText().toString().trim();
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
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
            this.inputCuenta.setText(telf);
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

    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.MiTransfer);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.misCuentas = list;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void loadDataDestino() {
        try {
            unYp8VQThY.init(this.context);
            List<CuentaBanco> cuentaBancoList = unYp8VQThY.getInstance().getCuentasLists();
            List<String> cList = new ArrayList<>();
            for (CuentaBanco wl : cuentaBancoList) {
                String cuentaData = wl.getCuenta();
                String temp = getCuentaFormateada(cuentaData);
                cList.add(temp);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cList);
            this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
            this.inputCuenta = autoCompleteTextView;
            autoCompleteTextView.setAdapter(adapter);
            this.inputCuenta.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.7
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        l3GXbXAyUW.this.inputCuenta.showDropDown();
                    }
                }
            });
        } catch (Exception e) {
        }
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("cuenta_id")) {
            try {
                int id = arg.getInt("cuenta_id");
                CuentaBanco cuenta = unYp8VQThY.getInstance().getCuentaListWithId(id);
                String temp2 = getCuentaFormateada(cuenta.getCuenta());
                this.inputCuentaDestino.setText(temp2);
                this.inputCuenta.setText(cuenta.getMovil());
            } catch (Exception e2) {
            }
        }
    }

    private void loadSearchSpinnerCuentas() {
        List<CuentaBanco> cuentasLists = unYp8VQThY.getInstance().getCuentasLists();
        this.lCuentas = cuentasLists;
        if (cuentasLists != null && cuentasLists.size() > 0) {
            this.items.clear();
            List<CuentaBanco> list = this.lCuentas;
            this.cuentasList = list;
            for (CuentaBanco uyh0pxs9m37in : list) {
                this.items.add(uyh0pxs9m37in.toString());
            }
        }
        SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione la cuenta de destino", 2131820786, "Cerrar");
        this.spinnerDialog = spinnerDialog;
        spinnerDialog.setCancellable(true);
        this.spinnerDialog.setShowKeyboard(false);
        this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.8
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in2, int position) {
                CuentaBanco cuenta = (CuentaBanco) l3GXbXAyUW.this.lCuentas.get(position);
                l3GXbXAyUW.this.inputCuentaDestino.setText(l3GXbXAyUW.this.getCuentaFormateada(cuenta.getCuenta()));
                l3GXbXAyUW l3gxbxayuw = l3GXbXAyUW.this;
                l3gxbxayuw.cuentaDestino = l3gxbxayuw.inputCuentaDestino.getText().toString().trim().replace("-", BuildConfig.FLAVOR);
                if (cuenta.getMovil() == null || cuenta.getMovil().length() <= 0 || (cuenta.getMovil().length() != 8 && cuenta.getMovil().length() != 10)) {
                    l3GXbXAyUW.this.inputCuenta.setText(BuildConfig.FLAVOR);
                    l3GXbXAyUW.this.checkBoxMyPhone.setEnabled(false);
                } else {
                    l3GXbXAyUW.this.inputCuenta.setText(cuenta.getMovil());
                    l3GXbXAyUW.this.checkBoxMyPhone.setEnabled(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCuentaFormateada(String cuentaData) {
        String temp = BuildConfig.FLAVOR;
        for (int i = 0; i < 16; i++) {
            temp = temp + Character.toString(cuentaData.charAt(i));
            if ((temp.length() + 1) % 5 == 0 && temp.split("-").length <= 3) {
                temp = temp + "-";
            }
        }
        return temp;
    }

    public void completarQR() {
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("QRData")) {
                String qrdata = arg.getString("QRData");
                Log.d("RESULTADO", qrdata);
                if (qrdata.contains("TRANSFERMOVIL_ETECSA") && qrdata.contains("TRANSFERENCIA")) {
                    String[] parametros = qrdata.split(",");
                    String cuenta = parametros[2];
                    String movil_confirmar = BuildConfig.FLAVOR;
                    if (parametros.length == 4) {
                        movil_confirmar = parametros[3];
                    }
                    if (cuenta.length() == 16) {
                        String temp = getCuentaFormateada(cuenta);
                        this.inputCuentaDestino.setText(temp);
                        this.inputLayoutCuentaDestino.setEnabled(false);
                        this.btnCuentaDestino.setEnabled(false);
                    }
                    if (movil_confirmar.length() == 8 || movil_confirmar.length() == 10) {
                        if (movil_confirmar.length() == 10) {
                            movil_confirmar = movil_confirmar.substring(2);
                        }
                        this.inputCuenta.setText(movil_confirmar);
                        this.checkBoxMyPhone.setEnabled(true);
                        this.checkBoxMyPhone.setVisibility(0);
                    }
                }
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

    private void initSeparator() {
        loadDrawables();
        cuentaOnListeners();
    }

    private void loadDrawables() {
        try {
            Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_clasica);
            Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
            this.tarjeta = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuentaDestino.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        l3GXbXAyUW.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuentaDestino.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW.10
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (count == 16) {
                        l3GXbXAyUW.this.inputCuentaDestino.setText(l3GXbXAyUW.this.getCuentaFormateada(s.toString()));
                        return;
                    }
                    if (count == 0) {
                        l3GXbXAyUW.this.keyDel = 1;
                    }
                    boolean flag = true;
                    String[] eachBlock = l3GXbXAyUW.this.inputCuentaDestino.getText().toString().split("-");
                    for (String str : eachBlock) {
                        if (str.length() > 4) {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        l3GXbXAyUW.this.inputCuentaDestino.setText(l3GXbXAyUW.this.cuentaCaracteres);
                        return;
                    }
                    l3GXbXAyUW l3gxbxayuw = l3GXbXAyUW.this;
                    if (l3gxbxayuw.keyDel != 0) {
                        l3gxbxayuw.cuentaCaracteres = l3gxbxayuw.inputCuentaDestino.getText().toString();
                        l3GXbXAyUW.this.keyDel = 0;
                        return;
                    }
                    int length = l3gxbxayuw.inputCuentaDestino.getText().length() + 1;
                    float length2 = (l3GXbXAyUW.this.inputCuentaDestino.getText().length() + 1) % 5;
                    if ((l3GXbXAyUW.this.inputCuentaDestino.getText().length() + 1) % 5 == 0 && l3GXbXAyUW.this.inputCuentaDestino.getText().toString().split("-").length <= 3) {
                        l3GXbXAyUW.this.inputCuentaDestino.setText(((Object) l3GXbXAyUW.this.inputCuentaDestino.getText()) + "-");
                        l3GXbXAyUW.this.inputCuentaDestino.setSelection(l3GXbXAyUW.this.inputCuentaDestino.getText().length());
                    }
                    l3GXbXAyUW l3gxbxayuw2 = l3GXbXAyUW.this;
                    l3gxbxayuw2.cuentaCaracteres = l3gxbxayuw2.inputCuentaDestino.getText().toString();
                } catch (Exception ex) {
                    Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                l3GXbXAyUW l3gxbxayuw = l3GXbXAyUW.this;
                l3gxbxayuw.mostrarTarjeta(l3gxbxayuw.inputCuentaDestino, l3GXbXAyUW.this.inputCuentaDestino.getText().toString());
            }
        });
    }

    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta_destino) {
        try {
            if (tarjeta_destino.length() >= 7) {
                if (tarjeta_destino.substring(0, 7).contains("9760-03") && tarjeta_destino.length() >= 4) {
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.tarjeta, (Drawable) null);
                } else {
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        } catch (Exception e) {
        }
    }
}
