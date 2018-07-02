package com.upraxis.exam.person.model;



import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;


@Entity(tableName = Person.TABLE_NAME)
public class Person implements Parcelable{

    public static final String COLUMN_ID = "id";
    public static final String TABLE_NAME = "person";

    @ColumnInfo(name = "id")
    @NonNull
    @PrimaryKey
    private String id;


    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String bday;

    @NonNull
    private String mobileNumber;

    @NonNull
    private String email;

    @NonNull
    private String address;

    @NonNull
    private String contactPerson;

    @NonNull
    private String contactPersonNumber;

    public Person(){
        firstName = "";
        lastName = "";
        bday = "";
        mobileNumber = "";
        email = "";
        address = "";
        contactPerson = "";
        contactPersonNumber = "";
    }

    // Constructor for Parcelable Person
    public Person(Parcel parcel){
        id = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        bday = parcel.readString();
        mobileNumber = parcel.readString();
        email = parcel.readString();
        address = parcel.readString();
        contactPerson = parcel.readString();
        contactPersonNumber = parcel.readString();
    }

    public void setPerson(@NonNull String firstName,
                  @NonNull String lastName,
                  @NonNull String bday,
                  @NonNull String mobileNumber,
                  @NonNull String email,
                  @NonNull String address,
                  @NonNull String contactPerson,
                  @NonNull String contactPersonNumber){

        this.firstName = firstName;
        this.lastName = lastName;
        this.bday = bday;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPersonNumber = contactPersonNumber;
    }


    public void setId(@NonNull String id){
        this.id = id;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public void setBday(@NonNull String bday){
        this.bday = bday;
    }

    public void setMobileNumber(@NonNull String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(@NonNull String email){
        this.email = email;
    }

    public void setAddress(@NonNull String address){
        this.address = address;
    }

    public void setContactPerson(@NonNull String contactPerson){
        this.contactPerson = contactPerson;
    }

    public void setContactPersonNumber(@NonNull String contactPersonNumber){
        this.contactPersonNumber = contactPersonNumber;
    }

    @NonNull
    public String getId() { return id; }

    @NonNull
    public String getFirstName() { return  firstName; }


    @NonNull
    public String getLastName() { return lastName; }

    @NonNull
    public String getBday() { return bday; }

    @NonNull
    public String getMobileNumber() { return  mobileNumber; }

    @NonNull
    public String getEmail() { return  email; }

    @NonNull
    public String getAddress() { return address; }

    @NonNull
    public String getContactPerson() { return contactPerson; }

    @NonNull
    public String getContactPersonNumber() { return contactPersonNumber; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(bday);
        dest.writeString(mobileNumber);
        dest.writeString(email);
        dest.writeString(address);
        dest.writeString(contactPerson);
        dest.writeString(contactPersonNumber);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>(){

        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }
    };
}