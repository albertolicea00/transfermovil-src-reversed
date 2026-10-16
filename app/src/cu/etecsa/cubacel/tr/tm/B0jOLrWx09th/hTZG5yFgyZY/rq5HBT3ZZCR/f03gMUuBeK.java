package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR;

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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f03gMUuBeK extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public R1sDOSqZ2z agencia;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    public List<String> facList;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    private AutoCompleteTextView inputMonto;
    private TextInputLayout lyBolsas;
    public qTDVwLFEjE monedaBolsa;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public List<TeflMovil> telfMovilLists;
    public TextView toolbarTitle;
    public TextView txContacto;
    public int tipoBolsa = 2;
    public String codeService = "13";
    public ArrayList<String> items = new ArrayList<>();
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.r0pabfcjitq1zo, container, false);
        this.context = container.getContext();
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbarTitle = textView;
        textView.setText(getString(R.string.head_recarga_movil_agente));
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView2;
        textView2.setVisibility(8);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.tx_movil_recarga));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                f03gMUuBeK.this.inputCuenta.showDropDown();
            }
        });
        unYp8VQThY.init(this.context);
        this.telfMovilLists = unYp8VQThY.getInstance().getAllMovilLists();
        List<String> telefonos = new ArrayList<>();
        for (TeflMovil wl : this.telfMovilLists) {
            telefonos.add(wl.getNumber());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputCuenta.setAdapter(adapter);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.inputLayoutMonto.setHint(getString(R.string.monto_moneda_en_cuc));
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f03gMUuBeK.this.submitForm();
            }
        });
        loadSearchSpinner();
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                f03gMUuBeK.this.showOpcionContacto(v);
            }
        });
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            this.agencia = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
        }
        if (getArguments() != null && getArguments().containsKey("factura")) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        loadSpinnerBolsa(qTDVwLFEjE.CUP);
        return this.rootView;
    }

    public void loadSpinnerBolsa(qTDVwLFEjE moneda) {
        if (moneda == qTDVwLFEjE.CUP) {
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
            this.adapterTipoBolsa = arrayAdapterCreateFromResource;
            arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spBolsas.setAdapter(this.adapterTipoBolsa);
            this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        }
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

    private void loadSearchSpinner() {
        try {
            List<TeflMovil> list = this.telfMovilLists;
            if (list != null && list.size() > 0) {
                for (TeflMovil uyh0pxs9m37in : this.telfMovilLists) {
                    String facura = uyh0pxs9m37in.getNumber();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getNumber();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getNumber();
                    }
                    this.items.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    TeflMovil cuenta = f03gMUuBeK.this.telfMovilLists.get(position);
                    f03gMUuBeK.this.inputCuenta.setText(cuenta.getNumber());
                }
            });
        } catch (Exception e2) {
        }
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
        String edit_telef = this.inputCuenta.getText().toString();
        List<TeflMovil> c_list = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list.size() == 0) {
            TeflMovil c = new TeflMovil();
            c.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpcionContacto(final View v) {
        CharSequence[] items = {this.context.getString(R.string.tx_opcion_buscar_movil_libreta), this.context.getString(R.string.tx_opcion_buscar_movil_gestion)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_buscar_movil));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f03gMUuBeK.this.txContacto.setText(BuildConfig.FLAVOR);
                f03gMUuBeK f03gmuubek = f03gMUuBeK.this;
                f03gmuubek.displayContact = BuildConfig.FLAVOR;
                f03gmuubek.txContacto.setVisibility(8);
                switch (i) {
                    case 0:
                        List<TeflMovil> list = f03gMUuBeK.this.telfMovilLists;
                        if (list == null || list.size() <= 0) {
                            Toast.makeText(f03gMUuBeK.this.context, "No hay elementos para mostrar", 0).show();
                        } else {
                            f03gMUuBeK.this.spinnerDialog.showSpinerDialog();
                        }
                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT < 23 || f03gMUuBeK.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                            f03gMUuBeK.this.busk_contactos(v);
                        } else {
                            f03gMUuBeK.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                        }
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
