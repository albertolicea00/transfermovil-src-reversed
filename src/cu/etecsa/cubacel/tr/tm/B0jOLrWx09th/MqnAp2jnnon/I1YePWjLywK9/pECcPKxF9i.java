package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class pECcPKxF9i extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public Context context;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutTipo;
    public final CharSequence[] items = {"Cuenta Internacional", "Cuenta Nacional"};
    public View rootView;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public String[] titles;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.lerjfsqpawoqx, container, false);
        this.context = container.getContext();
        this.titles = getResources().getStringArray(R.array.array_tipo_cuenta_nauta);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_nauta_nombre);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_nauta_nombre);
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
        this.inputCuenta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.pECcPKxF9i.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(pECcPKxF9i.this.inputCuenta.getText().toString());
                if (nautaCuenta.size() == 2) {
                    pECcPKxF9i.this.showDialogWithCheckBox();
                    return;
                }
                Nauta item_nauta = nautaCuenta.get(0);
                if (item_nauta.getTipo_cuenta() == 1) {
                    pECcPKxF9i peccpkxf9i = pECcPKxF9i.this;
                    peccpkxf9i.tipoCuenta = "1";
                    peccpkxf9i.id_tipo_cuenta = 1;
                    peccpkxf9i.spinnerTipo.setText(String.valueOf(peccpkxf9i.titles[0].toString()));
                    return;
                }
                pECcPKxF9i peccpkxf9i2 = pECcPKxF9i.this;
                peccpkxf9i2.id_tipo_cuenta = 2;
                peccpkxf9i2.tipoCuenta = "2";
                peccpkxf9i2.spinnerTipo.setText(String.valueOf(peccpkxf9i2.titles[1].toString()));
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.pECcPKxF9i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                pECcPKxF9i.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateTipoCuentaNauta()) {
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
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        String cadenaSolicitud = codingUser + "*" + this.tipoCuenta;
        String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
        String msTipoCuenta = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + NombreTipoCuenta + "</font>";
        String msg = "Confirme los siguientes datos de la cuenta Nauta a recargar: " + msgUser + msTipoCuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaConsultaSaldo);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("92", cadenaSolicitud, msg, group);
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCuenta.getText().toString().trim().split(" ");
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_nauta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.text_su_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context).setTitle("La cuenta tiene dos tipos de cuentas, Seleccione una:").setItems(this.items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.pECcPKxF9i.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    pECcPKxF9i peccpkxf9i = pECcPKxF9i.this;
                    peccpkxf9i.tipoCuenta = "1";
                    peccpkxf9i.id_tipo_cuenta = 1;
                    peccpkxf9i.spinnerTipo.setText(String.valueOf(peccpkxf9i.titles[0].toString()));
                    return;
                }
                pECcPKxF9i peccpkxf9i2 = pECcPKxF9i.this;
                peccpkxf9i2.id_tipo_cuenta = 2;
                peccpkxf9i2.tipoCuenta = "2";
                peccpkxf9i2.spinnerTipo.setText(String.valueOf(peccpkxf9i2.titles[1].toString()));
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
        ((IHVTCBmiLV) getActivity()).UpdateMenu();
    }

    public void helpAlertGestion(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ERROR!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.pECcPKxF9i.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
