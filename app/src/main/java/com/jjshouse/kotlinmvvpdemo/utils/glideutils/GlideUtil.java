package com.jjshouse.kotlinmvvpdemo.utils.glideutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.jjshouse.kotlinmvvpdemo.JJApplication;
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.options.GlideOptions;
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.options.GlideOptionsFactory;

public class GlideUtil {

    public static void display(Context context, ImageView imageView, String url) {
        display(context, imageView, url, GlideOptionsFactory.get(GlideOptionsFactory.Type.DEFAULT));
    }

    public static void display(Context context, ImageView imageView, String url, GlideOptions op) {
        if (context == null) {
            return;
        }
        if (context instanceof AppCompatActivity) {
            display((AppCompatActivity) context, imageView, url, op);
            return;
        }

        RequestBuilder<Drawable> builder = Glide.with(context).load(url);
        display(builder, imageView, op);
    }

    public static void display(AppCompatActivity activity, ImageView imageView, String url) {
        display(activity, imageView, url, GlideOptionsFactory.get(GlideOptionsFactory.Type.DEFAULT));
    }

    public static void display(AppCompatActivity activity, ImageView imageView, String url, GlideOptions op) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        RequestBuilder<Drawable> builder = Glide.with(activity).load(url);
        display(builder, imageView, op);
    }

    public static void display(Fragment fragment, ImageView imageView, String url) {
        display(fragment, imageView, url, GlideOptionsFactory.get(GlideOptionsFactory.Type.DEFAULT));
    }

    public static void display(Fragment fragment, ImageView imageView, String url, GlideOptions op) {
        if (fragment == null || fragment.isRemoving() || fragment.getActivity() == null) {
            return;
        }
        RequestBuilder<Drawable> builder = Glide.with(fragment).load(url);
        display(builder, imageView, op);
    }

    /**
     *
     * @param builder
     * @param imageView
     * @param op
     */
    @SuppressLint("CheckResult")
    public static void display(RequestBuilder<Drawable> builder, ImageView imageView, GlideOptions op) {
        RequestOptions options = new RequestOptions()
                .placeholder(op.getReplaceImage())
                .error(op.getReplaceImage())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);
        if (op.getDoAnimate()) {
            builder.transition(DrawableTransitionOptions.withCrossFade());
        }
        builder.apply(options).into(imageView);
    }

    public static void clearMemoryCache() {
        Glide.get(JJApplication.instance.getApplicationContext()).clearMemory();
    }

    public static void clearDiskCache() {
        Glide.get(JJApplication.instance.getApplicationContext()).clearDiskCache();
    }
}
