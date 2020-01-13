package com.veryvoga.recycler.pullrefresh;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.pnikosis.materialishprogress.ProgressWheel;
import com.veryvoga.recycler.R;


/**
 * Created by Anthony on 2016/7/18.
 */
public class DefaultFooter extends BaseIndicator {
    private TextView mStringIndicator;
    private ProgressWheel progress_wheell;
    private int default_rim_color;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup parent) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.prj_ptr_footer_default, parent, true);
        View child = v.getChildAt(v.getChildCount() - 1);
        mStringIndicator = (TextView) child.findViewById(R.id.tv_footer);
        progress_wheell = (ProgressWheel) v.findViewById(R.id.progress_wheell);
        default_rim_color = progress_wheell.getRimColor();
        return child;
    }

    @Override
    public void onAction() {
        mStringIndicator.setText(R.string.head_loading);
    }

    @Override
    public void onUnaction() {
        mStringIndicator.setText(R.string.head_loading);
    }

    @Override
    public void onRestore() {
        mStringIndicator.setText(R.string.head_loading);
        progress_wheell.setRimColor(default_rim_color);
        progress_wheell.stopSpinning();
    }

    @Override
    public void onLoading() {
        mStringIndicator.setText(R.string.head_loading);
        progress_wheell.setRimColor(Color.parseColor("#00000000"));
        progress_wheell.spin();
    }

    @Override
    public void setIndicatorMode(int color){
        mStringIndicator.setTextColor(color);
        progress_wheell.setBarColor(color);
    }
}
