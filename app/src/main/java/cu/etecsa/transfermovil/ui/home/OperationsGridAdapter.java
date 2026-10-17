package cu.etecsa.transfermovil.ui.home;

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
import cu.etecsa.transfermovil.core.GlobalState;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG
 * @fingerprint RecyclerView adapter for home operations grid (432 lines).
 *              Loads active operations from DB via DAO (unYp8VQThY), maps BankType
 *              to parent icon (ETECSA→ico_agente, BPA→logo_bpa, BANDEC→logo_bandec,
 *              Metropolitano→logo_metro, MiTransfer→mitransfer_color2).
 *              Supports: drag reorder (persisted to DB), swipe-to-dismiss (sets order=-1),
 *              "Insertar Operación" button for adding inactive operations via multi-choice dialog.
 *              Inner class ItemViewHolder implements ItemSelectionListener + OnItemClickListener.
 *
 * Dependencies:
 *   - Operacion → data entity (ZNRpoHwtLXM.MZUDJuUoMJL)
 *   - unYp8VQThY → DAO singleton for operations
 *   - FBsQzP3Zfj → UssdDispatcher.goToFragment()
 *   - U6ucOCBccJ → GlobalState.writeLog()
 *   - R1sDOSqZ2z → BankType enum (piM0KeORWQz)
 */
public class OperationsGridAdapter extends RecyclerView.Adapter<OperationsGridAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {

    public FragmentActivity activity;
    public boolean btnActivoNuevo;
    public boolean[] checkedItems;
    public Context context;
    public List<OperationMenuItem> itemList = new ArrayList<>();
    public String[] listItems;
    private final DragStartListener dragStartListener;
    public OnItemClickListener mItemClickListener;
    public OperationMenuItem nuevoItem;
    // public List<Operacion> operacionList;
    // public List<Operacion> operacionNoIncluidas;
    public ViewGroup parentHome;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public OperationsGridAdapter(FragmentActivity activity, DragStartListener dragStartListener) {
        this.btnActivoNuevo = true;
        this.dragStartListener = dragStartListener;
        this.context = activity;
        this.activity = activity;
        try {
            // this.operacionList = unYp8VQThY.getInstance().getOperacionesList();
            // fillItemList();
            // List<Operacion> noActivas = unYp8VQThY.getInstance().getOperacionesNoActivasList();
            // this.operacionNoIncluidas = noActivas;
            // if (noActivas.size() > 0) {
            //     this.nuevoItem = new OperationMenuItem();
            //     nuevoItem.setTitulo("");
            //     nuevoItem.setIconoOperacion(R.drawable.ico11);
            //     nuevoItem.setSubtitulo("Insertar Operación");
            //     nuevoItem.setOrden(-1);
            //     this.itemList.add(nuevoItem);
            // } else {
            //     this.btnActivoNuevo = false;
            // }
        } catch (Exception ex) {
            GlobalState.writeLog(ex.getMessage());
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.q5dhs65bu5ijgr, parent, false);
        // ItemViewHolder holder = new ItemViewHolder(view, this.itemList);
        // this.parentHome = parent;
        // return holder;
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        // holder.cardView.setOnClickListener(v -> {
        //     try {
        //         int lastIndex = itemList.size() - 1;
        //         if (lastIndex == position && btnActivoNuevo) {
        //             operacionNoIncluidas = unYp8VQThY.getInstance().getOperacionesNoActivasList();
        //             listItems = new String[operacionNoIncluidas.size()];
        //             for (int i = 0; i < operacionNoIncluidas.size(); i++) {
        //                 listItems[i] = operacionNoIncluidas.get(i).getTipo_serivicio().name()
        //                     + ": " + operacionNoIncluidas.get(i).getTitulo();
        //             }
        //             checkedItems = new boolean[operacionNoIncluidas.size()];
        //             clickNewItem();
        //             return;
        //         }
        //         OperationMenuItem item = itemList.get(position);
        //         if (item != null) {
        //             FragmentDialogResult result = UssdDispatcher.goToFragment(activity, parentHome, context, item.getId());
        //             if (result.getFragment() == null) {
        //                 if (result.getDialogo() != null) result.getDialogo().show();
        //             } else {
        //                 activity.getSupportFragmentManager().beginTransaction()
        //                     .replace(R.id.containerView, result.getFragment())
        //                     .addToBackStack(null).commit();
        //             }
        //         }
        //     } catch (Exception ex) { GlobalState.writeLog(ex.getMessage()); }
        // });
        //
        // holder.imagenBorrar.setOnClickListener(v -> {
        //     AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //     builder.setTitle("¿Desea eliminar el elemento seleccionado?");
        //     builder.setPositiveButton("SI", (d, i) -> onItemDismiss(position));
        //     builder.setNegativeButton("NO", (d, i) -> {});
        //     builder.create().show();
        // });
        //
        // holder.tituloTextView.setText(itemList.get(position).getTitulo());
        // holder.subtituloTextView.setText(itemList.get(position).getSubtitulo());
        // holder.imagenPadre.setImageResource(itemList.get(position).getIconoPadre());
        // holder.imagenOper.setImageResource(itemList.get(position).getIconoOperacion());
        // holder.imagenBorrar.setVisibility(View.VISIBLE);
        // if (itemList.size() - 1 == position && btnActivoNuevo) {
        //     holder.imagenBorrar.setVisibility(View.GONE);
        // }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        // try {
        //     notifyItemRemoved(position);
        //     Operacion op = unYp8VQThY.getInstance().getOperacionWithId(itemList.get(position).getId());
        //     op.setOrder(-1);
        //     unYp8VQThY.getInstance().updateOperacion(op);
        //     itemList.remove(position);
        //     if (!btnActivoNuevo) {
        //         nuevoItem = new OperationMenuItem();
        //         nuevoItem.setTitulo("");
        //         nuevoItem.setIconoOperacion(R.drawable.ico11);
        //         nuevoItem.setSubtitulo("Insertar Operación");
        //         nuevoItem.setOrden(-1);
        //         itemList.add(nuevoItem);
        //         btnActivoNuevo = true;
        //     }
        //     notifyDataSetChanged();
        // } catch (Exception ex) { GlobalState.writeLog(ex.getMessage()); }
    }

    @Override
    public void notificarCambio(int originalPosition, int destinyPosition) {
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        // try {
        //     int lastIndex = itemList.size() - 1;
        //     if (btnActivoNuevo && (fromPosition == lastIndex || toPosition == lastIndex)) {
        //         return true;
        //     }
        //     notifyItemMoved(fromPosition, toPosition);
        //     if (fromPosition < toPosition) {
        //         OperationMenuItem aux = itemList.get(fromPosition);
        //         for (int i = fromPosition + 1; i <= toPosition; i++) {
        //             itemList.set(i - 1, itemList.get(i));
        //         }
        //         itemList.set(toPosition, aux);
        //     }
        //     if (fromPosition > toPosition) {
        //         OperationMenuItem aux = itemList.get(fromPosition);
        //         for (int i = fromPosition - 1; i >= toPosition; i--) {
        //             itemList.set(i + 1, itemList.get(i));
        //         }
        //         itemList.set(toPosition, aux);
        //     }
        //     int max = btnActivoNuevo ? itemList.size() - 1 : itemList.size();
        //     for (int i = 0; i < max; i++) {
        //         Operacion op = unYp8VQThY.getInstance().getOperacionWithId(itemList.get(i).getId());
        //         op.setOrder(i);
        //         unYp8VQThY.getInstance().updateOperacion(op);
        //     }
        //     return true;
        // } catch (Exception ex) { GlobalState.writeLog(ex.getMessage()); return false; }
        return false;
    }

    public void fillItemList() {
        // BankType switch → parent icon:
        //   ETECSA → ico_agente, BPA → logo_bpa, BANDEC → logo_bandec,
        //   Metropolitano → logo_metro, MiTransfer → mitransfer_color2, default → etecsa
    }

    public void clickNewItem() {
        // Multi-choice dialog "Selecciones una o varias operaciones"
        // Checked items get order set and added to grid; if all added, "Insertar" button removed.
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements ItemSelectionListener, OnItemClickListener {
        public final CardView cardView;
        public final ImageView imagenBorrar;
        public final ImageView imagenOper;
        public final ImageView imagenPadre;
        public final TextView subtituloTextView;
        public final TextView tituloTextView;

        public ItemViewHolder(View itemView, List<OperationMenuItem> itemList) {
            super(itemView);
            // this.imagenOper = itemView.findViewById(R.id.icono);
            // this.imagenPadre = itemView.findViewById(R.id.icoPadre);
            // this.tituloTextView = itemView.findViewById(R.id.titulo);
            // this.subtituloTextView = itemView.findViewById(R.id.subtitulo);
            // this.cardView = itemView.findViewById(R.id.cv);
            // this.imagenBorrar = itemView.findViewById(R.id.btn_borrar);
            this.imagenOper = null;
            this.imagenPadre = null;
            this.tituloTextView = null;
            this.subtituloTextView = null;
            this.cardView = null;
            this.imagenBorrar = null;
        }

        @Override
        public void onItemSelected() {}

        @Override
        public void onItemClear() {}

        @Override
        public void onItemClick(View view, int position) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(this.itemView, position);
            }
        }
    }
}
