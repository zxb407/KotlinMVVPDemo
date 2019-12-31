package com.core.frame.base;

import java.lang.System;

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J)\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00132\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$\"\u00020%H\u0016\u00a2\u0006\u0002\u0010&J\u0010\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000201H\u0016J\u001a\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\nH\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006:"}, d2 = {"Lcom/core/frame/base/MActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "()V", "mLocalBroadcastHandler", "getMLocalBroadcastHandler", "()Lcom/core/frame/broadcast/ILocalBroadcastHandler;", "setMLocalBroadcastHandler", "(Lcom/core/frame/broadcast/ILocalBroadcastHandler;)V", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "getMToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "mToolbarHandler", "Lcom/core/frame/toolbar/ToolbarHandlerImpl;", "registeredReceivers", "", "Landroid/content/BroadcastReceiver;", "getRegisteredReceivers", "()Ljava/util/List;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "registerLocalReceiver", "receiver", "filter", "Landroid/content/IntentFilter;", "actions", "", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "sendLocalBroadcast", "intent", "Landroid/content/Intent;", "sendLocalBroadcastSync", "setContentView", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "", "setupTitle", "title", "", "setupToolbar", "appCompatActivity", "toolbar", "unRegisterAllLocalReceivers", "unRegisterLocalReceiver", "lib_core_frame_debug"})
public class MActivity extends androidx.appcompat.app.AppCompatActivity implements com.core.frame.broadcast.ILocalBroadcastHandler {
    @org.jetbrains.annotations.NotNull()
    public com.core.frame.broadcast.ILocalBroadcastHandler mLocalBroadcastHandler;
    @org.jetbrains.annotations.Nullable()
    private androidx.appcompat.widget.Toolbar mToolbar;
    private com.core.frame.toolbar.ToolbarHandlerImpl mToolbarHandler;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.core.frame.broadcast.ILocalBroadcastHandler getMLocalBroadcastHandler() {
        return null;
    }
    
    public final void setMLocalBroadcastHandler(@org.jetbrains.annotations.NotNull()
    com.core.frame.broadcast.ILocalBroadcastHandler p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public androidx.appcompat.widget.Toolbar getMToolbar() {
        return null;
    }
    
    public void setMToolbar(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.Toolbar p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
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
    
    @java.lang.Override()
    public void setContentView(int layoutResID) {
    }
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    public void setupToolbar(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity appCompatActivity, @org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public void setupTitle(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence title) {
    }
    
    public void setupTitle(int title) {
    }
    
    public MActivity() {
        super();
    }
}