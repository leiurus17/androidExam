package com.upraxis.exam.person.details.view;

import com.upraxis.exam.framework.ApplicationMvpView;
import com.upraxis.exam.person.model.Person;

public interface PersonDetailsView extends ApplicationMvpView {

    void showDetails(Person person);
}
