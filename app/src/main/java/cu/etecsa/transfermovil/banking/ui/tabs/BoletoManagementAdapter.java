package cu.etecsa.transfermovil.banking.ui.tabs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.List;

/** Clean model and row adapter for the MiTransfer registration management menu. */
public final class BoletoManagementAdapter
        extends RecyclerView.Adapter<BoletoManagementAdapter.ViewHolder> {

    public enum Action {
        REGISTER,
        CHANGE_PIN,
        DELETE_REGISTRATION,
        ASSOCIATE_CLASSIC_ACCOUNT
    }

    public static final class MenuItem {
        public final String title;
        public final String subtitle;
        public final int icon;
        public final Action action;

        public MenuItem(String title, String subtitle, int icon, Action action) {
            this.title = title;
            this.subtitle = subtitle;
            this.icon = icon;
            this.action = action;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Action action);
    }

    private final List<MenuItem> items;
    private OnItemClickListener listener;

    public BoletoManagementAdapter(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dpiivfe2yk6mn, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem item = items.get(position);
        holder.title.setText(item.title);
        holder.subtitle.setText(item.subtitle);
        holder.icon.setImageResource(item.icon);
        holder.action = item.action;
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final CardView card;
        public final ImageView icon;
        public final ImageView favorite;
        public final TextView title;
        public final TextView subtitle;
        public final RelativeLayout placeholder;
        private Action action;

        ViewHolder(View view) {
            super(view);
            card = view.findViewById(R.id.cv);
            icon = view.findViewById(R.id.icono);
            favorite = view.findViewById(R.id.fav);
            title = view.findViewById(R.id.titulo);
            subtitle = view.findViewById(R.id.subtitulo);
            placeholder = view.findViewById(R.id.mainHolder);
            placeholder.setOnClickListener(this);
            view.setClickable(true);
            view.setOnClickListener(v -> notifyItemClick(v));
        }

        @Override
        public void onClick(View view) {
            notifyItemClick(itemView);
        }

        private void notifyItemClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, action);
            }
        }
    }
}
