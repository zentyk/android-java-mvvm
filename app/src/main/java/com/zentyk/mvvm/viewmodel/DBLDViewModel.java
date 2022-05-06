package com.zentyk.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zentyk.mvvm.model.User;

public class DBLDViewModel extends ViewModel {
    private MutableLiveData<User> user;

    public DBLDViewModel() {
        user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public void UpdateUser() {
        User u = new User("John", "30");
        this.user.setValue(u);
    }
}
