package com.jjshouse.kotlinmvvpdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import com.core.frame.utils.NetworkUtils
import com.jjshouse.kotlinmvvpdemo.R
import org.cchao.kotlintemplate.expansion.click

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.widget
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
class StateLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    //加载中展示的view
    private var loadingView: View? = null
    //加载失败显示的view, 比如断网了
    private var errorView: View? = null
    //加载成功的view,这个view是业务view
    private var successView: View? = null
    //暂时没有用到的空白view
    private var emptyView: View? = null

    val isSuccessViewVisible: Boolean
        get() = successView!!.isShown

    val isShowLoading: Boolean
        get() = null != loadingView && loadingView!!.isShown

    private var listener: OnReloadListener? = null

    init {
        initView()//初始化View
    }

    /**
     * 添加那4个子View：加载中的，加载成功的，加载没有数据，加载失败的
     */
    private fun initView() {
        //1.加载loadingView
        loadingView = View.inflate(context, R.layout.layout_loading, null)
        //2.添加失败的View
        errorView = View.inflate(context, R.layout.layout_network404, null)
        val btn_reload = errorView!!.findViewById<Button>(R.id.click_again)
        btn_reload.click(OnClickListener {
            if (!NetworkUtils.isConnected()) {
                com.core.frame.utils.ToastUtils.showCustomLong(R.layout.layout_net_error_toast,Gravity.CENTER)
                return@OnClickListener
            }
            //1.先显示loadingView
            showLoadingView()
            //2.点击的时候再一次重新加载数据
            if (listener != null) {
                listener!!.onReload()
            }
        })
        addView(errorView)
        //3.添加空白的view
        emptyView = View.inflate(context, R.layout.layout_empty_view, null)
        addView(emptyView)
        addView(loadingView)
        //4.加载成功的View在各界面是不同的，所以提供一个方法bindsucessview动态添加
        //一开始隐藏所有的View
        hideAll()
    }

    /**
     * 添加一个成功的View进来
     */
    fun bindSuccessView(view: View) {
        successView = view
        if (successView != null) {
            successView!!.visibility = View.INVISIBLE//隐藏successView
            //将它添加进来
            addView(successView)
        }
    }

    /**
     * 检查被bind的view是否已经被添加过了
     *
     * @param view 被检查的view
     * @return
     */
    private fun checkToBindView(view: View?): Boolean {
        if (view != null && view.parent != null) {
            Log.e(TAG, "view to bind has already been added ==>>" + view.parent)
            return false
        }
        return true
    }

    fun bindLoadingView(view: View?) {
        //检查是否被绑定
        if (!checkToBindView(loadingView)&& null != view){
            removeView(loadingView)
        }

        if (null != view) {
            loadingView = view
            addView(loadingView)
            loadingView!!.visibility = View.INVISIBLE
        }
    }

    fun bindEmptyView(view: View?) {
        //检查是否被绑定
        if (!checkToBindView(emptyView) && null != view) {
            removeView(emptyView)
        }

        if (null != view) {
            emptyView = view
            addView(emptyView)
            emptyView!!.visibility = View.INVISIBLE
        }
    }

    fun bindErrorView(view: View?) {
        //检查是否被绑定
        if (!checkToBindView(errorView)) return

        if (null != view) {
            errorView = view
        }
    }

    fun showSuccessView() {
        //先隐藏其他的
        hideAll()
        if (successView != null) {
            successView!!.visibility = View.VISIBLE
        }
    }

    fun showLoadingViewAbove() {
        loadingView!!.visibility = View.VISIBLE
    }

    fun showEmptyView() {
        //先隐藏其他的
        hideAll()
        emptyView!!.visibility = View.VISIBLE
    }

    fun showErrorView() {
        //先隐藏其他的
        hideAll()
        errorView!!.visibility = View.VISIBLE
    }

    fun showLoadingView() {
        //先隐藏其他的
        hideAll()
        loadingView!!.visibility = View.VISIBLE
    }

    /**
     * 隐藏所有的View
     */
    fun hideAll() {
        //设置各界面不可见，同时让他们不重新layout，要用的时候直接show就行了
        loadingView!!.visibility = View.INVISIBLE
        errorView!!.visibility = View.INVISIBLE
        emptyView!!.visibility = View.INVISIBLE
        if (successView != null) {
            successView!!.visibility = View.INVISIBLE
        }
    }

    fun setOnReloadListener(listener: OnReloadListener) {
        this.listener = listener
    }

    interface OnReloadListener {
        /**
         * 当重新加载的按钮被点击的时候调用
         */
        fun onReload()
    }

    companion object {
        //
        private val TAG = "StateLayout"
    }
}
