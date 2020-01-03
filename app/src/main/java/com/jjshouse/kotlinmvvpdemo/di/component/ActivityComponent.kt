package com.jjshouse.kotlinmvvpdemo.di.component

import com.jjshouse.kotlinmvvpdemo.SecondActivity
import com.jjshouse.kotlinmvvpdemo.di.module.ActivityModule
import com.jjshouse.kotlinmvvpdemo.di.scope.ActivityScope
import dagger.Component

/**
 * Created by wing on 16-11-25.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class,ContractViewComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: SecondActivity)
}

