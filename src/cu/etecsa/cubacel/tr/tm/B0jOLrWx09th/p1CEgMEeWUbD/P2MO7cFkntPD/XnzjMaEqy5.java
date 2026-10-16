package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XnzjMaEqy5 extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    public String cuentaCaracteres;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputCuentaWrite;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutCuentaWrite;
    private TextInputLayout inputLayoutMisCuentas;
    public TextInputLayout inputLayoutTipoMoneda;
    public int keyDel;
    public boolean lock;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public List<MCBank> misCuentas;
    public View rootView;
    public jN13TOyLMX spinnerMisCuentas;
    public jN13TOyLMX spinnerTipoMoneda;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public String tipoCuenta;
    public String[] tipomoneda;
    public int moneda = 1;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.XnzjMaEqy5.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            XnzjMaEqy5.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.omj02gayhgurc, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Factura> facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(1);
        List<String> facList = new ArrayList<>();
        for (Factura wl : facturasLists) {
            facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.XnzjMaEqy5.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XnzjMaEqy5.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.XnzjMaEqy5.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XnzjMaEqy5.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCuenta() || !validateTipoMoneda()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String msg = "Desea pagar la cuenta de electricidad: " + cuenta;
        String cadena = cuenta + "*0*" + this.moneda;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "41", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 13) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_metro));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!validateTipoMoneda()) {
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(1);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }
}
