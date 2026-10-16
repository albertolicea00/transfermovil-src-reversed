package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
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

/* JADX INFO: loaded from: classes.dex */
public class n1lAq5KrpfE extends RecyclerView.Adapter<a2dVPTG0kZc> {
    private Context context;
    private List<qkUMT7ePEQ> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public n1lAq5KrpfE(Context contexts, List<qkUMT7ePEQ> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.j090c4o52czjo2, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.tituloTextView.setText(this.itemList.get(i).getTitulo());
        customViewHolder.subtituloTextView.setText(this.itemList.get(i).getSubtitulo());
        customViewHolder.iconoImageView.setImageResource(this.itemList.get(i).getIcono());
        customViewHolder.cantidadTextView.setText(this.itemList.get(i).getCantidad());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<qkUMT7ePEQ> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cantidadTextView;
        public CardView cv;
        public ImageView iconoImageView;
        public RelativeLayout placeHolder;
        public TextView subtituloTextView;
        public TextView tituloTextView;

        public a2dVPTG0kZc(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.iconoImageView = (ImageView) view.findViewById(R.id.icono);
            this.cantidadTextView = (TextView) view.findViewById(R.id.cantidad);
            this.tituloTextView = (TextView) view.findViewById(R.id.titulo);
            this.subtituloTextView = (TextView) view.findViewById(R.id.subtitulo);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mainHolder);
            this.placeHolder = relativeLayout;
            relativeLayout.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = n1lAq5KrpfE.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }

        public void btn_pagar_On_Click(View view) {
            OnItemClickListener onItemClickListener = n1lAq5KrpfE.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
