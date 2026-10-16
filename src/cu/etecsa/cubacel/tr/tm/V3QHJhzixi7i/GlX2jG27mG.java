package cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class GlX2jG27mG extends ItemTouchHelper.Callback {
    public static final float ALPHA_FULL = 1.0f;
    private final j5DsTHaKx5I mAdapter;
    private int originalPosition = 0;
    private int destinyPosition = 0;

    public GlX2jG27mG(j5DsTHaKx5I adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        this.originalPosition = source.getAdapterPosition();
        this.destinyPosition = target.getAdapterPosition();
        this.mAdapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == 1) {
            float alpha = 1.0f - (Math.abs(dX) / viewHolder.itemView.getWidth());
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
            return;
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != 0) {
            if (viewHolder instanceof TBQZlehlWh) {
                TBQZlehlWh itemViewHolder = (TBQZlehlWh) viewHolder;
                itemViewHolder.onItemSelected();
            }
        } else {
            this.mAdapter.notificarCambio(this.originalPosition, this.destinyPosition);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof TBQZlehlWh) {
            TBQZlehlWh itemViewHolder = (TBQZlehlWh) viewHolder;
            itemViewHolder.onItemClear();
        }
    }
}
