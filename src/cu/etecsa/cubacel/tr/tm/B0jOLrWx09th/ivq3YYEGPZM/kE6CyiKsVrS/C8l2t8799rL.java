package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class C8l2t8799rL extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    private Button btnBuscarContacto;
    private Uri contactUri;
    public Context context;
    private EditText inputClave;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutMovil;
    private EditText inputMonto;
    private AutoCompleteTextView inputMovil;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.e1r19ufa5sita, container, false);
        this.context = container.getContext();
        this.inputLayoutMovil = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_gnumero);
        this.inputMovil = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_gnumero);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_gmonto);
        this.inputMonto = (EditText) this.rootView.findViewById(R.id.input_gmonto);
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_gclave);
        this.inputClave = (EditText) this.rootView.findViewById(R.id.input_gclave);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C8l2t8799rL.this.busk_contactos(v);
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C8l2t8799rL.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNumber() || !validateClave() || !validateMonto()) {
            return;
        }
        String cadena = this.inputMovil.getText().toString() + "*" + this.inputClave.getText().toString() + "*" + this.inputMonto.getText().toString();
        String msg = "Desea realiza la transferencia al siguiente celular:  " + this.inputMovil.getText().toString() + ". Con el monto a transferir: " + this.inputMonto.getText().toString() + " CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTransferir);
        rDEl7rW1aN bs = new rDEl7rW1aN();
        if (bs.getCodeAgent() != null) {
            if (bs.getCodeAgent().getCode().contains("-1")) {
                ((S9ycHcoxAzy) getActivity()).actionCallUSSD("234", "1", cadena, msg, group);
                return;
            } else {
                ((IHVTCBmiLV) getActivity()).actionCallUSSD("234", "1", cadena, msg, group);
                return;
            }
        }
        ((S9ycHcoxAzy) getActivity()).actionCallUSSD("234", "1", cadena, msg, group);
    }

    private boolean validateNumber() {
        if (this.inputMovil.getText().toString().trim().isEmpty()) {
            this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_movil));
            requestFocus(this.inputMovil);
            return false;
        }
        if (this.inputMovil.getText().toString().trim().length() != 8) {
            this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputMovil);
            return false;
        }
        this.inputLayoutMovil.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(this.context.getString(R.string.err_msg_monto_cel_invalid));
            requestFocus(this.inputMonto);
            return false;
        }
        if (this.inputMonto.getText().toString().trim().contains(".")) {
            this.inputLayoutMonto.setError("Solo se admiten valores enteros");
            requestFocus(this.inputMonto);
            return false;
        }
        this.inputLayoutMonto.setErrorEnabled(false);
        return true;
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
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
        this.inputMovil.setText(telf);
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

    private String getName(Uri uri) {
        String name = null;
        ContentResolver contentResolver = this.context.getContentResolver();
        Cursor c = contentResolver.query(uri, new String[]{"display_name"}, null, null, null);
        if (c.moveToFirst()) {
            name = c.getString(0);
        }
        c.close();
        return name;
    }
}
