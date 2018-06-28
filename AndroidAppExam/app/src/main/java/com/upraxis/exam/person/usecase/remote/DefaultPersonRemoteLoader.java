package com.upraxis.exam.person.usecase.remote;

import com.upraxis.exam.api.ApiFactory;
import com.upraxis.exam.api.PersonDto;
import com.upraxis.exam.api.person.PersonApi;
import com.upraxis.exam.person.model.Person;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;

public class DefaultPersonRemoteLoader implements PersonRemoteLoader {

    private ApiFactory apiFactory;

    @Inject
    DefaultPersonRemoteLoader(ApiFactory apiFactory) { this.apiFactory = apiFactory; }

    @Override
    public Single<List<PersonDto>> load() {
        return apiFactory.create(PersonApi.class)
                .flatMap(
                        personApi -> personApi.getAll()
                );
    }
}
