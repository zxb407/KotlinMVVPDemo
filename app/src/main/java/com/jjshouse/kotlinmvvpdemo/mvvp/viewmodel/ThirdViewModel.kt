package com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.jjshouse.kotlinmvvpdemo.base.BaseViewModel
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean

import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel
 * Created by xbzhang on 2020/1/9
 * Description:
 */

class ThirdViewModel @Inject
constructor() : BaseViewModel() {

    var url: LiveData<String> = Transformations.map(data) { (_, banners) -> banners[0].config[0].image }

    val data: MutableLiveData<HomeDataBean>
        get() = get(HomeDataBean::class.java)

    fun onClickButton() {
        val temp = data.value
        temp!!.banners[0].config[0].image =
            "https://cdn-4.jjshouse.com/upimg/jjshouse/o400/5c/00/896c89a9c40330b5c23165b4a52c5c00.jpg"
        data.value = temp
    }
}
