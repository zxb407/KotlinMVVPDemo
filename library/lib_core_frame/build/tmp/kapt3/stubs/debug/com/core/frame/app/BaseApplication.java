package com.core.frame.app;

import java.lang.System;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/core/frame/app/BaseApplication;", "Landroid/app/Application;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "getMainHandler", "Landroid/os/Handler;", "getMainThreadId", "", "initLogRule", "initToastRule", "onCreate", "Companion", "lib_core_frame_debug"})
public class BaseApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static android.os.Handler handler;
    @org.jetbrains.annotations.NotNull()
    public static com.core.frame.app.BaseApplication instance;
    public static final com.core.frame.app.BaseApplication.Companion Companion = null;
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void initToastRule() {
    }
    
    private final void initLogRule() {
    }
    
    public final int getMainThreadId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getMainHandler() {
        return null;
    }
    
    public BaseApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/core/frame/app/BaseApplication$Companion;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "instance", "Lcom/core/frame/app/BaseApplication;", "getInstance", "()Lcom/core/frame/app/BaseApplication;", "setInstance", "(Lcom/core/frame/app/BaseApplication;)V", "lib_core_frame_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Handler getHandler() {
            return null;
        }
        
        public final void setHandler(@org.jetbrains.annotations.NotNull()
        android.os.Handler p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.app.BaseApplication getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull()
        com.core.frame.app.BaseApplication p0) {
        }
        
        private Companion() {
            super();
        }
    }
}