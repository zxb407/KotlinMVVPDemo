package com.core.frame.crash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/core/frame/crash/ICrashHandler;", "", "reportError", "", "context", "Landroid/content/Context;", "e", "", "error", "", "lib_core_frame_debug"})
public abstract interface ICrashHandler {
    
    /**
     * Report error.
     * @param context context
     * @param e       [Throwable]
     * @param error   message
     */
    public abstract void reportError(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable e, @org.jetbrains.annotations.NotNull()
    java.lang.String error);
}