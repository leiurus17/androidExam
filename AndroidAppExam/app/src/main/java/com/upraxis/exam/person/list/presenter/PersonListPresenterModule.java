package com.upraxis.exam.person.list.presenter;

import dagger.Binds;
import dagger.Module;

@Module
public interface PersonListPresenterModule {

    @Binds
    PersonListPresenter bindPresenter(DefaultPersonListPresenter presenter);
}
