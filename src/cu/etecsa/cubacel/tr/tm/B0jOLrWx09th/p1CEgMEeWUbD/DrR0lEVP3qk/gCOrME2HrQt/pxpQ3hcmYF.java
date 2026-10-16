package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class pxpQ3hcmYF extends Agg55uYctq {
    private Button btnAceptar;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutRC04;
    private TextInputLayout inputLayoutRC05;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputRC04;
    private AutoCompleteTextView inputRC05;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.uaofdnorhvuxr, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutRC04 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc04);
        this.inputRC04 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc04);
        this.inputLayoutRC05 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc05);
        this.inputRC05 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc05);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        unYp8VQThY.init(this.context);
        List<ServicioPublico> servLists = unYp8VQThY.getInstance().getFacturasListsTipoServicio(0);
        List<String> onatList = new ArrayList<>();
        for (ServicioPublico wl : servLists) {
            onatList.add(wl.getValor());
        }
        if (onatList.size() > 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, onatList);
            this.inputRC05.setAdapter(adapter);
            this.inputRC05.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.pxpQ3hcmYF.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    pxpQ3hcmYF.this.inputRC05.showDropDown();
                }
            });
        }
        if (getArguments() != null) {
            this.inputRC05.setText(getArguments().get("servicio").toString());
        }
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BPA);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.pxpQ3hcmYF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pxpQ3hcmYF.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateLicencia() || !validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String licencia = this.inputRC04.getText().toString().trim() + "*" + this.inputRC05.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        String cadena = licencia + "*" + monto + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String msg = "Desea pagar la ONAT, RC04A: " + this.inputRC04.getText().toString() + ", RC05: " + this.inputRC05.getText().toString();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmOnat);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "43", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "43", "01", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
