package com.jjshouse.kotlinmvvpdemo.ui.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.base.BaseMvpFragment
import com.jjshouse.kotlinmvvpdemo.handle.URLManager
import com.jjshouse.kotlinmvvpdemo.model.databean.CategoryDataBean
import com.jjshouse.kotlinmvvpdemo.model.databean.Children
import com.jjshouse.kotlinmvvpdemo.model.databean.NativeConfig
import com.jjshouse.kotlinmvvpdemo.model.databean.SubnavBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.CategoryFragmentContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.CategoryFragmentPresenter
import com.veryvoga.recycler.adapter.CommonAdapter
import com.veryvoga.recycler.adapter.MultiItemTypeAdapter
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * PackageName: com.dding.mvpdemo.ui.fragment
 * Created by xbzhang on 2019/1/8
 * Description: 主页Category标签, 商品目录分类
 */
class CategoryFragment : BaseMvpFragment<CategoryFragmentPresenter>(), CategoryFragmentContract.View, View.OnClickListener {

    private var mAdapter: LeftCategoryAdapter? = null
    private var mRAdapter: RightCategoryAdapter? = null
    private var curLeftPos: Int = 0
    private var curCatUrl: String? = null
    private var curCatNativeConfig: NativeConfig? = null
    private var curCatId: String = ""

    companion object {
        fun newInstance(): CategoryFragment {
            val fragment = CategoryFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun inject() {
        getInjector().inject(this)
    }

    override fun onVisibleToUser() {

    }

    override fun onInvisibleToUser() {

    }

    override fun onTryAgain() {

    }

    override fun isMonitorNetWork(): Boolean {
        return true
    }

    override fun useDefaultToolBar(): Boolean {
        return false
    }

    override fun getSuccessView(): View {
        return View.inflate(context, R.layout.fragment_category, null)
    }

    override fun initEvent() {
        category_search_icon.setOnClickListener(this)
        stateLayout.setOnReloadListener(this)
        category_banner.setOnClickListener(this)
        toolbar_back_icon.setOnClickListener(this)
    }

    override fun initView() {
        stateLayout.showLoadingViewAbove()
        initRecycler()
        initBanner()
    }

    override fun initData() {
        mPresenter.getCategoryInfo()
    }

    override fun onReload() {
        mPresenter.getCategoryInfo()
    }

    override fun onCategorySuccess(data: List<CategoryDataBean>) {
        stateLayout.showSuccessView()
        if (data.isNotEmpty()) {
            if (curLeftPos >= data.size - 1) {
                curLeftPos = 0
            }
            mAdapter?.clearData()
            mAdapter?.addDataAll(data)
            mAdapter?.notifyDataSetChanged()
            mRAdapter?.clearData()
            mRAdapter?.addDataAll(data[curLeftPos].subnav)
            mRAdapter?.notifyDataSetChanged()
            Glide.with(mActivity).load(URLManager.getImageUrl(data[curLeftPos].banner)).apply(RequestOptions().placeholder(
                R.drawable.pic_default)).into(category_banner)
            curCatUrl = data[curLeftPos].url
            curCatNativeConfig = data[curLeftPos].nativeConfig
        }
        mAdapter?.setOnItemClickListener(object : MultiItemTypeAdapter.OnItemClickListener<CategoryDataBean> {
            override fun onItemClick(view: View?, holder: RecyclerView.ViewHolder, o: CategoryDataBean, position: Int) {
                if (o.subnav.isEmpty()) {
                    jumpNative(o.nativeConfig)
                    return
                }
                curCatId = o.cat_id
                curLeftPos = position
                curCatUrl = o.url
                curCatNativeConfig = o.nativeConfig
                Glide.with(mActivity).load(URLManager.getImageUrl(o.banner)).into(category_banner)
                mAdapter?.notifyDataSetChanged()
                mRAdapter?.clearData()
                mRAdapter?.addDataAll(o.subnav)
                mRAdapter?.notifyDataSetChanged()
                scroll_container.smoothScrollTo(0, 0)
                scrollMiddleH(view, position)
            }

            override fun onItemLongClick(view: View?, holder: RecyclerView.ViewHolder?, o: CategoryDataBean?, position: Int): Boolean {
                return true
            }
        })
    }

    private fun initRecycler() {
        mAdapter = LeftCategoryAdapter(mActivity)
        mRAdapter = RightCategoryAdapter(mActivity)
        initHeaderWrapper()
        rc_right.layoutManager = LinearLayoutManager(context)
        rc_right.adapter = mRAdapter
        rc_left.layoutManager = LinearLayoutManager(context)
        rc_left.adapter = mAdapter
    }

    override fun onCategoryError(msg: String) {
        stateLayout.showErrorView()
    }

    private fun initBanner() {
    }

    private fun jumpNative(data: NativeConfig?) {
        data?.let {
//            var intent = Intent(this.mActivity, ProductListActivity::class.java)
//            intent.putExtra("config", it)
//            mActivity.startActivity(intent)
        }
    }

    private fun scrollMiddleH(view: View?, pos: Int) {
        if (view != null) {
            var rcHeight = rc_left.height
            var vTop = view.top
            var vHeight = view.height
            var dis = vTop - (rcHeight - vHeight) / 2
            rc_left.smoothScrollBy(0, dis)
        }
    }

    private fun initHeaderWrapper() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.category_search_icon -> {
//                mActivity.startActivity(Intent(mActivity, SearchActivity::class.java))
            }
            R.id.category_banner -> {
                curCatNativeConfig?.let {
                    jumpNative(it)
                }
            }
            R.id.toolbar_back_icon -> {
                mActivity.finish()
            }
        }
    }

    inner class LeftCategoryAdapter(context: Context) : CommonAdapter<CategoryDataBean>(context, R.layout.item_left_category) {
        override fun convert(holder: com.veryvoga.recycler.base.ViewHolder, item: CategoryDataBean, position: Int) {
            holder.setText(R.id.tv_category, item.name)
            if (position == curLeftPos) {
                holder.setBackgroundColor(R.id.cl_category_container, Color.WHITE)
                holder.getView<TextView>(R.id.tv_category).textSize = 14f
                holder.setVisible(R.id.v_redline, true)
            } else {
                holder.setBackgroundColor(R.id.cl_category_container, android.R.color.darker_gray)
                holder.getView<TextView>(R.id.tv_category).textSize = 14f
                holder.setVisible(R.id.v_redline, false)
            }
        }
    }

    inner class RightCategoryAdapter(context: Context) : CommonAdapter<SubnavBean>(context, R.layout.item_right_category) {
        override fun convert(holder: com.veryvoga.recycler.base.ViewHolder, item: SubnavBean, position: Int) {
            holder.setText(R.id.tv_right_title, item.name)
            holder.setOnClickListener(R.id.ll_all) {
                jumpNative(item.nativeConfig)
            }
            var mGridAdapter = RightGridItemAdapter(this@RightCategoryAdapter.mContext)
            var gridView = holder.getView<RecyclerView>(R.id.rc_right_gridview)
            var layoutManager = GridLayoutManager(this@RightCategoryAdapter.mContext, 3)
            mGridAdapter.addDataAll(item.children)
            gridView.layoutManager = layoutManager
            gridView.adapter = mGridAdapter
            holder.setVisible(R.id.ll_all, !item.url.isEmpty())
        }
    }

    inner class RightGridItemAdapter(context: Context) : CommonAdapter<Children>(context, R.layout.item_right_grid) {
        override fun convert(holder: com.veryvoga.recycler.base.ViewHolder, item: Children, position: Int) {
            if (item.url.isEmpty()) {
                holder.setVisible(R.id.cl_category_container, false)
                return
            } else {
                holder.setVisible(R.id.cl_category_container, true)
            }
            holder.setText(R.id.tv_right_grid_name, item.name)
            holder.setImageUrl(mContext, R.id.iv_right_grid_img, URLManager.getImageUrl(item.img))
            holder.setOnClickListener(R.id.cl_category_container) {
                jumpNative(item.nativeConfig)
            }
        }
    }
}
