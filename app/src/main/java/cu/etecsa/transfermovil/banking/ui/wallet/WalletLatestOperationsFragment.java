package cu.etecsa.transfermovil.banking.ui.wallet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR */
public class WalletLatestOperationsFragment extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    private Context context;
    private View rootView;
    private TextInputLayout accountLayout;
    private TextInputLayout walletLayout;
    private jN13TOyLMX walletSelector;
    private jN13TOyLMX accountSelector;
    private ArrayAdapter<CharSequence> walletAdapter;
    private ArrayAdapter<MCBank> accountAdapter;
    private pAzq93vIl3 ussdManager;
    private int walletType;
    private String selectedValue = BuildConfig.FLAVOR;
    private String agency = "04";
    private boolean partialUssd;
    private static final int MAX_PACKET_PARAMETERS = 4;

    private final jN13TOyLMX.OnItemClickListener walletClick = new jN13TOyLMX.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) {
            walletType = position + 1;
            if ("-MIS CUENTAS-".equals(walletSelector.getText().toString())) {
                agency = "08";
                if (loadAccounts()) accountLayout.setVisibility(View.VISIBLE);
                else {
                    showNoAccountsDialog();
                    accountLayout.setVisibility(View.GONE);
                }
            } else {
                agency = "04";
                accountLayout.setVisibility(View.GONE);
                accountSelector.setText(BuildConfig.FLAVOR);
                selectedValue = walletType == 1 ? "USD" : "CUP";
            }
        }
    };

    private final jN13TOyLMX.OnItemClickListener accountClick = new jN13TOyLMX.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) {
            MCBank account = accountAdapter.getItem(position);
            selectedValue = account == null ? BuildConfig.FLAVOR : account.getCuenta();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.lymnfdpmxjeos, container, false);
        context = container.getContext();
        ussdManager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(context);
        walletLayout = rootView.findViewById(R.id.lyBolsas);
        walletSelector = rootView.findViewById(R.id.spBolsas);
        List<TMonedasWallet> currencies = unYp8VQThY.getInstance().getMonedasWallet();
        if (currencies == null || currencies.isEmpty()) {
            walletAdapter = ArrayAdapter.createFromResource(context, R.array.array_bolsa_mas_mis_cuentas, android.R.layout.simple_list_item_1);
        } else {
            List<CharSequence> labels = new ArrayList<>();
            for (TMonedasWallet currency : currencies) labels.add(currency.getDescripcion());
            walletAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, labels);
        }
        walletAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        walletSelector.setAdapter(walletAdapter);
        walletSelector.setOnItemClickListener(walletClick);
        accountLayout = rootView.findViewById(R.id.input_layout_mis_cuentas);
        accountLayout.setVisibility(View.GONE);
        accountSelector = rootView.findViewById(R.id.spinnerCuentas);
        Button accept = rootView.findViewById(R.id.btn_aceptar);
        accept.setOnClickListener(view -> submitForm());
        return rootView;
    }

    public void submitForm() {
        if (!validateWallet()) return;
        if ("08".equals(agency) && !validateAccount()) return;
        String message = "Desea consultar las últimas operaciones de la cuenta: " + selectedValue;
        String payload = "1*" + selectedValue + "*" + walletType;
        ViewGroup form = rootView.findViewById(R.id.frmView);
        try {
            partialUssd = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception ignored) {
            partialUssd = false;
        }
        if (!partialUssd) {
            UssdDispatcher.actionCallUSSDBack(context, "48", payload, message, form, getFragmentManager());
        } else {
            ussdManager.principalEnviarUSSD(context, "110", "48", agency, MAX_PACKET_PARAMETERS,
                    payload, message, form, getFragmentManager());
        }
    }

    private boolean validateWallet() {
        if (walletSelector.getText().toString().trim().isEmpty()) {
            walletLayout.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(walletSelector);
            return false;
        }
        walletLayout.setErrorEnabled(false);
        return true;
    }

    private boolean validateAccount() {
        if (accountSelector.getText().toString().trim().isEmpty()) {
            accountLayout.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(accountSelector);
            return false;
        }
        if (selectedValue.length() != 16) {
            accountLayout.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(accountSelector);
            return false;
        }
        accountLayout.setErrorEnabled(false);
        return true;
    }

    private boolean loadAccounts() {
        try {
            List<MCBank> walletAccounts = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.MiTransfer);
            List<MCBank> enterpriseAccounts = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.CLASICAEMP);
            accountAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
            if ((walletAccounts == null || walletAccounts.isEmpty()) && (enterpriseAccounts == null || enterpriseAccounts.isEmpty())) return false;
            if (walletAccounts != null) for (MCBank account : walletAccounts) accountAdapter.add(account);
            if (enterpriseAccounts != null) for (MCBank account : enterpriseAccounts) accountAdapter.add(account);
            accountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            accountSelector.setAdapter(accountAdapter);
            accountSelector.setOnItemClickListener(accountClick);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    private void showNoAccountsDialog() {
        new AlertDialog.Builder(context).setTitle("Aviso")
                .setMessage("No tiene cuentas registradas para este banco")
                .setPositiveButton("OK", (dialog, id) -> { }).show();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) getActivity().getWindow().setSoftInputMode(5);
    }

    @Override public void onUssdResponseReceived(String response) { }

    @Override public void onCloseAndBack() {
        try {
            getActivity().getSupportFragmentManager().popBackStack();
        } catch (Exception ignored) {
            try { getActivity().onBackPressed(); } catch (Exception ignoredAgain) { }
        }
    }
}
