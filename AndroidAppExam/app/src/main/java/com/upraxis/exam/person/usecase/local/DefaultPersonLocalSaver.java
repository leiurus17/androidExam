package com.upraxis.exam.person.usecase.local;

import android.util.Log;

import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.person.usecase.DefaultPersonLoader;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class DefaultPersonLocalSaver implements PersonLocalSaver {

    private static String TAG = DefaultPersonLoader.class.getName();

    private PersonDao personDao;

    @Inject
    DefaultPersonLocalSaver(PersonDao personDao) { this.personDao = personDao; }


//    public Completable save(Person person) {
//        return Completable.fromCallable(
//                () -> {
//                    personDao.insert(person);
//                    return Completable.complete();
//                }
//        );
//    }

    @Override
    public Observable<Person> save(Person person) {
        return Completable.fromCallable(
                () -> {
                    personDao.insert(person);
                    return Completable.complete();
                })
                .andThen(Observable.fromCallable(()-> person));
    }

    @Override
    public Observable<List<Person>> save(List<Person> persons) {
        Log.d(TAG, "======================== SAVE PERSONS");
        return Completable.fromCallable(
                () -> {
                    personDao.insert(persons);
                    return Completable.complete();
                })
                .andThen(Observable.fromCallable(()-> persons));
    }
}
