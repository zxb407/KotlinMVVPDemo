package com.core.frame.crash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H$J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/core/frame/crash/BaseCrashhandler;", "Lcom/core/frame/crash/ICrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isMainThread", "", "()Z", "handleUncaughtException", "", "thread", "Ljava/lang/Thread;", "ex", "", "mainthread", "formatedMessage", "", "showAlertDialog", "uncaughtException", "Companion", "lib_core_frame_debug"})
public abstract class BaseCrashhandler implements com.core.frame.crash.ICrashHandler, java.lang.Thread.UncaughtExceptionHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private static final java.lang.String ERROR_FORMATER = "[androidcrash] [%s] [%s], message: %s; stacktrace: %s.";
    public static final com.core.frame.crash.BaseCrashhandler.Companion Companion = null;
    
    private final boolean isMainThread() {
        return false;
    }
    
    /**
     * Handle the uncaught exception.
     *
     * @param thread          [Thread]
     * @param ex              [Throwable]
     * @param mainthread      wheather the main thread
     * @param formatedMessage formated message
     */
    protected abstract void handleUncaughtException(@org.jetbrains.annotations.NotNull()
    java.lang.Thread thread, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable ex, boolean mainthread, @org.jetbrains.annotations.NotNull()
    java.lang.String formatedMessage);
    
    /**
     * Show the alert dialog
     *
     * @param context
     */
    private final void showAlertDialog(android.content.Context context) {
    }
    
    /**
     * The thread is being terminated by an uncaught exception. Further
     * exceptions thrown in this method are prevent the remainder of the
     * method from executing, but are otherwise ignored.
     *
     * @param thread the thread that has an uncaught exception
     * @param ex     the exception that was thrown
     */
    @java.lang.Override()
    public void uncaughtException(@org.jetbrains.annotations.NotNull()
    java.lang.Thread thread, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable ex) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getContext() {
        return null;
    }
    
    public BaseCrashhandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/core/frame/crash/BaseCrashhandler$Companion;", "", "()V", "ERROR_FORMATER", "", "lib_core_frame_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}