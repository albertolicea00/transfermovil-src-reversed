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
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;

/* JADX INFO: loaded from: classes.dex */
public class uKzekWA2jf extends QGQCqILT4b implements pAzq93vIl3.UssdResponseObserver {
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
    public pAzq93vIl3 manager;
    public jN13TOyLMX spTipoRecarga;
    public TipoRecargaEnum tipo;
    public TextView txContacto;
    private AutoCompleteTextView txCuenta;
    private AutoCompleteTextView txMonto;
    public boolean pagoTotal = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public jN13TOyLMX.OnItemClickListener spClickTipoRecarga = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            uKzekWA2jf.this.inputLayoutCuentaWrite.setVisibility(8);
            uKzekWA2jf.this.inputLayoutMisCuentas.setVisibility(8);
            uKzekWA2jf.this.mcBankArrayAdapter = null;
            uKzekWA2jf.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
            uKzekWA2jf.this.spinnerTipoMoneda.setText(BuildConfig.FLAVOR);
            if (uKzekWA2jf.this.bancoEntity != null && uKzekWA2jf.this.bancoEntity == R1sDOSqZ2z.BANDEC) {
                uKzekWA2jf.this.swCuentasBanco.setChecked(false);
            }
        }
    };

    public enum TipoRecargaEnum {
        Movil,
        MovilPlus
    }

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
        this.manager = new pAzq93vIl3(this.context, this);
        try {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                this.rootView = inflater.inflate(R.layout.c6dylu1efiype, container, false);
            } else {
                this.rootView = inflater.inflate(R.layout.c6dylu1efiype, container, false);
            }
        } catch (Exception e) {
            this.rootView = inflater.inflate(R.layout.c6dylu1efiype, container, false);
        }
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass8.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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
        this.lyTipoRecarga = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoRecarga);
        this.spTipoRecarga = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoRecarga);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_recarga, android.R.layout.simple_list_item_1);
        this.adapterTipoRecarga = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTipoRecarga.setAdapter(this.adapterTipoRecarga);
        this.spTipoRecarga.setOnItemClickListener(this.spClickTipoRecarga);
        this.lyCuenta = (TextInputLayout) this.rootView.findViewById(R.id.lyCuenta);
        this.txCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCuenta);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.txCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                uKzekWA2jf.this.txCuenta.showDropDown();
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
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uKzekWA2jf.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setImageResource(R.drawable.ico_contacts);
        this.btnBskContacto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || uKzekWA2jf.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    uKzekWA2jf.this.busk_contactos(v);
                } else {
                    uKzekWA2jf.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uKzekWA2jf.this.mensajeAyuda("Ayuda", "Utilizando esta opción usted puede transferir saldo desde una tarjeta bancaria hacia la cuenta CUP del Monedero MiTransfer.");
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
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
        String msg;
        super.submitForm();
        if (!validateCuenta() || !validateMonto() || !validateSelectionAccounts() || !validateSeleccionBandec()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.txCuenta.getText().toString().trim();
        try {
            switch (this.monedaTarjeta) {
            }
        } catch (Exception e) {
        }
        EV9Tu0zIL4.DatosTarjeta datosTarjeta = validarCuenta(this.cuentaOrigen);
        String monto = this.txMonto.getText().toString().trim();
        String msg2 = "¿ Desea recargar su cuenta CUP " + cuenta + ", con el monto en CUP: " + monto + "?";
        if (datosTarjeta.currency == qTDVwLFEjE.USD) {
            msg = msg2 + " La moneda de la cuenta seleccionada: (" + this.cuentaOrigen + ") es MLC.";
        } else if (this.cuentaOrigen == "0000") {
            msg = msg2;
        } else {
            msg = msg2 + " La cuenta seleccionada es: (" + this.cuentaOrigen + ").";
        }
        String cadena = "1*" + cuenta + "*" + monto + "*1*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e2) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "29", cadena, msg, group, getFragmentManager());
            return;
        }
        this.manager.principalEnviarUSSD(this.context, "110", "29", "0" + this.banco, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_hint_aviso));
        builder.setMessage(this.context.getString(R.string.err_no_tiene_cuentas));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.6
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
        String montoStr = this.txMonto.getText().toString().trim();
        if (!this.pagoTotal) {
            if (this.txMonto.getText().toString().trim().isEmpty()) {
                this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.txMonto);
                return false;
            }
            if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
                this.lyMonto.setError("No se permiten ceros a la izquierda");
                requestFocus(this.txMonto);
                return false;
            }
            if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
                this.lyMonto.setError("Formato de monto inválido");
                requestFocus(this.txMonto);
                return false;
            }
            if (montoStr.matches("^0+[1-9]+\\.$")) {
                this.lyMonto.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
                requestFocus(this.txMonto);
                return false;
            }
            if (montoStr.endsWith(".")) {
                this.lyMonto.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
                requestFocus(this.txMonto);
                return false;
            }
            if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
                this.lyMonto.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
                requestFocus(this.txMonto);
                return false;
            }
            if (montoStr.equals("0") || montoStr.equals("0.")) {
                this.lyMonto.setError("El monto debe ser mayor a 0");
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

    public boolean validateSeleccionBandec() {
        if (this.bancoEntity == R1sDOSqZ2z.BANDEC && !this.swCuentasBanco.isChecked()) {
            this.swCuentasBanco.setError("Debe seleccionar una cuenta");
            Toast.makeText(this.context, "Debe seleccionar una cuenta", 0).show();
            requestFocus(this.swCuentasBanco);
            return false;
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
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.7
            @Override // java.lang.Runnable
            public void run() {
                new androidx.appcompat.app.AlertDialog.Builder(uKzekWA2jf.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
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
