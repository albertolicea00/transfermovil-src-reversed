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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import java.util.List;

/**
 * RecyclerView adapter for operation items that passes the operation enum on click.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL
 * @fingerprint Adapter displaying operation items with title/subtitle/icon and dispatching both position and operation-typed click events
 */
public class OperationActionAdapter extends RecyclerView.Adapter<OperationItemViewHolder> {
    private Context context;
    private List<OperationListItem> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, FdonIAFI9w fdonIAFI9w);

        void onItemClick(View view, int i);
    }

    public OperationActionAdapter(Context contexts, List<OperationListItem> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override
    public OperationItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dpiivfe2yk6mn, viewGroup, false);
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
        List<OperationListItem> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv;
        public ImageView favImageView;
        public ImageView iconoImageView;
        private FdonIAFI9w operacion;
        public RelativeLayout placeHolder;
        public TextView subtituloTextView;
        public TextView tituloTextView;

        public InnerViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.iconoImageView = (ImageView) view.findViewById(R.id.icono);
            this.favImageView = (ImageView) view.findViewById(R.id.fav);
            this.tituloTextView = (TextView) view.findViewById(R.id.titulo);
            this.subtituloTextView = (TextView) view.findViewById(R.id.subtitulo);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mainHolder);
            this.placeHolder = relativeLayout;
            relativeLayout.setOnClickListener(this);
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    InnerViewHolder holder = InnerViewHolder.this;
                    OnItemClickListener onItemClickListener = OperationActionAdapter.this.mItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onGetItemClick(holder.itemView, holder.operacion);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = OperationActionAdapter.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
                OperationActionAdapter.this.mItemClickListener.onGetItemClick(this.itemView, this.operacion);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
