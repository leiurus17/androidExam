package com.upraxis.exam.framework;

import android.app.Application;

import com.upraxis.exam.App;
import com.upraxis.exam.api.ApiModule;
import com.upraxis.exam.database.DatabaseModule;
import com.upraxis.exam.person.PersonModule;
import com.upraxis.exam.person.list.PersonListModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Component(modules = {
        AndroidInjectionModule.class,
        AndroidModule.class,
        ApiModule.class,
        PersonModule.class,
        DatabaseModule.class
})

@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    void inject(App application);
}
