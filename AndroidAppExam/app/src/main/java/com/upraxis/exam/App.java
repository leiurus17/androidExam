package com.upraxis.exam;

import android.app.Activity;
import android.app.Application;

import com.upraxis.exam.framework.AppComponent;
import com.upraxis.exam.framework.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application
        implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent().inject(this);
    }

    protected AppComponent initializeComponent(){
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
