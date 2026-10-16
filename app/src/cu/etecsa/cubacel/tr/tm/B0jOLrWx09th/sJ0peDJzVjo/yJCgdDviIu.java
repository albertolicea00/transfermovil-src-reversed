package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yJCgdDviIu extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoCuenta;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private Uri contactUri;
    public Context context;
    public float importe;
    private AutoCompleteTextView inputCuenta;
    private TextInputEditText inputImporte;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutImporte;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoCuenta;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputNumeroDestinatario;
    public View rootView;
    public jN13TOyLMX spinnerTipoCuenta;
    public jN13TOyLMX spinnerTipoMoneda;
    public String[] tipos;
    public int banco = 0;
    public String cuenta = BuildConfig.FLAVOR;
    public int tipoCuenta = 0;
    public String nombreTipoCuenta = BuildConfig.FLAVOR;
    public int moneda = 0;
    public String movil = "0000000";
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (yJCgdDviIu.this.isFieldsOK()) {
                try {
                    yJCgdDviIu.this.enviarUSSD();
                    yJCgdDviIu.this.nuevoDatos();
                } catch (Exception e) {
                }
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || yJCgdDviIu.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    yJCgdDviIu.this.busk_contactos(v);
                } else {
                    yJCgdDviIu.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            yJCgdDviIu.this.tipoCuenta = position + 1;
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            yJCgdDviIu.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.punmdxs1r7a5u, container, false);
        this.context = container.getContext();
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
        loadViewUI(this.rootView);
        loadData();
        this.tipos = getResources().getStringArray(R.array.array_tipo_cuenta_nauta);
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu$8, reason: invalid class name */
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

    public void loadViewUI(View v) {
        this.inputCuenta = (AutoCompleteTextView) v.findViewById(R.id.inputCuenta);
        this.inputLayoutCuenta = (TextInputLayout) v.findViewById(R.id.inputLayoutCuenta);
        this.spinnerTipoCuenta = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoCuenta);
        this.inputLayoutTipoCuenta = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoCuenta);
        this.inputImporte = (TextInputEditText) v.findViewById(R.id.inputImporte);
        this.inputLayoutImporte = (TextInputLayout) v.findViewById(R.id.inputLayoutImporte);
        this.spinnerTipoMoneda = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoMoneda);
        TextInputLayout textInputLayout = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoMoneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        if (this.banco == 2) {
            textInputLayout.setVisibility(8);
        }
        this.inputNumeroDestinatario = (AutoCompleteTextView) v.findViewById(R.id.inputNumeroDestinatario);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) v.findViewById(R.id.inputLayoutNumeroDestinatario);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cuenta_nauta, android.R.layout.simple_list_item_1);
        this.adapterTipoCuenta = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoCuenta.setAdapter(this.adapterTipoCuenta);
        this.spinnerTipoCuenta.setOnItemClickListener(this.spClickTipo);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        this.cuenta.toLowerCase();
        if (this.cuenta.contains("ERROR")) {
            Log.d("CADENA", "cadena vacia");
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
        String cadena = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*" + this.moneda + "*" + this.movil;
        String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
        String msPin = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
        String msTipoCuenta = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
        String msg = "Confirme los siguientes datos de la cuenta Nauta a recargar: " + msgUser + msPin + msTipoCuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "59", cadena, msg, group, getFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (validateCuenta() && validateTipoCuentaNauta() && validateMonto()) {
            return (this.agencia == R1sDOSqZ2z.BANDEC || validateTipoMoneda()) && validateMovil();
        }
        return false;
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCuenta.getText().toString().trim().split(" ");
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_nauta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCuenta.setError("Su cuenta no debe tener espacios en blanco");
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().contains("@")) {
            this.inputLayoutCuenta.setError("Escriba la cuenta sin el tipo de dominio (Ej de tipo: @nauta.com.cu)");
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        this.cuenta = this.inputCuenta.getText().toString().trim();
        return true;
    }

    private boolean validateTipoCuentaNauta() {
        if (this.spinnerTipoCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoCuenta.setError("Seleccione un tipo de cuenta Nauta");
            requestFocus(this.spinnerTipoCuenta);
            return false;
        }
        this.inputLayoutTipoCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputImporte);
            return false;
        }
        this.inputLayoutImporte.setErrorEnabled(false);
        try {
            float f = Float.parseFloat(this.inputImporte.getText().toString().trim());
            this.importe = f;
            if (f < 1.0f) {
                this.inputLayoutImporte.setError(getString(R.string.err_msg_importe_inferior));
                requestFocus(this.inputImporte);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.inputLayoutImporte.setError("Monto incorrecto");
            requestFocus(this.inputImporte);
            return false;
        }
    }

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
    }

    private boolean validateMovil() {
        if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8) {
                this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
                requestFocus(this.inputNumeroDestinatario);
                return false;
            }
            this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
            if (!this.inputNumeroDestinatario.getText().toString().trim().substring(0, 1).contains("5") && !this.inputNumeroDestinatario.getText().toString().trim().substring(0, 1).contains("6")) {
                this.inputLayoutNumeroDestinatario.setError("Numero de movil incorrecto");
                requestFocus(this.inputNumeroDestinatario);
                return false;
            }
            this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
            this.movil = this.inputNumeroDestinatario.getText().toString().trim();
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private void loadData() {
        try {
            unYp8VQThY.init(this.context);
            List<Nauta> nautaLists = unYp8VQThY.getInstance().getAllNautaLists();
            List<String> cuentas_nautas = new ArrayList<>();
            List<Integer> tipos_cuentas = new ArrayList<>();
            for (Nauta c : nautaLists) {
                String nom_cuenta = c.getCuenta();
                if (!cuentas_nautas.contains(nom_cuenta)) {
                    cuentas_nautas.add(nom_cuenta);
                }
                tipos_cuentas.add(Integer.valueOf(c.getTipo_cuenta()));
            }
            ArrayAdapter<String> adapterCuentas = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cuentas_nautas);
            this.inputCuenta.setAdapter(adapterCuentas);
            this.inputCuenta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(yJCgdDviIu.this.inputCuenta.getText().toString());
                    if (nautaCuenta.size() == 2) {
                        yJCgdDviIu yjcgddviiu = yJCgdDviIu.this;
                        yjcgddviiu.showDialogWithCheckBox(yjcgddviiu.tipos);
                        return;
                    }
                    Nauta item_nauta = nautaCuenta.get(0);
                    if (item_nauta.getTipo_cuenta() == 1) {
                        yJCgdDviIu yjcgddviiu2 = yJCgdDviIu.this;
                        yjcgddviiu2.tipoCuenta = 1;
                        yjcgddviiu2.spinnerTipoCuenta.setText(yjcgddviiu2.tipos[0]);
                    } else {
                        yJCgdDviIu yjcgddviiu3 = yJCgdDviIu.this;
                        yjcgddviiu3.tipoCuenta = 2;
                        yjcgddviiu3.spinnerTipoCuenta.setText(yjcgddviiu3.tipos[1]);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogWithCheckBox(final String[] items) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context).setTitle("La cuenta tiene dos tipos de cuentas, Seleccione una:").setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    yJCgdDviIu yjcgddviiu = yJCgdDviIu.this;
                    yjcgddviiu.tipoCuenta = 1;
                    yjcgddviiu.spinnerTipoCuenta.setText(items[0]);
                } else {
                    yJCgdDviIu yjcgddviiu2 = yJCgdDviIu.this;
                    yjcgddviiu2.tipoCuenta = 2;
                    yjcgddviiu2.spinnerTipoCuenta.setText(items[1]);
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void helpAlertGestion(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ERROR!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
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
            this.inputNumeroDestinatario.setText(telf);
        } catch (Exception e) {
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
        if (contactCursor.moveToFirst()) {
            id = contactCursor.getString(0);
        }
        contactCursor.close();
        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
        if (phoneCursor.moveToFirst()) {
            phone = phoneCursor.getString(0);
        }
        phoneCursor.close();
        return phone;
    }

    public void nuevoDatos() {
        String edit_nauta = this.inputCuenta.getText().toString();
        int tipo = this.tipoCuenta;
        List<Nauta> c_list = unYp8VQThY.getInstance().getNautaListsWithAccount(edit_nauta, tipo);
        if (c_list.size() == 0) {
            Nauta c = new Nauta();
            c.setCuenta(edit_nauta);
            c.setTipo_cuenta(this.tipoCuenta);
            unYp8VQThY.getInstance().addNauta(c);
        }
        String edit_telef = this.inputNumeroDestinatario.getText().toString();
        List<TeflMovil> c_list_dest = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list_dest.size() == 0) {
            TeflMovil c2 = new TeflMovil();
            c2.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c2);
        }
    }
}
