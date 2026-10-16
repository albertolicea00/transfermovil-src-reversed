package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;

/* JADX INFO: loaded from: classes.dex */
public class JPTJLdwS9n extends ItemTouchHelperExtension.Callback {
    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelperExtension.Callback.makeMovementFlags(3, 16);
    }

    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return true;
    }

    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    }

    @Override // com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        QV8ylwbhfB.ItemBaseViewHolder holder = (QV8ylwbhfB.ItemBaseViewHolder) viewHolder;
        if (viewHolder instanceof QV8ylwbhfB.ItemBaseViewHolder) {
            holder.mViewContent.setTranslationX(dX);
        }
        if (dY == 0.0f || dX != 0.0f) {
            return;
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
