package cu.etecsa.transfermovil.banking.ui.bpa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * BPA session management sub-menu fragment.
 *
 * <p>Presents two operations: "Autenticarse" (authenticate/login) and
 * "Desconectar" (disconnect/close session). The authenticate option
 * navigates to the auth fragment; disconnect shows a confirmation dialog
 * that dispatches USSD code "70" and calls
 * {@code UssdDispatcher.closeSessionBank()}.</p>
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.p97uirGL7T
 * @original_apk_version 1.260416
 */
public class BpaSessionMenuFragment extends Fragment {

    private Context context;
    private View rootView;
    private RecyclerView recyclerView;

    /**
     * Click listener that routes operations:
     * <pre>
     *   1 → BPAAutenticarse  → lzGEfceoJu (BpaAuthFragment)
     *   2 → BPADesconectar   → showDialogCerrarSession() → USSD "70"
     * </pre>
     */
    private final OperationMenuAdapter.OnItemClickListener onItemClickListener =
            new OperationMenuAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    // Not used; routing is by operation code
                }

                @Override
                public void onGetItemClick(View view, BankOperationCode operacion) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    switch (operacion) {
                        case BPAAutenticarse:
                            ft.replace(R.id.containerView, new BpaAuthFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPADesconectar:
                            showDialogCerrarSession();
                            break;
                        default:
                            Toast.makeText(context, "Error! " + operacion,
                                    Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_operations_list, container, false);
        context = container.getContext();
        recyclerView = rootView.findViewById(R.id.drawerList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        initData();
        return rootView;
    }

    /**
     * Populates the menu with 2 session operations.
     */
    private void initData() {
        List<OperationMenuItem> items = new ArrayList<>();

        OperationMenuItem autenticarse = new OperationMenuItem();
        autenticarse.setTitle("Autenticarse");
        autenticarse.setSubtitle("Acceder al sistema");
        autenticarse.setIcon(R.drawable.ic_autenticacion_bpa);
        autenticarse.setType(OperationMenuItem.TYPE_POST);
        autenticarse.setOperationCode(BankOperationCode.BPAAutenticarse);
        items.add(autenticarse);

        OperationMenuItem close = new OperationMenuItem();
        close.setTitle(context.getString(R.string.banco_desconectar));
        close.setSubtitle(context.getString(R.string.banco_sub_desconectar));
        close.setIcon(R.drawable.ic_desconectarse_bpa);
        close.setType(OperationMenuItem.TYPE_POST);
        close.setOperationCode(BankOperationCode.BPADesconectar);
        items.add(close);

        OperationMenuAdapter adapter = new OperationMenuAdapter(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
    }

    /**
     * Shows confirmation dialog for closing the bank session.
     * Calls {@code UssdDispatcher.closeSessionBank()} before showing the dialog,
     * then dispatches USSD code "70" if user confirms.
     */
    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage(context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("70");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        UssdDispatcher.closeSessionBank(getActivity());
        builder.create().show();
    }

    /**
     * Dispatches a USSD code through the appropriate activity interface.
     * Checks whether the current agent code contains "-1" to decide
     * between legacy (S9ycHcoxAzy) and new (IHVTCBmiLV) activity cast.
     *
     * @param code the USSD operation code
     */
    private void dispatchUssd(String code) {
        BaseMainActivity bs = new BaseMainActivity();
        if (bs.getCodeAgent() != null && !bs.getCodeAgent().getCode().contains("-1")) {
            ((BankingActivity) getActivity()).actionCallUSSD(code);
        } else {
            ((MainBankingActivity) getActivity()).actionCallUSSD(code);
        }
    }
}
