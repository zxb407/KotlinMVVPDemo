package com.core.frame.manager;

import java.lang.System;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description: manage activity
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\r\u001a\u00020\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/core/frame/manager/AppActivityManager;", "", "()V", "topActivity", "Landroid/app/Activity;", "getTopActivity", "()Landroid/app/Activity;", "AppExit", "", "context", "Landroid/content/Context;", "addActivity", "activity", "killActivity", "cls", "Ljava/lang/Class;", "killAllActivity", "killTopActivity", "removeActivity", "Companion", "lib_core_frame_debug"})
public final class AppActivityManager {
    private static java.util.Stack<android.app.Activity> mActivityStack;
    private static com.core.frame.manager.AppActivityManager mAppManager;
    public static final com.core.frame.manager.AppActivityManager.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getTopActivity() {
        return null;
    }
    
    /**
     * add activity
     */
    public final void addActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    /**
     * remove activity
     */
    public final void removeActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    /**
     * kill top Activity
     */
    public final void killTopActivity() {
    }
    
    /**
     * kill specfic Activity
     */
    private final void killActivity(android.app.Activity activity) {
    }
    
    /**
     * kill specfic Activity
     */
    public final void killActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cls) {
    }
    
    /**
     * kill all Activity
     */
    public final void killAllActivity() {
    }
    
    /**
     * exit app
     */
    public final void AppExit(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private AppActivityManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/core/frame/manager/AppActivityManager$Companion;", "", "()V", "instance", "Lcom/core/frame/manager/AppActivityManager;", "getInstance", "()Lcom/core/frame/manager/AppActivityManager;", "mActivityStack", "Ljava/util/Stack;", "Landroid/app/Activity;", "mAppManager", "lib_core_frame_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.AppActivityManager getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}