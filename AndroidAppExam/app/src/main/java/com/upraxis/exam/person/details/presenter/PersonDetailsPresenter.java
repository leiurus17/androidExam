package com.upraxis.exam.person.details.presenter;

import com.upraxis.exam.framework.ApplicationMvpPresenter;
import com.upraxis.exam.person.details.view.PersonDetailsView;

public interface PersonDetailsPresenter extends ApplicationMvpPresenter<PersonDetailsView> {

    void loadDetails(String personId);

}
