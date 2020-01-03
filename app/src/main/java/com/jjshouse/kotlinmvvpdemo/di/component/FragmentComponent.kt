package com.jjshouse.kotlinmvvpdemo.di.component

import com.jjshouse.kotlinmvvpdemo.di.module.FragmentModule
import com.jjshouse.kotlinmvvpdemo.di.scope.FragmentScope
import dagger.Subcomponent

/**
 * Created by wing on 16-11-25.
 */
@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
//    fun inject(fragment: FavoriteListFragment)
}
