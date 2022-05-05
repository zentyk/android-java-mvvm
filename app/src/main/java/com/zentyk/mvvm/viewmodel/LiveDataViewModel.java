package com.zentyk.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zentyk.mvvm.model.User;

import java.util.ArrayList;
import java.util.List;

public class LiveDataViewModel extends ViewModel {
     private MutableLiveData<List<User>> userListLiveData;
     private List<User> userList;

     public LiveData<List<User>> getUserList() {
          if(userListLiveData == null) {
               userListLiveData = new MutableLiveData<>();
               userList = new ArrayList<>();
          }
          return userListLiveData;
     }

     public void addUser(User user) {
          userList.add(user);
          // setValue() is used in the main thread
          userListLiveData.setValue(userList);

          // postValue() is used in background thread
          //userListLiveData.postValue(userList);
     }
}
