package com.upraxis.exam.person.usecase;

import com.upraxis.exam.person.model.Person;

import java.util.List;

import io.reactivex.Single;

public interface PersonLoader {

    Single<Person> loadPersonById(String id);

    Single<List<Person>> loadPersonData();
    Single<List<Person>> loadLocalPersonData();
}
