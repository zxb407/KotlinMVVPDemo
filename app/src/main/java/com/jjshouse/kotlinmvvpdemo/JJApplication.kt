package com.jjshouse.kotlinmvvpdemo

import com.core.frame.app.BaseApplication
import com.crashlytics.android.Crashlytics
import com.jjshouse.kotlinmvvpdemo.di.component.AppComponent
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerAppComponent
import com.jjshouse.kotlinmvvpdemo.di.module.AppModule
import io.fabric.sdk.android.Fabric
import javax.inject.Inject


/**
 * PackageName: com.jjshouse.kotlinmvvpdemo
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
class JJApplication : BaseApplication() {

    @Inject
    lateinit var appComponent: AppComponent

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics()) //此处手动初始化crashlytics，firecrash -> customCrashHandler -> defaultCrashHandler
        initDagger2()
    }

    private fun initDagger2() {
        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }

    companion object {
        lateinit var instance: JJApplication
    }
}