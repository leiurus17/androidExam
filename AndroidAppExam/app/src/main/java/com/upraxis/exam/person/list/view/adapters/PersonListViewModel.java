package com.upraxis.exam.person.list.view.adapters;

import android.arch.lifecycle.ViewModel;

import com.upraxis.exam.person.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListViewModel extends ViewModel {

    private List<Person> persons;

    public PersonListViewModel() { persons = new ArrayList<>(); }

    public List<Person> getPersons() { return persons; }

    public void setPersons(List<Person> persons) { this.persons = persons; }
}
