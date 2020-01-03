package com.jjshouse.kotlinmvvpdemo.di.scope

import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 *
 * Description:
 *
 * @author xzhang
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class AppScope
