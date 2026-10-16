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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vD9rc3MbTL extends RecyclerView.Adapter<a2dVPTG0kZc> {
    private Context context;
    private List<WUULVgZq02> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, FdonIAFI9w fdonIAFI9w);

        void onItemClick(View view, int i);
    }

    public vD9rc3MbTL(Context contexts, List<WUULVgZq02> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dpiivfe2yk6mn, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.tituloTextView.setText(this.itemList.get(i).getTitulo());
        customViewHolder.subtituloTextView.setText(this.itemList.get(i).getSubtitulo());
        customViewHolder.iconoImageView.setImageResource(this.itemList.get(i).getIcono());
        customViewHolder.operacion = this.itemList.get(i).getOperacion();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WUULVgZq02> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv;
        public ImageView favImageView;
        public ImageView iconoImageView;
        private FdonIAFI9w operacion;
        public RelativeLayout placeHolder;
        public TextView subtituloTextView;
        public TextView tituloTextView;

        public a2dVPTG0kZc(View view) {
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
            view.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.a2dVPTG0kZc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    OnItemClickListener onItemClickListener = vD9rc3MbTL.this.mItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onGetItemClick(a2dvptg0kzc.itemView, a2dvptg0kzc.operacion);
                    }
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = vD9rc3MbTL.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
                vD9rc3MbTL.this.mItemClickListener.onGetItemClick(this.itemView, this.operacion);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
