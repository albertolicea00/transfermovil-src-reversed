package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class HTmIvOo9nb extends Fragment implements FBsQzP3Zfj.UssdBaseObserver {
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    public Context context;
    public String cuenta;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputAutorizo;
    private AutoCompleteTextView inputCI;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutAutorizo;
    private TextInputLayout inputLayoutCI;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutTerminal;
    private AutoCompleteTextView inputTerminal;
    public int keyDel;
    public View rootView;
    public Drawable tarjeta_clasica;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.jdxp7ybexy1mx, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutCuenta);
        this.inputLayoutAutorizo = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutAutorizo);
        this.inputLayoutTerminal = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutTerminal);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputCuenta);
        this.inputAutorizo = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputAutorizo);
        this.inputTerminal = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputTerminal);
        this.btHelp = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HTmIvOo9nb.this.submitForm();
            }
        });
        loadDrawables();
        cuentaOrigenOnListeners();
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("Cuenta")) {
            String input = arg.getString("Cuenta");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append(input.charAt(i));
                int posInBlock = (i + 1) % 4;
                if (posInBlock == 0 && i != input.length() - 1) {
                    sb.append('-');
                }
            }
            this.inputCuenta.setText(sb.toString());
            this.inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.tarjeta_clasica, (Drawable) null);
        }
        this.btHelp.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HTmIvOo9nb.this.mensajeAyuda("Ayuda", "Los datos solicitados Autorizo (Aut) y Terminal (TML) se obtienen de un comprobante de compra emitido por un POS.");
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateAutorizo() || !validateTerminal()) {
            return;
        }
        this.cuenta = this.inputCuenta.getText().toString().trim();
        String autorizo = this.inputAutorizo.getText().toString().trim();
        String terminal = this.inputTerminal.getText().toString().trim();
        String msg = "Desea asociar la cuenta: " + this.cuenta.replace("-", BuildConfig.FLAVOR) + "?";
        String cuentaEnviar = this.cuenta.replace("-", BuildConfig.FLAVOR);
        String cadena = "08*" + cuentaEnviar + "*" + autorizo + "*" + terminal;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmAsocClasica);
        FBsQzP3Zfj.actionCallUSSDBackAsocClasica(this.context, "111", cadena, msg, group, getFragmentManager(), this);
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
        if (!this.inputCuenta.getText().toString().replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_err_tarjeta_clasica));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateAutorizo() {
        if (this.inputAutorizo.getText().toString().trim().isEmpty()) {
            this.inputLayoutAutorizo.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputAutorizo);
            return false;
        }
        if (this.inputAutorizo.getText().toString().trim().length() != 6) {
            this.inputLayoutAutorizo.setError(getString(R.string.err_msg_len_autorizo));
            requestFocus(this.inputAutorizo);
            return false;
        }
        this.inputLayoutAutorizo.setErrorEnabled(false);
        return true;
    }

    private boolean validateTerminal() {
        if (this.inputTerminal.getText().toString().trim().isEmpty()) {
            this.inputLayoutTerminal.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputTerminal);
            return false;
        }
        if (this.inputTerminal.getText().toString().trim().length() != 8) {
            this.inputLayoutTerminal.setError(getString(R.string.err_msg_len_terminal));
            requestFocus(this.inputTerminal);
            return false;
        }
        this.inputLayoutTerminal.setErrorEnabled(false);
        return true;
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    HTmIvOo9nb.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.4
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    HTmIvOo9nb.this.inputCuenta.setText(HTmIvOo9nb.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    HTmIvOo9nb.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = HTmIvOo9nb.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    HTmIvOo9nb.this.inputCuenta.setText(HTmIvOo9nb.this.cuentaCaracteres);
                    return;
                }
                HTmIvOo9nb hTmIvOo9nb = HTmIvOo9nb.this;
                if (hTmIvOo9nb.keyDel != 0) {
                    hTmIvOo9nb.cuentaCaracteres = hTmIvOo9nb.inputCuenta.getText().toString();
                    HTmIvOo9nb.this.keyDel = 0;
                    return;
                }
                int length = hTmIvOo9nb.inputCuenta.getText().length() + 1;
                float length2 = (HTmIvOo9nb.this.inputCuenta.getText().length() + 1) % 5;
                if ((HTmIvOo9nb.this.inputCuenta.getText().length() + 1) % 5 == 0 && HTmIvOo9nb.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    HTmIvOo9nb.this.inputCuenta.setText(((Object) HTmIvOo9nb.this.inputCuenta.getText()) + "-");
                    HTmIvOo9nb.this.inputCuenta.setSelection(HTmIvOo9nb.this.inputCuenta.getText().length());
                }
                HTmIvOo9nb hTmIvOo9nb2 = HTmIvOo9nb.this;
                hTmIvOo9nb2.cuentaCaracteres = hTmIvOo9nb2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String tarjeta = HTmIvOo9nb.this.inputCuenta.getText().toString().replace("-", BuildConfig.FLAVOR).trim();
                if (tarjeta.length() >= 6) {
                    if (tarjeta.startsWith("976003")) {
                        HTmIvOo9nb.this.inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, HTmIvOo9nb.this.tarjeta_clasica, (Drawable) null);
                    } else {
                        HTmIvOo9nb.this.inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            }
        });
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

    public void loadDrawables() {
        Drawable drClasica = getResources().getDrawable(R.drawable.tarjeta_clasica);
        Bitmap bitmapClasica = ((BitmapDrawable) drClasica).getBitmap();
        this.tarjeta_clasica = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapClasica, 80, 60, true));
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj.UssdBaseObserver
    public void onCloseAndBack() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj.UssdBaseObserver
    public void onClose(boolean result) {
        if (result) {
            int perfil = 0;
            Bundle arg = getArguments();
            if (arg != null && arg.containsKey("PerfilCUenta")) {
                perfil = arg.getInt("PerfilCUenta");
            }
            if (perfil != 1) {
                qTDVwLFEjE currencyEntity = qTDVwLFEjE.USD;
                MCBank cuentaBanco = new MCBank();
                R1sDOSqZ2z tipoBanco = R1sDOSqZ2z.MiTransfer;
                String alias = "Clásica-" + this.cuenta.split("-")[3];
                cuentaBanco.setAlias(alias);
                if (this.cuenta.contains("-")) {
                    this.cuenta = this.cuenta.replace("-", BuildConfig.FLAVOR);
                }
                cuentaBanco.setCuenta(this.cuenta);
                cuentaBanco.setTipo_moneda(currencyEntity);
                cuentaBanco.setAgencia(tipoBanco);
                rDEl7rW1aN baseActivity = new rDEl7rW1aN();
                if (unYp8VQThY.getInstance().getMiCuenta(baseActivity.encryption(this.cuenta)).size() == 0 && unYp8VQThY.getInstance().getMisCuentasAlias(alias).size() == 0) {
                    unYp8VQThY.init(this.context);
                    unYp8VQThY.getInstance().addMCBank(cuentaBanco);
                }
            } else {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
            FragmentManager fragmentManager2 = getFragmentManager();
            fragmentManager2.popBackStack();
        }
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        int inicioAut = mensaje.indexOf("Autorizo (Aut)");
        int finAut = "Autorizo (Aut)".length() + inicioAut;
        int inicioTml = mensaje.indexOf("Terminal (TML)");
        int finTml = "Terminal (TML)".length() + inicioTml;
        spannableString.setSpan(new StyleSpan(1), inicioAut, finAut, 33);
        spannableString.setSpan(new StyleSpan(1), inicioTml, finTml, 33);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.5
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(HTmIvOo9nb.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
                alertDialog.show();
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                if (textView != null) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        });
    }
}
