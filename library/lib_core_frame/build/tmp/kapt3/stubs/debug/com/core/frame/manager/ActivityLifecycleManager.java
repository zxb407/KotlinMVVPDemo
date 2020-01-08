package com.core.frame.manager;

import java.lang.System;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/27
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/core/frame/manager/ActivityLifecycleManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "activityCount", "", "foreground", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/core/frame/manager/ActivityLifecycleManager$AppStateListener;", "sCurrentActivityWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "totalActivityCount", "addListener", "", "listener", "getCurrentActivity", "isBackground", "isForeground", "onActivityCreated", "activity", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "removeListener", "AppStateListener", "Companion", "lib_core_frame_debug"})
public final class ActivityLifecycleManager implements android.app.Application.ActivityLifecycleCallbacks {
    private int totalActivityCount;
    private int activityCount;
    private boolean foreground;
    private java.lang.ref.WeakReference<android.app.Activity> sCurrentActivityWeakRef;
    private final java.util.concurrent.CopyOnWriteArrayList<com.core.frame.manager.ActivityLifecycleManager.AppStateListener> listeners = null;
    private static com.core.frame.manager.ActivityLifecycleManager instance;
    public static final com.core.frame.manager.ActivityLifecycleManager.Companion Companion = null;
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    android.os.Bundle p1) {
    }
    
    @java.lang.Override()
    public void onActivityStarted(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onActivitySaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.os.Bundle p1) {
    }
    
    @java.lang.Override()
    public void onActivityResumed(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onActivityPaused(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onActivityStopped(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onActivityDestroyed(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final boolean isForeground() {
        return false;
    }
    
    public final boolean isBackground() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.Activity getCurrentActivity() {
        return null;
    }
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    com.core.frame.manager.ActivityLifecycleManager.AppStateListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    com.core.frame.manager.ActivityLifecycleManager.AppStateListener listener) {
    }
    
    public ActivityLifecycleManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/core/frame/manager/ActivityLifecycleManager$AppStateListener;", "", "onBecameBackground", "", "onBecameForeground", "lib_core_frame_debug"})
    public static abstract interface AppStateListener {
        
        public abstract void onBecameForeground();
        
        public abstract void onBecameBackground();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/core/frame/manager/ActivityLifecycleManager$Companion;", "", "()V", "instance", "Lcom/core/frame/manager/ActivityLifecycleManager;", "get", "application", "Landroid/app/Application;", "ctx", "Landroid/content/Context;", "init", "lib_core_frame_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.ActivityLifecycleManager init(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.core.frame.manager.ActivityLifecycleManager get(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.ActivityLifecycleManager get(@org.jetbrains.annotations.NotNull()
        android.content.Context ctx) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.ActivityLifecycleManager get() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}