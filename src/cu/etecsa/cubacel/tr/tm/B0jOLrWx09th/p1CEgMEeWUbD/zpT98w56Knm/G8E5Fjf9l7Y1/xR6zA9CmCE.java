package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class xR6zA9CmCE extends Agg55uYctq {
    private Button btnAceptar;
    private AutoCompleteTextView inputATM;
    private TextInputLayout inputLayoutATM;
    private TextInputLayout inputLayoutPOS;
    private TextInputLayout inputLayoutTOTAL;
    private AutoCompleteTextView inputPOS;
    private AutoCompleteTextView inputTOTAL;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.vx38bjtn0eckz, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.inputLayoutATM = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_atm);
        this.inputATM = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_atm);
        this.inputLayoutPOS = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pos);
        this.inputPOS = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pos);
        this.inputLayoutTOTAL = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_total);
        this.inputTOTAL = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_limite_total);
        this.inputLayoutTOTAL.setVisibility(8);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.Metropolitano);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xR6zA9CmCE.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateSumaApp() || !validateSelectionAccounts()) {
            return;
        }
        String atm = this.inputATM.getText().toString().trim();
        String pos = this.inputPOS.getText().toString().trim();
        int sumaTotal = 0;
        try {
            int atmF = Integer.parseInt(atm);
            int posF = Integer.parseInt(pos);
            sumaTotal = atmF + posF;
        } catch (Exception e) {
        }
        String total = String.valueOf(sumaTotal);
        String msg = String.format("¿Desea modificar los límites temporalmente de sus cuentas bancarias? Límites temporales establecidos: ATM: %s, POS:%s y Total: %s.", atm, pos, total);
        String cadena = atm + "*" + pos + "*" + total + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmLimiteBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "61", "03", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "61", cadena, msg, group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateCuenta() {
        if (this.inputATM.getText().toString().trim().isEmpty()) {
            this.inputLayoutATM.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputATM);
            return false;
        }
        this.inputLayoutATM.setErrorEnabled(false);
        if (this.inputPOS.getText().toString().trim().isEmpty()) {
            this.inputLayoutPOS.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputPOS);
            return false;
        }
        this.inputLayoutPOS.setErrorEnabled(false);
        return true;
    }

    private boolean validateSumaApp() {
        try {
            float atm = Float.parseFloat(this.inputATM.getText().toString().trim());
            float pos = Float.parseFloat(this.inputPOS.getText().toString().trim());
            if (atm > 0.0f) {
                this.inputLayoutATM.setErrorEnabled(false);
                if (pos > 0.0f) {
                    this.inputLayoutPOS.setErrorEnabled(false);
                    return true;
                }
                this.inputLayoutPOS.setError("El valor de POS debe ser mayor que cero");
                requestFocus(this.inputPOS);
                return false;
            }
            this.inputLayoutATM.setError("El valor de ATM debe ser mayor que cero");
            requestFocus(this.inputATM);
            return false;
        } catch (Exception e) {
            this.inputLayoutATM.setError("Valor incorrecto");
            requestFocus(this.inputATM);
            this.inputLayoutPOS.setError("Valor incorrecto");
            return false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
        FragmentManager fragmentManager = getFragmentManager();
        Bundle result = new Bundle();
        result.putBoolean("returning", true);
        fragmentManager.setFragmentResult("returnToA", result);
        fragmentManager.popBackStack();
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
