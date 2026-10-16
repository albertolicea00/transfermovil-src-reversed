package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.cyVKjSmMxV;
import cu.etecsa.tm.ecommerce.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bk1v6NAFu8 extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<cyVKjSmMxV> itemList;
    public OnItemCheckListener mItemCheckListener;

    public interface OnItemCheckListener {
        void onGetItemCheck(View view, int i, int i2, boolean z);
    }

    public bk1v6NAFu8(Context context, List<cyVKjSmMxV> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g0aexzxtucb1le, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.id = this.itemList.get(i).getCodigo();
        holder.posItem = i;
        holder.txPermiso.setText(this.itemList.get(i).getDescripcion());
        if (this.itemList.get(i).isEstado()) {
            holder.swPermiso.setChecked(true);
        } else {
            holder.swPermiso.setChecked(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<cyVKjSmMxV> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOnItemClickListener(OnItemCheckListener mItemCheckListener) {
        this.mItemCheckListener = mItemCheckListener;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
        public CardView cv;
        public int id;
        public int posItem;
        public Switch swPermiso;
        public TextView txPermiso;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txPermiso = (TextView) view.findViewById(R.id.txPermiso);
            Switch r0 = (Switch) view.findViewById(R.id.swPermiso);
            this.swPermiso = r0;
            r0.setOnCheckedChangeListener(this);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            OnItemCheckListener onItemCheckListener = bk1v6NAFu8.this.mItemCheckListener;
            if (onItemCheckListener != null) {
                onItemCheckListener.onGetItemCheck(this.itemView, this.posItem, this.id, isChecked);
            }
        }
    }
}
