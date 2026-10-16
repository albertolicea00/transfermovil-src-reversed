package cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gNS2UxRuVW extends ListAdapter<WUULVgZq02, RecyclerView.ViewHolder> implements ouX1muv8Hd.StickyHeaderInterface {
    public static final DiffUtil.ItemCallback<WUULVgZq02> ModelDiffUtilCallback = new DiffUtil.ItemCallback<WUULVgZq02>() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.gNS2UxRuVW.1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(WUULVgZq02 model, WUULVgZq02 t1) {
            return model.getTitulo().equals(t1.getTitulo());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(WUULVgZq02 model, WUULVgZq02 t1) {
            return model.equals(t1);
        }
    };
    private Context context;
    private List<WUULVgZq02> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, FdonIAFI9w fdonIAFI9w);
    }

    public gNS2UxRuVW() {
        super(ModelDiffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == rBXnNc0Kx4.Header.intValue()) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.k5yq4nqbiqz4c, viewGroup, false);
            return new HeaderViewHolder(itemView);
        }
        View itemView2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dpiivfe2yk6mn, viewGroup, false);
        return new PostViewHolder(itemView2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == rBXnNc0Kx4.Header.intValue()) {
            ((HeaderViewHolder) viewHolder).bind(getItem(i));
        } else {
            ((PostViewHolder) viewHolder).bind(getItem(i));
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title_header);
        }

        public void bind(WUULVgZq02 model) {
            this.title.setText(model.getTitulo());
        }
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv;
        public ImageView favImageView;
        public ImageView iconoImageView;
        public FdonIAFI9w operacion;
        public RelativeLayout placeHolder;
        public TextView subtituloTextView;
        public TextView tituloTextView;

        public PostViewHolder(View view) {
            super(view);
            view.setClickable(true);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.iconoImageView = (ImageView) view.findViewById(R.id.icono);
            this.favImageView = (ImageView) view.findViewById(R.id.fav);
            this.tituloTextView = (TextView) view.findViewById(R.id.titulo);
            this.subtituloTextView = (TextView) view.findViewById(R.id.subtitulo);
            this.placeHolder = (RelativeLayout) view.findViewById(R.id.mainHolder);
            view.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.gNS2UxRuVW.PostViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PostViewHolder postViewHolder = PostViewHolder.this;
                    OnItemClickListener onItemClickListener = gNS2UxRuVW.this.mItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onGetItemClick(postViewHolder.itemView, postViewHolder.operacion);
                    }
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = gNS2UxRuVW.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.operacion);
            }
        }

        public void bind(WUULVgZq02 model) {
            this.tituloTextView.setText(model.getTitulo());
            this.subtituloTextView.setText(model.getSubtitulo());
            this.iconoImageView.setImageResource(model.getIcono());
            this.operacion = model.getOperacion();
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType().intValue();
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd.StickyHeaderInterface
    public Integer getHeaderPositionForItem(Integer itemPosition) {
        for (Integer i = itemPosition; i.intValue() > 0; i = Integer.valueOf(i.intValue() - 1)) {
            if (isHeader(i).booleanValue()) {
                Integer headerPosition = i;
                return headerPosition;
            }
        }
        return 0;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd.StickyHeaderInterface
    public Integer getHeaderLayout(Integer headerPosition) {
        return Integer.valueOf(R.layout.k5yq4nqbiqz4c);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd.StickyHeaderInterface
    public void bindHeaderData(View header, Integer headerPosition) {
        TextView tv = (TextView) header.findViewById(R.id.title_header);
        tv.setText(getItem(headerPosition.intValue()).getTitulo());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd.StickyHeaderInterface
    public Boolean isHeader(Integer itemPosition) {
        return Boolean.valueOf(getItem(itemPosition.intValue()).getType().equals(rBXnNc0Kx4.Header));
    }
}
