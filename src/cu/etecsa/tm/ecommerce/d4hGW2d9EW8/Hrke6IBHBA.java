package cu.etecsa.tm.ecommerce.d4hGW2d9EW8;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class Hrke6IBHBA extends AppCompatAutoCompleteTextView implements AdapterView.OnItemClickListener {
    private static final int MAX_CLICK_DURATION = 200;
    private Context context;
    private boolean isPopup;
    public OnItemClickListener mItemClickListener;
    private int position_select;
    private long startClickTime;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public Hrke6IBHBA(Context context) {
        super(context);
        setOnItemClickListener(this);
    }

    public Hrke6IBHBA(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        setOnItemClickListener(this);
    }

    public Hrke6IBHBA(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
        setOnItemClickListener(this);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        try {
            if (focused) {
                performFiltering(BuildConfig.FLAVOR, 0);
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
                setKeyListener(null);
                dismissDropDown();
            } else {
                this.isPopup = false;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        try {
            switch (event.getAction()) {
                case 0:
                    this.startClickTime = Calendar.getInstance().getTimeInMillis();
                    break;
                case 1:
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - this.startClickTime;
                    if (clickDuration < 200) {
                        if (this.isPopup) {
                            dismissDropDown();
                            this.isPopup = false;
                        } else {
                            requestFocus();
                            showDropDown();
                            this.isPopup = true;
                        }
                    }
                    break;
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.isPopup = false;
        this.position_select = i;
        OnItemClickListener onItemClickListener = this.mItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        Drawable dropdownIcon = ContextCompat.getDrawable(getContext(), R.drawable.abc_textfield_search_material);
        if (dropdownIcon != null) {
            right = dropdownIcon;
            right.mutate().setAlpha(RecyclerView.ViewHolder.FLAG_IGNORE);
        }
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    }

    public int getPosition_select() {
        return this.position_select;
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
