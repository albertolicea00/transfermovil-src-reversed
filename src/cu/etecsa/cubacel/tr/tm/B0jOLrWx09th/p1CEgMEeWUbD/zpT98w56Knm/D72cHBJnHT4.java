package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class D72cHBJnHT4 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    public int id_tipo_cuenta;
    public TextInputLayout inputLayoutTipo;
    public TextInputLayout inputLayoutTipoMoneda;
    public int pos_tipo;
    public View rootView;
    public jN13TOyLMX spinnerTipo;
    public jN13TOyLMX spinnerTipoMoneda;
    public String tipoCuenta;
    public String[] tipomoneda;
    public String[] titles;
    public int moneda = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.D72cHBJnHT4.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            D72cHBJnHT4.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.bsfsfqussrhdk, container, false);
        this.context = container.getContext();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.D72cHBJnHT4.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                D72cHBJnHT4.this.submitForm();
            }
        });
        this.titles = getResources().getStringArray(R.array.array_ultimas_operaciones);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_ultimas_operaciones, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateTipoCuenta() || !validateTipoMoneda()) {
            return;
        }
        int position_select = this.spinnerTipo.getPosition_select();
        this.pos_tipo = position_select;
        String idTipo = String.valueOf(position_select + 1);
        String msg = "Desea consultar las ultimas operaciones de:" + ((Object) this.spinnerTipo.getText());
        String cadena = idTipo + "*" + this.moneda;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "48", cadena, msg, group, getFragmentManager());
    }

    private boolean validateTipoCuenta() {
        if (this.spinnerTipo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipo.setError("Seleccione el tipo de servicio");
            requestFocus(this.spinnerTipo);
            return false;
        }
        this.inputLayoutTipo.setErrorEnabled(false);
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
}
