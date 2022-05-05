package com.zentyk.mvvm.viewmodel;

import androidx.lifecycle.ViewModel;

import com.zentyk.mvvm.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private List<User> usersList;

    public UserViewModel(){
        usersList = new ArrayList<>();
    }

    public void AddUser(User user) {
        usersList.add(user);
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
