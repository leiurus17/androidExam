package com.upraxis.exam.person;

import com.upraxis.exam.person.details.PersonDetailsModule;
import com.upraxis.exam.person.list.PersonListModule;
import com.upraxis.exam.person.usecase.PersonUseCaseModule;


import dagger.Module;
@Module(includes = {
        PersonListModule.class,
        PersonDetailsModule.class,
        PersonUseCaseModule.class
})
public interface PersonModule {

}
