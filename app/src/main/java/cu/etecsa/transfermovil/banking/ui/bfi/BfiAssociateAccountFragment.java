package cu.etecsa.transfermovil.banking.ui.bfi;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import java.util.Random;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.F2leFVNWrdy */

/* JADX INFO: loaded from: classes.dex */
public class BfiAssociateAccountFragment extends EV9Tu0zIL4 {
    private Button btnAceptar;
    public Context context;
    private String coordenadasA;
    private String coordenadasB;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCoordenadas;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCoordenadas;
    private TextInputLayout inputLayoutCuenta;
    public int keyDel;
    public boolean lock;
    public String mensajeCuentaOrigen;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public TextView toolbar_title;
    private String[] letrasMatriz = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[] numerosMatriz = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public boolean isConfirm = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.e1ewxrhfitjnet, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCoordenadas = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_coordenadas);
        this.inputLayoutCoordenadas = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_coordenadas);
        Random random = new Random();
        this.coordenadasA = this.letrasMatriz[random.nextInt(10)] + this.numerosMatriz[random.nextInt(10)];
        this.inputLayoutCoordenadas.setHint("Valor de la coordenada: " + this.coordenadasA);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText("Asociar cuenta");
        initSeparator();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.BfiAssociateAccountFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BfiAssociateAccountFragment.this.submitForm();
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
        if (!validateCuenta(cuenta) || !validateCoordenadas()) {
            return;
        }
        String coordenadasMatriz = this.coordenadasA;
        String valorCoordenadas = this.inputCoordenadas.getText().toString().trim();
        String cadena = cuenta + "*" + coordenadasMatriz + "*" + valorCoordenadas;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "60", cadena, "Desea actualizar su cuenta", group, getFragmentManager());
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
        if (!validateCuentaOrigen(this.inputCuenta.getText().toString().trim())) {
            if (!this.isConfirm) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setTitle("Advertencia");
                builder.setMessage(this.mensajeCuentaOrigen);
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.BfiAssociateAccountFragment.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        BfiAssociateAccountFragment f2leFVNWrdy = BfiAssociateAccountFragment.this;
                        f2leFVNWrdy.isConfirm = true;
                        f2leFVNWrdy.submitForm();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.BfiAssociateAccountFragment.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
                return false;
            }
            return true;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCoordenadas() {
        if (this.inputCoordenadas.getText().toString().trim().isEmpty() || this.inputCoordenadas.getText().toString().trim().length() != 2) {
            this.inputLayoutCoordenadas.setError("Coordenada incorrecta");
            requestFocus(this.inputCoordenadas);
            return false;
        }
        this.inputLayoutCoordenadas.setErrorEnabled(false);
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
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.BfiAssociateAccountFragment.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        BfiAssociateAccountFragment.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.BfiAssociateAccountFragment.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    try {
                        BfiAssociateAccountFragment.this.keyDel = 1;
                    } catch (Exception ex) {
                        Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                        return;
                    }
                }
                boolean flag = true;
                String[] eachBlock = BfiAssociateAccountFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    BfiAssociateAccountFragment.this.inputCuenta.setText(BfiAssociateAccountFragment.this.cuentaCaracteres);
                    return;
                }
                BfiAssociateAccountFragment f2leFVNWrdy = BfiAssociateAccountFragment.this;
                if (f2leFVNWrdy.keyDel == 0) {
                    int length = f2leFVNWrdy.inputCuenta.getText().length() + 1;
                    float length2 = (BfiAssociateAccountFragment.this.inputCuenta.getText().length() + 1) % 5;
                    if ((BfiAssociateAccountFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && BfiAssociateAccountFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                        BfiAssociateAccountFragment.this.inputCuenta.setText(((Object) BfiAssociateAccountFragment.this.inputCuenta.getText()) + "-");
                        BfiAssociateAccountFragment.this.inputCuenta.setSelection(BfiAssociateAccountFragment.this.inputCuenta.getText().length());
                    }
                    BfiAssociateAccountFragment f2leFVNWrdy2 = BfiAssociateAccountFragment.this;
                    f2leFVNWrdy2.cuentaCaracteres = f2leFVNWrdy2.inputCuenta.getText().toString();
                    return;
                }
                f2leFVNWrdy.cuentaCaracteres = f2leFVNWrdy.inputCuenta.getText().toString();
                BfiAssociateAccountFragment.this.keyDel = 0;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BfiAssociateAccountFragment f2leFVNWrdy = BfiAssociateAccountFragment.this;
                f2leFVNWrdy.mostrarTarjeta(f2leFVNWrdy.inputCuenta, BfiAssociateAccountFragment.this.inputCuenta.getText().toString());
            }
        });
    }

    /** Renders BPA, BANDEC, or Metropolitano card art from the entered account. */
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
                }
            }
            Drawable tarjetaDrawable;
            switch (tipoBanco) {
                case 1: tarjetaDrawable = this.tarjeta_bpa; break;
                case 2: tarjetaDrawable = this.tarjeta_bandec; break;
                case 3: tarjetaDrawable = this.tarjeta_metro; break;
                default: tarjetaDrawable = null; break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, tarjetaDrawable, null);
        } catch (Exception ignored) {
            // Incomplete card values are ignored while the user types.
        }
    }

                private boolean validateCuentaOrigen(String cuenta) {
                    EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(cuenta.replace("-", BuildConfig.FLAVOR));
                    this.mensajeCuentaOrigen = BuildConfig.FLAVOR;
                    if (!datosTarjeta.isValidBank) {
                        this.mensajeCuentaOrigen = this.context.getString(R.string.alert_msg_no_bank);
                        return false;
                    }
                    return true;
                }
            }
