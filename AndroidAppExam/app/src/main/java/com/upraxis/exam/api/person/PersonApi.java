package com.upraxis.exam.api.person;

import com.upraxis.exam.api.PersonDto;
import com.upraxis.exam.api.UPraxisApi;
import com.upraxis.exam.person.model.Person;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonApi {

    //http://www.mocky.io/v2/5b2b6d6e3000008d002345ff
    String PERSON_DATA_JSON_URL = "v2/5b2b6d6e3000008d002345ff";

    @GET(PERSON_DATA_JSON_URL)
    Single<List<PersonDto>> getAll();

    @GET(PERSON_DATA_JSON_URL)
    Call<Person> getAllPerson();

}
