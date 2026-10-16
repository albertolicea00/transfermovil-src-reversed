package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PTsHXOZ1gC extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterOrganizacion;
    public R1sDOSqZ2z agencia;
    public int banco;
    private Button btnAceptar;
    public ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    public Uri contactUri;
    public String displayContact;
    public List<String> facList;
    private AutoCompleteTextView inputCI;
    private AutoCompleteTextView inputCantidadMeses;
    private TextInputLayout inputLayoutCI;
    private TextInputLayout inputLayoutSalario;
    private AutoCompleteTextView inputSalario;
    private TextInputLayout lyCantidadMeses;
    private TextInputLayout lyOrganizacion;
    public TextInputLayout lyPhoneConfirm;
    public ConstraintLayout modalConfirmarPago;
    public jN13TOyLMX spOrganizacion;
    public TextView titulo;
    public TextView txContacto;
    public AutoCompleteTextView txPhoneConfirm;
    public int organizacion = 0;
    public boolean isEnviarAuxDat = false;
    public float importe = 0.0f;
    public int cantidadMeses = 0;
    public String agencyL = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickOrganizacion = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            PTsHXOZ1gC pTsHXOZ1gC = PTsHXOZ1gC.this;
            int i = position + 1;
            pTsHXOZ1gC.organizacion = i;
            pTsHXOZ1gC.toggleFieldsByOrganizacion(i);
        }
    };
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC.3
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    PTsHXOZ1gC.this.modalConfirmarPago.setVisibility(0);
                    PTsHXOZ1gC.this.isEnviarAuxDat = true;
                } else {
                    PTsHXOZ1gC.this.modalConfirmarPago.setVisibility(8);
                    PTsHXOZ1gC.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || PTsHXOZ1gC.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    PTsHXOZ1gC.this.busk_contactos(v);
                } else {
                    PTsHXOZ1gC.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.dmvhsjjmimwos, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass5.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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
        initComponentesCuentas(this.rootView, this.agencia);
        this.titulo = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        initViews();
        setupOrganizacionSpinner();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputCI.setAdapter(adapter);
        this.inputSalario.setAdapter(adapter);
        setupListeners();
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
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

    private void initViews() {
        this.lyOrganizacion = (TextInputLayout) this.rootView.findViewById(R.id.lyOrganizacion);
        this.spOrganizacion = (jN13TOyLMX) this.rootView.findViewById(R.id.spOrganizacion);
        this.inputLayoutCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCIPartido);
        this.inputCI = (AutoCompleteTextView) this.rootView.findViewById(R.id.textCell);
        this.inputLayoutSalario = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_salario);
        this.inputSalario = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputSalario);
        this.lyCantidadMeses = (TextInputLayout) this.rootView.findViewById(R.id.lyCantidadMeses);
        this.inputCantidadMeses = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputCantidadMeses);
        this.chConfirmPhone = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
    }

    private void setupOrganizacionSpinner() {
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_organizacion_politica, android.R.layout.simple_list_item_1);
        this.adapterOrganizacion = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spOrganizacion.setAdapter(this.adapterOrganizacion);
        this.spOrganizacion.setOnItemClickListener(this.spClickOrganizacion);
    }

    private void setupListeners() {
        this.chConfirmPhone.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PTsHXOZ1gC.this.submitForm();
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        StringBuilder sb;
        String str;
        super.submitForm();
        if (!validateSpOrganizacion() || !validateCi()) {
            return;
        }
        if (this.organizacion == 3) {
            if (!validateCantidadMeses()) {
                return;
            }
        } else if (!validateMonto()) {
            return;
        }
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String movilConfirmar = "00";
        if (this.isEnviarAuxDat && this.txPhoneConfirm.getText().toString().trim().length() > 0) {
            movilConfirmar = this.txPhoneConfirm.getText().toString().trim();
        }
        String ci = this.inputCI.getText().toString().trim();
        String valor = this.organizacion == 3 ? String.valueOf(this.cantidadMeses) : String.valueOf(this.importe);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("¿Desea pagar la cuota del CI: ");
        sb2.append(ci);
        if (this.organizacion == 3) {
            sb = new StringBuilder();
            sb.append(" para una cantidad de ");
            sb.append(this.cantidadMeses);
            str = " meses";
        } else {
            sb = new StringBuilder();
            sb.append(" para un ingreso declarado de ");
            sb.append(this.importe);
            str = " CUP";
        }
        sb.append(str);
        sb2.append(sb.toString());
        sb2.append("?");
        String msg = sb2.toString();
        String cadena = this.organizacion + "*" + ci + "*" + valor + "*" + this.monedaTarjeta + "*" + movilConfirmar + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        if (!this.isPartialUSSD) {
            if (this.organizacion != 3) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "7", cadena, msg, group, getFragmentManager());
                return;
            } else {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "122", cadena, msg, group, getFragmentManager());
                return;
            }
        }
        if (this.organizacion != 3) {
            this.manager.principalEnviarUSSD(this.context, "110", "7", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "122", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFieldsByOrganizacion(int organizacion) {
        ConstraintLayout containerCuentas = (ConstraintLayout) this.rootView.findViewById(R.id.container_cuentas);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) containerCuentas.getLayoutParams();
        if (organizacion == 3) {
            this.inputLayoutSalario.setVisibility(8);
            this.lyCantidadMeses.setVisibility(0);
            params.topToBottom = R.id.lyCantidadMeses;
        } else {
            this.inputLayoutSalario.setVisibility(0);
            this.lyCantidadMeses.setVisibility(8);
            params.topToBottom = R.id.input__layout_salario;
        }
        containerCuentas.setLayoutParams(params);
    }

    private boolean validateCi() {
        if (this.inputCI.getText().toString().trim().isEmpty()) {
            this.inputLayoutCI.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCI);
            return false;
        }
        if (this.inputCI.getText().toString().trim().length() != 11) {
            this.inputLayoutCI.setError(getString(R.string.err_msg_len_ci));
            requestFocus(this.inputCI);
            return false;
        }
        this.inputLayoutCI.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        try {
            if (!this.inputSalario.getText().toString().trim().isEmpty()) {
                this.inputLayoutSalario.setErrorEnabled(false);
                this.importe = Float.parseFloat(this.inputSalario.getText().toString());
                this.inputLayoutSalario.setErrorEnabled(false);
                return true;
            }
            this.inputLayoutSalario.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputSalario);
            return false;
        } catch (Exception e) {
            this.inputLayoutSalario.setError("Ingrese un importe válido");
            requestFocus(this.inputSalario);
            return false;
        }
    }

    private boolean validateCantidadMeses() {
        if (this.inputCantidadMeses.getText().toString().trim().isEmpty()) {
            this.lyCantidadMeses.setError("Ingrese la cantidad de meses");
            requestFocus(this.inputCantidadMeses);
            return false;
        }
        try {
            int i = Integer.parseInt(this.inputCantidadMeses.getText().toString());
            this.cantidadMeses = i;
            if (i <= 0 || i > 12) {
                this.lyCantidadMeses.setError("La cantidad de meses debe estar entre 1 y 12");
                requestFocus(this.inputCantidadMeses);
                return false;
            }
            this.lyCantidadMeses.setErrorEnabled(false);
            return true;
        } catch (Exception e) {
            this.lyCantidadMeses.setError("Ingrese una cantidad válida");
            requestFocus(this.inputCantidadMeses);
            return false;
        }
    }

    public boolean validateSpOrganizacion() {
        if (this.spOrganizacion.getText().toString().trim().isEmpty()) {
            this.lyOrganizacion.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spOrganizacion);
            return false;
        }
        this.lyOrganizacion.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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

    public void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri);
            if (telf != null) {
                String telf2 = telf.replace(" ", BuildConfig.FLAVOR).trim();
                if (telf2.contains("+")) {
                    telf2 = telf2.substring(1);
                }
                if (telf2.charAt(0) == '0') {
                    telf2 = telf2.substring(1);
                }
                if ((telf2.substring(0, 3).toString().contains("535") || telf2.substring(0, 3).toString().contains("536")) && telf2.length() == 10) {
                    telf2 = telf2.substring(2);
                }
                this.txPhoneConfirm.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txContacto.setText(this.displayContact);
                    this.txContacto.setVisibility(0);
                    this.displayContact = BuildConfig.FLAVOR;
                }
            }
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        try {
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
        } catch (Exception e) {
            return null;
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
