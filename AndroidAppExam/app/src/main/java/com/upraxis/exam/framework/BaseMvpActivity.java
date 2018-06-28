package com.upraxis.exam.framework;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

public abstract class BaseMvpActivity<V extends ApplicationMvpView, P extends ApplicationMvpPresenter<V>>
    extends MvpActivity<V, P> implements ApplicationMvpView {
}
