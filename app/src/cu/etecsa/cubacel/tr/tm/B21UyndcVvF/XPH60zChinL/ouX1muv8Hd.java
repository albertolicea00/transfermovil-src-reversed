package cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ouX1muv8Hd extends RecyclerView.ItemDecoration {
    private Integer mHeaderHeight;
    private StickyHeaderInterface mListener;

    public interface StickyHeaderInterface {
        void bindHeaderData(View view, Integer num);

        Integer getHeaderLayout(Integer num);

        Integer getHeaderPositionForItem(Integer num);

        Boolean isHeader(Integer num);
    }

    public ouX1muv8Hd(StickyHeaderInterface listener) {
        this.mListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int topChildPosition;
        super.onDrawOver(c, parent, state);
        View topChild = parent.getChildAt(0);
        if (topChild == null || (topChildPosition = parent.getChildAdapterPosition(topChild)) == -1) {
            return;
        }
        int headerPos = this.mListener.getHeaderPositionForItem(Integer.valueOf(topChildPosition)).intValue();
        View currentHeader = getHeaderViewForItem(headerPos, parent);
        fixLayoutSize(parent, currentHeader);
        int contactPoint = currentHeader.getBottom();
        View childInContact = getChildInContact(parent, contactPoint, headerPos);
        if (childInContact != null && this.mListener.isHeader(Integer.valueOf(parent.getChildAdapterPosition(childInContact))).booleanValue()) {
            moveHeader(c, currentHeader, childInContact);
        } else {
            drawHeader(c, currentHeader);
        }
    }

    private View getHeaderViewForItem(int headerPosition, RecyclerView parent) {
        int layoutResId = this.mListener.getHeaderLayout(Integer.valueOf(headerPosition)).intValue();
        View header = LayoutInflater.from(parent.getContext()).inflate(layoutResId, (ViewGroup) parent, false);
        this.mListener.bindHeaderData(header, Integer.valueOf(headerPosition));
        return header;
    }

    private void drawHeader(Canvas c, View header) {
        c.save();
        c.translate(0.0f, 0.0f);
        header.draw(c);
        c.restore();
    }

    private void moveHeader(Canvas c, View currentHeader, View nextHeader) {
        c.save();
        c.translate(0.0f, nextHeader.getTop() - currentHeader.getHeight());
        currentHeader.draw(c);
        c.restore();
    }

    private View getChildInContact(RecyclerView parent, int contactPoint, int currentHeaderPos) {
        int childBottomPosition;
        for (int i = 0; i < parent.getChildCount(); i++) {
            int heightTolerance = 0;
            View child = parent.getChildAt(i);
            if (currentHeaderPos != i) {
                boolean isChildHeader = this.mListener.isHeader(Integer.valueOf(parent.getChildAdapterPosition(child))).booleanValue();
                if (isChildHeader) {
                    heightTolerance = this.mHeaderHeight.intValue() - child.getHeight();
                }
            }
            if (child.getTop() > 0) {
                childBottomPosition = child.getBottom() + heightTolerance;
            } else {
                childBottomPosition = child.getBottom();
            }
            if (childBottomPosition > contactPoint && child.getTop() <= contactPoint) {
                return child;
            }
        }
        return null;
    }

    private void fixLayoutSize(ViewGroup parent, View view) {
        int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), 0);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, parent.getPaddingLeft() + parent.getPaddingRight(), view.getLayoutParams().width);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, parent.getPaddingTop() + parent.getPaddingBottom(), view.getLayoutParams().height);
        view.measure(childWidthSpec, childHeightSpec);
        int measuredWidth = view.getMeasuredWidth();
        Integer numValueOf = Integer.valueOf(view.getMeasuredHeight());
        this.mHeaderHeight = numValueOf;
        view.layout(0, 0, measuredWidth, numValueOf.intValue());
    }
}
