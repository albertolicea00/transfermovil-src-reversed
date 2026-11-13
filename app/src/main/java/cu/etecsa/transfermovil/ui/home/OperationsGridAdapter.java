package cu.etecsa.transfermovil.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.O2oXWQuRDi;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.transfermovil.core.GlobalState;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 * Home operations grid reconstructed from the original adapter.
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG
 */
public class OperationsGridAdapter extends RecyclerView.Adapter<OperationsGridAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {

    private final FragmentActivity activity;
    private final Context context;
    private final DragStartListener dragStartListener;
    private final List<OperationMenuItem> itemList = new ArrayList<>();
    private List<Operation> activeOperations = new ArrayList<>();
    private List<Operation> inactiveOperations = new ArrayList<>();
    private ViewGroup parentHome;
    private boolean addOperationAvailable;
    private String[] choices = new String[0];
    private boolean[] checked = new boolean[0];

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener clickListener;

    public OperationsGridAdapter(FragmentActivity activity, DragStartListener dragStartListener) {
        this.activity = activity;
        this.context = activity;
        this.dragStartListener = dragStartListener;
        loadOperations();
    }

    private void loadOperations() {
        try {
            DatabaseHelper.init(context);
            activeOperations = safeList(DatabaseHelper.getInstance().getOperacionesList());
            inactiveOperations = safeList(DatabaseHelper.getInstance().getOperacionesNoActivasList());
            itemList.clear();
            for (Operation operation : activeOperations) itemList.add(toMenuItem(operation));
            addOperationAvailable = !inactiveOperations.isEmpty();
            if (addOperationAvailable) {
                OperationMenuItem add = new OperationMenuItem();
                add.setTitulo("");
                add.setSubtitulo("Insertar Operación");
                add.setIconoOperacion(cu.etecsa.cubacel.tr.tm.R.drawable.ico11);
                add.setOrden(-1);
                itemList.add(add);
            }
        } catch (Exception ex) {
            GlobalState.writeLog("OperationsGridAdapter.loadOperations: " + ex.getMessage());
            Toast.makeText(context, "No se pudieron cargar las operaciones", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Operation> safeList(List<Operation> list) {
        return list == null ? new ArrayList<>() : list;
    }

    private OperationMenuItem toMenuItem(Operation operation) {
        OperationMenuItem item = new OperationMenuItem();
        item.setId(operation.getId());
        item.setTitulo(operation.getTitulo());
        item.setSubtitulo(operation.getSubtitulo());
        item.setIconoOperacion(operation.getImagen());
        item.setIconoPadre(parentIcon(operation.getTipo_serivicio()));
        item.setOrden(operation.getOrder());
        item.setRuta_fragment(operation.getFragment_name());
        return item;
    }

    private int parentIcon(BankType type) {
        if (type == BankType.ETECSA) return cu.etecsa.cubacel.tr.tm.R.drawable.ico_agente;
        if (type == BankType.BPA) return cu.etecsa.cubacel.tr.tm.R.drawable.logo_bpa;
        if (type == BankType.BANDEC) return cu.etecsa.cubacel.tr.tm.R.drawable.logo_bandec;
        if (type == BankType.Metropolitano) return cu.etecsa.cubacel.tr.tm.R.drawable.logo_metro;
        if (type == BankType.MiTransfer) return cu.etecsa.cubacel.tr.tm.R.drawable.mitransfer_color2;
        return cu.etecsa.cubacel.tr.tm.R.drawable.etecsa;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(cu.etecsa.cubacel.tr.tm.R.layout.q5dhs65bu5ijgr, parent, false);
        parentHome = parent;
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        OperationMenuItem item = itemList.get(position);
        holder.title.setText(item.getTitulo());
        holder.subtitle.setText(item.getSubtitulo());
        holder.operationIcon.setImageResource(item.getIconoOperacion());
        holder.parentIcon.setImageResource(item.getIconoPadre());
        holder.delete.setVisibility(addOperationAvailable && position == itemList.size() - 1
                ? View.GONE : View.VISIBLE);
        holder.card.setOnClickListener(v -> {
            if (addOperationAvailable && position == itemList.size() - 1) {
                showAddOperationDialog();
            } else {
                openOperation(item);
            }
        });
        holder.delete.setOnClickListener(v -> confirmRemove(position));
    }

    private void openOperation(OperationMenuItem item) {
        try {
            O2oXWQuRDi result = UssdDispatcher.goToFragment(activity, parentHome, context, item.getId());
            if (result == null) return;
            if (result.getFragment() != null) {
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(cu.etecsa.cubacel.tr.tm.R.id.containerView, result.getFragment())
                        .addToBackStack(null).commit();
            } else if (result.getDialogo() != null) {
                result.getDialogo().show();
            } else {
                Toast.makeText(context, "Esta operación no tiene una acción disponible", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            GlobalState.writeLog("OperationsGridAdapter.openOperation " + item.getId() + ": " + ex.getMessage());
            Toast.makeText(context, "No se pudo abrir esta operación", Toast.LENGTH_SHORT).show();
        }
    }

    private void confirmRemove(int position) {
        new AlertDialog.Builder(context)
                .setTitle("¿Desea eliminar el elemento seleccionado?")
                .setPositiveButton("SI", (dialog, which) -> onItemDismiss(position))
                .setNegativeButton("NO", null)
                .show();
    }

    private void showAddOperationDialog() {
        try {
            inactiveOperations = safeList(DatabaseHelper.getInstance().getOperacionesNoActivasList());
            choices = new String[inactiveOperations.size()];
            checked = new boolean[inactiveOperations.size()];
            for (int i = 0; i < inactiveOperations.size(); i++) {
                Operation operation = inactiveOperations.get(i);
                choices[i] = operation.getTipo_serivicio().name() + ": " + operation.getTitulo();
            }
            new AlertDialog.Builder(context)
                    .setTitle("Selecciones una o varias operaciones")
                    .setMultiChoiceItems(choices, checked, (dialog, which, selected) -> checked[which] = selected)
                    .setCancelable(false)
                    .setPositiveButton("OK", (dialog, which) -> addSelectedOperations())
                    .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                    .show();
        } catch (Exception ex) {
            GlobalState.writeLog("OperationsGridAdapter.showAddOperationDialog: " + ex.getMessage());
        }
    }

    private void addSelectedOperations() {
        try {
            for (int i = 0; i < checked.length; i++) {
                if (!checked[i]) continue;
                Operation operation = inactiveOperations.get(i);
                operation.setOrder(activeOperations.size());
                DatabaseHelper.getInstance().updateOperacion(operation);
                activeOperations.add(operation);
                itemList.add(addOperationAvailable ? itemList.size() - 1 : itemList.size(), toMenuItem(operation));
            }
            inactiveOperations = safeList(DatabaseHelper.getInstance().getOperacionesNoActivasList());
            if (inactiveOperations.isEmpty() && addOperationAvailable) {
                itemList.remove(itemList.size() - 1);
                addOperationAvailable = false;
            }
            notifyDataSetChanged();
        } catch (Exception ex) {
            GlobalState.writeLog("OperationsGridAdapter.addSelectedOperations: " + ex.getMessage());
        }
    }

    private void persistOrder() {
        int activeCount = addOperationAvailable ? itemList.size() - 1 : itemList.size();
        for (int i = 0; i < activeCount; i++) {
            Operation operation = DatabaseHelper.getInstance().getOperacionWithId(itemList.get(i).getId());
            if (operation != null) {
                operation.setOrder(i);
                DatabaseHelper.getInstance().updateOperacion(operation);
            }
        }
    }

    @Override public int getItemCount() { return itemList.size(); }

    @Override
    public void onItemDismiss(int position) {
        if (position < 0 || position >= itemList.size() ||
                (addOperationAvailable && position == itemList.size() - 1)) return;
        try {
            Operation operation = DatabaseHelper.getInstance().getOperacionWithId(itemList.get(position).getId());
            if (operation != null) {
                operation.setOrder(-1);
                DatabaseHelper.getInstance().updateOperacion(operation);
                for (int i = 0; i < activeOperations.size(); i++) {
                    if (activeOperations.get(i).getId() == operation.getId()) {
                        activeOperations.remove(i);
                        break;
                    }
                }
            }
            itemList.remove(position);
            if (!addOperationAvailable) {
                OperationMenuItem add = new OperationMenuItem();
                add.setSubtitulo("Insertar Operación");
                add.setIconoOperacion(cu.etecsa.cubacel.tr.tm.R.drawable.ico11);
                add.setOrden(-1);
                itemList.add(add);
                addOperationAvailable = true;
            }
            persistOrder();
            notifyDataSetChanged();
        } catch (Exception ex) {
            GlobalState.writeLog("OperationsGridAdapter.onItemDismiss: " + ex.getMessage());
        }
    }

    @Override public void notificarCambio(int originalPosition, int destinyPosition) { persistOrder(); }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < 0 || toPosition < 0 || fromPosition >= itemList.size() || toPosition >= itemList.size()) return false;
        int last = itemList.size() - 1;
        if (addOperationAvailable && (fromPosition == last || toPosition == last)) return true;
        OperationMenuItem moved = itemList.remove(fromPosition);
        itemList.add(toPosition, moved);
        notifyItemMoved(fromPosition, toPosition);
        persistOrder();
        return true;
    }

    public void setOnItemClickListener(OnItemClickListener listener) { clickListener = listener; }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemSelectionListener, OnItemClickListener {
        final CardView card;
        final ImageView delete;
        final ImageView operationIcon;
        final ImageView parentIcon;
        final TextView subtitle;
        final TextView title;

        ItemViewHolder(View view) {
            super(view);
            operationIcon = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.icono);
            parentIcon = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.icoPadre);
            title = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.titulo);
            subtitle = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.subtitulo);
            card = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.cv);
            delete = view.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_borrar);
        }

        @Override public void onItemSelected() { itemView.setAlpha(0.7f); }
        @Override public void onItemClear() { itemView.setAlpha(1f); }
        @Override public void onItemClick(View view, int position) {
            if (clickListener != null) clickListener.onItemClick(view, position);
        }
    }
}
