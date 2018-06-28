package com.upraxis.exam.person.usecase;

import com.upraxis.exam.person.usecase.local.PersonLocalUserCaseModule;
import com.upraxis.exam.person.usecase.remote.PersonRemoteUseCaseModule;

import dagger.Binds;
import dagger.Module;

@Module(
        includes = { PersonRemoteUseCaseModule.class,
                PersonLocalUserCaseModule.class
        }
)
public interface PersonUseCaseModule {

    @Binds
    abstract PersonLoader bindPersonLoader(DefaultPersonLoader loader);
}
