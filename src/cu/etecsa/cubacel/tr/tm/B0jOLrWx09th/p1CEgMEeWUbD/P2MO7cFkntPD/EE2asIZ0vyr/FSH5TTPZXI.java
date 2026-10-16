package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FSH5TTPZXI extends EV9Tu0zIL4 {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private ImageButton btnSearch;
    public CheckBox checkBoxMensaje;
    public CheckBox checkBoxMyPhone;
    private Uri contactUri;
    public Context context;
    public String cuentaCaracteres;
    public String cuentaDestino;
    public String cuentaOrigen;
    private List<CuentaBanco> cuentasList;
    public String displayContact;
    public int enviarMiMovil;
    public String importe;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputCuentaWrite;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutCuentaWrite;
    private TextInputLayout inputLayoutMisCuentas;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutMsg;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoMoneda;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputMsg;
    private AutoCompleteTextView inputNumeroDestinatario;
    public int keyDel;
    private List<CuentaBanco> lCuentas;
    public boolean lock;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public String mensaje;
    public String mensajeCuentaDestino;
    public List<MCBank> misCuentas;
    public int monedaImporte;
    public int monedaTarjeta;
    public String movilConfirmar;
    public View rootView;
    public jceCwl8l2R seleccionTransferencia;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerMisCuentas;
    public jN13TOyLMX spinnerTipoMoneda;
    public jN13TOyLMX spinnerTipoMonedaTarjeta;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String[] tipomoneda;
    public TextView txDescripcionContacto;
    public TextView txNombreContacto;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public boolean isConfirm = false;
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.11
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                FSH5TTPZXI.this.inputLayoutMsg.setVisibility(0);
                FSH5TTPZXI.this.inputMsg.setVisibility(0);
            } else {
                FSH5TTPZXI.this.inputLayoutMsg.setVisibility(8);
                FSH5TTPZXI.this.inputMsg.setVisibility(8);
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.12
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 3:
                    if (!FSH5TTPZXI.this.cargarMisCuentas()) {
                        FSH5TTPZXI.this.showDialogNoTieneCuentas();
                    } else {
                        FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                        fsh5ttpzxi.monedaTarjeta = 0;
                        fsh5ttpzxi.seleccionTransferencia = jceCwl8l2R.MIS_CUENTAS;
                        fsh5ttpzxi.inputLayoutMisCuentas.setVisibility(0);
                        FSH5TTPZXI.this.inputLayoutCuentaWrite.setVisibility(8);
                    }
                    break;
                case 4:
                    FSH5TTPZXI fsh5ttpzxi2 = FSH5TTPZXI.this;
                    fsh5ttpzxi2.monedaTarjeta = 0;
                    fsh5ttpzxi2.seleccionTransferencia = jceCwl8l2R.NUEVA_CUENTA;
                    fsh5ttpzxi2.inputLayoutMisCuentas.setVisibility(8);
                    FSH5TTPZXI.this.inputLayoutCuentaWrite.setVisibility(0);
                    FSH5TTPZXI fsh5ttpzxi3 = FSH5TTPZXI.this;
                    fsh5ttpzxi3.mcBankArrayAdapter = null;
                    fsh5ttpzxi3.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    FSH5TTPZXI.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    FSH5TTPZXI fsh5ttpzxi4 = FSH5TTPZXI.this;
                    fsh5ttpzxi4.seleccionTransferencia = jceCwl8l2R.MONEDA;
                    fsh5ttpzxi4.monedaTarjeta = position + 1;
                    fsh5ttpzxi4.inputLayoutMisCuentas.setVisibility(8);
                    FSH5TTPZXI.this.inputLayoutCuentaWrite.setVisibility(8);
                    FSH5TTPZXI fsh5ttpzxi5 = FSH5TTPZXI.this;
                    fsh5ttpzxi5.mcBankArrayAdapter = null;
                    fsh5ttpzxi5.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    FSH5TTPZXI.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMonedaImporte = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.13
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            FSH5TTPZXI.this.monedaImporte = position + 1;
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.14
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = FSH5TTPZXI.this.mcBankArrayAdapter.getItem(position);
            FSH5TTPZXI.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.15
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || FSH5TTPZXI.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    FSH5TTPZXI.this.busk_contactos(v);
                } else {
                    FSH5TTPZXI.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
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
        this.rootView = inflater.inflate(R.layout.wslwfon2eck7h, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.btnSearch = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        loadSearchSpinnerCuentas();
        this.btnSearch.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (unYp8VQThY.getInstance().getCuentasLists() != null && unYp8VQThY.getInstance().getCuentasLists().size() > 0) {
                    FSH5TTPZXI.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(FSH5TTPZXI.this.context);
                builder.setTitle("Notificación").setMessage("No tiene cuentas registradas. Para insertarlas debe ir a Gestión->Cuentas Banco.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).setNeutralButton("Insertar nueva", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentManager mFragmentManager = FSH5TTPZXI.this.getActivity().getSupportFragmentManager();
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
        this.inputCuentaWrite = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta_write);
        this.inputLayoutCuentaWrite = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta_write);
        this.inputLayoutMisCuentas = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_cuentas);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        this.checkBoxMyPhone = (CheckBox) this.rootView.findViewById(R.id.checkBoxMyPhone);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.checkBoxSendMsg);
        this.checkBoxMensaje = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.inputLayoutMsg = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_msg);
        this.inputMsg = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_msg);
        this.seleccionTransferencia = jceCwl8l2R.VACIO;
        this.tipomoneda = getResources().getStringArray(R.array.currency_account);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_account, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        TextInputLayout textInputLayout2 = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_tipo_moneda_importe);
        this.inputLayoutTipoMonedaImporte = textInputLayout2;
        textInputLayout2.setVisibility(0);
        this.spinnerTipoMonedaTarjeta = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMonedaImporte);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMonedaImporte = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMonedaTarjeta.setAdapter(this.adapterTipoMonedaImporte);
        this.spinnerTipoMonedaTarjeta.setOnItemClickListener(this.spClickMonedaImporte);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        loadDrawables();
        cuentaDestinoOnListeners();
        cuentaOrigenOnListeners();
        completarQR();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FSH5TTPZXI.this.submitForm();
            }
        });
        this.inputLayoutMisCuentas.setVisibility(8);
        this.inputLayoutCuentaWrite.setVisibility(8);
        this.inputLayoutMsg.setVisibility(8);
        this.checkBoxMensaje.setVisibility(8);
        if (this.inputNumeroDestinatario.getText().toString().trim().length() <= 0) {
            this.checkBoxMyPhone.setVisibility(8);
        }
        this.inputNumeroDestinatario.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (FSH5TTPZXI.this.inputNumeroDestinatario.getText().toString().length() > 0) {
                    FSH5TTPZXI.this.checkBoxMyPhone.setEnabled(true);
                    FSH5TTPZXI.this.checkBoxMyPhone.setVisibility(0);
                    return;
                }
                FSH5TTPZXI.this.checkBoxMyPhone.setEnabled(false);
                FSH5TTPZXI.this.checkBoxMyPhone.setChecked(false);
                FSH5TTPZXI.this.checkBoxMensaje.setEnabled(false);
                FSH5TTPZXI.this.checkBoxMensaje.setChecked(false);
                FSH5TTPZXI.this.inputMsg.setVisibility(8);
                FSH5TTPZXI.this.checkBoxMensaje.setVisibility(8);
                FSH5TTPZXI.this.checkBoxMyPhone.setVisibility(8);
            }
        });
        loadDataDestino();
        loadDataOrigen();
        this.txDescripcionContacto = (TextView) this.rootView.findViewById(R.id.txDescripcionContacto);
        this.txNombreContacto = (TextView) this.rootView.findViewById(R.id.txNombreContacto);
        return this.rootView;
    }

    private void loadDrawables() {
        Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_bpa);
        Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
        this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
        Drawable drBANDEC = getResources().getDrawable(R.drawable.tarjeta_bandec);
        Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
        this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
        Drawable drMETRO = getResources().getDrawable(R.drawable.tarjeta_metro);
        Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
        this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
    }

    private void cuentaDestinoOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                fsh5ttpzxi.isConfirm = false;
                if (keyCode == 67) {
                    fsh5ttpzxi.keyDel = 1;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                fsh5ttpzxi.isConfirm = false;
                if (count == 16) {
                    fsh5ttpzxi.inputCuenta.setText(FSH5TTPZXI.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    fsh5ttpzxi.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = fsh5ttpzxi.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    FSH5TTPZXI.this.inputCuenta.setText(FSH5TTPZXI.this.cuentaCaracteres);
                    return;
                }
                FSH5TTPZXI fsh5ttpzxi2 = FSH5TTPZXI.this;
                if (fsh5ttpzxi2.keyDel != 0) {
                    fsh5ttpzxi2.cuentaCaracteres = fsh5ttpzxi2.inputCuenta.getText().toString();
                    FSH5TTPZXI.this.keyDel = 0;
                    return;
                }
                int length = fsh5ttpzxi2.inputCuenta.getText().length() + 1;
                float length2 = (FSH5TTPZXI.this.inputCuenta.getText().length() + 1) % 5;
                if ((FSH5TTPZXI.this.inputCuenta.getText().length() + 1) % 5 == 0 && FSH5TTPZXI.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    FSH5TTPZXI.this.inputCuenta.setText(((Object) FSH5TTPZXI.this.inputCuenta.getText()) + "-");
                    FSH5TTPZXI.this.inputCuenta.setSelection(FSH5TTPZXI.this.inputCuenta.getText().length());
                }
                FSH5TTPZXI fsh5ttpzxi3 = FSH5TTPZXI.this;
                fsh5ttpzxi3.cuentaCaracteres = fsh5ttpzxi3.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                fsh5ttpzxi.isConfirm = false;
                fsh5ttpzxi.mostrarTarjeta(fsh5ttpzxi.inputCuenta, FSH5TTPZXI.this.inputCuenta.getText().toString());
            }
        });
    }

    private void cuentaOrigenOnListeners() {
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    FSH5TTPZXI.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    FSH5TTPZXI.this.inputCuentaWrite.setText(FSH5TTPZXI.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    FSH5TTPZXI.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = FSH5TTPZXI.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    FSH5TTPZXI.this.inputCuentaWrite.setText(FSH5TTPZXI.this.cuentaCaracteres);
                    return;
                }
                FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                if (fsh5ttpzxi.keyDel != 0) {
                    fsh5ttpzxi.cuentaCaracteres = fsh5ttpzxi.inputCuentaWrite.getText().toString();
                    FSH5TTPZXI.this.keyDel = 0;
                    return;
                }
                int length = fsh5ttpzxi.inputCuentaWrite.getText().length() + 1;
                float length2 = (FSH5TTPZXI.this.inputCuentaWrite.getText().length() + 1) % 5;
                if ((FSH5TTPZXI.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && FSH5TTPZXI.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                    FSH5TTPZXI.this.inputCuentaWrite.setText(((Object) FSH5TTPZXI.this.inputCuentaWrite.getText()) + "-");
                    FSH5TTPZXI.this.inputCuentaWrite.setSelection(FSH5TTPZXI.this.inputCuentaWrite.getText().length());
                }
                FSH5TTPZXI fsh5ttpzxi2 = FSH5TTPZXI.this;
                fsh5ttpzxi2.cuentaCaracteres = fsh5ttpzxi2.inputCuentaWrite.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                fsh5ttpzxi.mostrarTarjeta(fsh5ttpzxi.inputCuentaWrite, FSH5TTPZXI.this.inputCuentaWrite.getText().toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String monedaImporteDescripcion;
        String msg;
        this.cuentaDestino = "0000";
        this.cuentaOrigen = "0000";
        this.importe = "0";
        this.movilConfirmar = "0000";
        this.enviarMiMovil = 0;
        this.mensaje = "0000";
        String strTrim = this.inputCuenta.getText().toString().trim();
        this.cuentaDestino = strTrim;
        if (strTrim.contains("-")) {
            this.cuentaDestino = this.cuentaDestino.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta() || !validateMonto()) {
            return;
        }
        this.importe = this.inputMonto.getText().toString().trim();
        if (!validateTipoMonedaImporte()) {
            return;
        }
        switch (AnonymousClass19.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[this.seleccionTransferencia.ordinal()]) {
            case 1:
                if (!validateTipoMoneda()) {
                    return;
                }
                if (this.monedaTarjeta == 3) {
                    if ((!validateCuentaDestino(this.cuentaDestino, true) && showErroTarjetaDialog()) || !validateIsIfMonedaImporteMLC(BuildConfig.FLAVOR, this.cuentaDestino, true)) {
                        return;
                    }
                } else if (isCuentaMLC(this.cuentaDestino)) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                } else if (this.monedaImporte == 3) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                }
                break;
            case 2:
                if (!validateCuentaSpOrigen()) {
                    return;
                }
                String str = this.miCuentaSeleccion;
                this.cuentaOrigen = str;
                if (isCuentaMLC(str)) {
                    if ((!validateCuentaDestino(this.cuentaDestino, true) && showErroTarjetaDialog()) || !validateIsIfMonedaImporteMLC(this.cuentaOrigen, this.cuentaDestino, false)) {
                        return;
                    }
                } else if (isCuentaMLC(this.cuentaDestino)) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                } else if (this.monedaImporte == 3) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                }
                break;
            case 3:
                String strTrim2 = this.inputCuentaWrite.getText().toString().trim();
                this.cuentaOrigen = strTrim2;
                if (strTrim2.contains("-")) {
                    this.cuentaOrigen = this.cuentaOrigen.replace("-", BuildConfig.FLAVOR);
                }
                if (!validateCuentaNuevaOrigen(this.cuentaOrigen)) {
                    return;
                }
                if (isCuentaMLC(this.cuentaOrigen)) {
                    if ((!validateCuentaDestino(this.cuentaDestino, true) && showErroTarjetaDialog()) || !validateIsIfMonedaImporteMLC(this.cuentaOrigen, this.cuentaDestino, false)) {
                        return;
                    }
                } else if (isCuentaMLC(this.cuentaDestino)) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                } else if (this.monedaImporte == 3) {
                    this.mensajeCuentaDestino = this.context.getString(R.string.tx_no_transferir_mlc_origen_cup);
                    if (showErroTarjetaDialog()) {
                        return;
                    }
                }
                break;
            default:
                if (!showErrorSelector()) {
                    return;
                }
                break;
        }
        if (!validateNumber()) {
            return;
        }
        if (this.checkBoxMyPhone.isChecked()) {
            this.enviarMiMovil = 1;
        }
        if (this.checkBoxMensaje.isChecked()) {
            validateMensaje(this.inputMsg.getText().toString().trim());
            this.mensaje = this.inputMsg.getText().toString().trim();
        }
        if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.movilConfirmar = this.inputNumeroDestinatario.getText().toString().trim();
        }
        String cadena = this.cuentaDestino + "*" + this.importe + "*" + this.monedaImporte + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen + "*" + this.movilConfirmar + "*" + this.enviarMiMovil + "*" + this.mensaje;
        switch (this.monedaImporte) {
            case 1:
                monedaImporteDescripcion = "CUP";
                break;
            case 2:
                monedaImporteDescripcion = "CUC";
                break;
            case 3:
                monedaImporteDescripcion = "USD";
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
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "45", cadena, msg, group, getFragmentManager());
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI$19, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass19 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R;

        static {
            int[] iArr = new int[jceCwl8l2R.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R = iArr;
            try {
                iArr[jceCwl8l2R.MONEDA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jceCwl8l2R.MIS_CUENTAS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jceCwl8l2R.NUEVA_CUENTA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private boolean showMonedaImporteMLCIncorrecto() {
        requestFocus(this.spinnerTipoMoneda);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
        builder.setTitle("Advertencia");
        builder.setMessage("Las cuentas de destino y origen son USD, debe especificar el importe en USD ");
        builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.8
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
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    FSH5TTPZXI fsh5ttpzxi = FSH5TTPZXI.this;
                    fsh5ttpzxi.isConfirm = true;
                    fsh5ttpzxi.submitForm();
                }
            });
            builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.10
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
        return validateCuentaDestino(this.cuentaDestino, false) || !showErroTarjetaDialog();
    }

    private boolean validateCuentaSpOrigen() {
        if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCuentaNuevaOrigen(String cuenta) {
        if (cuenta.isEmpty()) {
            this.inputLayoutCuentaWrite.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuentaWrite);
            return false;
        }
        if (cuenta.length() != 16) {
            this.inputLayoutCuentaWrite.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuentaWrite);
            return false;
        }
        this.inputLayoutCuentaWrite.setErrorEnabled(false);
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

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione una opción");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
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

    private boolean validateNumber() {
        if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8 && !this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }

    private boolean validateMensaje(String mensaje) {
        if (mensaje.isEmpty()) {
            this.inputLayoutMsg.setError("El mensaje no puede estar vacio");
            requestFocus(this.inputMsg);
            return false;
        }
        this.inputLayoutMsg.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta) {
        int tipoBanco = 0;
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 4) {
                    switch (tarjeta.substring(5, 7)) {
                        case "12":
                            tipoBanco = 1;
                            break;
                        case "06":
                            tipoBanco = 2;
                            break;
                        case "95":
                            tipoBanco = 3;
                            break;
                    }
                } else {
                    String bancoCode = tarjeta.substring(0, 2);
                    switch (bancoCode.hashCode()) {
                        case 1541:
                            if (!bancoCode.equals("05")) {
                            }
                            break;
                        case 1542:
                            if (!bancoCode.equals("06")) {
                            }
                            break;
                        case 1569:
                            if (!bancoCode.equals("12")) {
                            }
                            break;
                        default:
                            break;
                    }
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Switch insn not found in header
                        	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        */
                    /*
                        Method dump skipped, instruction units count: 222
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                public boolean cargarMisCuentas() {
                    try {
                        List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.BFI);
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
                    arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                    arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
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

                private boolean showErrorSelector() {
                    this.inputLayoutTipoMoneda.setError("Seleccione una opción");
                    requestFocus(this.spinnerTipoMoneda);
                    return false;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void showDialogNoTieneCuentas() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setTitle("Aviso");
                    builder.setMessage("No tiene cuentas registradas para este banco");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.16
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
                        this.inputCuenta.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.17
                            @Override // android.view.View.OnFocusChangeListener
                            public void onFocusChange(View view, boolean hasFocus) {
                                if (hasFocus) {
                                    FSH5TTPZXI.this.inputCuenta.showDropDown();
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

                private void loadDataOrigen() {
                    Bundle arg = getArguments();
                    if (arg != null && arg.containsKey("cuenta_origen_id")) {
                        try {
                            int id = arg.getInt("cuenta_origen_id");
                            MCBank cuentaMC = unYp8VQThY.getInstance().getMCBank(id);
                            this.monedaTarjeta = 0;
                            this.seleccionTransferencia = jceCwl8l2R.MIS_CUENTAS;
                            this.spinnerTipoMoneda.setText("-MIS CUENTAS-");
                            this.inputLayoutMisCuentas.setVisibility(0);
                            this.inputLayoutCuentaWrite.setVisibility(8);
                            cargarMisCuentas();
                            this.spinnerMisCuentas.setText(cuentaMC.toString());
                            this.miCuentaSeleccion = cuentaMC.getCuenta();
                        } catch (Exception e) {
                        }
                    }
                }

                private void loadSearchSpinnerCuentas() {
                    List<CuentaBanco> cuentasLists = unYp8VQThY.getInstance().getCuentasLists();
                    this.lCuentas = cuentasLists;
                    if (cuentasLists != null && cuentasLists.size() > 0) {
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
                    this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI.18
                        @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                        public void onClick(String uyh0pxs9m37in2, int position) {
                            CuentaBanco cuenta = (CuentaBanco) FSH5TTPZXI.this.lCuentas.get(position);
                            FSH5TTPZXI.this.inputCuenta.setText(FSH5TTPZXI.this.getCuentaFormateada(cuenta.getCuenta()));
                            if (cuenta.getMovil() == null || cuenta.getMovil().length() <= 0 || (cuenta.getMovil().length() != 8 && cuenta.getMovil().length() != 10)) {
                                FSH5TTPZXI.this.inputNumeroDestinatario.setText(BuildConfig.FLAVOR);
                                FSH5TTPZXI.this.checkBoxMyPhone.setEnabled(false);
                            } else {
                                FSH5TTPZXI.this.inputNumeroDestinatario.setText(cuenta.getMovil());
                                FSH5TTPZXI.this.checkBoxMyPhone.setEnabled(true);
                            }
                        }
                    });
                }
            }
