package com.core.frame.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.core.frame.R


/**
 * Package:com.dding.base.framework
 * Date:2018/12/28
 * Author:dding
 * Description:
 */
abstract class MToolbarActivity : MActivity() {


    /**
     * Overide this method and pass your content view with toolbar.
     *
     * @param inflater [LayoutInflater]
     * @return Content view with toolbar.
     */
    open fun onCreateToolbarLayout(inflater: LayoutInflater): ViewGroup {
        return inflater.inflate(R.layout.sdk_base_toolbar_fragment, null) as? ViewGroup
            ?: throw RuntimeException("Only ViewGroup will be accepted.") as Throwable
    }

    override fun setContentView(layoutResID: Int) {
        this.setContentView(layoutInflater.inflate(layoutResID, null, true))
    }

    override fun setContentView(view: View?) {
        val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        this.setContentView(view, lp)
    }

    abstract fun useDefaultToolBar(): Boolean

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        if (useDefaultToolBar()) {
            val rootView = onCreateToolbarLayout(layoutInflater)
            val contentView = rootView.findViewById<View>(R.id.root) as ViewGroup
            if (null != contentView) {
                contentView.addView(view, params)
            } else {
                rootView.addView(view, params)
            }
            super.setContentView(rootView, params)
        } else {
            super.setContentView(view, params)
        }
    }
}
