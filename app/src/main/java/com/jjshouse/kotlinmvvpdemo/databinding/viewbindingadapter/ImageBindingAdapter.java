package com.jjshouse.kotlinmvvpdemo.databinding.viewbindingadapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.GlideUtil;
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.options.GlideOptionsFactory;

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.databinding.viewbindingadapter
 * Created by xbzhang on 2020/1/9
 * Description:
 */
public class ImageBindingAdapter {
    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView view , String url) {
        GlideUtil.display(view.getContext(), view, url, GlideOptionsFactory.INSTANCE.get(GlideOptionsFactory.Type.THUMBNAIL));
    }

    @BindingAdapter({"imageSrc"})
    public static void setImageUrl(ImageView view, int src) {
        view.setImageResource(src);
    }

    @BindingAdapter({"imageBitmap"})
    public static void setImageUrl(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
}
