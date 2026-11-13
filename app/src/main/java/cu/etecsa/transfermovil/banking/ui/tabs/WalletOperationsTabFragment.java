package cu.etecsa.transfermovil.banking.ui.tabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletPinEntryFragment;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.H0kVHR7zuu
 * @original_apk_version 1.260416
 */
public class WalletOperationsTabFragment extends Fragment {
    public Context context;
    private enum Action { AUTHENTICATE, DISCONNECT }

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
        if (action == Action.AUTHENTICATE) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerView, new WalletPinEntryFragment())
                    .addToBackStack(null).commit();
        } else if (action == Action.DISCONNECT) {
            showDialogCerrarSession();
        }
    }

    public View rootView;
    public RecyclerView rvseguridad;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.rvseguridad = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        this.rvseguridad.setLayoutManager(llmSegidad);
        initData();
        return this.rootView;
    }

    private void initData() {
        List<MenuRow> rows = new ArrayList<>();
        rows.add(new MenuRow(getString(R.string.tx_autenticarse),
                getString(R.string.tx_acceder_al_sistema),
                R.drawable.ic_autenticacion_bolsa, Action.AUTHENTICATE));
        rows.add(new MenuRow(context.getString(R.string.banco_desconectar),
                context.getString(R.string.banco_sub_desconectar),
                R.drawable.ic_desconectarse_bolsa, Action.DISCONNECT));
        rvseguridad.setAdapter(new MenuAdapter(rows));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletOperationsTabFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) WalletOperationsTabFragment.this.getActivity()).actionCallUSSD("70");
                        return;
                    } else {
                        ((IHVTCBmiLV) WalletOperationsTabFragment.this.getActivity()).actionCallUSSD("70");
                        return;
                    }
                }
                ((S9ycHcoxAzy) WalletOperationsTabFragment.this.getActivity()).actionCallUSSD("70");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletOperationsTabFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        UssdDispatcher.closeSessionBank(getActivity());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
