package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f1IveoSASW extends QGQCqILT4b implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public AccessibilityManager accessibilityManager;
    public ArrayAdapter<CharSequence> adapterCategoria;
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private ImageButton btnSearch;
    private ImageButton btnSecondContacts;
    public int categoria;
    public CheckBox checkBoxMensaje;
    public CheckBox checkBoxMyPhone;
    public CheckBox checkBoxSendSaldo;
    private Uri contactUri;
    public String cuentaCaracteres;
    public String cuentaDestino;
    private List<CuentaBanco> cuentasList;
    public String displayContact;
    public int enviarMiMovil;
    public int enviarSaldo;
    public String importe;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputIdFactura;
    private TextInputLayout inputLayoutCategoria;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutIdFactura;
    private TextInputLayout inputLayoutMisCuentas;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutMsg;
    private TextInputLayout inputLayoutNumeroDestinatario;
    private TextInputLayout inputLayoutSecondPhone;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputMsg;
    private AutoCompleteTextView inputNumeroDestinatario;
    private AutoCompleteTextView inputSecondPhone;
    public int keyDel;
    private List<CuentaBanco> lCuentas;
    public boolean lock;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public String mensaje;
    public String mensajeCuentaDestino;
    public List<MCBank> misCuentas;
    public int monedaImporte;
    public int monedaTarjeta;
    public String movilConfirmar;
    public View rootView;
    public jN13TOyLMX spinnerCategoria;
    public SpinnerDialog spinnerDialog;
    public SpinnerDialog spinnerDialogCategoria;
    public jN13TOyLMX spinnerMisCuentas;
    public jN13TOyLMX spinnerTipoMonedaTarjeta;
    public String[] tipomoneda;
    public EditText txCategoria;
    public TextView txDescripcionContacto;
    public TextView txDescripcionSecondContacto;
    public TextView txNombreContacto;
    public TextView txSecondNombreContacto;
    private TextView txTitulo;
    public int MAX_PARAMETERS_PQUETE = 6;
    public int varContacto = 0;
    public String secondPhone = "0";
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public boolean isConfirm = false;
    public int transferType = 0;
    public boolean isOpenOnceOne = false;
    public ArrayList<String> itemsCategoria = new ArrayList<>();
    private jN13TOyLMX.OnItemClickListener spClickMonedaImporte = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.12
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f1IveoSASW.this.monedaImporte = position + 1;
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.13
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = f1IveoSASW.this.mcBankArrayAdapter.getItem(position);
            f1IveoSASW.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.14
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || f1IveoSASW.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    f1IveoSASW.this.busk_contactos(v);
                } else {
                    f1IveoSASW.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnSecondContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.15
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || f1IveoSASW.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    f1IveoSASW.this.busk_contactos2(v);
                } else {
                    f1IveoSASW.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public ArrayList<String> items = new ArrayList<>();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.t6tjpmqogsbrhs, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.btnSearch = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        R1sDOSqZ2z r1sDOSqZ2z = R1sDOSqZ2z.BFI;
        this.agencia = r1sDOSqZ2z;
        initComponentesCuentas(this.rootView, r1sDOSqZ2z);
        this.btnSearch.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (unYp8VQThY.getInstance().getCuentasLists() != null && unYp8VQThY.getInstance().getCuentasLists().size() > 0) {
                    f1IveoSASW.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(f1IveoSASW.this.context);
                builder.setTitle("Notificación").setMessage("No tiene cuentas registradas. Para insertarlas debe ir a Gestión->Cuentas Banco.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).setNeutralButton("Insertar nueva", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentManager mFragmentManager = f1IveoSASW.this.getActivity().getSupportFragmentManager();
                        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                        oaEWezaNAI editTarjeta = new oaEWezaNAI();
                        mFragmentTransaction.replace(R.id.containerView, editTarjeta).addToBackStack(null).commit();
                    }
                });
                builder.show();
            }
        });
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_phone_confirm);
        this.inputSecondPhone = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_second_phone);
        this.inputLayoutSecondPhone = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_second_phone);
        this.inputLayoutCategoria = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_categoria);
        this.txCategoria = (EditText) this.rootView.findViewById(R.id.txCategoria);
        this.inputIdFactura = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_id_factura);
        this.inputLayoutIdFactura = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_id_factura);
        this.checkBoxMyPhone = (CheckBox) this.rootView.findViewById(R.id.checkBoxMyPhone);
        this.checkBoxSendSaldo = (CheckBox) this.rootView.findViewById(R.id.checkBoxSendSaldo);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_tipo_moneda_importe);
        this.inputLayoutTipoMonedaImporte = textInputLayout;
        textInputLayout.setVisibility(0);
        this.adapterMoneda = ArrayAdapter.createFromResource(this.context, R.array.currency_bfi, android.R.layout.simple_list_item_1);
        jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerMoneda);
        this.spinnerTipoMonedaTarjeta = jn13toylmx;
        jn13toylmx.setAdapter(this.adapterMoneda);
        this.spinnerTipoMonedaTarjeta.setOnItemClickListener(this.spClickMonedaImporte);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        ImageButton imageButton2 = (ImageButton) this.rootView.findViewById(R.id.btn_second_Contacts);
        this.btnSecondContacts = imageButton2;
        imageButton2.setOnClickListener(this.btnSecondContactsOnClick);
        this.txTitulo = (TextView) this.rootView.findViewById(R.id.txTitulo);
        if (getArguments() != null && getArguments().containsKey("TransferType")) {
            this.transferType = ((Integer) getArguments().getSerializable("TransferType")).intValue();
        }
        int i = this.transferType;
        if (i == 1 || i == 2) {
            this.inputLayoutSecondPhone.setVisibility(8);
            this.btnSecondContacts.setVisibility(8);
            this.inputLayoutNumeroDestinatario.setVisibility(0);
            this.btnContacts.setVisibility(0);
            this.checkBoxSendSaldo.setVisibility(0);
            if (this.transferType == 1) {
                this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_con_confirm));
            } else {
                this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_indistinta));
            }
        } else {
            this.inputLayoutSecondPhone.setVisibility(0);
            this.btnSecondContacts.setVisibility(0);
            this.inputLayoutNumeroDestinatario.setVisibility(8);
            this.btnContacts.setVisibility(8);
            this.checkBoxSendSaldo.setVisibility(8);
            this.txTitulo.setText(this.context.getString(R.string.tx_bfi_transferencia_con_solic));
        }
        loadSearchSpinnerCuentas();
        loadDrawables();
        cuentaDestinoOnListeners();
        completarQR();
        loadSearchSpinnerCategoria();
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (!accessibilityManager.isTouchExplorationEnabled()) {
            this.txCategoria.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        f1IveoSASW.this.inputLayoutCategoria.setErrorEnabled(false);
                        f1IveoSASW f1iveosasw = f1IveoSASW.this;
                        f1iveosasw.isOpenOnceOne = true;
                        f1iveosasw.spinnerDialogCategoria.showSpinerDialog();
                        return;
                    }
                    f1IveoSASW.this.isOpenOnceOne = false;
                }
            });
            this.txCategoria.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (f1IveoSASW.this.txCategoria.getText().toString().length() > 0 || f1IveoSASW.this.isOpenOnceOne) {
                        f1IveoSASW.this.inputLayoutCategoria.setErrorEnabled(false);
                        f1IveoSASW.this.spinnerDialogCategoria.showSpinerDialog();
                    }
                }
            });
        } else {
            this.txCategoria.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    f1IveoSASW.this.inputLayoutCategoria.setErrorEnabled(false);
                    f1IveoSASW.this.spinnerDialog.showSpinerDialog();
                }
            });
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f1IveoSASW.this.submitForm();
            }
        });
        if (this.inputNumeroDestinatario.getText().toString().trim().length() <= 0) {
            this.checkBoxMyPhone.setVisibility(8);
        }
        this.inputNumeroDestinatario.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (f1IveoSASW.this.inputNumeroDestinatario.getText().toString().length() > 0) {
                    f1IveoSASW.this.checkBoxMyPhone.setEnabled(true);
                    f1IveoSASW.this.checkBoxMyPhone.setVisibility(0);
                } else {
                    f1IveoSASW.this.checkBoxMyPhone.setEnabled(false);
                    f1IveoSASW.this.checkBoxMyPhone.setChecked(false);
                    f1IveoSASW.this.checkBoxMyPhone.setVisibility(8);
                }
            }
        });
        loadDataDestino();
        this.txDescripcionContacto = (TextView) this.rootView.findViewById(R.id.txDescripcionContacto);
        this.txNombreContacto = (TextView) this.rootView.findViewById(R.id.txNombreContacto);
        this.txDescripcionSecondContacto = (TextView) this.rootView.findViewById(R.id.txDescripcion_second_Contacto);
        this.txSecondNombreContacto = (TextView) this.rootView.findViewById(R.id.tx_second_NombreContacto);
        return this.rootView;
    }

    private void cuentaDestinoOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                f1IveoSASW f1iveosasw = f1IveoSASW.this;
                f1iveosasw.isConfirm = false;
                if (keyCode == 67) {
                    f1iveosasw.keyDel = 1;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.8
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                f1IveoSASW f1iveosasw = f1IveoSASW.this;
                f1iveosasw.isConfirm = false;
                if (count == 16) {
                    f1iveosasw.inputCuenta.setText(f1IveoSASW.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    f1iveosasw.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = f1iveosasw.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    f1IveoSASW.this.inputCuenta.setText(f1IveoSASW.this.cuentaCaracteres);
                    return;
                }
                f1IveoSASW f1iveosasw2 = f1IveoSASW.this;
                if (f1iveosasw2.keyDel != 0) {
                    f1iveosasw2.cuentaCaracteres = f1iveosasw2.inputCuenta.getText().toString();
                    f1IveoSASW.this.keyDel = 0;
                    return;
                }
                int length = f1iveosasw2.inputCuenta.getText().length() + 1;
                float length2 = (f1IveoSASW.this.inputCuenta.getText().length() + 1) % 5;
                if ((f1IveoSASW.this.inputCuenta.getText().length() + 1) % 5 == 0 && f1IveoSASW.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    f1IveoSASW.this.inputCuenta.setText(((Object) f1IveoSASW.this.inputCuenta.getText()) + "-");
                    f1IveoSASW.this.inputCuenta.setSelection(f1IveoSASW.this.inputCuenta.getText().length());
                }
                f1IveoSASW f1iveosasw3 = f1IveoSASW.this;
                f1iveosasw3.cuentaCaracteres = f1iveosasw3.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                f1IveoSASW f1iveosasw = f1IveoSASW.this;
                f1iveosasw.isConfirm = false;
                f1iveosasw.mostrarTarjeta(f1iveosasw.inputCuenta, f1IveoSASW.this.inputCuenta.getText().toString());
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        String monedaImporteDescripcion;
        String msg;
        this.cuentaDestino = "0000";
        this.importe = "0";
        this.movilConfirmar = "0000";
        this.enviarMiMovil = 0;
        this.enviarSaldo = 0;
        this.mensaje = "0000";
        String strTrim = this.inputCuenta.getText().toString().trim();
        this.cuentaDestino = strTrim;
        if (strTrim.contains("-")) {
            this.cuentaDestino = this.cuentaDestino.replace("-", BuildConfig.FLAVOR);
        }
        if (validateCuenta() && validateMonto()) {
            this.importe = this.inputMonto.getText().toString().trim();
            if (!validateTipoMonedaImporte() || !validateNumber() || !validateCategoria()) {
                return;
            }
            if ((this.transferType == 0 && !validateSecondPhone()) || !validateSelectionAccounts()) {
                return;
            }
            boolean isPartialUSSD = false;
            try {
                isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
            } catch (Exception e) {
            }
            if (this.checkBoxMyPhone.isChecked()) {
                this.enviarMiMovil = 1;
            }
            if (this.checkBoxSendSaldo.isChecked()) {
                this.enviarSaldo = 1;
            }
            if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
                this.movilConfirmar = this.inputNumeroDestinatario.getText().toString().trim();
            }
            if (!this.inputSecondPhone.getText().toString().trim().isEmpty()) {
                this.secondPhone = this.inputSecondPhone.getText().toString().trim();
            }
            String cadena = this.cuentaDestino + "*" + this.importe + "*" + this.monedaImporte + "*" + this.monedaTarjeta + "*" + this.secondPhone + "*" + this.cuentaOrigen + "*" + this.movilConfirmar + "*" + this.enviarMiMovil + "*" + this.enviarSaldo + "*" + this.transferType + "*" + this.categoria;
            switch (this.monedaImporte) {
                case 1:
                    monedaImporteDescripcion = "USD";
                    break;
                case 2:
                    monedaImporteDescripcion = "EUR";
                    break;
                case 3:
                    monedaImporteDescripcion = "GBP";
                    break;
                case 4:
                    monedaImporteDescripcion = "CAD";
                    break;
                case 5:
                    monedaImporteDescripcion = "CHF";
                    break;
                case 6:
                    monedaImporteDescripcion = "MXN";
                    break;
                case 7:
                    monedaImporteDescripcion = "SEK";
                    break;
                case 8:
                    monedaImporteDescripcion = "DKK";
                    break;
                case 9:
                    monedaImporteDescripcion = "NOK";
                    break;
                case 10:
                    monedaImporteDescripcion = "JPY";
                    break;
                case 11:
                    monedaImporteDescripcion = "CUP";
                    break;
                default:
                    monedaImporteDescripcion = BuildConfig.FLAVOR;
                    break;
            }
            String msgSimple = "Desea transferir " + this.importe + " " + monedaImporteDescripcion + " a la cuenta " + this.cuentaDestino;
            String msgCuentaOrigen = "Desea transferir " + this.importe + " " + monedaImporteDescripcion + " a la cuenta " + this.cuentaDestino + " desde la cuenta " + this.cuentaOrigen;
            if (this.monedaTarjeta == 0) {
                msg = msgCuentaOrigen;
            } else {
                msg = msgSimple;
            }
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            if (isPartialUSSD) {
                this.manager.principalEnviarUSSD(this.context, "110", "104", "05", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
            } else {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "104", cadena, msg, group, getFragmentManager());
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean showMonedaImporteMLCIncorrecto() {
        requestFocus(this.spinnerTipoMoneda);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
        builder.setTitle("Advertencia");
        builder.setMessage("Las cuentas de destino y origen son USD, debe especificar el importe en USD ");
        builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
        return true;
    }

    private boolean validateIsIfMonedaImporteMLC(String origen, String destino, boolean isMLCOrigen) {
        if (((isCuentaMLC(origen) && isCuentaMLC(destino)) || (isCuentaMLC(destino) && isMLCOrigen)) && this.monedaImporte != 3) {
            showMonedaImporteMLCIncorrecto();
            return false;
        }
        return true;
    }

    private boolean isCuentaMLC(String cuenta) {
        EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
        if (datosTarjeta.isValidBank && datosTarjeta.isValidCurrency && datosTarjeta.currency == qTDVwLFEjE.USD) {
            return true;
        }
        return false;
    }

    private boolean showErroTarjetaDialog() {
        if (!this.isConfirm) {
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
            builder.setTitle("Advertencia");
            builder.setMessage(this.mensajeCuentaDestino);
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    f1IveoSASW f1iveosasw = f1IveoSASW.this;
                    f1iveosasw.isConfirm = true;
                    f1iveosasw.submitForm();
                }
            });
            builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            return true;
        }
        return false;
    }

    private boolean validateCuentaDestino(String cuenta, boolean validateUSD) {
        EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
        this.mensajeCuentaDestino = BuildConfig.FLAVOR;
        if (!datosTarjeta.isValidBank) {
            this.mensajeCuentaDestino = this.context.getString(R.string.alert_msg_no_bank);
            return false;
        }
        if (this.monedaImporte == 3 || validateUSD) {
            if (!datosTarjeta.isValidCurrency) {
                this.mensajeCuentaDestino = this.context.getString(R.string.alert_msg_no_currency);
                return false;
            }
            if (datosTarjeta.currency != qTDVwLFEjE.USD) {
                this.mensajeCuentaDestino = this.context.getString(R.string.alert_msg_no_currency_mlc);
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean validateCuenta() {
        if (this.cuentaDestino.isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.cuentaDestino.length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
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

    private boolean validateTipoMonedaImporte() {
        if (this.spinnerTipoMonedaTarjeta.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMonedaImporte.setError("Seleccione");
            requestFocus(this.spinnerTipoMonedaTarjeta);
            return false;
        }
        this.inputLayoutTipoMonedaImporte.setErrorEnabled(false);
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

    private boolean validateSecondPhone() {
        if (this.inputSecondPhone.getText().toString().trim().length() != 8 && this.inputSecondPhone.getText().toString().trim().length() != 10) {
            this.inputLayoutSecondPhone.setError(this.context.getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputSecondPhone);
            return false;
        }
        this.inputLayoutSecondPhone.setErrorEnabled(false);
        return true;
    }

    private boolean validateNumber() {
        if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8 && !this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }

    private boolean validateFactura() {
        if (this.inputIdFactura.getText().toString().trim().isEmpty()) {
            this.inputLayoutIdFactura.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.inputIdFactura);
            return false;
        }
        this.inputLayoutIdFactura.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
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
                        this.inputCuenta.setText(temp);
                        this.inputCuenta.setEnabled(false);
                        this.inputLayoutCuenta.setEnabled(false);
                        this.btnSearch.setEnabled(false);
                    }
                    if (movil_confirmar.length() == 8 || movil_confirmar.length() == 10) {
                        if (movil_confirmar.length() == 10) {
                            movil_confirmar = movil_confirmar.substring(2);
                        }
                        this.inputNumeroDestinatario.setText(movil_confirmar);
                        this.checkBoxMyPhone.setEnabled(true);
                        this.checkBoxMyPhone.setVisibility(0);
                    }
                }
            }
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
                this.inputNumeroDestinatario.setText(telf2);
                this.checkBoxMyPhone.setEnabled(true);
                this.checkBoxMyPhone.setVisibility(0);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txDescripcionContacto.setVisibility(0);
                    this.txNombreContacto.setText(this.displayContact);
                    this.txNombreContacto.setVisibility(0);
                    this.displayContact = BuildConfig.FLAVOR;
                }
            }
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
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
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.TransferenciaEmpresa);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public boolean showErrorSelector() {
        this.inputLayoutTipoMoneda.setError("Seleccione una opción");
        requestFocus(this.spinnerTipoMoneda);
        return false;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.16
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
            this.inputCuenta.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.17
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        f1IveoSASW.this.inputCuenta.showDropDown();
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
                this.inputCuenta.setText(temp2);
                this.inputNumeroDestinatario.setText(cuenta.getMovil());
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
        this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.18
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in2, int position) {
                CuentaBanco cuenta = (CuentaBanco) f1IveoSASW.this.lCuentas.get(position);
                f1IveoSASW.this.inputCuenta.setText(f1IveoSASW.this.getCuentaFormateada(cuenta.getCuenta()));
                if (cuenta.getMovil() == null || cuenta.getMovil().length() <= 0 || (cuenta.getMovil().length() != 8 && cuenta.getMovil().length() != 10)) {
                    f1IveoSASW.this.inputNumeroDestinatario.setText(BuildConfig.FLAVOR);
                    f1IveoSASW.this.checkBoxMyPhone.setEnabled(false);
                } else {
                    f1IveoSASW.this.inputNumeroDestinatario.setText(cuenta.getMovil());
                    f1IveoSASW.this.checkBoxMyPhone.setEnabled(true);
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
        this.spinnerDialogCategoria.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW.19
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in, int position) {
                f1IveoSASW f1iveosasw = f1IveoSASW.this;
                f1iveosasw.categoria = position + 1;
                f1iveosasw.txCategoria.setText(uyh0pxs9m37in);
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
