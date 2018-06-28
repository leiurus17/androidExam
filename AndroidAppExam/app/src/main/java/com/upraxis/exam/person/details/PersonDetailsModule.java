package com.upraxis.exam.person.details;

import com.upraxis.exam.framework.ActivityScope;
import com.upraxis.exam.person.details.presenter.PersonDetailsPresenterModule;
import com.upraxis.exam.person.details.view.PersonDetailsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface PersonDetailsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = PersonDetailsPresenterModule.class)
    PersonDetailsActivity contributePersonDetailsActivityInjector();
}
