package com.upraxis.exam.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.upraxis.exam.BuildConfig;
import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.person.usecase.local.PersonDao;

@Database(
        entities = {
                Person.class
        },
        version = BuildConfig.DATABASE_VERSION,
        exportSchema = true
)
public abstract class UPraxisExamDatabase extends RoomDatabase{

    public abstract PersonDao personDao();

}
