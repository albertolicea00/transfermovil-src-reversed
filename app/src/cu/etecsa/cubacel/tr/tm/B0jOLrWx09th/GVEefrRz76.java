package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
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
import androidx.appcompat.app.AlertDialog;
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
public abstract class GVEefrRz76 extends EV9Tu0zIL4 implements pAzq93vIl3.UssdResponseObserver {
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
    public boolean loadMLC;
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
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String[] tipomoneda;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public boolean isConfirm = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public jN13TOyLMX.OnItemClickListener spClickMonedaNoMLC = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 2:
                    if (GVEefrRz76.this.cargarMisCuentas()) {
                        GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                        gVEefrRz76.monedaTarjeta = 0;
                        gVEefrRz76.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        gVEefrRz76.inputLayoutMisCuentas.setVisibility(0);
                        GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        GVEefrRz76.this.showDialogNoTieneCuentas();
                        GVEefrRz76.this.inputLayoutMisCuentas.setVisibility(8);
                        GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    }
                    break;
                case 3:
                    GVEefrRz76 gVEefrRz77 = GVEefrRz76.this;
                    gVEefrRz77.monedaTarjeta = 0;
                    gVEefrRz77.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    gVEefrRz77.inputLayoutMisCuentas.setVisibility(8);
                    GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(0);
                    GVEefrRz76 gVEefrRz78 = GVEefrRz76.this;
                    gVEefrRz78.mcBankArrayAdapter = null;
                    gVEefrRz78.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    GVEefrRz76.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    GVEefrRz76 gVEefrRz79 = GVEefrRz76.this;
                    gVEefrRz79.seleccionCuenta = jceCwl8l2R.MONEDA;
                    gVEefrRz79.monedaTarjeta = position + 1;
                    gVEefrRz79.inputLayoutMisCuentas.setVisibility(8);
                    GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    GVEefrRz76 gVEefrRz710 = GVEefrRz76.this;
                    gVEefrRz710.mcBankArrayAdapter = null;
                    gVEefrRz710.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    GVEefrRz76.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMonedaMLC = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 1:
                    if (GVEefrRz76.this.cargarMisCuentas()) {
                        GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                        gVEefrRz76.monedaTarjeta = 0;
                        gVEefrRz76.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        gVEefrRz76.inputLayoutMisCuentas.setVisibility(0);
                        GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        GVEefrRz76.this.showDialogNoTieneCuentas();
                    }
                    break;
                case 2:
                    GVEefrRz76 gVEefrRz77 = GVEefrRz76.this;
                    gVEefrRz77.monedaTarjeta = 0;
                    gVEefrRz77.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    gVEefrRz77.inputLayoutMisCuentas.setVisibility(8);
                    GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(0);
                    GVEefrRz76 gVEefrRz78 = GVEefrRz76.this;
                    gVEefrRz78.mcBankArrayAdapter = null;
                    gVEefrRz78.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    GVEefrRz76.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    GVEefrRz76 gVEefrRz79 = GVEefrRz76.this;
                    gVEefrRz79.seleccionCuenta = jceCwl8l2R.MONEDA;
                    gVEefrRz79.monedaTarjeta = 3;
                    gVEefrRz79.inputLayoutMisCuentas.setVisibility(8);
                    GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    GVEefrRz76 gVEefrRz710 = GVEefrRz76.this;
                    gVEefrRz710.mcBankArrayAdapter = null;
                    gVEefrRz710.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    GVEefrRz76.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = GVEefrRz76.this.mcBankArrayAdapter.getItem(position);
            GVEefrRz76.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    public abstract void nuevoDatos();

    public void initComponentesCuentas(View rootView, R1sDOSqZ2z agencia) {
        this.bancoEntity = agencia;
        this.seleccionCuenta = jceCwl8l2R.VACIO;
        this.cuentaOrigen = "0000";
        TextInputLayout textInputLayout = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoMoneda);
        this.spinnerMisCuentas = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCuentas);
        this.inputCuentaWrite = (AutoCompleteTextView) rootView.findViewById(R.id.input_cuenta_write);
        this.inputLayoutCuentaWrite = (TextInputLayout) rootView.findViewById(R.id.input__layout_cuenta_write);
        this.inputLayoutMisCuentas = (TextInputLayout) rootView.findViewById(R.id.input_layout_cuentas);
        this.swCuentasBanco = (Switch) rootView.findViewById(R.id.swCuentasBanco);
        this.tipomoneda = getResources().getStringArray(R.array.accounts);
        this.inputLayoutTipoMoneda.setVisibility(0);
        R1sDOSqZ2z r1sDOSqZ2z = this.bancoEntity;
        if (r1sDOSqZ2z != null && r1sDOSqZ2z == R1sDOSqZ2z.BANDEC) {
            this.inputLayoutTipoMoneda.setVisibility(8);
            this.swCuentasBanco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    GVEefrRz76.this.inputLayoutMisCuentas.setVisibility(8);
                    GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                    if (b) {
                        GVEefrRz76.this.showDialogCuentas();
                        return;
                    }
                    GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                    gVEefrRz76.swCuentasBanco.setText(gVEefrRz76.context.getString(R.string.tx_habilitar_uso_de_cuentas_origen));
                    GVEefrRz76.this.seleccionCuenta = jceCwl8l2R.VACIO;
                }
            });
        } else {
            this.swCuentasBanco.setVisibility(8);
        }
        this.inputLayoutMisCuentas.setVisibility(8);
        this.inputLayoutCuentaWrite.setVisibility(8);
        loadDrawables();
        cuentaOrigenOnListeners();
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
    }

    public void loadMonedaNoMLC() {
        this.loadMLC = false;
        this.tipomoneda = getResources().getStringArray(R.array.currency_no_usd_account);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_no_usd_account, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMonedaNoMLC);
    }

    public void loadMonedaMLC() {
        this.loadMLC = true;
        this.tipomoneda = getResources().getStringArray(R.array.currency_only_mlc);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_only_mlc, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMonedaMLC);
    }

    public void submitForm() {
        this.cuentaOrigen = "0000";
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76$15, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
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
            switch (AnonymousClass15.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[this.seleccionCuenta.ordinal()]) {
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

    public boolean cargarMisCuentas() {
        List<MCBank> list;
        try {
            if (this.loadMLC) {
                list = unYp8VQThY.getInstance().getMCBankByAgencyMLC(this.bancoEntity);
            } else {
                list = unYp8VQThY.getInstance().getMCBankByAgencyNoMLC(this.bancoEntity);
            }
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

    public void showDialogCuentas() {
        CharSequence[] items = {"Insertar cuenta", "Listar mis cuentas"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                        gVEefrRz76.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                        gVEefrRz76.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                        GVEefrRz76.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                        GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(0);
                        GVEefrRz76.this.inputLayoutMisCuentas.setVisibility(8);
                        GVEefrRz76 gVEefrRz77 = GVEefrRz76.this;
                        gVEefrRz77.mcBankArrayAdapter = null;
                        gVEefrRz77.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                        GVEefrRz76.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        if (GVEefrRz76.this.cargarMisCuentas()) {
                            GVEefrRz76 gVEefrRz78 = GVEefrRz76.this;
                            gVEefrRz78.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                            gVEefrRz78.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                            GVEefrRz76.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                            GVEefrRz76.this.inputLayoutCuentaWrite.setVisibility(8);
                            GVEefrRz76.this.inputLayoutMisCuentas.setVisibility(0);
                        } else {
                            GVEefrRz76.this.showDialogNoTieneCuentas();
                            GVEefrRz76.this.swCuentasBanco.setChecked(false);
                        }
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                GVEefrRz76.this.swCuentasBanco.setChecked(false);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GVEefrRz76.this.swCuentasBanco.setChecked(false);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogNoTieneCuentas() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    GVEefrRz76.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.10
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                    gVEefrRz76.inputCuentaWrite.setText(gVEefrRz76.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    GVEefrRz76.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = GVEefrRz76.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    GVEefrRz76 gVEefrRz77 = GVEefrRz76.this;
                    if (gVEefrRz77.keyDel == 0) {
                        int length = gVEefrRz77.inputCuentaWrite.getText().length() + 1;
                        float length2 = (GVEefrRz76.this.inputCuentaWrite.getText().length() + 1) % 5;
                        if ((GVEefrRz76.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && GVEefrRz76.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                            GVEefrRz76.this.inputCuentaWrite.setText(((Object) GVEefrRz76.this.inputCuentaWrite.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = GVEefrRz76.this.inputCuentaWrite;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        GVEefrRz76 gVEefrRz78 = GVEefrRz76.this;
                        gVEefrRz78.cuentaCaracteres = gVEefrRz78.inputCuentaWrite.getText().toString();
                        return;
                    }
                    gVEefrRz77.cuentaCaracteres = gVEefrRz77.inputCuentaWrite.getText().toString();
                    GVEefrRz76.this.keyDel = 0;
                    return;
                }
                GVEefrRz76 gVEefrRz79 = GVEefrRz76.this;
                gVEefrRz79.inputCuentaWrite.setText(gVEefrRz79.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                AutoCompleteTextView autoCompleteTextView = gVEefrRz76.inputCuentaWrite;
                gVEefrRz76.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
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
                    throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.mostrarTarjeta(android.widget.AutoCompleteTextView, java.lang.String):void");
                }

                public boolean validateCuentaSpOrigen() {
                    if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
                        this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
                        requestFocus(this.spinnerMisCuentas);
                        return false;
                    }
                    this.inputLayoutMisCuentas.setErrorEnabled(false);
                    if (!validateCuentaOrigen(this.miCuentaSeleccion) && !this.isConfirm) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                        builder.setTitle("Advertencia");
                        builder.setMessage(this.mensajeCuentaOrigen);
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.11
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                                gVEefrRz76.isConfirm = true;
                                gVEefrRz76.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.12
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                        builder.setTitle("Advertencia");
                        builder.setMessage(this.mensajeCuentaOrigen);
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.13
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                GVEefrRz76 gVEefrRz76 = GVEefrRz76.this;
                                gVEefrRz76.isConfirm = true;
                                gVEefrRz76.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.GVEefrRz76.14
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.show();
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
