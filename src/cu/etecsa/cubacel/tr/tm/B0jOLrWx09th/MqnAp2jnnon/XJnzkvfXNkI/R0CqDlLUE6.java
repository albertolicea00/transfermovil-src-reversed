package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI;

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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class R0CqDlLUE6 extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNumero;
    private TextInputLayout inputLayoutPin;
    private AutoCompleteTextView inputNumero;
    private AutoCompleteTextView inputPin;
    public final CharSequence[] items = {"Usar pin predeterminado", "Insertar otro pin"};
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ofg514xse7rk9, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Pin> pinLists = unYp8VQThY.getInstance().getAllPinLists();
        List<TelfFijo> telfFijosLists = unYp8VQThY.getInstance().getAllFijoLists();
        List<String> telefonos = new ArrayList<>();
        for (TelfFijo wl : telfFijosLists) {
            telefonos.add(wl.getNumber());
        }
        List<String> pins = new ArrayList<>();
        for (Pin wl2 : pinLists) {
            pins.add(wl2.getPin());
        }
        ArrayAdapter<String> adapterPin = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, pins);
        ArrayAdapter<String> adapterTelefono = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputLayoutNumero = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pfnumero);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pfnumero);
        this.inputNumero = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapterTelefono);
        this.inputLayoutPin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pfpin);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pfpin);
        this.inputPin = autoCompleteTextView2;
        autoCompleteTextView2.setAdapter(adapterPin);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.R0CqDlLUE6.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                R0CqDlLUE6.this.submitForm();
            }
        });
        if (getArguments() != null) {
            this.inputNumero.setText(getArguments().get("pago").toString());
            this.inputPin.setText(getArguments().get("pago_pin").toString());
            if (getArguments().get("pago_pin").toString().isEmpty()) {
                showDialogWithCheckBox();
            }
        } else {
            showDialogWithCheckBox();
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String cadena;
        if ((this.inputPin.isEnabled() && !validatePin()) || !validateNumero()) {
            return;
        }
        nuevoDatos();
        String numero = this.inputNumero.getText().toString().trim();
        String pin = this.inputPin.getText().toString().trim();
        if (this.inputPin.isEnabled()) {
            cadena = BuildConfig.FLAVOR + pin + "*" + numero;
        } else {
            cadena = BuildConfig.FLAVOR + "000000000000*" + numero;
        }
        String msg = "Desea pagar la factura del " + getString(R.string.hint_numero) + ": " + numero;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmPagarFactura);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("2", cadena, msg, group);
    }

    private boolean validateNumero() {
        if (this.inputNumero.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumero.setError(getString(R.string.err_msg_empty_numero));
            requestFocus(this.inputNumero);
            return false;
        }
        if (this.inputNumero.getText().toString().trim().length() != 8) {
            this.inputLayoutNumero.setError(getString(R.string.err_msg_len_numero));
            requestFocus(this.inputNumero);
            return false;
        }
        this.inputLayoutNumero.setErrorEnabled(false);
        return true;
    }

    private boolean validatePin() {
        if (this.inputPin.getText().toString().trim().isEmpty()) {
            this.inputLayoutPin.setError(getString(R.string.err_msg_err_pin));
            requestFocus(this.inputPin);
            return false;
        }
        if (this.inputPin.getText().toString().trim().length() != 12) {
            this.inputLayoutPin.setError(getString(R.string.err_msg_len_pin));
            requestFocus(this.inputPin);
            return false;
        }
        this.inputLayoutPin.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void formVisibility(int opcion) {
        if (opcion == 0) {
            this.inputLayoutPin.setEnabled(false);
            this.inputPin.setEnabled(false);
            this.inputPin.setVisibility(8);
            this.inputLayoutPin.setVisibility(8);
            return;
        }
        this.inputLayoutPin.setEnabled(true);
        this.inputPin.setEnabled(true);
        this.inputPin.setVisibility(0);
        this.inputLayoutPin.setVisibility(0);
    }

    private void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setSingleChoiceItems(this.items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.R0CqDlLUE6.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                R0CqDlLUE6.this.formVisibility(i);
            }
        });
        builder.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.R0CqDlLUE6.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void nuevoDatos() {
        String edit_pin = this.inputPin.getText().toString();
        String edit_telef = this.inputNumero.getText().toString();
        List<TelfFijo> c_list = unYp8VQThY.getInstance().getFijoListsWithPhoneNumber(edit_telef);
        if (c_list.size() == 0) {
            TelfFijo c = new TelfFijo();
            c.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfFijo(c);
        }
        List<Pin> p_list = unYp8VQThY.getInstance().getPinListsWithNumPin(edit_pin);
        if (p_list.size() == 0) {
            Pin p = new Pin();
            p.setDescripcion(BuildConfig.FLAVOR);
            p.setPin(edit_pin);
            unYp8VQThY.getInstance().addPin(p);
        }
        ((IHVTCBmiLV) getActivity()).UpdateMenu();
    }
}
