package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.RiZsr8xXRC;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HZgbT8IXPf extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public R1sDOSqZ2z agencia;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutNumeroDestinatario;
    private AutoCompleteTextView inputNumeroDestinatario;
    private TextInputLayout lyBolsas;
    public List<String> nautaCuentas;
    public List<Nauta> nautaLists;
    public RiZsr8xXRC opcionPlus;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public TextView txContacto;
    public String cuenta = "0000";
    public int tipoCuenta = 0;
    public String movil = "0000";
    public int tipoBolsa = 0;
    public ArrayList<String> items = new ArrayList<>();
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            HZgbT8IXPf.this.submitFormNautaPlus();
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || HZgbT8IXPf.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    HZgbT8IXPf.this.busk_contactos(v);
                } else {
                    HZgbT8IXPf.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            HZgbT8IXPf.this.tipoBolsa = 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.qwoykdj6mz7c8, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_usd, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.inputCuenta = (AutoCompleteTextView) v.findViewById(R.id.inputCuenta);
        this.inputLayoutCuenta = (TextInputLayout) v.findViewById(R.id.inputLayoutCuenta);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.inputNumeroDestinatario = (AutoCompleteTextView) v.findViewById(R.id.inputNumeroDestinatario);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) v.findViewById(R.id.inputLayoutNumeroDestinatario);
        loadData();
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
        ImageButton imageButton2 = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Nauta> list = HZgbT8IXPf.this.nautaLists;
                if (list != null && list.size() > 0) {
                    HZgbT8IXPf.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(HZgbT8IXPf.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("OpcionNautaPlus")) {
                RiZsr8xXRC riZsr8xXRC = (RiZsr8xXRC) arg.getSerializable("OpcionNautaPlus");
                this.opcionPlus = riZsr8xXRC;
                if (riZsr8xXRC == RiZsr8xXRC.SIN_CUENTA) {
                    this.inputLayoutCuenta.setVisibility(8);
                    this.inputLayoutNumeroDestinatario.setHint(this.context.getString(R.string.tx_beneficiario_recarga_paquete));
                    this.btSearchAccount.setVisibility(8);
                } else if (riZsr8xXRC == RiZsr8xXRC.CON_CUENTA) {
                    this.inputLayoutCuenta.setHint(this.context.getString(R.string.tx_wallet_nauta_plus_nombre_cuenta));
                }
            }
        }
        loadSearchSpinner();
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.2
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(HZgbT8IXPf.this.nautaLists.get(position).getCuenta());
                    HZgbT8IXPf.this.inputCuenta.setText(nautaCuenta.get(0).getCuenta());
                    if (nautaCuenta.size() != 2) {
                        Nauta item_nauta = nautaCuenta.get(0);
                        if (item_nauta.getTipo_cuenta() == 1) {
                            HZgbT8IXPf.this.tipoCuenta = 1;
                        } else {
                            HZgbT8IXPf.this.tipoCuenta = 2;
                        }
                    }
                }
            });
        } catch (Exception e) {
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
            this.inputLayoutCuenta.setError("La cuenta no debe tener espacios en blanco");
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

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
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
                this.inputLayoutNumeroDestinatario.setError("Número de móvil incorrecto");
                requestFocus(this.inputNumeroDestinatario);
                return false;
            }
            this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
            this.movil = this.inputNumeroDestinatario.getText().toString().trim();
        }
        if (!this.movil.equals("0000")) {
            return true;
        }
        this.inputLayoutNumeroDestinatario.setError(getString(R.string.err_msg_empty_cuenta));
        requestFocus(this.inputNumeroDestinatario);
        return false;
    }

    public void submitFormNautaPlus() {
        RiZsr8xXRC riZsr8xXRC = this.opcionPlus;
        if (riZsr8xXRC == RiZsr8xXRC.CON_CUENTA) {
            if (validateCuenta() && validateMovil() && validateSpBolsa()) {
                try {
                    this.cuenta.toLowerCase();
                    if (this.cuenta.contains("ERROR")) {
                        Log.d("CADENA", "cadena vacia");
                        helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
                        return;
                    }
                    String cadena = this.cuenta + "*" + this.movil + "*" + this.tipoBolsa;
                    String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user_nauta_plus) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
                    String movil = BuildConfig.FLAVOR;
                    if (this.inputNumeroDestinatario.getText().toString().length() > 0) {
                        movil = " Móvil a confirmar: " + ((Object) this.inputNumeroDestinatario.getText());
                    }
                    String msg = "Confirme los siguientes datos del beneficiario de la compra de nauta Plus. " + msgUser + movil;
                    ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
                    FBsQzP3Zfj.actionCallUSSDBack(this.context, "34", cadena, msg, group, getFragmentManager());
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        if (riZsr8xXRC == RiZsr8xXRC.SIN_CUENTA && validateMovil() && validateSpBolsa()) {
            try {
                this.cuenta.toLowerCase();
                if (this.cuenta.contains("ERROR")) {
                    Log.d("CADENA", "cadena vacia");
                    helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
                } else {
                    String cadena2 = "0000*" + this.movil + "*" + this.tipoBolsa;
                    String movil2 = "Móvil del beneficiario:" + ((Object) this.inputNumeroDestinatario.getText()) + "</font>";
                    String msg2 = "Confirme el móvil del beneficiario de la compra de nauta Plus. " + movil2;
                    ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
                    FBsQzP3Zfj.actionCallUSSDBack(this.context, "34", cadena2, msg2, group2, getFragmentManager());
                }
            } catch (Exception e2) {
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
                if (c.getTipo_cuenta() == 1) {
                    String str = nom_cuenta + "@nauta.com.cu";
                } else if (c.getTipo_cuenta() == 2) {
                    String str2 = nom_cuenta + "@nauta.co.cu";
                }
                this.nautaCuentas.add(nom_cuenta);
            }
            ArrayAdapter<String> adapterCuentas = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cuentas_nautas);
            this.inputCuenta.setAdapter(adapterCuentas);
        } catch (Exception e) {
        }
    }

    public void helpAlertGestion(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ERROR!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf.6
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
