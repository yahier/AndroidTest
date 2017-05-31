package com.yahier.androidtest.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.yahier.androidtest.BR;


/**
 * Created by yahier on 17/5/25.
 */


public class UserObservable extends BaseObservable {
    private String firstName;
    private String lastName;

    public UserObservable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}