package org.cchao.imagepreviewlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.core.frame.widget.rtl.RtlViewPager;


/**
 * Created by shucc on 17/2/24.
 * cc@cchao.org
 */
class HackyViewPager extends RtlViewPager {

    public HackyViewPager(Context context) {
        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}

