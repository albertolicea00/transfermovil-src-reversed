package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class kq0rlPklFL extends QGQCqILT4b {
    public static final int PICK_CONTACT_REQUEST = 1;
    public AccessibilityManager accessibilityManager;
    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoRecarga;
    public R1sDOSqZ2z agencia;
    public int banco;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    private Uri contactUri;
    public String displayContact;
    private TextInputLayout lyCuenta;
    private TextInputLayout lyMonto;
    public TextInputLayout lyTipoRecarga;
    public boolean pagoTotal = false;
    public jN13TOyLMX spTipoRecarga;
    public TextView txContacto;
    private AutoCompleteTextView txCuenta;
    private AutoCompleteTextView txMonto;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        this.context = context;
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.rootView = inflater.inflate(R.layout.m4lvapy8dlrub5, container, false);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    break;
                case 2:
                    this.banco = 2;
                    break;
                case 3:
                    this.banco = 3;
                    break;
            }
        }
        this.lyCuenta = (TextInputLayout) this.rootView.findViewById(R.id.lyCuenta);
        this.txCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCuenta);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.txCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                kq0rlPklFL.this.txCuenta.showDropDown();
            }
        });
        if (getArguments() != null && getArguments().containsKey("factura")) {
            this.txCuenta.setText(getArguments().get("factura").toString());
        }
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.lyMonto.setHint(getString(R.string.monto_moneda_en_cuc));
        initComponentesCuentas(this.rootView, this.agencia);
        if (this.accessibilityManager.isTouchExplorationEnabled()) {
            this.spTipoRecarga.setFocusable(true);
            this.spTipoRecarga.setClickable(true);
            this.spinnerTipoMoneda.setFocusable(true);
            this.spinnerTipoMoneda.setClickable(true);
        } else {
            this.spinnerTipoMoneda.setFocusable(false);
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kq0rlPklFL.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setImageResource(R.drawable.ico_contacts);
        this.btnBskContacto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || kq0rlPklFL.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    kq0rlPklFL.this.busk_contactos(v);
                } else {
                    kq0rlPklFL.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.txCuenta.getText().toString().trim();
        String monto = this.txMonto.getText().toString().trim();
        String msg = "¿ Desea recargar el TFA " + cuenta + ", con el monto en CUP: " + monto + " ?";
        String cadena = cuenta + "*" + monto + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTFA);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "108", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_hint_aviso));
        builder.setMessage(this.context.getString(R.string.err_no_tiene_cuentas));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean validateCuenta() {
        if (this.txCuenta.getText().toString().trim().isEmpty()) {
            this.lyCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCuenta);
            return false;
        }
        if (this.txCuenta.getText().toString().trim().length() != 8 && this.txCuenta.getText().toString().trim().length() != 10) {
            this.lyCuenta.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.txCuenta);
            return false;
        }
        this.lyCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.txMonto.getText().toString().trim().isEmpty()) {
                this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.txMonto);
                return false;
            }
            try {
                float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
                if (importe < 1.0f) {
                    this.lyMonto.setError(getString(R.string.err_msg_importe_inferior));
                    requestFocus(this.txMonto);
                    return false;
                }
                this.lyMonto.setErrorEnabled(false);
                return true;
            } catch (Exception e) {
                this.lyMonto.setError("Monto incorrecto");
                requestFocus(this.txMonto);
                return false;
            }
        }
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
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
            this.txCuenta.setText(telf);
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

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.5
            @Override // java.lang.Runnable
            public void run() {
                new androidx.appcompat.app.AlertDialog.Builder(kq0rlPklFL.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }
}
