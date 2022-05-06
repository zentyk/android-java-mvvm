package com.zentyk.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.zentyk.mvvm.R;
import com.zentyk.mvvm.databinding.ActivityLiveDataBindingBinding;
import com.zentyk.mvvm.model.User;
import com.zentyk.mvvm.viewmodel.DBLDViewModel;

public class LiveDataBinding extends AppCompatActivity {
    private DBLDViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLiveDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data_binding);
        binding.setLifecycleOwner(this);
        viewModel = ViewModelProviders.of(this).get(DBLDViewModel.class);
        binding.setViewModel(viewModel);

        User u = new User("Zentyk", "26");
        viewModel.setUser(u);
    }
}