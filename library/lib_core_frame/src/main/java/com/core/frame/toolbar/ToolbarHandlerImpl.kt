package com.core.frame.toolbar

import android.app.Activity
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 *
 */
class ToolbarHandlerImpl : IToolbarHandler {

    private var mActivity: Activity? = null

    /**
     * Setup and config toolbar.
     *
     * @param appCompatActivity [AppCompatActivity]
     * @param toolbar           [Toolbar]
     */
    override fun setupToolbar(appCompatActivity: AppCompatActivity, toolbar: Toolbar) {
        this.mActivity = appCompatActivity
        appCompatActivity.setSupportActionBar(toolbar)
        appCompatActivity.supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = appCompatActivity.title
        }
    }

    /**
     * [Activity.onOptionsItemSelected].
     *
     * @param item [MenuItem]
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (android.R.id.home == id) {
            mActivity?.onBackPressed()
            return true
        }
        return false
    }
}
