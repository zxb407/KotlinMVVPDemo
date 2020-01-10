package com.jjshouse.kotlinmvvpdemo.ui.activity

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.core.frame.manager.ActivityLifecycleManager
import com.core.frame.manager.AppActivityManager
import com.core.frame.utils.jsonutils.JsonUtils
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.base.BaseActivity
import com.jjshouse.kotlinmvvpdemo.model.databean.MessageBean
import com.jjshouse.kotlinmvvpdemo.ui.fragment.CategoryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {

    var curTag: String = TAG_FRAGMENT_HOME
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    private var firstTime: Long = 0

    //是否需要在登录成功后处理推送跳转
    private var needProcessPush = false

    companion object {
        const val TAG_FRAGMENT_CATEGORY = "tag_fragment_category"
        const val TAG_FRAGMENT_BAG = "tag_fragment_bag"
        const val TAG_FRAGMENT_ACCOUNT = "tag_fragment_account"
        const val TAG_FRAGMENT_HOME = "tag_fragment_home_native"
        const val KEY_PUSH = "key_push"

        fun launch(context: Context, tag: String) {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("TAG", tag)
            context.startActivity(intent)
        }

        fun launchPush(context: Context, bean: MessageBean): Intent {
            val intent = Intent(context, MainActivity::class.java)
            if (ActivityLifecycleManager.get().isBackground()) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            intent.putExtra(KEY_PUSH, JsonUtils.toString(bean))
            return intent
        }
    }
    override fun inject() {
        getInjector().inject(this)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        setRadioGroup()
        launchFragment(curTag)
    }

    override fun initEvent() {
    }

    override fun initData() {
    }

    private fun setRadioGroup() {
        home_navi_container.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.home_navi_rb_home -> {
                    curTag = TAG_FRAGMENT_HOME
                }
                R.id.home_navi_rb_category -> {
                    curTag = TAG_FRAGMENT_CATEGORY
                }
                R.id.home_navi_rb_cart -> {
                    curTag = TAG_FRAGMENT_BAG
                }
                R.id.home_navi_rb_account -> {
                    curTag = TAG_FRAGMENT_ACCOUNT
                }
            }
            switchFragment()
        }
    }

    private fun switchFragment() {
        fm = this@MainActivity.supportFragmentManager
        ft = fm.beginTransaction()
        resetFragments(fm, ft)
        showCurrentFragment(fm, ft)
        ft.commitAllowingStateLoss()
    }

    private fun resetFragments(fm: FragmentManager, ft: FragmentTransaction) {
        var fragments: List<Fragment> = fm.fragments
        for (fragment in fragments) {
            if (fragment != null) {
                if (fragment is CategoryFragment
                    || fragment is CategoryFragment
                    || fragment is CategoryFragment
                    || fragment is CategoryFragment) {
                    ft.hide(fragment)
                }
            }
        }
    }

    private fun showCurrentFragment(fm: FragmentManager, ft: FragmentTransaction) {
        var fragment: Fragment? = fm.findFragmentByTag(curTag)
        if (fragment != null) {
            ft.show(fragment)
        } else {
            fragment = createFragment()
            ft.add(R.id.main_content, fragment!!, curTag)
        }
        fragment?.userVisibleHint = true
    }

    private fun createFragment(): Fragment? {
        when (curTag) {
            TAG_FRAGMENT_HOME -> return CategoryFragment.newInstance()
            TAG_FRAGMENT_CATEGORY -> return CategoryFragment.newInstance()
            TAG_FRAGMENT_BAG -> return CategoryFragment.newInstance()
            TAG_FRAGMENT_ACCOUNT -> return CategoryFragment.newInstance()
        }
        return null
    }

    private fun launchFragment(stringExtra: String) {
        when (stringExtra) {
            TAG_FRAGMENT_HOME -> home_navi_rb_home.isChecked = true
            TAG_FRAGMENT_CATEGORY -> home_navi_rb_category.isChecked = true
            TAG_FRAGMENT_BAG -> home_navi_rb_cart.isChecked = true
            TAG_FRAGMENT_ACCOUNT -> home_navi_rb_account.isChecked = true
        }
    }

    override fun onBackPressed() {
        if (!curTag.equals(TAG_FRAGMENT_HOME)) {
            launchFragment(TAG_FRAGMENT_HOME)
        } else {
            var secondTime = System.currentTimeMillis()
            if (secondTime - firstTime > 2000) {
                Toast.makeText(this, resources.getString(R.string.press_again_to_exit), Toast.LENGTH_SHORT).show()
                firstTime = secondTime
            } else {
                AppActivityManager.instance.AppExit()
            }
        }
    }

    override fun onTryAgain() {
    }

    override fun isMonitorNetWork(): Boolean {
        return true
    }

    override fun useDefaultToolBar(): Boolean {
        return false
    }

    override fun onClick(p0: View) {

    }
}
