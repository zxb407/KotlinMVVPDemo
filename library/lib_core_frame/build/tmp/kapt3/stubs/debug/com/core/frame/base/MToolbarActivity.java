package com.core.frame.base;

import java.lang.System;

/**
 * Package:com.dding.base.framework
 * Date:2018/12/28
 * Author:dding
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/core/frame/base/MToolbarActivity;", "Lcom/core/frame/base/MActivity;", "()V", "onCreateToolbarLayout", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "setContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "", "useDefaultToolBar", "", "lib_core_frame_debug"})
public abstract class MToolbarActivity extends com.core.frame.base.MActivity {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Overide this method and pass your content view with toolbar.
     *
     * @param inflater [LayoutInflater]
     * @return Content view with toolbar.
     */
    @org.jetbrains.annotations.NotNull()
    public android.view.ViewGroup onCreateToolbarLayout(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater) {
        return null;
    }
    
    @java.lang.Override()
    public void setContentView(int layoutResID) {
    }
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    public abstract boolean useDefaultToolBar();
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    public MToolbarActivity() {
        super();
    }
}