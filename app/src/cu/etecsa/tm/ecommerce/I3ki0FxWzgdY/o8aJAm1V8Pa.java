package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB;
import cu.etecsa.tm.ecommerce.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o8aJAm1V8Pa extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<HD5RIUn7tB> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, int i2);

        void onGetItemClick(View view, int i, HD5RIUn7tB hD5RIUn7tB);

        void onGetItemCuentaClick(View view, int i, HD5RIUn7tB hD5RIUn7tB);
    }

    public o8aJAm1V8Pa(Context context, List<HD5RIUn7tB> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.q4houtzmrfrck, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.idCuenta = this.itemList.get(i).getId();
        holder.item = this.itemList.get(i);
        holder.txNombreCuenta.setText(this.itemList.get(i).getDescripcion());
        holder.txNumeroCuenta.setText(this.itemList.get(i).getSource());
        holder.txMoneda.setText(this.itemList.get(i).getMoneda());
        holder.txFechaCreacion.setText(this.itemList.get(i).getFechaCreacion());
        if (this.itemList.get(i).isActivo()) {
            holder.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.verde));
            holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_done_white));
        } else {
            holder.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo));
            holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<HD5RIUn7tB> list = this.itemList;
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
        public CardView cdEstado;
        public CardView cv;
        public int idCuenta;
        public ImageView imStatus;
        public HD5RIUn7tB item;
        public int posItem;
        public TextView txFechaCreacion;
        public TextView txMoneda;
        public TextView txNombreCuenta;
        public TextView txNumeroCuenta;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txMoneda = (TextView) view.findViewById(R.id.txMoneda);
            this.txFechaCreacion = (TextView) view.findViewById(R.id.txFechaCreacion);
            this.cdEstado = (CardView) view.findViewById(R.id.cdEstado);
            this.txNumeroCuenta = (TextView) view.findViewById(R.id.txNumeroCuenta);
            this.txNombreCuenta = (TextView) view.findViewById(R.id.txNombreCuenta);
            this.imStatus = (ImageView) view.findViewById(R.id.imStatus);
            this.cv.setOnLongClickListener(this);
            this.cv.setOnClickListener(this);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            OnItemClickListener onItemClickListener = o8aJAm1V8Pa.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.idCuenta);
                o8aJAm1V8Pa.this.mItemClickListener.onGetItemCuentaClick(this.itemView, this.posItem, this.item);
                return true;
            }
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            OnItemClickListener onItemClickListener = o8aJAm1V8Pa.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.item);
            }
        }
    }
}
