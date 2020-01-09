package com.jjshouse.kotlinmvvpdemo.base;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jjshouse.kotlinmvvpdemo.JJApplication;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * VM基类，注意VM中不要持有activity，fragment对象。
 * 尽量使用livedata的订阅在activity，fragment中做操作
 * 或者使用Rxbus
 */
public class BaseViewModel extends AndroidViewModel{
    /**
     * 页面无数据显示
     */
    private Map<String, MutableLiveData> maps;

    public BaseViewModel() {
        super(JJApplication.instance);
        maps = new ConcurrentHashMap<>();  //初始化集合(线程安全)
    }

    public void onDestroy() {
        onCleared();
    }

    /**
     * 通过指定的数据实体类获取对应的 LiveData 类
     */
    protected <T> MutableLiveData<T> get(Class<T> clazz) {
        return get(null, clazz);
    }

    /**
     * 通过指定的key或者数据实体类获取对应的 LiveData 类
     */
    protected <T> MutableLiveData<T> get(String key, Class<T> clazz) {
        String keyName;
        if (TextUtils.isEmpty(key)) {
            keyName = clazz.getCanonicalName();
        } else {
            keyName = key;
        }
        MutableLiveData<T> mutableLiveData = maps.get(keyName);
        // 判断集合是否已经存在 LiveData 对象，若存在就返回
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        // 如果 Map 集合中没有对应实体类的 LiveData 对象，就创建并添加至集合中
        mutableLiveData = new MutableLiveData<>();
        assert keyName != null;
        maps.put(keyName, mutableLiveData);
        return mutableLiveData;
    }

    /**
     * 在对应的FragmentActivity销毁之后调用
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        if (maps != null) {
            maps.clear();
        }
    }

}
