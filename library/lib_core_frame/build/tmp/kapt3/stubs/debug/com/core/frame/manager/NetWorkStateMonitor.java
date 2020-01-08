package com.core.frame.manager;

import java.lang.System;

/**
 * PackageName: com.core.frame.manager
 * Created by xbzhang on 2019/12/30
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/core/frame/manager/NetWorkStateMonitor;", "", "()V", "Companion", "lib_core_frame_debug"})
public final class NetWorkStateMonitor {
    private static com.core.frame.manager.NetWorkStateMonitor instance;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NetWorkStateMonitor";
    private static boolean state;
    public static final com.core.frame.manager.NetWorkStateMonitor.Companion Companion = null;
    
    private NetWorkStateMonitor() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/core/frame/manager/NetWorkStateMonitor$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/core/frame/manager/NetWorkStateMonitor;", "state", "", "get", "application", "Landroid/app/Application;", "ctx", "Landroid/content/Context;", "init", "registNetworkCallBack", "", "context", "lib_core_frame_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.NetWorkStateMonitor init(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
        
        private final void registNetworkCallBack(android.app.Application context) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.core.frame.manager.NetWorkStateMonitor get(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.NetWorkStateMonitor get(@org.jetbrains.annotations.NotNull()
        android.content.Context ctx) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.core.frame.manager.NetWorkStateMonitor get() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}