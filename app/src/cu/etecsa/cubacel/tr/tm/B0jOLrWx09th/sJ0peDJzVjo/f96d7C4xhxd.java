package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

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
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class f96d7C4xhxd extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public R1sDOSqZ2z agencia;
    public Button btnAceptar;
    public Context context;
    public TextInputLayout inputLayoutTipoMoneda;
    public TextInputLayout lyCarnet;
    public TextInputLayout lyMonto;
    public TextInputLayout lyUsuario;
    public int moneda;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public AutoCompleteTextView txCarnet;
    public AutoCompleteTextView txMonto;
    public AutoCompleteTextView txUsuario;
    public int banco = 0;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.f96d7C4xhxd.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (f96d7C4xhxd.this.isFieldsOK()) {
                try {
                    f96d7C4xhxd.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.f96d7C4xhxd.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f96d7C4xhxd.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.n0gnqzvd1gtmw3, container, false);
        this.context = container.getContext();
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass3.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    break;
                case 2:
                    this.banco = 2;
                    break;
                case 3:
                    this.banco = 3;
                    break;
            }
        }
        loadViewUI(this.rootView);
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.f96d7C4xhxd$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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
        this.spinnerTipoMoneda = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoMoneda);
        this.inputLayoutTipoMoneda = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        if (this.banco == 2) {
            this.inputLayoutTipoMoneda.setVisibility(8);
        }
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        if (validateUsuario() && validateCi() && validateMonto()) {
            return this.agencia == R1sDOSqZ2z.BANDEC || validateTipoMoneda();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        String usuario = this.txUsuario.getText().toString().trim();
        String ci = this.txCarnet.getText().toString().trim();
        Float monto = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
        String cadena = usuario + "*" + ci + "*" + String.valueOf(monto) + "*" + this.moneda;
        String numberAsString = String.format("%.2f", monto);
        String msg = "Confirme los siguientes datos a recargar: Usuario: " + usuario + ", Carnet de identidad: " + ci + ", Importe a recargar: " + numberAsString + " CUP";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "93", cadena, msg, group, getFragmentManager());
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

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
