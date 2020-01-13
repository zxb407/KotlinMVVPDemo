package com.veryvoga.datepicker;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.veryvoga.datepicker.listener.OnItemSelectedListener;
import com.veryvoga.datepicker.view.WheelView;

import java.util.Calendar;
import java.util.Date;


public class DatePickerPop extends PopupWindow {

    private final int OPEN_POP = 1;
    private final int HIDE_POP = 2;
    private final int MIN_YEAR = 1900;
    private final int MAX_YEAR = 2100;

    private TextView textCancel;
    private TextView textApply;
    private WheelView wvMonth;
    private WheelView wvYear;

    private Activity activity;

    private int nowYear;
    private int nowMonth;
    private Calendar calendar;

    private OnDateSelectListener onDateSelectListener;

    public DatePickerPop(Activity activity) {
        this(activity, 0, 0);
    }

    public DatePickerPop(Activity activity, int nowYear, int nowMonth) {
        super(activity);
        setAnimationStyle(R.style.Pop_Bottom_Style);
        this.activity = activity;
        this.nowYear = nowYear;
        this.nowMonth = nowMonth;

        View view = LayoutInflater.from(activity).inflate(R.layout.pop_date_picker, null);
        textCancel = view.findViewById(R.id.text_cancel);
        textApply = view.findViewById(R.id.text_apply);
        wvMonth = view.findViewById(R.id.lv_month);
        wvYear = view.findViewById(R.id.lv_year);

        setTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        initData();
        bindEvent();
    }

    public void setOnDateSelectListener(OnDateSelectListener onDateSelectListener) {
        this.onDateSelectListener = onDateSelectListener;
    }

    @Override
    public final void showAtLocation(View parent, int gravity, int x, int y) {
        setWindowAlpha(activity, OPEN_POP);
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public final void dismiss() {
        setWindowAlpha(activity, HIDE_POP);
        super.dismiss();
    }

    private void initData() {
        wvMonth.setTextXOffset(80);
        wvYear.setTextXOffset(-80);
        wvMonth.setTextSize(16);
        wvYear.setTextSize(16);
        wvMonth.setAdapter(new NumericWheelAdapter(1, 12));
        wvYear.setAdapter(new NumericWheelAdapter(MIN_YEAR, MAX_YEAR));
        if (nowYear < MIN_YEAR || nowYear > MAX_YEAR || nowMonth <= 0 || nowMonth > 12) {
            calendar = Calendar.getInstance();
            if (nowYear < MIN_YEAR || nowYear > MAX_YEAR) {
                nowYear = calendar.get(Calendar.YEAR);
            }
            if (nowMonth <= 0 || nowMonth > 12) {
                nowMonth = calendar.get(Calendar.MONTH) + 1;
            }
        }
        //月份会偏移一位
        wvMonth.setCurrentItem(nowMonth - 1);
        wvYear.setCurrentItem(nowYear - MIN_YEAR);
    }

    private void bindEvent() {
        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        textApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nowYear = wvYear.getCurrentItem() + MIN_YEAR;
                nowMonth = wvMonth.getCurrentItem() + 1;
                //增加与当前日期的比对，如果小于当前日期，弹toast提示
                if (nowYear < calendar.get(Calendar.YEAR) ||
                        (nowYear == calendar.get(Calendar.YEAR) && nowMonth - 1 < calendar.get(Calendar.MONTH))) {
                    Toast.makeText(activity, activity.getResources().getString(R.string.date_is_invalid), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (null != onDateSelectListener) {
                    onDateSelectListener.onSelect(nowYear, nowMonth);
                }
                dismiss();
            }
        });
        wvMonth.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                nowMonth = index + 1;
                if (null != onDateSelectListener) {
                    onDateSelectListener.onChange(nowYear, nowMonth);
                }
            }
        });
        wvYear.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                nowYear = index + MIN_YEAR;
                if (null != onDateSelectListener) {
                    onDateSelectListener.onChange(nowYear, nowMonth);
                }
            }
        });
    }

    /**
     * 设置弹出框出现与隐藏时背景透明度变化
     *
     * @param type
     */
    private void setWindowAlpha(Activity activity, int type) {
        //设置背景颜色变暗
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        if (type == OPEN_POP) {
            lp.alpha = 0.6f;
        } else {
            lp.alpha = 1.0f;
        }
        activity.getWindow().setAttributes(lp);
    }

    public interface OnDateSelectListener {

        void onSelect(int year, int month);

        void onChange(int year, int month);
    }
}
