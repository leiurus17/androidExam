package com.upraxis.exam.person.list.view.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upraxis.exam.R;
import com.upraxis.exam.person.model.Person;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListViewHolder>{

    private PersonListViewModel viewModel;

    private PublishSubject<Person> onClickPersonSubject;

    private List<Object> organizedPersons;

    public PersonListAdapter(//PersonListViewModel viewModel,
                             Consumer<Person> onClickPersonListener){

//        this.viewModel = viewModel;
        onClickPersonSubject = PublishSubject.create();
        this.onClickPersonSubject.subscribe(onClickPersonListener);

        organizedPersons = new ArrayList<>();
    }

    @NonNull
    @Override
    public PersonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PersonListViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonListViewHolder holder, int position) {

        Object item = organizedPersons.get(position);
//        holder.bind(item);

        PersonListViewHolder itemHolder = ((PersonListViewHolder) holder);
        itemHolder.bind((Person) item);

        itemHolder.container.setOnClickListener(
                onClick -> onClickPersonSubject.onNext((Person) item)
        );

    }

    @Override
    public int getItemCount() {
        return organizedPersons.size();
    }

    public void set(List<Person> newPersons){

        this.organizedPersons.clear();
        this.organizedPersons.addAll(newPersons);
        //viewModel.setPersons(newPersons);

        notifyDataSetChanged();
    }

//    @Override
//    public int getCount(){
//        return personList.size();
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
//
//        View view = convertView;
//
//        PersonListViewHolder viewHolder = null;
//
//        if(view == null){
//
//            LayoutInflater layoutInflater = activity.getLayoutInflater();
//            view = layoutInflater.inflate(R.layout.item_person, null, true);
//
//            viewHolder =  new PersonListViewHolder(view);
//            view.setTag(viewHolder);
//        }
//        else{
//            viewHolder = (PersonListViewHolder) view.getTag();
//        }
//
//        viewHolder.setText(personList.get(position).getFirstName() + " " + personList.get(position).getLastName());
//
//        return view;
//    }
}
