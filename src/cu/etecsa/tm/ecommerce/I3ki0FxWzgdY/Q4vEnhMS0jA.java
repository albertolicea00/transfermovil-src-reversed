package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Q4vEnhMS0jA extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<nzfmd7tb20> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, nzfmd7tb20 nzfmd7tb20Var);

        void onGetItemClick(View view, int i, String str);
    }

    public Q4vEnhMS0jA(Context context, List<nzfmd7tb20> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (UhA7J2923N.getInstance().getCompactMode() != null && UhA7J2923N.getInstance().getCompactMode().contains("ON")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f2odi1po8vurkt, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.s3cc6tzywlsknx, viewGroup, false);
        }
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.txID.setText(this.itemList.get(i).getIdDevolucion());
        holder.itemDevolucion = this.itemList.get(i);
        DecimalFormat df = new DecimalFormat("0.00##");
        String result = df.format(this.itemList.get(i).getImporte());
        holder.txImporte.setText(result);
        holder.txMoneda.setText(this.itemList.get(i).getMoneda());
        holder.txFecha.setText(this.itemList.get(i).getFecha());
        holder.txPagoOriginal.setText(this.itemList.get(i).getIdPago());
        holder.txUser.setText(this.itemList.get(i).getUser());
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[this.itemList.get(i).getEstadoPago().ordinal()]) {
            case 1:
                CardView cardView = holder.cdEstado;
                Resources resources = this.context.getResources();
                int i2 = R.color.verde;
                cardView.setCardBackgroundColor(resources.getColor(i2));
                holder.txEstadoText.setText(this.context.getString(R.string.status_pagado));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i2));
                holder.txID.setTextColor(this.context.getResources().getColor(i2));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_done_white));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.verde2));
                break;
            case 2:
                CardView cardView2 = holder.cdEstado;
                Resources resources2 = this.context.getResources();
                int i3 = R.color.naranja;
                cardView2.setCardBackgroundColor(resources2.getColor(i3));
                holder.txEstadoText.setText(this.context.getString(R.string.status_pendiente));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_pause));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i3));
                holder.txID.setTextColor(this.context.getResources().getColor(i3));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.naranja2));
                break;
            case 3:
                CardView cardView3 = holder.cdEstado;
                Resources resources3 = this.context.getResources();
                int i4 = R.color.naranja;
                cardView3.setCardBackgroundColor(resources3.getColor(i4));
                holder.txEstadoText.setText(this.context.getString(R.string.status_pendiente));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_pause));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i4));
                holder.txID.setTextColor(this.context.getResources().getColor(i4));
                break;
            case 4:
                CardView cardView4 = holder.cdEstado;
                Resources resources4 = this.context.getResources();
                int i5 = R.color.rojo;
                cardView4.setCardBackgroundColor(resources4.getColor(i5));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_abort));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i5));
                holder.txEstadoText.setText(this.context.getString(R.string.status_fallido));
                holder.txID.setTextColor(this.context.getResources().getColor(i5));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.rojo2));
                break;
            case 5:
                CardView cardView5 = holder.cdEstado;
                Resources resources5 = this.context.getResources();
                int i6 = R.color.rojo;
                cardView5.setCardBackgroundColor(resources5.getColor(i6));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i6));
                holder.txEstadoText.setText(this.context.getString(R.string.status_cancelado));
                holder.txID.setTextColor(this.context.getResources().getColor(i6));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.rojo2));
                break;
            case 6:
                CardView cardView6 = holder.cdEstado;
                Resources resources6 = this.context.getResources();
                int i7 = R.color.verde_oscuro;
                cardView6.setCardBackgroundColor(resources6.getColor(i7));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_devolucion));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i7));
                holder.txEstadoText.setText(this.context.getString(R.string.status_devolucion));
                holder.txID.setTextColor(this.context.getResources().getColor(i7));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.verde_oscuro2));
                break;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.Q4vEnhMS0jA$1, reason: invalid class name */
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
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.DEVUELTO_PENDIENTE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.FALLIDO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.CANCELADO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.DEVUELTO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<nzfmd7tb20> list = this.itemList;
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
        public ImageView imStatus;
        public nzfmd7tb20 itemDevolucion;
        public int posItem;
        public TextView txEstadoText;
        public TextView txFecha;
        public TextView txID;
        public TextView txImporte;
        public TextView txMoneda;
        public TextView txPagoOriginal;
        public TextView txUser;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txID = (TextView) view.findViewById(R.id.txID);
            this.txImporte = (TextView) view.findViewById(R.id.txImporte);
            this.txMoneda = (TextView) view.findViewById(R.id.txMoneda);
            this.txEstadoText = (TextView) view.findViewById(R.id.txEstadoText);
            this.txFecha = (TextView) view.findViewById(R.id.txFecha);
            this.cdEstado = (CardView) view.findViewById(R.id.cdEstado);
            this.txPagoOriginal = (TextView) view.findViewById(R.id.txPagoOriginal);
            this.imStatus = (ImageView) view.findViewById(R.id.imStatus);
            this.txUser = (TextView) view.findViewById(R.id.txUser);
            this.cv.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = Q4vEnhMS0jA.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.txID.getText().toString());
                Q4vEnhMS0jA.this.mItemClickListener.onGetItemClick(this.itemView, this.posItem, this.itemDevolucion);
            }
        }
    }
}
