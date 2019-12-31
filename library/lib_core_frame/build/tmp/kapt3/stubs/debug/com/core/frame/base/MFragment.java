package com.core.frame.base;

import java.lang.System;

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/31
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J)\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000b2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 \"\u00020!H\u0016\u00a2\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006*"}, d2 = {"Lcom/core/frame/base/MFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "()V", "mLocalBroadcastHandler", "getMLocalBroadcastHandler", "()Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "setMLocalBroadcastHandler", "(Lcom/core/frame/broadcast/ILocalBroadcastHandler;)V", "registeredReceivers", "", "Landroid/content/BroadcastReceiver;", "getRegisteredReceivers", "()Ljava/util/List;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "registerLocalReceiver", "receiver", "filter", "Landroid/content/IntentFilter;", "actions", "", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "sendLocalBroadcast", "", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "unRegisterAllLocalReceivers", "unRegisterLocalReceiver", "lib_core_frame_debug"})
public class MFragment extends androidx.fragment.app.Fragment implements com.core.frame.broadcast.ILocalBroadcastHandler {
    @org.jetbrains.annotations.NotNull()
    public com.core.frame.broadcast.ILocalBroadcastHandler mLocalBroadcastHandler;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.core.frame.broadcast.ILocalBroadcastHandler getMLocalBroadcastHandler() {
        return null;
    }
    
    public final void setMLocalBroadcastHandler(@org.jetbrains.annotations.NotNull()
    com.core.frame.broadcast.ILocalBroadcastHandler p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<android.content.BroadcastReceiver> getRegisteredReceivers() {
        return null;
    }
    
    @java.lang.Override()
    public void unRegisterAllLocalReceivers() {
    }
    
    @java.lang.Override()
    public void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    android.content.IntentFilter filter) {
    }
    
    @java.lang.Override()
    public void registerLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String... actions) {
    }
    
    @java.lang.Override()
    public void unRegisterLocalReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver receiver) {
    }
    
    @java.lang.Override()
    public boolean sendLocalBroadcast(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return false;
    }
    
    @java.lang.Override()
    public void sendLocalBroadcastSync(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    public MFragment() {
        super();
    }
}