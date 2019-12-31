package com.core.frame.broadcast;

import java.lang.System;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0016\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/core/frame/broadcast/LocalBroadcastHandlerImpl;", "Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mReceivers", "Ljava/util/LinkedList;", "Landroid/content/BroadcastReceiver;", "registeredReceivers", "", "getRegisteredReceivers", "()Ljava/util/List;", "getBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "context", "registerLocalReceiver", "", "receiver", "filter", "Landroid/content/IntentFilter;", "actions", "", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "sendLocalBroadcast", "", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "unRegisterAllLocalReceivers", "unRegisterLocalReceiver", "lib_core_frame_debug"})
public final class LocalBroadcastHandlerImpl implements com.core.frame.broadcast.ILocalBroadcastHandler {
    private final java.util.LinkedList<android.content.BroadcastReceiver> mReceivers = null;
    private final android.content.Context mContext = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<android.content.BroadcastReceiver> getRegisteredReceivers() {
        return null;
    }
    
    private final androidx.localbroadcastmanager.content.LocalBroadcastManager getBroadcastManager(android.content.Context context) {
        return null;
    }
    
    /**
     * Unregister all the [BroadcastReceiver] register in the [LocationManager]
     */
    @java.lang.Override()
    public synchronized void unRegisterAllLocalReceivers() {
    }
    
    /**
     * See [LocalBroadcastManager.registerReceiver]
     *
     * @param receiver
     * @param filter
     */
    @java.lang.Override()
    public void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    android.content.IntentFilter filter) {
    }
    
    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver [BroadcastReceiver]
     * @param actions  string actions
     */
    @java.lang.Override()
    public void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String... actions) {
    }
    
    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver
     */
    @java.lang.Override()
    public void unRegisterLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver) {
    }
    
    /**
     * See [LocalBroadcastManager.sendBroadcast]
     *
     * @param intent
     *
     * @return
     */
    @java.lang.Override()
    public boolean sendLocalBroadcast(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return false;
    }
    
    /**
     * See [LocalBroadcastManager.sendBroadcastSync]
     *
     * @param intent
     */
    @java.lang.Override()
    public void sendLocalBroadcastSync(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    public LocalBroadcastHandlerImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super();
    }
}