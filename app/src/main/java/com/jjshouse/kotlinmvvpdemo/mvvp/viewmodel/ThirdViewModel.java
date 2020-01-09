package com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.jjshouse.kotlinmvvpdemo.base.BaseViewModel;
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean;

import javax.inject.Inject;

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel
 * Created by xbzhang on 2020/1/9
 * Description:
 */

public class ThirdViewModel extends BaseViewModel {

    @Inject
    public ThirdViewModel() {
        super();
    }

    public LiveData<String> url = Transformations.map(getData(), data -> data.getBanners().get(0).getConfig().get(0).getImage());

    public MutableLiveData<HomeDataBean> getData() {
        return get(HomeDataBean.class);
    }

    public void onClickButton() {
        HomeDataBean temp = getData().getValue();
        temp.getBanners().get(0).getConfig().get(0).setImage("https://cdn-4.jjshouse.com/upimg/jjshouse/o400/5c/00/896c89a9c40330b5c23165b4a52c5c00.jpg");
        getData().setValue(temp);
    }
}
