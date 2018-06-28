package com.upraxis.exam.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.upraxis.exam.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RoomDaoModule.class)
public interface DatabaseModule {

    @Provides
    @Singleton
    static UPraxisExamDatabase provideDatabase(App application) {
        return Room.databaseBuilder(application,
                UPraxisExamDatabase.class,
                "upraxis-database.sql")
                .fallbackToDestructiveMigration()
                .build();
    }
}
