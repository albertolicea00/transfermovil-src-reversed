package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xy8ZrFR33a extends RecyclerView.Adapter<a2dVPTG0kZc> {
    private Context context;
    private List<M7OG7jG8CS> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public xy8ZrFR33a(Context contexts, List<M7OG7jG8CS> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dcezgpua1mdqx, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.transaccionaTextView.setText("ID: " + this.itemList.get(i).getIdTransaccion());
        customViewHolder.cuentaTextView.setText(this.itemList.get(i).getCuenta());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        String date = dateFormat.format(this.itemList.get(i).getFecha());
        customViewHolder.fechaTextView.setText(date);
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
        List<M7OG7jG8CS> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cuentaTextView;
        public CardView cv;
        public TextView fechaTextView;
        public TextView monedaTextView;
        public TextView montoTextView;
        public RelativeLayout placeHolder;
        public SearchView search;
        public TextView servicioTextView;
        public TextView transaccionaTextView;

        public a2dVPTG0kZc(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.montoTextView = (TextView) view.findViewById(R.id.txtmonto);
            this.fechaTextView = (TextView) view.findViewById(R.id.txtfecha);
            this.cuentaTextView = (TextView) view.findViewById(R.id.txtcuenta);
            this.transaccionaTextView = (TextView) view.findViewById(R.id.txttransaccion);
            this.servicioTextView = (TextView) view.findViewById(R.id.txtservicio);
            this.monedaTextView = (TextView) view.findViewById(R.id.txtmoneda);
            this.search = (SearchView) view.findViewById(R.id.searchView);
            this.placeHolder = (RelativeLayout) view.findViewById(R.id.mainHolder);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = xy8ZrFR33a.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
