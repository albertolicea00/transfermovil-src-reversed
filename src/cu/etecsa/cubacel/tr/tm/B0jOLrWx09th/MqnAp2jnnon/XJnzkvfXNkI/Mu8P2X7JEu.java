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
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Mu8P2X7JEu extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutPredeterminarpin;
    private AutoCompleteTextView inputPredeterminarpin;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.mns3c5qngy65s, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Pin> pinLists = unYp8VQThY.getInstance().getAllPinLists();
        List<String> pins = new ArrayList<>();
        for (Pin wl : pinLists) {
            pins.add(wl.getPin());
        }
        ArrayAdapter<String> adapterPin = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, pins);
        this.inputLayoutPredeterminarpin = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_predeterminarpin);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_predeterminarpin);
        this.inputPredeterminarpin = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapterPin);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.Mu8P2X7JEu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Mu8P2X7JEu.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validatePin()) {
            return;
        }
        nuevoDatos();
        String pin = this.inputPredeterminarpin.getText().toString().trim();
        String msg = "Desea Predeterminar el pin : " + pin;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmPredeterminar);
        ((IHVTCBmiLV) getActivity()).actionCallUSSD("0", pin, msg, group);
    }

    private boolean validatePin() {
        if (this.inputPredeterminarpin.getText().toString().trim().isEmpty()) {
            this.inputLayoutPredeterminarpin.setError(getString(R.string.err_msg_empty_pin));
            requestFocus(this.inputPredeterminarpin);
            return false;
        }
        if (this.inputPredeterminarpin.getText().toString().trim().length() != 12) {
            this.inputLayoutPredeterminarpin.setError(getString(R.string.err_msg_len_pin));
            requestFocus(this.inputPredeterminarpin);
            return false;
        }
        this.inputLayoutPredeterminarpin.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_pin = this.inputPredeterminarpin.getText().toString();
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
