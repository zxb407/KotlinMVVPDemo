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

public class LoadMore5Wrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_LOAD_MORE = Integer.MAX_VALUE - 2;
    public static final int ITEM_TYPE_NO_MORE = Integer.MAX_VALUE - 3;
    public static final int ITEM_TYPE_RELOAD = Integer.MAX_VALUE - 4;
    private int threhold = 5; //默认预加载个数

    private RecyclerView.Adapter mInnerAdapter;
    private View mLoadMoreView;
    private int mLoadMoreLayoutId;
    private View mNoMoreView;
    private int mNoMoreLayoutId;
    private View mRetryView;
    private int mRetryLayoutId;
    private boolean hasMore = true; //是否还有下一页数据
    private boolean needRetry = false; //请求错误后是否重试
    private boolean loading;  //分页加载是否正在进行中

    public LoadMore5Wrapper(RecyclerView.Adapter adapter) {
        mInnerAdapter = adapter;
    }

    private boolean hasLoadMore() {
        return (mLoadMoreView != null || mLoadMoreLayoutId != 0);
    }

    private boolean hasNoMore() {
        return (mNoMoreView != null || mNoMoreLayoutId != 0);
    }

    private boolean hasRetry() {
        return (mRetryView != null || mRetryLayoutId != 0);
    }

    private boolean isShowLoadMore(int position) {
        return hasLoadMore() && (position >= mInnerAdapter.getItemCount());
    }

    private boolean isStartLoadMore(int position) {
        if (hasLoadMore() && mInnerAdapter.getItemCount() > 0) {
            if (mInnerAdapter.getItemCount() <= threhold) {
                threhold = mInnerAdapter.getItemCount();
                return position >= mInnerAdapter.getItemCount();
            } else {
                if (!loading && position >= mInnerAdapter.getItemCount() - threhold) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    @Override
    public int getItemViewType(int position) {
        if (isShowLoadMore(position)) {
            if (hasMore) {
                return ITEM_TYPE_LOAD_MORE;
            } else {
                if (needRetry && hasRetry()) {
                    return ITEM_TYPE_RELOAD;
                }
                if (!needRetry && hasNoMore()) {
                    return ITEM_TYPE_NO_MORE;
                }
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
            if (mNoMoreView != null) {
                holder = ViewHolder.createViewHolder(parent.getContext(), mNoMoreView);
            } else {
                holder = ViewHolder.createViewHolder(parent.getContext(), parent, mNoMoreLayoutId);
            }
            return holder;
        }
        if (viewType == ITEM_TYPE_RELOAD) {
            ViewHolder holder;
            if (mRetryView != null) {
                holder = ViewHolder.createViewHolder(parent.getContext(), mRetryView);
            } else {
                holder = ViewHolder.createViewHolder(parent.getContext(), parent, mRetryLayoutId);
            }
            return holder;
        }
        return mInnerAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (isStartLoadMore(position)) {
            if (mOnLoadMoreListener != null && hasMore) {
                loading = true;
                mOnLoadMoreListener.onLoadMoreRequested();
            }
        }

        if (isShowLoadMore(position)) {
            if (getItemViewType(position) == ITEM_TYPE_RELOAD) {
                ((ViewHolder) holder).itemView.setVisibility(View.VISIBLE);
                ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onRetry();
                            ((ViewHolder) holder).itemView.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
            if (getItemViewType(position) == ITEM_TYPE_NO_MORE) {
                ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onNoMore();
                        }
                    }
                });
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

        void onNoMore();

        void onRetry();
    }

    private OnLoadMoreListener mOnLoadMoreListener;

    public LoadMore5Wrapper setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        if (loadMoreListener != null) {
            mOnLoadMoreListener = loadMoreListener;
        }
        return this;
    }

    public LoadMore5Wrapper setLoadMoreView(View loadMoreView) {
        mLoadMoreView = loadMoreView;
        return this;
    }

    public LoadMore5Wrapper setLoadMoreView(int layoutId) {
        mLoadMoreLayoutId = layoutId;
        return this;
    }

    public LoadMore5Wrapper setNoMoreView(View loadMoreView) {
        mNoMoreView = loadMoreView;
        return this;
    }

    public LoadMore5Wrapper setNoMoreView(int layoutId) {
        mNoMoreLayoutId = layoutId;
        return this;
    }

    public LoadMore5Wrapper setRetryView(View retryView) {
        mRetryView = retryView;
        return this;
    }

    public LoadMore5Wrapper setRetryView(int layoutId) {
        mRetryLayoutId = layoutId;
        return this;
    }

    //最后一页加载成功后调用
    public void hideLoadMoreView() {
        hasMore = false;
        needRetry = false;
        notifyDataSetChanged();
    }

    //最后一页加载成功后状态恢复初始化
    public void resetLoadMoreView() {
        hasMore = true;
        needRetry = false;
    }

    //每次接口请求成功后最先调用
    public void loadingSuccess() {
        hasMore = true;
        needRetry = false;
        loading = false;
    }

    //每次接口调用失败后最先调用
    public void loadingError() {
        hasMore = false;
        needRetry = true;
        notifyDataSetChanged();
    }
}
