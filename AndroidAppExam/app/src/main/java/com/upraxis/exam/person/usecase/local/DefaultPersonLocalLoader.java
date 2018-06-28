package com.upraxis.exam.person.usecase.local;

import com.upraxis.exam.person.model.Person;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

class DefaultPersonLocalLoader implements PersonLocalLoader {

    private PersonDao dao;

    @Inject
    DefaultPersonLocalLoader(PersonDao dao) { this.dao = dao; }



    @Override
    public Single<List<Person>> all() {
        return Single.fromCallable(() ->  dao.selectAll() );
    }

    @Override
    public Single<Person> byId(String id) {
        return Single.fromCallable(() -> dao.selectById(id));
    }
}
