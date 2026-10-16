package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6;

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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yzFfgPWLpL extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutNumero;
    private AutoCompleteTextView inputNumero;
    public String menuOpcion = "4";
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.f5dpfn502q14dj, container, false);
        this.context = container.getContext();
        this.inputLayoutNumero = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_ultima_recarga);
        this.inputNumero = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_ultima_recarga);
        unYp8VQThY.init(this.context);
        List<TeflMovil> telfMovilLists = unYp8VQThY.getInstance().getAllMovilLists();
        List<String> telefonos = new ArrayList<>();
        for (TeflMovil wl : telfMovilLists) {
            telefonos.add(wl.getNumber());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputNumero.setAdapter(adapter);
        if (getArguments() != null) {
            this.inputNumero.setText(getArguments().get("movil").toString());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.yzFfgPWLpL.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                yzFfgPWLpL.this.submitForm();
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
        String cadena = this.menuOpcion + "*" + this.inputNumero.getText().toString().trim();
        String msg = this.context.getString(R.string.msg_consult_recarga) + this.inputNumero.getText().toString().trim();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmUltimasRecargas);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("11", cadena, msg, group);
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
        List<TeflMovil> c_list = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list.size() == 0) {
            TeflMovil c = new TeflMovil();
            c.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c);
        }
        ((IHVTCBmiLV) getActivity()).UpdateMenu();
    }
}
