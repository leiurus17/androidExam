package com.upraxis.exam.framework;

import android.content.Context;

import com.upraxis.exam.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}
