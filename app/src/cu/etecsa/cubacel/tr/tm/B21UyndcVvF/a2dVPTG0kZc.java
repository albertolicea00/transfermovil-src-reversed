package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class a2dVPTG0kZc extends RecyclerView.ViewHolder {
    public CardView cv;
    public ImageView favImageView;
    public ImageView iconoImageView;
    public TextView subtituloTextView;
    public TextView tituloTextView;

    public a2dVPTG0kZc(View view, final lkLP9buUCl.OnItemClickListener listener) {
        super(view);
        view.setClickable(true);
        this.cv = (CardView) view.findViewById(R.id.cv);
        this.iconoImageView = (ImageView) view.findViewById(R.id.icono);
        this.favImageView = (ImageView) view.findViewById(R.id.fav);
        this.tituloTextView = (TextView) view.findViewById(R.id.titulo);
        this.subtituloTextView = (TextView) view.findViewById(R.id.subtitulo);
        view.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.a2dVPTG0kZc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                lkLP9buUCl.OnItemClickListener onItemClickListener = listener;
                if (onItemClickListener != null) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    onItemClickListener.onItemClick(a2dvptg0kzc.itemView, a2dvptg0kzc.getLayoutPosition());
                }
            }
        });
    }
}
