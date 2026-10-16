package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.dyNtEg2NFV;
import cu.etecsa.tm.ecommerce.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Q0oVunEdUV extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<dyNtEg2NFV> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, int i2);

        void onGetItemClick(View view, int i, HD5RIUn7tB hD5RIUn7tB);

        void onGetItemCuentaClick(View view, int i, HD5RIUn7tB hD5RIUn7tB);
    }

    public Q0oVunEdUV(Context context, List<dyNtEg2NFV> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.u6qxyxqst0ormv, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.idCuenta = this.itemList.get(i).getId();
        holder.txNombreCuenta.setText(this.itemList.get(i).getUser());
        holder.txCantidad.setText(this.itemList.get(i).getCantidad());
        holder.txImporte.setText(this.itemList.get(i).getImporte() + " " + this.itemList.get(i).getMoneda());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<dyNtEg2NFV> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public CardView cv;
        public int idCuenta;
        public int posItem;
        public TextView txCantidad;
        public TextView txImporte;
        public TextView txNombreCuenta;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txNombreCuenta = (TextView) view.findViewById(R.id.txNombreCuenta);
            this.txCantidad = (TextView) view.findViewById(R.id.txCantidad);
            this.txImporte = (TextView) view.findViewById(R.id.txImporte);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            if (Q0oVunEdUV.this.mItemClickListener != null) {
                return true;
            }
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            OnItemClickListener onItemClickListener = Q0oVunEdUV.this.mItemClickListener;
        }
    }
}
