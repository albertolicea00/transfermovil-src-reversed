package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class yn4mwNjGz0 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public Context context;
    public boolean editMode = false;
    private TextInputLayout inputLayoutPin;
    private TextInputLayout inputLayoutTipo;
    private EditText inputPin;
    public Pin pin;
    public jN13TOyLMX spinnerTipo;
    public TextView toolbar_title;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sg3dggd9my8k3, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutPin = (TextInputLayout) rootView.findViewById(R.id.input__layout_pin);
        this.inputLayoutTipo = (TextInputLayout) rootView.findViewById(R.id.input__layout_tipo);
        this.inputPin = (EditText) rootView.findViewById(R.id.input_pin);
        this.spinnerTipo = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipo);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        if (getArguments() != null) {
            this.toolbar_title.setText(R.string.title_edit_pin);
            int IdPin = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            Pin pinListWithId = unYp8VQThY.getInstance().getPinListWithId(IdPin);
            this.pin = pinListWithId;
            this.inputPin.setText(pinListWithId.getPin());
            this.spinnerTipo.setText(this.pin.getDescripcion());
            this.editMode = true;
        } else {
            this.toolbar_title.setText(R.string.title_new_pin);
            this.pin = new Pin();
        }
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.yn4mwNjGz0.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                yn4mwNjGz0.this.submitForm();
            }
        });
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validatePin() || !validateDescripcion()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.yn4mwNjGz0.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(yn4mwNjGz0.this.context);
                yn4mwNjGz0 yn4mwnjgz0 = yn4mwNjGz0.this;
                yn4mwnjgz0.pin.setPin(yn4mwnjgz0.inputPin.getText().toString());
                yn4mwNjGz0 yn4mwnjgz1 = yn4mwNjGz0.this;
                yn4mwnjgz1.pin.setDescripcion(yn4mwnjgz1.spinnerTipo.getText().toString());
                if (yn4mwNjGz0.this.editMode) {
                    unYp8VQThY.getInstance().updatePin(yn4mwNjGz0.this.pin);
                } else {
                    unYp8VQThY.getInstance().addPin(yn4mwNjGz0.this.pin);
                }
                ((IHVTCBmiLV) yn4mwNjGz0.this.getActivity()).UpdateMenu();
                yn4mwNjGz0.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validatePin() {
        if (this.inputPin.getText().toString().trim().isEmpty()) {
            this.inputLayoutPin.setError(getString(R.string.err_msg_empty_pin));
            requestFocus(this.inputPin);
            return false;
        }
        if (this.inputPin.getText().toString().trim().length() != 12) {
            this.inputLayoutPin.setError(getString(R.string.err_msg_len_pin));
            requestFocus(this.inputPin);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !this.inputPin.getText().toString().contains(this.pin.getPin()))) {
            if (unYp8VQThY.getInstance().getPinListsWithNumPin(this.inputPin.getText().toString().trim()).size() != 0) {
                this.inputLayoutPin.setError(this.context.getString(R.string.num_pin_existe));
                requestFocus(this.inputPin);
                return false;
            }
            this.inputLayoutPin.setErrorEnabled(false);
            return true;
        }
        return true;
    }

    private boolean validateDescripcion() {
        if (this.spinnerTipo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipo.setError(getString(R.string.err_msg_empty_tipo_cuenta));
            requestFocus(this.spinnerTipo);
            return false;
        }
        this.inputLayoutTipo.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
