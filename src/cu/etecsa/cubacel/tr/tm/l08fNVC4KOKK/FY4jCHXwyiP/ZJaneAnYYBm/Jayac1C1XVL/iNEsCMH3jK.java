package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class iNEsCMH3jK extends RecyclerView.Adapter<a2dVPTG0kZc> {
    private boolean areSwitchesEnabled = false;
    private Context context;
    private List<QfruhfaN5Z> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onGetItemClick(View view, QfruhfaN5Z qfruhfaN5Z);
    }

    public iNEsCMH3jK(Context contexts, List<QfruhfaN5Z> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.byap3x5fpdn6c, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.txParteUssd.setText(this.itemList.get(i).getTitulo());
        customViewHolder.swEnviarUssd.setChecked(this.itemList.get(i).enviado);
        if (this.itemList.get(i).enviado) {
            customViewHolder.swEnviarUssd.setEnabled(false);
        } else {
            customViewHolder.swEnviarUssd.setEnabled(true);
        }
        customViewHolder.uyh0pxs9m37in = this.itemList.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public int encontrarPosicionPorId(int noPqte) {
        for (int i = 0; i < this.itemList.size(); i++) {
            if (this.itemList.get(i).getNoPaquete() == noPqte) {
                return i;
            }
        }
        return -1;
    }

    public void modificarItem(int posicion, QfruhfaN5Z nuevoItem) {
        if (posicion >= 0 && posicion < this.itemList.size()) {
            this.itemList.set(posicion, nuevoItem);
            notifyItemChanged(posicion);
        }
    }

    public void cambiarEstadoSwitch(int posicion, boolean status) {
        if (status) {
            if (posicion >= 0 && posicion < this.itemList.size()) {
                this.itemList.get(posicion).enviado = status;
                notifyItemChanged(posicion);
                return;
            }
            return;
        }
        Toast.makeText(this.context, "Paquete enviado, no posible volver a enviar", 0).show();
    }

    public void enableSwitches() {
        this.areSwitchesEnabled = true;
        notifyDataSetChanged();
    }

    public void disableSwitches() {
        this.areSwitchesEnabled = false;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<QfruhfaN5Z> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv;
        public Switch swEnviarUssd;
        public TextView txParteUssd;
        public QfruhfaN5Z uyh0pxs9m37in;

        public a2dVPTG0kZc(View view) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.txParteUssd = (TextView) view.findViewById(R.id.txParteUssd);
            Switch r0 = (Switch) view.findViewById(R.id.swEnviarUssd);
            this.swEnviarUssd = r0;
            r0.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            OnItemClickListener onItemClickListener = iNEsCMH3jK.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onGetItemClick(this.itemView, this.uyh0pxs9m37in);
                this.swEnviarUssd.setEnabled(false);
                this.uyh0pxs9m37in.enviado = true;
                iNEsCMH3jK.this.notifyItemChanged(getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
