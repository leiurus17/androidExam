package com.upraxis.exam.person.details.presenter;


import dagger.Binds;
import dagger.Module;

@Module
public interface PersonDetailsPresenterModule {

    @Binds
    PersonDetailsPresenter bindPresenter(DefaultPersonDetailsPresenter presenter);
}
