package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.D1rOcltDGsD;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class aKh5ZFPmqR extends RecyclerView.Adapter<a2dVPTG0kZc> {
    public FragmentActivity activity;
    private Context context;
    private List<qcI22KekhL> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public aKh5ZFPmqR(Context contexts, List<qcI22KekhL> itemList, FragmentActivity activity) {
        this.context = contexts;
        this.itemList = itemList;
        this.activity = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ub9jrbamrdukq, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.cantidadTextView.setText("Operaciones: " + this.itemList.get(i).getCantidad());
        customViewHolder.montoTextView.setText("$" + this.itemList.get(i).getMonto().toString());
        customViewHolder.servicioTextView.setText(this.itemList.get(i).getServicio());
        customViewHolder.monedaTextView.setText(this.itemList.get(i).getMoneda());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<qcI22KekhL> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cantidadTextView;
        public CardView cv;
        public TextView monedaTextView;
        public TextView montoTextView;
        public RelativeLayout placeHolder;
        public TextView servicioTextView;

        public a2dVPTG0kZc(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.montoTextView = (TextView) view.findViewById(R.id.txtmonto);
            this.cantidadTextView = (TextView) view.findViewById(R.id.txtcantidad);
            this.servicioTextView = (TextView) view.findViewById(R.id.txttransaccion);
            this.monedaTextView = (TextView) view.findViewById(R.id.txtmoneda);
            this.montoTextView.setOnClickListener(this);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mainHolder);
            this.placeHolder = relativeLayout;
            relativeLayout.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == this.montoTextView.getId()) {
                qcI22KekhL uyh0pxs9m37in = (qcI22KekhL) aKh5ZFPmqR.this.itemList.get(getPosition());
                FragmentManager mFragmentManager = aKh5ZFPmqR.this.activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                D1rOcltDGsD detalle = new D1rOcltDGsD();
                Bundle b = new Bundle();
                b.putString("moneda", String.valueOf(uyh0pxs9m37in.getMoneda()));
                b.putString("servicio", String.valueOf(uyh0pxs9m37in.getServicio()));
                detalle.setArguments(b);
                mFragmentTransaction.replace(R.id.containerView, detalle).addToBackStack(null).commit();
            }
            OnItemClickListener onItemClickListener = aKh5ZFPmqR.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
