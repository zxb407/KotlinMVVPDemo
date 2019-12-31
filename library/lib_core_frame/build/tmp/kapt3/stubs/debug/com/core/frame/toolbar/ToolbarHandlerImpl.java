package com.core.frame.toolbar;

import java.lang.System;

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/core/frame/toolbar/ToolbarHandlerImpl;", "Lcom/core/frame/toolbar/IToolbarHandler;", "()V", "mActivity", "Landroid/app/Activity;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setupToolbar", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "lib_core_frame_debug"})
public final class ToolbarHandlerImpl implements com.core.frame.toolbar.IToolbarHandler {
    private android.app.Activity mActivity;
    
    /**
     * Setup and config toolbar.
     *
     * @param appCompatActivity [AppCompatActivity]
     * @param toolbar           [Toolbar]
     */
    @java.lang.Override()
    public void setupToolbar(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity appCompatActivity, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    /**
     * [Activity.onOptionsItemSelected].
     *
     * @param item [MenuItem]
     * @return
     */
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public ToolbarHandlerImpl() {
        super();
    }
}