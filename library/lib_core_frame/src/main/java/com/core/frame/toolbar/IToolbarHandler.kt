package com.core.frame.toolbar

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 *
 */
interface IToolbarHandler {

    /**
     * Setup and config toolbar.
     *
     * @param appCompatActivity [AppCompatActivity]
     * @param toolbar           [Toolbar]
     */
    fun setupToolbar(appCompatActivity: AppCompatActivity, toolbar: Toolbar)

    /**
     * [android.app.Activity.onOptionsItemSelected].
     *
     * @param item [MenuItem]
     * @return
     */
    fun onOptionsItemSelected(item: MenuItem): Boolean
}
