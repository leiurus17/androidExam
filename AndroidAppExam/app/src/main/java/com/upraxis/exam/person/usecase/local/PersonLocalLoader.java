package com.upraxis.exam.person.usecase.local;

import com.upraxis.exam.person.model.Person;

import java.util.List;

import io.reactivex.Single;

public interface PersonLocalLoader {

    Single<List<Person>> all();

    Single<Person> byId(String id);
}
