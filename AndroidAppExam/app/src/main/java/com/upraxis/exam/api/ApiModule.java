package com.upraxis.exam.api;

import dagger.Binds;
import dagger.Module;

@Module
public interface ApiModule {

    @Binds
    ApiFactory bindApiFactory(DefaultApiFactory apiFactory);
}
