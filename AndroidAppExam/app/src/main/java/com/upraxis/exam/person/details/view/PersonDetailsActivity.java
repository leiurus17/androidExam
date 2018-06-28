package com.upraxis.exam.person.details.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.upraxis.exam.R;
import com.upraxis.exam.framework.BaseMvpActivity;
import com.upraxis.exam.person.details.presenter.PersonDetailsPresenter;
import com.upraxis.exam.person.model.Person;
import com.upraxis.exam.util.Utilities;

import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class PersonDetailsActivity extends BaseMvpActivity<PersonDetailsView, PersonDetailsPresenter> implements PersonDetailsView {

    private static String TAG = PersonDetailsActivity.class.getName();

    @BindView(R.id.person_fullname_text)
    TextView textViewFullName;

    @BindView(R.id.person_bday_text)
    TextView textViewBday;

    @BindView(R.id.person_age_text)
    TextView textViewAge;

    @BindView(R.id.person_email_text)
    TextView textViewEmail;

    @BindView(R.id.person_address_text)
    TextView textViewAddress;

    @BindView(R.id.person_mobile_text)
    TextView textViewMobile;

    @BindView(R.id.person_contact_text)
    TextView textViewContactPerson;

    @BindView(R.id.person_contact_num_text)
    TextView textviewContactPersonNumber;

    @Inject
    PersonDetailsPresenter personDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        ButterKnife.bind(this);

        if(getIntent().hasExtra(Person.COLUMN_ID)){
            personDetailsPresenter.loadDetails(getIntent().getStringExtra(Person.COLUMN_ID).toString());
        }
    }

    @NonNull
    @Override
    public PersonDetailsPresenter createPresenter() {
        return personDetailsPresenter;
    }

    @Override
    public void showDetails(Person person) {

        textViewFullName.setText(person.getFirstName() + " " + person.getLastName());

        Date bdayDate = Utilities.ConvertStringToDate(person.getBday());

        textViewBday.setText("Birthday: " + Utilities.ConvertTimeStampToStringDate("" + bdayDate.getTime()));
        textViewAge.setText("Age: " + Utilities.computeAge("" + bdayDate.getTime()));

        textViewEmail.setText(person.getEmail());

        textViewMobile.setText(person.getMobileNumber());
        textViewAddress.setText(person.getAddress());
        textViewContactPerson.setText(person.getContactPerson());
        textviewContactPersonNumber.setText(person.getContactPersonNumber());
    }
}
