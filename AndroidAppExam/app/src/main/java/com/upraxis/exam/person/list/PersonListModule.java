package com.upraxis.exam.person.list;


import com.upraxis.exam.framework.ActivityScope;
import com.upraxis.exam.person.list.presenter.PersonListPresenterModule;
import com.upraxis.exam.person.list.view.PersonListActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface PersonListModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = PersonListPresenterModule.class)
    PersonListActivity contributePersonListActivityInjector();

}

