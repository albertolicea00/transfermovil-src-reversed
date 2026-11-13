package cu.etecsa.transfermovil.banking.ui.metro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.RFBEnXW0Xr */
public class MetroCubacelPlanPurchaseFragment extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public int MAX_PARAMETERS_PQUETE = 3;
    private Button btnAceptar;
    public Context context;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputApellido1;
    private AutoCompleteTextView inputApellido2;
    private AutoCompleteTextView inputCi;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutApellido1;
    private TextInputLayout inputLayoutApellido2;
    private TextInputLayout inputLayoutCi;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutNombre;
    private AutoCompleteTextView inputNombre;
    public int keyDel;
    public boolean lock;
    public pAzq93vIl3 manager;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.rebqw4tatagcq, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.hint_tarj_telebanca));
        this.inputLayoutNombre = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nombre);
        this.inputNombre = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nombre);
        this.inputLayoutApellido1 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_apellido1);
        this.inputApellido1 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_apellido1);
        this.inputLayoutApellido2 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_apellido2);
        this.inputApellido2 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_apellido2);
        this.inputLayoutCi = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci);
        try {
            InputFilter[] fArray = {new InputFilter.LengthFilter(16)};
            this.inputCuenta.setFilters(fArray);
            loadDrawables();
        } catch (Exception e) {
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.MetroCubacelPlanPurchaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetroCubacelPlanPurchaseFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        boolean isPartialUSSD;
        if (!validateCuenta() || !validateNombreApp() || !validateCi()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String nombre = this.inputNombre.getText().toString().trim();
        String apellido1 = this.inputApellido1.getText().toString().trim();
        String apellido2 = this.inputApellido2.getText().toString().trim();
        String ci = this.inputCi.getText().toString().trim();
        String cadena = "03*" + cuenta + "*" + nombre + "*" + apellido1 + "*" + apellido2 + "*" + ci;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
            isPartialUSSD = false;
        }
        if (!isPartialUSSD) {
            UssdDispatcher.actionCallUSSDBack(this.context, "49", cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "49", "03", this.MAX_PARAMETERS_PQUETE, cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty() || !this.inputCuenta.getText().toString().trim().substring(0, 2).contains("95")) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_err_tarjeta_telebanca));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 10) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_tarjeta_telebanca));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCi() {
        if (this.inputCi.getText().toString().trim().isEmpty()) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private boolean validateNombreApp() {
        if (this.inputNombre.getText().toString().trim().isEmpty()) {
            this.inputLayoutNombre.setError(getString(R.string.err_msg_empty_nombre));
            requestFocus(this.inputNombre);
            return false;
        }
        if (this.inputApellido1.getText().toString().trim().isEmpty()) {
            this.inputLayoutApellido1.setError(getString(R.string.err_msg_empty_apellido));
            requestFocus(this.inputApellido1);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public String reemplazarCaracteresRaros(String input) {
        String output = input;
        for (int i = 0; i < "àèìòùÀÉËÌÓÚçÇ".length(); i++) {
            output = output.replace("àèìòùÀÉËÌÓÚçÇ".charAt(i), "aeiouAEIIOUcC".charAt(i));
        }
        return output;
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.MetroCubacelPlanPurchaseFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    MetroCubacelPlanPurchaseFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.MetroCubacelPlanPurchaseFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    MetroCubacelPlanPurchaseFragment.this.inputCuenta.setText(MetroCubacelPlanPurchaseFragment.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    MetroCubacelPlanPurchaseFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    MetroCubacelPlanPurchaseFragment.this.inputCuenta.setText(MetroCubacelPlanPurchaseFragment.this.cuentaCaracteres);
                    return;
                }
                MetroCubacelPlanPurchaseFragment rFBEnXW0Xr = MetroCubacelPlanPurchaseFragment.this;
                if (rFBEnXW0Xr.keyDel != 0) {
                    rFBEnXW0Xr.cuentaCaracteres = rFBEnXW0Xr.inputCuenta.getText().toString();
                    MetroCubacelPlanPurchaseFragment.this.keyDel = 0;
                    return;
                }
                int length = rFBEnXW0Xr.inputCuenta.getText().length() + 1;
                float length2 = (MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().length() + 1) % 5;
                if ((MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    MetroCubacelPlanPurchaseFragment.this.inputCuenta.setText(((Object) MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText()) + "-");
                    MetroCubacelPlanPurchaseFragment.this.inputCuenta.setSelection(MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().length());
                }
                MetroCubacelPlanPurchaseFragment rFBEnXW0Xr2 = MetroCubacelPlanPurchaseFragment.this;
                rFBEnXW0Xr2.cuentaCaracteres = rFBEnXW0Xr2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                MetroCubacelPlanPurchaseFragment rFBEnXW0Xr = MetroCubacelPlanPurchaseFragment.this;
                rFBEnXW0Xr.mostrarTarjeta(rFBEnXW0Xr.inputCuenta, MetroCubacelPlanPurchaseFragment.this.inputCuenta.getText().toString());
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
                    String codigo = tarjeta.substring(5, 7);
                    if ("12".equals(codigo)) tipoBanco = 1;
                    else if ("06".equals(codigo)) tipoBanco = 2;
                    else if ("95".equals(codigo)) tipoBanco = 3;
                } else {
                    String codigo = tarjeta.substring(0, 2);
                    if ("12".equals(codigo)) tipoBanco = 1;
                    else if ("06".equals(codigo)) tipoBanco = 2;
                    else if ("05".equals(codigo)) tipoBanco = 3;
                }
            }
            Drawable drawable;
            switch (tipoBanco) {
                case 1: drawable = this.tarjeta_bpa; break;
                case 2: drawable = this.tarjeta_bandec; break;
                case 3: drawable = this.tarjeta_metro; break;
                default: drawable = null; break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null);
        } catch (Exception ignored) {
            // Match smali behavior for malformed or incomplete account identifiers.
        }
    }
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
                public void onUssdResponseReceived(String response) {
                }

                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
                public void onCloseAndBack() {
                    try {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.popBackStack();
                    } catch (Exception e) {
                        try {
                            getActivity().onBackPressed();
                        } catch (Exception e2) {
                        }
                    }
                }
            }
