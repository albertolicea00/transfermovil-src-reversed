package cu.etecsa.transfermovil.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.Ytn7eH8pGB
 * @fingerprint AutoCompleteTextView with configurable threshold (allows threshold=0).
 */
public class CustomAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private int myThreshold;

    public CustomAutoCompleteTextView(Context context) {
        super(context);
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setThreshold(int threshold) {
        if (threshold < 0) {
            threshold = 0;
        }
        this.myThreshold = threshold;
    }

    @Override
    public boolean enoughToFilter() {
        return getText().length() >= this.myThreshold;
    }

    @Override
    public int getThreshold() {
        return this.myThreshold;
    }
}
