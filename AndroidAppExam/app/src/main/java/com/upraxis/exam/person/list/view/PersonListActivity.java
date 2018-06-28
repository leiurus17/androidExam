package com.upraxis.exam.person.list.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.upraxis.exam.R;
import com.upraxis.exam.framework.BaseMvpActivity;
import com.upraxis.exam.person.details.view.PersonDetailsActivity;
import com.upraxis.exam.person.list.presenter.PersonListPresenter;
import com.upraxis.exam.person.list.view.adapters.PersonListAdapter;
import com.upraxis.exam.person.list.view.adapters.PersonListViewModel;
import com.upraxis.exam.person.model.Person;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class PersonListActivity extends BaseMvpActivity<PersonListView, PersonListPresenter> implements PersonListView {

    private static String TAG = PersonListActivity.class.getName();

    @BindView(R.id.person_list)
    RecyclerView recyclerView;

    @Inject
    PersonListPresenter personListPresenter;

    List<Person> list;

    private PersonListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        ButterKnife.bind(this);

        setUpView();


    }

    @NonNull
    @Override
    public PersonListPresenter createPresenter() {
        return personListPresenter;
    }


    @Override
    public void showList(List<Person> list) {
        Log.d(TAG, "showList");
//        PersonListAdapter adapters = new PersonListAdapter(this, list);
//        listView.setAdapter(adapters);
//        listView.setOnItemClickListener(this);

        adapter.set(list);
    }

//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, PersonDetailsActivity.class);
//        intent.putExtra(Person.COLUMN_ID, list.get(position).getId());
//        startActivity(intent);
//
//    }


    public void setUpView(){


        adapter = new PersonListAdapter(this::onClickPerson);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        personListPresenter.loadPersons();
    }

    private void onClickPerson(Person person){

        Log.d(TAG, "onClickPerson ----------fsdfsdafsdfsa----------");
        Intent intent = new Intent(this, PersonDetailsActivity.class);
        intent.putExtra(Person.COLUMN_ID, person.getId());
        startActivity(intent);
    }


}
