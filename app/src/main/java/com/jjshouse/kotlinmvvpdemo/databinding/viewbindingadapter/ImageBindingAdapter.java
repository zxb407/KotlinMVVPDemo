package com.jjshouse.kotlinmvvpdemo.databinding.viewbindingadapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.core.frame.utils.glideutils.GlideUtil;
import com.core.frame.utils.glideutils.options.GlideOptionsFactory;

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.databinding.bindingadapter
 * Created by xbzhang on 2020/1/7
 * Description:
 */
public class ImageBindingAdapter {
    @BindingAdapter(value = {"imageUrl"}, requireAll = true)
    public static void setImageUrl(ImageView view, String url) {
        GlideUtil.display(view.getContext(), view, url, GlideOptionsFactory.INSTANCE.get(GlideOptionsFactory.Type.LOGO));
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
