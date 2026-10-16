package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.R;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KpXoKSVQGs extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<s5BkGOZ35ku> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, String str);
    }

    public KpXoKSVQGs(Context context, List<s5BkGOZ35ku> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.q3w9fergcgz4d7, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.txID.setText(this.itemList.get(i).getIdPago());
        DecimalFormat df = new DecimalFormat("0.00##");
        String result = df.format(this.itemList.get(i).getImporte());
        holder.txImporte.setText(result);
        holder.txMoneda.setText(this.itemList.get(i).getMoneda());
        holder.txFecha.setText(this.itemList.get(i).getFecha());
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[this.itemList.get(i).getEstadoPago().ordinal()]) {
            case 1:
                holder.cdEstado.setBackgroundColor(this.context.getResources().getColor(R.color.verde));
                holder.txEstadoText.setText(this.context.getString(R.string.status_pagado));
                break;
            case 2:
                holder.cdEstado.setBackgroundColor(this.context.getResources().getColor(R.color.naranja));
                holder.txEstadoText.setText(this.context.getString(R.string.status_pendiente));
                break;
            case 3:
                holder.cdEstado.setBackgroundColor(this.context.getResources().getColor(R.color.rojo));
                holder.txEstadoText.setText(this.context.getString(R.string.status_cancelado));
                break;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.KpXoKSVQGs$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco;

        static {
            int[] iArr = new int[SHYgXB9Dco.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco = iArr;
            try {
                iArr[SHYgXB9Dco.PAGADO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.PENDIENTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.CANCELADO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<s5BkGOZ35ku> list = this.itemList;
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

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cdEstado;
        public CardView cv;
        public int posItem;
        public TextView txEstadoText;
        public TextView txFecha;
        public TextView txID;
        public TextView txImporte;
        public TextView txMoneda;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txID = (TextView) view.findViewById(R.id.txID);
            this.txImporte = (TextView) view.findViewById(R.id.txImporte);
            this.txMoneda = (TextView) view.findViewById(R.id.txMoneda);
            this.txEstadoText = (TextView) view.findViewById(R.id.txEstadoText);
            this.txFecha = (TextView) view.findViewById(R.id.txFecha);
            this.cdEstado = (CardView) view.findViewById(R.id.cdEstado);
            this.cv.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = KpXoKSVQGs.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.txID.getText().toString());
            }
        }
    }
}
