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
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
public class Z3kYdPwq6K2 extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public AccessibilityManager accessibilityManager;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private R1sDOSqZ2z agency;
    private String agencyCode;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private ImageButton btnCuentaDestino;
    private ImageButton btnSecondContacts;
    public int categoria;
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
    public TextInputLayout inputLayoutCategoria;
    public TextInputLayout inputLayoutClave;
    public TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutCuentaDestino;
    public TextInputLayout inputLayoutMisCuentas;
    public TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutSecondPhone;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputSecondPhone;
    public boolean isWithPin;
    public int keyDel;
    private List<CuentaBanco> lCuentas;
    public TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public List<MCBank> misCuentas;
    public View rootView;
    private String secondPhone;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public SpinnerDialog spinnerDialogCategoria;
    public jN13TOyLMX spinnerMisCuentas;
    public Drawable tarjeta;
    public EditText txCategoria;
    public TextView txContacto;
    public TextView txDescripcionSecondContacto;
    private AutoCompleteTextView txMonedaImporte;
    public TextView txSecondNombreContacto;
    public TextView txTitulo;
    public int varContacto = 0;
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
    public int transferType = 0;
    public ArrayList<String> itemsCategoria = new ArrayList<>();
    public boolean isOpenOnceOne = false;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Z3kYdPwq6K2.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    Z3kYdPwq6K2.this.busk_contactos(v);
                } else {
                    Z3kYdPwq6K2.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnSecondContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.7
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Z3kYdPwq6K2.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    Z3kYdPwq6K2.this.busk_contactos2(v);
                } else {
                    Z3kYdPwq6K2.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
            z3kYdPwq6K2.tipoBolsa = position + 1;
            if (position == 0) {
                z3kYdPwq6K2.txMonedaImporte.setText("USD");
            }
            switch (position) {
                case 0:
                    if (!Z3kYdPwq6K2.this.cargarMisCuentas()) {
                        Z3kYdPwq6K2.this.showDialogNoTieneCuentas();
                        Z3kYdPwq6K2.this.inputLayoutMisCuentas.setVisibility(8);
                        Z3kYdPwq6K2.this.seleccionTransferencia = false;
                    } else {
                        Z3kYdPwq6K2 z3kYdPwq6K3 = Z3kYdPwq6K2.this;
                        z3kYdPwq6K3.seleccionTransferencia = true;
                        z3kYdPwq6K3.inputLayoutMisCuentas.setVisibility(0);
                    }
                    break;
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.9
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = Z3kYdPwq6K2.this.mcBankArrayAdapter.getItem(position);
            Z3kYdPwq6K2.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.o46hfkqfqmwxir, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.txTitulo = (TextView) this.rootView.findViewById(R.id.txTitulo);
        this.btnSecondContacts = (ImageButton) this.rootView.findViewById(R.id.btn_second_Contacts);
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
        this.txDescripcionSecondContacto = (TextView) this.rootView.findViewById(R.id.txDescripcion_second_Contacto);
        this.txSecondNombreContacto = (TextView) this.rootView.findViewById(R.id.tx_second_NombreContacto);
        this.inputSecondPhone = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_second_phone);
        this.inputLayoutSecondPhone = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_second_phone);
        this.inputLayoutCategoria = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_categoria);
        this.txCategoria = (EditText) this.rootView.findViewById(R.id.txCategoria);
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
        } else {
            this.isWithPin = false;
            this.agency = R1sDOSqZ2z.CLASICAEMP;
            this.agencyCode = "08";
            this.inputLayoutClave.setVisibility(8);
        }
        if (getArguments() != null && getArguments().containsKey("returning_to_a")) {
            try {
                this.isDirectScan = getArguments().getBoolean("returning_to_a");
            } catch (Exception e) {
            }
        }
        if (getArguments() != null && getArguments().containsKey("TransferType")) {
            this.transferType = ((Integer) getArguments().getSerializable("TransferType")).intValue();
        }
        this.btnCuentaDestino.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (unYp8VQThY.getInstance().getCuentasLists() != null && unYp8VQThY.getInstance().getCuentasLists().size() > 0) {
                    Z3kYdPwq6K2.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Z3kYdPwq6K2.this.context);
                builder.setTitle("Notificación").setMessage("No tiene cuentas registradas. Para insertarlas debe ir a Gestión->Cuentas Banco.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        this.btnSecondContacts.setOnClickListener(this.btnSecondContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Z3kYdPwq6K2.this.submitForm();
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
        if (this.transferType == 0) {
            this.btnContacts.setVisibility(8);
            this.inputLayoutCuenta.setVisibility(8);
            this.txContacto.setVisibility(8);
            this.checkBoxMyPhone.setVisibility(8);
        } else {
            this.btnSecondContacts.setVisibility(8);
            this.inputLayoutSecondPhone.setVisibility(8);
            this.txSecondNombreContacto.setVisibility(8);
        }
        this.txTitulo.setText(this.transferType == 0 ? R.string.tx_bfi_transferencia_con_solic : R.string.tx_bfi_transferencia_con_confirm);
        loadDataDestino();
        initSeparator();
        loadSearchSpinnerCuentas();
        completarQR();
        loadSearchSpinnerCategoria();
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (!accessibilityManager.isTouchExplorationEnabled()) {
            this.txCategoria.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.3
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        Z3kYdPwq6K2.this.inputLayoutCategoria.setErrorEnabled(false);
                        Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
                        z3kYdPwq6K2.isOpenOnceOne = true;
                        z3kYdPwq6K2.spinnerDialogCategoria.showSpinerDialog();
                        return;
                    }
                    Z3kYdPwq6K2.this.isOpenOnceOne = false;
                }
            });
            this.txCategoria.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Z3kYdPwq6K2.this.txCategoria.getText().toString().length() > 0 || Z3kYdPwq6K2.this.isOpenOnceOne) {
                        Z3kYdPwq6K2.this.inputLayoutCategoria.setErrorEnabled(false);
                        Z3kYdPwq6K2.this.spinnerDialogCategoria.showSpinerDialog();
                    }
                }
            });
        } else {
            this.txCategoria.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Z3kYdPwq6K2.this.inputLayoutCategoria.setErrorEnabled(false);
                    Z3kYdPwq6K2.this.spinnerDialog.showSpinerDialog();
                }
            });
        }
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
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICAEMP);
        arg.putSerializable("TransferType", Integer.valueOf(this.transferType));
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
        String cadenaInicio = this.agencyCode + "*";
        if (this.isWithPin) {
            if (!validateClave()) {
                return;
            }
            cadenaInicio = cadenaInicio + this.inputClave.getText().toString().trim() + "*";
        }
        if (!validateCuentaDestino() || !validateMonto()) {
            return;
        }
        String importe = this.inputMonto.getText().toString().trim();
        if (!validateCategoria() || !validateSpBolsa()) {
            return;
        }
        if ((this.seleccionTransferencia && !validateCuentaOrigen()) || !validatePhone()) {
            return;
        }
        if (this.transferType == 0 && !validateSecondPhone()) {
            return;
        }
        if (this.checkBoxMyPhone.isChecked()) {
            this.enviarMiMovil = 1;
        }
        if (this.checkBoxSendSaldo.isChecked()) {
            this.enviarSaldo = 1;
        }
        String cadena = cadenaInicio + (this.tipo + "*" + this.miCuentaSeleccion + "*" + this.cuentaDestino + "*" + importe + "*" + this.enviarMiMovil + "*" + this.movilConfrirm + "*" + this.enviarSaldo + "*" + this.secondPhone + "*" + this.transferType + "*" + this.categoria + "*" + this.tipoBolsa);
        String msg = "Desea transferir " + importe + " " + this.txMonedaImporte.getText().toString() + " a la cuenta " + this.cuentaDestino;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "220", "08", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else if (!this.isWithPin) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "220", cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBackWithRetun(this.context, "220", cadena, msg, group, getFragmentManager());
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
        if (!this.inputCuentaDestino.getText().toString().replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
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

    private boolean validateSecondPhone() {
        if (this.inputSecondPhone.getText().toString().trim().isEmpty()) {
            this.inputLayoutSecondPhone.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputSecondPhone);
            return false;
        }
        if (this.inputSecondPhone.getText().toString().trim().length() != 8 && this.inputSecondPhone.getText().toString().trim().length() != 10) {
            this.inputLayoutSecondPhone.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputSecondPhone);
            return false;
        }
        this.secondPhone = this.inputSecondPhone.getText().toString().trim();
        this.inputLayoutSecondPhone.setErrorEnabled(false);
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

    private boolean validateCategoria() {
        if (this.txCategoria.getText().toString().trim().isEmpty()) {
            this.inputLayoutCategoria.setError("Seleccione");
            requestFocus(this.txCategoria);
            return false;
        }
        this.inputLayoutCategoria.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
                this.inputSecondPhone.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txDescripcionSecondContacto.setVisibility(0);
                    this.txSecondNombreContacto.setText(this.displayContact);
                    this.txSecondNombreContacto.setVisibility(0);
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
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.CLASICAEMP);
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
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.10
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
            this.inputCuentaDestino.setAdapter(adapter);
            this.inputCuentaDestino.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.11
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        Z3kYdPwq6K2.this.inputCuentaDestino.showDropDown();
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
        this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.12
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in2, int position) {
                CuentaBanco cuenta = (CuentaBanco) Z3kYdPwq6K2.this.lCuentas.get(position);
                Z3kYdPwq6K2.this.inputCuentaDestino.setText(Z3kYdPwq6K2.this.getCuentaFormateada(cuenta.getCuenta()));
                Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
                z3kYdPwq6K2.cuentaDestino = z3kYdPwq6K2.inputCuentaDestino.getText().toString().trim().replace("-", BuildConfig.FLAVOR);
                if (cuenta.getMovil() == null || cuenta.getMovil().length() <= 0 || (cuenta.getMovil().length() != 8 && cuenta.getMovil().length() != 10)) {
                    Z3kYdPwq6K2.this.inputCuenta.setText(BuildConfig.FLAVOR);
                    Z3kYdPwq6K2.this.checkBoxMyPhone.setEnabled(false);
                } else {
                    Z3kYdPwq6K2.this.inputCuenta.setText(cuenta.getMovil());
                    Z3kYdPwq6K2.this.checkBoxMyPhone.setEnabled(true);
                }
            }
        });
    }

    private void loadSearchSpinnerCategoria() {
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.categ_tranfer_bfi, android.R.layout.simple_list_item_1);
        for (int i = 0; i < arrayAdapterCreateFromResource.getCount(); i++) {
            this.itemsCategoria.add((String) arrayAdapterCreateFromResource.getItem(i));
        }
        SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.itemsCategoria, "Seleccione la categoría", 2131820786, "Cerrar");
        this.spinnerDialogCategoria = spinnerDialog;
        spinnerDialog.setCancellable(true);
        this.spinnerDialogCategoria.setShowKeyboard(false);
        this.spinnerDialogCategoria.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.13
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in, int position) {
                Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
                z3kYdPwq6K2.categoria = position + 1;
                z3kYdPwq6K2.txCategoria.setText(uyh0pxs9m37in);
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
            Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_clasica_empresarial);
            Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
            this.tarjeta = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuentaDestino.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.14
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        Z3kYdPwq6K2.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuentaDestino.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2.15
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (count == 16) {
                        Z3kYdPwq6K2.this.inputCuentaDestino.setText(Z3kYdPwq6K2.this.getCuentaFormateada(s.toString()));
                        return;
                    }
                    if (count == 0) {
                        Z3kYdPwq6K2.this.keyDel = 1;
                    }
                    boolean flag = true;
                    String[] eachBlock = Z3kYdPwq6K2.this.inputCuentaDestino.getText().toString().split("-");
                    for (String str : eachBlock) {
                        if (str.length() > 4) {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        Z3kYdPwq6K2.this.inputCuentaDestino.setText(Z3kYdPwq6K2.this.cuentaCaracteres);
                        return;
                    }
                    Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
                    if (z3kYdPwq6K2.keyDel != 0) {
                        z3kYdPwq6K2.cuentaCaracteres = z3kYdPwq6K2.inputCuentaDestino.getText().toString();
                        Z3kYdPwq6K2.this.keyDel = 0;
                        return;
                    }
                    int length = z3kYdPwq6K2.inputCuentaDestino.getText().length() + 1;
                    float length2 = (Z3kYdPwq6K2.this.inputCuentaDestino.getText().length() + 1) % 5;
                    if ((Z3kYdPwq6K2.this.inputCuentaDestino.getText().length() + 1) % 5 == 0 && Z3kYdPwq6K2.this.inputCuentaDestino.getText().toString().split("-").length <= 3) {
                        Z3kYdPwq6K2.this.inputCuentaDestino.setText(((Object) Z3kYdPwq6K2.this.inputCuentaDestino.getText()) + "-");
                        Z3kYdPwq6K2.this.inputCuentaDestino.setSelection(Z3kYdPwq6K2.this.inputCuentaDestino.getText().length());
                    }
                    Z3kYdPwq6K2 z3kYdPwq6K3 = Z3kYdPwq6K2.this;
                    z3kYdPwq6K3.cuentaCaracteres = z3kYdPwq6K3.inputCuentaDestino.getText().toString();
                } catch (Exception ex) {
                    Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Z3kYdPwq6K2 z3kYdPwq6K2 = Z3kYdPwq6K2.this;
                z3kYdPwq6K2.mostrarTarjeta(z3kYdPwq6K2.inputCuentaDestino, Z3kYdPwq6K2.this.inputCuentaDestino.getText().toString());
            }
        });
    }

    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta_destino) {
        try {
            if (tarjeta_destino.length() >= 7) {
                if (tarjeta_destino.substring(0, 7).contains("9760-04") && tarjeta_destino.length() >= 4) {
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.tarjeta, (Drawable) null);
                } else {
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        } catch (Exception e) {
        }
    }
}
