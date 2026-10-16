package cu.etecsa.tm.ecommerce.I3ki0FxWzgdY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.v7emp5gRyD;
import cu.etecsa.tm.ecommerce.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jTnoQAoHrX extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<v7emp5gRyD> itemList;
    public OnItemClickListener mItemClickListener;
    public o8aJAm1V8Pa.OnItemClickListener mItemCuentaListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, int i, int i2, String str);

        void onGetLongItemClick(View view, int i, int i2);
    }

    public jTnoQAoHrX(Context context, List<v7emp5gRyD> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public jTnoQAoHrX(Context context, List<v7emp5gRyD> itemList, o8aJAm1V8Pa.OnItemClickListener cuentaListener) {
        this.context = context;
        this.itemList = itemList;
        this.mItemCuentaListener = cuentaListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gcv7oc1bo6cxc, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        holder.posItem = i;
        holder.txNegocio.setText(this.itemList.get(i).getTitulo());
        holder.idNegocio = Integer.valueOf(this.itemList.get(i).getId()).intValue();
        List<HD5RIUn7tB> cuentaNegocios = this.itemList.get(i).getCuentasList();
        if (cuentaNegocios.size() == 0) {
            holder.titleCuentas.setText("NO HAY CUENTAS ASOCIADAS");
            holder.imExpand.setVisibility(8);
            holder.hasCuentas = false;
            return;
        }
        holder.hasCuentas = true;
        holder.rcCuentas.setItemAnimator(new DefaultItemAnimator());
        holder.rcCuentas.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        holder.rcCuentas.setLayoutManager(lLyManager);
        holder.rcCuentas.setNestedScrollingEnabled(false);
        o8aJAm1V8Pa listCuentasAdapter = new o8aJAm1V8Pa(this.context, cuentaNegocios);
        holder.rcCuentas.setAdapter(listCuentasAdapter);
        listCuentasAdapter.setOnItemClickListener(this.mItemCuentaListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<v7emp5gRyD> list = this.itemList;
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
        public CardView btAgregarCuenta;
        public CardView cdNegocio;
        public CardView cdVerCuentas;
        public CardView cv;
        public boolean hasCuentas;
        public int idNegocio;
        public ImageView imExpand;
        public int posItem;
        public RecyclerView rcCuentas;
        public TextView titleCuentas;
        public TextView txNegocio;

        public CustomViewHolder(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txNegocio = (TextView) view.findViewById(R.id.txNegocio);
            this.titleCuentas = (TextView) view.findViewById(R.id.titleCuentas);
            this.btAgregarCuenta = (CardView) view.findViewById(R.id.cdAgregarCuenta);
            int i = R.id.rcCuentas;
            this.rcCuentas = (RecyclerView) view.findViewById(i);
            this.btAgregarCuenta.setOnClickListener(this);
            this.rcCuentas = (RecyclerView) view.findViewById(i);
            this.cdVerCuentas = (CardView) view.findViewById(R.id.cdVerCuentas);
            this.imExpand = (ImageView) view.findViewById(R.id.imExpand);
            CardView cardView = (CardView) view.findViewById(R.id.cdNegocio);
            this.cdNegocio = cardView;
            cardView.setOnLongClickListener(this);
            this.cdVerCuentas.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.jTnoQAoHrX.CustomViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CustomViewHolder customViewHolder = CustomViewHolder.this;
                    if (customViewHolder.hasCuentas) {
                        if (customViewHolder.rcCuentas.getVisibility() == 0) {
                            CustomViewHolder.this.rcCuentas.setVisibility(8);
                            CustomViewHolder customViewHolder2 = CustomViewHolder.this;
                            customViewHolder2.imExpand.setImageDrawable(jTnoQAoHrX.this.context.getResources().getDrawable(R.drawable.ic_expand));
                            CustomViewHolder.this.titleCuentas.setText("VER CUENTAS ASOCIADAS");
                            return;
                        }
                        CustomViewHolder.this.rcCuentas.setVisibility(0);
                        CustomViewHolder.this.titleCuentas.setText("CUENTAS ASOCIADAS");
                        CustomViewHolder customViewHolder3 = CustomViewHolder.this;
                        customViewHolder3.imExpand.setImageDrawable(jTnoQAoHrX.this.context.getResources().getDrawable(R.drawable.ic_collapse));
                    }
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = jTnoQAoHrX.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.posItem, this.idNegocio, this.txNegocio.getText().toString());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            OnItemClickListener onItemClickListener = jTnoQAoHrX.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetLongItemClick(this.itemView, this.posItem, this.idNegocio);
                return false;
            }
            return false;
        }
    }
}
