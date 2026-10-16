package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class wbFn8tBw8W extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lyMovil;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public TextView txContacto;
    private AutoCompleteTextView txMonedaImporte;
    private EditText txMonto;
    private AutoCompleteTextView txMovil;
    public int tipoBolsa = 0;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.wbFn8tBw8W.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            wbFn8tBw8W.this.tipoBolsa = 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ojja20nm9i2zi, container, false);
        this.context = container.getContext();
        this.lyMovil = (TextInputLayout) this.rootView.findViewById(R.id.lyMovil);
        this.txMovil = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMovil);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (EditText) this.rootView.findViewById(R.id.txMonto);
        this.lyMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.lyMonedaImporte);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.txMonedaImporte = autoCompleteTextView;
        autoCompleteTextView.setText("USD");
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.wbFn8tBw8W.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wbFn8tBw8W.this.submitForm();
            }
        });
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_usd, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.wbFn8tBw8W.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                wbFn8tBw8W.this.busk_contactos(v);
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateMonto() || !validateSpBolsa()) {
            return;
        }
        String cuenta = this.txMovil.getText().toString().trim();
        String monto = this.txMonto.getText().toString().trim();
        String moneda = this.txMonedaImporte.getText().toString().trim();
        String msg = "¿Desea realizar la recarga de la cuenta: " + cuenta + " ?";
        String cadena = cuenta + "*" + monto + "*" + moneda + "*" + this.tipoBolsa;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "20", cadena, msg, group, getFragmentManager());
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

    private boolean validateCuenta() {
        if (this.txMovil.getText().toString().trim().isEmpty()) {
            this.lyMovil.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txMovil);
            return false;
        }
        if (this.txMovil.getText().toString().trim().length() != 8 && this.txMovil.getText().toString().trim().length() != 10) {
            this.lyMovil.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.txMovil);
            return false;
        }
        this.lyMovil.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        this.lyMonto.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
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
            this.txMovil.setText(telf);
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
