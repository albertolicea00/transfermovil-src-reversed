package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class Ytn7eH8pGB extends AppCompatAutoCompleteTextView {
    private int myThreshold;

    public Ytn7eH8pGB(Context context) {
        super(context);
    }

    public Ytn7eH8pGB(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public Ytn7eH8pGB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setThreshold(int threshold) {
        if (threshold < 0) {
            threshold = 0;
        }
        this.myThreshold = threshold;
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return getText().length() >= this.myThreshold;
    }

    @Override // android.widget.AutoCompleteTextView
    public int getThreshold() {
        return this.myThreshold;
    }
}
