package com.jjshouse.kotlinmvvpdemo.di.module

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.di.module
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    fun getFragment() = fragment
}