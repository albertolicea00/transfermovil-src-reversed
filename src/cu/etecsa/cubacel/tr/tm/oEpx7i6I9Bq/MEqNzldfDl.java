package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class MEqNzldfDl extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public String alias;
    private Button btn_aceptar;
    public Context context;
    public String cuenta;
    public MCBank cuentaBanco;
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
    public R1sDOSqZ2z tipoBanco;
    public String[] tipomoneda;
    public int moneda = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MEqNzldfDl.this.moneda = position + 1;
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
        this.rootView = inflater.inflate(R.layout.rpmusgytsllit, container, false);
        init();
        loadDrawables();
        cuentaOrigenOnListeners();
        if (arg != null && arg.containsKey("cuenta_id")) {
            int id = Integer.parseInt(arg.get("cuenta_id").toString());
            unYp8VQThY.init(this.context);
            MCBank mCBank = unYp8VQThY.getInstance().getMCBank(id);
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
            if (this.cuentaBanco.getAgencia() != R1sDOSqZ2z.BFI) {
                if (this.cuentaBanco.getAgencia() == R1sDOSqZ2z.MiTransfer) {
                    this.moneda = 3;
                    this.spinnerTipoMoneda.setText("USD");
                } else {
                    switch (AnonymousClass8.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[this.cuentaBanco.getTipo_moneda().ordinal()]) {
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
                switch (AnonymousClass8.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[this.cuentaBanco.getTipo_moneda().ordinal()]) {
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
            this.cuentaBanco = new MCBank();
        }
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE;

        static {
            int[] iArr = new int[qTDVwLFEjE.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE = iArr;
            try {
                iArr[qTDVwLFEjE.CUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.CUC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.USD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.EUR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.GBP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.CAD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.CHF.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.MXN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.SEK.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.DKK.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.NOK.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.JPY.ordinal()] = 12;
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
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MEqNzldfDl.this.submitForm();
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
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    MEqNzldfDl.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    MEqNzldfDl.this.inputCuenta.setText(MEqNzldfDl.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    MEqNzldfDl.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = MEqNzldfDl.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    MEqNzldfDl.this.inputCuenta.setText(MEqNzldfDl.this.cuentaCaracteres);
                    return;
                }
                MEqNzldfDl mEqNzldfDl = MEqNzldfDl.this;
                if (mEqNzldfDl.keyDel != 0) {
                    mEqNzldfDl.cuentaCaracteres = mEqNzldfDl.inputCuenta.getText().toString();
                    MEqNzldfDl.this.keyDel = 0;
                    return;
                }
                if ((mEqNzldfDl.inputCuenta.getText().length() + 1) % 5 == 0 && MEqNzldfDl.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    MEqNzldfDl.this.inputCuenta.setText(((Object) MEqNzldfDl.this.inputCuenta.getText()) + "-");
                    MEqNzldfDl.this.inputCuenta.setSelection(MEqNzldfDl.this.inputCuenta.getText().length());
                }
                MEqNzldfDl mEqNzldfDl2 = MEqNzldfDl.this;
                mEqNzldfDl2.cuentaCaracteres = mEqNzldfDl2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                MEqNzldfDl mEqNzldfDl = MEqNzldfDl.this;
                mEqNzldfDl.mostrarTarjeta(mEqNzldfDl.inputCuenta, MEqNzldfDl.this.inputCuenta.getText().toString());
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
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
                    ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_clasica, android.R.layout.simple_list_item_1);
                    this.adapterTipoMoneda = arrayAdapterCreateFromResource;
                    arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
                    tipoBanco = 4;
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
                    ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.currency_clasica, android.R.layout.simple_list_item_1);
                    this.adapterTipoMoneda = arrayAdapterCreateFromResource2;
                    arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
                    tipoBanco = 6;
                } else {
                    String bancoCode = tarjeta.substring(0, 2);
                    switch (bancoCode.hashCode()) {
                        case 1539:
                            if (!bancoCode.equals("03")) {
                            }
                            break;
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
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                        Method dump skipped, instruction units count: 434
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code duplicated, block: B:11:0x0029  */
                /* JADX WARN: Code duplicated, block: B:39:0x007c  */
                public R1sDOSqZ2z getBanco(String tarjeta) {
                    int tipoBanco = 0;
                    try {
                        if (tarjeta.length() >= 2) {
                            if (tarjeta.substring(0, 2).contains("92")) {
                                switch (tarjeta.substring(4, 6)) {
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
                            } else if (tarjeta.substring(0, 2).contains("03")) {
                                tipoBanco = 5;
                            } else if (tarjeta.startsWith("976003")) {
                                tipoBanco = 4;
                            } else if (tarjeta.startsWith("976004")) {
                                tipoBanco = 6;
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
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
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
                                throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.getBanco(java.lang.String):cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z");
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
                                qTDVwLFEjE currencyEntity = null;
                                R1sDOSqZ2z r1sDOSqZ2z = this.tipoBanco;
                                if (r1sDOSqZ2z != R1sDOSqZ2z.BFI) {
                                    if (r1sDOSqZ2z == R1sDOSqZ2z.MiTransfer || r1sDOSqZ2z == R1sDOSqZ2z.CLASICAEMP) {
                                        currencyEntity = qTDVwLFEjE.USD;
                                    } else {
                                        switch (this.moneda) {
                                            case 1:
                                                currencyEntity = qTDVwLFEjE.CUP;
                                                break;
                                            case 2:
                                                currencyEntity = qTDVwLFEjE.CUC;
                                                break;
                                            case 3:
                                                currencyEntity = qTDVwLFEjE.USD;
                                                break;
                                            default:
                                                currencyEntity = null;
                                                break;
                                        }
                                    }
                                } else {
                                    switch (this.moneda) {
                                        case 1:
                                            currencyEntity = qTDVwLFEjE.USD;
                                            break;
                                        case 2:
                                            currencyEntity = qTDVwLFEjE.EUR;
                                            break;
                                        case 3:
                                            currencyEntity = qTDVwLFEjE.GBP;
                                            break;
                                        case 4:
                                            currencyEntity = qTDVwLFEjE.CAD;
                                            break;
                                        case 5:
                                            currencyEntity = qTDVwLFEjE.CHF;
                                            break;
                                        case 6:
                                            currencyEntity = qTDVwLFEjE.MXN;
                                            break;
                                        case 7:
                                            currencyEntity = qTDVwLFEjE.SEK;
                                            break;
                                        case 8:
                                            currencyEntity = qTDVwLFEjE.DKK;
                                            break;
                                        case 9:
                                            currencyEntity = qTDVwLFEjE.NOK;
                                            break;
                                        case 10:
                                            currencyEntity = qTDVwLFEjE.JPY;
                                            break;
                                        case 11:
                                            currencyEntity = qTDVwLFEjE.CUP;
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
                                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.4
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        unYp8VQThY.init(MEqNzldfDl.this.context);
                                        if (MEqNzldfDl.this.editMode) {
                                            unYp8VQThY.getInstance().updateMCBank(MEqNzldfDl.this.cuentaBanco);
                                        } else {
                                            unYp8VQThY.getInstance().addMCBank(MEqNzldfDl.this.cuentaBanco);
                                        }
                                        if (MEqNzldfDl.this.getActivity() instanceof IHVTCBmiLV) {
                                            ((IHVTCBmiLV) MEqNzldfDl.this.getActivity()).UpdateMenu();
                                        } else if (MEqNzldfDl.this.getActivity() instanceof S9ycHcoxAzy) {
                                            ((S9ycHcoxAzy) MEqNzldfDl.this.getActivity()).UpdateMenu();
                                        }
                                        if (MEqNzldfDl.this.cuentaBanco.getAgencia() == R1sDOSqZ2z.MiTransfer || MEqNzldfDl.this.cuentaBanco.getAgencia() == R1sDOSqZ2z.CLASICAEMP) {
                                            MEqNzldfDl.this.asociarClasica();
                                        } else {
                                            MEqNzldfDl.this.getFragmentManager().popBackStack();
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
                                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.5
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        FragmentManager mFragmentManager = MEqNzldfDl.this.getActivity().getSupportFragmentManager();
                                        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                                        Bundle arg = new Bundle();
                                        arg.putSerializable("Cuenta", MEqNzldfDl.this.cuentaBanco.getCuenta());
                                        arg.putSerializable("PerfilCUenta", 1);
                                        if (MEqNzldfDl.this.tipoBanco == R1sDOSqZ2z.MiTransfer) {
                                            HTmIvOo9nb asociarClasicaBolsa = new HTmIvOo9nb();
                                            asociarClasicaBolsa.setArguments(arg);
                                            mFragmentTransaction.replace(R.id.containerView, asociarClasicaBolsa).addToBackStack(null).commit();
                                        } else {
                                            l2FaHPPBDa asociarClasicaEmpresarial = new l2FaHPPBDa();
                                            asociarClasicaEmpresarial.setArguments(arg);
                                            mFragmentTransaction.replace(R.id.containerView, asociarClasicaEmpresarial).addToBackStack(null).commit();
                                        }
                                    }
                                });
                                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.MEqNzldfDl.6
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        MEqNzldfDl.this.getFragmentManager().popBackStack();
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
                                    rDEl7rW1aN baseActivity = new rDEl7rW1aN();
                                    if (unYp8VQThY.getInstance().getMiCuenta(baseActivity.encryption(this.cuenta)).size() != 0) {
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
                                    if (unYp8VQThY.getInstance().getMisCuentasAlias(this.inputCuentaAlias.getText().toString().trim()).size() != 0) {
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
                                R1sDOSqZ2z agencia = getBanco(this.cuenta);
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
