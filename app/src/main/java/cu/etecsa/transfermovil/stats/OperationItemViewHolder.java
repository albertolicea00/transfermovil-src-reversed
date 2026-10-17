package cu.etecsa.transfermovil.stats;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;

/**
 * Standalone ViewHolder for operation list items with title, subtitle, icon, and favorite.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.a2dVPTG0kZc
 * @fingerprint RecyclerView.ViewHolder binding card, icon, favorite, title, and subtitle views with click delegation
 */
public class OperationItemViewHolder extends RecyclerView.ViewHolder {
    public CardView cv;
    public ImageView favImageView;
    public ImageView iconoImageView;
    public TextView subtituloTextView;
    public TextView tituloTextView;

    public OperationItemViewHolder(View view, final OperationListAdapter.OnItemClickListener listener) {
        super(view);
        view.setClickable(true);
        this.cv = (CardView) view.findViewById(R.id.cv);
        this.iconoImageView = (ImageView) view.findViewById(R.id.icono);
        this.favImageView = (ImageView) view.findViewById(R.id.fav);
        this.tituloTextView = (TextView) view.findViewById(R.id.titulo);
        this.subtituloTextView = (TextView) view.findViewById(R.id.subtitulo);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationListAdapter.OnItemClickListener onItemClickListener = listener;
                if (onItemClickListener != null) {
                    OperationItemViewHolder holder = OperationItemViewHolder.this;
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            }
        });
    }
}
