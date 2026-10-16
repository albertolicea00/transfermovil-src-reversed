package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.V6JQkNZYoP2.vwtSdi7ika;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class rRvXcuGxBE implements DialogInterface.OnClickListener {
    private static final int MAX_YEAR = 2099;
    private static final int MIN_YEAR = 1970;
    private static final String[] MONTHS_LIST = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private Calendar currentCalendar;
    private final Context mContext;
    private AlertDialog mDialog;
    private AlertDialog.Builder mDialogBuilder;
    private int mMonth;
    private OnDateSetListener mOnDateSetListener;
    private int mTextTitleColor;
    private int mTheme;
    private int mYear;

    public interface OnDateSetListener {
        void onYearMonthSet(int i, int i2);
    }

    public rRvXcuGxBE(Context context, Calendar calendar, OnDateSetListener onDateSetListener) {
        this(context, calendar, onDateSetListener, -1, -1);
    }

    public rRvXcuGxBE(Context context, Calendar calendar, OnDateSetListener onDateSetListener, int theme) {
        this(context, calendar, onDateSetListener, theme, -1);
    }

    public rRvXcuGxBE(Context context, Calendar calendar, OnDateSetListener onDateSetListener, int theme, int titleTextColor) {
        this.mContext = context;
        this.mOnDateSetListener = onDateSetListener;
        this.mTheme = theme;
        this.mTextTitleColor = titleTextColor;
        this.currentCalendar = calendar;
        build();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case -2:
                dialog.cancel();
                break;
            case -1:
                OnDateSetListener onDateSetListener = this.mOnDateSetListener;
                if (onDateSetListener != null) {
                    onDateSetListener.onYearMonthSet(this.mYear, this.mMonth);
                }
                break;
        }
    }

    private void build() {
        int currentTheme = this.mTheme;
        if (currentTheme == -1) {
            currentTheme = R.style.MyDialogTheme;
        }
        this.mDialogBuilder = new AlertDialog.Builder(this.mContext, currentTheme);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        View titleView = layoutInflater.inflate(R.layout.e4v0rmooslnmy, (ViewGroup) null, false);
        View contentView = layoutInflater.inflate(R.layout.ozczpppa0uwsv, (ViewGroup) null, false);
        NumberPicker yearPicker = (NumberPicker) contentView.findViewById(R.id.year_picker);
        NumberPicker monthPicker = (NumberPicker) contentView.findViewById(R.id.month_picker);
        TextView monthName = (TextView) titleView.findViewById(R.id.month_name);
        TextView yearValue = (TextView) titleView.findViewById(R.id.year_name);
        if (this.mTextTitleColor != -1) {
            setTextColor(monthName);
            setTextColor(yearValue);
        }
        this.mDialogBuilder.setCustomTitle(titleView);
        this.mDialogBuilder.setView(contentView);
        yearPicker.setMinValue(MIN_YEAR);
        yearPicker.setMaxValue(MAX_YEAR);
        monthPicker.setMinValue(0);
        String[] strArr = MONTHS_LIST;
        monthPicker.setMaxValue(strArr.length - 1);
        monthPicker.setDisplayedValues(strArr);
        setCurrentDate(this.currentCalendar, yearPicker, monthPicker, monthName, yearValue);
        setListeners(yearPicker, monthPicker, monthName, yearValue);
        this.mDialogBuilder.setPositiveButton("OK", this);
        this.mDialogBuilder.setNegativeButton("CANCELAR", this);
        this.mDialog = this.mDialogBuilder.create();
    }

    private void setTextColor(TextView titleView) {
        titleView.setTextColor(ContextCompat.getColor(this.mContext, this.mTextTitleColor));
    }

    private void setCurrentDate(vwtSdi7ika yearPicker, vwtSdi7ika monthPicker, TextView monthName, TextView yearValue) {
        Calendar calendar = Calendar.getInstance();
        this.mMonth = calendar.get(2);
        this.mYear = calendar.get(1);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        monthName.setText(monthFormat.format(calendar.getTime()));
        yearValue.setText(Integer.toString(this.mYear));
        monthPicker.setValue(this.mMonth);
        yearPicker.setValue(this.mYear);
    }

    private void setCurrentDate(Calendar calendar, NumberPicker yearPicker, NumberPicker monthPicker, TextView monthName, TextView yearValue) {
        this.mMonth = calendar.get(2);
        this.mYear = calendar.get(1);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        monthName.setText(monthFormat.format(calendar.getTime()));
        yearValue.setText(Integer.toString(this.mYear));
        monthPicker.setValue(this.mMonth);
        yearPicker.setValue(this.mYear);
    }

    private void setListeners(final NumberPicker yearPicker, final NumberPicker monthPicker, final TextView monthName, final TextView yearValue) {
        monthName.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (monthPicker.getVisibility() == 8) {
                    monthPicker.setVisibility(0);
                    yearPicker.setVisibility(8);
                    yearValue.setAlpha(0.39f);
                    monthName.setAlpha(1.0f);
                }
            }
        });
        yearValue.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (yearPicker.getVisibility() == 8) {
                    yearPicker.setVisibility(0);
                    monthPicker.setVisibility(8);
                    monthName.setAlpha(0.39f);
                    yearValue.setAlpha(1.0f);
                }
            }
        });
        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE.3
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                rRvXcuGxBE.this.mMonth = newVal;
                monthName.setText(rRvXcuGxBE.MONTHS_LIST[newVal]);
            }
        });
        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE.4
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                rRvXcuGxBE.this.mYear = newVal;
                yearValue.setText(Integer.toString(newVal));
            }
        });
    }

    public void show() {
        this.mDialog.show();
    }
}
