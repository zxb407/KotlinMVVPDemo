package org.cchao.imagepreviewlib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

/**
 * Created by shucc on 17/12/6.
 * cc@cchao.org
 */
public class ImagePreviewBuilder {

    private final String TAG = getClass().getName();

    private AppCompatActivity activity;

    private Intent intent;

    private Pair<View, String> pair;

    private int enterPosition;

    private ImagePreviewExitListener imagePreviewExitListener;

    private static ImagePreviewSelectListener imagePreviewSelectListener;

    private static int exitPosition;

    private ImagePreviewBuilder(AppCompatActivity activity) {
        this.activity = activity;
        intent = new Intent(activity, ImagePreviewActivity.class);
    }

    public static ImagePreviewBuilder from(@NonNull AppCompatActivity activity) {
        return new ImagePreviewBuilder(activity);
    }

    public static ImagePreviewBuilder from(@NonNull Fragment fragment) {
        return new ImagePreviewBuilder((AppCompatActivity) fragment.getActivity());
    }

    public ImagePreviewBuilder setInitPosition(int initPosition) {
        intent.putExtra(ImagePreviewActivity.EXTRA_IMAGE_INDEX, initPosition);
        enterPosition = initPosition;
        return this;
    }

    public ImagePreviewBuilder setTag(@NonNull String tag) {
        intent.putExtra(ImagePreviewActivity.EXTRA_IMAGE_TAG, tag);
        return this;
    }

    public ImagePreviewBuilder setImageUrlArray(@NonNull List<String> urls) {
        intent.putStringArrayListExtra(ImagePreviewActivity.EXTRA_IMAGE_URLS, (ArrayList<String>) urls);
        return this;
    }

    public ImagePreviewBuilder setImageIntroduce(@NonNull String text){
        intent.putExtra(ImagePreviewActivity.EXTRA_IMAGE_INTRODUCE, text);
        return this;
    }

    public ImagePreviewBuilder setPairView(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.pair = Pair.create(view, view.getTransitionName());
        }
        return this;
    }

    public ImagePreviewBuilder setImagePreviewExitListener(@NonNull ImagePreviewExitListener imagePreviewExitListener) {
        this.imagePreviewExitListener = imagePreviewExitListener;
        return this;
    }

    public ImagePreviewBuilder setImagePreviewSelectListener(@NonNull ImagePreviewSelectListener imagePreviewSelectListener) {
        this.imagePreviewSelectListener = imagePreviewSelectListener;
        return this;
    }

    public void startActivity() {
        if (null != pair && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            activity.startActivity(intent, optionsCompat.toBundle());
            setSharedElementCallback();
        } else {
            activity.startActivity(intent);
        }
    }
    public void startActivityForResult() {
        if (null != pair && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            activity.startActivityForResult(intent, 223,optionsCompat.toBundle());
            setSharedElementCallback();
            activity.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
    }

    @TargetApi(21)
    private void setSharedElementCallback() {
        activity.setExitSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                if (exitPosition != enterPosition) {
                    View view = imagePreviewExitListener.exitView(exitPosition);
                    names.clear();
                    sharedElements.clear();
                    names.add(view.getTransitionName());
                    sharedElements.put(view.getTransitionName(), view);
                }
                activity.setExitSharedElementCallback((SharedElementCallback) null);
            }
        });
    }

    protected static void setExitPosition(int exitPosition) {
        ImagePreviewBuilder.exitPosition = exitPosition;
    }

    @TargetApi(21)
    public static void onActivityReenter(final Activity activity, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        activity.postponeEnterTransition();
        activity.getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onPreDraw() {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
                activity.startPostponedEnterTransition();
                return false;
            }
        });
    }

    protected static ImagePreviewSelectListener getImagePreviewSelectListener() {
        return imagePreviewSelectListener;
    }

}
