package com.jjshouse.kotlinmvvpdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.jjshouse.kotlinmvvpdemo.R;

/**
 * PackageName: com.veryvoga.vv.ui.widget
 * Created by xbzhang on 2019/1/24
 * Description:
 */
public class CustomImageView extends AppCompatImageView {
    private float ratio;
    public CustomImageView(Context context) {
        super(context);
        init(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        ratio = typedArray.getFloat(R.styleable.CustomImageView_ratio, 0.0f);
        init(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取宽度的模式和尺寸
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        //获取高度的模式和尺寸
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        //宽确定，高不确定
//        if(widthMode == MeasureSpec.EXACTLY&&heightMode!=MeasureSpec.EXACTLY&&ratio!=0){
//            heightSize = (int) (widthSize*ratio+0.5f);//根据宽度和比例计算高度
//            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
//        }else if(widthMode!=MeasureSpec.EXACTLY&&heightMode==MeasureSpec.EXACTLY&ratio!=0){
//            widthSize = (int) (heightSize/ratio+0.5f);
//            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize,MeasureSpec.EXACTLY);
//        }else{
//            throw new RuntimeException("无法设定宽高比");
//        }

        if(ratio!=0){
            heightSize = (int) (widthSize*ratio+0.5f);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(heightSize, View.MeasureSpec.EXACTLY);

        }
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    public void setRatio(float ratio){
        this.ratio = ratio;
    }
}
