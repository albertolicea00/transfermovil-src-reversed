package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class hvC0UGR2L0 extends Fragment {
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    private AutoCompleteTextView inputMonto;
    public final CharSequence[] items = {"Pago Total", "Pago Parcial"};
    public boolean pagoTotal = false;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ygewp0nwxxef8, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Factura> facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(0);
        List<String> facList = new ArrayList<>();
        for (Factura wl : facturasLists) {
            facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.hvC0UGR2L0.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                hvC0UGR2L0.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.hvC0UGR2L0.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hvC0UGR2L0.this.submitForm();
            }
        });
        showDialogWithCheckBox();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String msg;
        if (!validateCuenta() || !validateMonto()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        this.inputMonto.getText().toString().trim();
        String monedaFactura = BuildConfig.FLAVOR;
        try {
            if (cuenta.charAt(2) == '1') {
                monedaFactura = "CUP";
            } else if (cuenta.charAt(2) == '2') {
                monedaFactura = "CUC";
            } else {
                monedaFactura = "NO ES POSIBLE IDENTIFICAR LA MONEDA";
            }
        } catch (Exception e) {
        }
        String monto = "0";
        String msg2 = "Desea realizar el pago total de la cuenta: " + cuenta;
        if (this.pagoTotal) {
            msg = msg2;
        } else {
            monto = this.inputMonto.getText().toString().trim();
            String msg3 = "¿ Desea pagar la cuenta: " + cuenta + ", con el monto: " + monto + " " + monedaFactura + " ?. El monto y moneda corresponde a la moneda de la cuenta";
            msg = msg3;
        }
        String cadena = cuenta + "*" + monto;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "42", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 15 && this.inputCuenta.getText().toString().trim().length() != 14) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.inputMonto.getText().toString().trim().isEmpty()) {
                this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.inputMonto);
                return false;
            }
            this.inputLayoutMonto.setErrorEnabled(false);
            return true;
        }
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
            c.setTipo_Factura(0);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    private void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setSingleChoiceItems(this.items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.hvC0UGR2L0.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                hvC0UGR2L0.this.formVisibility(i);
            }
        });
        builder.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.hvC0UGR2L0.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void formVisibility(int opcion) {
        if (opcion != 0) {
            this.inputLayoutMonto.setEnabled(true);
            this.pagoTotal = false;
            return;
        }
        this.inputLayoutMonto.setEnabled(false);
        this.inputMonto.setEnabled(false);
        this.inputMonto.setVisibility(8);
        this.inputLayoutMonto.setVisibility(8);
        this.pagoTotal = true;
    }
}
