package cu.etecsa.transfermovil.banking.ui.bpa;

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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.auVvnTnpCQ */
public class BpaCloseFixedTermFragment extends Fragment {
    private Button btnAceptar;
    public Context context;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCoordenadas;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCoordenadas;
    private TextInputLayout inputLayoutCuenta;
    public int keyDel;
    public boolean lock;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    private TextView titleMain;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.bh6zcverawzt7, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        initSeparator();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.BpaCloseFixedTermFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BpaCloseFixedTermFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String cuenta = this.inputCuenta.getText().toString().trim();
        if (cuenta.contains("-")) {
            cuenta = cuenta.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta(cuenta)) {
            return;
        }
        String msg = "Desea cerrar la cuenta a plazo fijo: " + cuenta;
        String cadena = cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        UssdDispatcher.actionCallUSSDBack(this.context, "82", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta(String cuenta) {
        if (cuenta.trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (cuenta.length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
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
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.BpaCloseFixedTermFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        BpaCloseFixedTermFragment.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.BpaCloseFixedTermFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    try {
                        BpaCloseFixedTermFragment.this.keyDel = 1;
                    } catch (Exception ex) {
                        Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                        return;
                    }
                }
                boolean flag = true;
                String[] eachBlock = BpaCloseFixedTermFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    BpaCloseFixedTermFragment.this.inputCuenta.setText(BpaCloseFixedTermFragment.this.cuentaCaracteres);
                    return;
                }
                BpaCloseFixedTermFragment auvvntnpcq = BpaCloseFixedTermFragment.this;
                if (auvvntnpcq.keyDel == 0) {
                    int length = auvvntnpcq.inputCuenta.getText().length() + 1;
                    float length2 = (BpaCloseFixedTermFragment.this.inputCuenta.getText().length() + 1) % 5;
                    if ((BpaCloseFixedTermFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && BpaCloseFixedTermFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                        BpaCloseFixedTermFragment.this.inputCuenta.setText(((Object) BpaCloseFixedTermFragment.this.inputCuenta.getText()) + "-");
                        BpaCloseFixedTermFragment.this.inputCuenta.setSelection(BpaCloseFixedTermFragment.this.inputCuenta.getText().length());
                    }
                    BpaCloseFixedTermFragment auvvntnpcq2 = BpaCloseFixedTermFragment.this;
                    auvvntnpcq2.cuentaCaracteres = auvvntnpcq2.inputCuenta.getText().toString();
                    return;
                }
                auvvntnpcq.cuentaCaracteres = auvvntnpcq.inputCuenta.getText().toString();
                BpaCloseFixedTermFragment.this.keyDel = 0;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BpaCloseFixedTermFragment auvvntnpcq = BpaCloseFixedTermFragment.this;
                auvvntnpcq.mostrarTarjeta(auvvntnpcq.inputCuenta, BpaCloseFixedTermFragment.this.inputCuenta.getText().toString());
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
            // Match the original smali behavior for malformed account identifiers.
        }
    }
}
