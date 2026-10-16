package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.loopeer.itemtouchhelperextension.Extension;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QV8ylwbhfB extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_ACTION_WIDTH = 1001;
    public static final int ITEM_TYPE_ACTION_WIDTH_NO_SPRING = 1002;
    public static final int ITEM_TYPE_RECYCLER_WIDTH = 1000;
    private List<M7OG7jG8CS> itemList;
    private Context mContext;
    private KYTjPlWScT modulosEstadisticosEntity;
    public View view;

    public QV8ylwbhfB(Context context, List<M7OG7jG8CS> itemList) {
        this.mContext = context;
        this.itemList = itemList;
    }

    public QV8ylwbhfB(Context context, List<M7OG7jG8CS> itemList, KYTjPlWScT modulosEstadisticosEntity) {
        this.mContext = context;
        this.itemList = itemList;
        this.modulosEstadisticosEntity = modulosEstadisticosEntity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.view = getLayoutInflater().inflate(R.layout.obush3awjtnkn, parent, false);
        if (viewType == 1001) {
            return new ItemSwipeWithActionWidthViewHolder(this.view);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ItemBaseViewHolder baseViewHolder = (ItemBaseViewHolder) holder;
        baseViewHolder.bind(this.itemList.get(position), position);
        if (holder instanceof ItemSwipeWithActionWidthViewHolder) {
            ItemSwipeWithActionWidthViewHolder viewHolder = (ItemSwipeWithActionWidthViewHolder) holder;
            viewHolder.mActionViewDelete.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QV8ylwbhfB.this.doDelete(holder.getAdapterPosition());
                }
            });
        }
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDelete(int adapterPosition) {
        try {
            M7OG7jG8CS itemOperacion = this.itemList.get(adapterPosition);
            unYp8VQThY.init(this.mContext);
            RecordSMS recordSMS = unYp8VQThY.getInstance().getRecordSMSwithIDTransaction(itemOperacion.getIdTransaccion()).get(0);
            recordSMS.setMostrar(false);
            if (unYp8VQThY.getInstance().updateRecordSMS(recordSMS) > 0) {
                try {
                    this.itemList.remove(adapterPosition);
                    notifyItemRemoved(adapterPosition);
                    Toast.makeText(this.mContext, "Elemento eliminado", 0).show();
                } catch (Exception e) {
                    Toast.makeText(this.mContext, "Error: Elemento no eliminado", 0).show();
                }
                return;
            }
            Toast.makeText(this.mContext, "Error: Elemento no eliminado ", 0).show();
        } catch (Exception e2) {
            Toast.makeText(this.mContext, "Error: Elemento no eliminado", 0).show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return ITEM_TYPE_ACTION_WIDTH;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    public class ItemBaseViewHolder extends RecyclerView.ViewHolder {
        public TextView cuentaTextView;
        public CardView cv;
        public TextView fechaTextView;
        public View mActionContainer;
        public View mViewContent;
        public TextView monedaTextView;
        public TextView montoTextView;
        public RelativeLayout placeHolder;
        public int position;
        public SearchView search;
        public TextView servicioTextView;
        public TextView transaccionaTextView;

        public ItemBaseViewHolder(View itemView) {
            super(itemView);
            this.cv = (CardView) itemView.findViewById(R.id.cv);
            this.montoTextView = (TextView) itemView.findViewById(R.id.txtmonto);
            this.fechaTextView = (TextView) itemView.findViewById(R.id.txtfecha);
            this.cuentaTextView = (TextView) itemView.findViewById(R.id.txtcuenta);
            this.transaccionaTextView = (TextView) itemView.findViewById(R.id.txttransaccion);
            this.servicioTextView = (TextView) itemView.findViewById(R.id.txtservicio);
            this.monedaTextView = (TextView) itemView.findViewById(R.id.txtmoneda);
            this.search = (SearchView) itemView.findViewById(R.id.searchView);
            this.placeHolder = (RelativeLayout) itemView.findViewById(R.id.mainHolder);
            this.mViewContent = itemView.findViewById(R.id.mainHolder);
            this.mActionContainer = itemView.findViewById(R.id.view_list_repo_action_container);
            this.mViewContent.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB.ItemBaseViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }

        public void bind(M7OG7jG8CS bModel, int pos) {
            this.position = pos;
            this.transaccionaTextView.setText("ID: " + bModel.getIdTransaccion());
            this.cuentaTextView.setText(bModel.getCuenta());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            String date = dateFormat.format(bModel.getFecha());
            this.fechaTextView.setText(date);
            this.montoTextView.setText("$" + bModel.getMonto().toString());
            this.servicioTextView.setText(bModel.getServicio());
            this.monedaTextView.setText(bModel.getMoneda());
        }
    }

    public class ItemSwipeWithActionWidthViewHolder extends ItemBaseViewHolder implements Extension {
        public View mActionViewDelete;

        public ItemSwipeWithActionWidthViewHolder(View itemView) {
            super(itemView);
            View viewFindViewById = itemView.findViewById(R.id.view_list_repo_action_delete);
            this.mActionViewDelete = viewFindViewById;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB.ItemSwipeWithActionWidthViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemSwipeWithActionWidthViewHolder itemSwipeWithActionWidthViewHolder = ItemSwipeWithActionWidthViewHolder.this;
                    QV8ylwbhfB.this.doDelete(itemSwipeWithActionWidthViewHolder.position);
                }
            });
        }

        @Override // com.loopeer.itemtouchhelperextension.Extension
        public float getActionWidth() {
            return this.mActionContainer.getWidth();
        }
    }
}
