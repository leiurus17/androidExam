package com.upraxis.exam.database;

import com.upraxis.exam.person.usecase.local.PersonDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public interface RoomDaoModule {

    @Provides
    @Singleton
    static PersonDao providesPersonDao(UPraxisExamDatabase uPraxisExamDatabase){
        return uPraxisExamDatabase.personDao();
    }
}
