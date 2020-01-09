package com.jjshouse.kotlinmvvpdemo.base

import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jjshouse.kotlinmvvpdemo.JJApplication
import java.util.concurrent.ConcurrentHashMap


/**
 * VM基类，注意VM中不要持有activity，fragment对象。
 * 尽量使用livedata的订阅在activity，fragment中做操作
 */
open class BaseViewModel : AndroidViewModel(JJApplication.instance) {
    /**
     * 页面无数据显示
     */
    private val maps: MutableMap<String, MutableLiveData<*>>?

    init {
        maps = ConcurrentHashMap()  //初始化集合(线程安全)
    }

    fun onDestroy() {
        onCleared()
    }

    /**
     * 通过指定的数据实体类获取对应的 LiveData 类
     */
    protected operator fun <T> get(clazz: Class<T>): MutableLiveData<T> {
        return get(null, clazz)
    }

    /**
     * 通过指定的key或者数据实体类获取对应的 LiveData 类
     */
    protected operator fun <T> get(key: String?, clazz: Class<T>): MutableLiveData<T> {
        val keyName: String?
        if (TextUtils.isEmpty(key)) {
            keyName = clazz.canonicalName
        } else {
            keyName = key
        }
        var mutableLiveData: MutableLiveData<*>? = maps!![keyName]
        // 判断集合是否已经存在 LiveData 对象，若存在就返回
        if (mutableLiveData != null) {
            return mutableLiveData as MutableLiveData<T>
        }
        // 如果 Map 集合中没有对应实体类的 LiveData 对象，就创建并添加至集合中
        mutableLiveData = MutableLiveData<T>()
        assert(keyName != null)
        maps[keyName!!] = mutableLiveData
        return mutableLiveData
    }

    /**
     * 在对应的FragmentActivity销毁之后调用
     */
    override fun onCleared() {
        super.onCleared()
        maps?.clear()
    }
}
