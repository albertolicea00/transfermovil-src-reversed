package cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations;

import android.app.AlertDialog;
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
import android.widget.Switch;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.MobileCardBank;
import cu.etecsa.transfermovil.banking.ui.bfi.BankingAccountValidatorFragment;
import cu.etecsa.transfermovil.core.enums.AccountSelection;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;


import java.util.List;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.DQIrxODoMU */
public abstract class BandecAccountSelectionFragment extends BankingAccountValidatorFragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public BankType bancoEntity;
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
    public ArrayAdapter<MobileCardBank> mcBankArrayAdapter;
    public List<MobileCardBank> misCuentas;
    public int monedaTarjeta;
    public View rootView;
    public AccountSelection seleccionCuenta;
    public jN13TOyLMX spinnerMisCuentas;
    public jN13TOyLMX spinnerTipoMoneda;
    public Switch swCuentasBanco;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String[] tipomoneda;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 1:
                    if (BandecAccountSelectionFragment.this.cargarMisCuentas()) {
                        BandecAccountSelectionFragment dQIrxODoMU = BandecAccountSelectionFragment.this;
                        dQIrxODoMU.monedaTarjeta = 0;
                        dQIrxODoMU.seleccionCuenta = AccountSelection.MIS_CUENTAS;
                        dQIrxODoMU.inputLayoutMisCuentas.setVisibility(0);
                        BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                        BandecAccountSelectionFragment.this.inputLayoutMisCuentas.setVisibility(8);
                        BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    }
                    break;
                case 2:
                    BandecAccountSelectionFragment dQIrxODoMU2 = BandecAccountSelectionFragment.this;
                    dQIrxODoMU2.monedaTarjeta = 0;
                    dQIrxODoMU2.seleccionCuenta = AccountSelection.NUEVA_CUENTA;
                    dQIrxODoMU2.inputLayoutMisCuentas.setVisibility(8);
                    BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                    BandecAccountSelectionFragment dQIrxODoMU3 = BandecAccountSelectionFragment.this;
                    dQIrxODoMU3.mcBankArrayAdapter = null;
                    dQIrxODoMU3.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BandecAccountSelectionFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    BandecAccountSelectionFragment dQIrxODoMU4 = BandecAccountSelectionFragment.this;
                    dQIrxODoMU4.seleccionCuenta = AccountSelection.MONEDA;
                    dQIrxODoMU4.monedaTarjeta = 1;
                    dQIrxODoMU4.inputLayoutMisCuentas.setVisibility(8);
                    BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                    BandecAccountSelectionFragment dQIrxODoMU5 = BandecAccountSelectionFragment.this;
                    dQIrxODoMU5.mcBankArrayAdapter = null;
                    dQIrxODoMU5.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    BandecAccountSelectionFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(BandecAccountSelectionFragment.this.context);
            builder.setTitle(BandecAccountSelectionFragment.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(BandecAccountSelectionFragment.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MobileCardBank mcBank = BandecAccountSelectionFragment.this.mcBankArrayAdapter.getItem(position);
            BandecAccountSelectionFragment.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    public abstract void nuevoDatos();

    public void initComponentesCuentas(View rootView, BankType agencia) {
        this.bancoEntity = agencia;
        this.seleccionCuenta = AccountSelection.VACIO;
        this.cuentaOrigen = "0000";
        this.tipomoneda = getResources().getStringArray(R.array.currency_account_bandec);
        TextInputLayout textInputLayout = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_account_bandec, android.R.layout.simple_list_item_1);
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
        r0.setVisibility(8);
        loadDrawables();
        cuentaOrigenOnListeners();
    }

    public void submitForm() {
        this.cuentaOrigen = "0000";
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$AccountSelection;

        static {
            int[] iArr = new int[AccountSelection.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$AccountSelection = iArr;
            try {
                iArr[AccountSelection.MONEDA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$AccountSelection[AccountSelection.MIS_CUENTAS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$AccountSelection[AccountSelection.NUEVA_CUENTA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public boolean validateSelectionAccounts() {
        switch (AnonymousClass9.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$AccountSelection[this.seleccionCuenta.ordinal()]) {
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

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuentaWrite.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    BandecAccountSelectionFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWrite.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    BandecAccountSelectionFragment dQIrxODoMU = BandecAccountSelectionFragment.this;
                    dQIrxODoMU.inputCuentaWrite.setText(dQIrxODoMU.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    BandecAccountSelectionFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = BandecAccountSelectionFragment.this.inputCuentaWrite.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    BandecAccountSelectionFragment dQIrxODoMU2 = BandecAccountSelectionFragment.this;
                    if (dQIrxODoMU2.keyDel == 0) {
                        int length = dQIrxODoMU2.inputCuentaWrite.getText().length() + 1;
                        float length2 = (BandecAccountSelectionFragment.this.inputCuentaWrite.getText().length() + 1) % 5;
                        if ((BandecAccountSelectionFragment.this.inputCuentaWrite.getText().length() + 1) % 5 == 0 && BandecAccountSelectionFragment.this.inputCuentaWrite.getText().toString().split("-").length <= 3) {
                            BandecAccountSelectionFragment.this.inputCuentaWrite.setText(((Object) BandecAccountSelectionFragment.this.inputCuentaWrite.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = BandecAccountSelectionFragment.this.inputCuentaWrite;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        BandecAccountSelectionFragment dQIrxODoMU3 = BandecAccountSelectionFragment.this;
                        dQIrxODoMU3.cuentaCaracteres = dQIrxODoMU3.inputCuentaWrite.getText().toString();
                        return;
                    }
                    dQIrxODoMU2.cuentaCaracteres = dQIrxODoMU2.inputCuentaWrite.getText().toString();
                    BandecAccountSelectionFragment.this.keyDel = 0;
                    return;
                }
                BandecAccountSelectionFragment dQIrxODoMU4 = BandecAccountSelectionFragment.this;
                dQIrxODoMU4.inputCuentaWrite.setText(dQIrxODoMU4.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BandecAccountSelectionFragment dQIrxODoMU = BandecAccountSelectionFragment.this;
                AutoCompleteTextView autoCompleteTextView = dQIrxODoMU.inputCuentaWrite;
                dQIrxODoMU.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
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

    /** Restored from the archived v162 smali because JADX omitted this method. */
    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta) {
        int tipoBanco = 0;
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 4) {
                    String bancoCode = tarjeta.substring(5, 7);
                    if ("12".equals(bancoCode)) tipoBanco = 1;
                    else if ("06".equals(bancoCode)) tipoBanco = 2;
                    else if ("95".equals(bancoCode)) tipoBanco = 3;
                } else {
                    String bancoCode = tarjeta.substring(0, 2);
                    if ("12".equals(bancoCode)) tipoBanco = 1;
                    else if ("06".equals(bancoCode)) tipoBanco = 2;
                    else if ("05".equals(bancoCode)) tipoBanco = 3;
                }
            }
            switch (tipoBanco) {
                case 1:
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, this.tarjeta_bpa, null);
                    break;
                case 2:
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, this.tarjeta_bandec, null);
                    break;
                case 3:
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, this.tarjeta_metro, null);
                    break;
                default:
                    inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
            }
        } catch (Exception ignored) {
        }
    }

    public boolean cargarMisCuentas() {
                    try {
                        List<MobileCardBank> list = DatabaseHelper.getInstance().getMCBankByAgency(this.bancoEntity);
                        if (list == null || list.size() <= 0) {
                            return false;
                        }
                        this.misCuentas = list;
                        this.mcBankArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
                        for (MobileCardBank uyh0pxs9m37in : list) {
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
                    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    BandecAccountSelectionFragment dQIrxODoMU = BandecAccountSelectionFragment.this;
                                    dQIrxODoMU.seleccionCuenta = AccountSelection.NUEVA_CUENTA;
                                    dQIrxODoMU.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                    BandecAccountSelectionFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                    BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(0);
                                    BandecAccountSelectionFragment.this.inputLayoutMisCuentas.setVisibility(8);
                                    BandecAccountSelectionFragment dQIrxODoMU2 = BandecAccountSelectionFragment.this;
                                    dQIrxODoMU2.mcBankArrayAdapter = null;
                                    dQIrxODoMU2.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                                    BandecAccountSelectionFragment.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                                    dialogInterface.dismiss();
                                    break;
                                case 1:
                                    if (BandecAccountSelectionFragment.this.cargarMisCuentas()) {
                                        BandecAccountSelectionFragment dQIrxODoMU3 = BandecAccountSelectionFragment.this;
                                        dQIrxODoMU3.seleccionCuenta = AccountSelection.MIS_CUENTAS;
                                        dQIrxODoMU3.inputCuentaWrite.setText(BuildConfig.FLAVOR);
                                        BandecAccountSelectionFragment.this.swCuentasBanco.setText(BuildConfig.FLAVOR);
                                        BandecAccountSelectionFragment.this.inputLayoutCuentaWrite.setVisibility(8);
                                        BandecAccountSelectionFragment.this.inputLayoutMisCuentas.setVisibility(0);
                                    } else {
                                        BandecAccountSelectionFragment.this.showDialogNoTieneCuentas();
                                        BandecAccountSelectionFragment.this.swCuentasBanco.setChecked(false);
                                    }
                                    dialogInterface.dismiss();
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                            BandecAccountSelectionFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.7
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            BandecAccountSelectionFragment.this.swCuentasBanco.setChecked(false);
                        }
                    });
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                }

                public void showDialogNoTieneCuentas() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setTitle("Aviso");
                    builder.setMessage("No tiene cuentas registradas para este banco");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BandecAccountSelectionFragment.8
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
