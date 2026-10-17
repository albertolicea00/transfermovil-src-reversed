package cu.etecsa.transfermovil.stats;

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

/**
 * RecyclerView adapter for statistics category items with icon and count.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.n1lAq5KrpfE
 * @fingerprint Adapter displaying category items with title, subtitle, icon, and count text with click delegation
 */
public class StatsCategoryAdapter extends RecyclerView.Adapter<OperationItemViewHolder> {
    private Context context;
    private List<StatsCategoryItem> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public StatsCategoryAdapter(Context contexts, List<StatsCategoryItem> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override
    public OperationItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.j090c4o52czjo2, viewGroup, false);
        OperationItemViewHolder viewHolder = new OperationItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OperationItemViewHolder customViewHolder, int i) {
        customViewHolder.tituloTextView.setText(this.itemList.get(i).getTitulo());
        customViewHolder.subtituloTextView.setText(this.itemList.get(i).getSubtitulo());
        customViewHolder.iconoImageView.setImageResource(this.itemList.get(i).getIcono());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        List<StatsCategoryItem> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cantidadTextView;
        public CardView cv;
        public ImageView iconoImageView;
        public RelativeLayout placeHolder;
        public TextView subtituloTextView;
        public TextView tituloTextView;

        public InnerViewHolder(View view) {
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

        @Override
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = StatsCategoryAdapter.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }

        public void btn_pagar_On_Click(View view) {
            OnItemClickListener onItemClickListener = StatsCategoryAdapter.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
