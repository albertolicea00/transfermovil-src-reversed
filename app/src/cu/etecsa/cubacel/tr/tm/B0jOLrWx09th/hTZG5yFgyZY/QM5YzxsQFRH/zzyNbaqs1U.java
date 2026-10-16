package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;

/* JADX INFO: loaded from: classes.dex */
public class zzyNbaqs1U extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    private AutoCompleteTextView inputMonto;
    private TextInputLayout lyBolsas;
    public qTDVwLFEjE monedaBolsa;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public TextView toolbarTitle;
    public TextView txContacto;
    public int tipoBolsa = 0;
    public String codeService = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.zzyNbaqs1U.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.r0pabfcjitq1zo, container, false);
        this.context = container.getContext();
        this.toolbarTitle = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.tx_movil_recarga));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.zzyNbaqs1U.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                zzyNbaqs1U.this.inputCuenta.showDropDown();
            }
        });
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.inputLayoutMonto.setHint(getString(R.string.monto_moneda_en_cuc));
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.zzyNbaqs1U.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zzyNbaqs1U.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.zzyNbaqs1U.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || zzyNbaqs1U.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    zzyNbaqs1U.this.busk_contactos(v);
                } else {
                    zzyNbaqs1U.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            this.agencia = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
        }
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("TipoBolsa")) {
                qTDVwLFEjE qtdvwlfeje = (qTDVwLFEjE) arg.getSerializable("TipoBolsa");
                this.monedaBolsa = qtdvwlfeje;
                if (qtdvwlfeje == qTDVwLFEjE.CUP) {
                    this.codeService = "54";
                    this.tipoBolsa = 2;
                    this.toolbarTitle.setText(getString(R.string.tx_wallet_recarga_cup));
                } else if (qtdvwlfeje == qTDVwLFEjE.USD) {
                    this.codeService = "23";
                    this.tipoBolsa = 1;
                    this.toolbarTitle.setText(getString(R.string.tx_wallet_recarga_usd));
                }
                loadSpinnerBolsa(this.monedaBolsa);
            }
        }
        return this.rootView;
    }

    public void loadSpinnerBolsa(qTDVwLFEjE moneda) {
        if (moneda == qTDVwLFEjE.CUP) {
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
            this.adapterTipoBolsa = arrayAdapterCreateFromResource;
            arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spBolsas.setAdapter(this.adapterTipoBolsa);
            this.spBolsas.setOnItemClickListener(this.spClickBolsa);
            return;
        }
        if (moneda == qTDVwLFEjE.USD) {
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_usd, android.R.layout.simple_list_item_1);
            this.adapterTipoBolsa = arrayAdapterCreateFromResource2;
            arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spBolsas.setAdapter(this.adapterTipoBolsa);
            this.spBolsas.setOnItemClickListener(this.spClickBolsa);
            return;
        }
        Toast.makeText(this.context, "Ha ocurrido un error", 1).show();
    }

    public void submitForm() {
        if (!validateCuenta() || !validateMonto() || !validateSpBolsa()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String msg = "¿ Desea recargar el saldo del móvil " + cuenta + ", con el monto en CUP: " + monto + " ?";
        if (this.tipoBolsa == 1) {
            msg = "¿ Desea recargar el saldo del móvil " + cuenta + ", con el monto en CUP: " + monto + " ? Usando la cuenta USD.";
        }
        String str = this.codeService;
        if (str != null && str.length() > 0) {
            String cadena = cuenta + "*" + monto + "*0*" + this.tipoBolsa;
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, this.codeService, cadena, msg, group, getFragmentManager());
            return;
        }
        Toast.makeText(this.context, "Ha ocurrido un error", 1).show();
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 8 && this.inputCuenta.getText().toString().trim().length() != 10) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        try {
            float importe = Float.parseFloat(this.inputMonto.getText().toString().trim());
            if (importe < 1.0f) {
                this.inputLayoutMonto.setError(getString(R.string.err_msg_importe_inferior));
                requestFocus(this.inputMonto);
                return false;
            }
            this.inputLayoutMonto.setErrorEnabled(false);
            return true;
        } catch (Exception e) {
            this.inputLayoutMonto.setError("Monto incorrecto");
            requestFocus(this.inputMonto);
            return false;
        }
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

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
            this.inputCuenta.setText(telf);
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
