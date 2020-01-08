package com.jjshouse.kotlinmvvpdemo.utils.glideutils.options;

import android.content.res.Resources;
import com.jjshouse.kotlinmvvpdemo.R;

import java.util.HashMap;

public class GlideOptionsFactory {
    private static HashMap<Type, GlideOptions> mOptions;

    private GlideOptionsFactory() {
    }

    private static void init() {
        if (mOptions == null) {
            mOptions = new HashMap<>();
            mOptions.put(Type.DEFAULT, new GlideOptions(R.drawable.ic_black_placeholder, true));
            mOptions.put(Type.LOGO, new GlideOptions(R.mipmap.ic_launcher, true));
        }
    }

    public static GlideOptions get(Type type) {
        init();
        if (mOptions.containsKey(type)) {
            return mOptions.get(type);
        }

        throw new IllegalArgumentException();
    }

    public enum Type {
        DEFAULT(1), LOGO(2);
        private int type;

        private Type(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "type:" + type;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
