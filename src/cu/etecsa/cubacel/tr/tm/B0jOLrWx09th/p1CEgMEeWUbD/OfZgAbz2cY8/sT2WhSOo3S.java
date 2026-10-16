package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class sT2WhSOo3S extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutTipoMoneda;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public String tipoCuenta;
    public String[] tipomoneda;
    public TextView title;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.omj02gayhgurc, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Factura> facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(3);
        List<String> facList = new ArrayList<>();
        for (Factura wl : facturasLists) {
            facList.add(wl.getFactura());
        }
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.title = textView;
        textView.setText("Pago del Gas");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.sT2WhSOo3S.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                sT2WhSOo3S.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        this.tipomoneda = getResources().getStringArray(R.array.array_gas_bandec);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.inputLayoutTipoMoneda = textInputLayout;
        textInputLayout.setVisibility(0);
        this.inputLayoutTipoMoneda.setHint("Tipo de pago");
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_gas_bandec, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.sT2WhSOo3S.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sT2WhSOo3S.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        int idCurrency;
        if (!validateCuenta() || !validateTipoMoneda()) {
            return;
        }
        nuevoDatos();
        int pos_tipoMoneda = this.spinnerTipoMoneda.getPosition_select();
        if (pos_tipoMoneda == 0) {
            idCurrency = 1;
        } else {
            idCurrency = 2;
        }
        String cuenta = this.inputCuenta.getText().toString().trim();
        String msg = "Desea pagar la cuenta del gas: " + cuenta;
        String cadena = cuenta + "*0*" + idCurrency;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "67", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 12) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_12_metro));
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
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo pago a ejecutar");
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
            c.setTipo_Factura(3);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }
}
