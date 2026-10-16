package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Agg55uYctq extends EV9Tu0zIL4 implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public R1sDOSqZ2z bancoEntity;
    public Context context;
    public String cuentaCaracteres;
    public String cuentaOrigen;
    public ConstraintLayout frmCuentasLista;
    public AutoCompleteTextView inputCuentaWrite;
    public TextInputLayout inputLayoutCuentaWrite;
    public TextInputLayout inputLayoutMisCuentas;
    public TextInputLayout inputLayoutTipoMoneda;
    public int keyDel;
    public boolean lock;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public String mensajeCuentaOrigen;
    public List<MCBank> misCuentas;
    public int monedaTarjeta;
    public View rootView;
    public jceCwl8l2R seleccionCuenta;
    public jN13TOyLMX spinnerMisCuentas;
    public jN13TOyLMX spinnerTipoMoneda;
    public Switch swCuentasBanco;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bfi;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String[] tipomoneda;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 3:
                    if (Agg55uYctq.this.cargarMisCuentas()) {
                        Agg55uYctq agg55uYctq = Agg55uYctq.this;
                        agg55uYctq.monedaTarjeta = 0;
                        agg55uYctq.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        agg55uYctq.inputLayoutMisCuentas.setVisibility(0);
                        Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                        Agg55uYctq.this.inputLayoutMisCuentas.setVisibility(8);
                        Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(8);
                    }
                    break;
                case 4:
                    Agg55uYctq agg55uYctq2 = Agg55uYctq.this;
                    agg55uYctq2.monedaTarjeta = 0;
                    agg55uYctq2.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    agg55uYctq2.inputLayoutMisCuentas.setVisibility(8);
                    Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(0);
                    Agg55uYctq agg55uYctq3 = Agg55uYctq.this;
                    agg55uYctq3.mcBankArrayAdapter = null;
                    agg55uYctq3.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Agg55uYctq.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    Agg55uYctq agg55uYctq4 = Agg55uYctq.this;
                    agg55uYctq4.seleccionCuenta = jceCwl8l2R.MONEDA;
                    agg55uYctq4.monedaTarjeta = position + 1;
                    agg55uYctq4.inputLayoutMisCuentas.setVisibility(8);
                    Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(8);
                    Agg55uYctq agg55uYctq5 = Agg55uYctq.this;
                    agg55uYctq5.mcBankArrayAdapter = null;
                    agg55uYctq5.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Agg55uYctq.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Agg55uYctq.this.context);
            builder.setTitle(Agg55uYctq.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(Agg55uYctq.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.4.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = Agg55uYctq.this.mcBankArrayAdapter.getItem(position);
            Agg55uYctq.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };
    public boolean isConfirm = false;

    public abstract void nuevoDatos();

    public void initComponentesCuentas(View rootView, R1sDOSqZ2z agencia) {
        this.bancoEntity = agencia;
        this.seleccionCuenta = jceCwl8l2R.VACIO;
        this.cuentaOrigen = "0000";
        this.tipomoneda = getResources().getStringArray(R.array.currency_account);
        TextInputLayout textInputLayout = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_account, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        this.inputCuentaWrite = (AutoCompleteTextView) rootView.findViewById(R.id.input_cuenta_write);
        this.inputLayoutCuentaWrite = (TextInputLayout) rootView.findViewById(R.id.input__layout_cuenta_write);
        this.inputLayoutMisCuentas = (TextInputLayout) rootView.findViewById(R.id.input_layout_cuentas);
        this.spinnerMisCuentas = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCuentas);
        this.inputLayoutMisCuentas.setVisibility(8);
        this.inputLayoutCuentaWrite.setVisibility(8);
        Switch r0 = (Switch) rootView.findViewById(R.id.swCuentasBanco);
        this.swCuentasBanco = r0;
        R1sDOSqZ2z r1sDOSqZ2z = this.bancoEntity;
        if (r1sDOSqZ2z != null && r1sDOSqZ2z == R1sDOSqZ2z.BANDEC) {
            this.inputLayoutTipoMoneda.setVisibility(8);
            this.swCuentasBanco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Agg55uYctq.this.inputLayoutMisCuentas.setVisibility(8);
                    Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(8);
                    if (b) {
                        Agg55uYctq.this.showDialogCuentas();
                        return;
                    }
                    Agg55uYctq agg55uYctq = Agg55uYctq.this;
                    agg55uYctq.swCuentasBanco.setText(agg55uYctq.context.getString(R.string.tx_habilitar_uso_de_cuentas_origen));
                    Agg55uYctq.this.seleccionCuenta = jceCwl8l2R.VACIO;
                }
            });
        } else {
            r0.setVisibility(8);
        }
        loadDrawables();
        cuentaOrigenOnListeners();
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
    }

    public void submitForm() {
        this.cuentaOrigen = "0000";
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq$14, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass14 {
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

    public boolean validateSelectionAccounts() {
        if (this.bancoEntity != R1sDOSqZ2z.BANDEC || this.swCuentasBanco.isChecked()) {
            switch (AnonymousClass14.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[this.seleccionCuenta.ordinal()]) {
                case 1:
                    return validateTipoMoneda();
                case 2:
                    if (!validateCuentaSpOrigen()) {
                        return false;
                    }
                    this.cuentaOrigen = this.miCuentaSeleccion;
                    return true;
                case 3:
                    String strTrim = this.inputCuentaWrite.getText().toString().trim();
                    this.cuentaOrigen = strTrim;
                    if (strTrim.contains("-")) {
                        this.cuentaOrigen = this.cuentaOrigen.replace("-", BuildConfig.FLAVOR);
                    }
                    return validateCuentaNuevaOrigen(this.cuentaOrigen);
                default:
                    return showErrorSelector();
            }
        }
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    Agg55uYctq.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    Agg55uYctq agg55uYctq = Agg55uYctq.this;
                    agg55uYctq.inputCuentaWrite.setText(agg55uYctq.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    Agg55uYctq.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = Agg55uYctq.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    Agg55uYctq agg55uYctq2 = Agg55uYctq.this;
                    if (agg55uYctq2.keyDel == 0) {
                        int length = agg55uYctq2.inputCuentaWrite.getText().length() + 1;
                        float length2 = (Agg55uYctq.this.inputCuentaWrite.getText().length() + 1) % 5;
                        if ((Agg55uYctq.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && Agg55uYctq.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                            Agg55uYctq.this.inputCuentaWrite.setText(((Object) Agg55uYctq.this.inputCuentaWrite.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = Agg55uYctq.this.inputCuentaWrite;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        Agg55uYctq agg55uYctq3 = Agg55uYctq.this;
                        agg55uYctq3.cuentaCaracteres = agg55uYctq3.inputCuentaWrite.getText().toString();
                        return;
                    }
                    agg55uYctq2.cuentaCaracteres = agg55uYctq2.inputCuentaWrite.getText().toString();
                    Agg55uYctq.this.keyDel = 0;
                    return;
                }
                Agg55uYctq agg55uYctq4 = Agg55uYctq.this;
                agg55uYctq4.inputCuentaWrite.setText(agg55uYctq4.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Agg55uYctq agg55uYctq = Agg55uYctq.this;
                AutoCompleteTextView autoCompleteTextView = agg55uYctq.inputCuentaWrite;
                agg55uYctq.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
            }
        });
    }

    public void loadDrawables() {
        Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_bpa);
        Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
        this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
        Drawable drBANDEC = getResources().getDrawable(R.drawable.tarjeta_bandec);
        Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
        this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
        Drawable drMETRO = getResources().getDrawable(R.drawable.tarjeta_metro);
        Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
        this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
        Drawable drBFI = getResources().getDrawable(R.drawable.tarjeta_bfi);
        Bitmap bitmapBFI = Bitmap.createBitmap(drBFI.getIntrinsicWidth(), drBFI.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapBFI);
        drBFI.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drBFI.draw(canvas);
        this.tarjeta_bfi = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBFI, 80, 60, true));
    }

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
                        Method dump skipped, instruction units count: 252
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                public boolean cargarMisCuentas() {
                    try {
                        List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(this.bancoEntity);
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

                public boolean validateCuentaSpOrigen() {
                    if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
                        this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
                        requestFocus(this.spinnerMisCuentas);
                        return false;
                    }
                    this.inputLayoutMisCuentas.setErrorEnabled(false);
                    if (!validateCuentaOrigen(this.miCuentaSeleccion) && !this.isConfirm) {
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                        builder.setTitle("Advertencia");
                        builder.setMessage(this.mensajeCuentaOrigen);
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                Agg55uYctq agg55uYctq = Agg55uYctq.this;
                                agg55uYctq.isConfirm = true;
                                agg55uYctq.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.show();
                        return false;
                    }
                    return true;
                }

                public boolean validateCuentaNuevaOrigen(String cuenta) {
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
                    if (!validateCuentaOrigen(this.cuentaOrigen) && !this.isConfirm) {
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                        builder.setTitle("Advertencia");
                        builder.setMessage(this.mensajeCuentaOrigen);
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                Agg55uYctq agg55uYctq = Agg55uYctq.this;
                                agg55uYctq.isConfirm = true;
                                agg55uYctq.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.9
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

                public boolean showErrorSelector() {
                    this.inputLayoutTipoMoneda.setError("Seleccione una opción");
                    requestFocus(this.spinnerTipoMoneda);
                    return false;
                }

                public boolean validateTipoMoneda() {
                    if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
                        this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
                        requestFocus(this.spinnerTipoMoneda);
                        return false;
                    }
                    this.inputLayoutTipoMoneda.setErrorEnabled(false);
                    return true;
                }

                public void showDialogCuentas() {
                    CharSequence[] items = {"Insertar cuenta", "Listar mis cuentas"};
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                    builder.setTitle("Seleccione:");
                    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    Agg55uYctq agg55uYctq = Agg55uYctq.this;
                                    agg55uYctq.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                                    agg55uYctq.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                    Agg55uYctq.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                    Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(0);
                                    Agg55uYctq.this.inputLayoutMisCuentas.setVisibility(8);
                                    Agg55uYctq agg55uYctq2 = Agg55uYctq.this;
                                    agg55uYctq2.mcBankArrayAdapter = null;
                                    agg55uYctq2.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                                    Agg55uYctq.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                                    dialogInterface.dismiss();
                                    break;
                                case 1:
                                    if (Agg55uYctq.this.cargarMisCuentas()) {
                                        Agg55uYctq agg55uYctq3 = Agg55uYctq.this;
                                        agg55uYctq3.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                                        agg55uYctq3.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                        Agg55uYctq.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                        Agg55uYctq.this.inputLayoutCuentaWrite.setVisibility(8);
                                        Agg55uYctq.this.inputLayoutMisCuentas.setVisibility(0);
                                    } else {
                                        Agg55uYctq.this.showDialogNoTieneCuentas();
                                        Agg55uYctq.this.swCuentasBanco.setChecked(false);
                                    }
                                    dialogInterface.dismiss();
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                            Agg55uYctq.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.12
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            Agg55uYctq.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                }

                public void showDialogNoTieneCuentas() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setTitle("Aviso");
                    builder.setMessage("No tiene cuentas registradas para este banco");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq.13
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
