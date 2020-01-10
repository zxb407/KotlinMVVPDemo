package com.veryvoga.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.veryvoga.recycler.base.ItemViewDelegate;
import com.veryvoga.recycler.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang on 2017/5/21.
 */

public abstract class LoopCommonAdapter<T> extends LoopMultiItemTypeAdapter<T> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public LoopCommonAdapter(final Context context, final int layoutId) {
        this(context, layoutId, new ArrayList<T>());
    }

    public LoopCommonAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                LoopCommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);
}
