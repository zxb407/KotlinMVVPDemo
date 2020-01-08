package com.core.frame.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/core/frame/utils/SystemUtils;", "", "()V", "hideInputMethod", "", "context", "Landroid/content/Context;", "v", "Landroid/view/View;", "isInputMethodActive", "", "showInputMethod", "toggleInputMethod", "lib_core_frame_debug"})
public final class SystemUtils {
    public static final com.core.frame.utils.SystemUtils INSTANCE = null;
    
    /**
     * 切换输入法显示状态, 如果输入法已显示, 则隐藏输入法, 反之则显示输入法.
     *
     * @param context
     */
    public final void toggleInputMethod(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void showInputMethod(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void showInputMethod(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void hideInputMethod(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void hideInputMethod(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final boolean isInputMethodActive(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private SystemUtils() {
        super();
    }
}