package com.upraxis.exam.framework;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module
public class AppModule {

    private Context m_appContext;

    public AppModule(@NonNull Context context) {
        m_appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return m_appContext;
    }
}
