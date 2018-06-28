package com.upraxis.exam.person.list.presenter;

import com.upraxis.exam.framework.ApplicationMvpPresenter;
import com.upraxis.exam.person.list.view.PersonListView;

public interface PersonListPresenter extends ApplicationMvpPresenter<PersonListView>{

    void loadPersons();
    void loadRemotePersons();
}
