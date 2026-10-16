package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JUhL44kV5Z extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNumero;
    private AutoCompleteTextView inputNumero;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.dyzl6egrqjyoz, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<TelfFijo> telfFijosLists = unYp8VQThY.getInstance().getAllFijoLists();
        List<String> telefonos = new ArrayList<>();
        for (TelfFijo wl : telfFijosLists) {
            telefonos.add(wl.getNumber());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputLayoutNumero = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cfnumero);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cfnumero);
        this.inputNumero = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.JUhL44kV5Z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JUhL44kV5Z.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNumero()) {
            return;
        }
        nuevoDatos();
        String numero = this.inputNumero.getText().toString().trim();
        String msg = "Desea consultar la factura del " + getString(R.string.hint_numero) + ": " + numero;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmUltimosPagos);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("3", numero, msg, group);
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_telef = this.inputNumero.getText().toString();
        List<TelfFijo> c_list = unYp8VQThY.getInstance().getFijoListsWithPhoneNumber(edit_telef);
        if (c_list.size() == 0) {
            TelfFijo c = new TelfFijo();
            c.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfFijo(c);
        }
        ((IHVTCBmiLV) getActivity()).UpdateMenu();
    }
}
