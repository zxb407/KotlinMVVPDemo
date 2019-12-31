package org.cchao.kotlintemplate.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lorg/cchao/kotlintemplate/ui/base/BasePresenter;", "", "attachView", "", "baseView", "Lorg/cchao/kotlintemplate/ui/base/BaseView;", "detachView", "getDestroyCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getPauseCompositeDisposable", "unSubscribeOnDestroy", "unSubscribeOnPause", "lib_core_frame_debug"})
public abstract interface BasePresenter {
    
    public abstract void attachView(@org.jetbrains.annotations.NotNull()
    org.cchao.kotlintemplate.ui.base.BaseView baseView);
    
    public abstract void detachView();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.disposables.CompositeDisposable getPauseCompositeDisposable();
    
    public abstract void unSubscribeOnPause();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.disposables.CompositeDisposable getDestroyCompositeDisposable();
    
    public abstract void unSubscribeOnDestroy();
}