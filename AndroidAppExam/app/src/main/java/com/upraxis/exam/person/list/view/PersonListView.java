package com.upraxis.exam.person.list.view;

import com.upraxis.exam.framework.ApplicationMvpView;
import com.upraxis.exam.person.model.Person;

import java.util.List;

public interface PersonListView extends ApplicationMvpView {

    void showList(List<Person> list);
}
