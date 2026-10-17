package cu.etecsa.transfermovil.ui.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import java.util.Calendar;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX
 * @fingerprint AutoCompleteTextView acting as a dropdown spinner. When accessibility
 *              (TalkBack) is enabled, shows an AlertDialog instead of the dropdown popup.
 *              Hides keyboard on focus, uses click duration threshold (200ms) to toggle popup.
 */
public class DropdownSpinnerView extends AutoCompleteTextView
        implements AdapterView.OnItemClickListener {

    private static final int MAX_CLICK_DURATION = 200;
    public AccessibilityManager accessibilityManager;
    private Context context;
    private boolean isPopup;
    public ListAdapter listAdapter;
    public OnItemClickListener mItemClickListener;
    private int position_select;
    private long startClickTime;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public DropdownSpinnerView(Context context) {
        super(context);
        init(context);
    }

    public DropdownSpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropdownSpinnerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setOnItemClickListener(this);
        this.context = context;
        AccessibilityManager am = (AccessibilityManager) context.getSystemService("accessibility");
        this.accessibilityManager = am;
        if (am.isTouchExplorationEnabled()) {
            setFocusable(true);
            setClickable(true);
        }
        try {
            if (this.listAdapter == null) {
                this.listAdapter = getAdapter();
            }
        } catch (Exception e) {
            this.listAdapter = null;
        }
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        try {
            if (focused) {
                performFiltering("", 0);
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
                setKeyListener(null);
                dismissDropDown();
                if (this.accessibilityManager.isTouchExplorationEnabled()) {
                    if (this.listAdapter == null) {
                        this.listAdapter = getAdapter();
                    }
                    showDialogOptions();
                }
            } else {
                this.isPopup = false;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                if (this.listAdapter != null) {
                    this.listAdapter = getAdapter();
                }
                showDialogOptions();
            }
        } catch (Exception e) {
        }
        try {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    this.startClickTime = Calendar.getInstance().getTimeInMillis();
                    break;
                case MotionEvent.ACTION_UP:
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - this.startClickTime;
                    if (clickDuration < MAX_CLICK_DURATION) {
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.isPopup = false;
        this.position_select = i;
        OnItemClickListener listener = this.mItemClickListener;
        if (listener != null) {
            listener.onItemClick(view, i);
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(
            Drawable left, Drawable top, Drawable right, Drawable bottom) {
        Drawable dropdownIcon = ContextCompat.getDrawable(getContext(),
                android.R.drawable.ic_menu_more);
        if (dropdownIcon != null) {
            right = dropdownIcon;
            right.mutate().setAlpha(128);
        }
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    }

    public int getPosition_select() {
        return this.position_select;
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private void showDialogOptions() {
        ListAdapter adapter = this.listAdapter;
        if (adapter != null) {
            CharSequence[] items = new CharSequence[adapter.getCount()];
            for (int i = 0; i < adapter.getCount(); i++) {
                items[i] = adapter.getItem(i).toString();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Seleccione una opción: ");
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    OnItemClickListener listener = mItemClickListener;
                    if (listener != null) {
                        listener.onItemClick(getRootView(), i);
                        setText(listAdapter.getItem(i).toString());
                        dialogInterface.dismiss();
                        dismissDropDown();
                    }
                }
            });
            builder.setNegativeButton("Cerrar", (dialog, id) -> {});
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
