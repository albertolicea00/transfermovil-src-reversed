package cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations;

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
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.HgJHxigegS */
public class BandecCardInfoQueryFragment extends Fragment {
    public Button btnAceptar;
    public Context context;
    public String cuenta;
    public String cuentaCaracteres;
    public String descripcion;
    public AutoCompleteTextView inputCuenta;
    public AutoCompleteTextView inputDescripcion;
    public TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutDescripcion;
    public int keyDel;
    public boolean lock;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String toolbar_title;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.uem9sttylzu9t, container, false);
        this.rootView = viewInflate;
        this.inputLayoutCuenta = (TextInputLayout) viewInflate.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        initSeparator();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecCardInfoQueryFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BandecCardInfoQueryFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String strTrim = this.inputCuenta.getText().toString().trim();
        this.cuenta = strTrim;
        if (strTrim.contains("-")) {
            this.cuenta = this.cuenta.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta(this.cuenta)) {
            return;
        }
        String msg = "Desea consultar el estado de la tarjeta: " + this.cuenta;
        String cadena = this.cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "78", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta(String cuenta) {
        if (cuenta.isEmpty()) {
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
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecCardInfoQueryFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        BandecCardInfoQueryFragment.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.BandecCardInfoQueryFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    try {
                        BandecCardInfoQueryFragment.this.keyDel = 1;
                    } catch (Exception ex) {
                        Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                        return;
                    }
                }
                boolean flag = true;
                String[] eachBlock = BandecCardInfoQueryFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {
                    BandecCardInfoQueryFragment hgJHxigegS = BandecCardInfoQueryFragment.this;
                    if (hgJHxigegS.keyDel == 0) {
                        int length = hgJHxigegS.inputCuenta.getText().length() + 1;
                        float length2 = (BandecCardInfoQueryFragment.this.inputCuenta.getText().length() + 1) % 5;
                        if ((BandecCardInfoQueryFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && BandecCardInfoQueryFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                            BandecCardInfoQueryFragment.this.inputCuenta.setText(((Object) BandecCardInfoQueryFragment.this.inputCuenta.getText()) + "-");
                            AutoCompleteTextView autoCompleteTextView = BandecCardInfoQueryFragment.this.inputCuenta;
                            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
                        }
                        BandecCardInfoQueryFragment hgJHxigegS2 = BandecCardInfoQueryFragment.this;
                        hgJHxigegS2.cuentaCaracteres = hgJHxigegS2.inputCuenta.getText().toString();
                        return;
                    }
                    hgJHxigegS.cuentaCaracteres = hgJHxigegS.inputCuenta.getText().toString();
                    BandecCardInfoQueryFragment.this.keyDel = 0;
                    return;
                }
                BandecCardInfoQueryFragment hgJHxigegS3 = BandecCardInfoQueryFragment.this;
                hgJHxigegS3.inputCuenta.setText(hgJHxigegS3.cuentaCaracteres);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BandecCardInfoQueryFragment hgJHxigegS = BandecCardInfoQueryFragment.this;
                AutoCompleteTextView autoCompleteTextView = hgJHxigegS.inputCuenta;
                hgJHxigegS.mostrarTarjeta(autoCompleteTextView, autoCompleteTextView.getText().toString());
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
            // The source leaves the current drawable unchanged when a prefix is malformed.
        }
    }
