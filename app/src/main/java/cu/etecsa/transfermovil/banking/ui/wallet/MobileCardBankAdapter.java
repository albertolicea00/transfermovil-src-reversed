package cu.etecsa.transfermovil.banking.ui.wallet;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.data.entity.MobileCardBank;
import java.util.ArrayList;
import java.util.List;

/** RecyclerView adapter for saved MiTransfer bank cards. */
public final class MobileCardBankAdapter extends RecyclerView.Adapter<MobileCardBankAdapter.Holder> {
    public interface Listener {
        void onTransfer(MobileCardBank account);
        void onQr(MobileCardBank account);
        void onEdit(MobileCardBank account);
        void onDelete(MobileCardBank account);
        void onShare(MobileCardBank account);
    }

    private final Context context;
    private final List<MobileCardBank> items = new ArrayList<>();
    private Listener listener;

    public MobileCardBankAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<MobileCardBank> accounts) {
        items.clear();
        if (accounts != null) items.addAll(accounts);
        notifyDataSetChanged();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rbrrbrw7gndvu, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        MobileCardBank account = items.get(position);
        holder.title.setText(account.getAlias());
        String card = account.getCuenta();
        holder.subtitle.setText("XXXX XXXX XXXX " + card.substring(12));
        holder.currency.setText(account.getTipo_moneda().name());
        int image = imageFor(account.getAgencia());
        if (image != 0) {
            Glide.with(context).load(image).placeholder(R.drawable.tarjeta_blanco).into(holder.bankImage);
        } else {
            holder.bankImage.setImageResource(R.drawable.tarjeta_blanco);
        }
        holder.menu.setVisibility(View.GONE);
        holder.menuVisible = false;
        holder.main.setOnClickListener(v -> {
            holder.menuVisible = !holder.menuVisible;
            holder.menu.setVisibility(holder.menuVisible ? View.VISIBLE : View.GONE);
        });
        holder.transfer.setOnClickListener(v -> { if (listener != null) listener.onTransfer(account); });
        holder.qr.setOnClickListener(v -> { if (listener != null) listener.onQr(account); });
        holder.edit.setOnClickListener(v -> { if (listener != null) listener.onEdit(account); });
        holder.share.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle("Notificación")
                .setMessage("¿Desea enviar su número de cuenta a otro destinatario? Tenga en cuenta que será enviada en texto plano y debe asegurarse de la confiabilidad del destinatario")
                .setPositiveButton("SI", (dialog, which) -> { if (listener != null) listener.onShare(account); })
                .setNegativeButton("NO", null).show());
        holder.delete.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle("Notificación")
                .setMessage("¿Desea eliminar la cuenta?")
                .setPositiveButton("SI", (dialog, which) -> { if (listener != null) listener.onDelete(account); })
                .setNegativeButton("NO", null).show());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static int imageFor(BankType bank) {
        if (bank == null) return 0;
        switch (bank) {
            case BPA: return R.drawable.tarjeta_bpa;
            case BANDEC: return R.drawable.tarjeta_bandec;
            case Metropolitano: return R.drawable.tarjeta_metro;
            case BFI: return R.drawable.tarjeta_bfi;
            case MiTransfer: return R.drawable.tarjeta_clasica;
            case CLASICAEMP: return R.drawable.tarjeta_clasica_empresarial;
            default: return 0;
        }
    }

    static final class Holder extends RecyclerView.ViewHolder {
        final CardView card;
        final TextView title;
        final ImageView bankImage;
        final TextView currency;
        final ConstraintLayout main;
        final TextView subtitle;
        final ConstraintLayout menu;
        final ConstraintLayout transfer;
        final ConstraintLayout qr;
        final ConstraintLayout edit;
        final ConstraintLayout share;
        final ConstraintLayout delete;
        boolean menuVisible;

        Holder(View view) {
            super(view);
            card = view.findViewById(R.id.cv);
            title = view.findViewById(R.id.txCuenta);
            bankImage = view.findViewById(R.id.ivBanco);
            currency = view.findViewById(R.id.txMoneda);
            main = view.findViewById(R.id.mainHolder);
            subtitle = view.findViewById(R.id.txCuentaBanco);
            menu = view.findViewById(R.id.menuContraint);
            transfer = view.findViewById(R.id.btnTransfer);
            qr = view.findViewById(R.id.btnQr);
            edit = view.findViewById(R.id.btnEdit);
            share = view.findViewById(R.id.btnShare);
            delete = view.findViewById(R.id.btnDelete);
        }
    }
}
