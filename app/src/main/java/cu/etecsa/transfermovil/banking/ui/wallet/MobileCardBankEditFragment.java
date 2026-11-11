package cu.etecsa.transfermovil.banking.ui.wallet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.transfermovil.ui.AgentMainActivity;
import cu.etecsa.transfermovil.ui.GeneralMainActivity;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.MobileCardBank;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.core.enums.Currency;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletClassicAccountAssociationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletQrPaymentFragment;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl */
public class MobileCardBankEditFragment extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public String alias;
    private Button btn_aceptar;
    public Context context;
    public String cuenta;
    public MobileCardBank cuentaBanco;
    public String cuentaCaracteres;
    public boolean editMode;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputCuentaAlias;
    private TextInputLayout inputLayoutAlias;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputNumeroDestinatario;
    public int keyDel;
    public boolean lock;
    public String numero;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bfi;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_clasica;
    public Drawable tarjeta_clasica_emp;
    public Drawable tarjeta_metro;
    public BankType tipoBanco;
    public String[] tipomoneda;
    public int moneda = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MobileCardBankEditFragment.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arg = getArguments();
        this.context = container.getContext();
        DatabaseHelper.init(this.context);
        this.rootView = inflater.inflate(R.layout.rpmusgytsllit, container, false);
        init();
        loadDrawables();
        cuentaOrigenOnListeners();
        if (arg != null && arg.containsKey("cuenta_id")) {
            int id = Integer.parseInt(arg.get("cuenta_id").toString());
            DatabaseHelper.init(this.context);
            MobileCardBank mCBank = DatabaseHelper.getInstance().getMCBank(id);
            this.cuentaBanco = mCBank;
            if (mCBank.getMovil_notificar() != null && !this.cuentaBanco.getMovil_notificar().isEmpty()) {
                this.inputNumeroDestinatario.setText(this.cuentaBanco.getMovil_notificar());
            }
            String auxCuenta = this.cuentaBanco.getCuenta();
            this.cuenta = this.cuentaBanco.getCuenta();
            if (auxCuenta.length() == 16) {
                String temp = BuildConfig.FLAVOR;
                for (int i = 0; i < 16; i++) {
                    temp = temp + Character.toString(auxCuenta.charAt(i));
                    if ((temp.length() + 1) % 5 == 0 && temp.split("-").length <= 3) {
                        temp = temp + "-";
                    }
                }
                this.inputCuenta.setText(temp);
            }
            this.inputCuentaAlias.setText(this.cuentaBanco.getAlias());
            if (this.cuentaBanco.getAgencia() != BankType.BFI) {
                if (this.cuentaBanco.getAgencia() == BankType.MiTransfer) {
                    this.moneda = 3;
                    this.spinnerTipoMoneda.setText("USD");
                } else {
                    switch (AnonymousClass8.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[this.cuentaBanco.getTipo_moneda().ordinal()]) {
                        case 1:
                            this.moneda = 1;
                            this.spinnerTipoMoneda.setText("CUP");
                            break;
                        case 2:
                            this.moneda = 2;
                            this.spinnerTipoMoneda.setText("CUC");
                            break;
                        case 3:
                            this.moneda = 3;
                            this.spinnerTipoMoneda.setText("USD");
                            break;
                    }
                }
            } else {
                switch (AnonymousClass8.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[this.cuentaBanco.getTipo_moneda().ordinal()]) {
                    case 1:
                        this.moneda = 11;
                        this.spinnerTipoMoneda.setText("CUP");
                        break;
                    case 3:
                        this.moneda = 1;
                        this.spinnerTipoMoneda.setText("USD");
                        break;
                    case 4:
                        this.moneda = 2;
                        this.spinnerTipoMoneda.setText("EUR");
                        break;
                    case 5:
                        this.moneda = 3;
                        this.spinnerTipoMoneda.setText("GBP");
                        break;
                    case 6:
                        this.moneda = 4;
                        this.spinnerTipoMoneda.setText("CAD");
                        break;
                    case 7:
                        this.moneda = 5;
                        this.spinnerTipoMoneda.setText("CHF");
                        break;
                    case 8:
                        this.moneda = 6;
                        this.spinnerTipoMoneda.setText("MXN");
                        break;
                    case 9:
                        this.moneda = 7;
                        this.spinnerTipoMoneda.setText("SEK");
                        break;
                    case 10:
                        this.moneda = 8;
                        this.spinnerTipoMoneda.setText("DKK");
                        break;
                    case 11:
                        this.moneda = 9;
                        this.spinnerTipoMoneda.setText("NOK");
                        break;
                    case 12:
                        this.moneda = 10;
                        this.spinnerTipoMoneda.setText("JPY");
                        break;
                }
            }
            this.editMode = true;
        } else {
            this.cuentaBanco = new MobileCardBank();
        }
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency;

        static {
            int[] iArr = new int[Currency.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency = iArr;
            try {
                iArr[Currency.CUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.CUC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.USD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.EUR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.GBP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.CAD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.CHF.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.MXN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.SEK.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.DKK.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.NOK.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Currency[Currency.JPY.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public void init() {
        this.inputLayoutAlias = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_alias);
        this.inputCuentaAlias = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta_alias);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_tipo_moneda_tarjeta);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMonedaImporte);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_movil);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_movil);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btn_aceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MobileCardBankEditFragment.this.submitForm();
            }
        });
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
        Drawable drClasica = getResources().getDrawable(R.drawable.tarjeta_clasica);
        Bitmap bitmapClasica = ((BitmapDrawable) drClasica).getBitmap();
        this.tarjeta_clasica = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapClasica, 80, 60, true));
        Drawable drClasicaE = getResources().getDrawable(R.drawable.tarjeta_clasica_empresarial);
        Bitmap bitmapClasicaE = ((BitmapDrawable) drClasicaE).getBitmap();
        this.tarjeta_clasica_emp = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapClasicaE, 80, 60, true));
        Drawable drBFI = getResources().getDrawable(R.drawable.tarjeta_bfi);
        Bitmap bitmapBFI = Bitmap.createBitmap(drBFI.getIntrinsicWidth(), drBFI.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapBFI);
        drBFI.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drBFI.draw(canvas);
        this.tarjeta_bfi = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBFI, 80, 60, true));
    }

    private void cuentaOrigenOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    MobileCardBankEditFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    MobileCardBankEditFragment.this.inputCuenta.setText(MobileCardBankEditFragment.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    MobileCardBankEditFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = MobileCardBankEditFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    MobileCardBankEditFragment.this.inputCuenta.setText(MobileCardBankEditFragment.this.cuentaCaracteres);
                    return;
                }
                MobileCardBankEditFragment mEqNzldfDl = MobileCardBankEditFragment.this;
                if (mEqNzldfDl.keyDel != 0) {
                    mEqNzldfDl.cuentaCaracteres = mEqNzldfDl.inputCuenta.getText().toString();
                    MobileCardBankEditFragment.this.keyDel = 0;
                    return;
                }
                if ((mEqNzldfDl.inputCuenta.getText().length() + 1) % 5 == 0 && MobileCardBankEditFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    MobileCardBankEditFragment.this.inputCuenta.setText(((Object) MobileCardBankEditFragment.this.inputCuenta.getText()) + "-");
                    MobileCardBankEditFragment.this.inputCuenta.setSelection(MobileCardBankEditFragment.this.inputCuenta.getText().length());
                }
                MobileCardBankEditFragment mEqNzldfDl2 = MobileCardBankEditFragment.this;
                mEqNzldfDl2.cuentaCaracteres = mEqNzldfDl2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                MobileCardBankEditFragment mEqNzldfDl = MobileCardBankEditFragment.this;
                mEqNzldfDl.mostrarTarjeta(mEqNzldfDl.inputCuenta, MobileCardBankEditFragment.this.inputCuenta.getText().toString());
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b0  */
    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta) {
        int tipoBanco = 0;
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 6) {
                    switch (tarjeta.substring(5, 7)) {
                        case "12": tipoBanco = 1; break;
                        case "06": tipoBanco = 2; break;
                        case "95": tipoBanco = 3; break;
                    }
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
                    setClassicCurrencies(); tipoBanco = 4;
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
                    setClassicCurrencies(); tipoBanco = 6;
                } else {
                    switch (tarjeta.substring(0, 2)) {
                        case "12": tipoBanco = 1; break;
                        case "06": tipoBanco = 2; break;
                        case "05": tipoBanco = 3; break;
                        case "03": tipoBanco = 5; break;
                    }
                }
            }
            Drawable icon = null;
            switch (tipoBanco) {
                case 1: icon = this.tarjeta_bpa; break;
                case 2: icon = this.tarjeta_bandec; break;
                case 3: icon = this.tarjeta_metro; break;
                case 4: icon = this.tarjeta_clasica; break;
                case 5:
                    // Original smali falls through and overwrites the BFI icon below.
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, this.tarjeta_bfi, null);
                case 6: icon = this.tarjeta_clasica_emp; break;
                default: break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, icon, null);
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
    }

    private void setClassicCurrencies() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.context, R.array.currency_clasica, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = adapter;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(adapter);
    }

    public BankType getBanco(String tarjeta) {
        int tipoBanco = 0;
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92")) {
                    switch (tarjeta.substring(4, 6)) {
                        case "12": tipoBanco = 1; break;
                        case "06": tipoBanco = 2; break;
                        case "95": tipoBanco = 3; break;
                    }
                } else if (tarjeta.substring(0, 2).contains("03")) {
                    tipoBanco = 5;
                } else if (tarjeta.startsWith("976003")) {
                    tipoBanco = 4;
                } else if (tarjeta.startsWith("976004")) {
                    tipoBanco = 6;
                } else {
                    switch (tarjeta.substring(0, 2)) {
                        case "12": tipoBanco = 1; break;
                        case "06": tipoBanco = 2; break;
                        case "05": tipoBanco = 3; break;
                    }
                }
            }
            switch (tipoBanco) {
                case 1: return BankType.BPA;
                case 2: return BankType.BANDEC;
                case 3: return BankType.Metropolitano;
                case 4: return BankType.CLASICA;
                case 5: return BankType.BFI;
                case 6: return BankType.CLASICAEMP;
                default: return null;
            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            return null;
        }
    }

    public void submitForm() {
                                String strTrim = this.inputCuenta.getText().toString().trim();
                                this.cuenta = strTrim;
                                if (strTrim.contains("-")) {
                                    this.cuenta = this.cuenta.replace("-", BuildConfig.FLAVOR);
                                }
                                if (!validateCuenta(this.cuenta) || !validateTipoBanco() || !validateAlias() || !validateNumber()) {
                                    return;
                                }
                                this.alias = this.inputCuentaAlias.getText().toString().trim();
                                if (!validateTipoMoneda()) {
                                    return;
                                }
                                Currency currencyEntity = null;
                                BankType r1sDOSqZ2z = this.tipoBanco;
                                if (r1sDOSqZ2z != BankType.BFI) {
                                    if (r1sDOSqZ2z == BankType.MiTransfer || r1sDOSqZ2z == BankType.CLASICAEMP) {
                                        currencyEntity = Currency.USD;
                                    } else {
                                        switch (this.moneda) {
                                            case 1:
                                                currencyEntity = Currency.CUP;
                                                break;
                                            case 2:
                                                currencyEntity = Currency.CUC;
                                                break;
                                            case 3:
                                                currencyEntity = Currency.USD;
                                                break;
                                            default:
                                                currencyEntity = null;
                                                break;
                                        }
                                    }
                                } else {
                                    switch (this.moneda) {
                                        case 1:
                                            currencyEntity = Currency.USD;
                                            break;
                                        case 2:
                                            currencyEntity = Currency.EUR;
                                            break;
                                        case 3:
                                            currencyEntity = Currency.GBP;
                                            break;
                                        case 4:
                                            currencyEntity = Currency.CAD;
                                            break;
                                        case 5:
                                            currencyEntity = Currency.CHF;
                                            break;
                                        case 6:
                                            currencyEntity = Currency.MXN;
                                            break;
                                        case 7:
                                            currencyEntity = Currency.SEK;
                                            break;
                                        case 8:
                                            currencyEntity = Currency.DKK;
                                            break;
                                        case 9:
                                            currencyEntity = Currency.NOK;
                                            break;
                                        case 10:
                                            currencyEntity = Currency.JPY;
                                            break;
                                        case 11:
                                            currencyEntity = Currency.CUP;
                                            break;
                                    }
                                }
                                this.cuentaBanco.setCuenta(this.cuenta);
                                this.cuentaBanco.setAlias(this.alias);
                                this.cuentaBanco.setTipo_moneda(currencyEntity);
                                this.cuentaBanco.setAgencia(this.tipoBanco);
                                if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
                                    this.cuentaBanco.setMovil_notificar(this.inputNumeroDestinatario.getText().toString().trim());
                                }
                                execute_commit();
                            }

                            private void execute_commit() {
                                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                                builder.setTitle(R.string.confirm);
                                builder.setMessage(R.string.msg_reponsabilidad_cuenta_usuario);
                                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.4
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        DatabaseHelper.init(MobileCardBankEditFragment.this.context);
                                        if (MobileCardBankEditFragment.this.editMode) {
                                            DatabaseHelper.getInstance().updateMCBank(MobileCardBankEditFragment.this.cuentaBanco);
                                        } else {
                                            DatabaseHelper.getInstance().addMCBank(MobileCardBankEditFragment.this.cuentaBanco);
                                        }
                                        if (MobileCardBankEditFragment.this.getActivity() instanceof AgentMainActivity) {
                                            ((AgentMainActivity) MobileCardBankEditFragment.this.getActivity()).UpdateMenu();
                                        } else if (MobileCardBankEditFragment.this.getActivity() instanceof GeneralMainActivity) {
                                            ((GeneralMainActivity) MobileCardBankEditFragment.this.getActivity()).UpdateMenu();
                                        }
                                        if (MobileCardBankEditFragment.this.cuentaBanco.getAgencia() == BankType.MiTransfer || MobileCardBankEditFragment.this.cuentaBanco.getAgencia() == BankType.CLASICAEMP) {
                                            MobileCardBankEditFragment.this.asociarClasica();
                                        } else {
                                            MobileCardBankEditFragment.this.getFragmentManager().popBackStack();
                                        }
                                    }
                                });
                                builder.setNegativeButton("NO", null);
                                builder.show();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void asociarClasica() {
                                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                                builder.setTitle(R.string.confirm);
                                builder.setMessage(R.string.msg_shortcut_asociar_clasica);
                                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.5
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        FragmentManager mFragmentManager = MobileCardBankEditFragment.this.getActivity().getSupportFragmentManager();
                                        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                                        Bundle arg = new Bundle();
                                        arg.putSerializable("Cuenta", MobileCardBankEditFragment.this.cuentaBanco.getCuenta());
                                        arg.putSerializable("PerfilCUenta", 1);
                                        if (MobileCardBankEditFragment.this.tipoBanco == BankType.MiTransfer) {
                                            WalletClassicAccountAssociationFragment asociarClasicaBolsa = new WalletClassicAccountAssociationFragment();
                                            asociarClasicaBolsa.setArguments(arg);
                                            mFragmentTransaction.replace(R.id.containerView, asociarClasicaBolsa).addToBackStack(null).commit();
                                        } else {
                                            WalletQrPaymentFragment asociarClasicaEmpresarial = new WalletQrPaymentFragment();
                                            asociarClasicaEmpresarial.setArguments(arg);
                                            mFragmentTransaction.replace(R.id.containerView, asociarClasicaEmpresarial).addToBackStack(null).commit();
                                        }
                                    }
                                });
                                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MobileCardBankEditFragment.6
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        MobileCardBankEditFragment.this.getFragmentManager().popBackStack();
                                    }
                                });
                                builder.show();
                            }

                            private boolean validateCuenta(String cuentaOrigen) {
                                if (cuentaOrigen.isEmpty()) {
                                    this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
                                    requestFocus(this.inputCuenta);
                                    return false;
                                }
                                if (cuentaOrigen.length() != 16) {
                                    this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
                                    requestFocus(this.inputCuenta);
                                    return false;
                                }
                                if (!this.editMode) {
                                    BaseMainActivity baseActivity = new BaseMainActivity();
                                    if (DatabaseHelper.getInstance().getMiCuenta(baseActivity.encryption(this.cuenta)).size() != 0) {
                                        this.inputLayoutCuenta.setError("Cuenta ya existe");
                                        requestFocus(this.inputCuenta);
                                        return false;
                                    }
                                    this.inputLayoutCuenta.setErrorEnabled(false);
                                    return true;
                                }
                                this.inputLayoutCuenta.setErrorEnabled(false);
                                return true;
                            }

                            private boolean validateAlias() {
                                if (this.inputCuentaAlias.getText().toString().trim().isEmpty()) {
                                    this.inputLayoutAlias.setError(getString(R.string.err_msg_empty_cuenta));
                                    requestFocus(this.inputCuentaAlias);
                                    return false;
                                }
                                if (!this.editMode) {
                                    if (DatabaseHelper.getInstance().getMisCuentasAlias(this.inputCuentaAlias.getText().toString().trim()).size() != 0) {
                                        this.inputLayoutAlias.setError("Alias ya existe");
                                        requestFocus(this.inputCuentaAlias);
                                        return false;
                                    }
                                    this.inputLayoutAlias.setErrorEnabled(false);
                                    return true;
                                }
                                this.inputLayoutAlias.setErrorEnabled(false);
                                return true;
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

                            private boolean validateTipoBanco() {
                                BankType agencia = getBanco(this.cuenta);
                                if (agencia != null) {
                                    this.inputLayoutCuenta.setErrorEnabled(false);
                                    this.tipoBanco = agencia;
                                    return true;
                                }
                                this.inputLayoutCuenta.setError("Formato de tarjeta inválido");
                                requestFocus(this.inputCuenta);
                                return false;
                            }

                            private void requestFocus(View view) {
                                if (view.requestFocus()) {
                                    getActivity().getWindow().setSoftInputMode(5);
                                }
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
                        }
