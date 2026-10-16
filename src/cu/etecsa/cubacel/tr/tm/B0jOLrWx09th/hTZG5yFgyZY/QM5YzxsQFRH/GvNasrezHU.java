package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GvNasrezHU extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private Button btnAceptar;
    public Context context;
    public TextInputLayout inputLayoutMisCuentas;
    public TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public int pos_tipo;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public jN13TOyLMX spinnerMisCuentas;
    public TextView toolbar_title;
    public int tipoBolsa = 0;
    public String miCuentaSeleccion = BuildConfig.FLAVOR;
    public String tipo = "1";
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public jN13TOyLMX.OnItemClickListener btnUltOper = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            GvNasrezHU gvNasrezHU = GvNasrezHU.this;
            gvNasrezHU.tipoBolsa = position + 1;
            switch (position) {
                case 0:
                    if (!gvNasrezHU.cargarMisCuentas()) {
                        GvNasrezHU.this.showDialogNoTieneCuentas();
                        GvNasrezHU.this.inputLayoutMisCuentas.setVisibility(8);
                    } else {
                        GvNasrezHU.this.inputLayoutMisCuentas.setVisibility(0);
                    }
                    break;
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = GvNasrezHU.this.mcBankArrayAdapter.getItem(position);
            GvNasrezHU.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.lymnfdpmxjeos, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(this.context);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_mis_cuentas, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_mis_cuentas);
        this.inputLayoutMisCuentas = textInputLayout;
        textInputLayout.setVisibility(8);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.title_consulta_saldo_rec);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GvNasrezHU.this.submitForm();
            }
        });
        return this.rootView;
    }

    public void submitForm() {
        if (!validateSpBolsa() || !validateCuentaOrigen()) {
            return;
        }
        String msg = "Desea consultar el saldo de la cuenta: " + this.miCuentaSeleccion;
        String cadena = this.tipo + "*" + this.miCuentaSeleccion + "*" + this.tipoBolsa;
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "46", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "46", "08", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    private boolean validateCuentaOrigen() {
        if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        if (this.miCuentaSeleccion.length() != 16) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        this.inputLayoutMisCuentas.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("No tiene cuentas registradas para este banco");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.MiTransfer);
            List<MCBank> listClasic = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.CLASICAEMP);
            this.mcBankArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            if ((list == null || list.size() <= 0) && (listClasic == null || listClasic.size() <= 0)) {
                return false;
            }
            if (list != null && list.size() > 0) {
                for (MCBank uyh0pxs9m37in : list) {
                    this.mcBankArrayAdapter.add(uyh0pxs9m37in);
                }
            }
            if (listClasic != null && listClasic.size() > 0) {
                for (MCBank uyh0pxs9m37in2 : listClasic) {
                    this.mcBankArrayAdapter.add(uyh0pxs9m37in2);
                }
            }
            this.mcBankArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerMisCuentas.setAdapter(this.mcBankArrayAdapter);
            this.spinnerMisCuentas.setOnItemClickListener(this.spClickMisCuentas);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
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
