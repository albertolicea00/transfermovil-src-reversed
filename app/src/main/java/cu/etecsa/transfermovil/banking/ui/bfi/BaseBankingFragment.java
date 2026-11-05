package cu.etecsa.transfermovil.banking.ui.bfi;

import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.*;

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
/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
 * @original_apk_version 1.260416
 */
public abstract class BaseBankingFragment extends BankingAccountValidatorFragment implements pAzq93vIl3.UssdResponseObserver {
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
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 3:
                    if (BaseBankingFragment.this.cargarMisCuentas()) {
                        BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                        agg55uYctq.monedaTarjeta = 0;
                        agg55uYctq.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        agg55uYctq.inputLayoutMisCuentas.setVisibility(0);
                        BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                        BaseBankingFragment.this.inputLayoutMisCuentas.setVisibility(8);
                        BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    }
                    break;
                case 4:
                    BaseBankingFragment agg55uYctq2 = BaseBankingFragment.this;
                    agg55uYctq2.monedaTarjeta = 0;
                    agg55uYctq2.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    agg55uYctq2.inputLayoutMisCuentas.setVisibility(8);
                    BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                    BaseBankingFragment agg55uYctq3 = BaseBankingFragment.this;
                    agg55uYctq3.mcBankArrayAdapter = null;
                    agg55uYctq3.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BaseBankingFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    BaseBankingFragment agg55uYctq4 = BaseBankingFragment.this;
                    agg55uYctq4.seleccionCuenta = jceCwl8l2R.MONEDA;
                    agg55uYctq4.monedaTarjeta = position + 1;
                    agg55uYctq4.inputLayoutMisCuentas.setVisibility(8);
                    BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    BaseBankingFragment agg55uYctq5 = BaseBankingFragment.this;
                    agg55uYctq5.mcBankArrayAdapter = null;
                    agg55uYctq5.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BaseBankingFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(BaseBankingFragment.this.context);
            builder.setTitle(BaseBankingFragment.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(BaseBankingFragment.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.4.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = BaseBankingFragment.this.mcBankArrayAdapter.getItem(position);
            BaseBankingFragment.this.miCuentaSeleccion = mcBank.getCuenta();
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
            this.swCuentasBanco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    BaseBankingFragment.this.inputLayoutMisCuentas.setVisibility(8);
                    BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    if (b) {
                        BaseBankingFragment.this.showDialogCuentas();
                        return;
                    }
                    BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                    agg55uYctq.swCuentasBanco.setText(agg55uYctq.context.getString(R.string.tx_habilitar_uso_de_cuentas_origen));
                    BaseBankingFragment.this.seleccionCuenta = jceCwl8l2R.VACIO;
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment$14, reason: invalid class name */
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
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    BaseBankingFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                    agg55uYctq.inputCuentaWrite.setText(agg55uYctq.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    BaseBankingFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = BaseBankingFragment.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    BaseBankingFragment agg55uYctq2 = BaseBankingFragment.this;
                    if (agg55uYctq2.keyDel == 0) {
                        int length = agg55uYctq2.inputCuentaWrite.getText().length() + 1;
                        float length2 = (BaseBankingFragment.this.inputCuentaWrite.getText().length() + 1) % 5;
                        if ((BaseBankingFragment.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && BaseBankingFragment.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                            BaseBankingFragment.this.inputCuentaWrite.setText(((Object) BaseBankingFragment.this.inputCuentaWrite.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = BaseBankingFragment.this.inputCuentaWrite;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        BaseBankingFragment agg55uYctq3 = BaseBankingFragment.this;
                        agg55uYctq3.cuentaCaracteres = agg55uYctq3.inputCuentaWrite.getText().toString();
                        return;
                    }
                    agg55uYctq2.cuentaCaracteres = agg55uYctq2.inputCuentaWrite.getText().toString();
                    BaseBankingFragment.this.keyDel = 0;
                    return;
                }
                BaseBankingFragment agg55uYctq4 = BaseBankingFragment.this;
                agg55uYctq4.inputCuentaWrite.setText(agg55uYctq4.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
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
                    String codigoBanco = tarjeta.substring(5, 7);
                    if ("12".equals(codigoBanco)) tipoBanco = 1;
                    else if ("06".equals(codigoBanco)) tipoBanco = 2;
                    else if ("95".equals(codigoBanco)) tipoBanco = 3;
                } else {
                    String codigoBanco = tarjeta.substring(0, 2);
                    if ("12".equals(codigoBanco)) tipoBanco = 1;
                    else if ("06".equals(codigoBanco)) tipoBanco = 2;
                    else if ("05".equals(codigoBanco)) tipoBanco = 3;
                    else if ("03".equals(codigoBanco)) tipoBanco = 5;
                }
            }

            Drawable tarjetaDrawable;
            switch (tipoBanco) {
                case 1: tarjetaDrawable = this.tarjeta_bpa; break;
                case 2: tarjetaDrawable = this.tarjeta_bandec; break;
                case 3: tarjetaDrawable = this.tarjeta_metro; break;
                case 5: tarjetaDrawable = this.tarjeta_bfi; break;
                default: tarjetaDrawable = null; break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, tarjetaDrawable, null);
        } catch (Exception ignored) {
            // Original smali catches malformed or incomplete account identifiers.
        }
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
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                                agg55uYctq.isConfirm = true;
                                agg55uYctq.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.7
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
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                                agg55uYctq.isConfirm = true;
                                agg55uYctq.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.9
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
                    BankingAccountValidatorFragment.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
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
                    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    BaseBankingFragment agg55uYctq = BaseBankingFragment.this;
                                    agg55uYctq.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                                    agg55uYctq.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                    BaseBankingFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                    BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                                    BaseBankingFragment.this.inputLayoutMisCuentas.setVisibility(8);
                                    BaseBankingFragment agg55uYctq2 = BaseBankingFragment.this;
                                    agg55uYctq2.mcBankArrayAdapter = null;
                                    agg55uYctq2.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                                    BaseBankingFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                                    dialogInterface.dismiss();
                                    break;
                                case 1:
                                    if (BaseBankingFragment.this.cargarMisCuentas()) {
                                        BaseBankingFragment agg55uYctq3 = BaseBankingFragment.this;
                                        agg55uYctq3.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                                        agg55uYctq3.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                        BaseBankingFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                        BaseBankingFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                                        BaseBankingFragment.this.inputLayoutMisCuentas.setVisibility(0);
                                    } else {
                                        BaseBankingFragment.this.showDialogNoTieneCuentas();
                                        BaseBankingFragment.this.swCuentasBanco.setChecked(false);
                                    }
                                    dialogInterface.dismiss();
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                            BaseBankingFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.12
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            BaseBankingFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                }

                public void showDialogNoTieneCuentas() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setTitle("Aviso");
                    builder.setMessage("No tiene cuentas registradas para este banco");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseBankingFragment.13
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
