package com.veryvoga.recycler.wrapper;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.veryvoga.recycler.base.ViewHolder;
import com.veryvoga.recycler.utils.WrapperUtils;


/**
 * Created by xzhang on 2017/5/21.
 */

public class LoadMoreWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_LOAD_MORE = Integer.MAX_VALUE - 2;
    public static final int ITEM_TYPE_NO_MORE = Integer.MAX_VALUE - 3;

    private RecyclerView.Adapter mInnerAdapter;
    private View mLoadMoreView;
    private int mLoadMoreLayoutId;
    private View mNoMoreView;
    private int mNoMoreLayoutId;
    private boolean hasMore = true;

    public LoadMoreWrapper(RecyclerView.Adapter adapter) {
        mInnerAdapter = adapter;
    }

    private boolean hasLoadMore() {
        return (mLoadMoreView != null || mLoadMoreLayoutId != 0) && mInnerAdapter.getItemCount() > 0;
    }

    private boolean isShowLoadMore(int position) {
        return hasLoadMore() && mInnerAdapter.getItemCount() > 0 && position >= mInnerAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowLoadMore(position)) {
            if (hasMore) {
                return ITEM_TYPE_LOAD_MORE;
            } else {
                return ITEM_TYPE_NO_MORE;
            }
        }
        return mInnerAdapter.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_LOAD_MORE) {
            ViewHolder holder;
            if (mLoadMoreView != null) {
                holder = ViewHolder.createViewHolder(parent.getContext(), mLoadMoreView);
            } else {
                holder = ViewHolder.createViewHolder(parent.getContext(), parent, mLoadMoreLayoutId);
            }
            return holder;
        }
        if (viewType == ITEM_TYPE_NO_MORE) {
            ViewHolder holder;
            if (mLoadMoreView != null) {
                holder = ViewHolder.createViewHolder(parent.getContext(), mNoMoreView);
            } else {
                holder = ViewHolder.createViewHolder(parent.getContext(), parent, mNoMoreLayoutId);
            }
            return holder;
        }
        return mInnerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isShowLoadMore(position)) {
            if (mOnLoadMoreListener != null && hasMore) {
                mOnLoadMoreListener.onLoadMoreRequested();
            }
            return;
        }
        mInnerAdapter.onBindViewHolder(holder, position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        WrapperUtils.onAttachedToRecyclerView(mInnerAdapter, recyclerView, new WrapperUtils.SpanSizeCallback() {
            @Override
            public int getSpanSize(GridLayoutManager layoutManager, GridLayoutManager.SpanSizeLookup oldLookup, int position) {
                if (isShowLoadMore(position)) {
                    return layoutManager.getSpanCount();
                }
                if (oldLookup != null) {
                    return oldLookup.getSpanSize(position);
                }
                return 1;
            }
        });
    }


    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        mInnerAdapter.onViewAttachedToWindow(holder);

        if (isShowLoadMore(holder.getLayoutPosition())) {
            setFullSpan(holder);
        }
    }

    private void setFullSpan(RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();

        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;

            p.setFullSpan(true);
        }
    }

    @Override
    public int getItemCount() {
        return mInnerAdapter.getItemCount() + (hasLoadMore() ? 1 : 0);
    }


    public interface OnLoadMoreListener {
        void onLoadMoreRequested();
    }

    private OnLoadMoreListener mOnLoadMoreListener;

    public LoadMoreWrapper setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        if (loadMoreListener != null) {
            mOnLoadMoreListener = loadMoreListener;
        }
        return this;
    }

    public LoadMoreWrapper setLoadMoreView(View loadMoreView) {
        mLoadMoreView = loadMoreView;
        return this;
    }

    public LoadMoreWrapper setLoadMoreView(int layoutId) {
        mLoadMoreLayoutId = layoutId;
        return this;
    }

    public LoadMoreWrapper setNoMoreView(View loadMoreView) {
        mNoMoreView = loadMoreView;
        return this;
    }

    public LoadMoreWrapper setNoMoreView(int layoutId) {
        mNoMoreLayoutId = layoutId;
        return this;
    }

    public void hideLoadMoreView() {
        hasMore = false;
        notifyDataSetChanged();
    }

    public void resetLoadMoreView() {
        hasMore = true;
    }
}
