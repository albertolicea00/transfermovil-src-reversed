package cu.etecsa.transfermovil.banking.ui.bfi;

import android.content.DialogInterface;
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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.YWo20QOWZz */
public abstract class BaseCommissionAccountFragment extends BaseTwoAccountFragment {
    public ArrayAdapter<CharSequence> adapterTipoMonedaComision;
    public R1sDOSqZ2z bancoEntityComision;
    public String cuentaCaracteresComision;
    public String cuentaOrigenComision;
    public ConstraintLayout frmCuentasLista;
    public AutoCompleteTextView inputCuentaWriteComision;
    public TextInputLayout inputLayoutCuentaWriteComision;
    public TextInputLayout inputLayoutMisCuentasComision;
    public TextInputLayout inputLayoutTipoMonedaComision;
    public int keyDelComision;
    public boolean lockComision;
    public ArrayAdapter<MCBank> mcBankArrayAdapterComision;
    public List<MCBank> misCuentasComision;
    public int monedaTarjetaComision;
    public jceCwl8l2R seleccionCuentaComision;
    public jN13TOyLMX spinnerMisCuentasComision;
    public jN13TOyLMX spinnerTipoMonedaComision;
    public Switch swCuentasBancoComision;
    public String[] tipomonedaComision;
    public String miCuentaSeleccionComision = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickMonedaComision = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    if (BaseCommissionAccountFragment.this.cargarMisCuentasComision()) {
                        BaseCommissionAccountFragment yWo20QOWZz = BaseCommissionAccountFragment.this;
                        yWo20QOWZz.monedaTarjetaComision = 0;
                        yWo20QOWZz.seleccionCuentaComision = jceCwl8l2R.MIS_CUENTAS;
                        yWo20QOWZz.inputLayoutMisCuentasComision.setVisibility(0);
                        BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(8);
                    } else {
                        BaseCommissionAccountFragment.this.showDialogNoTieneCuentas();
                        BaseCommissionAccountFragment.this.inputLayoutMisCuentasComision.setVisibility(8);
                        BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(8);
                    }
                    break;
                case 1:
                    BaseCommissionAccountFragment yWo20QOWZz2 = BaseCommissionAccountFragment.this;
                    yWo20QOWZz2.monedaTarjetaComision = 0;
                    yWo20QOWZz2.seleccionCuentaComision = jceCwl8l2R.NUEVA_CUENTA;
                    yWo20QOWZz2.inputLayoutMisCuentasComision.setVisibility(8);
                    BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(0);
                    BaseCommissionAccountFragment yWo20QOWZz3 = BaseCommissionAccountFragment.this;
                    yWo20QOWZz3.mcBankArrayAdapterComision = null;
                    yWo20QOWZz3.spinnerMisCuentasComision.setText(BuildConfig.FLAVOR);
                    BaseCommissionAccountFragment yWo20QOWZz4 = BaseCommissionAccountFragment.this;
                    yWo20QOWZz4.miCuentaSeleccionComision = BuildConfig.FLAVOR;
                    yWo20QOWZz4.cuentaOrigenOnListenersComision();
                    break;
                default:
                    BaseCommissionAccountFragment yWo20QOWZz5 = BaseCommissionAccountFragment.this;
                    yWo20QOWZz5.seleccionCuentaComision = jceCwl8l2R.MONEDA;
                    yWo20QOWZz5.monedaTarjetaComision = position + 1;
                    yWo20QOWZz5.inputLayoutMisCuentasComision.setVisibility(8);
                    BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(8);
                    BaseCommissionAccountFragment yWo20QOWZz6 = BaseCommissionAccountFragment.this;
                    yWo20QOWZz6.mcBankArrayAdapterComision = null;
                    yWo20QOWZz6.spinnerMisCuentasComision.setText(BuildConfig.FLAVOR);
                    BaseCommissionAccountFragment.this.miCuentaSeleccionComision = BuildConfig.FLAVOR;
                    break;
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMisCuentasComision = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = BaseCommissionAccountFragment.this.mcBankArrayAdapterComision.getItem(position);
            BaseCommissionAccountFragment.this.miCuentaSeleccionComision = mcBank.getCuenta();
        }
    };

    public abstract void nuevoDatosComision();

    public void initComponentesCuentasComision(View rootView, R1sDOSqZ2z agencia) {
        this.bancoEntityComision = agencia;
        this.seleccionCuentaComision = jceCwl8l2R.VACIO;
        this.cuentaOrigenComision = "0000";
        this.tipomonedaComision = getResources().getStringArray(R.array.accounts);
        TextInputLayout textInputLayout = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo_moneda_comision);
        this.inputLayoutTipoMonedaComision = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMonedaComision = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoMoneda_comision);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.accounts, android.R.layout.simple_list_item_1);
        this.adapterTipoMonedaComision = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMonedaComision.setAdapter(this.adapterTipoMonedaComision);
        this.spinnerTipoMonedaComision.setOnItemClickListener(this.spClickMonedaComision);
        this.inputCuentaWriteComision = (AutoCompleteTextView) rootView.findViewById(R.id.input_cuenta_write_comision);
        this.inputLayoutCuentaWriteComision = (TextInputLayout) rootView.findViewById(R.id.input__layout_cuenta_write_comision);
        this.inputLayoutMisCuentasComision = (TextInputLayout) rootView.findViewById(R.id.input_layout_cuentas_comision);
        this.spinnerMisCuentasComision = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCuentas_comision);
        this.inputLayoutMisCuentasComision.setVisibility(8);
        this.inputLayoutCuentaWriteComision.setVisibility(8);
        Switch r0 = (Switch) rootView.findViewById(R.id.swCuentasBanco_comision);
        this.swCuentasBancoComision = r0;
        R1sDOSqZ2z r1sDOSqZ2z = this.bancoEntityComision;
        if (r1sDOSqZ2z != null && r1sDOSqZ2z == R1sDOSqZ2z.BANDEC) {
            this.inputLayoutTipoMonedaComision.setVisibility(8);
            this.swCuentasBancoComision.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    BaseCommissionAccountFragment.this.inputLayoutMisCuentasComision.setVisibility(8);
                    BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(8);
                    if (b) {
                        BaseCommissionAccountFragment.this.showDialogCuentasComision();
                        return;
                    }
                    BaseCommissionAccountFragment yWo20QOWZz = BaseCommissionAccountFragment.this;
                    yWo20QOWZz.swCuentasBancoComision.setText(yWo20QOWZz.context.getString(R.string.tx_habilitar_uso_de_cuentas_origen));
                    BaseCommissionAccountFragment.this.seleccionCuentaComision = jceCwl8l2R.VACIO;
                }
            });
        } else {
            r0.setVisibility(8);
        }
    }

    public void submitFormComision() {
        this.cuentaOrigenComision = "0000";
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
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

    public boolean validateSelectionAccountsComision() {
        if (this.bancoEntityComision != R1sDOSqZ2z.BANDEC || this.swCuentasBancoComision.isChecked()) {
            switch (AnonymousClass10.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[this.seleccionCuentaComision.ordinal()]) {
                case 1:
                    return validateTipoMonedaComision();
                case 2:
                    if (!validateCuentaSpOrigenComision()) {
                        return false;
                    }
                    this.cuentaOrigenComision = this.miCuentaSeleccionComision;
                    return true;
                case 3:
                    String strTrim = this.inputCuentaWriteComision.getText().toString().trim();
                    this.cuentaOrigenComision = strTrim;
                    if (strTrim.contains("-")) {
                        this.cuentaOrigenComision = this.cuentaOrigenComision.replace("-", BuildConfig.FLAVOR);
                    }
                    return validateCuentaNuevaOrigenComision(this.cuentaOrigenComision);
                default:
                    return showErrorSelectorComision();
            }
        }
        return true;
    }

    public void requestFocusComision(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void cuentaOrigenOnListenersComision() {
        this.inputCuentaWriteComision.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    BaseCommissionAccountFragment.this.keyDelComision = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuentaWriteComision.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    BaseCommissionAccountFragment yWo20QOWZz = BaseCommissionAccountFragment.this;
                    yWo20QOWZz.inputCuentaWriteComision.setText(yWo20QOWZz.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    BaseCommissionAccountFragment.this.keyDelComision = 1;
                }
                boolean flag = true;
                String[] eachBlock = BaseCommissionAccountFragment.this.inputCuentaWriteComision.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    BaseCommissionAccountFragment yWo20QOWZz2 = BaseCommissionAccountFragment.this;
                    if (yWo20QOWZz2.keyDelComision == 0) {
                        int length = yWo20QOWZz2.inputCuentaWriteComision.getText().length() + 1;
                        float length2 = (BaseCommissionAccountFragment.this.inputCuentaWriteComision.getText().length() + 1) % 5;
                        if ((BaseCommissionAccountFragment.this.inputCuentaWriteComision.getText().length() + 1) % 5 == 0 && BaseCommissionAccountFragment.this.inputCuentaWriteComision.getText().toString().split("-").length <= 3) {
                            BaseCommissionAccountFragment.this.inputCuentaWriteComision.setText(((Object) BaseCommissionAccountFragment.this.inputCuentaWriteComision.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = BaseCommissionAccountFragment.this.inputCuentaWriteComision;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        BaseCommissionAccountFragment yWo20QOWZz3 = BaseCommissionAccountFragment.this;
                        yWo20QOWZz3.cuentaCaracteresComision = yWo20QOWZz3.inputCuentaWriteComision.getText().toString();
                        return;
                    }
                    yWo20QOWZz2.cuentaCaracteresComision = yWo20QOWZz2.inputCuentaWriteComision.getText().toString();
                    BaseCommissionAccountFragment.this.keyDelComision = 0;
                    return;
                }
                BaseCommissionAccountFragment yWo20QOWZz4 = BaseCommissionAccountFragment.this;
                yWo20QOWZz4.inputCuentaWriteComision.setText(yWo20QOWZz4.cuentaCaracteresComision);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BaseCommissionAccountFragment yWo20QOWZz = BaseCommissionAccountFragment.this;
                AutoCompleteTextView autoCompleteTextView = yWo20QOWZz.inputCuentaWriteComision;
                yWo20QOWZz.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
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

    public boolean cargarMisCuentasComision() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(this.bancoEntityComision);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.misCuentasComision = list;
            this.mcBankArrayAdapterComision = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (MCBank uyh0pxs9m37in : list) {
                this.mcBankArrayAdapterComision.add(uyh0pxs9m37in);
            }
            this.mcBankArrayAdapterComision.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerMisCuentasComision.setAdapter(this.mcBankArrayAdapterComision);
            this.spinnerMisCuentasComision.setOnItemClickListener(this.spClickMisCuentasComision);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateCuentaSpOrigenComision() {
        if (this.spinnerMisCuentasComision.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentasComision.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocusComision(this.spinnerMisCuentasComision);
            return false;
        }
        this.inputLayoutMisCuentasComision.setErrorEnabled(false);
        return true;
    }

    public boolean validateCuentaNuevaOrigenComision(String cuenta) {
        if (cuenta.isEmpty()) {
            this.inputLayoutCuentaWriteComision.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocusComision(this.inputCuentaWriteComision);
            return false;
        }
        if (cuenta.length() != 16) {
            this.inputLayoutCuentaWriteComision.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocusComision(this.inputCuentaWriteComision);
            return false;
        }
        this.inputLayoutCuentaWriteComision.setErrorEnabled(false);
        return true;
    }

    public boolean showErrorSelectorComision() {
        this.inputLayoutTipoMonedaComision.setError("Seleccione una opción");
        requestFocusComision(this.spinnerTipoMonedaComision);
        return false;
    }

    public boolean validateTipoMonedaComision() {
        if (this.spinnerTipoMonedaComision.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMonedaComision.setError("Seleccione el tipo de moneda");
            requestFocusComision(this.spinnerTipoMonedaComision);
            return false;
        }
        this.inputLayoutTipoMonedaComision.setErrorEnabled(false);
        return true;
    }

    public void showDialogCuentasComision() {
        CharSequence[] items = {"Insertar cuenta", "Listar mis cuentas"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        BaseCommissionAccountFragment yWo20QOWZz = BaseCommissionAccountFragment.this;
                        yWo20QOWZz.seleccionCuentaComision = jceCwl8l2R.NUEVA_CUENTA;
                        yWo20QOWZz.inputCuentaWriteComision.setText(BuildConfig.FLAVOR);
                        BaseCommissionAccountFragment.this.swCuentasBancoComision.setText(BuildConfig.FLAVOR);
                        BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(0);
                        BaseCommissionAccountFragment.this.inputLayoutMisCuentasComision.setVisibility(8);
                        BaseCommissionAccountFragment yWo20QOWZz2 = BaseCommissionAccountFragment.this;
                        yWo20QOWZz2.mcBankArrayAdapterComision = null;
                        yWo20QOWZz2.spinnerMisCuentasComision.setText(BuildConfig.FLAVOR);
                        BaseCommissionAccountFragment.this.miCuentaSeleccionComision = BuildConfig.FLAVOR;
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        if (BaseCommissionAccountFragment.this.cargarMisCuentasComision()) {
                            BaseCommissionAccountFragment yWo20QOWZz3 = BaseCommissionAccountFragment.this;
                            yWo20QOWZz3.seleccionCuentaComision = jceCwl8l2R.MIS_CUENTAS;
                            yWo20QOWZz3.inputCuentaWriteComision.setText(BuildConfig.FLAVOR);
                            BaseCommissionAccountFragment.this.swCuentasBancoComision.setText(BuildConfig.FLAVOR);
                            BaseCommissionAccountFragment.this.inputLayoutCuentaWriteComision.setVisibility(8);
                            BaseCommissionAccountFragment.this.inputLayoutMisCuentasComision.setVisibility(0);
                        } else {
                            BaseCommissionAccountFragment.this.showDialogNoTieneCuentasComision();
                            BaseCommissionAccountFragment.this.swCuentasBancoComision.setChecked(false);
                        }
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                BaseCommissionAccountFragment.this.swCuentasBancoComision.setChecked(false);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                BaseCommissionAccountFragment.this.swCuentasBanco.setChecked(false);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogNoTieneCuentasComision() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.BaseCommissionAccountFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }
}
