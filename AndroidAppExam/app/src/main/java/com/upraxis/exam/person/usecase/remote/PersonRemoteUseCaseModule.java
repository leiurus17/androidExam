package com.upraxis.exam.person.usecase.remote;

import dagger.Binds;
import dagger.Module;

@Module
public interface PersonRemoteUseCaseModule {

    @Binds
    PersonRemoteLoader bindLoader(DefaultPersonRemoteLoader loader);
}
