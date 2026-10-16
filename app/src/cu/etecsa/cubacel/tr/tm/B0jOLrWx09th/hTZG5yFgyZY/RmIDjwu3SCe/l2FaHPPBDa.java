package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class l2FaHPPBDa extends Fragment implements FBsQzP3Zfj.UssdBaseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox checkBoxTitular;
    private Uri contactUri;
    public Context context;
    public String cuenta;
    public String cuentaCaracteres;
    public String displayContact;
    private AutoCompleteTextView inputAutorizo;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutAutorizo;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutPhoneConfirm;
    private TextInputLayout inputLayoutTerminal;
    private AutoCompleteTextView inputPhoneConfirm;
    private AutoCompleteTextView inputTerminal;
    public int keyDel;
    public View rootView;
    public Drawable tarjeta_clasica;
    public TextView txContacto;
    public int titular = 0;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || l2FaHPPBDa.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    l2FaHPPBDa.this.busk_contactos(v);
                } else {
                    l2FaHPPBDa.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.yzkxvibg3aiba, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutCuenta);
        this.inputLayoutAutorizo = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutAutorizo);
        this.inputLayoutTerminal = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutTerminal);
        this.inputLayoutPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_phone_confirm);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputCuenta);
        this.inputAutorizo = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputAutorizo);
        this.inputTerminal = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputTerminal);
        this.inputPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.btHelp = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.checkBoxTitular = (CheckBox) this.rootView.findViewById(R.id.checkBoxTitular);
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l2FaHPPBDa.this.submitForm();
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
        this.btHelp.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l2FaHPPBDa.this.mensajeAyuda("Ayuda", "Los datos solicitados Autorizo (Aut) y Terminal (TML) se obtienen de un comprobante de compra emitido por un POS.\nEl Titular de la cuenta debe marcar la casilla de verificación.\nEn Móvil a confirmar se debe ingresar el número móvil de la persona contrapartida de la operación.");
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateAutorizo() || !validateTerminal() || !validatePhone()) {
            return;
        }
        if (this.checkBoxTitular.isChecked()) {
            this.titular = 1;
        }
        this.cuenta = this.inputCuenta.getText().toString().trim();
        String autorizo = this.inputAutorizo.getText().toString().trim();
        String terminal = this.inputTerminal.getText().toString().trim();
        String phone = this.inputPhoneConfirm.getText().toString().trim();
        String msg = "Desea asociar la cuenta: " + this.cuenta.replace("-", BuildConfig.FLAVOR) + "?";
        String cuentaEnviar = this.cuenta.replace("-", BuildConfig.FLAVOR);
        String cadena = "08*" + cuentaEnviar + "*" + autorizo + "*" + terminal + "*" + phone + "*" + this.titular;
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
        if (!this.inputCuenta.getText().toString().replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
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

    private boolean validatePhone() {
        if (this.inputPhoneConfirm.getText().toString().trim().isEmpty()) {
            this.inputLayoutPhoneConfirm.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputPhoneConfirm);
            return false;
        }
        if (this.inputPhoneConfirm.getText().toString().trim().length() != 8 && this.inputPhoneConfirm.getText().toString().trim().length() != 10) {
            this.inputLayoutPhoneConfirm.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputPhoneConfirm);
            return false;
        }
        this.inputLayoutPhoneConfirm.setErrorEnabled(false);
        return true;
    }

    public void cuentaOrigenOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    l2FaHPPBDa.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.4
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 16) {
                    l2FaHPPBDa.this.inputCuenta.setText(l2FaHPPBDa.this.getCuentaFormateada(s.toString()));
                    return;
                }
                if (count == 0) {
                    l2FaHPPBDa.this.keyDel = 1;
                }
                boolean flag = true;
                String[] eachBlock = l2FaHPPBDa.this.inputCuenta.getText().toString().split("-");
                for (String str : eachBlock) {
                    if (str.length() > 4) {
                        flag = false;
                    }
                }
                if (!flag) {
                    l2FaHPPBDa.this.inputCuenta.setText(l2FaHPPBDa.this.cuentaCaracteres);
                    return;
                }
                l2FaHPPBDa l2fahppbda = l2FaHPPBDa.this;
                if (l2fahppbda.keyDel != 0) {
                    l2fahppbda.cuentaCaracteres = l2fahppbda.inputCuenta.getText().toString();
                    l2FaHPPBDa.this.keyDel = 0;
                    return;
                }
                if ((l2fahppbda.inputCuenta.getText().length() + 1) % 5 == 0 && l2FaHPPBDa.this.inputCuenta.getText().toString().split("-").length <= 3) {
                    l2FaHPPBDa.this.inputCuenta.setText(((Object) l2FaHPPBDa.this.inputCuenta.getText()) + "-");
                    l2FaHPPBDa.this.inputCuenta.setSelection(l2FaHPPBDa.this.inputCuenta.getText().length());
                }
                l2FaHPPBDa l2fahppbda2 = l2FaHPPBDa.this;
                l2fahppbda2.cuentaCaracteres = l2fahppbda2.inputCuenta.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String tarjeta = l2FaHPPBDa.this.inputCuenta.getText().toString().replace("-", BuildConfig.FLAVOR).trim();
                if (tarjeta.length() >= 6) {
                    if (tarjeta.startsWith("976004")) {
                        l2FaHPPBDa.this.inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, l2FaHPPBDa.this.tarjeta_clasica, (Drawable) null);
                    } else {
                        l2FaHPPBDa.this.inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
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
        Drawable drClasica = getResources().getDrawable(R.drawable.tarjeta_clasica_empresarial);
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
                R1sDOSqZ2z tipoBanco = R1sDOSqZ2z.CLASICAEMP;
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
        int inicio = mensaje.indexOf("Titular de la cuenta");
        int fin = "Titular de la cuenta".length() + inicio;
        int inicio1 = mensaje.indexOf("Móvil a confirmar");
        int fin1 = "Móvil a confirmar".length() + inicio1;
        spannableString.setSpan(new StyleSpan(1), inicio, fin, 33);
        spannableString.setSpan(new StyleSpan(1), inicio1, fin1, 33);
        spannableString.setSpan(new StyleSpan(1), inicioAut, finAut, 33);
        spannableString.setSpan(new StyleSpan(1), inicioTml, finTml, 33);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.5
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(l2FaHPPBDa.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.l2FaHPPBDa.5.1
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

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            Uri data2 = data.getData();
            this.contactUri = data2;
            renderContact(data2);
        }
    }

    private void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri).replace(" ", BuildConfig.FLAVOR).trim();
            if (telf.contains("+")) {
                telf = telf.substring(1);
            }
            if (telf.charAt(0) == '0') {
                telf = telf.substring(1);
            }
            if ((telf.substring(0, 3).toString().contains("535") || telf.substring(0, 3).toString().contains("536")) && telf.length() == 10) {
                telf = telf.substring(2);
            }
            this.inputPhoneConfirm.setText(telf);
            String str = this.displayContact;
            if (str != null && str.length() > 0) {
                this.txContacto.setVisibility(0);
                this.txContacto.setText(this.displayContact);
                this.displayContact = BuildConfig.FLAVOR;
                return;
            }
            this.txContacto.setVisibility(8);
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
            this.txContacto.setVisibility(8);
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        this.displayContact = BuildConfig.FLAVOR;
        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
        if (contactCursor.moveToFirst()) {
            id = contactCursor.getString(0);
        }
        contactCursor.close();
        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "display_name"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
        if (phoneCursor.moveToFirst()) {
            phone = phoneCursor.getString(0);
            this.displayContact = phoneCursor.getString(1);
        }
        phoneCursor.close();
        return phone;
    }
}
