package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv;

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
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GMFMyKMnO2 extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    private Button btnBuscarContacto;
    private Uri contactUri;
    public Context context;
    private TextInputLayout inputLayoutMovil;
    private AutoCompleteTextView inputMovil;
    public int operacion;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.operacion = getArguments().getInt("operacion");
        this.rootView = inflater.inflate(R.layout.g0wi8p7zuvdre2, container, false);
        this.context = container.getContext();
        this.inputLayoutMovil = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_gnumero);
        this.inputMovil = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_gnumero);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GMFMyKMnO2.this.busk_contactos(v);
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GMFMyKMnO2.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNumber()) {
            return;
        }
        String cadena = "tel:";
        switch (this.operacion) {
            case 1:
                cadena = "tel:" + this.inputMovil.getText().toString().trim();
                break;
            case 2:
                cadena = "tel:*99" + this.inputMovil.getText().toString().trim();
                break;
        }
        Intent phoneIntent = new Intent("android.intent.action.CALL");
        phoneIntent.setData(Uri.parse(cadena));
        startActivity(phoneIntent);
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

    private List<String> getContactNames() {
        List<String> contacts = new ArrayList<>();
        ContentResolver cr = this.context.getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("display_name"));
                contacts.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contacts;
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
