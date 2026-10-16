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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LjOlaYSSMH extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public CheckBox checkBoxMyPhone;
    public CheckBox checkBoxSendSaldo;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    public int enviarMiMovil;
    public int enviarSaldo;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    private List<TMonedasWallet> lisMonedas;
    private TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public TextView txContacto;
    private AutoCompleteTextView txMonedaImporte;
    public int tipoBolsa = 0;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.LjOlaYSSMH.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || LjOlaYSSMH.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    LjOlaYSSMH.this.busk_contactos(v);
                } else {
                    LjOlaYSSMH.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.LjOlaYSSMH.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            LjOlaYSSMH ljOlaYSSMH = LjOlaYSSMH.this;
            ljOlaYSSMH.tipoBolsa = position + 1;
            if (position == 0) {
                ljOlaYSSMH.txMonedaImporte.setText("USD");
            } else if (position == 1) {
                ljOlaYSSMH.txMonedaImporte.setText("CUP");
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.uockimotqgolg, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.btnContacts = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        CheckBox checkBox = (CheckBox) this.rootView.findViewById(R.id.checkBoxMyPhone);
        this.checkBoxMyPhone = checkBox;
        checkBox.setEnabled(true);
        this.checkBoxSendSaldo = (CheckBox) this.rootView.findViewById(R.id.checkBoxSendSaldo);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_tipo_moneda_importe);
        this.inputLayoutTipoMonedaImporte = textInputLayout;
        textInputLayout.setVisibility(0);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        List<TMonedasWallet> monedasWalletSinMisCuentas = unYp8VQThY.getInstance().getMonedasWalletSinMisCuentas();
        this.lisMonedas = monedasWalletSinMisCuentas;
        if (monedasWalletSinMisCuentas == null || monedasWalletSinMisCuentas.size() <= 0) {
            this.adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        } else {
            List<CharSequence> monedas = new ArrayList<>();
            for (TMonedasWallet moneda : this.lisMonedas) {
                if (!moneda.getDescripcion().equals("-MIS CUENTAS-")) {
                    monedas.add(moneda.getDescripcion());
                }
            }
            this.adapterTipoBolsa = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, monedas);
        }
        this.adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        this.btnContacts.setOnClickListener(this.btnContactsOnClick);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.LjOlaYSSMH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LjOlaYSSMH.this.submitForm();
            }
        });
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        this.enviarMiMovil = 0;
        this.enviarSaldo = 0;
        if (!validateCuenta() || !validateMonto()) {
            return;
        }
        String importe = this.inputMonto.getText().toString().trim();
        if (!validateSpBolsa()) {
            return;
        }
        if (this.checkBoxMyPhone.isChecked()) {
            this.enviarMiMovil = 1;
        }
        if (this.checkBoxSendSaldo.isChecked()) {
            this.enviarSaldo = 1;
        }
        String cuentaDestino = this.inputCuenta.getText().toString().trim();
        String cadena = cuentaDestino + "*" + importe + "*0*" + this.enviarMiMovil + "*" + this.enviarSaldo + "*" + this.tipoBolsa;
        String msg = "Desea transferir " + importe + " " + this.txMonedaImporte.getText().toString() + " a la cuenta del número " + cuentaDestino;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "45", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "45", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMonto() {
        String montoStr = this.inputMonto.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.inputLayoutMonto.setError("No se permiten ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
            requestFocus(this.inputMonto);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
                requestFocus(this.inputMonto);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.inputLayoutMonto.setError("Monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty() || this.inputCuenta.getText().toString().trim().length() != 8) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_num_cel_eight_bolsa));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
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

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
