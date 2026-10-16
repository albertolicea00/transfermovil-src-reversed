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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PqTzgaEYF6 extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoCuenta;
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public Switch ckDeudaNautaHogar;
    private Uri contactUri;
    public float importe;
    private AutoCompleteTextView inputCuenta;
    private TextInputEditText inputImporte;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutImporte;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoCuenta;
    private AutoCompleteTextView inputNumeroDestinatario;
    public List<String> nautaCuentas;
    public List<Nauta> nautaLists;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerTipoCuenta;
    public Switch swNautaHogar;
    public String[] tipos;
    public int banco = 0;
    public String cuenta = BuildConfig.FLAVOR;
    public int tipoCuenta = 0;
    public String nombreTipoCuenta = BuildConfig.FLAVOR;
    public String movil = "0000000";
    public ArrayList<String> items = new ArrayList<>();
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            PqTzgaEYF6.this.submitForm();
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || PqTzgaEYF6.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    PqTzgaEYF6.this.busk_contactos(v);
                } else {
                    PqTzgaEYF6.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            PqTzgaEYF6.this.tipoCuenta = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.k3u8kork1t7c3, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.ckDeudaNautaHogar = (Switch) this.rootView.findViewById(R.id.ckDeudaNautaHogar);
        Switch r0 = (Switch) this.rootView.findViewById(R.id.swNautaHogar);
        this.swNautaHogar = r0;
        r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                PqTzgaEYF6.this.ckDeudaNautaHogar.setChecked(false);
                if (b) {
                    PqTzgaEYF6.this.ckDeudaNautaHogar.setVisibility(0);
                } else {
                    PqTzgaEYF6.this.ckDeudaNautaHogar.setVisibility(8);
                }
            }
        });
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass10.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agencyL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agencyL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agencyL = "03";
                    break;
            }
        }
        loadViewUI(this.rootView);
        loadData();
        initComponentesCuentas(this.rootView, this.agencia);
        this.tipos = getResources().getStringArray(R.array.array_tipo_cuenta_nauta);
        if (getArguments() != null && getArguments().containsKey("pago")) {
            String cuentaNauta = getArguments().get("pago").toString();
            String[] arr = cuentaNauta.split("@");
            this.inputCuenta.setText(arr[0]);
            this.cuenta = arr[0];
            if (arr[1].contains(".com.cu")) {
                this.tipoCuenta = 1;
                this.spinnerTipoCuenta.setText(this.tipos[0]);
            } else if (arr[1].contains(".co.cu")) {
                this.tipoCuenta = 2;
                this.spinnerTipoCuenta.setText(this.tipos[1]);
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Nauta> list = PqTzgaEYF6.this.nautaLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(PqTzgaEYF6.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    PqTzgaEYF6.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
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
        this.inputNumeroDestinatario = (AutoCompleteTextView) v.findViewById(R.id.inputNumeroDestinatario);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) v.findViewById(R.id.inputLayoutNumeroDestinatario);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cuenta_nauta, android.R.layout.simple_list_item_1);
        this.adapterTipoCuenta = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoCuenta.setAdapter(this.adapterTipoCuenta);
        this.spinnerTipoCuenta.setOnItemClickListener(this.spClickTipo);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
    }

    private void enviarUSSD() {
        if (!this.swNautaHogar.isChecked()) {
            this.cuenta.toLowerCase();
            if (this.cuenta.contains("ERROR")) {
                Log.d("CADENA", "cadena vacia");
                helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
                return;
            }
            if (this.isPartialUSSD) {
                this.cuenta = processString(this.cuenta);
            }
            this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
            String cadena = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*" + this.monedaTarjeta + "*" + this.movil + "*" + this.cuentaOrigen + "*1";
            String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
            String msPin = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
            String msTipoCuenta = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
            String msg = "Confirme los siguientes datos de la cuenta Nauta a recargar: " + msgUser + msPin + msTipoCuenta;
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
            if (this.isPartialUSSD) {
                this.manager.principalEnviarUSSD(this.context, "110", "59", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
                return;
            } else {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "59", cadena, msg, group, getFragmentManager());
                return;
            }
        }
        if (!this.ckDeudaNautaHogar.isChecked()) {
            this.cuenta.toLowerCase();
            if (this.cuenta.contains("ERROR")) {
                Log.d("CADENA", "cadena vacia");
                helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
                return;
            }
            if (this.isPartialUSSD) {
                this.cuenta = processString(this.cuenta);
            }
            this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
            String cadena2 = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*" + this.monedaTarjeta + "*" + this.movil + "*" + this.cuentaOrigen + "*2";
            String msgUser2 = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
            String msPin2 = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
            String msTipoCuenta2 = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
            String msg2 = "Nauta Hogar. Confirme los siguientes datos de la cuenta a recargar: " + msgUser2 + msPin2 + msTipoCuenta2;
            ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
            if (this.isPartialUSSD) {
                this.manager.principalEnviarUSSD(this.context, "110", "84", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena2, msg2, group2, getFragmentManager());
                return;
            } else {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "84", cadena2, msg2, group2, getFragmentManager());
                return;
            }
        }
        this.cuenta.toLowerCase();
        if (this.cuenta.contains("ERROR")) {
            Log.d("CADENA", "cadena vacia");
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        if (this.isPartialUSSD) {
            this.cuenta = processString(this.cuenta);
        }
        this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
        String cadena3 = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*" + this.monedaTarjeta + "*" + this.movil + "*" + this.cuentaOrigen + "*3";
        String msgUser3 = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
        String msPin3 = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
        String msTipoCuenta3 = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
        String msg3 = "Pago de deudas pendientes en el servicio de Nauta Hogar. Confirme los siguientes datos de la cuenta a pagar: " + msgUser3 + msPin3 + msTipoCuenta3;
        ViewGroup group3 = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "86", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena3, msg3, group3, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "86", cadena3, msg3, group3, getFragmentManager());
        }
    }

    private boolean isFieldsOK() {
        return validateCuenta() && validateTipoCuentaNauta() && validateMonto() && validateSelectionAccounts() && validateMovil();
    }

    private String processString(String input) {
        if (input == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            if (input.isEmpty()) {
                return BuildConfig.FLAVOR;
            }
            if (input.length() > 10) {
                int middle = input.length() / 2;
                String part1 = input.substring(0, middle);
                String part2 = input.substring(middle);
                return part1 + "*" + part2;
            }
            return input;
        } catch (Exception e) {
            return input;
        }
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
        if (this.inputCuenta.getText().toString().length() > 20) {
            this.inputLayoutCuenta.setError("El nombre del usuario del correo no puede tener más de 20 caracteres");
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (isFieldsOK()) {
            try {
                enviarUSSD();
                nuevoDatos();
            } catch (Exception e) {
            }
        }
    }

    private void loadData() {
        try {
            this.nautaCuentas = new ArrayList();
            unYp8VQThY.init(this.context);
            this.nautaLists = unYp8VQThY.getInstance().getAllNautaLists();
            List<String> cuentas_nautas = new ArrayList<>();
            List<Integer> tipos_cuentas = new ArrayList<>();
            for (Nauta c : this.nautaLists) {
                String nom_cuenta = c.getCuenta();
                if (!cuentas_nautas.contains(nom_cuenta)) {
                    cuentas_nautas.add(nom_cuenta);
                }
                tipos_cuentas.add(Integer.valueOf(c.getTipo_cuenta()));
                String cuentaCompleta = nom_cuenta;
                if (c.getTipo_cuenta() == 1) {
                    cuentaCompleta = cuentaCompleta + "@nauta.com.cu";
                } else if (c.getTipo_cuenta() == 2) {
                    cuentaCompleta = cuentaCompleta + "@nauta.co.cu";
                }
                this.nautaCuentas.add(cuentaCompleta);
            }
            ArrayAdapter<String> adapterCuentas = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cuentas_nautas);
            this.inputCuenta.setAdapter(adapterCuentas);
            this.inputCuenta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.6
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(PqTzgaEYF6.this.inputCuenta.getText().toString());
                    if (nautaCuenta.size() == 2) {
                        PqTzgaEYF6 pqTzgaEYF6 = PqTzgaEYF6.this;
                        pqTzgaEYF6.showDialogWithCheckBox(pqTzgaEYF6.tipos);
                        return;
                    }
                    Nauta item_nauta = nautaCuenta.get(0);
                    if (item_nauta.getTipo_cuenta() == 1) {
                        PqTzgaEYF6 pqTzgaEYF7 = PqTzgaEYF6.this;
                        pqTzgaEYF7.tipoCuenta = 1;
                        pqTzgaEYF7.spinnerTipoCuenta.setText(pqTzgaEYF7.tipos[0]);
                    } else {
                        PqTzgaEYF6 pqTzgaEYF8 = PqTzgaEYF6.this;
                        pqTzgaEYF8.tipoCuenta = 2;
                        pqTzgaEYF8.spinnerTipoCuenta.setText(pqTzgaEYF8.tipos[1]);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogWithCheckBox(final String[] items) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context).setTitle("La cuenta tiene dos tipos de cuentas, Seleccione una:").setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    PqTzgaEYF6 pqTzgaEYF6 = PqTzgaEYF6.this;
                    pqTzgaEYF6.tipoCuenta = 1;
                    pqTzgaEYF6.spinnerTipoCuenta.setText(items[0]);
                } else {
                    PqTzgaEYF6 pqTzgaEYF7 = PqTzgaEYF6.this;
                    pqTzgaEYF7.tipoCuenta = 2;
                    pqTzgaEYF7.spinnerTipoCuenta.setText(items[1]);
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
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.8
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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

    private void loadSearchSpinner() {
        try {
            List<String> list = this.nautaCuentas;
            if (list != null && list.size() > 0) {
                for (String uyh0pxs9m37in : this.nautaCuentas) {
                    this.items.add(uyh0pxs9m37in);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6.9
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(PqTzgaEYF6.this.nautaLists.get(position).getCuenta());
                    PqTzgaEYF6.this.inputCuenta.setText(nautaCuenta.get(0).getCuenta());
                    if (nautaCuenta.size() == 2) {
                        PqTzgaEYF6 pqTzgaEYF6 = PqTzgaEYF6.this;
                        pqTzgaEYF6.showDialogWithCheckBox(pqTzgaEYF6.tipos);
                        return;
                    }
                    Nauta item_nauta = nautaCuenta.get(0);
                    if (item_nauta.getTipo_cuenta() == 1) {
                        PqTzgaEYF6 pqTzgaEYF7 = PqTzgaEYF6.this;
                        pqTzgaEYF7.tipoCuenta = 1;
                        pqTzgaEYF7.spinnerTipoCuenta.setText(pqTzgaEYF7.tipos[0]);
                    } else {
                        PqTzgaEYF6 pqTzgaEYF8 = PqTzgaEYF6.this;
                        pqTzgaEYF8.tipoCuenta = 2;
                        pqTzgaEYF8.spinnerTipoCuenta.setText(pqTzgaEYF8.tipos[1]);
                    }
                }
            });
        } catch (Exception e) {
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
