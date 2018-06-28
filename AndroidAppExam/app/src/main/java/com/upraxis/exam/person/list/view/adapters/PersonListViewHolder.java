package com.upraxis.exam.person.list.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upraxis.exam.R;
import com.upraxis.exam.person.model.Person;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;


class PersonListViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.person_name)
    TextView textView;

    @BindView(R.id.person_container)
    View container;

    PersonListViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setText(String text){
        textView.setText(text);
    }

    void bind(Person person){
        textView.setText(person.getFirstName() + " " + person.getLastName());
    }

}
