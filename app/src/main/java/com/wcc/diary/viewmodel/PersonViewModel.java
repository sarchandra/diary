package com.wcc.diary.viewmodel;

import androidx.lifecycle.ViewModel;

public class PersonViewModel extends ViewModel {
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

   private String firstname ="";

}
