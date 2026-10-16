package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DmvQBLZLbV extends ypYiy6EkAW<ViewHolder> {
    private static final int ITEM_COUNT = 50;
    private static final String TAG = DmvQBLZLbV.class.getSimpleName();
    private static final int TYPE_ACTIVE = 1;
    private static final int TYPE_INACTIVE = 0;
    public FragmentActivity activity;
    private ViewHolder.ClickListener clickListener;
    public Context context;
    private List<yHdVJARBHM> items;
    public int operation;

    public DmvQBLZLbV(ViewHolder.ClickListener clickListener, List<yHdVJARBHM> list, FragmentActivity activity, Context context) {
        this.operation = 0;
        this.clickListener = clickListener;
        this.items = list;
        this.activity = activity;
        this.operation = 0;
        this.context = context;
    }

    public void removeItem(int position) {
        this.items.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItems(List<Integer> positions) {
        Collections.sort(positions, new Comparator<Integer>() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.DmvQBLZLbV.1
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
        return new ViewHolder(v, this.clickListener, this.activity, this.operation, this.items, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        yHdVJARBHM uyh0pxs9m37in = this.items.get(position);
        String alias = uyh0pxs9m37in.getTitulo();
        holder.title.setText(alias);
        holder.subtitle.setText(uyh0pxs9m37in.getSubtitulo());
        holder.btn_pagar.setImageResource(R.drawable.qr_btn);
        holder.btn_check.setVisibility(8);
        if (uyh0pxs9m37in.getSubtitulo() != null && uyh0pxs9m37in.getSubtitulo().length() == 0) {
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
        private static final String TAG = khginYXYg6.ViewHolder.class.getSimpleName();
        public FragmentActivity activity;
        public ImageView btn_check;
        public ImageView btn_pagar;
        public CheckBox cheked;
        public Context context;
        public List<yHdVJARBHM> itemList;
        private khginYXYg6.ViewHolder.ClickListener listener;
        public int operation;
        public TextView subtitle;
        public TextView title;

        public interface ClickListener extends khginYXYg6.ViewHolder.ClickListener {
            @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
            void onItemClicked(int i);

            @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
            boolean onItemLongClicked(int i);

            @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
            boolean showQR(int i);
        }

        public ViewHolder(View itemView, khginYXYg6.ViewHolder.ClickListener listener) {
            super(itemView);
            this.operation = 0;
            this.title = (TextView) itemView.findViewById(R.id.titulo);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cheked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            this.btn_pagar = (ImageView) itemView.findViewById(R.id.btn_pagar);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.btn_check);
            this.btn_check = imageView;
            imageView.setVisibility(8);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public ViewHolder(View itemView, final khginYXYg6.ViewHolder.ClickListener listener, FragmentActivity activity, int operation, List<yHdVJARBHM> itemList, Context context) {
            super(itemView);
            this.operation = 0;
            this.title = (TextView) itemView.findViewById(R.id.titulo);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cheked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            this.btn_pagar = (ImageView) itemView.findViewById(R.id.btn_pagar);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.btn_check);
            this.btn_check = imageView;
            imageView.setVisibility(8);
            this.operation = operation;
            this.listener = listener;
            this.itemList = itemList;
            this.activity = activity;
            this.context = context;
            this.btn_pagar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.DmvQBLZLbV.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    listener.showQR(ViewHolder.this.getLayoutPosition());
                }
            });
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            this.itemList.get(getPosition());
            FragmentManager mFragmentManager = this.activity.getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            if (this.listener != null && v.getId() != this.btn_pagar.getId() && v.getId() != this.btn_check.getId()) {
                this.listener.onItemClicked(getPosition());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            khginYXYg6.ViewHolder.ClickListener clickListener = this.listener;
            if (clickListener != null) {
                return clickListener.onItemLongClicked(getPosition());
            }
            return false;
        }
    }
}
