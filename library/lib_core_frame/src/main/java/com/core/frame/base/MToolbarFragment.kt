package com.core.frame.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.core.frame.R


/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2020/1/10
 * Description:
 *
 */
abstract class MToolbarFragment : MFragment() {

    var rootView: View? = null

    /**
     * Overide this method and pass your content view with toolbar.
     *
     * @param inflater [LayoutInflater]
     * @return Content view with toolbar.
     */
    open fun onCreateToolbarLayout(inflater: LayoutInflater): ViewGroup {
        return inflater.inflate(R.layout.sdk_base_toolbar_activity, null) as? ViewGroup
            ?: throw RuntimeException("Only ViewGroup will be accepted.") as Throwable
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var childView = getContentView()
        if (useDefaultToolBar()) {
            rootView = onCreateToolbarLayout(layoutInflater)
            val contentView = rootView!!.findViewById<View>(R.id.root) as ViewGroup
            contentView.addView(childView)
        } else {
            rootView = childView
        }
        val parent = rootView?.parent
        if (parent is ViewGroup) {
            parent.removeView(rootView)
        }
        return rootView
    }

    abstract fun getContentView(): View

    abstract fun useDefaultToolBar(): Boolean
}