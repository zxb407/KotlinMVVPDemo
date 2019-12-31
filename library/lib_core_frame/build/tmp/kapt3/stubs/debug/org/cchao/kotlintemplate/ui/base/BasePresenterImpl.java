package org.cchao.kotlintemplate.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lorg/cchao/kotlintemplate/ui/base/BasePresenterImpl;", "T", "Lorg/cchao/kotlintemplate/ui/base/BaseView;", "Lorg/cchao/kotlintemplate/ui/base/BasePresenter;", "()V", "destroyCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "pauseCompositeDisposable", "presenterView", "Lorg/cchao/kotlintemplate/ui/base/BaseView;", "attachView", "", "baseView", "detachView", "getDestroyCompositeDisposable", "getPauseCompositeDisposable", "getPresenterView", "()Lorg/cchao/kotlintemplate/ui/base/BaseView;", "unSubscribeOnDestroy", "unSubscribeOnPause", "lib_core_frame_debug"})
public class BasePresenterImpl<T extends org.cchao.kotlintemplate.ui.base.BaseView> implements org.cchao.kotlintemplate.ui.base.BasePresenter {
    private T presenterView;
    private io.reactivex.disposables.CompositeDisposable pauseCompositeDisposable;
    private io.reactivex.disposables.CompositeDisposable destroyCompositeDisposable;
    
    @java.lang.Override()
    public void attachView(@org.jetbrains.annotations.NotNull()
    org.cchao.kotlintemplate.ui.base.BaseView baseView) {
    }
    
    @java.lang.Override()
    public void detachView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final T getPresenterView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.disposables.CompositeDisposable getPauseCompositeDisposable() {
        return null;
    }
    
    @java.lang.Override()
    public void unSubscribeOnPause() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.disposables.CompositeDisposable getDestroyCompositeDisposable() {
        return null;
    }
    
    @java.lang.Override()
    public void unSubscribeOnDestroy() {
    }
    
    public BasePresenterImpl() {
        super();
    }
}