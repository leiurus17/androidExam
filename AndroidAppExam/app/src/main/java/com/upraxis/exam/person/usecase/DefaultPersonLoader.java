package com.upraxis.exam.person.usecase;

import android.util.Log;

import com.upraxis.exam.api.PersonDto;
import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.person.usecase.local.PersonLocalLoader;
import com.upraxis.exam.person.usecase.local.PersonLocalSaver;
import com.upraxis.exam.person.usecase.remote.PersonRemoteLoader;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class DefaultPersonLoader implements PersonLoader {

    private static String TAG = DefaultPersonLoader.class.getName();

    private PersonRemoteLoader personRemoteLoader;
    private PersonLocalLoader personLocalLoader;
    private PersonLocalSaver personLocalSaver;

    @Inject
    public DefaultPersonLoader(PersonRemoteLoader personRemoteLoader,
                               PersonLocalLoader personLocalLoader,
                               PersonLocalSaver personLocalSaver){
        this.personRemoteLoader = personRemoteLoader;
        this.personLocalLoader = personLocalLoader;
        this.personLocalSaver = personLocalSaver;
    }



    @Override
    public Single<Person> loadPersonById(String id) {
        return personLocalLoader.byId(id);
    }

    @Override
    public Single<List<Person>> loadPersonData() {

        return personRemoteLoader.load()
                .flatMapObservable(Observable::fromIterable)
                .flatMap(
                        personDto -> {
                            return personDtoToPerson(personDto);
                        })

                .toList()
                .flatMap(data -> Single.fromObservable(personLocalSaver.save(data)));

    }

    @Override
    public Single<List<Person>> loadLocalPersonData() {
        return personLocalLoader.all();
    }

    public Observable<Person> personDtoToPerson(PersonDto person){
        Log.d(TAG,"personDtoToPerson " + person.getFirstName());
        Person personDtoToPerson = new Person();
        personDtoToPerson.setPerson(
                person.getFirstName(),
                person.getLastName(),
                person.getBday(),
                person.getMobileNumber(),
                person.getEmail(),
                person.getAddress(),
                person.getContactPerson(),
                person.getContactPersonNumber());
        personDtoToPerson.setId(person.getId());

        return Observable.just(personDtoToPerson);
    }
}
