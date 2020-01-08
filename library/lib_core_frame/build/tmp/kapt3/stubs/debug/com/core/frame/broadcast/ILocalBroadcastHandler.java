package com.core.frame.broadcast;

import java.lang.System;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&J%\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH&\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "", "registeredReceivers", "", "Landroid/content/BroadcastReceiver;", "getRegisteredReceivers", "()Ljava/util/List;", "registerLocalReceiver", "", "receiver", "filter", "Landroid/content/IntentFilter;", "actions", "", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "sendLocalBroadcast", "", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "unRegisterAllLocalReceivers", "unRegisterLocalReceiver", "lib_core_frame_debug"})
public abstract interface ILocalBroadcastHandler {
    
    /**
     * Get all the [BroadcastReceiver] register in the [LocalBroadcastManager]
     *
     * @return [BroadcastReceiver]'s list.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<android.content.BroadcastReceiver> getRegisteredReceivers();
    
    /**
     * Unregister all the [BroadcastReceiver] register in the [android.location.LocationManager]
     */
    public abstract void unRegisterAllLocalReceivers();
    
    /**
     * See [LocalBroadcastManager.registerReceiver]
     *
     * @param receiver [BroadcastReceiver]
     * @param filter   [IntentFilter]
     */
    public abstract void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    android.content.IntentFilter filter);
    
    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver
     */
    public abstract void unRegisterLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver);
    
    /**
     * See [LocalBroadcastManager.sendBroadcast]
     *
     * @param intent
     *
     * @return
     */
    public abstract boolean sendLocalBroadcast(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent);
    
    /**
     * See [LocalBroadcastManager.sendBroadcastSync]
     *
     * @param intent
     */
    public abstract void sendLocalBroadcastSync(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent);
    
    public abstract void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String[] actions);
}