package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk;

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
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Udt22QU0bZ extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutRC04;
    private TextInputLayout inputLayoutRC05;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputRC04;
    private AutoCompleteTextView inputRC05;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public String[] tipomoneda;
    public int monedaTarjeta = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.Udt22QU0bZ.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            Udt22QU0bZ.this.monedaTarjeta = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.va8n98hpxnf15, container, false);
        this.context = container.getContext();
        this.inputLayoutRC04 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc04);
        this.inputRC04 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc04);
        this.inputLayoutRC05 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc05);
        this.inputRC05 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc05);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        this.inputLayoutTipoMoneda.setVisibility(0);
        unYp8VQThY.init(this.context);
        List<ServicioPublico> servLists = unYp8VQThY.getInstance().getFacturasListsTipoServicio(0);
        List<String> onatList = new ArrayList<>();
        for (ServicioPublico wl : servLists) {
            onatList.add(wl.getValor());
        }
        if (onatList.size() > 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, onatList);
            this.inputRC05.setAdapter(adapter);
            this.inputRC05.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.Udt22QU0bZ.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Udt22QU0bZ.this.inputRC05.showDropDown();
                }
            });
        }
        if (getArguments() != null) {
            this.inputRC05.setText(getArguments().get("servicio").toString());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.Udt22QU0bZ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Udt22QU0bZ.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateLicencia() || !validateMonto() || !validateTipoMoneda()) {
            return;
        }
        nuevoDatos();
        String moneda = String.valueOf(this.monedaTarjeta);
        String licencia = this.inputRC04.getText().toString().trim() + "*" + this.inputRC05.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String cadena = licencia + "*" + monto + "*" + moneda;
        String msg = "Desea pagar la ONAT, RC04A: " + this.inputRC04.getText().toString() + ", RC05: " + this.inputRC05.getText().toString();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmOnat);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "43", cadena, msg, group, getFragmentManager());
    }

    private boolean validateLicencia() {
        if (this.inputRC04.getText().toString().trim().isEmpty()) {
            this.inputLayoutRC04.setError(getString(R.string.err_msg_empty_rc04));
            requestFocus(this.inputRC04);
            return false;
        }
        if (this.inputRC05.getText().toString().trim().isEmpty()) {
            this.inputLayoutRC05.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputRC05);
            return false;
        }
        this.inputLayoutRC04.setErrorEnabled(false);
        this.inputLayoutRC05.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
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
        String edit_onat = this.inputRC05.getText().toString();
        List<ServicioPublico> c_list = unYp8VQThY.getInstance().getServicioPublicoListsWithValor(edit_onat);
        if (c_list.size() == 0) {
            ServicioPublico s = new ServicioPublico();
            s.setTipo_servicio(0);
            s.setCod_servicio("RC05");
            s.setValor(edit_onat);
            unYp8VQThY.getInstance().addServicioPublico(s);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }
}
