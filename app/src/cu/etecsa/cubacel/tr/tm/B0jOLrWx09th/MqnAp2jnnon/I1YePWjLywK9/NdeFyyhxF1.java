package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NdeFyyhxF1 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public Context context;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutNumeroDestinatario;
    private TextInputLayout inputLayoutTicket;
    public TextInputLayout inputLayoutTipo;
    private AutoCompleteTextView inputNumeroDestinatario;
    private EditText inputTicket;
    public final CharSequence[] items = {"Cuenta Internacional", "Cuenta Nacional"};
    public int modulo = 0;
    public View rootView;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public String[] titles;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null && getArguments().containsKey("modulo")) {
            this.modulo = getArguments().getInt("modulo");
        }
        this.rootView = inflater.inflate(R.layout.q4tjwwbyqyxzti, container, false);
        this.context = container.getContext();
        this.titles = getResources().getStringArray(R.array.array_tipo_cuenta_nauta);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nauta_nombre);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nauta_nombre);
        this.inputLayoutTicket = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nauta_code_bono);
        this.inputTicket = (EditText) this.rootView.findViewById(R.id.input_nauta_code_bono);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nauta_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nauta_phone_confirm);
        if (this.modulo == 1) {
            this.inputNumeroDestinatario.setVisibility(8);
            this.inputLayoutNumeroDestinatario.setVisibility(8);
        }
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cuenta_nauta, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        unYp8VQThY.init(this.context);
        List<Nauta> nautaLists = unYp8VQThY.getInstance().getAllNautaLists();
        List<String> cuentas_nautas = new ArrayList<>();
        List<Integer> tipos_cuentas = new ArrayList<>();
        for (Nauta c : nautaLists) {
            String nom_cuenta = c.getCuenta();
            if (!cuentas_nautas.contains(nom_cuenta)) {
                cuentas_nautas.add(nom_cuenta);
            }
            tipos_cuentas.add(Integer.valueOf(c.getTipo_cuenta()));
        }
        ArrayAdapter<String> adapterCuentas = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cuentas_nautas);
        this.inputCuenta.setAdapter(adapterCuentas);
        this.inputCuenta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(NdeFyyhxF1.this.inputCuenta.getText().toString());
                if (nautaCuenta.size() == 2) {
                    NdeFyyhxF1.this.showDialogWithCheckBox();
                    return;
                }
                Nauta item_nauta = nautaCuenta.get(0);
                if (item_nauta.getTipo_cuenta() == 1) {
                    NdeFyyhxF1 ndeFyyhxF1 = NdeFyyhxF1.this;
                    ndeFyyhxF1.tipoCuenta = "1";
                    ndeFyyhxF1.id_tipo_cuenta = 1;
                    ndeFyyhxF1.spinnerTipo.setText(String.valueOf(ndeFyyhxF1.titles[0].toString()));
                    return;
                }
                NdeFyyhxF1 ndeFyyhxF2 = NdeFyyhxF1.this;
                ndeFyyhxF2.id_tipo_cuenta = 2;
                ndeFyyhxF2.tipoCuenta = "2";
                ndeFyyhxF2.spinnerTipo.setText(String.valueOf(ndeFyyhxF2.titles[1].toString()));
            }
        });
        List<TeflMovil> telfMovilLists = unYp8VQThY.getInstance().getAllMovilLists();
        List<String> telefonos = new ArrayList<>();
        for (TeflMovil wl : telfMovilLists) {
            telefonos.add(wl.getNumber());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputNumeroDestinatario.setAdapter(adapter1);
        if (getArguments() != null && getArguments().containsKey("pago")) {
            String cuenta = getArguments().get("pago").toString();
            String[] arr = cuenta.split("@");
            this.inputCuenta.setText(arr[0]);
            if (arr[1].contains(".com.cu")) {
                this.tipoCuenta = "1";
                this.id_tipo_cuenta = 1;
                this.spinnerTipo.setText(String.valueOf(this.titles[0].toString()));
            } else if (arr[1].contains(".co.cu")) {
                this.id_tipo_cuenta = 2;
                this.tipoCuenta = "2";
                this.spinnerTipo.setText(String.valueOf(this.titles[1].toString()));
            }
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NdeFyyhxF1.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String cadenaSolicitud;
        if (!validateCuenta() || !validateBono() || !validateTipoCuentaNauta() || !validateNumber()) {
            return;
        }
        String tipo = this.spinnerTipo.getText().toString().trim();
        int tamanno = tipo.length();
        String NombreTipoCuenta = BuildConfig.FLAVOR;
        if (tamanno == 24) {
            this.tipoCuenta = "1";
        }
        if (tamanno == 24) {
            this.tipoCuenta = "1";
            this.id_tipo_cuenta = 1;
            NombreTipoCuenta = "Cuenta Internacional";
        } else if (tamanno == 19) {
            this.tipoCuenta = "2";
            NombreTipoCuenta = "Cuenta Nacional";
            this.id_tipo_cuenta = 2;
        }
        nuevoDatos();
        new kR22DOzTiB();
        String codingUser = this.inputCuenta.getText().toString().trim().toLowerCase();
        if (codingUser.contains("ERROR")) {
            Log.d("CADENA", "cadena vacia");
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        if (this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            cadenaSolicitud = this.inputTicket.getText().toString() + "*" + codingUser + "*" + this.tipoCuenta + "*00000000";
        } else {
            cadenaSolicitud = this.inputTicket.getText().toString() + "*" + codingUser + "*" + this.tipoCuenta + "*" + this.inputNumeroDestinatario.getText().toString();
        }
        String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
        String msPin = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_numero_bono) + "</font><font color=#f44336>" + this.inputTicket.getText().toString() + "</font>";
        String msTipoCuenta = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + NombreTipoCuenta + "</font>";
        String msg = "Confirme los siguientes datos de la cuenta Nauta a recargar: " + msgUser + msPin + msTipoCuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaRecarga);
        rDEl7rW1aN bs = new rDEl7rW1aN();
        if (bs.getCodeAgent() != null && !bs.getCodeAgent().getCode().contains("-1")) {
            ((IHVTCBmiLV) getActivity()).actionCallUSSD("90", cadenaSolicitud, msg, group);
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
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateBono() {
        if (this.inputTicket.getText().toString().trim().isEmpty()) {
            this.inputLayoutTicket.setError(this.context.getString(R.string.err_msg_nauta_monto_vacio));
            requestFocus(this.inputTicket);
            return false;
        }
        if (this.inputTicket.getText().toString().trim().length() != 12 && this.inputTicket.getText().toString().trim().length() != 16) {
            this.inputLayoutTicket.setError(this.context.getString(R.string.err_msg_nauta_monto_incorrecto));
            requestFocus(this.inputTicket);
            return false;
        }
        this.inputLayoutTicket.setErrorEnabled(false);
        return true;
    }

    private boolean validateTipoCuentaNauta() {
        if (this.spinnerTipo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipo.setError("Seleccione un tipo de cuenta Nauta");
            requestFocus(this.spinnerTipo);
            return false;
        }
        this.inputLayoutTipo.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context).setTitle("La cuenta tiene dos tipos de cuentas, Seleccione una:").setItems(this.items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    NdeFyyhxF1 ndeFyyhxF1 = NdeFyyhxF1.this;
                    ndeFyyhxF1.tipoCuenta = "1";
                    ndeFyyhxF1.id_tipo_cuenta = 1;
                    ndeFyyhxF1.spinnerTipo.setText(String.valueOf(ndeFyyhxF1.titles[0].toString()));
                    return;
                }
                NdeFyyhxF1 ndeFyyhxF2 = NdeFyyhxF1.this;
                ndeFyyhxF2.id_tipo_cuenta = 2;
                ndeFyyhxF2.tipoCuenta = "2";
                ndeFyyhxF2.spinnerTipo.setText(String.valueOf(ndeFyyhxF2.titles[1].toString()));
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_nauta = this.inputCuenta.getText().toString();
        int tipo = this.id_tipo_cuenta;
        List<Nauta> c_list = unYp8VQThY.getInstance().getNautaListsWithAccount(edit_nauta, tipo);
        if (c_list.size() == 0) {
            Nauta c = new Nauta();
            c.setCuenta(edit_nauta);
            c.setTipo_cuenta(this.id_tipo_cuenta);
            unYp8VQThY.getInstance().addNauta(c);
        }
        String edit_telef = this.inputNumeroDestinatario.getText().toString();
        List<TeflMovil> c_list_dest = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list_dest.size() == 0) {
            TeflMovil c2 = new TeflMovil();
            c2.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c2);
        }
        rDEl7rW1aN bs = new rDEl7rW1aN();
        if (bs.getCodeAgent() != null && !bs.getCodeAgent().getCode().contains("-1")) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        }
    }

    public void helpAlertGestion(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ERROR!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean validateNumber() {
        if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8 && !this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }
}
