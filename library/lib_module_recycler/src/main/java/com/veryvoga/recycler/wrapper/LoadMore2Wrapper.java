package com.veryvoga.recycler.wrapper;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * @author cchen6
 * @Date on 2019/7/31
 * @Description
 */
public class LoadMore2Wrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_LOAD_MORE = -100;
    private final int TYPE_FOOTER = -200;
    private final int TYPE_HEADER = -300;
    private final int TYPE_DEFAULT = -400;

    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;

    private OnLoadMoreListener onLoadMoreListener;

    //1表示表示滑动至最后一个开始加在更多
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    //最后一个的位置
    private int[] lastPositions;
    //最后一个可见的item的位置
    private int lastVisibleItemPosition;

    //是否显示加载中
    private boolean loading = false;

    //是否全部加载完成
    private boolean isLoadAll = false;

    private View headerView = null;
    private View footerView = null;
    private View loadView = null;

    public LoadMore2Wrapper(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_LOAD_MORE) {
            return new RecyclerView.ViewHolder(loadView) {
            };
        } else if (viewType == TYPE_FOOTER) {
            return new RecyclerView.ViewHolder(footerView) {
            };
        } else if (viewType == TYPE_HEADER) {
            return new RecyclerView.ViewHolder(headerView) {
            };
        } else {
            return adapter.onCreateViewHolder(viewGroup, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        if (viewType != TYPE_LOAD_MORE && viewType != TYPE_FOOTER && viewType != TYPE_HEADER) {
            position = viewHolder.getAdapterPosition();
            if (headerView != null) {
                position = position - 1;
            }
            adapter.onBindViewHolder(viewHolder, position);
        }
    }

    @Override
    public int getItemCount() {
        int count = adapter.getItemCount();
        if (count == 0) {
            return 0;
        }
        if (!isLoadAll && loading && loadView != null) {
            count++;
        }
        if (isLoadAll && footerView != null) {
            count++;
        }
        if (headerView != null) {
            count++;
        }
        return count;
    }

    @Override
    public final int getItemViewType(int position) {
        if (headerView != null && position == 0) {
            return TYPE_HEADER;
        }
        if (position >= (headerView == null ? adapter.getItemCount() : adapter.getItemCount() + 1) && loading && loadView != null) {
            return TYPE_LOAD_MORE;
        }
        if (footerView != null && position >= (headerView == null ? adapter.getItemCount() : adapter.getItemCount() + 1)) {
            return TYPE_FOOTER;
        }
        return adapter.getItemViewType(headerView == null ? position : position - 1);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (isStaggeredGridLayout(holder)) {
            handleLayoutIfStaggeredGridLayout(holder);
        }
    }

    private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        return layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    }

    private void handleLayoutIfStaggeredGridLayout(RecyclerView.ViewHolder holder) {
        int viewType = holder.getItemViewType();
        if (viewType == TYPE_LOAD_MORE || viewType == TYPE_HEADER || viewType == TYPE_FOOTER) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            p.setFullSpan(true);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView1) {
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView == null) {
            recyclerView = recyclerView1;
            if (null != onLoadMoreListener) {
                setLoadMoreListener();
            }
        }
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = (GridLayoutManager) manager;
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    if (viewType == TYPE_LOAD_MORE || viewType == TYPE_HEADER
                            || viewType == TYPE_FOOTER) {
                        return gridManager.getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    /**
     * 设置提前加载
     *
     * @param num
     */
    public void setVisibleThreshold(int num) {
        visibleThreshold = num;
        if (recyclerView != null) {
            //网格或瀑布布局特殊处理
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            if (manager instanceof GridLayoutManager) {
                visibleThreshold = visibleThreshold * ((GridLayoutManager) manager).getSpanCount();
            }
            if (manager instanceof StaggeredGridLayoutManager) {
                visibleThreshold = visibleThreshold * ((StaggeredGridLayoutManager) manager).getSpanCount();
            }
        }
    }

    /**
     * 添加底部
     *
     * @param view
     */
    public void setFooterView(View view) {
        if (view == null) {
            throw new NullPointerException("FooterView is null!");
        }
        if (footerView != null) {
            return;
        }
        footerView = view;
        footerView.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * 移除底部View
     */
    public void removeFooterView() {
        if (footerView != null) {
            footerView = null;
            notifyItemRemoved(getItemCount());
        }
    }

    /**
     * 添加头部
     *
     * @param view
     */
    public void addHeaderView(View view) {
        if (view == null) {
            throw new NullPointerException("HeadView is null");
        }
        if (headerView != null) {
            return;
        }
        headerView = view;
        headerView.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        notifyDataSetChanged();
    }

    public void removeHeaderView() {
        if (headerView != null) {
            headerView = null;
            notifyDataSetChanged();
        }
    }

    public void setLoadingView(View view) {
        if (view == null) {
            throw new NullPointerException("LoadingView is null!");
        }
        if (loadView != null) {
            return;
        }
        loadView = view;
        loadView.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }

    private void removeLoadingView() {
        loading = false;
        notifyDataSetChanged();
    }

    public final void reset() {
        if (recyclerView != null) {
            //必须主线程notify
            if (loading) {
                removeLoadingView();
            } else {
                notifyDataSetChanged();
            }
        }
    }

    /**
     * 设置是否已经全部加载完成
     *
     * @param loadAll
     */
    public final void setLoadAll(boolean loadAll) {
        if (loading) {
            reset();
        } else if (!loadAll) {
            footerView = null;
        }
        isLoadAll = loadAll;
    }

    /**
     * 设置加载更多监听
     */
    private void setLoadMoreListener() {
        if (onLoadMoreListener != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        if (loading) {
                            return;
                        }
                        totalItemCount = linearLayoutManager.getItemCount();
                        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                        if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)
                                && dy > 0 && !isLoadAll && adapter.getItemCount() > 0) {
                            loading = true;
                            if (loadView != null) {
                                notifyItemInserted(getItemCount() - 1);
                            }
                            onLoadMoreListener.onLoadMore();
                        }
                    }
                });
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        if (loading) {
                            return;
                        }
                        if (lastPositions == null) {
                            lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                        }
                        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                        lastVisibleItemPosition = findMax(lastPositions);
                        if (!loading && staggeredGridLayoutManager.getItemCount() <= lastVisibleItemPosition + visibleThreshold
                                && dy > 0 && !isLoadAll && adapter.getItemCount() > 0) {
                            loading = true;
                            if (loadView != null) {
                                notifyItemInserted(getItemCount() - 1);
                            }
                            onLoadMoreListener.onLoadMore();
                        }
                    }
                });
            }
        }
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
