package com.jjshouse.kotlinmvvpdemo.databinding.bindingadapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.GlideUtil;

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.databinding.bindingadapter
 * Created by xbzhang on 2020/1/7
 * Description:
 */
public class ImageBindingAdapter {
    @BindingAdapter(value = {"imageUrl"}, requireAll = true)
    public static void setImageUrl(ImageView view, String url) {
        GlideUtil.display(view.getContext(), view, url);
    }

    @BindingAdapter(value = {"imageSrc"}, requireAll = true)
    public static void setImageSrc(ImageView view, int src) {
        view.setImageResource(src);
    }

    @BindingAdapter(value = {"imageBitmap"}, requireAll = true)
    public static void setImageBitmap(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
}
