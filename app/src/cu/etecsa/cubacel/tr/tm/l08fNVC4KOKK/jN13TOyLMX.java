package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

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
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class jN13TOyLMX extends AutoCompleteTextView implements AdapterView.OnItemClickListener {
    private static final int MAX_CLICK_DURATION = 200;
    public AccessibilityManager accessibilityManager;
    private Context context;
    private boolean isPopup;
    public ListAdapter listAdapter;
    public OnItemClickListener mItemClickListener;
    private int position_select;
    private long startClickTime;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public jN13TOyLMX(Context context) {
        super(context);
        setOnItemClickListener(this);
        this.context = context;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (accessibilityManager.isTouchExplorationEnabled()) {
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

    public jN13TOyLMX(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        setOnItemClickListener(this);
        this.context = arg0;
        AccessibilityManager accessibilityManager = (AccessibilityManager) arg0.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (accessibilityManager.isTouchExplorationEnabled()) {
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

    public jN13TOyLMX(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
        setOnItemClickListener(this);
        this.context = arg0;
        AccessibilityManager accessibilityManager = (AccessibilityManager) arg0.getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (accessibilityManager.isTouchExplorationEnabled()) {
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
                if (this.accessibilityManager.isTouchExplorationEnabled()) {
                    if (this.listAdapter == null) {
                        this.listAdapter = getAdapter();
                    }
                    showDialogUltimasOperaciones();
                }
                return;
            }
            this.isPopup = false;
        } catch (Exception e) {
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        try {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                if (this.listAdapter != null) {
                    this.listAdapter = getAdapter();
                }
                showDialogUltimasOperaciones();
            }
        } catch (Exception e) {
        }
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
        } catch (Exception e2) {
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

    private void showDialogUltimasOperaciones() {
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            CharSequence[] items = new CharSequence[listAdapter.getCount()];
            for (int i = 0; i < this.listAdapter.getCount(); i++) {
                items[i] = this.listAdapter.getItem(i).toString();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Seleccione una opción: ");
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    jN13TOyLMX jn13toylmx = jN13TOyLMX.this;
                    OnItemClickListener onItemClickListener = jn13toylmx.mItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(jn13toylmx.getRootView(), i2);
                        jN13TOyLMX jn13toylmx2 = jN13TOyLMX.this;
                        jn13toylmx2.setText(jn13toylmx2.listAdapter.getItem(i2).toString());
                        dialogInterface.dismiss();
                        jN13TOyLMX.this.dismissDropDown();
                    }
                }
            });
            builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
