package com.zentyk.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zentyk.mvvm.model.User;

public class DBLDViewModel extends ViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> visible;
    private MutableLiveData<Float> size;

    public DBLDViewModel() {
        user = new MutableLiveData<>();
        visible = new MutableLiveData<>();
        size = new MutableLiveData<>();

        visible.setValue(true);
        size.setValue(14f);
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

    public MutableLiveData<Boolean> getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible.setValue(visible);
    }

    public MutableLiveData<Float> getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size.setValue(size);
    }

    public void ChangeVisibility() {
        if(visible.getValue()) {
            visible.setValue(false);
        }
        else {
            visible.setValue(true);
        }
        size.setValue(size.getValue().floatValue()+5l);
    }
}