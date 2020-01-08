package com.core.frame.crash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/core/frame/crash/CustomCrashHandler;", "Lcom/core/frame/crash/BaseCrashhandler;", "context", "Landroid/content/Context;", "mHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "(Landroid/content/Context;Ljava/lang/Thread$UncaughtExceptionHandler;)V", "handleUncaughtException", "", "thread", "Ljava/lang/Thread;", "ex", "", "mainthread", "", "formatedMessage", "", "reportError", "e", "error", "lib_core_frame_debug"})
public final class CustomCrashHandler extends com.core.frame.crash.BaseCrashhandler {
    private final java.lang.Thread.UncaughtExceptionHandler mHandler = null;
    
    /**
     * Handle the uncaught exception.
     *
     * @param thread          [Thread]
     * @param ex              [Throwable]
     * @param formatedMessage formated message
     */
    @java.lang.Override()
    protected void handleUncaughtException(@org.jetbrains.annotations.NotNull()
    java.lang.Thread thread, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable ex, boolean mainthread, @org.jetbrains.annotations.NotNull()
    java.lang.String formatedMessage) {
    }
    
    /**
     * Report error.
     *
     * @param context context
     * @param e       [Throwable]
     * @param error   message
     */
    @java.lang.Override()
    public void reportError(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable e, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public CustomCrashHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.Thread.UncaughtExceptionHandler mHandler) {
        super(null);
    }
}