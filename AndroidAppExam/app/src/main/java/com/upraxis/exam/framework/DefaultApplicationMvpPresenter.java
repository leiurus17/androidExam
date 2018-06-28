package com.upraxis.exam.framework;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

public class DefaultApplicationMvpPresenter<V extends ApplicationMvpView>
    extends MvpBasePresenter<V> implements ApplicationMvpPresenter<V>{

}
