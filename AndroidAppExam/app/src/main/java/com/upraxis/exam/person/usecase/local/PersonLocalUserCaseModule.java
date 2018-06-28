package com.upraxis.exam.person.usecase.local;

import dagger.Binds;
import dagger.Module;

@Module
public interface PersonLocalUserCaseModule {

    @Binds
    PersonLocalLoader bindLocalLoader(DefaultPersonLocalLoader loader);

    @Binds
    PersonLocalSaver bindLocalSaver(DefaultPersonLocalSaver saver);
}
