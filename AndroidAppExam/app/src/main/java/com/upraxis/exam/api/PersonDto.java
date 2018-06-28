package com.upraxis.exam.api;

import io.reactivex.annotations.Nullable;

public class PersonDto {

    @Nullable
    private String id;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String bday;

    @Nullable
    private String email;

    @Nullable
    private String mobileNumber;

    @Nullable
    private String address;

    @Nullable
    private String contactPerson;

    @Nullable
    private String contactPersonNumber;

    @Nullable
    public String getId() { return id; }

    @Nullable
    public String getFirstName() { return firstName; }

    @Nullable
    public String getLastName() { return lastName; }

    @Nullable
    public String getBday() { return bday; }

    @Nullable
    public String getEmail() { return email; }

    @Nullable
    public String getMobileNumber() { return mobileNumber; }

    @Nullable
    public String getAddress() { return address; }

    @Nullable
    public String getContactPerson() { return contactPerson; }

    @Nullable
    public String getContactPersonNumber() { return contactPersonNumber; }

    public PersonDto(){
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.bday = "";
        this.email = "";
        this.mobileNumber = "";
        this.contactPerson = "";
        this.contactPersonNumber = "";
    }

    public void setBasicInfo(@Nullable String id,
                             @Nullable String firstname,
                             @Nullable String lastName,
                             @Nullable String bday,
                             @Nullable String email,
                             @Nullable String mobileNumber,
                             @Nullable String address){
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastName;
        this.bday = bday;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public void setContactPerson(@Nullable String contactPerson,
                                 @Nullable String contactPersonNumber){
        this.contactPerson = contactPerson;
        this.contactPersonNumber = contactPersonNumber;
    }


}
