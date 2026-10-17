package cu.etecsa.transfermovil.banking.ui.tabs;

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
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletPinEntryFragment;
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.H0kVHR7zuu
 *
 * Wallet session tab — "Sesión". Shows authenticate + disconnect options.
 * On authenticate → navigates to WalletPinEntryFragment.
 * On disconnect → shows confirmation dialog, sends USSD code 70.
 */
public class WalletOperationsTabFragment extends Fragment {

    public Context context;
    public View rootView;
    public RecyclerView recyclerView;

    public OperationListAdapter.OnItemClickListener onItemClickListener = new OperationListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onGetItemClick(View view, BankOperationCode operacion) {
            FragmentManager fm = WalletOperationsTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (operacion != null) {
                switch (operacion) {
                    case BOLSAAutenticarse:
                        ft.replace(R.id.containerView, new WalletPinEntryFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSADesconectar:
                        WalletOperationsTabFragment.this.showDialogCloseSession();
                        break;
                    default:
                        Toast.makeText(WalletOperationsTabFragment.this.context, operacion.toString(), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rv = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.recyclerView = rv;
        rv.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.context);
        this.recyclerView.setLayoutManager(llm);
        initData();
        return this.rootView;
    }

    private void initData() {
        List<OperationItem> items = new ArrayList<>();

        OperationItem auth = new OperationItem();
        auth.setTitulo(getString(R.string.tx_autenticarse));
        auth.setSubtitulo(getString(R.string.tx_acceder_al_sistema));
        auth.setIcono(R.drawable.ic_autenticacion_bolsa);
        auth.setType(OperationItem.TYPE_POST);
        auth.setOperacion(BankOperationCode.BOLSAAutenticarse);
        items.add(auth);

        OperationItem close = new OperationItem();
        close.setTitulo(this.context.getString(R.string.banco_desconectar));
        close.setSubtitulo(this.context.getString(R.string.banco_sub_desconectar));
        close.setIcono(R.drawable.ic_desconectarse_bolsa);
        close.setType(OperationItem.TYPE_POST);
        close.setOperacion(BankOperationCode.BOLSADesconectar);
        items.add(close);

        OperationListAdapter adapter = new OperationListAdapter(this.context, items);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    void showDialogCloseSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                UssdDispatcher.closeSessionBank(getActivity());
                // Routes through agent code check to determine activity cast
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        UssdDispatcher.closeSessionBank(getActivity());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
