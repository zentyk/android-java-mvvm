package com.zentyk.mvvm.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.zentyk.mvvm.R;
import com.zentyk.mvvm.databinding.ActivityDataBindingBinding;
import com.zentyk.mvvm.model.User;

public class DataBindingActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        user = new User("John", "30");

        binding.setUserData(user);
    }
}