package cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h6V5083iulG extends RecyclerView.Adapter<ItemViewHolder> implements j5DsTHaKx5I {
    public FragmentActivity activity;
    public boolean btnActivoNuevo;
    public boolean[] checkedItems;
    public Context context;
    public List<S5yJNkLr85> itemList = new ArrayList();
    public String[] listItems;
    private final CdmbKxDIrW mDragStartListener;
    public OnItemClickListener mItemClickListener;
    public S5yJNkLr85 nuevoItem;
    public List<Operacion> operacionList;
    public List<Operacion> operacionNoIncluidas;
    public ViewGroup parent_home;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public h6V5083iulG(FragmentActivity activity, CdmbKxDIrW dragStartListener) {
        this.btnActivoNuevo = true;
        this.mDragStartListener = dragStartListener;
        this.context = activity;
        this.activity = activity;
        try {
            this.operacionList = unYp8VQThY.getInstance().getOperacionesList();
            fillItemList();
            List<Operacion> operacionesNoActivasList = unYp8VQThY.getInstance().getOperacionesNoActivasList();
            this.operacionNoIncluidas = operacionesNoActivasList;
            if (operacionesNoActivasList.size() > 0) {
                S5yJNkLr85 s5yJNkLr85 = new S5yJNkLr85();
                this.nuevoItem = s5yJNkLr85;
                s5yJNkLr85.setTitulo(BuildConfig.FLAVOR);
                this.nuevoItem.setIconoOperacion(R.drawable.ico11);
                this.nuevoItem.setSubtitulo("Insertar Operación");
                this.nuevoItem.setOrden(-1);
                this.itemList.add(this.nuevoItem);
            } else {
                this.btnActivoNuevo = false;
            }
        } catch (Exception ex) {
            U6ucOCBccJ.writeLog(ex.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.q5dhs65bu5ijgr, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view, this.itemList);
        this.parent_home = parent;
        return itemViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    int size = h6V5083iulG.this.itemList.size() - 1;
                    int i = position;
                    if (size == i) {
                        h6V5083iulG h6v5083iulg = h6V5083iulG.this;
                        if (h6v5083iulg.btnActivoNuevo) {
                            h6v5083iulg.operacionNoIncluidas = unYp8VQThY.getInstance().getOperacionesNoActivasList();
                            h6V5083iulG h6v5083iulg2 = h6V5083iulG.this;
                            h6v5083iulg2.listItems = new String[h6v5083iulg2.operacionNoIncluidas.size()];
                            for (int i2 = 0; i2 < h6V5083iulG.this.operacionNoIncluidas.size(); i2++) {
                                h6V5083iulG.this.listItems[i2] = h6V5083iulG.this.operacionNoIncluidas.get(i2).getTipo_serivicio().name() + ": " + h6V5083iulG.this.operacionNoIncluidas.get(i2).getTitulo();
                            }
                            h6V5083iulG h6v5083iulg3 = h6V5083iulG.this;
                            h6v5083iulg3.checkedItems = new boolean[h6v5083iulg3.operacionNoIncluidas.size()];
                            h6V5083iulG.this.clickNewItem();
                            return;
                        }
                    }
                    S5yJNkLr85 operacion_acceso = h6V5083iulG.this.itemList.get(i);
                    if (operacion_acceso != null) {
                        h6V5083iulG h6v5083iulg4 = h6V5083iulG.this;
                        O2oXWQuRDi accesoDirectoResult = FBsQzP3Zfj.goToFragment(h6v5083iulg4.activity, h6v5083iulg4.parent_home, h6v5083iulg4.context, operacion_acceso.getId());
                        if (accesoDirectoResult.getFragment() == null) {
                            if (accesoDirectoResult.getDialogo() != null) {
                                accesoDirectoResult.getDialogo().show();
                            }
                        } else {
                            Fragment f = accesoDirectoResult.getFragment();
                            FragmentManager mFragmentManager = h6V5083iulG.this.activity.getSupportFragmentManager();
                            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.replace(R.id.containerView, f).addToBackStack(null).commit();
                        }
                    }
                } catch (Exception ex) {
                    U6ucOCBccJ.writeLog(ex.getMessage());
                }
            }
        });
        holder.imagenBorrar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(h6V5083iulG.this.context);
                    mBuilder.setTitle("¿Desea eliminar el elemento seleccionado?");
                    mBuilder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            h6V5083iulG.this.onItemDismiss(position);
                        }
                    });
                    mBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.2.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();
                } catch (Exception ex) {
                    U6ucOCBccJ.writeLog(ex.getMessage());
                }
            }
        });
        try {
            int maximo = this.itemList.size();
            holder.tituloTextView.setText(this.itemList.get(position).getTitulo());
            holder.subtituloTextView.setText(this.itemList.get(position).getSubtitulo());
            holder.imagenPadre.setImageResource(this.itemList.get(position).getIconoPadre());
            holder.imagenOper.setImageResource(this.itemList.get(position).getIconoOperacion());
            holder.imagenBorrar.setVisibility(0);
            if (maximo - 1 == position && this.btnActivoNuevo) {
                holder.imagenBorrar.setVisibility(8);
            }
        } catch (Exception ex) {
            U6ucOCBccJ.writeLog(ex.getMessage());
        }
    }

    public void clickNewItem() {
        try {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this.context);
            mBuilder.setTitle("Selecciones una o varias operaciones");
            mBuilder.setMultiChoiceItems(this.listItems, this.checkedItems, new DialogInterface.OnMultiChoiceClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.3
                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                    if (isChecked) {
                        h6V5083iulG.this.checkedItems[position] = true;
                    } else {
                        h6V5083iulG.this.checkedItems[position] = false;
                    }
                }
            });
            mBuilder.setCancelable(false);
            mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int which) {
                    int icono_padre;
                    int i = 0;
                    while (true) {
                        h6V5083iulG h6v5083iulg = h6V5083iulG.this;
                        boolean[] zArr = h6v5083iulg.checkedItems;
                        if (i < zArr.length) {
                            if (zArr[i]) {
                                Operacion operacion_mostrar = h6v5083iulg.operacionNoIncluidas.get(i);
                                if (h6V5083iulG.this.operacionList.size() == 0) {
                                    operacion_mostrar.setOrder(1);
                                } else {
                                    operacion_mostrar.setOrder(h6V5083iulG.this.operacionList.size() - 1);
                                }
                                unYp8VQThY.getInstance().updateOperacion(operacion_mostrar);
                                S5yJNkLr85 nuevo = new S5yJNkLr85();
                                nuevo.setId(operacion_mostrar.getId());
                                nuevo.setTitulo(operacion_mostrar.getTitulo());
                                nuevo.setSubtitulo(operacion_mostrar.getSubtitulo());
                                nuevo.setIconoOperacion(operacion_mostrar.getImagen());
                                nuevo.setOrden(operacion_mostrar.getOrder());
                                switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[operacion_mostrar.getTipo_serivicio().ordinal()]) {
                                    case 1:
                                        icono_padre = R.drawable.ico_agente;
                                        break;
                                    case 2:
                                        icono_padre = R.drawable.logo_bpa;
                                        break;
                                    case 3:
                                        icono_padre = R.drawable.logo_bandec;
                                        break;
                                    case 4:
                                        icono_padre = R.drawable.logo_metro;
                                        break;
                                    default:
                                        icono_padre = R.drawable.etecsa;
                                        break;
                                }
                                nuevo.setIconoPadre(icono_padre);
                                List<S5yJNkLr85> list = h6V5083iulG.this.itemList;
                                list.add(list.size() - 1, nuevo);
                                h6V5083iulG.this.notifyDataSetChanged();
                            }
                            i++;
                        } else {
                            if (unYp8VQThY.getInstance().getOperacionesNoActivasList().size() == 0) {
                                h6V5083iulG h6v5083iulg2 = h6V5083iulG.this;
                                h6v5083iulg2.btnActivoNuevo = false;
                                List<S5yJNkLr85> list2 = h6v5083iulg2.itemList;
                                list2.remove(list2.size() - 1);
                                h6V5083iulG h6v5083iulg3 = h6V5083iulG.this;
                                h6v5083iulg3.notifyItemRemoved(h6v5083iulg3.itemList.size() - 1);
                                return;
                            }
                            return;
                        }
                    }
                }
            });
            mBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        } catch (Exception ex) {
            U6ucOCBccJ.writeLog(ex.getMessage());
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.ETECSA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.j5DsTHaKx5I
    public void onItemDismiss(int position) {
        try {
            notifyItemRemoved(position);
            Operacion operaciondelete = unYp8VQThY.getInstance().getOperacionWithId(this.itemList.get(position).getId());
            operaciondelete.setOrder(-1);
            unYp8VQThY.getInstance().updateOperacion(operaciondelete);
            this.itemList.remove(position);
            if (!this.btnActivoNuevo) {
                S5yJNkLr85 s5yJNkLr85 = new S5yJNkLr85();
                this.nuevoItem = s5yJNkLr85;
                s5yJNkLr85.setTitulo(BuildConfig.FLAVOR);
                this.nuevoItem.setIconoOperacion(R.drawable.ico11);
                this.nuevoItem.setSubtitulo("Insertar Operación");
                this.nuevoItem.setOrden(-1);
                this.itemList.add(this.nuevoItem);
                this.btnActivoNuevo = true;
            }
            notifyDataSetChanged();
        } catch (Exception ex) {
            U6ucOCBccJ.writeLog(ex.getMessage());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.j5DsTHaKx5I
    public void notificarCambio(int originalPosition, int destinyPosition) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.j5DsTHaKx5I
    public boolean onItemMove(int fromPosition, int toPosition) {
        try {
            int position_ultima = this.itemList.size() - 1;
            if (!this.btnActivoNuevo || (fromPosition != position_ultima && toPosition != position_ultima)) {
                notifyItemMoved(fromPosition, toPosition);
                if (fromPosition < toPosition) {
                    S5yJNkLr85 aux = this.itemList.get(fromPosition);
                    for (int i = fromPosition + 1; i <= toPosition; i++) {
                        S5yJNkLr85 e = this.itemList.get(i);
                        this.itemList.set(i - 1, e);
                    }
                    this.itemList.set(toPosition, aux);
                }
                if (fromPosition > toPosition) {
                    S5yJNkLr85 aux2 = this.itemList.get(fromPosition);
                    for (int i2 = fromPosition - 1; i2 >= toPosition; i2--) {
                        S5yJNkLr85 e2 = this.itemList.get(i2);
                        this.itemList.set(i2 + 1, e2);
                    }
                    this.itemList.set(toPosition, aux2);
                }
                int MAX = this.itemList.size() - 1;
                if (!this.btnActivoNuevo) {
                    MAX = this.itemList.size();
                }
                for (int i3 = 0; i3 < MAX; i3++) {
                    Operacion operacion = unYp8VQThY.getInstance().getOperacionWithId(this.itemList.get(i3).getId());
                    operacion.setOrder(i3);
                    unYp8VQThY.getInstance().updateOperacion(operacion);
                }
            }
            return true;
        } catch (Exception ex) {
            U6ucOCBccJ.writeLog(ex.getMessage());
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    public void fillItemList() {
        int icono_padre;
        for (Operacion operacion : this.operacionList) {
            try {
                S5yJNkLr85 uyh0pxs9m37in = new S5yJNkLr85();
                uyh0pxs9m37in.setId(operacion.getId());
                uyh0pxs9m37in.setTitulo(operacion.getTitulo());
                uyh0pxs9m37in.setSubtitulo(operacion.getSubtitulo());
                uyh0pxs9m37in.setIconoOperacion(operacion.getImagen());
                switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[operacion.getTipo_serivicio().ordinal()]) {
                    case 1:
                        icono_padre = R.drawable.ico_agente;
                        break;
                    case 2:
                        icono_padre = R.drawable.logo_bpa;
                        break;
                    case 3:
                        icono_padre = R.drawable.logo_bandec;
                        break;
                    case 4:
                        icono_padre = R.drawable.logo_metro;
                        break;
                    case 5:
                        icono_padre = R.drawable.mitransfer_color2;
                        break;
                    default:
                        icono_padre = R.drawable.etecsa;
                        break;
                }
                uyh0pxs9m37in.setIconoPadre(icono_padre);
                uyh0pxs9m37in.setOrden(operacion.getOrder());
                uyh0pxs9m37in.setRuta_fragment(operacion.getFragment_name());
                this.itemList.add(uyh0pxs9m37in);
            } catch (Exception ex) {
                U6ucOCBccJ.writeLog(ex.getMessage());
            }
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements TBQZlehlWh, OnItemClickListener {
        public final CardView cardView;
        public final ImageView imagenBorrar;
        public final ImageView imagenOper;
        public final ImageView imagenPadre;
        public final TextView subtituloTextView;
        public final TextView tituloTextView;

        public ItemViewHolder(View itemView, List<S5yJNkLr85> itemList) {
            super(itemView);
            this.imagenOper = (ImageView) itemView.findViewById(R.id.icono);
            this.imagenPadre = (ImageView) itemView.findViewById(R.id.icoPadre);
            this.tituloTextView = (TextView) itemView.findViewById(R.id.titulo);
            this.subtituloTextView = (TextView) itemView.findViewById(R.id.subtitulo);
            this.cardView = (CardView) itemView.findViewById(R.id.cv);
            this.imagenBorrar = (ImageView) itemView.findViewById(R.id.btn_borrar);
        }

        @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.TBQZlehlWh
        public void onItemSelected() {
        }

        @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.TBQZlehlWh
        public void onItemClear() {
        }

        @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.OnItemClickListener
        public void onItemClick(View view, int position) {
            OnItemClickListener onItemClickListener = h6V5083iulG.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, position);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
