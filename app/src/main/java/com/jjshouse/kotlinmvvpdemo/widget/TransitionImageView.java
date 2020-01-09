package com.jjshouse.kotlinmvvpdemo.widget;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.widget
 * Created by xbzhang on 2020/1/8
 * Description:
 */
public class TransitionImageView extends AppCompatImageView {

    public TransitionImageView(Context context) {
        super(context);
    }

    public TransitionImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TransitionImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                if (getDrawable() instanceof TransitionDrawable){
                    ((TransitionDrawable)getDrawable()).reverseTransition(300);
                }
                break;
            default:
                return super.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
}
