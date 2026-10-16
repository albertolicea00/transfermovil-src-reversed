package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class oaEWezaNAI extends EV9Tu0zIL4 {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    public List<Client> clientsList;
    private Uri contactUri;
    public Context context;
    public String cuenta;
    public CuentaBanco cuentaBanco;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCuenta;
    private EditText inputDescricion;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutDescripcion;
    private TextInputLayout inputLayoutMovil;
    private TextInputLayout inputLayoutSpinnerCliente;
    private AutoCompleteTextView inputMovil;
    public int keyDel;
    public boolean lock;
    public String mensajeCuentaOrigen;
    public int posCliente;
    public jN13TOyLMX spinnerCliente;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bfi;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_clasica;
    public Drawable tarjeta_clasica_emp;
    public Drawable tarjeta_metro;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public boolean editMode = false;
    public boolean isConfirm = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.10
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            oaEWezaNAI oaewezanai = oaEWezaNAI.this;
            oaewezanai.posCliente = position + 1;
            oaewezanai.id_cliente_select = oaewezanai.clientsList.get(oaewezanai.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.uetdwqrbhz75w, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputLayoutCuenta = (TextInputLayout) rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) rootView.findViewById(R.id.input_cuenta);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.inputLayoutDescripcion = (TextInputLayout) rootView.findViewById(R.id.input__layout_descripcion);
        this.inputDescricion = (EditText) rootView.findViewById(R.id.input_descripcion);
        this.inputLayoutMovil = (TextInputLayout) rootView.findViewById(R.id.input__layout_gnumero);
        this.inputMovil = (AutoCompleteTextView) rootView.findViewById(R.id.input_gnumero);
        this.clientsList = unYp8VQThY.getInstance().getAllClientLists();
        List<String> titles = new ArrayList<>();
        for (Client c : this.clientsList) {
            try {
                if (c.getName().length() != 0) {
                    titles.add(c.getName());
                }
            } catch (Exception e) {
            }
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, titles);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCliente.setAdapter(adapter1);
        if (getArguments() != null) {
            this.toolbar_title.setText("Editar Cuenta");
            int id = Integer.parseInt(getArguments().get("cuenta_id").toString());
            unYp8VQThY.init(this.context);
            CuentaBanco cuentaListWithId = unYp8VQThY.getInstance().getCuentaListWithId(id);
            this.cuentaBanco = cuentaListWithId;
            String temp = getCuentaFormateada(cuentaListWithId.getCuenta());
            this.inputCuenta.setText(temp);
            this.inputDescricion.setText(this.cuentaBanco.getDescripcion());
            this.inputMovil.setText(this.cuentaBanco.getMovil());
            if (this.cuentaBanco.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.cuentaBanco.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText("Nueva cuenta");
            this.cuentaBanco = new CuentaBanco();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        initSeparator();
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                oaEWezaNAI.this.busk_contactos(v);
            }
        });
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oaEWezaNAI.this.submitForm();
            }
        });
        return rootView;
    }

    public void submitForm() {
        String strTrim = this.inputCuenta.getText().toString().trim();
        this.cuenta = strTrim;
        if (strTrim.contains("-")) {
            this.cuenta = this.cuenta.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta(this.cuenta) || !validateNumber()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    oaEWezaNAI oaewezanai = oaEWezaNAI.this;
                    oaewezanai.lista_vacia = true;
                    oaewezanai.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    oaEWezaNAI.this.lista_vacia = false;
                }
            });
            builder.show();
            return;
        }
        execute_commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute_commit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.msg_reponsabilidad_cuenta_usuario);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(oaEWezaNAI.this.context);
                oaEWezaNAI oaewezanai = oaEWezaNAI.this;
                oaewezanai.cuentaBanco.setCuenta(oaewezanai.cuenta);
                if (oaEWezaNAI.this.inputDescricion.getText().toString().length() > 0) {
                    oaEWezaNAI oaewezanai2 = oaEWezaNAI.this;
                    oaewezanai2.cuentaBanco.setDescripcion(oaewezanai2.inputDescricion.getText().toString().trim());
                }
                oaEWezaNAI oaewezanai3 = oaEWezaNAI.this;
                int i = oaewezanai3.id_cliente_select;
                if (i != 0 && i != -1) {
                    oaewezanai3.cuentaBanco.setId_client(i);
                }
                if (oaEWezaNAI.this.inputMovil.getText().toString().length() > 0) {
                    oaEWezaNAI oaewezanai4 = oaEWezaNAI.this;
                    oaewezanai4.cuentaBanco.setMovil(oaewezanai4.inputMovil.getText().toString());
                }
                if (oaEWezaNAI.this.editMode) {
                    unYp8VQThY.getInstance().updateCuentaBanco(oaEWezaNAI.this.cuentaBanco);
                } else {
                    unYp8VQThY.getInstance().addCuentaBanco(oaEWezaNAI.this.cuentaBanco);
                }
                if (oaEWezaNAI.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) oaEWezaNAI.this.getActivity()).UpdateMenu();
                } else if (oaEWezaNAI.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) oaEWezaNAI.this.getActivity()).UpdateMenu();
                }
                oaEWezaNAI.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCuenta(String ccuenta) {
        if (ccuenta.isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (ccuenta.length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !ccuenta.contains(this.cuentaBanco.getCuenta()))) {
            if (unYp8VQThY.getInstance().getCuentaListsWithAccount(ccuenta).size() != 0) {
                this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_num_cuenta_existe));
                requestFocus(this.inputCuenta);
                return false;
            }
        } else {
            this.inputLayoutCuenta.setErrorEnabled(false);
        }
        if (!validateCuentaOrigen(ccuenta) && !this.isConfirm) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Advertencia");
            builder.setMessage(this.mensajeCuentaOrigen);
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    oaEWezaNAI oaewezanai = oaEWezaNAI.this;
                    oaewezanai.isConfirm = true;
                    oaewezanai.submitForm();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            return false;
        }
        return true;
    }

    private boolean validateSpinnerCliente() {
        if (this.spinnerCliente.getText().toString().trim().isEmpty()) {
            return false;
        }
        this.lista_vacia = true;
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
            Drawable drClasica = getResources().getDrawable(R.drawable.tarjeta_clasica);
            Bitmap bitmapClasica = ((BitmapDrawable) drClasica).getBitmap();
            Resources resources = getResources();
            Bitmap bitmapBPA2 = Bitmap.createScaledBitmap(bitmapClasica, 80, 60, true);
            this.tarjeta_clasica = new BitmapDrawable(resources, bitmapBPA2);
            Drawable drClasicaE = getResources().getDrawable(R.drawable.tarjeta_clasica_empresarial);
            Bitmap bitmapClasicaE = ((BitmapDrawable) drClasicaE).getBitmap();
            this.tarjeta_clasica_emp = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapClasicaE, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.8
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        oaEWezaNAI.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (count == 16) {
                        oaEWezaNAI.this.inputCuenta.setText(oaEWezaNAI.this.getCuentaFormateada(s.toString()));
                        return;
                    }
                    if (count == 0) {
                        oaEWezaNAI.this.keyDel = 1;
                    }
                    boolean flag = true;
                    String[] eachBlock = oaEWezaNAI.this.inputCuenta.getText().toString().split("-");
                    for (String str : eachBlock) {
                        if (str.length() > 4) {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        oaEWezaNAI.this.inputCuenta.setText(oaEWezaNAI.this.cuentaCaracteres);
                        return;
                    }
                    oaEWezaNAI oaewezanai = oaEWezaNAI.this;
                    if (oaewezanai.keyDel != 0) {
                        oaewezanai.cuentaCaracteres = oaewezanai.inputCuenta.getText().toString();
                        oaEWezaNAI.this.keyDel = 0;
                        return;
                    }
                    int length = oaewezanai.inputCuenta.getText().length() + 1;
                    float length2 = (oaEWezaNAI.this.inputCuenta.getText().length() + 1) % 5;
                    if ((oaEWezaNAI.this.inputCuenta.getText().length() + 1) % 5 == 0 && oaEWezaNAI.this.inputCuenta.getText().toString().split("-").length <= 3) {
                        oaEWezaNAI.this.inputCuenta.setText(((Object) oaEWezaNAI.this.inputCuenta.getText()) + "-");
                        oaEWezaNAI.this.inputCuenta.setSelection(oaEWezaNAI.this.inputCuenta.getText().length());
                    }
                    oaEWezaNAI oaewezanai2 = oaEWezaNAI.this;
                    oaewezanai2.cuentaCaracteres = oaewezanai2.inputCuenta.getText().toString();
                } catch (Exception ex) {
                    Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                oaEWezaNAI oaewezanai = oaEWezaNAI.this;
                oaewezanai.mostrarTarjeta(oaewezanai.inputCuenta, oaEWezaNAI.this.inputCuenta.getText().toString());
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    /* JADX WARN: Code duplicated, block: B:37:0x0080  */
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
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
                    tipoBanco = 4;
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
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
                        Method dump skipped, instruction units count: 300
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                private boolean validateNumber() {
                    if (!this.inputMovil.getText().toString().trim().isEmpty() && this.inputMovil.getText().toString().trim().length() != 8) {
                        this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_cel_eight));
                        requestFocus(this.inputMovil);
                        return false;
                    }
                    this.inputLayoutMovil.setErrorEnabled(false);
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
                    this.inputMovil.setText(telf);
                }

                private String getPhone(Uri uri) {
                    String phone = null;
                    String id = null;
                    try {
                        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
                        if (contactCursor.moveToFirst()) {
                            id = contactCursor.getString(0);
                        }
                        contactCursor.close();
                        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
                        if (phoneCursor.moveToFirst()) {
                            phone = phoneCursor.getString(0);
                        }
                        phoneCursor.close();
                    } catch (Exception e) {
                    }
                    return phone;
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

                private boolean validateCuentaOrigen(String cuenta) {
                    EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
                    this.mensajeCuentaOrigen = BuildConfig.FLAVOR;
                    if (!datosTarjeta.isValidBank) {
                        this.mensajeCuentaOrigen = this.context.getString(R.string.alert_msg_no_bank);
                        return false;
                    }
                    return true;
                }
            }
