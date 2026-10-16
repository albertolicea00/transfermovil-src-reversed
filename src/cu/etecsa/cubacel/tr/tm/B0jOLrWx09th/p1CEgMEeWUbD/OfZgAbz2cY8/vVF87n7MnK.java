package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalBancaria;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vVF87n7MnK extends Fragment {
    public ArrayAdapter<CharSequence> adapterMotivo;
    public Button btnAceptar;
    public Context context;
    public String cuenta;
    public String cuentaCaracteres;
    public String descripcion;
    public AutoCompleteTextView inputCuenta;
    public AutoCompleteTextView inputDescripcion;
    public TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutDescripcion;
    public V9s8rJIDplX jsonFilesManager;
    public int keyDel;
    public boolean lock;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyProvincia;
    private TextInputLayout lySucursal;
    public int motivo;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public View rootView;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private jN13TOyLMX spSucursal;
    public jN13TOyLMX spinnerMotivo;
    public SucursalBancaria sucursal;
    public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    public List<SucursalBancaria> sucursalList;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String[] tipomoneda;
    public String toolbar_title;
    private jN13TOyLMX.OnItemClickListener spClickMotivos = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            vVF87n7MnK.this.motivo = position + 1;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            vVF87n7MnK vvf87n7mnk = vVF87n7MnK.this;
            vvf87n7mnk.provincia = vvf87n7mnk.provinciasArrayAdapter.getItem(position);
            vVF87n7MnK vvf87n7mnk2 = vVF87n7MnK.this;
            vvf87n7mnk2.municipio = null;
            vvf87n7mnk2.spMunicipio.setText(BuildConfig.FLAVOR);
            vVF87n7MnK vvf87n7mnk3 = vVF87n7MnK.this;
            vvf87n7mnk3.sucursal = null;
            vvf87n7mnk3.spSucursal.setText(BuildConfig.FLAVOR);
            vVF87n7MnK vvf87n7mnk4 = vVF87n7MnK.this;
            vvf87n7mnk4.loadMunicipio(vvf87n7mnk4.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            vVF87n7MnK vvf87n7mnk = vVF87n7MnK.this;
            vvf87n7mnk.municipio = vvf87n7mnk.municipioArrayAdapter.getItem(position);
            vVF87n7MnK vvf87n7mnk2 = vVF87n7MnK.this;
            vvf87n7mnk2.sucursal = null;
            vvf87n7mnk2.spSucursal.setText(BuildConfig.FLAVOR);
            if (!vVF87n7MnK.this.loadSucursales(vVF87n7MnK.this.municipio.getCod_provincia() + vVF87n7MnK.this.municipio.getCod_municipio())) {
                Toast.makeText(vVF87n7MnK.this.context, "No hay sucursales en el municipio seleccionado", 1).show();
                vVF87n7MnK.this.sucursalArrayAdapter = new ArrayAdapter<>(vVF87n7MnK.this.context, R.layout.simple_dropdown_item_1line);
                vVF87n7MnK.this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                vVF87n7MnK.this.spSucursal.setAdapter(vVF87n7MnK.this.sucursalArrayAdapter);
                vVF87n7MnK.this.spSucursal.setOnItemClickListener(vVF87n7MnK.this.spSucursal);
                vVF87n7MnK.this.sucursalArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            vVF87n7MnK vvf87n7mnk = vVF87n7MnK.this;
            vvf87n7mnk.sucursal = vvf87n7mnk.sucursalArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.v69r7arihgxpk, container, false);
        this.context = getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.input_cuenta);
        this.spinnerMotivo = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spinnerMotivo);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, cu.etecsa.cubacel.tr.tm.R.array.array_reimprimir_bandec, R.layout.simple_list_item_1);
        this.adapterMotivo = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.spinnerMotivo.setAdapter(this.adapterMotivo);
        this.spinnerMotivo.setOnItemClickListener(this.spClickMotivos);
        this.inputLayoutDescripcion = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.input__layout_descripcion);
        initSeparator();
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                vVF87n7MnK.this.submitForm();
            }
        });
        V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
        this.jsonFilesManager = v9s8rJIDplX;
        v9s8rJIDplX.loadData(this.context, R1sDOSqZ2z.BANDEC);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spSucursal);
        loadProvincias();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String cuenta = this.inputCuenta.getText().toString().trim();
        if (!validateMunicipio() || !validateSucursal()) {
            return;
        }
        String str = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
        String surcursalSeleccionado = this.sucursal.getCodigoSucursal();
        if (cuenta.contains("-")) {
            cuenta = cuenta.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta(cuenta) || !validateDescripcion()) {
            return;
        }
        String msg = "Desea reimprimir la tarjeta: " + cuenta;
        String cadena = surcursalSeleccionado + "*" + cuenta + "*" + this.motivo;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "74", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta(String cuenta) {
        if (cuenta.isEmpty()) {
            this.inputLayoutCuenta.setError(getString(cu.etecsa.cubacel.tr.tm.R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (cuenta.length() != 16) {
            this.inputLayoutCuenta.setError(getString(cu.etecsa.cubacel.tr.tm.R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateDescripcion() {
        if (this.spinnerMotivo.getText().toString().trim().isEmpty()) {
            this.inputLayoutDescripcion.setError(getString(cu.etecsa.cubacel.tr.tm.R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMotivo);
            return false;
        }
        this.inputLayoutDescripcion.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private void initSeparator() {
        loadDrawables();
        cuentaOnListeners();
    }

    private void loadDrawables() {
        try {
            Drawable drBPA = getResources().getDrawable(cu.etecsa.cubacel.tr.tm.R.drawable.tarjeta_bpa);
            Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
            this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
            Drawable drBANDEC = getResources().getDrawable(cu.etecsa.cubacel.tr.tm.R.drawable.tarjeta_bandec);
            Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
            this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
            Drawable drMETRO = getResources().getDrawable(cu.etecsa.cubacel.tr.tm.R.drawable.tarjeta_metro);
            Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
            this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        vVF87n7MnK.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    try {
                        vVF87n7MnK.this.keyDel = 1;
                    } catch (Exception ex) {
                        Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                        return;
                    }
                }
                boolean flag = true;
                String[] eachBlock = vVF87n7MnK.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    vVF87n7MnK vvf87n7mnk = vVF87n7MnK.this;
                    if (vvf87n7mnk.keyDel == 0) {
                        int length = vvf87n7mnk.inputCuenta.getText().length() + 1;
                        float length2 = (vVF87n7MnK.this.inputCuenta.getText().length() + 1) % 5;
                        if ((vVF87n7MnK.this.inputCuenta.getText().length() + 1) % 5 == 0 && vVF87n7MnK.this.inputCuenta.getText().toString().split("-").length <= 3) {
                            vVF87n7MnK.this.inputCuenta.setText(((Object) vVF87n7MnK.this.inputCuenta.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = vVF87n7MnK.this.inputCuenta;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        vVF87n7MnK vvf87n7mnk2 = vVF87n7MnK.this;
                        vvf87n7mnk2.cuentaCaracteres = vvf87n7mnk2.inputCuenta.getText().toString();
                        return;
                    }
                    vvf87n7mnk.cuentaCaracteres = vvf87n7mnk.inputCuenta.getText().toString();
                    vVF87n7MnK.this.keyDel = 0;
                    return;
                }
                vVF87n7MnK vvf87n7mnk3 = vVF87n7MnK.this;
                vvf87n7mnk3.inputCuenta.setText(vvf87n7mnk3.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                vVF87n7MnK vvf87n7mnk = vVF87n7MnK.this;
                AutoCompleteTextView autoCompleteTextView = vvf87n7mnk.inputCuenta;
                vvf87n7mnk.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
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
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                private boolean loadProvincias() {
                    try {
                        List<Provincia> list = unYp8VQThY.getInstance().getAllProvinciasLists();
                        if (list == null || list.size() <= 0) {
                            return false;
                        }
                        this.provinciaList = list;
                        this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
                        for (Provincia uyh0pxs9m37in : list) {
                            this.provinciasArrayAdapter.add(uyh0pxs9m37in);
                        }
                        this.provinciasArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                        this.spProvincia.setAdapter(this.provinciasArrayAdapter);
                        this.spProvincia.setOnItemClickListener(this.spClickProvincias);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public boolean loadMunicipio(String codigo) {
                    try {
                        List<Municipio> list = unYp8VQThY.getInstance().getAllMunipiosLists(codigo);
                        if (list == null || list.size() <= 0) {
                            return false;
                        }
                        this.municipiosList = list;
                        this.municipioArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
                        for (Municipio uyh0pxs9m37in : list) {
                            this.municipioArrayAdapter.add(uyh0pxs9m37in);
                        }
                        this.municipioArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                        this.spMunicipio.setAdapter(this.municipioArrayAdapter);
                        this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
                        this.municipioArrayAdapter.notifyDataSetChanged();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public boolean loadSucursales(String codigo) {
                    try {
                        List<SucursalBancaria> list = this.jsonFilesManager.getSucursalxDPA(codigo, this.context);
                        if (list == null || list.size() <= 0) {
                            return false;
                        }
                        this.sucursalList = list;
                        this.sucursalArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
                        for (SucursalBancaria uyh0pxs9m37in : list) {
                            this.sucursalArrayAdapter.add(uyh0pxs9m37in);
                        }
                        this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                        this.spSucursal.setAdapter(this.sucursalArrayAdapter);
                        this.spSucursal.setOnItemClickListener(this.spClickSucursal);
                        this.sucursalArrayAdapter.notifyDataSetChanged();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

                private boolean validateMunicipio() {
                    this.lyMunicipio.setErrorEnabled(false);
                    if (this.spMunicipio.getText().toString().trim().isEmpty()) {
                        this.lyMunicipio.setError("Seleccione el municipio");
                        requestFocus(this.spMunicipio);
                        return false;
                    }
                    this.lyMunicipio.setErrorEnabled(false);
                    return true;
                }

                private boolean validateSucursal() {
                    this.lySucursal.setErrorEnabled(false);
                    if (this.spSucursal.getText().toString().trim().isEmpty()) {
                        this.lySucursal.setError("Seleccione la sucursal");
                        requestFocus(this.spSucursal);
                        return false;
                    }
                    this.lySucursal.setErrorEnabled(false);
                    return true;
                }
            }
