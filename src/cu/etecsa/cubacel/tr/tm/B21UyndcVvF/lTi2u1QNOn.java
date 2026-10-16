package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lTi2u1QNOn extends ypYiy6EkAW<ViewHolder> {
    private static final int ITEM_COUNT = 50;
    private static final String TAG = lTi2u1QNOn.class.getSimpleName();
    private static final int TYPE_ACTIVE = 1;
    private static final int TYPE_INACTIVE = 0;
    private ViewHolder.ClickListener clickListener;
    private List<yHdVJARBHM> items;

    public lTi2u1QNOn(ViewHolder.ClickListener clickListener, List<yHdVJARBHM> list) {
        this.clickListener = clickListener;
        this.items = list;
    }

    public void removeItem(int position) {
        this.items.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItems(List<Integer> positions) {
        Collections.sort(positions, new Comparator<Integer>() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lTi2u1QNOn.1
            @Override // java.util.Comparator
            public int compare(Integer lhs, Integer rhs) {
                return rhs.intValue() - lhs.intValue();
            }
        });
        while (!positions.isEmpty()) {
            if (positions.size() == 1) {
                removeItem(positions.get(0).intValue());
                positions.remove(0);
            } else {
                int count = 1;
                while (positions.size() > count && positions.get(count).equals(Integer.valueOf(positions.get(count - 1).intValue() - 1))) {
                    count++;
                }
                if (count == 1) {
                    removeItem(positions.get(0).intValue());
                } else {
                    removeRange(positions.get(count - 1).intValue(), count);
                }
                for (int i = 0; i < count; i++) {
                    positions.remove(0);
                }
            }
        }
    }

    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            this.items.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.uyh0pxs9m37in, parent, false);
        return new ViewHolder(v, this.clickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        yHdVJARBHM uyh0pxs9m37in = this.items.get(position);
        holder.title.setText(uyh0pxs9m37in.getTitulo());
        TextView textView = holder.subtitle;
        StringBuilder sb = new StringBuilder();
        sb.append(uyh0pxs9m37in.getSubtitulo());
        sb.append(uyh0pxs9m37in.isMarcado() ? "eliminar" : BuildConfig.FLAVOR);
        textView.setText(sb.toString());
        if (uyh0pxs9m37in.getSubtitulo().length() == 0) {
            holder.title.setTextColor(-65536);
        }
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(uyh0pxs9m37in.isMarcado());
            holder.itemView.setLayoutParams(sglp);
        }
        holder.cheked.setVisibility(isSelected(position) ? 0 : 4);
        holder.cheked.setChecked(isSelected(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.items.get(i).isMarcado() ? 1 : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private static final String TAG = ViewHolder.class.getSimpleName();
        public CheckBox cheked;
        private ClickListener listener;
        public TextView subtitle;
        public TextView title;

        public interface ClickListener {
            void onItemClicked(int i);

            boolean onItemLongClicked(int i);
        }

        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.titulo);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cheked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ClickListener clickListener = this.listener;
            if (clickListener != null) {
                clickListener.onItemClicked(getPosition());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            ClickListener clickListener = this.listener;
            if (clickListener != null) {
                return clickListener.onItemLongClicked(getPosition());
            }
            return false;
        }
    }
}
