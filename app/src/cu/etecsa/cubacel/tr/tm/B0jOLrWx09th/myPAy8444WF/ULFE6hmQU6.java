package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class ULFE6hmQU6 extends Agg55uYctq {
    public R1sDOSqZ2z agencia;
    public String agenicyL;
    public int banco;
    public Button btn_aceptar;
    private TextInputLayout lyCarnet;
    private TextInputLayout lyMulta;
    public int tipo;
    public TipoMulta tipoMulta;
    public TextView titulo;
    private AutoCompleteTextView txCarnet;
    private AutoCompleteTextView txMulta;

    public enum TipoMulta {
        Contravension,
        Transito
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.a7lmtqmap0r5i8, container, false);
        this.context = container.getContext();
        this.titulo = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.manager = new pAzq93vIl3(this.context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agenicyL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agenicyL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agenicyL = "03";
                    break;
            }
        }
        if (getArguments() != null && getArguments().containsKey("TipoMultaEntity")) {
            TipoMulta tipoMulta = (TipoMulta) getArguments().getSerializable("TipoMultaEntity");
            this.tipoMulta = tipoMulta;
            switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$myPAy8444WF$ULFE6hmQU6$TipoMulta[tipoMulta.ordinal()]) {
                case 1:
                    this.tipo = 1;
                    this.titulo.setText(this.context.getString(R.string.tx_title_consultra_contravencion));
                    break;
                case 2:
                    this.tipo = 2;
                    this.titulo.setText(this.context.getString(R.string.tx_consulta_transito));
                    break;
            }
        }
        this.lyMulta = (TextInputLayout) this.rootView.findViewById(R.id.lyMulta);
        this.lyCarnet = (TextInputLayout) this.rootView.findViewById(R.id.lyCarnet);
        this.txMulta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMulta);
        this.txCarnet = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCarnet);
        if (this.tipoMulta == TipoMulta.Transito) {
            this.lyCarnet.setHint(this.context.getString(R.string.hint_licencia_conducir));
        } else {
            this.lyCarnet.setHint(this.context.getString(R.string.hint_carnet_de_identidad));
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btn_aceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ULFE6hmQU6.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$myPAy8444WF$ULFE6hmQU6$TipoMulta;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[TipoMulta.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$myPAy8444WF$ULFE6hmQU6$TipoMulta = iArr;
            try {
                iArr[TipoMulta.Contravension.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$myPAy8444WF$ULFE6hmQU6$TipoMulta[TipoMulta.Transito.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr2;
            try {
                iArr2[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean isFieldsOK() {
        return validateMulta() && validateCIoLicencia();
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

    private void enviarUSSD() {
        String ci = "0000";
        String licencia = "0000";
        String idMulta = this.txMulta.getText().toString().trim();
        switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$myPAy8444WF$ULFE6hmQU6$TipoMulta[this.tipoMulta.ordinal()]) {
            case 1:
                ci = this.txCarnet.getText().toString().trim();
                break;
            case 2:
                licencia = this.txCarnet.getText().toString().trim();
                break;
        }
        String cadena = this.tipo + "*" + idMulta + "*" + ci + "*" + licencia;
        String msg = "Confirme que desea consultar el siguiente identificador de multa. ID de Multa: " + idMulta + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "98", "02", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "98", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMulta() {
        if (this.txMulta.getText().toString().trim().isEmpty()) {
            this.lyMulta.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txMulta);
            return false;
        }
        this.lyMulta.setErrorEnabled(false);
        return true;
    }

    private boolean validateCIoLicencia() {
        if (this.txCarnet.getText().toString().trim().isEmpty()) {
            this.lyCarnet.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txCarnet);
            return false;
        }
        this.lyCarnet.setErrorEnabled(false);
        return true;
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
