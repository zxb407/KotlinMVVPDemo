package com.core.frame.utils;

import java.lang.System;

/**
 * **Create Date:** 2018/3/5<br></br>
 * **Author:** Zhanglei<br></br>
 * **Description:** <br></br>
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u000fJ\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u0019\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006)"}, d2 = {"Lcom/core/frame/utils/UIUtils;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "isRunOnMainThread", "", "()Z", "mainThreadId", "", "getMainThreadId", "()I", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "dp2px", "dp", "getColor", "id", "getDimens", "getString", "", "getStringArrays", "", "(I)[Ljava/lang/String;", "inflate", "Landroid/view/View;", "post", "", "runnable", "Ljava/lang/Runnable;", "px2dp", "px", "runOnUiThread", "lib_core_frame_debug"})
public final class UIUtils {
    public static final com.core.frame.utils.UIUtils INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.res.Resources getResources() {
        return null;
    }
    
    public final boolean isRunOnMainThread() {
        return false;
    }
    
    public final int getMainThreadId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    /**
     * dp转换为px
     */
    public final int dp2px(int dp) {
        return 0;
    }
    
    /**
     * px转换为dp
     */
    public final int px2dp(int px) {
        return 0;
    }
    
    /**
     * 获取字符
     * @param id
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getString(int id) {
        return null;
    }
    
    /**
     * 获取字符数组
     *
     * @param id
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getStringArrays(int id) {
        return null;
    }
    
    /**
     * 获取颜色
     */
    public final int getColor(int id) {
        return 0;
    }
    
    /**
     * 根据id获取尺寸
     * @param id
     * @return
     */
    public final int getDimens(int id) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View inflate(int id) {
        return null;
    }
    
    public final void runOnUiThread(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    public final void post(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    private UIUtils() {
        super();
    }
}