package cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
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

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.wLHKkaC4Ha */
public class BandecRegistrationFragment extends Fragment implements pAzq93vIl3.UssdResponseObserver {
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
        this.rootView = inflater.inflate(R.layout.qeuk96upbfs2v, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutNombre = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nombre);
        this.inputNombre = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nombre);
        this.inputLayoutNombre.setHint("Nombre y apellidos");
        this.inputLayoutApellido1 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_apellido1);
        this.inputApellido1 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_apellido1);
        this.inputLayoutApellido1.setVisibility(8);
        this.inputApellido1.setVisibility(8);
        this.inputLayoutApellido2 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_apellido2);
        this.inputApellido2 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_apellido2);
        this.inputLayoutApellido2.setVisibility(8);
        this.inputApellido2.setVisibility(8);
        this.inputLayoutCi = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ci);
        this.inputLayoutCi.setHint(getString(R.string.hint_fecha_vencimiento));
        loadDrawables();
        cuentaOrigenOnListeners();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecRegistrationFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BandecRegistrationFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        boolean isPartialUSSD;
        if (!validateCuenta() || !validateNombreApp() || !validateFecha()) {
            return;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String cuenta2 = cuenta.contains("-") ? cuenta.replace("-", BuildConfig.FLAVOR) : cuenta;
        String nombre = this.inputNombre.getText().toString().trim();
        String ci = this.inputCi.getText().toString().trim();
        String cadena = "02*" + cuenta2 + "*" + nombre + "*" + ci;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
            isPartialUSSD = false;
        }
        if (!isPartialUSSD) {
            UssdDispatcher.actionCallUSSDBack(this.context, "49", cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "49", "02", this.MAX_PARAMETERS_PQUETE, cadena, "Desea registrarse en el sistema", group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().replace("-", BuildConfig.FLAVOR).trim().length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateFecha() {
        if (this.inputCi.getText().toString().trim().isEmpty()) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_empty_fecha));
            requestFocus(this.inputCi);
            return false;
        }
        if (this.inputCi.getText().toString().trim().length() != 4) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_empty_fecha_lenght));
            requestFocus(this.inputCi);
            return false;
        }
        int fechaMes = Integer.parseInt(this.inputCi.getText().toString().substring(2));
        if (fechaMes < 0 || fechaMes > 12) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_fecha_mes_err));
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private boolean validateNombreApp() {
        if (this.inputNombre.getText().toString().trim().isEmpty()) {
            this.inputLayoutNombre.setError(getString(R.string.err_msg_empty_full_nombre));
            requestFocus(this.inputNombre);
            return false;
        }
        this.inputLayoutNombre.setErrorEnabled(false);
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
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecRegistrationFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    BandecRegistrationFragment.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecRegistrationFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    BandecRegistrationFragment.this.inputCuenta.setText(BandecRegistrationFragment.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    BandecRegistrationFragment.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = BandecRegistrationFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    BandecRegistrationFragment.this.inputCuenta.setText(BandecRegistrationFragment.this.cuentaCaracteres);
                    return;
                }
                BandecRegistrationFragment wlhkkac4ha = BandecRegistrationFragment.this;
                if (wlhkkac4ha.keyDel != 0) {
                    wlhkkac4ha.cuentaCaracteres = wlhkkac4ha.inputCuenta.getText().toString();
                    BandecRegistrationFragment.this.keyDel = 0;
                    return;
                }
                int length = wlhkkac4ha.inputCuenta.getText().length() + 1;
                float length2 = (BandecRegistrationFragment.this.inputCuenta.getText().length() + 1) % 5;
                if ((BandecRegistrationFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && BandecRegistrationFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    BandecRegistrationFragment.this.inputCuenta.setText(((Object) BandecRegistrationFragment.this.inputCuenta.getText()) + "-");
                    BandecRegistrationFragment.this.inputCuenta.setSelection(BandecRegistrationFragment.this.inputCuenta.getText().length());
                }
                BandecRegistrationFragment wlhkkac4ha2 = BandecRegistrationFragment.this;
                wlhkkac4ha2.cuentaCaracteres = wlhkkac4ha2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BandecRegistrationFragment wlhkkac4ha = BandecRegistrationFragment.this;
                wlhkkac4ha.mostrarTarjeta(wlhkkac4ha.inputCuenta, BandecRegistrationFragment.this.inputCuenta.getText().toString());
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
            Drawable icon = null;
            switch (tipoBanco) {
                case 1: icon = this.tarjeta_bpa; break;
                case 2: icon = this.tarjeta_bandec; break;
                case 3: icon = this.tarjeta_metro; break;
                default: break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, icon, null);
        } catch (Exception ignored) {
            // Match the source: malformed prefixes leave the current drawable as-is.
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
