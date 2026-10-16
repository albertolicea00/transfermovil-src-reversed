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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d7Bxd6SDJ6 extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public R1sDOSqZ2z agencia;
    public int banco;
    private Button btnAceptar;
    public ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    public Uri contactUri;
    public String displayContact;
    public List<String> facList;
    private AutoCompleteTextView inputCI;
    private TextInputLayout inputLayoutCI;
    private TextInputLayout inputLayoutSalario;
    private AutoCompleteTextView inputSalario;
    public TextInputLayout lyPhoneConfirm;
    public ConstraintLayout modalConfirmarPago;
    public TextView titulo;
    public TextView txContacto;
    public AutoCompleteTextView txPhoneConfirm;
    public boolean isEnviarAuxDat = false;
    public float importe = 0.0f;
    public String agencyL = BuildConfig.FLAVOR;
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.d7Bxd6SDJ6.3
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    d7Bxd6SDJ6.this.modalConfirmarPago.setVisibility(0);
                    d7Bxd6SDJ6.this.isEnviarAuxDat = true;
                } else {
                    d7Bxd6SDJ6.this.modalConfirmarPago.setVisibility(8);
                    d7Bxd6SDJ6.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.d7Bxd6SDJ6.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || d7Bxd6SDJ6.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    d7Bxd6SDJ6.this.busk_contactos(v);
                } else {
                    d7Bxd6SDJ6.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.r9ehgmzrt2krub, container, false);
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
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.titulo = textView;
        textView.setText(R.string.head_pcc);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputLayoutCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCIPartido);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.textCell);
        this.inputCI = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutSalario = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_salario);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) this.rootView.findViewById(R.id.inputSalario);
        this.inputSalario = autoCompleteTextView2;
        autoCompleteTextView2.setAdapter(adapter);
        this.inputCI.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.d7Bxd6SDJ6.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                d7Bxd6SDJ6.this.inputCI.showDropDown();
            }
        });
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
        this.chConfirmPhone = checkBox;
        checkBox.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
        this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
        this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.d7Bxd6SDJ6.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d7Bxd6SDJ6.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.d7Bxd6SDJ6$5, reason: invalid class name */
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String movilConfirmar = "00";
        if (this.isEnviarAuxDat && this.txPhoneConfirm.getText().toString().trim().length() > 0) {
            movilConfirmar = this.txPhoneConfirm.getText().toString().trim();
        }
        String ci = this.inputCI.getText().toString().trim();
        String msg = "¿ Desea pagar la cuota del militante con CI: " + ci + " y un ingreso declarado de " + this.importe + " CUP?";
        String cadena = ci + "*" + this.importe + "*" + this.monedaTarjeta + "*" + movilConfirmar + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "7", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "7", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMonto() {
        if (this.inputSalario.getText().toString().trim().isEmpty()) {
            this.inputLayoutSalario.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputSalario);
            return false;
        }
        try {
            this.importe = Float.parseFloat(this.inputSalario.getText().toString());
            return true;
        } catch (Exception e) {
            this.importe = 0.0f;
            return true;
        }
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
