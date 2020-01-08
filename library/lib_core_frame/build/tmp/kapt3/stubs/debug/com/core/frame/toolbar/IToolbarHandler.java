package com.core.frame.toolbar;

import java.lang.System;

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/core/frame/toolbar/IToolbarHandler;", "", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setupToolbar", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "lib_core_frame_debug"})
public abstract interface IToolbarHandler {
    
    /**
     * Setup and config toolbar.
     *
     * @param appCompatActivity [AppCompatActivity]
     * @param toolbar           [Toolbar]
     */
    public abstract void setupToolbar(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity appCompatActivity, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.Toolbar toolbar);
    
    /**
     * [android.app.Activity.onOptionsItemSelected].
     *
     * @param item [MenuItem]
     * @return
     */
    public abstract boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item);
}