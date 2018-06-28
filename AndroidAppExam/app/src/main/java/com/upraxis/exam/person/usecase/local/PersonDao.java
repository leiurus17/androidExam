package com.upraxis.exam.person.usecase.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.upraxis.exam.person.model.Person;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Person> person);

    @Query("SELECT * FROM " + Person.TABLE_NAME)
    List<Person> selectAll();

    @Query("SELECT * FROM " + Person.TABLE_NAME + " WHERE " + Person.COLUMN_ID + "= :id")
    Person selectById(String id);
}
