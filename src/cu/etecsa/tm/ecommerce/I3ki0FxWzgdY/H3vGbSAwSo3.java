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
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class H3vGbSAwSo3 extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<s5BkGOZ35ku> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, s5BkGOZ35ku s5bkgoz35ku);

        void onGetItemClick(View view, int i, String str);
    }

    public H3vGbSAwSo3(Context context, List<s5BkGOZ35ku> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (UhA7J2923N.getInstance().getCompactMode() != null && UhA7J2923N.getInstance().getCompactMode().contains("ON")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b82arkalghssd, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cjsq2wwodlo27, viewGroup, false);
        }
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.itemPago = this.itemList.get(i);
        holder.txID.setText(this.itemList.get(i).getIdPago());
        DecimalFormat df = new DecimalFormat("0.00##");
        String result = df.format(this.itemList.get(i).getImporte());
        holder.txImporte.setText(result);
        holder.txMoneda.setText(this.itemList.get(i).getMoneda());
        holder.txFecha.setText(this.itemList.get(i).getFecha());
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
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.verde2));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_done_white));
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
                int i4 = R.color.rojo;
                cardView3.setCardBackgroundColor(resources3.getColor(i4));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_abort));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i4));
                holder.txEstadoText.setText(this.context.getString(R.string.status_fallido));
                holder.txID.setTextColor(this.context.getResources().getColor(i4));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.rojo2));
                break;
            case 4:
                CardView cardView4 = holder.cdEstado;
                Resources resources4 = this.context.getResources();
                int i5 = R.color.rojo;
                cardView4.setCardBackgroundColor(resources4.getColor(i5));
                holder.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
                holder.txEstadoText.setTextColor(this.context.getResources().getColor(i5));
                holder.txEstadoText.setText(this.context.getString(R.string.status_cancelado));
                holder.txID.setTextColor(this.context.getResources().getColor(i5));
                holder.txUser.setTextColor(this.context.getResources().getColor(R.color.rojo2));
                break;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.H3vGbSAwSo3$1, reason: invalid class name */
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
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.FALLIDO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.CANCELADO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
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
        public ImageView imStatus;
        public s5BkGOZ35ku itemPago;
        public int posItem;
        public TextView txEstadoText;
        public TextView txFecha;
        public TextView txID;
        public TextView txImporte;
        public TextView txMoneda;
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
            this.txUser = (TextView) view.findViewById(R.id.txUser);
            this.imStatus = (ImageView) view.findViewById(R.id.imStatus);
            this.cv.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = H3vGbSAwSo3.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.txID.getText().toString());
                H3vGbSAwSo3.this.mItemClickListener.onGetItemClick(this.itemView, this.posItem, this.itemPago);
            }
        }
    }
}
