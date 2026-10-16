package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class A9IFPpW4HW extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutMovil;
    private EditText inputMonto;
    private AutoCompleteTextView inputMovil;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.f0rzrnjmltb5l, container, false);
        this.context = container.getContext();
        this.inputLayoutMovil = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_movil_recarga);
        this.inputMovil = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_movil_recarga);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto_recarga);
        this.inputMonto = (EditText) this.rootView.findViewById(R.id.input_monto_recarga);
        unYp8VQThY.init(this.context);
        List<TeflMovil> telfMovilLists = unYp8VQThY.getInstance().getAllMovilLists();
        List<String> telefonos = new ArrayList<>();
        for (TeflMovil wl : telfMovilLists) {
            telefonos.add(wl.getNumber());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, telefonos);
        this.inputMovil.setAdapter(adapter);
        if (getArguments() != null) {
            this.inputMovil.setText(getArguments().get("pago").toString());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                A9IFPpW4HW.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateNumber() || !validateMonto()) {
            return;
        }
        nuevoDatos();
        String cadena = this.inputMovil.getText().toString().trim() + "*" + this.inputMonto.getText().toString().trim();
        String msg = "Desea recargar el siguiente celular:  " + this.inputMovil.getText().toString() + ". Monto a transferir: " + this.inputMonto.getText().toString() + " CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRecargar);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("12", cadena, msg, group);
    }

    private boolean validateNumber() {
        if (this.inputMovil.getText().toString().trim().isEmpty()) {
            this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_movil));
            requestFocus(this.inputMovil);
            return false;
        }
        if (this.inputMovil.getText().toString().trim().length() != 8) {
            this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputMovil);
            return false;
        }
        this.inputLayoutMovil.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(this.context.getString(R.string.err_msg_monto_cel_invalid));
            requestFocus(this.inputMonto);
            return false;
        }
        this.inputLayoutMonto.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_telef = this.inputMovil.getText().toString();
        List<TeflMovil> c_list = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list.size() == 0) {
            TeflMovil c = new TeflMovil();
            c.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c);
        }
        ((IHVTCBmiLV) getActivity()).UpdateMenu();
    }
}
