package cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class BolUq6wGDu extends RecyclerView {
    public BolUq6wGDu(Context context) {
        super(context);
    }

    public BolUq6wGDu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BolUq6wGDu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (getAdapter() instanceof ouX1muv8Hd.StickyHeaderInterface) {
            setStickyItemDecoration();
        }
    }

    private void setStickyItemDecoration() {
        ouX1muv8Hd itemDecoration = new ouX1muv8Hd((ouX1muv8Hd.StickyHeaderInterface) getAdapter());
        addItemDecoration(itemDecoration);
    }
}
