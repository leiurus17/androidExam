package com.upraxis.exam.person.usecase.remote;

import com.upraxis.exam.api.PersonDto;
import com.upraxis.exam.person.model.Person;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;

public interface PersonRemoteLoader {

    Single<List<PersonDto>> load();
}
