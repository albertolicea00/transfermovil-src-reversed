package cu.etecsa.transfermovil.banking.ui.tabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiConsultarLimiteFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiConsultarSaldoFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiConsultarUltimasOperacionesFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiAccountStatementFragment;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc */
public class BfiConsultationsMenuFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    private final vD9rc3MbTL.OnItemClickListener listener = new vD9rc3MbTL.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) { }
        @Override public void onGetItemClick(View view, FdonIAFI9w operation) {
            Fragment destination;
            if (operation == FdonIAFI9w.BFIConsultarSaldo) destination = new BfiConsultarSaldoFragment();
            else if (operation == FdonIAFI9w.BFIUltimasoperaciones) destination = new BfiConsultarUltimasOperacionesFragment();
            else if (operation == FdonIAFI9w.BFIConsultaLimite) destination = new BfiConsultarLimiteFragment();
            else if (operation == FdonIAFI9w.BFIEstadoCuentas) destination = new BfiAccountStatementFragment();
            else return;
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.containerView, destination).addToBackStack(null).commit();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = container.getContext();
        View root = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        recyclerView = root.findViewById(R.id.drawerList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        populate();
        return root;
    }

    private void populate() {
        List<WUULVgZq02> items = new ArrayList<>();
        add(items, R.string.tx_consultar_saldo, R.string.banco_sub_saldo,
                R.drawable.ic_consulta_saldo_bfi, FdonIAFI9w.BFIConsultarSaldo);
        add(items, R.string.tx_ultimas_operaciones, R.string.tx_sub_ultimas_operaciones_bolsa,
                R.drawable.ic_consulta_ultimas_oper_bfi, FdonIAFI9w.BFIUltimasoperaciones);
        add(items, R.string.title_tx_consulta_limite, R.string.banco_sub_consulta_limites,
                R.drawable.ic_consulta_limites_bfi, FdonIAFI9w.BFIConsultaLimite);
        add(items, R.string.banco_tx_estado_cuentas, R.string.banco_sub_estado_cuentas,
                R.drawable.ic_estado_cuentas_bfi, FdonIAFI9w.BFIEstadoCuentas);
        vD9rc3MbTL adapter = new vD9rc3MbTL(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(listener);
    }

    private void add(List<WUULVgZq02> items, int title, int subtitle, int icon, FdonIAFI9w operation) {
        WUULVgZq02 item = new WUULVgZq02();
        item.setTitulo(getString(title));
        item.setSubtitulo(getString(subtitle));
        item.setIcono(icon);
        item.setType(rBXnNc0Kx4.Post);
        item.setOperacion(operation);
        items.add(item);
    }
}
