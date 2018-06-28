package com.upraxis.exam.person.details.presenter;

import android.util.Log;

import com.upraxis.exam.person.details.view.PersonDetailsView;
import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.person.usecase.DefaultPersonLoader;
import com.upraxis.exam.person.usecase.PersonLoader;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DefaultPersonDetailsPresenter implements PersonDetailsPresenter {

    private static String TAG = DefaultPersonDetailsPresenter.class.getName();

    PersonDetailsView view;
    PersonLoader personLoader;

    Disposable disposable;

    @Inject
    public DefaultPersonDetailsPresenter(PersonLoader personLoader){
        this.personLoader = personLoader;
    }

    @Override
    public void attachView(PersonDetailsView view) {
        this.view = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if(disposable != null) disposable.dispose();
    }

    @Override
    public void loadDetails(String personId) {

        personLoader.loadPersonById(personId)
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Person>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "loadDetails onSubscribe " );
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(Person person) {
                        Log.d(TAG, "loadDetails onSuccess");
                        view.showDetails(person);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "loadDetails onError : " + e.getMessage());
                    }
                });
    }
}
