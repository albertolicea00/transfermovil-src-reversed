package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.JpFlOZXEDx;
import cu.etecsa.tm.ecommerce.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s7v6K7WoKk7 extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<JpFlOZXEDx> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, int i2);

        void onGetLongItemClick(View view, int i, int i2);

        void onPermisosItemClick(View view, int i, boolean z);
    }

    public s7v6K7WoKk7(Context context, List<JpFlOZXEDx> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.y59fn3c7kxcxqs, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.id = this.itemList.get(i).getIdUser();
        holder.posItem = i;
        holder.tituloTextView.setText(this.itemList.get(i).getNombre());
        holder.subtituloTextView.setText(this.itemList.get(i).getCorreo());
        holder.isActivo = this.itemList.get(i).isActivo();
        if (this.itemList.get(i).isActivo()) {
            CardView cardView = holder.cdEstado;
            Resources resources = this.context.getResources();
            int i2 = R.color.verde;
            cardView.setCardBackgroundColor(resources.getColor(i2));
            holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_done_white));
            if (Build.VERSION.SDK_INT >= 23) {
                holder.iconoImageView.setBorderColor(this.context.getColor(i2));
            } else {
                holder.iconoImageView.setBorderColor(this.context.getResources().getColor(i2));
            }
        } else {
            CardView cardView2 = holder.cdEstado;
            Resources resources2 = this.context.getResources();
            int i3 = R.color.rojo;
            cardView2.setCardBackgroundColor(resources2.getColor(i3));
            holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
            if (Build.VERSION.SDK_INT >= 23) {
                holder.iconoImageView.setBorderColor(this.context.getColor(i3));
            } else {
                holder.iconoImageView.setBorderColor(this.context.getResources().getColor(i3));
            }
        }
        Glide.with(this.context).load(this.itemList.get(i).getAvatar()).signature(new ObjectKey(this.itemList.get(i).getUpdateAt())).centerCrop().placeholder(R.drawable.ic_avatar).into(holder.iconoImageView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<JpFlOZXEDx> list = this.itemList;
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
        public CircleImageView iconoImageView;
        public int id;
        public ImageView imStatus;
        public boolean isActivo;
        public ImageView permisosImageView;
        public int posItem;
        public TextView subtituloTextView;
        public TextView tituloTextView;
        public TextView txEstadoText;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.iconoImageView = (CircleImageView) view.findViewById(R.id.imAvatar);
            this.tituloTextView = (TextView) view.findViewById(R.id.txTitulo);
            this.subtituloTextView = (TextView) view.findViewById(R.id.txSubtitulo);
            this.permisosImageView = (ImageView) view.findViewById(R.id.imPermisos);
            this.cdEstado = (CardView) view.findViewById(R.id.cdEstado);
            this.txEstadoText = (TextView) view.findViewById(R.id.txEstadoText);
            this.cv.setOnClickListener(this);
            this.cv.setOnLongClickListener(this);
            this.imStatus = (ImageView) view.findViewById(R.id.imStatus);
            this.permisosImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.CustomViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CustomViewHolder customViewHolder = CustomViewHolder.this;
                    s7v6K7WoKk7.this.mItemClickListener.onPermisosItemClick(customViewHolder.itemView, customViewHolder.id, customViewHolder.isActivo);
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = s7v6K7WoKk7.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.id);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            OnItemClickListener onItemClickListener = s7v6K7WoKk7.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetLongItemClick(this.itemView, this.posItem, this.id);
                return true;
            }
            return true;
        }
    }
}
