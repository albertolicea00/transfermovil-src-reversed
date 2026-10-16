package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

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
public class w1lXYiCfJyk extends Agg55uYctq {
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public Button btnAceptar;
    public TextInputLayout inputLayoutTipoMoneda;
    public TextInputLayout lyCarnet;
    public TextInputLayout lyMonto;
    public TextInputLayout lyUsuario;
    public AutoCompleteTextView txCarnet;
    public AutoCompleteTextView txMonto;
    public AutoCompleteTextView txUsuario;
    public int banco = 0;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.w1lXYiCfJyk.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            w1lXYiCfJyk.this.submitForm();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.l5akmg8xmsysl, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agencyL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agencyL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agencyL = "03";
                    break;
            }
        }
        loadViewUI(this.rootView);
        initComponentesCuentas(this.rootView, this.agencia);
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.w1lXYiCfJyk$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void loadViewUI(View v) {
        this.lyUsuario = (TextInputLayout) v.findViewById(R.id.lyUsuario);
        this.txUsuario = (AutoCompleteTextView) v.findViewById(R.id.txUsuario);
        this.lyCarnet = (TextInputLayout) v.findViewById(R.id.lyCarnet);
        this.txCarnet = (AutoCompleteTextView) v.findViewById(R.id.txCarnet);
        this.lyMonto = (TextInputLayout) v.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        this.lyUsuario = (TextInputLayout) v.findViewById(R.id.lyUsuario);
        this.txUsuario = (AutoCompleteTextView) v.findViewById(R.id.txUsuario);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (isFieldsOK()) {
            try {
                enviarUSSD();
            } catch (Exception e) {
            }
        }
    }

    private boolean isFieldsOK() {
        return validateUsuario() && validateCi() && validateMonto() && validateSelectionAccounts();
    }

    private void enviarUSSD() {
        String usuario = this.txUsuario.getText().toString().trim();
        String ci = this.txCarnet.getText().toString().trim();
        Float monto = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
        String cadena = usuario + "*" + ci + "*" + String.valueOf(monto) + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String numberAsString = String.format("%.2f", monto);
        String msg = "Confirme los siguientes datos a recargar: Usuario: " + usuario + ", Carnet de identidad: " + ci + ", Importe a recargar: " + numberAsString + " CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "93", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "93", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateUsuario() {
        if (this.txUsuario.getText().toString().trim().isEmpty()) {
            this.lyUsuario.setError(this.context.getString(R.string.err_msg_joven_club_cuenta));
            requestFocus(this.txUsuario);
            return false;
        }
        this.lyUsuario.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        this.lyMonto.setErrorEnabled(false);
        try {
            float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
            if (importe < 1.0f) {
                this.lyMonto.setError(getString(R.string.err_msg_importe_inferior_cup));
                requestFocus(this.txMonto);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.lyMonto.setError("Monto incorrecto");
            requestFocus(this.txMonto);
            return false;
        }
    }

    private boolean validateCi() {
        if (this.txCarnet.getText().toString().trim().isEmpty()) {
            this.lyCarnet.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.txCarnet);
            return false;
        }
        this.lyCarnet.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
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
