package cu.etecsa.transfermovil.banking.ui.tabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
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

    private enum Action { BALANCE, LATEST_OPERATIONS, LIMIT, ACCOUNT_STATEMENT }

    private static final class MenuRow {
        final String title;
        final String subtitle;
        final int icon;
        final Action action;

        MenuRow(String title, String subtitle, int icon, Action action) {
            this.title = title;
            this.subtitle = subtitle;
            this.icon = icon;
            this.action = action;
        }
    }

    private void selectAction(Action action) {
        Fragment destination;
        if (action == Action.BALANCE) destination = new BfiConsultarSaldoFragment();
        else if (action == Action.LATEST_OPERATIONS) destination = new BfiConsultarUltimasOperacionesFragment();
        else if (action == Action.LIMIT) destination = new BfiConsultarLimiteFragment();
        else if (action == Action.ACCOUNT_STATEMENT) destination = new BfiAccountStatementFragment();
        else return;
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, destination).addToBackStack(null).commit();
    }

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
        List<MenuRow> items = new ArrayList<>();
        add(items, R.string.tx_consultar_saldo, R.string.banco_sub_saldo,
                R.drawable.ic_consulta_saldo_bfi, Action.BALANCE);
        add(items, R.string.tx_ultimas_operaciones, R.string.tx_sub_ultimas_operaciones_bolsa,
                R.drawable.ic_consulta_ultimas_oper_bfi, Action.LATEST_OPERATIONS);
        add(items, R.string.title_tx_consulta_limite, R.string.banco_sub_consulta_limites,
                R.drawable.ic_consulta_limites_bfi, Action.LIMIT);
        add(items, R.string.banco_tx_estado_cuentas, R.string.banco_sub_estado_cuentas,
                R.drawable.ic_estado_cuentas_bfi, Action.ACCOUNT_STATEMENT);
        recyclerView.setAdapter(new MenuAdapter(items));
    }

    private void add(List<MenuRow> items, int title, int subtitle, int icon, Action action) {
        items.add(new MenuRow(getString(title), getString(subtitle), icon, action));
    }

    private final class MenuAdapter extends RecyclerView.Adapter<RowHolder> {
        private final List<MenuRow> rows;

        MenuAdapter(List<MenuRow> rows) {
            this.rows = rows;
        }

        @Override
        public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dpiivfe2yk6mn, parent, false);
            return new RowHolder(view);
        }

        @Override
        public void onBindViewHolder(RowHolder holder, int position) {
            MenuRow row = rows.get(position);
            holder.title.setText(row.title);
            holder.subtitle.setText(row.subtitle);
            holder.icon.setImageResource(row.icon);
            holder.action = row.action;
        }

        @Override
        public int getItemCount() {
            return rows.size();
        }
    }

    private final class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView title;
        final TextView subtitle;
        final ImageView icon;
        Action action;

        RowHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titulo);
            subtitle = (TextView) view.findViewById(R.id.subtitulo);
            icon = (ImageView) view.findViewById(R.id.icono);
            view.findViewById(R.id.mainHolder).setOnClickListener(this);
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            selectAction(action);
        }
    }
}
