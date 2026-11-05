package cu.etecsa.transfermovil.banking.ui.metro;

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
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.OqcjrfuV9V */
public class MetroCoordinatesTransferFragment extends Fragment {
    private Button btnAceptar;
    public Context context;
    private String coordenadasA;
    private String coordenadasB;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCoordenadas;
    private AutoCompleteTextView inputCoordenadas2;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCoordenadas;
    private TextInputLayout inputLayoutCoordenadas2;
    private TextInputLayout inputLayoutCuenta;
    public int keyDel;
    public boolean lock;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    private String[] letrasMatriz = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[] numerosMatriz = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.g0cqzifteyml1p, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCoordenadas = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_coordenadas);
        this.inputLayoutCoordenadas = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_coordenadas);
        this.inputCoordenadas2 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_coordenadas2);
        this.inputLayoutCoordenadas2 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_coordenadas2);
        Random random = new Random();
        this.coordenadasA = this.letrasMatriz[random.nextInt(10)] + this.numerosMatriz[random.nextInt(10)];
        this.inputLayoutCoordenadas.setHint("Valor de la coordenada: " + this.coordenadasA);
        initSeparator();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.MetroCoordinatesTransferFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetroCoordinatesTransferFragment.this.submitForm();
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
        String str = this.coordenadasB;
        this.inputCoordenadas2.getText().toString().trim();
        String cadena = cuenta + "*" + coordenadasMatriz + "*" + valorCoordenadas;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "79", cadena, "Confirme que desea generar el código pin", group, getFragmentManager());
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

    private boolean validateCoordenadas() {
        if (this.inputCoordenadas.getText().toString().trim().isEmpty() || this.inputCoordenadas.getText().toString().trim().length() != 2) {
            this.inputLayoutCoordenadas.setError("Coordenada incorrecta");
            requestFocus(this.inputCoordenadas);
            return false;
        }
        this.inputLayoutCoordenadas.setErrorEnabled(false);
        return true;
    }

    private boolean validateCoordenadas2() {
        if (this.inputCoordenadas2.getText().toString().trim().isEmpty() || this.inputCoordenadas2.getText().toString().trim().length() != 2) {
            this.inputLayoutCoordenadas2.setError("Coordenada incorrecta");
            requestFocus(this.inputCoordenadas2);
            return false;
        }
        this.inputLayoutCoordenadas2.setErrorEnabled(false);
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
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.MetroCoordinatesTransferFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        MetroCoordinatesTransferFragment.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.MetroCoordinatesTransferFragment.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    try {
                        MetroCoordinatesTransferFragment.this.keyDel = 1;
                    } catch (Exception ex) {
                        Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                        return;
                    }
                }
                boolean flag = true;
                String[] eachBlock = MetroCoordinatesTransferFragment.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    MetroCoordinatesTransferFragment.this.inputCuenta.setText(MetroCoordinatesTransferFragment.this.cuentaCaracteres);
                    return;
                }
                MetroCoordinatesTransferFragment oqcjrfuV9V = MetroCoordinatesTransferFragment.this;
                if (oqcjrfuV9V.keyDel == 0) {
                    int length = oqcjrfuV9V.inputCuenta.getText().length() + 1;
                    float length2 = (MetroCoordinatesTransferFragment.this.inputCuenta.getText().length() + 1) % 5;
                    if ((MetroCoordinatesTransferFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && MetroCoordinatesTransferFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                        MetroCoordinatesTransferFragment.this.inputCuenta.setText(((Object) MetroCoordinatesTransferFragment.this.inputCuenta.getText()) + "-");
                        MetroCoordinatesTransferFragment.this.inputCuenta.setSelection(MetroCoordinatesTransferFragment.this.inputCuenta.getText().length());
                    }
                    MetroCoordinatesTransferFragment oqcjrfuV9V2 = MetroCoordinatesTransferFragment.this;
                    oqcjrfuV9V2.cuentaCaracteres = oqcjrfuV9V2.inputCuenta.getText().toString();
                    return;
                }
                oqcjrfuV9V.cuentaCaracteres = oqcjrfuV9V.inputCuenta.getText().toString();
                MetroCoordinatesTransferFragment.this.keyDel = 0;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                MetroCoordinatesTransferFragment oqcjrfuV9V = MetroCoordinatesTransferFragment.this;
                oqcjrfuV9V.mostrarTarjeta(oqcjrfuV9V.inputCuenta, MetroCoordinatesTransferFragment.this.inputCuenta.getText().toString());
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
            // Match smali behavior for malformed or incomplete account identifiers.
        }
    }
}
