package cu.etecsa.transfermovil.stats;

import android.util.SparseBooleanArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract RecyclerView adapter with multi-selection support via SparseBooleanArray.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ypYiy6EkAW
 * @fingerprint Base adapter providing toggle/clear/query selection state for RecyclerView items
 */
public abstract class SelectableAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private static final String TAG = SelectableAdapter.class.getSimpleName();
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public boolean isSelected(int position) {
        return getSelectedItems().contains(Integer.valueOf(position));
    }

    public void toggleSelection(int position) {
        if (this.selectedItems.get(position, false)) {
            this.selectedItems.delete(position);
        } else {
            this.selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }

    public void clearSelection() {
        List<Integer> selection = getSelectedItems();
        this.selectedItems.clear();
        for (Integer i : selection) {
            notifyItemChanged(i.intValue());
        }
    }

    public int getSelectedItemCount() {
        return this.selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(this.selectedItems.size());
        for (int i = 0; i < this.selectedItems.size(); i++) {
            items.add(Integer.valueOf(this.selectedItems.keyAt(i)));
        }
        return items;
    }
}
