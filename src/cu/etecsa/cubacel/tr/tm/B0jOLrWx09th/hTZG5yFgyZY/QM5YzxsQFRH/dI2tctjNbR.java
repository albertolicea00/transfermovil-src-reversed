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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dI2tctjNbR extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private Button btnAceptar;
    public Context context;
    public TextInputLayout inputLayoutMisCuentas;
    public List<TMonedasWallet> lisMonedas;
    public TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public ArrayAdapter<MCBank> mcBankArrayAdapter;
    public List<MCBank> misCuentas;
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
    public String agency = "04";
    public jN13TOyLMX.OnItemClickListener btnUltOper = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dI2tctjNbR di2tctjnbr = dI2tctjNbR.this;
            di2tctjnbr.tipoBolsa = position + 1;
            if (di2tctjnbr.spBolsas.getText().toString().equals("-MIS CUENTAS-")) {
                dI2tctjNbR di2tctjnbr2 = dI2tctjNbR.this;
                di2tctjnbr2.agency = "08";
                if (!di2tctjnbr2.cargarMisCuentas()) {
                    dI2tctjNbR.this.showDialogNoTieneCuentas();
                    dI2tctjNbR.this.inputLayoutMisCuentas.setVisibility(8);
                    return;
                } else {
                    dI2tctjNbR.this.inputLayoutMisCuentas.setVisibility(0);
                    return;
                }
            }
            dI2tctjNbR di2tctjnbr3 = dI2tctjNbR.this;
            di2tctjnbr3.agency = "04";
            di2tctjnbr3.inputLayoutMisCuentas.setVisibility(8);
            dI2tctjNbR.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
            dI2tctjNbR di2tctjnbr4 = dI2tctjNbR.this;
            di2tctjnbr4.miCuentaSeleccion = di2tctjnbr4.tipoBolsa == 1 ? "USD" : "CUP";
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = dI2tctjNbR.this.mcBankArrayAdapter.getItem(position);
            dI2tctjNbR.this.miCuentaSeleccion = mcBank.getCuenta();
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
        List<TMonedasWallet> monedasWallet = unYp8VQThY.getInstance().getMonedasWallet();
        this.lisMonedas = monedasWallet;
        if (monedasWallet == null || monedasWallet.size() <= 0) {
            this.adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_mas_mis_cuentas, android.R.layout.simple_list_item_1);
        } else {
            List<CharSequence> monedas = new ArrayList<>();
            for (TMonedasWallet moneda : this.lisMonedas) {
                monedas.add(moneda.getDescripcion());
            }
            this.adapterTipoBolsa = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, monedas);
        }
        this.adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_mis_cuentas);
        this.inputLayoutMisCuentas = textInputLayout;
        textInputLayout.setVisibility(8);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dI2tctjNbR.this.submitForm();
            }
        });
        return this.rootView;
    }

    public void submitForm() {
        if (!validateSpBolsa()) {
            return;
        }
        if (this.agency == "08" && !validateCuentaOrigen()) {
            return;
        }
        String msg = "Desea consultar las últimas operaciones de la cuenta: " + this.miCuentaSeleccion;
        String cadena = this.tipo + "*" + this.miCuentaSeleccion + "*" + this.tipoBolsa;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "48", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "48", this.agency, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
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
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR.4
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
