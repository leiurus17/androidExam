package com.upraxis.exam.person.list.presenter;

import android.util.Log;

import com.upraxis.exam.framework.DefaultApplicationMvpPresenter;
import com.upraxis.exam.person.list.view.PersonListView;
import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.person.usecase.PersonLoader;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class DefaultPersonListPresenter
        extends DefaultApplicationMvpPresenter<PersonListView>
        implements PersonListPresenter{


    private static String TAG = DefaultPersonListPresenter.class.getName();

    PersonListView view;
    PersonLoader personLoader;



    @Inject
    public DefaultPersonListPresenter(PersonLoader personLoader){

        this.personLoader = personLoader;
    }

    @Override
    public void loadPersons() {

        personLoader.loadLocalPersonData()
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Person>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "loadLocalPersons:: onSubscribe " + d.toString());
                    }

                    @Override
                    public void onSuccess(List<Person> people) {
                        Log.d(TAG, "loadLocalPerson:: onSuccess ");
                        if(people.size() != 0)
                            view.showList(people);
                        loadRemotePersons();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "loadLocalPerson onError " + e.getMessage());
                        loadRemotePersons();
                    }
                });
    }


    @Override
    public void loadRemotePersons() {
        personLoader.loadPersonData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        new SingleObserver<List<Person>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d(TAG, "==================== onSubscribe");
                            }

                            @Override
                            public void onSuccess(List<Person> listPerson) {
                                Log.d(TAG, "==================== onSuccess " + listPerson.size());
//                                    Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>> " + person.getFirstName());
                                view.showList(listPerson);

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(TAG, "==================== onError " + e.getMessage());
                            }
                        }
                );
    }


    @Override
    public void attachView(PersonListView view) {
        super.attachView(view);
        this.view = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
