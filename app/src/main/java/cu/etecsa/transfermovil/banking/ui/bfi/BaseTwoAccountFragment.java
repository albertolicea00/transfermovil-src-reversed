package cu.etecsa.transfermovil.banking.ui.bfi;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.*;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
 * @original_apk_version 1.260416
 */
public abstract class BaseTwoAccountFragment extends BankingAccountValidatorFragment {
    public ArrayAdapter<CharSequence> adapterMoneda;
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
    public boolean isConfirm = false;
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    if (BaseTwoAccountFragment.this.cargarMisCuentas()) {
                        BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                        qGQCqILT4b.monedaTarjeta = 0;
                        qGQCqILT4b.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        qGQCqILT4b.inputLayoutMisCuentas.setVisibility(0);
                        BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                        BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                        BaseTwoAccountFragment.this.inputLayoutMisCuentas.setVisibility(8);
                    }
                    break;
                case 1:
                    BaseTwoAccountFragment qGQCqILT4b2 = BaseTwoAccountFragment.this;
                    qGQCqILT4b2.monedaTarjeta = 0;
                    qGQCqILT4b2.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    qGQCqILT4b2.inputLayoutMisCuentas.setVisibility(8);
                    BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                    BaseTwoAccountFragment qGQCqILT4b3 = BaseTwoAccountFragment.this;
                    qGQCqILT4b3.mcBankArrayAdapter = null;
                    qGQCqILT4b3.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BaseTwoAccountFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    BaseTwoAccountFragment qGQCqILT4b4 = BaseTwoAccountFragment.this;
                    qGQCqILT4b4.seleccionCuenta = jceCwl8l2R.MONEDA;
                    qGQCqILT4b4.monedaTarjeta = position + 1;
                    qGQCqILT4b4.inputLayoutMisCuentas.setVisibility(8);
                    BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    BaseTwoAccountFragment qGQCqILT4b5 = BaseTwoAccountFragment.this;
                    qGQCqILT4b5.mcBankArrayAdapter = null;
                    qGQCqILT4b5.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BaseTwoAccountFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(BaseTwoAccountFragment.this.context);
            builder.setTitle(BaseTwoAccountFragment.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(BaseTwoAccountFragment.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.4.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = BaseTwoAccountFragment.this.mcBankArrayAdapter.getItem(position);
            BaseTwoAccountFragment.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    public abstract void nuevoDatos();

    public void initComponentesCuentas(View rootView, R1sDOSqZ2z agencia) {
        this.bancoEntity = agencia;
        this.seleccionCuenta = jceCwl8l2R.VACIO;
        this.cuentaOrigen = "0000";
        this.tipomoneda = getResources().getStringArray(R.array.accounts);
        TextInputLayout textInputLayout = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.accounts, android.R.layout.simple_list_item_1);
        this.adapterMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterMoneda);
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
            this.swCuentasBanco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    BaseTwoAccountFragment.this.inputLayoutMisCuentas.setVisibility(8);
                    BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    if (b) {
                        BaseTwoAccountFragment.this.showDialogCuentas();
                        return;
                    }
                    BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                    qGQCqILT4b.swCuentasBanco.setText(qGQCqILT4b.context.getString(R.string.tx_habilitar_uso_de_cuentas_origen));
                    BaseTwoAccountFragment.this.seleccionCuenta = jceCwl8l2R.VACIO;
                }
            });
        } else {
            r0.setVisibility(8);
        }
        loadDrawables();
        cuentaOrigenOnListeners();
    }

    public void submitForm() {
        this.cuentaOrigen = "0000";
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment$14, reason: invalid class name */
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
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    BaseTwoAccountFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                    qGQCqILT4b.inputCuentaWrite.setText(qGQCqILT4b.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    BaseTwoAccountFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = BaseTwoAccountFragment.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    BaseTwoAccountFragment qGQCqILT4b2 = BaseTwoAccountFragment.this;
                    if (qGQCqILT4b2.keyDel == 0) {
                        int length = qGQCqILT4b2.inputCuentaWrite.getText().length() + 1;
                        float length2 = (BaseTwoAccountFragment.this.inputCuentaWrite.getText().length() + 1) % 5;
                        if ((BaseTwoAccountFragment.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && BaseTwoAccountFragment.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                            BaseTwoAccountFragment.this.inputCuentaWrite.setText(((Object) BaseTwoAccountFragment.this.inputCuentaWrite.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = BaseTwoAccountFragment.this.inputCuentaWrite;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        BaseTwoAccountFragment qGQCqILT4b3 = BaseTwoAccountFragment.this;
                        qGQCqILT4b3.cuentaCaracteres = qGQCqILT4b3.inputCuentaWrite.getText().toString();
                        return;
                    }
                    qGQCqILT4b2.cuentaCaracteres = qGQCqILT4b2.inputCuentaWrite.getText().toString();
                    BaseTwoAccountFragment.this.keyDel = 0;
                    return;
                }
                BaseTwoAccountFragment qGQCqILT4b4 = BaseTwoAccountFragment.this;
                qGQCqILT4b4.inputCuentaWrite.setText(qGQCqILT4b4.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                AutoCompleteTextView autoCompleteTextView = qGQCqILT4b.inputCuentaWrite;
                qGQCqILT4b.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
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
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                                qGQCqILT4b.isConfirm = true;
                                qGQCqILT4b.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.7
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
                        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                                qGQCqILT4b.isConfirm = true;
                                qGQCqILT4b.submitForm();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.9
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

                public void showDialogCuentas() {
                    CharSequence[] items = {"Insertar cuenta", "Listar mis cuentas"};
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.context);
                    builder.setTitle("Seleccione:");
                    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    BaseTwoAccountFragment qGQCqILT4b = BaseTwoAccountFragment.this;
                                    qGQCqILT4b.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                                    qGQCqILT4b.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                    BaseTwoAccountFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                    BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                                    BaseTwoAccountFragment.this.inputLayoutMisCuentas.setVisibility(8);
                                    BaseTwoAccountFragment qGQCqILT4b2 = BaseTwoAccountFragment.this;
                                    qGQCqILT4b2.mcBankArrayAdapter = null;
                                    qGQCqILT4b2.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                                    BaseTwoAccountFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                                    dialogInterface.dismiss();
                                    break;
                                case 1:
                                    if (BaseTwoAccountFragment.this.cargarMisCuentas()) {
                                        BaseTwoAccountFragment qGQCqILT4b3 = BaseTwoAccountFragment.this;
                                        qGQCqILT4b3.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                                        qGQCqILT4b3.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                        BaseTwoAccountFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                        BaseTwoAccountFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                                        BaseTwoAccountFragment.this.inputLayoutMisCuentas.setVisibility(0);
                                    } else {
                                        BaseTwoAccountFragment.this.showDialogNoTieneCuentas();
                                        BaseTwoAccountFragment.this.swCuentasBanco.setChecked(false);
                                    }
                                    dialogInterface.dismiss();
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                            BaseTwoAccountFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.12
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            BaseTwoAccountFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                }

                public void showDialogNoTieneCuentas() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setTitle("Aviso");
                    builder.setMessage("No tiene cuentas registradas para este banco");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseTwoAccountFragment.13
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
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
            }
