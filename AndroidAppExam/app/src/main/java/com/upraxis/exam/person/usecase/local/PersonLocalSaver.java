package com.upraxis.exam.person.usecase.local;

import com.upraxis.exam.person.model.Person;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PersonLocalSaver {

    Observable<Person> save(Person person);

    Observable<List<Person>> save(List<Person> persons);
}
