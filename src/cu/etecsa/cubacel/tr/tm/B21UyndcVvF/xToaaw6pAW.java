package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xToaaw6pAW extends ypYiy6EkAW<ViewHolder> {
    private static final int ITEM_COUNT = 50;
    private static final String TAG = QJoZrWCCWp.class.getSimpleName();
    private static final int TYPE_ACTIVE = 1;
    private static final int TYPE_INACTIVE = 0;
    public FragmentActivity activity;
    private ViewHolder.ClickListener clickListener;
    public Context context;
    private List<yHdVJARBHM> items;
    public int operation;

    public xToaaw6pAW(ViewHolder.ClickListener clickListener, List<yHdVJARBHM> list) {
        this.operation = 0;
        this.clickListener = clickListener;
        this.items = list;
    }

    public xToaaw6pAW(ViewHolder.ClickListener clickListener, List<yHdVJARBHM> list, FragmentActivity activity, int operation) {
        this.operation = 0;
        this.clickListener = clickListener;
        this.items = list;
        this.activity = activity;
        this.operation = operation;
    }

    public xToaaw6pAW(ViewHolder.ClickListener clickListener, List<yHdVJARBHM> list, FragmentActivity activity, int operation, Context context) {
        this.operation = 0;
        this.clickListener = clickListener;
        this.items = list;
        this.activity = activity;
        this.operation = operation;
        this.context = context;
    }

    public void removeItem(int position) {
        this.items.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItems(List<Integer> positions) {
        Collections.sort(positions, new Comparator<Integer>() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW.1
            @Override // java.util.Comparator
            public int compare(Integer lhs, Integer rhs) {
                return rhs.intValue() - lhs.intValue();
            }
        });
        while (!positions.isEmpty()) {
            if (positions.size() == 1) {
                removeItem(positions.get(0).intValue());
                positions.remove(0);
            } else {
                int count = 1;
                while (positions.size() > count && positions.get(count).equals(Integer.valueOf(positions.get(count - 1).intValue() - 1))) {
                    count++;
                }
                if (count == 1) {
                    removeItem(positions.get(0).intValue());
                } else {
                    removeRange(positions.get(count - 1).intValue(), count);
                }
                for (int i = 0; i < count; i++) {
                    positions.remove(0);
                }
            }
        }
    }

    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            this.items.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.uyh0pxs9m37in, parent, false);
        return new ViewHolder(v, this.clickListener, this.activity, this.operation, this.items, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        yHdVJARBHM uyh0pxs9m37in = this.items.get(position);
        String cuenta = uyh0pxs9m37in.getTitulo();
        holder.title.setText(cuenta);
        TextView textView = holder.subtitle;
        StringBuilder sb = new StringBuilder();
        sb.append(uyh0pxs9m37in.getSubtitulo());
        sb.append(uyh0pxs9m37in.isMarcado() ? "eliminar" : BuildConfig.FLAVOR);
        textView.setText(sb.toString());
        holder.btn_pagar.setImageResource(R.drawable.pay);
        holder.btn_check.setImageResource(R.drawable.check);
        if (uyh0pxs9m37in.getSubtitulo().length() == 0) {
            holder.title.setTextColor(-65536);
        }
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(uyh0pxs9m37in.isMarcado());
            holder.itemView.setLayoutParams(sglp);
        }
        holder.cheked.setVisibility(isSelected(position) ? 0 : 4);
        holder.cheked.setChecked(isSelected(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.items.get(i).isMarcado() ? 1 : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private static final String TAG = ViewHolder.class.getSimpleName();
        public FragmentActivity activity;
        public ImageView btn_check;
        public ImageView btn_pagar;
        public CheckBox cheked;
        public Context context;
        public List<yHdVJARBHM> itemList;
        private ClickListener listener;
        public int operation;
        public TextView subtitle;
        public TextView title;

        public interface ClickListener {
            void onItemClicked(int i);

            boolean onItemLongClicked(int i);
        }

        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            this.operation = 0;
            this.title = (TextView) itemView.findViewById(R.id.titulo);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cheked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            this.btn_pagar = (ImageView) itemView.findViewById(R.id.btn_pagar);
            this.btn_check = (ImageView) itemView.findViewById(R.id.btn_check);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public ViewHolder(View itemView, ClickListener listener, FragmentActivity activity, int operation, List<yHdVJARBHM> itemList, Context context) {
            super(itemView);
            this.operation = 0;
            this.title = (TextView) itemView.findViewById(R.id.titulo);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cheked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            this.btn_pagar = (ImageView) itemView.findViewById(R.id.btn_pagar);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.btn_check);
            this.btn_check = imageView;
            this.operation = operation;
            this.listener = listener;
            this.itemList = itemList;
            this.activity = activity;
            this.context = context;
            imageView.setVisibility(8);
            this.btn_pagar.setOnClickListener(this);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            final yHdVJARBHM uyh0pxs9m37in = this.itemList.get(getPosition());
            FragmentManager mFragmentManager = this.activity.getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            if (v.getId() == this.btn_pagar.getId()) {
                CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO", "MITRANSFER"};
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setTitle("Seleccione el banco");
                builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW.ViewHolder.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FragmentManager mFragmentManager2 = ViewHolder.this.activity.getSupportFragmentManager();
                        FragmentTransaction mFragmentTransaction = mFragmentManager2.beginTransaction();
                        Bundle b = new Bundle();
                        b.putInt("cuenta_id", uyh0pxs9m37in.getId());
                        switch (i) {
                            case 0:
                                b.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                                hqPCcU1E8u tFragment = new hqPCcU1E8u();
                                tFragment.setArguments(b);
                                mFragmentTransaction.replace(R.id.containerView, tFragment).addToBackStack(null).commit();
                                break;
                            case 1:
                                b.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                                hqPCcU1E8u tFragment2 = new hqPCcU1E8u();
                                tFragment2.setArguments(b);
                                mFragmentTransaction.replace(R.id.containerView, tFragment2).addToBackStack(null).commit();
                                break;
                            case 2:
                                b.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                                hqPCcU1E8u tFragment3 = new hqPCcU1E8u();
                                tFragment3.setArguments(b);
                                mFragmentTransaction.replace(R.id.containerView, tFragment3).addToBackStack(null).commit();
                                break;
                            case 3:
                                b.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                                JrjJL8mtlI tFragment4 = new JrjJL8mtlI();
                                tFragment4.setArguments(b);
                                mFragmentTransaction.replace(R.id.containerView, tFragment4).addToBackStack(null).commit();
                                break;
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return;
            }
            if (this.listener != null && v.getId() != this.btn_pagar.getId() && v.getId() != this.btn_check.getId()) {
                this.listener.onItemClicked(getPosition());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            ClickListener clickListener = this.listener;
            if (clickListener != null) {
                return clickListener.onItemLongClicked(getPosition());
            }
            return false;
        }
    }
}
