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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Empresa;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class H0oV6Ot0bS extends EV9Tu0zIL4 implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    public Empresa agencia;
    public List<Empresa> agenciasList;
    private R1sDOSqZ2z agency;
    private String agencyCode;
    private ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox checkBoxMyPhone;
    private Uri contactUri;
    public Context context;
    public String cuenta;
    public String cuentaCaracteres;
    private List<CuentaBanco> cuentasList;
    public String displayContact;
    public int enviarMiMovil;
    private AutoCompleteTextView inputClave;
    private TextInputLayout inputLayoutClave;
    public boolean isWithPin;
    public int keyDel;
    private List<CuentaBanco> lCuentas;
    public boolean lock;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyCuenta;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lyPhoneConfirm;
    public pAzq93vIl3 manager;
    public String mensajeCuentaDestino;
    public String mensajeCuentaOrigen;
    public View rootView;
    public jN13TOyLMX spBolsas;
    private jN13TOyLMX spMonedaImporte;
    public SpinnerDialog spinnerDialog;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    private AutoCompleteTextView txCuenta;
    public TextView txDescripcionContacto;
    private AutoCompleteTextView txMonto;
    public TextView txNombreContacto;
    private AutoCompleteTextView txPhoneConfirm;
    public ArrayList<String> items = new ArrayList<>();
    private String phoneConfirm = "0000";
    public int tipoBolsa = 0;
    public String monedaBolsa = BuildConfig.FLAVOR;
    public boolean isConfirm = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            H0oV6Ot0bS h0oV6Ot0bS = H0oV6Ot0bS.this;
            h0oV6Ot0bS.tipoBolsa = position + 1;
            if (position == 0) {
                h0oV6Ot0bS.spMonedaImporte.setText("USD");
                H0oV6Ot0bS.this.monedaBolsa = "USD";
            } else if (position == 1) {
                h0oV6Ot0bS.spMonedaImporte.setText("CUP");
                H0oV6Ot0bS.this.monedaBolsa = "CUP";
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || H0oV6Ot0bS.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    H0oV6Ot0bS.this.busk_contactos(v);
                } else {
                    H0oV6Ot0bS.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ag3owic0hbnoo, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.lyClave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.txClave);
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputClave.setFilters(fArray);
        if (Build.VERSION.SDK_INT >= 26) {
            this.inputClave.setImportantForAutofill(2);
        }
        this.inputLayoutClave.setVisibility(8);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            Bundle arg = getArguments();
            this.agency = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
            this.isWithPin = true;
            this.agencyCode = "04";
            this.inputLayoutClave.setVisibility(0);
        }
        this.lyCuenta = (TextInputLayout) this.rootView.findViewById(R.id.lyCuenta);
        this.txCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCuenta);
        this.btSearchAccount = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        loadSearchSpinnerCuentas();
        initSeparator();
        this.btSearchAccount.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (unYp8VQThY.getInstance().getCuentasLists() != null && unYp8VQThY.getInstance().getCuentasLists().size() > 0) {
                    H0oV6Ot0bS.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(H0oV6Ot0bS.this.context);
                builder.setTitle("Notificación").setMessage("No tiene cuentas registradas. Para insertarlas debe ir a Gestión->Cuentas Banco.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).setNeutralButton("Insertar nueva", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentManager mFragmentManager = H0oV6Ot0bS.this.getActivity().getSupportFragmentManager();
                        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                        oaEWezaNAI editTarjeta = new oaEWezaNAI();
                        mFragmentTransaction.replace(R.id.containerView, editTarjeta).addToBackStack(null).commit();
                    }
                });
                builder.show();
            }
        });
        loadAgencias();
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.lyMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyMonedaImporte);
        this.spMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spMonedaImporte);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_no_cuc, android.R.layout.simple_list_item_1);
        this.adapterTipoMonedaImporte = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMonedaImporte.setAdapter(this.adapterTipoMonedaImporte);
        jN13TOyLMX jn13toylmx = this.spMonedaImporte;
        jn13toylmx.setOnItemClickListener(jn13toylmx);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txPhoneConfirm = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (H0oV6Ot0bS.this.txPhoneConfirm.getText().toString().length() > 0) {
                    H0oV6Ot0bS.this.checkBoxMyPhone.setEnabled(true);
                    H0oV6Ot0bS.this.checkBoxMyPhone.setVisibility(0);
                } else {
                    H0oV6Ot0bS.this.checkBoxMyPhone.setEnabled(false);
                    H0oV6Ot0bS.this.checkBoxMyPhone.setChecked(false);
                    H0oV6Ot0bS.this.checkBoxMyPhone.setVisibility(8);
                }
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.checkBoxMyPhone);
        this.checkBoxMyPhone = checkBox;
        checkBox.setEnabled(true);
        if (this.txPhoneConfirm.getText().toString().trim().length() <= 0) {
            this.checkBoxMyPhone.setVisibility(8);
        }
        this.txNombreContacto = (TextView) this.rootView.findViewById(R.id.txNombreContacto);
        this.txNombreContacto = (TextView) this.rootView.findViewById(R.id.txDescripcionContacto);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                H0oV6Ot0bS.this.submitForm();
            }
        });
        completarQR();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem itemToHide = menu.findItem(R.id.qrsgen);
        itemToHide.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.BOLSATransferirBancos);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
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
                        this.txCuenta.setText(temp);
                        this.txCuenta.setEnabled(false);
                        this.lyCuenta.setEnabled(false);
                        this.btSearchAccount.setEnabled(false);
                    }
                    if (movil_confirmar.length() == 8 || movil_confirmar.length() == 10) {
                        if (movil_confirmar.length() == 10) {
                            movil_confirmar = movil_confirmar.substring(2);
                        }
                        this.txPhoneConfirm.setText(movil_confirmar);
                        this.checkBoxMyPhone.setEnabled(true);
                        this.checkBoxMyPhone.setVisibility(0);
                    }
                }
            }
        }
    }

    private boolean loadAgencias() {
        try {
            this.agenciasList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<Empresa> list = jsonFilesManager.loadDataAgencias(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (Empresa uyh0pxs9m37in : list) {
                this.agenciasList.add(uyh0pxs9m37in);
            }
            return true;
        } catch (Exception e) {
            return false;
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
        this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.4
            @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
            public void onClick(String uyh0pxs9m37in2, int position) {
                CuentaBanco cuenta = (CuentaBanco) H0oV6Ot0bS.this.lCuentas.get(position);
                H0oV6Ot0bS.this.txCuenta.setText(H0oV6Ot0bS.this.getCuentaFormateada(cuenta.getCuenta()));
                if (cuenta.getMovil() == null || cuenta.getMovil().length() <= 0 || (cuenta.getMovil().length() != 8 && cuenta.getMovil().length() != 10)) {
                    H0oV6Ot0bS.this.txPhoneConfirm.setText(BuildConfig.FLAVOR);
                } else {
                    H0oV6Ot0bS.this.txPhoneConfirm.setText(cuenta.getMovil());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String msg;
        String cadenaInicio = BuildConfig.FLAVOR;
        if (this.isWithPin) {
            if (!validateClave()) {
                return;
            }
            cadenaInicio = this.agencyCode + "*" + this.inputClave.getText().toString().trim() + "*";
        }
        if (!validateCuenta() || !validateMonto()) {
            return;
        }
        String importe = this.txMonto.getText().toString().trim();
        if (!validateSpBolsa()) {
            return;
        }
        if (this.checkBoxMyPhone.isChecked()) {
            this.enviarMiMovil = 1;
        }
        String cuentaDestino = this.txCuenta.getText().toString();
        String cuentaDestino2 = cuentaDestino.contains("-") ? cuentaDestino.replace("-", BuildConfig.FLAVOR) : cuentaDestino;
        if (!this.txPhoneConfirm.getText().toString().trim().isEmpty() && (this.txPhoneConfirm.getText().toString().length() == 8 || this.txPhoneConfirm.getText().toString().length() == 10)) {
            this.phoneConfirm = this.txPhoneConfirm.getText().toString().trim();
        }
        if (!this.isConfirm && !validateMonedasDistintas()) {
            showErroTarjetaDialog();
            return;
        }
        String cadena = cadenaInicio + (this.agencia.getCode() + "*" + cuentaDestino2 + "*" + importe + "*" + this.spMonedaImporte.getText().toString() + "*" + this.phoneConfirm + "*" + this.enviarMiMovil + "*" + this.tipoBolsa);
        String msg2 = "Desea transferir " + importe + " " + this.spMonedaImporte.getText().toString() + " a la cuenta del número " + cuentaDestino2;
        if (isCuentaMLC(cuentaDestino2) && !this.spMonedaImporte.getText().toString().contains("USD")) {
            String msg3 = "Desea transferir " + importe + " " + this.spMonedaImporte.getText().toString() + " a la cuenta del número " + cuentaDestino2 + ". Advertencia:Usted esta tratando de transferir desde su cuenta CUP a una cuenta de bancaria de tipo MLC, es posible que falle esta operación, revise antes de continuar.";
            msg = msg3;
        } else {
            msg = msg2;
        }
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "16", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else if (!this.isWithPin) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "16", cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBackWithRetun(this.context, "16", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        String cuentaDest = this.txCuenta.getText().toString();
        if (cuentaDest.contains("-")) {
            cuentaDest = cuentaDest.replace("-", BuildConfig.FLAVOR);
        }
        if (cuentaDest.isEmpty()) {
            this.lyCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCuenta);
            return false;
        }
        if (cuentaDest.length() != 16) {
            this.lyCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.txCuenta);
            return false;
        }
        this.lyCuenta.setErrorEnabled(false);
        if (!validateCuentaOrigen(cuentaDest.toString()) && !this.isConfirm) {
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
            builder.setTitle("Advertencia");
            builder.setMessage(this.mensajeCuentaOrigen);
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    H0oV6Ot0bS h0oV6Ot0bS = H0oV6Ot0bS.this;
                    h0oV6Ot0bS.isConfirm = true;
                    h0oV6Ot0bS.submitForm();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            return false;
        }
        return true;
    }

    private boolean validateCuentaOrigen(String cuenta) {
        EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
        this.mensajeCuentaOrigen = BuildConfig.FLAVOR;
        if (!datosTarjeta.isValidBank) {
            this.mensajeCuentaOrigen = this.context.getString(R.string.alert_msg_no_bank);
            return false;
        }
        return true;
    }

    private boolean validateMonto() {
        String montoStr = this.txMonto.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.lyMonto.setError("No se permiten ceros a la izquierda");
            requestFocus(this.txMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.lyMonto.setError("Formato de monto inválido");
            requestFocus(this.txMonto);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.lyMonto.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.txMonto);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.lyMonto.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.txMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.lyMonto.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.txMonto);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.lyMonto.setError("El monto debe ser mayor a 0");
            requestFocus(this.txMonto);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.lyMonto.setError("El monto debe ser mayor a 0");
                requestFocus(this.txMonto);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.lyMonto.setError("Monto inválido");
            requestFocus(this.txMonto);
            return false;
        }
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public boolean validateMonedasDistintas() {
        String cuentaDestino = this.txCuenta.getText().toString();
        if (cuentaDestino.contains("-")) {
            cuentaDestino = cuentaDestino.replace("-", BuildConfig.FLAVOR);
        }
        String monedaImporte = this.spMonedaImporte.getText().toString();
        return validateCuentaDestino(cuentaDestino, monedaImporte, this.monedaBolsa.contains("USD"));
    }

    private void initSeparator() {
        loadDrawables();
        cuentaOnListeners();
    }

    private void loadDrawables() {
        try {
            Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_bpa);
            Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
            this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
            Drawable drBANDEC = getResources().getDrawable(R.drawable.tarjeta_bandec);
            Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
            this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
            Drawable drMETRO = getResources().getDrawable(R.drawable.tarjeta_metro);
            Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
            this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.txCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        H0oV6Ot0bS.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.txCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.10
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (count == 16) {
                        H0oV6Ot0bS.this.txCuenta.setText(H0oV6Ot0bS.this.getCuentaFormateada(s.toString()));
                        return;
                    }
                    if (count == 0) {
                        H0oV6Ot0bS.this.keyDel = 1;
                    }
                    boolean flag = true;
                    String[] eachBlock = H0oV6Ot0bS.this.txCuenta.getText().toString().split("-");
                    for (String str : eachBlock) {
                        if (str.length() > 4) {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        H0oV6Ot0bS.this.txCuenta.setText(H0oV6Ot0bS.this.cuentaCaracteres);
                        return;
                    }
                    H0oV6Ot0bS h0oV6Ot0bS = H0oV6Ot0bS.this;
                    if (h0oV6Ot0bS.keyDel != 0) {
                        h0oV6Ot0bS.cuentaCaracteres = h0oV6Ot0bS.txCuenta.getText().toString();
                        H0oV6Ot0bS.this.keyDel = 0;
                        return;
                    }
                    int length = h0oV6Ot0bS.txCuenta.getText().length() + 1;
                    float length2 = (H0oV6Ot0bS.this.txCuenta.getText().length() + 1) % 5;
                    if ((H0oV6Ot0bS.this.txCuenta.getText().length() + 1) % 5 == 0 && H0oV6Ot0bS.this.txCuenta.getText().toString().split("-").length <= 3) {
                        H0oV6Ot0bS.this.txCuenta.setText(((Object) H0oV6Ot0bS.this.txCuenta.getText()) + "-");
                        H0oV6Ot0bS.this.txCuenta.setSelection(H0oV6Ot0bS.this.txCuenta.getText().length());
                    }
                    H0oV6Ot0bS h0oV6Ot0bS2 = H0oV6Ot0bS.this;
                    h0oV6Ot0bS2.cuentaCaracteres = h0oV6Ot0bS2.txCuenta.getText().toString();
                } catch (Exception ex) {
                    Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                H0oV6Ot0bS h0oV6Ot0bS = H0oV6Ot0bS.this;
                h0oV6Ot0bS.mostrarTarjeta(h0oV6Ot0bS.txCuenta, H0oV6Ot0bS.this.txCuenta.getText().toString());
            }
        });
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
                            if (bancoCode.equals("05")) {
                            }
                            break;
                        case 1542:
                            if (bancoCode.equals("06")) {
                            }
                            break;
                        case 1569:
                            if (bancoCode.equals("12")) {
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
                        Method dump skipped, instruction units count: 258
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
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

                private boolean showMonedaImporteIncorrecto(String monedaIncorrecta, String monedaCorrecta) {
                    requestFocus(this.spMonedaImporte);
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                    builder.setTitle("Advertencia");
                    builder.setMessage("La cuenta de destino es en " + monedaCorrecta + " y el importe especificado es en" + monedaIncorrecta + ", debe especificar el importe en " + monedaCorrecta);
                    builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                    return false;
                }

                private boolean showMonedaBolsaIncorrecto(String monedaIncorrecta, String monedaCorrecta) {
                    requestFocus(this.spMonedaImporte);
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                    builder.setTitle("Advertencia");
                    builder.setMessage("La cuenta de destino es en " + monedaCorrecta + " y la cuenta MiTransfer seleccionada es en" + monedaIncorrecta + ", debe selecionar la cuenta " + monedaCorrecta);
                    builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.12
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                    return false;
                }

                private boolean isCuentaMLC(String cuenta) {
                    EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
                    if (datosTarjeta.isValidBank && datosTarjeta.isValidCurrency && datosTarjeta.currency == qTDVwLFEjE.USD) {
                        return true;
                    }
                    return false;
                }

                private boolean showErroTarjetaDialog() {
                    if (this.isConfirm) {
                        return true;
                    }
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                    builder.setTitle("Advertencia");
                    builder.setMessage(this.mensajeCuentaDestino);
                    builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.13
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            H0oV6Ot0bS h0oV6Ot0bS = H0oV6Ot0bS.this;
                            h0oV6Ot0bS.isConfirm = true;
                            h0oV6Ot0bS.submitForm();
                        }
                    });
                    builder.setNegativeButton("Revisar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS.14
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                    return true;
                }

                private boolean validateCuentaDestino(String cuenta, String monedaImp, boolean validateUSD) {
                    EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
                    this.mensajeCuentaDestino = BuildConfig.FLAVOR;
                    if (!datosTarjeta.isValidBank) {
                        this.mensajeCuentaDestino = this.context.getString(R.string.alert_msg_no_bank);
                        return false;
                    }
                    if (monedaImp == "USD" || validateUSD) {
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
                            this.txNombreContacto.setVisibility(0);
                            this.txNombreContacto.setText(this.displayContact);
                            this.displayContact = BuildConfig.FLAVOR;
                            return;
                        }
                        this.txNombreContacto.setVisibility(8);
                    } catch (Exception e) {
                        this.displayContact = BuildConfig.FLAVOR;
                        this.txNombreContacto.setVisibility(8);
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

                private boolean validateClave() {
                    if (this.inputClave.getText().toString().trim().isEmpty()) {
                        this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clave_bolsa));
                        requestFocus(this.inputClave);
                        return false;
                    }
                    if (this.inputClave.getText().toString().trim().length() != 4) {
                        this.inputLayoutClave.setError(getString(R.string.err_msg_len_newpin_bolsa));
                        requestFocus(this.inputClave);
                        return false;
                    }
                    this.inputLayoutClave.setErrorEnabled(false);
                    return true;
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
