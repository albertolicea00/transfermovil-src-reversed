package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class J9bkD55BKNh extends ypYiy6EkAW<a2dVPTG0kZc> {
    private FragmentActivity activity;
    private Context context;
    private List<K5ksEKSUSh> itemList;
    public OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onDelete(int i, int i2);

        void onEditIten(int i);

        void onQR(int i);

        void onShare(String str);

        void onTransfer(int i);
    }

    public J9bkD55BKNh(Context contexts, List<K5ksEKSUSh> itemList) {
        this.context = contexts;
        this.itemList = itemList;
    }

    public J9bkD55BKNh(Context contexts, FragmentActivity activity, List<K5ksEKSUSh> itemList) {
        this.context = contexts;
        this.itemList = itemList;
        this.activity = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rbrrbrw7gndvu, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view, this.activity, this.context);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.tituloTextView.setText(this.itemList.get(i).getTitulo());
        customViewHolder.cuentTextView.setText(this.itemList.get(i).getSubtitulo());
        customViewHolder.monedaTextView.setText(this.itemList.get(i).getMoneda());
        customViewHolder.id = this.itemList.get(i).id;
        customViewHolder.cuenta = this.itemList.get(i).cuenta;
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.itemList.get(i).getBanco().ordinal()]) {
            case 1:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_bpa)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
            case 2:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_bandec)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
            case 3:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_metro)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
            case 4:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_bfi)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
            case 5:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_clasica)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
            case 6:
                Glide.with(this.context).load(Integer.valueOf(R.drawable.tarjeta_clasica_empresarial)).placeholder(R.drawable.tarjeta_blanco).into(customViewHolder.bancoImage);
                break;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BFI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICAEMP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<K5ksEKSUSh> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView bancoImage;
        public ConstraintLayout btnDelete;
        public ConstraintLayout btnEdit;
        public ConstraintLayout btnQr;
        public ConstraintLayout btnShare;
        public ConstraintLayout btnTransfer;
        public TextView cuentTextView;
        public String cuenta;
        public CardView cv;
        public int id;
        public ConstraintLayout menuConstraint;
        public TextView monedaTextView;
        public ConstraintLayout placeHolder;
        public TextView tituloTextView;
        public boolean visibleContraint;

        public a2dVPTG0kZc(View view, FragmentActivity factivity, Context fcontext) {
            super(view);
            this.cv = (CardView) view.findViewById(R.id.cv);
            this.tituloTextView = (TextView) view.findViewById(R.id.txCuenta);
            this.bancoImage = (ImageView) view.findViewById(R.id.ivBanco);
            this.monedaTextView = (TextView) view.findViewById(R.id.txMoneda);
            this.placeHolder = (ConstraintLayout) view.findViewById(R.id.mainHolder);
            this.cuentTextView = (TextView) view.findViewById(R.id.txCuentaBanco);
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.menuContraint);
            this.menuConstraint = constraintLayout;
            this.visibleContraint = false;
            constraintLayout.setVisibility(8);
            this.placeHolder.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    if (!a2dvptg0kzc.visibleContraint) {
                        a2dvptg0kzc.menuConstraint.setVisibility(0);
                        a2dVPTG0kZc.this.visibleContraint = true;
                    } else {
                        a2dvptg0kzc.menuConstraint.setVisibility(8);
                        a2dVPTG0kZc.this.visibleContraint = false;
                    }
                }
            });
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.btnTransfer);
            this.btnTransfer = constraintLayout2;
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    J9bkD55BKNh.this.mItemClickListener.onTransfer(a2dvptg0kzc.id);
                }
            });
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.btnQr);
            this.btnQr = constraintLayout3;
            constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    J9bkD55BKNh.this.mItemClickListener.onQR(a2dvptg0kzc.id);
                }
            });
            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.btnEdit);
            this.btnEdit = constraintLayout4;
            constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    J9bkD55BKNh.this.mItemClickListener.onEditIten(a2dvptg0kzc.id);
                }
            });
            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.btnShare);
            this.btnShare = constraintLayout5;
            constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(J9bkD55BKNh.this.context);
                    builder.setTitle("Notificación").setMessage("¿Desea enviar su número de cuenta a otro destinatario? Tenga en cuenta que será enviada en texto plano y debe asegurarse de la confiabilidad del destinatario").setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.5.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                                J9bkD55BKNh.this.mItemClickListener.onShare(a2dvptg0kzc.cuenta);
                            } catch (Exception e) {
                            }
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }
            });
            ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.btnDelete);
            this.btnDelete = constraintLayout6;
            constraintLayout6.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(J9bkD55BKNh.this.context);
                    builder.setTitle("Notificación").setMessage("¿Desea eliminar la cuenta?").setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                                J9bkD55BKNh.this.notifyItemChanged(a2dvptg0kzc.getAdapterPosition());
                                a2dVPTG0kZc a2dvptg0kzc2 = a2dVPTG0kZc.this;
                                J9bkD55BKNh.this.notifyItemRangeChanged(a2dvptg0kzc2.getAdapterPosition(), J9bkD55BKNh.this.itemList.size());
                                J9bkD55BKNh.this.itemList.remove(a2dVPTG0kZc.this.getAdapterPosition());
                                a2dVPTG0kZc a2dvptg0kzc3 = a2dVPTG0kZc.this;
                                J9bkD55BKNh.this.mItemClickListener.onDelete(a2dvptg0kzc3.getAdapterPosition(), a2dVPTG0kZc.this.id);
                            } catch (Exception e) {
                            }
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.a2dVPTG0kZc.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickListener onItemClickListener = J9bkD55BKNh.this.mItemClickListener;
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
